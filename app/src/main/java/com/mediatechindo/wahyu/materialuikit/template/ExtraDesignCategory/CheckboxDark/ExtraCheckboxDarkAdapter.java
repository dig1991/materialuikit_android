package com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.CheckboxDark;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ExtraCheckboxDarkAdapter extends RecyclerView.Adapter<ExtraCheckboxDarkAdapter.ItemViewHolder> {
    private ArrayList<ExtraCheckboxDarkModel> dataList;
    private LayoutInflater mInflater;
    private Context context;

    public ExtraCheckboxDarkAdapter(Context ctx, ArrayList<ExtraCheckboxDarkModel> data) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_extra_checkbox_dark, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.imageIcon.setImageDrawable(ContextCompat.getDrawable(context, dataList.get(position).getImageIcon()));
        holder.checkbox.setChecked(false);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.checkbox.setChecked(!holder.checkbox.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
