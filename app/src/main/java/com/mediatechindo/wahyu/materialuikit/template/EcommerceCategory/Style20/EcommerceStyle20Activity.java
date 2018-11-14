package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style20;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class EcommerceStyle20Activity extends AppCompatActivity implements View.OnClickListener, EcommerceStyle20ClickListener{
    private TextView button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce20_layout);

        setupToolbar();

        button1 = (TextView) findViewById(R.id.button1);
        button2 = (TextView) findViewById(R.id.button2);
        button3 = (TextView) findViewById(R.id.button3);
        button4 = (TextView) findViewById(R.id.button4);
        button5 = (TextView) findViewById(R.id.button5);

        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar);
        rangeSeekbar.setLeftThumbDrawable(ContextCompat.getDrawable(this, R.mipmap.ic_dot_yellow));
        rangeSeekbar.setLeftThumbHighlightDrawable(ContextCompat.getDrawable(this, R.mipmap.ic_dot_yellow));
        rangeSeekbar.setRightThumbDrawable(ContextCompat.getDrawable(this, R.mipmap.ic_dot_yellow));
        rangeSeekbar.setRightThumbHighlightDrawable(ContextCompat.getDrawable(this, R.mipmap.ic_dot_yellow));
        final TextView tvMin = (TextView) findViewById(R.id.textMin);
        final TextView tvMax = (TextView) findViewById(R.id.textMax);

        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText("$" + String.valueOf(minValue));
                tvMax.setText("$" + String.valueOf(maxValue));
            }
        });

        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
//                Toast.makeText(EcommerceStyle20Activity.this, String.valueOf(minValue) + " : " + String.valueOf(maxValue), Toast.LENGTH_SHORT).show();
            }
        });


        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView rView1 = (RecyclerView) findViewById(R.id.recyclerViewColor);
        rView1.setLayoutManager(layoutManager1);
        rView1.setNestedScrollingEnabled(false);
        rView1.setHasFixedSize(false);

        ArrayList<EcommerceStyle20Model> rowListItem = getAllItemList();
        EcommerceStyle20Adapter rcAdapter1 = new EcommerceStyle20Adapter(this, rowListItem);
        rView1.setAdapter(rcAdapter1);
        rcAdapter1.setClickListener(this);
    }

    private ArrayList<EcommerceStyle20Model> getAllItemList(){
        ArrayList<EcommerceStyle20Model> allItems = new ArrayList<EcommerceStyle20Model>();
        EcommerceStyle20Model dt;

        dt = new EcommerceStyle20Model(R.drawable.ecommerce20_color1);
        allItems.add(dt);
        dt = new EcommerceStyle20Model(R.drawable.ecommerce20_color2);
        allItems.add(dt);
        dt = new EcommerceStyle20Model(R.drawable.ecommerce20_color3);
        allItems.add(dt);
        dt = new EcommerceStyle20Model(R.drawable.ecommerce20_color4);
        allItems.add(dt);
        dt = new EcommerceStyle20Model(R.drawable.ecommerce20_color5);
        allItems.add(dt);
        dt = new EcommerceStyle20Model(R.drawable.ecommerce20_color6);
        allItems.add(dt);

        return  allItems;
    }

    private void setupToolbar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Filter");
        }
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
            case R.id.btnApplyFilter:
                Toast.makeText(this, "Button Apply Filter clicked!", Toast.LENGTH_SHORT).show();
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
        button1.setTextColor(ContextCompat.getColor(this, R.color.ecommerce20fontSize));
        button2.setTextColor(ContextCompat.getColor(this, R.color.ecommerce20fontSize));
        button3.setTextColor(ContextCompat.getColor(this, R.color.ecommerce20fontSize));
        button4.setTextColor(ContextCompat.getColor(this, R.color.ecommerce20fontSize));
        button5.setTextColor(ContextCompat.getColor(this, R.color.ecommerce20fontSize));

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
