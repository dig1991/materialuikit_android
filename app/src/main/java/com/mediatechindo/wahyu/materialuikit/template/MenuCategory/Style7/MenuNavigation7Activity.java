package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style7;

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
import android.view.ViewTreeObserver;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

public class MenuNavigation7Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "testing";
    MenuNavigation7Adapter listAdapter;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation7_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Menu");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MenuNavigation7Activity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final String[] mGroups = {
                "Stories",
                "Feed",
                "Messages",
                "Profile"
        };

        final String[][] mChilds = {
                {"Popular", "Recent", "Favourite"},
                {"Sub Menu 1", "Sub Menu 2"},
                {"Sub Menu 1", "Sub Menu 2"},
                {}
        };

        NavigationView navigationViewLeft = (NavigationView) findViewById(R.id.nav_view);

        int width = getResources().getDisplayMetrics().widthPixels;
        DrawerLayout.LayoutParams params = (android.support.v4.widget.DrawerLayout.LayoutParams) navigationViewLeft.getLayoutParams();
        params.width = width;
        navigationViewLeft.setLayoutParams(params);

        expListView = (ExpandableListView) findViewById(R.id.menuExpandable);
        listAdapter = new MenuNavigation7Adapter(this, mGroups, mChilds);
        expListView.setAdapter(listAdapter);
        expListView.expandGroup(0);


        ViewTreeObserver vto = expListView.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                expListView.setIndicatorBounds(expListView.getRight()- 100, expListView.getWidth());
            }
        });


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                Toast.makeText(MenuNavigation7Activity.this, "Menu "+mChilds[groupPosition][childPosition]+" clicked!", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                if(groupPosition > 2) {
                    Toast.makeText(MenuNavigation7Activity.this, "Menu " + mGroups[groupPosition] + " clicked!", Toast.LENGTH_SHORT).show();
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });

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
        switch (view.getId()) {
            case R.id.navmain_profile:
                setButtonSelected(view);
                Toast.makeText(this, "menu profile clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_messages:
                setButtonSelected(view);
                Toast.makeText(this, "menu messages clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_settings:
                setButtonSelected(view);
                Toast.makeText(this, "menu settings clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_group:
                setButtonSelected(view);
                Toast.makeText(this, "menu group clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_photos:
                setButtonSelected(view);
                Toast.makeText(this, "menu photos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_videos:
                setButtonSelected(view);
                Toast.makeText(this, "menu videos clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navmain_logout:
                setButtonSelected(view);
                Toast.makeText(this, "menu logout clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void setButtonSelected(final View v) {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.menuContainer);
        for (int index = 0; index < (viewGroup).getChildCount(); ++index) {
            View nextChild = (viewGroup).getChildAt(index);
            nextChild.setBackground(ContextCompat.getDrawable(MenuNavigation7Activity.this, R.drawable.menunavigation4_buttonmenu));
        }

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                v.setBackgroundColor(ContextCompat.getColor(MenuNavigation7Activity.this, R.color.menuNavigation4menuSelected));
            }
        }, 200);
    }
}
