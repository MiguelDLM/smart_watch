package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public abstract class a implements com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a, com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b {

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private com.baidu.navisdk.pronavi.ui.buttoncollect.data.a f7889a;

    public final void a(@oOoXoXO com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar) {
        this.f7889a = aVar;
    }

    @oOoXoXO
    public final com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b() {
        return this.f7889a;
    }

    @OOXIXo
    public final String c() {
        String e;
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a aVar = this.f7889a;
        if (aVar == null || (e = aVar.e()) == null) {
            return "";
        }
        return e;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public void g() {
    }

    public final void a() {
        com.baidu.navisdk.ui.routeguide.model.i s = com.baidu.navisdk.ui.routeguide.model.i.s();
        IIX0o.oO(s, "RGEnlargeRoadMapModel.getInstance()");
        if (s.k()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(c(), "exitEnlargeMapState: ");
            }
            com.baidu.navisdk.ui.routeguide.b.V().w();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
            com.baidu.navisdk.ui.routeguide.model.i s2 = com.baidu.navisdk.ui.routeguide.model.i.s();
            IIX0o.oO(s2, "RGEnlargeRoadMapModel.getInstance()");
            s2.b(0);
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.q.2");
        }
    }
}
