package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style15;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mediatechindo.wahyu.materialuikit.R;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class GalleryStyle15Fragment extends Fragment {
    int wizard_page_position;
    private TextView textTitle, textPage;
    private RelativeLayout fg1,fg2,fg3,fg4,fg5;

    public GalleryStyle15Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.gallery15_fragment;
        View view = inflater.inflate(layout_id, container, false);

        textTitle = (TextView) view.findViewById(R.id.textTitle);
        textPage = (TextView) view.findViewById(R.id.textPage);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPagerTab);
        viewPager.setAdapter(new TabViewPagerAdapter(getChildFragmentManager()));
        viewPager.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.gallery10_viewpager_margin));
        viewPager.addOnPageChangeListener(new WizardPageChangeListener());
        viewPager.setOffscreenPageLimit(5);
        textPage.setText("1 of 5");

        return view;
    }

    public void setTabFgFragment(int page, RelativeLayout fg){
        switch (page){
            case 0:
                fg1 = fg;
                break;
            case 1:
                fg2 = fg;
                break;
            case 2:
                fg3 = fg;
                break;
            case 3:
                fg4 = fg;
                break;
            case 4:
                fg5 = fg;
                break;
            default:
                break;
        }

    }

    private class TabViewPagerAdapter extends FragmentPagerAdapter {

        private int WIZARD_PAGES_COUNT = 5;

        public TabViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new GalleryStyle15TabFragment(position);
        }

        @Override
        public int getCount() {
            return WIZARD_PAGES_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }

    private class WizardPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int position) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int position) {
            int page = position + 1;
            textPage.setText(page + " of 5");

            if(fg1 != null && fg2 != null && fg3 != null && fg4 != null && fg5 != null){
                fg1.setVisibility(View.VISIBLE);
                fg2.setVisibility(View.VISIBLE);
                fg3.setVisibility(View.VISIBLE);
                fg4.setVisibility(View.VISIBLE);
                fg5.setVisibility(View.VISIBLE);

                switch (position){
                    case 0:
                        fg1.setVisibility(View.GONE);
                        break;
                    case 1:
                        fg2.setVisibility(View.GONE);
                        break;
                    case 2:
                        fg3.setVisibility(View.GONE);
                        break;
                    case 3:
                        fg4.setVisibility(View.GONE);
                        break;
                    case 4:
                        fg5.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
