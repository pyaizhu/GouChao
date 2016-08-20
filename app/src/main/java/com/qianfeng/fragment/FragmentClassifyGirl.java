package com.qianfeng.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.qianfeng.base.BaseFragment;
import com.qianfeng.gouchao.R;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class FragmentClassifyGirl extends BaseFragment {

    RadioGroup rg_classify_girl;
    FrameLayout frame_classify_girl;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_classify_girl;
    }

    @Override
    protected void init(View view) {
        rg_classify_girl= (RadioGroup) view.findViewById(R.id.rg_classify_girl);
        frame_classify_girl= (FrameLayout) view.findViewById(R.id.frame_classify_girl);
    }
}
