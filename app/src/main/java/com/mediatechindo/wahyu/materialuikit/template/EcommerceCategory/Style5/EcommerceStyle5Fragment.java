package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class EcommerceStyle5Fragment extends Fragment implements View.OnClickListener{
    int wizard_page_position;

    public EcommerceStyle5Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.ecommerce5_fragment;
        View view = inflater.inflate(layout_id, container, false);

        String url1 = BuildConfig.IMAGE_URL + "ecommerce/style-5/Ecommerce-5-img-1.jpg";
        String url2 = BuildConfig.IMAGE_URL + "ecommerce/style-5/Ecommerce-5-img-2.jpg";
        String url3 = BuildConfig.IMAGE_URL + "ecommerce/style-5/Ecommerce-5-img-3.jpg";

        loadImageRequest((ImageView) view.findViewById(R.id.image1), url1);
        loadImageRequest((ImageView) view.findViewById(R.id.image2), url2);
        loadImageRequest((ImageView) view.findViewById(R.id.image3), url3);
        loadImageRequest((ImageView) view.findViewById(R.id.image4), url2);

        (view.findViewById(R.id.buttonShopNow)).setOnClickListener(this);

        return view;
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(getActivity())
                .load(url)
                .crossFade()
                .thumbnail(0.01f)
                .fitCenter()
                .into(bg);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "Button Shop Now clicked!", Toast.LENGTH_SHORT).show();
    }
}
