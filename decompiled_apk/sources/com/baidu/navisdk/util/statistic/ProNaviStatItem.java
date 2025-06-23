package com.baidu.navisdk.util.statistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import java.util.Map;

/* loaded from: classes8.dex */
public class ProNaviStatItem extends com.baidu.navisdk.comapi.statistics.f implements com.baidu.navisdk.module.statistics.b {
    private static ProNaviStatItem V0;
    private String A;
    public int A0;
    public long B;
    public int B0;
    private long C;
    public int C0;
    public long D;
    public int D0;
    private long E;
    public int E0;
    public long F;
    public int F0;
    private long G;
    public int G0;
    public long H;
    public long H0;
    private long I;

    /* renamed from: I0, reason: collision with root package name */
    private long f9357I0;
    private int J;
    public long J0;
    private int K;
    private long K0;
    private long L;
    public long L0;
    private float M;
    private long M0;
    private float N;
    private long N0;
    private boolean O;

    /* renamed from: O0, reason: collision with root package name */
    private long f9358O0;
    private BroadcastReceiver P;
    private int P0;
    private Intent Q;
    private int Q0;
    private long R;
    private long R0;
    private int S;
    private long S0;
    private boolean T;
    private int T0;
    private long U;
    private int U0;
    private long V;
    private int W;
    private long X;
    private long Y;
    private long Z;
    private long a0;
    private long b0;
    private long c0;
    private int d0;
    private int e0;
    private String f0;
    private String g0;
    private int h0;
    private int i0;
    private int j;
    public int j0;
    public int k;
    public int k0;
    public long l;
    public int l0;
    public long m;
    public int m0;
    public boolean n;
    public int n0;
    private long o;

    /* renamed from: o0, reason: collision with root package name */
    public int f9359o0;
    private int p;
    public int p0;
    private int q;
    public int q0;
    public long r;
    public int r0;
    private long s;
    public int s0;
    private boolean t;
    public int t0;
    public long u;
    public int u0;
    public long v;
    public int v0;
    public long w;
    public int w0;
    private int x;

