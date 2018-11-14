package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style20;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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

public class MenuNavigation20Activity extends AppCompatActivity implements View.OnClickListener {
    ListView menuList;
    ArrayList<MenuNavigation20Model> menuData;
    MenuNavigation20Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation20_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Menu");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        int width = getResources().getDisplayMetrics().widthPixels;
        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) navigationView.getLayoutParams();
        params.width = width;
        navigationView.setLayoutParams(params);


        final String[] menus = {"Explore", "Messages", "Photos", "Videos", "Group", "Setting"};
        final int[] icon = {
                R.drawable.ic_explore,
                R.drawable.ic_messages,
                R.drawable.ic_photos,
                R.drawable.ic_videos,
                R.drawable.ic_group,
                R.drawable.ic_setting};
        menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            MenuNavigation20Model menu = new MenuNavigation20Model();
            menu.setMenuName(menus[i]);
            menu.setIconImage(icon[i]);
            if(i == 0){
                menu.setMenuNotificationNonActiveCount(32);
            }else if(i == 1){
                menu.setMenuNotificationCount(2);
            }
            menuData.add(menu);
        }

        menuList = (ListView) findViewById(R.id.menuList);
        adapter = new MenuNavigation20Adapter(this, menuData);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuNavigation20Activity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    MenuNavigation20Model menu = new MenuNavigation20Model();
                    menu.setMenuName(menus[j]);
                    menu.setIconImage(icon[j]);
                    if(j == 0){
                        menu.setMenuNotificationNonActiveCount(32);
                    }else if(j == 1){
                        menu.setMenuNotificationCount(2);
                    }

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
        switch (view.getId()){
            case R.id.buttonLogout :
                Toast.makeText(this, "button logout clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}
