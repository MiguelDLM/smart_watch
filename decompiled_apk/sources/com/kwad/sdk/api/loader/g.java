package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.utils.bc;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
class g {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final v anC;
    private int anD;
    private String anE;
    private final String mUrl;

    /* loaded from: classes11.dex */
    public interface a {
        void a(a.b bVar);
    }

    public g(v vVar) {
        this.anC = vVar;
        String AU = vVar.AU();
        this.mUrl = AU;
        this.anE = AU;
    }

    private static Map<String, String> AM() {
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", bc.Code);
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Charset", "UTF-8");
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        hashMap.put("User-Agent", RequestParamsUtils.getUserAgent());
        return hashMap;
    }

    private static HttpURLConnection cl(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    private String f(Map<String, String> map) {
        String aM = h.aM(this.anC.getContext());
        if (TextUtils.isEmpty(aM)) {
            aM = this.anC.AV().getSDKVersion();
        }
        int sDKVersionCode = this.anC.AV().getSDKVersionCode();
        JSONObject appInfo = this.anC.AV().getAppInfo();
        JSONObject deviceInfo = this.anC.AV().getDeviceInfo();
        JSONObject networkInfo = this.anC.AV().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        m.putValue(jSONObject, "sdkApiVersion", BuildConfig.VERSION_NAME);
        m.putValue(jSONObject, "sdkApiVersionCode", BuildConfig.VERSION_CODE);
        m.putValue(jSONObject, bn.f.Code, aM);
        m.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        m.putValue(jSONObject, "sdkType", 1);
        m.putValue(jSONObject, "appInfo", appInfo);
        m.putValue(jSONObject, "deviceInfo", deviceInfo);
        m.putValue(jSONObject, "networkInfo", networkInfo);
        m.putValue(jSONObject, "sdkAbi", w.yp());
        String jSONObject2 = jSONObject.toString();
        this.anC.AV().addHp(map);
        JSONObject jSONObject3 = new JSONObject();
        m.putValue(jSONObject3, "version", BuildConfig.VERSION_NAME);
        m.putValue(jSONObject3, com.huawei.openalliance.ad.uriaction.i.Code, appInfo.optString(com.huawei.openalliance.ad.uriaction.i.Code));
        m.putValue(jSONObject3, "message", this.anC.AV().getRM(jSONObject2));
        this.anC.AV().sR(this.mUrl, map, jSONObject3.toString());
        return jSONObject3.toString();
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            Map<String, String> AM = AM();
            String f = f(AM);
            HttpURLConnection cl = cl(this.anE);
            a(cl, AM);
            cl.connect();
            new DataOutputStream(cl.getOutputStream()).write(f.getBytes());
            int responseCode = cl.getResponseCode();
            if (responseCode == 200) {
                String a2 = a(cl.getInputStream());
                a.b bVar = new a.b();
                JSONObject jSONObject = new JSONObject(a2);
                String optString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString) && !"null".equals(optString)) {
                    jSONObject.put("data", new JSONObject(this.anC.AV().getRD(optString)));
                }
                bVar.parseJson(jSONObject);
                aVar.a(bVar);
            } else if (responseCode / 100 == 3) {
                if (this.anD < 21) {
                    this.anE = cl.getHeaderField("Location");
                    this.anD++;
                    a(aVar);
                }
            } else {
                throw new RuntimeException("response code = " + responseCode);
            }
            try {
                cl.disconnect();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(java.io.InputStream r5) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L32
        La:
            int r3 = r5.read(r0)     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L19
            r4 = -1
            if (r3 == r4) goto L1b
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L19
            goto La
        L16:
            r0 = move-exception
            r1 = r2
            goto L4c
        L19:
            r0 = move-exception
            goto L34
        L1b:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L16 java.io.IOException -> L19
            r5.close()     // Catch: java.io.IOException -> L23
            goto L27
        L23:
            r5 = move-exception
            r5.printStackTrace()
        L27:
            r2.close()     // Catch: java.io.IOException -> L2b
            goto L2f
        L2b:
            r5 = move-exception
            r5.printStackTrace()
        L2f:
            return r0
        L30:
            r0 = move-exception
            goto L4c
        L32:
            r0 = move-exception
            r2 = r1
        L34:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L16
            if (r5 == 0) goto L41
            r5.close()     // Catch: java.io.IOException -> L3d
            goto L41
        L3d:
            r5 = move-exception
            r5.printStackTrace()
        L41:
            if (r2 == 0) goto L4b
            r2.close()     // Catch: java.io.IOException -> L47
            goto L4b
        L47:
            r5 = move-exception
            r5.printStackTrace()
        L4b:
            return r1
        L4c:
            if (r5 == 0) goto L56
            r5.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r5 = move-exception
            r5.printStackTrace()
        L56:
            if (r1 == 0) goto L60
            r1.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r5 = move-exception
            r5.printStackTrace()
        L60:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.g.a(java.io.InputStream):java.lang.String");
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
