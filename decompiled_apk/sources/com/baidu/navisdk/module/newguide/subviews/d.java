package com.baidu.navisdk.module.newguide.subviews;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.f;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class d extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    protected View i;
    protected int j;
    private com.baidu.navisdk.pronavi.style.i.a k;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle;
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGContinueNaviView", "mContinueView onClick: ");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.6");
            if (((com.baidu.navisdk.ui.routeguide.widget.d) d.this).c != null) {
                k k = com.baidu.navisdk.framework.interfaces.c.p().k();
                if (k != null) {
                    k.A();
                }
                if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
                    bundle = new Bundle();
                    bundle.putBoolean(RGFSMTable.FsmParamsKey.IS_NEED_EXECUTE_GLASS_FMS, false);
                } else {
                    bundle = null;
                }
                ((com.baidu.navisdk.ui.routeguide.widget.d) d.this).c.a(3, 0, 0, bundle);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_continue_navi"));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f7340a;

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f7340a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (d.this.i != null) {
                this.f7340a.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                d.this.i.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.pronavi.style.c {
        public c(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public String a() {
            return "RGContinueNavi";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            d.this.q0();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            a(d.this.i);
        }
    }

    public d(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.j = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        View view = this.i;
        if (view != null) {
            com.baidu.navisdk.ui.util.b.a(view, R.drawable.nsdk_rg_selector_common_control_btn_bg);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, f fVar) {
        View view;
        if (!z || (view = this.i) == null || view.getVisibility() != 0) {
            return null;
        }
        Animator v = v(fVar.a());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(v);
        return arrayList;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        c();
    }

    public void n0() {
        if (this.i == null) {
            ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.bnav_rg_continue_nav_stub);
            if (viewStub != null) {
                try {
                    com.baidu.navisdk.ui.util.b.a(viewStub);
                } catch (Exception e) {
                    if (g.PRO_NAV.c()) {
                        g.PRO_NAV.c("RGContinueNaviView", "loadContinueView: " + e);
                    }
                }
            }
            View findViewById = this.b.findViewById(R.id.bnav_rg_toolbox_continue_nav);
            this.i = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(new a());
                o0();
            }
        }
    }

    public void o0() {
        com.baidu.navisdk.pronavi.style.i.a aVar = this.k;
        if (aVar == null) {
            c cVar = new c(new Integer[0]);
            this.k = cVar;
            com.baidu.navisdk.pronavi.style.f.b.a("RGContinueNavi", cVar);
        } else {
            aVar.a(this.i);
            this.k.a("RGContinueNavi");
        }
    }

    public void p0() {
        int dimensionPixelSize;
        f o = com.baidu.navisdk.ui.routeguide.utils.b.o();
        int i = o.f6817a;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGContinueNaviView", "setPortraitContinueViewMarginBottom: " + o);
        }
        if (i == 2) {
            dimensionPixelSize = o.b;
        } else if (i == 3) {
            dimensionPixelSize = 0;
        } else {
            dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
        }
        com.baidu.navisdk.pronavi.util.b.f7961a.a(this.i, dimensionPixelSize);
    }

    public Animator v(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(marginLayoutParams.bottomMargin, i);
        ofInt.addUpdateListener(new b(marginLayoutParams));
        return ofInt;
    }

    public void w(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGContinueNaviView", "setTopBarState: " + i);
        }
        this.j = i;
        if (i == 1) {
            if (!com.baidu.navisdk.poisearch.model.a.k().h() && !x.b().A2()) {
                y();
                return;
            }
            return;
        }
        if (i == 0) {
            c();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.j == 1) {
            n0();
            View view = this.i;
            if (view != null) {
                view.setVisibility(0);
            }
            if (j0()) {
                p0();
            }
            return super.y();
        }
        c();
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        c();
        this.i = null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, f fVar) {
        View view;
        if (!z || (view = this.i) == null || view.getVisibility() != 0) {
            return null;
        }
        Animator v = v(i2);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(v);
        return arrayList;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, f fVar) {
        View view;
        if (!z || (view = this.i) == null || view.getVisibility() != 0) {
            return null;
        }
        Animator v = v(JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(v);
        return arrayList;
    }
}
