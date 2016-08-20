package com.qianfeng.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(), container, false);
        return view;
    }

    /**
     * 该方法会紧随onCreatView后调用
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        init(view);
        loadDatas();
    }

    /**
     * 初始化方法
     * @param view
     */
    protected void init(View view) {
    }

    /**
     * 加载数据的方法
     */
    protected void loadDatas() {
    }


    /**
     * 设置fragment需要展示的布局Id
     * @return
     */
    protected abstract int getContentViewId();
}

