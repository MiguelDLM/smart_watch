package com.baidu.navisdk.util.statistic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.y;

/* loaded from: classes8.dex */
public class LightNaviStatItem extends com.baidu.navisdk.comapi.statistics.f implements com.baidu.navisdk.module.statistics.b {
    private static LightNaviStatItem p0;
    private float A;
    private boolean B;
    private BroadcastReceiver C;
    private Intent D;
    private long E;
    private Bundle F;
    private Bundle G;
    private long H;
    private long I;
    private long J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private long O;
    private long P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public int e0;
    public int f0;
    public int g0;
    public int h0;
    public int i0;
    private long j;
    public int j0;
    private long k;
    public int k0;
    private int l;
    public int l0;
    private boolean m;
    public int m0;
    private long n;
    public int n0;
    private int o;

    /* renamed from: o0, reason: collision with root package name */
    private String f9353o0;
    private int p;
    private long q;
    private long r;
    private boolean s;
    private long t;
    private long u;
    private long v;
    private String w;
    private int x;
    private long y;
    private float z;

    private LightNaviStatItem(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
        this.l = 8;
        this.m = false;
        this.n = 0L;
        this.o = 0;
        this.p = 0;
        this.q = -1L;
        this.r = 0L;
        this.s = false;
        this.x = 0;
        this.y = 0L;
        this.z = 0.0f;
        this.A = 0.0f;
        this.B = false;
        this.C = null;
        this.D = null;
        this.E = 0L;
        this.F = new Bundle();
        this.G = new Bundle();
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0;
        this.L = 3;
        this.M = -1;
        this.N = false;
        this.O = System.currentTimeMillis();
        this.P = 0L;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        this.f0 = -1;
        this.g0 = -1;
        this.h0 = -1;
        this.i0 = -1;
        this.j0 = -1;
        this.k0 = -1;
        this.l0 = -1;
        this.m0 = -1;
        this.n0 = -1;
        this.f9353o0 = null;
    }

    private void q() {
        b("scene", "1");
    }

