package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style7;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style3.ProfileStyle3ClickListener;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style3.ProfileStyle3Model;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class ProfileStyle7Activity extends AppCompatActivity implements View.OnClickListener, ProfileStyle3ClickListener {
    ArrayList<ProfileStyle3Model> rowListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile7_layout);

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

        String url1 = BuildConfig.IMAGE_URL + "profile/style-6/Profile-6-image1.jpg";
        String url2 = BuildConfig.IMAGE_URL + "profile/style-6/Profile-6-image2.jpg";

        Glide.with(this)
                .load(url1)
                .thumbnail(0.01f)
                .centerCrop()
                .into((ImageView) findViewById(R.id.imageMain));

        Glide.with(this)
                .load(url2)
                .thumbnail(0.01f)
                .centerCrop()
                .into((ImageView) findViewById(R.id.image2));
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
                Toast.makeText(this, "button follow clicked!", Toast.LENGTH_SHORT).show();
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
