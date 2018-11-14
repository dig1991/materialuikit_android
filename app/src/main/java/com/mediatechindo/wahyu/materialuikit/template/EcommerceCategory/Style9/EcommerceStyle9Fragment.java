package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style9;

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
public class EcommerceStyle9Fragment extends Fragment implements EcommerceStyle9ClickListener{
    int wizard_page_position;

    public EcommerceStyle9Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.ecommerce9_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<EcommerceStyle9Model> rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        EcommerceStyle9Adapter rcAdapter = new EcommerceStyle9Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
        return view;
    }

    private ArrayList<EcommerceStyle9Model> getAllItemList(){
        ArrayList<EcommerceStyle9Model> allItems = new ArrayList<EcommerceStyle9Model>();
        EcommerceStyle9Model dt;

        dt = new EcommerceStyle9Model("Sky Blue Dress","192","ecommerce/style-9/Ecommerce-9-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle9Model("Velcro Sneaker White","225","ecommerce/style-9/Ecommerce-9-img-2.jpg");
        allItems.add(dt);

        dt = new EcommerceStyle9Model("Sky Blue Dress","192","ecommerce/style-9/Ecommerce-9-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle9Model("Velcro Sneaker White","225","ecommerce/style-9/Ecommerce-9-img-2.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
