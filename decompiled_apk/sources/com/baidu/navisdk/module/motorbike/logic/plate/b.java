package com.baidu.navisdk.module.motorbike.logic.plate;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class b implements com.baidu.navisdk.module.motorbike.logic.plate.a {

    /* renamed from: a, reason: collision with root package name */
    private c f7196a;

    /* renamed from: com.baidu.navisdk.module.motorbike.logic.plate.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0243b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f7197a = new b();
    }

    public static com.baidu.navisdk.module.motorbike.logic.plate.a d() {
        return C0243b.f7197a;
    }

    private void e() {
        this.f7196a.setPlateInfo(com.baidu.navisdk.module.motorbike.preferences.a.u0().s());
        this.f7196a.c = com.baidu.navisdk.module.motorbike.preferences.a.u0().u();
        this.f7196a.b = com.baidu.navisdk.module.motorbike.preferences.a.u0().p();
        this.f7196a.f7198a = com.baidu.navisdk.module.motorbike.preferences.a.u0().t();
    }

    private void f() {
        com.baidu.navisdk.module.motorbike.preferences.a u0 = com.baidu.navisdk.module.motorbike.preferences.a.u0();
        String plate = this.f7196a.getPlate();
        c cVar = this.f7196a;
        u0.a(plate, cVar.c, cVar.b, cVar.f7198a);
    }

    private void g() {
        Bundle v = com.baidu.navisdk.framework.b.v();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorPlateManager", "syncPlateFromCarOwner: " + v);
        }
        if (v == null) {
            e();
            return;
        }
        c cVar = new c(v);
        String plate = this.f7196a.getPlate();
        if (!this.f7196a.equals(cVar)) {
            this.f7196a.a(cVar);
            f();
        }
        if (TextUtils.isEmpty(this.f7196a.getPlate())) {
            com.baidu.navisdk.module.motorbike.preferences.a.u0().m(false);
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().a(32, false);
            if (!TextUtils.isEmpty(plate)) {
                com.baidu.navisdk.module.motorbike.preferences.a.u0().l(0);
                return;
            }
            return;
        }
        if (!com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().h()) {
            com.baidu.navisdk.module.motorbike.preferences.a.u0().m(true);
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().a(32, true);
        }
    }

    @Override // com.baidu.navisdk.module.motorbike.logic.plate.a
    public c a() {
        g();
        return this.f7196a;
    }

    @Override // com.baidu.navisdk.module.motorbike.logic.plate.a
    public String b() {
        g();
        return this.f7196a.getPlate();
    }

    @Override // com.baidu.navisdk.module.motorbike.logic.plate.a
    public int c() {
        int i = this.f7196a.b;
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return -1;
    }

    private b() {
        this.f7196a = new c();
        e();
    }
}
