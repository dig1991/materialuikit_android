package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style10;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle10Activity extends AppCompatActivity implements EcommerceStyle10ClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce10_layout);

        setupToolbar();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ArrayList<EcommerceStyle10Model> rowListItem = getAllItemList();

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        EcommerceStyle10Adapter rcAdapter = new EcommerceStyle10Adapter(this, rowListItem);
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

            View mCustomView = mInflater.inflate(R.layout.ecommerce10_toolbar, null);
            actionBar.setCustomView(mCustomView);
            actionBar.setDisplayShowCustomEnabled(true);
        }
    }

    private ArrayList<EcommerceStyle10Model> getAllItemList(){
        ArrayList<EcommerceStyle10Model> allItems = new ArrayList<EcommerceStyle10Model>();
        EcommerceStyle10Model dt;

        dt = new EcommerceStyle10Model("Zara Jumpsuit Dress","Dress","125","ecommerce/style-10/Ecommerce-10-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle10Model("Black Faux Leather","Dress","125","ecommerce/style-10/Ecommerce-10-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle10Model("Zara Sneakers","Shoes","125","ecommerce/style-10/Ecommerce-10-img-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle10Model("Velcro Sneakers White","Shoes","125","ecommerce/style-10/Ecommerce-10-img-4.jpg");
        allItems.add(dt);

        dt = new EcommerceStyle10Model("Zara Jumpsuit Dress","Dress","125","ecommerce/style-10/Ecommerce-10-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle10Model("Black Faux Leather","Dress","125","ecommerce/style-10/Ecommerce-10-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle10Model("Zara Sneakers","Shoes","125","ecommerce/style-10/Ecommerce-10-img-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle10Model("Velcro Sneakers White","Shoes","125","ecommerce/style-10/Ecommerce-10-img-4.jpg");
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
