package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style24;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
 * Created by wahyu on 28/06/16.
 */

@SuppressLint("ValidFragment")
public class ProfileStyle24Fragment extends Fragment implements ProfileStyle24FriendClickListener, ProfileStyle24PhotoClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profile24_fragment, container, false);

        ArrayList<ProfileStyle24PhotoModel> rowListItem = getAllItemPhotoList();
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 3);
        RecyclerView rViewPhotos = (RecyclerView) view.findViewById(R.id.recyclerViewPhotos);
        ProfileStyle24PhotoAdapter rcAdapterPhotos = new ProfileStyle24PhotoAdapter(getActivity(), rowListItem);
        rcAdapterPhotos.setClickListener(this);

        rViewPhotos.setHasFixedSize(true);
        rViewPhotos.setLayoutManager(lLayout);
        rViewPhotos.setNestedScrollingEnabled(false);
        rViewPhotos.setAdapter(rcAdapterPhotos);

        ArrayList<ProfileStyle24FriendModel> rowListItem2 = getAllItemFriendList();
        GridLayoutManager lLayout2 = new GridLayoutManager(getActivity(), 3);
        RecyclerView rViewFriends = (RecyclerView) view.findViewById(R.id.recyclerViewFriends);
        ProfileStyle24FriendAdapter rcAdapterFriends = new ProfileStyle24FriendAdapter(getActivity(), rowListItem2);
        rcAdapterFriends.setClickListener(this);

        rViewFriends.setHasFixedSize(true);
        rViewFriends.setLayoutManager(lLayout2);
        rViewFriends.setNestedScrollingEnabled(false);
        rViewFriends.setAdapter(rcAdapterFriends);

        ImageView bg = (ImageView) view.findViewById(R.id.imageBackground);
        String url = BuildConfig.IMAGE_URL + "profile/style-10/Profile-10-background.jpg";
        String urlThumb = BuildConfig.IMAGE_URL + "profile/style-10/Profile-10-background_thumb.jpg";

        loadImageRequest(bg, url, urlThumb);

        return view;
    }

    private ArrayList<ProfileStyle24PhotoModel> getAllItemPhotoList(){
        ArrayList<ProfileStyle24PhotoModel> allItems = new ArrayList<ProfileStyle24PhotoModel>();
        ProfileStyle24PhotoModel dt;

        for(int i=0; i<6; i++){
            int num = i + 1;
            dt = new ProfileStyle24PhotoModel("profile/style-2/Profile-2-post" + num + ".png");
            allItems.add(dt);
        }

        return  allItems;
    }

    private ArrayList<ProfileStyle24FriendModel> getAllItemFriendList(){
        ArrayList<ProfileStyle24FriendModel> allItems = new ArrayList<ProfileStyle24FriendModel>();
        ProfileStyle24FriendModel dt;

        for(int i=0; i<5; i++){
            int num = i + 1;
            dt = new ProfileStyle24FriendModel("profile/style-3/Profile-3-friend" + num + ".png");
            allItems.add(dt);
        }

        return  allItems;
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
    public void itemFriendClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Friend " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemPhotoClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Portfolio " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
