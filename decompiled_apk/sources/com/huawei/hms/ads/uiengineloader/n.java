package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: classes10.dex */
public final class n implements j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17353a = "PathClassLoaderStrategy";

    @Override // com.huawei.hms.ads.uiengineloader.j
    public final ClassLoader a(Context context, String str, int i, PackageInfo packageInfo) {
        af.b(f17353a, "begin to new classloader, armeabiType:".concat(String.valueOf(i)));
        return new com.huawei.hms.ads.dynamicloader.d(i.a(context, str, packageInfo), i.b(context, str, packageInfo), context.getClassLoader());
    }
}
