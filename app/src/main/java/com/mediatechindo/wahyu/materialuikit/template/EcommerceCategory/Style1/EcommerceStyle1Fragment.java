package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class EcommerceStyle1Fragment extends Fragment implements EcommerceStyle1ClickListener, View.OnClickListener{
    int wizard_page_position;

    public EcommerceStyle1Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.ecommerce1_fragment;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<EcommerceStyle1Model> rowListItem = getAllItemList();
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 2);

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        EcommerceStyle1Adapter rcAdapter = new EcommerceStyle1Adapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

        (view.findViewById(R.id.buttonShopNow)).setOnClickListener(this);

        String url = BuildConfig.IMAGE_URL + "ecommerce/style-1/Ecommerce-1.jpg";
        String urlThumb = BuildConfig.IMAGE_URL + "ecommerce/style-1/Ecommerce-1-thumb.jpg";
        loadImageRequest((ImageView) view.findViewById(R.id.headerImage), url, urlThumb);

        return view;
    }

    private ArrayList<EcommerceStyle1Model> getAllItemList(){
        ArrayList<EcommerceStyle1Model> allItems = new ArrayList<EcommerceStyle1Model>();
        EcommerceStyle1Model dt;

        dt = new EcommerceStyle1Model("Sky Blue Dress","$225","ecommerce/style-1/Ecommerce-1-img-post-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle1Model("Sky Blue Dress","$225","ecommerce/style-1/Ecommerce-1-img-post-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle1Model("Sky Blue Dress","$225","ecommerce/style-1/Ecommerce-1-img-post-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle1Model("Sky Blue Dress","$225","ecommerce/style-1/Ecommerce-1-img-post-4.jpg");
        allItems.add(dt);

        dt = new EcommerceStyle1Model("Sky Blue Dress","$225","ecommerce/style-1/Ecommerce-1-img-post-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle1Model("Sky Blue Dress","$225","ecommerce/style-1/Ecommerce-1-img-post-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle1Model("Sky Blue Dress","$225","ecommerce/style-1/Ecommerce-1-img-post-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle1Model("Sky Blue Dress","$225","ecommerce/style-1/Ecommerce-1-img-post-4.jpg");
        allItems.add(dt);

        return  allItems;
    }

    private void loadImageRequest(ImageView bg, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(getActivity())
                .load(urlThumb);

        Glide.with(getActivity())
                .load(url)
                .crossFade()
                .thumbnail(thumbnailRequest)
                .into(bg);
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "Button Shop Now clicked!", Toast.LENGTH_SHORT).show();
    }
}
