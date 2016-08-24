package com.qianfeng.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.qianfeng.base.BaseFragment;
import com.qianfeng.gouchao.R;


//-----------------------社区页面
public class FragmentCommunity extends BaseFragment implements View.OnClickListener {
    ViewPager viewPager;
    Button Redman,Starmatch;
    FragmentManager fm;
    FragmentTransaction ft;
    RadioGroup radioGroup;

    @Override
    protected int getContentViewId() {
        return R.layout.fargment_community;
    }

    @Override
    protected void init(View view) {
       viewPager= (ViewPager) view.findViewById(R.id.community_viewpager);

        Redman= (Button) view.findViewById(R.id.Redman);
        Starmatch= (Button) view.findViewById(R.id.Starmatch);
        Redman.setOnClickListener(this);
        Starmatch.setOnClickListener(this);
        //联动
        radioGroup= (RadioGroup) view.findViewById(R.id.radio_community);

        FragmentPagerAdapter adapter=new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position==0){
                    //红人馆
                    return  new Fragment_RedMan();
                }else {
                    //星搭配
                    return new Fragment_StarMatch();
                }

            }

            @Override
            public int getCount() {
                return 2;
            }

        };
        viewPager.setAdapter(adapter);

        //Viewpager和Fragment联动
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    //模拟点击
                radioGroup.getChildAt(position).performClick();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    //红人馆和星搭配点击切换页面
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Redman:
                viewPager.setCurrentItem(0);
                break;
            case R.id.Starmatch:
                viewPager.setCurrentItem(1);
                break;
        }


    }
}
