package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style7;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle7RecentAdapter extends RecyclerView.Adapter<GalleryStyle7RecentAdapter.ItemViewHolder> {
    private static ArrayList<GalleryStyle7RecentModel> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private GalleryStyle7ClickListener clicklistener = null;

    public GalleryStyle7RecentAdapter(Context ctx, ArrayList<GalleryStyle7RecentModel> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private LinearLayout lastItemCover;
        private RelativeLayout itemCheckIndicator;


        public ItemViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            lastItemCover = (LinearLayout) itemView.findViewById(R.id.lastItemCover);
            itemCheckIndicator = (RelativeLayout) itemView.findViewById(R.id.itemCheckIndicator);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_gallery7, parent, false);
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

        if ((position+1) == dataList.size()){
            holder.lastItemCover.setVisibility(View.VISIBLE);
        }else{
            holder.lastItemCover.setVisibility(View.GONE);
        }

        holder.itemCheckIndicator.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((position+1) < dataList.size()) {
                    if (holder.itemCheckIndicator.getVisibility() == View.VISIBLE) {
                        holder.itemCheckIndicator.setVisibility(View.GONE);
                        clicklistener.itemRecentUnSelect(view, dataList.get(position).getId());
                    } else {
                        holder.itemCheckIndicator.setVisibility(View.VISIBLE);
                        clicklistener.itemRecentSelect(view, dataList.get(position).getId());
                    }
                }else{
                    Toast.makeText(context, "More clicked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setClickListener(GalleryStyle7ClickListener listener) {
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
