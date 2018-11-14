package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style11;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 28/06/16.
 */
public class ProfileStyle11Tab1 extends Fragment implements View.OnClickListener{
    View tab1;
    View tab2;
    View tab3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile11_tab1_layout, container, false);

        ImageView bg = (ImageView) view.findViewById(R.id.imageMain);
        String url = BuildConfig.IMAGE_URL + "profile/style-11/Profile-11-background.jpg";
        String urlThumb = BuildConfig.IMAGE_URL + "profile/style-11/Profile-11-background_thumb.jpg";

        loadImageRequest(bg, url, urlThumb);

        Fragment mHome = new ProfileStyle11Fragment1();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.profile_layout_cont, mHome);
        ft.commit();

        LinearLayout tabPhotos = (LinearLayout) view.findViewById(R.id.tabPhotos);
        LinearLayout tabFollowers = (LinearLayout) view.findViewById(R.id.tabFollowers);
        LinearLayout tabFollowings = (LinearLayout) view.findViewById(R.id.tabFollowings);
        tabPhotos.setOnClickListener(this);
        tabFollowers.setOnClickListener(this);
        tabFollowings.setOnClickListener(this);

        tab1 = view.findViewById(R.id.tab1Indicator);
        tab2 = view.findViewById(R.id.tab2Indicator);
        tab3 = view.findViewById(R.id.tab3Indicator);

        return view;
    }

    private void loadImageRequest(ImageView img, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(getActivity())
                .load(urlThumb);

        Glide.with(getActivity())
                .load(url)
                .thumbnail(thumbnailRequest)
                .crossFade()
                .into(img);
    }

    @Override
    public void onClick(View view) {
        Fragment fm1 = new ProfileStyle11Fragment1();
        Fragment fm2 = new ProfileStyle11Fragment2();
        Fragment fm3 = new ProfileStyle11Fragment3();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft;

        tab1.setVisibility(View.INVISIBLE);
        tab2.setVisibility(View.INVISIBLE);
        tab3.setVisibility(View.INVISIBLE);
        switch (view.getId()){
            case R.id.tabPhotos:
                ft = fm.beginTransaction();
                ft.replace(R.id.profile_layout_cont, fm1);
                ft.commit();
                tab1.setVisibility(View.VISIBLE);
                break;
            case R.id.tabFollowers:
                ft = fm.beginTransaction();
                ft.replace(R.id.profile_layout_cont, fm2);
                ft.commit();
                tab2.setVisibility(View.VISIBLE);
                break;
            case R.id.tabFollowings:
                ft = fm.beginTransaction();
                ft.replace(R.id.profile_layout_cont, fm3);
                ft.commit();
                tab3.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

}
