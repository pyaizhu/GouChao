package com.qianfeng.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.base.BaseFragment;
import com.qianfeng.gouchao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类模块的Fragment类
 */
public class FragmentClassify extends BaseFragment{

    TabLayout tab_classify_title;//头部导航栏
    ViewPager viewpager_classify;//底部viewpager
    List<String> tab_titles;//tablayout各tab名称的list集合


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

        /**TabLayout各tab的名称*/
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
        viewpager_classify.setAdapter(new ClassifyFragmentPagerAdapter(getActivity().getSupportFragmentManager(),tab_titles));

        /**设置TabLayout与viewpager关联*/
        tab_classify_title.setupWithViewPager(viewpager_classify);
    }

    /**viewpager的adapter类*/
    class ClassifyFragmentPagerAdapter extends FragmentPagerAdapter {
        List<String> titles;
        public ClassifyFragmentPagerAdapter(FragmentManager fm,List<String> titles) {
            super(fm);
            this.titles=titles;
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentClassifyLadies.getFragmentClassifyChild(position+"");
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_UNCHANGED;
        }
    }
}
