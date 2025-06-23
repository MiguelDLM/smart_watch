package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.HashSet;

/* loaded from: classes10.dex */
public final class m implements j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17352a = "HMSClassLoaderStrategy";
    private static final String b = "com.huawei.hwid";
    private static final String c = "com.huawei.hms.core.service.HMSCoreService";
    private static final String d = "lib";
    private static final String e = "arm64";
    private static final HashSet<String> f = new HashSet<String>() { // from class: com.huawei.hms.ads.uiengineloader.m.1
        {
            add("com.huawei.hwid");
            add("com.huawei.hms");
            add("com.huawei.hwid.tv");
        }
    };

    @Override // com.huawei.hms.ads.uiengineloader.j
    public final ClassLoader a(Context context, String str, int i, PackageInfo packageInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(new File(context.getPackageResourcePath()).getParent());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("lib");
        sb.append(str2);
        sb.append(e);
        String sb2 = sb.toString();
        af.b(f17352a, "The api version is:" + Build.VERSION.SDK_INT + ", callingPkg is HMS, use the hmsNativePath.");
        return new com.huawei.hms.ads.dynamicloader.d(str, sb2, context.getClassLoader());
    }

    public static boolean a(Context context) {
        String str;
        String packageName = context.getPackageName();
        af.b(f17352a, "The pkg name of clientContext is:".concat(String.valueOf(packageName)));
        if (!a(context, packageName)) {
            if (context instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                String packageName2 = baseContext.getPackageName();
                af.b(f17352a, "The pkg name of baseContext is:".concat(String.valueOf(packageName2)));
                str = a(baseContext, packageName2) ? "The base context is HMS context, cp is HMS." : "The context is HMS context, cp is HMS.";
            }
            af.b(f17352a, "The cp is not HMS.");
            return false;
        }
        af.b(f17352a, str);
        return true;
    }

    private static boolean a(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            af.b(f17352a, "Get pkg name failed: null.");
            return false;
        }
        if (!f.contains(str)) {
            if (!str.startsWith("com.huawei.hwid")) {
                af.b(f17352a, "The pkg does not start with HMS prefix.");
                return false;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo == null) {
                    af.c(f17352a, "Get callPackage packageInfo failed: null.");
                    return false;
                }
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                if (serviceInfoArr == null) {
                    af.c(f17352a, "Get service Info failed: null.");
                    return false;
                }
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (TextUtils.equals(serviceInfo.name, c)) {
                        str2 = "Check Service name: The calling package is HMS.";
                    }
                }
                af.b(f17352a, "The calling package is not HMS.");
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                af.c(f17352a, "Get callPackage packageInfo NameNotFoundException.");
                return false;
            } catch (Throwable th) {
                af.c(f17352a, "Get callPackage packageInfo ex: " + th.getClass().getSimpleName());
                return false;
            }
        }
        str2 = "The pkgName belongs to HMS pkg names, the cp is HMS.";
        af.b(f17352a, str2);
        return true;
    }
}
