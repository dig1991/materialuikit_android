package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style6;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class MusicStyle6Fragment extends Fragment implements View.OnClickListener, MusicStyle6ClickListener {
    int wizard_page_position;
    private MediaPlayer mediaPlayer;
    private ImageView buttonAudio;
    private boolean isPlaying = false;
    private SeekBar seekbar;
    private Handler myHandler = new Handler();

    public MusicStyle6Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.music6_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<MusicStyle6Model> rowListItem2 = getAllItemList2();
        MusicStyle6Adapter rcAdapter2 = new MusicStyle6Adapter(getActivity(), rowListItem2);
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 2);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerViewTopArtist);
        rView.setLayoutManager(lLayout);
        rView.setAdapter(rcAdapter2);
        rView.setNestedScrollingEnabled(false);
        rcAdapter2.setClickListener(this);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.audio);
        buttonAudio = (ImageView) view.findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(this);

        seekbar = (SeekBar) view.findViewById(R.id.seekbar);
        seekbar.setClickable(true);
        seekbar.setPadding(0, 0, 0, 0);

        return view;
    }

    private ArrayList<MusicStyle6Model> getAllItemList2(){
        ArrayList<MusicStyle6Model> allItems = new ArrayList<>();
        MusicStyle6Model dt;

        dt = new MusicStyle6Model("music/image_11.jpg", "Niall Horan", "8 Albums");
        allItems.add(dt);
        dt = new MusicStyle6Model("music/image_10.jpg", "Kashmir", "3 Albums");
        allItems.add(dt);
        dt = new MusicStyle6Model("music/image_9.jpg", "Alt-J", "8 Albums");
        allItems.add(dt);
        dt = new MusicStyle6Model("music/image_16.jpg", "Whitney Houston", "3 Albums");
        allItems.add(dt);

        return  allItems;
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            if(isPlaying) {
                seekbar.setProgress(mediaPlayer.getCurrentPosition());
                myHandler.postDelayed(this, 100);
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAudio:
                if(isPlaying){
                    mediaPlayer.pause();
                    buttonAudio.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_play_white));
                    isPlaying = false;
                }else{
                    mediaPlayer.start();
                    buttonAudio.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_pause_white));
                    seekbar.setMax(mediaPlayer.getDuration());
                    seekbar.setProgress(mediaPlayer.getCurrentPosition());
                    myHandler.postDelayed(UpdateSongTime, 100);
                    isPlaying = true;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void itemClicked(View view, int position) {
        int pos = position +1;
        Toast.makeText(getActivity(), "Genre Item " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
