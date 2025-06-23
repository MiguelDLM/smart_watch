package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes11.dex */
public final class at implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c WI;
    private c YB;

    @KsJson
    /* loaded from: classes11.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int status;
    }

    /* loaded from: classes11.dex */
    public interface b {
        void qf();
    }

    /* loaded from: classes11.dex */
    public interface c {
        void qi();
    }

    public at(c cVar) {
        this.YB = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.WI = cVar;
        c cVar2 = this.YB;
        if (cVar2 != null) {
            cVar2.qi();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.WI = null;
    }

    public final void sU() {
        if (this.WI != null) {
            a aVar = new a();
            aVar.status = 1;
            this.WI.a(aVar);
        }
    }
}
