package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style13;

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
public class ActivityStyle13Fragment extends Fragment implements ActivityStyle13ClickListener{
    int wizard_page_position;
    ArrayList<ActivityStyle13Model> rowListItem;

    public ActivityStyle13Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.activity13_fragment;
        View view = inflater.inflate(layout_id, container, false);

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        ActivityStyle13Adapter rcAdapter = new ActivityStyle13Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
        return view;
    }

    private ArrayList<ActivityStyle13Model> getAllItemList(){
        ArrayList<ActivityStyle13Model> allItems = new ArrayList<>();
        ActivityStyle13Model dt;

        dt = new ActivityStyle13Model("Christopher Nolan","activity/style-13/Activity-13-img-1.jpg");
        allItems.add(dt);
        dt = new ActivityStyle13Model("Nikita Woods","activity/style-13/Activity-13-img-2.jpg");
        allItems.add(dt);
        dt = new ActivityStyle13Model("Madelaine","activity/style-13/Activity-13-img-3.jpg");
        allItems.add(dt);
        dt = new ActivityStyle13Model("Jonas Bjerre","activity/style-13/Activity-13-img-4.jpg");
        allItems.add(dt);
        dt = new ActivityStyle13Model("Christopher Nolan","activity/style-13/Activity-13-img-1.jpg");
        allItems.add(dt);
        dt = new ActivityStyle13Model("Nikita Woods","activity/style-13/Activity-13-img-2.jpg");
        allItems.add(dt);
        dt = new ActivityStyle13Model("Madelaine","activity/style-13/Activity-13-img-3.jpg");
        allItems.add(dt);
        dt = new ActivityStyle13Model("Jonas Bjerre","activity/style-13/Activity-13-img-4.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int pos = position + 1;
        Toast.makeText(getActivity(), "Position " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
