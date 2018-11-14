package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style15;

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

public class ActivityStyle15Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity15_layout);

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

        String userUrl1 = BuildConfig.IMAGE_URL + "activity/style-4/Activity-4-profpic-1.jpg";
        String userUrl2 = BuildConfig.IMAGE_URL + "activity/style-4/Activity-4-profpic-2.jpg";

        ImageView imgProfile1 = (ImageView) findViewById(R.id.imgProfile1);
        ImageView imgProfile2 = (ImageView) findViewById(R.id.imgProfile2);
        ImageView imgProfile3 = (ImageView) findViewById(R.id.imgProfile3);
        ImageView imgProfile4 = (ImageView) findViewById(R.id.imgProfile4);
        loadImageSquareRequest(imgProfile1, userUrl1);
        loadImageSquareRequest(imgProfile2, userUrl1);
        loadImageSquareRequest(imgProfile3, userUrl2);
        loadImageSquareRequest(imgProfile4, userUrl1);

        ImageView img1 = (ImageView) findViewById(R.id.image1);
        ImageView img2 = (ImageView) findViewById(R.id.image2);
        String urlPost = BuildConfig.IMAGE_URL + "activity/style-15/Activity-15-img-1.jpg";
        String urlPost2 = BuildConfig.IMAGE_URL + "activity/style-15/Activity-15-img-2.jpg";

        loadImageRequest(img1, urlPost);
        loadImageRequest(img2, urlPost2);

        String friend1Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend1.png";
        String friend2Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend2.png";
        String friend3Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend3.png";

        ImageView friend1 = (ImageView) findViewById(R.id.friend1);
        ImageView friend2 = (ImageView) findViewById(R.id.friend2);
        ImageView friend3 = (ImageView) findViewById(R.id.friend3);

        loadImageCircleRequest(friend1, friend1Url);
        loadImageCircleRequest(friend2, friend2Url);
        loadImageCircleRequest(friend3, friend3Url);

        TextView status = (TextView)findViewById(R.id.textName1);

        Spannable word = new SpannableString("Christina");
        word.setSpan(new StyleSpan(Typeface.BOLD), 0, word.length(), 0);
        status.setText(word);

        Spannable wordTwo = new SpannableString(" Posted");
        status.append(wordTwo);

        TextView status2 = (TextView)findViewById(R.id.textName2);

        word = new SpannableString("Gabrielle Madelaine");
        word.setSpan(new StyleSpan(Typeface.BOLD), 0, word.length(), 0);
        status2.setText(word);

        wordTwo = new SpannableString(" Liked a Post");
        status2.append(wordTwo);

        TextView status3 = (TextView)findViewById(R.id.textName3);

        word = new SpannableString("Christopher Nolan");
        word.setSpan(new StyleSpan(Typeface.BOLD), 0, word.length(), 0);
        status3.setText(word);

        wordTwo = new SpannableString(" Added 3 friends");
        status3.append(wordTwo);

        TextView status4 = (TextView)findViewById(R.id.textName4);

        word = new SpannableString("Christina");
        word.setSpan(new StyleSpan(Typeface.BOLD), 0, word.length(), 0);
        status4.setText(word);

        wordTwo = new SpannableString(" Posted");
        status4.append(wordTwo);
    }

    private void loadImageSquareRequest(ImageView img, String url){
        Glide.with(this)
                .load(url)
                .into(img);
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
            case R.id.buttonLike1:
                Toast.makeText(this, "button like clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonLike2:
                Toast.makeText(this, "button like clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonLike3:
                Toast.makeText(this, "button like clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonLike4:
                Toast.makeText(this, "button like clicked!", Toast.LENGTH_SHORT).show();
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
