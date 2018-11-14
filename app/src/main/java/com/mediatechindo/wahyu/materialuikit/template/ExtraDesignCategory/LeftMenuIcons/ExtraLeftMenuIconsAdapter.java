package com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.LeftMenuIcons;

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

public class ExtraLeftMenuIconsAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<ExtraLeftMenuIconsModel> menuData;
    private LayoutInflater mInflater;

    public ExtraLeftMenuIconsAdapter(Context ctx, ArrayList<ExtraLeftMenuIconsModel> data){
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
            convertView = mInflater.inflate(R.layout.row_extra_leftmenu_icons, null);
            holder = new ViewHolder();

            holder.buttonMenu = (RelativeLayout) convertView.findViewById(R.id.buttonMenu);
            holder.iconImage = (ImageView) convertView.findViewById(R.id.iconImage);
            holder.menuText = (TextView) convertView.findViewById(R.id.menuText);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.iconImage.setImageResource(menuData.get(position).getIconImage());

        if(menuData.get(position).isSelected()) {
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, R.color.extraLeftMenu2menuActiveBg));
            holder.menuText.setText(menuData.get(position).getMenuName());
            holder.menuText.setTypeface(null, Typeface.BOLD);
            holder.menuText.setTextColor(ContextCompat.getColor(context, R.color.extraLeftMenu2menuFontActive));
        }else{
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
            holder.menuText.setText(menuData.get(position).getMenuName());
            holder.menuText.setTypeface(null, Typeface.NORMAL);
            holder.menuText.setTextColor(ContextCompat.getColor(context, R.color.extraLeftMenu2menuFont));
        }

        return convertView;
    }

    static class ViewHolder {
        RelativeLayout buttonMenu;
        TextView menuText;
        ImageView iconImage;
    }
}
