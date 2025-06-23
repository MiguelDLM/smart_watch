package com.huawei.hms.ads.jsb;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.huawei.hms.ads.jsb.annotations.OuterVisible;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.ads.jsb.inner.impl.JsBridgeImpl;
import com.huawei.hms.ads.jsbridge.b;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONObject;

@OuterVisible
/* loaded from: classes10.dex */
public class PPSJsBridge extends com.huawei.hms.ads.jsbridge.a {

    /* renamed from: a, reason: collision with root package name */
    private static JsbConfig f17311a;
    private String b = null;
    private WeakReference<WebView> c;
    private IWebView d;
    private boolean e;

    @OuterVisible
    public PPSJsBridge(WebView webView) {
        if (webView == null) {
            b.b("webView object is null, cannot register it.");
            return;
        }
        b(webView);
        a();
        webView.addJavascriptInterface(this, "_HwJSBridge");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context b() {
        WebView webView;
        if (this.e) {
            IWebView iWebView = this.d;
            if (iWebView != null) {
                Context context = iWebView.getContext();
                if (context == null) {
                    b.b("custom webView context is null.");
                }
                return context;
            }
        } else {
            WeakReference<WebView> weakReference = this.c;
            if (weakReference != null && (webView = weakReference.get()) != null) {
                return webView.getContext();
            }
        }
        b.b("the webview context is null.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        if (this.e) {
            IWebView iWebView = this.d;
            if (iWebView != null) {
                return a(iWebView);
            }
            return null;
        }
        WeakReference<WebView> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return a(this.c.get());
    }

    @OuterVisible
    public static void init(JsbConfig jsbConfig) {
        f17311a = jsbConfig;
    }

    @OuterVisible
    public void destroy() {
        if (this.b != null) {
            JsBridgeImpl.invoke(b(), "pps.listener.offDownloadChange", "{webid:" + this.b + ooOOo0oXI.f33074oOoXoXO, null, String.class);
        }
        WeakReference<WebView> weakReference = this.c;
        if (weakReference != null) {
            weakReference.clear();
        }
        IWebView iWebView = this.d;
        if (iWebView != null) {
            iWebView.removeJavascriptInterface("_HwJSBridge");
            this.d = null;
        }
    }

    @JavascriptInterface
    public String invoke(String str, String str2) {
        WeakReference<WebView> weakReference = this.c;
        if (weakReference != null && weakReference.get() != null) {
            return JsBridgeImpl.invoke(this.c.get().getContext(), str, str2);
        }
        b.b("this webView is destroyed");
        return null;
    }

    @JavascriptInterface
    public void invokeAsync(final String str, final String str2, final String str3) {
        final JSONObject jSONObject = new JSONObject();
        com.huawei.hms.ads.jsbridge.a.a(new Runnable() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                String str4 = str2;
                final boolean z = true;
                final String str5 = null;
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    z = jSONObject2.optBoolean("top", true);
                    str5 = jSONObject2.optString(Constant.MAP_KEY_UUID);
                    if (!TextUtils.isEmpty(jSONObject2.optString(Constant.MAP_KEY_WEBID))) {
                        PPSJsBridge.this.b = jSONObject2.optString(Constant.MAP_KEY_WEBID);
                    }
                    jSONObject2.put("url", PPSJsBridge.this.c());
                    str4 = jSONObject2.toString();
                } catch (Throwable unused) {
                    b.b("jsb response data error.");
                }
                Context b = PPSJsBridge.this.b();
                if (b == null) {
                    b.b("invoke method param context is null.");
                }
                JsBridgeImpl.invoke(b, str, str4, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str6, CallResult<String> callResult) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(callResult.getData());
                            boolean optBoolean = jSONObject3.optBoolean("complete", true);
                            jSONObject.put("code", callResult.getCode());
                            jSONObject.put("data", jSONObject3);
                            jSONObject.put("msg", callResult.getMsg());
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            PPSJsBridge.this.a(str3, jSONObject.toString(), optBoolean, z, str5);
                        } catch (Throwable unused2) {
                            b.b("jsb response data error.");
                        }
                    }
                }, String.class);
            }
        });
    }

    @OuterVisible
    public PPSJsBridge(IWebView iWebView) {
        if (iWebView == null) {
            b.b("webView object is null, cannot register it.");
            return;
        }
        b(iWebView);
        a();
        iWebView.addJavascriptInterface(this, "_HwJSBridge");
    }

    private void a() {
        JsBridgeImpl.initConfig(b(), f17311a);
    }

    private void b(WebView webView) {
        this.c = new WeakReference<>(webView);
    }

    private void b(IWebView iWebView) {
        this.e = true;
        this.d = iWebView;
    }

    private void a(final String str) {
        com.huawei.hms.ads.jsbridge.a.a(new Runnable() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                if (PPSJsBridge.this.e) {
                    if (PPSJsBridge.this.d != null) {
                        PPSJsBridge.this.d.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2.1
                            @Override // android.webkit.ValueCallback
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onReceiveValue(String str3) {
                            }
                        });
                        return;
                    }
                    str2 = "please register a custom webView object to jsb.";
                } else {
                    if (PPSJsBridge.this.c != null && PPSJsBridge.this.c.get() != null) {
                        ((WebView) PPSJsBridge.this.c.get()).evaluateJavascript(str, new ValueCallback<String>() { // from class: com.huawei.hms.ads.jsb.PPSJsBridge.2.2
                            @Override // android.webkit.ValueCallback
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onReceiveValue(String str3) {
                            }
                        });
                        return;
                    }
                    str2 = "please register a webView object to jsb.";
                }
                b.b(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z, boolean z2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z2) {
            str4 = String.format(Locale.ENGLISH, "if(window['%s']){%s(%s)};", str, str, str2);
            if (z) {
                str4 = str4 + "delete window." + str;
            }
        } else {
            if (str3 == null) {
                str3 = "";
            }
            str4 = "var iframeEles=document.querySelectorAll('iframe');if(iframeEles && iframeEles.length>0){for (let index = 0; index < iframeEles.length; index++) {var iframe = iframeEles[index];if (iframe &&iframe.contentWindow) {iframe.contentWindow.postMessage({ppsMsgType:1,data:" + str2 + ",cb:'" + str + "',complete:" + z + ",uuid:'" + str3 + "'},'*');}}};var myEvent = new CustomEvent(\"tmp\", {detail:{ppsMsgType:1,data:" + str2 + ",cb:'" + str + "',complete:" + z + ",uuid:'" + str3 + "'}});window.dispatchEvent(myEvent);";
        }
        a(str4);
    }
}
