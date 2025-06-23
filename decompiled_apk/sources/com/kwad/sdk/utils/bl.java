package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;

/* loaded from: classes11.dex */
public final class bl {
    public static void a(long j, int i, @Nullable Context context) {
        if (j != 0 && context != null && i > 0 && i <= 100) {
            long currentTimeMillis = j - System.currentTimeMillis();
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
                if (sharedPreferences == null) {
                    return;
                }
                if (Math.abs(currentTimeMillis) / 3600000 > i) {
                    sharedPreferences.edit().putLong("key_time_diff_s2c", currentTimeMillis).apply();
                } else {
                    sharedPreferences.edit().remove("key_time_diff_s2c").apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static long v(@Nullable Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!z) {
            return currentTimeMillis;
        }
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return Math.abs(currentTimeMillis);
            }
            long j = sharedPreferences.getLong("key_time_diff_s2c", 0L);
            if (j != 0) {
                return currentTimeMillis + j;
            }
        }
        return Math.abs(currentTimeMillis);
    }
}
