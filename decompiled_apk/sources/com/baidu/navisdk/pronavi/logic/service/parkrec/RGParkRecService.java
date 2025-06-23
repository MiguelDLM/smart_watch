package com.baidu.navisdk.pronavi.logic.service.parkrec;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.jni.nativeif.JNIIdssControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.pronavi.data.model.f;
import com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService;
import com.baidu.navisdk.pronavi.logic.base.a;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class RGParkRecService<C extends com.baidu.navisdk.pronavi.logic.base.a> extends RGBaseLogicService<C> {
    private final f m;
    private final com.baidu.navisdk.pronavi.logic.service.parkrec.b n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private final d t;
    private final e u;
    private final c v;
    private final l.a w;

    /* loaded from: classes7.dex */
    public static final class a implements l.a {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.control.l.a
        public final void a() {
            com.baidu.navisdk.model.datastruct.destrec.c cVar;
            boolean z;
            RGParkRecService.this.o = false;
            MutableLiveData<com.baidu.navisdk.pronavi.logic.service.parkrec.a> b = RGParkRecService.this.m.b();
            boolean z2 = RGParkRecService.this.p;
            boolean z3 = RGParkRecService.this.q;
            com.baidu.navisdk.pronavi.logic.service.parkrec.a value = RGParkRecService.this.m.b().getValue();
            if (value != null && (cVar = value.a()) != null) {
                if (cVar.e() && !RGParkRecService.this.s && !RGParkRecService.this.p) {
                    z = true;
                } else {
                    z = false;
                }
                cVar.a(z);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } else {
                cVar = null;
            }
            b.postValue(new com.baidu.navisdk.pronavi.logic.service.parkrec.a(false, z2, z3, cVar));
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends com.baidu.navisdk.comapi.routeplan.v2.a {
        public b() {
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        @OOXIXo
        public String getName() {
            return "RGParkRecService";
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public void onRoutePlan(int i, int i2, @oOoXoXO com.baidu.navisdk.comapi.routeplan.v2.d dVar, @oOoXoXO Bundle bundle) {
            if (i == 2 || i == 65) {
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(((Func) RGParkRecService.this).g, "onRoutePlan " + i + ", " + i2 + ", " + bundle);
                }
                com.baidu.navisdk.util.worker.lite.a.a(RGParkRecService.this.u);
                RGParkRecService.this.m.a().postValue(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements JNIIdssControl.IdssResponseCallback {
        public c() {
        }

        @Override // com.baidu.navisdk.jni.nativeif.JNIIdssControl.IdssResponseCallback
        public void onFail(int i) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGParkRecService.this).g, "requestPark --> fail! type = " + i);
            }
        }

        @Override // com.baidu.navisdk.jni.nativeif.JNIIdssControl.IdssResponseCallback
        public void onSuccess(int i, @oOoXoXO byte[] bArr) {
            boolean z;
            boolean z2;
            String f;
            Boolean bool;
            String str;
            Integer num;
            g gVar = g.PRO_NAV;
            ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> arrayList = null;
            if (gVar.d()) {
                String str2 = ((Func) RGParkRecService.this).g;
                StringBuilder sb = new StringBuilder();
                sb.append("requestPark --> success! type = ");
                sb.append(i);
                sb.append(", pb size = ");
                if (bArr != null) {
                    num = Integer.valueOf(bArr.length);
                } else {
                    num = null;
                }
                sb.append(num);
                gVar.e(str2, sb.toString());
            }
            if (i != 3) {
                return;
            }
            com.baidu.navisdk.model.datastruct.destrec.c a2 = RGParkRecService.this.n.a(bArr);
            if (gVar.d()) {
                String str3 = ((Func) RGParkRecService.this).g;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestPark --> startParkRec = ");
                sb2.append(RGParkRecService.this.o);
                sb2.append(", startParkSpaceRecOrNav = ");
                sb2.append(RGParkRecService.this.p);
                sb2.append(", startParkSpaceNav = ");
                sb2.append(RGParkRecService.this.q);
                sb2.append(", showStrongRecPanel = ");
                sb2.append(RGParkRecService.this.s);
                sb2.append(", isStrongRec = ");
                if (a2 != null) {
                    bool = Boolean.valueOf(a2.e());
                } else {
                    bool = null;
                }
                sb2.append(bool);
                sb2.append(", recParkingText = ");
                if (a2 != null) {
                    str = a2.c();
                } else {
                    str = null;
                }
                sb2.append(str);
                gVar.e(str3, sb2.toString());
                String str4 = ((Func) RGParkRecService.this).g;
                if (a2 != null) {
                    arrayList = a2.b();
                }
                gVar.a(str4, "requestPark", "allRecPoiList", arrayList);
            }
            if (a2 != null && a2.e()) {
                z = true;
            } else {
                z = false;
            }
            if (z && !RGParkRecService.this.s && !RGParkRecService.this.p) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                RGParkRecService.this.s = true;
            }
            if (a2 != null) {
                a2.a(z2);
            }
            com.baidu.navisdk.pronavi.logic.service.parkrec.a aVar = new com.baidu.navisdk.pronavi.logic.service.parkrec.a(RGParkRecService.this.o, RGParkRecService.this.p, RGParkRecService.this.q, a2);
            RGParkRecService.this.m.b().postValue(aVar);
            com.baidu.navisdk.model.datastruct.destrec.e b = aVar.b();
            if (b != null) {
                boolean b2 = com.baidu.navisdk.ui.routeguide.control.d.e.b();
                if (gVar.d()) {
                    gVar.e(((Func) RGParkRecService.this).g, "requestPark --> hasEnterIntelligentDest = " + b2);
                }
                if (RGParkRecService.this.p && !b2) {
                    RGParkRecService.this.a(b);
                }
                com.baidu.navisdk.model.modelfactory.a a3 = com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
                if (a3 != null) {
                    RoutePlanNode endNode = ((com.baidu.navisdk.model.modelfactory.f) a3).g();
                    if (!z && (f = b.f()) != null && f.length() != 0) {
                        IIX0o.oO(endNode, "endNode");
                        if (!TextUtils.equals(endNode.getUID(), b.f())) {
                            RoutePlanNode routePlanNode = new RoutePlanNode();
                            routePlanNode.setName(b.c());
                            routePlanNode.setUID(b.f());
                            routePlanNode.setGeoPoint(b.b());
                            routePlanNode.mBuildingID = b.a();
                            routePlanNode.setFrom(1);
                            routePlanNode.setNodeType(1);
                            Bundle bundle = new Bundle();
                            String d = b.d();
                            if (d != null && d.length() != 0) {
                                bundle.putString("park_uid", b.d());
                            }
                            BNRoutePlaner.getInstance().h(0);
                            a0.G = 14;
                            l.l().a(routePlanNode, 2, bundle);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.model.modelfactory.RoutePlanModel");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends com.baidu.navisdk.util.worker.lite.b {
        public d(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            Lifecycle lifecycle = RGParkRecService.this.getLifecycle();
            IIX0o.oO(lifecycle, "lifecycle");
            if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(((Func) RGParkRecService.this).g, "requestParkRunnable --> startParkRec = " + RGParkRecService.this.o + ", startParkSpaceRecOrNav = " + RGParkRecService.this.p);
                }
                if (RGParkRecService.this.o || RGParkRecService.this.p) {
                    RGParkRecService.this.n.a();
                    com.baidu.navisdk.util.worker.lite.a.a(this, 10002, 60000L);
                    return;
                }
            }
            com.baidu.navisdk.util.worker.lite.a.a(this);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends com.baidu.navisdk.util.worker.lite.b {
        public e(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGParkRecService.this).g, "requestSaveParkDataRunnable --> startParkSpaceRecOrNav = " + RGParkRecService.this.p);
            }
            Lifecycle lifecycle = RGParkRecService.this.getLifecycle();
            IIX0o.oO(lifecycle, "lifecycle");
            if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED) && RGParkRecService.this.p) {
                com.baidu.navisdk.module.park.a routeSaveParkData = com.baidu.navisdk.module.park.a.c(com.baidu.navisdk.framework.b.q());
                if (gVar.d()) {
                    gVar.e(((Func) RGParkRecService.this).g, "requestSaveParkDataRunnable --> routeSaveParkData = " + routeSaveParkData);
                }
                IIX0o.oO(routeSaveParkData, "routeSaveParkData");
                if (routeSaveParkData.n()) {
                    RGParkRecService.this.m.a().postValue(routeSaveParkData);
                    if (!RGParkRecService.this.r) {
                        BNMapController.getInstance().setACEParkViewMode(2);
                        RGParkRecService.this.r = true;
                    }
                    com.baidu.navisdk.ui.routeguide.control.d dVar = com.baidu.navisdk.ui.routeguide.control.d.e;
                    dVar.a(true);
                    dVar.a(routeSaveParkData);
                }
                com.baidu.navisdk.util.worker.lite.a.a(this, 10002, 5000L);
                return;
            }
            com.baidu.navisdk.util.worker.lite.a.a(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGParkRecService(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        f fVar = (f) context.b(f.class);
        this.m = fVar;
        this.n = new com.baidu.navisdk.pronavi.logic.service.parkrec.b(context, fVar);
        this.t = new d("BNWorkerCenter::RequestParkRunnable");
        this.u = new e("BNWorkerCenter::RequestSaveParkDataRunnable");
        this.v = new c();
        this.w = new a();
    }

    private final void r() {
        s();
        this.r = false;
    }

    private final void s() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "hideRecommendPoi---");
        }
        BNMapController.getDynamicOverlay().hideAll(900);
        BNMapController.getInstance().setEndNodeNameVisible(true);
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "BNParkRecService";
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService
    @OOXIXo
    public int[] p() {
        return new int[]{4503, 4504};
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService
    @OOXIXo
    public com.baidu.navisdk.comapi.routeplan.v2.a q() {
        return new b();
    }

    private final void d(Message message) {
        com.baidu.navisdk.model.datastruct.destrec.c a2;
        com.baidu.navisdk.model.datastruct.destrec.c cVar = null;
        Integer valueOf = message != null ? Integer.valueOf(message.what) : null;
        if (valueOf != null && valueOf.intValue() == 4503) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "handleEngineMsg --> NL_UI_MESSAGE_TYPE_INTELLIGENT_PARK!  arg1 = " + message.arg1 + ", arg2 = " + message.arg2);
            }
            if (message.arg1 == 0) {
                this.o = true;
                com.baidu.navisdk.util.worker.lite.a.a(this.t);
                com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) this.t, 10002);
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 4504) {
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(this.g, "handleEngineMsg --> NL_UI_MESSAGE_TYPE_CAR_PARK_GUIDE! arg1 = " + message.arg1 + ", arg2 = " + message.arg2);
            }
            int i = message.arg1;
            boolean z = i != 0;
            this.p = z;
            this.q = i == 2;
            if (z) {
                com.baidu.navisdk.ui.routeguide.control.d.e.e();
                com.baidu.navisdk.util.worker.lite.a.a(this.t);
                com.baidu.navisdk.util.worker.lite.a.a(this.u);
                com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) this.t, 10002);
                com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) this.u, 10002);
                return;
            }
            MutableLiveData<com.baidu.navisdk.pronavi.logic.service.parkrec.a> b2 = this.m.b();
            boolean z2 = this.o;
            boolean z3 = this.q;
            com.baidu.navisdk.pronavi.logic.service.parkrec.a value = this.m.b().getValue();
            if (value != null && (a2 = value.a()) != null) {
                a2.a((!a2.e() || this.s || this.p) ? false : true);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                cVar = a2;
            }
            b2.postValue(new com.baidu.navisdk.pronavi.logic.service.parkrec.a(z2, false, z3, cVar));
            r();
            com.baidu.navisdk.ui.routeguide.control.d.e.g();
        }
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService, com.baidu.navisdk.pageframe.logic.BNLogicService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        JNIIdssControl.getInstance().registerCallback(3, this.v);
        l.l().a(this.w);
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService, com.baidu.navisdk.pageframe.logic.BNLogicService, com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        JNIIdssControl.getInstance().unRegisterCallback(3);
        l.l().a((l.a) null);
        this.p = false;
        this.o = false;
        com.baidu.navisdk.util.worker.lite.a.a(this.t);
        com.baidu.navisdk.util.worker.lite.a.a(this.u);
        r();
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService
    public void c(@OOXIXo Message msg) {
        IIX0o.x0xO0oo(msg, "msg");
        super.c(msg);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            String str = this.g;
            StringBuilder sb = new StringBuilder();
            sb.append("handleRouteGuideMsg: onMessage ");
            sb.append(msg.what - 4096);
            sb.append(", ");
            sb.append(msg.arg1);
            sb.append(", ");
            sb.append(msg.arg2);
            gVar.e(str, sb.toString());
        }
        d(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.baidu.navisdk.model.datastruct.destrec.e eVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "showRecommendPoi --> recommendStallNode = " + eVar);
        }
        if (eVar == null || TextUtils.isEmpty(eVar.c()) || eVar.e() == null) {
            return;
        }
        BNMapController.getInstance().clearLayer(8);
        BNMapController.getInstance().showLayer(8, false);
        BNMapController.getInstance().setEndNodeNameVisible(false);
        BNDynamicOverlay dynamicOverlay = BNMapController.getDynamicOverlay();
        dynamicOverlay.clear(900);
        com.baidu.navisdk.model.datastruct.b bVar = new com.baidu.navisdk.model.datastruct.b();
        bVar.b(1621);
        bVar.a(eVar.c());
        bVar.a(eVar.e());
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        dynamicOverlay.setDataSet(900, (List<com.baidu.navisdk.model.datastruct.b>) arrayList);
        dynamicOverlay.showAll(900);
    }
}
