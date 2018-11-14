package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;

public class MusicStyle10Activity extends AppCompatActivity implements View.OnClickListener, MusicStyle10ClickListener {
    private int numSelected = 11;
    private int totalMenuCount = 14;
    private TextView selectedInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music10_layout);

        selectedInfo = (TextView) findViewById(R.id.selectedInfo);

        //Top 40 albums
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ArrayList<MusicStyle10Model> rowListItem2 = getAllItemList2();
        MusicStyle10Adapter rcAdapter2 = new MusicStyle10Adapter(this, rowListItem2);

        RecyclerView rView2 = (RecyclerView) findViewById(R.id.recyclerView);
        rView2.setLayoutManager(layoutManager);
        rView2.setAdapter(rcAdapter2);
        rView2.setNestedScrollingEnabled(false);
        rcAdapter2.setClickListener(this);
    }

    private ArrayList<MusicStyle10Model> getAllItemList2(){
        ArrayList<MusicStyle10Model> allItems = new ArrayList<>();
        MusicStyle10Model dt;

        dt = new MusicStyle10Model("Rock", false, "Country", false, "Jazz", false);
        allItems.add(dt);
        dt = new MusicStyle10Model("HIp Hop", false, "Pop", true, "Alternative", false);
        allItems.add(dt);
        dt = new MusicStyle10Model("Blues", true, "EDM", false, "Garage Blues", false);
        allItems.add(dt);
        dt = new MusicStyle10Model("Lounge", false, "Folk", false, "Funk", false);
        allItems.add(dt);
        dt = new MusicStyle10Model("Britpop", false, "Reggae", true, null, false);
        allItems.add(dt);
        return  allItems;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAudio:
                break;
            case R.id.buttonNext:
                Toast.makeText(this, "Button Next clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void itemClickedAdd() {
        numSelected++;
        setSelectedInfo();
    }

    @Override
    public void itemClickedRemove() {
        numSelected--;
        setSelectedInfo();
    }

    private void setSelectedInfo(){
        selectedInfo.setText(numSelected + " out of " + totalMenuCount + " selected");
    }
}
