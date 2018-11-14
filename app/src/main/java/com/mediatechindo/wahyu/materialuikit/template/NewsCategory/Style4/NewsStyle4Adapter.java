package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style4;

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
public class NewsStyle4Adapter extends RecyclerView.Adapter<NewsStyle4Adapter.ItemViewHolder> {
    private static ArrayList<NewsStyle4Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private NewsStyle4ClickListener clicklistener = null;

    public NewsStyle4Adapter(Context ctx, ArrayList<NewsStyle4Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView title, author, time;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
            time = (TextView) itemView.findViewById(R.id.time);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(NewsStyle4ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news4, parent, false);
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
                .into(holder.imageView);

        holder.title.setText(dataList.get(position).getTitle());
        holder.author.setText(dataList.get(position).getAuthor());
        holder.time.setText(dataList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
