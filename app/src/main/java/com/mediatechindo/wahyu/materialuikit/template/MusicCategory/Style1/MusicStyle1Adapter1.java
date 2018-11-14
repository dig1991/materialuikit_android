package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style1;

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
public class MusicStyle1Adapter1 extends RecyclerView.Adapter<MusicStyle1Adapter1.ItemViewHolder> {
    private static ArrayList<MusicStyle1Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private MusicStyle1ClickListener clicklistener = null;

    public MusicStyle1Adapter1(Context ctx, ArrayList<MusicStyle1Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView genre;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            genre = (TextView) itemView.findViewById(R.id.numItem);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked1(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(MusicStyle1ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_music1, parent, false);
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

        holder.genre.setText(dataList.get(position).getGenre());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
