package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style21;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ProfileStyle21Adapter extends RecyclerView.Adapter<ProfileStyle21Adapter.ItemViewHolder> {
    private static String[] dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ProfileStyle21ClickListener clicklistener = null;

    public ProfileStyle21Adapter(Context ctx, String[] data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView menuText;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            menuText = (TextView) itemView.findViewById(R.id.menuText);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(ProfileStyle21ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_profile21, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.menuText.setText(dataList[position]);
    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }
}
