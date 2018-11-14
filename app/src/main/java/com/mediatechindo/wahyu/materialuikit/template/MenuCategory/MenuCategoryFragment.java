package com.mediatechindo.wahyu.materialuikit.template.MenuCategory;

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
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style1.MenuNavigation1Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style10.MenuNavigation10Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style11.MenuNavigation11Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style12.MenuNavigation12Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style13.MenuNavigation13Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style14.MenuNavigation14Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style15.MenuNavigation15Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style16.MenuNavigation16Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style17.MenuNavigation17Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style18.MenuNavigation18Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style19.MenuNavigation19Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style2.MenuNavigation2Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style20.MenuNavigation20Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style3.MenuNavigation3Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style4.MenuNavigation4Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style5.MenuNavigation5Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style6.MenuNavigation6Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style7.MenuNavigation7Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style8.MenuNavigation8Activity;
import com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style9.MenuNavigation9Activity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class MenuCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.menu_menu);
        MenuNavigationMenuAdapter adapter = new MenuNavigationMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getActivity(), MenuNavigation1Activity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), MenuNavigation2Activity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), MenuNavigation3Activity.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getActivity(), MenuNavigation4Activity.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getActivity(), MenuNavigation5Activity.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(getActivity(), MenuNavigation6Activity.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(getActivity(), MenuNavigation7Activity.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getActivity(), MenuNavigation8Activity.class);
                        startActivity(intent);
                        break;
                    case 8 :
                        intent = new Intent(getActivity(), MenuNavigation9Activity.class);
                        startActivity(intent);
                        break;
                    case 9 :
                        intent = new Intent(getActivity(), MenuNavigation10Activity.class);
                        startActivity(intent);
                        break;
                    case 10 :
                        intent = new Intent(getActivity(), MenuNavigation11Activity.class);
                        startActivity(intent);
                        break;
                    case 11 :
                        intent = new Intent(getActivity(), MenuNavigation12Activity.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        intent = new Intent(getActivity(), MenuNavigation13Activity.class);
                        startActivity(intent);
                        break;
                    case 13 :
                        intent = new Intent(getActivity(), MenuNavigation14Activity.class);
                        startActivity(intent);
                        break;
                    case 14 :
                        intent = new Intent(getActivity(), MenuNavigation15Activity.class);
                        startActivity(intent);
                        break;
                    case 15 :
                        intent = new Intent(getActivity(), MenuNavigation16Activity.class);
                        startActivity(intent);
                        break;
                    case 16 :
                        intent = new Intent(getActivity(), MenuNavigation17Activity.class);
                        startActivity(intent);
                        break;
                    case 17 :
                        intent = new Intent(getActivity(), MenuNavigation18Activity.class);
                        startActivity(intent);
                        break;
                    case 18 :
                        intent = new Intent(getActivity(), MenuNavigation19Activity.class);
                        startActivity(intent);
                        break;
                    case 19 :
                        intent = new Intent(getActivity(), MenuNavigation20Activity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        return view;
    }
}
