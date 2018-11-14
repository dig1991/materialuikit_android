package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style25;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.List;

public class EcommerceStyle25Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecommerce25_layout);

        setupToolbar();

        List<String> stateList = new ArrayList<String>();
        stateList.add("Exp Date");
        stateList.add("2017");
        stateList.add("2018");

        Spinner spinnerExpDate = (Spinner) findViewById(R.id.spinnerExpDate);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_left, stateList);
        spinnerExpDate.setAdapter(adapter);

    }

    private void setupToolbar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Payment");
        }
    }

    public void onRadioCliked(View v) {
        RadioButton shippingCost1 = (RadioButton) findViewById(R.id.shippingCost1);
        RadioButton shippingCost2 = (RadioButton) findViewById(R.id.shippingCost2);
        RadioButton shippingCost3 = (RadioButton) findViewById(R.id.shippingCost3);
        shippingCost1.setChecked(false);
        shippingCost2.setChecked(false);
        shippingCost3.setChecked(false);

        switch (v.getId()){
            case R.id.shippingCost1:
                shippingCost1.setChecked(true);
                break;
            case R.id.shippingCost2:
                shippingCost2.setChecked(true);
                break;
            case R.id.shippingCost3:
                shippingCost3.setChecked(true);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ecommerce24_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_search:
                Toast.makeText(this, "action search cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_shopping_cart:
                Toast.makeText(this, "action shopping cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "action setting cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNext:
                Toast.makeText(this, "Button Next clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSetEmail:
                Toast.makeText(this, "Button Set Email clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSetCardInfo:
                Toast.makeText(this, "Button Set Card Info clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

}
