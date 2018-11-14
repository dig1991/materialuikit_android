package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style9;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

public class MenuNavigation9Activity extends AppCompatActivity implements View.OnClickListener{
    SlidingPaneLayout mSlidingPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation9_layout);

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
                setButtonSelected(view);
                Toast.makeText(this, "Button dashboard clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                setButtonSelected(view);
                Toast.makeText(this, "Button explore clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                setButtonSelected(view);
                Toast.makeText(this, "Button profile clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                setButtonSelected(view);
                Toast.makeText(this, "Button messages clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                setButtonSelected(view);
                Toast.makeText(this, "Button setting clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnLogout:
                mSlidingPanel.closePane();
                Toast.makeText(this, "Button logout clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void setButtonSelected(final View v){
        mSlidingPanel.closePane();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.menuContainer);
        for(int index = 0; index<(viewGroup).getChildCount(); ++index) {
            View nextChild = (viewGroup).getChildAt(index);
            nextChild.setBackgroundColor(ContextCompat.getColor(MenuNavigation9Activity.this, android.R.color.transparent));
        }

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                v.setBackground(ContextCompat.getDrawable(MenuNavigation9Activity.this, R.drawable.menunavigation9_menu_selected_bg));
            }
        }, 1000);
    }
}
