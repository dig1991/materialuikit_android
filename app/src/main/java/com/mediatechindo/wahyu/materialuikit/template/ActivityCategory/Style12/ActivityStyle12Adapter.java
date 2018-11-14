package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style12;

import android.content.Context;
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
public class ActivityStyle12Adapter extends RecyclerView.Adapter<ActivityStyle12Adapter.ItemViewHolder> {
    private static ArrayList<ActivityStyle12Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public ActivityStyle12Adapter(Context ctx, ArrayList<ActivityStyle12Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgProfile;
        private TextView textName;
        private TextView textComment;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textComment = (TextView) itemView.findViewById(R.id.textComment);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity12, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.textName.setText(dataList.get(position).getName());
        holder.textComment.setText(dataList.get(position).getComment());

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
