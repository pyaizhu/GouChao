package com.qianfeng.network;


import com.qianfeng.bean.Fashion_json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Administrator on 2016/8/11 0011.
 */
public interface HttpUtils {


    /**
     * 红人馆
     * @return
     */
    @GET(HttpUrls.HTTP_Community)
    Call<Fashion_json> getNewData(@Query("page")String page);


//    Call<NewsData> getNewData(@Query("flag") String flag);



}
