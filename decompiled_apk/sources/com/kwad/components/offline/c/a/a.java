package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class a implements com.kwad.sdk.core.webview.c.c {
    private final IOfflineCompoCallBackFunction adT;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.adT = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void onError(int i, String str) {
        String jSONObject = new com.kwad.sdk.core.webview.c.e(i, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.adT;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void a(final com.kwad.sdk.core.b bVar) {
        if (com.kwad.sdk.core.config.d.CF()) {
            GlobalThreadPools.Gr().submit(new Runnable() { // from class: com.kwad.components.offline.c.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    final String jSONObject = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
                    bo.runOnUiThread(new Runnable() { // from class: com.kwad.components.offline.c.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (a.this.adT != null) {
                                a.this.adT.onSuccess(jSONObject);
                            }
                        }
                    });
                }
            });
            return;
        }
        String jSONObject = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.adT;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(jSONObject);
        }
    }
}
