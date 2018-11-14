package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style29;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.mediatechindo.wahyu.materialuikit.tools.DividerItemDecoration;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle29Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce29_layout);

        setupToolbar();

        ArrayList<EcommerceStyle29Model> rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rView.setHasFixedSize(false);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        EcommerceStyle29Adapter rcAdapter = new EcommerceStyle29Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    private void setupToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("User Review (5)");
        }
    }

    private ArrayList<EcommerceStyle29Model> getAllItemList() {
        ArrayList<EcommerceStyle29Model> allItems = new ArrayList<>();
        EcommerceStyle29Model dt;

        dt = new EcommerceStyle29Model("Madelaino Arno", getResources().getString(R.string.lorem_ipsum2), "2 hour ago");
        allItems.add(dt);
        dt = new EcommerceStyle29Model("Michael Angelo", getResources().getString(R.string.lorem_ipsum2), "3 hour ago");
        allItems.add(dt);
        dt = new EcommerceStyle29Model("Anna Hudgens", getResources().getString(R.string.lorem_ipsum2), "4 hour ago");
        allItems.add(dt);
        dt = new EcommerceStyle29Model("Terrry Truckers", getResources().getString(R.string.lorem_ipsum2), "8 hour ago");
        allItems.add(dt);
        dt = new EcommerceStyle29Model("Madelaino Arno", getResources().getString(R.string.lorem_ipsum2), "2 hour ago");
        allItems.add(dt);

        return allItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return true;
    }

}
