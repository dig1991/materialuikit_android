package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style7;

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
public class GalleryStyle7Fragment extends Fragment implements  GalleryStyle7ClickListener {
    int wizard_page_position;
    private GalleryStyle7RecentAdapter rcAdapterRecent;
    private ArrayList<GalleryStyle7RecentModel> itemSelected = new ArrayList<>();

    public GalleryStyle7Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.gallery7_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<GalleryStyle7RecentModel> rowListItem = getAllItemInteriorList();
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 3);
        RecyclerView rViewInterior = (RecyclerView) view.findViewById(R.id.recyclerViewInterior);
        rcAdapterRecent = new GalleryStyle7RecentAdapter(getActivity(), rowListItem);

        rViewInterior.setHasFixedSize(true);
        rViewInterior.setLayoutManager(lLayout);
        rViewInterior.setNestedScrollingEnabled(false);
        rViewInterior.setAdapter(rcAdapterRecent);
        rcAdapterRecent.setClickListener(this);

        ArrayList<GalleryStyle7LastModel> rowListItem2 = getAllItemWomenList();
        GridLayoutManager lLayout2 = new GridLayoutManager(getActivity(), 3);
        RecyclerView rViewWomen = (RecyclerView) view.findViewById(R.id.recyclerViewWomen);
        GalleryStyle7LastAdapter rcAdapterWomen = new GalleryStyle7LastAdapter(getActivity(), rowListItem2);

        rViewWomen.setHasFixedSize(true);
        rViewWomen.setLayoutManager(lLayout2);
        rViewWomen.setNestedScrollingEnabled(false);
        rViewWomen.setAdapter(rcAdapterWomen);
        return view;
    }

    private ArrayList<GalleryStyle7RecentModel> getAllItemInteriorList(){
        ArrayList<GalleryStyle7RecentModel> allItems = new ArrayList<GalleryStyle7RecentModel>();
        GalleryStyle7RecentModel dt;

        for(int i=1; i<7; i++){
            dt = new GalleryStyle7RecentModel(i, "gallery/style-1/Gallery-1-img-" + i + ".png");
            allItems.add(dt);
        }

        return  allItems;
    }

    private ArrayList<GalleryStyle7LastModel> getAllItemWomenList(){
        ArrayList<GalleryStyle7LastModel> allItems = new ArrayList<GalleryStyle7LastModel>();
        GalleryStyle7LastModel dt;

        for(int i=7; i<13; i++){
            dt = new GalleryStyle7LastModel("gallery/style-1/Gallery-1-img-" + i + ".png");
            allItems.add(dt);
        }

        return  allItems;
    }

    @Override
    public void itemRecentSelect(View view, int id) {
        itemSelected.add(new GalleryStyle7RecentModel(id));
        ((GalleryStyle7Activity) getActivity()).setDataSelected(rcAdapterRecent, itemSelected);
    }

    @Override
    public void itemRecentUnSelect(View view, int id) {
        for (int i = 0; i < itemSelected.size(); i++) {
            if (itemSelected.get(i).getId() == id) {
                itemSelected.remove(i);
            }
        }
        ((GalleryStyle7Activity) getActivity()).setDataSelected(rcAdapterRecent, itemSelected);
    }
}
