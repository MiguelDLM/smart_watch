package com.sina.weibo.sdk.web.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareTransActivity;

/* loaded from: classes11.dex */
public abstract class b extends WebViewClient {
    protected com.sina.weibo.sdk.web.b.b aA;
    protected WbAuthListener aB;
    protected com.sina.weibo.sdk.auth.b ax = com.sina.weibo.sdk.auth.b.b();
    protected Activity ay;
    protected com.sina.weibo.sdk.web.a az;

    public b(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        this.ay = activity;
        this.az = aVar;
        this.aA = bVar;
    }

    private void a(int i, String str) {
        Bundle extras = this.ay.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Intent intent = new Intent(this.ay, (Class<?>) ShareTransActivity.class);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.putExtras(extras);
        intent.putExtra("_weibo_resp_errcode", i);
        intent.putExtra("_weibo_resp_errstr", str);
        this.ay.setResult(-1, intent);
    }

    public final void m(String str) {
        a(0, str);
    }

    public final void n(String str) {
        a(2, str);
    }

    public final void o(String str) {
        a(1, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        CharSequence description;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        com.sina.weibo.sdk.web.a aVar = this.az;
        if (aVar != null) {
            webResourceError.getErrorCode();
            description = webResourceError.getDescription();
            description.toString();
            webResourceRequest.getUrl();
            aVar.p();
        }
    }

    public void p(String str) {
    }

    public void q() {
    }

    public boolean s() {
        return false;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
