package com.qianfeng.network;



import com.qianfeng.Bean.HomeBean;
import com.qianfeng.Bean.HomeImageViewBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Administrator on 2016/8/20 0020.
 */
public interface HttpUtils {

    //    @GET(HttpURLs.GOODS_TOP_URL)
    //    Call<TopListBean> getTopBean(@Query("ntype") String ntype);
    //
    //    @GET(HttpURLs.GOODS_TYPE_URL)
    //    Call<GoodsBean> getGoodsBean(@Query("parentID") String parentID);

    @GET(HttpURLs.Home_RC_ZuiXin_URL)
    Call<HomeBean> getHomeBean(@Query("page") String page);

    @GET(HttpURLs.Home_ViewPager_URL)
    Call<HomeImageViewBean> getHomeImageViewBean();
}
