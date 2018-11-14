package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style8;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 13/10/16.
 */

public class MenuNavigation8Adapter extends BaseAdapter{
    private Context context;
    private ArrayList<MenuNavigation8Model> menuData;
    private LayoutInflater mInflater;

    public MenuNavigation8Adapter(Context ctx, ArrayList<MenuNavigation8Model> data){
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
            convertView = mInflater.inflate(R.layout.row_menunavigation8, null);
            holder = new ViewHolder();

            holder.menuText = (TextView) convertView.findViewById(R.id.menuText);
            holder.menuNotificationCount = (TextView) convertView.findViewById(R.id.menuNotificationCount);
            holder.menuNotificationNonActiveCount = (TextView) convertView.findViewById(R.id.menuNotificationNonActiveCount);
            holder.barNotificationActive = convertView.findViewById(R.id.barNotificationActive);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        if(menuData.get(position).getMenuNotificationCount() > 0){
            holder.menuNotificationNonActiveCount.setVisibility(View.VISIBLE);
            holder.menuNotificationNonActiveCount.setText(Integer.toString(menuData.get(position).getMenuNotificationCount()));
        }else{
            holder.menuNotificationNonActiveCount.setVisibility(View.GONE);
        }
        holder.menuNotificationCount.setVisibility(View.GONE);

        if(menuData.get(position).isSelected()) {
            holder.barNotificationActive.setVisibility(View.VISIBLE);
            holder.menuText.setText(menuData.get(position).getMenuName());
            holder.menuText.setTextColor(ContextCompat.getColor(context, R.color.menuNavigation8menuFontActive));
            holder.menuText.setTypeface(null, Typeface.BOLD);

            if(menuData.get(position).getMenuNotificationCount() > 0){
                holder.menuNotificationNonActiveCount.setVisibility(View.GONE);
                holder.menuNotificationCount.setVisibility(View.VISIBLE);
                holder.menuNotificationCount.setText(Integer.toString(menuData.get(position).getMenuNotificationCount()));
            }else{
                holder.menuNotificationCount.setVisibility(View.GONE);
            }

        }else{
            holder.barNotificationActive.setVisibility(View.GONE);
            holder.menuText.setText(menuData.get(position).getMenuName());
            holder.menuText.setTextColor(ContextCompat.getColor(context, R.color.menuNavigation8menuFont));
            holder.menuText.setTypeface(null, Typeface.NORMAL);
        }


        return convertView;
    }

    static class ViewHolder {
        TextView menuText;
        TextView menuNotificationCount;
        TextView menuNotificationNonActiveCount;
        View barNotificationActive;
    }
}
