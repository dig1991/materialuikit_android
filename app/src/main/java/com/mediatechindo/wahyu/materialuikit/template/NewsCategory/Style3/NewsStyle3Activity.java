package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class NewsStyle3Activity extends AppCompatActivity implements View.OnClickListener, NewsStyle3ClickListener {
    private int numSelected = 6;
    private int totalMenuCount = 9;
    private TextView selectedInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news3_layout);

        selectedInfo = (TextView) findViewById(R.id.selectedInfo);

        //Top 40 albums
        GridLayoutManager lLayout1 = new GridLayoutManager(this, 3);

        ArrayList<NewsStyle3Model> rowListItem2 = getAllItemList2();
        NewsStyle3Adapter rcAdapter2 = new NewsStyle3Adapter(this, rowListItem2);

        RecyclerView rView2 = (RecyclerView) findViewById(R.id.recyclerView);
        rView2.setLayoutManager(lLayout1);
        rView2.setAdapter(rcAdapter2);
        rView2.setNestedScrollingEnabled(false);
        rcAdapter2.setClickListener(this);
    }

    private ArrayList<NewsStyle3Model> getAllItemList2(){
        ArrayList<NewsStyle3Model> allItems = new ArrayList<>();
        NewsStyle3Model dt;

        dt = new NewsStyle3Model("Lifestyle", "news/style-3/news3_item1.png", false);
        allItems.add(dt);
        dt = new NewsStyle3Model("Business", "news/style-3/news3_item2.png", true);
        allItems.add(dt);
        dt = new NewsStyle3Model("Politics", "news/style-3/news3_item3.png", false);
        allItems.add(dt);
        dt = new NewsStyle3Model("Entertainment", "news/style-3/news3_item4.png", false);
        allItems.add(dt);
        dt = new NewsStyle3Model("Culture & Religion", "news/style-3/news3_item5.png", false);
        allItems.add(dt);
        dt = new NewsStyle3Model("Technology", "news/style-3/news3_item6.png", true);
        allItems.add(dt);
        dt = new NewsStyle3Model("Social", "news/style-3/news3_item7.png", false);
        allItems.add(dt);
        dt = new NewsStyle3Model("Sport", "news/style-3/news3_item8.png", true);
        allItems.add(dt);
        dt = new NewsStyle3Model("Regional", "news/style-3/news3_item9.png", false);
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAudio:
                break;
            case R.id.buttonNext:
                Toast.makeText(this, "Button Next clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void itemClickedAdd() {
        numSelected++;
        setSelectedInfo();
    }

    @Override
    public void itemClickedRemove() {
        numSelected--;
        setSelectedInfo();
    }

    private void setSelectedInfo(){
        selectedInfo.setText(numSelected + " out of " + totalMenuCount + " selected");
    }
}
