package com.baidu.navisdk.module.newguide.subviews.guides;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.f1;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.m;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class g extends com.baidu.navisdk.ui.routeguide.widget.b {
    private View i;
    private View j;
    private View k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private ViewGroup t;
    private f1 u;
    private String v;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a(g gVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMDefaultModeHighwayN", "onClick: mExitTurnIcon");
            }
        }
    }

    public g(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
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
        this.s = null;
        this.t = null;
        t0();
    }

    private void s0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default highway exitVdrLowPrecisionGuideView: ");
        }
        f1 f1Var = this.u;
        if (f1Var != null && f1Var.c()) {
            this.u.a();
        }
    }

    private void t0() {
        if (this.b == null) {
            return;
        }
        if (1 == x.b().d0()) {
            this.f = 1;
        } else {
            this.f = 2;
        }
        ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.nsdk_layout_rg_highway_simple_guide_stub);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Exception e) {
                e.printStackTrace();
                if (com.baidu.navisdk.util.common.g.PRO_NAV.c()) {
                    com.baidu.navisdk.util.common.g.PRO_NAV.c("RGMMDefaultModeHighwayN", "initViews: " + e.toString());
                }
            }
        }
        View findViewById = this.b.findViewById(R.id.bnav_rg_new_highway_simple);
        this.i = findViewById;
        if (findViewById == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("RGMMDefaultModeHighwayN", "initViews mHighwayView == null");
                return;
            }
            return;
        }
        this.t = (ViewGroup) findViewById.findViewById(R.id.bnav_rg_hw_guide_info_layout);
        this.l = (ImageView) this.i.findViewById(R.id.bnav_rg_hw_turn_icon);
        this.j = this.i.findViewById(R.id.bnav_rg_hg_direction_mode);
        this.m = (TextView) this.i.findViewById(R.id.bnav_rg_hw_after_meters_multi_tv);
        this.n = (TextView) this.i.findViewById(R.id.bnav_rg_hw_after_label_info);
        this.o = (TextView) this.i.findViewById(R.id.bnav_rg_hw_go_where_multi_tv);
        this.p = (TextView) this.i.findViewById(R.id.bnav_rg_hw_ic_code);
        this.k = this.i.findViewById(R.id.bnav_rg_hg_along_mode);
        this.q = (TextView) this.i.findViewById(R.id.bnav_rg_hg_cur_road_name_tv);
        this.r = (TextView) this.i.findViewById(R.id.bnav_rg_hg_cur_road_remain_dist_tv);
        this.s = (TextView) this.i.findViewById(R.id.bnav_rg_hg_cur_road_remain_dist_word);
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
        }
        w0();
        r0();
    }

    private void u0() {
        if (this.u == null) {
            this.u = new f1();
        }
        boolean a2 = this.u.a((ViewGroup) this.i, R.id.bnav_rg_vdr_low_precision_guide_layout_highway);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default highway intoVdrLowPrecisionGuideView: " + a2);
        }
    }

    private void w0() {
        if (this.i != null) {
            com.baidu.navisdk.module.newguide.a.e().a(this.i);
        }
    }

    private void x0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default highway updateVdrGuideView: ");
        }
        if (this.u == null) {
            u0();
        }
        View view = this.k;
        if (view != null && view.getVisibility() != 8) {
            this.k.setVisibility(8);
        }
        View view2 = this.j;
        if (view2 != null && view2.getVisibility() != 8) {
            this.j.setVisibility(8);
        }
        String a2 = m.y().a(4);
        if (this.u != null && !TextUtils.isEmpty(a2)) {
            this.u.a(a2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        w0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeHighwayN", "hide - mHighwayViewContainer = " + this.i);
        }
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
        this.v = null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        String str;
        String str2;
        boolean z;
        int i;
        int i2;
        if (RouteGuideFSM.getInstance().getCurrentEvent() != null && RouteGuideFSM.getInstance().getCurrentEvent().equals(RGFSMTable.FsmEvent.MSG_YAWING_START)) {
            return;
        }
        if (x.b().P2()) {
            x0();
            return;
        }
        s0();
        String j = m.y().j();
        String b = a0.I().b(j);
        String a2 = a0.I().a(j);
        Bundle bundle2 = a0.A;
        Bundle a3 = com.baidu.navisdk.ui.routeguide.holder.a.d().a(bundle2.getInt("nGPAddDist"), bundle2.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.GP_LENGTH, 0));
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeHighwayN", "updateData exitBundle: " + a3);
        }
        if (a3 != null) {
            str2 = a3.getString("id");
            str = a3.getString("name");
        } else {
            str = null;
            str2 = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = m.y().a();
        }
        String b2 = m.y().b();
        if (!TextUtils.isEmpty(str) && !str.equals(b2)) {
            z = false;
        } else {
            z = true;
        }
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeHighwayN", "updateData: " + j + ",direction: " + str + ",curRoadName:" + b2);
        }
        View view = this.k;
        if (view != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        View view2 = this.j;
        if (view2 != null) {
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            view2.setVisibility(i);
        }
        if (z) {
            this.v = null;
            TextView textView = this.q;
            if (textView != null) {
                textView.setText(b2);
            }
            TextView textView2 = this.r;
            if (textView2 != null) {
                textView2.setText(b);
            }
            TextView textView3 = this.s;
            if (textView3 != null) {
                textView3.setText(a2);
                return;
            }
            return;
        }
        TextView textView4 = this.m;
        if (textView4 != null && this.n != null && b != null && a2 != null) {
            textView4.setText(b);
            this.n.setText(a2);
        }
        if (this.p != null) {
            if (gVar.d() && a0.F) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                str2 = str2 + "--12345678912";
            }
            if (TextUtils.isEmpty(str2)) {
                this.p.setVisibility(8);
            } else {
                this.p.setVisibility(0);
                this.p.setText(JarUtils.getResources().getString(R.string.nsdk_string_hw_ic_code, str2));
            }
        }
        if (!str.equals(this.v)) {
            this.v = str;
            String string = JarUtils.getResources().getString(R.string.nsdk_string_rg_destine_for);
            String string2 = JarUtils.getResources().getString(R.string.bnav_string_hw_direction);
            if (gVar.d() && a0.F) {
                str = str + "--测试路名折行效果测试路名折行效果测试路名折行效果测试路名折行效果";
            }
            int length = str.length();
            String str3 = string + " " + str + " " + string2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#80ffffff")), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 3, length + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#80ffffff")), length + 4, str3.length(), 33);
            TextView textView5 = this.o;
            if (textView5 != null) {
                textView5.setText(spannableStringBuilder);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public void f(String str) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        this.v = null;
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.l = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public void n0() {
        Object valueOf;
        ViewGroup viewGroup = this.t;
        if (viewGroup != null && viewGroup.isShown()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.4f);
            alphaAnimation.setDuration(550L);
            this.t.clearAnimation();
            this.t.startAnimation(alphaAnimation);
            a(this.l, this.n, this.m, this.p, this.o, this.k);
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("entryVoicePanelFuseAnim mGuideInfoLayout.isShown = ");
            ViewGroup viewGroup2 = this.t;
            if (viewGroup2 == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(viewGroup2.isShown());
            }
            sb.append(valueOf);
            gVar.e("RGMMDefaultModeHighwayN", sb.toString());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public View o0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMDefaultModeHighwayN", "getCurrentPanelView() mHighwayView:" + this.i);
        }
        return this.i;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public int p0() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_default_top_guide_panel_total_min_height);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public boolean q0() {
        return super.q0();
    }

    public void r0() {
        d(null);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public boolean v(int i) {
        return super.v(i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeHighwayN", "show() - mHighwayViewContainer = " + this.i);
        }
        this.v = null;
        View view = this.i;
        if (view != null) {
            view.setVisibility(0);
        }
        r0();
        return true;
    }

    private void a(View... viewArr) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setDuration(550L);
        for (View view : viewArr) {
            if (view != null && view.isShown()) {
                view.clearAnimation();
                view.startAnimation(scaleAnimation);
            }
        }
    }
}
