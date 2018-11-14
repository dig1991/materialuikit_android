package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style3;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
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
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.mediatechindo.wahyu.materialuikit.R.id.recyclerView;

public class InstagramActivity extends AppCompatActivity implements View.OnClickListener{
    RequestQueue volleyQueue;
    RecyclerView rView;
    ArrayList<InstagramModel> rowListItem;
    InstagramAdapter rcAdapter;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instagram_layout);
        volleyQueue = Volley.newRequestQueue(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        // ADD SPACE TOP DRAWER ON LOLLIPOP AND UP
        final NavigationView navigationViewLeft = (NavigationView) findViewById(R.id.nav_view);
        View navLeftLay = navigationViewLeft.getHeaderView(0);
        Space spaceLeftTop = (Space) navLeftLay.findViewById(R.id.spaceLeftTop);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP){
            spaceLeftTop.setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rView = (RecyclerView) findViewById(recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        getData();

    }

    public void getData() {
        String url = "https://api.instagram.com/v1/users/self/media/recent?access_token=" + getResources().getString(R.string.instagram_token) ;

        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        rowListItem = new ArrayList<>();
                        InstagramModel mdl;
                        String dataTitle = "";
                        try {
                            JSONObject js = new JSONObject(response);
                            JSONArray post = js.getJSONArray("data");
                            for (int i = 0; i < post.length(); i++) {
                                mdl = new InstagramModel();
                                JSONObject dt = (JSONObject) post.get(i);
                                JSONObject images = dt.getJSONObject("images");
                                JSONObject standard_resolution = images.getJSONObject("standard_resolution");
                                mdl.setMainImageUrl(standard_resolution.getString("url"));
//                                mdl.setTime(dt.getString("created_time"));

                                String x = dt.getString("created_time"); // created_time tag value goes here.
                                long foo = Long.parseLong(x)*1000;
                                Date date = new Date(foo);
                                DateFormat formatter = new SimpleDateFormat("MMMM dd,yyyy");
                                mdl.setTime(formatter.format(date));

                                JSONObject user = dt.getJSONObject("user");
                                mdl.setName(user.getString("full_name"));
                                mdl.setProfileUrl(user.getString("profile_picture"));

                                String text = "";
                                try{
                                    JSONObject caption = dt.getJSONObject("caption");
                                    text = caption.getString("text");
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
//                                mdl.setComment(text);

                                JSONObject likes = dt.getJSONObject("likes");
                                mdl.setNumLove(likes.getInt("count") + "");

                                JSONArray tags = dt.getJSONArray("tags");
                                String tagsString = "";
                                for (int j = 0; j < tags.length(); j++) {
                                    tagsString = tagsString + " #" + tags.get(j);
                                }
                                mdl.setHashtag(tagsString);

                                JSONObject comments = dt.getJSONObject("comments");
                                mdl.setNumComment(comments.getInt("count") + " COMMENT");

                                rowListItem.add(mdl);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        rcAdapter = new InstagramAdapter(InstagramActivity.this, rowListItem);
                        rView.setAdapter(rcAdapter);
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

    private void loadImageCircleRequest(ImageView img, String url){
        Glide.with(this)
                .load(url)
                .transform(new ImageViewCircleTransform(this))
                .into(img);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.news9_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "action search clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoginSignupBack:
                onBackPressed();
                break;
            case R.id.buttonEdit:
                Toast.makeText(this, "button edit clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onDestroy() {
        volleyQueue.cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return true;
            }
        });
        super.onDestroy();
    }
}
