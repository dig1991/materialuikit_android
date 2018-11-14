package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style30;

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

import com.mediatechindo.wahyu.materialuikit.tools.DividerItemDecoration;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle30Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String[] pageTitle = {"PROMO","WOMEN","MEN","KIDS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce30_layout);

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

        ArrayList<EcommerceStyle30Model> rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rView.setHasFixedSize(false);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        EcommerceStyle30Adapter rcAdapter = new EcommerceStyle30Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    private ArrayList<EcommerceStyle30Model> getAllItemList() {
        ArrayList<EcommerceStyle30Model> allItems = new ArrayList<>();
        EcommerceStyle30Model dt;

        dt = new EcommerceStyle30Model("WOMAN COLLECTIONS", "ecommerce/style-30/Ecommerce-30-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle30Model("MEN COLLECTIONS", "ecommerce/style-30/Ecommerce-30-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle30Model("WOMAN COLLECTIONS", "ecommerce/style-30/Ecommerce-30-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle30Model("MEN COLLECTIONS", "ecommerce/style-30/Ecommerce-30-img-2.jpg");
        allItems.add(dt);

        return allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ecommerce1_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_shopping_cart:
                Toast.makeText(this, "action shopping cart clicked!", Toast.LENGTH_SHORT).show();
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
}
