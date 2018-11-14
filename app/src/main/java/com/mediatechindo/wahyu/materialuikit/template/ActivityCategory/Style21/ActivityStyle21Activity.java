package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style21;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Space;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;
import com.tubb.smrv.SwipeMenuRecyclerView;

import java.util.ArrayList;

public class ActivityStyle21Activity extends AppCompatActivity implements View.OnClickListener, ActivityStyle21ClickListener {
    ArrayList<ActivityStyle21Model> rowListItem;
    private ItemTouchHelper mItemTouchHelper;
    private SwipeMenuRecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity21_layout);

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

        rView = (SwipeMenuRecyclerView) findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        ActivityStyle21Adapter rcAdapter = new ActivityStyle21Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

    }

    private ArrayList<ActivityStyle21Model> getAllItemList(){
        ArrayList<ActivityStyle21Model> allItems = new ArrayList<>();
        ActivityStyle21Model dt;

        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend2.png","Christina", getResources().getString(R.string.lorem_ipsum2), "17:53");
        allItems.add(dt);
        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend3.png","Remi Boucher", getResources().getString(R.string.lorem_ipsum3), "17:55");
        allItems.add(dt);
        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend3.png","Steve Rogers", getResources().getString(R.string.lorem_ipsum3), "17:55");
        allItems.add(dt);
        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend3.png","Ludwig Beetoven", getResources().getString(R.string.lorem_ipsum3), "17:55");
        allItems.add(dt);

        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend2.png","Christina", getResources().getString(R.string.lorem_ipsum2), "17:53");
        allItems.add(dt);
        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend3.png","Remi Boucher", getResources().getString(R.string.lorem_ipsum3), "17:55");
        allItems.add(dt);
        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend3.png","Steve Rogers", getResources().getString(R.string.lorem_ipsum3), "17:55");
        allItems.add(dt);
        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend3.png","Ludwig Beetoven", getResources().getString(R.string.lorem_ipsum3), "17:55");
        allItems.add(dt);

        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend2.png","Christina", getResources().getString(R.string.lorem_ipsum2), "17:53");
        allItems.add(dt);
        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend3.png","Remi Boucher", getResources().getString(R.string.lorem_ipsum3), "17:55");
        allItems.add(dt);
        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend3.png","Steve Rogers", getResources().getString(R.string.lorem_ipsum3), "17:55");
        allItems.add(dt);
        dt = new ActivityStyle21Model("profile/style-3/Profile-3-friend3.png","Ludwig Beetoven", getResources().getString(R.string.lorem_ipsum3), "17:55");
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
        int pos = position + 1;
        Toast.makeText(this, "Position " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }

}
