package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style18;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

public class EcommerceStyle18Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView button1,button2,button3,button4,button5;
    private ViewPager viewPager;
    private View indicator1;
    private View indicator2;
    private View indicator3;
    private View indicator4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce18_layout);

        setupToolbar();

        button1 = (TextView) findViewById(R.id.button1);
        button2 = (TextView) findViewById(R.id.button2);
        button3 = (TextView) findViewById(R.id.button3);
        button4 = (TextView) findViewById(R.id.button4);
        button5 = (TextView) findViewById(R.id.button5);

        indicator1 = findViewById(R.id.indicator1);
        indicator2 = findViewById(R.id.indicator2);
        indicator3 = findViewById(R.id.indicator3);
        indicator4 = findViewById(R.id.indicator4);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new WizardPageChangeListener());

        updateIndicators(0);

        String url = BuildConfig.IMAGE_URL + "ecommerce/style-18/Ecommerce-18-img-2.jpg";
        ImageView img = (ImageView) findViewById(R.id.imageRelated1);
        loadImageRequest(img, url);

        String url2 = BuildConfig.IMAGE_URL + "ecommerce/style-18/Ecommerce-18-img-3.jpg";
        ImageView img2 = (ImageView) findViewById(R.id.imageRelated2);
        loadImageRequest(img2, url2);
    }

    private void loadImageRequest(ImageView img, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .into(img);
    }

    private void setupToolbar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Ecommerce");
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private int WIZARD_PAGES_COUNT = 4;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new EcommerceStyle18Fragment(position);
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
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_yellow));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                break;
            case 1:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_yellow));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                break;
            case 2:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_yellow));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                break;
            case 3:
                indicator1.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator2.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator3.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_grey));
                indicator4.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_dot_yellow));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ecommerce15_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_search:
                Toast.makeText(this, "action search cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_shopping_cart:
                Toast.makeText(this, "action shopping cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "action setting cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnQuantity:
                Toast.makeText(this, "Button Quantity clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAddToWishlist:
                Toast.makeText(this, "Button Add to Wishlist clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAddToChart:
                Toast.makeText(this, "Button Add to Cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemRelated1:
                Toast.makeText(this, "Related Product 1 clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemRelated2:
                Toast.makeText(this, "Related Product 2 clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button1:
                setSize(view);
                break;
            case R.id.button2:
                setSize(view);
                break;
            case R.id.button3:
                setSize(view);
                break;
            case R.id.button4:
                setSize(view);
                break;
            case R.id.button5:
                setSize(view);
                break;
            default:
                break;
        }

    }

    private void setSize(View btnClick){
        button1.setBackground(ContextCompat.getDrawable(this,R.drawable.ecommerce15_color_bg));
        button2.setBackground(ContextCompat.getDrawable(this,R.drawable.ecommerce15_color_bg));
        button3.setBackground(ContextCompat.getDrawable(this,R.drawable.ecommerce15_color_bg));
        button4.setBackground(ContextCompat.getDrawable(this,R.drawable.ecommerce15_color_bg));
        button5.setBackground(ContextCompat.getDrawable(this,R.drawable.ecommerce15_color_bg));
        button1.setTextColor(ContextCompat.getColor(this, R.color.ecommerce18fontSize));
        button2.setTextColor(ContextCompat.getColor(this, R.color.ecommerce18fontSize));
        button3.setTextColor(ContextCompat.getColor(this, R.color.ecommerce18fontSize));
        button4.setTextColor(ContextCompat.getColor(this, R.color.ecommerce18fontSize));
        button5.setTextColor(ContextCompat.getColor(this, R.color.ecommerce18fontSize));

        btnClick.setBackground(ContextCompat.getDrawable(this,R.drawable.ecommerce11_selected_bg));
        TextView textActive = (TextView) btnClick;
        textActive.setTextColor(Color.WHITE);
    }
}
