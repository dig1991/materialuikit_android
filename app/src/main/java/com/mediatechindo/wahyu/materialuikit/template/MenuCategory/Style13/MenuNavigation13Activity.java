package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style13;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class MenuNavigation13Activity extends AppCompatActivity {
    SlidingPaneLayout mSlidingPanel;
    ListView menuList;
    ArrayList<MenuNavigation13Model> menuData;
    MenuNavigation13Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation13_layout);

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

        final String[] menus = {"Explore", "Messages", "Photos", "Videos", "Group", "Setting"};
        final int[] icon = {
                R.drawable.ic_explore,
                R.drawable.ic_messages,
                R.drawable.ic_photos,
                R.drawable.ic_videos,
                R.drawable.ic_group,
                R.drawable.ic_setting};
        menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            MenuNavigation13Model menu = new MenuNavigation13Model();
            menu.setMenuName(menus[i]);
            menu.setIconImage(icon[i]);
            if(i == 0){
                menu.setMenuNotificationNonActiveCount(32);
            }else if(i == 1){
                menu.setMenuNotificationCount(2);
            }
            menuData.add(menu);
        }

        menuList = (ListView) findViewById(R.id.menuList);
        adapter = new MenuNavigation13Adapter(this, menuData);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuNavigation13Activity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();
                mSlidingPanel.closePane();

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    MenuNavigation13Model menu = new MenuNavigation13Model();
                    menu.setMenuName(menus[j]);
                    menu.setIconImage(icon[j]);
                    if(j == 0){
                        menu.setMenuNotificationNonActiveCount(32);
                    }else if(j == 1){
                        menu.setMenuNotificationCount(2);
                    }

                    if(i == j) {
                        menu.setSelected(true);
                    }

                    menuData.add(menu);
                }
                adapter.notifyDataSetChanged();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menunavigation4_menu, menu);
        return true;
    }

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

}
