package com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory;

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
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.CheckboxDark.ExtraCheckboxDarkActivity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.CheckboxLight.ExtraCheckboxLightActivity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.LeftMenuDark.ExtraLeftMenuDarkActivity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.LeftMenuIcons.ExtraLeftMenuIconsActivity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.LeftMenuLight.ExtraLeftMenuLightActivity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.LeftMenuSocial.ExtraLeftMenuSocialActivity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.ModalDialog1.ExtraDialog1Activity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.ModalDialog2.ExtraDialog2Activity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.ModalDialog3.ExtraDialog3Activity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.Search1.ExtraSearch1Activity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.Search2.ExtraSearch2Activity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.Search3.ExtraSearch3Activity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.TextDark.ExtraTextDarkActivity;
import com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.TextLight.ExtraTextLightActivity;
import com.mediatechindo.wahyu.materialuikit.tools.RecyclerItemClickListener;

/**
 * Created by wahyu on 21/07/16.
 */

@SuppressLint("ValidFragment")
public class ExtraDesignCategoryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.menu_category_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.menuCategoryList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String[] menu = getResources().getStringArray(R.array.extradesign_menu);
        ExtraDesignMenuAdapter adapter = new ExtraDesignMenuAdapter(getActivity(), menu);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
                switch (position){
                    case 0 :
                        intent = new Intent(getActivity(), ExtraDialog1Activity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getActivity(), ExtraDialog2Activity.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getActivity(), ExtraDialog3Activity.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getActivity(), ExtraLeftMenuLightActivity.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getActivity(), ExtraLeftMenuIconsActivity.class);
                        startActivity(intent);
                        break;
                    case 5 :
                        intent = new Intent(getActivity(), ExtraLeftMenuDarkActivity.class);
                        startActivity(intent);
                        break;
                    case 6 :
                        intent = new Intent(getActivity(), ExtraLeftMenuSocialActivity.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getActivity(), ExtraCheckboxLightActivity.class);
                        startActivity(intent);
                        break;
                    case 8 :
                        intent = new Intent(getActivity(), ExtraCheckboxDarkActivity.class);
                        startActivity(intent);
                        break;
                    case 9 :
                        intent = new Intent(getActivity(), ExtraTextLightActivity.class);
                        startActivity(intent);
                        break;
                    case 10 :
                        intent = new Intent(getActivity(), ExtraTextDarkActivity.class);
                        startActivity(intent);
                        break;
                    case 11 :
                        intent = new Intent(getActivity(), ExtraSearch1Activity.class);
                        startActivity(intent);
                        break;
                    case 12 :
                        intent = new Intent(getActivity(), ExtraSearch2Activity.class);
                        startActivity(intent);
                        break;
                    case 13 :
                        intent = new Intent(getActivity(), ExtraSearch3Activity.class);
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
