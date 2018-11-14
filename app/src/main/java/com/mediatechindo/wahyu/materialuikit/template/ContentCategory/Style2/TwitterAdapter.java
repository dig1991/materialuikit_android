package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class TwitterAdapter extends RecyclerView.Adapter<TwitterAdapter.ItemViewHolder> {
    private static ArrayList<TwitterModel> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public TwitterAdapter(Context ctx, ArrayList<TwitterModel> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageProfile;
        private TextView name, username, time, comment;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageProfile = (ImageView) itemView.findViewById(R.id.imageProfile);
            name = (TextView) itemView.findViewById(R.id.name);
            username = (TextView) itemView.findViewById(R.id.username);
            time = (TextView) itemView.findViewById(R.id.time);
            comment = (TextView) itemView.findViewById(R.id.comment);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_twitter, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.username.setText(dataList.get(position).getUsername());
        holder.time.setText(dataList.get(position).getTime());
        holder.comment.setText(dataList.get(position).getComment());

        Glide.with(context)
                .load(dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imageProfile);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
