package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style20;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

/**
 * Created by wahyu on 13/10/16.
 */

public class MenuNavigation20Adapter extends BaseAdapter{
    private Context context;
    private ArrayList<MenuNavigation20Model> menuData;
    private LayoutInflater mInflater;

    public MenuNavigation20Adapter(Context ctx, ArrayList<MenuNavigation20Model> data){
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
            convertView = mInflater.inflate(R.layout.row_menunavigation20, null);
            holder = new ViewHolder();

            holder.buttonMenu = (RelativeLayout) convertView.findViewById(R.id.buttonMenu);
            holder.iconImage = (ImageView) convertView.findViewById(R.id.iconImage);
            holder.menuText = (TextView) convertView.findViewById(R.id.menuText);
            holder.menuNotificationCount = (TextView) convertView.findViewById(R.id.menuNotificationCount);
            holder.menuNotificationNonActiveCount = (TextView) convertView.findViewById(R.id.menuNotificationNonActiveCount);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.iconImage.setImageResource(menuData.get(position).getIconImage());

        if(menuData.get(position).getMenuNotificationNonActiveCount() > 0){
            holder.menuNotificationNonActiveCount.setVisibility(View.VISIBLE);
            holder.menuNotificationNonActiveCount.setText(Integer.toString(menuData.get(position).getMenuNotificationNonActiveCount()));
        }else{
            holder.menuNotificationNonActiveCount.setVisibility(View.GONE);
        }

        if(menuData.get(position).getMenuNotificationCount() > 0){
            holder.menuNotificationCount.setVisibility(View.VISIBLE);
            holder.menuNotificationCount.setText(Integer.toString(menuData.get(position).getMenuNotificationCount()));
        }else{
            holder.menuNotificationCount.setVisibility(View.GONE);
        }

        if(menuData.get(position).isSelected()) {
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, R.color.menuNavigation13menuSelectedBg));
            holder.menuText.setText(menuData.get(position).getMenuName());
            holder.menuText.setTypeface(null, Typeface.BOLD);
        }else{
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
            holder.menuText.setText(menuData.get(position).getMenuName());
            holder.menuText.setTypeface(null, Typeface.NORMAL);
        }

        return convertView;
    }

    static class ViewHolder {
        RelativeLayout buttonMenu;
        TextView menuText;
        TextView menuNotificationCount;
        TextView menuNotificationNonActiveCount;
        ImageView iconImage;
    }
}
