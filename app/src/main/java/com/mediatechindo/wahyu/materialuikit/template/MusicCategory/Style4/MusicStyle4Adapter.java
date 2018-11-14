package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style4;

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
public class MusicStyle4Adapter extends RecyclerView.Adapter<MusicStyle4Adapter.ItemViewHolder> {
    private static ArrayList<MusicStyle4Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private MusicStyle4ClickListener clicklistener = null;

    public MusicStyle4Adapter(Context ctx, ArrayList<MusicStyle4Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView numItem, title, duration;
        private ImageButton btnMore;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            numItem = (TextView) itemView.findViewById(R.id.numItem);
            title = (TextView) itemView.findViewById(R.id.title);
            duration = (TextView) itemView.findViewById(R.id.duration);
            btnMore = (ImageButton) itemView.findViewById(R.id.btnMore);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(MusicStyle4ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_music4, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        int pos = position + 1;
        holder.numItem.setText(pos + "");
        holder.title.setText(dataList.get(position).getTitle());
        holder.duration.setText(dataList.get(position).getDuration());
        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Button more clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        if (position == 2){
            holder.title.setTextColor(ContextCompat.getColor(context, R.color.music3fontPlaying));
            holder.duration.setTextColor(ContextCompat.getColor(context, R.color.music3fontPlaying));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
