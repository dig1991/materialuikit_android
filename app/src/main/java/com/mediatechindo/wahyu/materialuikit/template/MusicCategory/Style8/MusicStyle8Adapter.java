package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style8;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class MusicStyle8Adapter extends RecyclerView.Adapter<MusicStyle8Adapter.ItemViewHolder> {
    private static ArrayList<MusicStyle8Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private MusicStyle8ClickListener clicklistener = null;

    public MusicStyle8Adapter(Context ctx, ArrayList<MusicStyle8Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, songCount;
        private ImageButton btnMore;
        private ImageView playlistArt;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            title = (TextView) itemView.findViewById(R.id.title);
            songCount = (TextView) itemView.findViewById(R.id.songCount);
            btnMore = (ImageButton) itemView.findViewById(R.id.btnMore);
            playlistArt = (ImageView) itemView.findViewById(R.id.playlistArt);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(MusicStyle8ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_music8, parent, false);
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
                .into(holder.playlistArt);

        holder.title.setText(dataList.get(position).getTitle());
        holder.songCount.setText(dataList.get(position).getSongCount());
        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Button more clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
