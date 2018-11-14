package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style20;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle20Adapter extends RecyclerView.Adapter<EcommerceStyle20Adapter.ItemViewHolder> {
    private static ArrayList<EcommerceStyle20Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private EcommerceStyle20ClickListener clicklistener = null;

    public EcommerceStyle20Adapter(Context ctx, ArrayList<EcommerceStyle20Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View colorItem;
        private RelativeLayout selectedIndicator;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            colorItem = itemView.findViewById(R.id.colorItem);
            selectedIndicator = (RelativeLayout) itemView.findViewById(R.id.selectedIndicator);
        }

        @Override
        public void onClick(View v) {
            if(selectedIndicator.getVisibility() == View.GONE) {
                selectedIndicator.setVisibility(View.VISIBLE);
            }else{
                selectedIndicator.setVisibility(View.GONE);
            }

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(EcommerceStyle20ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ecommerce20, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.colorItem.setBackground(ContextCompat.getDrawable(context, dataList.get(position).getColorId()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
