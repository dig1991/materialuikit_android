package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style30;

import android.os.Bundle;
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

public class ActivityStyle30Activity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<ActivityStyle30Model> rowListItem;
    private ActivityStyle30Adapter rcAdapter;
    public static final int SEND_MESSAGE = 1;
    public static final int RECEIVE_MESSAGE = 2;
    public static final int RECEIVE_IMAGE = 3;
    public static final int RECEIVE_AUDIO = 4;
    public static final int RECEIVE_MAP = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity30_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Remi Boucher");
        }

        rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);
        rView.setHasFixedSize(false);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);

        rcAdapter = new ActivityStyle30Adapter(this, rowListItem);
        rView.setAdapter(rcAdapter);

    }

    private ArrayList<ActivityStyle30Model> getAllItemList(){
        ArrayList<ActivityStyle30Model> allItems = new ArrayList<>();
        ActivityStyle30Model dt;

        dt = new ActivityStyle30Model(RECEIVE_AUDIO, "", "02:34");
        allItems.add(dt);
        dt = new ActivityStyle30Model(SEND_MESSAGE, "Met me at 10 PM",  "01:34");
        allItems.add(dt);

        dt = new ActivityStyle30Model(RECEIVE_MAP, "", "02:34");
        allItems.add(dt);
        dt = new ActivityStyle30Model(SEND_MESSAGE, "Wow that's great!", "01:34");
        allItems.add(dt);

        dt = new ActivityStyle30Model(RECEIVE_MESSAGE, getResources().getString(R.string.lorem_ipsum2), "02:34");
        allItems.add(dt);
        dt = new ActivityStyle30Model(SEND_MESSAGE, "Ok", "01:34");
        allItems.add(dt);

        return  allItems;
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
        switch (view.getId()){
            case R.id.buttonMore:
                Toast.makeText(this, "Button more clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_attachment:
                Toast.makeText(this, "Button attachment clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSend:
                Toast.makeText(this, "Button send clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
