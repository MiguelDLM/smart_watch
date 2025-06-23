package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public final class ab implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b WQ;
    private a Xt;
    private Handler fS = new Handler(Looper.getMainLooper());

    /* loaded from: classes11.dex */
    public interface a {
        void bA();
    }

    public ab(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.WQ = bVar;
        this.Xt = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.fS.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.fS.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.ab.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                ab.this.Xt.bA();
            }
        });
        cVar.a(null);
    }
}
