package com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style15;

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

public class LoginSignupStyle15Activity extends AppCompatActivity implements View.OnClickListener{
    private static final String[] pageTitle = {"SIGN UP","SIGN IN"};
    View bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsignup15_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("");
        }
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_loginsignup15);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_loginsignup15);
        LoginSignup5Adapter adapter = new LoginSignup5Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);

        bg = findViewById(R.id.loginsignup15_layout);

        String url = BuildConfig.IMAGE_URL + "login-signup/style-15/Login-Register-15-960.jpg";

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
            fragments.add(new LoginSignupStyle15Fragment());
            fragments.add(new LoginSignupStyle15Fragment());
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
            case R.id.txtForgotPassword:
                Toast.makeText(this, "Forgot Password clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignIn:
                Toast.makeText(this, "Sign In button clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignUp:
                Toast.makeText(this, "Sign Up button clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignFacebook:
                Toast.makeText(this, "Sign In with Facebook clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
