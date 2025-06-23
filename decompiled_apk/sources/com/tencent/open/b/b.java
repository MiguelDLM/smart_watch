package com.tencent.open.b;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class b extends WebView {
    public b(Context context) {
        super(context);
        oIX0oI();
    }

    public void oIX0oI() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        xxIXOIIO.oOoXoXO("OpenWebView", "removeJSInterface");
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebSettings settings = getSettings();
        if (settings == null) {
            return;
        }
        try {
            Method method = settings.getClass().getMethod("removeJavascriptInterface", String.class);
            if (method != null) {
                method.invoke(this, "searchBoxJavaBridge_");
                method.invoke(this, "accessibility");
                method.invoke(this, "accessibilityTraversal");
                xxIXOIIO.oOoXoXO("OpenWebView", "remove js interface");
            }
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("OpenWebView", "remove js interface.e:" + e.toString());
        }
    }
}
