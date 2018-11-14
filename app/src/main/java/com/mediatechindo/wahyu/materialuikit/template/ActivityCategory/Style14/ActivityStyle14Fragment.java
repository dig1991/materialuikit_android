package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style14;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class ActivityStyle14Fragment extends Fragment implements ActivityStyle14ClickListener {
    int wizard_page_position;
    ArrayList<ActivityStyle14Model> rowListItem;

    public ActivityStyle14Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.activity14_fragment;
        View view = inflater.inflate(layout_id, container, false);

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        ActivityStyle14Adapter rcAdapter = new ActivityStyle14Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
        return view;
    }

    private ArrayList<ActivityStyle14Model> getAllItemList(){
        ArrayList<ActivityStyle14Model> allItems = new ArrayList<>();
        ActivityStyle14Model dt;

        dt = new ActivityStyle14Model("Christopher Nolan",
                "Shanghai City Landscape",
                "activity/style-14/Activity-14-img-1.jpg",
                "activity/style-14/Activity-14-img-1-thumb.jpg");
        allItems.add(dt);
        dt = new ActivityStyle14Model("Nikita Woods",
                "Japanese Cuisine",
                "activity/style-14/Activity-14-img-2.jpg",
                "activity/style-14/Activity-14-img-2-thumb.jpg");
        allItems.add(dt);
        dt = new ActivityStyle14Model("Christopher Nolan",
                "Shanghai City Landscape",
                "activity/style-14/Activity-14-img-1.jpg",
                "activity/style-14/Activity-14-img-1-thumb.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int pos = position + 1;
        Toast.makeText(getActivity(), "Position " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
