package com.baidu.mobads.sdk.api;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

/* loaded from: classes7.dex */
public interface IXHybridAdRenderer extends IAdInterListener {
    String getJavaScriptBridge();

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onReceivedError(WebView webView, int i, String str, String str2);

    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void setCustomerWebView(WebView webView);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
