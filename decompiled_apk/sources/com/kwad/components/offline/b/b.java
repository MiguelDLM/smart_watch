package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.core.n.b.a<IObiwanOfflineCompo> {

    /* loaded from: classes11.dex */
    public static final class a {
        private static final b adC = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void au(Context context) {
        ul().init(context);
    }

    private static b ul() {
        return a.adC;
    }

    @Override // com.kwad.components.core.n.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IObiwanOfflineCompo iObiwanOfflineCompo) {
        a(context, iObiwanOfflineCompo);
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.atl)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pn() {
        return "OBIWAN";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String po() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pp() {
        return "3.3.56";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pq() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.56-445ef4f109-409.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pr() {
        return "d4a07cc878d997efd944c0182236fa7c";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String ps() {
        return "ks_obiwan_3356";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pt() {
        return IObiwanOfflineCompo.IMPL;
    }

    private b() {
    }

    private void a(Context context, final IObiwanOfflineCompo iObiwanOfflineCompo) {
        iObiwanOfflineCompo.init(context, new d(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.au(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    final com.kwad.components.offline.b.a aVar = new com.kwad.components.offline.b.a(iObiwanOfflineCompo);
                    com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.c.a.class, aVar);
                    com.kwad.sdk.core.e.c.a(new c(aVar.getLog()));
                    b.this.pm();
                    g.b(new g.a() { // from class: com.kwad.components.offline.b.b.1.1
                        private void updateConfigs() {
                            c cVar;
                            if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atl)) {
                                cVar = new c(aVar.getLog());
                            } else {
                                cVar = null;
                            }
                            com.kwad.sdk.core.e.c.a(cVar);
                            aVar.updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.g.a
                        public final void d(@NonNull SdkConfigData sdkConfigData) {
                            updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.g.a
                        public final void qW() {
                            updateConfigs();
                        }
                    });
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
