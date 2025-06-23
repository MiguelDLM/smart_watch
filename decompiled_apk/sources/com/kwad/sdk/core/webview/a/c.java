package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes11.dex */
public class c extends com.kwad.sdk.core.webview.a.a {
    private a Ih;

    /* loaded from: classes11.dex */
    public static class a {
        private int OP;
        private KsAdWebView.c Pm;
        private KsAdWebView.e aFl;
        private KsAdWebView.b aFm;
        private KsAdWebView.d aFn;
        private boolean aFo;
        private boolean aFr;
        private AdTemplate mAdTemplate;
        private final Context mContext;
        private boolean aFp = true;
        private boolean aFq = true;
        private boolean aFk = true;
        private boolean aFs = false;
        private long aFt = 600;
        private long aFu = 0;

        public a(Context context) {
            this.mContext = context;
        }

        private boolean HA() {
            return this.aFs;
        }

        public final boolean HB() {
            return this.aFq;
        }

        public final boolean HC() {
            return this.aFk;
        }

        public final boolean HD() {
            return this.aFp;
        }

        public final boolean HE() {
            return this.aFr;
        }

        public final boolean HF() {
            if (!HA()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.aFu;
            if (j > 0 && currentTimeMillis - j <= this.aFt) {
                return true;
            }
            return false;
        }

        public final KsAdWebView.d Hz() {
            return this.aFn;
        }

        public final a a(KsAdWebView.d dVar) {
            this.aFn = dVar;
            return this;
        }

        public final void aC(long j) {
            this.aFu = j;
        }

        public final a b(KsAdWebView.e eVar) {
            this.aFl = eVar;
            return this;
        }

        public final a bs(boolean z) {
            this.aFs = true;
            return this;
        }

        public final a bt(boolean z) {
            this.aFo = true;
            return this;
        }

        public final a bu(boolean z) {
            this.aFq = z;
            return this;
        }

        public final a bv(boolean z) {
            this.aFp = z;
            return this;
        }

        public final a bw(boolean z) {
            this.aFr = true;
            return this;
        }

        public final a c(KsAdWebView.c cVar) {
            this.Pm = cVar;
            return this;
        }

        public final a dx(int i) {
            this.OP = i;
            return this;
        }

        public final a ek(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.e ik() {
            return this.aFl;
        }

        public final KsAdWebView.b mH() {
            return this.aFm;
        }

        public final com.kwad.sdk.core.adlog.c.a ok() {
            return com.kwad.sdk.core.adlog.c.a.BZ().cI(this.OP).cJ(this.aFo ? 1 : 0);
        }

        public final KsAdWebView.c qa() {
            return this.Pm;
        }

        public final a a(KsAdWebView.b bVar) {
            this.aFm = bVar;
            return this;
        }
    }

    public static int a(@NonNull a aVar, String str) {
        int E = com.kwad.sdk.core.download.a.b.E(aVar.getContext(), str);
        if (E == 1) {
            if (aVar.mH() != null) {
                aVar.mH().onSuccess();
            }
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), "", 2, (com.kwad.sdk.core.adlog.c.a) null);
        } else {
            if (aVar.mH() != null) {
                aVar.mH().onFailed();
            }
            if (E == -1) {
                com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), "", 2, null);
            }
        }
        return E;
    }

    private boolean eU(String str) {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            if (!str.startsWith("tel:") && !str.startsWith("sms:")) {
                a aVar = this.Ih;
                if (aVar != null) {
                    if (aVar.HB()) {
                        a(this.Ih, str);
                        return true;
                    }
                    if (eV(str)) {
                        return true;
                    }
                }
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            a aVar2 = this.Ih;
            if (aVar2 != null) {
                aVar2.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }

    private static boolean eV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("hwfastapp://") && !str.startsWith("hap://app") && !str.startsWith("intent://hapjs.org/") && !str.startsWith("intent://")) {
            return false;
        }
        return true;
    }

    public final void L(String str) {
        this.mUniqueId = str;
    }

    public final a getClientConfig() {
        return this.Ih;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageFinished");
        a aVar = this.Ih;
        if (aVar != null && aVar.ik() != null) {
            this.Ih.ik().onPageFinished();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageStart");
        a aVar = this.Ih;
        if (aVar != null && aVar.ik() != null) {
            this.Ih.ik().onPageStart();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.kwad.sdk.core.e.c.d("KsAdWebViewClient", "onReceivedError " + i);
        a aVar = this.Ih;
        if (aVar != null && aVar.ik() != null) {
            this.Ih.ik().onReceivedHttpError(i, str, str2);
        }
        com.kwad.sdk.core.webview.b.c.b.ag(str2, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean didCrash;
        if (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null) {
            didCrash = renderProcessGoneDetail.didCrash();
            if (didCrash) {
                return true;
            }
        }
        if (super.onRenderProcessGone(webView, renderProcessGoneDetail)) {
            return true;
        }
        return false;
    }

    public final void setClientConfig(a aVar) {
        this.Ih = aVar;
        setNeedHybridLoad(aVar.HC());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.e.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "shouldOverrideUrlLoading");
        a aVar = this.Ih;
        if (aVar == null || !aVar.HF() || ((this.Ih.Hz() != null && this.Ih.Hz().shouldOverrideUrlLoading(webView, str)) || eU(str))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
