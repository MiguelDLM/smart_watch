package com.kwad.sdk.utils;

/* loaded from: classes11.dex */
public final class i {
    public static void ao(String str, String str2) {
        com.kwad.sdk.core.e.c.d("callbackLog", str + str2);
    }

    public static void b(String str, String str2, String str3, String str4) {
        ao(str, str2 + "_" + str3 + "_" + str4);
    }

    public static void r(String str, int i) {
        com.kwad.sdk.core.e.c.d("audioVideoLog", str + "_type_" + i + "_time_" + System.currentTimeMillis());
    }
}
