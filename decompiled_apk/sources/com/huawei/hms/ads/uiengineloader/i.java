package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes10.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17350a = "ClassLoaderPathManager";
    private static final String b = "com.huawei.hff";
    private static HashMap<String, ArrayList<String>> c = new HashMap<>();

    public static String a(Context context, String str, PackageInfo packageInfo) {
        String str2;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            af.c(f17350a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        if (c.containsKey(str)) {
            ArrayList<String> arrayList = c.get(str);
            if (arrayList != null && !arrayList.isEmpty()) {
                StringBuilder sb = new StringBuilder(str);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    sb.append(File.pathSeparator);
                    sb.append(next);
                }
                return sb.toString();
            }
            str2 = "No split apk path has set.";
        } else {
            str2 = "No split apk required, continue.";
        }
        af.b(f17350a, str2);
        return str;
    }

    public static String b(Context context, String str, PackageInfo packageInfo) {
        String str2 = null;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            af.c(f17350a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        String a2 = ag.a(context, str, z.a(context, str), packageInfo);
        packageInfo.applicationInfo.nativeLibraryDir = a2;
        if (!c.containsKey(str)) {
            af.b(f17350a, "No split apk required, continue.");
            return a2;
        }
        ArrayList<String> arrayList = c.get(str);
        if (arrayList == null || arrayList.isEmpty()) {
            af.b(f17350a, "No split apk path has set.");
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (sb.length() != 0) {
                    sb.append(File.pathSeparator);
                }
                sb.append(z.b(context, next));
            }
            str2 = sb.toString();
        }
        if (TextUtils.isEmpty(a2)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return a2;
        }
        return a2 + File.pathSeparator + str2;
    }

    private static void c(Context context, String str, PackageInfo packageInfo) {
        if (c.containsKey(str)) {
            af.b(f17350a, "HFF split info for dynamicApkPath has set.");
            return;
        }
        new r();
        Set<q> a2 = r.a(context, packageInfo.applicationInfo, b);
        if (a2.isEmpty()) {
            af.b(f17350a, "No HFF split path need to add to classloader.");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<q> it = a2.iterator();
        while (it.hasNext()) {
            arrayList.add(ad.a(it.next().f17355a));
        }
        c.put(str, arrayList);
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            af.b(f17350a, "No split apk path has set.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (sb.length() != 0) {
                sb.append(File.pathSeparator);
            }
            sb.append(z.b(context, next));
        }
        return sb.toString();
    }
}
