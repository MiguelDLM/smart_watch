package com.alimm.tanx.core.web.webview;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class AdWebViewManager {
    private static String TAG = "AdWebViewManager";
    private TanxAdWebView nowWebView;

    private void preload() {
        PreloadWebView.getInstance().preload(false);
    }

    public void destroy() {
        TanxAdWebView tanxAdWebView = this.nowWebView;
        if (tanxAdWebView != null) {
            tanxAdWebView.destroy();
            TanxAdWebView tanxAdWebView2 = this.nowWebView;
            if (tanxAdWebView2 != null) {
                ViewParent parent = tanxAdWebView2.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.nowWebView);
                }
                this.nowWebView.removeAllViews();
                this.nowWebView.destroy();
                this.nowWebView = null;
            }
        }
    }

    public TanxAdWebView getWebView(Context context) {
        this.nowWebView = PreloadWebView.getInstance().getWebView(context);
        preload();
        return this.nowWebView;
    }
}
