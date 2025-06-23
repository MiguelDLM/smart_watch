package com.baidu.mobads.sdk.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.Cdo;

/* loaded from: classes7.dex */
public class BaiduHybridAdManager {
    private Cdo mAdProd;
    private String mAppSid;
    private WebView mWebView;
    private BaiduHybridAdViewListener mBaiduHybridAdViewListener = new BaiduHybridAdViewListener() { // from class: com.baidu.mobads.sdk.api.BaiduHybridAdManager.1
        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdClick(int i, String str) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdFailed(int i, String str, String str2) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdShow(int i, String str) {
        }
    };
    private boolean mAppPageReceivedError = false;

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.mAppPageReceivedError) {
            this.mWebView = webView;
            Cdo cdo = new Cdo(this.mWebView);
            this.mAdProd = cdo;
            cdo.h(this.mAppSid);
            this.mAdProd.a(this.mBaiduHybridAdViewListener);
            this.mAdProd.a();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mAppPageReceivedError = false;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.mAppPageReceivedError = true;
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.mBaiduHybridAdViewListener = baiduHybridAdViewListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Cdo cdo;
        if (!this.mAppPageReceivedError && (cdo = this.mAdProd) != null) {
            cdo.b(webView, str);
        }
        try {
            Uri parse = Uri.parse(str);
            if (!"mobadssdk".equals(parse.getScheme())) {
                if ("mobads".equals(parse.getScheme())) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
