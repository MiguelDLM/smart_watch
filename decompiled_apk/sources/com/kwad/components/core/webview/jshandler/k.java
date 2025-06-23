package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class k implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.e.d.c La;
    private KsAppDownloadListener Wr;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private com.kwad.sdk.core.webview.c.c nt;

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String WP;
        public String packageName;
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    public k(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    private synchronized void o(String str, String str2) {
        this.La = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.Wr == null) {
            KsAppDownloadListener sQ = sQ();
            this.Wr = sQ;
            this.La.b(sQ);
        }
    }

    private static boolean p(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private KsAppDownloadListener sQ() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.k.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                k.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                k.this.p(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                k.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                k.this.p(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                k.this.p(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    k.this.p(1, 0);
                } else {
                    k.this.p(2, i);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "installAppForDownload";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.nt = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, int i2) {
        if (this.nt != null) {
            b bVar = new b();
            bVar.status = i;
            bVar.progress = i2;
            this.nt.a(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.nt = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            if (p(aVar.WP, aVar.packageName)) {
                cVar.onError(-1, "param is empty");
                return;
            }
            if (this.La == null) {
                o(aVar.WP, aVar.packageName);
            }
            a.C0788a ar = new a.C0788a(this.mContext).ao(true).ap(false).ar(this.mAdTemplate).ar(false);
            if (this.La.s(ar)) {
                return;
            }
            this.La.d(this.Wr);
            this.La.r(ar);
        } catch (Exception unused) {
            cVar.onError(-1, "data parse error");
        }
    }
}
