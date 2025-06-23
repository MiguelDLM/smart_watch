package com.alimm.tanx.core.web.cache;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alimm.tanx.core.web.cache.WebViewCacheInterceptor;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes.dex */
public class WebViewCacheInterceptorInst implements WebViewRequestInterceptor {
    private static volatile WebViewCacheInterceptorInst webViewCacheInterceptorInst;
    private WebViewRequestInterceptor mInterceptor;

    public static WebViewCacheInterceptorInst getInstance() {
        if (webViewCacheInterceptorInst == null) {
            synchronized (WebViewCacheInterceptorInst.class) {
                try {
                    if (webViewCacheInterceptorInst == null) {
                        webViewCacheInterceptorInst = new WebViewCacheInterceptorInst();
                    }
                } finally {
                }
            }
        }
        return webViewCacheInterceptorInst;
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void clearCache() {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.clearCache();
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void enableForce(boolean z) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.enableForce(z);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public InputStream getCacheFile(String str) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.getCacheFile(str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public File getCachePath() {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.getCachePath();
    }

    public void init(WebViewCacheInterceptor.Builder builder) {
        if (builder != null) {
            this.mInterceptor = builder.build();
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void initAssetsData() {
        AssetsLoader.getInstance().initData();
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    @TargetApi(21)
    public WebResourceResponse interceptRequest(WebResourceRequest webResourceRequest) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.interceptRequest(webResourceRequest);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(WebView webView, String str) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.loadUrl(webView, str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public WebResourceResponse interceptRequest(String str) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.interceptRequest(str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(String str, String str2) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.loadUrl(str, str2);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(String str, Map<String, String> map, String str2) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.loadUrl(str, map, str2);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(WebView webView, String str, Map<String, String> map) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.loadUrl(webView, str, map);
    }
}
