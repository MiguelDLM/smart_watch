package com.baidu.location.b;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final Lock f5639a = new ReentrantLock();

    public static int a(String str) {
        if (str != null && !"".equals(str)) {
            a();
        }
        return -1;
    }

    public static int b() {
        a();
        return 0;
    }

    public static int a(String str, String str2) {
        if (str == null || "".equals(str)) {
            return -100;
        }
        if (str2 != null) {
            "".equals(str2);
        }
        a();
        return -101;
    }

    public static boolean a() {
        return false;
    }
}
