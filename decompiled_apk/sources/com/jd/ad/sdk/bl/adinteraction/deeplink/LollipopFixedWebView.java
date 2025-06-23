package com.jd.ad.sdk.bl.adinteraction.deeplink;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/* loaded from: classes10.dex */
public class LollipopFixedWebView extends WebView {
    public LollipopFixedWebView(Context context) {
        super(jad_an(context));
    }

    public static Context jad_an(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return context.createConfigurationContext(new Configuration());
        }
        return context;
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet) {
        super(jad_an(context), attributeSet);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i) {
        super(jad_an(context), attributeSet, i);
    }

    @TargetApi(21)
    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(jad_an(context), attributeSet, i, i2);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(jad_an(context), attributeSet, i, z);
    }
}
