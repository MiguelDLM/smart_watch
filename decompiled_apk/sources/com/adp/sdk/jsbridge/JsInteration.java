package com.adp.sdk.jsbridge;

import android.webkit.JavascriptInterface;

/* loaded from: classes.dex */
public class JsInteration {
    private OnJSCallListener mListener;

    /* loaded from: classes.dex */
    public interface OnJSCallListener {
        void onJSCall(String str);
    }

    public OnJSCallListener getListener() {
        return this.mListener;
    }

    @JavascriptInterface
    public void onJSCall(String str) {
        OnJSCallListener onJSCallListener = this.mListener;
        if (onJSCallListener != null) {
            onJSCallListener.onJSCall(str);
        }
    }

    public void setListener(OnJSCallListener onJSCallListener) {
        this.mListener = onJSCallListener;
    }
}
