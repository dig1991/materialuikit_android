package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style30;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.tools.CustomViewPager;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileStyle30Activity extends AppCompatActivity implements View.OnClickListener {
    private static final int[] iconActive = {R.drawable.ic_camera_active, R.drawable.ic_video_active, R.drawable.ic_group_black};
    private static final String[] pageNum = {"359","10,289","4,317"};
    private static final String[] pageTitle = {"Photos","Videos","Friends"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile30_layout);

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

        FloatingActionButton fbAdd = (FloatingActionButton) findViewById(R.id.buttonAdd);
        fbAdd.setOnClickListener(this);
        FloatingActionButton fbShare = (FloatingActionButton) findViewById(R.id.buttonShare);
        fbShare.setOnClickListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_profile1);
        CustomViewPager viewPager = (CustomViewPager) findViewById(R.id.viewpager_profile1);
        ProfileStyle1Adapter adapter = new ProfileStyle1Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        for(int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(getTitleTabView(iconActive[i], pageNum[i], pageTitle[i]));
        }
    }

    private View getTitleTabView(int icon, String numString, String titleString){
        View v = LayoutInflater.from(this).inflate(R.layout.profile30_tab_title, null);
        ImageView img = (ImageView) v.findViewById(R.id.imageIcon);
        img.setImageDrawable(ContextCompat.getDrawable(this, icon));
        TextView num = (TextView) v.findViewById(R.id.titleTabCount);
        TextView title = (TextView) v.findViewById(R.id.titleTabText);
        num.setText(numString);
        title.setText(titleString);
        return v;
    }

    public class ProfileStyle1Adapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public ProfileStyle1Adapter(FragmentManager fm){
            super(fm);
            this.fragments = new ArrayList<>();
            fragments.add(new ProfileStyle30Fragment());
            fragments.add(new ProfileStyle30Fragment());
            fragments.add(new ProfileStyle30Fragment());
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int arrayPos) {
            return pageTitle[arrayPos];
        }
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
            case R.id.buttonAdd:
                Toast.makeText(this, "button add clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonShare:
                Toast.makeText(this, "button share clicked!", Toast.LENGTH_SHORT).show();
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
