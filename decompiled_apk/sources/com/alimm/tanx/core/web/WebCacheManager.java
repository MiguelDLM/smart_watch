package com.alimm.tanx.core.web;

import android.content.Context;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.web.cache.ResourceInterceptor;
import com.alimm.tanx.core.web.cache.WebViewCacheInterceptor;
import com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst;
import com.alimm.tanx.core.web.cache.config.CacheExtensionConfig;
import com.alimm.tanx.core.web.webview.AdWebViewManager;
import com.alimm.tanx.core.web.webview.PreloadWebView;
import java.io.File;

/* loaded from: classes.dex */
public class WebCacheManager {
    private static WebCacheManager instance;

    public static WebCacheManager getInstance() {
        if (instance == null) {
            synchronized (WebCacheManager.class) {
                try {
                    if (instance == null) {
                        instance = new WebCacheManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private void initWebViewCache(Context context) {
        WebViewCacheInterceptor.Builder builder = new WebViewCacheInterceptor.Builder(context);
        builder.setCachePath(new File(context.getCacheDir(), "cache_path_name")).setDynamicCachePath(new File(context.getCacheDir(), "dynamic_webview_cache")).setCacheSize(52428800L).setConnectTimeoutSecond(20L).setReadTimeoutSecond(20L);
        CacheExtensionConfig cacheExtensionConfig = new CacheExtensionConfig();
        cacheExtensionConfig.addExtension("json").removeExtension("swf");
        builder.setCacheExtensionConfig(cacheExtensionConfig);
        builder.setDebug(LogUtils.isDebug(""));
        builder.setResourceInterceptor(new ResourceInterceptor() { // from class: com.alimm.tanx.core.web.WebCacheManager.1
            @Override // com.alimm.tanx.core.web.cache.ResourceInterceptor
            public boolean interceptor(String str) {
                return true;
            }
        });
        WebViewCacheInterceptorInst.getInstance().init(builder);
    }

    private void preload() {
        PreloadWebView.getInstance().preload(true);
    }

    public void destroy() {
        PreloadWebView.getInstance().destroy();
    }

    public AdWebViewManager getAdWebView() {
        return new AdWebViewManager();
    }

    public void init(Context context) {
        preload();
        initWebViewCache(context);
    }
}
