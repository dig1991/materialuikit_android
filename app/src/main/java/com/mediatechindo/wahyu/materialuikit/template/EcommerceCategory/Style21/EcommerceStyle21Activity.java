package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style21;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;
import com.tubb.smrv.SwipeMenuRecyclerView;

import java.util.ArrayList;

public class EcommerceStyle21Activity extends AppCompatActivity implements View.OnClickListener, EcommerceStyle21ClickListener {
    private ArrayList<EcommerceStyle21Model> rowListItem;
    private SwipeMenuRecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce21_layout);

        setupToolbar();

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rView = (SwipeMenuRecyclerView) findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        EcommerceStyle21Adapter rcAdapter = new EcommerceStyle21Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Shopping Cart");
        }
    }

    private ArrayList<EcommerceStyle21Model> getAllItemList() {
        ArrayList<EcommerceStyle21Model> allItems = new ArrayList<>();
        EcommerceStyle21Model dt;

        dt = new EcommerceStyle21Model("ecommerce/style-21/Ecommerce-21-img-1.jpg", "Zara Jumpsuit Dress", "Size: M", "$125");
        allItems.add(dt);
        dt = new EcommerceStyle21Model("ecommerce/style-21/Ecommerce-21-img-2.jpg", "Black Faux Leather", "Size: M", "$250");
        allItems.add(dt);

        dt = new EcommerceStyle21Model("ecommerce/style-21/Ecommerce-21-img-1.jpg", "Zara Jumpsuit Dress", "Size: M", "$125");
        allItems.add(dt);
        dt = new EcommerceStyle21Model("ecommerce/style-21/Ecommerce-21-img-2.jpg", "Black Faux Leather", "Size: M", "$250");
        allItems.add(dt);

        return allItems;
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddToWishlist:
                Toast.makeText(this, "Button add to wishlist clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAddToChart:
                Toast.makeText(this, "Button add to cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

    @Override
    public void itemClicked(View view, int position) {
        int pos = position + 1;
        Toast.makeText(this, "Position " + pos + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
