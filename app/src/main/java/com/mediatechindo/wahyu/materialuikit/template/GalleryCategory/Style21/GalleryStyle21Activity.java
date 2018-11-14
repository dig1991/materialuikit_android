package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style21;

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

public class GalleryStyle21Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery21_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Cinnamons");
        }

        ImageView img1 = (ImageView) findViewById(R.id.image1);
        ImageView img2 = (ImageView) findViewById(R.id.image2);
        ImageView img3 = (ImageView) findViewById(R.id.image3);
        ImageView img4 = (ImageView) findViewById(R.id.image4);
        String url = BuildConfig.IMAGE_URL + "gallery/style-21/Gallery-21-img-1.png";
        String url2 = BuildConfig.IMAGE_URL + "gallery/style-21/Gallery-21-img-2.png";
        String url3 = BuildConfig.IMAGE_URL + "gallery/style-21/Gallery-21-img-3.png";
        loadImageRequest(img1, url);
        loadImageRequest(img2, url2);
        loadImageRequest(img3, url3);
        loadImageRequest(img4, url);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);

    }

    private void loadImageRequest(ImageView bg, String url) {
        Glide.with(this)
                .load(url)
                .crossFade()
                .fitCenter()
                .thumbnail(0.01f)
                .into(bg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity28_menu, menu);
        return true;
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
            case R.id.image1:
                Toast.makeText(this, "Image 1 clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image2:
                Toast.makeText(this, "Image 2 clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image3:
                Toast.makeText(this, "Image 3 clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image4:
                Toast.makeText(this, "Image 4 clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
