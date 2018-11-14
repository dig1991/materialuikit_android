package com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

public class LoginSignupStyle21Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsignup21_layout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignIn:
                Toast.makeText(this, "Button Sign In clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSignUp:
                Toast.makeText(this, "Button Sign Up clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
