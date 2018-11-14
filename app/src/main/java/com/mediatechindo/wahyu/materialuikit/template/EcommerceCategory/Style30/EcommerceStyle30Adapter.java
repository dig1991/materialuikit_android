package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style30;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle30Adapter extends RecyclerView.Adapter<EcommerceStyle30Adapter.ItemViewHolder> {
    private static ArrayList<EcommerceStyle30Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public EcommerceStyle30Adapter(Context ctx, ArrayList<EcommerceStyle30Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;
        private Button buttonShopNow;

        public ItemViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.imageMain);
            buttonShopNow = (Button) itemView.findViewById(R.id.buttonShopNow);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ecommerce30, parent, false);
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
        holder.title.setText(dataList.get(position).getCategoryTitle());
        holder.buttonShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Button Shop Now clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
