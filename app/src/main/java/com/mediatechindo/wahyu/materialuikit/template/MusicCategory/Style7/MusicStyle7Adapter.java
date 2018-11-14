package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style7;

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
public class MusicStyle7Adapter extends RecyclerView.Adapter<MusicStyle7Adapter.ItemViewHolder> {
    private static ArrayList<MusicStyle7Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private MusicStyle7ClickListener clicklistener = null;

    public MusicStyle7Adapter(Context ctx, ArrayList<MusicStyle7Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView title1, title2, description;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            title1 = (TextView) itemView.findViewById(R.id.title1);
            title2 = (TextView) itemView.findViewById(R.id.title2);
            description = (TextView) itemView.findViewById(R.id.description);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(MusicStyle7ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_music7, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .transform(new ImageViewCircleTransform(context))
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);

        holder.title1.setText(dataList.get(position).getTitle().toUpperCase());
        holder.title2.setText(dataList.get(position).getTitle());
        holder.description.setText(dataList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
