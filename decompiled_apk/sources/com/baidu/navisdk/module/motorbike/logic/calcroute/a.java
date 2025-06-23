package com.baidu.navisdk.module.motorbike.logic.calcroute;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.module.routepreference.a {

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7195a = new a();
    }

    public static a j() {
        return b.f7195a;
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int a() {
        return com.baidu.navisdk.module.motorbike.preferences.a.u0().c();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public com.baidu.navisdk.module.routepreference.b b(int i) {
        return com.baidu.navisdk.module.motorbike.logic.plate.b.d().a();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public void d(int i) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().c(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public String e() {
        return com.baidu.navisdk.module.motorbike.logic.plate.b.d().b();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public boolean h() {
        if ((com.baidu.navisdk.module.motorbike.preferences.a.u0().c() & 32) != 0) {
            return true;
        }
        return false;
    }

    private a() {
        super("MotorCalcRoutePreferController");
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return com.baidu.navisdk.module.motorbike.logic.plate.b.d().c();
    }

    public void b(boolean z) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().m(z);
        a(32, z);
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int d() {
        return com.baidu.navisdk.module.motorbike.preferences.a.u0().A();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int b() {
        return com.baidu.navisdk.module.motorbike.preferences.a.u0().a(1);
    }
}
