package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class MusicStyle7Fragment extends Fragment implements View.OnClickListener, MusicStyle7ClickListener {
    int wizard_page_position;

    public MusicStyle7Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.music7_fragment;
        View view = inflater.inflate(layout_id, container, false);

        String url = BuildConfig.IMAGE_URL + "music/image_2.jpg";
        ImageView mainImageView = (ImageView) view.findViewById(R.id.mainImageView);
        loadImageRequest(mainImageView, url);
        mainImageView.setOnClickListener(this);

        ArrayList<MusicStyle7Model> rowListItem2 = getAllItemList2();
        MusicStyle7Adapter rcAdapter2 = new MusicStyle7Adapter(getActivity(), rowListItem2);
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 2);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerViewTopArtist);
        rView.setLayoutManager(lLayout);
        rView.setAdapter(rcAdapter2);
        rView.setNestedScrollingEnabled(false);
        rcAdapter2.setClickListener(this);

        return view;
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
    }

    private ArrayList<MusicStyle7Model> getAllItemList2(){
        ArrayList<MusicStyle7Model> allItems = new ArrayList<>();
        MusicStyle7Model dt;

        dt = new MusicStyle7Model("music/image_5.jpg", "Best Album 2017", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new MusicStyle7Model("music/image_1.jpg", "Hip Hop of The Month", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new MusicStyle7Model("music/image_15.jpg", "Top 10 Playlist", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new MusicStyle7Model("music/image_14.jpg", "Morning Workout", getString(R.string.lorem_ipsum4));
        allItems.add(dt);

        dt = new MusicStyle7Model("music/image_5.jpg", "Best Album 2017", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new MusicStyle7Model("music/image_1.jpg", "Hip Hop of The Month", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new MusicStyle7Model("music/image_15.jpg", "Top 10 Playlist", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new MusicStyle7Model("music/image_14.jpg", "Morning Workout", getString(R.string.lorem_ipsum4));
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mainImageView:
                Toast.makeText(getActivity(), "Play now clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void itemClicked(View view, int position) {
        int pos = position +1;
        Toast.makeText(getActivity(), "Item " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
