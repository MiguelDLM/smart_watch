package com.huawei.hms.ads.uiengineloader;

import dalvik.system.DexClassLoader;

/* loaded from: classes10.dex */
public final class h extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17349a = "h";

    public h(String str, String str2, ClassLoader classLoader) {
        super(str, str2, null, classLoader);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                af.c(f17349a, "Cannot find The class:".concat(str));
            }
        }
        return super.loadClass(str, z);
    }
}
