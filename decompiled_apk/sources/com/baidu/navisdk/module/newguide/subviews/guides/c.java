package com.baidu.navisdk.module.newguide.subviews.guides;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class c extends com.baidu.navisdk.module.newguide.subviews.guides.b {
    private View i;
    private View j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private View r;
    private boolean s;
    private InterfaceC0268c t;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeExitMainRo", "onClick: mTurnIcon");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeExitMainRo", "onClick: ");
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.subviews.guides.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0268c {
        void a(boolean z);
    }

    public c(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = false;
        y0();
        u0();
    }

    private void y0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeExitMainRo", "initViews - orientation = " + this.f);
        }
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            if (gVar.d()) {
                gVar.e("RGDefaultModeExitMainRo", "initViews null == mRootViewGroup");
                return;
            }
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.nsdk_layout_rg_exit_main_road_guide_view_stub);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Exception e) {
                e.printStackTrace();
                if (com.baidu.navisdk.util.common.g.PRO_NAV.c()) {
                    com.baidu.navisdk.util.common.g.PRO_NAV.c("RGDefaultModeExitMainRo", "initViews: " + e.toString());
                }
            }
        }
        View findViewById = this.b.findViewById(R.id.bn_rg_exit_guide_main_layout);
        this.i = findViewById;
        this.j = findViewById.findViewById(R.id.bn_rg_exit_guide_layout);
        this.k = (ImageView) this.i.findViewById(R.id.bnav_rg_sg_turn_icon);
        this.l = (TextView) this.i.findViewById(R.id.bnav_rg_hw_after_meters_multi_tv);
        this.m = (TextView) this.i.findViewById(R.id.bnav_rg_hw_after_label_info);
        this.n = (TextView) this.i.findViewById(R.id.bnav_rg_hw_exit_code);
        this.o = (TextView) this.i.findViewById(R.id.bnav_rg_hw_go_where_tv);
        this.p = (TextView) this.i.findViewById(R.id.bn_rg_exit_main_next_road_name);
        this.q = (TextView) this.i.findViewById(R.id.bn_rg_exit_main_next_road_name_head);
        this.r = this.i.findViewById(R.id.bn_rg_exit_main_next_road_name_layout);
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
        }
        this.i.setOnClickListener(new b(this));
        z0();
    }

    private void z0() {
        if (this.j != null) {
            com.baidu.navisdk.module.newguide.a.e().a(this.j, R.drawable.bn_bg_rg_exit_main_road_guide_view);
        }
        View view = this.r;
        if (view != null) {
            com.baidu.navisdk.ui.util.b.a(view, R.drawable.bn_bg_rg_exit_main_road_follow_guide_view);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        z0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeExitMainRo", "hide() - mSimpleGuideView = " + this.i);
        }
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
        InterfaceC0268c interfaceC0268c = this.t;
        if (interfaceC0268c != null) {
            interfaceC0268c.a(false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        String str;
        String str2;
        boolean z;
        String string;
        boolean z2;
        boolean z3;
        if (this.s) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeExitMainRo", "updateData = " + bundle);
        }
        if (bundle == null) {
            return;
        }
        boolean z4 = bundle.getBoolean("remain_dist_hide", false);
        if (bundle.getInt("updatetype") == 1) {
            int i = bundle.getInt("resid", 0);
            int i2 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0);
            String string2 = bundle.getString("road_name");
            if (gVar.d()) {
                gVar.e("RGDefaultModeExitMainRo", "updateData! --> nextRoadName = " + string2);
            }
            if (string2 == null || string2.length() == 0) {
                string2 = JarUtils.getResources().getString(R.string.nsdk_string_navi_no_name_road);
            }
            if (i != 0 && this.k != null) {
                try {
                    if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
                        Drawable drawable = JarUtils.getResources().getDrawable(i);
                        this.k.setImageDrawable(drawable);
                        if (drawable == null) {
                            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1359", "1", "2");
                        }
                    } else {
                        this.k.setImageDrawable(com.baidu.navisdk.ui.routeguide.subview.util.b.a(i));
                    }
                } catch (OutOfMemoryError unused) {
                }
            } else if (i == 0) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1359", "1", "0");
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1359", "1", "1");
            }
            String a2 = a0.I().a(i2);
            String b2 = a0.I().b(a2);
            String a3 = a0.I().a(a2);
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("update text -> mAfterMetersInfoTV = ");
                if (this.l == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                sb.append(z2);
                sb.append(", mAfterLabelInfoTV = ");
                if (this.m == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                sb.append(z3);
                sb.append(", start = ");
                sb.append(b2);
                sb.append(", end = ");
                sb.append(a3);
                sb.append(" ,frontInfo = ");
                sb.append(a2);
                sb.append(", remainDist = ");
                sb.append(i2);
                gVar2.e("RGDefaultModeExitMainRo", sb.toString());
            }
            if (this.l != null && gVar2.d()) {
                gVar2.e("RGDefaultModeExitMainRo", "mAfterMetersInfoTV.getVisible = " + this.l.getVisibility());
            }
            TextView textView = this.l;
            String str3 = "";
            if (textView != null && this.m != null && b2 != null && a3 != null) {
                if (!z4) {
                    textView.setTextSize(0, JarUtils.getResources().getDimension(R.dimen.nsdk_rg_guide_txt_size_num));
                    this.l.setText(b2);
                    this.m.setText(a3);
                    this.l.setPadding(0, com.baidu.navisdk.module.asr.busi.c.a(2.0f), 0, 0);
                } else {
                    textView.setTextSize(0, JarUtils.getResources().getDimension(R.dimen.navi_dimens_36dp));
                    this.l.setText("现在");
                    this.l.setPadding(0, com.baidu.navisdk.module.asr.busi.c.a(12.0f), 0, 10);
                    this.m.setText("");
                }
            }
            String d = a0.I().d();
            if (gVar2.d()) {
                gVar2.e("RGDefaultModeExitMainRo", "mGoWhereInfoTV.setText --> " + d);
            }
            if (!TextUtils.isEmpty(d)) {
                String str4 = JarUtils.getResources().getString(R.string.nsdk_rg_go_out) + "  " + d;
                if (gVar2.d() && a0.F) {
                    str4 = str4 + "--测试路名折行效果测试路名折行效果测试路名折行效果测试路名折行效果";
                }
                TextView textView2 = this.o;
                if (textView2 != null && !textView2.getText().equals(str4)) {
                    this.o.setText(str4);
                }
            }
            Bundle bundle2 = a0.A;
            Bundle a4 = com.baidu.navisdk.ui.routeguide.holder.a.d().a(bundle2.getInt("nGPAddDist"), bundle2.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.GP_LENGTH, 0));
            if (gVar2.d()) {
                gVar2.e("RGDefaultModeExitMainRo", "updateData: " + a4);
            }
            if (a4 != null) {
                str = a4.getString("id");
                str2 = a4.getString("name");
            } else {
                str = null;
                str2 = null;
            }
            if (this.n != null) {
                if (gVar2.d() && a0.F) {
                    if (!TextUtils.isEmpty(str)) {
                        str3 = str;
                    }
                    str = str3 + "--12345678912";
                }
                if (TextUtils.isEmpty(str)) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                    this.n.setText(JarUtils.getResources().getString(R.string.nsdk_string_hw_ic_code, str));
                }
            }
            boolean n0 = n0();
            String c = a0.I().c(string2);
            if (gVar2.d()) {
                gVar2.e("RGDefaultModeExitMainRo", "updateData isShowFollow: " + n0 + ", " + c);
            }
            if (!n0 && (!TextUtils.isEmpty(c) || !TextUtils.isEmpty(str2))) {
                z = true;
            } else {
                z = false;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().d2()) {
                z = false;
            }
            if (z) {
                if (TextUtils.isEmpty(str2) && !c.endsWith("方向")) {
                    if (TextUtils.equals("目的地", c)) {
                        string = JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive);
                    } else {
                        string = JarUtils.getResources().getString(R.string.nsdk_string_rg_enter);
                    }
                } else {
                    string = JarUtils.getResources().getString(R.string.nsdk_string_rg_destine_for);
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.q.setText(string);
                    this.p.setText(str2 + " 方向");
                } else {
                    this.p.setText(c);
                    this.q.setText(string);
                }
                this.r.setVisibility(0);
                this.p.setVisibility(0);
                this.q.setVisibility(0);
                InterfaceC0268c interfaceC0268c = this.t;
                if (interfaceC0268c != null) {
                    interfaceC0268c.a(true);
                    return;
                }
                return;
            }
            this.r.setVisibility(8);
            InterfaceC0268c interfaceC0268c2 = this.t;
            if (interfaceC0268c2 != null) {
                interfaceC0268c2.a(false);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void f(String str) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        com.baidu.navisdk.ui.util.j.a(this.k);
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void o0() {
        View view = this.i;
        if (view != null && view.isShown() && !this.s) {
            a(this.k, this.l, this.m, this.o, this.n, this.r);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public View p0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeExitMainRo", "getCurrentPanelView() mSimpleGuideView:" + this.i);
        }
        return this.i;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public int q0() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_default_top_guide_panel_total_min_height);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void s0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void t0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void u0() {
        d(a0.I().h());
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public int w0() {
        View view = this.i;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.s) {
            return false;
        }
        super.y();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeExitMainRo", "show() - mSimpleGuideView = " + this.i);
        }
        View view = this.i;
        if (view != null) {
            view.setVisibility(0);
            this.i.requestLayout();
            if (!x.b().Z1()) {
                x.b().N3();
            }
        }
        u0();
        return true;
    }

    private void a(View... viewArr) {
        if (this.s) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setDuration(500L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        for (View view : viewArr) {
            if (view != null) {
                view.clearAnimation();
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                view.startAnimation(animationSet);
            }
        }
    }

    public void a(InterfaceC0268c interfaceC0268c) {
        this.t = interfaceC0268c;
    }
}
