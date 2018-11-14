package com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.LeftMenuLight;

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

public class ExtraLeftMenuLightActivity extends AppCompatActivity implements View.OnClickListener{
    ListView menuList;
    ArrayList<ExtraLeftMenuLightModel> menuData;
    ExtraLeftMenuLightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra_leftmenu_light_layout);

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

        final String[] menus = {"Feed", "Explore", "Activity", "Group", "Photos", "Videos", "Setting"};
        menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            ExtraLeftMenuLightModel menu = new ExtraLeftMenuLightModel();
            menu.setMenuName(menus[i]);
            menuData.add(menu);
        }

        menuList = (ListView) findViewById(R.id.menuList);
        adapter = new ExtraLeftMenuLightAdapter(this, menuData);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ExtraLeftMenuLightActivity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    ExtraLeftMenuLightModel menu = new ExtraLeftMenuLightModel();
                    menu.setMenuName(menus[j]);
                    if(i == j) {
                        menu.setSelected(true);
                    }

                    menuData.add(menu);
                }
                adapter.notifyDataSetChanged();

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
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
