package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class MusicStyle2Activity extends AppCompatActivity implements View.OnClickListener, MusicStyle2ClickListener {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private FloatingActionButton buttonPlay;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music2_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.music2_toolbar_gradient));
        }

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Artist");
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));

        String url = BuildConfig.IMAGE_URL + "music/image_12.jpg";
        ImageView mainImageView = (ImageView) findViewById(R.id.mainImageView);
        loadImageRequest(mainImageView, url);

        //browse by genre
        ArrayList<MusicStyle2Model> rowListItem1 = getAllItemList1();
        MusicStyle2Adapter1 rcAdapter1 = new MusicStyle2Adapter1(this, rowListItem1);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView rView1 = (RecyclerView) findViewById(R.id.recyclerViewGenre);
        rView1.setLayoutManager(layoutManager1);
        rView1.setAdapter(rcAdapter1);
        rView1.setNestedScrollingEnabled(false);
        rcAdapter1.setClickListener(this);

        //Top 40 albums
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ArrayList<MusicStyle2Model> rowListItem2 = getAllItemList2();
        MusicStyle2Adapter2 rcAdapter2 = new MusicStyle2Adapter2(this, rowListItem2);

        RecyclerView rView2 = (RecyclerView) findViewById(R.id.recyclerViewTopAlbum);
        rView2.setLayoutManager(layoutManager2);
        rView2.setAdapter(rcAdapter2);
        rView2.setNestedScrollingEnabled(false);
        rcAdapter2.setClickListener(this);

        buttonPlay = (FloatingActionButton) findViewById(R.id.buttonPlay);
        buttonPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play_white2));

        AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
                    buttonPlay.hide();
                } else {
                    buttonPlay.show();
                }
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.audio);

        Button buttonFollow = (Button) findViewById(R.id.buttonFollow);
        buttonFollow.setOnClickListener(this);
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
    }

    private ArrayList<MusicStyle2Model> getAllItemList1(){
        ArrayList<MusicStyle2Model> allItems = new ArrayList<>();
        MusicStyle2Model dt;

        dt = new MusicStyle2Model("music/image_11.jpg", "Treepassers", "8 Songs", "2016");
        allItems.add(dt);
        dt = new MusicStyle2Model("music/image_10.jpg", "Katalogue", "22 Songs", "2016");
        allItems.add(dt);
        dt = new MusicStyle2Model("music/image_11.jpg", "Treepassers", "8 Songs", "2016");
        allItems.add(dt);
        dt = new MusicStyle2Model("music/image_10.jpg", "Katalogue", "22 Songs", "2016");
        allItems.add(dt);

        return  allItems;
    }

    private ArrayList<MusicStyle2Model> getAllItemList2(){
        ArrayList<MusicStyle2Model> allItems = new ArrayList<>();
        MusicStyle2Model dt;

        dt = new MusicStyle2Model("Rocket brothers", "2:35");
        allItems.add(dt);
        dt = new MusicStyle2Model("Mouthful of Wasps", "2:35");
        allItems.add(dt);
        dt = new MusicStyle2Model("The Aftermath", "2:35");
        allItems.add(dt);
        dt = new MusicStyle2Model("Mom in Love, Dad in Space", "2:35");
        allItems.add(dt);
        dt = new MusicStyle2Model("Kalifornia", "2:35");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return true;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonPlay:
                if(isPlaying){
                    mediaPlayer.pause();
                    buttonPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play_white2));
                    isPlaying = false;
                }else{
                    mediaPlayer.start();
                    buttonPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pause_white2));
                    isPlaying = true;
                }
                break;
            case R.id.buttonFollow:
                Toast.makeText(this, "Button follow clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void itemClicked1(View view, int position) {
        int pos = position +1;
        Toast.makeText(this, "Feature Item " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClicked2(View view, int position) {
        int pos = position +1;
        Toast.makeText(this, "Popular Item " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }

}
