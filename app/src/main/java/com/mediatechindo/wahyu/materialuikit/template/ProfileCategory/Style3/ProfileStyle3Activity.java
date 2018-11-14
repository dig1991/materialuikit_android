package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style3;

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
import android.widget.Space;
import android.widget.Toast;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.mediatechindo.wahyu.materialuikit.*;
import com.mediatechindo.wahyu.materialuikit.tools.DividerItemDecoration;

import java.util.ArrayList;

public class ProfileStyle3Activity extends AppCompatActivity implements View.OnClickListener, ProfileStyle3ClickListener {
    ArrayList<ProfileStyle3Model> rowListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile3_layout);

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

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setLayoutManager(layoutManager);
        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        ProfileStyle3Adapter rcAdapter = new ProfileStyle3Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

        String url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-header.png";
        String urlThumb = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-header-thumb.png";

        loadImageRequest(drawer, url, urlThumb);

    }

    private void loadImageRequest(final DrawerLayout bg, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(this)
                .load(urlThumb);

        Glide.with(this)
                .load(url)
                .crossFade()
                .thumbnail(thumbnailRequest)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        bg.setBackground(resource);
                    }
                });
    }

    private ArrayList<ProfileStyle3Model> getAllItemList(){
        ArrayList<ProfileStyle3Model> allItems = new ArrayList<ProfileStyle3Model>();
        ProfileStyle3Model dt;

        dt = new ProfileStyle3Model("Michelle Hendley","San Fransisco, CA","profile/style-3/Profile-3-friend1.png");
        allItems.add(dt);
        dt = new ProfileStyle3Model("Kimberly White","Manhattan, NY","profile/style-3/Profile-3-friend2.png");
        allItems.add(dt);
        dt = new ProfileStyle3Model("Steve Roger","Booklyn, NY","profile/style-3/Profile-3-friend3.png");
        allItems.add(dt);
        dt = new ProfileStyle3Model("Amy Patterson","Little Indian, ABQ","profile/style-3/Profile-3-friend4.png");
        allItems.add(dt);
        dt = new ProfileStyle3Model("Hannah Paige","San Fransisco, CA","profile/style-3/Profile-3-friend5.png");
        allItems.add(dt);
        dt = new ProfileStyle3Model("Michelle Hendley","San Fransisco, CA","profile/style-3/Profile-3-friend1.png");
        allItems.add(dt);
        dt = new ProfileStyle3Model("Kimberly White","Manhattan, NY","profile/style-3/Profile-3-friend2.png");
        allItems.add(dt);
        dt = new ProfileStyle3Model("Steve Roger","Booklyn, NY","profile/style-3/Profile-3-friend3.png");
        allItems.add(dt);
        dt = new ProfileStyle3Model("Amy Patterson","Little Indian, ABQ","profile/style-3/Profile-3-friend4.png");
        allItems.add(dt);
        dt = new ProfileStyle3Model("Hannah Paige","San Fransisco, CA","profile/style-3/Profile-3-friend5.png");
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
            case R.id.btnFolow:
                Toast.makeText(this, "button follow me clicked!", Toast.LENGTH_SHORT).show();
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
        ProfileStyle3Model dt = rowListItem.get(position);
        Toast.makeText(this, dt.getName() + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
