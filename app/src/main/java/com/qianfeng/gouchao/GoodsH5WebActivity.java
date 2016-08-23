package com.qianfeng.gouchao;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.qianfeng.base.BaseActivity;
import com.qianfeng.network.HttpURLs;

/**
 * 商品详情界面
 * Created by Administrator on 2016/8/23 0023.
 */
public class GoodsH5WebActivity extends BaseActivity {


    private WebView webView;
    ImageView iv_goods_h5web;
    //url相关
    private long id;
    String web_url;

    @Override
    public int getContentViewId() {
        return R.layout.activity_goods_h5web;
    }

    @Override
    protected void init() {
        id=getIntent().getLongExtra("mingId",1);//获取商品列表界面点击item时传进来的mindId
        web_url=HttpURLs.GOODS_H5_WEB+id;//得到mingId，拼接成完整的URL
        /**工具栏返回键相关*/
        iv_goods_h5web=findViewByIds(R.id.iv_goods_h5web);
        iv_goods_h5web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**webview相关*/
        webView=findViewByIds(R.id.webview_goods_h5web);
        webView.getSettings().setJavaScriptEnabled(true);//设置webview响应javascript
        webView.loadUrl(web_url);//加载要访问的网页url
        //设置网页在应用内打开（即设置webview作为一个浏览器）
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;//返回true，表明在应用内打开
            }
        });

    }
}
