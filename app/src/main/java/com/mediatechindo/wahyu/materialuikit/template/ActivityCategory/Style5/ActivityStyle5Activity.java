package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style5;

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

public class ActivityStyle5Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5_layout);

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



        String user1 = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend2.png";
        String user2 = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend3.png";
        ImageView imgProfile1 = (ImageView) findViewById(R.id.imgProfile1);
        ImageView imgProfile2 = (ImageView) findViewById(R.id.imgProfile2);
        ImageView imgProfile3 = (ImageView) findViewById(R.id.imgProfile3);
        ImageView imgProfile4 = (ImageView) findViewById(R.id.imgProfile4);
        ImageView imgProfile5 = (ImageView) findViewById(R.id.imgProfile5);
        ImageView imgProfile6 = (ImageView) findViewById(R.id.imgProfile6);
        ImageView imgProfile7 = (ImageView) findViewById(R.id.imgProfile7);
        ImageView imgProfile8 = (ImageView) findViewById(R.id.imgProfile8);
        loadImageCircleRequest(imgProfile1, user1);
        loadImageCircleRequest(imgProfile2, user1);
        loadImageCircleRequest(imgProfile3, user1);
        loadImageCircleRequest(imgProfile4, user2);
        loadImageCircleRequest(imgProfile5, user2);
        loadImageCircleRequest(imgProfile6, user1);
        loadImageCircleRequest(imgProfile7, user1);
        loadImageCircleRequest(imgProfile8, user1);


        // text 1
        TextView status = (TextView)findViewById(R.id.textDescription1);
        TextView status6 = (TextView)findViewById(R.id.textDescription6);

        Spannable word = new SpannableString("Gabriella Madelaine");
        word.setSpan(new StyleSpan(Typeface.BOLD), 0, word.length(), 0);
        status.setText(word);
        status6.setText(word);

        Spannable wordTwo = new SpannableString(" liked");
        status.append(wordTwo);
        status6.append(wordTwo);

        Spannable wordThree = new SpannableString(" How to be A Hipster");
        wordThree.setSpan(new StyleSpan(Typeface.BOLD), 0, wordThree.length(), 0);
        wordThree.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.activity5fontBlue)), 0, wordThree.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        status.append(wordThree);
        status6.append(wordThree);

        // text 2
        TextView status2 = (TextView)findViewById(R.id.textDescription2);
        TextView status7 = (TextView)findViewById(R.id.textDescription7);

        Spannable word2 = new SpannableString("Gabriella Madelaine");
        word2.setSpan(new StyleSpan(Typeface.BOLD), 0, word2.length(), 0);
        status2.setText(word2);
        status7.setText(word2);

        Spannable wordTwo2 = new SpannableString(" commented");
        status2.append(wordTwo2);
        status7.append(wordTwo2);

        Spannable wordThree2 = new SpannableString(" How to be A Hipster");
        wordThree2.setSpan(new StyleSpan(Typeface.BOLD), 0, wordThree2.length(), 0);
        wordThree2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.activity5fontBlue)), 0, wordThree2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        status2.append(wordThree2);
        status7.append(wordThree2);

        // text 3
        TextView status3 = (TextView)findViewById(R.id.textDescription3);
        TextView status8 = (TextView)findViewById(R.id.textDescription8);

        Spannable word3 = new SpannableString("Gabriella Madelaine");
        word3.setSpan(new StyleSpan(Typeface.BOLD), 0, word3.length(), 0);
        status3.setText(word3);
        status8.setText(word3);

        Spannable wordTwo3 = new SpannableString(" is now following you");
        status3.append(wordTwo3);
        status8.append(wordTwo3);

        // text 4
        TextView status4 = (TextView)findViewById(R.id.textDescription4);

        Spannable word4 = new SpannableString("Tony Ramirez");
        word4.setSpan(new StyleSpan(Typeface.BOLD), 0, word4.length(), 0);
        status4.setText(word4);

        Spannable wordTwo4 = new SpannableString(" added 3 new friends");
        status4.append(wordTwo4);

        // text 5
        TextView status5 = (TextView)findViewById(R.id.textDescription5);

        Spannable word5 = new SpannableString("Tomy Ramirez");
        word5.setSpan(new StyleSpan(Typeface.BOLD), 0, word5.length(), 0);
        status5.setText(word5);

        Spannable wordTwo5 = new SpannableString(" liked");
        status5.append(wordTwo5);

        Spannable wordThree5 = new SpannableString(" Introduction to UX design");
        wordThree5.setSpan(new StyleSpan(Typeface.BOLD), 0, wordThree5.length(), 0);
        wordThree5.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.activity5fontYellow)), 0, wordThree5.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        status5.append(wordThree5);

        String friend1Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend1.png";
        String friend2Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend2.png";
        String friend3Url = BuildConfig.IMAGE_URL + "profile/style-3/Profile-3-friend3.png";

        ImageView friend1 = (ImageView) findViewById(R.id.friend1);
        ImageView friend2 = (ImageView) findViewById(R.id.friend2);
        ImageView friend3 = (ImageView) findViewById(R.id.friend3);

        loadImageCircleRequest(friend1, friend1Url);
        loadImageCircleRequest(friend2, friend2Url);
        loadImageCircleRequest(friend3, friend3Url);

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
