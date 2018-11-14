package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style5;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style4.MusicStyle4Model;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.mediatechindo.wahyu.materialuikit.R.id.buttonPlay;

public class MusicStyle5Activity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private SeekBar seekbar;
    private TextView txtNow;
    private ImageView buttonAudio;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private boolean isRepeat = false;
    private boolean isShuffle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music5_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Now Playing");
            actionBar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.music2_toolbar_gradient));
        }

        String url = BuildConfig.IMAGE_URL + "music/image_7.jpg";
        ImageView mainImageView = (ImageView) findViewById(R.id.imageBackground);
        loadImageRequest(mainImageView, url);

        String url2 = BuildConfig.IMAGE_URL + "music/image_10.jpg";
        ImageView songArt = (ImageView) findViewById(R.id.songArt);
        loadImageRequest(songArt, url2);

        txtNow = (TextView) findViewById(R.id.dislayNow);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        buttonAudio = (ImageView) findViewById(R.id.buttonPlay);

        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        seekbar.setClickable(true);
        seekbar.setPadding(0, 0, 0, 0);

        finalTime = mediaPlayer.getDuration();

        buttonAudio.setOnClickListener(this);

        buttonRepeat = (ImageView) findViewById(R.id.buttonRepeat);
        buttonRepeat.setOnClickListener(this);
        findViewById(R.id.buttonPrev).setOnClickListener(this);
        findViewById(R.id.buttonNext).setOnClickListener(this);
        findViewById(R.id.buttonMore).setOnClickListener(this);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
        buttonShuffle = (ImageView) findViewById(R.id.buttonShuffle);
        buttonShuffle.setOnClickListener(this);

    }

    private ImageView buttonRepeat, buttonShuffle;

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            if(isPlaying) {
                startTime = mediaPlayer.getCurrentPosition();
                txtNow.setText(String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes((long) startTime)))
                );
                seekbar.setProgress((int) startTime);
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

    private ArrayList<MusicStyle4Model> getAllItemList2() {
        ArrayList<MusicStyle4Model> allItems = new ArrayList<>();
        MusicStyle4Model dt;

        dt = new MusicStyle4Model("Rocket brothers", "2:35");
        allItems.add(dt);
        dt = new MusicStyle4Model("Mouthful of Wasps", "2:35");
        allItems.add(dt);
        dt = new MusicStyle4Model("The Aftermath", "2:35");
        allItems.add(dt);
        dt = new MusicStyle4Model("Mom in Love, Dad in Space", "2:35");
        allItems.add(dt);
        dt = new MusicStyle4Model("Kalifornia", "2:35");
        allItems.add(dt);

        dt = new MusicStyle4Model("Rocket brothers", "2:35");
        allItems.add(dt);
        dt = new MusicStyle4Model("Mouthful of Wasps", "2:35");
        allItems.add(dt);
        dt = new MusicStyle4Model("The Aftermath", "2:35");
        allItems.add(dt);
        dt = new MusicStyle4Model("Mom in Love, Dad in Space", "2:35");
        allItems.add(dt);
        dt = new MusicStyle4Model("Kalifornia", "2:35");
        allItems.add(dt);

        return allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.music5_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_list:
                Toast.makeText(this, "Action Show Playlist clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "Action Setting clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAudio:
            case buttonPlay:
                if (isPlaying) {
                    mediaPlayer.pause();
                    buttonAudio.setImageDrawable(ContextCompat.getDrawable(MusicStyle5Activity.this, R.drawable.ic_play_white2));
                    isPlaying = false;
                } else {
                    mediaPlayer.start();

                    buttonAudio.setImageDrawable(ContextCompat.getDrawable(MusicStyle5Activity.this, R.drawable.ic_pause_white2));

                    startTime = mediaPlayer.getCurrentPosition();
                    seekbar.setMax((int) finalTime);

                    txtNow.setText(String.format("%02d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                            startTime)))
                    );

                    seekbar.setProgress((int) startTime);

                    myHandler.postDelayed(UpdateSongTime, 100);

                    isPlaying = true;
                }
                break;
            case R.id.buttonRepeat:
                if(isRepeat){
                    buttonRepeat.setImageDrawable(ContextCompat.getDrawable(MusicStyle5Activity.this, R.drawable.ic_repeat));
                    isRepeat = false;
                }else {
                    buttonRepeat.setImageDrawable(ContextCompat.getDrawable(MusicStyle5Activity.this, R.drawable.ic_repeat_orange));
                    isRepeat = true;
                }
                break;
            case R.id.buttonPrev:
                Toast.makeText(this, "Button Skip Previous clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonAdd:
                Toast.makeText(this, "Button Add clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonMore:
                Toast.makeText(this, "Button More clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonNext:
                Toast.makeText(this, "Button Skip Next clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonShuffle:
                if(isShuffle){
                    buttonShuffle.setImageDrawable(ContextCompat.getDrawable(MusicStyle5Activity.this, R.drawable.ic_shuffle));
                    isShuffle = false;
                }else{
                    buttonShuffle.setImageDrawable(ContextCompat.getDrawable(MusicStyle5Activity.this, R.drawable.ic_shuffle_orange));
                    isShuffle = true;
                }

                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        isPlaying = false;
        mediaPlayer.release();
        super.onDestroy();
    }
}
