package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style4;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle4Activity extends AppCompatActivity implements EcommerceStyle4ClickListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce4_layout);

        setupToolbar();

        ArrayList<EcommerceStyle4Model> rowListDressItem = getAllDressItemList();
        GridLayoutManager lLayout1 = new GridLayoutManager(this, 2);

        RecyclerView rView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        rView1.setLayoutManager(lLayout1);
        rView1.setNestedScrollingEnabled(false);
        rView1.setHasFixedSize(false);

        EcommerceStyle4DressAdapter rcAdapter1 = new EcommerceStyle4DressAdapter(this, rowListDressItem);
        rView1.setAdapter(rcAdapter1);
        rcAdapter1.setClickListener(this);


        ArrayList<EcommerceStyle4Model> rowListShoesItem = getAllShoesItemList();
        GridLayoutManager lLayout2 = new GridLayoutManager(this, 2);

        RecyclerView rView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        rView2.setLayoutManager(lLayout2);
        rView2.setNestedScrollingEnabled(false);
        rView2.setHasFixedSize(false);

        EcommerceStyle4ShoesAdapter rcAdapter2 = new EcommerceStyle4ShoesAdapter(this, rowListShoesItem);
        rView2.setAdapter(rcAdapter2);
        rcAdapter2.setClickListener(this);

    }

    private void setupToolbar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Ecommerce");
        }
    }

    private ArrayList<EcommerceStyle4Model> getAllDressItemList(){
        ArrayList<EcommerceStyle4Model> allItems = new ArrayList<EcommerceStyle4Model>();
        EcommerceStyle4Model dt;

        dt = new EcommerceStyle4Model("Zara Jumpsuit Dress","$225","ecommerce/style-3/Ecommerce-3-img-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle4Model("Black Faux Leather","$225","ecommerce/style-3/Ecommerce-3-img-4.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle4Model("Sky Blue Dress","$22","ecommerce/style-3/Ecommerce-3-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle4Model("Sky Blue Dress","$546","ecommerce/style-3/Ecommerce-3-img-2.jpg");
        allItems.add(dt);

        return  allItems;
    }

    private ArrayList<EcommerceStyle4Model> getAllShoesItemList(){
        ArrayList<EcommerceStyle4Model> allItems = new ArrayList<EcommerceStyle4Model>();
        EcommerceStyle4Model dt;

        dt = new EcommerceStyle4Model("Burgundy Ankle Boot","225","ecommerce/style-4/Ecommerce-4-img-1.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle4Model("Height Heel Pointed","225","ecommerce/style-4/Ecommerce-4-img-2.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle4Model("Zara Sneakers","225","ecommerce/style-4/Ecommerce-4-img-3.jpg");
        allItems.add(dt);
        dt = new EcommerceStyle4Model("Black Faux Hight Heel","225","ecommerce/style-4/Ecommerce-4-img-4.jpg");
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
    public void itemDressClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "Dress Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemShoesClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "Shoes Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.moreDressItem:
                Toast.makeText(this, "Button more item Women Dress clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.moreShoesItem:
                Toast.makeText(this, "Button more item Shoes clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
