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
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class BridgeWebView extends WebView implements a.C0014a {
    private Map<String, c> mCallbacks = new ArrayMap();
    private a mClient;
    private Gson mGson;
    private boolean mJSLoaded = false;
    private List<Object> mMessages = new ArrayList();
    private long mUniqueId = 0;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f732a;

        public a(b bVar) {
            this.f732a = bVar;
        }

        public void run() {
            BridgeWebView.this.dispatchMessage(this.f732a);
        }
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* access modifiers changed from: private */
    public void dispatchMessage(Object obj) {
        Gson gson = this.mGson;
        if (gson != null) {
            String format = String.format("javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');", new Object[]{gson.toJson(obj).replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\"").replaceAll("(?<=[^\\\\])(')", "\\\\'").replaceAll("%7B", URLEncoder.encode("%7B")).replaceAll("%7D", URLEncoder.encode("%7D")).replaceAll("%22", URLEncoder.encode("%22"))});
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                loadUrl(format);
            }
        }
    }

    private void doSend(String str, Object obj, c cVar) {
        String str2;
        boolean z = obj instanceof String;
        if (z || this.mGson != null) {
            JSRequest jSRequest = new JSRequest();
            if (obj != null) {
                if (z) {
                    str2 = (String) obj;
                } else {
                    str2 = this.mGson.toJson(obj);
                }
                jSRequest.data = str2;
            }
            if (cVar != null) {
                StringBuilder sb = new StringBuilder();
                long j = this.mUniqueId + 1;
                this.mUniqueId = j;
                sb.append(j);
                sb.append("_");
                sb.append(SystemClock.currentThreadTimeMillis());
                String format = String.format("JAVA_CB_%s", new Object[]{sb.toString()});
                this.mCallbacks.put(format, cVar);
                jSRequest.callbackId = format;
            }
            if (!TextUtils.isEmpty(str)) {
                jSRequest.handlerName = str;
            }
            queueMessage(jSRequest);
        }
    }

    private void init() {
        clearCache(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setCacheMode(2);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        a aVar = new a(this);
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

    public void onLoadFinished() {
        this.mJSLoaded = true;
        List<Object> list = this.mMessages;
        if (list != null) {
            for (Object dispatchMessage : list) {
                dispatchMessage(dispatchMessage);
            }
            this.mMessages = null;
        }
    }

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

    public void setWebViewClient(WebViewClient webViewClient) {
        this.mClient.a(webViewClient);
    }

    public void sendToWeb(Object obj, c cVar) {
        doSend((String) null, obj, cVar);
    }

    public void sendToWeb(String str, Object... objArr) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(String.format(BridgeUtil.JAVASCRIPT_STR, new Object[]{String.format(str, objArr)}));
        }
    }

    public BridgeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public BridgeWebView(Context context) {
        super(context);
        init();
    }
}
