package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style10;

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

public class MenuNavigation10Activity extends AppCompatActivity {
    SlidingPaneLayout mSlidingPanel;
    ListView menuList;
    ArrayList<MenuNavigation10Model> menuData;
    MenuNavigation10Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation10_layout);

        mSlidingPanel = (SlidingPaneLayout) findViewById(R.id.SlidingPanel);
        mSlidingPanel.setPanelSlideListener(panelListener);
        mSlidingPanel.setParallaxDistance(100);
        mSlidingPanel.setSliderFadeColor(ContextCompat.getColor(this, android.R.color.transparent));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Menu");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_home);
        }
        final String[] menus = {"Feed", "Explore", "Activity", "Group", "Photos", "Videos", "Setting"};
        menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            MenuNavigation10Model menu = new MenuNavigation10Model();
            menu.setMenuName(menus[i]);
            if(i == 0){
                menu.setMenuNotificationCount(2);
            }
            menuData.add(menu);
        }

        menuList = (ListView) findViewById(R.id.menuList);
        adapter = new MenuNavigation10Adapter(this, menuData);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuNavigation10Activity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();
                mSlidingPanel.closePane();

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    MenuNavigation10Model menu = new MenuNavigation10Model();
                    menu.setMenuName(menus[j]);
                    if (j == 0) {
                        menu.setMenuNotificationCount(12);
                    }
                    if(j == i) {
                        menu.setSelected(true);
                    }
                    menuData.add(menu);
                    adapter.notifyDataSetChanged();
                }
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
