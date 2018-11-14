package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style11;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;
import com.mediatechindo.wahyu.materialuikit.R;

public class ActivityStyle11Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity11_layout);

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

        ImageView img1 = (ImageView) findViewById(R.id.image1);
        String urlPost = BuildConfig.IMAGE_URL + "activity/style-11/Activity-11-img.jpg";
        loadImageRequest(img1, urlPost);

        String friend1Url = BuildConfig.IMAGE_URL + "activity/style-4/Activity-4-profpic-1.jpg";
        String friend2Url = BuildConfig.IMAGE_URL + "activity/style-4/Activity-4-profpic-2.jpg";
        ImageView imgProfile1 = (ImageView) findViewById(R.id.imgProfile1);
        ImageView imgProfile2 = (ImageView) findViewById(R.id.imgProfile2);
        ImageView imgProfile3 = (ImageView) findViewById(R.id.imgProfile3);
        loadImageCircleRequest(imgProfile1, friend1Url);
        loadImageCircleRequest(imgProfile2, friend2Url);
        loadImageCircleRequest(imgProfile3, friend1Url);


        TextView status1 = (TextView)findViewById(R.id.textName1);
        TextView status3 = (TextView)findViewById(R.id.textName3);

        Spannable word1 = new SpannableString("Christina");
        word1.setSpan(new StyleSpan(Typeface.BOLD), 0, word1.length(), 0);
        status1.setText(word1);
        status3.setText(word1);

        Spannable wordTwo1 = new SpannableString(" Posted");
        status1.append(wordTwo1);
        status3.append(wordTwo1);

        TextView status2 = (TextView)findViewById(R.id.textName2);

        Spannable word2 = new SpannableString("Tony Ramirez");
        word2.setSpan(new StyleSpan(Typeface.BOLD), 0, word2.length(), 0);
        status2.setText(word2);

        Spannable wordTwo2 = new SpannableString(" Posted");
        status2.append(wordTwo2);

    }

    private void loadImageCircleRequest(ImageView img, String url){
        Glide.with(this)
                .load(url)
                .transform(new ImageViewCircleTransform(this))
                .into(img);
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .crossFade()
                .into(bg);
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
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }
}
