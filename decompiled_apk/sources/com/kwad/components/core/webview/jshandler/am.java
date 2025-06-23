package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class am implements com.kwad.sdk.core.webview.c.a {
    private List<c> mHolders = new ArrayList();

    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.download.a.a {
        private c Yp;

        public a(c cVar) {
            this.Yp = cVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            am.a(this.Yp, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            am.a(this.Yp, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            am.a(this.Yp, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            am.a(this.Yp, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i) {
            am.a(this.Yp, 3, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            am.a(this.Yp, 2, (i * 1.0f) / 100.0f);
        }
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
    }

    /* loaded from: classes11.dex */
    public static class c {
        private com.kwad.components.core.e.d.c Yq;
        private a Yr;
        private AdTemplate mAdTemplate;
        private com.kwad.sdk.core.webview.c.c nt;

        public c(com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
            this.Yq = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void destroy() {
            a aVar;
            com.kwad.components.core.e.d.c cVar = this.Yq;
            if (cVar != null && (aVar = this.Yr) != null) {
                cVar.c(aVar);
            }
        }

        public final long getCreativeId() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.b.e.ec(adTemplate);
        }

        public final void a(a aVar) {
            this.Yq.b(aVar);
            this.Yr = aVar;
        }
    }

    public am(List<AdTemplate> list, List<com.kwad.components.core.e.d.c> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.mHolders.add(new c(list2.get(i), list.get(i)));
            }
        }
    }

    private c K(long j) {
        if (j == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.getCreativeId() == j) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c K = K(bVar.creativeId);
                if (K != null) {
                    K.nt = cVar;
                    K.a(new a(K));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        Iterator<c> it = this.mHolders.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar, int i, float f) {
        if (cVar == null || cVar.nt == null) {
            return;
        }
        com.kwad.sdk.core.e.c.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.nt + f);
        com.kwad.sdk.core.webview.c.c cVar2 = cVar.nt;
        az.a aVar = new az.a();
        aVar.YL = f;
        aVar.status = i;
        aVar.creativeId = cVar.getCreativeId();
        aVar.totalBytes = com.kwad.sdk.core.response.b.e.dS(cVar.mAdTemplate).totalBytes;
        cVar2.a(aVar);
    }
}
