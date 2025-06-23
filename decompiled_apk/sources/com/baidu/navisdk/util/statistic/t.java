package com.baidu.navisdk.util.statistic;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.i0;
import com.baidu.navisdk.util.common.l0;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes8.dex */
public class t extends com.baidu.navisdk.comapi.statistics.f implements com.baidu.navisdk.module.statistics.b {
    private static t S;
    public long A;
    public int B;
    public int C;
    public int D;
    public int E;
    private String F;
    public boolean G;
    public boolean H;
    private int I;
    private boolean J;
    public int K;
    public int L;
    public String M;
    private String N;
    private int O;
    public int P;
    public boolean Q;
    private final Bundle R;
    public String j;
    int k;
    public int l;
    public int m;
    public int n;
    private Long o;
    private Long p;
    public Long q;
    public Long r;
    public Long s;
    public long t;
    public long u;
    private Long v;
    private Long w;
    public int x;
    public int y;
    public long z;

    public t(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
        this.j = "1";
        this.k = 4;
        this.l = 0;
        this.m = 0;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.s = 0L;
        this.v = 0L;
        this.w = 0L;
        this.x = 0;
        this.D = -1;
        this.F = null;
        this.I = -1;
        this.J = true;
        this.K = 0;
        this.L = 0;
        this.M = null;
        this.N = null;
        this.O = 0;
        this.P = 0;
        this.Q = false;
        this.R = new Bundle();
    }

    private boolean s() {
        int i = 0;
        if (q()) {
            LogUtil.e("Statistics-RoutePlanStatItem", "addEventParams() not stat. return for not event!!!");
            return false;
        }
        if (r()) {
            LogUtil.e("Statistics-RoutePlanStatItem", "addEventParams() for preCalc");
        }
        if (l0.c(this.N)) {
            this.N = BNRoutePlaner.getInstance().a("", "");
        }
        b("ssid", this.N);
        t();
        b("cal_type", this.j);
        String str = this.j;
        if (str == null) {
            str = "null";
        }
        d("cal_type", str);
        Long v = v();
        b("re_time", Long.toString(v.longValue()));
        a("re_time", v.longValue());
        if (this.n <= 0) {
            this.n = BNRoutePlaner.getInstance().t();
        }
        b("rou_ret", Integer.toString(this.n));
        a("rou_ret", this.n);
        b("start_from", Integer.toString(this.B));
        a("start_from", this.B);
        b("rou_entry", Integer.toString(this.l));
        a("rou_entry", this.l);
        b("new_comer", Integer.toString(this.O));
        a("new_comer", this.O);
        if (com.baidu.navisdk.framework.b.r() == this.m) {
            b("rou_defsort", "1");
            a("rou_defsort", 1);
        } else {
            b("rou_defsort", "2");
            a("rou_defsort", 2);
        }
        if (!this.J) {
            b("rou_dis", Long.toString(this.u));
            b("rou_time", Long.toString(this.t));
            LogUtil.e("Statistics-RoutePlanStatItem", "do nothing come from in navi or map route");
        } else {
            b("sel_times", Integer.toString(this.E));
            a("sel_times", this.E);
            if (this.H) {
                i = this.y + 1;
            }
            b("sel_pos", i + "/" + this.n);
            d("sel_pos", i + "/" + this.n);
            b("switch_time", Long.toString(this.A - this.z));
            a("switch_time", this.A - this.z);
            b("switch_time", Long.toString(this.A - this.z));
            b("rou_dis", Long.toString(this.u));
            b("rou_time", Long.toString(this.t));
        }
        b("rou_way", String.valueOf(this.k));
        a("rou_way", this.k);
        b("loc_type", Integer.toString(this.C));
        a("loc_type", this.C);
        b("has_s", Integer.toString(this.D));
        b("os_src", this.F);
        d("os_src", this.F);
        long longValue = this.w.longValue() - this.v.longValue();
        b("entotal_time", Long.toString(longValue));
        a("entotal_time", longValue);
        b("en_time", Long.toString(this.r.longValue()));
        a("en_time", this.r.longValue());
        b("ennt_time", Long.toString(this.q.longValue()));
        d("ennt_time", Long.toString(this.q.longValue()));
        b("ser_time", Long.toString(this.s.longValue()));
        a("ser_time", this.s.longValue());
        b("nt", Integer.toString(this.x));
        a("nt", this.x);
        b("carno_type", Integer.toString(this.K));
        a("carno_type", this.K);
        w();
        b("sub_prefer", Integer.toString(this.L));
        a("sub_prefer", this.L);
        if (!TextUtils.isEmpty(this.M)) {
            b("car_number", this.M);
            d("car_number", this.M);
        }
        b("route_charge_prefer", Integer.toString(this.P));
        a("route_charge_prefer", this.P);
        return true;
    }

