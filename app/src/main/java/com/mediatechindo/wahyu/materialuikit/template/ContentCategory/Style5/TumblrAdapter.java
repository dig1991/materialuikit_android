package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class TumblrAdapter extends RecyclerView.Adapter<TumblrAdapter.ItemViewHolder> {
    private static ArrayList<TumblrModel> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public TumblrAdapter(Context ctx, ArrayList<TumblrModel> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageMain;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageMain = (ImageView) itemView.findViewById(R.id.imageMain);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tumblr, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        Glide.with(context)
                .load(dataList.get(position).getImageUrl())
                .fitCenter()
                .into(holder.imageMain);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
