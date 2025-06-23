package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.carlogo.views.BN3DCarLogoLayout;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.utils.a;

/* loaded from: classes8.dex */
public class d extends j {
    private BN3DCarLogoLayout e;
    private com.baidu.navisdk.module.carlogo.control.a f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a(d dVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMM3DCarLogoCard", "onClick: ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BN3DCarLogoLayout.d {
        public b() {
        }

        @Override // com.baidu.navisdk.module.carlogo.views.BN3DCarLogoLayout.d
        public void a() {
            d.this.o();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMM3DCarLogoCard", "onAnimationEnd: ");
            }
            if (d.this.e != null) {
                d.this.e.clearAnimation();
            }
            com.baidu.navisdk.ui.routeguide.control.i.g().b(1006);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public d(com.baidu.navisdk.framework.interfaces.e eVar) {
        this.f8808a = 1006;
        a(eVar);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        } else {
            layoutParams.setMargins(com.baidu.navisdk.ui.routeguide.control.x.b().V(), dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        }
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public View e() {
        return this.e;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void g() {
        super.g();
        com.baidu.navisdk.module.carlogo.control.a aVar = this.f;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoCard", "onDestory: ");
        }
        BN3DCarLogoLayout bN3DCarLogoLayout = this.e;
        if (bN3DCarLogoLayout != null) {
            bN3DCarLogoLayout.setOnTouchDownListener(null);
        }
        com.baidu.navisdk.module.carlogo.control.a aVar = this.f;
        if (aVar != null) {
            aVar.d();
            this.f = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.j, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        super.j();
        h();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.j, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        super.k();
        if (this.e != null) {
            this.e.startAnimation(com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 600L));
        }
        com.baidu.navisdk.module.carlogo.control.a aVar = this.f;
        if (aVar != null) {
            aVar.c(com.baidu.navisdk.module.vehiclemanager.b.i().b());
        }
    }

    public void p() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoCard", "hideOnAnimation: ");
        }
        Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 500L);
        a2.setFillAfter(true);
        a2.setAnimationListener(new c());
        BN3DCarLogoLayout bN3DCarLogoLayout = this.e;
        if (bN3DCarLogoLayout != null) {
            bN3DCarLogoLayout.startAnimation(a2);
        }
    }

    private void a(com.baidu.navisdk.framework.interfaces.e eVar) {
        BN3DCarLogoLayout bN3DCarLogoLayout = (BN3DCarLogoLayout) com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().b(), R.layout.nsdk_layout_rg_3d_car_logo_panel);
        this.e = bN3DCarLogoLayout;
        if (bN3DCarLogoLayout != null) {
            bN3DCarLogoLayout.setOnClickListener(new a(this));
            if (this.f == null) {
                this.f = new com.baidu.navisdk.module.carlogo.control.a(com.baidu.navisdk.ui.routeguide.b.V().b(), this.e, com.baidu.navisdk.module.carlogo.control.c.c());
            }
            this.f.a(eVar);
            this.e.setOnTouchDownListener(new b());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void a(boolean z) {
        super.a(z);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMM3DCarLogoCard", "updateStyle: " + z);
        }
        com.baidu.navisdk.module.carlogo.control.a aVar = this.f;
        if (aVar != null) {
            aVar.b(z);
        }
    }
}
