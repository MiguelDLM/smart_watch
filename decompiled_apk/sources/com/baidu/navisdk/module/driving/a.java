package com.baidu.navisdk.module.driving;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.p0;
import com.garmin.fit.xOxOoo;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.model.datastruct.a f7149a = new com.baidu.navisdk.model.datastruct.a();
    private com.baidu.navisdk.listeners.a b;
    private p0 c;
    private p0.b d;

    /* renamed from: com.baidu.navisdk.module.driving.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0239a implements p0.b {
        public C0239a() {
        }

        @Override // com.baidu.navisdk.util.common.p0.b
        public void onTick(int i) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNDrivingDistanceTimeSe", "onTick: " + i);
            }
            a.this.e();
            if (a.this.b != null) {
                a.this.b.a(a.this.f7149a);
            }
        }
    }

    private void d() {
        if (this.d == null) {
            this.d = new C0239a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Bundle bundle = new Bundle();
        boolean routeDrivingInfo = BNRouteGuider.getInstance().getRouteDrivingInfo(bundle);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNDrivingDistanceTimeSe", "getRouteDrivingInfo: " + routeDrivingInfo + "," + bundle);
        }
        if (bundle.containsKey(xOxOoo.f15470o00)) {
            long j = bundle.getLong(xOxOoo.f15470o00, this.f7149a.f6902a);
            if (j >= 0) {
                this.f7149a.f6902a = (int) j;
            }
        }
        if (bundle.containsKey("time")) {
            long j2 = bundle.getLong("time", this.f7149a.b);
            if (j2 >= 0) {
                this.f7149a.b = j2;
            }
        }
    }

    public void a(long j) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNDrivingDistanceTimeSe", "startLoopUpdate: " + j);
        }
        c();
        if (this.c == null) {
            this.c = new p0("BNDriveDistance-UT");
        }
        d();
        this.c.a(j);
        this.c.a(this.d);
        this.c.a(Integer.MAX_VALUE);
    }

    public com.baidu.navisdk.model.datastruct.a b() {
        e();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNDrivingDistanceTimeSe", "getLatestData: " + this.f7149a);
        }
        return this.f7149a;
    }

    public void c() {
        p0 p0Var = this.c;
        if (p0Var != null) {
            p0Var.a();
            this.c = null;
        }
    }

    public void b(com.baidu.navisdk.listeners.a aVar) {
        if (aVar == this.b) {
            this.b = null;
        }
    }

    public void a(com.baidu.navisdk.listeners.a aVar) {
        this.b = aVar;
    }

    public void a() {
        c();
        this.b = null;
        this.d = null;
    }
}
