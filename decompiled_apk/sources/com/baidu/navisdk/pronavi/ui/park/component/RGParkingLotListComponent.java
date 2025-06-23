package com.baidu.navisdk.pronavi.ui.park.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.o;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.bn;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class RGParkingLotListComponent extends RGUiComponent<com.baidu.navisdk.pronavi.ui.base.b> {
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c p;
    private com.baidu.navisdk.ui.util.a q;
    private boolean r;
    private final com.baidu.navisdk.pronavi.data.model.f s;
    private final BNDynamicOverlay t;
    private String u;
    private boolean v;
    private boolean w;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends com.baidu.navisdk.util.worker.lite.b {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            BNMapController.getInstance().resetRouteDetailIndex();
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7954a;

        public d(boolean z) {
            this.f7954a = z;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            com.baidu.navisdk.asr.d.B().c();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            if (this.f7954a) {
                str = "0";
            } else {
                str = "1";
            }
            r.d("38.0.21.1469", str);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements Observer<com.baidu.navisdk.pronavi.logic.service.parkrec.a> {

        /* loaded from: classes7.dex */
        public static final class a extends com.baidu.navisdk.util.worker.lite.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f7956a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Bundle bundle, String str) {
                super(str);
                this.f7956a = bundle;
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_DYNAMIC_LAYER, this.f7956a);
            }
        }

        public e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(@oOoXoXO com.baidu.navisdk.pronavi.logic.service.parkrec.a aVar) {
            String j;
            if (aVar != null) {
                if (aVar.c()) {
                    com.baidu.navisdk.model.datastruct.destrec.c a2 = aVar.a();
                    if (a2 != null) {
                        RGParkingLotListComponent.this.a(a2);
                        if (RGParkingLotListComponent.this.r) {
                            RGParkingLotListComponent.this.a(a2.b(), RGParkingLotListComponent.this.u);
                            return;
                        }
                        if (a2.e() && !RGParkingLotListComponent.this.v) {
                            RGParkingLotListComponent.this.v = true;
                            RGParkingLotListComponent rGParkingLotListComponent = RGParkingLotListComponent.this;
                            if (a2.b().isEmpty()) {
                                j = null;
                            } else {
                                com.baidu.navisdk.model.datastruct.destrec.f fVar = a2.b().get(0);
                                IIX0o.oO(fVar, "data.allRecPoiList[0]");
                                j = fVar.j();
                            }
                            rGParkingLotListComponent.u = j;
                            if (!a2.b().isEmpty()) {
                                RGParkingLotListComponent.this.a(a2.b(), false);
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("uid", RGParkingLotListComponent.this.u);
                            bundle.putInt("key_type_show_views", 7);
                            bundle.putBoolean("isStringRec", true);
                            com.baidu.navisdk.util.worker.lite.a.c(new a(bundle, "BNWorkerCenter::enterParkListState"));
                            com.baidu.navisdk.util.statistic.userop.b.r().b("38.0.21.1462");
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (RGParkingLotListComponent.this.r) {
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
                }
                RGParkingLotListComponent.this.F();
                return;
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
            RGParkingLotListComponent.this.F();
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends com.baidu.navisdk.util.worker.lite.b {
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(int i, String str) {
            super(str);
            this.b = i;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n0;
            com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n02;
            ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> b;
            com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a aVar;
            RecyclerView o02;
            com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = RGParkingLotListComponent.this.p;
            if (cVar != null && (o02 = cVar.o0()) != null) {
                o02.scrollToPosition(this.b);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar2 = RGParkingLotListComponent.this.p;
            if (cVar2 != null && (n02 = cVar2.n0()) != null && (b = n02.b()) != null && (aVar = b.get(this.b)) != null) {
                aVar.a(true);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar3 = RGParkingLotListComponent.this.p;
            if (cVar3 != null && (n0 = cVar3.n0()) != null) {
                n0.notifyItemChanged(this.b);
            }
            RGParkingLotListComponent.this.b(this.b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends com.baidu.navisdk.ui.util.a {
        public g(long j) {
            super(j);
        }

        @Override // com.baidu.navisdk.ui.util.a
        public void onFinish() {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends com.baidu.navisdk.util.worker.lite.b {
        public i(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            BNMapController.getInstance().resetRouteDetailIndex();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGParkingLotListComponent(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.s = (com.baidu.navisdk.pronavi.data.model.f) context.b(com.baidu.navisdk.pronavi.data.model.f.class);
        this.t = BNMapController.getDynamicOverlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        this.t.cancelFocusAllBySid(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER);
        this.t.cancelZoomBySid(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER);
        com.baidu.navisdk.util.worker.lite.a.b(new b("BNWorkerCenter::cancelZoomCarAndPark"), ErrorCode.ERROR_NO_NETWORK);
    }

    private final String D() {
        MutableLiveData<com.baidu.navisdk.pronavi.logic.service.parkrec.a> b2;
        com.baidu.navisdk.pronavi.logic.service.parkrec.a value;
        com.baidu.navisdk.model.datastruct.destrec.c a2;
        com.baidu.navisdk.pronavi.data.model.f fVar = this.s;
        if (fVar != null && (b2 = fVar.b()) != null && (value = b2.getValue()) != null && (a2 = value.a()) != null) {
            return a2.c();
        }
        return null;
    }

    private final ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> E() {
        MutableLiveData<com.baidu.navisdk.pronavi.logic.service.parkrec.a> b2;
        com.baidu.navisdk.pronavi.logic.service.parkrec.a value;
        com.baidu.navisdk.model.datastruct.destrec.c a2;
        ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> arrayList = new ArrayList<>();
        com.baidu.navisdk.pronavi.data.model.f fVar = this.s;
        if (fVar != null && (b2 = fVar.b()) != null && (value = b2.getValue()) != null && (a2 = value.a()) != null) {
            arrayList.addAll(a2.b());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        this.t.clear(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER);
        this.t.cancelFocusAllBySid(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER);
        this.t.cancelZoomBySid(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        this.r = false;
        this.u = null;
        if (!this.w) {
            com.baidu.navisdk.asr.d.B().c();
        }
        H();
        C();
        K();
        I();
    }

    private final void H() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = this.p;
        if (cVar != null) {
            cVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void I() {
        ((com.baidu.navisdk.pronavi.ui.base.b) n()).j().e("RGBucketGroupComponent").a(1026).a(Boolean.TRUE).a();
    }

    private final void J() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGParkingLotListComponent", "startAutoHideTime: ");
        }
        com.baidu.navisdk.ui.util.a aVar = this.q;
        if (aVar != null) {
            aVar.cancel();
        }
        g gVar2 = new g(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        this.q = gVar2;
        gVar2.start();
    }

    private final void K() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGParkingLotListComponent", "stopAutoHideTime: ");
        }
        com.baidu.navisdk.ui.util.a aVar = this.q;
        if (aVar != null) {
            aVar.cancel();
        }
        this.q = null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGParkingLotListComponent", "onDestroy");
        }
        super.h();
        K();
        F();
        this.p = null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGParkingLotListComponent";
    }

    private final void c(int i2) {
        if (i2 < 0) {
            return;
        }
        com.baidu.navisdk.util.worker.lite.a.c(new f(i2, "BNWorkerCenter::onItemCardClick"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int i2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = this.p;
        if (cVar != null) {
            cVar.v(i2);
        }
    }

    private final void e(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        c(d(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String str) {
        if (str != null && str.length() != 0) {
            this.t.cancelFocusAllBySid(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER);
            this.t.cancelZoomBySid(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER);
            this.t.focusIdsBySid(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER, str);
            this.t.zoomBySid(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER, 1, null, new int[]{1});
            com.baidu.navisdk.util.worker.lite.a.b(new i("BNWorkerCenter::zoomCarAndPark"), ErrorCode.ERROR_NO_NETWORK);
            return;
        }
        C();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        MutableLiveData<com.baidu.navisdk.pronavi.logic.service.parkrec.a> b2;
        super.g();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGParkingLotListComponent", "onCreate");
        }
        com.baidu.navisdk.pronavi.data.model.f fVar = this.s;
        if (fVar == null || (b2 = fVar.b()) == null) {
            return;
        }
        b2.observe(this, new e());
    }

    private final int d(String str) {
        RecyclerView o02;
        RecyclerView o03;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = this.p;
        RecyclerView.Adapter adapter = null;
        if (!(((cVar == null || (o03 = cVar.o0()) == null) ? null : o03.getAdapter()) instanceof com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b)) {
            return -1;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar2 = this.p;
        if (cVar2 != null && (o02 = cVar2.o0()) != null) {
            adapter = o02.getAdapter();
        }
        if (adapter != null) {
            ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> a2 = ((com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b) adapter).a();
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.navisdk.model.datastruct.destrec.f fVar = a2.get(i2);
                IIX0o.oO(fVar, "list[i]");
                if (IIX0o.Oxx0IOOO(str, fVar.j())) {
                    return i2;
                }
            }
            return -1;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.ParkingLotListAdapter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a aVar;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n0;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n02;
        RecyclerView o02;
        RecyclerView.LayoutManager layoutManager;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = this.p;
        ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> arrayList = null;
        Integer valueOf = (cVar == null || (o02 = cVar.o0()) == null || (layoutManager = o02.getLayoutManager()) == null) ? null : Integer.valueOf(layoutManager.getItemCount());
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar2 = this.p;
        if (cVar2 != null && (n02 = cVar2.n0()) != null) {
            arrayList = n02.b();
        }
        IIX0o.ooOOo0oXI(valueOf);
        int intValue = valueOf.intValue();
        for (int i3 = 0; i3 < intValue; i3++) {
            if (i3 != i2 && arrayList != null && (aVar = arrayList.get(i3)) != null && aVar.i()) {
                arrayList.get(i3).a(false);
                com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar3 = this.p;
                if (cVar3 != null && (n0 = cVar3.n0()) != null) {
                    n0.notifyItemChanged(i3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends com.baidu.navisdk.asr.i.b {
        final /* synthetic */ boolean c;

        public h(boolean z) {
            this.c = z;
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a(@OOXIXo String intention, int i) {
            IIX0o.x0xO0oo(intention, "intention");
            super.a(intention, i);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("smart park select");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().d("38.0.21.1468", this.c ? "1" : "0");
            RGParkingLotListComponent.this.d(i);
            com.baidu.navisdk.asr.d.B().c();
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void c() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("smart park stop");
            }
            RGParkingLotListComponent.this.G();
        }

        @Override // com.baidu.navisdk.asr.i.b
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("smart park cancel");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements b.a {
        final /* synthetic */ boolean b;

        public c(boolean z) {
            this.b = z;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b.a
        public void a(boolean z, int i, @oOoXoXO com.baidu.navisdk.model.datastruct.destrec.f fVar) {
            RecyclerView o02;
            com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = RGParkingLotListComponent.this.p;
            if (cVar != null && (o02 = cVar.o0()) != null) {
                o02.scrollToPosition(i);
            }
            if (z) {
                RGParkingLotListComponent.this.u = fVar != null ? fVar.j() : null;
                RGParkingLotListComponent.this.b(i);
                RGParkingLotListComponent.this.f(fVar != null ? fVar.j() : null);
            } else {
                RGParkingLotListComponent.this.u = null;
                RGParkingLotListComponent.this.C();
            }
            RGParkingLotListComponent.this.a(z, i);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b.a
        public void a(@oOoXoXO com.baidu.navisdk.model.datastruct.destrec.f fVar) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("38.0.24.1467", this.b ? "0" : "1");
            if (fVar != null) {
                RoutePlanNode routePlanNode = new RoutePlanNode();
                routePlanNode.setName(fVar.g());
                routePlanNode.setUID(fVar.j());
                routePlanNode.setGeoPoint(o.a(fVar.i()));
                routePlanNode.setFrom(2);
                routePlanNode.setNodeType(2);
                BNRoutePlaner.getInstance().h(0);
                a0.G = 14;
                l.l().a(routePlanNode, 1, (Bundle) null);
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public com.baidu.navisdk.apicenter.h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        MutableLiveData<com.baidu.navisdk.pronavi.logic.service.parkrec.a> b2;
        com.baidu.navisdk.pronavi.logic.service.parkrec.a value;
        com.baidu.navisdk.model.datastruct.destrec.c a2;
        ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> b3;
        IIX0o.x0xO0oo(api, "api");
        int d2 = api.d();
        if (d2 == 1) {
            Bundle bundle = (Bundle) api.a("paramA");
            boolean z = bundle.getBoolean("show_by_click", false);
            boolean z2 = bundle.getBoolean("call_by_xd", false);
            boolean z3 = bundle.getBoolean("isStringRec", false);
            String string = bundle.getString("uid", this.u);
            this.w = z;
            a(D(), E(), string, false, z, z2, z3);
            return null;
        }
        if (d2 == 2) {
            G();
            return null;
        }
        if (d2 == 3) {
            return com.baidu.navisdk.apicenter.h.a().a(Boolean.valueOf(this.r));
        }
        if (d2 != 4) {
            return super.a(api);
        }
        com.baidu.navisdk.pronavi.data.model.f fVar = this.s;
        if (fVar != null && (b2 = fVar.b()) != null && (value = b2.getValue()) != null && (a2 = value.a()) != null && (b3 = a2.b()) != null) {
            a(b3, true);
        }
        return null;
    }

    private final void a(String str, ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> arrayList, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3;
        this.u = str2;
        if (this.r) {
            a(arrayList, str2);
        } else {
            if (str2 == null || str2.length() == 0) {
                ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> E = E();
                if (E.isEmpty()) {
                    str3 = null;
                } else {
                    com.baidu.navisdk.model.datastruct.destrec.f fVar = E.get(0);
                    IIX0o.oO(fVar, "it[0]");
                    str3 = fVar.j();
                }
                this.u = str3;
            }
            a(str, arrayList, z2, z3, this.u, z4);
        }
        if (!z) {
            J();
        }
        f(this.u);
        this.r = true;
    }

    private final void a(String str, ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> arrayList, boolean z, boolean z2, String str2, boolean z3) {
        ((com.baidu.navisdk.pronavi.ui.base.b) this.i).j().e("RGSaveParkComponent").a(10002).a();
        ((com.baidu.navisdk.pronavi.ui.base.b) this.i).j().e("RGChargeStationListComponent").a(4002).a();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().k(false);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGParkingLotListComponent", bn.b.V);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("38.0.21.1466", z3 ? "0" : "1");
        if (this.p == null) {
            a(str, arrayList, z3);
        }
        boolean b2 = com.baidu.navisdk.ui.routeguide.utils.b.b("parkingLotList", false);
        if (gVar.d()) {
            gVar.e("RGParkingLotListComponent", "showParkingLotListView : exitHDNavi: " + b2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = this.p;
        if (cVar != null) {
            cVar.f(str);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar2 = this.p;
        if (cVar2 != null) {
            cVar2.y();
        }
        e(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> arrayList, boolean z) {
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            JSONObject jSONObject = new JSONObject();
            com.baidu.navisdk.model.datastruct.destrec.f fVar = arrayList.get(i2);
            IIX0o.oO(fVar, "dataList[i]");
            jSONObject.put("name", fVar.g());
            jSONArray.put(jSONObject);
        }
        String str = z ? "为您找到以下停车场，是否切换" : "目的地停车场已满，推荐终点更多停车场，是否切换";
        com.baidu.navisdk.asr.d.B().a(str, a("park_intention", jSONArray, "park_select", str), (com.baidu.navisdk.asr.i.b) new h(z), false);
    }

    @OOXIXo
    public final String a(@OOXIXo String intention, @OOXIXo JSONArray listArray, @OOXIXo String prodType, @OOXIXo String playText) {
        IIX0o.x0xO0oo(intention, "intention");
        IIX0o.x0xO0oo(listArray, "listArray");
        IIX0o.x0xO0oo(prodType, "prodType");
        IIX0o.x0xO0oo(playText, "playText");
        com.baidu.navisdk.asr.model.c a2 = com.baidu.navisdk.module.asr.c.a().b((Object) intention).c(listArray).h(prodType).a(playText);
        com.baidu.navisdk.module.asr.model.a.a(a2);
        String a3 = a2.a();
        IIX0o.oO(a3, "upload.build()");
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.baidu.navisdk.model.datastruct.destrec.c cVar) {
        com.baidu.navisdk.model.datastruct.b f2;
        this.t.clear(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER);
        ArrayList<com.baidu.navisdk.model.datastruct.b> a2 = cVar.a();
        for (com.baidu.navisdk.model.datastruct.destrec.f fVar : cVar.b()) {
            if (TextUtils.equals(fVar.a(), "当前终点") && (f2 = fVar.f()) != null) {
                f2.b(0);
            }
        }
        if (a2.isEmpty()) {
            F();
            return;
        }
        this.t.setDataSet(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER, a2);
        this.t.showAll(BNDynamicOverlay.Key.ACE_REC_PARK_LAYER);
        com.baidu.navisdk.util.statistic.userop.b.r().b("38.0.21.1464");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@oOoXoXO Configuration configuration) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n0;
        super.a(configuration);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = this.p;
        if (cVar != null) {
            com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) n();
            IIX0o.oO(context, "context");
            ViewGroup H = context.H();
            ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> arrayList = null;
            Integer valueOf = configuration != null ? Integer.valueOf(configuration.orientation) : null;
            IIX0o.ooOOo0oXI(valueOf);
            int intValue = valueOf.intValue();
            com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar2 = this.p;
            if (cVar2 != null && (n0 = cVar2.n0()) != null) {
                arrayList = n0.b();
            }
            cVar.a(H, intValue, arrayList);
            if (cVar.a()) {
                cVar.y();
            } else {
                cVar.c();
            }
        }
        if (this.r) {
            f(this.u);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(String str, ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> arrayList, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGParkingLotListComponent", "init");
        }
        com.baidu.navisdk.pronavi.ui.base.b context = (com.baidu.navisdk.pronavi.ui.base.b) n();
        IIX0o.oO(context, "context");
        Context a2 = context.a();
        com.baidu.navisdk.pronavi.ui.base.b context2 = (com.baidu.navisdk.pronavi.ui.base.b) n();
        IIX0o.oO(context2, "context");
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = new com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c(a2, context2.H(), arrayList, z, new c(z), null, 0, 96, null);
        this.p = cVar;
        cVar.b(new d(z));
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar2 = this.p;
        if (cVar2 != null) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c.a(cVar2, false, null, 3, null);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar3 = this.p;
        if (cVar3 != null) {
            cVar3.f(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z, int i2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a aVar;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n0;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = this.p;
        ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> b2 = (cVar == null || (n0 = cVar.n0()) == null) ? null : n0.b();
        if (b2 != null && (aVar = b2.get(i2)) != null) {
            aVar.a(z);
        }
        if (!z || b2 == null || b2.size() <= 0) {
            return;
        }
        int size = b2.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 != i2) {
                b2.get(i3).a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> arrayList, String str) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n0;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n02;
        ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> a2;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b n03;
        ArrayList<com.baidu.navisdk.model.datastruct.destrec.f> a3;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar = this.p;
        if (cVar != null && (n03 = cVar.n0()) != null && (a3 = n03.a()) != null) {
            a3.clear();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar2 = this.p;
        if (cVar2 != null && (n02 = cVar2.n0()) != null && (a2 = n02.a()) != null) {
            a2.addAll(arrayList);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.c cVar3 = this.p;
        if (cVar3 != null && (n0 = cVar3.n0()) != null) {
            n0.notifyDataSetChanged();
        }
        e(str);
    }
}
