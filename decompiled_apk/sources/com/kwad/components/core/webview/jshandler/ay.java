package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class ay implements com.kwad.sdk.core.webview.c.a {
    private final a YH;

    /* loaded from: classes11.dex */
    public interface a {
        @MainThread
        void bB();
    }

    public ay(a aVar) {
        this.YH = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        bo.runOnUiThread(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.ay.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (ay.this.YH != null) {
                    ay.this.YH.bB();
                }
                cVar.a(null);
            }
        });
    }
}
