package com.baidu.navisdk.module.newguide.subviews;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.routeguide.toolbox.view.a;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.ui.routeguide.widget.d implements View.OnClickListener, com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    private RelativeLayout i;
    private View j;
    private TextView k;
    private View l;
    private TextView m;
    private View n;
    private TextView o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private String t;
    private a.o u;
    private f v;
    private e w;
    private boolean x;

    /* loaded from: classes7.dex */
    public class a implements a.q0 {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.q0
        public void a() {
            b.this.o0();
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.subviews.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0266b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f7336a;

        public C0266b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f7336a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.i != null) {
                this.f7336a.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.i.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f7337a;

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f7337a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.i != null) {
                this.f7337a.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.i.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f7338a;
        final /* synthetic */ Pair b;

        public d(ViewGroup.MarginLayoutParams marginLayoutParams, Pair pair) {
            this.f7338a = marginLayoutParams;
            this.b = pair;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (b.this.i != null) {
                this.f7338a.width = ((Integer) this.b.first).intValue();
                b.this.i.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a();

        void b();

        void c();
    }

    public b(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.j = null;
        this.k = null;
        this.n = null;
        this.o = null;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = null;
        this.x = false;
    }

    private void A(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "setClearPoiVIewText: " + z);
        }
        u0();
        if (z) {
            this.k.setText(R.string.nsdk_string_route_search_has_results_in_clear_view);
        } else {
            this.k.setText(R.string.nsdk_string_route_search_no_results_in_clear_view);
        }
        this.k.setVisibility(0);
    }

    private void A0() {
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            int childCount = this.i.getChildCount();
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGBottomBarStatusView", "hideStatusContainerView childCount: " + childCount);
            }
            if (childCount == 0) {
                this.i.setVisibility(8);
            }
        }
    }

    private void B0() {
        int i;
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f h0 = h0();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "initStatusViewLocation: " + h0);
        }
        if ((!C0() || h0.g(true)) && h0.f6817a != 0) {
            boolean C0 = C0();
            int i2 = h0.f6817a;
            if (C0) {
                i = h0.b;
            } else {
                i = h0.c;
            }
            a(i2, C0, i);
        }
    }

    private boolean C0() {
        if (this.f == 1) {
            return true;
        }
        return false;
    }

    private boolean D0() {
        TextView textView = this.k;
        if (textView == null || !(textView.getParent() instanceof ViewGroup) || this.k.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private boolean E0() {
        View view = this.n;
        if (view == null || !(view.getParent() instanceof ViewGroup) || this.n.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private boolean F0() {
        View view = this.j;
        if (view == null || !(view.getParent() instanceof ViewGroup) || this.j.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private boolean G0() {
        View view = this.l;
        if (view == null || !(view.getParent() instanceof ViewGroup) || this.l.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private void H0() {
        if (this.i == null) {
            ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.bnav_rg_bottombar_status_stub);
            if (viewStub != null) {
                try {
                    com.baidu.navisdk.ui.util.b.a(viewStub);
                } catch (Exception e2) {
                    if (g.PRO_NAV.c()) {
                        g.PRO_NAV.c("RGBottomBarStatusView", "loadLandViewContainer: " + e2);
                    }
                }
            }
            this.i = (RelativeLayout) this.b.findViewById(R.id.bnav_rg_bottombar_status_view);
            a aVar = new a();
            o0();
            x.b().a(aVar);
            B0();
        }
        if (this.i.getVisibility() != 0) {
            this.i.setVisibility(0);
        }
    }

    private void I0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "removeMultRouteSwitchView: ");
        }
        TextView textView = this.k;
        if (textView != null) {
            ViewParent parent = textView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.k);
            }
        }
        A0();
    }

    private void J0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "removeHasProgressView: ");
        }
        View view = this.n;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.n);
            }
        }
        A0();
    }

    private void K0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "removeMultRouteSwitchView: ");
        }
        View view = this.j;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.j);
            }
        }
        A0();
    }

    private void L0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "removeNoProgressView: ");
        }
        View view = this.l;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.l);
            }
        }
        A0();
    }

    private void M0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "updateCurrentStatus: " + this.x);
        }
        if (this.x) {
            return;
        }
        z(this.p);
        y(this.q);
        a.o oVar = this.u;
        if (this.s) {
            a(this.t, oVar);
        } else {
            p0();
        }
        if (this.r) {
            b(this.t, this.u);
        } else {
            q0();
        }
        if (this.s || this.r) {
            this.u = oVar;
        }
    }

    private void e(int i, int i2) {
        boolean z;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "setContainerMarginLeftRight: " + i + ":" + i2);
        }
        if (this.i == null) {
            return;
        }
        Pair<Integer, Integer> d2 = d(i, i2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
        boolean z2 = true;
        if (marginLayoutParams.leftMargin != ((Integer) d2.second).intValue()) {
            marginLayoutParams.leftMargin = ((Integer) d2.second).intValue();
            z = true;
        } else {
            z = false;
        }
        if (marginLayoutParams.width != ((Integer) d2.first).intValue()) {
            marginLayoutParams.width = ((Integer) d2.first).intValue();
        } else {
            z2 = z;
        }
        if (z2) {
            this.i.requestLayout();
        }
    }

    private void u0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "addClearPoiView: ");
        }
        H0();
        if (this.k == null) {
            TextView textView = (TextView) com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.bnav_layout_rg_bottombar_clear_poi, this.i, false);
            this.k = textView;
            textView.setOnClickListener(this);
            com.baidu.navisdk.ui.util.b.a((View) this.k, R.drawable.bn_rg_bottom_bar_bg);
        }
        ViewParent parent = this.k.getParent();
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "addClearPoiView: " + parent);
        }
        if (parent instanceof ViewGroup) {
            if (parent != this.i) {
                ((ViewGroup) parent).removeView(this.k);
                this.i.addView(this.k);
                return;
            } else {
                this.k.setVisibility(0);
                if (gVar.d()) {
                    gVar.e("RGBottomBarStatusView", "addClearPoiView parent is mStatusViewContainer");
                    return;
                }
                return;
            }
        }
        this.i.addView(this.k);
    }

    private void w0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "addHasProgressView: ");
        }
        H0();
        if (this.n == null) {
            View a2 = com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_mapmode_toolbox_rp_watting, this.i, false);
            this.n = a2;
            a2.setOnClickListener(this);
            this.o = (TextView) this.n.findViewById(R.id.bnav_rg_toolbox_rp_watting_tv);
            this.n.findViewById(R.id.bnav_rg_toolbox_rp_watting_cancle).setOnClickListener(this);
            com.baidu.navisdk.ui.util.b.a(this.n, R.drawable.bn_rg_bottom_bar_bg);
        }
        ViewParent parent = this.n.getParent();
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "addHasProgressView: " + parent);
        }
        if (parent instanceof ViewGroup) {
            if (parent != this.i) {
                ((ViewGroup) parent).removeView(this.n);
                this.i.addView(this.n);
            } else {
                if (gVar.d()) {
                    gVar.e("RGBottomBarStatusView", "addHasProgressView parent is mStatusViewContainer");
                }
                this.n.setVisibility(0);
            }
        } else {
            this.i.addView(this.n);
        }
        this.n.setVisibility(0);
    }

    private Animator x(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(marginLayoutParams.bottomMargin, i);
        ofInt.addUpdateListener(new C0266b(marginLayoutParams));
        return ofInt;
    }

    private void x0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "addMultRouteSwitchView: ");
        }
        H0();
        if (this.j == null) {
            View a2 = com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.bnav_layout_rg_bottombar_multi_route_switch, this.i, false);
            this.j = a2;
            View findViewById = a2.findViewById(R.id.bnav_rg_toolbox_resume_tv);
            View findViewById2 = this.j.findViewById(R.id.bnav_rg_toolbox_switch_route_tv);
            findViewById.setOnClickListener(this);
            findViewById2.setOnClickListener(this);
            this.j.setOnClickListener(this);
            com.baidu.navisdk.ui.util.b.a(this.j, R.drawable.bn_rg_bottom_bar_bg);
        }
        ViewParent parent = this.j.getParent();
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "addMultRouteSwitchView: " + parent);
        }
        if (parent instanceof ViewGroup) {
            if (parent != this.i) {
                ((ViewGroup) parent).removeView(this.j);
                this.i.addView(this.j);
                return;
            } else {
                if (gVar.d()) {
                    gVar.e("RGBottomBarStatusView", "addMultRouteSwitchView parent is mStatusViewContainer");
                }
                this.j.setVisibility(0);
                return;
            }
        }
        this.i.addView(this.j);
    }

    private void y(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "setTopBarState: " + i);
        }
        if (i == 0) {
            z(false);
        }
    }

    private void y0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "addNoProgressView: ");
        }
        H0();
        if (this.l == null) {
            View a2 = com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_bottom_loading_no_progress, this.i, false);
            this.l = a2;
            a2.setOnClickListener(this);
            this.m = (TextView) this.l.findViewById(R.id.bnav_rg_loading_no_progress_txt);
            View findViewById = this.l.findViewById(R.id.bnav_rg_loading_no_progress_exit_btn);
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
            }
            com.baidu.navisdk.ui.util.b.a(this.l, R.drawable.bn_rg_bottom_bar_bg);
        }
        ViewParent parent = this.l.getParent();
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "addNoProgressView: " + parent);
        }
        if (parent instanceof ViewGroup) {
            if (parent != this.i) {
                ((ViewGroup) parent).removeView(this.l);
                this.i.addView(this.l);
                return;
            } else {
                if (gVar.d()) {
                    gVar.e("RGBottomBarStatusView", "addNoProgressView parent is mStatusViewContainer");
                }
                this.l.setVisibility(0);
                return;
            }
        }
        this.i.addView(this.l);
    }

    private void z0() {
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        I0();
        J0();
        K0();
        L0();
        this.i = null;
        this.n = null;
        this.j = null;
        this.l = null;
        this.k = null;
    }

    public void b(String str, a.o oVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "showLoadingViewNoProgress: " + str);
        }
        this.x = false;
        this.t = str;
        this.r = true;
        e eVar = this.w;
        if (eVar != null) {
            eVar.b();
        }
        this.u = oVar;
        y0();
        this.m.setText(str);
        this.l.setVisibility(0);
    }

    public void c(String str, a.o oVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "showNaviReady: " + str);
        }
        y(0);
        b(str, oVar);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        Animator a2;
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout == null) {
            return null;
        }
        if (relativeLayout.getVisibility() != 0) {
            a(3, z, i2);
            return null;
        }
        if (z) {
            a2 = x(fVar.a());
        } else {
            a2 = a(i, 3, i2);
        }
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(a2);
        return arrayList;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        z0();
        this.x = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        e eVar = this.w;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void n0() {
        this.x = false;
        M0();
    }

    public void o0() {
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().L() != 0 && x.b().d0() == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.bnav_rg_bottombar_status_view);
            this.i = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.getLayoutParams().height = com.baidu.navisdk.ui.util.b.d(R.dimen.nsdk_rg_bottom_no_progress_new_height) + com.baidu.navisdk.ui.routeguide.mapmode.a.o5().L();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "onClick: " + view);
        }
        int id = view.getId();
        if (id == R.id.bnav_rg_toolbox_resume_tv) {
            f fVar = this.v;
            if (fVar != null) {
                fVar.c();
                return;
            }
            return;
        }
        if (id == R.id.bnav_rg_toolbox_switch_route_tv) {
            f fVar2 = this.v;
            if (fVar2 != null) {
                fVar2.a();
                return;
            }
            return;
        }
        if (id == R.id.bnav_rg_toolbox_rp_watting_cancle) {
            a.o oVar = this.u;
            if (oVar != null) {
                oVar.a();
            }
            p0();
            return;
        }
        if (id == R.id.bnav_rg_toolbox_clear_poi_tv) {
            f fVar3 = this.v;
            if (fVar3 != null) {
                fVar3.b();
                return;
            }
            return;
        }
        if (id == R.id.bnav_rg_loading_no_progress_exit_btn) {
            t0();
            a.o oVar2 = this.u;
            if (oVar2 != null) {
                oVar2.a();
            }
        }
    }

    public void p0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "hideLoadingViewHasProgress: ");
        }
        this.u = null;
        this.s = false;
        if (E0()) {
            J0();
        }
        e eVar = this.w;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void q0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "hideLoadingViewNoProgress: ");
        }
        this.r = false;
        if (G0()) {
            L0();
        }
        e eVar = this.w;
        if (eVar != null) {
            eVar.a();
        }
    }

    public boolean r0() {
        View view = this.j;
        if (view == null || !(view.getParent() instanceof ViewGroup) || this.j.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public boolean s0() {
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void t0() {
        if (!this.x) {
            this.x = true;
            z0();
        }
    }

    public void v(int i) {
        if (i != 0) {
            if (i == 1) {
                if (com.baidu.navisdk.poisearch.model.a.k().h()) {
                    y(true);
                    return;
                } else {
                    y(false);
                    y(i);
                    return;
                }
            }
            return;
        }
        y(false);
        y(i);
    }

    public void w(int i) {
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i);
        }
    }

    public void z(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "showResumeSwitchView: " + z);
        }
        this.x = false;
        this.p = z;
        if (!z && !F0()) {
            return;
        }
        if (z) {
            x0();
            this.j.setVisibility(0);
        } else {
            K0();
        }
        e eVar = this.w;
        if (eVar != null) {
            if (z) {
                eVar.b();
            } else {
                eVar.a();
            }
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.c", "", null, null);
        }
    }

    public void a(f fVar) {
        this.v = fVar;
    }

    public void a(e eVar) {
        this.w = eVar;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        z0();
        M0();
    }

    public void y(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "showClearPoiView: " + z);
        }
        this.x = false;
        this.q = z;
        if (z || D0()) {
            if (z) {
                A(com.baidu.navisdk.poisearch.model.a.k().g() > 0);
            } else {
                I0();
            }
            e eVar = this.w;
            if (eVar != null) {
                if (z) {
                    eVar.b();
                } else {
                    eVar.a();
                }
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        e eVar = this.w;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void a(String str, a.o oVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "showLoadingViewHasProgress: " + str);
        }
        this.x = false;
        this.u = oVar;
        this.t = str;
        this.s = true;
        e eVar = this.w;
        if (eVar != null) {
            eVar.b();
        }
        w0();
        this.n.setVisibility(0);
        this.o.setText(str);
    }

    private Pair<Integer, Integer> d(int i, int i2) {
        int j;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "getLandStatusViewWidthMarginLeft: " + i + ", hdViewSize:" + i2);
        }
        int q = com.baidu.navisdk.ui.routeguide.utils.b.q();
        if (i == 2) {
            j = (com.baidu.navisdk.ui.routeguide.utils.a.f9151a.c() - q) - i2;
        } else {
            j = com.baidu.navisdk.ui.routeguide.utils.b.j();
        }
        if (i != 2) {
            q = i == 3 ? q + (((com.baidu.navisdk.ui.routeguide.utils.b.a(com.baidu.navisdk.ui.routeguide.b.V().b()) - q) - j) / 2) : 0;
        }
        return new Pair<>(Integer.valueOf(j), Integer.valueOf(q));
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        Animator a2;
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout == null) {
            return null;
        }
        if (relativeLayout.getVisibility() != 0) {
            a(0, z, i2);
            return null;
        }
        if (z) {
            a2 = x(0);
        } else {
            a2 = a(i, 0, i2);
        }
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(a2);
        return arrayList;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        Animator a2;
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout == null) {
            return null;
        }
        if (relativeLayout.getVisibility() != 0) {
            a(2, z, i2);
            return null;
        }
        if (z) {
            a2 = x(i2);
        } else {
            a2 = a(i, 2, i2);
        }
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(a2);
        return arrayList;
    }

    private void a(int i, boolean z, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "setContainerMargin: " + i + ", " + z + ", " + i2);
        }
        if (!z) {
            e(i, i2);
            return;
        }
        if (i == 2) {
            com.baidu.navisdk.pronavi.util.b.f7961a.a(this.i, i2);
        } else if (i == 3) {
            com.baidu.navisdk.pronavi.util.b.f7961a.a(this.i, 0);
        } else {
            com.baidu.navisdk.pronavi.util.b.f7961a.a(this.i, 0);
        }
    }

    private Animator a(int i, int i2, int i3) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "getLandMarginLeftRightAnimator: " + i + ", toState:" + i2 + "," + i3);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
        if (marginLayoutParams == null) {
            return null;
        }
        Pair<Integer, Integer> d2 = d(i2, i3);
        int intValue = ((Integer) d2.second).intValue();
        int i4 = marginLayoutParams.leftMargin;
        if (gVar.d()) {
            gVar.e("RGBottomBarStatusView", "getLandMarginLeftRightAnimator left: " + intValue + ", " + i4);
        }
        if (i4 == intValue) {
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i4, intValue);
        ofInt.addUpdateListener(new c(marginLayoutParams));
        ofInt.addListener(new d(marginLayoutParams, d2));
        return ofInt;
    }
}
