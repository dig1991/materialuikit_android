package com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.ModalDialog3;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

import static com.mediatechindo.wahyu.materialuikit.R.id.buttonLogin;

public class ExtraDialog3Activity extends AppCompatActivity implements View.OnClickListener {
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra_dialog3_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        // ADD SPACE TOP DRAWER ON LOLLIPOP AND UP
        final NavigationView navigationViewLeft = (NavigationView) findViewById(R.id.nav_view);
        View navLeftLay = navigationViewLeft.getHeaderView(0);
        Space spaceLeftTop = (Space) navLeftLay.findViewById(R.id.spaceLeftTop);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            spaceLeftTop.setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogForm = inflater.inflate(R.layout.extra_dialog3_dialog, null, false);
        final LinearLayout loginContainer = (LinearLayout) dialogForm.findViewById(R.id.loginContainer);
        final LinearLayout signupContainer = (LinearLayout) dialogForm.findViewById(R.id.signupContainer);
        TextView buttonTabLogin = (TextView) dialogForm.findViewById(R.id.buttonTabLogin);
        buttonTabLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginContainer.setVisibility(View.VISIBLE);
                signupContainer.setVisibility(View.GONE);
            }
        });
        TextView buttonTabSignup = (TextView) dialogForm.findViewById(R.id.buttonTabSignup);
        buttonTabSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginContainer.setVisibility(View.GONE);
                signupContainer.setVisibility(View.VISIBLE);
            }
        });

        Button buttonLogin = (Button) dialogForm.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogForm);
        builder.create();

        dialog = builder.create();
        dialog.show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_shopping_cart:
                Toast.makeText(this, "action shopping cart clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLoginSignupBack:
                onBackPressed();
                break;
            case buttonLogin:
                dialog.dismiss();
                break;
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }
}
