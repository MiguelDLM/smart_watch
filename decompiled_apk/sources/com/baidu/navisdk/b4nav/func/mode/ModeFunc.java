package com.baidu.navisdk.b4nav.func.mode;

import com.baidu.navisdk.b4nav.c;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.comapi.mapcontrol.NavMapManager;
import com.baidu.navisdk.comapi.mapcontrol.NavMapModeManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.framework.func.Func;

/* loaded from: classes7.dex */
public abstract class ModeFunc<R> extends CoreFunc<R> {
    private boolean m;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) ModeFunc.this).g;
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc
    public void b(boolean z) {
        super.b(z);
        if (com.baidu.navisdk.module.init.a.a()) {
            BNRoutePlaner.getInstance().p(10);
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        a(1002, new a());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        if (com.baidu.navisdk.module.init.a.a() && !((c) this.i).p() && com.baidu.navisdk.module.init.a.a()) {
            if (!this.m) {
                NavMapManager.getInstance().removeNaviMapListener();
                NavMapManager.getInstance().handleRoadCondition(0);
                NavMapManager.getInstance().setNaviMapMode(0);
                NavMapManager.getInstance().handleMapOverlays(0);
            }
            t();
            s();
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        super.k();
        r();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
        if (!com.baidu.navisdk.module.init.a.a()) {
            return;
        }
        this.k.l();
        throw null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "ModeFunc";
    }

    public void r() {
        NavMapModeManager.getInstance().cacheMapMode();
    }

    public void s() {
        NavMapModeManager.getInstance().reset();
    }

    public void t() {
        NavMapModeManager.getInstance().restoreMapMode();
    }
}
