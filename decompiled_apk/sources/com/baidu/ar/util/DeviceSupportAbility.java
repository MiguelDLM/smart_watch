package com.baidu.ar.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.NavigationType;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.fa;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.ks;
import com.baidu.ar.kw;
import com.baidu.ar.ni;
import com.google.ar.core.ArCoreApk;
import com.huawei.hiar.AREnginesApk;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class DeviceSupportAbility {
    private static boolean CS;
    private static NavigationType dr;
    private static boolean du;

    private static JSONObject a(Context context, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            ks.k(jSONObject2);
            ks.b(context, jSONObject2);
            if (!TextUtils.isEmpty(str)) {
                ks.a(context, jSONObject2, str, str2);
            }
            ks.a(context, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jSONObject.put("info", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean checkARCoreSupportVersionCode(Context context) {
        return ((long) context.getPackageManager().getPackageInfo("com.google.ar.core", 0).versionCode) >= 210260663;
    }

    public static String getBlacklistParams(Context context, String str) {
        return a(context, str, ARConfig.getARId()).toString();
    }

    public static NavigationType getNavigationAbilityType(Context context, boolean z) {
        try {
            NavigationType navigationType = dr;
            if (navigationType != null) {
                return navigationType;
            }
            if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) == null) {
                NavigationType navigationType2 = NavigationType.None;
                dr = navigationType2;
                return navigationType2;
            }
            if (l(context)) {
                NavigationType navigationType3 = NavigationType.None;
                dr = navigationType3;
                return navigationType3;
            }
            du = z;
            if (AREnginesApk.isAREngineApkReady(context) && m(context)) {
                NavigationType navigationType4 = NavigationType.AREngine;
                dr = navigationType4;
                return navigationType4;
            }
            if (!ArCoreApk.getInstance().checkAvailability(context).isSupported() || !checkARCoreSupportVersionCode(context)) {
                dr = !z ? NavigationType.ARPedometer : NavigationType.ARIMU;
                return dr;
            }
            dr = NavigationType.ARCore;
            if (!z) {
                dr = NavigationType.ARPedometer;
            }
            return dr;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            e.printStackTrace();
            NavigationType navigationType5 = NavigationType.ARIMU;
            dr = navigationType5;
            return navigationType5;
        } catch (RuntimeException e2) {
            e = e2;
            e.printStackTrace();
            NavigationType navigationType52 = NavigationType.ARIMU;
            dr = navigationType52;
            return navigationType52;
        } catch (Throwable th) {
            e = th;
            e.printStackTrace();
            NavigationType navigationType522 = NavigationType.ARIMU;
            dr = navigationType522;
            return navigationType522;
        }
    }

    public static NavigationType getSelectedNavigationType() {
        return dr;
    }

    public static boolean isOutDoor() {
        return du;
    }

    public static void jumpMarket(Context context) {
        StringBuilder sb;
        if (CS) {
            try {
                Intent intent = new Intent("com.huawei.appmarket.intent.action.AppDetail");
                intent.putExtra("APP_PACKAGENAME", "com.huawei.arengine.service");
                intent.setPackage(x.Y);
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("the target activity is not found: ");
                sb.append(e.getMessage());
                Log.w("DeviceSupportAbility", sb.toString());
            } catch (SecurityException e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("the target app has no permission of media");
                sb.append(e.getMessage());
                Log.w("DeviceSupportAbility", sb.toString());
            }
        }
    }

    private static boolean l(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append("ar");
        sb.append(str);
        sb.append("devices/");
        final File file = new File(filesDir, sb.toString());
        final File file2 = new File(file.getAbsolutePath(), "ar-devices");
        ni.a(kw.hn(), a(context, (String) null, (String) null), new fa() { // from class: com.baidu.ar.util.DeviceSupportAbility.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                httpException.printStackTrace();
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                try {
                    DeviceSupportAbility.a(iHttpResponse.getContent(), file, file2);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return file2.exists();
    }

    private static boolean m(Context context) {
        return ((long) context.getPackageManager().getPackageInfo("com.huawei.arengine.service", 0).versionCode) >= 100000105;
    }

    public static void setNavigationType(NavigationType navigationType) {
        dr = navigationType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, File file, File file2) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("errorNum")) {
            int i = jSONObject.getInt("errorNum");
            if (i != 1 && i != 3) {
                if (i == 0 && file2.exists()) {
                    file2.delete();
                    return;
                }
                return;
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file2.exists()) {
                return;
            }
            file2.createNewFile();
        }
    }
}
