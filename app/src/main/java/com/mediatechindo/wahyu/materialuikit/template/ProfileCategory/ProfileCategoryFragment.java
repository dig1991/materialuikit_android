package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory;

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
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style1.ProfileStyle1Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style10.ProfileStyle10Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style11.ProfileStyle11Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style12.ProfileStyle12Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style13.ProfileStyle13Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style14.ProfileStyle14Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style15.ProfileStyle15Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style16.ProfileStyle16Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style17.ProfileStyle17Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style18.ProfileStyle18Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style19.ProfileStyle19Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style2.ProfileStyle2Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style20.ProfileStyle20Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style21.ProfileStyle21Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style22.ProfileStyle22Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style23.ProfileStyle23Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style24.ProfileStyle24Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style25.ProfileStyle25Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style26.ProfileStyle26Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style27.ProfileStyle27Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style28.ProfileStyle28Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style29.ProfileStyle29Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style3.ProfileStyle3Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style30.ProfileStyle30Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style4.ProfileStyle4Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style5.ProfileStyle5Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style6.ProfileStyle6Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style7.ProfileStyle7Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style8.ProfileStyle8Activity;
import com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style9.ProfileStyle9Activity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class ProfileCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.profile_menu);
        ProfileMenuAdapter adapter = new ProfileMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getActivity(), ProfileStyle1Activity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), ProfileStyle2Activity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), ProfileStyle3Activity.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getActivity(), ProfileStyle4Activity.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getActivity(), ProfileStyle5Activity.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(getActivity(), ProfileStyle6Activity.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(getActivity(), ProfileStyle7Activity.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getActivity(), ProfileStyle8Activity.class);
                        startActivity(intent);
                        break;
                    case 8 :
                        intent = new Intent(getActivity(), ProfileStyle9Activity.class);
                        startActivity(intent);
                        break;
                    case 9 :
                        intent = new Intent(getActivity(), ProfileStyle10Activity.class);
                        startActivity(intent);
                        break;
                    case 10 :
                        intent = new Intent(getActivity(), ProfileStyle11Activity.class);
                        startActivity(intent);
                        break;
                    case 11 :
                        intent = new Intent(getActivity(), ProfileStyle12Activity.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        intent = new Intent(getActivity(), ProfileStyle13Activity.class);
                        startActivity(intent);
                        break;
                    case 13 :
                        intent = new Intent(getActivity(), ProfileStyle14Activity.class);
                        startActivity(intent);
                        break;
                    case 14 :
                        intent = new Intent(getActivity(), ProfileStyle15Activity.class);
                        startActivity(intent);
                        break;
                    case 15 :
                        intent = new Intent(getActivity(), ProfileStyle16Activity.class);
                        startActivity(intent);
                        break;
                    case 16 :
                        intent = new Intent(getActivity(), ProfileStyle17Activity.class);
                        startActivity(intent);
                        break;
                    case 17 :
                        intent = new Intent(getActivity(), ProfileStyle18Activity.class);
                        startActivity(intent);
                        break;
                    case 18 :
                        intent = new Intent(getActivity(), ProfileStyle19Activity.class);
                        startActivity(intent);
                        break;
                    case 19 :
                        intent = new Intent(getActivity(), ProfileStyle20Activity.class);
                        startActivity(intent);
                        break;
                    case 20 :
                        intent = new Intent(getActivity(), ProfileStyle21Activity.class);
                        startActivity(intent);
                        break;
                    case 21 :
                        intent = new Intent(getActivity(), ProfileStyle22Activity.class);
                        startActivity(intent);
                        break;
                    case 22 :
                        intent = new Intent(getActivity(), ProfileStyle23Activity.class);
                        startActivity(intent);
                        break;
                    case 23 :
                        intent = new Intent(getActivity(), ProfileStyle24Activity.class);
                        startActivity(intent);
                        break;
                    case 24 :
                        intent = new Intent(getActivity(), ProfileStyle25Activity.class);
                        startActivity(intent);
                        break;
                    case 25 :
                        intent = new Intent(getActivity(), ProfileStyle26Activity.class);
                        startActivity(intent);
                        break;
                    case 26 :
                        intent = new Intent(getActivity(), ProfileStyle27Activity.class);
                        startActivity(intent);
                        break;
                    case 27 :
                        intent = new Intent(getActivity(), ProfileStyle28Activity.class);
                        startActivity(intent);
                        break;
                    case 28 :
                        intent = new Intent(getActivity(), ProfileStyle29Activity.class);
                        startActivity(intent);
                        break;
                    case 29 :
                        intent = new Intent(getActivity(), ProfileStyle30Activity.class);
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
