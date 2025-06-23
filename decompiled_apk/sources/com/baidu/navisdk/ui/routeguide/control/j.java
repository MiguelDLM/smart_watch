package com.baidu.navisdk.ui.routeguide.control;

import android.graphics.Bitmap;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;

/* loaded from: classes8.dex */
public class j implements com.baidu.navisdk.framework.interfaces.pronavi.h, com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.carlogo.control.d f8563a;
    private Bitmap b;
    private String c;
    private String d;
    private int e = -1;
    private boolean f;

    private void d() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = -1;
    }

    private void e() {
        BNMapController.getInstance().setCarLogoTriangle();
        if (com.baidu.navisdk.ui.routeguide.ace.a.m().g() != null && com.baidu.navisdk.ui.routeguide.ace.a.m().g().getValue() != null) {
            com.baidu.navisdk.ui.routeguide.ace.g value = com.baidu.navisdk.ui.routeguide.ace.a.m().g().getValue();
            com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
            if (value.c()) {
                if (s != null) {
                    s.j().e("RGBucketGroupComponent").a(2017).a(Boolean.TRUE).b((Object) 2).a();
                    return;
                }
                return;
            } else if (value.b()) {
                if (s != null) {
                    s.j().e("RGBucketGroupComponent").a(2017).a(Boolean.TRUE).b((Object) 1).a();
                    return;
                }
                return;
            } else {
                com.baidu.navisdk.module.pronavi.model.g.o().a(true);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p(0);
                return;
            }
        }
        com.baidu.navisdk.module.pronavi.model.g.o().a(true);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p(0);
    }

    private void f() {
        BNMapController.getInstance().setCarLogoSpeed();
        com.baidu.navisdk.module.pronavi.model.g.o().a(false);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p(8);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(false, 0);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.h
    public int a() {
        com.baidu.navisdk.module.carlogo.control.d dVar = this.f8563a;
        if (dVar == null) {
            return 0;
        }
        dVar.a();
        throw null;
    }

    public boolean b(String str, String str2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCurrentCarLogoControl", "on3DSuccess: " + str + ", configFileName:" + str2);
        }
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            if (gVar.d()) {
                gVar.e("RGCurrentCarLogoControl", "on3DSuccess is not navi begin");
            }
            return false;
        }
        d();
        this.c = str;
        this.d = str2;
        if (this.f) {
            return true;
        }
        boolean z = BNMapController.getInstance().set3DCarLogoToMap(str, str2);
        if (z) {
            if (com.baidu.navisdk.ui.routeguide.ace.a.m().g() != null && com.baidu.navisdk.ui.routeguide.ace.a.m().g().getValue() != null) {
                com.baidu.navisdk.ui.routeguide.ace.g value = com.baidu.navisdk.ui.routeguide.ace.a.m().g().getValue();
                com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
                if (value.c()) {
                    if (s != null) {
                        s.j().e("RGBucketGroupComponent").a(2017).a(Boolean.TRUE).b((Object) 2).a();
                    }
                } else if (!value.b()) {
                    com.baidu.navisdk.module.pronavi.model.g.o().a(true);
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p(0);
                } else if (s != null) {
                    s.j().e("RGBucketGroupComponent").a(2017).a(Boolean.TRUE).b((Object) 1).a();
                }
            } else {
                com.baidu.navisdk.module.pronavi.model.g.o().a(true);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p(0);
            }
        }
        return z;
    }

    public int c() {
        return this.e;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.h
    public void onDestroy() {
        com.baidu.navisdk.module.carlogo.control.d dVar = this.f8563a;
        if (dVar == null) {
            return;
        }
        dVar.b();
        throw null;
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.h
    public boolean a(String str, String str2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCurrentCarLogoControl", "set3DCarLogo: " + str + ", " + str2);
        }
        return b(str, str2);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.h
    public void b() {
        String str;
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
            return;
        }
        this.f = false;
        if (this.b != null) {
            BNMapController.getInstance().setCarImageToMap(this.b);
            return;
        }
        String str2 = this.c;
        if (str2 != null && (str = this.d) != null) {
            b(str2, str);
        } else if (this.e == 227) {
            f();
        } else {
            e();
        }
    }
}
