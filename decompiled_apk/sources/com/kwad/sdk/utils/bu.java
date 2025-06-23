package com.kwad.sdk.utils;

import XXO0.oIX0oI;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class bu {
    public static void a(WebView webView, String str, String str2) {
        a(webView, x0xO.II0xO0.f34059xoIox + str + oIX0oI.I0Io.f4096II0xO0 + JSONObject.quote(str2) + oIX0oI.I0Io.f4095I0Io, (ValueCallback<String>) null);
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private static void a(final WebView webView, final String str, ValueCallback<String> valueCallback) {
        final ValueCallback valueCallback2 = null;
        runOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.bu.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    webView.evaluateJavascript(str, valueCallback2);
                } catch (Exception unused) {
                }
            }
        });
    }
}
