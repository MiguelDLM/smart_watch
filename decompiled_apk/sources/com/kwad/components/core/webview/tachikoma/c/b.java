package com.kwad.components.core.webview.tachikoma.c;

import android.app.Activity;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.k;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.mvp.a {
    public com.kwad.components.core.webview.tachikoma.e.c Tf;
    public StyleTemplate Th;
    public e Zt;
    public com.kwad.sdk.widget.e abl;
    public k abm;
    public com.kwad.components.core.webview.tachikoma.k abn;
    public boolean abo;
    public e.a abp;
    public Activity mActivity;
    public AdResultData mAdResultData;

    /* renamed from: xo, reason: collision with root package name */
    public String f18469xo;
    public long xt;

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.Zt = null;
        this.mActivity = null;
        this.abl = null;
    }
}
