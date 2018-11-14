package com.mediatechindo.wahyu.materialuikit;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.ActivityCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.ContentCategory.ContentCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.EcommerceCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.ExtraDesignCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.GalleryCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.LoginSignupCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.MenuCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.MusicCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.NewsCategory.NewsCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.ProfileCategoryFragment;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.WalkthroughCategoryFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SlidingPaneLayout mSlidingPanel;
    private String titleBar = "";
    ListView menuList;
    ArrayList<MainMenuModel> menuData;
    MainMenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(getString(R.string.app_name));
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_home);
        }

        mSlidingPanel = (SlidingPaneLayout) findViewById(R.id.SlidingPanel);
        mSlidingPanel.setPanelSlideListener(panelListener);
        mSlidingPanel.setParallaxDistance(100);
        mSlidingPanel.setSliderFadeColor(ContextCompat.getColor(this, android.R.color.transparent));

        Fragment mHome = new MainFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.main_layout_cont, mHome);
        ft.commit();



        final String[] menus = {"Login & SignUp", "Menu", "Profile", "Wizard / Walkthrough", "Activity", "Gallery", "Ecommerce", "Extra Design", "Music", "News", "Content"};
        final int[] count = {25, 20, 30, 20, 30, 25, 30, 14, 14, 7, 5};
        menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            MainMenuModel menu = new MainMenuModel();
            menu.setMenuName(menus[i]);
            menu.setMenuNotificationCount(count[i]);
            menuData.add(menu);
        }

        menuList = (ListView) findViewById(R.id.menuList);
        adapter = new MainMenuAdapter(this, menuData);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    MainMenuModel menu = new MainMenuModel();
                    menu.setMenuName(menus[j]);
                    menu.setMenuNotificationCount(count[j]);

                    if(i == j) {
                        menu.setSelected(true);
                        actionMainMenu(i);
                    }

                    menuData.add(menu);
                }
                adapter.notifyDataSetChanged();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        mSlidingPanel.closePane();
                    }
                }, 200);
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
    public void onBackPressed() {
        if(mSlidingPanel.isOpen()){
            mSlidingPanel.closePane();
        }else{
            super.onBackPressed();
        }
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
            default:
                break;
        }
        return true;
    }

    private void actionMainMenu(int id){
        switch (id){
            case 0 :
                titleBar = "LOGIN & SIGNUP";
                Fragment mLogin = new LoginSignupCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mLogin)
                        .commit();

                break;
            case 1 :
                titleBar = "MENU";
                Fragment mMenu = new MenuCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mMenu)
                        .commit();
                break;
            case 2 :
                titleBar = "PROFILE";
                Fragment mProfile = new ProfileCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mProfile)
                        .commit();
                break;
            case 3 :
                titleBar = "WALKTHROUGH";
                Fragment mWizard = new WalkthroughCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mWizard)
                        .commit();
                break;
            case 4 :
                titleBar = "ACTIVITY";
                Fragment mActivity = new ActivityCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mActivity)
                        .commit();
                break;
            case 5 :
                titleBar = "GALLERY";
                Fragment mGallery = new GalleryCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mGallery)
                        .commit();
                break;
            case 6 :
                titleBar = "ECOMMERCE";
                Fragment mEcommerce = new EcommerceCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mEcommerce)
                        .commit();
                break;
            case 7 :
                titleBar = "EXTRA DESIGN";
                Fragment mExtra = new ExtraDesignCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mExtra)
                        .commit();
                break;
            case 8 :
                titleBar = "MUSIC";
                Fragment mMusic = new MusicCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mMusic)
                        .commit();
                break;
            case 9 :
                titleBar = "NEWS";
                Fragment mNews = new NewsCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mNews)
                        .commit();
                break;
            case 10 :
                titleBar = "CONTENT";
                Fragment mContent = new ContentCategoryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout_cont, mContent)
                        .commit();
                break;
            default:
                break;
        }

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle(titleBar);
    }

}
