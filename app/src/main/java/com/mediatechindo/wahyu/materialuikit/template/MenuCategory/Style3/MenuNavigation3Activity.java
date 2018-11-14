package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style3;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

public class MenuNavigation3Activity extends AppCompatActivity implements View.OnClickListener{
    SlidingPaneLayout mSlidingPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation3_layout);

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
            case R.id.button1:
                mSlidingPanel.closePane();
                Toast.makeText(this, "Button explore clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                mSlidingPanel.closePane();
                Toast.makeText(this, "Button timeline clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                mSlidingPanel.closePane();
                Toast.makeText(this, "Button photos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                mSlidingPanel.closePane();
                Toast.makeText(this, "Button videos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                mSlidingPanel.closePane();
                Toast.makeText(this, "Button messages clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnLogout:
                mSlidingPanel.closePane();
                Toast.makeText(this, "Button logout clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSetting:
                mSlidingPanel.closePane();
                Toast.makeText(this, "Button setting clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
