package com.program.wanandroiddemo.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ldoublem.loadingviewlib.view.LVCircularRing;
import com.program.wanandroiddemo.R;
import com.program.wanandroiddemo.base.BaseActivity;
import com.program.wanandroiddemo.utils.Constants;
import com.program.wanandroiddemo.utils.LogUtils;

import butterknife.BindView;

public class DetailsActivity extends BaseActivity  {

    @BindView(R.id.date_name)
    public TextView mName;

    @BindView(R.id.date_web)
    public WebView mWeb;

    @BindView(R.id.deta_layout)
    public View mLayout;

    @BindView(R.id.web_loaing_tv)
    public TextView mWebLoadingTv;


    @BindView(R.id.loading_ring)
    public LVCircularRing mLVCircularRing;

    @BindView(R.id.loading)
    public RelativeLayout mLoadingLayout;



    @Override
    protected void initPresenter() {


    }

    @Override
    protected void initView() {
//        LoadingBar.view(mLayout).show();

        onLoading();
        Intent intent = getIntent();
        String name = intent.getStringExtra(Constants.TITLE);
        String link = intent.getStringExtra(Constants.LINK);
        LogUtils.d(this,"name ="+name+";;;Link="+link);

        mName.setText(name);
//        mLVCircularRing.setVisibility(View.GONE);
//        mLoadingLayout.setVisibility(View.GONE);

//        mWeb.getSettings().setJavaScriptEnabled(true);


        //支持javascript
        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);// 支持通过JS打开新窗口
        // 设置可以支持缩放
        mWeb.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        mWeb.getSettings().setBuiltInZoomControls(true);
        //扩大比例的缩放
        mWeb.getSettings().setUseWideViewPort(true);
        mWeb.getSettings().setAllowFileAccess(true);
        mWeb.getSettings().setLoadsImagesAutomatically(true);// 支持自动加载图片
        //自适应屏幕
        mWeb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWeb.getSettings().setLoadWithOverviewMode(true);

        mWeb.setLayerType(View.LAYER_TYPE_SOFTWARE, null);



        mWeb.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mWebLoadingTv.setText(newProgress+"%");
            }
        });

        mWeb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                mLVCircularRing.setVisibility(View.GONE);
                mLoadingLayout.setVisibility(View.GONE);
//                LoadingBar.view(mLayout).cancel();
//                LoadingBar.release();
                LogUtils.d(DetailsActivity.this,"error   "+view.getHandler());

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }


        });
        mWeb.loadUrl(link);


    }

    private void onLoading() {
        mLVCircularRing.setBarColor(Color.BLACK);
        mLVCircularRing.startAnim();
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_details;
    }



}