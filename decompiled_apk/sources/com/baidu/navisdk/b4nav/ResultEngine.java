package com.baidu.navisdk.b4nav;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.SystemClock;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.b4nav.framework.B4NavEngine;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.statistic.t;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class ResultEngine extends B4NavEngine<c> {
    private t r;

    @OOXIXo
    private final b s;

    private final void r() {
        this.s.h();
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.B4NavEngine
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.s.d(true);
            throw null;
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.B4NavEngine, com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        if (!com.baidu.navisdk.util.statistic.userop.b.r().e("2.1")) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.1", "", null, null);
        }
        t u = t.u();
        this.r = u;
        if (u != null) {
            u.z = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.B4NavEngine, com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        r();
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.B4NavEngine, com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
        super.i();
    }

    @Override // com.baidu.navisdk.b4nav.framework.B4NavEngine, com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        super.j();
    }

    @Override // com.baidu.navisdk.b4nav.framework.B4NavEngine, com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        super.k();
        this.s.b(false);
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.B4NavEngine, com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
        this.s.g();
        throw null;
    }

    @Override // com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "ResultEngine";
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        if (api.d() != 1) {
            return null;
        }
        Object a2 = api.a("routeIndex");
        IIX0o.oO(a2, "api.get(\"routeIndex\")");
        int intValue = ((Number) a2).intValue();
        Object a3 = api.a("isAuto");
        IIX0o.oO(a3, "api.get(\"isAuto\")");
        a(intValue, ((Boolean) a3).booleanValue());
        throw null;
    }

    public final boolean a(int i, boolean z) {
        g gVar = g.B4NAV;
        if (gVar.d()) {
            gVar.e(this.g, "changeToRoutInner --> routeIndex = " + i + ", isAuto" + z);
        }
        this.s.k();
        throw null;
    }
}
