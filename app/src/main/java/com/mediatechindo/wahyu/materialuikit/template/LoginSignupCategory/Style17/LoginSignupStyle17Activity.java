package com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style17;

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

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.List;

public class LoginSignupStyle17Activity extends AppCompatActivity implements View.OnClickListener{
    private static final String[] pageTitle = {"SIGN UP","SIGN IN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsignup17_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Welcome");
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_loginsignup17);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_loginsignup17);
        LoginSignup4Adapter adapter = new LoginSignup4Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
    }

    public class LoginSignup4Adapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public LoginSignup4Adapter(FragmentManager fm){
            super(fm);
            this.fragments = new ArrayList<>();
            fragments.add(new LoginSignupStyle17Fragment());
            fragments.add(new LoginSignupStyle17Fragment());
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
            case R.id.txtForgotPassword:
                Toast.makeText(this, "Forgot Password clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignIn:
                Toast.makeText(this, "Sign In button clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
