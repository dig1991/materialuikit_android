package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 18/11/2015.
 */
public class MenuNavigation6Adapter extends BaseExpandableListAdapter {

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private String[] mGroups;
    private String[][] mChilds;

    public MenuNavigation6Adapter(Context context, String[] group, String[][] child) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mGroups = group;
        mChilds = child;
    }

    @Override
    public int getGroupCount() {
        return mGroups.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups[groupPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.row_menunavigation6_header, parent, false);
        }

        TextView category_title = (TextView) convertView.findViewById(R.id.category_title);
        category_title.setText(mGroups[groupPosition]);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChilds[groupPosition].length;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChilds[groupPosition][childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.row_menunavigation6, parent, false);
        }
        TextView menuText = (TextView) convertView.findViewById(R.id.menuText);
        menuText.setText(mChilds[groupPosition][childPosition]);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
