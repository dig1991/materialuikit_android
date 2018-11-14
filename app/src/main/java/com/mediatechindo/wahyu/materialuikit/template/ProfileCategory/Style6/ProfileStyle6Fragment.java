package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style6;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
 * Created by wahyu on 28/06/16.
 */

@SuppressLint("ValidFragment")
public class ProfileStyle6Fragment extends Fragment implements ProfileStyle6ClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile6_fragment, container, false);

        ArrayList<ProfileStyle6Model> rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        ProfileStyle6Adapter rcAdapter = new ProfileStyle6Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

        return view;
    }

    private ArrayList<ProfileStyle6Model> getAllItemList(){
        ArrayList<ProfileStyle6Model> allItems = new ArrayList<ProfileStyle6Model>();
        ProfileStyle6Model dt;

        dt = new ProfileStyle6Model("Urban Skyscrapers","19","profile/style-6/Profile-6-image1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle6Model("Citywalks","45","profile/style-6/Profile-6-image2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle6Model("Antique Cars","788","profile/style-6/Profile-6-image3.jpg");
        allItems.add(dt);
        dt = new ProfileStyle6Model("Urban Skyscrapers","19","profile/style-6/Profile-6-image1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle6Model("Citywalks","45","profile/style-6/Profile-6-image2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle6Model("Antique Cars","788","profile/style-6/Profile-6-image3.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
