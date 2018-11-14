package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style18;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.Toast;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class ProfileStyle18Activity extends AppCompatActivity implements View.OnClickListener, ProfileStyle18ClickListener{
    ArrayList<ProfileStyle18Model> rowListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile18_layout);

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

        ImageView imgCover = (ImageView) findViewById(R.id.imageCover);
        String url = BuildConfig.IMAGE_URL + "profile/style-16/Profile-16-header.jpg";
        String urlThumb = BuildConfig.IMAGE_URL + "profile/style-16/Profile-16-header-thumb.jpg";

        loadImageCover(imgCover, url, urlThumb);

        rowListItem = getAllItemList();
        StaggeredGridLayoutManager gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(gaggeredGridLayoutManager);
        rView.setNestedScrollingEnabled(false);

        ProfileStyle18Adapter rcAdapter = new ProfileStyle18Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

    }

    private ArrayList<ProfileStyle18Model> getAllItemList(){
        ArrayList<ProfileStyle18Model> allItems = new ArrayList<ProfileStyle18Model>();
        ProfileStyle18Model dt;

        dt = new ProfileStyle18Model("Book Shelf","profile/style-18/Profile-18-post1.jpg");
        allItems.add(dt);
        dt = new ProfileStyle18Model("Bedroom","profile/style-18/Profile-18-post2.jpg");
        allItems.add(dt);
        dt = new ProfileStyle18Model("Mirror","profile/style-18/Profile-18-post3.jpg");
        allItems.add(dt);
        dt = new ProfileStyle18Model("Chair","profile/style-18/Profile-18-post4.jpg");
        allItems.add(dt);

        return  allItems;
    }

    private void loadImageCover(ImageView bg, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(this)
                .load(urlThumb);

        Glide.with(this)
                .load(url)
                .crossFade()
                .thumbnail(thumbnailRequest)
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
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void itemClicked(View view, int position) {
        ProfileStyle18Model dt = rowListItem.get(position);
        Toast.makeText(this, dt.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
