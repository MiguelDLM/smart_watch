package com.alimm.tanx.core.web.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/* loaded from: classes.dex */
public class TanxAdWebView extends WebView {
    private boolean clickable;
    private OnScrollChangedCallback mOnScrollChangedCallback;

    public TanxAdWebView(Context context) {
        super(context);
        this.clickable = true;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangedCallback onScrollChangedCallback = this.mOnScrollChangedCallback;
        if (onScrollChangedCallback != null) {
            onScrollChangedCallback.onScroll(i, i2);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.clickable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setOnScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback) {
        this.mOnScrollChangedCallback = onScrollChangedCallback;
    }

    public void setWebClickable(boolean z) {
        this.clickable = z;
    }

    public TanxAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clickable = true;
    }

    public TanxAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clickable = true;
    }

    public TanxAdWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.clickable = true;
    }
}
