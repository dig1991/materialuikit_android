package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style25;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle25Adapter extends RecyclerView.Adapter<ActivityStyle25Adapter.ItemViewHolder> {
    private static ArrayList<ActivityStyle25Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ActivityStyle25ClickListener clicklistener = null;

    public ActivityStyle25Adapter(Context ctx, ArrayList<ActivityStyle25Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgProfile;
        private ImageView check;
        private TextView textName;
        private TextView timed;
        private TextView description;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            check = (ImageView) itemView.findViewById(R.id.check);
            textName = (TextView) itemView.findViewById(R.id.textName);
            timed = (TextView) itemView.findViewById(R.id.timed);
            description = (TextView) itemView.findViewById(R.id.description);
        }

        @Override
        public void onClick(View v) {
            check.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_check_gray));
            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(ActivityStyle25ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity25, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.textName.setText(dataList.get(position).getName());
        holder.timed.setText(dataList.get(position).getTime());
        holder.description.setText(dataList.get(position).getDescription());

        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getProfileUrl())
                .transform(new ImageViewCircleTransform(context))
                .into(holder.imgProfile);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
