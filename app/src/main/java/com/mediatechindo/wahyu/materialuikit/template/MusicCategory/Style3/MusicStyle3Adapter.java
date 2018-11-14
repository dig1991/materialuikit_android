package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style3;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class MusicStyle3Adapter extends RecyclerView.Adapter<MusicStyle3Adapter.ItemViewHolder> {
    private static ArrayList<MusicStyle3Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private MusicStyle3ClickListener clicklistener = null;
    private int lastSelectedPosition = -1;

    public MusicStyle3Adapter(Context ctx, ArrayList<MusicStyle3Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView numItem, title, duration;
        private ImageButton btnMore;

        public ItemViewHolder(View itemView) {
            super(itemView);

            numItem = (TextView) itemView.findViewById(R.id.numItem);
            title = (TextView) itemView.findViewById(R.id.title);
            duration = (TextView) itemView.findViewById(R.id.duration);
            btnMore = (ImageButton) itemView.findViewById(R.id.btnMore);
        }
    }

    public void setClickListener(MusicStyle3ClickListener listener) {
        this.clicklistener = listener;
    }

    public int getSelectedPosition(){
        return lastSelectedPosition;
    }

    public void setSelectedPosition(int position){
        lastSelectedPosition = position;
        notifyItemRangeChanged(0, dataList.size());
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_music3, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        int pos = position + 1;
        holder.numItem.setText(pos + "");

        holder.title.setText(dataList.get(position).getTitle());
        holder.duration.setText(dataList.get(position).getDuration());
        if(position ==  lastSelectedPosition){
            holder.title.setTextColor(ContextCompat.getColor(context, R.color.music3fontPlaying));
            holder.duration.setTextColor(ContextCompat.getColor(context, R.color.music3fontPlaying));
        }else{
            holder.title.setTextColor(ContextCompat.getColor(context, android.R.color.black));
            holder.duration.setTextColor(ContextCompat.getColor(context, R.color.music3fontGray));
        }

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Button more clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastSelectedPosition = holder.getAdapterPosition();
                notifyItemRangeChanged(0, dataList.size());
                clicklistener.itemClicked(holder, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
