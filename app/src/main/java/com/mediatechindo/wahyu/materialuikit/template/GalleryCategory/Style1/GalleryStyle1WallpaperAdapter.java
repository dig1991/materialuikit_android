package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle1WallpaperAdapter extends RecyclerView.Adapter<GalleryStyle1WallpaperAdapter.ItemViewHolder> {
    private static ArrayList<GalleryStyle1WallpaperModel> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private GalleryStyle1WallpaperClickListener clicklistener = null;

    public GalleryStyle1WallpaperAdapter(Context ctx, ArrayList<GalleryStyle1WallpaperModel> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private LinearLayout lastItemCover;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            lastItemCover = (LinearLayout) itemView.findViewById(R.id.lastItemCover);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemPhotoClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(GalleryStyle1WallpaperClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_gallery1, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);

        if ((position+1) == dataList.size()){
            holder.lastItemCover.setVisibility(View.VISIBLE);
        }else{
            holder.lastItemCover.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
