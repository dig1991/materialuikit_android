package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style14;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style7.GalleryStyle7RecentAdapter;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style7.GalleryStyle7RecentModel;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class GalleryStyle14Fragment extends Fragment implements  GalleryStyle14ClickListener {
    int wizard_page_position;
    private GalleryStyle7RecentAdapter rcAdapterRecent;
    private ArrayList<GalleryStyle7RecentModel> itemSelected = new ArrayList<>();

    public GalleryStyle14Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.gallery14_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<GalleryStyle14Model> rowListItem = getAllItemList();
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 2);

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        GalleryStyle14Adapter rcAdapter = new GalleryStyle14Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

        return view;
    }

    private ArrayList<GalleryStyle14Model> getAllItemList(){
        ArrayList<GalleryStyle14Model> allItems = new ArrayList<GalleryStyle14Model>();
        GalleryStyle14Model dt;

        dt = new GalleryStyle14Model("Book Shelf","123","35435","gallery/style-14/Gallery-14-img-1.png");
        allItems.add(dt);
        dt = new GalleryStyle14Model("Bedroom","546","567","gallery/style-14/Gallery-14-img-2.png");
        allItems.add(dt);
        dt = new GalleryStyle14Model("Furniture","22","54","gallery/style-14/Gallery-14-img-3.png");
        allItems.add(dt);
        dt = new GalleryStyle14Model("Object","546","54776","gallery/style-14/Gallery-14-img-4.png");
        allItems.add(dt);
        dt = new GalleryStyle14Model("Mirror","123","35435","gallery/style-14/Gallery-14-img-5.png");
        allItems.add(dt);
        dt = new GalleryStyle14Model("Object","546","567","gallery/style-14/Gallery-14-img-6.png");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
