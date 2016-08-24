package com.qianfeng.adapter;


import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qianfeng.gouchao.R;

import com.nshmura.recyclertablayout.RecyclerTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页bar的adapter
 */
public class HomeBarAdapter extends RecyclerTabLayout.Adapter implements View.OnClickListener {

    HomePagerAdapter homePagerAdapter;
    String[] str = {"最新", "情侣","潮男","潮童","内地","渡假","欧美", "日韩", "亲子","简约","名媛","高街", "混搭", "复古", "休闲","甜美","运动","牛仔", "闺蜜","OL", "摩登", "小众", "party"};
    List<Boolean> isClicks;
  //  String TAG = "print";


    public HomeBarAdapter(ViewPager viewPager) {
        super(viewPager);
        homePagerAdapter = (HomePagerAdapter) mViewPager.getAdapter();
        isClicks = new ArrayList<>();
        for (int i = 0; i < homePagerAdapter.getCount() ; i++) {
            isClicks.add(i,false);
        //    Log.e(TAG, "MatchMatchBarAdapter: "+isCicks.get(i));
        }
        isClicks.add(0,true);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_bar,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        /**页面滑动根据布尔集合设置item的颜色*/
       mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
         @Override
         public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

         }

         @Override
         public void onPageSelected(int position) {
             for (int i = 0; i <isClicks.size() ; i++) {
                 isClicks.set(i,false);
             }
              isClicks.add(position,true);
             notifyDataSetChanged();
         }

         @Override
         public void onPageScrollStateChanged(int state) {

         }
     });


        ((ViewHolder)holder).textView.setText(str[position]);
        if(isClicks.get(position)){
            ((ViewHolder) holder).textView.setTextColor(Color.parseColor("#FF317A"));
        }else{
            ((ViewHolder) holder).textView.setTextColor(Color.parseColor("#AAACBA"));

        }
    }

    @Override
    public int getItemCount() {
        return homePagerAdapter.getCount();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.tvText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getViewPager().setCurrentItem(getAdapterPosition());
                }
            });
        }
    }
}