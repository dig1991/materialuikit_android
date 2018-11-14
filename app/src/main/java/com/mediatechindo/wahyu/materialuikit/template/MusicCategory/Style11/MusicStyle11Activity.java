package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style11;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.mediatechindo.wahyu.materialuikit.R.id.buttonPlay;

public class MusicStyle11Activity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private SeekBar seekbar;
    private TextView txtNow, txtTotal;
    private ImageView buttonAudio;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private boolean isRepeat = false;
    private boolean isShuffle = false;
    private ImageView buttonRepeat, buttonShuffle;


    private int timerPosition = 0;
    private MusicStyle11Adapter rcAdapter;
    private ArrayList<MusicStyle11Model> rowListLyrics = new ArrayList<>();
    private RecyclerView rView;

    private String[] lyricText;
    private double[] timer = {100,2000,3000,4500,6000,7000,8300,9000,9700,11000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music11_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            LayoutInflater mInflater = LayoutInflater.from(this);

            View mCustomView = mInflater.inflate(R.layout.music11_toolbar, null);
            actionBar.setCustomView(mCustomView);
            actionBar.setDisplayShowCustomEnabled(true);
        }

        lyricText = getResources().getStringArray(R.array.dummy_lyric);

        String url = BuildConfig.IMAGE_URL + "music/image_9.jpg";
        ImageView mainImageView = (ImageView) findViewById(R.id.imageBackground);
        loadImageRequest(mainImageView, url);

        String url2 = BuildConfig.IMAGE_URL + "music/image_10.jpg";
        ImageView songArt = (ImageView) findViewById(R.id.songArt);
        loadImageRequest(songArt, url2);

        txtNow = (TextView) findViewById(R.id.dislayNow);
        txtTotal = (TextView) findViewById(R.id.dislayTotal);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        buttonAudio = (ImageView) findViewById(R.id.buttonPlay);

        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        seekbar.setClickable(true);
        seekbar.setPadding(0, 0, 0, 0);

        finalTime = mediaPlayer.getDuration();
        txtTotal.setText(String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );

        buttonAudio.setOnClickListener(this);

        buttonRepeat = (ImageView) findViewById(R.id.buttonRepeat);
        buttonRepeat.setOnClickListener(this);
        findViewById(R.id.buttonPrev).setOnClickListener(this);
        findViewById(R.id.buttonNext).setOnClickListener(this);
        buttonShuffle = (ImageView) findViewById(R.id.buttonShuffle);
        buttonShuffle.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcAdapter = new MusicStyle11Adapter(this, rowListLyrics);

        rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setLayoutManager(layoutManager);
        rView.setAdapter(rcAdapter);
        rView.setNestedScrollingEnabled(false);

    }

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

                if(timer[timerPosition] <= startTime){
                    if(timerPosition == 0) {
                        rowListLyrics.add(new MusicStyle11Model(" ", 0));
                        rcAdapter.notifyItemInserted(0);
                        rcAdapter.updateTextLyrics();

                        rowListLyrics.add(new MusicStyle11Model(lyricText[timerPosition], timer[timerPosition]));
                        rcAdapter.notifyItemInserted(0);
                        rcAdapter.updateTextLyrics();

                        rowListLyrics.add(new MusicStyle11Model(lyricText[timerPosition + 1], timer[timerPosition + 1]));
                        rcAdapter.notifyItemInserted(0);
                        rcAdapter.updateTextLyrics();
                    }
                    if(timerPosition < (lyricText.length - 2)) {
                        rowListLyrics.add(new MusicStyle11Model(lyricText[timerPosition + 2], timer[timerPosition + 2]));
                        rcAdapter.notifyItemInserted(4);
                        rcAdapter.updateTextLyrics();
                    }

                    if (rowListLyrics.size() > 2 && timerPosition > 0){
                        rowListLyrics.remove(0);
                        rcAdapter.notifyItemRemoved(0);
                        rcAdapter.updateTextLyrics();
                    }

                    if(timerPosition < (lyricText.length - 1)) {
                        timerPosition++;
                    }
                }
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
        switch (view.getId()) {
            case R.id.buttonAudio:
            case buttonPlay:
                if (isPlaying) {
                    mediaPlayer.pause();
                    buttonAudio.setImageDrawable(ContextCompat.getDrawable(MusicStyle11Activity.this, R.drawable.ic_play_white2));
                    isPlaying = false;
                } else {
                    mediaPlayer.start();
                    timerPosition = 0;
                    rowListLyrics.clear();
                    buttonAudio.setImageDrawable(ContextCompat.getDrawable(MusicStyle11Activity.this, R.drawable.ic_pause_white2));

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
                    buttonRepeat.setImageDrawable(ContextCompat.getDrawable(MusicStyle11Activity.this, R.drawable.ic_repeat));
                    isRepeat = false;
                }else {
                    buttonRepeat.setImageDrawable(ContextCompat.getDrawable(MusicStyle11Activity.this, R.drawable.ic_repeat_orange));
                    isRepeat = true;
                }
                break;
            case R.id.buttonPrev:
                Toast.makeText(this, "Button Skip Previous clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonNext:
                Toast.makeText(this, "Button Skip Next clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonShuffle:
                if(isShuffle){
                    buttonShuffle.setImageDrawable(ContextCompat.getDrawable(MusicStyle11Activity.this, R.drawable.ic_shuffle));
                    isShuffle = false;
                }else{
                    buttonShuffle.setImageDrawable(ContextCompat.getDrawable(MusicStyle11Activity.this, R.drawable.ic_shuffle_orange));
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
