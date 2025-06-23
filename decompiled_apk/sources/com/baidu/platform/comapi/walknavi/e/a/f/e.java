package com.baidu.platform.comapi.walknavi.e.a.f;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.platform.comapi.walknavi.e.a.f.f;
import com.baidu.platform.comapi.walknavi.e.a.g.h;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class e {
    public static c a(Context context, com.baidu.platform.comapi.walknavi.e.a.a.a aVar, f.a<JSONObject> aVar2) {
        String a2 = a(context, aVar);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String str = com.baidu.platform.comapi.walknavi.e.a.g.d.f9738a + com.baidu.platform.comapi.walknavi.e.a.g.d.b + "/queryARResource";
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("doQueryArResource: " + str);
        d dVar = new d(str, aVar2);
        dVar.execute(a2);
        return dVar;
    }

    public static String a(Context context, com.baidu.platform.comapi.walknavi.e.a.a.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
        } catch (Exception unused) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("doQueryArResource catch Exception");
        }
        if (aVar == null) {
            return jSONObject2.toString();
        }
        String d = aVar.d();
        if (d != null) {
            jSONObject = new JSONObject(d);
        } else {
            jSONObject = new JSONObject();
        }
        UUID a2 = new com.baidu.platform.comapi.walknavi.e.a.g.e(context).a();
        if (a2 != null) {
            jSONObject.put("user_id", a2.toString());
        }
        jSONObject2.put(HttpConstants.HTTP_AR_VALUE, jSONObject.toString());
        String a3 = aVar.a();
        if (!TextUtils.isEmpty(a3)) {
            jSONObject2.put("ar_key", a3);
        }
        String b = aVar.b();
        if (!TextUtils.isEmpty(b)) {
            jSONObject2.put(ARConfigKey.AR_ID, b);
        } else {
            jSONObject2.put(ARConfigKey.AR_ID, "");
        }
        jSONObject2.put(HttpConstants.HTTP_GLES_VERSION, ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion >> 16);
        jSONObject2.put(HttpConstants.HTTP_OS_TYPE_OLD, "android");
        jSONObject2.put(HttpConstants.HTTP_ENGINE_VERSION, com.baidu.platform.comapi.walknavi.e.a.g.b.a());
        jSONObject2.put("app_id", com.baidu.platform.comapi.walknavi.e.a.g.b.a(context));
        jSONObject2.put("device_id", Build.MODEL);
        jSONObject2.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        jSONObject2.put("user_id", a2.toString());
        jSONObject2.put("publish_id", "6");
        if (!com.baidu.platform.comapi.walknavi.e.a.b.f9716a) {
            jSONObject2.put("update_check", 1);
        }
        a(context, jSONObject2);
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("doQueryArResource = " + jSONObject2.toString());
        return jSONObject2.toString();
    }

    public static b a(String str, int i, String str2, boolean z, a<String> aVar) {
        b bVar = new b(str, i, z, aVar);
        bVar.execute(str2);
        return bVar;
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            if (context == null) {
                com.baidu.platform.comapi.walknavi.e.a.g.a.a("bdar: postSystemInfo context is null!!!");
                return;
            }
            long[] a2 = h.a();
            long[] b = h.b();
            Sensor defaultSensor = ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4);
            if (jSONObject != null) {
                jSONObject.put(HttpConstants.OS_BRAND, Build.BRAND.toLowerCase());
                jSONObject.put(HttpConstants.OS_MODEL, Build.MODEL.toLowerCase());
                jSONObject.put(HttpConstants.OS_VERSION_SDK, Build.VERSION.SDK_INT);
                jSONObject.put(HttpConstants.OS_VERSION_RELESE, Build.VERSION.RELEASE);
                jSONObject.put(HttpConstants.OS_WIDTH_PIXELS, context.getResources().getDisplayMetrics().widthPixels);
                jSONObject.put(HttpConstants.OS_HEIGHT_PIXELS, context.getResources().getDisplayMetrics().heightPixels);
                jSONObject.put(HttpConstants.OS_SCALE_PDI, context.getResources().getDisplayMetrics().densityDpi);
                jSONObject.put(HttpConstants.OS_RAM_AVAIL_MEMORY, h.b(context));
                jSONObject.put(HttpConstants.OS_RAM_MEMEORY, h.a(context));
                boolean z = true;
                jSONObject.put(HttpConstants.OS_ROM_AVAIL_MEMORY, a2[1]);
                jSONObject.put(HttpConstants.OS_ROM_MEMORY, a2[0]);
                jSONObject.put(HttpConstants.OS_ROM_SDCARD_AVAIL_MEMORY, b[1]);
                jSONObject.put(HttpConstants.OS_SDCARD_MEMORY, b[0]);
                jSONObject.put(HttpConstants.OS_CPU_NAME, h.c());
                jSONObject.put(HttpConstants.OS_CPU_NUM_CORES, h.d());
                jSONObject.put(HttpConstants.OS_CPU_MIN_FREQ, h.e());
                jSONObject.put(HttpConstants.OS_CPU_MAX_FREQ, h.f());
                jSONObject.put(HttpConstants.OS_CPU_CUR_FREQ, h.g());
                jSONObject.put(HttpConstants.OS_CPU_ABI, Build.CPU_ABI);
                jSONObject.put(HttpConstants.OS_NATIVE_HEAPSIZE, (int) (Runtime.getRuntime().maxMemory() / 1048576));
                if (defaultSensor == null) {
                    z = false;
                }
                jSONObject.put(HttpConstants.OS_NATIVE_SENSOR, z);
                jSONObject.put(HttpConstants.OS_CPU_SUPPORTED_ABIS, Arrays.asList(Build.SUPPORTED_ABIS));
            }
        } catch (Exception unused) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("postSystemInfo catch Exception");
        }
    }
}
