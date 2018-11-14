package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style14;

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
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class MusicStyle14Fragment extends Fragment implements View.OnClickListener, MusicStyle14ClickListener {
    int wizard_page_position;

    public MusicStyle14Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.music14_fragment;
        View view = inflater.inflate(layout_id, container, false);

        String url1 = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend3.png";
        ImageView mainImageView1 = (ImageView) view.findViewById(R.id.profilePicture);
        loadImageCircleRequest(mainImageView1, url1);

        String url = BuildConfig.IMAGE_URL + "music/video_image_6.png";
        ImageView mainImageView = (ImageView) view.findViewById(R.id.mainImageView);
        loadImageRequest(mainImageView, url);
        mainImageView.setOnClickListener(this);

        ArrayList<MusicStyle14Model> rowListItem1 = getAllItemList1();

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        MusicStyle14Adapter1 rcAdapter1 = new MusicStyle14Adapter1(getActivity(), rowListItem1);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerViewMyVideos);
        rView.setLayoutManager(layoutManager1);
        rView.setAdapter(rcAdapter1);
        rView.setNestedScrollingEnabled(false);
        rcAdapter1.setClickListener(this);

        ArrayList<MusicStyle14Model> rowListItem2 = getAllItemList2();

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        MusicStyle14Adapter2 rcAdapter2 = new MusicStyle14Adapter2(getActivity(), rowListItem2);

        RecyclerView rView2 = (RecyclerView) view.findViewById(R.id.recyclerViewWatchLater);
        rView2.setLayoutManager(layoutManager2);
        rView2.setAdapter(rcAdapter2);
        rView2.setNestedScrollingEnabled(false);
        rcAdapter2.setClickListener(this);

        return view;
    }

    private void loadImageCircleRequest(ImageView img, String url){
        Glide.with(this)
                .load(url)
                .transform(new ImageViewCircleTransform(getActivity()))
                .into(img);
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
    }

    private ArrayList<MusicStyle14Model> getAllItemList1(){
        ArrayList<MusicStyle14Model> allItems = new ArrayList<>();
        MusicStyle14Model dt;

        dt = new MusicStyle14Model("music/video_image_3.png", "Spirit Musical Behaved on Farther", "235 views");
        allItems.add(dt);
        dt = new MusicStyle14Model("music/video_image_2.png", "Spirit Musical Behaved on Farther", "235 views");
        allItems.add(dt);

        dt = new MusicStyle14Model("music/video_image_3.png", "Spirit Musical Behaved on Farther", "235 views");
        allItems.add(dt);
        dt = new MusicStyle14Model("music/video_image_2.png", "Spirit Musical Behaved on Farther", "235 views");
        allItems.add(dt);

        return  allItems;
    }

    private ArrayList<MusicStyle14Model> getAllItemList2(){
        ArrayList<MusicStyle14Model> allItems = new ArrayList<>();
        MusicStyle14Model dt;

        dt = new MusicStyle14Model("music/video_image_4.png", "Spirit Musical Behaved on Farther", "235 views");
        allItems.add(dt);
        dt = new MusicStyle14Model("music/video_image_5.png", "Spirit Musical Behaved on Farther", "235 views");
        allItems.add(dt);

        dt = new MusicStyle14Model("music/video_image_4.png", "Spirit Musical Behaved on Farther", "235 views");
        allItems.add(dt);
        dt = new MusicStyle14Model("music/video_image_5.png", "Spirit Musical Behaved on Farther", "235 views");
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
    public void itemClicked1(View view, int position) {
        int pos = position +1;
        Toast.makeText(getActivity(), "My Videos Item " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClicked2(View view, int position) {
        int pos = position +1;
        Toast.makeText(getActivity(), "Watch Later Item " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
