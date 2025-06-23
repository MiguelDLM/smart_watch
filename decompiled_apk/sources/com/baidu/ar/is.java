package com.baidu.ar;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class is implements in {
    public JSONObject a(JSONObject jSONObject, ij ijVar) {
        String fT = ijVar.fT();
        if (fT != null) {
            jSONObject.put("_uniq", fT);
        }
        return jSONObject;
    }

    public Map<String, Object> i(List<ij> list) {
        Object bC;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ij ijVar = list.get(0);
        ArrayList<String> arrayList = new ArrayList();
        Iterator<String> keys = ijVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!"event_id".equals(next) && (bC = ijVar.bC(next)) != null) {
                hashMap.put(next, bC);
                hashMap2.put(next, bC);
                arrayList.add(next);
            }
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            ij ijVar2 = list.get(i);
            for (String str : arrayList) {
                if (hashMap2.containsKey(str) && !hashMap.get(str).equals(ijVar2.bC(str))) {
                    hashMap2.remove(str);
                }
            }
        }
        return hashMap2;
    }

    public void k(JSONObject jSONObject) {
        jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
        jSONObject.put(HttpConstants.IS_AIP, "3");
        Object[] signatureAndTime = ARConfig.getSignatureAndTime();
        jSONObject.put(HttpConstants.SIGN, signatureAndTime[0]);
        jSONObject.put("timestamp", signatureAndTime[1]);
    }

    public void l(JSONObject jSONObject) {
        String str;
        int i;
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        newRequest.setUrl(kw.ho()).setMethod("POST").setBody(jSONObject);
        IHttpResponse execute = newRequest.execute();
        if (execute.isSuccess()) {
            i = execute.getCode();
            str = execute.getContent();
        } else {
            str = "";
            i = 0;
        }
        if (i != 200 || !str.equals("success")) {
            throw new IOException(String.format("stats response is error. code: %d response: %s", Integer.valueOf(i), str));
        }
    }

    @Override // com.baidu.ar.in
    public void a(Context context, ij ijVar) {
        if (context == null) {
            throw new SecurityException("context is cleared");
        }
        try {
            JSONObject cZ = ijVar.cZ();
            a(cZ, ijVar);
            a(cZ, context);
            l(cZ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.ar.in
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.content.Context r8, java.util.List<com.baidu.ar.ij> r9) {
        /*
            r7 = this;
            if (r8 == 0) goto L7c
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r1 = 0
            java.util.Map r2 = r7.i(r9)     // Catch: org.json.JSONException -> L13
            if (r2 == 0) goto L15
            java.util.Set r3 = r2.keySet()     // Catch: org.json.JSONException -> L13
            goto L16
        L13:
            r8 = move-exception
            goto L73
        L15:
            r3 = r1
        L16:
            java.util.Iterator r9 = r9.iterator()     // Catch: org.json.JSONException -> L13
        L1a:
            boolean r4 = r9.hasNext()     // Catch: org.json.JSONException -> L13
            if (r4 == 0) goto L44
            java.lang.Object r4 = r9.next()     // Catch: org.json.JSONException -> L13
            com.baidu.ar.ij r4 = (com.baidu.ar.ij) r4     // Catch: org.json.JSONException -> L13
            if (r1 != 0) goto L39
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L13
            r5.<init>()     // Catch: org.json.JSONException -> L13
            java.lang.String r1 = "event_id"
            java.lang.String r6 = "[multi]"
            r5.put(r1, r6)     // Catch: org.json.JSONException -> L36
            r1 = r5
            goto L39
        L36:
            r8 = move-exception
            r1 = r5
            goto L73
        L39:
            org.json.JSONObject r5 = r4.a(r3)     // Catch: org.json.JSONException -> L13
            r7.a(r5, r4)     // Catch: org.json.JSONException -> L13
            r0.put(r5)     // Catch: org.json.JSONException -> L13
            goto L1a
        L44:
            if (r1 == 0) goto L76
            if (r2 == 0) goto L6a
            java.util.Set r9 = r2.entrySet()     // Catch: org.json.JSONException -> L13
            java.util.Iterator r9 = r9.iterator()     // Catch: org.json.JSONException -> L13
        L50:
            boolean r2 = r9.hasNext()     // Catch: org.json.JSONException -> L13
            if (r2 == 0) goto L6a
            java.lang.Object r2 = r9.next()     // Catch: org.json.JSONException -> L13
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: org.json.JSONException -> L13
            java.lang.Object r3 = r2.getKey()     // Catch: org.json.JSONException -> L13
            java.lang.String r3 = (java.lang.String) r3     // Catch: org.json.JSONException -> L13
            java.lang.Object r2 = r2.getValue()     // Catch: org.json.JSONException -> L13
            r1.put(r3, r2)     // Catch: org.json.JSONException -> L13
            goto L50
        L6a:
            r7.a(r1, r8)     // Catch: org.json.JSONException -> L13
            java.lang.String r8 = "data"
            r1.put(r8, r0)     // Catch: org.json.JSONException -> L13
            goto L76
        L73:
            r8.printStackTrace()
        L76:
            if (r1 == 0) goto L7b
            r7.l(r1)
        L7b:
            return
        L7c:
            java.lang.SecurityException r8 = new java.lang.SecurityException
            java.lang.String r9 = "context is cleared"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.is.a(android.content.Context, java.util.List):void");
    }

    public void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return;
        }
        jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, "android");
        jSONObject.put(HttpConstants.HTTP_OS_TYPE, "android");
        jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, kg.getVersionCode());
        jSONObject.put("app_id", kg.n(context));
        String str = Build.MODEL;
        jSONObject.put("device_id", str);
        int i = Build.VERSION.SDK_INT;
        jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, i);
        jSONObject.put(HttpConstants.OS_BRAND, Build.BRAND.toLowerCase());
        jSONObject.put(HttpConstants.OS_MODEL, str.toLowerCase());
        jSONObject.put(HttpConstants.OS_VERSION_SDK, i);
        jSONObject.put(HttpConstants.OS_VERSION_RELESE, Build.VERSION.RELEASE);
        jSONObject.put(HttpConstants.OS_WIDTH_PIXELS, context.getResources().getDisplayMetrics().widthPixels);
        jSONObject.put(HttpConstants.OS_HEIGHT_PIXELS, context.getResources().getDisplayMetrics().heightPixels);
        jSONObject.put(HttpConstants.OS_SCALE_PDI, context.getResources().getDisplayMetrics().densityDpi);
        long[] romMemroy = ku.getRomMemroy();
        jSONObject.put(HttpConstants.OS_ROM_MEMORY, romMemroy[0]);
        jSONObject.put(HttpConstants.OS_ROM_AVAIL_MEMORY, romMemroy[1]);
        jSONObject.put(HttpConstants.OS_SDCARD_MEMORY, ku.getSDCardTotalSize());
        jSONObject.put(HttpConstants.OS_ROM_SDCARD_AVAIL_MEMORY, ku.getSDAvailableSizeByM());
        jSONObject.put(HttpConstants.OS_RAM_MEMEORY, ku.getRamMemory(context));
        jSONObject.put(HttpConstants.OS_RAM_AVAIL_MEMORY, ku.getAvailMemory(context));
        if (ku.isHasGyroscope(context)) {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 1);
        } else {
            jSONObject.put(HttpConstants.OS_HAS_GYROSCOPE, 0);
        }
        jSONObject.put(HttpConstants.OS_CPU_NAME, ku.getCpuName());
        jSONObject.put(HttpConstants.OS_CPU_NUM_CORES, ku.getNumCores());
        jSONObject.put(HttpConstants.OS_CPU_MIN_FREQ, ku.getMinCpuFreq());
        jSONObject.put(HttpConstants.OS_CPU_MAX_FREQ, ku.getMaxCpuFreq());
        jSONObject.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
        jSONObject.put(HttpConstants.OS_CPU_CUR_FREQ, ku.getCurCpuFreq());
        jSONObject.put(HttpConstants.OS_NATIVE_HEAPSIZE, (int) (Runtime.getRuntime().maxMemory() / 1048576));
        jSONObject.put(HttpConstants.OS_NATIVE_SENSOR, ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null);
        jSONObject.put(HttpConstants.NETWORK_TYPE, kq.u(context));
        jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Arrays.asList(Build.SUPPORTED_ABIS));
        try {
            jSONObject.put(HttpConstants.HTTP_GLES_VERSION, ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        UUID hg = new kk(context).hg();
        String uuid = hg != null ? hg.toString() : "";
        k(jSONObject);
        jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
        jSONObject.put("cuid", ARConfig.getCUID());
        a(context, jSONObject);
        jSONObject.put(HttpConstants.HTTP_OS_TYPE, "android");
        jSONObject.put(HttpConstants.OS_VERSION, Build.MODEL);
        jSONObject.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
        jSONObject.put("user_id", uuid);
        jSONObject.put("device_id", uuid);
        int i = Build.VERSION.SDK_INT;
        jSONObject.put(HttpConstants.OS_VERSION, i);
        jSONObject.put(HttpConstants.APP_VERSION, kg.getVersionCode());
        jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, kg.getVersionCode());
        if (!TextUtils.isEmpty(kg.n(context))) {
            jSONObject.put("app_id", kg.n(context));
        }
        jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, i);
        jSONObject.put("hardware", Build.HARDWARE);
        jSONObject.put("manufacture", Build.MANUFACTURER);
        jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
    }
}
