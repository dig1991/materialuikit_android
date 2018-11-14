package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class YoutubeFragment extends Fragment implements View.OnClickListener, YoutubeClickListener {
    RequestQueue volleyQueue;
    int wizard_page_position;
    RecyclerView rView;
    ArrayList<YoutubeModel> rowListItem;
    ImageView mainImage;
    TextView mainTitle, mainSource, maintime;
    String playListId;

    public YoutubeFragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.youtube_fragment;
        View view = inflater.inflate(layout_id, container, false);
        volleyQueue = Volley.newRequestQueue(getActivity());


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        rView = (RecyclerView) view.findViewById(R.id.recyclerViewTopArtist);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        playListId = "PLOU2XLYxmsIJqntMn36kS3y_lxKmQiaAS";
        getData();

        mainImage = (ImageView) view.findViewById(R.id.mainImage);
        mainTitle = (TextView) view.findViewById(R.id.mainTitle);
        mainSource = (TextView) view.findViewById(R.id.mainSource);
        maintime = (TextView) view.findViewById(R.id.maintime);

        return view;
    }

    public void getData() {
        String url = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=" + playListId + "&maxResults=10&key=" + getString(R.string.youtube_api_key) ;

        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        rowListItem = new ArrayList<>();
                        YoutubeModel mdl;
                        String dataTitle = "";
                        try {
                            JSONObject js = new JSONObject(response);
                            JSONArray post = js.getJSONArray("items");
                            for (int i = 0; i < post.length(); i++) {
                                mdl = new YoutubeModel();
                                JSONObject dt = (JSONObject) post.get(i);
                                JSONObject snippet = dt.getJSONObject("snippet");

                                mdl.setTitle(snippet.getString("title"));
                                mdl.setTime(snippet.getString("publishedAt").substring(0,10));
                                mdl.setSource(snippet.getString("channelTitle"));

                                JSONObject thumbnails = snippet.getJSONObject("thumbnails");
                                JSONObject thumdefault = thumbnails.getJSONObject("default");
                                mdl.setImageUrl(thumdefault.getString("url"));

                                rowListItem.add(mdl);
                                if(i == 0){
                                    JSONObject high = thumbnails.getJSONObject("high");

                                    loadImageRequest(mainImage, high.getString("url"));
                                    mainTitle.setText(snippet.getString("title"));
                                    mainSource.setText(snippet.getString("channelTitle"));
                                    maintime.setText(snippet.getString("publishedAt").substring(0,10));
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        YoutubeAdapter adapter = new YoutubeAdapter(getActivity(), rowListItem);
                        rView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Accept", "application/json");
                return params;
            }
        };

        int socketTimeout = 5000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        getRequest.setRetryPolicy(policy);
        volleyQueue.add(getRequest);
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mainImageView:
                Toast.makeText(getActivity(), "Play now clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void itemClicked(View view, int position) {
        int pos = position +1;
        Toast.makeText(getActivity(), "Item " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        volleyQueue.cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        });
        super.onDestroy();
    }
}
