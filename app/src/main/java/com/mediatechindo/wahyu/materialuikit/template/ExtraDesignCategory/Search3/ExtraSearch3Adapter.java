package com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.Search3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ExtraSearch3Adapter extends RecyclerView.Adapter<ExtraSearch3Adapter.ItemViewHolder> {
    private ArrayList<ExtraSearch3Model> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public ExtraSearch3Adapter(Context ctx, ArrayList<ExtraSearch3Model> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageIcon;
        private TextView title;
        private CheckBox checkbox;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageIcon = (ImageView) itemView.findViewById(R.id.imageIcon);
            title = (TextView) itemView.findViewById(R.id.title);
            checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_extra_search3, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.title.setText(dataList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, dataList.get(position).getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
