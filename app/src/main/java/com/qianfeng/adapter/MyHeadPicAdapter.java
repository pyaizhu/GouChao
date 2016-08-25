package com.qianfeng.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.qianfeng.Bean.ColorsConstant;
import com.qianfeng.gouchao.R;

import java.util.ArrayList;
import java.util.List;

public class MyHeadPicAdapter extends PagerAdapter {
    //图片的list集合
    List<ImageView> imageViews = new ArrayList<>();


    public MyHeadPicAdapter(Context context) {
        for (int i = 0; i < 8; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setImageResource(R.drawable.zhanwei);
            //imageView.setBackgroundColor(context.getResources().getColor(ColorsConstant.colors[i]));
            final int index = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                //头部图片的点击事件
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "im android " + index, Toast.LENGTH_SHORT).show();
                }
            });
            imageViews.add(imageView);
        }
    }

    @Override
    public int getCount() {
        return ColorsConstant.colors.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position), 0);
        return imageViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }
}