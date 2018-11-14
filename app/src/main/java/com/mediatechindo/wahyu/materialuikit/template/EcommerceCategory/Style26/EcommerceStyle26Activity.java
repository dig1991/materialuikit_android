package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style26;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.tools.DividerItemDecoration;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle26Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce26_layout);

        setupToolbar();

        ArrayList<EcommerceStyle26Model> rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rView.setHasFixedSize(false);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        EcommerceStyle26Adapter rcAdapter = new EcommerceStyle26Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    private void setupToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Order Confirmation");
        }
    }

    private ArrayList<EcommerceStyle26Model> getAllItemList() {
        ArrayList<EcommerceStyle26Model> allItems = new ArrayList<>();
        EcommerceStyle26Model dt;

        dt = new EcommerceStyle26Model("ecommerce/style-21/Ecommerce-21-img-1.jpg", "Zara Jumpsuit Dress", "Size: M", "1", "$125");
        allItems.add(dt);
        dt = new EcommerceStyle26Model("ecommerce/style-21/Ecommerce-21-img-2.jpg", "Black Faux Leather", "Size: M", "2", "$125");
        allItems.add(dt);

        return allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ecommerce24_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_search:
                Toast.makeText(this, "action search cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_shopping_cart:
                Toast.makeText(this, "action shopping cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "action setting cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonEditAddress:
                Toast.makeText(this, "Button Edit Address clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonEditPayment:
                Toast.makeText(this, "Button Edit Payment clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnFinishOrder:
                Toast.makeText(this, "Button Finish Order clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

}
