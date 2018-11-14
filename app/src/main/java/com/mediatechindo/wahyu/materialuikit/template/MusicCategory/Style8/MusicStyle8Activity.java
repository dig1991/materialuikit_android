package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style8;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

import static com.mediatechindo.wahyu.materialuikit.R.id.buttonPlay;

public class MusicStyle8Activity extends AppCompatActivity implements View.OnClickListener, MusicStyle8ClickListener {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private ImageView buttonAudio;
    private SeekBar seekbar;
    private Handler myHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music8_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("My Playlist");
            actionBar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.music2_toolbar_gradient));
        }

        //Top 40 albums
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ArrayList<MusicStyle8Model> rowListItem2 = getAllItemList2();
        MusicStyle8Adapter rcAdapter2 = new MusicStyle8Adapter(this, rowListItem2);

        RecyclerView rView2 = (RecyclerView) findViewById(R.id.recyclerView);
        rView2.setLayoutManager(layoutManager);
        rView2.setAdapter(rcAdapter2);
        rView2.setNestedScrollingEnabled(false);
        rcAdapter2.setClickListener(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        buttonAudio = (ImageView) findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(this);

        seekbar = (SeekBar) findViewById(R.id.seekbar);
        seekbar.setClickable(true);
        seekbar.setPadding(0, 0, 0, 0);

        String url = BuildConfig.IMAGE_URL + "music/image_10.jpg";
        ImageView mainImageView = (ImageView) findViewById(R.id.musicArt);
        loadImageRequest(mainImageView, url);
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            if(isPlaying) {
                seekbar.setProgress(mediaPlayer.getCurrentPosition());
                myHandler.postDelayed(this, 100);
            }
        }
    };

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
    }

    private ArrayList<MusicStyle8Model> getAllItemList2(){
        ArrayList<MusicStyle8Model> allItems = new ArrayList<>();
        MusicStyle8Model dt;

        dt = new MusicStyle8Model("music/playlist_1.png", "Workout Playlist", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_2.png", "My Favourite Playlist", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_3.png", "All time Rock", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_4.png", "Blues", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_5.png", "Study Songs", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_6.png", "Popstars", "240 Songs");
        allItems.add(dt);

        dt = new MusicStyle8Model("music/playlist_1.png", "Workout Playlist", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_2.png", "My Favourite Playlist", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_3.png", "All time Rock", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_4.png", "Blues", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_5.png", "Study Songs", "240 Songs");
        allItems.add(dt);
        dt = new MusicStyle8Model("music/playlist_6.png", "Popstars", "240 Songs");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.music8_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_add:
                Toast.makeText(this, "Action Add Playlist clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAudio:
            case buttonPlay:
                if(isPlaying){
                    mediaPlayer.pause();
                    buttonAudio.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play_white));
                    isPlaying = false;
                }else{
                    mediaPlayer.start();
                    buttonAudio.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pause_white));
                    seekbar.setMax(mediaPlayer.getDuration());
                    seekbar.setProgress(mediaPlayer.getCurrentPosition());
                    myHandler.postDelayed(UpdateSongTime, 100);
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
    public void itemClicked(View view, int position) {
        int pos = position +1;
        Toast.makeText(this, "Playlist " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }

}
