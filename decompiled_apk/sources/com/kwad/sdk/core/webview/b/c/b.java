package com.kwad.sdk.core.webview.b.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    public static final Map<String, JSONObject> aFN = new HashMap();
    public static boolean aFO = true;

    /* loaded from: classes11.dex */
    public static class a {
        public String msg;
    }

    public static void a(com.kwad.sdk.g.a.b bVar, int i) {
        com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.aJm).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Jf())));
    }

    public static void ae(String str, String str2) {
        t.putValue(fe(str), "c_" + str2, System.currentTimeMillis());
    }

    private static void af(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void ag(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void c(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        t.putValue(fe(str), "c_responseStart_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    public static void d(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        t.putValue(fe(str), "c_responseEnd_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    private static JSONObject fe(String str) {
        Map<String, JSONObject> map = aFN;
        JSONObject jSONObject = map.get(str);
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            map.put(str, jSONObject2);
            return jSONObject2;
        }
        return jSONObject;
    }

    private static void ff(String str) {
        aFN.remove(str);
    }

    public static void fg(String str) {
        long currentTimeMillis;
        int i;
        JSONObject fe = fe(str);
        long HH = com.kwad.sdk.core.webview.b.a.HG().HH();
        if (HH <= 0) {
            currentTimeMillis = -1;
        } else {
            currentTimeMillis = System.currentTimeMillis() - HH;
        }
        t.putValue(fe, "c_loadUrl", System.currentTimeMillis());
        t.putValue(fe, "c_init_interval", currentTimeMillis);
        if (aFO) {
            i = 1;
        } else {
            i = 2;
        }
        t.putValue(fe, "c_init_state", i);
        aFO = false;
    }

    public static void a(com.kwad.sdk.g.a.b bVar, int i, int i2, String str) {
        com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.aJm).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i2).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Jf())).setFailReason(str));
    }

    public static void a(String str, String str2, int i, String str3, long j) {
        String str4;
        if (i == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        if (j > 60000 || j < 0) {
            j = -1;
        }
        com.kwad.sdk.commercial.b.b(str4, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i).setInterval(String.valueOf(j)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject fe = fe(str2);
        t.putValue(fe, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    int optInt = jSONObject.optInt("status");
                    String optString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG, "");
                    String optString2 = jSONObject.optString("webViewCostParams", "");
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            fe.put(next, jSONObject2.opt(next));
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (optInt == 1) {
                            af(str, str2);
                        } else {
                            ag(str, optString);
                        }
                    }
                    ff(str2);
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                    ff(str2);
                }
            } catch (Throwable th) {
                ff(str2);
                throw th;
            }
        }
    }

    private static void a(String str, String str2, int i, String str3) {
        long currentTimeMillis;
        String str4;
        JSONObject jSONObject = aFN.get(str2);
        if (jSONObject == null) {
            currentTimeMillis = -3;
        } else {
            long optLong = jSONObject.optLong("c_loadUrl");
            if (optLong <= 0) {
                currentTimeMillis = -2;
            } else {
                currentTimeMillis = System.currentTimeMillis() - optLong;
                if (currentTimeMillis > 100000 || currentTimeMillis < 0) {
                    currentTimeMillis = -1;
                }
            }
        }
        if (i == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        com.kwad.sdk.commercial.b.a(str4, new WebViewLoadMsg().setUrl(str).setState(i).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
        ff(str2);
    }
}
