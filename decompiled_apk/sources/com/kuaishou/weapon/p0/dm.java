package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: classes11.dex */
public final class dm {

    /* renamed from: a, reason: collision with root package name */
    private static a f18391a;

    /* loaded from: classes11.dex */
    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private dm() {
    }

    public static String a(Context context) {
        if (b(context)) {
            return "arm64-v8a";
        }
        return "armeabi-v7a";
    }

    public static boolean b(Context context) {
        if (c(context) != a.ARM64_V8A) {
            return false;
        }
        return true;
    }

    private static a c(Context context) {
        a aVar;
        boolean is64Bit;
        a aVar2;
        a aVar3 = f18391a;
        if (aVar3 != null) {
            return aVar3;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            if (is64Bit) {
                aVar2 = a.ARM64_V8A;
            } else {
                aVar2 = a.ARMEABI_V7A;
            }
            f18391a = aVar2;
        } else {
            try {
                Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                if (((Boolean) cls.getDeclaredMethod("is64Bit", null).invoke(cls.getDeclaredMethod("getRuntime", null).invoke(cls, null), null)).booleanValue()) {
                    aVar = a.ARM64_V8A;
                } else {
                    aVar = a.ARMEABI_V7A;
                }
                f18391a = aVar;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        f18391a = a.ARM64_V8A;
                    } else {
                        f18391a = a.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    f18391a = a.UNKNOWN;
                }
            }
        }
        return f18391a;
    }
}
