package com.baidu.navisdk.b4nav.func.calcroute.listener;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.f;
import com.baidu.navisdk.comapi.routeplan.v2.d;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.statistic.t;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes7.dex */
public class c extends com.baidu.navisdk.comapi.routeplan.v2.a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.b4nav.func.calcroute.listener.a f6575a;

    @NonNull
    private final com.baidu.navisdk.b4nav.b b;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private volatile boolean e = false;
    private volatile boolean f = true;
    private final com.baidu.navisdk.util.worker.lite.b g = new a(this, "ResultPersistentRPListener::SimSecondPieceRunnable");
    private final com.baidu.navisdk.util.worker.lite.b h = new b("ResultPersistentRPListener::weatherUpdateRunnable");

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.lite.b {
        public a(c cVar, String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            f.c(null, 18);
            BNRoutePlaner.getInstance().a((d) null, 18, -1);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.lite.b {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            com.baidu.navisdk.b4nav.func.calcroute.listener.a aVar = c.this.f6575a;
            g gVar = g.B4NAV;
            if (gVar.d()) {
                gVar.e(com.baidu.navisdk.util.worker.g.TAG, "weatherUpdateRunnable --> isParseFirstCars = " + c.this.e + ", isReceiveWeatherMsg = " + c.this.c + ", isWeatherUpdateSuccess = " + c.this.d + ", listener = " + aVar);
            }
            if (aVar != null && c.this.e && c.this.c) {
                if (!c.this.d) {
                    aVar.a(1053);
                } else {
                    aVar.a(1052);
                    c.this.b.b();
                    throw null;
                }
            }
        }
    }

    public c(@NonNull com.baidu.navisdk.b4nav.b bVar) {
        this.b = bVar;
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public String getName() {
        return "ResultPersistentRPListener";
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public boolean isPersist() {
        return true;
    }

    @Override // com.baidu.navisdk.comapi.routeplan.v2.a
    public void onRoutePlan(int i, int i2, d dVar, Bundle bundle) {
        g gVar = g.B4NAV;
        if (gVar.d()) {
            gVar.e("ResultPersistentRPListener", "route result page: onRoutePlan --> \n        resultType = " + i + "\n        subType = " + i2 + "\n        session = " + dVar + "\n        extraData = " + bundle);
        }
        if (dVar != null && dVar.e() != null) {
            int i3 = dVar.e().f;
            int i4 = dVar.e().h;
            this.b.e();
            throw null;
        }
        com.baidu.navisdk.b4nav.func.calcroute.listener.a aVar = this.f6575a;
        if (aVar == null) {
            if (gVar.d()) {
                gVar.e("ResultPersistentRPListener", "onRoutePlan --> listener is null!!!");
                return;
            }
            return;
        }
        if (i == 1) {
            if (gVar.d()) {
                gVar.e("ResultPersistentRPListener", "onRoutePlan --> RP_BEFORE_START!!!");
            }
            this.e = false;
            this.c = false;
            this.d = false;
            this.f = true;
            com.baidu.navisdk.util.worker.lite.a.a(this.g);
            com.baidu.navisdk.util.worker.lite.a.a(this.h);
            this.b.a(com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.b.CALC_ROUTE_LOADING);
            throw null;
        }
        if (i == 2) {
            if (gVar.d()) {
                gVar.e("ResultPersistentRPListener", "onRoutePlan --> RP_NORMAL_SUCCESS!!!");
                gVar.e("ResultPersistentRPListener", "onRoutePlan --> entry = 4, intent = 0");
            }
            this.e = false;
            this.c = false;
            this.d = false;
            com.baidu.navisdk.util.worker.lite.a.a(this.h);
            t.u().G = true;
            this.b.a(com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.b.CALC_ROUTE_SUCCESS);
            throw null;
        }
        if (i == 3 || i == 4) {
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("onRoutePlan --> ");
                sb.append(i == 3 ? "RP_NORMAL_GENERAL_FAILED" : "RP_NORMAL_ENGINE_FAILED");
                sb.append("!!!");
                gVar.e("ResultPersistentRPListener", sb.toString());
                gVar.e("ResultPersistentRPListener", "onRoutePlan --> failType = " + i2);
            }
            com.baidu.navisdk.util.worker.lite.a.a(this.h);
            this.b.a(com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.b.CALC_ROUTE_FAIL);
            throw null;
        }
        if (i == 5) {
            aVar.a(1001);
            return;
        }
        if (i == 18) {
            this.b.b();
            throw null;
        }
        if (i == 19) {
            this.b.b("build_route_state", com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.a.BUILD_ROUTE_FAILED);
            aVar.a(1005, bundle);
            return;
        }
        if (i == 49) {
            aVar.a(1020, bundle);
            return;
        }
        if (i == 145) {
            if (gVar.d()) {
                gVar.e("ResultPersistentRPListener", "onRoutePlan --> SYNC_OPERATION --> subType = " + i2);
            }
            if (i2 != 3) {
                return;
            }
            this.b.m();
            throw null;
        }
        if (i == 67) {
            this.e = false;
            this.c = false;
            this.d = false;
            com.baidu.navisdk.util.worker.lite.a.a(this.h);
            this.b.a(com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.b.CALC_ROUTE_SUCCESS);
            throw null;
        }
        if (i == 68) {
            this.b.a(com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.b.CALC_ROUTE_FAIL);
            throw null;
        }
        if (i == 177) {
            if (gVar.d()) {
                gVar.e("ResultPersistentRPListener", "onRoutePlan --> isFirstReceiveWeatherMsg = " + this.f);
            }
            this.c = true;
            this.d = true;
            a();
            return;
        }
        if (i == 178) {
            this.c = true;
            this.d = false;
            a();
            return;
        }
        if (i == 4103) {
            aVar.a(4007, bundle);
            this.e = true;
            a();
            return;
        }
        if (i != 4104) {
            switch (i) {
                case 4097:
                    this.b.c(true);
                    throw null;
                case 4098:
                    this.b.a(com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.b.CALC_ROUTE_FAIL);
                    throw null;
                case 4099:
                    this.b.b();
                    throw null;
                case 4100:
                    aVar.a(4004, bundle);
                    return;
                default:
                    switch (i) {
                        case 4107:
                            aVar.a(4011, bundle);
                            return;
                        case 4108:
                            this.b.a(com.baidu.navisdk.module.routeresultbase.logic.calcroute.model.b.CALC_ROUTE_FAIL);
                            throw null;
                        case 4109:
                            aVar.a(ErrorCode.AD_DATA_NOT_READY, bundle);
                            return;
                        case 4110:
                            aVar.a(ErrorCode.AD_REPLAY, bundle);
                            return;
                        default:
                            return;
                    }
            }
        }
        aVar.a(4008, bundle);
    }

    public void a(com.baidu.navisdk.b4nav.func.calcroute.listener.a aVar) {
        this.f6575a = aVar;
    }

    private void a() {
        g gVar = g.B4NAV;
        if (gVar.d()) {
            gVar.e("ResultPersistentRPListener", "tryToSendWeatherUpdateMsg --> isParseFirstCars = " + this.e + ", isReceiveWeatherMsg = " + this.c + ", isWeatherUpdateSuccess = " + this.d);
        }
        com.baidu.navisdk.util.worker.lite.a.a(this.h);
        com.baidu.navisdk.util.worker.lite.a.a(this.h, 10002, 1000L);
    }
}
