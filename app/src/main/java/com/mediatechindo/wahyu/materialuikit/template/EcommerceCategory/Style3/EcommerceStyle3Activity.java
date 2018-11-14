package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style3;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle3Activity extends AppCompatActivity implements EcommerceStyle3ClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce3_layout);

        setupToolbar();

        ArrayList<EcommerceStyle3Model> rowListItem = getAllItemList();
        GridLayoutManager lLayout = new GridLayoutManager(this, 2);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setLayoutManager(lLayout);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        EcommerceStyle3Adapter rcAdapter = new EcommerceStyle3Adapter(this, rowListItem);
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

            View mCustomView = mInflater.inflate(R.layout.ecommerce3_toolbar, null);
            actionBar.setCustomView(mCustomView);
            actionBar.setDisplayShowCustomEnabled(true);
        }
    }

    private ArrayList<EcommerceStyle3Model> getAllItemList(){
        ArrayList<EcommerceStyle3Model> allItems = new ArrayList<EcommerceStyle3Model>();
        EcommerceStyle3Model dt;

        dt = new EcommerceStyle3Model("Sky Blue Dress","225","ecommerce/style-3/Ecommerce-3-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle3Model("Sky Blue Dress","225","ecommerce/style-3/Ecommerce-3-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle3Model("Zara Jumpsuit Dress","225","ecommerce/style-3/Ecommerce-3-img-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle3Model("Black Faux Leather","225","ecommerce/style-3/Ecommerce-3-img-4.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle3Model("Sky Blue Dress","225","ecommerce/style-3/Ecommerce-3-img-5.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle3Model("Sky Blue Dress","225","ecommerce/style-3/Ecommerce-3-img-6.jpg");
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
}
