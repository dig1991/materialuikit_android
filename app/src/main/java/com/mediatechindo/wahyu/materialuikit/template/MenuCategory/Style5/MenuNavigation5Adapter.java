package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style5;

import android.content.Context;
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

public class MenuNavigation5Adapter extends BaseAdapter{
    private Context context;
    private ArrayList<MenuNavigation5Model> menuData;
    private LayoutInflater mInflater;

    public MenuNavigation5Adapter(Context ctx, ArrayList<MenuNavigation5Model> data){
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
            convertView = mInflater.inflate(R.layout.row_menunavigation5, null);
            holder = new ViewHolder();

            holder.menuText = (TextView) convertView.findViewById(R.id.menuText);
            holder.menuNotificationCount = (TextView) convertView.findViewById(R.id.menuNotificationCount);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.menuText.setText(menuData.get(position).getMenuName());
        if(menuData.get(position).getMenuNotificationCount() > 0){
            holder.menuNotificationCount.setVisibility(View.VISIBLE);
            holder.menuNotificationCount.setText(Integer.toString(menuData.get(position).getMenuNotificationCount()));
        }else{
            holder.menuNotificationCount.setVisibility(View.GONE);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView menuText;
        TextView menuNotificationCount;
    }
}
