package com.kwad.sdk.core.webview.a;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.d;

/* loaded from: classes11.dex */
public class a extends WebViewClient {
    private boolean aFk = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.aFk = z;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.aFk && d.CT()) {
            com.kwad.sdk.core.e.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
            WebResourceResponse aa = com.kwad.sdk.core.webview.b.a.HG().aa(str, this.mUniqueId);
            return aa == null ? super.shouldInterceptRequest(webView, str) : aa;
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.aFk && d.CT()) {
            String uri = webResourceRequest.getUrl().toString();
            com.kwad.sdk.core.e.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
            WebResourceResponse aa = com.kwad.sdk.core.webview.b.a.HG().aa(uri, this.mUniqueId);
            return aa == null ? super.shouldInterceptRequest(webView, webResourceRequest) : aa;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
