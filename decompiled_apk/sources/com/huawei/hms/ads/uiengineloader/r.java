package com.huawei.hms.ads.uiengineloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes10.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17356a = "r";
    private static final String b = "presplits";
    private static final String c = ",";

    @SuppressLint({"NewApi"})
    private static HashMap<String, String> a(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        String[] strArr;
        String[] strArr2;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 128);
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            strArr = packageInfo.splitNames;
        } catch (PackageManager.NameNotFoundException e) {
            af.c(f17356a, "getSourceDir:cannot find the package:" + str + " info." + e.getClass().getSimpleName());
        } catch (Throwable th) {
            af.c(f17356a, "getSourceDir ex: " + th.getClass().getSimpleName());
        }
        if (strArr != null && (strArr2 = applicationInfo.splitSourceDirs) != null) {
            int min = Math.min(strArr.length, strArr2.length);
            for (int i = 0; i < min; i++) {
                hashMap.put(packageInfo.splitNames[i], applicationInfo.splitSourceDirs[i]);
            }
            return hashMap;
        }
        af.c(f17356a, "splitNames or splitSourceDirs is null.");
        return hashMap;
    }

    private static Set<q> b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable th) {
            af.d(f17356a, "getMetaSplits:cannot find the package:" + str + "info." + th.getClass().getSimpleName());
            applicationInfo = null;
        }
        return a(context, applicationInfo, str);
    }

    public static Set<q> a(Context context, ApplicationInfo applicationInfo, String str) {
        HashSet hashSet = new HashSet();
        if (context != null && applicationInfo != null) {
            try {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    String string = bundle.getString(b);
                    if (TextUtils.isEmpty(string)) {
                        af.b(f17356a, "No metadata: presplits found.");
                        return hashSet;
                    }
                    String[] split = string.split(",");
                    HashMap<String, String> a2 = a(context, str);
                    if (split.length != 0 && !a2.isEmpty()) {
                        for (String str2 : split) {
                            for (Map.Entry<String, String> entry : a2.entrySet()) {
                                if (str2.equals(entry.getKey())) {
                                    hashSet.add(new q(new File(entry.getValue()), entry.getKey()));
                                }
                            }
                        }
                    }
                    return hashSet;
                }
            } catch (Throwable th) {
                af.c(f17356a, "getSplitsInfo err: " + th.getClass().getSimpleName());
            }
        }
        return hashSet;
    }
}
