package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNFrameLayout;
import com.baidu.navisdk.ui.widget.BNOnTouchListener;
import com.baidu.navisdk.utils.a;

/* loaded from: classes8.dex */
public class j0 extends j implements com.baidu.navisdk.module.plate.b, com.baidu.navisdk.module.plate.a, com.baidu.navisdk.module.plate.e {
    private View e;
    private ViewGroup f;
    private com.baidu.navisdk.module.plate.view.d g;
    private final Context h;
    private com.baidu.navisdk.module.plate.view.c i;
    private com.baidu.navisdk.module.plate.layout.a j;
    private com.baidu.navisdk.module.routepreference.g k;
    private BNFrameLayout l;
    private int m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a(j0 j0Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMPlateLimitSettingCard", "onClick: ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j0.this.r();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements BNOnTouchListener {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNOnTouchListener
        public void onTouch(MotionEvent motionEvent) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMPlateLimitSettingCard", "mWatchTouch::onTouch");
            }
            j0.this.m();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j0.this.p();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMPlateLimitSettingCard", "onAnimationEnd: ");
            }
            if (j0.this.f != null) {
                j0.this.f.clearAnimation();
            }
            com.baidu.navisdk.ui.routeguide.control.i.g().b(1009);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public j0() {
        this.f8808a = 1009;
        this.h = com.baidu.navisdk.ui.routeguide.b.V().b();
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        View view = this.e;
        if (view != null) {
            view.setVisibility(8);
        }
        com.baidu.navisdk.module.plate.view.c cVar = this.i;
        if (cVar != null) {
            cVar.c(true);
        }
        com.baidu.navisdk.module.plate.layout.a aVar = this.j;
        if (aVar != null) {
            aVar.c(true);
        }
        p();
    }

    private void s() {
        RelativeLayout relativeLayout = (RelativeLayout) com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().b(), R.layout.nsdk_layout_rg_plate_setting_panel);
        this.f = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new a(this));
            ViewGroup viewGroup = (ViewGroup) this.f.findViewById(R.id.new_energy_root_view);
            ViewGroup viewGroup2 = (ViewGroup) this.f.findViewById(R.id.new_energy_container_view);
            this.l = (BNFrameLayout) this.f.findViewById(R.id.watch_touch);
            com.baidu.navisdk.module.plate.view.d dVar = new com.baidu.navisdk.module.plate.view.d(2);
            this.g = dVar;
            dVar.a(viewGroup2);
            this.g.b(viewGroup);
            View findViewById = this.f.findViewById(R.id.half_screen_mask_view);
            this.e = findViewById;
            findViewById.setOnClickListener(new b());
            this.m = BNCommSettingManager.getInstance().getScreenOrientationMode();
            this.k = com.baidu.navisdk.module.routeresult.logic.plate.a.b().a(1);
            BNFrameLayout bNFrameLayout = this.l;
            if (bNFrameLayout != null) {
                bNFrameLayout.setTouchEventListener(new c());
            }
        }
    }

    private void t() {
        if (com.baidu.navisdk.util.common.z.b(this.h)) {
            this.e.setVisibility(0);
            if (this.i == null) {
                this.i = new com.baidu.navisdk.module.plate.view.c(this.h, this.g);
            }
            a(1);
            this.i.a(true, (Bundle) null);
            this.i.a((com.baidu.navisdk.module.plate.a) this);
            this.i.a((com.baidu.navisdk.module.plate.b) this);
            this.i.a(false, true);
            this.i.a(new d());
            return;
        }
        TipTool.onCreateToastDialog(this.h, "当前无网络，请稍后再试");
        r();
    }

    @Override // com.baidu.navisdk.module.plate.b
    public void c() {
        com.baidu.navisdk.module.plate.layout.a aVar = this.j;
        if (aVar != null) {
            aVar.A();
            this.j.e(false);
        }
        com.baidu.navisdk.module.plate.view.c cVar = this.i;
        if (cVar != null) {
            cVar.p();
        }
        this.e.setVisibility(8);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public View e() {
        return this.f;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public boolean f() {
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void g() {
        super.g();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMPlateLimitSettingCard", "onDestory: ");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.j, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        super.j();
        a(this.m);
        com.baidu.navisdk.module.routepreference.g b2 = com.baidu.navisdk.module.routeresult.logic.plate.a.b().b(1);
        if (!this.k.equals(b2)) {
            this.k = b2;
            com.baidu.navisdk.ui.routeguide.control.l.l().i();
        }
        com.baidu.navisdk.module.plate.layout.a aVar = this.j;
        if (aVar != null) {
            aVar.b((com.baidu.navisdk.module.plate.e) null);
            this.j.a((com.baidu.navisdk.module.plate.e) null);
        }
        com.baidu.navisdk.module.asr.a.b().a(true);
        com.baidu.navisdk.framework.b.b(false);
        h();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.j, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        super.k();
        com.baidu.navisdk.module.asr.a.b().a(false);
        com.baidu.navisdk.framework.b.b(true);
        if (this.f != null) {
            t();
            this.f.startAnimation(com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 600L));
        }
    }

    @Override // com.baidu.navisdk.module.plate.e
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMPlateLimitSettingCard", "onTextChanged --> s = " + ((Object) charSequence) + ", start = " + i + ", before = " + i2 + ", count = " + i3);
        }
        m();
    }

    public void p() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMPlateLimitSettingCard", "hideOnAnimation: ");
        }
        Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 500L);
        a2.setFillAfter(true);
        a2.setAnimationListener(new e());
        ViewGroup viewGroup = this.f;
        if (viewGroup != null) {
            viewGroup.startAnimation(a2);
        }
    }

    public void q() {
        if (com.baidu.navisdk.util.common.z.b(this.h)) {
            this.e.setVisibility(0);
            if (this.j == null) {
                this.j = new com.baidu.navisdk.module.plate.layout.a((Activity) this.h, this.g);
            }
            this.j.a(true, (Bundle) null);
            this.j.e(true);
            this.j.a((com.baidu.navisdk.module.plate.b) this);
            this.j.a((com.baidu.navisdk.module.plate.a) this);
            this.j.b(this);
            this.j.a((com.baidu.navisdk.module.plate.e) this);
            return;
        }
        TipTool.onCreateToastDialog(this.h, "当前无网络，请稍后再试");
    }

    private void a(int i) {
        BNCommSettingManager.getInstance().putScreenOrientationMode(i);
        com.baidu.navisdk.module.newguide.controllers.c.a(i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void a(boolean z) {
        super.a(z);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMPlateLimitSettingCard", "updateStyle: " + z);
        }
    }

    @Override // com.baidu.navisdk.module.plate.a
    public void a(int i, int i2, Bundle bundle) {
        if (i2 == 0) {
            q();
            if (bundle != null) {
                this.j.c(bundle);
            }
            this.j.e(i);
            return;
        }
        p();
    }
}
