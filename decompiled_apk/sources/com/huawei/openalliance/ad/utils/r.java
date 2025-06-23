package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public abstract class r {
    public static final String Code = "FileUtil";
    private static final int V = 10;

    private static void B(File file) {
        if (file == null) {
            return;
        }
        int i = 0;
        while (i < 10 && file != null && !aw.Code(V(file))) {
            i++;
            if (file.exists()) {
                fb.Code(Code, "current file exists");
                if (file.isFile()) {
                    I(file);
                    return;
                }
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && TextUtils.equals(V(parentFile), V(file))) {
                fb.I(Code, "parent file is the same as current");
                return;
            }
            file = parentFile;
        }
    }

    public static String Code(Context context) {
        Context createDeviceProtectedStorageContext;
        File dataDir;
        if (Build.VERSION.SDK_INT >= 24) {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            dataDir = createDeviceProtectedStorageContext.getDataDir();
            return V(dataDir);
        }
        String V2 = V(context.getFilesDir());
        int lastIndexOf = V2.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? V2 : V2.substring(0, lastIndexOf);
    }

    private static boolean I(File file) {
        try {
            File file2 = new File(file.getCanonicalPath() + System.currentTimeMillis());
            if (file.renameTo(file2)) {
                return file2.delete();
            }
            return false;
        } catch (IOException unused) {
            fb.I(Code, "deleteSingleFile IOException");
            return false;
        }
    }

    public static String V(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException unused) {
            fb.Z(Code, "get path error");
            return null;
        }
    }

    private static void Z(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        Z(file2);
                    } else {
                        I(file2);
                    }
                }
            }
            I(file);
        }
    }

    public static String Code(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[4];
            if (inputStream.read(bArr, 0, 4) > 0) {
                return v.Code(bArr);
            }
            return null;
        } catch (IOException unused) {
            fb.Z(Code, "fail to read file header");
            return null;
        }
    }

    public static void Code(String str) {
        if (ay.Code(str)) {
            return;
        }
        Z(new File(str));
    }

    public static boolean Code(File file) {
        if (file == null || file.mkdirs()) {
            return true;
        }
        B(file);
        return file.mkdirs();
    }
}
