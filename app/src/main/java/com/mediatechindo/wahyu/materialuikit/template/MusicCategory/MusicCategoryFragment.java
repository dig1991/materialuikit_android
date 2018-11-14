package com.mediatechindo.wahyu.materialuikit.template.MusicCategory;

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
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style1.MusicStyle1Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style10.MusicStyle10Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style11.MusicStyle11Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style12.MusicStyle12Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style13.MusicStyle13Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style14.MusicStyle14Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style2.MusicStyle2Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style3.MusicStyle3Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style4.MusicStyle4Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style5.MusicStyle5Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style6.MusicStyle6Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style7.MusicStyle7Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style8.MusicStyle8Activity;
import com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style9.MusicStyle9Activity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class MusicCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.music_menu);
        MusicMenuAdapter adapter = new MusicMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getActivity(), MusicStyle1Activity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), MusicStyle2Activity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), MusicStyle3Activity.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getActivity(), MusicStyle4Activity.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getActivity(), MusicStyle5Activity.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(getActivity(), MusicStyle6Activity.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(getActivity(), MusicStyle7Activity.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getActivity(), MusicStyle8Activity.class);
                        startActivity(intent);
                        break;
                    case 8 :
                        intent = new Intent(getActivity(), MusicStyle9Activity.class);
                        startActivity(intent);
                        break;
                    case 9 :
                        intent = new Intent(getActivity(), MusicStyle10Activity.class);
                        startActivity(intent);
                        break;
                    case 10 :
                        intent = new Intent(getActivity(), MusicStyle11Activity.class);
                        startActivity(intent);
                        break;
                    case 11 :
                        intent = new Intent(getActivity(), MusicStyle12Activity.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        intent = new Intent(getActivity(), MusicStyle13Activity.class);
                        startActivity(intent);
                        break;
                    case 13 :
                        intent = new Intent(getActivity(), MusicStyle14Activity.class);
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
