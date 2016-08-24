package com.qianfeng.fragment;

/**
 * Created by cpoopc on 2015/9/15.
 */

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.qianfeng.adapter.MyFragmentPagerAdapter;
import com.qianfeng.widget.PagerSlidingTabStrip;
import com.qianfeng.widget.ScrollAbleFragment;
import com.qianfeng.widget.ScrollableLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * User: cpoopc
 * Date: 2015-09-15
 * Time: 10:31
 * Ver.: 0.1
 */
public abstract class BasePagerFragment extends Fragment {


    public void initFragmentPager(ViewPager viewPager, PagerSlidingTabStrip pagerSlidingTabStrip, final ScrollableLayout mScrollLayout) {
        final ArrayList<ScrollAbleFragment> fragmentList = new ArrayList<>();
        fragmentList.add(FragmentHomeChaonan.newInstance());
        fragmentList.add(RecyclerViewFragment.newInstance());
        fragmentList.add(FragmentHomeChaonan.newInstance());
        fragmentList.add(RecyclerViewFragment.newInstance());

        List<String> titleList = new ArrayList<>();
        titleList.add("潮男");
        titleList.add("潮女");
        titleList.add("潮童");
        titleList.add("每日最佳");
        viewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), fragmentList, titleList));
        mScrollLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(0));
        pagerSlidingTabStrip.setViewPager(viewPager);
        pagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.e("onPageSelected", "page:" + i);
                /** 标注当前页面 **/
                mScrollLayout.getHelper().setCurrentScrollableContainer(fragmentList.get(i));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPager.setCurrentItem(0);
    }
}
