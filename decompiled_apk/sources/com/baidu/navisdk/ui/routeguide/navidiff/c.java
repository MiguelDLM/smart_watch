package com.baidu.navisdk.ui.routeguide.navidiff;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.navisdk.ui.routeguide.toolbox.d;
import com.baidu.navisdk.ui.routeguide.toolbox.f;
import com.baidu.navisdk.ui.routeguide.widget.g;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public final class c implements com.baidu.navisdk.module.pronavi.abs.b {
    private int b = 1;

    /* renamed from: a, reason: collision with root package name */
    private b f9078a = f(1);

    private String g(int i) {
        return i == 2 ? "motor" : i == 1 ? "car" : i == 3 ? "truck" : i == 4 ? "newneg" : "unknown";
    }

    public g a(Activity activity, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, g gVar) {
        if (gVar != null && gVar.z0() == this.b) {
            return gVar;
        }
        if (gVar != null) {
            gVar.i();
        }
        return this.f9078a.a(activity, viewGroup, aVar);
    }

    public boolean b(int i) {
        return this.b == i;
    }

    public String c() {
        return com.baidu.navisdk.module.routepreference.c.c(this.b);
    }

    public int d() {
        return com.baidu.navisdk.module.routepreference.c.e(this.b);
    }

    public void e(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorBNDifferentController", "updateVehicle vehicle: " + g(i) + ", current vehicle:" + g(this.b));
        }
        if (i != this.b) {
            this.b = i;
            this.f9078a = f(i);
        }
    }

    public boolean f() {
        return this.b == 2;
    }

    public void h() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorBNDifferentController", "reset mVehicle:" + this.b);
        }
        if (this.b != 1) {
            this.b = 1;
            this.f9078a = f(1);
        }
    }

    public void i() {
        com.baidu.navisdk.module.routepreference.c.i(this.b);
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
    }

    private b f(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorBNDifferentController", "createDiffConfig: " + g(i));
        }
        if (i == 2) {
            return new com.baidu.navisdk.ui.routeguide.motor.a();
        }
        if (i == 3) {
            return new com.baidu.navisdk.ui.routeguide.truck.a();
        }
        return new a();
    }

    public int b() {
        return com.baidu.navisdk.module.routepreference.c.b(this.b);
    }

    public void c(int i) {
        com.baidu.navisdk.module.routepreference.c.b(this.b, i);
    }

    public void d(int i) {
        com.baidu.navisdk.module.routepreference.c.c(this.b, i);
    }

    public boolean g() {
        return this.b == 3;
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.iview.a a(com.baidu.navisdk.ui.routeguide.mapmode.iview.a aVar) {
        if (aVar != null && aVar.f() == this.b) {
            return aVar;
        }
        if (aVar != null) {
            aVar.d();
        }
        return this.f9078a.a();
    }

    public f a(Context context, d dVar, f fVar) {
        if (fVar != null && fVar.b() == this.b) {
            return fVar;
        }
        if (fVar != null) {
            fVar.onDestroy();
        }
        return this.f9078a.a(context, dVar);
    }

    public boolean e() {
        return com.baidu.navisdk.module.routepreference.c.h(this.b);
    }

    public void a(boolean z) {
        com.baidu.navisdk.module.routepreference.c.a(this.b, z);
    }

    public boolean a(int i) {
        return com.baidu.navisdk.module.routepreference.c.a(this.b, i);
    }

    public int a() {
        return com.baidu.navisdk.module.routepreference.c.a(this.b);
    }
}
