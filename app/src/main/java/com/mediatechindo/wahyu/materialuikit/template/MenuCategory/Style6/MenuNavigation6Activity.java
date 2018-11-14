package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style6;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

public class MenuNavigation6Activity extends AppCompatActivity implements View.OnClickListener{
    SlidingPaneLayout mSlidingPanel;
    View bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation6_layout);

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

        bg = findViewById(R.id.imageMain);

        final String url = BuildConfig.IMAGE_URL + "menu-navigation/style-6/bg-image-Menu-6-960.jpg";

        Glide.with(this)
                .load(url)
                .thumbnail(0.01f)
                .centerCrop()
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        bg.setBackground(resource);
                    }
                });

        final String[] mGroups = {
                "Stories",
                "Feed",
                "Messages",
                "Profile"
        };

        final String[][] mChilds = {
                {"Popular","Recent","Favourite"},
                {},
                {},
                {}
        };

        ExpandableListView listMenu = (ExpandableListView) findViewById(R.id.menu_list);
        MenuNavigation6Adapter adapter = new MenuNavigation6Adapter(this, mGroups, mChilds);
        listMenu.setAdapter(adapter);
        listMenu.expandGroup(0);
        listMenu.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                Toast.makeText(MenuNavigation6Activity.this, "Menu "+mChilds[groupPosition][childPosition]+" clicked!", Toast.LENGTH_SHORT).show();
                mSlidingPanel.closePane();
                return false;
            }
        });

        listMenu.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                if(groupPosition > 0) {
                    Toast.makeText(MenuNavigation6Activity.this, "Menu " + mGroups[groupPosition] + " clicked!", Toast.LENGTH_SHORT).show();
                    mSlidingPanel.closePane();
                }
                return false;
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogout:
                Toast.makeText(this, "Button logout clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSetting:
                Toast.makeText(this, "Button setting clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
