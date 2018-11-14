package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style17;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 13/10/16.
 */

public class MenuNavigation17Adapter extends BaseAdapter{
    private Context context;
    private ArrayList<MenuNavigation17Model> menuData;
    private LayoutInflater mInflater;

    public MenuNavigation17Adapter(Context ctx, ArrayList<MenuNavigation17Model> data){
        context = ctx;
        mInflater = LayoutInflater.from(context);
        menuData = data;
    }

    @Override
    public int getCount() {
        return menuData.size();
    }

    @Override
    public Object getItem(int position) {
        return menuData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.grid_menunavigation17, null);
            holder = new ViewHolder();

            holder.buttonContainer = (CardView) convertView.findViewById(R.id.buttonContainer);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.name = (TextView) convertView.findViewById(R.id.name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.icon.setImageResource(menuData.get(position).getMenuIcon());
        holder.name.setText(menuData.get(position).getMenuName());

        if(menuData.get(position).isSelected()) {
            holder.buttonContainer.setCardBackgroundColor(ContextCompat.getColor(context, R.color.menuNavigation17menuSelected));
            holder.name.setTypeface(null, Typeface.BOLD);
        }else{
            holder.buttonContainer.setCardBackgroundColor(ContextCompat.getColor(context, R.color.menuNavigation17menu));
            holder.name.setTypeface(null, Typeface.NORMAL);
        }

        return convertView;
    }

    static class ViewHolder {
        CardView buttonContainer;
        ImageView icon;
        TextView name;
    }
}
