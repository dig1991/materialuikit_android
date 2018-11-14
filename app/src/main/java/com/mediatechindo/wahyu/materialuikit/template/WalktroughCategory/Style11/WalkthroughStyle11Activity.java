package com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style11;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.tools.CustomViewPager;
import com.mediatechindo.wahyu.materialuikit.R;

public class WalkthroughStyle11Activity extends AppCompatActivity implements View.OnClickListener {
    private CustomViewPager viewPager;
    private View indicator1;
    private View indicator2;
    private View indicator3;
    private View indicator4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkthrough11_layout);

        indicator1 = findViewById(R.id.indicator1);
        indicator2 = findViewById(R.id.indicator2);
        indicator3 = findViewById(R.id.indicator3);
        indicator4 = findViewById(R.id.indicator4);

        viewPager = (CustomViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new WizardPageChangeListener());

        updateIndicators(0);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private int WIZARD_PAGES_COUNT = 4;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new WalkthroughStyle11Fragment(position);
        }

        @Override
        public int getCount() {
            return WIZARD_PAGES_COUNT;
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
            updateIndicators(position);
        }
    }

    public void updateIndicators(int position) {
        switch (position) {
            case 0:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                break;
            case 1:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                break;
            case 2:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                break;
            case 3:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot));
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignUp:
                Toast.makeText(this, "Button Sign up clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignIn:
                Toast.makeText(this, "Button sign in clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignFacebook:
                Toast.makeText(this, "Button sign up with facebook clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
