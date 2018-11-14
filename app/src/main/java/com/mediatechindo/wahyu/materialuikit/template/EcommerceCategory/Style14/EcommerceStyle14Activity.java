package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style14;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

public class EcommerceStyle14Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce14_layout);

        setupToolbar();

        String url = BuildConfig.IMAGE_URL + "ecommerce/style-14/Ecommerce-14.jpg";

        ImageView img = (ImageView) findViewById(R.id.imageMain);
        loadImageRequest(img, url);
    }

    private void setupToolbar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Ecommerce");
        }
    }

    private void loadImageRequest(ImageView img, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .into(img);
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
            case R.id.buttonLove:
                Toast.makeText(this, "Button Love clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSize:
                Toast.makeText(this, "Button Size clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnQuantity:
                Toast.makeText(this, "Button Quantity clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAddToChart:
                Toast.makeText(this, "Button Add to Chart clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

}
