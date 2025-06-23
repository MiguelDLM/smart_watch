package com.baidu.navisdk.pronavi.ui.bucket;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.j;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.m;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.n;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.o;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.q;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.v;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.z;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.u;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket;
import com.baidu.navisdk.uiframe.UiModule;
import com.baidu.navisdk.util.jar.JarUtils;
import com.garmin.fit.OxXXx0X;

/* loaded from: classes7.dex */
public class RGLeftBucketComponent extends RGBaseBucketComponent<com.baidu.navisdk.pronavi.ui.base.b> {
    private Runnable A;
    private View B;
    private boolean C;

    /* loaded from: classes7.dex */
    public class a implements Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.a> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.pronavi.data.vm.devicestate.a aVar) {
            RGLeftBucketComponent.this.S();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Observer<com.baidu.navisdk.module.park.a> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.module.park.a aVar) {
            RGLeftBucketComponent.this.a(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Observer<com.baidu.navisdk.pronavi.logic.service.parkrec.a> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.pronavi.logic.service.parkrec.a aVar) {
            boolean z;
            if (aVar != null && aVar.c() && aVar.a() != null) {
                z = true;
            } else {
                z = false;
            }
            RGLeftBucketComponent.this.i(z);
            if (z) {
                com.baidu.navisdk.util.statistic.userop.b.r().b("38.0.21.1460");
            }
            if (z && !RGLeftBucketComponent.this.C) {
                TTSPlayerControl.playTTS("为您推荐终点附近停车场，请点击查看", 1);
                RGLeftBucketComponent.this.C = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((UiModule) RGLeftBucketComponent.this).k != null) {
                int L = RGLeftBucketComponent.this.L();
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(((Func) RGLeftBucketComponent.this).g, "refreshBucketMarginTop: " + L);
                }
                ViewGroup.LayoutParams layoutParams = ((UiModule) RGLeftBucketComponent.this).k.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (marginLayoutParams.topMargin != L) {
                        marginLayoutParams.topMargin = L;
                        ((UiModule) RGLeftBucketComponent.this).k.requestLayout();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i4 - i2;
            int i10 = i8 - i6;
            if (i9 == i10) {
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGLeftBucketComponent.this).g, "spaceView mTopPriorityBucket onLayoutChange: " + i10 + "->" + i9);
            }
            RGLeftBucketComponent.this.U();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnLayoutChangeListener {
        public f() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i4 - i2;
            int i10 = i8 - i6;
            if (i9 == i10) {
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGLeftBucketComponent.this).g, "spaceView mBottomPriorityBucket onLayoutChange: " + i10 + "->" + i9);
            }
            RGLeftBucketComponent.this.T();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RGLeftBucketComponent rGLeftBucketComponent = RGLeftBucketComponent.this;
            rGLeftBucketComponent.a(rGLeftBucketComponent.r);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RGLeftBucketComponent rGLeftBucketComponent = RGLeftBucketComponent.this;
            rGLeftBucketComponent.a(rGLeftBucketComponent.s);
        }
    }

    public RGLeftBucketComponent(@NonNull com.baidu.navisdk.pronavi.ui.base.b bVar) {
        super(bVar, true, true);
        this.C = false;
    }

    private int K() {
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).E()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width_new);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        int i = 0;
        boolean z4 = false;
        if (i.s().k() && x.b().C2()) {
            z = true;
        } else {
            z = false;
        }
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).o() != 1) {
            z3 = false;
        }
        if (z3) {
            int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_bottom);
            boolean g2 = x.b().g2();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "getLeftTopLayoutMarginTop isSimpeModeGuidePanelShowing: " + g2);
            }
            if (!g2 || !x.b().e2()) {
                z4 = g2;
            }
            if (z4) {
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_height) - JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
                if (R()) {
                    dimensionPixelSize += JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_26dp);
                }
            }
            if (z) {
                dimensionPixelSize = u.a(((com.baidu.navisdk.pronavi.ui.base.b) this.i).e());
            }
            int i2 = dimensionPixelSize;
            z2 = z4;
            i = i2;
        } else {
            z2 = false;
        }
        if (x.b().p2() && ((!z || !z3) && e(z2))) {
            i += x.b().X();
            if (!z2) {
                i += JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_simple_board_margin_top);
            }
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e(this.g, "getLeftTopLayoutMarginTop-> marginTop= " + i);
        }
        return i;
    }

    private View M() {
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.i iVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.i) a(6, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.i.class);
        if (iVar == null) {
            return null;
        }
        return iVar.getView();
    }

    private int N() {
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).E()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_left);
        }
        return 0;
    }

    private boolean O() {
        if (((com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d) a(41, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d.class)) != null) {
            return true;
        }
        return false;
    }

    private boolean P() {
        q qVar = (q) a(10, q.class);
        if (qVar != null) {
            return qVar.v();
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d dVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d) a(41, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d.class);
        if (dVar != null && dVar.v()) {
            return true;
        }
        return false;
    }

    private boolean Q() {
        q qVar = (q) a(10, q.class);
        if (qVar != null) {
            if (qVar.v() || qVar.w()) {
                return true;
            }
            return false;
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d dVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d) a(41, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d.class);
        if (dVar != null && (dVar.v() || dVar.w())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean R() {
        com.baidu.navisdk.pronavi.data.vm.devicestate.a value;
        com.baidu.navisdk.pronavi.data.vm.devicestate.b bVar = (com.baidu.navisdk.pronavi.data.vm.devicestate.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.data.vm.devicestate.b.class);
        if (bVar == null || (value = bVar.c().getValue()) == null || !value.c() || !value.d()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).o() == 1 && x.b().g2()) {
            h(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "postBottomHandleViewGlandRunnable: ");
        }
        BNViewPriorityBucket bNViewPriorityBucket = this.s;
        if (bNViewPriorityBucket != null) {
            Runnable runnable = this.w;
            if (runnable != null) {
                bNViewPriorityBucket.removeCallbacks(runnable);
            }
            if (this.w == null) {
                this.w = new h();
            }
            this.s.postDelayed(this.w, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "postTopHandleViewGlandRunnable: ");
        }
        BNViewPriorityBucket bNViewPriorityBucket = this.r;
        if (bNViewPriorityBucket != null) {
            Runnable runnable = this.v;
            if (runnable != null) {
                bNViewPriorityBucket.removeCallbacks(runnable);
            }
            if (this.v == null) {
                this.v = new g();
            }
            this.r.postDelayed(this.v, 500L);
        }
    }

    private void V() {
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.b bVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.b) a(3, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.b.class);
        if (bVar != null) {
            bVar.refreshVisible();
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c cVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c) a(43, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c.class);
        if (cVar != null) {
            cVar.refreshVisible();
        }
    }

    private void W() {
        q qVar = (q) a(10, q.class);
        if (qVar != null) {
            qVar.refreshVisible();
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d dVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d) a(41, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d.class);
        if (dVar != null) {
            dVar.x();
        }
    }

    private void X() {
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.b bVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.b) a(3, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.b.class);
        if (bVar != null) {
            bVar.u();
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c cVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c) a(43, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c.class);
        if (cVar != null) {
            cVar.u();
        }
    }

    private void Y() {
        q qVar = (q) a(10, q.class);
        if (qVar != null) {
            qVar.x();
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d dVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d) a(41, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d.class);
        if (dVar != null) {
            dVar.y();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent, com.baidu.navisdk.pronavi.ui.base.RGUiComponent
    public void A() {
        super.A();
        e(0);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent
    public void G() {
        super.G();
        BNViewPriorityBucket bNViewPriorityBucket = this.r;
        if (bNViewPriorityBucket != null) {
            bNViewPriorityBucket.addBucketLayoutChangeListener(new e());
        }
        BNViewPriorityBucket bNViewPriorityBucket2 = this.s;
        if (bNViewPriorityBucket2 != null) {
            bNViewPriorityBucket2.addBucketLayoutChangeListener(new f());
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent
    public void H() {
        super.H();
        b(((com.baidu.navisdk.pronavi.ui.base.b) this.i).E(), i.s().k());
        U();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "RGLeftBucketComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public void s() {
        com.baidu.navisdk.pronavi.data.model.f fVar = (com.baidu.navisdk.pronavi.data.model.f) ((com.baidu.navisdk.pronavi.ui.base.b) this.i).b(com.baidu.navisdk.pronavi.data.model.f.class);
        if (fVar != null) {
            fVar.a().observe(this, new b());
            fVar.b().observe(this, new c());
        }
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.comapi.base.b
    public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.e eVar;
        super.update(cVar, i, i2, obj);
        if (i == 2 && i2 == 518 && (eVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.e) a(40, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.e.class)) != null) {
            eVar.v();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent
    public void z() {
        super.z();
        e(0);
        W();
    }

    private void d(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "reloadItem: " + com.baidu.navisdk.ui.routeguide.utils.b.a(i));
        }
        if (i != 3) {
            return;
        }
        X();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(int i) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "updateMainAuxiliaryBridgeBtn: " + i);
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.a aVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.a) a(5, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.a.class);
        if (aVar != null) {
            aVar.g(i);
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.c cVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.c) a(4, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.c.class);
        if (cVar != null) {
            cVar.g(i);
        }
        if (!O() || (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) == null) {
            return;
        }
        bVar.b(i);
    }

    private void f(boolean z) {
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).E()) {
            h(false);
        } else {
            a(false, z);
        }
    }

    private void h(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "refreshBucketMarginTop: " + z);
        }
        View view = this.k;
        if (view == null) {
            return;
        }
        Runnable runnable = this.A;
        if (runnable == null) {
            this.A = new d();
        } else {
            view.removeCallbacks(runnable);
        }
        if (z) {
            this.k.post(this.A);
        } else {
            this.A.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void i(boolean z) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        if (!O() || (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) == null) {
            return;
        }
        bVar.g(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j(boolean z) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        if (com.baidu.navisdk.util.common.x.s()) {
            return;
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.u uVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.u) a(8, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.u.class);
        if (uVar != null) {
            uVar.b(z);
        }
        if (!O() || (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) == null) {
            return;
        }
        bVar.a(z);
    }

    private void k(boolean z) {
        v vVar = (v) a(27, v.class);
        if (vVar != null) {
            vVar.b(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent
    public void c(boolean z) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        super.c(z);
        if (!O() || (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) == null) {
            return;
        }
        bVar.f(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent, com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d dVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d) a(41, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.d.class);
        if (dVar != null) {
            dVar.a(this);
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.b bVar = (com.baidu.navisdk.pronavi.data.vm.devicestate.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.data.vm.devicestate.b.class);
        if (bVar != null) {
            bVar.c().observe(this, new a());
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public View b(int i, @Nullable View view) {
        if (view != null) {
            View findViewById = view.findViewById(R.id.nsdk_rg_left_bucket);
            this.B = view.findViewById(R.id.bnav_rg_right_panel);
            this.r = (BNViewPriorityBucket) findViewById.findViewById(R.id.nsdk_rg_left_top_bucket);
            if (this.x) {
                this.s = (BNViewPriorityBucket) findViewById.findViewById(R.id.nsdk_rg_left_bottom_bucket);
            }
            return findViewById;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (!gVar.c()) {
            return null;
        }
        gVar.c(this.g, "onContentViewCreate: parentModuleContentView is null ");
        return null;
    }

    private void d(Message message) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onSwitchModeNotice: " + message);
        }
        boolean z = message.arg2 > 0;
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.c cVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.c) a(9, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.c.class);
        if (cVar != null) {
            cVar.b(z);
        }
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    public com.baidu.navisdk.apicenter.h a(@NonNull com.baidu.navisdk.apicenter.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "execute: " + aVar);
        }
        int d2 = aVar.d();
        if (d2 == 1001) {
            com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.a aVar2 = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.a) a(5, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.a.class);
            if (aVar2 != null) {
                aVar2.g(0);
            }
            return null;
        }
        if (d2 == 1002) {
            com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.c cVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.c) a(4, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.c.class);
            if (cVar != null) {
                cVar.g(0);
            }
            return null;
        }
        if (d2 == 1013) {
            z zVar = (z) a(1, z.class);
            if (zVar != null) {
                zVar.v();
            }
            return null;
        }
        if (d2 == 1014) {
            k(aVar.b("paramA"));
            return null;
        }
        if (d2 != 2017) {
            switch (d2) {
                case 1004:
                    return com.baidu.navisdk.apicenter.h.a().a(this);
                case 1005:
                    J();
                    return null;
                case 1006:
                    j(aVar.b("paramA"));
                    return null;
                case 1007:
                    return com.baidu.navisdk.apicenter.h.a().a(Boolean.valueOf(P()));
                case 1008:
                    return com.baidu.navisdk.apicenter.h.a().a(Boolean.valueOf(Q()));
                case 1009:
                    Y();
                    return null;
                case 1010:
                    o oVar = (o) a(2, o.class);
                    if (oVar != null) {
                        oVar.v();
                    }
                    m mVar = (m) a(38, m.class);
                    if (mVar != null) {
                        mVar.y();
                    }
                    n nVar = (n) a(42, n.class);
                    if (nVar != null) {
                        nVar.w();
                    }
                    return null;
                default:
                    switch (d2) {
                        case 1017:
                            a(aVar.c("paramA"), aVar);
                            return null;
                        case 1018:
                            h(true);
                            return null;
                        case 1019:
                            return com.baidu.navisdk.apicenter.h.a().a(M());
                        case 1020:
                            d(aVar.c("paramA"));
                            return null;
                        default:
                            switch (d2) {
                                case 1024:
                                    j jVar = (j) a(17, j.class);
                                    if (jVar != null) {
                                        jVar.b(aVar.b("paramA"));
                                    }
                                    return null;
                                case 1025:
                                    b(aVar);
                                    return null;
                                case 1026:
                                    i(aVar.b("paramA"));
                                    return null;
                                case 1027:
                                    a((com.baidu.navisdk.module.park.a) aVar.a("paramA"));
                                    return null;
                                default:
                                    return super.a(aVar);
                            }
                    }
            }
        }
        a(aVar.b("paramA"), aVar.c("paramB"));
        return null;
    }

    private void c(int i) {
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.e eVar;
        if (i != 11 || (eVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.e) a(40, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.e.class)) == null) {
            return;
        }
        eVar.w();
    }

    private void g(boolean z) {
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).E()) {
            h(false);
        } else {
            a(true, z);
        }
    }

    private void b(boolean z, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "setScaleLeveLogoLocation: " + z + "," + z2);
        }
        int D = D();
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).c(RGFSMTable.FsmState.NearbySearch)) {
            return;
        }
        x.b().t(D > 0 ? K() : N());
    }

    private int d(boolean z) {
        if (z) {
            return x.b().R() - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_land_left_panel_width_new);
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent, com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        View view;
        super.h();
        Runnable runnable = this.A;
        if (runnable == null || (view = this.k) == null) {
            return;
        }
        view.removeCallbacks(runnable);
    }

    private void e(Message message) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "updateIntervalSpeedView: " + message);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_TYPE", message.what);
        int i = message.what;
        if (i == 4383) {
            if (!com.baidu.navisdk.module.pronavi.model.g.o().g()) {
                com.baidu.navisdk.module.pronavi.model.g.o().b(true);
            }
            bundle.putInt("KEY_INTERVAL_CAMERA_SPEED_LIMIT", message.arg1);
            bundle.putInt("KEY_INTERVAL_CAMERA_LENGTH", message.arg2);
            bundle.putInt("KEY_INTERVAL_CAMERA_REMAIN_AVERAGE_SPEED", com.baidu.navisdk.module.pronavi.model.g.o().c());
        } else if (i == 4384) {
            bundle.putInt("KEY_INTERVAL_CAMERA_REMAIN_AVERAGE_SPEED", message.arg1);
            bundle.putInt("KEY_INTERVAL_CAMERA_REMAIN_DIST", message.arg2);
        } else {
            com.baidu.navisdk.module.pronavi.model.g.o().b(false);
        }
        if (gVar.d()) {
            gVar.e(this.g, "updateIntervalSpeedView: " + bundle);
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.b bVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.b) a(3, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.b.class);
        if (bVar == null && gVar.c()) {
            gVar.c(this.g, "updateIntervalSpeedView: speedPanel == null");
        }
        if (bVar != null) {
            bVar.a(bundle);
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c cVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c) a(43, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.c.class);
        if (cVar == null && gVar.c()) {
            gVar.c(this.g, "updateIntervalSpeedView: hsIntervalView == null");
        }
        if (cVar != null) {
            cVar.a(bundle);
        }
    }

    private void b(com.baidu.navisdk.apicenter.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "handleEnlargeMapVisibleChange:" + aVar);
        }
        boolean b2 = aVar.b("paramA");
        boolean b3 = aVar.b("paramB");
        if (b2) {
            g(b3);
        } else {
            f(b3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent
    public void b(boolean z) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        super.b(z);
        if (!O() || (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) == null) {
            return;
        }
        bVar.d(z);
    }

    private boolean e(boolean z) {
        Rect a2;
        boolean z2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "isLaneViewCollision: " + z);
        }
        if (z) {
            z2 = RGLaneInfoModel.getModel(false).mLineNumber > 6;
            if (gVar.d()) {
                gVar.e(this.g + " Collision", "isLaneViewCollision -> " + z2);
            }
        } else {
            View firstVisibleView = this.r.getFirstVisibleView();
            if (firstVisibleView == null) {
                return false;
            }
            if (this.r.isSpaceView(firstVisibleView)) {
                a2 = com.baidu.navisdk.pronavi.util.b.f7961a.a(this.r);
                a2.right = a2.left + RGImageTextBtn.b.a(((com.baidu.navisdk.pronavi.ui.base.b) this.i).o()).getFirst().intValue();
            } else {
                a2 = com.baidu.navisdk.pronavi.util.b.f7961a.a(firstVisibleView);
            }
            Rect W = x.b().W();
            if (W == null || W.isEmpty()) {
                return false;
            }
            z2 = a2.right + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp) > W.left;
            if (gVar.d()) {
                gVar.e(this.g + " Collision", "isLaneViewCollision -> " + z2 + ", topLeftRect = " + a2.toString() + ", laneLineRect = " + W.toString());
            }
        }
        return z2;
    }

    private void a(boolean z, int i) {
        m mVar = (m) a(38, m.class);
        if (mVar != null) {
            mVar.a(z, i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent, com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(Configuration configuration) {
        super.a(configuration);
        h(true);
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).E() || !((com.baidu.navisdk.pronavi.ui.base.b) this.i).J()) {
            return;
        }
        a(true, false);
    }

    private void a(int i, com.baidu.navisdk.apicenter.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "refreshBtnVisible: " + com.baidu.navisdk.ui.routeguide.utils.b.a(i) + "," + aVar);
        }
        if (i == 1) {
            z zVar = (z) a(1, z.class);
            if (zVar != null) {
                zVar.refreshVisible();
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 3) {
                V();
                return;
            } else {
                if (i != 10) {
                    return;
                }
                W();
                return;
            }
        }
        o oVar = (o) a(2, o.class);
        if (oVar != null) {
            oVar.refreshVisible();
        }
        n nVar = (n) a(42, n.class);
        if (nVar != null) {
            nVar.refreshVisible();
        }
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.module.pronavi.msg.c
    public int[] a() {
        return new int[]{4219, 4464, 4415, OxXXx0X.Xx0OXIoI, 4383, 4384, 4385, 4172};
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.module.pronavi.msg.c
    public void a(Message message) {
        super.a(message);
        int i = message.what;
        if (i == 4172) {
            c(message.arg1);
            return;
        }
        if (i == 4219) {
            e(message.arg1);
            return;
        }
        if (i == 4415) {
            j(com.baidu.navisdk.ugc.report.c.a().a(message.arg1 == 1));
            return;
        }
        if (i == 4432) {
            com.baidu.navisdk.module.pronavi.model.g.o().b(false);
            V();
        } else {
            if (i != 4464) {
                switch (i) {
                    case 4383:
                    case 4384:
                    case 4385:
                        e(message);
                        return;
                    default:
                        return;
                }
            }
            d(message);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent
    public int a(int i, int i2, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "getMarginBottom: " + i + "," + i2 + ", " + fVar);
        }
        int dimensionPixelSize = com.baidu.navisdk.util.common.x.s() ? 0 : JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
        if (i != 2) {
            return (i == 3 && fVar.g(true)) ? com.baidu.navisdk.ui.routeguide.utils.b.p() : dimensionPixelSize;
        }
        if (fVar.c() && com.baidu.navisdk.module.cloudconfig.a.b().a("NAVI_SUPPORT_NEW_BTN", true)) {
            return dimensionPixelSize;
        }
        if (fVar.f == 3) {
            return i2;
        }
        return i2 + (fVar.g(true) ? com.baidu.navisdk.ui.routeguide.utils.b.p() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BNViewPriorityBucket bNViewPriorityBucket) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "handleViewGland: " + bNViewPriorityBucket);
        }
        if (bNViewPriorityBucket == null) {
            return;
        }
        int bottomVisibleSize = bNViewPriorityBucket.getBottomVisibleSize();
        int goneByPrioritySize = bNViewPriorityBucket.getGoneByPrioritySize();
        if (gVar.d()) {
            gVar.e(this.g, "handleViewGland bottomVisibleSize: " + bottomVisibleSize + ",goneByPrioritySize: " + goneByPrioritySize);
        }
        if (bottomVisibleSize == 0 && goneByPrioritySize == 0) {
            return;
        }
        int intValue = RGImageTextBtn.b.a(((com.baidu.navisdk.pronavi.ui.base.b) this.i).o()).getSecond().intValue();
        if (gVar.d()) {
            gVar.e(this.g, "handleViewGland: itemHeight:" + intValue);
        }
        int height = (this.k.getHeight() - this.k.getPaddingTop()) - this.k.getPaddingBottom();
        if (gVar.d()) {
            gVar.e(this.g, "handleViewGland bucketRemainHeight: " + height);
        }
        int childCount = bNViewPriorityBucket.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bNViewPriorityBucket.getChildAt(i);
            if (childAt != null && childAt.getVisibility() != 8) {
                Object tag = childAt.getTag();
                if (!(tag instanceof String) || (!BNViewPriorityBucket.SPACE_VIEW_TAG.equals(tag) && !"RoadConditionView".equals(tag))) {
                    int measuredHeight = childAt.getMeasuredHeight();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (marginLayoutParams != null) {
                        measuredHeight += marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                    }
                    height -= measuredHeight;
                }
            }
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e(this.g, "handleViewGland bucketRemainHeight: " + height);
        }
        if (height < 0) {
            if (gVar2.d()) {
                int i2 = (-height) / intValue;
                if (height % intValue != 0) {
                    i2++;
                }
                gVar2.e(this.g, "handleViewGland goneSize : " + i2);
            }
            bNViewPriorityBucket.goneBottomItemByPriority();
            return;
        }
        if (height > intValue) {
            int i3 = height / intValue;
            if (gVar2.d()) {
                gVar2.e(this.g, "handleViewGland visibleSize : " + i3);
            }
            bNViewPriorityBucket.recoverBottomForPriorityGone(i3);
        }
    }

    private void a(boolean z, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "setBucketMarginLeftForLandEnlarge: " + z + ", " + z2);
        }
        if (this.k == null) {
            if (gVar.c()) {
                gVar.c(this.g, "setBucketMarginLeftForLandEnlarge: mContentView is null");
                return;
            }
            return;
        }
        int d2 = d(z);
        if (gVar.d()) {
            gVar.e(this.g, "setBucketMarginLeftForLandEnlarge: " + d2);
        }
        View view = this.B;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams.leftMargin != d2) {
                    marginLayoutParams.leftMargin = d2;
                    this.B.requestLayout();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.navisdk.module.park.a aVar) {
        com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b bVar;
        if (!O() || (bVar = (com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b) ((com.baidu.navisdk.pronavi.ui.base.b) n()).c(com.baidu.navisdk.pronavi.ui.buttoncollect.dynamic.b.class)) == null) {
            return;
        }
        bVar.a(aVar);
    }
}
