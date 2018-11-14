package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style8;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle8Activity extends AppCompatActivity implements EcommerceStyle8ClickListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce8_layout);

        setupToolbar();

        String url = BuildConfig.IMAGE_URL + "ecommerce/style-8/Ecommerce-8-img-1.jpg";
        loadImageRequest((ImageView) findViewById(R.id.image1), url);

        (findViewById(R.id.buttonShopNow)).setOnClickListener(this);

        ArrayList<EcommerceStyle8Model> rowListDressItem = getAllDressItemList();
        GridLayoutManager lLayout1 = new GridLayoutManager(this, 2);

        RecyclerView rView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        rView1.setLayoutManager(lLayout1);
        rView1.setNestedScrollingEnabled(false);
        rView1.setHasFixedSize(false);

        EcommerceStyle8Adapter rcAdapter1 = new EcommerceStyle8Adapter(this, rowListDressItem);
        rView1.setAdapter(rcAdapter1);
        rcAdapter1.setClickListener(this);
    }

    private void setupToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("New Arrivals");
        }
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .crossFade()
                .thumbnail(0.01f)
                .fitCenter()
                .into(bg);
    }

    private ArrayList<EcommerceStyle8Model> getAllDressItemList() {
        ArrayList<EcommerceStyle8Model> allItems = new ArrayList<EcommerceStyle8Model>();
        EcommerceStyle8Model dt;

        dt = new EcommerceStyle8Model("Zara Jumpsuit Dress", "$225", "ecommerce/style-8/Ecommerce-8-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle8Model("Black Faux Leather", "$225", "ecommerce/style-8/Ecommerce-8-img-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle8Model("Zara Jumpsuit Dress", "$22", "ecommerce/style-8/Ecommerce-8-img-4.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle8Model("Black Faux Leather", "$546", "ecommerce/style-8/Ecommerce-8-img-5.jpg");
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
    public void itemDressClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "Item Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.moreDressItem:
                Toast.makeText(this, "Button more item Women Dress clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonShopNow:
                Toast.makeText(this, "Button show now clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
