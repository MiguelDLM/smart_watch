package com.adp.sdk.jsbridge;

import android.webkit.JavascriptInterface;

public class JsInteration {
    private OnJSCallListener mListener;

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
