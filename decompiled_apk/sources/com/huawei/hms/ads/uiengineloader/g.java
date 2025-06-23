package com.huawei.hms.ads.uiengineloader;

import dalvik.system.PathClassLoader;

/* loaded from: classes10.dex */
public final class g extends PathClassLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17348a = "g";

    public g(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                af.c(f17348a, "Cannot find The class:".concat(str));
            }
        }
        return super.loadClass(str, z);
    }
}
