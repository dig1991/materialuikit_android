package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style19;

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
import android.widget.TextView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class GalleryStyle19Activity extends AppCompatActivity implements View.OnClickListener, GalleryStyle19ClickListener {
    private TextView titleBar;
    private GalleryStyle19Adapter rcAdapter;
    private ArrayList<GalleryStyle19Model> itemSelected = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery19_layout);

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

        titleBar = (TextView) findViewById(R.id.titleBar);

        ArrayList<GalleryStyle19Model> rowListItem = getAllItemList();
        GridLayoutManager lLayout = new GridLayoutManager(this, 3);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        rcAdapter = new GalleryStyle19Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
    }

    private ArrayList<GalleryStyle19Model> getAllItemList(){
        ArrayList<GalleryStyle19Model> allItems = new ArrayList<GalleryStyle19Model>();
        GalleryStyle19Model dt;

        for(int i=1; i<9; i++){
            dt = new GalleryStyle19Model(i, "gallery/style-19/Gallery-19-img-" + i + ".png");
            allItems.add(dt);
        }

        return  allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gallery6_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                Toast.makeText(this, "action share clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                deleteItem();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "action setting clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    private void deleteItem() {
        if (itemSelected.size() == 0) {
            Toast.makeText(this, "Nothing to delete!", Toast.LENGTH_SHORT).show();
        }else {
            for (GalleryStyle19Model dt : itemSelected) {
                rcAdapter.deleteItem(dt.getId());
            }
            itemSelected.clear();
            titleBar.setText("Gallery");
        }
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
    public void itemSelect(View view, int id) {
        itemSelected.add(new GalleryStyle19Model(id));
        int numSelected = itemSelected.size();
        titleBar.setText(numSelected + " selected");
    }

    @Override
    public void itemUnSelect(View view, int id) {
        for (int i = 0; i < itemSelected.size(); i++) {
            if (itemSelected.get(i).getId() == id) {
                itemSelected.remove(i);
            }
        }
        int numSelected = itemSelected.size();

        if (numSelected < 1) {
            titleBar.setText("Gallery");
        } else {
            titleBar.setText(numSelected + " selected");
        }
    }
}
