package com.blankj.utilcode.util;

import android.os.Environment;
import java.io.File;

/* loaded from: classes8.dex */
public final class CleanUtils {
    private CleanUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean cleanCustomDir(String str) {
        return UtilsBridge.deleteAllInDir(UtilsBridge.getFileByPath(str));
    }

    public static boolean cleanExternalCache() {
        if ("mounted".equals(Environment.getExternalStorageState()) && UtilsBridge.deleteAllInDir(Utils.getApp().getExternalCacheDir())) {
            return true;
        }
        return false;
    }

    public static boolean cleanInternalCache() {
        return UtilsBridge.deleteAllInDir(Utils.getApp().getCacheDir());
    }

    public static boolean cleanInternalDbByName(String str) {
        return Utils.getApp().deleteDatabase(str);
    }

    public static boolean cleanInternalDbs() {
        return UtilsBridge.deleteAllInDir(new File(Utils.getApp().getFilesDir().getParent(), "databases"));
    }

    public static boolean cleanInternalFiles() {
        return UtilsBridge.deleteAllInDir(Utils.getApp().getFilesDir());
    }

    public static boolean cleanInternalSp() {
        return UtilsBridge.deleteAllInDir(new File(Utils.getApp().getFilesDir().getParent(), "shared_prefs"));
    }
}
