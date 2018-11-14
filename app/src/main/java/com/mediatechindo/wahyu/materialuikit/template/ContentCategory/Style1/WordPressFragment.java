package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
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
import com.mediatechindo.wahyu.materialuikit.tools.DividerItemDecoration;

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
public class WordPressFragment extends Fragment implements View.OnClickListener, WordPressClickListener {
    RequestQueue volleyQueue;
    int wizard_page_position;
    RecyclerView rView;
    ArrayList<WordPressModel> rowListItem;
    String source;
    ImageView mainImage;
    TextView mainTitle, mainDescription;

    public WordPressFragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.wordpress_fragment;
        View view = inflater.inflate(layout_id, container, false);
        volleyQueue = Volley.newRequestQueue(getActivity());


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        rView = (RecyclerView) view.findViewById(R.id.recyclerViewTopArtist);
        rView.setLayoutManager(layoutManager);
        rView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rView.setNestedScrollingEnabled(false);

        source = "en.blog.wordpress.com";
        getData();

        mainImage = (ImageView) view.findViewById(R.id.mainImage);
        mainTitle = (TextView) view.findViewById(R.id.mainTitle);
        mainDescription = (TextView) view.findViewById(R.id.mainDescription);

        return view;
    }

    public void getData() {
        String url = "https://public-api.wordpress.com/rest/v1.1/sites/" + source + "/posts/?number=10";

        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        rowListItem = new ArrayList<>();
                        WordPressModel dt;
                        try {
                            JSONObject js = new JSONObject(response);
                            JSONArray post = js.getJSONArray("posts");
                            for (int i = 0; i < post.length(); i++) {
                                JSONObject data = (JSONObject) post.get(i);

                                JSONObject thumb = data.getJSONObject("post_thumbnail");

                                dt = new WordPressModel();
                                dt.setTitle(data.getString("title"));
                                dt.setSource(source);
                                dt.setImageUrl(thumb.getString("URL"));
                                dt.setTime(data.getString("modified").substring(0,10));

                                rowListItem.add(dt);

                                if(i == 0){
                                    loadImageRequest(mainImage, thumb.getString("URL"));
                                    mainTitle.setText(data.getString("title"));
                                    mainDescription.setText(Html.fromHtml(data.getString("excerpt")));
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        WordPressAdapter rcAdapter2 = new WordPressAdapter(getActivity(), rowListItem);
                        rView.setAdapter(rcAdapter2);
                        rcAdapter2.setClickListener(WordPressFragment.this);
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
