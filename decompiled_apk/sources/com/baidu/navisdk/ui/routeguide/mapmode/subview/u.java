package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.map.g;
import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes8.dex */
public class u extends com.baidu.navisdk.ui.routeguide.widget.d {
    private static String f0 = "方向";
    private FrameLayout A;
    private LinearLayout B;
    private ImageView C;
    private TextView D;
    private RelativeLayout E;
    private View F;
    private TextView G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private boolean S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private Animation X;
    private Animation Y;
    private TextView Z;
    private ImageView a0;
    private TextView b0;
    private View c0;
    private Animation.AnimationListener d0;
    private Animation.AnimationListener e0;
    private boolean i;
    private boolean j;
    private View k;
    private ViewGroup l;
    private View m;
    private ViewGroup n;
    private com.baidu.nplatform.comapi.map.g o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private ImageView u;
    private ProgressBar v;
    private ImageView w;
    private View x;
    private View y;
    private ImageView z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", null, String.valueOf(com.baidu.navisdk.ui.routeguide.model.i.s().d()), null);
            u.this.o0();
            com.baidu.navisdk.ui.routeguide.model.i.s().b(0);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", null, String.valueOf(com.baidu.navisdk.ui.routeguide.model.i.s().d()), null);
            u.this.o0();
            com.baidu.navisdk.ui.routeguide.model.i.s().b(0);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.q", null, String.valueOf(com.baidu.navisdk.ui.routeguide.model.i.s().d()), null);
            u.this.o0();
            com.baidu.navisdk.ui.routeguide.model.i.s().b(0);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "showAnimationEnd: --> " + com.baidu.navisdk.ui.routeguide.control.n.d().f8567a);
            }
            u.this.Q0();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "onAnimationStart");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements g.a {
        public e(u uVar) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.nplatform.comapi.map.g.a
        public void a(com.baidu.nplatform.comapi.map.g gVar) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMMEnlargeRoadMapView", "onSurfaceViewDetachFromWindow");
            }
            if (gVar == 0) {
                return;
            }
            gVar.setDetachWindowListener(null);
            if (gVar.getParent() == null) {
                return;
            }
            ((ViewGroup) gVar.getParent()).removeView((View) gVar);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "hideAnimationEnd: --> ");
            }
            u.this.J0();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "hideAnimationStart: --> ");
            }
        }
    }

    public u(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = false;
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.S = false;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = new d();
        this.e0 = new f();
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            this.j = k.f0();
        }
        C(false);
        L0();
        z(this.j);
    }

    private void A(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "notifyEnlargeVisible: " + z);
        }
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s != null) {
            s.j().e("RGNormalHDComponent").a(ErrorCode.ERROR_NO_NETWORK).a(Boolean.valueOf(z)).a();
        }
    }

    private void B(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "update raster, raster type=" + this.J + "show," + z + "," + this.V);
        }
        if (z || this.V) {
            this.V = false;
            if (RouteGuideParams.RasterType.DIRECT_BOARD.equals(this.J)) {
                R0();
            } else if (RouteGuideParams.RasterType.GRID.equals(this.J)) {
                U0();
            } else if (RouteGuideParams.RasterType.VECTOR.equals(this.J)) {
                X0();
            } else if (RouteGuideParams.RasterType.STREET.equals(this.J)) {
                V0();
            }
        }
        S0();
        T0();
        W0();
        P0();
    }

    private void C(boolean z) {
        Object valueOf;
        if (this.j) {
            z = false;
        }
        if (this.n != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "showCommonWindowView: --> " + z + ", mCommonWindowMapGLSurfaceView: " + this.o);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v(z);
            if (z) {
                com.baidu.nplatform.comapi.map.g gVar2 = this.o;
                if (gVar2 != null && this.n != null) {
                    gVar2.setVisibility(0);
                    ImageView imageView = this.p;
                    if (imageView != null) {
                        imageView.setVisibility(4);
                    }
                }
                this.n.setVisibility(0);
            } else {
                com.baidu.nplatform.comapi.map.g gVar3 = this.o;
                if (gVar3 != null) {
                    gVar3.awakeDrawWaitEvent();
                    this.o.setVisibility(8);
                }
                this.n.setVisibility(8);
            }
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("showCommonWindowView end --> mCommonWindowMapGLSurfaceView= ");
                com.baidu.nplatform.comapi.map.g gVar4 = this.o;
                Object obj = "null";
                if (gVar4 == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(gVar4.getVisibility());
                }
                sb.append(valueOf);
                sb.append(", mCommonWindowRl.getChildCount= ");
                ViewGroup viewGroup = this.n;
                if (viewGroup != null) {
                    obj = Integer.valueOf(viewGroup.getChildCount());
                }
                sb.append(obj);
                gVar.e("RGMMEnlargeRoadMapView", sb.toString());
            }
        }
    }

    private void C0() {
        int a2;
        if (!com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
            int d2 = com.baidu.navisdk.ui.routeguide.model.i.s().d();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.q.1", String.valueOf(d2), null, null);
            if (RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J)) {
                a2 = 5;
            } else if (RouteGuideParams.RasterType.DEST_STREET.equals(this.J)) {
                a2 = 3;
            } else if (RouteGuideParams.RasterType.VECTOR.equals(this.J)) {
                a2 = 1;
            } else {
                a2 = com.baidu.navisdk.ui.routeguide.model.i.s().a(d2);
            }
            BNRouteGuider.getInstance().setExpandMapStatics(false, a2);
        }
    }

    private void D0() {
        if (this.l != null) {
            Animation animation = this.X;
            if (animation != null) {
                animation.setAnimationListener(null);
            }
            Animation animation2 = this.Y;
            if (animation2 != null) {
                animation2.setAnimationListener(null);
            }
            this.l.clearAnimation();
        }
    }

    private void E0() {
        if (!a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "exePause-> isVisibility=" + a());
                return;
            }
            return;
        }
        if (this.o != null && RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J)) {
            n0();
        }
    }

    private void F0() {
        if (a() && com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
            if (RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J)) {
                y0();
                C(true);
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "exeResume-> isVisibility=" + a() + "isAnyEnlargeRoadMapShowing=" + com.baidu.navisdk.ui.routeguide.model.i.s().k());
        }
    }

    public static int G0() {
        return com.baidu.navisdk.pronavi.util.a.h.d() / 2;
    }

    public static int H0() {
        return com.baidu.navisdk.pronavi.util.a.h.d() / 2;
    }

    private int I0() {
        int r0;
        int i = 0;
        if (this.q != null && this.r != null && this.G != null && this.s != null && this.t != null && this.D != null) {
            int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left) * 2;
            TextView textView = this.q;
            int a2 = com.baidu.navisdk.ui.util.j.a(textView, textView.getText().toString());
            int dimensionPixelOffset2 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_remain_dist_margin_left);
            TextView textView2 = this.r;
            int a3 = com.baidu.navisdk.ui.util.j.a(textView2, textView2.getText().toString());
            Resources resources = JarUtils.getResources();
            int i2 = R.dimen.nsdk_rg_enlarge_remain_dist_unit_margin_left;
            int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i2);
            int dimensionPixelOffset4 = JarUtils.getResources().getDimensionPixelOffset(i2);
            int dimensionPixelOffset5 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_next_turn_size);
            if (this.G.getVisibility() == 0) {
                TextView textView3 = this.G;
                i = com.baidu.navisdk.ui.util.j.a(textView3, textView3.getText().toString()) + JarUtils.getResources().getDimensionPixelOffset(i2);
            }
            TextView textView4 = this.s;
            int a4 = com.baidu.navisdk.ui.util.j.a(textView4, textView4.getText().toString());
            int dimensionPixelOffset6 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_enter_text_margin_left);
            int dimensionPixelOffset7 = JarUtils.getResources().getDimensionPixelOffset(i2);
            int dimensionPixelOffset8 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp);
            if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
                r0 = com.baidu.navisdk.pronavi.util.a.h.e();
            } else {
                r0 = r0();
            }
            int i3 = r0 - (((((((((((dimensionPixelOffset + a2) + dimensionPixelOffset2) + a3) + dimensionPixelOffset3) + dimensionPixelOffset4) + dimensionPixelOffset5) + i) + a4) + dimensionPixelOffset6) + dimensionPixelOffset7) + dimensionPixelOffset8);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "isNextTurnWidthEnough-> 剩余空间= " + i3);
            }
            return i3;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGMMEnlargeRoadMapView", "getExitNameMaxWidth-> view == null,return ! ");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "hideEndAfter()");
        }
        C(false);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().w(false);
        if (BNSettingManager.isRootScreenOpen() && RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J) && gVar.d()) {
            com.baidu.navisdk.util.drivertool.e.l().a();
        }
    }

    public static void K0() {
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        int e2 = aVar.e();
        Resources resources = JarUtils.getResources();
        int i = R.dimen.nsdk_rg_guide_panel_shadow_left;
        int dimensionPixelSize = e2 - (resources.getDimensionPixelSize(i) * 2);
        int d2 = aVar.d() / 2;
        Resources resources2 = JarUtils.getResources();
        int i2 = R.dimen.nsdk_rg_guide_panel_shadow_top;
        int dimensionPixelSize2 = d2 - resources2.getDimensionPixelSize(i2);
        Resources resources3 = JarUtils.getResources();
        int i3 = R.dimen.nsdk_rg_enlarge_bottom_shadow_height;
        int dimensionPixelSize3 = (dimensionPixelSize2 - resources3.getDimensionPixelSize(i3)) - JarUtils.getResources().getDimensionPixelSize(i);
        Resources resources4 = JarUtils.getResources();
        int i4 = R.dimen.nsdk_rg_enlarge_guide_info_height;
        int dimensionPixelSize4 = dimensionPixelSize3 - resources4.getDimensionPixelSize(i4);
        int d3 = (aVar.d() / 2) - (JarUtils.getResources().getDimensionPixelSize(i) * 2);
        int d4 = ((((aVar.d() / 2) - JarUtils.getResources().getDimensionPixelSize(i2)) - JarUtils.getResources().getDimensionPixelSize(i3)) - JarUtils.getResources().getDimensionPixelSize(i)) - JarUtils.getResources().getDimensionPixelSize(i4);
        if (com.baidu.navisdk.ui.routeguide.b.V().r().g()) {
            dimensionPixelSize4 -= ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
            d4 -= ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
        }
        int i5 = d4;
        int i6 = dimensionPixelSize4;
        int X = com.baidu.navisdk.ui.routeguide.control.x.b().X();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "initDynamicWindowShowSize: --> iVWidth: " + dimensionPixelSize + "iVHeight: " + i6 + ",iHWidth: " + d3 + ", iHHeight: " + i5);
        }
        BNMapController.getInstance().setDynamicWindowShowSize(dimensionPixelSize, i6, d3, i5, X);
    }

    private void L0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "initViews");
        }
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "mRootViewGroup == null");
                return;
            }
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.bnav_rg_enlarge_road_map_stub);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Exception e2) {
                if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    com.baidu.navisdk.util.common.g.PRO_NAV.e("RGMMEnlargeRoadMapView", "initViews Exception :" + e2.getMessage());
                    return;
                }
                return;
            }
        }
        View findViewById = this.b.findViewById(R.id.bnav_rg_enlarge_road_map_container);
        this.k = findViewById;
        if (findViewById == null) {
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "mEnlargeRoadMapViewContainer == null");
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) findViewById.findViewById(R.id.bnav_rg_enlarge_road_map);
        this.l = viewGroup2;
        this.m = viewGroup2.findViewById(R.id.bnav_rg_vector_enlarge_guide_info_background);
        this.E = (RelativeLayout) this.l.findViewById(R.id.bnav_rg_enlarge_info);
        this.p = (ImageView) this.l.findViewById(R.id.bnav_rg_enlarge_image);
        this.q = (TextView) this.l.findViewById(R.id.bnav_rg_enlarge_remain_dist);
        this.r = (TextView) this.l.findViewById(R.id.bnav_rg_enlarge_remain_dist_unit);
        this.t = (TextView) this.l.findViewById(R.id.bnav_rg_enlarge_next_road);
        this.s = (TextView) this.l.findViewById(R.id.bnav_rg_enter_enlarge_next_road);
        this.u = (ImageView) this.l.findViewById(R.id.bnav_rg_enlarge_turn_icon);
        this.v = (ProgressBar) this.l.findViewById(R.id.bnav_rg_enlarge_progress);
        this.w = (ImageView) this.l.findViewById(R.id.bnav_rg_enlarge_open_close);
        new Matrix();
        this.x = this.l.findViewById(R.id.bnav_rg_enlarge_carpos_layout);
        this.z = (ImageView) this.l.findViewById(R.id.bnav_rg_enlarge_carpos_image);
        this.A = (FrameLayout) this.l.findViewById(R.id.bnav_rg_street_layout);
        this.y = this.l.findViewById(R.id.bnav_rg_enlarge_image_mask);
        this.B = (LinearLayout) this.l.findViewById(R.id.bnav_rg_next_turn_layout);
        this.C = (ImageView) this.l.findViewById(R.id.bnav_rg_next_turn_image);
        this.D = (TextView) this.l.findViewById(R.id.bnav_rg_next_turn_text);
        this.n = (ViewGroup) this.b.findViewById(R.id.bnav_rg_common_window_view_rl);
        this.F = this.l.findViewById(R.id.bnav_enlarge_bottom_shadow);
        this.G = (TextView) this.l.findViewById(R.id.bnav_rg_enlarge_high_way_exit_code);
        this.c0 = this.l.findViewById(R.id.bnav_rg_next_turn_replace_layout);
        this.Z = (TextView) this.l.findViewById(R.id.bnav_rg_enlarge_replace_text);
        this.b0 = (TextView) this.l.findViewById(R.id.bnav_rg_next_turn_replace_text);
        this.a0 = (ImageView) this.l.findViewById(R.id.bnav_rg_next_turn_replace_image);
        f0();
        ViewGroup viewGroup3 = this.n;
        if (viewGroup3 != null) {
            viewGroup3.setOnClickListener(new a());
        }
        this.w.setOnClickListener(new b());
        this.l.setOnClickListener(new c());
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 2) {
            this.X = JarUtils.loadAnimation(this.f9165a, R.anim.nsdk_anim_rg_slide_in_left);
            this.Y = JarUtils.loadAnimation(this.f9165a, R.anim.nsdk_anim_rg_slide_out_left);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
            marginLayoutParams.width = r0();
            marginLayoutParams.height = q0();
            this.l.requestLayout();
            ViewGroup viewGroup4 = this.n;
            if (viewGroup4 != null) {
                ViewGroup.LayoutParams layoutParams = viewGroup4.getLayoutParams();
                layoutParams.width = r0();
                layoutParams.height = q0();
                this.n.requestLayout();
                return;
            }
            return;
        }
        this.F.setVisibility(0);
        this.X = JarUtils.loadAnimation(this.f9165a, R.anim.nsdk_anim_rg_slide_in_top);
        this.Y = JarUtils.loadAnimation(this.f9165a, R.anim.nsdk_anim_rg_slide_out_top);
        ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
        layoutParams2.width = w0();
        layoutParams2.height = u0();
        this.l.requestLayout();
        ViewGroup viewGroup5 = this.n;
        if (viewGroup5 != null) {
            ViewGroup.LayoutParams layoutParams3 = viewGroup5.getLayoutParams();
            layoutParams3.width = w0();
            layoutParams3.height = u0();
            this.n.requestLayout();
        }
    }

    private boolean M0() {
        int i;
        int i2;
        boolean z;
        int a2;
        int r0;
        if (this.q != null && this.r != null && this.G != null && this.s != null && this.t != null && this.D != null && this.Z != null && this.b0 != null) {
            int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left) * 2;
            TextView textView = this.q;
            int a3 = com.baidu.navisdk.ui.util.j.a(textView, textView.getText().toString());
            Resources resources = JarUtils.getResources();
            int i3 = R.dimen.nsdk_rg_enlarge_remain_dist_margin_left;
            int dimensionPixelOffset2 = resources.getDimensionPixelOffset(i3);
            int dimensionPixelOffset3 = JarUtils.getResources().getDimensionPixelOffset(i3);
            TextView textView2 = this.r;
            int a4 = com.baidu.navisdk.ui.util.j.a(textView2, textView2.getText().toString());
            Resources resources2 = JarUtils.getResources();
            int i4 = R.dimen.nsdk_rg_enlarge_remain_dist_unit_margin_left;
            int dimensionPixelOffset4 = resources2.getDimensionPixelOffset(i4);
            int dimensionPixelOffset5 = JarUtils.getResources().getDimensionPixelOffset(i4);
            int dimensionPixelOffset6 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_guide_first_turn_icon_size);
            if (this.G.getVisibility() == 0) {
                TextView textView3 = this.G;
                i = com.baidu.navisdk.ui.util.j.a(textView3, textView3.getText().toString());
            } else {
                i = 0;
            }
            TextView textView4 = this.s;
            int a5 = com.baidu.navisdk.ui.util.j.a(textView4, textView4.getText().toString());
            int dimensionPixelOffset7 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_enter_text_margin_left);
            TextView textView5 = this.t;
            int a6 = com.baidu.navisdk.ui.util.j.a(textView5, textView5.getText().toString());
            int dimensionPixelOffset8 = JarUtils.getResources().getDimensionPixelOffset(i4);
            int dimensionPixelOffset9 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_10dp);
            boolean isEmpty = TextUtils.isEmpty(this.L);
            if (isEmpty) {
                z = isEmpty;
                TextView textView6 = this.D;
                i2 = dimensionPixelOffset9;
                a2 = com.baidu.navisdk.ui.util.j.a(textView6, textView6.getText().toString());
            } else {
                i2 = dimensionPixelOffset9;
                z = isEmpty;
                TextView textView7 = this.b0;
                a2 = com.baidu.navisdk.ui.util.j.a(textView7, textView7.getText().toString());
            }
            int dimensionPixelOffset10 = a2 + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_next_turn_size);
            if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
                r0 = com.baidu.navisdk.pronavi.util.a.h.e();
            } else {
                r0 = r0();
            }
            int i5 = dimensionPixelOffset + a3 + dimensionPixelOffset2 + a4 + dimensionPixelOffset4;
            int i6 = dimensionPixelOffset5 + i5 + dimensionPixelOffset6 + i + a5 + dimensionPixelOffset3 + dimensionPixelOffset7 + a6 + dimensionPixelOffset8 + i2;
            if (!z) {
                i6 = i5 + i2 + dimensionPixelOffset3 + com.baidu.navisdk.ui.util.j.a(this.Z, this.L + ",") + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp);
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "isNextTurnWidthEnough-> 总宽度= " + r0 + "剩余空间= " + (r0 - i6) + " 需要空间= " + dimensionPixelOffset10);
            }
            if (r0 - i6 > dimensionPixelOffset10) {
                return true;
            }
            return false;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGMMEnlargeRoadMapView", "isNextTurnWidthEnough-> view == null,return ! ");
            return false;
        }
        return false;
    }

    private void N0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "update raster, raster type=" + this.J + "," + this.R + "," + this.V);
        }
        if (this.R || this.V) {
            this.V = false;
            if (RouteGuideParams.RasterType.DIRECT_BOARD.equals(this.J)) {
                R0();
            } else if (RouteGuideParams.RasterType.GRID.equals(this.J)) {
                U0();
            } else if (RouteGuideParams.RasterType.VECTOR.equals(this.J)) {
                X0();
            } else if (RouteGuideParams.RasterType.STREET.equals(this.J)) {
                V0();
            }
        }
        S0();
        T0();
        W0();
        P0();
    }

    private void O0() {
        Drawable d2;
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().i() && (d2 = com.baidu.navisdk.ui.routeguide.model.a0.I().e().d()) != null && this.B != null && this.C != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "初始化恢复 随后 内容（放大图）");
            }
            this.C.setImageDrawable(d2);
            v(0);
        }
    }

    private void P0() {
        int i;
        boolean isEmpty = TextUtils.isEmpty(this.L);
        boolean isEmpty2 = TextUtils.isEmpty(this.M);
        TextView textView = this.Z;
        if (textView != null) {
            if (!isEmpty) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            this.Z.setText(this.L);
            w(JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_240dp));
        }
        View view = this.c0;
        if (view != null && this.a0 != null) {
            if (!isEmpty2) {
                if (M0()) {
                    this.c0.setVisibility(0);
                    TextView textView2 = this.Z;
                    if (textView2 != null) {
                        textView2.setText(this.L + ",");
                    }
                    try {
                        if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
                            this.a0.setImageDrawable(JarUtils.getResources().getDrawable(this.N));
                        } else {
                            this.a0.setImageDrawable(com.baidu.navisdk.ui.routeguide.subview.util.b.a(this.N));
                        }
                    } catch (Throwable unused) {
                        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar.d()) {
                            gVar.e("RGMMEnlargeRoadMapView", "setReplaceNextTurnIcon setImageDrawable throwable");
                        }
                    }
                    this.N = 0;
                    return;
                }
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e("RGMMEnlargeRoadMapView", "空间不够隐藏mReplaceNextTurnLayout");
                }
                this.c0.setVisibility(8);
                return;
            }
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "showEndAfter()");
        }
        if (com.baidu.navisdk.ui.routeguide.control.n.d().f8567a) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h(true);
        }
    }

    private synchronized void R0() {
        try {
            ImageView imageView = this.p;
            if (imageView != null && this.m != null) {
                com.baidu.navisdk.ui.util.j.a(imageView);
                if (com.baidu.navisdk.ui.routeguide.model.i.s().b() != null && com.baidu.navisdk.ui.routeguide.model.i.s().c() != null) {
                    this.p.setImageBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().b());
                    this.p.setBackgroundDrawable(new BitmapDrawable(com.baidu.navisdk.ui.routeguide.model.i.s().c()));
                }
                this.m.setVisibility(0);
                this.p.setVisibility(0);
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void S0() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.subview.u.S0():void");
    }

    private void T0() {
        int i;
        int i2;
        int i3;
        if (this.t != null && this.s != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "updateRoadInfo, roadName=" + this.K + ", mHighWayExitCode=" + this.H + ", mHighWayExitName=" + this.I);
            }
            boolean isEmpty = TextUtils.isEmpty(this.L);
            int i4 = 0;
            if (!TextUtils.isEmpty(this.H) && !TextUtils.isEmpty(this.I)) {
                TextView textView = this.G;
                if (isEmpty) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                textView.setVisibility(i2);
                this.G.setText(this.H);
                this.s.setText(JarUtils.getResources().getString(R.string.nsdk_string_hw_go));
                x(I0());
                String str = this.I + f0;
                this.I = str;
                this.t.setText(str);
                TextView textView2 = this.t;
                if (isEmpty) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                textView2.setVisibility(i3);
                TextView textView3 = this.s;
                if (!isEmpty) {
                    i4 = 8;
                }
                textView3.setVisibility(i4);
                return;
            }
            x(JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_234dp));
            this.G.setVisibility(8);
            if (!RouteGuideParams.RasterType.VECTOR.equals(this.J) && !RouteGuideParams.RasterType.DIRECT_BOARD.equals(this.J) && !RouteGuideParams.RasterType.GRID.equals(this.J) && !RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J)) {
                if (RouteGuideParams.RasterType.STREET.equals(this.J)) {
                    this.s.setVisibility(0);
                    this.s.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive));
                    if (!TextUtils.isEmpty(this.K)) {
                        this.t.setVisibility(0);
                        this.t.setText(this.K);
                        return;
                    } else {
                        this.t.setVisibility(8);
                        return;
                    }
                }
                this.t.setVisibility(8);
                this.s.setVisibility(8);
                return;
            }
            TextView textView4 = this.t;
            if (isEmpty) {
                i = 0;
            } else {
                i = 8;
            }
            textView4.setVisibility(i);
            TextView textView5 = this.s;
            if (!isEmpty) {
                i4 = 8;
            }
            textView5.setVisibility(i4);
            this.s.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_enter));
            if (!TextUtils.isEmpty(this.K)) {
                this.t.setText(this.K);
                return;
            } else {
                this.t.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_no_name_road));
                return;
            }
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGMMEnlargeRoadMapView", "updateRoadInfo fail view is null");
        }
    }

    private void U0() {
        ImageView imageView = this.p;
        if (imageView != null && this.m != null) {
            com.baidu.navisdk.ui.util.j.a(imageView);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "updateSimpleModelView");
            }
            if (com.baidu.navisdk.ui.routeguide.model.i.s().b() != null && com.baidu.navisdk.ui.routeguide.model.i.s().c() != null) {
                this.p.setImageBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().b());
                this.p.setBackgroundDrawable(new BitmapDrawable(com.baidu.navisdk.ui.routeguide.model.i.s().c()));
            } else if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "getArrowBitmap=" + com.baidu.navisdk.ui.routeguide.model.i.s().b() + ", getBGBitmap=" + com.baidu.navisdk.ui.routeguide.model.i.s().c());
            }
            this.m.setVisibility(0);
            this.p.setVisibility(0);
        }
    }

    private void V0() {
        if (this.p != null && this.m != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "updateStreetView, roadName=" + this.K);
            }
            com.baidu.navisdk.ui.util.j.a(this.p);
            if (com.baidu.navisdk.ui.routeguide.model.i.s().c() != null) {
                if (gVar.d()) {
                    gVar.e("RGMMEnlargeRoadMapView", "!# updateVectorMapView: set bitmap");
                }
                this.p.setImageBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().c());
                this.p.setBackgroundResource(android.R.color.transparent);
            }
            this.m.setVisibility(0);
            this.p.setVisibility(0);
            if (this.y != null && !com.baidu.navisdk.ui.util.b.b()) {
                this.y.setVisibility(0);
            }
        }
    }

    private void W0() {
        if (this.u == null) {
            return;
        }
        int i = 8;
        if (!RouteGuideParams.RasterType.VECTOR.equals(this.J) && !RouteGuideParams.RasterType.DIRECT_BOARD.equals(this.J) && !RouteGuideParams.RasterType.GRID.equals(this.J) && !RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J)) {
            this.u.setVisibility(8);
            return;
        }
        int i2 = this.U;
        if (i2 != 0 && i2 != R.drawable.nsdk_drawable_rg_ic_turn_via_1) {
            ImageView imageView = this.u;
            if (TextUtils.isEmpty(this.L)) {
                i = 0;
            }
            imageView.setVisibility(i);
            try {
                if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
                    this.u.setImageDrawable(JarUtils.getResources().getDrawable(this.U));
                } else {
                    this.u.setImageDrawable(com.baidu.navisdk.ui.routeguide.subview.util.b.a(this.U));
                }
            } catch (Throwable unused) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGMMEnlargeRoadMapView", "updateTurnIcon setImageDrawable throwable");
                }
            }
            this.U = 0;
            return;
        }
        this.u.setVisibility(8);
    }

    private void X0() {
        ImageView imageView = this.p;
        if (imageView != null && this.m != null) {
            com.baidu.navisdk.ui.util.j.a(imageView);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "!# updateVectorMapView:");
            }
            if (com.baidu.navisdk.ui.routeguide.model.i.s().c() != null) {
                if (gVar.d()) {
                    gVar.e("RGMMEnlargeRoadMapView", "!# updateVectorMapView: set bitmap");
                }
                this.p.setImageBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().c());
                this.p.setBackgroundResource(android.R.color.transparent);
            }
            this.m.setVisibility(0);
            this.p.setVisibility(0);
        }
    }

    private void w(int i) {
        TextView textView = this.Z;
        if (textView != null && i > 0 && textView.getMaxWidth() != i) {
            this.Z.setMaxWidth(i);
        }
    }

    private void x(int i) {
        TextView textView = this.t;
        if (textView != null && i > 0 && textView.getMaxWidth() != i) {
            this.t.setMaxWidth(i);
        }
    }

    public void A0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "reset: --> ");
        }
        com.baidu.navisdk.ui.util.j.b(this.p);
        com.baidu.navisdk.ui.util.j.b(this.z);
        n0();
    }

    public void B0() {
        if (!RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState())) {
            return;
        }
        if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState())) {
            this.V = true;
        } else {
            this.V = false;
        }
        d(com.baidu.navisdk.ui.routeguide.model.i.s().e());
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NextDirectionIndicator", "updateDataByLastest - resetNextTurenView()");
        }
        if (TextUtils.isEmpty(this.L)) {
            O0();
            return;
        }
        LinearLayout linearLayout = this.B;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        if (this.l != null) {
            com.baidu.navisdk.ui.routeguide.control.n.d().f8567a = false;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "hide: rasterType --> " + this.J);
            }
            if (RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J)) {
                this.X.setAnimationListener(null);
                ViewGroup viewGroup = this.l;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
                J0();
            } else if (!this.W) {
                this.X.setAnimationListener(null);
                if (!com.baidu.navisdk.ui.routeguide.b.V().E() && !com.baidu.navisdk.j.c()) {
                    this.Y.setDuration(400L);
                    this.Y.setAnimationListener(this.e0);
                    this.l.startAnimation(this.Y);
                } else {
                    J0();
                }
            } else {
                this.W = false;
            }
            A(false);
        }
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        View view = this.x;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView2 = this.z;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        FrameLayout frameLayout = this.A;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        View view2 = this.y;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        C0();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().w(false);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        if (bundle == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "b == null");
                return;
            }
            return;
        }
        if (this.l != null) {
            a(bundle.getBoolean(RouteGuideParams.RGKey.ExpandMap.UpdateProgress), bundle, (Object) null);
        } else {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMMEnlargeRoadMapView", "mEnlargeRoadMapView == null");
            }
        }
        if (BNSettingManager.isRootScreenOpen() && RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J) && com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            com.baidu.navisdk.util.drivertool.e.l().g();
        }
    }

    public void e(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.l != null) {
            a(false, bundle, new Object());
        }
        if (BNSettingManager.isRootScreenOpen() && RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J) && com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            com.baidu.navisdk.util.drivertool.e.l().g();
        }
    }

    public void f(String str) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void f0() {
        super.f0();
        com.baidu.navisdk.ui.routeguide.control.x.b().a(this.k);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "onDispose start.");
        }
        com.baidu.navisdk.ui.util.j.a(this.p);
        com.baidu.navisdk.ui.util.j.a(this.z);
        n0();
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "onDispose end.");
        }
        this.B = null;
        this.C = null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void k0() {
        super.k0();
        E0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void l0() {
        super.l0();
        F0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void m0() {
        super.m0();
        E0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "destroyCommonWindowView-> mCommonWindowMapGLSurfaceView= " + this.o);
        }
        com.baidu.nplatform.comapi.map.g gVar2 = this.o;
        if (gVar2 == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (gVar2.getVisibility() == 0) {
            com.baidu.nplatform.comapi.map.b bVar = com.baidu.nplatform.comapi.map.b.f9495a;
            if (!bVar.b() && !bVar.a()) {
                this.o.setDetachWindowListener(new e(this));
            } else {
                try {
                    ((ViewGroup) gVar2.getParent()).removeView((View) gVar2);
                } catch (Throwable th) {
                    th.printStackTrace();
                    com.baidu.navisdk.util.common.g.PRO_NAV.a("RGMMEnlargeRoadMapView", "RGMMEnlargeRoadMapView gltexture destroy removeView mParent NPE");
                }
            }
        } else {
            try {
                ((ViewGroup) gVar2.getParent()).removeView((View) gVar2);
            } catch (Throwable th2) {
                th2.printStackTrace();
                com.baidu.navisdk.util.common.g.PRO_NAV.a("RGMMEnlargeRoadMapView", "RGMMEnlargeRoadMapView destroy removeView mParent NPE");
            }
        }
        C(false);
        this.o = null;
        if (this.i) {
            Log.e("CommonWindow-Time", "destroyCommonWindowView隐藏耗时->" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void o0() {
        com.baidu.navisdk.ui.routeguide.b.V().w();
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void onResume() {
        super.onResume();
        F0();
    }

    public Bitmap p0() {
        try {
            if (com.baidu.navisdk.ui.routeguide.model.i.s().c() == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().c().getWidth(), com.baidu.navisdk.ui.routeguide.model.i.s().c().getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Matrix matrix = new Matrix();
            canvas.drawBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().c(), matrix, paint);
            if (!RouteGuideParams.RasterType.DIRECT_BOARD.equals(this.J)) {
                if (RouteGuideParams.RasterType.GRID.equals(this.J)) {
                }
                return createBitmap;
            }
            if (com.baidu.navisdk.ui.routeguide.model.i.s().b() != null) {
                canvas.drawBitmap(com.baidu.navisdk.ui.routeguide.model.i.s().b(), matrix, paint);
            }
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int q0() {
        return com.baidu.navisdk.pronavi.util.a.h.d() / 2;
    }

    public int r0() {
        return com.baidu.navisdk.pronavi.util.a.h.d() / 2;
    }

    public boolean s0() {
        LinearLayout linearLayout = this.B;
        if (linearLayout != null) {
            return linearLayout.isShown();
        }
        return false;
    }

    public int t0() {
        return (u0() - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_bottom_shadow_height)) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left);
    }

    public int u0() {
        return ScreenUtil.getInstance().getHeightPixels() / 2;
    }

    public boolean v(int i) {
        boolean z;
        if (!TextUtils.isEmpty(this.L)) {
            LinearLayout linearLayout = this.B;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            return false;
        }
        if (this.B == null || this.C == null) {
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("mNextTurnImg showing? : ");
            if (this.C.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            gVar.e("RGMMEnlargeRoadMapView", sb.toString());
        }
        if (i == 0) {
            if (M0()) {
                this.B.setVisibility(0);
            } else {
                if (gVar.d()) {
                    gVar.e("RGMMEnlargeRoadMapView", "把随后gone掉了");
                }
                this.B.setVisibility(8);
            }
        } else {
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "把随后gone掉了");
            }
            this.B.setVisibility(8);
        }
        return true;
    }

    public int w0() {
        return -1;
    }

    public void x0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "hideWithoutAnimation: rasterType --> " + this.J);
        }
        c();
        C(false);
        if (this.l != null) {
            com.baidu.navisdk.ui.routeguide.control.n.d().f8567a = false;
            this.l.clearAnimation();
            this.l.setVisibility(8);
        }
        View view = this.x;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.z;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        FrameLayout frameLayout = this.A;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        View view2 = this.y;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().w(false);
    }

    public void y(boolean z) {
        this.W = z;
    }

    public void y0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "initCommonWindowView-> mCommonWindowMapGLSurfaceView= " + this.o + ", isVisible= " + com.baidu.navisdk.ui.routeguide.b.V().G());
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().G() && com.baidu.navisdk.ui.routeguide.b.V().C()) {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.nplatform.comapi.map.g gVar2 = this.o;
            if (gVar2 == null) {
                this.o = com.baidu.nplatform.comapi.map.b.f9495a.a(this.f9165a, 0, 0, 0.0f);
            } else if (gVar2.getParent() != null) {
                ((ViewGroup) this.o.getParent()).removeView((View) this.o);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            ViewGroup viewGroup = this.n;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.n.addView((View) this.o, layoutParams);
                if (this.i) {
                    Log.e("CommonWindow-Time", "initCommonWindowView addView耗时->" + (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                return;
            }
            return;
        }
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "initCommonWindowView-> isVisible= " + com.baidu.navisdk.ui.routeguide.b.V().G() + ", isNaviPageOnTop= " + com.baidu.navisdk.ui.routeguide.b.V().C());
        }
    }

    public void z(boolean z) {
        this.j = z;
        if (z) {
            ViewGroup viewGroup = this.l;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            c();
        }
    }

    public boolean z0() {
        boolean z;
        ViewGroup viewGroup = this.l;
        boolean z2 = true;
        if (viewGroup != null) {
            if (viewGroup.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return z;
            }
        } else {
            z = false;
        }
        ViewGroup viewGroup2 = this.n;
        if (viewGroup2 != null) {
            if (viewGroup2.getVisibility() != 0) {
                z2 = false;
            }
            if (z2) {
                return z2;
            }
            return z2;
        }
        return z;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        L0();
        if (this.o == null || !RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J)) {
            return;
        }
        if (this.i) {
            Log.e("CommonWindow-Time", "orientationChanged->");
        }
        n0();
        y0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.j) {
            return false;
        }
        super.y();
        if (this.l != null) {
            com.baidu.navisdk.ui.routeguide.control.n.d().f8567a = true;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMEnlargeRoadMapView", "show: rasterType --> " + this.J + ", forbidAnimation --> " + this.W);
            }
            this.l.setVisibility(0);
            if (RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J)) {
                D0();
                C(true);
                Q0();
            } else if (!this.W) {
                if (!com.baidu.navisdk.ui.routeguide.b.V().E() && !com.baidu.navisdk.j.c()) {
                    this.X.setDuration(400L);
                    this.X.setAnimationListener(this.d0);
                    this.l.startAnimation(this.X);
                } else {
                    Q0();
                }
            } else {
                this.W = false;
            }
            A(true);
        }
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (!RouteGuideParams.RasterType.VECTOR.equals(this.J) && RouteGuideParams.RasterType.STREET.equals(this.J)) {
            this.A.setVisibility(0);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().w(true);
        B0();
        return true;
    }

    private void a(boolean z, Bundle bundle, Object obj) {
        String string = bundle.getString("road_name");
        this.L = bundle.getString(RouteGuideParams.RGKey.ExpandMap.REPLACE_TEXT);
        this.M = bundle.getString(RouteGuideParams.RGKey.ExpandMap.REPLACE_ARROW_MAP);
        int i = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.TotalDist);
        int i2 = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.RemainDist);
        String string2 = bundle.getString(RouteGuideParams.RGKey.ExpandMap.RasterType);
        this.W = bundle.getBoolean(RouteGuideParams.RGKey.ExpandMap.ForbidAnimation, false);
        this.S = bundle.getBoolean("remain_dist_hide", false);
        if (!TextUtils.isEmpty(string)) {
            this.K = string;
        }
        if (!TextUtils.isEmpty(this.M)) {
            this.N = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.REPLACE_ARROW_MAP_RES_ID, 0);
        }
        this.J = string2;
        this.O = i;
        this.P = i2;
        boolean z2 = !z;
        this.R = z2;
        int i3 = 100;
        if (i2 > 0 && i > 0) {
            i3 = ((i - i2) * 100) / i;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "!# mRoadName=" + this.K + ", " + this.J + ", updateRaster=" + this.R);
            gVar.e("RGMMEnlargeRoadMapView", "!# Raster Pos = " + i3 + " Total = " + this.O + " Rem = " + this.P);
            StringBuilder sb = new StringBuilder();
            sb.append("!# mReplaceText = ");
            sb.append(this.L);
            sb.append(" mReplaceArrowMap = ");
            sb.append(this.M);
            gVar.e("RGMMEnlargeRoadMapView", sb.toString());
            gVar.e("RGMMEnlargeRoadMapView", "!# mReplaceArrowMapResId = " + this.N);
        }
        this.Q = i3;
        if (RouteGuideParams.RasterType.VECTOR.equals(this.J) || RouteGuideParams.RasterType.DIRECT_BOARD.equals(this.J) || RouteGuideParams.RasterType.GRID.equals(this.J) || RouteGuideParams.RasterType.COMMON_WINDOW.equals(this.J)) {
            this.U = bundle.getInt("resid", 0);
        }
        if (RouteGuideParams.RasterType.VECTOR.equals(this.J)) {
            bundle.getInt(RouteGuideParams.RGKey.ExpandMap.CarPosX, 0);
            bundle.getInt(RouteGuideParams.RGKey.ExpandMap.CarPosY, 0);
            this.T = -bundle.getInt(RouteGuideParams.RGKey.ExpandMap.CarRotate, 0);
        } else {
            ImageView imageView = this.z;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
        }
        if (!RouteGuideParams.RasterType.STREET.equals(this.J)) {
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            View view = this.y;
            if (view != null) {
                view.setVisibility(4);
            }
        }
        com.baidu.navisdk.module.pronavi.model.d dVar = null;
        this.H = null;
        this.I = null;
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null) {
            int i4 = com.baidu.navisdk.ui.routeguide.model.a0.A.getInt("nGPAddDist");
            com.baidu.navisdk.module.pronavi.model.d e2 = com.baidu.navisdk.ui.routeguide.b.V().i().c().e();
            if (gVar.d()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("updateRasterMapInfo, addDist=");
                sb2.append(i4);
                sb2.append(", directionData=");
                sb2.append(e2 == null ? "null" : e2.toString());
                gVar.e("RGMMEnlargeRoadMapView", sb2.toString());
            }
            if (e2 != null && e2.a() == i4 && !com.baidu.navisdk.util.common.l0.c(e2.d())) {
                dVar = e2;
            }
            if (dVar == null) {
                com.baidu.navisdk.module.pronavi.model.d j = com.baidu.navisdk.ui.routeguide.b.V().i().c().j();
                if (gVar.d()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("updateRasterMapInfo, addDist=");
                    sb3.append(i4);
                    sb3.append(", nextExit=");
                    sb3.append(j != null ? j.toString() : "null");
                    gVar.e("RGMMEnlargeRoadMapView", sb3.toString());
                }
                if (j != null && j.k() < 2000 && j.a() == i4) {
                    dVar = j;
                }
            }
            if (dVar != null && dVar.a() == i4) {
                this.H = "出口" + dVar.d();
                this.I = dVar.h();
            }
        }
        if (obj == null) {
            N0();
        } else {
            B(z2);
        }
    }

    public boolean a(Drawable drawable) {
        ImageView imageView;
        if (!TextUtils.isEmpty(this.L) || drawable == null || (imageView = this.C) == null) {
            return false;
        }
        imageView.setImageDrawable(drawable);
        return true;
    }

    public static int a(Context context) {
        int Q = com.baidu.navisdk.ui.routeguide.control.x.b().Q() - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left);
        return com.baidu.navisdk.ui.routeguide.b.V().r().g() ? Q - ScreenUtil.getInstance().getStatusBarHeightFullScreen(context) : Q;
    }
}
