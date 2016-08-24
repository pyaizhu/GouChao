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

    /**首页模块下的RecycleView的URL*/
    String Home_RC_ZuiXin_URL = "home/getCollList?sign=7528d7144dc77e4ae6460326b4554a1f&uid=0&maxresult=40&ver=1.0&page=1&deviceID=182943336455323";

    //首页模块下的轮播图
    String Home_ViewPager_URL ="home/getHotColumnList?sign=7528d7144dc77e4ae6460326b4554a1f&maxresult=20&ver=1.0&page=&deviceID=182943336455323";
}
