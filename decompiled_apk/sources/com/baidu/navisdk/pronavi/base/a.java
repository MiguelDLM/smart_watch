package com.baidu.navisdk.pronavi.base;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.module.pronavi.model.f;
import com.baidu.navisdk.pronavi.base.logic.RGBaseLogicFrame;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.b0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.u;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.pronavi.state.b {
    private f j;
    private com.baidu.navisdk.pronavi.logic.i.b k;
    private Activity l;
    private com.baidu.navisdk.ui.routeguide.subview.a m;
    private final k n;
    private final com.baidu.navisdk.module.pronavi.msg.b o;
    private int p;
    private int q;
    private int r;
    private int s;

    public a(@NonNull Activity activity, String str, com.baidu.navisdk.framework.data.a aVar, com.baidu.navisdk.pageframe.store.i.b bVar, RGBaseLogicFrame rGBaseLogicFrame, f fVar, com.baidu.navisdk.ui.routeguide.subview.a aVar2) {
        super(activity, str, aVar, bVar, rGBaseLogicFrame);
        this.o = new com.baidu.navisdk.module.pronavi.msg.a(80);
        this.j = fVar;
        this.l = activity;
        this.m = aVar2;
        this.n = c.p().k();
        com.baidu.navisdk.pronavi.util.a aVar3 = com.baidu.navisdk.pronavi.util.a.h;
        a(aVar3.a(), aVar3.b());
        F();
    }

    public boolean A() {
        if (com.baidu.navisdk.ui.routeguide.utils.b.i() != 0) {
            return true;
        }
        return false;
    }

    public boolean B() {
        return com.baidu.navisdk.ui.routeguide.utils.b.t();
    }

    public boolean C() {
        if (2 == com.baidu.navisdk.module.pronavi.a.j) {
            return true;
        }
        return false;
    }

    public boolean D() {
        return com.baidu.navisdk.ui.routeguide.utils.b.u();
    }

    public boolean E() {
        if (o() == 1) {
            return true;
        }
        return false;
    }

    public void F() {
    }

    public boolean a(int i) {
        return (i == 0 || i == 1) ? false : true;
    }

    public void b(com.baidu.navisdk.module.pronavi.msg.c cVar) {
        com.baidu.navisdk.module.pronavi.msg.b bVar = this.o;
        if (bVar == null || cVar == null) {
            return;
        }
        bVar.a(cVar);
    }

    public boolean c(String... strArr) {
        if (strArr == null) {
            return false;
        }
        String m = m();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(getClass().getName(), "isCurrentState: " + m);
        }
        if (TextUtils.isEmpty(m)) {
            return false;
        }
        for (String str : strArr) {
            if (m.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean d(String... strArr) {
        if (strArr == null) {
            return false;
        }
        String n = n();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(getClass().getName(), "isCurrentGlassState: " + n);
        }
        if (TextUtils.isEmpty(n)) {
            return false;
        }
        for (String str : strArr) {
            if (n.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.navisdk.context.business.a
    public Activity e() {
        return this.l;
    }

    @Override // com.baidu.navisdk.context.business.a
    public com.baidu.navisdk.context.support.service.a i() {
        return this.k;
    }

    public int l() {
        return com.baidu.navisdk.ui.routeguide.utils.b.b();
    }

    public String m() {
        return RouteGuideFSM.getInstance().getCurrentState();
    }

    public String n() {
        return RouteGuideFSM.getCurrentGlassState();
    }

    public int o() {
        return x.b().d0();
    }

    public int p() {
        return com.baidu.navisdk.ui.routeguide.utils.b.i();
    }

    public int q() {
        return this.r;
    }

    public int r() {
        return this.s;
    }

    public com.baidu.navisdk.module.pronavi.msg.b s() {
        return this.o;
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.f t() {
        return com.baidu.navisdk.ui.routeguide.utils.b.o();
    }

    @Nullable
    public k u() {
        return this.n;
    }

    public int v() {
        f fVar = this.j;
        if (fVar != null) {
            return fVar.d();
        }
        return 1;
    }

    public com.baidu.navisdk.ui.routeguide.subview.a w() {
        return this.m;
    }

    public View x() {
        return x.b().s0();
    }

    public int y() {
        f fVar = this.j;
        if (fVar != null) {
            return fVar.g();
        }
        return 1;
    }

    public boolean z() {
        return com.baidu.navisdk.ui.routeguide.utils.b.s();
    }

    @Override // com.baidu.navisdk.context.business.a
    public <T> T a(@NonNull Class<T> cls) {
        if (i() == null) {
            return null;
        }
        return (T) i().getService(cls);
    }

    @Override // com.baidu.navisdk.context.d, com.baidu.navisdk.context.a
    public b0 b() {
        return super.b();
    }

    @Override // com.baidu.navisdk.context.business.a, com.baidu.navisdk.context.d, com.baidu.navisdk.context.a
    public Context a() {
        Activity activity = this.l;
        if (activity == null) {
            return super.a();
        }
        return activity.getApplicationContext();
    }

    public void a(com.baidu.navisdk.module.pronavi.msg.c cVar) {
        com.baidu.navisdk.module.pronavi.msg.b bVar = this.o;
        if (bVar == null || cVar == null) {
            return;
        }
        bVar.b(cVar);
    }

    @Override // com.baidu.navisdk.uiframe.framework.a, com.baidu.navisdk.context.business.a, com.baidu.navisdk.context.d
    public void d() {
        super.d();
        this.l = null;
        this.k = null;
        this.j = null;
        this.o.a();
        u.b(this);
    }

    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this.m = aVar;
    }

    public void a(int i, int i2) {
        this.p = i;
        this.q = i2;
        this.r = i / 2;
        this.s = i2 / 2;
    }
}
