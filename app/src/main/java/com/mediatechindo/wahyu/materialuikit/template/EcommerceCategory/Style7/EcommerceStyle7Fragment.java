package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class EcommerceStyle7Fragment extends Fragment implements EcommerceStyle7OnStartDragListener{
    int wizard_page_position;
    private ItemTouchHelper mItemTouchHelper;

    public EcommerceStyle7Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.ecommerce7_fragment;
        View view = inflater.inflate(layout_id, container, false);

        EcommerceStyle7Adapter adapter = new EcommerceStyle7Adapter(getActivity(), this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemTouchHelper.Callback callback = new EcommerceStyle7ItemTouchCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        return view;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
