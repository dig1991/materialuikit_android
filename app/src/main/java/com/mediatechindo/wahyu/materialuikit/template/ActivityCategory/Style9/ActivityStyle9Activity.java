package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style9;

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
import com.mediatechindo.wahyu.materialuikit.tools.DividerItemDecoration;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class ActivityStyle9Activity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<ActivityStyle9Model> rowListItem;
    ActivityStyle9Adapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity9_layout);

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

        ImageView img1 = (ImageView) findViewById(R.id.image1);
        String urlPost = BuildConfig.IMAGE_URL + "activity/style-4/Activity-4-img-1.jpg";
        loadImageRequest(img1, urlPost);

        String friend1Url = BuildConfig.IMAGE_URL + "activity/style-4/Activity-4-profpic-1.jpg";
        ImageView imgProfile1 = (ImageView) findViewById(R.id.imgProfile1);
        loadImageSquareRequest(imgProfile1, friend1Url);


        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        rcAdapter = new ActivityStyle9Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    private ArrayList<ActivityStyle9Model> getAllItemList(){
        ArrayList<ActivityStyle9Model> allItems = new ArrayList<>();
        ActivityStyle9Model dt;

        dt = new ActivityStyle9Model("profile/style-3/Profile-3-friend3.png","Tony Ramirez", "Nice photo");
        allItems.add(dt);
        dt = new ActivityStyle9Model("profile/style-3/Profile-3-friend3.png","Ludwig", "I love how you took it on white");
        allItems.add(dt);
        dt = new ActivityStyle9Model("profile/style-3/Profile-3-friend2.png","Christina", "You're awesome!");
        allItems.add(dt);
        dt = new ActivityStyle9Model("profile/style-3/Profile-3-friend3.png","Remi Boucher", "Wow!");
        allItems.add(dt);
        dt = new ActivityStyle9Model("profile/style-3/Profile-3-friend3.png","Tony Ramirez", "Nice photo");
        allItems.add(dt);
        dt = new ActivityStyle9Model("profile/style-3/Profile-3-friend3.png","Ludwig", "I love how you took it on white");
        allItems.add(dt);
        dt = new ActivityStyle9Model("profile/style-3/Profile-3-friend2.png","Christina", "You're awesome!");
        allItems.add(dt);

        return  allItems;
    }

    private void loadImageSquareRequest(ImageView img, String url){
        Glide.with(this)
                .load(url)
                .into(img);
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
            case R.id.buttonEdit:
                Toast.makeText(this, "button edit clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonLike:
                Toast.makeText(this, "button like clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSend:
                Toast.makeText(this, "button send clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }
}
