package com.tencent.bugly.proguard;

import XXO0.oIX0oI;
import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public final class au {

    /* renamed from: a, reason: collision with root package name */
    private static au f26572a;
    private ac b;
    private aa c;
    private as d;
    private Context e;

    /* loaded from: classes13.dex */
    public static class II0xO0 implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f26573IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f26574Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ String f26575Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public final /* synthetic */ Map f26576OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Thread f26577XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ String f26578oI0IIXIo;

        public II0xO0(Thread thread, int i, String str, String str2, String str3, Map map) {
            this.f26577XO = thread;
            this.f26574Oo = i;
            this.f26573IXxxXO = str;
            this.f26575Oxx0xo = str2;
            this.f26578oI0IIXIo = str3;
            this.f26576OxxIIOOXO = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (au.f26572a == null) {
                    al.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                } else {
                    au.a(au.f26572a, this.f26577XO, this.f26574Oo, this.f26573IXxxXO, this.f26575Oxx0xo, this.f26578oI0IIXIo, this.f26576OxxIIOOXO);
                }
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
                al.e("[ExtraCrashManager] Crash error %s %s %s", this.f26573IXxxXO, this.f26575Oxx0xo, this.f26578oI0IIXIo);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            au.a(au.this);
        }
    }

    private au(Context context) {
        at a2 = at.a();
        if (a2 == null) {
            return;
        }
        this.b = ac.a();
        this.c = aa.a(context);
        this.d = a2.s;
        this.e = context;
        ak.a().a(new oIX0oI());
    }

    public static au a(Context context) {
        if (f26572a == null) {
            f26572a = new au(context);
        }
        return f26572a;
    }

    public static void a(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        ak.a().a(new II0xO0(thread, i, str, str2, str3, map));
    }

    public static /* synthetic */ void a(au auVar) {
        al.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            auVar.c.getClass();
            ap.a(cls, "sdkPackageName", "com.tencent.bugly");
            al.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            al.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    public static /* synthetic */ void a(au auVar, Thread thread, int i, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i == 4) {
            str4 = "Unity";
        } else if (i == 5 || i == 6) {
            str4 = "Cocos";
        } else {
            if (i != 8) {
                al.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
                return;
            }
            str4 = "H5";
        }
        al.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!auVar.b.b()) {
                al.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c = auVar.b.c();
            if (!c.f && auVar.b.b()) {
                al.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(str4, ap.a(), auVar.c.d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i != 5 && i != 6) {
                if (i == 8 && !c.l) {
                    al.e("[ExtraCrashManager] %s report is disabled.", str4);
                    al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!c.k) {
                al.e("[ExtraCrashManager] %s report is disabled.", str4);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i2 = i != 8 ? i : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = auVar.c.k();
            crashDetailBean.G = auVar.c.j();
            crashDetailBean.H = auVar.c.l();
            crashDetailBean.I = ab.b(auVar.e);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.b = i2;
            crashDetailBean.e = auVar.c.g();
            aa aaVar = auVar.c;
            crashDetailBean.f = aaVar.o;
            crashDetailBean.g = aaVar.q();
            crashDetailBean.m = auVar.c.f();
            crashDetailBean.n = String.valueOf(str);
            crashDetailBean.o = String.valueOf(str2);
            String str6 = "";
            if (str3 == null) {
                str5 = "";
            } else {
                String[] split = str3.split("\n");
                if (split.length > 0) {
                    str6 = split[0];
                }
                str5 = str3;
            }
            crashDetailBean.p = str6;
            crashDetailBean.q = str5;
            crashDetailBean.r = System.currentTimeMillis();
            crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
            crashDetailBean.z = ap.a(auVar.c.Q, at.h);
            crashDetailBean.A = auVar.c.d;
            crashDetailBean.B = currentThread.getName() + oIX0oI.I0Io.f4096II0xO0 + currentThread.getId() + oIX0oI.I0Io.f4095I0Io;
            crashDetailBean.L = auVar.c.s();
            crashDetailBean.h = auVar.c.p();
            aa aaVar2 = auVar.c;
            crashDetailBean.Q = aaVar2.f26524a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = auVar.c.z();
            aa aaVar3 = auVar.c;
            crashDetailBean.V = aaVar3.x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = auVar.c.y();
            crashDetailBean.y = ao.a();
            if (crashDetailBean.S == null) {
                crashDetailBean.S = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.S.putAll(map);
            }
            as.a(str4, ap.a(), auVar.c.d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!auVar.d.a(crashDetailBean, !at.a().C)) {
                auVar.d.b(crashDetailBean, false);
            }
            al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }
}
