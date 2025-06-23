package com.baidu.mobads.sdk.internal;

import XIXIX.OOXIXo;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* loaded from: classes7.dex */
public class cb {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6267a = "ApkLoader";
    protected static Thread.UncaughtExceptionHandler b = null;
    public static final String c = "__badApkVersion__9.35";
    public static final String d = "previousProxyVersion";
    protected static final String e = "__xadsdk__remote__final__";
    protected static final String f = "bdxadsdk.jar";
    protected static final String g = "__xadsdk__remote__final__builtin__.jar";
    protected static final String h = "__xadsdk__remote__final__builtinversion__.jar";
    protected static final String i = "__xadsdk__remote__final__downloaded__.jar";
    protected static final String j = "__xadsdk__remote__final__running__.jar";
    public static final String k = "OK";
    public static final String l = "ERROR";
    public static final String m = "APK_INFO";
    public static final String n = "CODE";
    public static final String o = "success";
    protected static volatile bq p = null;
    protected static volatile bq q = null;
    protected static volatile Class r = null;
    protected static String s = null;
    protected static final Handler t = new cc(Looper.getMainLooper());
    private static final String x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;
    protected Handler u;

    @SuppressLint({"HandlerLeak"})
    protected final Handler v;
    private bz w;
    private final Context y;
    private bv z;

    /* loaded from: classes7.dex */
    public static final class a extends Exception {

        /* renamed from: a, reason: collision with root package name */
        private static final long f6268a = 2978543166232984104L;

