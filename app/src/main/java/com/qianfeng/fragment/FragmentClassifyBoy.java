package com.qianfeng.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.qianfeng.base.BaseFragment;
import com.qianfeng.gouchao.R;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class FragmentClassifyBoy extends BaseFragment {

    RadioGroup rg_classify_boy;
    FrameLayout frame_classify_boy;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_classify_boy;
    }

    @Override
    protected void init(View view) {
        rg_classify_boy= (RadioGroup) view.findViewById(R.id.rg_classify_boy);
        frame_classify_boy= (FrameLayout) view.findViewById(R.id.frame_classify_boy);
    }
}
