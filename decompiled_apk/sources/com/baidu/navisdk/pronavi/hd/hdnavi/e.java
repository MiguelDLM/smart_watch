package com.baidu.navisdk.pronavi.hd.hdnavi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.hd.hdnavi.map.RGHDBaseMapHelper;
import com.baidu.navisdk.pronavi.hd.hdnavi.map.RGHDMapView;
import com.baidu.navisdk.ui.routeguide.control.o;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.text.oIX0oI;

/* loaded from: classes7.dex */
public class e extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c, com.baidu.navisdk.framework.interfaces.pronavi.hd.a {
    protected RGHDMapView i;
    private FrameLayout j;
    private com.baidu.navisdk.pronavi.hd.hdnavi.d k;
    protected int l;
    private int m;
    private int n;
    private RGHDBaseMapHelper o;
    protected View p;
    private com.baidu.navisdk.pronavi.hd.hdnavi.model.a q;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7732a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        public a(boolean z, int i, int i2) {
            this.f7732a = z;
            this.b = i;
            this.c = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterDoubleMap onAnimationUpdate: " + intValue);
            }
            e.this.a(intValue, this.f7732a, 2);
            int i = this.b;
            if (i != 3) {
                e.this.a(i, 2, this.f7732a, intValue, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7733a;
        final /* synthetic */ int b;

        public b(boolean z, int i) {
            this.f7733a = z;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterDoubleMap onAnimationCancel: ");
            }
            e.this.q0();
            e.this.C(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterDoubleMap onAnimationEnd: ");
            }
            e.this.q0();
            e.this.C(true);
            e.this.b(this.f7733a, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterDoubleMap onAnimationStart: ");
            }
            e.this.r0();
            if (e.this.o != null) {
                e.this.o.onAnimatorStartBaseMapOffsetXY(o.A());
            }
            if (this.b == 0) {
                e.this.D(true);
            }
            RGHDMapView rGHDMapView = e.this.i;
            if (rGHDMapView != null) {
                rGHDMapView.setShowRect(2, this.f7733a);
                e.this.i.setMapStatus(2, o.A(), this.f7733a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7734a;
        final /* synthetic */ boolean b;
        final /* synthetic */ int c;

        public c(int i, boolean z, int i2) {
            this.f7734a = i;
            this.b = z;
            this.c = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterFullHD onAnimationUpdate: " + intValue);
            }
            if (intValue == this.f7734a) {
                e.this.a(-1, this.b, 3);
                if (e.this.o != null) {
                    e.this.o.pauseBaseMapDraw();
                    return;
                }
                return;
            }
            e.this.a(intValue, this.b, 3);
            e.this.a(this.c, 3, this.b, intValue, this.f7734a);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7735a;
        final /* synthetic */ boolean b;

        public d(int i, boolean z) {
            this.f7735a = i;
            this.b = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterFullHD onAnimationCancel: ");
            }
            e.this.q0();
            e.this.z(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterFullHD onAnimationEnd: ");
            }
            e.this.q0();
            e.this.z(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterFullHD onAnimationStart: ");
            }
            e.this.r0();
            if (e.this.o != null) {
                e.this.o.onAnimatorStartBaseMapOffsetXY(o.A());
            }
            e.this.C(false);
            if (this.f7735a == 0) {
                e.this.D(true);
            }
            RGHDMapView rGHDMapView = e.this.i;
            if (rGHDMapView != null) {
                rGHDMapView.setShowRect(3, this.b);
                e.this.i.setMapStatus(3, o.A(), this.b);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.hd.hdnavi.e$e, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0319e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7736a;

        public C0319e(boolean z) {
            this.f7736a = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterNormal onAnimationUpdate: " + intValue);
            }
            e.this.a(intValue, this.f7736a, 0);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7737a;

        public f(boolean z) {
            this.f7737a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterNormal onAnimationCancel: ");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            e.this.q0();
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterNormal onAnimationEnd: ");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "getEnterNormal onAnimationStart: ");
            }
            e.this.r0();
            e.this.C(false);
            RGHDMapView rGHDMapView = e.this.i;
            if (rGHDMapView != null) {
                rGHDMapView.setShowRect(0, this.f7737a);
                e.this.i.setMapStatus(0, o.A(), this.f7737a);
            }
        }
    }

    public e(Context context, ViewGroup viewGroup, int i, com.baidu.navisdk.pronavi.hd.hdnavi.model.a aVar) {
        super(context, viewGroup);
        this.i = null;
        this.l = 0;
        this.m = -1;
        this.n = -1;
        this.q = aVar;
        a(false, i);
    }

    private int A(boolean z) {
        if (!j0()) {
            return -1;
        }
        if (z) {
            int i = this.l;
            if (i == 2) {
                return this.q.d();
            }
            if (i == 3) {
                return -1;
            }
        }
        return 0;
    }

    private int B(boolean z) {
        if (j0()) {
            return -1;
        }
        if (z) {
            int i = this.l;
            if (i == 2) {
                return this.q.b();
            }
            if (i == 3) {
                return -1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "setDoubleMapUpperUiVisible: " + z);
        }
        com.baidu.navisdk.pronavi.hd.hdnavi.d dVar = this.k;
        if (dVar != null) {
            if (z) {
                dVar.y();
            } else {
                dVar.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z) {
        int i;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "setHdMapViewVisible: " + z);
        }
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            frameLayout.setVisibility(i);
        }
    }

    private void p0() {
        if (this.o == null) {
            RGHDBaseMapHelper rGHDBaseMapHelper = new RGHDBaseMapHelper(this.q);
            this.o = rGHDBaseMapHelper;
            rGHDBaseMapHelper.addSurfaceListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        if (this.i != null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "onAnimEndSetHDMapFPS: ");
            }
            this.i.recoveryFps();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        if (this.i != null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDView", "onAnimStartSetHDMapFPS: ");
            }
            this.i.interruptFpsLimit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "cancelHDMapRadiusShadow: " + z);
        }
        View view = this.p;
        if (view != null) {
            view.setVisibility(8);
        }
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            View mapView = rGHDMapView.getMapView();
            if (mapView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) mapView.getLayoutParams();
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
            }
            if (z) {
                this.i.hideMapViewRoundCorner();
            }
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        int i3;
        ValueAnimator valueAnimator;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "getEnterFullHD: " + i + ", " + z + "," + i2);
        }
        int d2 = com.baidu.navisdk.pronavi.util.a.h.d();
        if (i == 0) {
            i3 = 0;
        } else if (i == 2) {
            i3 = this.q.a(z);
        } else {
            i3 = -1;
        }
        if (i3 >= 0) {
            valueAnimator = ValueAnimator.ofInt(i3, d2);
        } else {
            valueAnimator = null;
        }
        if (valueAnimator == null) {
            return null;
        }
        valueAnimator.addUpdateListener(new c(d2, z, i));
        valueAnimator.addListener(new d(i, z));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(valueAnimator);
        return arrayList;
    }

    public boolean e(Bundle bundle) {
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            return rGHDMapView.setHdDataToMap(bundle);
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void h() {
        super.h();
        RGHDBaseMapHelper rGHDBaseMapHelper = this.o;
        if (rGHDBaseMapHelper != null) {
            rGHDBaseMapHelper.onSizeChange();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        D(false);
        RGHDBaseMapHelper rGHDBaseMapHelper = this.o;
        if (rGHDBaseMapHelper != null) {
            rGHDBaseMapHelper.onDestroy(j0());
            this.o = null;
        }
        com.baidu.navisdk.pronavi.hd.hdnavi.d dVar = this.k;
        if (dVar != null) {
            dVar.i();
            this.k = null;
        }
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            rGHDMapView.onDestroy();
            this.i = null;
        }
        this.l = 0;
    }

    public void n0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "enterNaviState: ");
        }
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            rGHDMapView.enterNaviMode();
        }
    }

    public void o0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "exitBrowser: ");
        }
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            rGHDMapView.enterNaviMode();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.a
    public void onHdStateSwitch(int i, int i2, boolean z) {
        RGHDMapView rGHDMapView;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "onHdStateSwitch: " + i + oIX0oI.f33048oxoX + i2 + ",isPortrait: " + z);
        }
        this.l = i2;
        p0();
        if (i == 0 || i2 == 1) {
            RGHDBaseMapHelper.Companion.initOriginalWinRound(z);
        }
        if (i2 != 1 && (rGHDMapView = this.i) != null) {
            rGHDMapView.onHdStateSwitch(i, i2, z);
        }
        RGHDBaseMapHelper rGHDBaseMapHelper = this.o;
        if (rGHDBaseMapHelper != null) {
            rGHDBaseMapHelper.onHdStateSwitch(i, i2, z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void onResume() {
        super.onResume();
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            rGHDMapView.onResume();
        }
    }

    public void v(int i) {
        this.m = i;
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            rGHDMapView.setMapFps(i);
        }
    }

    public void w(int i) {
        this.n = i;
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            rGHDMapView.setNativeFps(i);
        }
    }

    public void y(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "setMapNightMode: " + z);
        }
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            rGHDMapView.setMapNightMode(z);
        }
    }

    private void b(boolean z, int i) {
        int i2;
        int dimensionPixelSize;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "changeLayout: " + z + "," + i);
        }
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.width = B(z);
            layoutParams.height = A(z);
            a(layoutParams, i != 2, this.l);
            this.j.requestLayout();
            int i3 = -1;
            if (j0()) {
                i2 = R.drawable.nsdk_rg_hd_view_shadow;
                i3 = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_30dp);
                dimensionPixelSize = -1;
            } else {
                i2 = R.drawable.nsdk_rg_hd_view_land_shadow;
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_hd_shadow_portrait_height);
            }
            View view = this.p;
            if (view != null) {
                com.baidu.navisdk.ui.util.b.a(view, i2);
                ViewGroup.LayoutParams layoutParams2 = this.p.getLayoutParams();
                layoutParams2.width = dimensionPixelSize;
                layoutParams2.height = i3;
                this.p.requestLayout();
            }
        }
    }

    private void c(boolean z, int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "createAndAddHDMap: " + z);
            gVar.e("RGHDView", "onCreate hdMapFps:" + this.m + ", mNativeFps" + this.n);
        }
        View onCreate = this.i.onCreate(this.f9165a, i);
        int i2 = this.m;
        if (i2 > -1) {
            this.i.setMapFps(i2);
        }
        int i3 = this.n;
        if (i3 > -1) {
            this.i.setNativeFps(i3);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        if (onCreate.getParent() instanceof ViewGroup) {
            ((ViewGroup) onCreate.getParent()).removeView(onCreate);
        }
        this.j.addView(onCreate, 0, marginLayoutParams);
        this.i.onResume();
    }

    public void a(com.baidu.navisdk.framework.interfaces.pronavi.hd.d dVar) {
        com.baidu.navisdk.pronavi.hd.hdnavi.d dVar2 = this.k;
        if (dVar2 != null) {
            dVar2.a(dVar);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "orientationChanged: " + i + ",mHdMapState:" + this.l);
        }
        b(true, i);
        com.baidu.navisdk.pronavi.hd.hdnavi.d dVar = this.k;
        if (dVar != null) {
            dVar.a(viewGroup, i);
            if (this.l == 2) {
                this.k.y();
            } else {
                this.k.c();
            }
        }
        if (this.l == 1) {
            if (gVar.d()) {
                gVar.e("RGHDView", "orientationChanged: PRELOAD");
                return;
            }
            return;
        }
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            rGHDMapView.onOrientationChange(i);
        }
        boolean z = i != 2;
        if (this.o == null && gVar.c() && gVar.d()) {
            gVar.c("RGHDView", "orientationChanged:  mBaseMapHelper = null");
            if (gVar.d()) {
                gVar.a("orientationChanged", new Throwable());
            }
        }
        if (this.l == 2) {
            b(z, true);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        int d2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "getEnterNormal: " + i + ", " + z + "," + i2);
        }
        RGHDBaseMapHelper rGHDBaseMapHelper = this.o;
        if (rGHDBaseMapHelper != null) {
            rGHDBaseMapHelper.setMapShowScreenRect();
            if (!a(RGFSMTable.FsmState.Fullview)) {
                this.o.onAnimatorStartBaseMapOffsetXY(o.A());
            }
        }
        if (i == 2) {
            d2 = this.q.a(z);
        } else {
            d2 = i == 3 ? com.baidu.navisdk.pronavi.util.a.h.d() : -1;
        }
        a(i, 0, z, 0, 0);
        ValueAnimator ofInt = d2 >= 0 ? ValueAnimator.ofInt(d2, 0) : null;
        if (ofInt == null) {
            return null;
        }
        ofInt.addUpdateListener(new C0319e(z));
        ofInt.addListener(new f(z));
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(ofInt);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "setHDMapRadiusShadow: " + z);
        }
        View view = this.p;
        if (view != null) {
            view.setVisibility(0);
        }
        RGHDMapView rGHDMapView = this.i;
        if (rGHDMapView != null) {
            View mapView = rGHDMapView.getMapView();
            if (mapView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) mapView.getLayoutParams();
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.navisdk.pronavi.hd.hdnavi.model.a.h.a();
                    marginLayoutParams.leftMargin = 0;
                } else {
                    marginLayoutParams.leftMargin = com.baidu.navisdk.pronavi.hd.hdnavi.model.a.h.b();
                    marginLayoutParams.topMargin = 0;
                }
                mapView.requestLayout();
            }
            if (z) {
                this.i.showMapViewRoundCorner(new com.baidu.navisdk.pronavi.hd.a(com.baidu.navisdk.pronavi.hd.hdnavi.model.a.h.c()));
            } else if (z2) {
                this.i.hideMapViewRoundCorner();
            }
        }
    }

    public void a(boolean z, int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "initView: " + z + "," + i);
        }
        if (this.j != null) {
            return;
        }
        if (!z) {
            this.i = new RGHDMapView(this.q);
        }
        ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.bnav_rg_hd_map_stub);
        if (viewStub != null) {
            try {
                com.baidu.navisdk.ui.util.b.a(viewStub);
            } catch (Exception e) {
                if (g.PRO_NAV.c()) {
                    g.PRO_NAV.c("RGHDView", "initView: " + e.toString());
                }
            }
        }
        this.p = this.b.findViewById(R.id.bnav_rg_hd_shadow_view);
        this.j = (FrameLayout) this.b.findViewById(R.id.bnav_rg_hd_map_container);
        b(z, i);
        c(z, i);
        if (z) {
            return;
        }
        this.k = new com.baidu.navisdk.pronavi.hd.hdnavi.d(this.f9165a, this.j);
    }

    private void a(FrameLayout.LayoutParams layoutParams, boolean z, int i) {
        if (z) {
            layoutParams.gravity = 8388691;
            layoutParams.rightMargin = 0;
            if (i == 2) {
                layoutParams.bottomMargin = this.q.e();
                return;
            } else {
                layoutParams.bottomMargin = 0;
                return;
            }
        }
        layoutParams.gravity = 8388629;
        layoutParams.bottomMargin = 0;
        if (i == 2) {
            layoutParams.rightMargin = this.q.a();
        } else {
            layoutParams.rightMargin = 0;
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        int i3;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDView", "getEnterDoubleMap: " + i + ", isPort:" + z + "," + i2);
        }
        RGHDBaseMapHelper rGHDBaseMapHelper = this.o;
        if (rGHDBaseMapHelper != null) {
            rGHDBaseMapHelper.setMapShowScreenRect();
        }
        if (i == 0) {
            i3 = 0;
        } else if (i == 3) {
            i3 = com.baidu.navisdk.pronavi.util.a.h.d();
            a(i, 2, z, i2, i2);
        } else {
            i3 = -1;
        }
        ValueAnimator ofInt = i3 >= 0 ? ValueAnimator.ofInt(i3, this.q.a(z)) : null;
        if (ofInt == null) {
            return null;
        }
        ofInt.addUpdateListener(new a(z, i, i2));
        ofInt.addListener(new b(z, i));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(ofInt);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, int i2) {
        FrameLayout frameLayout = this.j;
        if (frameLayout == null) {
            g gVar = g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("RGHDView", "changeHDMapViewHeight:  mHDMapViewContainer == null");
                return;
            }
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        a(layoutParams, z, i2);
        if (z) {
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.j.requestLayout();
                return;
            }
            return;
        }
        if (layoutParams.width != i) {
            layoutParams.width = i;
            this.j.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, boolean z, int i3, int i4) {
        if (this.o != null) {
            if (i2 == 2 && i3 == i4) {
                i3 -= com.baidu.navisdk.pronavi.hd.hdnavi.model.a.h.b();
            }
            this.o.changeBaseMapWinRound(i3, z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        com.baidu.navisdk.pronavi.hd.hdnavi.d dVar = this.k;
        if (dVar != null) {
            dVar.a(z);
        }
    }
}
