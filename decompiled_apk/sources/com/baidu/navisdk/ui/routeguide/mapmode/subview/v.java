package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class v extends com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a {
    private static String m = "RGMMFuzzyGuideView";
    private ViewGroup i;
    private TextView j;
    private ImageView k;
    private String l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a(v vVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public v(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, null);
    }

    private int A(int i) {
        TypedValue typedValue = new TypedValue();
        JarUtils.getResources().getValue(i, typedValue, true);
        return (int) TypedValue.complexToFloat(typedValue.data);
    }

    private void B(boolean z) {
        Drawable f;
        int dimensionPixelSize;
        if (z) {
            f = com.baidu.navisdk.ui.routeguide.holder.a.d().a();
        } else {
            f = com.baidu.navisdk.ui.routeguide.model.a0.I().f();
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(m, "disposeNextTurnVisible -> nextTurnDrawable = " + f);
        }
        if (f != null) {
            com.baidu.navisdk.ui.routeguide.control.x.b().a(f);
            com.baidu.navisdk.ui.routeguide.model.a0.I().i(true);
            com.baidu.navisdk.ui.routeguide.control.x.b().M0();
            com.baidu.navisdk.ui.routeguide.control.x.b().r(0);
            if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
                B(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_55dp));
                return;
            }
            return;
        }
        w0();
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            if (z) {
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_80dp);
            } else {
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_35dp);
            }
            B(dimensionPixelSize);
        }
    }

    private void f(String str) {
        if (!com.baidu.navisdk.util.common.l0.c(str)) {
            this.l = str;
            A(R.dimen.nsdk_text_size_rg_normal_info);
            if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
                str = JarUtils.getResources().getString(R.string.nsdk_string_rg_fuzzy_panel_text, str);
                A(R.dimen.nsdk_text_size_guide_mini_info);
            }
            this.j.setText(str);
        }
    }

    private void u0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.nsdk_layout_rg_mapmode_main_sub_fuzzy_guide_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.nsdk_layout_rg_mapmode_main_sub_fuzzy_guide_panel);
        this.i = viewGroup2;
        viewGroup2.setOnClickListener(new a(this));
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
            this.i.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_guide_top_panel));
        }
        this.k = (ImageView) this.i.findViewById(R.id.fuzzy_logo);
        this.j = (TextView) this.i.findViewById(R.id.fuzzy_tv);
    }

    private void w0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(m, "resetNextTurnVisible!");
        }
        com.baidu.navisdk.ui.routeguide.model.a0.I().i(false);
        com.baidu.navisdk.ui.routeguide.control.x.b().F();
    }

    private void x0() {
        d(null);
    }

    private void y0() {
        Bundle h = com.baidu.navisdk.ui.routeguide.model.a0.I().h();
        String string = h.getString("road_name");
        int i = h.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist);
        if (TextUtils.isEmpty(string) && i <= 0 && com.baidu.navisdk.ui.routeguide.model.a0.I().s()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(m, "next guide info empty, and update top panel by gfgi");
            }
            Bundle bundle = new Bundle();
            JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
            if (gVar.d()) {
                gVar.e(m, "bundle: " + bundle.toString());
            }
            int i2 = bundle.getInt("resid", 0);
            String string2 = bundle.getString("icon_name", "turn_back.png");
            int i3 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0);
            String string3 = bundle.getString("road_name");
            if (i2 > 0) {
                com.baidu.navisdk.ui.routeguide.control.x.b().f(com.baidu.navisdk.ui.routeguide.model.a0.I().a(string2, i3, string3));
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        u0();
        if (a()) {
            x0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(m, "RGMMFuzzyGuideView hide()");
        }
        super.c();
        this.i.setVisibility(8);
        this.l = "";
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        String g;
        super.d(bundle);
        boolean Q2 = com.baidu.navisdk.ui.routeguide.control.x.b().Q2();
        if (Q2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(m, "updateData isVdrMiddleLowInStart ");
            }
            g = com.baidu.navisdk.ui.routeguide.holder.a.d().b();
        } else {
            g = com.baidu.navisdk.ui.routeguide.model.a0.I().g();
        }
        if (com.baidu.navisdk.util.common.l0.c(g)) {
            g = this.l;
        }
        f(g);
        B(Q2);
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void n0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.isShown()) {
            AnimationSet animationSet = new AnimationSet(true);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f, 1, 0.0f, 1, 0.0f);
            scaleAnimation.setDuration(550L);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
            alphaAnimation.setDuration(550L);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            ImageView imageView = this.k;
            if (imageView != null && this.j != null) {
                imageView.clearAnimation();
                this.j.clearAnimation();
                this.k.startAnimation(animationSet);
                this.j.startAnimation(animationSet);
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void s0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(m, "switchToSimpleGuidePanel ->");
        }
        y0();
        w0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(m, "RGMMFuzzyGuideView show()");
        }
        super.y();
        com.baidu.navisdk.ui.routeguide.control.x.b().E4();
        this.i.setVisibility(0);
        B(com.baidu.navisdk.ui.routeguide.control.x.b().Q2());
        return true;
    }

    public v(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        u0();
        x0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        if (this.i == null || com.baidu.navisdk.ui.routeguide.control.x.b().d0() != 1) {
            return;
        }
        this.i.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_guide_top_panel));
    }

    private void B(int i) {
        TextView textView = this.j;
        if (textView == null || textView.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
        if (i != marginLayoutParams.rightMargin) {
            marginLayoutParams.rightMargin = i;
            this.j.setLayoutParams(marginLayoutParams);
        }
    }
}
