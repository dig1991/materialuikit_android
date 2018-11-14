package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style11;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class MusicStyle11Adapter extends RecyclerView.Adapter<MusicStyle11Adapter.ItemViewHolder> {
    private static ArrayList<MusicStyle11Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public MusicStyle11Adapter(Context ctx, ArrayList<MusicStyle11Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView lyricText;

        public ItemViewHolder(View itemView) {
            super(itemView);
            lyricText = (TextView) itemView.findViewById(R.id.lyricText);
        }
    }

    public void updateTextLyrics(){
        notifyItemRangeChanged(0, dataList.size());
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_music11, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        switch (holder.getAdapterPosition()){
            case 0:
                holder.lyricText.setText(dataList.get(position).getTextLyric());
                holder.lyricText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                holder.lyricText.setTextColor(ContextCompat.getColor(context, android.R.color.transparent));
                break;
            case 1:
                holder.lyricText.setText(dataList.get(position).getTextLyric());
                holder.lyricText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
                holder.lyricText.setTextColor(ContextCompat.getColor(context, android.R.color.white));
                break;
            case 2:
                holder.lyricText.setText(dataList.get(position).getTextLyric());
                holder.lyricText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                holder.lyricText.setTextColor(ContextCompat.getColor(context, R.color.music11fontNextLyric));
                break;
            default:
                holder.lyricText.setText(dataList.get(position).getTextLyric());
                holder.lyricText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                holder.lyricText.setTextColor(ContextCompat.getColor(context, android.R.color.transparent));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
