package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style17;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class MenuNavigation17Activity extends AppCompatActivity{
    GridView gridView;
    ArrayList<MenuNavigation17Model> menuData;
    MenuNavigation17Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation17_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Menu");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MenuNavigation17Activity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationViewLeft = (NavigationView) findViewById(R.id.nav_view);

        int width = getResources().getDisplayMetrics().widthPixels;
        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) navigationViewLeft.getLayoutParams();
        params.width = width;
        navigationViewLeft.setLayoutParams(params);

        final String[] menus = {"Dashboard", "Explore", "Photo", "Video", "Friends", "Messages", "Profile", "Setting"};
        final int[] icon = {
                R.drawable.ic_dashboard_black,
                R.drawable.ic_explore_black,
                R.drawable.ic_photo_black,
                R.drawable.ic_video_black,
                R.drawable.ic_group_black,
                R.drawable.ic_messages_black,
                R.drawable.ic_profile_black,
                R.drawable.ic_setting_black};
        final int[] iconSelected = {
                R.drawable.ic_dashboard,
                R.drawable.ic_explore,
                R.drawable.ic_photos,
                R.drawable.ic_videos,
                R.drawable.ic_group,
                R.drawable.ic_messages,
                R.drawable.ic_profile,
                R.drawable.ic_setting};
        menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            MenuNavigation17Model menu = new MenuNavigation17Model();
            menu.setMenuName(menus[i]);
            menu.setMenuIcon(icon[i]);
            menuData.add(menu);
        }

        gridView = (GridView) findViewById(R.id.gridview);
        adapter = new MenuNavigation17Adapter(this, menuData);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,int i, long id) {
                Toast.makeText(MenuNavigation17Activity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    MenuNavigation17Model menu = new MenuNavigation17Model();
                    menu.setMenuName(menus[j]);
                    menu.setMenuIcon(icon[j]);

                    if(i == j) {
                        menu.setSelected(true);
                        menu.setMenuIcon(iconSelected[j]);
                    }

                    menuData.add(menu);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menunavigation4_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "action search clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "action setting clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
