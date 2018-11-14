package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style15;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class GalleryStyle15TabFragment extends Fragment {
    int wizard_page_position;
    private RelativeLayout foregroundColor;

    public GalleryStyle15TabFragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.gallery15_tabfragment;
        View view = inflater.inflate(layout_id, container, false);

        ImageView image = (ImageView) view.findViewById(R.id.imageMain);
        foregroundColor = (RelativeLayout) view.findViewById(R.id.foregroundColor);
        if(wizard_page_position == 0) {
            foregroundColor.setVisibility(View.GONE);
        }
        ((GalleryStyle15Fragment) getParentFragment()).setTabFgFragment(wizard_page_position, foregroundColor);


        String url = BuildConfig.IMAGE_URL + "gallery/style-10/Gallery-10-img-1.png";
        String urlThumb = BuildConfig.IMAGE_URL + "gallery/style-10/Gallery-10-img-1-thumb.png";
        loadImageRequest(image, url, urlThumb);
        return view;
    }

    private void loadImageRequest(ImageView img, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(getActivity())
                .load(urlThumb);

        Glide.with(getActivity())
                .load(url)
                .thumbnail(thumbnailRequest)
                .into(img);
    }

}
