package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style7;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.DividerItemDecoration;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

import java.util.ArrayList;

public class NewsStyle7Activity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<NewsStyle7Model> rowListItem;
    NewsStyle7Adapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news7_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        ImageView image = (ImageView) findViewById(R.id.imageVideo);
        String url = BuildConfig.IMAGE_URL + "news/style-7/news_7_video_thumb.png";
        loadImageRequest(image, url);

        ImageView image2 = (ImageView) findViewById(R.id.imageProfile);
        String url2 = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend3.png";
        loadImageCircleRequest(image2, url2);

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rView.setNestedScrollingEnabled(true);

        rcAdapter = new NewsStyle7Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
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

    private ArrayList<NewsStyle7Model> getAllItemList() {
        ArrayList<NewsStyle7Model> allItems = new ArrayList<>();
        NewsStyle7Model dt;

        dt = new NewsStyle7Model("profile/style-3/Profile-3-friend3.png", "Tony Ramirez", "15 min", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new NewsStyle7Model("profile/style-3/Profile-3-friend3.png", "Ludwig", "15 min", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new NewsStyle7Model("profile/style-3/Profile-3-friend2.png", "Christina", "15 min", getString(R.string.lorem_ipsum4));
        allItems.add(dt);

        return allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity28_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "action setting clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Button Play Video clicked!", Toast.LENGTH_SHORT).show();
    }
}
