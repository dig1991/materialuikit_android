package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style12;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 13/10/16.
 */

public class MenuNavigation12Adapter extends BaseAdapter{
    private Context context;
    private ArrayList<MenuNavigation12Model> menuData;
    private LayoutInflater mInflater;

    public MenuNavigation12Adapter(Context ctx, ArrayList<MenuNavigation12Model> data){
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
            convertView = mInflater.inflate(R.layout.row_menunavigation12, null);
            holder = new ViewHolder();

            holder.menuText = (TextView) convertView.findViewById(R.id.menuText);
            holder.menuNotificationCount = (TextView) convertView.findViewById(R.id.menuNotificationCount);
            holder.buttonMenu = (RelativeLayout) convertView.findViewById(R.id.buttonMenu);

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

        if(menuData.get(position).isSelected()) {
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, R.color.menuNavigation12menuSelected));
            holder.menuText.setTypeface(null, Typeface.BOLD);
        }else{
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
            holder.menuText.setTypeface(null, Typeface.NORMAL);
        }


        return convertView;
    }

    static class ViewHolder {
        TextView menuText;
        TextView menuNotificationCount;
        RelativeLayout buttonMenu;
    }
}
