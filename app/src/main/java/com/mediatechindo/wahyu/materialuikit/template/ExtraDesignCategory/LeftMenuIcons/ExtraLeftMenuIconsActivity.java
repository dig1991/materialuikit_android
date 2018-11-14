package com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.LeftMenuIcons;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class ExtraLeftMenuIconsActivity extends AppCompatActivity implements View.OnClickListener{
    ListView menuList;
    ArrayList<ExtraLeftMenuIconsModel> menuData;
    ExtraLeftMenuIconsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra_leftmenu_icons_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final String[] menus = {"Explore", "Messages", "Photos", "Videos", "Group", "Setting"};
        final int[] icon = {
                R.drawable.ic_explore_gray,
                R.drawable.ic_messages_gray,
                R.drawable.ic_photos_gray,
                R.drawable.ic_videos_gray,
                R.drawable.ic_group_gray,
                R.drawable.ic_setting_gray};
        menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            ExtraLeftMenuIconsModel menu = new ExtraLeftMenuIconsModel();
            menu.setMenuName(menus[i]);
            menu.setIconImage(icon[i]);
            menuData.add(menu);
        }

        menuList = (ListView) findViewById(R.id.menuList);
        adapter = new ExtraLeftMenuIconsAdapter(this, menuData);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ExtraLeftMenuIconsActivity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    ExtraLeftMenuIconsModel menu = new ExtraLeftMenuIconsModel();
                    menu.setMenuName(menus[j]);
                    menu.setIconImage(icon[j]);
                    if(i == j) {
                        menu.setSelected(true);
                    }

                    menuData.add(menu);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLoginSignupBack:
                onBackPressed();
                break;
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }
}
