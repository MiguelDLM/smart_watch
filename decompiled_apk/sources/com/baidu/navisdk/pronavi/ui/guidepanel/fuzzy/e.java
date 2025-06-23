package com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class e extends b {
    private com.baidu.navisdk.pronavi.ui.guidepanel.b m;
    private View n;
    private ImageView o;
    private com.baidu.navisdk.pronavi.ui.guidepanel.a p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a(e eVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleFuzzyGuideView", "onClick: ");
            }
        }
    }

    public e(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    private Animation x0() {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        scaleAnimation.setDuration(550L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(550L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    public void A(int i) {
        if (this.n != null) {
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("随后-setNextTurnVisible - visible=");
                sb.append(i == 0);
                LogUtil.e("RGSimpleFuzzyGuideView", sb.toString());
            }
            this.n.setVisibility(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.b
    public void B(boolean z) {
        ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.bnav_rg_simple_mode_fuzzy_guide_stub);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ViewGroup viewGroup = (ViewGroup) this.b.findViewById(R.id.bnav_rg_simple_model_fuzzy_guide_panel);
        this.i = viewGroup;
        this.k = (ImageView) viewGroup.findViewById(R.id.fuzzy_logo);
        this.i.setOnClickListener(new a(this));
        this.n = this.i.findViewById(R.id.bnav_rg_next_turn_layout);
        this.o = (ImageView) this.i.findViewById(R.id.bnav_rg_sg_next_turn_icon);
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar == null) {
            this.m = new com.baidu.navisdk.pronavi.ui.guidepanel.b(this.f9165a, this.i, null);
        } else if (z) {
            bVar.a(this.i, this.f);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.a aVar = this.p;
        if (aVar == null) {
            this.p = new com.baidu.navisdk.pronavi.ui.guidepanel.a("FuzzySimpleGuide", this.i);
        } else {
            aVar.a(this.i);
        }
        this.p.a();
    }

    public void a(Drawable drawable) {
        ImageView imageView;
        if (drawable == null || (imageView = this.o) == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void b(Drawable drawable) {
        a(drawable);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c(Bundle bundle) {
        super.c(bundle);
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void n0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.isShown()) {
            Animation x02 = x0();
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.clearAnimation();
                this.k.startAnimation(x02);
            }
            View view = this.n;
            if (view != null && view.isShown()) {
                this.n.startAnimation(x02);
            }
            com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
            if (bVar != null) {
                bVar.a(x02);
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public View o0() {
        return this.i;
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void p0() {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void q0() {
        if (this.i != null && j0()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_panel_margin_top);
            if (marginLayoutParams != null && marginLayoutParams.topMargin != dimensionPixelOffset) {
                marginLayoutParams.topMargin = dimensionPixelOffset;
                this.i.requestLayout();
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void r0() {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.j();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void t0() {
        w0();
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.b
    public String u0() {
        return "RGSimpleFuzzyGuideView";
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void v(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()) != null && marginLayoutParams.topMargin != i) {
            marginLayoutParams.topMargin = i;
            this.i.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void w(int i) {
        A(i);
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.b
    public void w0() {
        y(x.b().O2());
        x.b().E(a0.I().j());
        super.w0();
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void x(int i) {
        if (i == 0) {
            A(0);
            x.b().M0();
        } else {
            A(8);
            x.b().N3();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void y(int i) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void z(boolean z) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        boolean b = super.b(bundle);
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.i();
        }
        return b;
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void a(Drawable drawable, String str, int i) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.a(drawable, str, i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void y(boolean z) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            if (z) {
                bVar.h();
            } else {
                bVar.b();
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void z(int i) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void A(boolean z) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.m;
        if (bVar != null) {
            bVar.b(z);
        }
    }
}
