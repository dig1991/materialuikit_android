package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style15;

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

public class EcommerceStyle15Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce15_layout);

        setupToolbar();

        button1 = (TextView) findViewById(R.id.button1);
        button2 = (TextView) findViewById(R.id.button2);
        button3 = (TextView) findViewById(R.id.button3);
        button4 = (TextView) findViewById(R.id.button4);
        button5 = (TextView) findViewById(R.id.button5);

        String url = BuildConfig.IMAGE_URL + "ecommerce/style-15/Ecommerce-15.jpg";

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
            case R.id.btnAddToChart:
                Toast.makeText(this, "Button add to cart clicked!", Toast.LENGTH_SHORT).show();
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
        button1.setTextColor(ContextCompat.getColor(this, R.color.ecommerce15fontSize));
        button2.setTextColor(ContextCompat.getColor(this, R.color.ecommerce15fontSize));
        button3.setTextColor(ContextCompat.getColor(this, R.color.ecommerce15fontSize));
        button4.setTextColor(ContextCompat.getColor(this, R.color.ecommerce15fontSize));
        button5.setTextColor(ContextCompat.getColor(this, R.color.ecommerce15fontSize));

        btnClick.setBackground(ContextCompat.getDrawable(this,R.drawable.ecommerce11_selected_bg));
        TextView textActive = (TextView) btnClick;
        textActive.setTextColor(Color.WHITE);
    }
}
