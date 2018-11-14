package com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.LeftMenuLight;

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

import static com.mediatechindo.wahyu.materialuikit.R.id.buttonMenu;

/**
 * Created by wahyu on 13/10/16.
 */

public class ExtraLeftMenuLightAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<ExtraLeftMenuLightModel> menuData;
    private LayoutInflater mInflater;

    public ExtraLeftMenuLightAdapter(Context ctx, ArrayList<ExtraLeftMenuLightModel> data){
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
            convertView = mInflater.inflate(R.layout.row_extra_leftmenu_light, null);
            holder = new ViewHolder();

            holder.buttonMenu = (RelativeLayout) convertView.findViewById(buttonMenu);
            holder.menuText = (TextView) convertView.findViewById(R.id.menuText);
            holder.barNotificationActive = convertView.findViewById(R.id.barNotificationActive);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        if(menuData.get(position).isSelected()) {
            holder.barNotificationActive.setVisibility(View.VISIBLE);
            holder.menuText.setText(menuData.get(position).getMenuName());
            holder.menuText.setTextColor(ContextCompat.getColor(context, R.color.extraLeftMenu1menuFontActive));
            holder.menuText.setTypeface(null, Typeface.BOLD);
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, R.color.extraLeftMenu1menuActiveBg));

        }else{
            holder.barNotificationActive.setVisibility(View.INVISIBLE);
            holder.menuText.setText(menuData.get(position).getMenuName());
            holder.menuText.setTextColor(ContextCompat.getColor(context, R.color.extraLeftMenu1menuFont));
            holder.menuText.setTypeface(null, Typeface.NORMAL);
            holder.buttonMenu.setBackgroundColor(ContextCompat.getColor(context, R.color.extraLeftMenu1menuBg));
        }


        return convertView;
    }

    static class ViewHolder {
        RelativeLayout buttonMenu;
        TextView menuText;
        View barNotificationActive;
    }
}
