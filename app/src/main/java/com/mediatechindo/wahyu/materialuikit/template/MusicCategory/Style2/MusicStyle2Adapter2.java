package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style2;

import android.content.Context;
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
public class MusicStyle2Adapter2 extends RecyclerView.Adapter<MusicStyle2Adapter2.ItemViewHolder> {
    private static ArrayList<MusicStyle2Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private MusicStyle2ClickListener clicklistener = null;

    public MusicStyle2Adapter2(Context ctx, ArrayList<MusicStyle2Model> data) {
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
                clicklistener.itemClicked2(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(MusicStyle2ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_music2, parent, false);
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
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
