package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style16;

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

public class MenuNavigation16Activity extends AppCompatActivity implements View.OnClickListener {
    ListView menuList;
    ArrayList<MenuNavigation16Model> menuData;
    MenuNavigation16Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation16_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Menu");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MenuNavigation16Activity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationViewLeft = (NavigationView) findViewById(R.id.nav_view);

        int width = getResources().getDisplayMetrics().widthPixels;
        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) navigationViewLeft.getLayoutParams();
        params.width = width;
        navigationViewLeft.setLayoutParams(params);

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
            MenuNavigation16Model menu = new MenuNavigation16Model();
            menu.setMenuName(menus[i]);
            menu.setIconImage(icon[i]);
            if(i == 0){
                menu.setMenuNotificationCount(22);
            }
            menuData.add(menu);
        }

        menuList = (ListView) findViewById(R.id.menuList);
        adapter = new MenuNavigation16Adapter(this, menuData);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuNavigation16Activity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    MenuNavigation16Model menu = new MenuNavigation16Model();
                    menu.setMenuName(menus[j]);
                    menu.setIconImage(icon[j]);
                    if(j == 0){
                        menu.setMenuNotificationCount(32);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.navmain_profile:
                Toast.makeText(this, "menu profile clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_messages:
                Toast.makeText(this, "menu messages clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_settings:
                Toast.makeText(this, "menu settings clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_group:
                Toast.makeText(this, "menu group clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_photos:
                Toast.makeText(this, "menu photos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_videos:
                Toast.makeText(this, "menu videos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_logout:
                Toast.makeText(this, "menu logout clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}
