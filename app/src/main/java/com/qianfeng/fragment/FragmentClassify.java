package com.qianfeng.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.qianfeng.base.BaseFragment;
import com.qianfeng.gouchao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类模块的Fragment类
 */
public class FragmentClassify extends BaseFragment{

    TabLayout tab_classify_title;
    ViewPager viewpager_classify;
    List<Fragment> classify_fragment_list;
    List<String> tab_titles;


    @Override
    protected int getContentViewId() {
        return R.layout.fargment_classify;
    }
    /**初始化控件*/
    @Override
    protected void init(View view) {
        viewpager_classify= (ViewPager) view.findViewById(R.id.viewpager_classify);
        tab_classify_title= (TabLayout) view.findViewById(R.id.tab_classify_title);

    }
    /**加载数据*/
    @Override
    protected void loadDatas() {
        tab_titles=new ArrayList<>();
        tab_titles.add("女装");
        tab_titles.add("男装");
        tab_titles.add("女童");
        tab_titles.add("男童");

        /**导航栏增加tab*/
        tab_classify_title.addTab(tab_classify_title.newTab().setText(tab_titles.get(0)));
        tab_classify_title.addTab(tab_classify_title.newTab().setText(tab_titles.get(1)));
        tab_classify_title.addTab(tab_classify_title.newTab().setText(tab_titles.get(2)));
        tab_classify_title.addTab(tab_classify_title.newTab().setText(tab_titles.get(3)));
        tab_classify_title.setTabMode(TabLayout.MODE_FIXED);
        /**viewpager设置adapter*/
        classify_fragment_list=new ArrayList<>();
        classify_fragment_list.add(new FragmentClassifyLadies());
        classify_fragment_list.add(new FragmentClassifyMan());
        classify_fragment_list.add(new FragmentClassifyGirl());
        classify_fragment_list.add(new FragmentClassifyBoy());

        viewpager_classify.setAdapter(new ClassifyFragmentPagerAdapter(getActivity().getSupportFragmentManager(),classify_fragment_list,tab_titles));
        tab_classify_title.setupWithViewPager(viewpager_classify);
    }

    private static class ClassifyFragmentPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments;
        List<String> titles;
        public ClassifyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments,List<String> titles) {
            super(fm);
            this.fragments=fragments;
            this.titles=titles;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }



}
