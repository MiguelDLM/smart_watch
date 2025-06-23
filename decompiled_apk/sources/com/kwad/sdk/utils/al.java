package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes11.dex */
public final class al {

    /* loaded from: classes11.dex */
    public interface a {
        void d(Throwable th);

        void oK();
    }

    public static boolean a(@Nullable String str, a aVar) {
        Uri fromFile;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Context context = ServiceProvider.getContext();
            File file = new File(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(3);
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
            } else {
                fromFile = Uri.fromFile(file);
            }
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                context.grantUriPermission(it.next().activityInfo.packageName, fromFile, 3);
            }
            context.startActivity(intent);
            if (aVar != null) {
                aVar.oK();
                return true;
            }
            return true;
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.d(th);
            }
            return false;
        }
    }

    public static boolean an(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                if (applicationInfo.enabled) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int ao(@Nullable Context context, String str) {
        if (context == null || str == null || c.bS(context)) {
            return -1;
        }
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33) {
                return -1;
            }
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.i) != 0) {
                return -1;
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str);
            if (file.exists() && file.isDirectory()) {
                return 1;
            }
            return 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        */
    public static boolean ap(@androidx.annotation.Nullable android.content.Context r4, @androidx.annotation.Nullable java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L31
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto La
            goto L31
        La:
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch: java.lang.Exception -> L31
            android.content.Intent r5 = r1.getLaunchIntentForPackage(r5)     // Catch: java.lang.Exception -> L31
            if (r5 != 0) goto L15
            return r0
        L15:
            java.lang.String r1 = "PackageUtil"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L31
            java.lang.String r3 = "openApp context: "
            r2.<init>(r3)     // Catch: java.lang.Exception -> L31
            r2.append(r4)     // Catch: java.lang.Exception -> L31
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L31
            com.kwad.sdk.core.e.c.d(r1, r2)     // Catch: java.lang.Exception -> L31
            r1 = 337641472(0x14200000, float:8.077936E-27)
            r5.setFlags(r1)     // Catch: java.lang.Exception -> L31
            r4.startActivity(r5)     // Catch: java.lang.Exception -> L31
            r0 = 1
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.al.ap(android.content.Context, java.lang.String):boolean");
    }

    public static void at(String str, String str2) {
        com.kwad.sdk.core.e.c.w("PackageUtil", "saveDownloadFile " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (!file.exists()) {
                com.kwad.sdk.core.e.c.w("PackageUtil", "cannot save package, download apk is not exists.");
                return;
            }
            Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
            if (context == null) {
                return;
            }
            y.f(context, str2, file.length());
            try {
                y.g(context, str2, com.kwad.sdk.utils.a.getFileMD5(file));
                return;
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
                return;
            }
        }
        com.kwad.sdk.core.e.c.w("PackageUtil", "cannot save package, has no download apk info.");
    }

    public static int au(String str, String str2) {
        ApplicationInfo applicationInfo;
        com.kwad.sdk.core.e.c.w("PackageUtil", "isPackageChanged " + str + " packageName " + str2);
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 0;
        }
        long V = y.V(context, str);
        String W = y.W(context, str);
        if (!TextUtils.isEmpty(W) && V > 0) {
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str2, 0);
                if (!TextUtils.isEmpty(str2) && packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && !TextUtils.isEmpty(applicationInfo.publicSourceDir)) {
                    File file = new File(packageInfo.applicationInfo.publicSourceDir);
                    if (!file.exists()) {
                        com.kwad.sdk.core.e.c.w("PackageUtil", "cannot judge package, insgtalled apk is not exists.");
                        return 0;
                    }
                    if (V != file.length()) {
                        return 1;
                    }
                    if (TextUtils.isEmpty(W)) {
                        com.kwad.sdk.core.e.c.w("PackageUtil", "cannot judge package, cannot calculate md5 of download file.");
                        return 0;
                    }
                    String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
                    if (TextUtils.isEmpty(fileMD5)) {
                        com.kwad.sdk.core.e.c.w("PackageUtil", "cannot judge package, cannot calculate md5 of installed file.");
                        return 0;
                    }
                    if (!W.equalsIgnoreCase(fileMD5)) {
                        return 1;
                    }
                    return 2;
                }
                com.kwad.sdk.core.e.c.w("PackageUtil", "cannot judge package, cannot get installed apk info.");
                return 0;
            } catch (PackageManager.NameNotFoundException e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
                return 0;
            }
        }
        com.kwad.sdk.core.e.c.w("PackageUtil", "cannot judge package, has no download apk info.");
        return 0;
    }

    public static boolean gO(@Nullable String str) {
        return a(str, null);
    }

    public static String gP(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            com.kwad.sdk.core.e.c.w("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }
}
