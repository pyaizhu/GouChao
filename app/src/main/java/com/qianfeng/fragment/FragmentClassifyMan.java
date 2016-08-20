package com.qianfeng.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.qianfeng.base.BaseFragment;
import com.qianfeng.gouchao.R;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class FragmentClassifyMan extends BaseFragment {

    RadioGroup rg_classify_man;
    FrameLayout frame_classify_man;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_classify_man;
    }

    @Override
    protected void init(View view) {
        rg_classify_man= (RadioGroup) view.findViewById(R.id.rg_classify_man);
        frame_classify_man= (FrameLayout) view.findViewById(R.id.frame_classify_man);
    }
}
