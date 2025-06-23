package com.alimm.tanx.core.bridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alimm.tanx.core.ad.base.tanxc_if;
import com.alimm.tanx.core.utils.AssetsUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.xXOx;
import x0xO.XO;

/* loaded from: classes.dex */
public class TanxJsBridge implements NotConfused {
    private static final String TAG = "TanxJsBridge";
    Context context;
    private final WebView webView;
    private Integer uniqueId = 0;
    public HashMap<String, Callback> responseCallbacks = new HashMap<>();
    public HashMap<String, JsHandler> messageHandlers = new HashMap<>();

    @SuppressLint({"SetJavaScriptEnabled"})
    public TanxJsBridge(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.addJavascriptInterface(this, PrerollVideoResponse.NORMAL);
    }

    private void dispatch(HashMap<String, Object> hashMap) {
        final String format = String.format("MamaBridge.handleMessageFromNative('%s');", new JSONObject(hashMap).toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace(xXOx.f32950X0o0xo, "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029"));
        try {
            try {
            } catch (Exception e) {
                LogUtils.e(TAG, e);
            }
            if (!tanxc_if.tanxc_if(this.webView)) {
                this.webView.post(new Runnable() { // from class: com.alimm.tanx.core.bridge.I0Io
                    @Override // java.lang.Runnable
                    public final void run() {
                        TanxJsBridge.this.lambda$dispatch$2(format);
                    }
                });
            } else {
                LogUtils.e(TAG, "webView已经回收，无法分发数据，终止！！！！");
                LogUtils.e(TAG, "jsBridge dispatch failed");
            }
        } catch (Throwable th) {
            LogUtils.e(TAG, "jsBridge dispatch failed");
            throw th;
        }
    }

    private void flush(String str) {
        Callback callback;
        if (str == null) {
            System.out.println("Javascript give data is null");
            return;
        }
        HashMap hashMap = (HashMap) JSON.parseObject(str, HashMap.class);
        final String str2 = (String) hashMap.get(XO.f34064XO);
        if (str2 != null) {
            callback = new Callback() { // from class: com.alimm.tanx.core.bridge.oIX0oI
                @Override // com.alimm.tanx.core.bridge.Callback
                public final void call(boolean z, AbstractMap abstractMap) {
                    TanxJsBridge.this.lambda$flush$0(str2, z, abstractMap);
                }
            };
        } else {
            callback = new Callback() { // from class: com.alimm.tanx.core.bridge.II0xO0
                @Override // com.alimm.tanx.core.bridge.Callback
                public final void call(boolean z, AbstractMap abstractMap) {
                    LogUtils.d(TanxJsBridge.TAG, "callbackID is empty");
                }
            };
        }
        LogUtils.d(TAG, str);
        String str3 = (String) hashMap.get(XO.f34065xoIox);
        JSONObject jSONObject = (JSONObject) hashMap.get("data");
        JsHandler jsHandler = this.messageHandlers.get(str3);
        if (jsHandler == null) {
            LogUtils.d(TAG, "jsHandler is null");
            callback.call(false, null);
            return;
        }
        try {
            HashMap hashMap2 = new HashMap();
            if (jSONObject != null) {
                for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                    hashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            jsHandler.handler(hashMap2, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getFromAssets(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(context).open(str)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatch$2(String str) {
        this.webView.evaluateJavascript(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$flush$0(String str, boolean z, AbstractMap abstractMap) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(XO.f34063Oxx0IOOO, str);
        hashMap.put(XO.f34062II0XooXoX, abstractMap);
        hashMap.put("success", Boolean.valueOf(z));
        dispatch(hashMap);
    }

    public void call(String str, HashMap<String, String> hashMap, Callback callback) {
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put(XO.f34065xoIox, str);
        if (hashMap != null) {
            hashMap2.put("data", hashMap);
        }
        if (callback != null) {
            this.uniqueId = Integer.valueOf(this.uniqueId.intValue() + 1);
            String str2 = "native_cb_" + this.uniqueId;
            this.responseCallbacks.put(str2, callback);
            hashMap2.put(XO.f34064XO, str2);
        }
        dispatch(hashMap2);
    }

    public void injectJavascript() {
        String fromAssets = getFromAssets(this.context, "mama.js");
        this.webView.loadUrl(x0xO.II0xO0.f34059xoIox + fromAssets);
    }

    public void postEvent(String str, Map<String, Object> map) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("eventName", str);
        hashMap.put("eventData", map);
        dispatch(hashMap);
    }

    @JavascriptInterface
    public void postMessage(String str) {
        flush(str);
    }

    public void ready() {
    }

    public void register(String str, JsHandler jsHandler) {
        this.messageHandlers.put(str, jsHandler);
    }

    public void remove(String str) {
        this.messageHandlers.remove(str);
    }
}
