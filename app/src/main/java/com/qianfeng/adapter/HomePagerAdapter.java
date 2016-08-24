package com.qianfeng.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 主页的pagerdapter
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragments;


    public HomePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
    this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
