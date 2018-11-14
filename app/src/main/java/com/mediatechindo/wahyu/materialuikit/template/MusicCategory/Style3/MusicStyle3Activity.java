package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style3;

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
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class MusicStyle3Activity extends AppCompatActivity implements View.OnClickListener, MusicStyle3ClickListener {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private ImageView buttonAudio;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private FloatingActionButton buttonPlay;
    private MusicStyle3Adapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music3_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.music2_toolbar_gradient));
        }

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));

        String url = BuildConfig.IMAGE_URL + "music/image_3.jpg";
        ImageView mainImageView = (ImageView) findViewById(R.id.imageBackground);
        loadImageRequest(mainImageView, url);

        String url2 = BuildConfig.IMAGE_URL + "music/image_10.jpg";
        ImageView musicArt = (ImageView) findViewById(R.id.musicArt);
        loadImageRequest(musicArt, url2);

        //Top 40 albums
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ArrayList<MusicStyle3Model> rowListItem2 = getAllItemList2();
        rcAdapter = new MusicStyle3Adapter(this, rowListItem2);

        RecyclerView rView2 = (RecyclerView) findViewById(R.id.recyclerView);
        rView2.setLayoutManager(layoutManager);
        rView2.setAdapter(rcAdapter);
        rView2.setNestedScrollingEnabled(false);
        rcAdapter.setClickListener(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        buttonAudio = (ImageView) findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(this);

        buttonPlay = (FloatingActionButton) findViewById(R.id.buttonPlay);
        buttonPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play_white2));

        AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
                    buttonPlay.hide();
                }else{
                    buttonPlay.show();
                }
            }
        });
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
    }

    private ArrayList<MusicStyle3Model> getAllItemList2(){
        ArrayList<MusicStyle3Model> allItems = new ArrayList<>();
        MusicStyle3Model dt;

        dt = new MusicStyle3Model("Rocket brothers", "2:35");
        allItems.add(dt);
        dt = new MusicStyle3Model("Mouthful of Wasps", "2:35");
        allItems.add(dt);
        dt = new MusicStyle3Model("The Aftermath", "2:35");
        allItems.add(dt);
        dt = new MusicStyle3Model("Mom in Love, Dad in Space", "2:35");
        allItems.add(dt);
        dt = new MusicStyle3Model("Kalifornia", "2:35");
        allItems.add(dt);

        dt = new MusicStyle3Model("Rocket brothers", "2:35");
        allItems.add(dt);
        dt = new MusicStyle3Model("Mouthful of Wasps", "2:35");
        allItems.add(dt);
        dt = new MusicStyle3Model("The Aftermath", "2:35");
        allItems.add(dt);
        dt = new MusicStyle3Model("Mom in Love, Dad in Space", "2:35");
        allItems.add(dt);
        dt = new MusicStyle3Model("Kalifornia", "2:35");
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

    private void playMusic(){
        if(isPlaying){
            mediaPlayer.pause();
            buttonPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play_white2));
            buttonAudio.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play_white));
            isPlaying = false;
        }else{
            mediaPlayer.start();
            buttonPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pause_white2));
            buttonAudio.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pause_white));
            isPlaying = true;

            if(rcAdapter.getSelectedPosition() == -1) {
                rcAdapter.setSelectedPosition(0);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAudio:
            case R.id.buttonPlay:
                playMusic();
                break;
            case R.id.buttonFollow:
                Toast.makeText(this, "Button follow clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void itemClicked(MusicStyle3Adapter.ItemViewHolder holder, int position) {
        isPlaying = false;
        playMusic();
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }

}
