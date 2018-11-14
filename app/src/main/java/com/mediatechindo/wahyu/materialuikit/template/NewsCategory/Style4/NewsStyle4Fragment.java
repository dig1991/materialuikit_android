package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style4;

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

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class NewsStyle4Fragment extends Fragment implements View.OnClickListener, NewsStyle4ClickListener {
    int wizard_page_position;

    public NewsStyle4Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.news4_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<NewsStyle4Model> rowListItem2 = getAllItemList2();
        NewsStyle4Adapter rcAdapter2 = new NewsStyle4Adapter(getActivity(), rowListItem2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerViewTopArtist);
        rView.setLayoutManager(layoutManager);
        rView.setAdapter(rcAdapter2);
        rView.setNestedScrollingEnabled(false);
        rcAdapter2.setClickListener(this);

        String url = BuildConfig.IMAGE_URL + "news/style-4/news4_main.png";
        ImageView mainImage = (ImageView) view.findViewById(R.id.mainImage);
        loadImageRequest(mainImage, url);

        String url2 = BuildConfig.IMAGE_URL + "news/style-4/news4_stories4.png";
        ImageView mainImage2 = (ImageView) view.findViewById(R.id.mainImage2);
        loadImageRequest(mainImage2, url2);

        String url3 = BuildConfig.IMAGE_URL + "news/style-4/news4_stories5.png";
        ImageView mainImage3 = (ImageView) view.findViewById(R.id.mainImage3);
        loadImageRequest(mainImage3, url3);

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

    private ArrayList<NewsStyle4Model> getAllItemList2(){
        ArrayList<NewsStyle4Model> allItems = new ArrayList<>();
        NewsStyle4Model dt;

        dt = new NewsStyle4Model("news/style-4/news4_stories1.png", "The World Global Warming held in Washington", "Michael Adams", "15 min");
        allItems.add(dt);
        dt = new NewsStyle4Model("news/style-4/news4_stories2.png", "US President Inagurations held in Washington", "Roy Montgomery", "1 hour ago");
        allItems.add(dt);
        dt = new NewsStyle4Model("news/style-4/news4_stories3.png", "Spotlight on Medtech Outsourcing and Innovation", "Roy Motgomery", "1 hour ago");
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
