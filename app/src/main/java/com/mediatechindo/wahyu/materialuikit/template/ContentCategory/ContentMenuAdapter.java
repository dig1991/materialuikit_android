package com.mediatechindo.wahyu.materialuikit.template.ContentCategory;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 29/07/16.
 */
public class ContentMenuAdapter extends RecyclerView.Adapter<ContentMenuAdapter.ViewHolder>{
    Activity activity;
    String[] datas;

    public ContentMenuAdapter(Activity act, String[] dt){
        this.activity = act;
        this.datas = dt;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_menu_category, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.buttonCategory.setText(datas[position]);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private Button buttonCategory;
        public ViewHolder(View itemView) {
            super(itemView);
            buttonCategory = (Button) itemView.findViewById(R.id.buttonCategory);
        }
    }
}
