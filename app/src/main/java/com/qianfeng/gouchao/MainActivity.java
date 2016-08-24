package com.qianfeng.gouchao;

import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qianfeng.base.BaseActivity;
import com.qianfeng.fragment.FragmentClassify;
import com.qianfeng.fragment.FragmentCommunity;
import com.qianfeng.fragment.FragmentHome;
import com.qianfeng.fragment.FragmentMine;
import com.qianfeng.fragment.FragmentSquare;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    // @InjectView(R.id.btnHome)
    private RadioButton btnHome;
    //  @InjectView(R.id.btnSquare)
    private RadioButton btnSquare;
    //   // @InjectView(R.id.btnCommunity)
    private RadioButton btnCommunity;
    //  @InjectView(R.id.btnMine)
    private RadioButton btnMine;
    private RadioButton btnClassify;
    // @InjectView(R.id.rgTab)

    private RadioGroup rgTab;
    //  @InjectView(R.id.frameLayout)
    private FrameLayout frameLayout;


    //    @Override
    //    protected void onCreate(Bundle savedInstanceState) {
    //        super.onCreate(savedInstanceState);
    //        // TODO: add setContentView(...) invocation
    //        ButterKnife.inject(this);
    //        rgTab.setOnCheckedChangeListener(this);
    //        rgTab.getChildAt(0).performClick();//模拟点击首页按钮
    //    }
    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();
        btnHome = findViewByIds(R.id.btnHome);
        btnClassify = findViewByIds(R.id.btnClassify);
        btnCommunity = findViewByIds(R.id.btnCommunity);
        btnMine = findViewByIds(R.id.btnMine);
        btnSquare = findViewByIds(R.id.btnSquare);
        rgTab = findViewByIds(R.id.rgTab);
        rgTab.setOnCheckedChangeListener(this);
        rgTab.getChildAt(0).performClick();//模拟点击首页按钮
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.btnHome:
                fragmentManager(R.id.frameLayout, new FragmentHome(), "home");
                break;
            case R.id.btnSquare:
                fragmentManager(R.id.frameLayout, new FragmentSquare(), "square");
                break;
            case R.id.btnClassify:
                fragmentManager(R.id.frameLayout, new FragmentClassify(), "classify");
                break;
            case R.id.btnCommunity:
                fragmentManager(R.id.frameLayout, new FragmentCommunity(), "community");
                break;
            case R.id.btnMine:
                fragmentManager(R.id.frameLayout, new FragmentMine(), "mine");
                break;
        }
    }
}
