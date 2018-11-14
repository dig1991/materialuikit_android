package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style6;

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

public class GalleryStyle6Activity extends AppCompatActivity implements GalleryStyle6ClickListener, View.OnClickListener {
    private TextView titleBar;
    private GalleryStyle6InteriorAdapter rcAdapterInterior;
    private ArrayList<GalleryStyle6InteriorModel> itemSelected = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery6_layout);

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
        if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            spaceLeftTop.setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        titleBar = (TextView) findViewById(R.id.titleBar);

        ArrayList<GalleryStyle6InteriorModel> rowListItem = getAllItemInteriorList();
        GridLayoutManager lLayout = new GridLayoutManager(this, 3);
        RecyclerView rViewInterior = (RecyclerView) findViewById(R.id.recyclerViewInterior);
        rcAdapterInterior = new GalleryStyle6InteriorAdapter(this, rowListItem);

        rViewInterior.setHasFixedSize(true);
        rViewInterior.setLayoutManager(lLayout);
        rViewInterior.setNestedScrollingEnabled(false);
        rViewInterior.setAdapter(rcAdapterInterior);
        rcAdapterInterior.setClickListener(this);

        ArrayList<GalleryStyle6WomenModel> rowListItem2 = getAllItemWomenList();
        GridLayoutManager lLayout2 = new GridLayoutManager(this, 3);
        RecyclerView rViewWomen = (RecyclerView) findViewById(R.id.recyclerViewWomen);
        GalleryStyle6WomenAdapter rcAdapterWomen = new GalleryStyle6WomenAdapter(this, rowListItem2);

        rViewWomen.setHasFixedSize(true);
        rViewWomen.setLayoutManager(lLayout2);
        rViewWomen.setNestedScrollingEnabled(false);
        rViewWomen.setAdapter(rcAdapterWomen);

        ArrayList<GalleryStyle6NatureModel> rowListItem3 = getAllItemNatureList();
        GridLayoutManager lLayout3 = new GridLayoutManager(this, 3);
        RecyclerView rViewNature = (RecyclerView) findViewById(R.id.recyclerViewNature);
        GalleryStyle6NatureAdapter rcAdapterNature = new GalleryStyle6NatureAdapter(this, rowListItem3);

        rViewNature.setHasFixedSize(true);
        rViewNature.setLayoutManager(lLayout3);
        rViewNature.setNestedScrollingEnabled(false);
        rViewNature.setAdapter(rcAdapterNature);

    }

    private ArrayList<GalleryStyle6InteriorModel> getAllItemInteriorList() {
        ArrayList<GalleryStyle6InteriorModel> allItems = new ArrayList<>();
        GalleryStyle6InteriorModel dt;

        for (int i = 1; i < 7; i++) {
            dt = new GalleryStyle6InteriorModel(i, "gallery/style-6/Gallery-6-img-" + i + ".png");
            allItems.add(dt);
        }

        return allItems;
    }

    private ArrayList<GalleryStyle6WomenModel> getAllItemWomenList() {
        ArrayList<GalleryStyle6WomenModel> allItems = new ArrayList<>();
        GalleryStyle6WomenModel dt;

        for (int i = 7; i < 13; i++) {
            dt = new GalleryStyle6WomenModel("gallery/style-6/Gallery-6-img-" + i + ".png");
            allItems.add(dt);
        }

        return allItems;
    }

    private ArrayList<GalleryStyle6NatureModel> getAllItemNatureList() {
        ArrayList<GalleryStyle6NatureModel> allItems = new ArrayList<>();
        GalleryStyle6NatureModel dt;

        for (int i = 7; i < 13; i++) {
            dt = new GalleryStyle6NatureModel("gallery/style-1/Gallery-1-img-" + i + ".png");
            allItems.add(dt);
        }

        return allItems;
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

    private void deleteItem() {
        if (itemSelected.size() == 0) {
            Toast.makeText(this, "Nothing to delete!", Toast.LENGTH_SHORT).show();
        }else {
            for (GalleryStyle6InteriorModel dt : itemSelected) {
                rcAdapterInterior.deleteItem(dt.getId());
            }
            itemSelected.clear();
            titleBar.setText("Gallery");
        }
    }

    @Override
    public void itemInteriorSelect(View view, int id) {
        itemSelected.add(new GalleryStyle6InteriorModel(id));
        int numSelected = itemSelected.size();
        titleBar.setText(numSelected + " selected");
    }

    @Override
    public void itemInteriorUnSelect(View view, int id) {
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
