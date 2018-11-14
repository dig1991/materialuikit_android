package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style2;

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
public class ProfileStyle2Fragment extends Fragment implements ProfileStyle2ClickListener {
    private GridLayoutManager lLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile2_fragment, container, false);

        ArrayList<ProfileStyle2Model> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getActivity(), 4);

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        ProfileStyle2Adapter rcAdapter = new ProfileStyle2Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

        return view;
    }

    private ArrayList<ProfileStyle2Model> getAllItemList(){
        ArrayList<ProfileStyle2Model> allItems = new ArrayList<ProfileStyle2Model>();
        ProfileStyle2Model dt;

        for(int i=0; i<12; i++){
            int num = i + 1;
            dt = new ProfileStyle2Model("profile/style-2/Profile-2-post" + num + ".png");
            allItems.add(dt);
        }
        for(int i=0; i<12; i++){
            int num = i + 1;
            dt = new ProfileStyle2Model("profile/style-2/Profile-2-post" + num + ".png");
            allItems.add(dt);
        }

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Position " + num + " clicked", Toast.LENGTH_SHORT).show();
    }
}
