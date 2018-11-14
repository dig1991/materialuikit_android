package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style29;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle29Adapter extends RecyclerView.Adapter<EcommerceStyle29Adapter.ItemViewHolder> {
    private static ArrayList<EcommerceStyle29Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public EcommerceStyle29Adapter(Context ctx, ArrayList<EcommerceStyle29Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView name,review,time;

        public ItemViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            review = (TextView) itemView.findViewById(R.id.review);
            time = (TextView) itemView.findViewById(R.id.time);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ecommerce29, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.review.setText(dataList.get(position).getReview());
        holder.time.setText(dataList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
