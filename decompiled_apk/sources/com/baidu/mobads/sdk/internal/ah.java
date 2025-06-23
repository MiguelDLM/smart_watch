package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class ah implements NativeCPUManager.DataPostBackListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f6222a;
    final /* synthetic */ ae b;

    public ah(ae aeVar, Object obj) {
        this.b = aeVar;
        this.f6222a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(JSONObject jSONObject) {
        Object obj = this.f6222a;
        if (obj instanceof Activity) {
            View findViewById = ((Activity) obj).findViewById(17);
            if (findViewById instanceof WebView) {
                this.b.a((WebView) findViewById, jSONObject);
            }
        }
    }
}
