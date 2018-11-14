package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style5;

import android.content.Context;
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
public class NewsStyle5Adapter extends RecyclerView.Adapter<NewsStyle5Adapter.ItemViewHolder> {
    private static ArrayList<NewsStyle5Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public NewsStyle5Adapter(Context ctx, ArrayList<NewsStyle5Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageProfile, buttonMore, imageMain;
        private TextView name, time, title, description;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageProfile = (ImageView) itemView.findViewById(R.id.imageProfile);
            buttonMore = (ImageView) itemView.findViewById(R.id.buttonMore);
            imageMain = (ImageView) itemView.findViewById(R.id.imageMain);
            name = (TextView) itemView.findViewById(R.id.name);
            time = (TextView) itemView.findViewById(R.id.time);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news5, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.time.setText(dataList.get(position).getTime());
        holder.title.setText(dataList.get(position).getTitle());
        holder.description.setText(dataList.get(position).getDescription());

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imageProfile);

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .centerCrop()
                .into(holder.imageMain);

        holder.buttonMore.setOnClickListener(new View.OnClickListener() {
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
