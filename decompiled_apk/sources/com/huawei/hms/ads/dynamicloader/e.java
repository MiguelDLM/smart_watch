package com.huawei.hms.ads.dynamicloader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.hms.ads.uiengineloader.ab;
import com.huawei.hms.ads.uiengineloader.af;
import com.huawei.hms.ads.uiengineloader.m;
import com.huawei.hms.ads.uiengineloader.n;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class e extends a {
    private static final String c = "DynamicContext";
    private static final ThreadLocal<ApplicationInfo> d = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    final PackageInfo f17280a;
    final String b;
    private final ClassLoader e;
    private final Resources f;
    private final Resources g;

    public e(Context context, String str, int i) {
        super(context);
        PackageInfo packageArchiveInfo = getBaseContext().getPackageManager().getPackageArchiveInfo(str, 128);
        this.f17280a = packageArchiveInfo;
        this.e = ((ab.a() && m.a(context)) ? new m() : new n()).a(context, str, i, packageArchiveInfo);
        this.g = a(str);
        this.f = context.getResources();
        this.b = str;
        af.b(c, "Create dynamicContext success.");
    }

    private PackageInfo a() {
        return this.f17280a;
    }

    private String b() {
        return this.b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        ThreadLocal<ApplicationInfo> threadLocal = d;
        return threadLocal.get() != null ? threadLocal.get() : super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        PackageInfo packageInfo = this.f17280a;
        if (packageInfo != null) {
            String str = packageInfo.packageName;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = this.g;
        return resources == null ? this.f : resources;
    }

    @Override // com.huawei.hms.ads.dynamicloader.a, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (Arrays.asList("connectivity", "location", "wifi", "user").contains(str)) {
            return getBaseContext().getSystemService(str);
        }
        Arrays.asList("sensor").contains(str);
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.getApplicationContext().registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.getApplicationContext().unregisterComponentCallbacks(componentCallbacks);
    }

    private Resources a(String str) {
        ApplicationInfo applicationInfo = this.f17280a.applicationInfo;
        applicationInfo.publicSourceDir = str;
        applicationInfo.sourceDir = str;
        try {
            return getBaseContext().getPackageManager().getResourcesForApplication(this.f17280a.applicationInfo);
        } catch (PackageManager.NameNotFoundException e) {
            af.c(c, "NameNotFoundException:" + e.getLocalizedMessage());
            return null;
        }
    }
}
