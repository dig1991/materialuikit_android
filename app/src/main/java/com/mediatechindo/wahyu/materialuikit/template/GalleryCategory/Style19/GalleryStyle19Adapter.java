package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style19;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle19Adapter extends RecyclerView.Adapter<GalleryStyle19Adapter.ItemViewHolder> {
    private static ArrayList<GalleryStyle19Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private GalleryStyle19ClickListener clicklistener = null;

    public GalleryStyle19Adapter(Context ctx, ArrayList<GalleryStyle19Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private RelativeLayout itemCheckIndicator;


        public ItemViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            itemCheckIndicator = (RelativeLayout) itemView.findViewById(R.id.itemCheckIndicator);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_gallery19, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);

        holder.itemCheckIndicator.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.itemCheckIndicator.getVisibility() == View.VISIBLE) {
                    holder.itemCheckIndicator.setVisibility(View.GONE);
                    clicklistener.itemUnSelect(view, dataList.get(position).getId());
                } else {
                    holder.itemCheckIndicator.setVisibility(View.VISIBLE);
                    clicklistener.itemSelect(view, dataList.get(position).getId());
                }
            }
        });
    }

    public void setClickListener(GalleryStyle19ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void deleteItem(int id) {
        for (int i=0; i<dataList.size(); i++) {
            if(dataList.get(i).getId() == id) {
                dataList.remove(i);
                notifyItemRemoved(i);
                notifyItemRangeChanged(i, dataList.size());
            }
        }
    }
}
