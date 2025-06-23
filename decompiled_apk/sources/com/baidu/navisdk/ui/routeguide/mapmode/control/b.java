package com.baidu.navisdk.ui.routeguide.mapmode.control;

import android.os.Bundle;
import com.baidu.navisdk.framework.interfaces.pronavi.p;
import com.baidu.navisdk.module.pronavi.model.d;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.n;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;

/* loaded from: classes8.dex */
public class b implements p, com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private n f8694a = new n(this);

    private void f() {
        String b;
        if (!this.f8694a.m().isEmpty()) {
            d dVar = this.f8694a.m().get(0);
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("showArriveServiceAreaRemind-> isSubscribed: ");
                sb.append(dVar.s());
                sb.append(", RemainDist= ");
                sb.append(dVar.k());
                sb.append(", bean.getId()= ");
                sb.append(dVar.g());
                sb.append(", mAlreadyRemindAreaId= ");
                if (this.f8694a.b() == null) {
                    b = "null";
                } else {
                    b = this.f8694a.b();
                }
                sb.append(b);
                LogUtil.e("RGServiceAreaController", sb.toString());
            }
            if (dVar.s() && dVar.k() <= 2000) {
                if ((l0.c(this.f8694a.b()) || !this.f8694a.b().equals(dVar.g())) && com.baidu.navisdk.ui.routeguide.b.V().j() != null && com.baidu.navisdk.ui.routeguide.b.V().j().b().a(dVar)) {
                    this.f8694a.b(dVar.g());
                }
            }
        }
    }

    public void a(boolean z, Bundle bundle) {
        if (z) {
            if (a(bundle)) {
                a();
            }
        } else {
            this.f8694a.a(false, (Bundle) null);
            a();
        }
    }

    public n b() {
        return this.f8694a;
    }

    public boolean c() {
        return this.f8694a.s();
    }

    public void d() {
        LogUtil.e("RGServiceAreaController", "resetServiceAreaView->");
        a(false);
        x.b().T0();
        x.b().F(0);
    }

    public void e() {
        LogUtil.e("RGServiceAreaController", "resetServiceAreaViewAndModel->");
        this.f8694a.a();
        d();
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        this.f8694a.w();
    }

    public boolean a(Bundle bundle) {
        return this.f8694a.a(true, bundle);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.p
    public void a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGServiceAreaController", "notifyViews-> isServicePanelCanShow: " + c());
        }
        if (c()) {
            f();
            a(true);
            if (!this.f8694a.m().isEmpty()) {
                x.b().R4();
            }
        } else if (this.f8694a.m().isEmpty()) {
            e();
        } else {
            a(false);
            if (!t.s().i()) {
                x.b().T0();
            }
        }
        x.b().F(this.f8694a.n().size());
    }

    private void a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGServiceAreaController", "notifyServiceAreaViewDisplay-> isShow= " + z);
        }
        if (z) {
            x.b().A4();
            if (x.b().m0() != null) {
                x.b().m0().k();
                return;
            }
            return;
        }
        x.b().z1();
    }
}
