package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes13.dex */
public final class at {
    private static at D = null;

    /* renamed from: a, reason: collision with root package name */
    public static int f26567a = 0;
    public static boolean b = false;
    public static int d = 2;
    public static boolean e = false;
    public static int f = 20480;
    public static int g = 3000;
    public static int h = 20480;
    public static long i = 209715200;
    public static long j = 604800000;
    public static String k = null;
    public static boolean l = false;
    public static String m = null;
    public static int n = 5000;
    public static boolean o = true;
    public static boolean p = false;
    public static String q;
    public static String r;
    public Boolean A;
    public int B = 31;
    public boolean C = false;
    public final Context c;
    public final as s;
    public final av t;
    public final NativeCrashHandler u;
    public final ac v;
    public final ak w;
    public final ay x;
    public BuglyStrategy.a y;
    public aw z;

    /* loaded from: classes13.dex */
    public class I0Io extends Thread {
        public I0Io() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            List<CrashDetailBean> list;
            if (!ap.a(at.this.c, "local_crash_lock")) {
                al.c("Failed to lock file for uploading local crash.", new Object[0]);
                return;
            }
            ag a2 = ag.a.a();
            List<ag.b> a3 = ag.a();
            if (a3 != null && !a3.isEmpty()) {
                al.c("sla load local data list size:%s", Integer.valueOf(a3.size()));
                Iterator<ag.b> it = a3.iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    ag.b next = it.next();
                    if (next.b < ap.b() - com.baidu.mobads.sdk.internal.bn.d) {
                        al.c("sla local data is expired:%s", next.c);
                        arrayList.add(next);
                        it.remove();
                    }
                }
                ag.d(arrayList);
                a2.b(a3);
            } else {
                al.c("sla local data is null", new Object[0]);
            }
            List<CrashDetailBean> a4 = as.a();
            if (a4 != null && a4.size() > 0) {
                al.c("Size of crash list: %s", Integer.valueOf(a4.size()));
                int size = a4.size();
                if (size > 20) {
                    ArrayList arrayList2 = new ArrayList();
                    Collections.sort(a4);
                    for (int i = 0; i < 20; i++) {
                        arrayList2.add(a4.get((size - 1) - i));
                    }
                    list = arrayList2;
                } else {
                    list = a4;
                }
                at.this.s.a(list, 0L, false, false, false);
            } else {
                al.c("no crash need to be uploaded at this start", new Object[0]);
            }
            ap.b(at.this.c, "local_crash_lock");
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeCrashHandler.getInstance().unBlockSigquit(false);
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeCrashHandler.getInstance().unBlockSigquit(true);
        }
    }

    private at(Context context, ak akVar, boolean z, BuglyStrategy.a aVar) {
        f26567a = 1004;
        Context a2 = ap.a(context);
        this.c = a2;
        ac a3 = ac.a();
        this.v = a3;
        this.w = akVar;
        this.y = aVar;
        this.z = null;
        as asVar = new as(a2, ai.a(), w.a(), a3, aVar);
        this.s = asVar;
        aa a4 = aa.a(a2);
        this.t = new av(a2, asVar, a3, a4);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a2, a4, asVar, a3, akVar, z, null);
        this.u = nativeCrashHandler;
        a4.N = nativeCrashHandler;
        if (ay.f == null) {
            ay.f = new ay(a2, a3, a4, akVar, asVar);
        }
        this.x = ay.f;
    }

    public final synchronized void c() {
        this.t.b();
        d();
        g();
    }

    public final void d() {
        this.u.setUserOpened(false);
    }

    public final void e() {
        this.u.setUserOpened(true);
    }

    public final void f() {
        new Handler(Looper.getMainLooper()).post(new oIX0oI());
        this.x.b(true);
    }

    public final void g() {
        new Handler(Looper.getMainLooper()).post(new II0xO0());
        this.x.b(false);
    }

    public final synchronized void h() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 30) {
                try {
                    al.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                    ap.b(5000L);
                    i2 = i3;
                } catch (Throwable th) {
                    if (!al.a(th)) {
                        th.printStackTrace();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final boolean i() {
        return this.x.f26582a.get();
    }

    public final boolean j() {
        if ((this.B & 16) > 0) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        if ((this.B & 8) > 0) {
            return true;
        }
        return false;
    }

    public static synchronized at a(Context context, boolean z, BuglyStrategy.a aVar) {
        at atVar;
        synchronized (at.class) {
            try {
                if (D == null) {
                    D = new at(context, ak.a(), z, aVar);
                }
                atVar = D;
            } catch (Throwable th) {
                throw th;
            }
        }
        return atVar;
    }

    public final synchronized void b() {
        this.t.a();
        e();
        f();
    }

    public static synchronized at a() {
        at atVar;
        synchronized (at.class) {
            atVar = D;
        }
        return atVar;
    }

    public final synchronized void a(boolean z, boolean z2, boolean z3) {
        this.u.testNativeCrash(z, z2, z3);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.s.b(crashDetailBean);
    }

    public final void a(long j2) {
        ak.a().a(new I0Io(), j2);
    }
}
