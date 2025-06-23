package com.kwad.components.offline.a;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.core.n.b.a<IAdLiveOfflineCompo> {

    /* loaded from: classes11.dex */
    public static final class a {
        private static final b ado = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void au(Context context) {
        ui().init(context);
    }

    private static b ui() {
        return a.ado;
    }

    @Override // com.kwad.components.core.n.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        a(context, iAdLiveOfflineCompo);
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) d.b(com.kwad.sdk.core.config.c.asM)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pn() {
        return "LIVE";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String po() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pp() {
        return "3.3.59";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pq() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.59-5a16210b94-483.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pr() {
        return "d4d7aede5bd01c9eaf4bf3cf50b001ef";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String ps() {
        return "ks_live_3359";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pt() {
        return IAdLiveOfflineCompo.IMPL;
    }

    private b() {
    }

    private void a(Context context, final IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.au(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.a.a.class, new com.kwad.components.offline.a.a(iAdLiveOfflineCompo));
                    b.this.pm();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
