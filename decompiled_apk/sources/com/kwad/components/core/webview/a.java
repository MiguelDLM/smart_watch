package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.c.d;
import com.kwad.sdk.core.webview.c.e;
import com.kwad.sdk.core.webview.c.f;
import com.kwad.sdk.utils.bu;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    private WebView OA;
    private final Map<String, com.kwad.sdk.core.webview.c.a> We = new ConcurrentHashMap(32);
    private com.kwad.sdk.core.webview.c.a Wf = new d();
    private boolean Wg;

    public a(WebView webView) {
        this.OA = webView;
        sE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2) {
        if (this.Wg) {
            com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callJS after destroy jsInterface, " + str2);
        } else {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callJS callback is empty");
                return;
            }
            com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.OA;
            if (webView == null) {
                return;
            }
            bu.a(webView, str, str2);
        }
    }

    private void sE() {
        a(new com.kwad.sdk.core.webview.d.a());
        a(new com.kwad.sdk.core.webview.d.b());
        a(new z());
    }

    public final void b(com.kwad.sdk.core.webview.c.a aVar) {
        if (!TextUtils.isEmpty(aVar.getKey())) {
            this.We.put(aVar.getKey(), aVar);
        } else {
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.webview.c.c cVar;
        com.kwad.sdk.core.e.c.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final com.kwad.sdk.core.webview.c.b bVar = new com.kwad.sdk.core.webview.c.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.c.a aVar = this.We.get(bVar.aFQ);
            if (aVar == null) {
                aVar = this.Wf;
            }
            WebView webView = this.OA;
            if (webView != null && (webView instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) webView;
                com.kwad.sdk.core.webview.b.c.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.aFQ, bVar.data);
            }
            if (aVar != null) {
                if (!TextUtils.isEmpty(bVar.aFR)) {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.1
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                            a.this.n(bVar.aFR, new f(bVar2).toJson().toString());
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i, String str2) {
                            a.this.n(bVar.aFR, new e(i, str2).toJson().toString());
                        }
                    };
                } else {
                    cVar = new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.2
                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                        }

                        @Override // com.kwad.sdk.core.webview.c.c
                        public final void onError(int i, String str2) {
                        }
                    };
                }
                aVar.a(bVar.data, cVar);
                return;
            }
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "bridgeHandler is null");
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "callAdBridge JSONException:" + e);
        }
    }

    public final void destroy() {
        com.kwad.sdk.core.e.c.i("KSAdJSBridge", "destroy jsInterface");
        Iterator<Map.Entry<String, com.kwad.sdk.core.webview.c.a>> it = this.We.entrySet().iterator();
        while (it.hasNext()) {
            com.kwad.sdk.core.webview.c.a value = it.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.Wg = true;
    }

    public final void a(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.We.containsKey(aVar.getKey())) {
            com.kwad.sdk.core.e.c.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
        }
        this.We.put(aVar.getKey(), aVar);
    }
}
