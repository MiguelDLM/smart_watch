package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.k;

/* loaded from: classes11.dex */
public class KsAdWebView extends com.kwad.sdk.core.webview.c {

    @NonNull
    private c.a Ih;
    private com.kwad.sdk.core.webview.a.c aFd;
    private String aFe;
    private long aFf;

    @Nullable
    private com.kwad.sdk.core.webview.d aFg;
    private String mUniqueId;

    /* loaded from: classes11.dex */
    public class a implements DownloadListener {
        private a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            boolean o = br.o(KsAdWebView.this, 100);
            com.kwad.sdk.core.e.c.d("KsAdWebView", "onDownloadStart: currentVisible " + o);
            if (!o || !KsAdWebView.this.Ih.HF()) {
                return;
            }
            if (KsAdWebView.this.Ih != null && KsAdWebView.this.Ih.getAdTemplate() != null && KsAdWebView.this.Ih.HD()) {
                com.kwad.sdk.core.response.b.e.dS(KsAdWebView.this.Ih.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                KsAdWebView.this.Ih.getAdTemplate().isWebViewDownload = true;
                c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
                if (readyClientConfig != null) {
                    readyClientConfig.ek(KsAdWebView.this.Ih.getAdTemplate());
                }
                ((com.kwad.sdk.service.a.a) ServiceProvider.get(com.kwad.sdk.service.a.a.class)).g(l.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.Ih.getAdTemplate());
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                KsAdWebView.this.getContext().startActivity(intent);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }

        public /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes11.dex */
    public interface c {
        void qb();
    }

    /* loaded from: classes11.dex */
    public interface d {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes11.dex */
    public interface e {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i, String str, String str2);
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    private String Hy() {
        return "KSADSDK_V3.3.63_" + getContext().getPackageName() + "_" + k.cd(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.a.c cVar = this.aFd;
        if (cVar != null && cVar.getClientConfig() != null) {
            return this.aFd.getClientConfig();
        }
        return null;
    }

    private void init(Context context) {
        com.kwad.sdk.core.e.c.i("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings a2 = bt.a(this);
        a2.setUseWideViewPort(true);
        a2.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.aFg != null) {
                    KsAdWebView.this.aFg.c(KsAdWebView.this.Ih);
                }
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (KsAdWebView.this.aFg != null) {
                    com.kwad.sdk.core.webview.d unused = KsAdWebView.this.aFg;
                    com.kwad.sdk.core.webview.d.d(KsAdWebView.this.Ih);
                }
            }
        };
        this.aFd = cVar;
        cVar.L(this.mUniqueId);
        setWebViewClient(this.aFd);
        setWebChromeClient(new com.kwad.sdk.core.webview.a.b());
        setDownloadListener(new a(this, (byte) 0));
        a2.setUserAgentString(a2.getUserAgentString() + Hy());
        this.Ih = new c.a(getContext());
    }

    private void setAccessibilityStateDisable(Context context) {
    }

    public c.a getClientConfig() {
        return this.Ih;
    }

    public long getLoadTime() {
        return this.aFf;
    }

    public String getLoadUrl() {
        return this.aFe;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        com.kwad.sdk.core.webview.b.c.b.fg(this.mUniqueId);
        this.aFe = str;
        this.aFf = System.currentTimeMillis();
        super.loadUrl(str);
    }

    public final void onActivityCreate() {
        com.kwad.sdk.core.webview.d dVar = this.aFg;
        if (dVar != null) {
            dVar.a(this.Ih);
        }
    }

    public final void onActivityDestroy() {
        release();
        com.kwad.sdk.core.webview.d dVar = this.aFg;
        if (dVar != null) {
            dVar.b(this.Ih);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        c.a aVar = this.Ih;
        if (aVar != null && aVar.qa() != null) {
            this.Ih.qa().qb();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.Ih.aC(System.currentTimeMillis());
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClientConfig(c.a aVar) {
        this.aFd.setClientConfig(aVar);
        if (this.Ih.HE()) {
            this.aFg = new com.kwad.sdk.core.webview.d();
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.framework.a.a.md.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.a.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.framework.a.a.md.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.a.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        init(context);
    }
}
