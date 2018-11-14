package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
public class ProfileStyle1Fragment extends Fragment implements ProfileStyle1ClickListener {
    private RecyclerView recyclerView;
    private GridLayoutManager lLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile1_fragment, container, false);

        ArrayList<ProfileStyle1Model> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getActivity(), 2);

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        ProfileStyle1Adapter rcAdapter = new ProfileStyle1Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

        return view;
    }

    private ArrayList<ProfileStyle1Model> getAllItemList(){
        ArrayList<ProfileStyle1Model> allItems = new ArrayList<ProfileStyle1Model>();
        ProfileStyle1Model dt;

        dt = new ProfileStyle1Model("Book Shelf","123","35435","profile/style-1/profile-1-post-1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle1Model("Bedroom","546","567","profile/style-1/profile-1-post-2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle1Model("Mirror","22","54","profile/style-1/profile-1-post-3.jpg");
        allItems.add(dt);
        dt = new ProfileStyle1Model("Chair","546","54776","profile/style-1/profile-1-post-4.jpg");
        allItems.add(dt);
        dt = new ProfileStyle1Model("Book Shelf","123","35435","profile/style-1/profile-1-post-1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle1Model("Bedroom","546","567","profile/style-1/profile-1-post-2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle1Model("Mirror","22","54","profile/style-1/profile-1-post-3.jpg");
        allItems.add(dt);
        dt = new ProfileStyle1Model("Chair","546","54776","profile/style-1/profile-1-post-4.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
