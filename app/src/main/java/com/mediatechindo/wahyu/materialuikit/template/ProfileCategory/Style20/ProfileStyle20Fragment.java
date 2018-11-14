package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style20;

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
public class ProfileStyle20Fragment extends Fragment implements ProfileStyle20ClickListener{
    ArrayList<ProfileStyle20Model> rowListItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile20_fragment, container, false);

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerView);
        rView.setLayoutManager(layoutManager);
        rView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        ProfileStyle20Adapter rcAdapter = new ProfileStyle20Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
        return view;
    }

    private ArrayList<ProfileStyle20Model> getAllItemList(){
        ArrayList<ProfileStyle20Model> allItems = new ArrayList<ProfileStyle20Model>();
        ProfileStyle20Model dt;

        dt = new ProfileStyle20Model("Michelle Hendley","San Fransisco, CA","profile/style-3/Profile-3-friend1.png");
        allItems.add(dt);
        dt = new ProfileStyle20Model("Kimberly White","Manhattan, NY","profile/style-3/Profile-3-friend2.png");
        allItems.add(dt);
        dt = new ProfileStyle20Model("Steve Roger","Booklyn, NY","profile/style-3/Profile-3-friend3.png");
        allItems.add(dt);
        dt = new ProfileStyle20Model("Amy Patterson","Little Indian, ABQ","profile/style-3/Profile-3-friend4.png");
        allItems.add(dt);
        dt = new ProfileStyle20Model("Hannah Paige","San Fransisco, CA","profile/style-3/Profile-3-friend5.png");
        allItems.add(dt);
        dt = new ProfileStyle20Model("Michelle Hendley","San Fransisco, CA","profile/style-3/Profile-3-friend1.png");
        allItems.add(dt);
        dt = new ProfileStyle20Model("Kimberly White","Manhattan, NY","profile/style-3/Profile-3-friend2.png");
        allItems.add(dt);
        dt = new ProfileStyle20Model("Steve Roger","Booklyn, NY","profile/style-3/Profile-3-friend3.png");
        allItems.add(dt);
        dt = new ProfileStyle20Model("Amy Patterson","Little Indian, ABQ","profile/style-3/Profile-3-friend4.png");
        allItems.add(dt);
        dt = new ProfileStyle20Model("Hannah Paige","San Fransisco, CA","profile/style-3/Profile-3-friend5.png");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        ProfileStyle20Model dt = rowListItem.get(position);
        Toast.makeText(getActivity(), dt.getName() + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
