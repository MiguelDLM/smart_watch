package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
final class f {
    private static final List<String> anA;

    /* loaded from: classes11.dex */
    public static class a extends DexClassLoader {
        private final ClassLoader anB;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.anB = classLoader;
            classLoader.getClass();
        }

        private static boolean ck(String str) {
            if (!TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api")) {
                return true;
            }
            return false;
        }

        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) {
            if (ck(str)) {
                return getParent().loadClass(str);
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            return super.loadClass(str, z);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        anA = arrayList;
        arrayList.add("com.kwad.sdk");
        arrayList.add("com.ksad");
        arrayList.add("com.kwai");
        arrayList.add("kwad.support");
        arrayList.add("android.support.rastermill");
    }

    @NonNull
    public static ClassLoader a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (b.b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new a(str, str2, str3, classLoader);
    }
}
