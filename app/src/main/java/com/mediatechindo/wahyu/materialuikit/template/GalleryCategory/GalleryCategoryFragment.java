package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory;

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
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style1.GalleryStyle1Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style10.GalleryStyle10Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style11.GalleryStyle11Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style12.GalleryStyle12Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style13.GalleryStyle13Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style14.GalleryStyle14Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style15.GalleryStyle15Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style16.GalleryStyle16Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style17.GalleryStyle17Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style18.GalleryStyle18Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style19.GalleryStyle19Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style2.GalleryStyle2Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style20.GalleryStyle20Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style21.GalleryStyle21Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style22.GalleryStyle22Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style23.GalleryStyle23Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style24.GalleryStyle24Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style25.GalleryStyle25Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style3.GalleryStyle3Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style4.GalleryStyle4Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style5.GalleryStyle5Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style6.GalleryStyle6Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style7.GalleryStyle7Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style8.GalleryStyle8Activity;
import com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style9.GalleryStyle9Activity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class GalleryCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.gallery_menu);
        GalleryMenuAdapter adapter = new GalleryMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getActivity(), GalleryStyle1Activity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), GalleryStyle2Activity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), GalleryStyle3Activity.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getActivity(), GalleryStyle4Activity.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getActivity(), GalleryStyle5Activity.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(getActivity(), GalleryStyle6Activity.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(getActivity(), GalleryStyle7Activity.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getActivity(), GalleryStyle8Activity.class);
                        startActivity(intent);
                        break;
                    case 8 :
                        intent = new Intent(getActivity(), GalleryStyle9Activity.class);
                        startActivity(intent);
                        break;
                    case 9 :
                        intent = new Intent(getActivity(), GalleryStyle10Activity.class);
                        startActivity(intent);
                        break;
                    case 10 :
                        intent = new Intent(getActivity(), GalleryStyle11Activity.class);
                        startActivity(intent);
                        break;
                    case 11 :
                        intent = new Intent(getActivity(), GalleryStyle12Activity.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        intent = new Intent(getActivity(), GalleryStyle13Activity.class);
                        startActivity(intent);
                        break;
                    case 13 :
                        intent = new Intent(getActivity(), GalleryStyle14Activity.class);
                        startActivity(intent);
                        break;
                    case 14 :
                        intent = new Intent(getActivity(), GalleryStyle15Activity.class);
                        startActivity(intent);
                        break;
                    case 15 :
                        intent = new Intent(getActivity(), GalleryStyle16Activity.class);
                        startActivity(intent);
                        break;
                    case 16 :
                        intent = new Intent(getActivity(), GalleryStyle17Activity.class);
                        startActivity(intent);
                        break;
                    case 17 :
                        intent = new Intent(getActivity(), GalleryStyle18Activity.class);
                        startActivity(intent);
                        break;
                    case 18 :
                        intent = new Intent(getActivity(), GalleryStyle19Activity.class);
                        startActivity(intent);
                        break;
                    case 19 :
                        intent = new Intent(getActivity(), GalleryStyle20Activity.class);
                        startActivity(intent);
                        break;
                    case 20 :
                        intent = new Intent(getActivity(), GalleryStyle21Activity.class);
                        startActivity(intent);
                        break;
                    case 21 :
                        intent = new Intent(getActivity(), GalleryStyle22Activity.class);
                        startActivity(intent);
                        break;
                    case 22 :
                        intent = new Intent(getActivity(), GalleryStyle23Activity.class);
                        startActivity(intent);
                        break;
                    case 23 :
                        intent = new Intent(getActivity(), GalleryStyle24Activity.class);
                        startActivity(intent);
                        break;
                    case 24 :
                        intent = new Intent(getActivity(), GalleryStyle25Activity.class);
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
