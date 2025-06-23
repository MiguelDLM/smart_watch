package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.bu;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    private com.kwad.components.core.e.d.c La;
    private WebView OA;
    private boolean Wg;
    private KsAppDownloadListener Wr;
    private int Ws = -100;
    private int Wt = 0;
    private com.kwad.sdk.core.webview.b cO;
    private AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0808a extends com.kwad.sdk.core.response.a.a {
        public String packageName;
        public String url;
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.OA = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.cO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str) {
        try {
            C0808a c0808a = new C0808a();
            c0808a.parseJson(new JSONObject(str));
            if (p(c0808a.url, c0808a.packageName)) {
                return;
            }
            if (this.La == null) {
                o(c0808a.url, c0808a.packageName);
            }
            a.C0788a ar = new a.C0788a(this.cO.OA.getContext()).ao(true).ap(false).ar(this.mAdTemplate).ar(false);
            if (this.La.s(ar)) {
                return;
            }
            this.La.d(this.Wr);
            this.La.r(ar);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    private void n(String str, String str2) {
        WebView webView;
        if (this.Wg || TextUtils.isEmpty(str) || (webView = this.OA) == null) {
            return;
        }
        bu.a(webView, str, str2);
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
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.a.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.p(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.p(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.p(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    a.this.p(1, 0);
                } else {
                    a.this.p(2, i);
                }
            }
        };
    }

    public final void destroy() {
        this.Wg = true;
        com.kwad.components.core.e.d.c cVar = this.La;
        if (cVar != null) {
            cVar.c(this.Wr);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (p(str, str2)) {
            return 0;
        }
        if (this.La == null) {
            o(str, str2);
        }
        return this.La.ov();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (p(str, str2)) {
            return 0;
        }
        if (this.La == null) {
            o(str, str2);
        }
        return this.Wt;
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(final String str) {
        bo.runOnUiThread(new az() { // from class: com.kwad.components.core.webview.a.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a.this.aI(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, int i2) {
        this.Wt = i2;
        if (this.Ws != i) {
            this.Ws = i;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            n("onDownLoadStatusCallback", sb.toString());
        }
    }
}
