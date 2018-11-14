package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style6;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle6Activity extends AppCompatActivity implements EcommerceStyle6ClickListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce6_layout);

        setupToolbar();

        ArrayList<EcommerceStyle6Model> rowListItem = getAllItemList();
        StaggeredGridLayoutManager gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setLayoutManager(gaggeredGridLayoutManager);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        EcommerceStyle6Adapter rcAdapter = new EcommerceStyle6Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            LayoutInflater mInflater = LayoutInflater.from(this);

            View mCustomView = mInflater.inflate(R.layout.ecommerce6_toolbar, null);
            actionBar.setCustomView(mCustomView);
            actionBar.setDisplayShowCustomEnabled(true);
        }
    }

    private ArrayList<EcommerceStyle6Model> getAllItemList(){
        ArrayList<EcommerceStyle6Model> allItems = new ArrayList<EcommerceStyle6Model>();
        EcommerceStyle6Model dt;

        dt = new EcommerceStyle6Model("Dress","$32","ecommerce/style-6/Ecommerce-6-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle6Model("Shoes","$250","ecommerce/style-6/Ecommerce-6-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle6Model("Hat","$32","ecommerce/style-6/Ecommerce-6-img-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle6Model("Bag & Purse","$250","ecommerce/style-6/Ecommerce-6-img-4.jpg");
        allItems.add(dt);

        dt = new EcommerceStyle6Model("Dress","$32","ecommerce/style-6/Ecommerce-6-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle6Model("Shoes","$250","ecommerce/style-6/Ecommerce-6-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle6Model("Hat","$32","ecommerce/style-6/Ecommerce-6-img-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle6Model("Bag & Purse","$250","ecommerce/style-6/Ecommerce-6-img-4.jpg");
        allItems.add(dt);

        return  allItems;
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
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_shopping_cart:
                Toast.makeText(this, "action shopping cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.allCategorybutton:
                Toast.makeText(this, "View all category clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
