package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style15;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 28/06/16.
 */

@SuppressLint("ValidFragment")
public class ProfileStyle15Fragment extends Fragment {
    private GridLayoutManager lLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile15_fragment, container, false);

        ImageView img1 = (ImageView) view.findViewById(R.id.image1);
        String url = BuildConfig.IMAGE_URL + "profile/style-15/Profile-15-image1.jpg";
        String urlThumb = BuildConfig.IMAGE_URL + "profile/style-15/Profile-15-image1-thumb.jpg";
        loadImageRequest(img1, url, urlThumb);

        ImageView img2 = (ImageView) view.findViewById(R.id.image2);
        String url2 = BuildConfig.IMAGE_URL + "profile/style-15/Profile-15-image2.jpg";
        String urlThumb2 = BuildConfig.IMAGE_URL + "profile/style-15/Profile-15-image2-thumb.jpg";
        loadImageRequest(img2, url2, urlThumb2);

        return view;
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
}
