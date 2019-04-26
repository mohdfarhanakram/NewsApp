package com.farhan.newsapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.farhan.newsapp.R;

/**
 * Created by Farhan on 25,April,2019
 */
public class WebViewActivity extends BaseActivity{

    public static String DETAIL_URL = "detail_url";

    private  String detailUrl;
    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_layout);

        detailUrl = getIntent().getStringExtra(DETAIL_URL);

        mWebView = findViewById(R.id.webView);
        mWebView.setInitialScale(1);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setScrollbarFadingEnabled(false);
        mWebView.getSettings().setBuiltInZoomControls(false);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        mWebView.loadUrl(detailUrl);
    }
}
