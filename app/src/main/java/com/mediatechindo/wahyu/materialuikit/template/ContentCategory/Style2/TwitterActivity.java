package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style2;

import android.os.AsyncTask;
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
import android.util.Base64;
import android.util.Log;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.mediatechindo.wahyu.materialuikit.R.id.recyclerView;

public class TwitterActivity extends AppCompatActivity implements View.OnClickListener{
    RequestQueue volleyQueue;
    RecyclerView rView;
    ArrayList<TwitterModel> rowListItem;
    TwitterAdapter rcAdapter;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_layout);
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

//        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rView = (RecyclerView) findViewById(recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        username = "Android";
        new DownloadTwitterTask().execute();
    }

    public void getData(final String token) {
        String url = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=" + username + "&count=10";

        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Twitter", "onResponse: " + response);
                        rowListItem = new ArrayList<>();
                        TwitterModel dt;
                        try {
                            JSONArray post = new JSONArray(response);
                            for (int i = 0; i < post.length(); i++) {
                                JSONObject data = (JSONObject) post.get(i);

                                JSONObject user = data.getJSONObject("user");

                                dt = new TwitterModel();
                                dt.setComment(data.getString("text"));
                                dt.setTime(data.getString("created_at"));
                                dt.setName(user.getString("name"));
                                dt.setUsername("@" + user.getString("screen_name"));
                                dt.setProfileUrl(user.getString("profile_background_image_url"));


                                rowListItem.add(dt);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        rcAdapter = new TwitterAdapter(TwitterActivity.this, rowListItem);
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
                params.put("Authorization", token);
                return params;
            }
        };

        int socketTimeout = 5000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        getRequest.setRetryPolicy(policy);
        volleyQueue.add(getRequest);
    }

    class DownloadTwitterTask extends AsyncTask<String, Void, String> {
        final String CONSUMER_KEY = TwitterActivity.this.getResources().getString(R.string.twitter_consumer_key);
        final String CONSUMER_SECRET = TwitterActivity.this.getResources().getString(R.string.twitter_consumer_secret);

        @Override
        protected String doInBackground(String... param) {
            JSONObject jsonAccess;
            String token = "";
            try {
                jsonAccess = new JSONObject(authenticateApp());
                token = jsonAccess.getString("token_type") + " " + jsonAccess.getString("access_token");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return token;
        }

        // onPostExecute convert the JSON results into a Twitter object (which is an Array list of tweets
        @Override
        protected void onPostExecute(String result) {
            getData(result);
        }

        private String authenticateApp() {
            Exception e;
            Throwable th;
            HttpURLConnection connection = null;
            StringBuilder reply = null;
            try {
                connection = (HttpURLConnection) new URL("https://api.twitter.com/oauth2/token").openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.addRequestProperty("Authorization", "Basic " + Base64.encodeToString((this.CONSUMER_KEY + ":" + this.CONSUMER_SECRET).getBytes(), 2));
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                connection.connect();
                OutputStream os = connection.getOutputStream();
                os.write("grant_type=client_credentials".getBytes());
                os.flush();
                os.close();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                try {
                    StringBuilder reply2 = new StringBuilder();
                    while (true) {
                        try {
                            String line = br.readLine();
                            if (line == null) {
                                break;
                            }
                            reply2.append(line);
                        } catch (Exception e2) {
                            e = e2;
                            reply = reply2;
                        } catch (Throwable th2) {
                            th = th2;
                            reply = reply2;
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                        reply = reply2;
                    } else {
                        reply = reply2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        if (connection != null) {
                            connection.disconnect();
                        }
                        return reply.toString();
                    } catch (Throwable th3) {
                        th = th3;
                        if (connection != null) {
                            connection.disconnect();
                        }
                        try {
                            throw th;
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (connection != null) {
                        connection.disconnect();
                    }
                    try {
                        throw th;
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e = e4;
                if (connection != null) {
                    connection.disconnect();
                }
                return reply.toString();
            }
            return reply.toString();
        }
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
