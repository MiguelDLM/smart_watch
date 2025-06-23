package com.baidu.navisdk.module.abtest.model;

import XIXIX.OOXIXo;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.mapframework.location.LocationChangeListener;
import com.baidu.mapframework.location.LocationManager;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.n;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.common.s0;

/* loaded from: classes7.dex */
public class k extends j {
    private int p;
    private double q;
    private boolean r;
    private n.b s;
    private volatile boolean t;
    private RoutePlanNode u;

    public k(com.baidu.navisdk.module.statistics.abtest.a aVar) {
        super(aVar);
        this.p = 0;
        this.q = OOXIXo.f3760XO;
        this.r = false;
        this.t = false;
    }

    private void A() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("StatisticsABVdrData", "resetHandler: " + this.s);
        }
        n.d().a(602);
        n.d().b(this.s);
        this.s = null;
    }

    private void u() {
        String str;
        if (!this.r && this.q > 1000.0d) {
            this.r = true;
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            if (s0.b(a2)) {
                str = "1";
            } else {
                str = "0";
            }
            r.a("3.14", str, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        z();
        double y = y();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("StatisticsABVdrData", "calCompletionRate totalDistanceDriving: " + this.q + ", distToDestLine:" + y + ", " + hashCode());
        }
        u();
        double d = this.q;
        if (d < OOXIXo.f3760XO) {
            d("nav_ctn_rt", "0");
            return;
        }
        if (y < OOXIXo.f3760XO) {
            return;
        }
        double d2 = d + y;
        if (d2 <= OOXIXo.f3760XO) {
            return;
        }
        int round = (int) Math.round((d / d2) * 100.0d);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("StatisticsABVdrData", "calCompletionRate totalDistanceDriving: " + this.q + ", distToDestLine:" + y + ", totalDistance: " + d2 + ",rate: " + round + ",isDestArrived: " + this.t);
        }
        if (this.t && round > 90) {
            round = 100;
        }
        d("nav_ctn_rt", Integer.toString(round));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        long elapsedRealtime = (SystemClock.elapsedRealtime() - com.baidu.navisdk.util.statistic.i.f9373a) / 1000;
        if (elapsedRealtime > 0) {
            d("na_dtn", Long.toString(elapsedRealtime));
        }
    }

    public static k x() {
        k kVar = (k) com.baidu.navisdk.framework.interfaces.c.p().a().g(4);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("StatisticsABVdrData", "getInstance: " + kVar.hashCode());
        }
        return kVar;
    }

    private double y() {
        RoutePlanNode routePlanNode = this.u;
        if (routePlanNode == null) {
            return -1.0d;
        }
        Bundle c = o.c(routePlanNode.getLongitudeE6(), this.u.getLatitudeE6());
        int i = c.getInt("MCx");
        int i2 = c.getInt("MCy");
        if (LogUtil.LOGGABLE) {
            LogUtil.e("StatisticsABVdrData", "getResidualLinearDistance(), bundle = " + c);
        }
        if (i == 0 && i2 == 0) {
            return -1.0d;
        }
        return o.a(LocationManager.getInstance().getCurLocation((LocationChangeListener.CoordType) null).longitude, LocationManager.getInstance().getCurLocation((LocationChangeListener.CoordType) null).latitude, i, i2);
    }

    private void z() {
        if (!l0.c(JNITrajectoryControl.sInstance.getCurrentUUID())) {
            this.q = JNITrajectoryControl.sInstance.getTrajectoryLength(r0);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("StatisticsABVdrData", "getTotalDistance: " + this.q);
        }
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public void b(Bundle bundle) {
    }

    public void c(boolean z) {
        String str;
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        d("vdr_occurs_nav", str);
    }

    public void d(int i) {
        if (com.baidu.navisdk.j.d()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("StatisticsABVdrData", "init: " + hashCode());
            }
            this.t = false;
            this.p = 0;
            this.q = OOXIXo.f3760XO;
            this.r = false;
            a(this.j.e(4));
            A();
            e(false);
            c(false);
            d(false);
            b(false);
            this.s = new a();
            n.d().a(this.s);
            n.d().a(602, 0, 0, null, 60000L);
        }
    }

    public void e(boolean z) {
        String str;
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        d("is_2_vdr", str);
    }

    public void f(boolean z) {
        String str;
        this.t = !z;
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        d("nul_et", str);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "StatisticsABVdrData";
    }

    @Override // com.baidu.navisdk.module.abtest.model.j
    public int n() {
        return 4;
    }

    public void s() {
        int i = this.p + 1;
        this.p = i;
        d("yaw_cnt", Integer.toString(i));
    }

    public void t() {
        f(true);
    }

    public void a(RoutePlanNode routePlanNode) {
        this.u = routePlanNode;
    }

    public void b(boolean z) {
        d("for_vdr_abtest", z ? "1" : "0");
    }

    @Override // com.baidu.navisdk.module.abtest.model.j, com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        if (com.baidu.navisdk.j.d()) {
            A();
            w();
            v();
            d("yaw_cnt", Integer.toString(this.p));
            super.b(i);
            this.p = 0;
            this.q = OOXIXo.f3760XO;
        }
    }

    /* loaded from: classes7.dex */
    public class a extends n.b {
        public a() {
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public void a(Message message) {
            if (message.what != 602) {
                return;
            }
            n.d().a(602);
            k.this.w();
            k.this.v();
            n.d().a(602, 0, 0, null, 10000L);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("StatisticsABVdrData", "vdr abtest execute: " + hashCode());
            }
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public String b() {
            return "StatisticsABVdrData";
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public void a() {
            a(602);
        }
    }

    public void d(boolean z) {
        d("vdr_occurs_startpt", z ? "1" : "0");
    }
}
