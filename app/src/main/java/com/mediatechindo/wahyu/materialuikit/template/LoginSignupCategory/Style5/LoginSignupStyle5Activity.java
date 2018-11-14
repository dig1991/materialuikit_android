package com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style5;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.List;

public class LoginSignupStyle5Activity extends AppCompatActivity implements View.OnClickListener{
    private static final String[] pageTitle = {"SIGN UP","SIGN IN"};
    View bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsignup5_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("");
        }
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_loginsignup5);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_loginsignup5);
        LoginSignup5Adapter adapter = new LoginSignup5Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        bg = findViewById(R.id.loginsignup5_layout);

        String url = BuildConfig.IMAGE_URL + "login-signup/style-5/Login-Register-5-960.jpg";

        Glide.with(this)
                .load(url)
                .override(480, 800)
                .thumbnail(0.01f)
                .centerCrop()
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        bg.setBackground(resource);
                    }
                });

    }

    public class LoginSignup5Adapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public LoginSignup5Adapter(FragmentManager fm){
            super(fm);
            this.fragments = new ArrayList<>();
            fragments.add(new LoginSignupStyle5Fragment());
            fragments.add(new LoginSignupStyle5Fragment());
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCreateAccount:
                Toast.makeText(this, "Create An Account button clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignFacebook:
                Toast.makeText(this, "Sign Up Facebook button clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtTermService:
                Toast.makeText(this, "Term of Service clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
