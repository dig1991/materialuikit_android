package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style14;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle14Adapter extends RecyclerView.Adapter<ActivityStyle14Adapter.ItemViewHolder> {
    private static ArrayList<ActivityStyle14Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ActivityStyle14ClickListener clicklistener = null;

    public ActivityStyle14Adapter(Context ctx, ArrayList<ActivityStyle14Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView name;
        private TextView title;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            name = (TextView) itemView.findViewById(R.id.name);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(ActivityStyle14ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity14, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {

        holder.name.setText(dataList.get(position).getName());
        holder.title.setText(dataList.get(position).getTitle());

        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrlThumb());

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .thumbnail(thumbnailRequest)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