    /* renamed from: x0, reason: collision with root package name */
    public int f9360x0;
    private int y;
    public int y0;
    private String z;
    public int z0;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.lite.b {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            ProNaviStatItem.this.M();
        }
    }

    private ProNaviStatItem(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
        this.j = 0;
        this.k = 1;
        this.n = false;
        this.o = 0L;
        this.p = 0;
        this.q = 0;
        this.r = -1L;
        this.s = 0L;
        this.t = false;
        this.y = 0;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = 0;
        this.K = 0;
        this.L = 0L;
        this.M = 0.0f;
        this.N = 0.0f;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = 0L;
        this.S = 0;
        this.T = false;
        this.U = System.currentTimeMillis();
        this.V = 0L;
        this.W = -1;
        this.X = -1L;
        this.Y = -1L;
        this.Z = -1L;
        this.a0 = -1L;
        this.b0 = 0L;
        this.c0 = 0L;
        this.d0 = 0;
        this.e0 = -1;
        this.f0 = null;
        this.g0 = "";
        this.h0 = -1;
        this.i0 = 0;
        this.j0 = -1;
        this.k0 = -1;
        this.l0 = -1;
        this.m0 = -1;
        this.n0 = -1;
        this.f9359o0 = -1;
        this.p0 = -1;
        this.q0 = -1;
        this.r0 = -1;
        this.s0 = -1;
        this.t0 = -1;
        this.u0 = -1;
        this.v0 = -1;
        this.w0 = -1;
        this.f9360x0 = -1;
        this.y0 = -1;
        this.z0 = -1;
        this.A0 = -1;
        this.B0 = -1;
        this.C0 = -1;
        this.D0 = -1;
        this.E0 = -1;
        this.F0 = -1;
        this.G0 = -1;
        this.H0 = 0L;
        this.f9357I0 = 0L;
        this.J0 = 0L;
        this.K0 = 0L;
        this.L0 = 0L;
        this.M0 = 0L;
        this.N0 = 0L;
        this.f9358O0 = 0L;
        this.P0 = 0;
        this.Q0 = 0;
        this.R0 = 0L;
        this.S0 = 0L;
        this.T0 = 0;
        this.U0 = 0;
    }

    private void L() {
        for (Map.Entry<String, Long> entry : com.baidu.navisdk.module.block.a.d.entrySet()) {
            b(entry.getKey(), String.valueOf(entry.getValue()));
        }
        b("page_medium_block_count", com.baidu.navisdk.module.block.a.b().f7040a.toString());
        b("page_serious_block_count", com.baidu.navisdk.module.block.a.b().b.toString());
        b("page_fatal_block_count", com.baidu.navisdk.module.block.a.b().c.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        b("entry", String.valueOf(0));
        b("device_info", com.baidu.navisdk.util.common.q.c());
        b("cpu_count", String.valueOf(com.baidu.navisdk.util.common.q.b()));
        if (com.baidu.navisdk.framework.a.c().a() != null) {
            b("cpu_name", com.baidu.navisdk.util.common.q.a(com.baidu.navisdk.framework.a.c().a()));
            b("cpu_max_freq", com.baidu.navisdk.util.common.q.c(com.baidu.navisdk.framework.a.c().a()));
            b("device_total_memory", String.valueOf(com.baidu.navisdk.util.common.q.b(com.baidu.navisdk.framework.a.c().a())));
        }
        for (Map.Entry<String, Long> entry : com.baidu.navisdk.module.perform.b.c.entrySet()) {
            b(entry.getKey(), String.valueOf(entry.getValue()));
        }
        b("navi_page_preload", String.valueOf(com.baidu.navisdk.module.perform.b.h));
        b("rr_enter_top_card_init", String.valueOf(com.baidu.navisdk.module.perform.b.g));
        com.baidu.navisdk.module.perform.b.h = 0;
        com.baidu.navisdk.module.perform.b.g = 1;
        b("device_perf_level", String.valueOf(com.baidu.navisdk.module.cloudconfig.a.b().a("device_perf_level", -1)));
        com.baidu.navisdk.module.abtest.model.g s = com.baidu.navisdk.module.abtest.model.g.s();
        if (s != null) {
            b("navi_ab_heat_monitor_plan", String.valueOf(s.o()));
        }
        long g = com.baidu.navisdk.module.perform.b.g("cost_maps_start_time");
        if (g > 0) {
            BNSettingManager.setMapsStartTime(g);
        }
        b(SettingParams.Key.MAPS_INIT_TIME, String.valueOf(BNSettingManager.getMapsStartTime()));
        a(false);
    }

    private void N() {
        LogUtil.e("Statistics-ProNaviStatItem", "endtStat battery after :" + this.N);
        if (this.P != null && com.baidu.navisdk.framework.a.c().a() != null) {
            try {
                com.baidu.navisdk.framework.a.c().a().unregisterReceiver(this.P);
                LogUtil.e("Statistics-ProNaviStatItem", "stat startStat battery has unregistered :");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized ProNaviStatItem O() {
        ProNaviStatItem proNaviStatItem;
        synchronized (ProNaviStatItem.class) {
            try {
                if (V0 == null) {
                    synchronized (ProNaviStatItem.class) {
                        try {
                            if (V0 == null) {
                                V0 = new ProNaviStatItem(com.baidu.navisdk.comapi.statistics.b.f());
                            }
                        } finally {
                        }
                    }
                }
                proNaviStatItem = V0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return proNaviStatItem;
    }

    private long P() {
        int myUid = Process.myUid();
        long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
        long uidTxBytes = TrafficStats.getUidTxBytes(myUid);
        if (uidRxBytes <= 0) {
            uidRxBytes = 0;
        }
        if (uidTxBytes <= 0) {
            uidTxBytes = 0;
        }
        return uidRxBytes + uidTxBytes;
    }

    public void A() {
        this.f9357I0 = SystemClock.elapsedRealtime();
    }

    public void B() {
        this.K0 = SystemClock.elapsedRealtime();
    }

    public void C() {
        if (this.C != 0) {
            this.B += SystemClock.elapsedRealtime() - this.C;
        }
        this.C = 0L;
    }

    public void D() {
        if (this.G != 0) {
            this.F += SystemClock.elapsedRealtime() - this.G;
            d("fullt", (this.F / 1000) + "");
        }
        this.G = 0L;
    }

    public void E() {
        if (this.E != 0) {
            this.D += SystemClock.elapsedRealtime() - this.E;
            d("land", (this.D / 1000) + "");
        }
        this.E = 0L;
    }

    public void F() {
        if (this.I != 0) {
            this.H += SystemClock.elapsedRealtime() - this.I;
            d("nort", (this.H / 1000) + "");
        }
        this.I = 0L;
    }

    public void G() {
        this.G = SystemClock.elapsedRealtime();
    }

    public void H() {
        this.E = SystemClock.elapsedRealtime();
    }

    public void I() {
        if (this.I != 0) {
            F();
        }
        this.I = SystemClock.elapsedRealtime();
    }

    public void J() {
        this.T = true;
        this.U = System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v18 */
    public void K() {
        ?? r0;
        this.K = j.b().a();
        b("ps0", this.K + "");
        if (com.baidu.navisdk.module.cloudconfig.a.b().b("is_open_perform_monitor", false)) {
            com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new a("Statistics-ProNaviStatItem_CommonProfile"), 10001);
        }
        this.L = P();
        N();
        if (this.P == null) {
            this.P = new BroadcastReceiver() { // from class: com.baidu.navisdk.util.statistic.ProNaviStatItem.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        if (intent.getIntExtra("status", 1) == 2) {
                            if (!ProNaviStatItem.this.O) {
                                ProNaviStatItem.this.O = true;
                            }
                            LogUtil.e("Statistics-ProNaviStatItem", "startStat battery has charge  :" + ProNaviStatItem.this.O);
                        }
                        ProNaviStatItem proNaviStatItem = ProNaviStatItem.this;
                        proNaviStatItem.N = proNaviStatItem.a(intent.getIntExtra("level", 0), intent.getIntExtra("scale", 100));
                    }
                }
            };
        }
        if (this.P != null && com.baidu.navisdk.framework.a.c().a() != null) {
            try {
                this.Q = com.baidu.navisdk.framework.a.c().a().registerReceiver(this.P, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.Q != null) {
                LogUtil.e("Statistics-ProNaviStatItem", "startStat battery has registered :");
                this.M = a(this.Q.getIntExtra("level", 0), this.Q.getIntExtra("scale", 100));
            }
        }
        LogUtil.e("Statistics-ProNaviStatItem", "startStat battery before :" + this.M);
        this.c0 = 0L;
        this.b0 = 0L;
        this.R = 0L;
        if (com.baidu.navisdk.j.d() && com.baidu.navisdk.module.base.c.a()) {
            r0 = 1;
        } else {
            r0 = 0;
        }
        this.t = r0;
        b("hasData", ((int) r0) + "");
        this.e0 = com.baidu.navisdk.module.base.b.a();
        b("city", this.e0 + "");
        a(false);
    }

    public void c(String str) {
        d("dfd", str);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50003";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public int e() {
        return 1;
    }

    public void f(int i) {
        this.d0 = i;
        d("entry", this.d0 + "");
    }

    public void g(int i) {
        int i2;
        if (this.f9358O0 != 0) {
            this.N0 += SystemClock.elapsedRealtime() - this.f9358O0;
            d("hd_time", (this.N0 / 1000) + "");
        }
        this.f9358O0 = 0L;
        int i3 = this.Q0;
        if (i3 != 0 && (i2 = i3 - i) > 0) {
            this.P0 += i2;
            d("hd_dis", this.P0 + "");
        }
        this.Q0 = 0;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-ProNaviStatItem";
    }

    public void i(int i) {
        this.i0 = i;
        d("navifinish_mode", this.i0 + "");
    }

    public void j(int i) {
        this.J = i;
        d("nt", this.J + "");
    }

    public void k(int i) {
        int i2;
        if (this.S0 != 0) {
            this.R0 += SystemClock.elapsedRealtime() - this.S0;
            d("normal_hd_time", (this.R0 / 1000) + "");
        }
        this.S0 = 0L;
        int i3 = this.U0;
        if (i3 != 0 && (i2 = i3 - i) > 0) {
            this.T0 += i2;
            d("normal_hd_dis", this.T0 + "");
        }
        this.U0 = 0;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void l() {
        super.l();
        this.W = -1;
        this.X = -1L;
        this.k = 1;
        this.l = 0L;
        this.m = 0L;
        this.L = 0L;
        this.n = false;
        this.o = 0L;
        this.p = 0;
        this.q = 0;
        this.r = -1L;
        this.s = 0L;
        this.u = 0L;
        this.t = false;
        this.v = 0L;
        this.w = 0L;
        this.M = 0.0f;
        this.N = 0.0f;
        this.Q = null;
        this.P = null;
        this.O = false;
        this.K = 0;
        this.x = 0;
        this.y = 0;
        this.z = null;
        this.A = null;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.R = 0L;
        this.b0 = 0L;
        this.c0 = 0L;
        this.J = 0;
        this.f0 = null;
        this.g0 = "";
        this.Y = -1L;
        this.Z = -1L;
        this.a0 = -1L;
        this.h0 = -1;
        this.i0 = 1;
        this.j0 = -1;
        this.k0 = -1;
        this.l0 = -1;
        this.m0 = -1;
        this.n0 = -1;
        this.f9359o0 = -1;
        this.p0 = -1;
        this.q0 = -1;
        this.r0 = -1;
        this.s0 = -1;
        this.t0 = -1;
        this.u0 = -1;
        this.v0 = -1;
        this.w0 = -1;
        this.f9360x0 = -1;
        this.y0 = -1;
        this.z0 = -1;
        this.S = 0;
        this.T = false;
        this.U = System.currentTimeMillis();
        this.V = 0L;
        this.L0 = 0L;
        this.M0 = 0L;
        this.H0 = 0L;
        this.f9357I0 = 0L;
        this.J0 = 0L;
        this.K0 = 0L;
        this.N0 = 0L;
        this.f9358O0 = 0L;
        this.P0 = 0;
        this.Q0 = 0;
        this.R0 = 0L;
        this.S0 = 0L;
        this.T0 = 0;
        this.U0 = 0;
    }

    public void m(int i) {
        this.h0 = i;
        if (i >= 0) {
            d("parking_service", this.h0 + "");
        }
    }

    public void n(int i) {
        if (this.j == 0) {
            this.k = i;
            d("start_route", this.k + "");
        }
    }

    public void o() {
        this.p++;
        d("lost_times", this.p + "");
    }

    public void p() {
        this.q++;
        d("out_times", this.q + "");
    }

    public void q() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ProNaviStatItem", "calcNaviPeriodStatistics->");
        }
        b("real_time", Long.valueOf((SystemClock.elapsedRealtime() - i.f9373a) / 1000) + "");
        b("df", Double.valueOf((double) ((P() - this.L) / 1024)) + "");
        b("lost_times", this.p + "");
        b("out_times", this.q + "");
        b("bt", (this.R / 1000) + "");
        if (!l0.c(this.z)) {
            a("pn", this.z + "");
        }
        a("cld", this.y + "");
        b("nt", this.J + "");
        b("land", (this.D / 1000) + "");
        b("fullt", (this.F / 1000) + "");
        b("nort", (this.H / 1000) + "");
        b("ar_full", (this.L0 / 1000) + "");
        b("ar_portrait", (this.H0 / 1000) + "");
        b("ar_real_time", (this.J0 / 1000) + "");
        b("hd_time", (this.N0 / 1000) + "");
        b("hd_dis", this.P0 + "");
        b("normal_hd_time", (this.R0 / 1000) + "");
        b("normal_hd_dis", this.T0 + "");
        a(false);
    }

    public void r() {
        if (!this.T) {
            return;
        }
        this.T = false;
        long currentTimeMillis = this.V + (System.currentTimeMillis() - this.U);
        this.V = currentTimeMillis;
        d("lost_totaltime", Long.toString(currentTimeMillis / 1000));
    }

    public void s() {
        if (this.d0 == 4) {
            this.Y = q.a("sdk_routeguide_refresh_firstinfo") - q.a("map_poi_click_start");
            this.Z = q.a("sdk_routeguide_refresh_firstinfo") - q.a("sdk_start_lib_routeplan");
            this.a0 = q.a("lib_network_server");
            b("pp_all_time", this.Y + "");
            b("pp_en_time", this.Z + "");
            b("pp_ns_time", this.a0 + "");
            a(false);
        }
    }

    public void t() {
        if (this.b0 == 0) {
            this.c0 = SystemClock.elapsedRealtime();
        }
    }

    public void u() {
        if (this.c0 != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.b0 = elapsedRealtime;
            this.R += elapsedRealtime - this.c0;
            b("bt", (this.R / 1000) + "");
        }
        this.c0 = 0L;
        this.b0 = 0L;
        a(false);
    }

    public void v() {
        if (!this.n) {
            this.n = true;
            SystemClock.elapsedRealtime();
            this.r = (SystemClock.elapsedRealtime() - i.f9373a) / 1000;
            b("loc_time", this.r + "");
            SystemClock.elapsedRealtime();
            SystemClock.elapsedRealtime();
            a(false);
        }
    }

    public void w() {
        if (this.M0 != 0) {
            this.L0 += SystemClock.elapsedRealtime() - this.M0;
            d("ar_full", (this.L0 / 1000) + "");
        }
        this.M0 = 0L;
    }

    public void x() {
        if (this.f9357I0 != 0) {
            this.H0 += SystemClock.elapsedRealtime() - this.f9357I0;
            d("ar_portrait", (this.H0 / 1000) + "");
        }
        this.f9357I0 = 0L;
    }

    public void y() {
        if (this.K0 != 0) {
            this.J0 += SystemClock.elapsedRealtime() - this.K0;
            d("ar_real_time", (this.J0 / 1000) + "");
        }
        this.K0 = 0L;
    }

    public void z() {
        this.M0 = SystemClock.elapsedRealtime();
    }

    public void b(long j) {
        b(SettingParams.Key.TTS_COPY_TIME, Long.toString(j));
        a(false);
    }

    public void c(long j) {
        this.o = j;
        d("real_dis", this.o + "");
    }

    public void d(int i) {
        this.S = i;
        b("dft", Integer.toString(i));
    }

    public void e(int i) {
        String str = this.x + "/" + i;
        this.z = str;
        a("pn", str, true);
    }

    public void h(int i) {
        this.f9358O0 = SystemClock.elapsedRealtime();
        this.Q0 = i;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        N();
        if (this.W >= 0 && this.X >= 0) {
            b("inittime_type", this.W + "");
            b("inittime", this.X + "");
        }
        b("start_route", this.k + "");
        b("rou_dis", this.m + "");
        b("rou_time", this.l + "");
        long elapsedRealtime = (SystemClock.elapsedRealtime() - i.f9373a) / 1000;
        Long valueOf = Long.valueOf(elapsedRealtime);
        b("real_time", valueOf + "");
        b("real_dis", this.o + "");
        LogUtil.e("Statistics-ProNaviStatItem", "NaviStatItem onevent beforeNavi = " + this.M + " afterNavi = " + this.N + " duration = " + valueOf + " mHasCharge = " + this.O);
        if (!this.O) {
            float f = this.M - this.N;
            if (elapsedRealtime > 0 && f >= 0.0f) {
                b("bph", ((f / ((float) elapsedRealtime)) * 3600.0f) + "");
            }
            b("bbn", this.M + "");
            b("ban", this.N + "");
        }
        b("loc_time", this.r + "");
        b("lost_times", this.p + "");
        b("out_times", this.q + "");
        b("ps0", this.K + "");
        b("pss", j.b().a() + "");
        b("df", Double.valueOf((double) ((P() - this.L) / 1024)) + "");
        c.d().a();
        b("jph", c.d().b() + "");
        b("hasData", (this.t ? 1 : 0) + "");
        b("dest_dis", this.s + "");
        b("bt", (this.R / 1000) + "");
        b("entry", this.d0 + "");
        b("city", this.e0 + "");
        if (!l0.c(this.z)) {
            a("pn", this.z + "");
        }
        a("cld", this.y + "");
        if (this.A != null) {
            a("vid", this.A + "");
        }
        b("nt", this.J + "");
        b("land", (this.D / 1000) + "");
        b("fullt", (this.F / 1000) + "");
        b("nort", (this.H / 1000) + "");
        if (this.f0 != null) {
            b("ssid", this.f0 + "");
        }
        l0.c(this.g0);
        b("pp_all_time", this.Y + "");
        b("pp_en_time", this.Z + "");
        b("pp_ns_time", this.a0 + "");
        if (this.h0 >= 0) {
            b("parking_service", this.h0 + "");
        }
        b("navifinish_mode", this.i0 + "");
        if (this.n0 >= 0) {
            b("dd_still_sample_fail", this.j0 + "");
            b("dd_driving_sample_fail", this.k0 + "");
            b("dd_train", this.l0 + "");
            b("dd_train_fail", this.m0 + "");
            b("dd_infer", this.n0 + "");
            b("dd_infer_fail", this.f9359o0 + "");
            b("dd_infer_recall", this.p0 + "");
            b("dd_first_verify", this.q0 + "");
            b("dd_first_verify_fail", this.r0 + "");
            b("dd_period_verify", this.s0 + "");
            b("dd_period_verify_fail", this.t0 + "");
            b("dd_infer_stop_right", this.f9360x0 + "");
            b("dd_infer_stop_all", this.y0 + "");
            b("dd_open_stop_all", this.z0 + "");
            if (this.C0 > 0) {
                b("dd_infer_stop_right_rate", this.C0 + "");
            }
            if (this.A0 > 0) {
                b("dd_infer_right_rate", this.A0 + "");
            }
        }
        if (this.u0 > 0) {
            b("dd_simple_infer", this.u0 + "");
            b("dd_simple_infer_fail", this.v0 + "");
            b("dd_simple_invalidate_model", this.w0 + "");
            if (this.D0 > 0) {
                b("dd_infer_simple_stop_right_rate", this.D0 + "");
            }
            if (this.B0 > 0) {
                b("dd_infer_simple_right_rate", this.B0 + "");
            }
        }
        if (this.E0 > 0) {
            b("dd_not_zero", this.E0 + "");
        }
        if (this.F0 > 0) {
            b("dd_turn_advance", this.F0 + "");
        }
        if (this.G0 > 0) {
            b("dd_check_yaw", this.G0 + "");
        }
        b("device_info", com.baidu.navisdk.util.common.q.c());
        b("ar_real_time", (this.J0 / 1000) + "");
        b("ar_portrait", (this.H0 / 1000) + "");
        b("ar_full", (this.L0 / 1000) + "");
        if (BNSettingManager.isNoviceMode()) {
            b("new_comer", "1");
        }
        if (com.baidu.navisdk.module.block.a.b().a()) {
            L();
        }
        b("hd_time", (this.N0 / 1000) + "");
        b("hd_dis", this.P0 + "");
        b("normal_hd_time", (this.R0 / 1000) + "");
        b("normal_hd_dis", this.T0 + "");
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-ProNaviStatItem", "onEvent->actParams: " + m());
        }
        super.b(i);
    }

    public void d(long j) {
        b("dd_train_time", Long.toString(j));
        a(false);
    }

    public void e(String str) {
        this.A = str;
        if (str != null) {
            a("vid", str, true);
        }
    }

    public void n() {
        this.x++;
    }

    public void a(String str, String str2, boolean z) {
        if (z) {
            a(str, str2);
        } else {
            b(str, str2);
        }
        super.a(false);
    }

    public void d(String str, String str2) {
        a(str, str2, false);
    }

    public void d(String str) {
        this.f0 = str;
        if (str != null) {
            d("ssid", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(int i, int i2) {
        if (i2 != 0) {
            return (i * 100) / i2;
        }
        return 100.0f;
    }

    public void a(long j, long j2) {
        this.l = j;
        this.m = j2;
        b("rou_dis", this.m + "");
        b("rou_time", this.l + "");
        a(false);
    }

    public void a(long j) {
        this.s = j;
        d("dest_dis", this.s + "");
    }

    public void l(int i) {
        this.S0 = SystemClock.elapsedRealtime();
        this.U0 = i;
    }

    public void b(String str) {
        d("hp_mode", str);
    }
}
