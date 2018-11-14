package com.mediatechindo.wahyu.materialuikit.template.NewsCategory;

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
import com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style1.NewsStyle1Activity;
import com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style2.NewsStyle2Activity;
import com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style3.NewsStyle3Activity;
import com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style4.NewsStyle4Activity;
import com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style5.NewsStyle5Activity;
import com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style6.NewsStyle6Activity;
import com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style7.NewsStyle7Activity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class NewsCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.news_menu);
        NewsMenuAdapter adapter = new NewsMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getActivity(), NewsStyle1Activity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), NewsStyle2Activity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), NewsStyle3Activity.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getActivity(), NewsStyle4Activity.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getActivity(), NewsStyle5Activity.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(getActivity(), NewsStyle6Activity.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(getActivity(), NewsStyle7Activity.class);
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
