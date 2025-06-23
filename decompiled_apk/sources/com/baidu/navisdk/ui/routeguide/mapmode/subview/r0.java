package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class r0 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private ViewGroup i;
    private ImageView j;
    private TextView k;
    private Animation l;
    private Animation m;
    private boolean n;
    private com.baidu.navisdk.util.worker.f o;
    private View.OnLayoutChangeListener p;

    /* loaded from: classes8.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            r0.this.p0();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (r0.this.k == null || r0.this.k.getVisibility() != 0) {
                r0.this.q0();
            } else {
                r0.this.n0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r0.this.n0();
        }
    }

    /* loaded from: classes8.dex */
    public class d extends com.baidu.navisdk.util.worker.f<String, String> {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            r0.this.n0();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("scenic_broadcast", "btn onLayout top=" + i2 + ", bottom=" + i6);
            }
            r0.this.q0();
        }
    }

    public r0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.n = false;
        this.o = new d("dismissTip-", null);
        this.p = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.o, true);
        this.n = false;
        TextView textView = this.k;
        if (textView != null) {
            textView.setVisibility(8);
            if (this.i.getParent() != null) {
                ((ViewGroup) this.i.getParent()).removeOnLayoutChangeListener(this.p);
            }
            ViewGroup viewGroup = this.b;
            if (viewGroup != null) {
                viewGroup.removeView(this.k);
                this.k = null;
            }
        }
    }

    private boolean o0() {
        ViewStub viewStub;
        if (this.i == null && (viewStub = (ViewStub) this.b.findViewById(R.id.bnav_rg_navi_safeguard_layout_stub)) != null) {
            viewStub.inflate();
        }
        ViewGroup viewGroup = (ViewGroup) this.b.findViewById(R.id.bnav_rg_navi_safeguard_layout);
        this.i = viewGroup;
        if (viewGroup == null) {
            return false;
        }
        this.j = (ImageView) this.b.findViewById(R.id.bnav_rg_navi_safeguard_bg);
        this.i.setOnClickListener(new b());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        Animation animation = this.l;
        if (animation != null) {
            animation.setAnimationListener(null);
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.clearAnimation();
            this.j.setImageResource(R.drawable.nsdk_drawable_navi_safeguard_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && this.b != null && viewGroup.getVisibility() == 0) {
            TextView textView = this.k;
            if (textView == null) {
                TextView textView2 = new TextView(this.f9165a);
                this.k = textView2;
                textView2.setBackgroundDrawable(t(R.drawable.nsdk_rr_left_bubble_bg));
                this.k.setTextColor(Color.parseColor("#ffffff"));
                this.k.setText("护航模式开启中");
                this.k.setTextSize(14.0f);
                this.k.setGravity(16);
                this.k.setOnClickListener(new c());
                int[] iArr = new int[2];
                this.i.getLocationInWindow(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = (i + this.i.getWidth()) - 10;
                layoutParams.topMargin = i2 + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_10dp);
                this.b.addView(this.k, 7, layoutParams);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) textView.getLayoutParams();
                int[] iArr2 = new int[2];
                this.i.getLocationInWindow(iArr2);
                int i3 = iArr2[0];
                int i4 = iArr2[1];
                layoutParams2.leftMargin = (i3 + this.i.getWidth()) - 10;
                layoutParams2.topMargin = i4 + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_10dp);
                this.k.requestLayout();
            }
            ((ViewGroup) this.i.getParent()).addOnLayoutChangeListener(this.p);
            if (!this.n) {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.o, true);
                com.baidu.navisdk.util.worker.c.a().a(this.o, new com.baidu.navisdk.util.worker.e(99, 0), 5000L);
                this.n = true;
            }
        }
    }

    private void r0() {
        if (this.m == null) {
            this.m = AnimationUtils.loadAnimation(this.f9165a, R.anim.nsdk_navi_safeguard_scale_anim);
        }
        if (!this.m.hasStarted()) {
            this.i.startAnimation(this.m);
        }
        if (this.l == null) {
            this.l = AnimationUtils.loadAnimation(this.f9165a, R.anim.nsdk_navi_safeguard_rotate_anim);
        }
        if (!this.l.hasStarted()) {
            this.j.setImageResource(R.drawable.nsdk_drawable_navi_safeguard_anim_bg);
            this.j.clearAnimation();
            this.j.startAnimation(this.l);
            this.l.setAnimationListener(new a());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSafeguardView", "showNaviSafeguardBtn: show --> ");
        }
        if (!(this.i == null ? o0() : true)) {
            return false;
        }
        super.y();
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.getVisibility() != 0) {
            this.i.setVisibility(0);
            r0();
            if (!BNCommSettingManager.getInstance().isNaviSafeTipsShowed()) {
                BNCommSettingManager.getInstance().setNaviSafeTipsShowed();
                q0();
            } else {
                y(true);
            }
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        this.i = null;
        o0();
        if (this.k != null) {
            n0();
            q0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSafeguardView", "showNaviSafeguardBtn: hide --> ");
        }
        super.c();
        if (this.i != null) {
            p0();
            this.i.setVisibility(8);
            n0();
        }
    }

    private void y(boolean z) {
        TextView textView = this.k;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }
}
