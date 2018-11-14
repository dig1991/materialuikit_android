package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style25;

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
import com.mediatechindo.wahyu.materialuikit.tools.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by wahyu on 28/06/16.
 */

@SuppressLint("ValidFragment")
public class ProfileStyle25Fragment extends Fragment implements ProfileStyle25ClickListener{
    ArrayList<ProfileStyle25Model> rowListItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile25_fragment, container, false);

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerView);
        rView.setLayoutManager(layoutManager);
        rView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        ProfileStyle25Adapter rcAdapter = new ProfileStyle25Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
        return view;
    }

    private ArrayList<ProfileStyle25Model> getAllItemList(){
        ArrayList<ProfileStyle25Model> allItems = new ArrayList<ProfileStyle25Model>();
        ProfileStyle25Model dt;

        dt = new ProfileStyle25Model("Making Friends is Easy","profile/style-25/Profile-25-post1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle25Model("I'm Born to Run","profile/style-25/Profile-25-post2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle25Model("I Wandered Strange Roads","profile/style-25/Profile-25-post3.jpg");
        allItems.add(dt);
        dt = new ProfileStyle25Model("I Wanna be Careless","profile/style-25/Profile-25-post4.jpg");
        allItems.add(dt);
        dt = new ProfileStyle25Model("Making Friends is Easy","profile/style-25/Profile-25-post1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle25Model("I'm Born to Run","profile/style-25/Profile-25-post2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle25Model("I Wandered Strange Roads","profile/style-25/Profile-25-post3.jpg");
        allItems.add(dt);
        dt = new ProfileStyle25Model("I Wanna be Careless","profile/style-25/Profile-25-post4.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        ProfileStyle25Model dt = rowListItem.get(position);
        Toast.makeText(getActivity(), dt.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
