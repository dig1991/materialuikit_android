package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class ActivityStyle3Fragment extends Fragment {
    int wizard_page_position;

    public ActivityStyle3Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.activity3_fragment;
        View view = inflater.inflate(layout_id, container, false);

        String friend3Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend3.png";
        String friend2Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend2.png";
        String urlPost = BuildConfig.IMAGE_URL + "activity/style-3/Activity-3-img.jpg";

        ImageView imgProfile1 = (ImageView) view.findViewById(R.id.imgProfile1);
        ImageView imgProfile2 = (ImageView) view.findViewById(R.id.imgProfile2);
        ImageView imgProfile3 = (ImageView) view.findViewById(R.id.imgProfile3);
        ImageView image1 = (ImageView) view.findViewById(R.id.image1);


        loadImageCircleRequest(imgProfile1, friend2Url);
        loadImageCircleRequest(imgProfile2, friend3Url);
        loadImageCircleRequest(imgProfile3, friend2Url);

        loadImageRequest(image1, urlPost);
        return view;
    }

    private void loadImageCircleRequest(ImageView img, String url){
        Glide.with(getActivity())
                .load(url)
                .transform(new ImageViewCircleTransform(getActivity()))
                .into(img);
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(getActivity())
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
    }
}
