package com.baidu.navisdk.comapi.trajectory;

import android.os.Bundle;
import com.baidu.mapframework.location.LocationManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;

/* loaded from: classes7.dex */
public class g extends com.baidu.navisdk.comapi.trajectory.a {
    private final d h = new d();

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f6747a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, j jVar) {
            super(str, str2);
            this.f6747a = jVar;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            try {
                int b = g.this.b(this.f6747a);
                com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
                r.a("8.2.4", "" + this.f6747a.a(), "" + b);
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
                if (!gVar.d()) {
                    return null;
                }
                gVar.e(g.this.b(), "endRecordCarNavi,ret:" + b);
                return null;
            } catch (Throwable th) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.TRAJECTORY;
                if (!gVar2.c()) {
                    return null;
                }
                gVar2.c(g.this.b(), "endRecordCarNavi,e:" + th);
                return null;
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.trajectory.a
    public String b() {
        return "BNTrajectoryRecordOutNaviLogicController";
    }

    public d e() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(j jVar) {
        String str;
        String str2;
        int i;
        if (!this.g) {
            return -13;
        }
        if (!this.d) {
            return -10;
        }
        if (this.e) {
            return -11;
        }
        if (this.c != null) {
            LocationManager.getInstance().removeLocationChangeLister(this.c);
            this.c = null;
        }
        com.baidu.navisdk.model.modelfactory.f h = BNRoutePlaner.getInstance().h();
        RoutePlanNode g = h != null ? h.g() : null;
        if (BNRoutePlaner.getInstance().d() == 20) {
            str = "1";
        } else if (BNRoutePlaner.getInstance().d() == 21) {
            str = "2";
        } else {
            str = (g == null || (str2 = g.mUID) == null || str2.length() <= 0) ? "" : g.mUID;
        }
        try {
            i = JNITrajectoryControl.sInstance.endRecordCarNavi(g != null ? g.mName : "未知", str, com.baidu.navisdk.module.pronavi.model.h.c, new Bundle());
        } catch (Exception unused) {
            i = -1;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
        if (gVar.d()) {
            gVar.e(b(), "endRecordCarNavi,engine-ret" + i);
        }
        this.g = false;
        this.h.c(false);
        this.f6741a = i;
        return i;
    }

    public void a(j jVar) {
        a("", jVar);
    }

    public void a(String str, j jVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.TRAJECTORY;
        if (gVar.d()) {
            gVar.e(b(), "endRecordCarNavi,source:" + str + ",trajectoryType:" + jVar);
        }
        com.baidu.navisdk.util.worker.c.a().b(new a("endRecord-out-navi", null, jVar), new com.baidu.navisdk.util.worker.e(1, 0));
    }
}
