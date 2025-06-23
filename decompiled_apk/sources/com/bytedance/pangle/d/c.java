package com.bytedance.pangle.d;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.h;
import com.bytedance.pangle.util.i;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import java.io.File;

/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static File f10526a;
    private static File b;
    private static File c;

    private static String a(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String b() {
        Application appApplication = Zeus.getAppApplication();
        if (c == null) {
            c = new File(appApplication.getFilesDir(), ".pangle" + h.f10572a);
        }
        return a(c);
    }

    public static String c() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + h.b);
            if (externalFilesDir != null) {
                return a(externalFilesDir);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void d() {
        if (f10526a == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + h.c);
            f10526a = file;
            a(file);
        }
    }

    public static String e(String str, int i) {
        return new File(a(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String f(String str, int i) {
        return new File(a(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static String g(String str, int i) {
        return new File(a(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String h(String str, int i) {
        if (i.i()) {
            return a(str, "version-".concat(String.valueOf(i)), "apk", "temp", "oat", com.bytedance.pangle.e.b.a());
        }
        return a(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String i(String str, int i) {
        return a(str, "version-".concat(String.valueOf(i)), "secondary-dexes");
    }

    private static String a(String... strArr) {
        d();
        File file = f10526a;
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return a(file);
    }

    public static String d(String str, int i) {
        return a(str, "version-".concat(String.valueOf(i)), NativeSymbolGenerator.LIB_PREFIX);
    }

    public static String b(String str, int i) {
        return new File(a(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String c(String str, int i) {
        if (i.i()) {
            return a(str, "version-".concat(String.valueOf(i)), "apk", "oat", com.bytedance.pangle.e.b.a());
        }
        return a(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String a() {
        Application appApplication = Zeus.getAppApplication();
        if (b == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + h.b);
            }
            b = downloadDir;
        }
        return a(b);
    }

    public static String a(String str, int i) {
        d();
        File file = f10526a;
        String[] strArr = {str, "version-".concat(String.valueOf(i))};
        for (int i2 = 0; i2 < 2; i2++) {
            String str2 = strArr[i2];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String a(String str) {
        return a(str);
    }
}
