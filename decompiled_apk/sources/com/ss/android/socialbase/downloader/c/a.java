package com.ss.android.socialbase.downloader.c;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes13.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f26235a = 4;
    private static AbstractC1056a b;

    /* renamed from: com.ss.android.socialbase.downloader.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static abstract class AbstractC1056a {
        public void a(String str, String str2) {
        }

        public void b(String str, String str2) {
        }

        public void c(String str, String str2) {
        }

        public void d(String str, String str2) {
        }

        public void e(String str, String str2) {
        }

        public void a(String str, String str2, Throwable th) {
        }
    }

    public static void a(int i) {
        f26235a = i;
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return "Downloader-" + str;
        }
        return "DownloaderLogger";
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f26235a <= 4) {
            Log.i(b(str), str2);
        }
        AbstractC1056a abstractC1056a = b;
        if (abstractC1056a != null) {
            abstractC1056a.c(b(str), str2);
        }
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f26235a <= 5) {
            Log.w(b(str), str2);
        }
        AbstractC1056a abstractC1056a = b;
        if (abstractC1056a != null) {
            abstractC1056a.e(b(str), str2);
        }
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f26235a <= 6) {
            Log.e(b(str), str2);
        }
        AbstractC1056a abstractC1056a = b;
        if (abstractC1056a != null) {
            abstractC1056a.d(b(str), str2);
        }
    }

    public static boolean a() {
        return f26235a <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f26235a <= 2) {
            Log.v(str, str2);
        }
        AbstractC1056a abstractC1056a = b;
        if (abstractC1056a != null) {
            abstractC1056a.a(b(str), str2);
        }
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f26235a <= 3) {
            Log.d(b(str), str2);
        }
        AbstractC1056a abstractC1056a = b;
        if (abstractC1056a != null) {
            abstractC1056a.b(b(str), str2);
        }
    }

    public static void c(String str) {
        d("DownloaderLogger", str);
    }

    public static void a(String str) {
        b("DownloaderLogger", str);
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f26235a <= 3) {
            Log.d(b(str), str2, th);
        }
        AbstractC1056a abstractC1056a = b;
        if (abstractC1056a != null) {
            abstractC1056a.b(b(str), str2 + th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f26235a <= 6) {
            Log.e(b(str), str2, th);
        }
        AbstractC1056a abstractC1056a = b;
        if (abstractC1056a != null) {
            abstractC1056a.a(b(str), str2, th);
        }
    }
}
