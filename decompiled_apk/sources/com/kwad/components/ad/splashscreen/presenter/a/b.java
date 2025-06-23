package com.kwad.components.ad.splashscreen.presenter.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.webview.tachikoma.i;

/* loaded from: classes11.dex */
public final class b extends i {
    public b(Context context, int i, int i2) {
        super(context, i, i2);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void f(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dt(tn()))) {
            com.kwad.components.ad.splashscreen.monitor.b.kW().c(tn(), str2);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void g(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dt(tn()))) {
            com.kwad.components.ad.splashscreen.monitor.b.kW().d(tn(), str2);
        }
    }
}
