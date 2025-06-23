package com.alimm.tanx.core.web.webview;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.WebConfigBean;
import com.alimm.tanx.core.utils.LogUtils;
import fi.iki.elonen.NanoHTTPD;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* loaded from: classes.dex */
public class PreloadWebView {
    private static final int CACHED_WEB_VIEW_MAX_NUM = 3;
    private static String TAG = "PreloadWebView";
    private static final Stack<WeakReference<TanxAdWebView>> mCachedWebViewStack = new Stack<>();
    private Handler mainHandler;

    /* loaded from: classes.dex */
    public static class Holder {
        private static final PreloadWebView INSTANCE = new PreloadWebView();

        private Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WeakReference<TanxAdWebView> createWebView() {
        TanxAdWebView tanxAdWebView = new TanxAdWebView(new MutableContextWrapper(TanxCoreSdk.getApplication()));
        tanxAdWebView.getSettings().setJavaScriptEnabled(true);
        tanxAdWebView.loadDataWithBaseURL("file:///android_asset/article/?item_id=0&token=0", getHtml(), NanoHTTPD.MIME_HTML, "utf-8", "file:///android_asset/article/?item_id=0&token=0");
        return new WeakReference<>(tanxAdWebView);
    }

    private static String getHtml() {
        return "<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"utf-8\">\n<meta name=\"viewport\" content=\"initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/article/css/android.css\">\n</head>\n<body class=\"font_m\"><header></header><article></article><footer></footer><script type=\"text/javascript\" src=\"file:///android_asset/article/js/lib.js\"></script><script type=\"text/javascript\" src=\"file:///android_asset/article/js/android.js\" ></script>\n</body>\n</html>\n";
    }

    private long getInitDelayTime(boolean z) {
        if (!z) {
            return 0L;
        }
        WebConfigBean webConfigBean = OrangeManager.getInstance().getWebConfigBean();
        if (webConfigBean == null) {
            webConfigBean = new WebConfigBean();
        }
        long j = webConfigBean.sdkInitWebViewPreloadDelayed;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public static PreloadWebView getInstance() {
        return Holder.INSTANCE;
    }

    private void initSettings(TanxAdWebView tanxAdWebView) {
        WebSettings settings = tanxAdWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setDefaultTextEncodingName("UTF-8");
        CookieManager.getInstance();
        settings.setMixedContentMode(2);
    }

    private boolean isPreload(boolean z) {
        WebConfigBean webConfigBean = OrangeManager.getInstance().getWebConfigBean();
        if (webConfigBean == null) {
            webConfigBean = new WebConfigBean();
        }
        LogUtils.d(TAG, "isPreload webConfigBean:" + webConfigBean.toString());
        if (z) {
            boolean z2 = webConfigBean.closeInitWebPreload;
            LogUtils.d(TAG, "isPreload initSwitch:" + z2);
            if (!z2) {
                return true;
            }
            return false;
        }
        boolean z3 = webConfigBean.closeNextWebPreload;
        LogUtils.d(TAG, "isPreload nextWebSwitch:" + z3);
        if (!z3) {
            return true;
        }
        return false;
    }

    public static void loadBaseHtml(TanxAdWebView tanxAdWebView) {
        if (tanxAdWebView == null) {
            return;
        }
        tanxAdWebView.loadDataWithBaseURL("file:///android_asset/article/?item_id=0&token=0", getHtml(), NanoHTTPD.MIME_HTML, "utf-8", "file:///android_asset/article/?item_id=0&token=0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushCachedWebViewStack() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.alimm.tanx.core.web.webview.PreloadWebView.2
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                LogUtils.d("PreloadWebView", "-->queueIdle");
                PreloadWebView.mCachedWebViewStack.push(PreloadWebView.this.createWebView());
                return false;
            }
        });
    }

    public void destroy() {
        Stack<WeakReference<TanxAdWebView>> stack = mCachedWebViewStack;
        if (stack != null) {
            stack.clear();
        }
    }

    public TanxAdWebView getWebView(Context context) {
        TanxAdWebView tanxAdWebView;
        Stack<WeakReference<TanxAdWebView>> stack = mCachedWebViewStack;
        if (stack != null && !stack.isEmpty() && (tanxAdWebView = stack.pop().get()) != null) {
            ((MutableContextWrapper) tanxAdWebView.getContext()).setBaseContext(context);
        } else {
            WeakReference<TanxAdWebView> createWebView = createWebView();
            ((MutableContextWrapper) createWebView.get().getContext()).setBaseContext(context);
            tanxAdWebView = createWebView.get();
        }
        tanxAdWebView.setWebClickable(true);
        initSettings(tanxAdWebView);
        return tanxAdWebView;
    }

    public void preload(boolean z) {
        LogUtils.d(TAG, "webView preload formSdkInit :" + z);
        if (isPreload(z)) {
            LogUtils.d(TAG, "webView preload开始");
            if (mCachedWebViewStack.size() < 3) {
                LogUtils.d(TAG, "webView preload 通过mainHandler pushCachedWebViewStack");
                if (this.mainHandler == null) {
                    this.mainHandler = new Handler(Looper.getMainLooper());
                }
                long initDelayTime = getInitDelayTime(z);
                LogUtils.d(TAG, "webView preload delayTime毫秒 :" + initDelayTime);
                this.mainHandler.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.web.webview.PreloadWebView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PreloadWebView.this.pushCachedWebViewStack();
                    }
                }, initDelayTime);
                return;
            }
            LogUtils.d(TAG, "webView preload mCachedWebViewStack已满，取消");
            return;
        }
        LogUtils.d(TAG, "preload取消");
    }

    private PreloadWebView() {
    }
}
