package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style3;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class GalleryStyle3Activity extends AppCompatActivity implements GalleryStyle3ClickListener {
    ArrayList<GalleryStyle3Model> rowListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery3_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Wallpaper");
        }

        rowListItem = getAllItemList();
        StaggeredGridLayoutManager gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(gaggeredGridLayoutManager);
        rView.setNestedScrollingEnabled(false);

        GalleryStyle3Adapter rcAdapter = new GalleryStyle3Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
    }

    private ArrayList<GalleryStyle3Model> getAllItemList(){
        ArrayList<GalleryStyle3Model> allItems = new ArrayList<GalleryStyle3Model>();
        GalleryStyle3Model dt;

        dt = new GalleryStyle3Model("Workspace","gallery/style-3/Gallery-3-img-1.png");
        allItems.add(dt);
        dt = new GalleryStyle3Model("Still Object","gallery/style-3/Gallery-3-img-2.png");
        allItems.add(dt);
        dt = new GalleryStyle3Model("Funny Stuff","gallery/style-3/Gallery-3-img-3.png");
        allItems.add(dt);
        dt = new GalleryStyle3Model("Toys","gallery/style-3/Gallery-3-img-4.png");
        allItems.add(dt);
        dt = new GalleryStyle3Model("Fashion","gallery/style-3/Gallery-3-img-5.png");
        allItems.add(dt);
        dt = new GalleryStyle3Model("Women","gallery/style-3/Gallery-3-img-6.png");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loginsignup_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_search:
                Toast.makeText(this, "action search clicked!", Toast.LENGTH_SHORT).show();
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
    public void itemClicked(View view, int position) {
        GalleryStyle3Model dt = rowListItem.get(position);
        Toast.makeText(this, dt.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
