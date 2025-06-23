package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import java.io.File;

/* loaded from: classes10.dex */
public abstract class av {
    private static final String Code = "StoUtils";

    public static String B(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                return r.V(externalCacheDir);
            }
            return null;
        } catch (Exception unused) {
            fb.I(Code, "getExternalFilesDir exception, use memory card folder.");
            return null;
        }
    }

    public static String Code(Context context) {
        String I;
        return (!V() || (I = I(context)) == null) ? V(context) : I;
    }

    public static String I(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return r.V(externalFilesDir);
            }
        } catch (Exception unused) {
            fb.I(Code, "getExternalFilesDir exception, use memory card folder.");
        }
        return null;
    }

    public static String V(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? "" : r.V(filesDir);
    }

    public static String Z(Context context) {
        File cacheDir;
        return (context == null || (cacheDir = context.getCacheDir()) == null) ? "" : r.V(cacheDir);
    }

    public static boolean Code() {
        try {
            if (bc.Code()) {
                return Environment.isExternalStorageRemovable();
            }
            return true;
        } catch (Throwable th) {
            fb.I(Code, "isExternalStorageRemovable, " + th.getClass().getSimpleName());
            return true;
        }
    }

    private static boolean V() {
        return TextUtils.equals("mounted", Environment.getExternalStorageState()) || !Code();
    }
}
