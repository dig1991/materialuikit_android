package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style2;

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
import android.widget.ImageView;
import android.widget.Space;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class GalleryStyle2Activity extends AppCompatActivity implements GalleryStyle2ClickListener,View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery2_layout);

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
        if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP){
            spaceLeftTop.setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ArrayList<GalleryStyle2Model> rowListItem1 = getAllItemList1();
        ArrayList<GalleryStyle2Model> rowListItem2 = getAllItemList2();
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView rView1 = (RecyclerView) findViewById(R.id.recyclerViewLandscape);
        RecyclerView rView2 = (RecyclerView) findViewById(R.id.recyclerViewUrbanCity);
        rView1.setHasFixedSize(true);
        rView1.setLayoutManager(layoutManager1);
        rView1.setNestedScrollingEnabled(false);
        rView1.setHasFixedSize(false);
        rView2.setHasFixedSize(true);
        rView2.setLayoutManager(layoutManager2);
        rView2.setNestedScrollingEnabled(false);
        rView2.setHasFixedSize(false);

        GalleryStyle2Adapter1 rcAdapter1 = new GalleryStyle2Adapter1(this, rowListItem1);
        GalleryStyle2Adapter2 rcAdapter2 = new GalleryStyle2Adapter2(this, rowListItem2);
        rView1.setAdapter(rcAdapter1);
        rView2.setAdapter(rcAdapter2);
        rcAdapter1.setClickListener(this);
        rcAdapter2.setClickListener(this);


        ImageView img1 = (ImageView) findViewById(R.id.imageNature);
        String urlPost = BuildConfig.IMAGE_URL + "gallery/style-2/Gallery-2-img-6.png";
        loadImageRequest(img1, urlPost);

    }

    private ArrayList<GalleryStyle2Model> getAllItemList1(){
        ArrayList<GalleryStyle2Model> allItems = new ArrayList<GalleryStyle2Model>();
        GalleryStyle2Model dt;

        dt = new GalleryStyle2Model("profile/style-17/Profile-17-post1.jpg");
        allItems.add(dt);
        dt = new GalleryStyle2Model("profile/style-17/Profile-17-post2.jpg");
        allItems.add(dt);

        return  allItems;
    }

    private ArrayList<GalleryStyle2Model> getAllItemList2(){
        ArrayList<GalleryStyle2Model> allItems = new ArrayList<GalleryStyle2Model>();
        GalleryStyle2Model dt;

        dt = new GalleryStyle2Model("profile/style-17/Profile-17-post3.jpg");
        allItems.add(dt);
        dt = new GalleryStyle2Model("profile/style-17/Profile-17-post4.jpg");
        allItems.add(dt);
        dt = new GalleryStyle2Model("profile/style-17/Profile-17-post5.jpg");
        allItems.add(dt);

        return  allItems;
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
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
    public void onClick(View view) {
        switch (view.getId()){
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

    @Override
    public void itemClicked1(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "List 1 Position " + num, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClicked2(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "List 2 Position " + num, Toast.LENGTH_SHORT).show();
    }
}