    private void t() {
        if (this.k == 7) {
            this.F = "1";
        } else {
            this.F = "0";
        }
    }

    public static t u() {
        if (S == null) {
            synchronized (t.class) {
                try {
                    if (S == null) {
                        S = new t(com.baidu.navisdk.comapi.statistics.b.f());
                    }
                } finally {
                }
            }
        }
        return S;
    }

    private Long v() {
        if (this.o.longValue() == 0 || this.p.longValue() <= 0) {
            return -1L;
        }
        long longValue = this.o.longValue() - this.p.longValue();
        Long valueOf = Long.valueOf(longValue);
        if (longValue < 0) {
            return -1L;
        }
        return valueOf;
    }

    private void w() {
        b("rou_tag", Integer.toString(this.m));
        try {
            a("rou_tag", this.m);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("statRoutePlanTag Exception :", e);
            }
        }
    }

    public void a(Long l) {
        if (this.w.longValue() == 0) {
            this.w = l;
        }
    }

    public void b(Long l) {
        this.v = l;
    }

    public void c(String str) {
        this.N = str;
        if (!TextUtils.isEmpty(str)) {
            b("ssid", str);
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50002";
    }

    public void e(int i) {
        if (s()) {
            super.k();
            com.baidu.navisdk.util.statistic.datacheck.a.a().a(this);
            l();
        }
    }

    public void f(int i) {
        this.k = i;
    }

    public void g(int i) {
        synchronized (this) {
            int i2 = this.k;
            if (i2 != 31 && i2 != 42) {
                this.I = i;
                b("rou_ret", HelpFormatter.DEFAULT_OPT_PREFIX + this.I);
                a("rou_ret", -this.I);
                i0.a().a(-this.I);
                w();
                String str = this.j;
                if (str == null) {
                    str = "null";
                }
                b("cal_type", str);
                if (i < 5000) {
                    Long v = v();
                    b("re_time", Long.toString(v.longValue()));
                    a("re_time", v.longValue());
                }
                b("rou_way", String.valueOf(this.k));
                a("rou_way", this.k);
                b("rou_entry", Integer.toString(this.l));
                a("rou_entry", this.l);
                b("has_s", Integer.toString(this.D));
                b("nt", Integer.toString(this.x));
                a("nt", this.x);
                super.k();
                com.baidu.navisdk.util.statistic.datacheck.a.a().a(this);
                l();
                return;
            }
            l();
        }
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-RoutePlanStatItem";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void l() {
        super.l();
        this.N = null;
        this.j = "1";
        this.E = 0;
        this.y = 0;
        this.o = 0L;
        this.t = 0L;
        this.u = 0L;
        this.H = false;
        this.n = 0;
        this.A = 0L;
        this.z = 0L;
        this.k = 3;
        this.C = 0;
        this.J = true;
        this.D = -1;
        this.B = -1;
        this.l = -1;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.s = 0L;
        this.v = 0L;
        this.w = 0L;
        this.x = 0;
        this.L = 0;
        this.M = null;
        this.Q = false;
        this.O = 0;
        this.P = 0;
        synchronized (this) {
            this.I = -1;
        }
        try {
            this.R.clear();
        } catch (Exception unused) {
        }
        LogUtil.e("Statistics-RoutePlanStatItem", "stat test route plan response time onCreateView");
    }

    public void n() {
        if (s()) {
            a(true);
        }
    }

    public String o() {
        return this.j;
    }

    public int p() {
        return this.k;
    }

    public boolean q() {
        if (this.v.longValue() == 0) {
            return true;
        }
        return false;
    }

    public boolean r() {
        int i = this.k;
        if (i != 31 && i != 42) {
            return false;
        }
        return true;
    }

    public void b(boolean z) {
        this.J = z;
    }

    public boolean d(int i) {
        switch (i) {
            case 2:
            case 5:
            case 15:
            case 22:
            case 26:
            case 28:
            case 32:
            case 35:
            case 37:
            case 39:
            case 102:
                return true;
            default:
                return false;
        }
    }

    public void h(int i) {
        this.O = i;
    }

    private void a(String str, int i) {
        try {
            Bundle bundle = this.R;
            if (bundle != null) {
                bundle.putInt(str, i);
            }
        } catch (Exception unused) {
        }
    }

    private void d(String str, String str2) {
        try {
            Bundle bundle = this.R;
            if (bundle != null) {
                bundle.putString(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public void b(String str) {
        this.j = str;
    }

    private void a(String str, long j) {
        try {
            Bundle bundle = this.R;
            if (bundle != null) {
                bundle.putLong(str, j);
            }
        } catch (Exception unused) {
        }
    }

    public void a(long j, long j2) {
        this.t = j;
        this.u = j2;
    }
}
