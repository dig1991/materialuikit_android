package com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style6;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.List;

public class WalkthroughStyle6Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "WalkthroughStyle6";
    private ViewPager viewPager;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkthrough6_layout);

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

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new WizardPageChangeListener());
        viewPager.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.walkthrough6_viewpager_margin));
        viewPager.setOffscreenPageLimit(4);
    }

    public void setImageFragment1(ImageView image){
        img1 = image;
    }

    public void setImageFragment2(ImageView image){
        img2 = image;
    }

    public void setImageFragment3(ImageView image){
        img3 = image;
    }

    public void setImageFragment4(ImageView image){
        img4 = image;
    }

    private void loadImageActive(ImageView img) {
        String url = BuildConfig.IMAGE_URL + "walkthrough/style-6/Welcome-6.jpg";
        Glide.with(this)
                .load(url)
                .thumbnail(0.1f)
                .crossFade()
                .into(img);
    }

    private void loadImageNonActive(ImageView img) {
        String url = BuildConfig.IMAGE_URL + "walkthrough/style-6/Welcome-6-grey.png";
        Glide.with(this)
                .load(url)
                .thumbnail(0.1f)
                .crossFade()
                .into(img);
    }

    private void setImageVisible(int pos){
        if(img1 != null && img4 != null && img3 != null && img4 != null) {
            switch (pos) {
                case 0:
                    loadImageActive(img1);
                    loadImageNonActive(img2);
                    loadImageNonActive(img3);
                    loadImageNonActive(img4);
                    break;
                case 1:
                    loadImageNonActive(img1);
                    loadImageActive(img2);
                    loadImageNonActive(img3);
                    loadImageNonActive(img4);
                    break;
                case 2:
                    loadImageNonActive(img1);
                    loadImageNonActive(img2);
                    loadImageActive(img3);
                    loadImageNonActive(img4);
                    break;
                case 3:
                    loadImageNonActive(img1);
                    loadImageNonActive(img2);
                    loadImageNonActive(img3);
                    loadImageActive(img4);
                    break;
                default:
                    break;
            }
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fragments = new ArrayList<>();
            fragments.add(new WalkthroughStyle6Page1());
            fragments.add(new WalkthroughStyle6Page2());
            fragments.add(new WalkthroughStyle6Page3());
            fragments.add(new WalkthroughStyle6Page4());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
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
            Log.d(TAG, "onPageSelected: position = " + position);
            setImageVisible(position);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoginSignupBack:
                onBackPressed();
                break;
            case R.id.btnSignIn:
                Toast.makeText(this, "Button Sign In clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignUp:
                Toast.makeText(this, "Button Sign Up clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
