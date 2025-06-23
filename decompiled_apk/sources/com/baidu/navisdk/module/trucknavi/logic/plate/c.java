package com.baidu.navisdk.module.trucknavi.logic.plate;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;

/* loaded from: classes7.dex */
public final class c implements com.baidu.navisdk.module.trucknavi.logic.plate.a {
    static String b;

    /* renamed from: a, reason: collision with root package name */
    private d f7580a;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f7581a = new c();
    }

    public static com.baidu.navisdk.module.trucknavi.logic.plate.a g() {
        return b.f7581a;
    }

    private void h() {
        String str = b;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("TruckPlateManager", "getPlateFromLocal-> " + str);
        }
        if (!l0.c(str)) {
            this.f7580a.a(str);
        }
    }

    private void i() {
        String vehicleInfoJsonStr = this.f7580a.getVehicleInfoJsonStr();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("TruckPlateManager", "setPlateToLocal-> " + vehicleInfoJsonStr);
        }
    }

    private void j() {
        String bundle;
        Bundle D = com.baidu.navisdk.framework.b.D();
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("syncPlateFromCarOwner-> bundle：");
            if (D == null) {
                bundle = null;
            } else {
                bundle = D.toString();
            }
            sb.append(bundle);
            LogUtil.e("TruckPlateManager", sb.toString());
        }
        if (D == null) {
            h();
            return;
        }
        d dVar = new d(D);
        if (!this.f7580a.equals(dVar)) {
            this.f7580a.a(dVar);
            i();
        }
        if (TextUtils.isEmpty(this.f7580a.getPlate())) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("TruckPlateManager", "syncPlateFromCarOwner-> plate == null!");
            }
        } else {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().t(0);
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().k(true);
            com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().a(32, true);
        }
    }

    public void a(String str) {
        if (l0.c(str)) {
            return;
        }
        b = str;
        this.f7580a.a(str);
    }

    @Override // com.baidu.navisdk.module.trucknavi.logic.plate.a
    public String b() {
        j();
        return this.f7580a.getPlate();
    }

    @Override // com.baidu.navisdk.module.trucknavi.logic.plate.a
    public int c() {
        int i = this.f7580a.c;
        if (i == 3) {
            return 1;
        }
        if (i == 1) {
            return 0;
        }
        return -1;
    }

    @Override // com.baidu.navisdk.module.trucknavi.logic.plate.a
    public int d() {
        return com.baidu.navisdk.module.trucknavi.preferences.a.r0().D();
    }

    @Override // com.baidu.navisdk.module.trucknavi.logic.plate.a
    public boolean e() {
        if ((com.baidu.navisdk.module.trucknavi.preferences.a.r0().D() & 1) != 1) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.trucknavi.logic.plate.a
    public boolean f() {
        if ((com.baidu.navisdk.module.trucknavi.preferences.a.r0().D() & 2) != 2) {
            return true;
        }
        return false;
    }

    private c() {
        d dVar = new d();
        this.f7580a = dVar;
        dVar.a(com.baidu.navisdk.module.trucknavi.preferences.a.r0().D());
    }

    @Override // com.baidu.navisdk.module.trucknavi.logic.plate.a
    public void b(boolean z) {
        int D = com.baidu.navisdk.module.trucknavi.preferences.a.r0().D();
        a(z ? D & 2 : D | 1);
    }

    @Override // com.baidu.navisdk.module.trucknavi.logic.plate.a
    public d a() {
        j();
        return this.f7580a;
    }

    public void a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("TruckPlateManager", "setFuncOn-> value=" + i);
        }
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().s(i);
        this.f7580a.a(i);
    }

    @Override // com.baidu.navisdk.module.trucknavi.logic.plate.a
    public void a(boolean z) {
        int D = com.baidu.navisdk.module.trucknavi.preferences.a.r0().D();
        a(z ? D & 1 : D | 2);
    }
}
