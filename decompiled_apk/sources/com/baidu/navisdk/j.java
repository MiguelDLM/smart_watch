package com.baidu.navisdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* loaded from: classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6860a = true;
    private static boolean b = false;
    private static boolean c = false;

    public static String a() {
        return "16.4.5";
    }

    public static String b() {
        return "6.3.1";
    }

    public static boolean c() {
        return b;
    }

    public static boolean d() {
        return f6860a;
    }

    public static boolean e() {
        return c;
    }

    public static void a(String str) {
    }

    public static void b(boolean z) {
        c = z;
    }

    public static void a(boolean z) {
        f6860a = z;
    }

    public static int a(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i = 0; i < min; i++) {
            try {
                int parseInt = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                if (parseInt != 0) {
                    return parseInt;
                }
            } catch (NumberFormatException unused) {
                return 1;
            }
        }
        if (split.length < split2.length) {
            return -1;
        }
        return split.length > split2.length ? 1 : 0;
    }
}
