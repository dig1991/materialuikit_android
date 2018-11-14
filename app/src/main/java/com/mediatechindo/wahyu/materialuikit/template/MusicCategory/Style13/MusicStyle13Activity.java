package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style13;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.concurrent.TimeUnit;

public class MusicStyle13Activity extends AppCompatActivity implements
        View.OnClickListener,
        MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnVideoSizeChangedListener,
        SurfaceHolder.Callback,
        MediaController.MediaPlayerControl {

    private MediaPlayer mMediaPlayer;
    private SurfaceView mSurfaceView;
    private SurfaceHolder holder;
    private TextView txtNow, txtTotal;
    private Handler handler;
    private SeekBar seekbar;
    private boolean isPlaying = false;
    private boolean isVideoReady = false;
    private double startTime = 0;
    private double finalTime = 0;
    private RelativeLayout videoInfo;
    private ImageView buttonPlay;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music13_layout);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Spirit Musical Behaved on Farther Letters");
            actionBar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.music2_toolbar_gradient));
        }

        videoInfo = (RelativeLayout) findViewById(R.id.videoInfo);

        txtNow = (TextView) findViewById(R.id.dislayNow);
        txtTotal = (TextView) findViewById(R.id.dislayTotal);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        seekbar.setClickable(true);

        // https://s3-us-west-2.amazonaws.com/material-ui-template/music/video_image_1.png

        String url = BuildConfig.IMAGE_URL + "music/video_image_2.png";
        ImageView mainImageView = (ImageView) findViewById(R.id.imageView);
        loadImageRequest(mainImageView, url);

        mSurfaceView = (SurfaceView) findViewById(R.id.surface);
        handler = new Handler();
        holder = mSurfaceView.getHolder();
        holder.addCallback(this);

        playVideo();
        buttonPlay = (ImageView) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        (findViewById(R.id.buttonFullscreen)).setOnClickListener(this);
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
    }

    private Handler myHandler = new Handler();

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            if (isPlaying) {
                startTime = mMediaPlayer.getCurrentPosition();
                txtNow.setText(String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes((long) startTime)))
                );
                seekbar.setProgress(mMediaPlayer.getCurrentPosition());
                myHandler.postDelayed(this, 100);
            }
        }
    };

    private void playVideo() {
        try {
            mMediaPlayer = MediaPlayer.create(this, R.raw.video);
            mMediaPlayer.setOnBufferingUpdateListener(this);
            mMediaPlayer.setOnCompletionListener(this);
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.setScreenOnWhilePlaying(true);
            mMediaPlayer.setOnVideoSizeChangedListener(this);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.seekTo(100);

            finalTime = mMediaPlayer.getDuration();
            txtTotal.setText(String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    finalTime)))
            );


            seekbar.setMax(mMediaPlayer.getDuration());
            seekbar.setProgress(mMediaPlayer.getCurrentPosition());

            myHandler.postDelayed(UpdateSongTime, 100);

            isPlaying = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isFullScreen = false;

    private void setFullScreenVideo(){
        if(isFullScreen) {
            isFullScreen = false;
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            actionBar.show();
        }else{
            isFullScreen = true;
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            actionBar.hide();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.music13_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
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
    public boolean onTouchEvent(MotionEvent event) {
        showVideoInfo();
        return false;
    }

    private void showVideoInfo(){
        videoInfo.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                videoInfo.setVisibility(View.GONE);
            }
        }, 5000);
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        mMediaPlayer.setDisplay(holder);
        isVideoReady = true;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {

    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        showVideoInfo();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public void start() {
        mMediaPlayer.start();
    }

    @Override
    public void pause() {
        mMediaPlayer.pause();
    }

    @Override
    public int getDuration() {
        return mMediaPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mMediaPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int i) {
        mMediaPlayer.seekTo(i);
    }

    @Override
    public boolean isPlaying() {
        return mMediaPlayer.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Override
    protected void onDestroy() {
        isPlaying = false;
        mMediaPlayer.release();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPlay:
                if(isVideoReady) {
                    mMediaPlayer.start();
                    buttonPlay.setVisibility(View.GONE);
                }
                break;
            case R.id.buttonFullscreen:
                setFullScreenVideo();
                break;
            default:
                break;
        }
    }
}
