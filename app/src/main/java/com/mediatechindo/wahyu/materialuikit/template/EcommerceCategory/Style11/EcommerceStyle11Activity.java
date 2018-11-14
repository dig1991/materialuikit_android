package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style11;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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

public class EcommerceStyle11Activity extends AppCompatActivity implements View.OnClickListener{
    private int descMaxline = 3;
    private TextView description,button1,button2,button3,button4,button5;
    private ImageView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce11_layout);

        setupToolbar();

        description = (TextView) findViewById(R.id.description);

        button1 = (TextView) findViewById(R.id.button1);
        button2 = (TextView) findViewById(R.id.button2);
        button3 = (TextView) findViewById(R.id.button3);
        button4 = (TextView) findViewById(R.id.button4);
        button5 = (TextView) findViewById(R.id.button5);

        String url = BuildConfig.IMAGE_URL + "ecommerce/style-11/Ecommerce-11.jpg";
        loadImageRequest((ImageView) findViewById(R.id.imageMain), url);

        more = (ImageView) findViewById(R.id.buttonMore);
        more.setOnClickListener(this);
        (findViewById(R.id.descriptionTitle)).setOnClickListener(this);
    }

    private void setupToolbar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Ecommerce");
        }
    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .crossFade()
                .thumbnail(0.01f)
                .fitCenter()
                .into(bg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ecommerce1_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_shopping_cart:
                Toast.makeText(this, "action shopping cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddToWishlist:
                Toast.makeText(this, "Button add to wishlist clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAddToChart:
                Toast.makeText(this, "Button add to cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonMore:
                actionDescriptionExpand();
                break;
            case R.id.descriptionTitle:
                actionDescriptionExpand();
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

    private void actionDescriptionExpand(){
        if(descMaxline==3){
            descMaxline = 100;
            more.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_expand_less));
        }else{
            descMaxline = 3;
            more.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_expand_more));
        }
        description.setMaxLines(descMaxline);
    }

    private void setSize(View btnClick){
        button1.setBackgroundColor(Color.TRANSPARENT);
        button2.setBackgroundColor(Color.TRANSPARENT);
        button3.setBackgroundColor(Color.TRANSPARENT);
        button4.setBackgroundColor(Color.TRANSPARENT);
        button5.setBackgroundColor(Color.TRANSPARENT);
        button1.setTextColor(ContextCompat.getColor(this, R.color.ecommerce11fontSize));
        button2.setTextColor(ContextCompat.getColor(this, R.color.ecommerce11fontSize));
        button3.setTextColor(ContextCompat.getColor(this, R.color.ecommerce11fontSize));
        button4.setTextColor(ContextCompat.getColor(this, R.color.ecommerce11fontSize));
        button5.setTextColor(ContextCompat.getColor(this, R.color.ecommerce11fontSize));

        btnClick.setBackground(ContextCompat.getDrawable(this,R.drawable.ecommerce11_selected_bg));
        TextView textActive = (TextView) btnClick;
        textActive.setTextColor(Color.WHITE);
    }
}
