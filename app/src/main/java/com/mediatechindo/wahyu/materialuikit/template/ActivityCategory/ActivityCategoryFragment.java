package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory;

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
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style1.ActivityStyle1Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style10.ActivityStyle10Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style11.ActivityStyle11Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style12.ActivityStyle12Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style13.ActivityStyle13Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style14.ActivityStyle14Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style15.ActivityStyle15Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style16.ActivityStyle16Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style17.ActivityStyle17Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style18.ActivityStyle18Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style19.ActivityStyle19Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style2.ActivityStyle2Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style20.ActivityStyle20Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style21.ActivityStyle21Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style22.ActivityStyle22Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style23.ActivityStyle23Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style24.ActivityStyle24Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style25.ActivityStyle25Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style26.ActivityStyle26Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style27.ActivityStyle27Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style28.ActivityStyle28Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style29.ActivityStyle29Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style3.ActivityStyle3Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style30.ActivityStyle30Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style4.ActivityStyle4Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style5.ActivityStyle5Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style6.ActivityStyle6Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style7.ActivityStyle7Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style8.ActivityStyle8Activity;
import com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style9.ActivityStyle9Activity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class ActivityCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.activity_menu);
        ActivityMenuAdapter adapter = new ActivityMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getActivity(), ActivityStyle1Activity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), ActivityStyle2Activity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), ActivityStyle3Activity.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getActivity(), ActivityStyle4Activity.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getActivity(), ActivityStyle5Activity.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(getActivity(), ActivityStyle6Activity.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(getActivity(), ActivityStyle7Activity.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getActivity(), ActivityStyle8Activity.class);
                        startActivity(intent);
                        break;
                    case 8 :
                        intent = new Intent(getActivity(), ActivityStyle9Activity.class);
                        startActivity(intent);
                        break;
                    case 9 :
                        intent = new Intent(getActivity(), ActivityStyle10Activity.class);
                        startActivity(intent);
                        break;
                    case 10 :
                        intent = new Intent(getActivity(), ActivityStyle11Activity.class);
                        startActivity(intent);
                        break;
                    case 11 :
                        intent = new Intent(getActivity(), ActivityStyle12Activity.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        intent = new Intent(getActivity(), ActivityStyle13Activity.class);
                        startActivity(intent);
                        break;
                    case 13 :
                        intent = new Intent(getActivity(), ActivityStyle14Activity.class);
                        startActivity(intent);
                        break;
                    case 14 :
                        intent = new Intent(getActivity(), ActivityStyle15Activity.class);
                        startActivity(intent);
                        break;
                    case 15 :
                        intent = new Intent(getActivity(), ActivityStyle16Activity.class);
                        startActivity(intent);
                        break;
                    case 16 :
                        intent = new Intent(getActivity(), ActivityStyle17Activity.class);
                        startActivity(intent);
                        break;
                    case 17 :
                        intent = new Intent(getActivity(), ActivityStyle18Activity.class);
                        startActivity(intent);
                        break;
                    case 18 :
                        intent = new Intent(getActivity(), ActivityStyle19Activity.class);
                        startActivity(intent);
                        break;
                    case 19 :
                        intent = new Intent(getActivity(), ActivityStyle20Activity.class);
                        startActivity(intent);
                        break;
                    case 20 :
                        intent = new Intent(getActivity(), ActivityStyle21Activity.class);
                        startActivity(intent);
                        break;
                    case 21 :
                        intent = new Intent(getActivity(), ActivityStyle22Activity.class);
                        startActivity(intent);
                        break;
                    case 22 :
                        intent = new Intent(getActivity(), ActivityStyle23Activity.class);
                        startActivity(intent);
                        break;
                    case 23 :
                        intent = new Intent(getActivity(), ActivityStyle24Activity.class);
                        startActivity(intent);
                        break;
                    case 24 :
                        intent = new Intent(getActivity(), ActivityStyle25Activity.class);
                        startActivity(intent);
                        break;
                    case 25 :
                        intent = new Intent(getActivity(), ActivityStyle26Activity.class);
                        startActivity(intent);
                        break;
                    case 26 :
                        intent = new Intent(getActivity(), ActivityStyle27Activity.class);
                        startActivity(intent);
                        break;
                    case 27 :
                        intent = new Intent(getActivity(), ActivityStyle28Activity.class);
                        startActivity(intent);
                        break;
                    case 28 :
                        intent = new Intent(getActivity(), ActivityStyle29Activity.class);
                        startActivity(intent);
                        break;
                    case 29 :
                        intent = new Intent(getActivity(), ActivityStyle30Activity.class);
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
