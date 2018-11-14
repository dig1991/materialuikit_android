package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Space;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class GalleryStyle1Activity extends AppCompatActivity
        implements View.OnClickListener, GalleryStyle1WallpaperClickListener, GalleryStyle1CameraClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery1_layout);

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

        ArrayList<GalleryStyle1WallpaperModel> rowListItem = getAllItemPhotoList();
        GridLayoutManager lLayout = new GridLayoutManager(this, 3);
        RecyclerView rViewWallpaper = (RecyclerView) findViewById(R.id.recyclerViewWallpaper);
        GalleryStyle1WallpaperAdapter rcAdapterPhotos = new GalleryStyle1WallpaperAdapter(this, rowListItem);
        rcAdapterPhotos.setClickListener(this);

        rViewWallpaper.setHasFixedSize(true);
        rViewWallpaper.setLayoutManager(lLayout);
        rViewWallpaper.setNestedScrollingEnabled(false);
        rViewWallpaper.setAdapter(rcAdapterPhotos);

        ArrayList<GalleryStyle1CameraModel> rowListItem2 = getAllItemFriendList();
        GridLayoutManager lLayout2 = new GridLayoutManager(this, 3);
        RecyclerView rViewCamera = (RecyclerView) findViewById(R.id.recyclerViewCamera);
        GalleryStyle1CameraAdapter rcAdapterFriends = new GalleryStyle1CameraAdapter(this, rowListItem2);
        rcAdapterFriends.setClickListener(this);

        rViewCamera.setHasFixedSize(true);
        rViewCamera.setLayoutManager(lLayout2);
        rViewCamera.setNestedScrollingEnabled(false);
        rViewCamera.setAdapter(rcAdapterFriends);

    }

    private ArrayList<GalleryStyle1WallpaperModel> getAllItemPhotoList(){
        ArrayList<GalleryStyle1WallpaperModel> allItems = new ArrayList<GalleryStyle1WallpaperModel>();
        GalleryStyle1WallpaperModel dt;

        for(int i=7; i<13; i++){
            dt = new GalleryStyle1WallpaperModel("gallery/style-1/Gallery-1-img-" + i + ".png");
            allItems.add(dt);
        }

        return  allItems;
    }

    private ArrayList<GalleryStyle1CameraModel> getAllItemFriendList(){
        ArrayList<GalleryStyle1CameraModel> allItems = new ArrayList<GalleryStyle1CameraModel>();
        GalleryStyle1CameraModel dt;

        for(int i=1; i<7; i++){
            dt = new GalleryStyle1CameraModel("gallery/style-1/Gallery-1-img-" + i + ".png");
            allItems.add(dt);
        }

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
    public void itemFriendClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "Camera " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemPhotoClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "Wallpaper " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
