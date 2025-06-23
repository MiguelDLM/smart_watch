package com.kwad.library.solder.lib;

import android.util.Log;

/* loaded from: classes11.dex */
public final class a {
    private static String C(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + xz();
    }

    public static void e(String str, String str2) {
        Log.e("Sodler", C(str, str2));
    }

    private static String xz() {
        return "";
    }

    public static void e(String str, Throwable th) {
        Log.e("Sodler", C(str, ""), th);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e("Sodler", C(str, str2), th);
    }
}
