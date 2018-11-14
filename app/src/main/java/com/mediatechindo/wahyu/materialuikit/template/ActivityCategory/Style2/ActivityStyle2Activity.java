package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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

public class ActivityStyle2Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_layout);

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

        TextView status = (TextView)findViewById(R.id.textDescription);

        Spannable word = new SpannableString("Gabriella Madelaine");
        word.setSpan(new StyleSpan(Typeface.BOLD), 0, word.length(), 0);
        status.setText(word);

        Spannable wordTwo = new SpannableString(" Posted a Photo");
        wordTwo.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.activity2fontGray)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        status.append(wordTwo);

        ImageView img1 = (ImageView) findViewById(R.id.image1);
        String urlPost = BuildConfig.IMAGE_URL + "activity/style-2/Activity-2-img.jpg";

        loadImageRequest(img1, urlPost);

        String friend1Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend1.png";
        String friend2Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend2.png";
        String friend3Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend3.png";

        ImageView imgProfile1 = (ImageView) findViewById(R.id.imgProfile1);
        ImageView imgProfile2 = (ImageView) findViewById(R.id.imgProfile2);
        ImageView imgProfile3 = (ImageView) findViewById(R.id.imgProfile3);
        ImageView friend1 = (ImageView) findViewById(R.id.friend1);
        ImageView friend2 = (ImageView) findViewById(R.id.friend2);
        ImageView friend3 = (ImageView) findViewById(R.id.friend3);

        loadImageCircleRequest(friend1, friend1Url);
        loadImageCircleRequest(friend2, friend2Url);
        loadImageCircleRequest(friend3, friend3Url);
        loadImageCircleRequest(imgProfile1, friend2Url);
        loadImageCircleRequest(imgProfile2, friend2Url);
        loadImageCircleRequest(imgProfile3, friend2Url);

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
        getMenuInflater().inflate(R.menu.activity3_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(this, "action edit clicked!", Toast.LENGTH_SHORT).show();
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
            case R.id.btnLoginSignupBack:
                onBackPressed();
                break;
            case R.id.buttonEdit:
                Toast.makeText(this, "button edit clicked!", Toast.LENGTH_SHORT).show();
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
