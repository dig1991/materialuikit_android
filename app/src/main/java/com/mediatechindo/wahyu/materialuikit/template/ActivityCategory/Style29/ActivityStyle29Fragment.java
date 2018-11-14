package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style29;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class ActivityStyle29Fragment extends Fragment implements View.OnClickListener{
    View button1;
    View button2;
    View button3;
    View button4;
    View button5;
    View button6;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity29_fragment, container, false);

        button1 = view.findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = view.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = view.findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = view.findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = view.findViewById(R.id.button6);
        button6.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Toast.makeText(getActivity(), "Button Photo clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(getActivity(), "Button Video clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Toast.makeText(getActivity(), "Button Document clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Toast.makeText(getActivity(), "Button Location clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                Toast.makeText(getActivity(), "Button Contact clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6:
                Toast.makeText(getActivity(), "Button Audio clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        ((ActivityStyle29Activity) getActivity()).closeMenuBottom();
    }
}
