package com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style16;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class WalkthroughStyle16Fragment extends Fragment {
    int wizard_page_position;

    public WalkthroughStyle16Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.walkthrough16_page1;
        switch (wizard_page_position) {
            case 0:
                layout_id = R.layout.walkthrough16_page1;
                break;

            case 1:
                layout_id = R.layout.walkthrough16_page2;
                break;

            case 2:
                layout_id = R.layout.walkthrough16_page3;
                break;

            case 3:
                layout_id = R.layout.walkthrough16_page4;
                break;
        }
        View view = inflater.inflate(layout_id, container, false);
        Button button = (Button) view.findViewById(R.id.btnGetStarted);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button Get Started clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
