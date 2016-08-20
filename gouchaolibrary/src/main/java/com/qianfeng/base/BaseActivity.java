package com.qianfeng.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * 所有activity的父类
 */
public abstract class BaseActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment showFragment;//正在显示的Fragment

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        //获取FragmentManager对象
        fragmentManager = getSupportFragmentManager();

        init();
        loadDatas();
    }

    /**
     * 返回当前activity所显示的布局Id
     *
     * @return
     */
    public abstract int getContentViewId();

    /**
     * 用于加载数据
     */
    protected void loadDatas() {
    }

    /**
     * 用于初始化
     */
    protected void init() {
    }

    /**
     * 查找页面布局Id所对应的控件对象，不需要强转
     *
     * @param resId
     * @param <T>
     * @return
     */
    protected <T> T findViewByIds(int resId) {
        return (T) findViewById(resId);
    }

    /**
     * 管理Fragment的显示与隐藏
     */
    protected void fragmentManager(int resid, Fragment fragment, String tag) {
        //开启一个事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //隐藏正在显示的Fragment
        if (showFragment != null) {
            fragmentTransaction.hide(showFragment);
        }
        //通过ID得到正在显示的fragment
        Fragment mFragment = fragmentManager.findFragmentByTag(tag);
        if (mFragment != null) {
            fragmentTransaction.show(mFragment);
        } else {
            mFragment = fragment;
            fragmentTransaction.add(resid, fragment, tag);
        }
        showFragment = mFragment;
        //提交事务
        fragmentTransaction.commit();
    }

    /**
     * 判断是否第一次进入，实现跳转的方法
     */
    protected void isFirst(final Intent intent1, final Intent intent2) {

        SharedPreferences sharedPreferences = this.getSharedPreferences("share", MODE_PRIVATE);
        boolean isFirst = sharedPreferences.getBoolean("isFirst", true);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        if (isFirst) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//第一次进入，进入intent1对应的页面
                    startActivity(intent1);
                    finish();
                }
            }, 2000);//延迟2秒跳转
            editor.putBoolean("isFirst", false);
            editor.commit();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//不是第一次进入，进入intent2对应页面
                    startActivity(intent2);
                    finish();
                }
            }, 2000);
        }
    }
}
