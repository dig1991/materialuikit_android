package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style17;

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
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style7.GalleryStyle7RecentAdapter;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style7.GalleryStyle7RecentModel;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class GalleryStyle17Fragment extends Fragment {
    int wizard_page_position;
    private GalleryStyle7RecentAdapter rcAdapterRecent;
    private ArrayList<GalleryStyle7RecentModel> itemSelected = new ArrayList<>();

    public GalleryStyle17Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.gallery17_fragment;
        View view = inflater.inflate(layout_id, container, false);


        ImageView bg = (ImageView) view.findViewById(R.id.imageMain);
        String url = BuildConfig.IMAGE_URL + "gallery/style-17/Gallery-17-img-1.png";
        String urlThumb = BuildConfig.IMAGE_URL + "gallery/style-17/Gallery-17-img-1-thumb.png";
        loadImageRequest(bg, url, urlThumb);

        return view;
    }

    private void loadImageRequest(ImageView bg, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(this)
                .load(urlThumb);

        Glide.with(this)
                .load(url)
                .crossFade()
                .thumbnail(thumbnailRequest)
                .into(bg);
    }

}
