package com.baidu.navisdk.ui.widget;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public abstract class BNWebViewClient extends WebViewClient {
    public static final int MSG_BN_CLOSE = 0;
    public static final int MSG_ON_OVERRIDE_URL_LOADING = 1;
    public static final int MSG_ON_PAGE_FINISHED = 3;
    public static final int MSG_ON_PAGE_STARTED = 2;
    public static final int MSG_ON_RECEIVED_ERROR = 4;
    public static final String URL_BN_CLOSE = "bdnavi://close";
    public static final String URL_BN_PREFIX = "bdnavi://";
    public static final String URL_HTTPS_PREFIX = "https://";
    public static final String URL_HTTP_PREFIX = "http://";

    private void handleBNUrlProtocol(WebView webView, String str) {
        if (str.startsWith(URL_BN_CLOSE)) {
            onEventBNavi(0, webView, str, null);
        }
    }

    public abstract boolean onEventAndroid(int i, WebView webView, String str, Message message);

    public abstract boolean onEventBNavi(int i, WebView webView, String str, Message message);

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        onEventAndroid(3, webView, str, null);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        onEventAndroid(2, webView, str, null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        LogUtil.e("BNWebViewClient", "onReceivedError:" + str2);
        onEventAndroid(4, webView, str2, null);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        LogUtil.e("BNWebViewClient", "OverrideUrlLoading:" + str);
        if (webView != null && str != null) {
            if (!str.startsWith(URL_HTTP_PREFIX) && !str.startsWith(URL_HTTPS_PREFIX)) {
                if (str.startsWith(URL_BN_PREFIX)) {
                    handleBNUrlProtocol(webView, str);
                }
            } else {
                webView.loadUrl(str);
                onEventAndroid(1, webView, str, null);
            }
        }
        return true;
    }
}
