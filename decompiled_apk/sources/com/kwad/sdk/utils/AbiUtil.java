package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: classes11.dex */
public final class AbiUtil {
    private static Abi aPg;

    /* loaded from: classes11.dex */
    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String bQ(Context context) {
        if (isArm64(context)) {
            return "arm64-v8a";
        }
        return "armeabi-v7a";
    }

    private static Abi bR(Context context) {
        Abi abi;
        boolean is64Bit;
        Abi abi2;
        Abi abi3 = aPg;
        if (abi3 != null) {
            return abi3;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            if (is64Bit) {
                abi2 = Abi.ARM64_V8A;
            } else {
                abi2 = Abi.ARMEABI_V7A;
            }
            aPg = abi2;
        } else {
            try {
                if (((Boolean) s.callMethod(s.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue()) {
                    abi = Abi.ARM64_V8A;
                } else {
                    abi = Abi.ARMEABI_V7A;
                }
                aPg = abi;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        aPg = Abi.ARM64_V8A;
                    } else {
                        aPg = Abi.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    aPg = Abi.UNKNOWN;
                }
            }
        }
        return aPg;
    }

    public static boolean isArm64(Context context) {
        if (bR(context) == Abi.ARM64_V8A) {
            return true;
        }
        return false;
    }
}
