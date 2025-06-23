package com.baidu.navisdk.module.routepreference;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.e0;

/* loaded from: classes7.dex */
public class d extends com.baidu.navisdk.module.routepreference.a {
    private boolean d;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f7476a = new d();
    }

    public static d j() {
        return b.f7476a;
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int a() {
        return BNSettingManager.getLastRouteSearchMCarPrefer();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public com.baidu.navisdk.module.routepreference.b b(int i) {
        return com.baidu.navisdk.module.routeresult.logic.plate.a.b().b(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public void d(int i) {
        BNSettingManager.setLastRouteSearchMCarPrefer(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public String e() {
        return com.baidu.navisdk.h.a();
    }

    public void g(int i) {
        e0.a(com.baidu.navisdk.framework.a.c().a()).b("calc_preference", i);
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public boolean h() {
        if ((BNSettingManager.getLastRouteSearchMCarPrefer() & 32) != 0) {
            return true;
        }
        return false;
    }

    private d() {
        super("BNPreferenceControllerV2");
        this.d = false;
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public void a(boolean z) {
        if (z) {
            com.baidu.navisdk.framework.b.M();
            this.d = com.baidu.navisdk.framework.b.S();
        } else {
            this.d = false;
        }
    }

    public void b(boolean z) {
        BNSettingManager.setPlateLimitOpen(z);
        a(32, z);
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int d() {
        if (com.baidu.navisdk.framework.a.c().a() == null) {
            return 3;
        }
        return BNSettingManager.getPrefRoutPlanMode();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int b() {
        return e0.a(com.baidu.navisdk.framework.a.c().a()).a("calc_preference", 1);
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int a(String str) {
        if (com.baidu.navisdk.j.d()) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return this.d ? 1 : 0;
        }
        return BNSettingManager.getPowerTypeFromLocal();
    }
}
