package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory;

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
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style1.EcommerceStyle1Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style10.EcommerceStyle10Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style11.EcommerceStyle11Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style12.EcommerceStyle12Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style13.EcommerceStyle13Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style14.EcommerceStyle14Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style15.EcommerceStyle15Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style16.EcommerceStyle16Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style17.EcommerceStyle17Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style18.EcommerceStyle18Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style19.EcommerceStyle19Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style2.EcommerceStyle2Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style20.EcommerceStyle20Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style21.EcommerceStyle21Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style22.EcommerceStyle22Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style23.EcommerceStyle23Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style24.EcommerceStyle24Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style25.EcommerceStyle25Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style26.EcommerceStyle26Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style27.EcommerceStyle27Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style28.EcommerceStyle28Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style29.EcommerceStyle29Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style3.EcommerceStyle3Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style30.EcommerceStyle30Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style4.EcommerceStyle4Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style5.EcommerceStyle5Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style6.EcommerceStyle6Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style7.EcommerceStyle7Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style8.EcommerceStyle8Activity;
import com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style9.EcommerceStyle9Activity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class EcommerceCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.ecommerce_menu);
        EcommerceMenuAdapter adapter = new EcommerceMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getActivity(), EcommerceStyle1Activity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), EcommerceStyle2Activity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), EcommerceStyle3Activity.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getActivity(), EcommerceStyle4Activity.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getActivity(), EcommerceStyle5Activity.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(getActivity(), EcommerceStyle6Activity.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(getActivity(), EcommerceStyle7Activity.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getActivity(), EcommerceStyle8Activity.class);
                        startActivity(intent);
                        break;
                    case 8 :
                        intent = new Intent(getActivity(), EcommerceStyle9Activity.class);
                        startActivity(intent);
                        break;
                    case 9 :
                        intent = new Intent(getActivity(), EcommerceStyle10Activity.class);
                        startActivity(intent);
                        break;
                    case 10 :
                        intent = new Intent(getActivity(), EcommerceStyle11Activity.class);
                        startActivity(intent);
                        break;
                    case 11 :
                        intent = new Intent(getActivity(), EcommerceStyle12Activity.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        intent = new Intent(getActivity(), EcommerceStyle13Activity.class);
                        startActivity(intent);
                        break;
                    case 13 :
                        intent = new Intent(getActivity(), EcommerceStyle14Activity.class);
                        startActivity(intent);
                        break;
                    case 14 :
                        intent = new Intent(getActivity(), EcommerceStyle15Activity.class);
                        startActivity(intent);
                        break;
                    case 15 :
                        intent = new Intent(getActivity(), EcommerceStyle16Activity.class);
                        startActivity(intent);
                        break;
                    case 16 :
                        intent = new Intent(getActivity(), EcommerceStyle17Activity.class);
                        startActivity(intent);
                        break;
                    case 17 :
                        intent = new Intent(getActivity(), EcommerceStyle18Activity.class);
                        startActivity(intent);
                        break;
                    case 18 :
                        intent = new Intent(getActivity(), EcommerceStyle19Activity.class);
                        startActivity(intent);
                        break;
                    case 19 :
                        intent = new Intent(getActivity(), EcommerceStyle20Activity.class);
                        startActivity(intent);
                        break;
                    case 20 :
                        intent = new Intent(getActivity(), EcommerceStyle21Activity.class);
                        startActivity(intent);
                        break;
                    case 21 :
                        intent = new Intent(getActivity(), EcommerceStyle22Activity.class);
                        startActivity(intent);
                        break;
                    case 22 :
                        intent = new Intent(getActivity(), EcommerceStyle23Activity.class);
                        startActivity(intent);
                        break;
                    case 23 :
                        intent = new Intent(getActivity(), EcommerceStyle24Activity.class);
                        startActivity(intent);
                        break;
                    case 24 :
                        intent = new Intent(getActivity(), EcommerceStyle25Activity.class);
                        startActivity(intent);
                        break;
                    case 25 :
                        intent = new Intent(getActivity(), EcommerceStyle26Activity.class);
                        startActivity(intent);
                        break;
                    case 26 :
                        intent = new Intent(getActivity(), EcommerceStyle27Activity.class);
                        startActivity(intent);
                        break;
                    case 27 :
                        intent = new Intent(getActivity(), EcommerceStyle28Activity.class);
                        startActivity(intent);
                        break;
                    case 28 :
                        intent = new Intent(getActivity(), EcommerceStyle29Activity.class);
                        startActivity(intent);
                        break;
                    case 29 :
                        intent = new Intent(getActivity(), EcommerceStyle30Activity.class);
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
