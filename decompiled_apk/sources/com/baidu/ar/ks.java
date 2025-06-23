package com.baidu.ar;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.constants.HttpConstants;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ks {
    private static String Dt;

    public static void a(Context context, Map<String, Object> map) {
        if (map == null) {
            return;
        }
        String aipAppId = DuMixARConfig.getAipAppId();
        map.put(HttpConstants.AIP_APP_ID, Integer.valueOf(TextUtils.isEmpty(aipAppId) ? 0 : Integer.parseInt(aipAppId)));
        map.put(HttpConstants.IS_AIP, "3");
        Object[] signatureAndTime = ARConfig.getSignatureAndTime();
        map.put(HttpConstants.SIGN, signatureAndTime[0]);
        map.put("timestamp", signatureAndTime[1]);
        map.put("user_id", v(context));
        map.put("cuid", ARConfig.getCUID());
    }

    public static void b(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return;
        }
        jSONObject.put("user_id", v(context));
        jSONObject.put("cuid", ARConfig.getCUID());
    }

    public static void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String aipAppId = DuMixARConfig.getAipAppId();
        a(jSONObject, TextUtils.isEmpty(aipAppId) ? 0 : Integer.parseInt(aipAppId), ARConfig.getSignatureAndTime());
    }

    public static String v(Context context) {
        if (Dt == null && context != null) {
            UUID hg = new kk(context).hg();
            Dt = hg != null ? hg.toString() : "";
        }
        return Dt;
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            kf.cl("bdar: addSystemInfo context/httpParams is null!!!");
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
        jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
        jSONObject.put("hardware", Build.HARDWARE);
        jSONObject.put(HttpConstants.HTTP_MANUFACTURER, Build.MANUFACTURER);
    }

    public static void a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context == null || jSONObject == null) {
            return;
        }
        String arValue = ARConfig.getArValue();
        jSONObject.put(HttpConstants.HTTP_AR_VALUE, (arValue != null ? new JSONObject(arValue) : new JSONObject()).toString());
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("ar_key", str);
        }
        if (TextUtils.isEmpty(str2)) {
            jSONObject.put(ARConfigKey.AR_ID, "");
        } else {
            jSONObject.put(ARConfigKey.AR_ID, str2);
        }
    }

    private static void a(JSONObject jSONObject, int i, Object[] objArr) {
        jSONObject.put(HttpConstants.AIP_APP_ID, i);
        jSONObject.put(HttpConstants.IS_AIP, "3");
        jSONObject.put(HttpConstants.SIGN, objArr[0]);
        jSONObject.put("timestamp", objArr[1]);
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        a(jSONObject, TextUtils.isEmpty(str) ? 0 : Integer.parseInt(str), ARConfig.getSignatureAndTime(str, str2));
    }
}
