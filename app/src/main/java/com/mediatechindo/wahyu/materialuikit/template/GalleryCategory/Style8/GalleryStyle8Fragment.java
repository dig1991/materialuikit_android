package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style8;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class GalleryStyle8Fragment extends Fragment {
    int wizard_page_position;
    private GalleryStyle8RecentAdapter rcAdapterRecent;

    public GalleryStyle8Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.gallery8_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<GalleryStyle8RecentModel> rowListItem = getAllItemInteriorList();
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 3);
        RecyclerView rViewInterior = (RecyclerView) view.findViewById(R.id.recyclerViewInterior);
        rcAdapterRecent = new GalleryStyle8RecentAdapter(getActivity(), rowListItem);

        rViewInterior.setHasFixedSize(true);
        rViewInterior.setLayoutManager(lLayout);
        rViewInterior.setNestedScrollingEnabled(false);
        rViewInterior.setAdapter(rcAdapterRecent);

        ArrayList<GalleryStyle8LastModel> rowListItem2 = getAllItemWomenList();
        GridLayoutManager lLayout2 = new GridLayoutManager(getActivity(), 3);
        RecyclerView rViewWomen = (RecyclerView) view.findViewById(R.id.recyclerViewWomen);
        GalleryStyle8LastAdapter rcAdapterWomen = new GalleryStyle8LastAdapter(getActivity(), rowListItem2);

        rViewWomen.setHasFixedSize(true);
        rViewWomen.setLayoutManager(lLayout2);
        rViewWomen.setNestedScrollingEnabled(false);
        rViewWomen.setAdapter(rcAdapterWomen);
        return view;
    }

    private ArrayList<GalleryStyle8RecentModel> getAllItemInteriorList(){
        ArrayList<GalleryStyle8RecentModel> allItems = new ArrayList<GalleryStyle8RecentModel>();
        GalleryStyle8RecentModel dt;

        for(int i=1; i<7; i++){
            dt = new GalleryStyle8RecentModel(i, "gallery/style-8/Gallery-8-img-" + i + ".png");
            allItems.add(dt);
        }

        return  allItems;
    }

    private ArrayList<GalleryStyle8LastModel> getAllItemWomenList(){
        ArrayList<GalleryStyle8LastModel> allItems = new ArrayList<GalleryStyle8LastModel>();
        GalleryStyle8LastModel dt;

        for(int i=7; i<13; i++){
            dt = new GalleryStyle8LastModel("gallery/style-1/Gallery-1-img-" + i + ".png");
            allItems.add(dt);
        }

        return  allItems;
    }

}
