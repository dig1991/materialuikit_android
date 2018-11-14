package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style6;

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

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle6Adapter extends RecyclerView.Adapter<EcommerceStyle6Adapter.ItemViewHolder> {
    private static ArrayList<EcommerceStyle6Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private EcommerceStyle6ClickListener clicklistener = null;

    public EcommerceStyle6Adapter(Context ctx, ArrayList<EcommerceStyle6Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView title,price;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(EcommerceStyle6ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_ecommerce6, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.price.setText(dataList.get(position).getPrice());

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .thumbnail(0.01f)
                .fitCenter()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
