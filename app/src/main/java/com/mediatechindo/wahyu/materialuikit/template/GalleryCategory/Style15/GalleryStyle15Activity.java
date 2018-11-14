package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style15;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.tools.NonSwipeableViewPager;
import com.mediatechindo.wahyu.materialuikit.R;

public class GalleryStyle15Activity extends AppCompatActivity implements View.OnClickListener{
    private static final String[] pageTitle = {"PHOTO","VIDEO","DOCUMENT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery15_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Gallery");
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_gallery14);
        NonSwipeableViewPager viewPager = (NonSwipeableViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new WizardPageChangeListener());
        tabLayout.setupWithViewPager(viewPager);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private int WIZARD_PAGES_COUNT = 3;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new GalleryStyle15Fragment(position);
        }

        @Override
        public int getCount() {
            return WIZARD_PAGES_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pageTitle[position];
        }
    }

    private class WizardPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int position) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int position) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity28_menu, menu);
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonShare:
                Toast.makeText(this, "Button Share clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonEdit:
                Toast.makeText(this, "Button Edit clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDelete:
                Toast.makeText(this, "Button Delete clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