        public a(String str) {
            bv.a().c(str);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Exception {

        /* renamed from: a, reason: collision with root package name */
        private static final long f6269a = -7838296421993681751L;

        public b(String str) {
            bv.a().c(str);
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z);
    }

    public cb(Activity activity) {
        this(activity.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            File[] listFiles = this.y.getFilesDir().listFiles();
            int i2 = 0;
            while (listFiles != null) {
                if (i2 < listFiles.length) {
                    if (listFiles[i2].getAbsolutePath().contains(e) && listFiles[i2].getAbsolutePath().endsWith("dex")) {
                        listFiles[i2].delete();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        } catch (Exception e2) {
            bv.a().c(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        return this.y.getSharedPreferences(x.aN, 0);
    }

    private boolean n() {
        String string = m().getString(d, null);
        String a2 = a();
        if (string == null || !string.equals(a2)) {
            return true;
        }
        return false;
    }

    private boolean o() {
        try {
            if (!bt.a(c())) {
                if (!bt.a(f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            this.z.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        bu buVar = new bu(f(), this.y);
        if (bt.a(buVar)) {
            try {
                if (!n()) {
                    synchronized (this) {
                        try {
                            this.z.a(f6267a, "loadDownloadedOrBuiltInApk len=" + buVar.length() + ", path=" + buVar.getAbsolutePath());
                            b(buVar);
                            double d2 = (double) m().getFloat(c, -1.0f);
                            this.z.a(f6267a, "downloadedApkFile.getApkVersion(): " + buVar.c() + ", badApkVersion: " + d2);
                            if (buVar.c() != d2) {
                                this.z.a(f6267a, "loaded: " + buVar.getPath());
                            } else {
                                throw new a("downloaded file marked bad, drop it and use built-in");
                            }
                        } finally {
                        }
                    }
                    return true;
                }
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            } catch (a e2) {
                this.z.a(f6267a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
                if (buVar.exists()) {
                    buVar.delete();
                }
                k();
                return false;
            }
        }
        return false;
    }

    public int h() {
        return this.y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public IXAdContainerFactory i() {
        return a(p);
    }

    public IXAdContainerFactory j() {
        return a(q);
    }

    public void k() {
        if (p != null) {
            p.b();
            p = null;
        }
    }

    public cb(Context context) {
        this.z = bv.a();
        this.A = false;
        this.u = t;
        this.B = new CopyOnWriteArrayList<>();
        this.v = new cd(this, Looper.getMainLooper());
        this.y = context;
        c(context);
        if (b == null) {
            b = cp.a(context);
            cp.a(context).a(new ce(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cp) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(b);
    }

    public static String f() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + i;
    }

    public void e() {
        this.z.a(f6267a, "start load assets file");
        d(this.y);
        String c2 = c();
        bu buVar = new bu(c2, this.y);
        if (bt.a(buVar)) {
            this.z.a(f6267a, "assets file can read ,will use it ");
            if (c(buVar)) {
                b(true);
                return;
            }
            return;
        }
        throw new b("loadBuiltInApk failed: " + c2);
    }

    public void g() {
        if (h() != 2 ? p() : false) {
            this.z.a(f6267a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.z.a(f6267a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            this.z.a(f6267a, "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(s)) {
            s = context.getDir(x, 0).getAbsolutePath() + "/";
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + h;
    }

    public void b() {
        new File(f()).delete();
    }

    private void b(bu buVar) {
        this.z.a(f6267a, "len=" + buVar.length() + ", path=" + buVar.getAbsolutePath());
        if (p == null) {
            String a2 = a(this.y);
            bu buVar2 = new bu(a2, this.y);
            if (buVar2.exists()) {
                buVar2.delete();
            }
            try {
                bt.a(new FileInputStream(buVar), a2);
            } catch (Exception e2) {
                this.z.c(e2);
            }
            p = new bq(buVar2.b(), this.y);
            try {
                IXAdContainerFactory a3 = p.a();
                this.z.a(f6267a, "preloaded apk.version=" + a3.getRemoteVersion());
                return;
            } catch (a e3) {
                this.z.a(f6267a, "preload local apk " + buVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + p.b);
                a(e3.getMessage());
                throw e3;
            }
        }
        this.z.a(f6267a, "mApkBuilder already initialized, version: " + p.b);
    }

    public static String c() {
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + g;
    }

    private static synchronized void d(Context context) {
        synchronized (cb.class) {
            try {
                try {
                    String c2 = c();
                    double b2 = b(c2);
                    bv.a().a(f6267a, "copy assets,compare version=" + Double.valueOf("9.35") + "remote=" + b2);
                    if (Double.valueOf("9.35").doubleValue() != b2) {
                        bu buVar = new bu(c2, context);
                        if (buVar.exists()) {
                            buVar.delete();
                        }
                        bt.a(context, f, c2);
                    }
                } catch (Exception e2) {
                    throw new b("loadBuiltInApk failed: " + e2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String a() {
        return "9.35";
    }

    @TargetApi(9)
    public void a(String str) {
        if (p != null) {
            SharedPreferences.Editor edit = m().edit();
            edit.putFloat(c, (float) p.b);
            edit.apply();
        }
    }

    private boolean c(bu buVar) {
        synchronized (this) {
            b(buVar);
            this.z.a(f6267a, "loaded: " + buVar.getPath());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Message obtainMessage = this.u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.u.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        double d2;
        if (z) {
            try {
                d2 = p.b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d2 = OOXIXo.f3760XO;
        }
        ao.a(d2, new ch(this, d2), new ci(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bu buVar) {
        Class<?> b2 = buVar.b();
        synchronized (this) {
            q = new bq(b2, this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, String str) {
        try {
            cp.a(this.y).c();
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i2 = 0; i2 < this.B.size(); i2++) {
                    c cVar = this.B.get(i2);
                    if (cVar != null) {
                        cVar.a(z);
                    }
                }
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!z && !o()) {
            this.A = true;
        } else {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.A) {
            be.a().a((i) new cf(this, z));
        } else {
            be.a().a(new cg(this, z), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.u = handler;
        if (p == null) {
            g();
        } else {
            b(true);
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(s)) {
            s = context.getDir(x, 0).getAbsolutePath() + "/";
        }
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        return s + j;
    }

    public static double b(Context context) {
        try {
            c(context);
            double b2 = b(f());
            String d2 = d();
            if (Double.valueOf("9.35").doubleValue() > b(d2)) {
                bu buVar = new bu(d2, context);
                if (buVar.exists()) {
                    buVar.delete();
                }
                bt.a(context, f, d2);
            }
            return Math.max(b2, b(d()));
        } catch (Exception unused) {
            return OOXIXo.f3760XO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bz bzVar) {
        if (bzVar.a().booleanValue()) {
            bx a2 = bx.a(this.y, bzVar, s, this.v);
            if (!a2.isAlive()) {
                this.z.a(f6267a, "XApkDownloadThread starting ...");
                a2.start();
            } else {
                this.z.a(f6267a, "XApkDownloadThread already started");
                a2.a(bzVar.c());
            }
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        be.a().a((i) new cj(this, cVar, handler));
    }

    public static double b(String str) {
        JarFile jarFile = null;
        try {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        if (co.d.booleanValue()) {
            File file = new File(str);
            if (bt.a(file)) {
                JarFile jarFile2 = new JarFile(file);
                try {
                    double parseDouble = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                    if (parseDouble > OOXIXo.f3760XO) {
                        try {
                            jarFile2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return parseDouble;
                    }
                    jarFile = jarFile2;
                } catch (Exception unused2) {
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    return OOXIXo.f3760XO;
                } catch (Throwable th2) {
                    th = th2;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (jarFile != null) {
                jarFile.close();
            }
            return OOXIXo.f3760XO;
        }
        return Double.valueOf("9.35").doubleValue();
    }

    public void a(c cVar) {
        a(cVar, t);
    }

    private IXAdContainerFactory a(bq bqVar) {
        if (bqVar == null) {
            return null;
        }
        try {
            return bqVar.a();
        } catch (Exception unused) {
            return null;
        }
    }
}
