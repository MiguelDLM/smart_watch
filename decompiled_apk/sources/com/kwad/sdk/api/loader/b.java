package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.sdk.api.SdkConfig;

/* loaded from: classes11.dex */
public final class b {
    public static void a(final Context context, final SdkConfig sdkConfig) {
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.b.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                b.c(context, "sdkconfig", sdkConfig.toJson());
            }
        });
    }

    public static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void c(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).commit();
        } catch (Throwable unused) {
        }
    }

    public static String getString(Context context, String str) {
        return b(context, str, "");
    }

    public static long n(Context context, String str) {
        return b(context, str, 0L);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean(str, z).commit();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean(str, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, long j) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putLong(str, j).commit();
        } catch (Throwable unused) {
        }
    }

    private static long b(Context context, String str, long j) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getLong(str, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
