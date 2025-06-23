package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: classes10.dex */
public final class l implements j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17351a = "DexClassLoaderStrategy";

    @Override // com.huawei.hms.ads.uiengineloader.j
    public final ClassLoader a(Context context, String str, int i, PackageInfo packageInfo) {
        af.b(f17351a, "The android version is below android 5, use dexClassLoader.");
        return new com.huawei.hms.ads.dynamicloader.c(i.a(context, str, packageInfo), ad.a(context.getFilesDir()), i.b(context, str, packageInfo), context.getClassLoader());
    }
}
