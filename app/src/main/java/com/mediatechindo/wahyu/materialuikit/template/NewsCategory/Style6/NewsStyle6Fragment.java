package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style6;

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
import com.mediatechindo.wahyu.materialuikit.tools.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class NewsStyle6Fragment extends Fragment implements View.OnClickListener, NewsStyle6ClickListener {
    int wizard_page_position;

    public NewsStyle6Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.news6_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<NewsStyle6Model> rowListItem2 = getAllItemList2();
        NewsStyle6Adapter rcAdapter2 = new NewsStyle6Adapter(getActivity(), rowListItem2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerViewTopArtist);
        rView.setLayoutManager(layoutManager);
        rView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
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

    private ArrayList<NewsStyle6Model> getAllItemList2(){
        ArrayList<NewsStyle6Model> allItems = new ArrayList<>();
        NewsStyle6Model dt;

        dt = new NewsStyle6Model("profile/style-3/Profile-3-friend3.png","news/style-5/news5_image1.png", "Tony Ramirez", "Lifestyle", "Tech Tent: Old phone and safe social", "15 min", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new NewsStyle6Model("profile/style-3/Profile-3-friend3.png","news/style-5/news5_image2.png", "Ludwig", "Techno", "Google Al Defeat Human Go Champion", "15 min", getString(R.string.lorem_ipsum4));
        allItems.add(dt);
        dt = new NewsStyle6Model("profile/style-3/Profile-3-friend2.png","news/style-5/news5_image3.png", "Christina", "Business", "Thousands hit as glitch halts BA flights", "15 min", getString(R.string.lorem_ipsum4));
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
