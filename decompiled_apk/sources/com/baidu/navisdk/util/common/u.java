package com.baidu.navisdk.util.common;

import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes8.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<List<Object>> f9251a;

    public static void a() {
    }

    public static void b(Object obj) {
    }

    public static void a(Object obj) {
    }

    public static void b() {
        WeakReference<List<Object>> weakReference = f9251a;
        if (weakReference != null) {
            weakReference.clear();
            f9251a = null;
        }
    }
}
