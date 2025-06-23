package com.baidu.navisdk.b4nav.func.necs;

import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.framework.func.Func;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes7.dex */
public class NeCsFunc extends CoreFunc<com.baidu.navisdk.b4nav.func.necs.a> {
    private final BNDynamicOverlay m;
    private final com.baidu.navisdk.util.worker.lite.b n;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) NeCsFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public b() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) NeCsFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public c() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) NeCsFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public d() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) NeCsFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public e() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) NeCsFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public f() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) NeCsFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public g() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) NeCsFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class h extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public h() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) NeCsFunc.this).g;
        }
    }

    private void u() {
        ((com.baidu.navisdk.b4nav.func.necs.a) this.j).a((com.baidu.navisdk.model.datastruct.chargestation.c) null);
        this.m.clear(BNDynamicOverlay.Key.NE_CHARGING_STATION);
        this.m.cancelFocusAll(BNDynamicOverlay.Key.NE_CHARGING_STATION);
        this.m.cancelZoom(BNDynamicOverlay.Key.NE_CHARGING_STATION);
        this.m.hideAllBySid(BNDynamicOverlay.Key.NE_CHARGING_STATION);
    }

    private void v() {
        u();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "NeCsFunc";
    }

    public void r() {
        this.m.clear(BNDynamicOverlay.Key.NE_LIGHT_CIRCLE);
        this.m.hideAllBySid(BNDynamicOverlay.Key.NE_LIGHT_CIRCLE);
    }

    public void s() {
        this.m.clear(BNDynamicOverlay.Key.NE_CHARGE_DRAW_LINE);
        this.m.hideAllBySid(BNDynamicOverlay.Key.NE_CHARGE_DRAW_LINE);
    }

    public void t() {
        if (!com.baidu.navisdk.util.common.g.ROUTE_RESULT.d()) {
            v();
        } else {
            this.k.c();
            throw null;
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc
    public void b(boolean z) {
        super.b(z);
        if (com.baidu.navisdk.module.init.a.a()) {
            t();
            r();
            s();
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        a(1000, new a());
        a(1002, new b());
        a(1003, new c());
        a(4002, new d());
        a(ErrorCode.CONTENT_FORCE_EXPOSURE, new e());
        a(1014, new f());
        a(4001, new g());
        a(4020, new h());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        if (com.baidu.navisdk.module.init.a.a()) {
            t();
            r();
            s();
            com.baidu.navisdk.util.worker.lite.a.a(this.n);
        }
    }
}
