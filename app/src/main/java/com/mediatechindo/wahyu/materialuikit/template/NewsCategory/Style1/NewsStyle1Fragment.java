package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class NewsStyle1Fragment extends Fragment {
    int wizard_page_position;

    public NewsStyle1Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.news1_fragment;
        View view = inflater.inflate(layout_id, container, false);
        return view;
    }

}
