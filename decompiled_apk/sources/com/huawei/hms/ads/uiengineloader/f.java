package com.huawei.hms.ads.uiengineloader;

/* loaded from: classes10.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17347a = "StringUtils";

    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            af.c(f17347a, "parseIntOrDefault exception: " + e.getClass().getSimpleName());
            return 0;
        }
    }

    private static boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }
}
