package com.baidu.navisdk.module.newguide.settings;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.p;
import com.baidu.navisdk.module.newguide.settings.f;
import com.baidu.navisdk.module.newguide.subviews.a;
import com.baidu.navisdk.module.newguide.subviews.b;
import com.baidu.navisdk.module.newguide.widgets.RGOutScrollView;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.toolbox.view.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public abstract class a extends com.baidu.navisdk.ui.routeguide.widget.d implements RGOutScrollView.c, RGOutScrollView.d, com.baidu.navisdk.framework.interfaces.pronavi.hd.b {
    private boolean A;
    private com.baidu.navisdk.module.newguide.subviews.e B;
    private com.baidu.navisdk.pronavi.data.vm.g C;
    private com.baidu.navisdk.pronavi.data.vm.d D;
    private Observer<Integer> E;
    private boolean F;
    private com.baidu.navisdk.pronavi.ui.base.b G;
    protected com.baidu.navisdk.module.newguide.subviews.c i;
    private com.baidu.navisdk.module.newguide.subviews.b j;
    private com.baidu.navisdk.module.newguide.subviews.a k;
    private com.baidu.navisdk.pronavi.ui.driving.a l;
    private com.baidu.navisdk.module.newguide.settings.f m;
    private RGOutScrollView n;
    protected FrameLayout o;
    private View p;
    private View q;
    private ImageView r;
    private int s;
    private int t;
    private int u;
    private int v;
    private f.i w;
    private p x;
    private Runnable y;
    private com.baidu.navisdk.module.newguide.settings.e z;

    /* renamed from: com.baidu.navisdk.module.newguide.settings.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0250a implements a.o {
        public C0250a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.view.a.o
        public void a() {
            if (a.this.k != null) {
                a.this.k.A(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.o {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.view.a.o
        public void a() {
            if (a.this.k != null) {
                a.this.k.A(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "onClick: " + a.this.A);
            }
            if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
                if (gVar.d()) {
                    gVar.e("RGBottomBarSettingsPage", "onClick: is ar navi");
                    return;
                }
                return;
            }
            if (RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getTopState())) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
            }
            if (a.this.n != null && !a.this.A) {
                p status = a.this.n.getStatus();
                p pVar = p.BOTTOM;
                if (status == pVar) {
                    a.this.a(p.SPECIFIC, true);
                    com.baidu.navisdk.util.statistic.userop.b.r().d("3.7", "2");
                } else {
                    a.this.a(pVar, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Observer<Integer> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            a.this.k1();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "onClick: " + a.this.A);
            }
            if (RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getTopState())) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
            }
            if (a.this.n != null && !a.this.A) {
                p status = a.this.n.getStatus();
                p pVar = p.BOTTOM;
                if (status == pVar) {
                    a.this.a(p.SPECIFIC, true);
                    com.baidu.navisdk.util.statistic.userop.b.r().d("3.7", "2");
                } else {
                    a.this.a(pVar, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements b.f {
        public f() {
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.b.f
        public void a() {
            if (((com.baidu.navisdk.ui.routeguide.widget.d) a.this).c != null) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) a.this).c.c();
                if (com.baidu.navisdk.module.abtest.model.i.w().o() == 1 || com.baidu.navisdk.module.abtest.model.i.w().o() == 2) {
                    com.baidu.navisdk.module.abtest.model.i.w().v();
                }
            }
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.b.f
        public void b() {
            if (((com.baidu.navisdk.ui.routeguide.widget.d) a.this).c != null) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) a.this).c.d();
            }
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.b.f
        public void c() {
            if (((com.baidu.navisdk.ui.routeguide.widget.d) a.this).c != null) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) a.this).c.a(3, 0, 0, null);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.5", null, null, "");
                if (com.baidu.navisdk.module.abtest.model.i.w().o() == 1 || com.baidu.navisdk.module.abtest.model.i.w().o() == 2) {
                    com.baidu.navisdk.module.abtest.model.i.w().s();
                }
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_multi_route_continue"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements b.e {
        public g() {
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.b.e
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "onHideStatusView: ");
            }
            a.this.n0();
            if (!a.this.D0()) {
                x.b().J3();
            }
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.b.e
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "onShowStatusView: ");
            }
            a.this.o0();
            if (a.this.k != null && a.this.k.o0()) {
                a.this.k.b(false, true);
            }
            x.b().G0();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements a.InterfaceC0265a {
        public h() {
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.a.InterfaceC0265a
        public void a() {
            a.this.X0();
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.a.InterfaceC0265a
        public void b() {
            if (!com.baidu.navisdk.ui.routeguide.control.d.e.a()) {
                a.this.Y0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.n != null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGBottomBarSettingsPage", "mScrollStatusUpdateRunnable run");
                }
                a.this.n.a(a.this.x, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements f.i {
        public k() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.f.i
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "onDragFinish: ");
            }
            a.this.A = false;
            a aVar = a.this;
            aVar.a(aVar.Z0());
        }

        @Override // com.baidu.navisdk.module.newguide.settings.f.i
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "switch2SortStatus: ");
            }
            a.this.a(p.TOP, false);
        }

        @Override // com.baidu.navisdk.module.newguide.settings.f.i
        public void c() {
            a.this.A = true;
        }

        @Override // com.baidu.navisdk.module.newguide.settings.f.i
        public void d() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "switch2NormalStatus: ");
            }
            a.this.A = false;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Observer<Boolean> {
        public l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "CLOSE_SETTING_PAGE onChanged: " + bool);
            }
            a.this.y(false);
        }
    }

    public a(Context context, com.baidu.navisdk.pronavi.ui.base.b bVar, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.x = p.BOTTOM;
        this.A = false;
        this.F = false;
        this.G = bVar;
        if (G(false)) {
            d(bVar);
            b(context, bVar, this.i.o0(), this.o);
            i1();
            e(bVar);
            a(context, viewGroup);
            c(bVar);
        }
    }

    private void D(boolean z) {
        e1();
        y(this.n.getTopStatusContentHeight());
        com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
        if (cVar != null && !z) {
            cVar.w(8);
        }
        I(z);
    }

    private void F(boolean z) {
        com.baidu.navisdk.module.newguide.settings.viewmodel.a I;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "handlerOpenSettingPage: isSlide:" + z);
        }
        if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
            x.b().B();
        }
        s0();
        W0();
        y0();
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null && (I = fVar.I()) != null) {
            I.b(true);
            I.n();
            I.f(true);
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.7", "3");
        }
    }

    private boolean G(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "loadTopView: " + z);
        }
        if (this.n == null || z) {
            this.n = F0();
        }
        int i2 = 0;
        if (this.n == null) {
            if (gVar.c()) {
                gVar.c("RGBottomBarSettingsPage", "loadTopView: mOutScrollView == null ");
            }
            return false;
        }
        this.s = -JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_toolbox_margin_left);
        this.t = 0;
        o0();
        e1();
        this.n.setScrollChangeListener(this);
        this.n.setOnScrollViewTouchListener(this);
        this.n.setOverScrollMode(2);
        FrameLayout frameLayout = this.o;
        if (frameLayout != null && (frameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.o.getParent()).removeView(this.o);
        }
        if (this.o == null) {
            FrameLayout G0 = G0();
            this.o = G0;
            this.r = (ImageView) G0.findViewById(R.id.bn_rg_setting_scroll_indicator);
            b(Z0());
        }
        boolean g1 = g1();
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar = new com.baidu.navisdk.framework.interfaces.pronavi.hd.f(0);
        if (!g1) {
            fVar = h0();
        }
        int i3 = fVar.f6817a;
        if (i3 == 2) {
            if (g1) {
                i2 = fVar.b;
            } else {
                i2 = fVar.c;
            }
        }
        Pair<Integer, Integer> b2 = b(i3, g1, i2);
        f0();
        this.n.a(this.o, ((Integer) b2.first).intValue(), ((Integer) b2.second).intValue());
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            this.p = viewGroup.findViewById(R.id.bn_rg_setting_page_bg_view);
            this.q = this.b.findViewById(R.id.bn_rg_setting_page_land_bg_view);
            k1();
        }
        d1();
        f1();
        return true;
    }

    private boolean H(boolean z) {
        RGOutScrollView rGOutScrollView = this.n;
        if (rGOutScrollView != null && rGOutScrollView.a(z)) {
            return true;
        }
        return false;
    }

    private void I(boolean z) {
        com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
        if (cVar != null && !z) {
            cVar.w(8);
        }
        com.baidu.navisdk.module.newguide.subviews.e eVar = this.B;
        if (eVar != null) {
            eVar.a(this.b);
        }
    }

    private void T0() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j2;
        if (this.B != null && (j2 = com.baidu.navisdk.ui.routeguide.b.V().j()) != null) {
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c2 = j2.c(false);
            if (c2 != null) {
                c2.a(this.B);
            }
            com.baidu.navisdk.ui.routeguide.ar.a a2 = j2.a(false);
            if (a2 != null) {
                a2.a(this.B);
            }
        }
    }

    private void U0() {
        com.baidu.navisdk.pronavi.ui.base.b bVar;
        com.baidu.navisdk.pronavi.data.model.g gVar;
        if (this.E == null) {
            this.E = new d();
        }
        if (!this.F && (bVar = this.G) != null && (gVar = (com.baidu.navisdk.pronavi.data.model.g) bVar.b(com.baidu.navisdk.pronavi.data.model.g.class)) != null && gVar.b().getValue() != null) {
            this.F = true;
            gVar.b().observeForever(this.E);
        }
    }

    private void V0() {
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            com.baidu.navisdk.module.newguide.settings.viewmodel.a I = fVar.I();
            LifecycleOwner J = this.m.J();
            if (I != null && J != null) {
                I.a(3).observe(J, new l());
            }
        }
    }

    private void W0() {
        com.baidu.navisdk.module.newguide.settings.viewmodel.a I;
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null && (I = fVar.I()) != null) {
            I.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        y(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        if (this.c != null) {
            com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k2 != null) {
                k2.w0();
            }
            if (!BNSettingManager.isQuitNaviEnable()) {
                return;
            }
            this.c.m();
            com.baidu.navisdk.module.abtest.model.k.x().t();
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.7.5", "2");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "1", "1", null);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_quit_navi"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p Z0() {
        RGOutScrollView rGOutScrollView = this.n;
        if (rGOutScrollView != null) {
            return rGOutScrollView.getStatus();
        }
        return p.BOTTOM;
    }

    private int a1() {
        if (g1()) {
            return com.baidu.navisdk.pronavi.util.a.h.a();
        }
        return com.baidu.navisdk.pronavi.util.a.h.b();
    }

    private void b1() {
        com.baidu.navisdk.module.newguide.settings.viewmodel.a I;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "handlerCloseSettingPage: ");
        }
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null && (I = fVar.I()) != null) {
            I.f(false);
        }
    }

    private void c1() {
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.p0();
        }
    }

    private void d1() {
        if (this.w == null) {
            this.w = new k();
        }
    }

    private void e1() {
        int c2;
        int i2;
        int c3 = com.baidu.navisdk.ui.routeguide.utils.b.c();
        boolean g1 = g1();
        int a1 = a1();
        if (g1) {
            if (!h0().g(true)) {
                i2 = c3;
            } else {
                i2 = 0;
            }
            a1 -= x.b().L();
            if (com.baidu.navisdk.ui.routeguide.b.V().r().g()) {
                c2 = a1 - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_bottom_bar_setting_top_margin);
            } else {
                c2 = a1;
            }
        } else {
            c2 = a1 - com.baidu.navisdk.pronavi.util.a.h.c(this.f9165a);
            i2 = 0;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "initParams: " + a1 + "," + c3 + ",0, " + c2);
        }
        this.n.setBottomStatusContentHeight(i2);
        this.n.setTopStatusContentHeight(c2);
        this.n.b(a1);
        this.u = 0 - i2;
        int i3 = c2 - c3;
        this.v = i3;
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.v(i3);
        }
    }

    private void f1() {
        RGOutScrollView rGOutScrollView;
        if (this.x != p.BOTTOM) {
            if (g1() && (rGOutScrollView = this.n) != null && !rGOutScrollView.c()) {
                this.x = p.TOP;
            }
            if (this.y == null) {
                this.y = new j();
            }
            RGOutScrollView rGOutScrollView2 = this.n;
            if (rGOutScrollView2 != null) {
                rGOutScrollView2.removeCallbacks(this.y);
                this.n.post(this.y);
            }
        }
    }

    private boolean g1() {
        if (this.f == 1) {
            return true;
        }
        return false;
    }

    private void h1() {
        if (this.m == null) {
            com.baidu.navisdk.module.newguide.settings.f fVar = new com.baidu.navisdk.module.newguide.settings.f(this.f9165a, this.b, this.c, this.o, this.v);
            this.m = fVar;
            fVar.a(this.w);
        }
        this.m.y();
        V0();
        n0();
    }

    private void i1() {
        com.baidu.navisdk.module.newguide.subviews.b H0 = H0();
        this.j = H0;
        H0.a(new f());
        this.j.a(new g());
    }

    private void j1() {
        com.baidu.navisdk.pronavi.ui.base.b bVar;
        com.baidu.navisdk.pronavi.data.model.g gVar;
        if (this.F && (bVar = this.G) != null && (gVar = (com.baidu.navisdk.pronavi.data.model.g) bVar.b(com.baidu.navisdk.pronavi.data.model.g.class)) != null && gVar.b().getValue() != null) {
            this.F = false;
            gVar.b().removeObserver(this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        if (this.p != null) {
            if (g1()) {
                if (BNCommSettingManager.getInstance().getIsShowMapSwitch() == 3) {
                    com.baidu.navisdk.ui.util.b.a(this.p, R.drawable.bn_rg_bottom_bar_new_bg);
                } else {
                    com.baidu.navisdk.ui.util.b.a(this.p, R.drawable.bn_rg_bottom_bar_bg);
                }
            } else {
                com.baidu.navisdk.ui.util.b.a(this.p, R.drawable.bn_rg_bottom_bar_bg);
            }
        }
        if (this.q != null) {
            if (BNCommSettingManager.getInstance().getIsShowMapSwitch() == 3) {
                com.baidu.navisdk.ui.util.b.a(this.q, R.drawable.bn_rg_bottom_bar_new_bg);
            } else {
                com.baidu.navisdk.ui.util.b.a(this.q, R.drawable.bn_rg_bottom_bar_bg);
            }
        }
    }

    private void x(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "changeBgViewMargin: " + i2 + ", mScrollFullPage:" + this.u);
        }
        if (this.u <= 0) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.p.getLayoutParams();
        if (i2 != marginLayoutParams.leftMargin) {
            marginLayoutParams.rightMargin = i2;
            marginLayoutParams.leftMargin = i2;
            this.p.requestLayout();
        }
    }

    private void y(int i2) {
        ViewGroup.LayoutParams layoutParams;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "updateContentViewHeight: " + i2);
        }
        FrameLayout frameLayout = this.o;
        if (frameLayout == null || (layoutParams = frameLayout.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = -1;
        layoutParams.height = i2;
        this.o.requestLayout();
    }

    public void A(boolean z) {
        x0();
    }

    public void A0() {
        com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
        if (cVar != null) {
            cVar.y(true);
        }
    }

    public void B(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "showHideResumeSwitchView: " + z);
        }
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.z(z);
        }
    }

    public boolean B0() {
        RGOutScrollView rGOutScrollView = this.n;
        if (rGOutScrollView != null && rGOutScrollView.getStatus() != p.BOTTOM) {
            return true;
        }
        return false;
    }

    public void C(boolean z) {
    }

    public boolean C0() {
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null && bVar.r0()) {
            return true;
        }
        return false;
    }

    public boolean D0() {
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null && bVar.s0()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.RGOutScrollView.d
    public void E() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "onScrollViewTouchDown: ");
        }
    }

    public void E0() {
        String str;
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.4");
        if (!z.b(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "网络连接不可用");
            return;
        }
        if (BNRoutePlaner.getInstance().B()) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "离线导航车牌限行不可用");
            return;
        }
        String a2 = com.baidu.navisdk.h.a(false);
        boolean D = com.baidu.navisdk.ui.routeguide.b.V().D();
        if (D) {
            str = com.baidu.navisdk.module.routeresult.logic.plate.a.b().b(1).getPlate(1);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(a2) && (!D || !TextUtils.isEmpty(str))) {
            if (!com.baidu.navisdk.module.routepreference.d.j().h()) {
                com.baidu.navisdk.module.routepreference.d.j().b(true);
                com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
                if (aVar != null) {
                    aVar.o();
                    return;
                }
                return;
            }
            return;
        }
        W0();
        com.baidu.navisdk.module.routepreference.d.j().b(true);
        if (!D) {
            com.baidu.navisdk.h.e(this.f9165a.getApplicationContext());
        }
    }

    public abstract RGOutScrollView F0();

    public abstract FrameLayout G0();

    public abstract com.baidu.navisdk.module.newguide.subviews.b H0();

    public boolean I0() {
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null && fVar.q0()) {
            return true;
        }
        com.baidu.navisdk.module.newguide.subviews.a aVar = this.k;
        if (aVar != null && aVar.p0()) {
            return true;
        }
        return H(true);
    }

    public void J0() {
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.r0();
            z(true);
        }
    }

    public void K0() {
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.c("正在计算路线", new C0250a());
        }
    }

    public void L0() {
        x0();
    }

    public void M0() {
        f("正在算路，请稍等");
    }

    public void N0() {
        f("您已偏离路线");
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.RGOutScrollView.d
    public void O() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "onScrollViewContentTouchDown: ");
        }
        e0();
    }

    public void O0() {
        com.baidu.navisdk.module.newguide.settings.e eVar = this.z;
        if (eVar != null && eVar.a()) {
            this.z.c();
        }
    }

    public void P0() {
        int i2;
        com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
        if (cVar != null) {
            if (com.baidu.navisdk.ui.routeguide.module.convoy.a.c) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            cVar.v(i2);
        }
    }

    public void Q0() {
    }

    public void R0() {
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.RGOutScrollView.d
    public void S() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "onScrollViewTouchUp: ");
        }
    }

    public void S0() {
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.RGOutScrollView.d
    public void Y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "onScrollViewContentTouchUp: ");
        }
        a(Z0());
    }

    public abstract com.baidu.navisdk.module.newguide.subviews.a a(Context context, com.baidu.navisdk.pronavi.ui.base.b bVar, ViewGroup viewGroup, ViewGroup viewGroup2);

    public abstract com.baidu.navisdk.module.newguide.subviews.c a(com.baidu.navisdk.pronavi.ui.base.b bVar);

    public abstract com.baidu.navisdk.module.newguide.subviews.e b(com.baidu.navisdk.pronavi.ui.base.b bVar);

    @Override // com.baidu.navisdk.module.newguide.widgets.RGOutScrollView.d
    public void d0() {
        y(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void f0() {
        super.f0();
        if (g1()) {
            return;
        }
        a(h0().b(), this.n);
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.f0();
        }
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.f0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i0() {
        super.i0();
        y(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void k0() {
        z(false);
    }

    public void n0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "canScroll: ");
        }
        RGOutScrollView rGOutScrollView = this.n;
        if (rGOutScrollView != null) {
            rGOutScrollView.setScrollAvailable(true);
        }
    }

    public void o0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "forbidScroll: ");
        }
        RGOutScrollView rGOutScrollView = this.n;
        if (rGOutScrollView != null) {
            p status = rGOutScrollView.getStatus();
            p pVar = p.BOTTOM;
            if (status != pVar) {
                this.n.a(pVar, false);
            }
            this.n.setScrollAvailable(false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void onResume() {
        super.onResume();
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.onResume();
        }
    }

    public com.baidu.navisdk.module.newguide.subviews.b p0() {
        return this.j;
    }

    public View q0() {
        com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
        if (cVar != null) {
            return cVar.o0();
        }
        return null;
    }

    public void r0() {
        com.baidu.navisdk.module.newguide.settings.viewmodel.a I;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "handlerFromCarOwnerBack: ");
        }
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null && (I = fVar.I()) != null) {
            I.h();
        }
    }

    public void s0() {
        s.T().a(false, false, false);
    }

    public void t0() {
        if (B0()) {
            y(false);
        }
        com.baidu.navisdk.module.newguide.settings.e eVar = this.z;
        if (eVar != null && eVar.a()) {
            this.z.c();
        }
        com.baidu.navisdk.module.newguide.subviews.a aVar = this.k;
        if (aVar != null && aVar.o0()) {
            this.k.z(false);
        }
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.c();
        }
        com.baidu.navisdk.pronavi.ui.driving.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.c();
            this.l = null;
        }
        RGOutScrollView rGOutScrollView = this.n;
        if (rGOutScrollView != null) {
            rGOutScrollView.setVisibility(8);
        }
    }

    public void u0() {
        com.baidu.navisdk.pronavi.ui.driving.a aVar = this.l;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void v(int i2) {
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.v(i2);
        }
    }

    public void w(int i2) {
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null && this.f == 2 && com.baidu.navisdk.module.pronavi.a.j != 2) {
            bVar.w(i2);
        }
    }

    public void w0() {
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.p0();
        }
    }

    public void x0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "hideLoadingViewNoProgress: ");
        }
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.q0();
        }
    }

    public void y0() {
        com.baidu.navisdk.module.newguide.subviews.a aVar = this.k;
        if (aVar != null && aVar.o0()) {
            this.k.z(false);
        }
    }

    public void z(boolean z) {
        com.baidu.navisdk.module.newguide.settings.viewmodel.a I;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "onSuperVoiceIconAnimStatus: " + z);
        }
        if (this.m != null && B0() && (I = this.m.I()) != null) {
            I.f(z);
        }
    }

    public void z0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "hideStatusView: ");
        }
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void b(Context context, com.baidu.navisdk.pronavi.ui.base.b bVar, ViewGroup viewGroup, ViewGroup viewGroup2) {
        com.baidu.navisdk.module.newguide.subviews.a a2 = a(context, bVar, viewGroup, viewGroup2);
        this.k = a2;
        a2.a(new h());
        this.k.a(new i());
    }

    private void d(com.baidu.navisdk.pronavi.ui.base.b bVar) {
        com.baidu.navisdk.module.newguide.subviews.c a2 = a(bVar);
        this.i = a2;
        if (a2 != null) {
            a2.b(new e());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        j1();
        y(false);
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.c();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.RGOutScrollView.c
    public void e(int i2) {
        int i3;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "onScroll: " + i2);
        }
        O0();
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.a(this.x, i2);
        }
        if (this.p == null || (i3 = this.u) <= 0) {
            return;
        }
        if (i2 <= i3) {
            int i4 = (i2 * 100) / i3;
            int i5 = (this.s * i4) / 100;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "onScroll: progress:" + i4 + ",margin: " + i5);
            }
            if (i5 != this.t) {
                this.t = i5;
                x(i5);
                return;
            }
            return;
        }
        int i6 = this.t;
        int i7 = this.s;
        if (i6 != i7) {
            this.t = i7;
            x(i7);
        }
    }

    public void f(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "showLoadingViewNoProgress: " + str);
        }
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.b(str, new b());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void h() {
        super.h();
        e1();
        y(this.n.getTopStatusContentHeight());
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
        if (cVar != null) {
            cVar.i();
        }
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.i();
        }
        com.baidu.navisdk.module.newguide.subviews.a aVar = this.k;
        if (aVar != null) {
            aVar.i();
            this.k = null;
        }
        com.baidu.navisdk.module.newguide.settings.e eVar = this.z;
        if (eVar != null) {
            if (eVar.a()) {
                this.z.c();
            }
            this.z.i();
            this.z = null;
        }
        com.baidu.navisdk.pronavi.ui.driving.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.i();
            this.l = null;
        }
        com.baidu.navisdk.module.newguide.subviews.e eVar2 = this.B;
        if (eVar2 != null) {
            eVar2.i();
        }
    }

    private void E(boolean z) {
        e1();
        y(this.n.getTopStatusContentHeight());
        com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
        if (cVar != null) {
            cVar.w(0);
        }
        com.baidu.navisdk.module.newguide.subviews.e eVar = this.B;
        if (eVar != null) {
            if (z) {
                eVar.n0();
            }
            this.B.i();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements a.b {
        public i() {
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.a.b
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "onShowQuiteBtn: ");
            }
            if (a.this.j != null) {
                a.this.j.t0();
            }
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.a.b
        public void a(boolean z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarSettingsPage", "onHideQuiteBtn: " + z);
            }
            if (a.this.j == null || z) {
                return;
            }
            a.this.j.n0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i2) {
        com.baidu.navisdk.module.newguide.subviews.c cVar;
        com.baidu.navisdk.module.newguide.subviews.c cVar2;
        super.a(viewGroup, i2);
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.a(viewGroup, i2);
        }
        G(true);
        n0();
        com.baidu.navisdk.module.newguide.subviews.c cVar3 = this.i;
        if (cVar3 != null) {
            cVar3.a(viewGroup, i2, this.o);
        }
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.a(viewGroup, i2);
        }
        if (g1()) {
            x(this.t);
        }
        com.baidu.navisdk.module.newguide.subviews.a aVar = this.k;
        if (aVar != null && (cVar2 = this.i) != null) {
            aVar.a(cVar2.o0(), i2, this.o);
        }
        com.baidu.navisdk.module.newguide.settings.e eVar = this.z;
        if (eVar != null) {
            eVar.a(viewGroup, i2);
        }
        com.baidu.navisdk.pronavi.ui.driving.a aVar2 = this.l;
        if (aVar2 != null && (cVar = this.i) != null) {
            aVar2.a(cVar.o0(), i2);
        }
        if (h0().g(g1())) {
            if (this.B != null) {
                com.baidu.navisdk.module.newguide.subviews.c cVar4 = this.i;
                if (cVar4 != null) {
                    cVar4.w(8);
                }
                this.B.a(viewGroup);
                this.B.a(viewGroup, i2);
                return;
            }
            I(g1());
            return;
        }
        com.baidu.navisdk.module.newguide.subviews.e eVar2 = this.B;
        if (eVar2 != null) {
            eVar2.i();
            this.B.a(viewGroup, i2);
        }
        com.baidu.navisdk.module.newguide.subviews.c cVar5 = this.i;
        if (cVar5 != null) {
            cVar5.w(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        super.b(bundle);
        U0();
        h1();
        RGOutScrollView rGOutScrollView = this.n;
        if (rGOutScrollView == null) {
            return true;
        }
        rGOutScrollView.setVisibility(0);
        if (this.z == null || !this.n.a(p.BOTTOM)) {
            return true;
        }
        this.z.y();
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void f(int i2, int i3, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "enterNormal: " + i2 + "," + i3 + "," + z);
        }
        y(false);
        E(z);
        a(false, (View) this.n);
        a(0, z, i3);
        com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
        if (cVar != null) {
            cVar.q0();
        }
    }

    private void c(com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (bVar != null) {
            this.D = (com.baidu.navisdk.pronavi.data.vm.d) bVar.c(com.baidu.navisdk.pronavi.data.vm.d.class);
            this.C = (com.baidu.navisdk.pronavi.data.vm.g) bVar.c(com.baidu.navisdk.pronavi.data.vm.g.class);
        }
    }

    public void y(boolean z) {
        RGOutScrollView rGOutScrollView = this.n;
        if (rGOutScrollView != null) {
            p status = rGOutScrollView.getStatus();
            p pVar = p.BOTTOM;
            if (status != pVar || this.n.b()) {
                com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
                if (fVar != null) {
                    fVar.o0();
                }
                this.n.a(pVar, z, 0, false);
            }
        }
    }

    private void b(p pVar) {
        Drawable f2 = com.baidu.navisdk.ui.util.b.f(pVar == p.TOP ? R.drawable.bn_ic_indicate_arrow_down : R.drawable.bn_ic_line_indicate);
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setImageDrawable(f2);
        }
    }

    private void b(p pVar, p pVar2, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "handlerOpenSettingPage: oldSt:" + pVar + ",newSt:" + pVar2);
        }
        p pVar3 = p.BOTTOM;
        if (pVar == pVar3 && pVar2 != pVar3) {
            F(z);
        } else {
            if (pVar == pVar3 || pVar2 != pVar3) {
                return;
            }
            b1();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void e(int i2, int i3, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "enterDoubleMap: " + i2 + "," + i3 + "," + z);
        }
        y(false);
        if (i2 == 0) {
            D(z);
            com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
            if (cVar != null) {
                cVar.p0();
            }
        }
        T0();
        a(2, z, i3);
        a(true, (View) this.n);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void b(int i2, int i3, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "enterFullHD: " + i2 + "," + i3 + "," + z);
        }
        y(false);
        if (i2 == 0) {
            D(z);
            com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
            if (cVar != null) {
                cVar.p0();
            }
        }
        T0();
        a(false, (View) this.n);
        a(3, z, i3);
    }

    private void e(com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (this.B == null) {
            this.B = b(bVar);
        }
        com.baidu.navisdk.module.newguide.subviews.e eVar = this.B;
        if (eVar != null) {
            eVar.b(new c());
        }
    }

    private Pair<Integer, Integer> b(int i2, boolean z, int i3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "getContentMarginLeftRight: " + i2);
        }
        int i4 = 0;
        if (!z) {
            if (i2 == 2) {
                i4 = com.baidu.navisdk.ui.routeguide.utils.b.q();
            } else if (i2 == 3) {
                i3 = com.baidu.navisdk.ui.routeguide.utils.b.k();
                i4 = com.baidu.navisdk.ui.routeguide.utils.b.q() + i3;
            } else {
                i4 = com.baidu.navisdk.ui.routeguide.utils.b.j() + JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_margin_left);
            }
            return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i3));
        }
        i3 = 0;
        return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i3));
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.RGOutScrollView.c
    public void a(p pVar, p pVar2, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "onStatusChanged: " + pVar + ", new: " + pVar2 + ",isSlide: " + z);
        }
        this.x = pVar2;
        if (pVar == pVar2) {
            return;
        }
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.a(pVar, pVar2, z);
        }
        b(pVar2);
        if (this.p != null) {
            if (pVar2 == p.BOTTOM) {
                if (this.t != 0) {
                    this.t = 0;
                    x(0);
                }
            } else {
                int i2 = this.t;
                int i3 = this.s;
                if (i2 != i3) {
                    this.t = i3;
                    x(i3);
                }
            }
        }
        p pVar3 = p.BOTTOM;
        if (pVar2 == pVar3 || pVar2 == p.SPECIFIC) {
            c1();
        }
        com.baidu.navisdk.pronavi.data.vm.d dVar = this.D;
        if (dVar != null) {
            dVar.a(pVar2);
        }
        if (pVar2 == pVar3) {
            this.A = false;
            e0();
            com.baidu.navisdk.module.newguide.subviews.a aVar = this.k;
            if (aVar != null) {
                aVar.y(true);
            }
            com.baidu.navisdk.pronavi.data.vm.g gVar2 = this.C;
            if (gVar2 != null) {
                gVar2.a(0);
            }
            RGOutScrollView rGOutScrollView = this.n;
            if (rGOutScrollView != null) {
                rGOutScrollView.setBackgroundColor(JarUtils.getResources().getColor(android.R.color.transparent));
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().o();
        } else {
            O0();
            a(pVar2);
            com.baidu.navisdk.module.newguide.subviews.a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.y(false);
            }
            com.baidu.navisdk.pronavi.data.vm.g gVar3 = this.C;
            if (gVar3 != null && this.f != 2) {
                gVar3.a(4);
            }
            RGOutScrollView rGOutScrollView2 = this.n;
            if (rGOutScrollView2 != null) {
                rGOutScrollView2.setBackgroundColor(Color.parseColor("#66000000"));
            }
        }
        b(pVar, pVar2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "startAutoHide: ");
        }
        if (pVar != p.BOTTOM) {
            u(10000);
        }
    }

    public void a(p pVar, boolean z) {
        RGOutScrollView rGOutScrollView = this.n;
        if (rGOutScrollView == null || rGOutScrollView.getStatus() == pVar) {
            return;
        }
        this.n.a(pVar, z);
    }

    public void a(int i2, int i3, Intent intent) {
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.a(i2, i3, intent);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.a(z);
        }
        com.baidu.navisdk.module.newguide.subviews.c cVar = this.i;
        if (cVar != null) {
            cVar.a(z);
        }
        com.baidu.navisdk.module.newguide.settings.f fVar = this.m;
        if (fVar != null) {
            fVar.a(z);
        }
        k1();
        b(Z0());
        com.baidu.navisdk.pronavi.ui.driving.a aVar = this.l;
        if (aVar != null) {
            aVar.a(z);
        }
        com.baidu.navisdk.module.newguide.subviews.e eVar = this.B;
        if (eVar != null) {
            eVar.a(z);
        }
    }

    public void a(String str, a.o oVar) {
        com.baidu.navisdk.module.newguide.subviews.b bVar = this.j;
        if (bVar != null) {
            bVar.a(str, oVar);
        }
    }

    private void a(Context context, ViewGroup viewGroup) {
        if (this.z != null || BNCommSettingManager.getInstance().getRGSettingBubbleShowTimes() >= 3) {
            return;
        }
        this.z = new com.baidu.navisdk.module.newguide.settings.e(context, viewGroup);
    }

    private void a(int i2, boolean z, int i3) {
        FrameLayout frameLayout;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarSettingsPage", "changeLandContentViewMarginLeftRight: ");
        }
        if (z || (frameLayout = this.o) == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
        Pair<Integer, Integer> b2 = b(i2, false, i3);
        if (marginLayoutParams.leftMargin == ((Integer) b2.first).intValue() && marginLayoutParams.rightMargin == ((Integer) b2.second).intValue()) {
            return;
        }
        marginLayoutParams.leftMargin = ((Integer) b2.first).intValue();
        marginLayoutParams.rightMargin = ((Integer) b2.second).intValue();
        this.o.requestLayout();
    }
}
