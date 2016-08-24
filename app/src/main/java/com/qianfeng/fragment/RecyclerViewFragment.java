package com.qianfeng.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.qianfeng.Bean.HomeBean;
import com.qianfeng.adapter.ZuiXinRecyclerAdapter;
import com.qianfeng.application.MyApplication;
import com.qianfeng.gouchao.R;
import com.qianfeng.widget.ScrollAbleFragment;
import com.qianfeng.widget.ScrollableHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewFragment extends ScrollAbleFragment implements ScrollableHelper.ScrollableContainer{


    private RecyclerView mRecyclerView;
    private int page = 1;
    private ZuiXinRecyclerAdapter adapter;
    List<HomeBean.AddDatasBean.ResultlistBean> strlist = new ArrayList<>();

    public static RecyclerViewFragment newInstance() {
        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        return recyclerViewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zuixin_viewpager, container, false);
        //加入数据

        mRecyclerView = (RecyclerView) view.findViewById(R.id.zuixin_rc);

        getData();
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        adapter = new ZuiXinRecyclerAdapter(getActivity(), strlist);
        mRecyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public View getScrollableView() {
        return mRecyclerView;
    }

    /**
     * 联网加载数据
     */
    private void getData() {
        Call<HomeBean> call = MyApplication.httputils.getHomeBean(page+"");
        call.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                List<HomeBean.AddDatasBean.ResultlistBean> list = response.body().getAddDatas().getResultlist();
                //i = response.body().getAddDatas().getCount();

                strlist.addAll(list);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {

            }
        });
    }
}