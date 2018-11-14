package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style15;

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
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

public class MenuNavigation15Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation15_layout);

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1 :
                Toast.makeText(this, "menu feed clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2 :
                Toast.makeText(this, "menu explore clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3 :
                Toast.makeText(this, "menu photos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4 :
                Toast.makeText(this, "menu videos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5 :
                Toast.makeText(this, "menu messages clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSetting :
                Toast.makeText(this, "button setting clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonProfile :
                Toast.makeText(this, "button profile clicked!", Toast.LENGTH_SHORT).show();
                break;
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
