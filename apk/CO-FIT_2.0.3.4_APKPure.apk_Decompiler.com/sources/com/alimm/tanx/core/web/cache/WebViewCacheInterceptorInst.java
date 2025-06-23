package com.alimm.tanx.core.web.cache;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alimm.tanx.core.web.cache.WebViewCacheInterceptor;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

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
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return webViewCacheInterceptorInst;
    }

    public void clearCache() {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor != null) {
            webViewRequestInterceptor.clearCache();
        }
    }

    public void enableForce(boolean z) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor != null) {
            webViewRequestInterceptor.enableForce(z);
        }
    }

    public InputStream getCacheFile(String str) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.getCacheFile(str);
    }

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

    public void initAssetsData() {
        AssetsLoader.getInstance().initData();
    }

    @TargetApi(21)
    public WebResourceResponse interceptRequest(WebResourceRequest webResourceRequest) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.interceptRequest(webResourceRequest);
    }

    public void loadUrl(WebView webView, String str) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor != null) {
            webViewRequestInterceptor.loadUrl(webView, str);
        }
    }

    public WebResourceResponse interceptRequest(String str) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.interceptRequest(str);
    }

    public void loadUrl(String str, String str2) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor != null) {
            webViewRequestInterceptor.loadUrl(str, str2);
        }
    }

    public void loadUrl(String str, Map<String, String> map, String str2) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor != null) {
            webViewRequestInterceptor.loadUrl(str, map, str2);
        }
    }

    public void loadUrl(WebView webView, String str, Map<String, String> map) {
        WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor != null) {
            webViewRequestInterceptor.loadUrl(webView, str, map);
        }
    }
}
