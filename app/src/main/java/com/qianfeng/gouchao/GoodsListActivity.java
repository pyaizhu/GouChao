package com.qianfeng.gouchao;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qbw.customview.RefreshLoadMoreLayout;
import com.qianfeng.application.MyApplication;
import com.qianfeng.base.BaseActivity;
import com.qianfeng.bean.GoodsListBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 商品列表界面
 * Created by Administrator on 2016/8/22 0022.
 */
public class GoodsListActivity extends BaseActivity {
    /**头部工具栏相关*/
    ImageView iv_goodslist_back;//返回键
    TextView tv_goods_typename;//商品类型

    /**gridview显示相关*/
    RefreshLoadMoreLayout refreshloadmore_goodslist;//下拉刷新上来加载更多（第三方会院框架）

    GridView gridview_goodslistactivity;//gridview
    List<GoodsListBean.AddDatasBean.ResultlistBean> datas=new ArrayList<>();//gridview数据源
    GoodsListGridViewAdapter adapter;//gridview适配器，装载商品信息数据
    String gId;//由FragmentGoods传进来的商品类型id，根据这个id，下载对应的商品类型下的商品信息数据
    String str_tv_goods_typename;//由FragmentGoods传进来的商品类型名称，把这个名称赋给tv_goods_typename
    int page=1;

    @Override
    public int getContentViewId() {
        return R.layout.activity_goodslist;
    }
    /**
     * 初始化控件，系统调用onCreate时调用
     * */
    @Override
    protected void init() {
        super.init();
        /**获得FragmentGoods传进来的gId和goodName数据*/
        Intent in=getIntent();
        gId=in.getStringExtra("gID");
        str_tv_goods_typename=in.getStringExtra("goods_typename");

        /**工具栏相关*/
        tv_goods_typename=findViewByIds(R.id.tv_goods_typename);
        iv_goodslist_back=findViewByIds(R.id.iv_goodslist_back);
        //点击返回键，关闭本界面
        iv_goodslist_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**gridview相关*/
        gridview_goodslistactivity=findViewByIds(R.id.gridview_goodslistactivity);
        adapter=new GoodsListGridViewAdapter(this,datas);
        gridview_goodslistactivity.setAdapter(adapter);
        gridview_goodslistactivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(GoodsListActivity.this,GoodsH5WebActivity.class);
                in.putExtra("mingId",datas.get(position).getMingId());

                startActivity(in);
            }
        });

        //上拉刷新和下拉加载更多
        refreshloadmore_goodslist=findViewByIds(R.id.refreshloadmore_goodslist);
        refreshloadmore_goodslist.init(new RefreshLoadMoreLayout.Config(new RefreshLoadMoreLayout.CallBack() {
            /**下拉刷新，下拉时会调用此方法，
             * refreshloadmore_goodslist会监听下拉事件
             * 把page参数置为1，调用refreshDatas()方法
             * */
            @Override
            public void onRefresh() {
                page=1;
                refreshDatas();
            }
            /**上拉加载更多，
             * refreshloadmore_goodslist会监听上拉事件
             * 上拉时会调用此方法，
             * 把page参数自加，调用onLoadMore()方法
             * */
            @Override
            public void onLoadMore() {
                page++;
                loadMoreDatas();
            }
        }));


    }

    /**加载数据的方法，系统调用onCreate时调用*/
    @Override
    protected void loadDatas() {
        super.loadDatas();
        //设置工具栏出商品名称
        tv_goods_typename.setText(str_tv_goods_typename);

        loadMoreDatas();
    }
    /**上拉加载更多时调用这个方法，加载数据*/
    private void loadMoreDatas() {
        HashMap<String,String> map=new HashMap<>();
        map.put("gId",gId);
        map.put("page",page+"");
        //Retrofit2联网下载json数据
        MyApplication.httputils.getGoodsListBean(map).enqueue(new Callback<GoodsListBean>() {

            @Override
            public void onResponse(Call<GoodsListBean> call, Response<GoodsListBean> response) {

                refreshloadmore_goodslist.stopLoadMore();
                //下载到的数据整体添加到datas
                List<GoodsListBean.AddDatasBean.ResultlistBean> list=response.body().getAddDatas().getResultlist();
                datas.addAll(list);
                //adapter刷新数据源
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<GoodsListBean> call, Throwable t) {

            }
        });
    }
    /**下拉刷新时调用这个方法，加载数据*/
    private void refreshDatas() {
        HashMap<String,String> map=new HashMap<>();
        map.put("gId",gId);
        map.put("page",page+"");
        //Retrofit2联网下载json数据
        MyApplication.httputils.getGoodsListBean(map).enqueue(new Callback<GoodsListBean>() {
            @Override
            public void onResponse(Call<GoodsListBean> call, Response<GoodsListBean> response) {
                refreshloadmore_goodslist.stopRefresh();
                //下载到的数据整体添加到datas
                List<GoodsListBean.AddDatasBean.ResultlistBean> list=response.body().getAddDatas().getResultlist();
                datas.clear();
                datas.addAll(list);
                //adapter刷新数据源
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<GoodsListBean> call, Throwable t) {

            }
        });
    }
    /**listview的adapter*/
    private static class GoodsListGridViewAdapter extends BaseAdapter {
        Context context;
        private List<GoodsListBean.AddDatasBean.ResultlistBean> datas;

        public GoodsListGridViewAdapter(Context context, List<GoodsListBean.AddDatasBean.ResultlistBean> datas) {
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
                convertView= LayoutInflater.from(context).inflate(R.layout.gridview_goodslist_item_1,null,false);
                viewHolder.tv_goodslist_currPrice= (TextView) convertView.findViewById(R.id.tv_goodslist_currPrice);
                viewHolder.tv_goodslist_origPrice= (TextView) convertView.findViewById(R.id.tv_goodslist_origPrice);
                viewHolder.tv_goodslist_goodname= (TextView) convertView.findViewById(R.id.tv_goodslist_goodname);
                viewHolder.iv_goodslist_item= (ImageView) convertView.findViewById(R.id.iv_goodslist_item);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            GoodsListBean.AddDatasBean.ResultlistBean bean=datas.get(position);

            viewHolder.tv_goodslist_currPrice.setText(bean.getCurrPrice()+"");
            viewHolder.tv_goodslist_origPrice.setText(bean.getOrigPrice()+"");
            viewHolder.tv_goodslist_goodname.setText(bean.getGoodName());
            Glide.with(context).load(bean.getPicUrl()).into(viewHolder.iv_goodslist_item);

            return convertView;
        }

        class ViewHolder{
            ImageView iv_goodslist_item;
            TextView tv_goodslist_currPrice;
            TextView tv_goodslist_origPrice;
            TextView tv_goodslist_goodname;

        }

    }

}
