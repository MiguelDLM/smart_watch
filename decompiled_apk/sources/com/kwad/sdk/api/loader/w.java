package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* loaded from: classes11.dex */
final class w {
    public static boolean is64Bit() {
        boolean is64Bit;
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            return is64Bit;
        }
        try {
            return ((Boolean) ApiReflect.cg("dalvik.system.VMRuntime").cj("getRuntime").cj("is64Bit").get()).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String yp() {
        if (is64Bit()) {
            return "arm64-v8a";
        }
        return "armeabi-v7a";
    }
}
