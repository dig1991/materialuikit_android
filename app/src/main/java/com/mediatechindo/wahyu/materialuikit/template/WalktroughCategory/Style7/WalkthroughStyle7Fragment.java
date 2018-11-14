package com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class WalkthroughStyle7Fragment extends Fragment {
    int wizard_page_position;

    public WalkthroughStyle7Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.walkthrough7_fragment;
        View view = inflater.inflate(layout_id, container, false);

        String url = BuildConfig.IMAGE_URL + "walkthrough/style-7/Welcome-7-circle.png";
        String urlThumb = BuildConfig.IMAGE_URL + "walkthrough/style-7/Welcome-7-circle-thumb.png";

        ImageView img = (ImageView) view.findViewById(R.id.imagePage1);
        loadImageRequest(img, url, urlThumb);

        return view;
    }

    private void loadImageRequest(ImageView img, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(this)
                .load(urlThumb);

        Glide.with(this)
                .load(url)
                .transform(new ImageViewCircleTransform(getActivity()))
                .crossFade()
                .thumbnail(thumbnailRequest)
                .into(img);

    }
}
