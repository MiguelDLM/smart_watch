package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.IOException;

/* loaded from: classes10.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17333a = "dl_FileUtil";

    public static String a(Context context) {
        Context createDeviceProtectedStorageContext;
        File dataDir;
        if (Build.VERSION.SDK_INT >= 24) {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            dataDir = createDeviceProtectedStorageContext.getDataDir();
            return a(dataDir);
        }
        String a2 = a(context.getFilesDir());
        int lastIndexOf = a2.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? a2 : a2.substring(0, lastIndexOf);
    }

    public static boolean b(String str) {
        boolean z;
        boolean z2 = true;
        try {
            File file = new File(str);
            String[] list = file.list();
            if (!file.isDirectory() || list == null || list.length <= 0) {
                z = true;
            } else {
                z = true;
                for (String str2 : list) {
                    try {
                        if (z) {
                            if (b(str + File.separator + str2)) {
                                z = true;
                            }
                        }
                        z = false;
                    } catch (Throwable th) {
                        th = th;
                        z2 = z;
                        af.b(f17333a, " delete err: " + th.getClass().getSimpleName());
                        return z2;
                    }
                }
            }
            if (z) {
                if (file.delete()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? str : str.substring(0, lastIndexOf);
    }

    public static String a(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            af.d(f17333a, "getFilePath Exception: " + e.getMessage());
            return null;
        }
    }

    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e) {
            af.d(f17333a, "makeDirectory Exception: " + e.getMessage());
            return false;
        }
    }
}
