package com.adp.sdk.jsbridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adp.sdk.jsbridge.a;
import com.google.gson.Gson;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class BridgeWebView extends WebView implements a.InterfaceC0094a {
    private Map<String, c> mCallbacks;
    private com.adp.sdk.jsbridge.a mClient;
    private Gson mGson;
    private boolean mJSLoaded;
    private List<Object> mMessages;
    private long mUniqueId;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4726a;

        public a(b bVar) {
            this.f4726a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            BridgeWebView.this.dispatchMessage(this.f4726a);
        }
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCallbacks = new ArrayMap();
        this.mMessages = new ArrayList();
        this.mUniqueId = 0L;
        this.mJSLoaded = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchMessage(Object obj) {
        Gson gson = this.mGson;
        if (gson == null) {
            return;
        }
        String format = String.format("javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');", gson.toJson(obj).replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\"").replaceAll("(?<=[^\\\\])(')", "\\\\'").replaceAll("%7B", URLEncoder.encode("%7B")).replaceAll("%7D", URLEncoder.encode("%7D")).replaceAll("%22", URLEncoder.encode("%22")));
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(format);
        }
    }

    private void doSend(String str, Object obj, c cVar) {
        String json;
        boolean z = obj instanceof String;
        if (!z && this.mGson == null) {
            return;
        }
        JSRequest jSRequest = new JSRequest();
        if (obj != null) {
            if (z) {
                json = (String) obj;
            } else {
                json = this.mGson.toJson(obj);
            }
            jSRequest.data = json;
        }
        if (cVar != null) {
            StringBuilder sb = new StringBuilder();
            long j = this.mUniqueId + 1;
            this.mUniqueId = j;
            sb.append(j);
            sb.append("_");
            sb.append(SystemClock.currentThreadTimeMillis());
            String format = String.format("JAVA_CB_%s", sb.toString());
            this.mCallbacks.put(format, cVar);
            jSRequest.callbackId = format;
        }
        if (!TextUtils.isEmpty(str)) {
            jSRequest.handlerName = str;
        }
        queueMessage(jSRequest);
    }

    private void init() {
        clearCache(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setCacheMode(2);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        com.adp.sdk.jsbridge.a aVar = new com.adp.sdk.jsbridge.a(this);
        this.mClient = aVar;
        super.setWebViewClient(aVar);
    }

    private void queueMessage(Object obj) {
        List<Object> list = this.mMessages;
        if (list != null) {
            list.add(obj);
        } else {
            dispatchMessage(obj);
        }
    }

    public void callHandler(String str, String str2, c cVar) {
        doSend(str, str2, cVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.mCallbacks.clear();
    }

    public Map<String, c> getCallbacks() {
        return this.mCallbacks;
    }

    public boolean isJSLoaded() {
        return this.mJSLoaded;
    }

    @Override // com.adp.sdk.jsbridge.a.InterfaceC0094a
    public void onLoadFinished() {
        this.mJSLoaded = true;
        List<Object> list = this.mMessages;
        if (list != null) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                dispatchMessage(it.next());
            }
            this.mMessages = null;
        }
    }

    @Override // com.adp.sdk.jsbridge.a.InterfaceC0094a
    public void onLoadStart() {
        this.mJSLoaded = false;
    }

    public void sendResponse(Object obj, String str) {
        boolean z = obj instanceof String;
        if ((z || this.mGson != null) && !TextUtils.isEmpty(str)) {
            b bVar = new b();
            if (!z) {
                this.mGson.toJson(obj);
            }
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                dispatchMessage(bVar);
            } else {
                post(new a(bVar));
            }
        }
    }

    public void sendToWeb(Object obj) {
        sendToWeb(obj, (c) null);
    }

    public void setGson(Gson gson) {
        this.mGson = gson;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.mClient.a(webViewClient);
    }

    public void sendToWeb(Object obj, c cVar) {
        doSend(null, obj, cVar);
    }

    public void sendToWeb(String str, Object... objArr) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(String.format(BridgeUtil.JAVASCRIPT_STR, String.format(str, objArr)));
        }
    }

    public BridgeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCallbacks = new ArrayMap();
        this.mMessages = new ArrayList();
        this.mUniqueId = 0L;
        this.mJSLoaded = false;
        init();
    }

    public BridgeWebView(Context context) {
        super(context);
        this.mCallbacks = new ArrayMap();
        this.mMessages = new ArrayList();
        this.mUniqueId = 0L;
        this.mJSLoaded = false;
        init();
    }
}
