package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style12;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class MusicStyle12Fragment extends Fragment implements View.OnClickListener, MusicStyle12ClickListener {
    int wizard_page_position;

    public MusicStyle12Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.music12_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<MusicStyle12Model> rowListItem2 = getAllItemList2();
        MusicStyle12Adapter rcAdapter2 = new MusicStyle12Adapter(getActivity(), rowListItem2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerViewTopArtist);
        rView.setLayoutManager(layoutManager);
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

    private ArrayList<MusicStyle12Model> getAllItemList2(){
        ArrayList<MusicStyle12Model> allItems = new ArrayList<>();
        MusicStyle12Model dt;

        dt = new MusicStyle12Model("music/video_image_4.png", "Spirit Musical Behaved on Farther Letters", "235 views * 12 hours ago");
        allItems.add(dt);
        dt = new MusicStyle12Model("music/video_image_3.png", "Spirit Musical Behaved on Farther Letters", "235 views * 12 hours ago");
        allItems.add(dt);

        dt = new MusicStyle12Model("music/video_image_4.png", "Spirit Musical Behaved on Farther Letters", "235 views * 12 hours ago");
        allItems.add(dt);
        dt = new MusicStyle12Model("music/video_image_3.png", "Spirit Musical Behaved on Farther Letters", "235 views * 12 hours ago");
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
