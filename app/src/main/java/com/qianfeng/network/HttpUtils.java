package com.qianfeng.network;

import com.qianfeng.bean.GoodsBean;
import com.qianfeng.bean.GoodsListBean;
import com.qianfeng.bean.TopListBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public interface HttpUtils {

    @GET(HttpURLs.GOODS_TOP_URL)
    Call<TopListBean> getTopBean(@Query("ntype") String ntype);

    @GET(HttpURLs.GOODS_TYPE_URL)
    Call<GoodsBean> getGoodsBean(@Query("parentID") String parentID);

    @GET(HttpURLs.GOODS_LIST_URL)
    Call<GoodsListBean> getGoodsListBean(@QueryMap Map<String, String> map);


}
