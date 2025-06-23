package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f6223a;
    final /* synthetic */ WebView b;
    final /* synthetic */ ae c;

    public ai(ae aeVar, JSONObject jSONObject, WebView webView) {
        this.c = aeVar;
        this.f6223a = jSONObject;
        this.b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6223a != null && this.b != null) {
            this.b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.f6223a.toString().replace("\"", "\\\"") + "\")");
        }
    }
}
