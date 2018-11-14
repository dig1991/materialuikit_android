package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style19;

import android.content.Context;
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

public class MenuNavigation19Adapter extends BaseAdapter{
    private Context context;
    private ArrayList<MenuNavigation19Model> menuData;
    private LayoutInflater mInflater;

    public MenuNavigation19Adapter(Context ctx, ArrayList<MenuNavigation19Model> data){
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
            convertView = mInflater.inflate(R.layout.row_menunavigation19, null);
            holder = new ViewHolder();

            holder.menuText = (TextView) convertView.findViewById(R.id.menuText);
            holder.buttonMenu = (RelativeLayout) convertView.findViewById(R.id.buttonMenu);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.menuText.setText(menuData.get(position).getMenuName());

        return convertView;
    }

    static class ViewHolder {
        TextView menuText;
        RelativeLayout buttonMenu;
    }
}
