package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes10.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17335a = "_multiKitLoadNative";
    private static final String b = "com.huawei.hms.runtimekit.container.kitsdk.KitContext";
    private static ThreadPoolExecutor c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());

    private static String a(Context context) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            context = context.createDeviceProtectedStorageContext();
        }
        return context.getFilesDir().getCanonicalPath() + File.separator + "modules";
    }

    private static String b(Context context, String str, String str2, PackageInfo packageInfo) {
        String str3;
        String str4;
        String substring;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.VERSION.SDK_INT >= 24) {
                    context = context.createDeviceProtectedStorageContext();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getFilesDir().getCanonicalPath());
                str4 = File.separator;
                sb2.append(str4);
                sb2.append("modules");
                sb.append(sb2.toString());
                sb.append(str4);
                sb.append(packageInfo.packageName);
                str3 = sb.toString();
                try {
                    substring = str2.substring(str2.lastIndexOf(str4) + 1);
                    zipFile = new ZipFile(str);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused2) {
            str3 = null;
        } catch (Throwable th2) {
            th = th2;
            str3 = null;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            HashSet hashSet = new HashSet();
            ac.a(entries, hashSet, substring);
            if (hashSet.size() <= 0) {
                af.b(f17335a, "native is empty");
                a(zipFile, str3, packageInfo, true);
                return str2;
            }
            String str5 = str3 + str4 + packageInfo.versionCode + str4 + NativeSymbolGenerator.LIB_PREFIX + str4 + substring;
            if (new File(str5).exists() || ac.a(zipFile, hashSet, str5) == 0) {
                a(zipFile, str3, packageInfo, true);
                return str5;
            }
            af.b(f17335a, "the apk decompress fail");
            a(zipFile, str3, packageInfo, false);
            return str2;
        } catch (Exception unused3) {
            zipFile2 = zipFile;
            af.c(f17335a, "catch IOException");
            a(zipFile2, str3, packageInfo, true);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            zipFile2 = zipFile;
            a(zipFile2, str3, packageInfo, true);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file) {
        return file.exists() && file.isDirectory() && file.listFiles() != null && file.listFiles().length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(File file) {
        boolean z;
        boolean z2 = false;
        if (c(file)) {
            z = true;
            for (File file2 : file.listFiles()) {
                z = z && d(file2);
            }
        } else {
            z = true;
        }
        if (!z) {
            return z;
        }
        if (z && file.delete()) {
            z2 = true;
        }
        return z2;
    }

    public static String a(Context context, String str, String str2, PackageInfo packageInfo) {
        af.b(f17335a, " generaNewNativePath");
        if (!b(context)) {
            return str2;
        }
        if (!TextUtils.isEmpty(str2) && str2.contains(File.separator)) {
            return b(context, str, str2, packageInfo);
        }
        af.b(f17335a, "nativePath is empty or error");
        return str2;
    }

    private static boolean b(Context context) {
        try {
            return context.getClassLoader().loadClass(b) != null;
        } catch (ClassNotFoundException unused) {
            af.b(f17335a, "The cp is not hms kit.");
            return false;
        }
    }

    private static void a(final String str, final int i, final boolean z) {
        c.execute(new Runnable() { // from class: com.huawei.hms.ads.uiengineloader.ag.1
            @Override // java.lang.Runnable
            public final void run() {
                File file = new File(str);
                String num = Integer.toString(i);
                if (ag.c(file)) {
                    for (File file2 : file.listFiles()) {
                        if (!z || !file2.getPath().contains(num)) {
                            StringBuilder sb = ag.d(file2) ? new StringBuilder(" delete success : ") : new StringBuilder(" delete failed : ");
                            sb.append(file2.getName());
                            af.b(ag.f17335a, sb.toString());
                        }
                    }
                }
            }
        });
    }

    private static void a(ZipFile zipFile, String str, PackageInfo packageInfo, boolean z) {
        int i;
        aj.a(zipFile);
        try {
            if (TextUtils.isEmpty(str) || (i = packageInfo.versionCode) <= 0) {
                return;
            }
            a(str, i, z);
        } catch (Exception unused) {
            af.c(f17335a, "IOException:");
        }
    }
}
