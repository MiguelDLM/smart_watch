package com.baidu.navisdk.pronavi.logic.service.roadcondition;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.adapter.struct.BNRoadCondition;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.v2.d;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.pronavi.data.model.g;
import com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService;
import com.baidu.navisdk.pronavi.logic.base.a;
import com.garmin.fit.OxXXx0X;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import oOIx.oxoX;

/* loaded from: classes7.dex */
public final class BNRoadConditionService<C extends com.baidu.navisdk.pronavi.logic.base.a> extends RGBaseLogicService<C> {
    private final g m;
    private final com.baidu.navisdk.pronavi.logic.service.roadcondition.c n;
    private final X0IIOO o;

    /* loaded from: classes7.dex */
    public static final class a extends com.baidu.navisdk.comapi.routeplan.v2.a {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        @OOXIXo
        public String getName() {
            return "BNRoadConditionService";
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public void onRoutePlan(int i, int i2, @oOoXoXO d dVar, @oOoXoXO Bundle bundle) {
            if (i == 2) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(((Func) BNRoadConditionService.this).g, "onRoutePlan " + i + ", " + i2 + ", " + bundle);
                }
                BNRoadConditionService.this.u();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<a> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7792a = new b();

        /* loaded from: classes7.dex */
        public static final class a extends com.baidu.navisdk.pronavi.logic.service.roadcondition.a {
            @Override // com.baidu.navisdk.pronavi.logic.service.roadcondition.a
            public boolean a() {
                if (com.baidu.navisdk.ui.routeguide.utils.b.A() && com.baidu.navisdk.ui.routeguide.utils.b.t()) {
                    return false;
                }
                return true;
            }
        }

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final a invoke() {
            return new a();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends com.baidu.navisdk.util.worker.lite.b {
        public c(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            BNRoadConditionService.this.n.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BNRoadConditionService(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.o = XIxXXX0x0.oIX0oI(b.f7792a);
        g gVar = (g) context.b(g.class);
        this.m = gVar;
        this.n = new com.baidu.navisdk.pronavi.logic.service.roadcondition.c(gVar, s());
    }

    private final int r() {
        List<m> value = this.m.d().getValue();
        int i = 0;
        if (value == null) {
            return 0;
        }
        double d = value.get(value.size() - 1).c;
        Double value2 = this.m.a().getValue();
        IIX0o.ooOOo0oXI(value2);
        IIX0o.oO(value2, "mRoadConditionViewM.getCarProgress().value!!");
        int Ox0O2 = (int) oxoX.Ox0O(d * value2.doubleValue());
        int i2 = 0;
        for (m mVar : value) {
            int i3 = mVar.c;
            if (i3 < Ox0O2) {
                i2 = i3;
            } else {
                if (mVar.b < 3) {
                    break;
                }
                i = i3;
            }
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onJammingRoad endJamDist: " + i + ", startJamDist: " + i2);
        }
        return i - i2;
    }

    private final com.baidu.navisdk.pronavi.logic.service.roadcondition.a s() {
        return (com.baidu.navisdk.pronavi.logic.service.roadcondition.a) this.o.getValue();
    }

    private final List<BNRoadCondition> t() {
        List<m> value = this.m.d().getValue();
        ArrayList arrayList = new ArrayList();
        if (value != null) {
            for (m mVar : value) {
                BNRoadCondition bNRoadCondition = new BNRoadCondition();
                bNRoadCondition.setIndex(mVar.f6935a);
                bNRoadCondition.setType(mVar.b);
                arrayList.add(bNRoadCondition);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        com.baidu.navisdk.util.worker.lite.a.b(new c("updateRoadConditionData"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        k l = ((com.baidu.navisdk.pronavi.logic.base.a) n()).l();
        if (l != null) {
            if (l instanceof com.baidu.navisdk.module.pronavi.message.b) {
                try {
                    com.baidu.navisdk.module.pronavi.model.g o = com.baidu.navisdk.module.pronavi.model.g.o();
                    IIX0o.oO(o, "RGAssistGuideModel.getInstance()");
                    ((com.baidu.navisdk.module.pronavi.message.b) l).a(o.a(), t());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            com.baidu.navisdk.module.pronavi.model.g o2 = com.baidu.navisdk.module.pronavi.model.g.o();
            IIX0o.oO(o2, "RGAssistGuideModel.getInstance()");
            l.a(o2.a());
        }
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "BNRoadConditionService";
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService
    @oOoXoXO
    public int[] p() {
        return new int[]{4174, 4100, 4171, 4172, OxXXx0X.Xx0OXIoI};
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService
    @OOXIXo
    public com.baidu.navisdk.comapi.routeplan.v2.a q() {
        return new a();
    }

    private final void a(int i) {
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        bNCommSettingManager.setIsShowMapSwitch(i);
        this.m.a(i);
        if (i != 0) {
            u();
        }
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService
    public void c(@OOXIXo Message msg) {
        IIX0o.x0xO0oo(msg, "msg");
        int i = msg.what;
        if (i != 4100) {
            if (i == 4174) {
                u();
                v();
                com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
                IIX0o.oO(V, "BNavigator.getInstance()");
                if (V.o() != null) {
                    com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
                    IIX0o.oO(V2, "BNavigator.getInstance()");
                    V2.o().f();
                    return;
                }
                return;
            }
            if (i == 4432) {
                u();
                return;
            }
            if (i != 4171) {
                if (i != 4172) {
                    return;
                }
                int i2 = msg.arg1;
                if (i2 == 0) {
                    if (msg.arg2 == 1) {
                        u();
                        return;
                    }
                    return;
                } else {
                    if (i2 == 6 || i2 == 11) {
                        u();
                        return;
                    }
                    return;
                }
            }
        }
        g gVar = this.m;
        IIX0o.oO(BNRouteGuider.getInstance(), "BNRouteGuider.getInstance()");
        gVar.a(r0.getCarProgress());
        com.baidu.navisdk.module.pronavi.model.g.o().n();
        com.baidu.navisdk.ui.routeguide.b V3 = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V3, "BNavigator.getInstance()");
        if (V3.o() != null) {
            com.baidu.navisdk.ui.routeguide.b V4 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V4, "BNavigator.getInstance()");
            V4.o().e();
        }
        v();
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "execute api " + api.d());
        }
        int d = api.d();
        if (d == 1) {
            u();
            return null;
        }
        if (d == 2) {
            a(api.c("paramA"));
            return null;
        }
        if (d == 3) {
            this.m.b(api.c("paramA"));
            return null;
        }
        if (d != 4) {
            return null;
        }
        return h.a().b("resultA", Integer.valueOf(r()));
    }
}
