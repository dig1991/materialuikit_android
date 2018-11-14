package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style13;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

public class GalleryStyle13Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery13_layout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Mountain Haze");
        }

        ImageView bg = (ImageView) findViewById(R.id.imageMain);
        String url = BuildConfig.IMAGE_URL + "gallery/style-12/Gallery-12-img-1.png";
        String urlThumb = BuildConfig.IMAGE_URL + "gallery/style-12/Gallery-12-img-1-thumb.png";
        loadImageRequest(bg, url, urlThumb);

    }

    private void loadImageRequest(ImageView bg, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(this)
                .load(urlThumb);

        Glide.with(this)
                .load(url)
                .crossFade()
                .thumbnail(thumbnailRequest)
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
            case R.id.buttonShare:
                Toast.makeText(this, "Button Share clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonEdit:
                Toast.makeText(this, "Button Edit clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDelete:
                Toast.makeText(this, "Button Delete clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
