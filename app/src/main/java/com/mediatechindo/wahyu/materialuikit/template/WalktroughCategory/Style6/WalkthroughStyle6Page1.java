package com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 15/11/16.
 */

public class WalkthroughStyle6Page1 extends Fragment{
    private static final String TAG = "WalkthroughStyle6";
    private ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.walkthrough6_fragment;
        View view = inflater.inflate(layout_id, container, false);

        String url = BuildConfig.IMAGE_URL + "walkthrough/style-6/Welcome-6.jpg";

        img = (ImageView) view.findViewById(R.id.contentImage);

        ((WalkthroughStyle6Activity) getActivity()).setImageFragment1(img);
        loadImageRequest(img, url);

        return view;
    }

    private void loadImageRequest(ImageView img, String url) {
        Glide.with(getActivity())
                .load(url)
                .thumbnail(0.1f)
                .into(img);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: page 1");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: page 1");
    }
}
