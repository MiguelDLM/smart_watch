package com.baidu.navisdk.module.trucknavi.logic.calcroute;

import android.text.TextUtils;
import com.baidu.navisdk.module.trucknavi.logic.plate.c;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.module.routepreference.a {

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7578a = new a();
    }

    public static a j() {
        return b.f7578a;
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int a() {
        return com.baidu.navisdk.module.trucknavi.preferences.a.r0().c();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public com.baidu.navisdk.module.routepreference.b b(int i) {
        return c.g().a();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public void d(int i) {
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().c(i);
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public String e() {
        return c.g().b();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public boolean h() {
        if ((com.baidu.navisdk.module.trucknavi.preferences.a.r0().c() & 32) != 0) {
            return true;
        }
        return false;
    }

    private a() {
        super("TruckCalcRoutePreferController");
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return c.g().c();
    }

    public void b(boolean z) {
        a(32, z);
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int d() {
        return com.baidu.navisdk.module.trucknavi.preferences.a.r0().w();
    }

    @Override // com.baidu.navisdk.module.routepreference.a
    public int b() {
        return com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(1);
    }
}
