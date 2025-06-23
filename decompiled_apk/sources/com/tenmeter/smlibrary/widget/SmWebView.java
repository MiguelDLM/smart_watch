package com.tenmeter.smlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;

/* loaded from: classes13.dex */
public class SmWebView extends WebView {
    public SmWebView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public SmWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SmWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public SmWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
