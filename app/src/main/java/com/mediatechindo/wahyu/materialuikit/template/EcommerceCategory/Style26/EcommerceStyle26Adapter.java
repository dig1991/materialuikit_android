package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style26;

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
public class EcommerceStyle26Adapter extends RecyclerView.Adapter<EcommerceStyle26Adapter.ItemViewHolder> {
    private static ArrayList<EcommerceStyle26Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public EcommerceStyle26Adapter(Context ctx, ArrayList<EcommerceStyle26Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProduct;
        private TextView title,numItem,price;

        public ItemViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            numItem = (TextView) itemView.findViewById(R.id.numItem);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ecommerce26, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageProductUrl())
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.imgProduct);

        holder.title.setText(dataList.get(position).getName());
        holder.price.setText(dataList.get(position).getPrice());
        holder.numItem.setText("Quantity : " + dataList.get(position).getQty());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
