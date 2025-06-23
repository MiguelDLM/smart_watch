package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import java.io.File;

/* loaded from: classes10.dex */
public final class s implements u {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17357a = "DecompressedLdStrategy";
    private static final String b = "loader";
    private static final String c = "com.huawei.hms.kit.type";
    private static final String d = "armeabi_type";

    private static Context b(Context context, y yVar) throws com.huawei.hms.ads.dynamicloader.j {
        IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(w.a(context, yVar.e));
        if (asInterface == null) {
            af.c(f17357a, "Get iDynamicLoader failed: null.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_name", yVar.f17365a);
        bundle.putString("loader_path", yVar.e);
        bundle.putInt("module_version", yVar.d);
        bundle.putString(com.huawei.hms.ads.dynamicloader.b.e, yVar.f);
        return w.a(context, yVar.f17365a, bundle, asInterface);
    }

    @Override // com.huawei.hms.ads.uiengineloader.u
    public final Context a(Context context, y yVar) {
        String str;
        if (yVar == null) {
            str = "moduleInfo is null.";
        } else {
            String str2 = yVar.b;
            if (TextUtils.isEmpty(str2)) {
                str = "modulePath is invalid.";
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("module_path", str2);
                bundle.putString(com.huawei.hms.ads.dynamicloader.b.e, yVar.f);
                bundle.putString("module_name", yVar.f17365a);
                af.b(f17357a, "loaderVersionType is : " + yVar.f);
                try {
                    if (!TextUtils.equals(a(context, str2, bundle), b)) {
                        com.huawei.hms.ads.dynamicloader.h.a(context);
                        return com.huawei.hms.ads.dynamicloader.h.a(context, bundle);
                    }
                    af.b(f17357a, "The module is a loader, use it to load first.");
                    yVar.e = str2;
                    IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(w.a(context, str2));
                    if (asInterface == null) {
                        af.c(f17357a, "Get iDynamicLoader failed: null.");
                        return null;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("module_name", yVar.f17365a);
                    bundle2.putString("loader_path", yVar.e);
                    bundle2.putInt("module_version", yVar.d);
                    bundle2.putString(com.huawei.hms.ads.dynamicloader.b.e, yVar.f);
                    return w.a(context, yVar.f17365a, bundle2, asInterface);
                } catch (Exception e) {
                    str = "Get local assets module context failed, " + e.getClass().getSimpleName();
                }
            }
        }
        af.c(f17357a, str);
        return null;
    }

    public static y a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(ad.a(context));
        String str2 = File.separator;
        sb.append(str2);
        sb.append(com.huawei.hms.ads.dynamicloader.b.f17277a);
        sb.append(str2);
        sb.append(str);
        File file = new File(sb.toString());
        return file.exists() ? a(file, str) : new y();
    }

    private static y b(Context context, String str, String str2) {
        y yVar = new y();
        if (context == null || TextUtils.isEmpty(str)) {
            af.c(f17357a, "The context or moduleName is null.");
            return yVar;
        }
        try {
            yVar = a(context, str);
            if (yVar.d > 0) {
                af.b(f17357a, "Successfully get module info from decompressed asset path.");
                v.a(context, str, yVar.d, str2);
                return yVar;
            }
        } catch (Exception e) {
            af.b(f17357a, "getDataModuleInfo failed." + e.getClass().getSimpleName());
        }
        return yVar;
    }

    @Override // com.huawei.hms.ads.uiengineloader.u
    public final y a(Context context, String str, String str2) {
        return b(context, str, str2);
    }

    private static y a(File file, String str) {
        String[] list = file.list();
        y yVar = new y();
        if (list == null || list.length == 0) {
            af.c(f17357a, "No version in module path.");
            return yVar;
        }
        int i = 0;
        for (String str2 : list) {
            if (Integer.parseInt(str2) > i) {
                i = Integer.parseInt(str2);
            }
        }
        if (i == 0) {
            af.c(f17357a, "Cannot get module version path.");
            return yVar;
        }
        w.a(i, ad.a(file), list, f17357a);
        StringBuilder sb = new StringBuilder();
        sb.append(ad.a(file));
        String str3 = File.separator;
        sb.append(str3);
        sb.append(i);
        sb.append(str3);
        sb.append(str);
        sb.append(com.huawei.hms.ads.dynamicloader.b.b);
        File file2 = new File(sb.toString());
        if (!file2.exists()) {
            af.c(f17357a, "Cannot find module apk int local path.");
            return yVar;
        }
        String a2 = ad.a(file2);
        yVar.f17365a = str;
        yVar.b = a2;
        yVar.d = i;
        af.b(f17357a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + i);
        return yVar;
    }

    private static String a(Context context, String str, Bundle bundle) {
        String str2;
        ApplicationInfo applicationInfo;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 128);
        String str3 = null;
        if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
            str2 = "The packageInfo is null.";
        } else {
            Bundle bundle2 = applicationInfo.metaData;
            if (bundle2 == null) {
                str2 = "Get meta-data failed.";
            } else {
                try {
                    for (String str4 : bundle2.keySet()) {
                        if (str4.startsWith(c)) {
                            str3 = bundle2.getString(str4);
                        }
                        if (str4.startsWith(d)) {
                            int i = bundle2.getInt(str4);
                            af.b(f17357a, "The module defined the armeabiType:".concat(String.valueOf(i)));
                            bundle.putInt("armeabiType", i);
                        }
                    }
                    af.c(f17357a, "The moduleType is:".concat(String.valueOf(str3)));
                    return str3;
                } catch (Throwable th) {
                    str2 = "getModuleMetaInfo err: " + th.getClass().getSimpleName();
                }
            }
        }
        af.c(f17357a, str2);
        return str3;
    }
}
