package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style2;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class NewsStyle2Activity extends AppCompatActivity {
    SlidingPaneLayout mSlidingPanel;
    ListView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news2_layout);

        mSlidingPanel = (SlidingPaneLayout) findViewById(R.id.SlidingPanel);
        mSlidingPanel.setPanelSlideListener(panelListener);
        mSlidingPanel.setParallaxDistance(100);
        mSlidingPanel.setSliderFadeColor(ContextCompat.getColor(this, android.R.color.transparent));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("News");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_home);
        }

        final String[] menus = {"Explore", "Heaqdline News", "Read Later", "Videos", "Photos", "Setting", "Logout"};
        ArrayList<NewsStyle2Model> menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            NewsStyle2Model menu = new NewsStyle2Model();
            menu.setMenuName(menus[i]);
            if(i == 2){
                menu.setMenuNotificationCount(2);
            }
            menuData.add(menu);
        }
        menuList = (ListView) findViewById(R.id.menuList);
        menuList.setAdapter(new NewsStyle2Adapter(this, menuData));
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(NewsStyle2Activity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();
                mSlidingPanel.closePane();
            }
        });
    }

    SlidingPaneLayout.PanelSlideListener panelListener = new SlidingPaneLayout.PanelSlideListener(){

        @Override
        public void onPanelClosed(View arg0) {
            // TODO Auto-genxxerated method stub

        }

        @Override
        public void onPanelOpened(View arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPanelSlide(View arg0, float arg1) {
            // TODO Auto-generated method stub

        }

    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(mSlidingPanel.isOpen()){
                    mSlidingPanel.closePane();
                }else{
                    mSlidingPanel.openPane();
                }
                break;
            default:
                break;
        }
        return true;
    }

}
