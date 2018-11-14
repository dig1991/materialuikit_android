package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style23;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle23Activity extends AppCompatActivity implements View.OnClickListener, EcommerceStyle23ClickListener {
    private TextView numItem,button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce23_layout);

        setupToolbar();

        numItem = (TextView) findViewById(R.id.numItem);

        button1 = (TextView) findViewById(R.id.button1);
        button2 = (TextView) findViewById(R.id.button2);
        button3 = (TextView) findViewById(R.id.button3);
        button4 = (TextView) findViewById(R.id.button4);
        button5 = (TextView) findViewById(R.id.button5);

        String url = BuildConfig.IMAGE_URL + "ecommerce/style-21/Ecommerce-21-img-1.jpg";
        ImageView img = (ImageView) findViewById(R.id.imgProduct);
        loadImageRequest(img, url);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView rView1 = (RecyclerView) findViewById(R.id.recyclerViewColor);
        rView1.setLayoutManager(layoutManager1);
        rView1.setNestedScrollingEnabled(false);
        rView1.setHasFixedSize(false);

        ArrayList<EcommerceStyle23Model> rowListItem = getAllItemList();
        EcommerceStyle23Adapter rcAdapter1 = new EcommerceStyle23Adapter(this, rowListItem);
        rView1.setAdapter(rcAdapter1);
        rcAdapter1.setClickListener(this);
    }

    private void loadImageRequest(ImageView img, String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .into(img);
    }

    private ArrayList<EcommerceStyle23Model> getAllItemList(){
        ArrayList<EcommerceStyle23Model> allItems = new ArrayList<EcommerceStyle23Model>();
        EcommerceStyle23Model dt;

        dt = new EcommerceStyle23Model(R.drawable.ecommerce20_color1);
        allItems.add(dt);
        dt = new EcommerceStyle23Model(R.drawable.ecommerce20_color2);
        allItems.add(dt);
        dt = new EcommerceStyle23Model(R.drawable.ecommerce20_color3);
        allItems.add(dt);
        dt = new EcommerceStyle23Model(R.drawable.ecommerce20_color4);
        allItems.add(dt);
        dt = new EcommerceStyle23Model(R.drawable.ecommerce20_color5);
        allItems.add(dt);
        dt = new EcommerceStyle23Model(R.drawable.ecommerce20_color6);
        allItems.add(dt);

        return  allItems;
    }

    private void setupToolbar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Edit");
        }
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
            case R.id.btnApplyChanges:
                Toast.makeText(this, "Button Apply Changes clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonMinus:
                int num = Integer.parseInt(numItem.getText().toString());
                if(num > 1) {
                    num--;
                }
                numItem.setText(Integer.toString(num));
                break;
            case R.id.buttonPlus:
                int num2 = Integer.parseInt(numItem.getText().toString());
                num2++;
                numItem.setText(Integer.toString(num2));
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
        button1.setTextColor(ContextCompat.getColor(this, R.color.ecommerce23fontSize));
        button2.setTextColor(ContextCompat.getColor(this, R.color.ecommerce23fontSize));
        button3.setTextColor(ContextCompat.getColor(this, R.color.ecommerce23fontSize));
        button4.setTextColor(ContextCompat.getColor(this, R.color.ecommerce23fontSize));
        button5.setTextColor(ContextCompat.getColor(this, R.color.ecommerce23fontSize));

        btnClick.setBackground(ContextCompat.getDrawable(this,R.drawable.ecommerce11_selected_bg));
        TextView textActive = (TextView) btnClick;
        textActive.setTextColor(Color.WHITE);
    }

    @Override
    public void itemClicked(View view, int position) {
//        int num = position + 1;
//        Toast.makeText(this, "List 1 Position " + num, Toast.LENGTH_SHORT).show();
    }
}
