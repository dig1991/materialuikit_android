package com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory;

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
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style1.WalkthroughStyle1Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style10.WalkthroughStyle10Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style11.WalkthroughStyle11Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style12.WalkthroughStyle12Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style13.WalkthroughStyle13Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style14.WalkthroughStyle14Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style15.WalkthroughStyle15Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style16.WalkthroughStyle16Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style17.WalkthroughStyle17Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style18.WalkthroughStyle18Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style19.WalkthroughStyle19Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style2.WalkthroughStyle2Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style20.WalkthroughStyle20Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style3.WalkthroughStyle3Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style4.WalkthroughStyle4Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style5.WalkthroughStyle5Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style6.WalkthroughStyle6Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style7.WalkthroughStyle7Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style8.WalkthroughStyle8Activity;
import com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style9.WalkthroughStyle9Activity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class WalkthroughCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.walktrought_menu);
        WalkthroughMenuAdapter adapter = new WalkthroughMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getActivity(), WalkthroughStyle1Activity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), WalkthroughStyle2Activity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), WalkthroughStyle3Activity.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getActivity(), WalkthroughStyle4Activity.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getActivity(), WalkthroughStyle5Activity.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(getActivity(), WalkthroughStyle6Activity.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(getActivity(), WalkthroughStyle7Activity.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getActivity(), WalkthroughStyle8Activity.class);
                        startActivity(intent);
                        break;
                    case 8 :
                        intent = new Intent(getActivity(), WalkthroughStyle9Activity.class);
                        startActivity(intent);
                        break;
                    case 9 :
                        intent = new Intent(getActivity(), WalkthroughStyle10Activity.class);
                        startActivity(intent);
                        break;
                    case 10 :
                        intent = new Intent(getActivity(), WalkthroughStyle11Activity.class);
                        startActivity(intent);
                        break;
                    case 11 :
                        intent = new Intent(getActivity(), WalkthroughStyle12Activity.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        intent = new Intent(getActivity(), WalkthroughStyle13Activity.class);
                        startActivity(intent);
                        break;
                    case 13 :
                        intent = new Intent(getActivity(), WalkthroughStyle14Activity.class);
                        startActivity(intent);
                        break;
                    case 14 :
                        intent = new Intent(getActivity(), WalkthroughStyle15Activity.class);
                        startActivity(intent);
                        break;
                    case 15 :
                        intent = new Intent(getActivity(), WalkthroughStyle16Activity.class);
                        startActivity(intent);
                        break;
                    case 16 :
                        intent = new Intent(getActivity(), WalkthroughStyle17Activity.class);
                        startActivity(intent);
                        break;
                    case 17 :
                        intent = new Intent(getActivity(), WalkthroughStyle18Activity.class);
                        startActivity(intent);
                        break;
                    case 18 :
                        intent = new Intent(getActivity(), WalkthroughStyle19Activity.class);
                        startActivity(intent);
                        break;
                    case 19 :
                        intent = new Intent(getActivity(), WalkthroughStyle20Activity.class);
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
