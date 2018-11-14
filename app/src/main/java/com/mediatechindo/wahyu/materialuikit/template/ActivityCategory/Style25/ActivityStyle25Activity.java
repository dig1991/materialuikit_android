package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style25;

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
import android.widget.ImageView;
import android.widget.Space;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class ActivityStyle25Activity extends AppCompatActivity implements View.OnClickListener, ActivityStyle25ClickListener {
    ArrayList<ActivityStyle25Model> rowListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity25_layout);

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
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        rView1.setHasFixedSize(false);
        rView1.setLayoutManager(layoutManager1);
        rView1.setNestedScrollingEnabled(false);

        ActivityStyle25Adapter rcAdapter = new ActivityStyle25Adapter(this, rowListItem);
        rView1.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

        RecyclerView rView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        rView2.setHasFixedSize(false);
        rView2.setLayoutManager(layoutManager2);
        rView2.setNestedScrollingEnabled(false);

        ActivityStyle25Adapter rcAdapter2 = new ActivityStyle25Adapter(this, rowListItem);
        rView2.setAdapter(rcAdapter);
        rcAdapter2.setClickListener(this);

    }

    private ArrayList<ActivityStyle25Model> getAllItemList(){
        ArrayList<ActivityStyle25Model> allItems = new ArrayList<>();
        ActivityStyle25Model dt;

        dt = new ActivityStyle25Model("profile/style-3/Profile-3-friend2.png","Christina","17:55",getResources().getString(R.string.lorem_ipsum2));
        allItems.add(dt);
        dt = new ActivityStyle25Model("profile/style-3/Profile-3-friend3.png","Remi Boocher","17:55",getResources().getString(R.string.lorem_ipsum3));
        allItems.add(dt);
        dt = new ActivityStyle25Model("profile/style-3/Profile-3-friend2.png","Christina","17:55",getResources().getString(R.string.lorem_ipsum2));
        allItems.add(dt);

        return  allItems;
    }

    private void loadImageSquareRequest(ImageView img, String url){
        Glide.with(this)
                .load(url)
                .into(img);
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
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
            case R.id.buttonEdit:
                Toast.makeText(this, "button edit clicked!", Toast.LENGTH_SHORT).show();
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
//        int pos = position + 1;
//        Toast.makeText(this, "Position " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
