package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class bc implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private com.kwad.sdk.core.webview.c.c Xm;
    private b YO;

    @KsJson
    /* loaded from: classes11.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int visibility;
    }

    /* loaded from: classes11.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public bc(b bVar) {
        this.YO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.YO;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "setHeaderBar";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.YO = null;
        this.Xm = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Xm = cVar;
        final a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        bo.postOnUiThread(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.bc.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                bc.this.b(aVar);
                if (bc.this.Xm != null) {
                    bc.this.Xm.a(null);
                }
            }
        });
    }
}
