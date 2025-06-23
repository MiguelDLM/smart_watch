package com.iflytek.sparkchain.media.ifla;

import java.util.Locale;

/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Locale f17466a = Locale.CHINA;

    public static String a(int i) {
        String[] strArr = b.f17467a;
        if (f17466a.equals(Locale.US)) {
            strArr = c.f17468a;
        } else if (f17466a.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = d.f17469a;
        }
        return (i <= 0 || i >= strArr.length) ? b(1) : strArr[i];
    }

    public static String b(int i) {
        String[] strArr = b.b;
        if (f17466a.equals(Locale.US)) {
            strArr = c.b;
        } else if (f17466a.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = d.b;
        }
        return (i < 0 || i >= strArr.length) ? "" : strArr[i];
    }
}
