package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style29;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class ActivityStyle29Activity extends AppCompatActivity implements View.OnClickListener, ActivityStyle29ClickListener {
    ArrayList<ActivityStyle29Model> rowListItem;
    ActivityStyle29Adapter rcAdapter;
    boolean isMenuShow = false;
    Fragment mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity29_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Remi Boucher");
        }
        mMenu = new ActivityStyle29Fragment();

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        rcAdapter = new ActivityStyle29Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);

    }

    private ArrayList<ActivityStyle29Model> getAllItemList() {
        ArrayList<ActivityStyle29Model> allItems = new ArrayList<>();
        ActivityStyle29Model dt;

        dt = new ActivityStyle29Model(false, getResources().getString(R.string.lorem_ipsum2), false, "02:34");
        allItems.add(dt);
        dt = new ActivityStyle29Model(true, "Met me at 10 PM", false, "01:34");
        allItems.add(dt);

        dt = new ActivityStyle29Model(false, "", true, "02:34");
        allItems.add(dt);
        dt = new ActivityStyle29Model(true, "Wow that's great!", false, "01:34");
        allItems.add(dt);

        dt = new ActivityStyle29Model(false, getResources().getString(R.string.lorem_ipsum2), false, "02:34");
        allItems.add(dt);
        dt = new ActivityStyle29Model(true, "Ok", false, "01:34");
        allItems.add(dt);

        return allItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
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
            case R.id.buttonMore:
                Toast.makeText(this, "Button more clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_attachment:
                if (isMenuShow) {
                    closeMenuBottom();
                } else {
                    openMenuBottom();
                }
                break;
            case R.id.buttonSend:
                Toast.makeText(this, "Button send clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

    private void openMenuBottom() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_top, R.anim.exit_to_bottom, R.anim.enter_from_bottom, R.anim.exit_to_top)
                .replace(R.id.menu_fragment, mMenu)
                .commit();

        isMenuShow = true;
    }

    public void closeMenuBottom() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_top, R.anim.enter_from_top, R.anim.exit_to_bottom)
                .remove(mMenu)
                .commit();
        isMenuShow = false;
    }

    @Override
    public void itemClicked(View view, int position) {
        closeMenuBottom();
    }
}
