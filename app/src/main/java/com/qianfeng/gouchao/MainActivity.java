package com.qianfeng.gouchao;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qianfeng.base.BaseActivity;
import com.qianfeng.fragment.FragmentClassify;
import com.qianfeng.fragment.FragmentCommunity;
import com.qianfeng.fragment.FragmentHome;
import com.qianfeng.fragment.FragmentMine;
import com.qianfeng.fragment.FragmentSquare;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @InjectView(R.id.btnHome)
    RadioButton btnHome;
    @InjectView(R.id.btnSquare)
    RadioButton btnSquare;
    @InjectView(R.id.btnClassify)
    RadioButton btnClassify;
    @InjectView(R.id.btnCommunity)
    RadioButton btnCommunity;
    @InjectView(R.id.btnMine)
    RadioButton btnMine;
    @InjectView(R.id.rgTab)
    RadioGroup rgTab;
    @InjectView(R.id.frameLayout)
    FrameLayout frameLayout;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btnHome, R.id.btnSquare, R.id.btnClassify, R.id.btnCommunity, R.id.btnMine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                fragmentManager(R.id.frameLayout,new FragmentHome(),"home");
                break;
            case R.id.btnSquare:
                fragmentManager(R.id.frameLayout,new FragmentSquare(),"square");
                break;
            case R.id.btnClassify:
                fragmentManager(R.id.frameLayout,new FragmentClassify(),"classify");
                break;
            case R.id.btnCommunity:
                fragmentManager(R.id.frameLayout,new FragmentCommunity(),"communuty");
                break;
            case R.id.btnMine:
                fragmentManager(R.id.frameLayout,new FragmentMine(),"mine");
                break;
        }
    }
}
