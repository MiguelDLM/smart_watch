package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes13.dex */
public final class g {

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f26193a;
        private String b;
        private Drawable c;
        private String d;
        private String e;
        private int f;
        private boolean g;

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            b(str2);
            a(drawable);
            a(str);
            c(str3);
            d(str4);
            a(i);
            a(z);
        }

        public Drawable a() {
            return this.c;
        }

        public boolean b() {
            return this.g;
        }

        public String c() {
            return this.f26193a;
        }

        public String d() {
            return this.b;
        }

        public String e() {
            return this.d;
        }

        public int f() {
            return this.f;
        }

        public String g() {
            return this.e;
        }

        public String toString() {
            return "{\n  pkg name: " + c() + "\n  app icon: " + a() + "\n  app name: " + d() + "\n  app path: " + e() + "\n  app v name: " + g() + "\n  app v code: " + f() + "\n  is system: " + b() + ooOOo0oXI.f33074oOoXoXO;
        }

        public void a(Drawable drawable) {
            this.c = drawable;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.d = str;
        }

        public void d(String str) {
            this.e = str;
        }

        public void a(boolean z) {
            this.g = z;
        }

        public void a(String str) {
            this.f26193a = str;
        }

        public void a(int i) {
            this.f = i;
        }
    }

    public static int a(String str) {
        if (c(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.c.O().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static a b(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.c.O().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return a(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean c(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static a a(PackageManager packageManager, PackageInfo packageInfo) {
        String str;
        Drawable drawable = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str2 = packageInfo.packageName;
        if (applicationInfo != null && applicationInfo.loadLabel(packageManager) != null) {
            str = applicationInfo.loadLabel(packageManager).toString();
        } else {
            str = "";
        }
        String str3 = str;
        try {
            drawable = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new a(str2, str3, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
