package com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style1.LoginSignupStyle1Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style10.LoginSignupStyle10Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style11.LoginSignupStyle11Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style12.LoginSignupStyle12Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style13.LoginSignupStyle13Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style14.LoginSignupStyle14Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style15.LoginSignupStyle15Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style16.LoginSignupStyle16Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style17.LoginSignupStyle17Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style18.LoginSignupStyle18Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style19.LoginSignupStyle19Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style2.LoginSignupStyle2Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style20.LoginSignupStyle20Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style21.LoginSignupStyle21Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style22.LoginSignupStyle22Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style23.LoginSignupStyle23Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style24.LoginSignupStyle24Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style25.LoginSignupStyle25Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style3.LoginSignupStyle3Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style4.LoginSignupStyle4Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style5.LoginSignupStyle5Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style6.LoginSignupStyle6Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style7.LoginSignupStyle7Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style8.LoginSignupStyle8Activity;
import com.mediatechindo.wahyu.materialuikit.template.LoginSignupCategory.Style9.LoginSignupStyle9Activity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class LoginSignupCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.login_signup_menu);
        LoginMenuAdapter adapter = new LoginMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                startLoginSignupActivity(position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        return view;
    }

    private void startLoginSignupActivity(int position){
        Intent intent;
        switch (position){
            case 0 :
                intent = new Intent(getActivity(), LoginSignupStyle1Activity.class);
                startActivity(intent);
                break;
            case 1 :
                intent = new Intent(getActivity(), LoginSignupStyle2Activity.class);
                startActivity(intent);
                break;
            case 2 :
                intent = new Intent(getActivity(), LoginSignupStyle3Activity.class);
                startActivity(intent);
                break;
            case 3 :
                intent = new Intent(getActivity(), LoginSignupStyle4Activity.class);
                startActivity(intent);
                break;
            case 4 :
                intent = new Intent(getActivity(), LoginSignupStyle5Activity.class);
                startActivity(intent);
                break;
            case 5 :
                intent = new Intent(getActivity(), LoginSignupStyle6Activity.class);
                startActivity(intent);
                break;
            case 6 :
                intent = new Intent(getActivity(), LoginSignupStyle7Activity.class);
                startActivity(intent);
                break;
            case 7 :
                intent = new Intent(getActivity(), LoginSignupStyle8Activity.class);
                startActivity(intent);
                break;
            case 8 :
                intent = new Intent(getActivity(), LoginSignupStyle9Activity.class);
                startActivity(intent);
                break;
            case 9 :
                intent = new Intent(getActivity(), LoginSignupStyle10Activity.class);
                startActivity(intent);
                break;
            case 10 :
                intent = new Intent(getActivity(), LoginSignupStyle11Activity.class);
                startActivity(intent);
                break;
            case 11 :
                intent = new Intent(getActivity(), LoginSignupStyle12Activity.class);
                startActivity(intent);
                break;
            case 12 :
                intent = new Intent(getActivity(), LoginSignupStyle13Activity.class);
                startActivity(intent);
                break;
            case 13 :
                intent = new Intent(getActivity(), LoginSignupStyle14Activity.class);
                startActivity(intent);
                break;
            case 14 :
                intent = new Intent(getActivity(), LoginSignupStyle15Activity.class);
                startActivity(intent);
                break;
            case 15 :
                intent = new Intent(getActivity(), LoginSignupStyle16Activity.class);
                startActivity(intent);
                break;
            case 16 :
                intent = new Intent(getActivity(), LoginSignupStyle17Activity.class);
                startActivity(intent);
                break;
            case 17 :
                intent = new Intent(getActivity(), LoginSignupStyle18Activity.class);
                startActivity(intent);
                break;
            case 18 :
                intent = new Intent(getActivity(), LoginSignupStyle19Activity.class);
                startActivity(intent);
                break;
            case 19 :
                intent = new Intent(getActivity(), LoginSignupStyle20Activity.class);
                startActivity(intent);
                break;
            case 20 :
                intent = new Intent(getActivity(), LoginSignupStyle21Activity.class);
                startActivity(intent);
                break;
            case 21 :
                intent = new Intent(getActivity(), LoginSignupStyle22Activity.class);
                startActivity(intent);
                break;
            case 22 :
                intent = new Intent(getActivity(), LoginSignupStyle23Activity.class);
                startActivity(intent);
                break;
            case 23 :
                intent = new Intent(getActivity(), LoginSignupStyle24Activity.class);
                startActivity(intent);
                break;
            case 24 :
                intent = new Intent(getActivity(), LoginSignupStyle25Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
