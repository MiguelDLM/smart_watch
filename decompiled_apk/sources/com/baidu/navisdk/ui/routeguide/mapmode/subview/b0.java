package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b0 extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.b {
    private ViewGroup i;
    private ViewGroup j;
    private ViewGroup k;
    private int l;
    private int m;
    private int n;
    private SparseArray<ViewGroup> o;
    private SparseArray<ImageView> p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private com.baidu.navisdk.pronavi.style.i.a v;
    private Runnable w;
    private int x;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.F0();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8720a;
        final /* synthetic */ Animation b;

        public b(b0 b0Var, View view, Animation animation) {
            this.f8720a = view;
            this.b = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f8720a.startAnimation(this.b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8721a;
        final /* synthetic */ Animation b;

        public c(b0 b0Var, View view, Animation animation) {
            this.f8721a = view;
            this.b = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f8721a.startAnimation(this.b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object valueOf;
            boolean z;
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().r();
            com.baidu.navisdk.ui.routeguide.control.x.b().t3();
            boolean z2 = true;
            if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
                if (!com.baidu.navisdk.ui.routeguide.control.x.b().e2() && com.baidu.navisdk.ui.routeguide.control.x.b().g2()) {
                    if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("updateMarginTopForAssistViewIsDisplayed,是否需要移动车道线，mLineNumber = ");
                        sb.append(RGLaneInfoModel.getModel(false).mLineNumber);
                        sb.append(", isShowLaneLineView = ");
                        sb.append(RGLaneInfoModel.getModel(false).isShowLaneLineView());
                        sb.append(", mLaneLineView.getVisibility() = ");
                        if (b0.this.k.getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        sb.append(z);
                        LogUtil.e("RGMMLaneLineView", sb.toString());
                    }
                    if (RGLaneInfoModel.getModel(false).mLineNumber <= 6) {
                        com.baidu.navisdk.ui.routeguide.control.x.b().Z2();
                        b0.this.s0();
                    } else {
                        if (RGLaneInfoModel.getModel(false).isShowLaneLineView() && b0.this.k.getVisibility() == 0) {
                            com.baidu.navisdk.ui.routeguide.control.x.b().V2();
                        }
                        b0.this.t0();
                    }
                } else {
                    b0.this.t0();
                }
            }
            com.baidu.navisdk.ui.routeguide.model.n c = com.baidu.navisdk.ui.routeguide.b.V().i().c();
            com.baidu.navisdk.ui.routeguide.mapmode.presenter.f m0 = com.baidu.navisdk.ui.routeguide.control.x.b().m0();
            if (LogUtil.LOGGABLE) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("updateMarginTopForAssistViewIsDisplayed,高速看板是否正在显示 = ");
                if (m0 == null || !m0.f()) {
                    z2 = false;
                }
                sb2.append(z2);
                sb2.append(", isServiceAreaCanShow = ");
                if (c == null) {
                    valueOf = "null";
                } else {
                    valueOf = Boolean.valueOf(c.s());
                }
                sb2.append(valueOf);
                LogUtil.e("RGMMLaneLineView", sb2.toString());
            }
            if (c != null && c.s() && m0 != null && m0.f()) {
                m0.j();
                com.baidu.navisdk.ui.routeguide.control.x.b().u3();
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.control.x.b().s2() && com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a.k.a() != 0) {
                com.baidu.navisdk.ui.routeguide.control.x.b().u3();
                return;
            }
            if (b0.this.r || b0.this.s) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().d();
                com.baidu.navisdk.ui.routeguide.control.x.b().u3();
            }
            if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
                b0.this.F0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e(b0 b0Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMLaneLineView", "updateArrivalTimeViewTopMargin(), handleArrivalTimeViewCollision()");
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().v0();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.ui.routeguide.model.n c = com.baidu.navisdk.ui.routeguide.b.V().i().c();
            com.baidu.navisdk.ui.routeguide.mapmode.presenter.f m0 = com.baidu.navisdk.ui.routeguide.control.x.b().m0();
            if (c != null && c.s() && m0 != null && m0.f()) {
                m0.j();
            } else {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGMMLaneLineView", "setAssistPanelViewsMarginTopWithHide(), handleArrivalTimeViewCollision()");
                }
                com.baidu.navisdk.ui.routeguide.control.x.b().v0();
            }
            if (!RGLaneInfoModel.getModel(false).isShowLaneLineView() || !b0.this.a()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().Z2();
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().r();
                com.baidu.navisdk.ui.routeguide.control.x.b().t3();
                com.baidu.navisdk.ui.routeguide.control.x.b().u3();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends com.baidu.navisdk.pronavi.style.c {
        public g(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGMMLaneLineView";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(@oOoXoXO String str) {
            if (b0.this.k != null) {
                b0.this.k.setBackgroundResource(b0.this.n0());
            }
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            a(b0.this.k);
        }
    }

    public b0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar, int i) {
        super(context, viewGroup, aVar);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = 101;
        this.m = R.id.bnav_rg_lane_info_rr;
        this.n = R.layout.nsdk_layout_lane_line;
        this.q = 0;
        this.r = true;
        this.s = false;
        this.t = 0;
        this.u = false;
        this.x = -1;
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            this.u = k.P();
        }
        B(i);
        a(com.baidu.navisdk.ui.util.b.b());
        y(this.u);
    }

    private void A(int i) {
        boolean z = true;
        if (((RelativeLayout.LayoutParams) this.k.getLayoutParams()).getRules()[11] == -1) {
            this.s = true;
        } else {
            if (i < 6 && this.t < 6) {
                z = false;
            }
            this.s = z;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMLaneLineView", "handleLaneCountChange: " + i + ",mLastLaneCount: " + this.t + ", " + this.s);
        }
        this.t = i;
    }

    private void A0() {
        if (this.j != null && this.k != null && z0()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.k.requestLayout();
            u0();
        }
    }

    private void B(int i) {
        this.l = i;
        this.o = new SparseArray<>();
        this.p = new SparseArray<>();
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        if (i == 100) {
            this.m = R.id.enlarge_lane_container;
            this.n = R.layout.nsdk_layout_lane_line;
            this.i = null;
        } else {
            this.m = R.id.bnav_rg_lane_info_rr;
            this.n = R.layout.nsdk_layout_lane_line;
            this.i = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_consecutive_lane_ll);
            E0();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(this.m);
        this.j = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.removeAllViews();
        ViewGroup viewGroup3 = (ViewGroup) JarUtils.inflate(this.f9165a, this.n, null);
        this.k = viewGroup3;
        viewGroup3.setBackgroundResource(n0());
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMLaneLineView", "initViews: mLaneLineView hashCode:" + this.k.hashCode() + ",type:" + i);
        }
        if (this.j != null && this.k != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(14);
            if (z0()) {
                layoutParams.addRule(h0().a(this.f != 2));
            }
            this.j.addView(this.k, layoutParams);
            if (z0()) {
                B0();
                return;
            }
            return;
        }
        if (gVar.c()) {
            gVar.c("RGMMLaneLineView", "initViews:mLaneLineContainer== null &&  mLaneLineView == null");
        }
    }

    private void B0() {
        if (this.v == null) {
            g gVar = new g(new Integer[0]);
            this.v = gVar;
            com.baidu.navisdk.pronavi.style.f.b.a("RGLaneLine", gVar);
        }
    }

    private boolean C(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMLaneLineView", "updateContainerHeight -> laneLineImageSize = " + i);
        }
        ViewGroup viewGroup = this.k;
        if (viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
            int x = x(i);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMLaneLineView", "updateContainerHeight -> layoutParams.height = " + layoutParams.height + ", height = " + x);
            }
            if (layoutParams.height != x) {
                layoutParams.height = x;
                this.k.setLayoutParams(layoutParams);
                this.r = true;
                return true;
            }
        }
        this.r = false;
        return false;
    }

    private void C0() {
        ViewGroup viewGroup;
        if (this.l == 100 && com.baidu.navisdk.ui.routeguide.control.x.b().s2() && (viewGroup = this.j) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
            int i = marginLayoutParams.topMargin;
            int P = com.baidu.navisdk.ui.routeguide.control.x.b().P() - p0();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMLaneLineView", "resetEnlargeLaneLineViewMargin -> currentMargin = " + i + ", margin = " + P);
            }
            if (i != P) {
                marginLayoutParams.topMargin = P;
                this.j.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private void D0() {
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            viewGroup.post(new f());
        }
    }

    private void E0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int b2 = b(com.baidu.navisdk.ui.routeguide.control.x.b().s2(), false);
            if (b2 != -1 && b2 != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = b2;
                this.i.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new e(this));
    }

    private void w0() {
        if (this.j != null && this.k != null && z0()) {
            ((RelativeLayout.LayoutParams) this.k.getLayoutParams()).addRule(11);
            this.k.requestLayout();
            u0();
        }
    }

    private ColorDrawable x0() {
        return new ColorDrawable(5149694);
    }

    private int y0() {
        return v(this.q);
    }

    private int z(int i) {
        int d2;
        int V;
        int dimensionPixelOffset;
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            d2 = com.baidu.navisdk.pronavi.util.a.h.e();
            V = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left) * 2;
        } else {
            d2 = com.baidu.navisdk.pronavi.util.a.h.d();
            V = com.baidu.navisdk.ui.routeguide.control.x.b().V();
        }
        int i2 = d2 - V;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMLaneLineView", "getLaneLineImageSize -> maxWidth <= 0,isOrientationPortrait: " + com.baidu.navisdk.ui.routeguide.control.x.b().s2() + ", maxWidth = " + i2);
        }
        if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.y()) {
                dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_road_condition_bar_width) * 2;
            } else {
                dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left);
            }
            i2 -= dimensionPixelOffset;
        }
        int w = w(0);
        int w2 = w(1);
        int dimensionPixelOffset2 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_1dp) * (i - 1);
        int i3 = i2 - ((w * i) + dimensionPixelOffset2);
        Resources resources = JarUtils.getResources();
        int i4 = R.dimen.navi_dimens_30dp;
        if (i3 >= resources.getDimensionPixelSize(i4)) {
            return 0;
        }
        if (i2 - ((w2 * i) + dimensionPixelOffset2) < JarUtils.getResources().getDimensionPixelSize(i4)) {
            return 2;
        }
        return 1;
    }

    private boolean z0() {
        if (this.l == 101) {
            return true;
        }
        return false;
    }

    public Rect X() {
        ViewGroup viewGroup;
        Rect rect = new Rect();
        if (this.j != null && (viewGroup = this.k) != null) {
            viewGroup.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void e(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMLaneLineView", "enterDoubleMap: " + i);
        }
        if (z && i == 0) {
            w0();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void f(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMLaneLineView", "enterNormal: " + i);
        }
        if (z) {
            A0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        this.o = null;
        this.p = null;
    }

    public int n0() {
        return R.drawable.bnav_rg_lane_line_new_bg;
    }

    public Drawable o0() {
        return JarUtils.getResources().getDrawable(R.drawable.bnav_rg_lane_line_divider_new_bg);
    }

    public int p0() {
        int x = x(this.q);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMLaneLineView", "getLaneLineViewHeight -> mLaneImageSize = " + this.q + ", height = " + x);
        }
        return x;
    }

    public int q0() {
        int i;
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            i = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
        } else {
            i = 0;
        }
        return p0() + i;
    }

    public boolean r0() {
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            return viewGroup.isShown();
        }
        return false;
    }

    public void s0() {
        if (this.j == null || this.l == 100) {
            return;
        }
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_width);
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.getLayoutParams() != null) {
            this.i.getLayoutParams().width = (com.baidu.navisdk.pronavi.util.a.h.e() - dimensionPixelOffset) - ScreenUtil.getInstance().dip2px(8);
            this.i.requestLayout();
        }
    }

    public void t0() {
        ViewGroup viewGroup;
        if (this.j != null && this.l != 100 && (viewGroup = this.i) != null && viewGroup.getLayoutParams() != null) {
            this.i.getLayoutParams().width = -1;
            this.i.requestLayout();
        }
    }

    public void u0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup == null || this.k == null || this.l == 100) {
            return;
        }
        Runnable runnable = this.w;
        if (runnable == null) {
            this.w = new d();
        } else {
            viewGroup.removeCallbacks(runnable);
        }
        this.i.post(this.w);
    }

    public int v(int i) {
        if (i == 0) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_lane_line_image_height_big);
        }
        if (i == 1) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_lane_line_image_height_medium);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_lane_line_image_height_small);
    }

    public int w(int i) {
        if (i == 0) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_lane_line_image_width_big);
        }
        if (i == 1) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_lane_line_image_width_medium);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_lane_line_image_width_small);
    }

    public int x(int i) {
        if (i == 0) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_follow_layout_height_big);
        }
        if (i == 1) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_follow_layout_height_medium);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_follow_layout_height_small);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.u) {
            return false;
        }
        if (!a(RGLaneInfoModel.getModel(false)) && this.l == 101) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMLaneLineView", "show NORMAL_LANE: hide");
            }
            return false;
        }
        if (h0().e(j0())) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMMLaneLineView", "show: 横屏全屏车道级拦截车信");
            }
            return false;
        }
        super.y();
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar3.d()) {
            String str = RGLaneInfoModel.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("RGMMLaneLineView show(),mType = ");
            sb.append(this.l);
            sb.append(", mLaneLineView.getChirld = ");
            ViewGroup viewGroup = this.k;
            sb.append(viewGroup == null ? "null" : Integer.valueOf(viewGroup.getChildCount()));
            gVar3.e(str, sb.toString());
        }
        ViewGroup viewGroup2 = this.j;
        if (viewGroup2 != null && this.k != null) {
            viewGroup2.setVisibility(0);
            this.k.setVisibility(0);
            if (this.l == 101) {
                if (!com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
                    u0();
                }
            } else {
                C0();
            }
            if (gVar3.d()) {
                gVar3.e(RGLaneInfoModel.TAG, "RGMMLaneLineView show(),,mLaneLineContainer.isShown = " + this.j.isShown());
            }
        } else if (gVar3.d()) {
            String str2 = RGLaneInfoModel.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RGMMLaneLineView show(),mType = ");
            sb2.append(this.l);
            sb2.append(", mLaneLineContainer == null ?");
            sb2.append(this.j == null);
            sb2.append(",mLaneLineView == null ? ");
            sb2.append(this.k == null);
            gVar3.e(str2, sb2.toString());
        }
        return true;
    }

    public void a(ViewGroup viewGroup, int i, int i2) {
        ViewGroup viewGroup2;
        super.a(viewGroup, i);
        B(i2);
        a(com.baidu.navisdk.ui.util.b.b());
        if (RGLaneInfoModel.getModel(false).isShowLaneLineView()) {
            LogUtil.e(RGLaneInfoModel.TAG, "onOrientationChanged RGLaneInfoModel");
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().b(RGLaneInfoModel.getModel(false).mImageIdList);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(RGLaneInfoModel.getModel(false).mImageIdList);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(7, true, 2);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h(com.baidu.navisdk.ui.routeguide.mapmode.a.o5().b2());
        }
        if (i2 != 101 || (viewGroup2 = this.k) == null) {
            return;
        }
        viewGroup2.post(new a());
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.b
    public void b(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMLaneLineView", "enterFullHD: " + i);
        }
        if (z && i == 0) {
            w0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(RGLaneInfoModel.TAG, "RGMMLaneLineView hide(), mType = " + this.l);
        }
        ViewGroup viewGroup = this.j;
        if (viewGroup != null && this.k != null) {
            viewGroup.setVisibility(8);
            this.k.setVisibility(8);
            if (this.l == 101) {
                D0();
            }
            this.o = null;
        } else if (gVar.d()) {
            String str = RGLaneInfoModel.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("RGMMLaneLineView hide() mLaneLineContainer == null ?");
            sb.append(this.j == null);
            sb.append(",mLaneLineView == null ? ");
            sb.append(this.k == null);
            gVar.e(str, sb.toString());
        }
        if (gVar.d()) {
            String str2 = RGLaneInfoModel.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RGMMLaneLineView hide(), mType = ");
            sb2.append(this.l);
            sb2.append(", mLaneLineView.isSown = ");
            ViewGroup viewGroup2 = this.k;
            sb2.append(viewGroup2 != null && viewGroup2.isShown());
            gVar.e(str2, sb2.toString());
        }
        this.s = false;
    }

    public int b(boolean z, boolean z2) {
        if (!z) {
            if (com.baidu.navisdk.module.newguide.a.e().d()) {
                return 0;
            }
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_simple_board_margin_top);
        }
        if (z2) {
            return (ScreenUtil.getInstance().getHeightPixels() / 2) - ScreenUtil.getInstance().dip2px(108);
        }
        if (!com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_panel_margin_top);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_bottom);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    public void a(ArrayList<Integer> arrayList) {
        ViewGroup viewGroup;
        Drawable a2;
        if (this.f9165a != null && (viewGroup = this.k) != null && arrayList != null) {
            viewGroup.removeAllViews();
            int size = arrayList.size();
            this.q = z(size);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMLaneLineView", "updateImageView -> type:" + this.l + "list = " + arrayList.size() + ", mLaneImageSize = " + this.q);
            }
            A(size);
            C0();
            C(this.q);
            for (int i = 0; i < size; i++) {
                int intValue = arrayList.get(i).intValue();
                if (intValue == 99) {
                    a2 = x0();
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGMMLaneLineView", "get error drawble");
                    }
                } else {
                    Drawable f2 = com.baidu.navisdk.ui.util.b.f(intValue);
                    a2 = (RGLaneInfoModel.getModel(false).getDriveHabbit() == 1 && com.baidu.navisdk.ui.routeguide.model.r.a(intValue)) ? com.baidu.navisdk.ui.routeguide.subview.util.b.a(f2) : f2;
                }
                if (com.baidu.navisdk.module.cloudconfig.f.c().c.Y == 1) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RGMMLaneLineView", "云控关闭车道线动画");
                    }
                    RGLaneInfoModel.getModel(false).mLaneLineList[i].bRecommend = false;
                    if (i < size - 1) {
                        RGLaneInfoModel.getModel(false).mLaneLineList[i + 1].bRecommend = false;
                    }
                }
                this.k.addView(a(i, a2, this.q, size));
                if (i < size - 1 && !RGLaneInfoModel.getModel(false).mLaneLineList[i].bRecommend && !RGLaneInfoModel.getModel(false).mLaneLineList[i + 1].bRecommend) {
                    this.k.addView(y(i));
                }
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateImageView -> mContext = ");
            sb.append(this.f9165a != null);
            sb.append(", mLaneLineView = ");
            sb.append(this.k != null);
            sb.append(", list= ");
            sb.append(arrayList);
            LogUtil.e("RGMMLaneLineView", sb.toString());
        }
    }

    public void y(boolean z) {
        this.u = z;
        if (z) {
            c();
        }
    }

    private ImageView y(int i) {
        if (this.p == null) {
            this.p = new SparseArray<>();
        }
        ImageView imageView = this.p.get(i);
        if (imageView == null) {
            ImageView imageView2 = new ImageView(this.f9165a);
            int y0 = y0();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_1dp), y0);
            imageView2.setTag(Integer.valueOf(y0));
            imageView2.setLayoutParams(layoutParams);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setImageDrawable(o0());
            this.p.put(i, imageView2);
            return imageView2;
        }
        int y02 = y0();
        if (((Integer) imageView.getTag()).intValue() == y02) {
            return imageView;
        }
        imageView.setTag(Integer.valueOf(y02));
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        layoutParams2.height = y02;
        imageView.setLayoutParams(layoutParams2);
        return imageView;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        ViewGroup viewGroup = this.k;
        if (viewGroup != null && this.l == 101 && viewGroup.isShown()) {
            return new View[]{this.k};
        }
        return null;
    }

    public void a(View view, float f2, float f3) {
        Animation a2 = a(f2, f3);
        Animation a3 = a(f3, f2);
        view.setAnimation(a2);
        view.setAnimation(a3);
        a2.setAnimationListener(new b(this, view, a3));
        a3.setAnimationListener(new c(this, view, a2));
    }

    public Animation a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(440L);
        return alphaAnimation;
    }

    private ViewGroup a(int i, Drawable drawable, int i2, int i3) {
        ImageView imageView;
        ImageView imageView2;
        char c2;
        int w = w(i2);
        int v = v(i2);
        int x = x(i2);
        if (this.o == null) {
            this.o = new SparseArray<>();
        }
        ViewGroup viewGroup = this.o.get(i);
        if (viewGroup == null) {
            viewGroup = (ViewGroup) JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_lane_line_item, null);
            imageView = (ImageView) viewGroup.findViewById(R.id.line_imageview);
            imageView2 = (ImageView) viewGroup.findViewById(R.id.line_coverview);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(w, v);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(w, x);
            Resources resources = JarUtils.getResources();
            int i4 = R.dimen.navi_dimens_1dp;
            int dimensionPixelOffset = resources.getDimensionPixelOffset(i4);
            layoutParams.rightMargin = dimensionPixelOffset;
            layoutParams.leftMargin = dimensionPixelOffset;
            layoutParams.addRule(13);
            imageView.setLayoutParams(layoutParams);
            if (i != i3 - 1 && RGLaneInfoModel.getModel(false).mLaneLineList[i].bRecommend) {
                layoutParams2.rightMargin = JarUtils.getResources().getDimensionPixelOffset(i4);
            }
            viewGroup.setLayoutParams(layoutParams2);
            viewGroup.setTag(Integer.valueOf(i2));
            this.o.put(i, viewGroup);
        } else {
            imageView = (ImageView) viewGroup.findViewById(R.id.line_imageview);
            imageView2 = (ImageView) viewGroup.findViewById(R.id.line_coverview);
            if (((Integer) viewGroup.getTag()).intValue() != i2) {
                viewGroup.setTag(Integer.valueOf(v));
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams3.width = w;
                layoutParams3.height = x;
                if (i != i3 - 1 && RGLaneInfoModel.getModel(false).mLaneLineList[i].bRecommend) {
                    layoutParams3.rightMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_1dp);
                }
                viewGroup.setLayoutParams(layoutParams3);
            }
        }
        imageView2.clearAnimation();
        imageView.clearAnimation();
        imageView.setImageDrawable(drawable);
        int dimensionPixelOffset2 = this.f9165a.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_assist_panel_icon_radius);
        int parseColor = Color.parseColor("#00FFFFFF");
        int parseColor2 = Color.parseColor("#4DFFFFFF");
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{parseColor2, parseColor, parseColor2});
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMLaneLineView", "车道线推荐 ： " + RGLaneInfoModel.getModel(false).mLaneLineList[i].bRecommend + "工程模式设置：" + BNSettingManager.isLaneLineDebugEnabled());
        }
        if (RGLaneInfoModel.getModel(false).mLaneLineList[i].bRecommend || BNSettingManager.isLaneLineDebugEnabled()) {
            a(imageView, 1.0f, 0.2f);
            a(imageView2, 1.0f, 0.6f);
            c2 = i == 0 ? (char) 2 : i == i3 + (-1) ? (char) 3 : (char) 1;
            if (i3 == 1) {
                c2 = 4;
            }
        } else {
            c2 = 0;
        }
        if (c2 == 0) {
            imageView2.setVisibility(8);
        } else if (c2 == 1) {
            imageView2.setVisibility(0);
        } else if (c2 == 2) {
            imageView2.setVisibility(0);
            float f2 = dimensionPixelOffset2;
            gradientDrawable.setCornerRadii(new float[]{f2, f2, 0.0f, 0.0f, 0.0f, 0.0f, f2, f2});
        } else if (c2 == 3) {
            imageView2.setVisibility(0);
            float f3 = dimensionPixelOffset2;
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, f3, f3, f3, f3, 0.0f, 0.0f});
        } else if (c2 == 4) {
            imageView2.setVisibility(0);
            float f4 = dimensionPixelOffset2;
            gradientDrawable.setCornerRadii(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
        }
        imageView2.setImageDrawable(gradientDrawable);
        return viewGroup;
    }

    private boolean a(RGLaneInfoModel rGLaneInfoModel) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMLaneLineView", "isCanShowNormalLane: " + rGLaneInfoModel);
        }
        if (rGLaneInfoModel == null) {
            return false;
        }
        return (rGLaneInfoModel.needDisplay | this.x) == -1;
    }

    public void a(boolean z, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMLaneLineView", "setIsShowNormalLaneLine: " + z + "," + i);
        }
        if (z) {
            this.x |= i;
        } else {
            this.x = (~i) & this.x;
        }
        if (this.l == 100) {
            return;
        }
        if (a(RGLaneInfoModel.getModel(false))) {
            if (RGLaneInfoModel.getModel(false).isShowLaneLineView() && RouteGuideParams.NavState.NAV_STATE_NAVING.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b())) {
                y();
                return;
            }
            return;
        }
        c();
    }
}
