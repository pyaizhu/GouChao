package com.qianfeng.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.qianfeng.application.MyApplication;
import com.qianfeng.bean.TopListBean;
import com.qianfeng.gouchao.R;
import com.qianfeng.network.HttpURLs;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 分类模块下的女士Fragment类
 * Created by Administrator on 2016/8/20 0020.
 */
public class FragmentClassifyLadies extends Fragment {

    private FragmentManager fragmentManager;
    private Fragment showFragment;//正在显示的Fragment
    FrameLayout frame_classify;

    ListView lv_classify_ladies;
    TopListViewAdapter adapter;
    List<TopListBean.AddDatasBean.ResultlistBean> topListBeanlist=new ArrayList<>();
    private int selectedId=0;

    String ntype;
    View mview;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("print","onAttach"+ntype);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("print","onCreateView");
        Log.d("print","topListBeanlist.size()"+topListBeanlist.size());
        if (topListBeanlist.size()>0){
            return mview;
        }else {
            View view=inflater.inflate(R.layout.fragment_classify_ladies,container,false);
            init(view);
            loadDatas();
            mview=view;
            return mview;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("print","onViewCreated");
    }

    /**管理Fragment的显示与隐藏的方法*/
    protected void myfragmentManager(int resid, Fragment fragment, String tag) {
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

    /**获取FragmentClassifyLadies的静态工厂方法*/
    public static FragmentClassifyLadies getFragmentClassifyChild(String ntype){
        Bundle bundle=new Bundle();
        bundle.putString("ntype",ntype);
        FragmentClassifyLadies fragmentClassifyLadies=new FragmentClassifyLadies();
        fragmentClassifyLadies.setArguments(bundle);
        return fragmentClassifyLadies;
    }

    /**系统盗用onCreate时，获得静态工厂方法传进来的Bundle*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ntype=getArguments().getString("ntype");
        Log.d("print","ntype"+ntype);
        Log.d("print","onCreate"+ntype);
    }

    /**初始化控件*/
    protected void init(View view) {
        lv_classify_ladies= (ListView) view.findViewById(R.id.lv_classify_ladies);
        adapter=new TopListViewAdapter(getActivity(),topListBeanlist);
        lv_classify_ladies.setAdapter(adapter);

        lv_classify_ladies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedId=position;
                adapter.notifyDataSetChanged();
                myfragmentManager(R.id.frame_classify,FragmentGoods.instanceFragmentGoods(topListBeanlist.get(position).getId()+""),topListBeanlist.get(position).getId()+"");
            }
        });

        frame_classify= (FrameLayout) view.findViewById(R.id.frame_classify);
        //获取FragmentManager对象
        fragmentManager = getChildFragmentManager();
    }

    /**加载数据的方法*/
    protected void loadDatas() {
        Log.d("print",HttpURLs.GOODS_TOP_URL+ntype);
        /**下载选择栏的数据*/
        final Call<TopListBean> topBeanCall = MyApplication.httputils.getTopBean(ntype);
        topBeanCall.enqueue(new Callback<TopListBean>() {
            @Override
            public void onResponse(Call<TopListBean> call, Response<TopListBean> response) {
                /**将下载到的数据保存到topListBeanlist中*/
                topListBeanlist.addAll(response.body().getAddDatas().getResultlist());
                adapter.notifyDataSetChanged();
                lv_classify_ladies.performItemClick(lv_classify_ladies.getChildAt(0),0,lv_classify_ladies.getItemIdAtPosition(0));
                Log.d("print",response.body().getAddDatas().getCount()+"");
                Log.d("print",topListBeanlist.size()+"");
            }
            @Override
            public void onFailure(Call<TopListBean> call, Throwable t) {

            }
        });
    }

    /**Listview的adapter类*/
    class TopListViewAdapter extends BaseAdapter {
        List<TopListBean.AddDatasBean.ResultlistBean> list;
        Context context;

        public TopListViewAdapter( Context context,List<TopListBean.AddDatasBean.ResultlistBean> list) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TopListviewViewHolder holder;
            if (convertView==null){
                holder=new TopListviewViewHolder();
                convertView=LayoutInflater.from(context).inflate(R.layout.item_toplistliew_1,null,false);
                holder.tv_item_toplistliew_1= (TextView) convertView.findViewById(R.id.tv_item_toplistliew_1);
                convertView.setTag(holder);
            }else {
                holder= (TopListviewViewHolder) convertView.getTag();
            }
                holder.tv_item_toplistliew_1.setText(list.get(position).getGoodName());
            if (position==selectedId){
                convertView.setBackgroundResource(R.drawable.select_color);
            }else {
                convertView.setBackgroundResource(R.drawable.unselect_color);
            }
            return convertView;
        }

        class TopListviewViewHolder{
            TextView tv_item_toplistliew_1;
        }
    }
}
