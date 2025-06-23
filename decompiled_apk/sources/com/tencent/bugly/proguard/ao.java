package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes13.dex */
public final class ao {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f26548a = true;
    public static boolean b = true;
    private static SimpleDateFormat c = null;
    private static int d = 30720;
    private static StringBuilder e = null;
    private static StringBuilder f = null;
    private static boolean g = false;
    private static a h = null;
    private static String i = null;
    private static String j = null;
    private static Context k = null;
    private static String l = null;
    private static boolean m = false;
    private static boolean n = false;
    private static ExecutorService o;
    private static int p;
    private static final Object q = new Object();

    /* loaded from: classes13.dex */
    public static class II0xO0 implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f26549IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f26550Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f26551XO;

        public II0xO0(String str, String str2, String str3) {
            this.f26551XO = str;
            this.f26550Oo = str2;
            this.f26549IXxxXO = str3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ao.e(this.f26551XO, this.f26550Oo, this.f26549IXxxXO);
        }
    }

    /* loaded from: classes13.dex */
    public static class oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f26553IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f26554Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f26555XO;

        public oIX0oI(String str, String str2, String str3) {
            this.f26555XO = str;
            this.f26554Oo = str2;
            this.f26553IXxxXO = str3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ao.d(this.f26555XO, this.f26554Oo, this.f26553IXxxXO);
        }
    }

    static {
        try {
            c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            al.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (ao.class) {
            if (m || context == null || !b) {
                return;
            }
            try {
                o = Executors.newSingleThreadExecutor();
                f = new StringBuilder(0);
                e = new StringBuilder(0);
                k = context;
                i = aa.a(context).d;
                j = "";
                l = k.getFilesDir().getPath() + "/buglylog_" + i + "_" + j + ".txt";
                p = Process.myPid();
            } catch (Throwable unused) {
            }
            m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, String str2, String str3) {
        q qVar;
        try {
            aa b2 = aa.b();
            if (b2 != null && (qVar = b2.N) != null) {
                return qVar.appendLogToNative(str, str2, str3);
            }
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void e(String str, String str2, String str3) {
        synchronized (ao.class) {
            if (f26548a) {
                f(str, str2, str3);
            } else {
                g(str, str2, str3);
            }
        }
    }

    private static synchronized void f(String str, String str2, String str3) {
        synchronized (ao.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f.append(a2);
                    if (f.length() >= d) {
                        StringBuilder sb = f;
                        f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                    }
                } finally {
                    try {
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        synchronized (ao.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f.append(a2);
                } catch (Throwable unused) {
                }
                if (f.length() <= d) {
                    return;
                }
                if (g) {
                    return;
                }
                g = true;
                a aVar = h;
                if (aVar == null) {
                    h = new a(l);
                } else {
                    File file = aVar.b;
                    if (file == null || file.length() + f.length() > h.c) {
                        h.a();
                    }
                }
                if (h.a(f.toString())) {
                    f.setLength(0);
                    g = false;
                }
            }
        }
    }

    private static String b() {
        q qVar;
        try {
            aa b2 = aa.b();
            if (b2 == null || (qVar = b2.N) == null) {
                return null;
            }
            return qVar.getLogFromNative();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c() {
        File file;
        if (!b) {
            return null;
        }
        if (n) {
            al.a("[LogUtil] Get user log from native.", new Object[0]);
            String b2 = b();
            if (b2 != null) {
                al.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(b2.length()));
                return ap.a(b2, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (q) {
            try {
                a aVar = h;
                if (aVar != null && aVar.f26552a && (file = aVar.b) != null && file.length() > 0) {
                    sb.append(ap.a(h.b, 30720, true));
                }
                StringBuilder sb2 = f;
                if (sb2 != null && sb2.length() > 0) {
                    sb.append(f.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ap.a(sb.toString(), "BuglyLog.txt");
    }

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f26552a;
        File b;
        long c = 30720;
        private String d;
        private long e;

        public a(String str) {
            if (str != null && !str.equals("")) {
                this.d = str;
                this.f26552a = a();
            }
        }

        public final boolean a() {
            try {
                File file = new File(this.d);
                this.b = file;
                if (file.exists() && !this.b.delete()) {
                    this.f26552a = false;
                    return false;
                }
                if (this.b.createNewFile()) {
                    return true;
                }
                this.f26552a = false;
                return false;
            } catch (Throwable th) {
                al.a(th);
                this.f26552a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            if (!this.f26552a) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.b, true);
                try {
                    fileOutputStream2.write(str.getBytes("UTF-8"));
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.e += r10.length;
                    this.f26552a = true;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        al.a(th);
                        this.f26552a = false;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static void a(int i2) {
        synchronized (q) {
            try {
                d = i2;
                if (i2 < 0) {
                    d = 0;
                } else if (i2 > 30720) {
                    d = 30720;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + ap.b(th));
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (ao.class) {
            if (m && b) {
                try {
                    if (n) {
                        o.execute(new oIX0oI(str, str2, str3));
                    } else {
                        o.execute(new II0xO0(str, str2, str3));
                    }
                } catch (Exception e2) {
                    al.b(e2);
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String date;
        e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = e;
        sb.append(date);
        sb.append(" ");
        sb.append(p);
        sb.append(" ");
        sb.append(j2);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return e.toString();
    }

    public static byte[] a() {
        if (f26548a) {
            if (b) {
                return ap.a(f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return c();
    }
}
