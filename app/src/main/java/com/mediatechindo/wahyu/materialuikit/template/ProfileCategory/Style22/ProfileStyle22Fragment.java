package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style22;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 28/06/16.
 */

@SuppressLint("ValidFragment")
public class ProfileStyle22Fragment extends Fragment implements ProfileStyle22ClickListener, View.OnClickListener{
    ArrayList<ProfileStyle22Model> rowListItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile22_fragment, container, false);

        rowListItem = getAllItemList();
        StaggeredGridLayoutManager gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        Button btnHire = (Button) view.findViewById(R.id.btnHire);
        btnHire.setOnClickListener(this);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(gaggeredGridLayoutManager);
        rView.setNestedScrollingEnabled(false);

        ProfileStyle22Adapter rcAdapter = new ProfileStyle22Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
        return view;
    }

    private ArrayList<ProfileStyle22Model> getAllItemList(){
        ArrayList<ProfileStyle22Model> allItems = new ArrayList<ProfileStyle22Model>();
        ProfileStyle22Model dt;

        dt = new ProfileStyle22Model("Book Shelf","profile/style-18/Profile-18-post1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle22Model("Bedroom","profile/style-18/Profile-18-post2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle22Model("Mirror","profile/style-18/Profile-18-post3.jpg");
        allItems.add(dt);
        dt = new ProfileStyle22Model("Chair","profile/style-18/Profile-18-post4.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        ProfileStyle22Model dt = rowListItem.get(position);
        Toast.makeText(getActivity(), dt.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "Button hire clicked!", Toast.LENGTH_SHORT).show();
    }
}