    private void r() {
        LogUtil.e("Statistics-LightNaviStatItem", "endtStat battery after :" + this.A);
        if (this.C != null && com.baidu.navisdk.framework.a.c().a() != null) {
            try {
                com.baidu.navisdk.framework.a.c().a().unregisterReceiver(this.C);
                LogUtil.e("Statistics-LightNaviStatItem", "ipo stat startStat battery has unregistered :");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public static LightNaviStatItem s() {
        if (p0 == null) {
            synchronized (LightNaviStatItem.class) {
                try {
                    if (p0 == null) {
                        p0 = new LightNaviStatItem(com.baidu.navisdk.comapi.statistics.b.f());
                    }
                } finally {
                }
            }
        }
        return p0;
    }

    private long t() {
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

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        r();
        q();
        b("start_route", this.l + "");
        b("rou_dis", this.k + "");
        b("rou_time", this.j + "");
        long j = this.J / 1000;
        Long valueOf = Long.valueOf(j);
        b("real_time", valueOf + "");
        b("real_dis", this.n + "");
        LogUtil.e("Statistics-LightNaviStatItem", "NaviStatItem onevent beforeNavi = " + this.z + " afterNavi = " + this.A + " duration = " + valueOf + " mHasCharge = " + this.B);
        if (!this.B) {
            float f = this.z - this.A;
            if (j > 0 && f >= 0.0f) {
                b("bph", ((f / ((float) j)) * 3600.0f) + "");
            }
        }
        b("loc_time", this.q + "");
        b("lost_times", this.o + "");
        b("out_times", this.p + "");
        b("ps0", this.x + "");
        b("pss", j.b().a() + "");
        b("df", Double.valueOf((double) ((t() - this.y) / 1024)) + "");
        c.d().a();
        b("jph", c.d().b() + "");
        b("hasData", (this.s ? 1 : 0) + "");
        b("dest_dis", this.r + "");
        b("bt", (this.E / 1000) + "");
        b("entry", this.L + "");
        b("city", this.M + "");
        b("ipo", (this.J / 1000) + "");
        b("ipof", (this.H / 1000) + "");
        b("ipol", (this.I / 1000) + "");
        String str = this.w;
        if (str != null) {
            a("vid", str);
        }
        this.K = y.a(com.baidu.navisdk.framework.a.c().a());
        b("nt", this.K + "");
        if (this.f9353o0 != null) {
            b("ssid", this.f9353o0 + "");
        }
        if (this.U >= 0) {
            b("dd_still_sample_fail", this.Q + "");
            b("dd_driving_sample_fail", this.R + "");
            b("dd_train", this.S + "");
            b("dd_train_fail", this.T + "");
            b("dd_infer", this.U + "");
            b("dd_infer_fail", this.V + "");
            b("dd_infer_recall", this.W + "");
            b("dd_first_verify", this.X + "");
            b("dd_first_verify_fail", this.Y + "");
            b("dd_period_verify", this.Z + "");
            b("dd_period_verify_fail", this.a0 + "");
            b("dd_infer_stop_right", this.e0 + "");
            b("dd_infer_stop_all", this.f0 + "");
            b("dd_open_stop_all", this.g0 + "");
            if (this.j0 > 0) {
                b("dd_infer_stop_right_rate", this.j0 + "");
            }
            if (this.h0 > 0) {
                b("dd_infer_right_rate", this.h0 + "");
            }
        }
        if (this.b0 > 0) {
            b("dd_simple_infer", this.b0 + "");
            b("dd_simple_infer_fail", this.c0 + "");
            b("dd_simple_invalidate_model", this.d0 + "");
            if (this.k0 > 0) {
                b("dd_infer_simple_stop_right_rate", this.k0 + "");
            }
            if (this.i0 > 0) {
                b("dd_infer_simple_right_rate", this.i0 + "");
            }
        }
        if (this.l0 > 0) {
            b("dd_not_zero", this.l0 + "");
        }
        if (this.m0 > 0) {
            b("dd_turn_advance", this.m0 + "");
        }
        if (this.n0 > 0) {
            b("dd_check_yaw", this.n0 + "");
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-LightNaviStatItem", "onEvent->actParams: " + m());
        }
        super.b(i);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String c() {
        return "50003_Light";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50003";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public int e() {
        return 1;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-LightNaviStatItem";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public int i() {
        return 0;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void l() {
        super.l();
        this.j = 0L;
        this.k = 0L;
        this.y = 0L;
        this.m = false;
        this.n = 0L;
        this.o = 0;
        this.p = 0;
        this.q = -1L;
        this.r = 0L;
        this.t = 0L;
        this.s = false;
        this.u = 0L;
        this.v = 0L;
        this.z = 0.0f;
        this.A = 0.0f;
        this.D = null;
        this.C = null;
        this.B = false;
        this.x = 0;
        this.w = null;
        this.E = 0L;
        this.F.clear();
        this.G.clear();
        this.f9353o0 = null;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        this.f0 = -1;
        this.g0 = -1;
        this.N = false;
        this.O = System.currentTimeMillis();
        this.P = 0L;
    }

    public void n() {
        this.p++;
        d("out_times", this.p + "");
    }

    public void o() {
        if (!this.m) {
            this.m = true;
            SystemClock.elapsedRealtime();
            this.q = (SystemClock.elapsedRealtime() - i.b) / 1000;
            SystemClock.elapsedRealtime();
            SystemClock.elapsedRealtime();
            b("loc_time", this.q + "");
        }
    }

    public void p() {
        q();
        this.x = j.b().a();
        this.y = t();
        if (this.C == null) {
            this.C = new BroadcastReceiver() { // from class: com.baidu.navisdk.util.statistic.LightNaviStatItem.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        if (intent.getIntExtra("status", 1) == 2) {
                            if (!LightNaviStatItem.this.B) {
                                LightNaviStatItem.this.B = true;
                            }
                            LogUtil.e("Statistics-LightNaviStatItem", "startStat battery has charge  :" + LightNaviStatItem.this.B);
                        }
                        LightNaviStatItem lightNaviStatItem = LightNaviStatItem.this;
                        lightNaviStatItem.A = lightNaviStatItem.a(intent.getIntExtra("level", 0), intent.getIntExtra("scale", 100));
                    }
                }
            };
        }
        if (this.C != null && com.baidu.navisdk.framework.a.c().a() != null) {
            this.D = com.baidu.navisdk.framework.a.c().a().registerReceiver(this.C, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            LogUtil.e("Statistics-LightNaviStatItem", "ipo stat startStat battery has registered :");
            Intent intent = this.D;
            if (intent != null) {
                this.z = a(intent.getIntExtra("level", 0), this.D.getIntExtra("scale", 100));
            }
        }
        LogUtil.e("Statistics-LightNaviStatItem", "startStat battery before :" + this.z);
        this.E = 0L;
        if (com.baidu.navisdk.j.d()) {
            this.s = com.baidu.navisdk.module.base.c.a();
        }
        this.M = com.baidu.navisdk.module.base.b.a();
        b("city", this.M + "");
        b("ps0", this.x + "");
        b("hasData", (this.s ? 1 : 0) + "");
        a(false);
    }

    public void d(String str, String str2) {
        a(str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(int i, int i2) {
        if (i2 != 0) {
            return (i * 100) / i2;
        }
        return 100.0f;
    }

    public void a(String str, String str2, boolean z) {
        if (z) {
            a(str, str2);
        } else {
            b(str, str2);
        }
        super.a(false);
    }

    public void b(String str) {
        d("hp_mode", str);
    }
}
