package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.ItemViewHolder> {
    private static ArrayList<YoutubeModel> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private YoutubeClickListener clicklistener = null;

    public YoutubeAdapter(Context ctx, ArrayList<YoutubeModel> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageMain;
        private TextView time, title, source;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageMain = (ImageView) itemView.findViewById(R.id.imageMain);
            source = (TextView) itemView.findViewById(R.id.source);
            time = (TextView) itemView.findViewById(R.id.time);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public void setClickListener(YoutubeClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_youtube, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.time.setText(dataList.get(position).getTime());
        holder.title.setText(dataList.get(position).getTitle());
        holder.source.setText(dataList.get(position).getSource());
        Glide.with(context)
                .load(dataList.get(position).getImageUrl())
                .centerCrop()
                .into(holder.imageMain);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
