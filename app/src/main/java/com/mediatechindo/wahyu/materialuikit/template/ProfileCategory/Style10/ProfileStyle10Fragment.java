package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style10;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class ProfileStyle10Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile10_fragment, container, false);

        ImageView bg = (ImageView) view.findViewById(R.id.imageMain);
        String url = BuildConfig.IMAGE_URL + "profile/style-10/Profile-10-background.jpg";
        String urlThumb = BuildConfig.IMAGE_URL + "profile/style-10/Profile-10-background_thumb.jpg";

        loadImageRequest(bg, url, urlThumb);

        return view;
    }

    private void loadImageRequest(ImageView img, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(getActivity())
                .load(urlThumb);

        Glide.with(getActivity())
                .load(url)
                .thumbnail(thumbnailRequest)
                .centerCrop()
                .crossFade()
                .into(img);
    }
}
