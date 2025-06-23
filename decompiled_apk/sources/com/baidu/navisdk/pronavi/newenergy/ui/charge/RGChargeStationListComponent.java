package com.baidu.navisdk.pronavi.newenergy.ui.charge;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.j;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.ui.chargelist.data.beans.e;
import com.baidu.navisdk.ui.chargelist.f;
import com.baidu.navisdk.ui.chargelist.interfaces.b;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.garmin.fit.OxXXx0X;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class RGChargeStationListComponent extends RGUiComponent<com.baidu.navisdk.pronavi.newenergy.a> implements com.baidu.navisdk.ui.chargelist.interfaces.b {

    @OOXIXo
    public static final a s = new a(null);
    private f p;
    private Bundle q;
    private com.baidu.navisdk.ui.util.a r;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b() {
            int e = com.baidu.navisdk.pronavi.util.a.h.e();
            com.baidu.navisdk.module.newguide.a e2 = com.baidu.navisdk.module.newguide.a.e();
            IIX0o.oO(e2, "RGNewOldFuncController.getInstance()");
            int c = e - e2.c();
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            com.baidu.navisdk.ui.routeguide.navicenter.impl.d r = V.r();
            IIX0o.oO(r, "BNavigator.getInstance().uiAction");
            if (r.g()) {
                return c - com.baidu.navisdk.ui.routeguide.utils.b.r();
            }
            return c;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }

        public final int a() {
            return com.baidu.navisdk.pronavi.util.a.h.d() / 2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGChargeStationListComponent.this).g, "mContentView: setOnClickListener");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7810a = new c();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends com.baidu.navisdk.ui.util.a {
        public d(long j) {
            super(j);
        }

        @Override // com.baidu.navisdk.ui.util.a
        public void onFinish() {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGChargeStationListComponent(@OOXIXo com.baidu.navisdk.pronavi.newenergy.a context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    private final void C() {
        com.baidu.navisdk.asr.d B;
        if (this.k == null) {
            com.baidu.navisdk.ui.routeguide.asr.c n = com.baidu.navisdk.ui.routeguide.asr.c.n();
            IIX0o.oO(n, "RGAsrProxy.getInstance()");
            if (n.i()) {
                com.baidu.navisdk.ui.routeguide.asr.c n2 = com.baidu.navisdk.ui.routeguide.asr.c.n();
                IIX0o.oO(n2, "RGAsrProxy.getInstance()");
                if (n2.d() && (B = com.baidu.navisdk.asr.d.B()) != null) {
                    B.c();
                }
            }
        }
    }

    private final int D() {
        return Math.max(0, com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.f());
    }

    private final int E() {
        if (j.d()) {
            return com.baidu.navisdk.ui.routeguide.utils.b.n();
        }
        return BNSettingManager.getViaPointCount();
    }

    private final boolean F() {
        View mContentView = this.k;
        if (mContentView != null) {
            IIX0o.oO(mContentView, "mContentView");
            if (mContentView.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    private final void G() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "showMoreMaxViaPointTip: ");
        }
        if (j.d()) {
            com.baidu.navisdk.framework.a c2 = com.baidu.navisdk.framework.a.c();
            IIX0o.oO(c2, "BNContextManager.getInstance()");
            TipTool.onCreateToastDialog(c2.a(), com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(E())));
        } else {
            com.baidu.navisdk.framework.a c3 = com.baidu.navisdk.framework.a.c();
            IIX0o.oO(c3, "BNContextManager.getInstance()");
            TipTool.onCreateToastDialog(c3.a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_over));
        }
    }

    private final void H() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "startAutoHideTime: ");
        }
        com.baidu.navisdk.ui.util.a aVar = this.r;
        if (aVar != null) {
            aVar.cancel();
        }
        d dVar = new d(10000L);
        this.r = dVar;
        dVar.start();
    }

    private final void I() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "stopAutoHideTime: ");
        }
        com.baidu.navisdk.ui.util.a aVar = this.r;
        if (aVar != null) {
            aVar.cancel();
        }
        this.r = null;
    }

    private final void c(int i) {
        if (this.k == null) {
            C mContext = this.i;
            IIX0o.oO(mContext, "mContext");
            View x = ((com.baidu.navisdk.pronavi.newenergy.a) mContext).x();
            IIX0o.oO(x, "mContext.upperUiRootView");
            View findViewById = x.findViewById(R.id.navi_rg_new_energy_charge_list_stub);
            if (!(findViewById instanceof ViewStub)) {
                findViewById = null;
            }
            ViewStub viewStub = (ViewStub) findViewById;
            try {
                if (viewStub != null) {
                    x = viewStub.inflate();
                } else {
                    x = x.findViewById(R.id.navi_rg_new_energy_charge_list_layout);
                }
            } catch (Exception e) {
                g gVar = g.PRO_NAV;
                if (gVar.c()) {
                    gVar.c(this.g, "initView: " + e);
                }
                x = x.findViewById(R.id.navi_rg_new_energy_charge_list_layout);
            }
            this.k = x;
        }
        View mContentView = this.k;
        if (mContentView != null) {
            IIX0o.oO(mContentView, "mContentView");
            ViewGroup.LayoutParams layoutParams = mContentView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.height = b(i);
                if (i == 2) {
                    com.baidu.navisdk.ui.routeguide.mapmode.subview.a c2 = com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c();
                    IIX0o.oO(c2, "DisplayCutoutManager.getInstance()");
                    int a2 = c2.a();
                    int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_left);
                    marginLayoutParams.leftMargin = a2 + dimensionPixelSize;
                    marginLayoutParams.width = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_land_left_panel_width_new) - (dimensionPixelSize * 2);
                } else {
                    marginLayoutParams.width = -1;
                }
                this.k.setOnClickListener(new b());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    private final void d(String str) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "cancelBubble: " + str);
        }
        if (str == null || str.length() == 0) {
            return;
        }
        BNMapController.getDynamicOverlay().cancelFocusIdsBySid(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE, str);
        Bundle bundle = this.q;
        if (bundle != null) {
            bundle.remove("uid");
        }
    }

    private final void e(e eVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "removeViaNode: " + eVar);
        }
        if (eVar == null) {
            return;
        }
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        com.baidu.navisdk.poisearch.model.b m = com.baidu.navisdk.poisearch.model.b.m();
        IIX0o.oO(m, "BNPickPointModel.getInstance()");
        m.a(new GeoPoint(eVar.m()));
        x.b().s4();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent
    public void A() {
        super.A();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "handlerYawing: ");
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void b(@OOXIXo e stationWrapper) {
        IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        b.a.a((com.baidu.navisdk.ui.chargelist.interfaces.b) this, stationWrapper);
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        I();
        f fVar = this.p;
        if (fVar != null) {
            fVar.f();
        }
        f fVar2 = this.p;
        if (fVar2 != null) {
            fVar2.c();
        }
        this.p = null;
        this.q = null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGChargeStationListComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public boolean p() {
        return false;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    @OOXIXo
    public String[] t() {
        return new String[]{PrerollVideoResponse.NORMAL};
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@oOoXoXO Configuration configuration) {
        super.a(configuration);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onConfigurationChanged: " + configuration);
        }
        f fVar = this.p;
        if (fVar != null) {
            IIX0o.ooOOo0oXI(fVar);
            fVar.c();
        }
        this.k = null;
        if (this.q != null) {
            a(new Bundle(this.q), this.m, true);
        }
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void b(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.b chargeWrapper) {
        IIX0o.x0xO0oo(chargeWrapper, "chargeWrapper");
        b.a.a(this, chargeWrapper);
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    @oOoXoXO
    public View b(int i, @oOoXoXO View view) {
        g gVar = g.PRO_NAV;
        if (!gVar.d()) {
            return null;
        }
        gVar.e(this.g, "onContentViewCreate: ");
        return null;
    }

    private final void b(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "hideList:" + z);
        }
        I();
        this.q = null;
        BNMapController.getDynamicOverlay().cancelFocusAll(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE);
        BNMapController.getDynamicOverlay().cancelZoom(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE);
        f fVar = this.p;
        if (fVar != null) {
            fVar.a(z);
            fVar.e();
        }
        this.p = null;
    }

    private final void d(e eVar) {
        boolean c2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "addViaNode: " + eVar);
        }
        if (eVar == null) {
            return;
        }
        String f = eVar.f();
        if (f != null && f.length() != 0) {
            c2 = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.a(f);
        } else {
            c2 = eVar.m() != null ? com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.c(eVar.m()) : false;
        }
        if (c2) {
            com.baidu.navisdk.framework.a c3 = com.baidu.navisdk.framework.a.c();
            IIX0o.oO(c3, "BNContextManager.getInstance()");
            TipTool.onCreateToastDialog(c3.a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_has_been_add_via));
            return;
        }
        String p = eVar.p();
        GeoPoint geoPoint = eVar.m() != null ? new GeoPoint(eVar.m()) : null;
        com.baidu.navisdk.module.nearbysearch.model.a aVar = new com.baidu.navisdk.module.nearbysearch.model.a();
        aVar.setName(p);
        aVar.setGeoPoint(geoPoint);
        aVar.setUID(f);
        aVar.setIconType(1);
        aVar.b(IBNRouteResultManager.NearbySearchKeyword.Charging_Station);
        com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
        ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e = bVar.e();
        IIX0o.oO(e, "BNApproachPoiManager.INS…E.unPassedApproachPoiList");
        if (gVar.d()) {
            gVar.e(this.g, "showAroundNeCsPoint --> onConfirmBtnClick() -->viaNodeList.size = " + e.size());
        }
        if (j.d()) {
            int n = com.baidu.navisdk.ui.routeguide.utils.b.n();
            if (e.size() >= n) {
                if (gVar.d()) {
                    gVar.e(this.g, "showAroundNeCsPoint --> 途经点数量大于" + n + " 个，直接返回！！！");
                }
                com.baidu.navisdk.framework.a c4 = com.baidu.navisdk.framework.a.c();
                IIX0o.oO(c4, "BNContextManager.getInstance()");
                TipTool.onCreateToastDialog(c4.a(), com.baidu.navisdk.ui.util.b.a(R.string.nsdk_string_rg_max_add_via_exceeded, Integer.valueOf(n)));
                return;
            }
        } else if (e.size() >= BNSettingManager.getViaPointCount()) {
            if (g.c0) {
                g.OPEN_SDK.f(this.g, "showAroundNeCsPoint --> " + BNSettingManager.getViaPointCount());
            }
            com.baidu.navisdk.framework.a c5 = com.baidu.navisdk.framework.a.c();
            IIX0o.oO(c5, "BNContextManager.getInstance()");
            TipTool.onCreateToastDialog(c5.a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_over));
            return;
        }
        BNRoutePlaner.getInstance().h(1);
        a0.G = 1;
        bVar.a(aVar, false);
        Bundle bundle = new Bundle();
        bundle.putBoolean("smart_sort_via", true);
        l.l().a(geoPoint, p, f, 1, bundle);
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "execute: " + api);
        }
        switch (api.d()) {
            case 4001:
                C();
                a((Bundle) api.a("paramA", (String) null), this.m, false);
                break;
            case 4002:
                a(this, false, 1, null);
                break;
            case 4003:
                return h.a().a(Boolean.valueOf(F()));
        }
        return super.a(api);
    }

    private final int b(int i) {
        if (i == 2) {
            return s.b();
        }
        return s.a();
    }

    public static /* synthetic */ void a(RGChargeStationListComponent rGChargeStationListComponent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        rGChargeStationListComponent.b(z);
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void b() {
        G();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(@androidx.annotation.Nullable android.os.Bundle r8, int r9, boolean r10) {
        /*
            r7 = this;
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r1 = r0.d()
            if (r1 == 0) goto L2d
            java.lang.String r1 = r7.g
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "showList: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = ", "
            r2.append(r3)
            r2.append(r9)
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r0.e(r1, r2)
        L2d:
            if (r8 != 0) goto L30
            return
        L30:
            android.os.Bundle r0 = r7.q
            if (r0 != 0) goto L3c
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r7.q = r0
            goto L42
        L3c:
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
            r0.clear()
        L42:
            android.os.Bundle r0 = r7.q
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
            r0.putAll(r8)
            r7.c(r9)
            com.baidu.navisdk.ui.chargelist.f r8 = r7.p
            if (r8 != 0) goto L76
            com.baidu.navisdk.ui.chargelist.f r8 = new com.baidu.navisdk.ui.chargelist.f
            C extends com.baidu.navisdk.context.business.a r9 = r7.i
            java.lang.String r0 = "mContext"
            kotlin.jvm.internal.IIX0o.oO(r9, r0)
            com.baidu.navisdk.pronavi.newenergy.a r9 = (com.baidu.navisdk.pronavi.newenergy.a) r9
            android.app.Activity r1 = r9.e()
            java.lang.String r9 = "mContext.activity"
            kotlin.jvm.internal.IIX0o.oO(r1, r9)
            int r4 = r7.D()
            int r5 = r7.E()
            r3 = 0
            r6 = 0
            r2 = 2
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.p = r8
        L76:
            android.os.Bundle r8 = r7.q
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r8)
            java.lang.String r9 = "uid"
            r0 = 0
            java.lang.String r8 = r8.getString(r9, r0)
            android.os.Bundle r9 = r7.q
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r9)
            java.lang.String r0 = "src"
            r1 = 0
            int r9 = r9.getInt(r0, r1)
            com.baidu.navisdk.ui.chargelist.f r0 = r7.p
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
            android.view.ViewGroup r1 = r0.getParentView()
            boolean r1 = r1 instanceof android.view.ViewGroup
            if (r1 == 0) goto Lb7
            boolean r1 = r0.d()
            if (r1 == 0) goto La8
            boolean r9 = r0.a(r8)
            goto Lca
        La8:
            android.view.ViewGroup r1 = r0.getParentView()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r7.a(r1, r8, r9)
            goto Lc9
        Lb7:
            android.view.View r1 = r7.k
            if (r1 == 0) goto Ldb
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            com.baidu.navisdk.ui.chargelist.f r2 = r7.p
            r1.addView(r2)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r7.a(r1, r8, r9)
        Lc9:
            r9 = 1
        Lca:
            r0.a(r7)
            com.baidu.navisdk.pronavi.newenergy.ui.charge.RGChargeStationListComponent$c r1 = com.baidu.navisdk.pronavi.newenergy.ui.charge.RGChargeStationListComponent.c.f7810a
            r0.setBackBtnClickListener(r1)
            r7.a(r8, r9)
            if (r10 != 0) goto Lda
            r7.H()
        Lda:
            return
        Ldb:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type android.widget.FrameLayout"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.newenergy.ui.charge.RGChargeStationListComponent.a(android.os.Bundle, int, boolean):void");
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void c(@OOXIXo e stationWrapper) {
        IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        d(stationWrapper);
    }

    private final void a(ViewGroup viewGroup, String str, Integer num) {
        f fVar = this.p;
        if (fVar != null) {
            fVar.a(viewGroup);
        }
        f fVar2 = this.p;
        if (fVar2 != null) {
            com.baidu.navisdk.ui.routeguide.model.d g = com.baidu.navisdk.ui.routeguide.model.d.g();
            IIX0o.oO(g, "RGChargeStationModel.getInstance()");
            com.baidu.navisdk.model.datastruct.chargestation.e b2 = g.b();
            BNRouteGuider bNRouteGuider = BNRouteGuider.getInstance();
            IIX0o.oO(bNRouteGuider, "BNRouteGuider.getInstance()");
            fVar2.a(str, b2, bNRouteGuider.getAddDist(), true);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.11.0", String.valueOf(num), "1", "0");
    }

    private final void a(String str, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "zoomMapBubble: " + str + ", " + z);
        }
        BNMapController.getDynamicOverlay().showAll(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE);
        if (z && str != null && str.length() != 0) {
            BNMapController.getDynamicOverlay().focusIdsBySid(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE, str);
        } else {
            BNMapController.getDynamicOverlay().cancelFocusAll(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE);
        }
        if (str != null && str.length() != 0) {
            BNMapController.getDynamicOverlay().zoomBySid(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE, 3, new String[]{str}, new int[]{1});
        }
        BNMapController.getInstance().resetRouteDetailIndex();
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.module.pronavi.msg.c
    @OOXIXo
    public int[] a() {
        return new int[]{OxXXx0X.Xx0OXIoI};
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.module.pronavi.msg.c
    public void a(@oOoXoXO Message message) {
        super.a(message);
        Integer valueOf = message != null ? Integer.valueOf(message.what) : null;
        if (valueOf != null && valueOf.intValue() == 4432) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "MSG_NAVI_Type_DrivingRouteChange: ");
            }
            if (F()) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void a(@OOXIXo e stationWrapper) {
        IIX0o.x0xO0oo(stationWrapper, "stationWrapper");
        e(stationWrapper);
    }

    @Override // com.baidu.navisdk.ui.chargelist.interfaces.b
    public void a(@OOXIXo com.baidu.navisdk.ui.chargelist.data.beans.b chargeWrapper) {
        IIX0o.x0xO0oo(chargeWrapper, "chargeWrapper");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "selectedApproachNode: " + chargeWrapper);
        }
        if (chargeWrapper.g()) {
            Bundle bundle = this.q;
            if (bundle != null) {
                bundle.putString("uid", chargeWrapper.f());
            }
            a(chargeWrapper.f(), true);
            return;
        }
        d(chargeWrapper.f());
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule
    public void a(boolean z) {
        super.a(z);
        f fVar = this.p;
        if (fVar != null) {
            fVar.g();
        }
    }
}
