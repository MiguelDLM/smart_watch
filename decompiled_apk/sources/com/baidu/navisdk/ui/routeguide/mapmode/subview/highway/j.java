package com.baidu.navisdk.ui.routeguide.mapmode.subview.highway;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.module.newguide.widgets.ServiceAreaBaseRelativeLayout;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class j extends com.baidu.navisdk.ui.routeguide.widget.d implements View.OnClickListener, com.baidu.navisdk.ui.routeguide.mapmode.iview.f, com.baidu.navisdk.framework.interfaces.pronavi.hd.b {
    private boolean A;
    private boolean B;
    private boolean C;
    private com.baidu.navisdk.pronavi.style.i.a D;
    private final com.baidu.navisdk.util.worker.f<String, String> E;
    private ViewGroup i;
    private View j;
    private ServiceAreaBaseRelativeLayout k;
    private ViewGroup l;
    private ViewGroup m;
    private View n;
    private g o;
    private h p;
    private f q;
    private d r;
    private e s;
    private f t;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.c u;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a v;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a w;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b x;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b y;
    private final com.baidu.navisdk.ui.routeguide.mapmode.presenter.f z;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            j.this.P();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b(j jVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "updateDestArrivalTimeMarginTop(), handleArrivalTimeViewCollision");
            }
            x.b().v0();
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.pronavi.style.c {
        public c(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGHighwayServiceArea";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(@oOoXoXO String str) {
            j.this.E0();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            b(j.this.l);
            b(j.this.m);
        }
    }

    public j(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.n = null;
        this.A = false;
        this.B = false;
        this.C = false;
        this.E = new a("RGHighwayServiceAreaView-mAutoClearTipsTask", null);
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            this.C = k.p0();
        }
        this.B = x.b().G2();
        this.z = new com.baidu.navisdk.ui.routeguide.mapmode.presenter.f(this);
        ViewGroup viewGroup2 = this.b;
        if (viewGroup2 != null) {
            this.i = viewGroup2;
            boolean d = com.baidu.navisdk.module.newguide.a.e().d();
            A(d);
            u0();
            B(d);
        } else {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "initView-> mRootViewGroup == null!!!");
            }
        }
        z(this.C);
    }

    private void A(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "addRootView->" + z);
        }
        if (this.j == null || z) {
            if (A0()) {
                if (gVar.d()) {
                    gVar.e("RGHighwayServiceAreaView", "addRootView isNeedMinLayout: ");
                }
                this.j = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_highway_service_area, null);
            } else {
                this.j = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_highway_new_service_area, null);
            }
        }
        if (this.j.getParent() != null) {
            ((ViewGroup) this.j.getParent()).removeView(this.j);
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.i.addView(this.j);
        }
    }

    private boolean A0() {
        if (!o0() && com.baidu.navisdk.module.newguide.a.e().d()) {
            return com.baidu.navisdk.ui.routeguide.utils.b.c(com.baidu.navisdk.ui.routeguide.utils.b.o().f6817a);
        }
        return true;
    }

    private void B0() {
        com.baidu.navisdk.pronavi.style.i.b g;
        if (this.D != null && (g = com.baidu.navisdk.ui.routeguide.utils.b.g()) != null) {
            g.b("RGServiceArea", this.D);
        }
    }

    public static int C(boolean z) {
        if (z) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_108dp);
        }
        com.baidu.navisdk.module.pronavi.model.f n = com.baidu.navisdk.ui.routeguide.b.V().n();
        if (n != null && n.m()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_140dp);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_service_area_panel_max_width);
    }

    private void C0() {
        com.baidu.navisdk.pronavi.style.i.a aVar = this.D;
        if (aVar == null) {
            c cVar = new c(new Integer[0]);
            this.D = cVar;
            com.baidu.navisdk.pronavi.style.f.b.a("RGServiceArea", cVar);
        } else {
            aVar.b("RGBgAlpha", this.l);
            this.D.b("RGBgAlpha", this.m);
            this.D.b(this.l);
            this.D.b(this.m);
        }
    }

    private void D(boolean z) {
        if (this.m == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setBottomDirectionBoardVisibility-> isShow= " + z + ",mServiceAreaBottomLayout == null,return!");
                return;
            }
            return;
        }
        if (z) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHighwayServiceAreaView", "setBottomDirectionBoardVisibility-> mBottomDirectionBoardView= " + this.w + ", mServiceAreaBottomLayout = " + this.m);
            }
            if (this.w == null) {
                com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a aVar = new com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a(this.f9165a, 1, this.f);
                this.w = aVar;
                a(this.m, aVar.e(), this.w.j());
            }
            this.w.e().setVisibility(0);
            this.y = this.w;
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a aVar2 = this.w;
        if (aVar2 != null) {
            aVar2.e().setVisibility(8);
            this.m.removeView(this.w.e());
            this.w = null;
        }
    }

    private void D0() {
        if (x.b().s2() && com.baidu.navisdk.ui.routeguide.utils.b.y()) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().g();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "显示高速看板时设置路况条的高度 resetRoadConditionBarTop --> ");
            }
        }
    }

    private void E(boolean z) {
        if (z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setBottomExitAreaVisibility-> mBottomExitAreaView= " + this.t + ", mServiceAreaBottomLayout = " + this.m);
            }
            ViewGroup viewGroup = this.m;
            if (viewGroup != null) {
                if (this.t == null) {
                    f fVar = new f(viewGroup, this.f, this.f9165a, 1);
                    this.t = fVar;
                    a(this.m, fVar.e(), this.t.j());
                }
                this.t.e().setVisibility(0);
                this.y = this.t;
                return;
            }
            return;
        }
        f fVar2 = this.t;
        if (fVar2 != null) {
            fVar2.e().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        Drawable background;
        Drawable background2;
        ViewGroup viewGroup = this.l;
        if (viewGroup != null && (background2 = viewGroup.getBackground()) != null) {
            background2.setAlpha(255);
        }
        ViewGroup viewGroup2 = this.m;
        if (viewGroup2 != null && (background = viewGroup2.getBackground()) != null) {
            background.setAlpha(255);
        }
    }

    private void F(boolean z) {
        if (z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setBottomServiceAreaView-> mBottomServiceAreaView= " + this.u + ", mServiceAreaBottomLayout = " + this.m);
            }
            if (this.m != null) {
                if (this.u == null) {
                    com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.c cVar = new com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.c(this.f9165a, this.f);
                    this.u = cVar;
                    a(this.m, cVar.e(), this.u.j());
                }
                this.u.e().setVisibility(0);
                this.y = this.u;
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.c cVar2 = this.u;
        if (cVar2 != null) {
            cVar2.e().setVisibility(8);
        }
    }

    private void F0() {
        if (RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getTopState())) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }
        x.b().T3();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.3.1", null, null, null);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar = this.x;
        if (bVar != null && b(bVar.b())) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.3.4", "2", null, null);
        }
    }

    private void G(boolean z) {
        if (z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setNormalTopViewVisibility-> mChangeServiceView= " + this.r + ", mServiceAreaTopLayout = " + this.l);
            }
            if (this.l != null) {
                if (this.r == null) {
                    d dVar = new d(this.f9165a, this.f);
                    this.r = dVar;
                    a(this.l, dVar.e(), this.r.j());
                }
                this.r.e().setVisibility(0);
                this.x = this.r;
                return;
            }
            return;
        }
        d dVar2 = this.r;
        if (dVar2 != null) {
            dVar2.e().setVisibility(8);
        }
    }

    private void G0() {
        if (w0()) {
            P();
            F0();
        }
    }

    private void H(boolean z) {
        if (z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setNormalTopViewVisibility-> mChangeView= " + this.s + ", mServiceAreaTopLayout = " + this.l);
            }
            if (this.l != null) {
                if (this.s == null) {
                    e eVar = new e(this.f9165a, this.f);
                    this.s = eVar;
                    a(this.l, eVar.e(), this.s.j());
                }
                this.s.e().setVisibility(0);
                this.x = this.s;
                return;
            }
            return;
        }
        e eVar2 = this.s;
        if (eVar2 != null) {
            eVar2.e().setVisibility(8);
        }
    }

    private void H0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "switchPanelStyle: ");
        }
        r0();
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (this.j != null) {
            boolean d = com.baidu.navisdk.module.newguide.a.e().d();
            A(d);
            u0();
            B(d);
        }
        if (a() && x0()) {
            if (this.i != null) {
                v(0);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.presenter.f fVar = this.z;
            if (fVar != null) {
                fVar.k();
            }
        }
    }

    private void I(boolean z) {
        if (z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setSingleTypeTopViewVisibility-> mSingleTypeServiceAreaView= " + this.p + ", mServiceAreaTopLayout = " + this.l);
            }
            if (this.l != null) {
                if (this.p == null) {
                    h hVar = new h(this.f9165a, this.f);
                    this.p = hVar;
                    a(this.l, hVar.e(), this.p.j());
                }
                this.p.e().setVisibility(0);
                this.x = this.p;
                return;
            }
            return;
        }
        h hVar2 = this.p;
        if (hVar2 != null) {
            hVar2.e().setVisibility(8);
        }
    }

    private void I0() {
        ServiceAreaBaseRelativeLayout serviceAreaBaseRelativeLayout;
        if (!x.b().s2() && (serviceAreaBaseRelativeLayout = this.k) != null) {
            serviceAreaBaseRelativeLayout.post(new b(this));
        }
    }

    private void J(boolean z) {
        if (this.l == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setTopDirectionBoradVisibility-> isShow= " + z + ",mServiceAreaTopLayout == null,return!");
                return;
            }
            return;
        }
        if (z) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHighwayServiceAreaView", "setTopDirectionBoradVisibility-> mTopDirectionBoardView= " + this.v + ", mServiceAreaTopLayout = " + this.l);
            }
            if (this.v == null) {
                com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a aVar = new com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a(this.f9165a, 0, this.f);
                this.v = aVar;
                a(this.l, aVar.e(), this.v.j());
            }
            this.v.e().setVisibility(0);
            this.x = this.v;
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.e().setVisibility(8);
            this.l.removeView(this.v.e());
            this.v = null;
        }
    }

    private void K(boolean z) {
        if (z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setTopExitAreaVisibility-> mTopExitAreaView= " + this.q + ", mServiceAreaTopLayout = " + this.l);
            }
            ViewGroup viewGroup = this.l;
            if (viewGroup != null) {
                if (this.q == null) {
                    f fVar = new f(viewGroup, this.f, this.f9165a, 0);
                    this.q = fVar;
                    a(this.l, fVar.e(), this.q.j());
                }
                this.q.e().setVisibility(0);
                this.x = this.q;
                return;
            }
            return;
        }
        f fVar2 = this.q;
        if (fVar2 != null) {
            fVar2.e().setVisibility(8);
        }
    }

    private void d(int i, int i2) {
        a(i, i2, true);
    }

    private void r0() {
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ViewGroup viewGroup2 = this.m;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
        }
        g gVar = this.o;
        if (gVar != null) {
            gVar.a();
            this.o = null;
        }
        e eVar = this.s;
        if (eVar != null) {
            eVar.a();
            this.s = null;
        }
        d dVar = this.r;
        if (dVar != null) {
            dVar.a();
            this.r = null;
        }
        h hVar = this.p;
        if (hVar != null) {
            hVar.a();
            this.p = null;
        }
        f fVar = this.q;
        if (fVar != null) {
            fVar.a();
            this.q = null;
        }
        f fVar2 = this.t;
        if (fVar2 != null) {
            fVar2.a();
            this.t = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.c cVar = this.u;
        if (cVar != null) {
            cVar.a();
            this.u = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
            this.v = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.a aVar2 = this.w;
        if (aVar2 != null) {
            aVar2.a();
            this.w = null;
        }
        this.x = null;
        this.y = null;
    }

    private int s0() {
        if (z0()) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_108dp);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_service_area_panel_min_width);
    }

    private boolean t0() {
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && !com.baidu.navisdk.ui.routeguide.b.V().i().c().m().isEmpty()) {
            return true;
        }
        return false;
    }

    private void u0() {
        this.k = (ServiceAreaBaseRelativeLayout) this.j.findViewById(R.id.bnavi_hw_service_area_content_layout);
        this.l = (ViewGroup) this.j.findViewById(R.id.bnavi_hw_service_area_top_layout);
        this.m = (ViewGroup) this.j.findViewById(R.id.bnavi_hw_service_area_bottom_layout);
        this.n = this.j.findViewById(R.id.bnavi_hw_service_area_first_tips);
        this.k.setMinWidth(s0());
        this.k.setMaxWidth(C(z0()));
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        View view = this.n;
        if (view != null) {
            view.setOnClickListener(this);
        }
        C0();
    }

    private boolean w0() {
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "ServiceAreaView onClick-> 当前是模拟导航，不可点击！");
            }
            return false;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar = this.x;
        if (bVar != null && bVar.b().p() == 1000 && !t0()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHighwayServiceAreaView", "ServiceAreaView onClick-> 方向看板正在显示，且没有高速数据，不可点击！");
            }
            return false;
        }
        return true;
    }

    private boolean x0() {
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && com.baidu.navisdk.ui.routeguide.b.V().i().c().s()) {
            return true;
        }
        return false;
    }

    private boolean y0() {
        com.baidu.navisdk.module.pronavi.model.d b2;
        com.baidu.navisdk.model.datastruct.chargestation.b bVar;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar2 = this.x;
        if (bVar2 == null) {
            b2 = null;
        } else {
            b2 = bVar2.b();
        }
        if (b2 == null) {
            return false;
        }
        if ((b2.p() != 7 && b2.p() != 6) || (bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) b2.a("charge_station_info")) == null) {
            return false;
        }
        return !TextUtils.isEmpty(bVar.l());
    }

    private boolean z0() {
        if (o0()) {
            return false;
        }
        return com.baidu.navisdk.ui.routeguide.utils.b.c(h0().f6817a);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        View[] viewArr = new View[2];
        ServiceAreaBaseRelativeLayout serviceAreaBaseRelativeLayout = this.k;
        if (serviceAreaBaseRelativeLayout != null && serviceAreaBaseRelativeLayout.isShown()) {
            viewArr[0] = this.k;
        }
        View view = this.n;
        if (view != null && view.isShown()) {
            viewArr[1] = this.n;
        }
        return viewArr;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.f
    public Rect L() {
        Rect rect = new Rect();
        ServiceAreaBaseRelativeLayout serviceAreaBaseRelativeLayout = this.k;
        if (serviceAreaBaseRelativeLayout != null) {
            serviceAreaBaseRelativeLayout.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.f
    public void P() {
        View view = this.n;
        if (view != null && view.getVisibility() == 0) {
            this.n.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.f
    public void Q() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "recoverSecondPanel->");
        }
        this.B = false;
        if (this.x != null && this.y != null) {
            b(2, false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.f
    public void a0() {
        if (com.baidu.navisdk.module.pronavi.a.j == 2 || this.n == null) {
            return;
        }
        if (this.A) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGHighwayServiceAreaView", "showFirstGuideTip-> 本次导航已经展示了，不展示提示气泡");
                return;
            }
            return;
        }
        if (this.x != null && y0() && t0()) {
            int chargeAreaTipDisplayCount = BNSettingManager.getChargeAreaTipDisplayCount();
            if (chargeAreaTipDisplayCount >= 3) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGHighwayServiceAreaView", "showFirstGuideTip-> 展示次数大于3，不展示提示气泡");
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - BNSettingManager.getChargeAreaTipDisplayTime() <= 86400000) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGHighwayServiceAreaView", "showFirstGuideTip-> 展示间隔小于24小时，不展示提示气泡");
                    return;
                }
                return;
            } else {
                this.n.setVisibility(0);
                com.baidu.navisdk.util.worker.c.a().a(this.E, new com.baidu.navisdk.util.worker.e(2, 0), 5000L);
                BNSettingManager.setChargeAreaTipDisplay(chargeAreaTipDisplayCount + 1);
                BNSettingManager.setChargeAreaTipTime(currentTimeMillis);
                this.A = true;
                return;
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGHighwayServiceAreaView", "showFirstGuideTip-> 没有充电站相关数据，不展示提示气泡");
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void e(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "enterDoubleMap: " + i + "," + z);
        }
        if (this.i == null) {
            return;
        }
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "enterDoubleMap: " + this.i.getVisibility());
        }
        if (!z && i == 0) {
            H0();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void f(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "enterNormal: " + i + "," + z);
        }
        if (this.i == null) {
            return;
        }
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "enterNormal: " + this.i.getVisibility());
        }
        if (!z) {
            H0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void h() {
        if (a()) {
            v();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.x = null;
        this.y = null;
        this.o = null;
        this.r = null;
        this.s = null;
        this.p = null;
        this.q = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.B = false;
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.presenter.f n0() {
        return this.z;
    }

    public boolean o0() {
        if (this.f != 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bnavi_hw_service_area_first_tips) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGHighwayServiceAreaView", "ServiceAreaView onClick-> 点击气泡！");
            }
            G0();
        } else if (id == R.id.bnavi_hw_service_area_top_layout || id == R.id.bnavi_hw_service_area_bottom_layout) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "ServiceAreaView onClick-> 蓝绿看板！");
            }
            G0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void onResume() {
        super.onResume();
        if (a() && x0()) {
            v();
        }
    }

    public boolean p0() {
        boolean z;
        if (com.baidu.navisdk.module.vehiclemanager.b.i().f() && com.baidu.navisdk.module.vehiclemanager.b.i().a() == 0) {
            z = true;
        } else {
            z = false;
        }
        boolean a2 = com.baidu.navisdk.function.b.FUNC_SERVICE_AREA_EMPTY_PARKING_SPACE_INFO.a();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "isShowEmptyParkingSpaceInfoScene--> isCar-->" + z + ", FUNC_SERVICE_AREA_EMPTY_PARKING_SPACE_INFO is -->" + a2);
        }
        if (!z || !a2) {
            return false;
        }
        return true;
    }

    public boolean q0() {
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.f
    public void v() {
        if (this.k == null) {
            return;
        }
        x.b().I().k();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.f
    public void x() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "hideSecondPanel->");
        }
        this.B = true;
        if (this.x != null && this.y != null) {
            b(1, false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.C || !BNCommSettingManager.getInstance().isShowHighSpeedPanel()) {
            return false;
        }
        super.y();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("show-> mContainer == null ? ");
            sb.append(this.i == null);
            gVar.e("RGHighwayServiceAreaView", sb.toString());
        }
        if (this.i != null) {
            v(0);
            y(true);
        }
        x.b().Y2();
        this.z.k();
        return true;
    }

    public void z(boolean z) {
        this.C = z;
        if (z) {
            c();
        }
    }

    private void b(int i, boolean z) {
        if (i > 1) {
            a(0, 0, z);
            a(1, 0, z);
        } else if (i > 0) {
            a(0, 0, z);
            a(1, 8, z);
        } else {
            a(0, 8, z);
            a(1, 8, z);
        }
    }

    private boolean d(com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "switchSecondAreaViewStyle-> data = " + dVar.toString());
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar = this.y;
        if (bVar != null && bVar.b() != null && dVar.g().equals(this.y.b().g()) && dVar.h().equals(this.y.b().h()) && dVar.p() == this.y.b().p()) {
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "switchSecondAreaViewStyle-> 第二个服务区面板无变化，无需更新样式！");
            }
            return false;
        }
        int i = R.drawable.nsdk_drawable_rg_hw_bg_green_bottom;
        if (dVar.p() != 3 && dVar.p() != 2 && dVar.p() != 5) {
            if (dVar.p() == 1000) {
                F(false);
                E(false);
                D(true);
            } else {
                if (dVar.p() == 1) {
                    i = R.drawable.nsdk_drawable_rg_hw_bg_blue_bottom;
                }
                E(false);
                D(false);
                F(true);
            }
        } else {
            F(false);
            D(false);
            E(true);
        }
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(JarUtils.getResources().getDrawable(i));
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.f
    public void a(List<com.baidu.navisdk.module.pronavi.model.d> list) {
        if (this.l != null && this.m != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "updateNormalServiceAreaData-> serviceAreaData.size = " + list.size());
            }
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null && !k.m()) {
                Iterator<com.baidu.navisdk.module.pronavi.model.d> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().p() == 6) {
                        it.remove();
                    }
                }
            }
            if (list.size() > 1) {
                b(2, true);
                com.baidu.navisdk.module.pronavi.model.d dVar = list.get(0);
                boolean c2 = c(dVar);
                com.baidu.navisdk.module.pronavi.model.d dVar2 = list.get(1);
                boolean d = d(dVar2);
                r4 = c2 || d;
                B0();
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("updateNormalServiceAreaData-> mShowingTopPanel= ");
                    com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar = this.x;
                    sb.append(bVar == null ? "null" : bVar.d());
                    sb.append(",mShowingBottomPanel= ");
                    com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar2 = this.y;
                    sb.append(bVar2 != null ? bVar2.d() : "null");
                    sb.append(", isFirstPanelChanged=");
                    sb.append(c2);
                    sb.append(", isSecondPanelChanged=");
                    sb.append(d);
                    gVar2.e("RGHighwayServiceAreaView", sb.toString());
                }
                com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar3 = this.x;
                if (bVar3 != null && this.y != null) {
                    bVar3.d(dVar);
                    this.y.d(dVar2);
                }
            } else if (list.size() > 0) {
                b(1, true);
                com.baidu.navisdk.module.pronavi.model.d dVar3 = list.get(0);
                r4 = c(dVar3);
                B0();
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar3.d()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("updateNormalServiceAreaData-> mShowingTopPanel= ");
                    com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar4 = this.x;
                    sb2.append(bVar4 != null ? bVar4.d() : "null");
                    sb2.append(",isPanelChanged=");
                    sb2.append(r4);
                    gVar3.e("RGHighwayServiceAreaView", sb2.toString());
                }
                com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar5 = this.x;
                if (bVar5 != null) {
                    bVar5.d(dVar3);
                }
            } else if (this.l.getVisibility() != 8 || this.m.getVisibility() != 8) {
                b(0, true);
                r4 = true;
            }
            if (r4) {
                com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar4.d()) {
                    gVar4.e("RGHighwayServiceAreaView", "updateNormalServiceAreaData-> 面板数据发生改变，重现计算碰撞");
                }
                v();
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar5.d()) {
            gVar5.e("RGHighwayServiceAreaView", "updateNormalServiceAreaData-> mServiceAreaTopLayout == null || mServiceAreaBottomLayout == null,return!");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "hide-> isVisibility= " + a());
        }
        if (a()) {
            super.c();
            if (this.i != null) {
                v(8);
            }
            D0();
            d(0, 8);
            d(1, 8);
            I0();
        }
    }

    private void v(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "setContainerViewVisible: " + i);
        }
        if (o0() && com.baidu.navisdk.module.newguide.a.e().d()) {
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setContainerViewVisible: isUserNewSetting and isPortrait");
            }
        } else {
            ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                viewGroup.setVisibility(i);
            }
        }
    }

    private void B(boolean z) {
        if (j0() || !z || this.k == null || !A0()) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.k.getLayoutParams()).addRule(9, -1);
        this.k.requestLayout();
    }

    private boolean b(com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.module.pronavi.model.a aVar;
        return p0() && dVar != null && dVar.p() == 4 && dVar.r() && (aVar = (com.baidu.navisdk.module.pronavi.model.a) dVar.a("parking_lot_info")) != null && aVar.a() > 0;
    }

    public void y(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "setServiceAreaPanelEnable-> enable=" + z);
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.setEnabled(z);
        }
        ViewGroup viewGroup2 = this.m;
        if (viewGroup2 != null) {
            viewGroup2.setEnabled(z);
        }
    }

    private boolean c(com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "switchFirstAreaViewStyle-> data = " + dVar.toString());
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar = this.x;
        if (bVar != null && bVar.b() != null && dVar.g().equals(this.x.b().g()) && dVar.h().equals(this.x.b().h()) && dVar.p() == this.x.b().p() && b(dVar) == b(this.x.b())) {
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "switchFirstAreaViewStyle-> 第一个服务区面板无变化，无需更新样式！");
            }
            return false;
        }
        int i = R.drawable.nsdk_drawable_rg_hw_bg_green_top;
        if (dVar.p() == 1) {
            a(false, dVar);
            K(false);
            J(false);
            H(false);
            G(false);
            I(true);
            i = R.drawable.nsdk_drawable_rg_hw_bg_blue_top;
        } else if (dVar.p() != 3 && dVar.p() != 2 && dVar.p() != 5) {
            if (dVar.p() == 1000) {
                I(false);
                a(false, dVar);
                K(false);
                H(false);
                G(false);
                J(true);
            } else if (dVar.p() == 6) {
                K(false);
                I(false);
                J(false);
                a(false, dVar);
                G(false);
                H(true);
                i = R.drawable.nsdk_drawable_rg_hw_bg_blue_top;
            } else if (dVar.p() == 7) {
                K(false);
                I(false);
                J(false);
                a(false, dVar);
                H(false);
                G(true);
            } else if (dVar.o().size() > 1) {
                K(false);
                I(false);
                J(false);
                H(false);
                G(false);
                a(true, dVar);
            } else {
                a(false, dVar);
                K(false);
                J(false);
                H(false);
                G(false);
                I(true);
            }
        } else {
            I(false);
            a(false, dVar);
            J(false);
            H(false);
            G(false);
            K(true);
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(JarUtils.getResources().getDrawable(i));
        }
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void b(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "enterFullHD: " + i + "," + z);
        }
        if (this.i == null) {
            return;
        }
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "enterFullHD: " + this.i.getVisibility());
        }
        if (z || i != 0) {
            return;
        }
        H0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.f
    public int A() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        int c2 = (this.x == null || (viewGroup2 = this.l) == null || viewGroup2.getVisibility() != 0) ? 0 : this.x.c();
        return (this.y == null || (viewGroup = this.m) == null || viewGroup.getVisibility() != 0) ? c2 : c2 + this.y.c();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.f
    public void a(com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("changFirstServiceAreaStatus-> serviceAreaBean= ");
            sb.append(dVar.toString());
            sb.append(", mShowingTopPanel.getData= ");
            com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar = this.x;
            sb.append((bVar == null || bVar.b() == null) ? "null" : this.x.b().toString());
            gVar.e("RGHighwayServiceAreaView", sb.toString());
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b bVar2 = this.x;
        if (bVar2 == null || bVar2.b() == null || !this.x.b().g().equals(dVar.g())) {
            return;
        }
        this.z.k();
    }

    private void a(int i, int i2, boolean z) {
        ViewGroup viewGroup;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "setServiceAreaPanelVisibility-> panelType= " + i + ", visibility= " + i2 + ", isResetPanel= " + z + ", isSecondPanelTempHide= " + this.B);
        }
        if (i == 0) {
            ViewGroup viewGroup2 = this.l;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(i2);
                if (i2 != 0) {
                    this.x = null;
                    return;
                }
                return;
            }
            return;
        }
        if (i == 1 && (viewGroup = this.m) != null) {
            if (i2 == 0) {
                if (this.B) {
                    return;
                }
                viewGroup.setVisibility(0);
            } else {
                viewGroup.setVisibility(8);
                if (z) {
                    this.y = null;
                }
            }
        }
    }

    private void a(boolean z, com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.module.pronavi.model.a aVar;
        if (z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayServiceAreaView", "setNormalTopViewVisibility-> mNormalServiceAreaView= " + this.o + ", mServiceAreaTopLayout = " + this.l);
            }
            boolean z2 = p0() && dVar.r() && (aVar = (com.baidu.navisdk.module.pronavi.model.a) dVar.a("parking_lot_info")) != null && aVar.a() > 0;
            if (this.l != null) {
                g gVar2 = this.o;
                if (gVar2 == null) {
                    g gVar3 = new g(this.f9165a, this.f);
                    this.o = gVar3;
                    gVar3.a(z2);
                    a(this.l, this.o.e(), this.o.j());
                } else {
                    gVar2.a(z2);
                }
                this.o.e().setVisibility(0);
                this.x = this.o;
                return;
            }
            return;
        }
        g gVar4 = this.o;
        if (gVar4 != null) {
            gVar4.e().setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.f fVar;
        super.a(viewGroup, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayServiceAreaView", "orientationChanged-> isVisibility= " + a() + ", isCanShow= " + x0());
        }
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            r0();
        }
        if (this.j != null) {
            this.i = viewGroup;
            boolean d = com.baidu.navisdk.module.newguide.a.e().d();
            A(d);
            if (d) {
                u0();
                B(true);
            }
        }
        if (a() && x0()) {
            if (this.i != null) {
                v(0);
            }
            v();
            if (!com.baidu.navisdk.module.newguide.a.e().d() || (fVar = this.z) == null) {
                return;
            }
            fVar.k();
        }
    }

    private void a(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return;
        }
        if (layoutParams != null) {
            viewGroup.addView(view, layoutParams);
        } else {
            viewGroup.addView(view);
        }
    }
}
