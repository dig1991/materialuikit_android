package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style12;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Space;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class ProfileStyle12Activity extends AppCompatActivity implements View.OnClickListener, ProfileStyle12ClickListener {
    ArrayList<ProfileStyle12Model> rowListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile12_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        // ADD SPACE TOP DRAWER ON LOLLIPOP AND UP
        final NavigationView navigationViewLeft = (NavigationView) findViewById(R.id.nav_view);
        View navLeftLay = navigationViewLeft.getHeaderView(0);
        Space spaceLeftTop = (Space) navLeftLay.findViewById(R.id.spaceLeftTop);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP){
            spaceLeftTop.setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        ProfileStyle12Adapter rcAdapter = new ProfileStyle12Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
    }

    private ArrayList<ProfileStyle12Model> getAllItemList(){
        ArrayList<ProfileStyle12Model> allItems = new ArrayList<ProfileStyle12Model>();
        ProfileStyle12Model dt;

        dt = new ProfileStyle12Model("Urban Skyscrapers","19","profile/style-6/Profile-6-image1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle12Model("Citywalks","45","profile/style-6/Profile-6-image2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle12Model("Antique Cars","788","profile/style-6/Profile-6-image3.jpg");
        allItems.add(dt);
        dt = new ProfileStyle12Model("Urban Skyscrapers","19","profile/style-6/Profile-6-image1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle12Model("Citywalks","45","profile/style-6/Profile-6-image2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle12Model("Antique Cars","788","profile/style-6/Profile-6-image3.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loginsignup_menu, menu);
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
        switch (view.getId()){
            case R.id.btnLoginSignupBack:
                onBackPressed();
                break;
            case R.id.buttonAdd:
                Toast.makeText(this, "button add clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
