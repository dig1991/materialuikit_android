package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style9;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class MusicStyle9Activity extends AppCompatActivity implements View.OnClickListener, MusicStyle9ClickListener {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private FloatingActionButton buttonPlay;
    private MusicStyle9Adapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music9_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Workout Playlist");
            actionBar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.music2_toolbar_gradient));
        }

        //Top 40 albums
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ArrayList<MusicStyle9Model> rowListItem2 = getAllItemList2();
        rcAdapter = new MusicStyle9Adapter(this, rowListItem2);

        RecyclerView rView2 = (RecyclerView) findViewById(R.id.recyclerView);
        rView2.setLayoutManager(layoutManager);
        rView2.setAdapter(rcAdapter);
        rView2.setNestedScrollingEnabled(false);
        rcAdapter.setClickListener(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        buttonPlay = (FloatingActionButton) findViewById(R.id.buttonPlay);
        buttonPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play_white2));
        buttonPlay.setOnClickListener(this);
    }

    private ArrayList<MusicStyle9Model> getAllItemList2(){
        ArrayList<MusicStyle9Model> allItems = new ArrayList<>();
        MusicStyle9Model dt;

        dt = new MusicStyle9Model("Rocket brothers", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("Mouthful of Wasps", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("The Aftermath", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("Mom in Love, Dad in Space", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("Kalifornia", "2:35");
        allItems.add(dt);

        dt = new MusicStyle9Model("Rocket brothers", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("Mouthful of Wasps", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("The Aftermath", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("Mom in Love, Dad in Space", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("Kalifornia", "2:35");
        allItems.add(dt);

        dt = new MusicStyle9Model("Rocket brothers", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("Mouthful of Wasps", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("The Aftermath", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("Mom in Love, Dad in Space", "2:35");
        allItems.add(dt);
        dt = new MusicStyle9Model("Kalifornia", "2:35");
        allItems.add(dt);

        return  allItems;
    }

    private void playMusic(){
        if(isPlaying){
            mediaPlayer.pause();
            buttonPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_play_white2));
            isPlaying = false;
        }else{
            mediaPlayer.start();
            buttonPlay.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pause_white2));
            isPlaying = true;

            if(rcAdapter.getSelectedPosition() == -1) {
                rcAdapter.setSelectedPosition(0);
            }
        }
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
    public void itemClicked(MusicStyle9Adapter.ItemViewHolder holder, int position) {
        isPlaying = false;
        playMusic();
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }
}
