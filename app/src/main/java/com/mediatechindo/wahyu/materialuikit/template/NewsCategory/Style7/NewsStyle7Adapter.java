package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style7;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class NewsStyle7Adapter extends RecyclerView.Adapter<NewsStyle7Adapter.ItemViewHolder> {
    private static ArrayList<NewsStyle7Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public NewsStyle7Adapter(Context ctx, ArrayList<NewsStyle7Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageProfile;
        private TextView name, time, comment;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageProfile = (ImageView) itemView.findViewById(R.id.imageProfile);
            name = (TextView) itemView.findViewById(R.id.name);
            time = (TextView) itemView.findViewById(R.id.time);
            comment = (TextView) itemView.findViewById(R.id.comment);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news7, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.time.setText(dataList.get(position).getTime());
        holder.comment.setText(dataList.get(position).getComment());

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imageProfile);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
