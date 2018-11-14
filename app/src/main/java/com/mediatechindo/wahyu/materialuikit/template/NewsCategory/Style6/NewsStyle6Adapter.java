package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style6;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class NewsStyle6Adapter extends RecyclerView.Adapter<NewsStyle6Adapter.ItemViewHolder> {
    private static ArrayList<NewsStyle6Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private NewsStyle6ClickListener clicklistener = null;

    public NewsStyle6Adapter(Context ctx, ArrayList<NewsStyle6Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageProfile, buttonBookmark, imageMain;
        private TextView name, time, category, title, description;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageProfile = (ImageView) itemView.findViewById(R.id.imageProfile);
            buttonBookmark = (ImageView) itemView.findViewById(R.id.buttonBookmark);
            imageMain = (ImageView) itemView.findViewById(R.id.imageMain);
            name = (TextView) itemView.findViewById(R.id.name);
            time = (TextView) itemView.findViewById(R.id.time);
            category = (TextView) itemView.findViewById(R.id.category);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }

    public void setClickListener(NewsStyle6ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news6, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.time.setText(dataList.get(position).getTime());
        holder.title.setText(dataList.get(position).getTitle());
        holder.category.setText(dataList.get(position).getCategory());

        switch (position){
            case 0:
                holder.category.setTextColor(ContextCompat.getColor(context, R.color.news6fontRamdom1));
                break;
            case 1:
                holder.category.setTextColor(ContextCompat.getColor(context, R.color.news6fontRamdom2));
                break;
            default:
                holder.category.setTextColor(ContextCompat.getColor(context, R.color.news6fontRamdom3));
                break;
        }

        holder.description.setText(dataList.get(position).getDescription());

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imageProfile);

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .centerCrop()
                .into(holder.imageMain);

        holder.buttonBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Button Bookmark clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
