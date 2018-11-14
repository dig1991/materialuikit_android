package com.mediatechindo.wahyu.materialuikit;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wahyu on 13/10/16.
 */

public class MainMenuAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<MainMenuModel> menuData;
    private LayoutInflater mInflater;

    public MainMenuAdapter(Context ctx, ArrayList<MainMenuModel> data){
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
            convertView = mInflater.inflate(R.layout.row_mainmenu, null);
            holder = new ViewHolder();

            holder.buttonMenu = (RelativeLayout) convertView.findViewById(R.id.buttonMenu);
            holder.menuText = (TextView) convertView.findViewById(R.id.menuText);
            holder.menuNotificationCount = (TextView) convertView.findViewById(R.id.menuNotificationCount);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.menuText.setText(menuData.get(position).getMenuName());
        holder.menuNotificationCount.setText(Integer.toString(menuData.get(position).getMenuNotificationCount()));

        if(menuData.get(position).isSelected()) {
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, R.color.main_menu_bg_active));
            holder.menuNotificationCount.setTextColor(ContextCompat.getColor(context, R.color.main_menu_count_active));

        }else{
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, R.color.main_menu_bg));
            holder.menuNotificationCount.setTextColor(ContextCompat.getColor(context, R.color.main_menu_count_nonactive));
        }


        return convertView;
    }

    static class ViewHolder {
        TextView menuText;
        TextView menuNotificationCount;
        RelativeLayout buttonMenu;
    }
}
