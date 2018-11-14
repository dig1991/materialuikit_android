package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style23;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Space;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class GalleryStyle23Activity extends AppCompatActivity implements View.OnClickListener, GalleryStyle23ClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery23_layout);

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

        ArrayList<GalleryStyle23Model> rowListItem = getAllItemList();
        GridLayoutManager lLayout = new GridLayoutManager(this, 2);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        GalleryStyle23Adapter rcAdapter = new GalleryStyle23Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
    }

    private ArrayList<GalleryStyle23Model> getAllItemList(){
        ArrayList<GalleryStyle23Model> allItems = new ArrayList<GalleryStyle23Model>();
        GalleryStyle23Model dt;

        dt = new GalleryStyle23Model("Workspace","Desk, Iterior, Workspace","gallery/style-23/Gallery-23-img-1.png");
        allItems.add(dt);
        dt = new GalleryStyle23Model("Fungky Bedroom","Interior, Cabin","gallery/style-23/Gallery-23-img-2.png");
        allItems.add(dt);
        dt = new GalleryStyle23Model("White Stripes Girl","Fashion, Instagram","gallery/style-23/Gallery-23-img-3.png");
        allItems.add(dt);
        dt = new GalleryStyle23Model("Coffee, Bread & Pecans","Food","gallery/style-23/Gallery-23-img-4.png");
        allItems.add(dt);

        dt = new GalleryStyle23Model("Workspace","Desk, Iterior, Workspace","gallery/style-23/Gallery-23-img-1.png");
        allItems.add(dt);
        dt = new GalleryStyle23Model("Fungky Bedroom","Interior, Cabin","gallery/style-23/Gallery-23-img-2.png");
        allItems.add(dt);
        dt = new GalleryStyle23Model("White Stripes Girl","Fashion, Instagram","gallery/style-23/Gallery-23-img-3.png");
        allItems.add(dt);
        dt = new GalleryStyle23Model("Coffee, Bread & Pecans","Food","gallery/style-23/Gallery-23-img-4.png");
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
