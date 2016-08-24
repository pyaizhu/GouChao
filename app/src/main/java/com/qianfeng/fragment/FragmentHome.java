package com.qianfeng.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.qianfeng.adapter.HomeBarAdapter;
import com.qianfeng.adapter.HomePagerAdapter;
import com.qianfeng.gouchao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class FragmentHome extends Fragment {

    RecyclerTabLayout recyclerTabLayout;
    ViewPager homeviewPager;
    List<Fragment> fragments;
    HomePagerAdapter homePagerAdapter;

    String TAG = "print";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_home, container, false);
        init(view);
        return view;
    }

    /**
     * 初始化
     */
    private void init(final View view) {
        homeviewPager = (ViewPager) view.findViewById(R.id.viewpagerHome);
        fragments = new ArrayList<>();
        //fragments.add(new FragmentZuixin());
        //        fragments.add(new HotFragment());
        //        fragments.add(new EuropeFragment());
        for (int i = 0; i < 23; i++) {
            fragments.add(new FragmentZuixinViewPager());
        }
        homePagerAdapter = new HomePagerAdapter(
                getActivity().getSupportFragmentManager(), fragments);
        homeviewPager.setAdapter(homePagerAdapter);
        recyclerTabLayout = (RecyclerTabLayout) view.findViewById(R.id.rcHome);
        recyclerTabLayout.setUpWithAdapter(new HomeBarAdapter(homeviewPager));
    }
}
