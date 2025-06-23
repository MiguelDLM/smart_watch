package com.baidu.mshield.b.c;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f6367a = -1;

    static {
        new ThreadLocal();
    }

    public static void a(int i, String str) {
    }

    public static void b(String str) {
        int i = f6367a;
        if (i == -1 || i == 0 || i == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i = f6367a;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            a(2, str);
        }
    }

    public static void a(Throwable th) {
    }

    public static void a(String str) {
        b(str);
    }
}
