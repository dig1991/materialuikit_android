package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
public class MusicStyle6Adapter extends RecyclerView.Adapter<MusicStyle6Adapter.ItemViewHolder> {
    private static ArrayList<MusicStyle6Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private MusicStyle6ClickListener clicklistener = null;

    public MusicStyle6Adapter(Context ctx, ArrayList<MusicStyle6Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView artist, albumCount;
        private ImageButton btnMore;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            artist = (TextView) itemView.findViewById(R.id.artist);
            albumCount = (TextView) itemView.findViewById(R.id.albumCount);
            btnMore = (ImageButton) itemView.findViewById(R.id.btnMore);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(MusicStyle6ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_music6, parent, false);
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

        holder.artist.setText(dataList.get(position).getArtist());
        holder.albumCount.setText(dataList.get(position).getSongCount());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
