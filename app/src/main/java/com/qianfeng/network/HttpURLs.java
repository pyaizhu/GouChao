package com.qianfeng.network;

/**
 * Created by Administrator on 2016/8/20 0020.
 */
public interface HttpURLs {
    String BASEURL="http://112.74.206.80:7080/GouChao/";



    /**分类模块下左侧选择栏的URL*/
    String GOODS_TOP_URL="goods/getTopList?sign=82071d9727cebe6b74dc5a4aab5c1d38&maxresult=50&ver=1.0&page=1&deviceID=864394100021205";

    /**分类模块下右侧Fragment的数据URL*/
    String GOODS_TYPE_URL="goods/getTypeList?sign=82071d9727cebe6b74dc5a4aab5c1d38&maxresult=50&ver=1.0&page=1&deviceID=864394100021205";

    /**分类模块下——点击商品类别——进入商品列表的URL*/
    String GOODS_LIST_URL="gcworth/typeGoodsList?sign=82071d9727cebe6b74dc5a4aab5c1d38&maxresult=100&stype=0&deviceID=864394100021205&isParent=false&ver=1.0";

    /**分类模块下——点击商品类别——商品列表——点击商品进入对应web页面的URL*/
    String GOODS_H5_WEB="http://h5.m.taobao.com/cm/snap/index.html?&ttid=2014_uyingyongbao_23215633%40baichuan_android_1.7.0&umpChannel=1-23215633&u_channel=1-23215633&id=";
}
