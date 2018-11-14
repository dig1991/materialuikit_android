package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 13/10/16.
 */

public class MenuNavigation7Adapter extends BaseExpandableListAdapter {
    private final Context _context;
    private final LayoutInflater mLayoutInflater;
    private String[] mGroups;
    private String[][] mChilds;

    public MenuNavigation7Adapter(Context context, String[] group, String[][] child) {
        this._context = context;
        mLayoutInflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mGroups = group;
        mChilds = child;
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
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.row_menunavigation7, parent, false);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.menuText);
        txtListChild.setText(mChilds[groupPosition][childPosition]);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChilds[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups[groupPosition];
    }

    @Override
    public int getGroupCount() {
        return mGroups.length;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.row_menunavigation7_header, parent, false);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.category_title);
        lblListHeader.setText(mGroups[groupPosition]);

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
