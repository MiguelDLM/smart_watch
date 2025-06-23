package com.iflytek.sparkchain.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.iflytek.sparkchain.core.Auth;
import com.kuaishou.weapon.p0.bi;
import java.io.File;

/* loaded from: classes10.dex */
public class DeviceIdUtil {
    public static String fa() {
        try {
            return ((TelephonyManager) getContext().getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            Log.i("AEE", "fa:" + e.toString());
            return "";
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String fb() {
        try {
            return Settings.Secure.getString(getContext().getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String fc() {
        String str;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                str = Build.getSerial();
            } else if (i > 24) {
                str = Build.SERIAL;
            } else {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", String.class, String.class).invoke(cls2, "gsm.scril.sn", null);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String fd() {
        return "";
    }

    public static String fe() {
        return Auth.d().c();
    }

    public static boolean ff() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/"};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i] + bi.y).exists()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String fg() {
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
            if (packageInfo == null) {
                return "";
            }
            try {
                return new String(packageInfo.signatures[0].toByteArray());
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static String fh() {
        return getContext().getPackageName();
    }

    public static Context getContext() {
        return Auth.d().a();
    }

    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }
}
