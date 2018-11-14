package com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style6;

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

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.List;

public class LoginSignupStyle6Activity extends AppCompatActivity implements View.OnClickListener{
    private static final String[] pageTitle = {"SIGN UP","SIGN IN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsignup6_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("");
        }
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_loginsignup6);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_loginsignup6);
        LoginSignup6Adapter adapter = new LoginSignup6Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public class LoginSignup6Adapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public LoginSignup6Adapter(FragmentManager fm){
            super(fm);
            this.fragments = new ArrayList<>();
            fragments.add(new LoginSignupStyle6Fragment());
            fragments.add(new LoginSignupStyle6Fragment());
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
