package com.baidu.navisdk.cruise.prefer;

import com.baidu.navisdk.util.common.e0;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private e0 f6767a;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f6768a = new a();
    }

    public static a g() {
        return b.f6768a;
    }

    public int a() {
        e0 e0Var = this.f6767a;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a("cruise_map_mode", 1);
    }

    public int b() {
        e0 e0Var = this.f6767a;
        if (e0Var == null) {
            return 18;
        }
        return e0Var.a("sp_cruise_map_user_scale_level", 18);
    }

    public boolean c() {
        e0 e0Var = this.f6767a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("cruise_electron_eye", true);
    }

    public boolean d() {
        e0 e0Var = this.f6767a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("cruise_play_route_traffic", true);
    }

    public boolean e() {
        e0 e0Var = this.f6767a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("cruise_play_safety_note", true);
    }

    public boolean f() {
        e0 e0Var = this.f6767a;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("cruise_route_traffic", true);
    }

    private a() {
        this.f6767a = e0.a(com.baidu.navisdk.framework.a.c().a());
    }

    public void a(int i) {
        e0 e0Var = this.f6767a;
        if (e0Var != null) {
            e0Var.b("sp_cruise_map_user_scale_level", i);
        }
    }
}
