package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style4;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

public class MenuNavigation4Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation4_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Menu");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        int width = getResources().getDisplayMetrics().widthPixels;
        DrawerLayout.LayoutParams params = (android.support.v4.widget.DrawerLayout.LayoutParams) navigationView.getLayoutParams();
        params.width = width;
        navigationView.setLayoutParams(params);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menunavigation4_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.navmain_profile :
                setButtonSelected(view);
                Toast.makeText(this, "menu profile clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_messages :
                setButtonSelected(view);
                Toast.makeText(this, "menu messages clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_settings :
                setButtonSelected(view);
                Toast.makeText(this, "menu settings clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_group :
                setButtonSelected(view);
                Toast.makeText(this, "menu group clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_photos :
                setButtonSelected(view);
                Toast.makeText(this, "menu photos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_videos :
                setButtonSelected(view);
                Toast.makeText(this, "menu videos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_logout :
                setButtonSelected(view);
                Toast.makeText(this, "menu logout clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void setButtonSelected(final View v){
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.menuContainer);
        for(int index = 0; index<(viewGroup).getChildCount(); ++index) {
            View nextChild = (viewGroup).getChildAt(index);
            nextChild.setBackground(ContextCompat.getDrawable(MenuNavigation4Activity.this, R.drawable.menunavigation4_buttonmenu));
        }

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                v.setBackgroundColor(ContextCompat.getColor(MenuNavigation4Activity.this, R.color.menuNavigation4menuSelected));
            }
        }, 200);
    }
}
