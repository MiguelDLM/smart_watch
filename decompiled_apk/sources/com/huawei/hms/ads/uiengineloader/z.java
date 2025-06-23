package com.huawei.hms.ads.uiengineloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes10.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17366a = "z";
    private static final String b = "lib";
    private static final String c = "!";
    private static final String d = "armeabi-v7a";
    private static final String e = "armeabi";
    private static final Pattern f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    public static String a(Context context, String str) {
        Iterator<String> it = b(context).iterator();
        while (it.hasNext()) {
            String next = it.next();
            StringBuilder sb = new StringBuilder();
            String str2 = File.separator;
            sb.append(str.substring(0, str.lastIndexOf(str2)));
            sb.append(str2);
            sb.append(next);
            String sb2 = sb.toString();
            if (new File(sb2).exists()) {
                af.b(f17366a, "The so has been unzipped, abi:".concat(String.valueOf(next)));
                return sb2;
            }
        }
        return b(context, str);
    }

    public static String b(Context context, String str) {
        if (Build.VERSION.SDK_INT > 23) {
            Iterator<String> it = b(context).iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (a(new File(str), next)) {
                    af.b(f17366a, "use the preferred abi:".concat(String.valueOf(next)));
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(c);
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append("lib");
                    sb.append(str2);
                    sb.append(next);
                    return sb.toString();
                }
            }
        }
        af.c(f17366a, "cannot get a valid native path, return null.");
        return null;
    }

    private static boolean a(Context context) {
        boolean is64Bit;
        boolean z = false;
        if (context == null) {
            af.d(f17366a, "Null context, please check it.");
            return false;
        }
        Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            return is64Bit;
        }
        try {
            return applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).nativeLibraryDir.contains("64");
        } catch (Throwable unused) {
            String str = f17366a;
            af.d(str, "Get application info failed: name not found, try to get baseContext.");
            if (context instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                z = true;
                if (baseContext == null) {
                    af.c(str, "Get baseContext failed: null. Return default: is64-bit.");
                    return true;
                }
                try {
                    return baseContext.getPackageManager().getApplicationInfo(baseContext.getPackageName(), 128).nativeLibraryDir.contains("64");
                } catch (Throwable unused2) {
                    af.d(f17366a, "Get baseContext application info failed: name not found");
                    return z;
                }
            }
            return z;
        }
    }

    @SuppressLint({"NewApi"})
    private static ArrayList<String> b(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, a(context) ? Build.SUPPORTED_64_BIT_ABIS : Build.SUPPORTED_32_BIT_ABIS);
        return arrayList;
    }

    private static boolean a(File file, String str) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                if (name.contains("../")) {
                    af.c(f17366a, "Unsafe zip name!");
                    aj.a(zipFile);
                    return false;
                }
                Matcher matcher = f.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (TextUtils.equals(str, group)) {
                        af.b(f17366a, "abiName:" + group + " matched.");
                        aj.a(zipFile);
                        return true;
                    }
                }
            }
            aj.a(zipFile);
        } catch (Exception e3) {
            e = e3;
            zipFile2 = zipFile;
            af.c(f17366a, "isApkContainPrefAbi exception:" + e.getClass().getSimpleName());
            aj.a(zipFile2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            aj.a(zipFile2);
            throw th;
        }
        return false;
    }
}
