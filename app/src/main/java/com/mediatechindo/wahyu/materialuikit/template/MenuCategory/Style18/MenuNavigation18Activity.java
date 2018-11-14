package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style18;

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
import android.widget.ListView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class MenuNavigation18Activity extends AppCompatActivity{
    ListView menuList;
    ArrayList<MenuNavigation18Model> menuData;
    MenuNavigation18Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation18_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Menu");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MenuNavigation18Activity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationViewLeft = (NavigationView) findViewById(R.id.nav_view);

        int width = getResources().getDisplayMetrics().widthPixels;
        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) navigationViewLeft.getLayoutParams();
        params.width = width;
        navigationViewLeft.setLayoutParams(params);


        final String[] menus = {"Feed", "Explore", "Activity", "Group", "Photos", "Videos", "Setting"};
        menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            MenuNavigation18Model menu = new MenuNavigation18Model();
            menu.setMenuName(menus[i]);
            if(i == 0){
                menu.setMenuNotificationCount(32);
            }else if(i == 1){
                menu.setMenuNotificationCount(2);
            }
            menuData.add(menu);
        }

        menuList = (ListView) findViewById(R.id.menuList);
        adapter = new MenuNavigation18Adapter(this, menuData);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuNavigation18Activity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    MenuNavigation18Model menu = new MenuNavigation18Model();
                    menu.setMenuName(menus[j]);
                    if(j == 0){
                        menu.setMenuNotificationCount(32);
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
