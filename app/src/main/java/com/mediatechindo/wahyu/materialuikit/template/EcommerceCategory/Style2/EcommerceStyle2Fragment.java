package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style2;

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
public class EcommerceStyle2Fragment extends Fragment implements EcommerceStyle2ClickListener{
    int wizard_page_position;

    public EcommerceStyle2Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.ecommerce2_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<EcommerceStyle2Model> rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        EcommerceStyle2Adapter rcAdapter = new EcommerceStyle2Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
        return view;
    }

    private ArrayList<EcommerceStyle2Model> getAllItemList(){
        ArrayList<EcommerceStyle2Model> allItems = new ArrayList<EcommerceStyle2Model>();
        EcommerceStyle2Model dt;

        dt = new EcommerceStyle2Model("Round Neck Dress","19","ecommerce/style-2/Ecommerce-2-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle2Model("Retro Printed Dress","22","ecommerce/style-2/Ecommerce-2-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle2Model("Seemed Plain Dress","22","ecommerce/style-2/Ecommerce-2-img-3.jpg");
        allItems.add(dt);

        dt = new EcommerceStyle2Model("Retro Printed Dress","22","ecommerce/style-2/Ecommerce-2-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle2Model("Seemed Plain Dress","22","ecommerce/style-2/Ecommerce-2-img-3.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
