package com.qianfeng.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qianfeng.application.MyApplication;
import com.qianfeng.bean.GoodsBean;
import com.qianfeng.gouchao.GoodsListActivity;
import com.qianfeng.gouchao.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 分类模块下的商品Fragment类
 * Created by Administrator on 2016/8/20 0020.
 */
public class FragmentGoods extends Fragment {

    GridView listview_classify_goods;
    String parentID;
    List<GoodsBean.AddDatasBean.ResultlistBean> goodsDatas=new ArrayList<>();
    MyListViewAdapter adapter;
    private View mview;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("print","FragmentGoods"+"    onAttach");
    }

    public static FragmentGoods instanceFragmentGoods(String parentID){

        Bundle bundle=new Bundle();
        bundle.putString("parentID",parentID);
        FragmentGoods fragmentGoods=new FragmentGoods();
        fragmentGoods.setArguments(bundle);
        return fragmentGoods;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentID=getArguments().getString("parentID");
        Log.d("print","FragmentGoods"+"    onCreate");

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("print","FragmentGoods"+"    onCreateView");

        if (goodsDatas.size()>0){
            return mview;
        }else {
            View view=inflater.inflate(R.layout.fragment_goods,container,false);
            init(view);
            loadDatas();
            mview=view;

            return mview;
        }


    }

    /**初始化控件*/
    protected void init(View view) {

        listview_classify_goods= (GridView) view.findViewById(R.id.listview_classify_goods);
        adapter=new MyListViewAdapter(getActivity(),goodsDatas);
        listview_classify_goods.setAdapter(adapter);


        /**
         * recycleview_classify_goods的item点击事件，点击一个item进入对应的详情列表
         *
         */
        listview_classify_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(getActivity(), GoodsListActivity.class);
                in.putExtra("goods_typename",goodsDatas.get(position).getGoodName());
                in.putExtra("gID",goodsDatas.get(position).getId()+"");
                startActivity(in);
            }
        });

    }

    /**加载数据的方法*/
    protected void loadDatas() {

        MyApplication.httputils.getGoodsBean(parentID).enqueue(new Callback<GoodsBean>() {
            @Override
            public void onResponse(Call<GoodsBean> call, Response<GoodsBean> response) {
                String str=response.body().toString();
                Log.d("print",str);
                List<GoodsBean.AddDatasBean.ResultlistBean> list=response.body().getAddDatas().getResultlist();
                goodsDatas.addAll(list);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GoodsBean> call, Throwable t) {

            }
        });
    }

    /**listview的adapter*/
    private static class MyListViewAdapter extends BaseAdapter{
        Context context;
        private List<GoodsBean.AddDatasBean.ResultlistBean> datas;

        public MyListViewAdapter(Context context, List<GoodsBean.AddDatasBean.ResultlistBean> datas) {
            this.context = context;
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView==null){
                viewHolder=new ViewHolder();
                convertView=LayoutInflater.from(context).inflate(R.layout.recycleview_goods_list_item_1,null,false);
                viewHolder.iv_goods= (ImageView) convertView.findViewById(R.id.iv_goods);
                viewHolder.tv_goods= (TextView) convertView.findViewById(R.id.tv_goods);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }

            viewHolder.tv_goods.setText(datas.get(position).getGoodName());
            Glide.with(context).load(datas.get(position).getPicPath()).into(viewHolder.iv_goods);

            return convertView;
        }

        class ViewHolder{
            ImageView iv_goods;
            TextView tv_goods;
        }

    }



}
