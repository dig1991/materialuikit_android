package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style17;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

public class GalleryStyle17Activity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private int pagePosition;
    private TextView textTitle, textPage;
    private CardView buttonPrev,buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery17_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        textTitle = (TextView) findViewById(R.id.textTitle);
        textPage = (TextView) findViewById(R.id.textPage);
        buttonPrev = (CardView) findViewById(R.id.buttonPrev);
        buttonNext = (CardView) findViewById(R.id.buttonNext);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new WizardPageChangeListener());
        pagePosition = 0;
        textPage.setText("1 of 5 Photos");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonPrev:
                viewPager.setCurrentItem(pagePosition - 1);
                break;
            case R.id.buttonNext:
                viewPager.setCurrentItem(pagePosition + 1);
                break;
            default:
                break;
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private int WIZARD_PAGES_COUNT = 5;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new GalleryStyle17Fragment(position);
        }

        @Override
        public int getCount() {
            return WIZARD_PAGES_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
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
            pagePosition = position;
            int page = position + 1;
            textPage.setText(page + " of 5 Photos");

            if(position == 0){
                buttonPrev.setCardBackgroundColor(ContextCompat.getColor(GalleryStyle17Activity.this, R.color.gallery17IconBgDisable));
                buttonNext.setCardBackgroundColor(ContextCompat.getColor(GalleryStyle17Activity.this, R.color.gallery17IconBg));
            }else if (position == 4){
                buttonPrev.setCardBackgroundColor(ContextCompat.getColor(GalleryStyle17Activity.this, R.color.gallery17IconBg));
                buttonNext.setCardBackgroundColor(ContextCompat.getColor(GalleryStyle17Activity.this, R.color.gallery17IconBgDisable));
            }else{
                buttonPrev.setCardBackgroundColor(ContextCompat.getColor(GalleryStyle17Activity.this, R.color.gallery17IconBg));
                buttonNext.setCardBackgroundColor(ContextCompat.getColor(GalleryStyle17Activity.this, R.color.gallery17IconBg));
            }

        }
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
            default:
                break;
        }
        return true;
    }

}
