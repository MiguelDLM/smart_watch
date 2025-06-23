package com.baidu.navisdk.module.newguide.controllers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.f;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.module.newguide.abs.c {

    /* renamed from: a, reason: collision with root package name */
    private View f7215a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private ImageView h;

    /* loaded from: classes7.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            b.this.a(0);
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.controllers.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0247b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f7217a;

        public C0247b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f7217a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.c != null) {
                this.f7217a.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.c.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f7218a;

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f7218a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.d != null) {
                this.f7218a.rightMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.d.requestLayout();
            }
        }
    }

    public b(View view) {
        this.f7215a = view;
        q();
    }

    private void p() {
        f o = com.baidu.navisdk.ui.routeguide.utils.b.o();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "handleHdNaviStateLayout: " + o);
        }
        if (o == null) {
            return;
        }
        int i = o.f6817a;
        if (i == 2) {
            c(o.c);
            b(com.baidu.navisdk.ui.routeguide.utils.b.q());
        } else if (i == 3) {
            b(com.baidu.navisdk.ui.routeguide.utils.b.q());
        }
    }

    private void q() {
        Object valueOf;
        this.e = null;
        this.f = null;
        this.g = null;
        if (this.f7215a != null) {
            if (x.b().s2()) {
                this.b = this.f7215a.findViewById(R.id.bnav_rg_top_panel);
                this.c = null;
            } else {
                this.b = this.f7215a.findViewById(R.id.bnav_rg_top_panel);
                this.c = this.f7215a.findViewById(R.id.bnav_rg_left_panel);
                this.d = this.f7215a.findViewById(R.id.bnav_rg_right_panel);
            }
            a();
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("initPanel -> mRootViewGroup = ");
            sb.append(this.f7215a);
            sb.append("isOrientationPortrait = ");
            sb.append(x.b().s2());
            sb.append(", mTopPanel = ");
            View view = this.b;
            Object obj = "null";
            if (view == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(view.getVisibility());
            }
            sb.append(valueOf);
            sb.append(", mLandspaceLeftPanel = ");
            View view2 = this.c;
            if (view2 != null) {
                obj = Integer.valueOf(view2.getVisibility());
            }
            sb.append(obj);
            gVar.e("RGGuidePanelManager", sb.toString());
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        View view;
        if (x.b().s2()) {
            View view2 = this.b;
            if (view2 != null && view2.isShown()) {
                view = this.b;
            } else {
                if (!com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                    if (e() != null && this.e.isShown()) {
                        view = this.e;
                    } else if (f() != null && this.f.isShown()) {
                        view = this.f;
                    } else if (d() != null && this.g.isShown()) {
                        view = this.g;
                    }
                }
                view = null;
            }
        } else {
            View view3 = this.c;
            if (view3 != null && view3.isShown()) {
                view = this.c;
            }
            view = null;
        }
        if (view == null) {
            return null;
        }
        return new View[]{view};
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void a() {
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void b(boolean z) {
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public View c() {
        return this.c;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public View d() {
        View view;
        if (this.g == null && x.b().s2() && (view = this.f7215a) != null) {
            this.g = view.findViewById(R.id.bnav_rg_simple_model_exit_main_road_panel);
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "getSimpleModeHighwayPanel -> isOrientationPortrait = " + x.b().s2() + ", mRootViewGroup = " + this.f7215a + ", panel = " + this.g);
        }
        return this.g;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public View e() {
        View view;
        if (this.e == null && x.b().s2() && (view = this.f7215a) != null) {
            this.e = view.findViewById(R.id.bnav_rg_simple_model_guide_panel);
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "getSimpleModeGuidePanel -> isOrientationPortrait = " + x.b().s2() + ", mRootViewGroup = " + this.f7215a + ", panel = " + this.e);
        }
        return this.e;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public View f() {
        View view;
        if (this.f == null && x.b().s2() && (view = this.f7215a) != null) {
            this.f = view.findViewById(R.id.bnav_rg_simple_model_highway_view);
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "getSimpleModeHighwayPanel -> isOrientationPortrait = " + x.b().s2() + ", mRootViewGroup = " + this.f7215a + ", panel = " + this.f);
        }
        return this.f;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public int g() {
        return x.b().X() + JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_panel_margin_top) + JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_bottom);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public View h() {
        return this.b;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void i() {
        c(true);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void j() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "hideTopPanel -> mTopPanel = " + this.b);
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public boolean k() {
        return !com.baidu.navisdk.ui.routeguide.utils.b.x();
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void l() {
        this.h = null;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void m() {
        ImageView imageView = this.h;
        if (imageView != null && imageView.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void n() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "showSimpleGuideLeftPanelView -> mLandspaceLeftPanel = " + this.c);
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void o() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "showTopPanel -> mTopPanel = " + this.b);
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void c(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "hideSimpleGuideLeftPanelView -> mLandspaceLeftPanel = " + this.c + ", isInvisible = " + z);
        }
        View view = this.c;
        if (view != null) {
            if (z) {
                view.setVisibility(4);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public int b() {
        if (k()) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_width);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_land_left_panel_width_new);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void a(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            if (z) {
                layoutParams.bottomMargin = this.f7215a.getContext().getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_follow_guide_height) + this.f7215a.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_5dp);
            } else {
                layoutParams.bottomMargin = this.f7215a.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_5dp);
            }
        }
    }

    private void b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "changeLandLeftPanelWidth: " + i);
        }
        View view = this.c;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.width != i) {
                marginLayoutParams.width = i;
                this.c.requestLayout();
            }
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c, com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, f fVar) {
        Animator a2;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "getEnterNormal fromState: " + i + ",miniHDHeight:" + i2 + ",isPort: " + z);
        }
        if (z) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        if (i == 2 && (a2 = a(0, 0)) != null) {
            a2.addListener(new a());
            arrayList.add(a2);
        }
        Animator d = d(com.baidu.navisdk.ui.routeguide.utils.b.j());
        if (d != null) {
            arrayList.add(d);
        }
        return arrayList;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c, com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, f fVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "getEnterFullHD fromState: " + i + ",miniHDHeight:" + i2 + ",isPort: " + z);
        }
        if (z) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        if (i == 2) {
            a(3);
            Animator a2 = a(0, 3);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Animator d = d(com.baidu.navisdk.ui.routeguide.utils.b.q());
        if (d != null) {
            arrayList.add(d);
        }
        return arrayList;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void a(View view, int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "orientationChanged -> rootViewGroup = " + view + ", orien = " + i);
        }
        this.f7215a = view;
        q();
        if (i == 2) {
            p();
        }
    }

    private void c(int i) {
        View view = this.d;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.rightMargin != i) {
                marginLayoutParams.rightMargin = i;
                this.d.requestLayout();
            }
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c, com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, f fVar) {
        Animator d;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "getEnterDoubleMap fromState: " + i + ",miniHDHeight:" + i2 + ",isPort: " + z);
        }
        if (z) {
            return null;
        }
        a(2);
        ArrayList arrayList = new ArrayList(2);
        Animator a2 = a(i2, 2);
        if (a2 != null) {
            arrayList.add(a2);
        }
        if (i == 0 && (d = d(com.baidu.navisdk.ui.routeguide.utils.b.q())) != null) {
            arrayList.add(d);
        }
        return arrayList;
    }

    @Nullable
    private Animator d(int i) {
        View view = this.c;
        if (view == null) {
            return null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i2 = marginLayoutParams.width;
        if (i2 == i) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGGuidePanelManager", "getLandLeftPanelWidthAnimator: fromWidth == toWidth");
            }
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i);
        ofInt.addUpdateListener(new C0247b(marginLayoutParams));
        return ofInt;
    }

    @Nullable
    private Animator a(int i, int i2) {
        View view = this.d;
        if (view == null) {
            return null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i3 = marginLayoutParams.rightMargin;
        if (i2 == 2) {
            i3 += com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().a();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, i);
        ofInt.addUpdateListener(new c(marginLayoutParams));
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        ViewGroup b = x.b().b(R.id.bnav_rg_content_panel_land);
        if (b == null) {
            return;
        }
        x.b().a(true, i != 2, b);
    }
}
