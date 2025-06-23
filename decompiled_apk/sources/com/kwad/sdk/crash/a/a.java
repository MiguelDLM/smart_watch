package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* loaded from: classes11.dex */
public final class a {
    private static Context aAl;
    private static String aHe;

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        return true;
    }

    public static File Ip() {
        File file;
        if (!TextUtils.isEmpty(aHe)) {
            file = new File(aHe);
        } else {
            file = new File(getDataDir(aAl), "kwad_ex");
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File Iq() {
        return new File(Ip(), "java_crash/dump");
    }

    public static File Ir() {
        return new File(Ip(), "anr_log/dump");
    }

    public static File Is() {
        return new File(Ip(), "native_crash_log/dump");
    }

    private static File getDataDir(Context context) {
        int i = Build.VERSION.SDK_INT;
        File file = null;
        if (i >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        if (i >= 24) {
            file = context.getDataDir();
        }
        if (file == null) {
            file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (!file.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return file;
    }

    public static void init(@NonNull Context context, @Nullable String str) {
        aAl = context;
        aHe = str;
    }
}
