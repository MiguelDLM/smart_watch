package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.huawei.openalliance.ad.constant.bn;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.q;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes13.dex */
public class NativeCrashHandler implements q {

    /* renamed from: a, reason: collision with root package name */
    static String f26521a = null;
    private static NativeCrashHandler b = null;
    private static int c = 1;
    private static boolean n = true;
    private final Context d;
    private final aa e;
    private final ak f;
    private NativeExceptionHandler g;
    private final boolean h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private as m;

    /* loaded from: classes13.dex */
    public class II0xO0 implements Comparator<File> {
        public II0xO0() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            return Long.compare(file2.lastModified(), file.lastModified());
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            if (!ap.a(NativeCrashHandler.this.d, "native_record_lock")) {
                al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                return;
            }
            if (!NativeCrashHandler.n) {
                NativeCrashHandler.this.a(999, "false");
            }
            CrashDetailBean a2 = be.a(NativeCrashHandler.this.d, NativeCrashHandler.f26521a, NativeCrashHandler.this.g);
            if (a2 != null) {
                al.a("[Native] Get crash from native record.", new Object[0]);
                if (!NativeCrashHandler.this.m.a(a2, true)) {
                    NativeCrashHandler.this.m.b(a2, false);
                }
                be.a(false, NativeCrashHandler.f26521a);
            }
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
            long b = ap.b() - at.j;
            long b2 = ap.b() + 86400000;
            File file = new File(NativeCrashHandler.f26521a);
            if (file.exists() && file.isDirectory()) {
                try {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new II0xO0());
                        int length = listFiles.length;
                        long j = 0;
                        int i2 = 0;
                        int i3 = 0;
                        int i4 = 0;
                        while (i2 < length) {
                            File file2 = listFiles[i2];
                            long lastModified = file2.lastModified();
                            j += file2.length();
                            if (lastModified >= b && lastModified < b2 && j < at.i) {
                                i = length;
                                i2++;
                                length = i;
                            }
                            i = length;
                            al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i3++;
                            if (file2.delete()) {
                                i4++;
                            }
                            i2++;
                            length = i;
                        }
                        al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i3), Integer.valueOf(i4));
                    }
                } catch (Throwable th) {
                    al.a(th);
                }
            }
            ap.b(NativeCrashHandler.this.d, "native_record_lock");
        }
    }

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z, String str) {
        this.d = ap.a(context);
        if (ap.b(f26521a)) {
            try {
                if (ap.b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + aa.a(context).c + "/app_bugly";
            }
            f26521a = str;
        }
        this.m = asVar;
        this.e = aaVar;
        this.f = akVar;
        this.h = z;
        this.g = new bd(context, aaVar, asVar, ac.a());
    }

    public static synchronized String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = f26521a;
        }
        return str;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                if (b == null) {
                    b = new NativeCrashHandler(context, aaVar, asVar, akVar, z, str);
                }
                nativeCrashHandler = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeCrashHandler;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return n;
    }

    public static synchronized void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            f26521a = str;
        }
    }

    public static void setShouldHandleInJava(boolean z) {
        n = z;
        NativeCrashHandler nativeCrashHandler = b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z));
        }
    }

    @Override // com.tencent.bugly.proguard.q
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.i || this.j) && str != null && str2 != null && str3 != null) {
            try {
                if (this.j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f.a(new oIX0oI());
    }

    public void disableCatchAnrTrace() {
        c = 1;
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        c |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    @Override // com.tencent.bugly.proguard.q
    public String getLogFromNative() {
        if (!this.i && !this.j) {
            return null;
        }
        try {
            if (this.j) {
                return getNativeLog();
            }
            return (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.g;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            al.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public String getSystemProperty(String str) {
        if (!this.j && !this.i) {
            return bn.b.S;
        }
        return getProperties(str);
    }

    public boolean isEnableCatchAnrTrace() {
        if ((c & 2) == 2) {
            return true;
        }
        return false;
    }

    public synchronized boolean isUserOpened() {
        return this.l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        boolean z;
        if (strategyBean != null) {
            try {
                boolean z2 = strategyBean.f;
                if (z2 != this.k) {
                    al.d("server native changed to %b", Boolean.valueOf(z2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (ac.a().c().f && this.l) {
            z = true;
        } else {
            z = false;
        }
        if (z != this.k) {
            al.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.i || this.j) && str != null && str2 != null) {
            try {
                if (this.j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z, int i);

    public void removeEmptyNativeRecordFiles() {
        be.c(f26521a);
    }

    public native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public native void setNativeInfo(int i, String str);

    @Override // com.tencent.bugly.proguard.q
    public boolean setNativeIsAppForeground(boolean z) {
        String str;
        if (z) {
            str = "true";
        } else {
            str = "false";
        }
        return a(14, str);
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (!al.a(e)) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        try {
            c(z);
            boolean isUserOpened = isUserOpened();
            ac a2 = ac.a();
            if (a2 != null) {
                if (isUserOpened && a2.c().f) {
                    isUserOpened = true;
                } else {
                    isUserOpened = false;
                }
            }
            if (isUserOpened != this.k) {
                al.a("native changed to %b", Boolean.valueOf(isUserOpened));
                b(isUserOpened);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void startNativeMonitor() {
        try {
            if (!this.j && !this.i) {
                boolean b2 = ap.b(this.e.t);
                boolean z = !b2;
                if (at.b) {
                    String str = "Bugly_Native";
                    if (!b2) {
                        str = this.e.t;
                    }
                    boolean a2 = a(str, z);
                    this.j = a2;
                    if (!a2 && b2) {
                        this.i = a("NativeRQD", false);
                    }
                } else {
                    String str2 = "Bugly_Native";
                    aa aaVar = this.e;
                    String str3 = aaVar.t;
                    if (b2) {
                        aaVar.getClass();
                    } else {
                        str2 = str3;
                    }
                    this.j = a(str2, z);
                }
                if (!this.j && !this.i) {
                    return;
                }
                a(this.h);
                setNativeAppVersion(this.e.o);
                setNativeAppChannel(this.e.s);
                setNativeAppPackage(this.e.c);
                setNativeUserId(this.e.f());
                setNativeIsAppForeground(this.e.a());
                setNativeLaunchTime(this.e.f26524a);
                return;
            }
            a(this.h);
        } catch (Throwable th) {
            throw th;
        }
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (!this.j) {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void unBlockSigquit(boolean z) {
        if (z) {
            a(21, "true");
        } else {
            a(21, "false");
        }
    }

    public native String unregist();

    private synchronized void c() {
        if (!this.k) {
            al.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                al.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.k = false;
                return;
            }
        } catch (Throwable unused) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.k = false;
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
            this.j = false;
            this.i = false;
        }
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    private synchronized void a(boolean z) {
        if (this.k) {
            al.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.j) {
            try {
                String regist = regist(f26521a, z, c);
                if (regist != null) {
                    al.a("[Native] Native Crash Report enable.", new Object[0]);
                    this.e.u = regist;
                    String concat = HelpFormatter.DEFAULT_OPT_PREFIX.concat(regist);
                    if (!at.b && !this.e.h.contains(concat)) {
                        aa aaVar = this.e;
                        aaVar.h = aaVar.h.concat(HelpFormatter.DEFAULT_OPT_PREFIX).concat(this.e.u);
                    }
                    al.a("comInfo.sdkVersion %s", this.e.h);
                    this.k = true;
                    String runningCpuAbi = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi)) {
                        this.e.e(runningCpuAbi);
                    }
                    return;
                }
            } catch (Throwable unused) {
                al.c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.i) {
            try {
                Class cls = Integer.TYPE;
                String str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", new Class[]{String.class, String.class, cls, cls}, new Object[]{f26521a, ab.d(), Integer.valueOf(z ? 1 : 5), 1});
                if (str == null) {
                    String d = ab.d();
                    aa.b();
                    str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{f26521a, d, Integer.valueOf(aa.B())});
                }
                if (str != null) {
                    this.k = true;
                    this.e.u = str;
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.e.e(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.j = false;
        this.i = false;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = b;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        a(16, String.valueOf(z));
        a(17, String.valueOf(z2));
        a(18, String.valueOf(z3));
        testNativeCrash();
    }

    private synchronized void c(boolean z) {
        if (this.l != z) {
            al.a("user change native %b", Boolean.valueOf(z));
            this.l = z;
        }
    }

    private static boolean a(String str, boolean z) {
        boolean z2;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                al.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                al.d(th.getMessage(), new Object[0]);
                al.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str) {
        if (!this.j) {
            return false;
        }
        try {
            setNativeInfo(i, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
