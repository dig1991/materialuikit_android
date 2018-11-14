package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle6Adapter extends RecyclerView.Adapter<ActivityStyle6Adapter.ItemViewHolder> {
    private static ArrayList<ActivityStyle6Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ActivityStyle6ClickListener clicklistener = null;

    public ActivityStyle6Adapter(Context ctx, ArrayList<ActivityStyle6Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private ImageView imgProfile;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(ActivityStyle6ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_activity6, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .thumbnail(0.01f)
                .fitCenter()
                .into(holder.image);

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imgProfile);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
