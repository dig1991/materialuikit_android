package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style23;

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

public class ProfileStyle23Activity extends AppCompatActivity
        implements View.OnClickListener, ProfileStyle23PhotoClickListener, ProfileStyle23FriendClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile23_layout);

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

        ArrayList<ProfileStyle23PhotoModel> rowListItem = getAllItemPhotoList();
        GridLayoutManager lLayout = new GridLayoutManager(this, 3);
        RecyclerView rViewPhotos = (RecyclerView) findViewById(R.id.recyclerViewPhotos);
        ProfileStyle23PhotoAdapter rcAdapterPhotos = new ProfileStyle23PhotoAdapter(this, rowListItem);
        rcAdapterPhotos.setClickListener(this);

        rViewPhotos.setHasFixedSize(true);
        rViewPhotos.setLayoutManager(lLayout);
        rViewPhotos.setNestedScrollingEnabled(false);
        rViewPhotos.setAdapter(rcAdapterPhotos);

        ArrayList<ProfileStyle23FriendModel> rowListItem2 = getAllItemFriendList();
        GridLayoutManager lLayout2 = new GridLayoutManager(this, 3);
        RecyclerView rViewFriends = (RecyclerView) findViewById(R.id.recyclerViewFriends);
        ProfileStyle23FriendAdapter rcAdapterFriends = new ProfileStyle23FriendAdapter(this, rowListItem2);
        rcAdapterFriends.setClickListener(this);

        rViewFriends.setHasFixedSize(true);
        rViewFriends.setLayoutManager(lLayout2);
        rViewFriends.setNestedScrollingEnabled(false);
        rViewFriends.setAdapter(rcAdapterFriends);

    }

    private ArrayList<ProfileStyle23PhotoModel> getAllItemPhotoList(){
        ArrayList<ProfileStyle23PhotoModel> allItems = new ArrayList<ProfileStyle23PhotoModel>();
        ProfileStyle23PhotoModel dt;

        for(int i=0; i<6; i++){
            int num = i + 1;
            dt = new ProfileStyle23PhotoModel("profile/style-2/Profile-2-post" + num + ".png");
            allItems.add(dt);
        }

        return  allItems;
    }

    private ArrayList<ProfileStyle23FriendModel> getAllItemFriendList(){
        ArrayList<ProfileStyle23FriendModel> allItems = new ArrayList<ProfileStyle23FriendModel>();
        ProfileStyle23FriendModel dt;

        for(int i=0; i<5; i++){
            int num = i + 1;
            dt = new ProfileStyle23FriendModel("profile/style-3/Profile-3-friend" + num + ".png");
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
            case R.id.btnHire:
                Toast.makeText(this, "button hire clicked!", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "Friend " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemPhotoClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(this, "Portfolio " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
