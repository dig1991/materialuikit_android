package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style27;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle27Adapter extends RecyclerView.Adapter<ActivityStyle27Adapter.ItemViewHolder> {
    private static ArrayList<ActivityStyle27Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public ActivityStyle27Adapter(Context ctx, ArrayList<ActivityStyle27Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout receiveLayout;
        private RelativeLayout sendLayout;
        private RelativeLayout receiveImage;
        private TextView receiveMessage;
        private TextView receiveTime;
        private TextView sendMessage;
        private TextView sendTime;

        public ItemViewHolder(View itemView) {
            super(itemView);

            receiveLayout = (RelativeLayout) itemView.findViewById(R.id.receiveLayout);
            sendLayout = (RelativeLayout) itemView.findViewById(R.id.sendLayout);
            receiveImage = (RelativeLayout) itemView.findViewById(R.id.receiveImage);
            receiveMessage = (TextView) itemView.findViewById(R.id.receiveMessage);
            receiveTime = (TextView) itemView.findViewById(R.id.receiveTime);
            sendMessage = (TextView) itemView.findViewById(R.id.sendMessage);
            sendTime = (TextView) itemView.findViewById(R.id.sendTime);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity27, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        if(dataList.get(position).isImage()) {
            holder.receiveImage.setVisibility(View.VISIBLE);
            holder.sendLayout.setVisibility(View.GONE);
            holder.receiveLayout.setVisibility(View.GONE);
        }else if(dataList.get(position).isSend()) {
            holder.receiveImage.setVisibility(View.GONE);
            holder.sendLayout.setVisibility(View.VISIBLE);
            holder.receiveLayout.setVisibility(View.GONE);
            holder.sendMessage.setText(dataList.get(position).getMessage());
            holder.sendTime.setText(dataList.get(position).getTime());
        }else{
            holder.receiveImage.setVisibility(View.GONE);
            holder.sendLayout.setVisibility(View.GONE);
            holder.receiveLayout.setVisibility(View.VISIBLE);
            holder.receiveMessage.setText(dataList.get(position).getMessage());
            holder.receiveTime.setText(dataList.get(position).getTime());
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
