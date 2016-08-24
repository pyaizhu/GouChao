package com.qianfeng.application;

import android.app.Application;
import android.util.Log;

import com.qianfeng.network.HttpURLs;
import com.qianfeng.network.HttpUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2016/8/20 0020.
 */
public class MyApplication extends Application {


    public static HttpUtils httputils;

    @Override
    public void onCreate() {
        super.onCreate();
        httputils=initRetrofit();
    }

    private HttpUtils initRetrofit() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(HttpURLs.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpUtils httputils=retrofit.create(HttpUtils.class);
        Log.d("print","HttpUtils");
        return httputils;
    }
}
