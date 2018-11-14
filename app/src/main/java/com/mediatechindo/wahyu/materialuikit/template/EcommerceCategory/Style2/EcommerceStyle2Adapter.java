package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style2;

import android.content.Context;
import android.support.v7.widget.CardView;
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
public class EcommerceStyle2Adapter extends RecyclerView.Adapter<EcommerceStyle2Adapter.ItemViewHolder> {
    private static ArrayList<EcommerceStyle2Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private EcommerceStyle2ClickListener clicklistener = null;

    public EcommerceStyle2Adapter(Context ctx, ArrayList<EcommerceStyle2Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image1,image2;
        private TextView title1,itemCount1,title2,itemCount2;
        private CardView leftLayout, rightLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            leftLayout = (CardView) itemView.findViewById(R.id.leftLayout);
            rightLayout = (CardView) itemView.findViewById(R.id.rightLayout);
            image1 = (ImageView) itemView.findViewById(R.id.image1);
            title1 = (TextView) itemView.findViewById(R.id.title1);
            itemCount1 = (TextView) itemView.findViewById(R.id.itemCount1);
            image2 = (ImageView) itemView.findViewById(R.id.image2);
            title2 = (TextView) itemView.findViewById(R.id.title2);
            itemCount2 = (TextView) itemView.findViewById(R.id.itemCount2);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(EcommerceStyle2ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ecommerce2, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        int num = position + 1;
        holder.leftLayout.setVisibility(View.GONE);
        holder.rightLayout.setVisibility(View.GONE);
        if(num % 2 != 0) {
            holder.leftLayout.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                    .thumbnail(0.01f)
                    .centerCrop()
                    .into(holder.image1);
            holder.title1.setText(dataList.get(position).getTitle());
            holder.itemCount1.setText(dataList.get(position).getPictureCount() + " Items");
        }else{
            holder.rightLayout.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                    .thumbnail(0.01f)
                    .centerCrop()
                    .into(holder.image2);
            holder.title2.setText(dataList.get(position).getTitle());
            holder.itemCount2.setText(dataList.get(position).getPictureCount() + " Items");
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
