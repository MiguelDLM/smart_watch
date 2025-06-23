package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import XXO0.oIX0oI;
import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.model.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.List;

/* loaded from: classes8.dex */
public class m extends g0 {
    private TextView A;
    private TextView B;
    private RelativeLayout C;
    private LinearLayout D;
    private String E;
    private String F;
    private String G;
    private int H;
    private int I;
    private int J;
    private Drawable K;
    private int L;
    private String M;
    private com.baidu.navisdk.util.navimageloader.b N;
    private com.baidu.navisdk.util.navimageloader.e O;
    private g P;
    private LinearLayout Q;
    private View R;
    private ImageView S;
    private TextView T;
    protected String U;
    private com.baidu.navisdk.ui.routeguide.model.f V;
    private int W;
    private f.c X;
    private CountDownTimer Y;
    private final int w;
    private RelativeLayout x;
    private ImageView y;
    private TextView z;

    /* loaded from: classes8.dex */
    public class a implements g0.c {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void b() {
            com.baidu.navisdk.ui.routeguide.control.s.T().b(m.this.V);
            if (m.this.V != null) {
                m mVar = m.this;
                mVar.a(mVar.V.a());
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void d() {
            m.this.y0();
            m.this.x0();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (m.this.A != null && m.this.D != null) {
                m.this.A.setMaxWidth((m.this.D.getWidth() / 3) * 2);
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.util.worker.f<String, String> {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (m.this.B != null && m.this.D != null) {
                m.this.B.setMaxWidth(m.this.D.getWidth() / 3);
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.X != null) {
                m.this.X.onClick(1);
            }
            if (m.this.w != 1) {
                m.this.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.X != null) {
                m.this.X.onClick(2);
            }
            m.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.X != null) {
                m.this.X.onClick(2);
            }
            m.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a();
    }

    public m(Context context, ViewGroup viewGroup, int i, int i2) {
        super(context, viewGroup);
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = null;
        this.L = 0;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.U = null;
        this.V = null;
        this.W = -1;
        this.X = null;
        this.Y = null;
        this.t = i;
        this.U = String.valueOf(hashCode());
        this.w = i2;
        u0();
    }

    private void s0() {
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout != null) {
            relativeLayout.setElevation(0.0f);
            com.baidu.navisdk.ui.util.b.a(this.C, R.color.nsdk_rg_common_notification_low_priority);
        }
        View view = this.k;
        if (view != null) {
            com.baidu.navisdk.ui.util.b.a(view, R.drawable.nsdk_nav_notification_background);
        }
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.T;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private void t0() {
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setClickable(true);
        this.C.setOnClickListener(new d());
        this.Q.setOnClickListener(new e());
        TextView textView = this.T;
        if (textView != null) {
            textView.setOnClickListener(new f());
        }
    }

    private void u0() {
        Context context;
        if (this.i != null && (context = this.f9165a) != null) {
            View a2 = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_mapmode_common_notification);
            this.k = a2;
            if (a2 == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            this.y = (ImageView) this.k.findViewById(R.id.bnav_rg_common_notification_icon);
            this.x = (RelativeLayout) this.k.findViewById(R.id.bnav_rg_common_notification_all_text_layout);
            this.z = (TextView) this.k.findViewById(R.id.bnav_rg_common_notification_maintitle_text);
            this.A = (TextView) this.k.findViewById(R.id.bnav_rg_common_notification_subtitle_text);
            this.B = (TextView) this.k.findViewById(R.id.bnav_rg_common_notification_tips_text);
            this.C = (RelativeLayout) this.k.findViewById(R.id.bnav_rg_common_notification_layout);
            this.D = (LinearLayout) this.k.findViewById(R.id.bnav_rg_common_notification_sub_third_title_layout);
            this.Q = (LinearLayout) this.k.findViewById(R.id.bnav_rg_common_notification_close_layout);
            this.R = this.k.findViewById(R.id.bnav_rg_common_notification_close_line);
            this.S = (ImageView) this.k.findViewById(R.id.bnav_rg_common_notification_close_iv);
            this.T = (TextView) this.k.findViewById(R.id.bnav_rg_common_notification_bottom_tv);
            if (com.baidu.navisdk.module.newguide.a.e().d() && w0()) {
                layoutParams.bottomMargin = a(this.w, h0());
            }
            if (this.w == 1) {
                s0();
            }
            layoutParams.gravity = 80;
            this.i.addView(this.k, layoutParams);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMCommonNotificationView", "initViews:addView mNotificationView, mViewContainer.views = " + this.i.getChildCount());
            }
            t0();
            this.q = new a();
        }
    }

    private boolean w0() {
        if (this.f == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        com.baidu.navisdk.ui.routeguide.control.s.T().c(this);
    }

    private void z0() {
        f(this.E);
        g(this.F);
        h(this.G);
        x(this.H);
        A(this.I);
        D(this.J);
        b(this.K);
        a(this.M, this.N, this.O);
        y(this.L);
    }

    public m A(int i) {
        TextView textView = this.A;
        if (textView == null) {
            return this;
        }
        this.I = i;
        com.baidu.navisdk.ui.util.b.a(textView, i);
        com.baidu.navisdk.ui.util.b.a(this.R, i);
        return this;
    }

    public m B(int i) {
        this.W = i;
        return this;
    }

    public m C(int i) {
        RelativeLayout relativeLayout = this.x;
        if (relativeLayout != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
            marginLayoutParams.leftMargin = ScreenUtil.getInstance().dip2px(i);
            this.x.setLayoutParams(marginLayoutParams);
        }
        return this;
    }

    public m D(int i) {
        TextView textView = this.B;
        if (textView == null) {
            return this;
        }
        this.J = i;
        com.baidu.navisdk.ui.util.b.a(textView, i);
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0
    public void o0() {
        super.o0();
        x0();
        y0();
        i();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0
    public void p0() {
        if (!com.baidu.navisdk.ui.routeguide.control.s.T().a(this.t)) {
            o0();
            return;
        }
        super.p0();
        com.baidu.navisdk.ui.routeguide.model.f fVar = this.V;
        if (fVar != null) {
            a(fVar.a());
        }
        t0();
        LogUtil.e("caoyujieTodo", "recoveryView");
    }

    public void q0() {
        super.c();
        x0();
    }

    public void r0() {
        g gVar = this.P;
        if (gVar != null) {
            gVar.a();
        }
    }

    public m v(int i) {
        this.o = i;
        return this;
    }

    public m w(int i) {
        ImageView imageView = this.S;
        if (imageView == null) {
            return this;
        }
        if (i != 100) {
            if (i != 130 && i != 200) {
                if (i == 300) {
                    com.baidu.navisdk.ui.util.b.a(imageView, R.drawable.nsdk_drawable_common_notification_icon_close);
                }
            } else {
                com.baidu.navisdk.ui.util.b.a(imageView, R.drawable.nsdk_drawable_common_notification_icon_close);
            }
        } else {
            com.baidu.navisdk.ui.util.b.a(imageView, R.drawable.nsdk_drawable_toolbox_icon_quit_nav);
        }
        return this;
    }

    public m x(int i) {
        TextView textView = this.z;
        if (textView == null) {
            return this;
        }
        this.H = i;
        com.baidu.navisdk.ui.util.b.a(textView, i);
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        m mVar;
        String str;
        String str2;
        com.baidu.navisdk.ui.routeguide.model.f fVar;
        Handler handler;
        TextView textView;
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null && (textView = this.z) != null) {
            k.b(textView.getText().toString());
        }
        boolean z = false;
        if (!BNSettingManager.isAvoidanceNotificationVisible()) {
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.control.s.T().a(this.t) && !com.baidu.navisdk.ui.routeguide.control.s.T().l() && !com.baidu.navisdk.ui.routeguide.control.s.T().j()) {
            com.baidu.navisdk.ui.routeguide.control.s.T().g(this.t);
            if (this.V == null) {
                str = "RGMMCommonNotificationView";
                mVar = this;
                mVar.V = new com.baidu.navisdk.ui.routeguide.model.f(this, this.U, this.n, this.o, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.r, this.s, this.M, this.N, this.O, this.t, this.W, this.X, this.w);
            } else {
                mVar = this;
                str = "RGMMCommonNotificationView";
            }
            if (!com.baidu.navisdk.ui.routeguide.control.s.T().c(mVar.V)) {
                com.baidu.navisdk.ui.routeguide.control.s.T().a(mVar.V);
                z = super.y();
                str2 = str;
            } else {
                str2 = str;
                LogUtil.e(str2, "该通知model已经存在，不重复显示");
            }
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("AutoHide -> startAutoHideTime mHandler=");
                com.baidu.navisdk.ui.routeguide.model.f fVar2 = mVar.V;
                sb.append(fVar2 == null ? "null" : fVar2.t.toString());
                sb.append(", mAutoHideTime=");
                sb.append(mVar.o);
                sb.append(", mView = ");
                sb.append(toString());
                LogUtil.e(str2, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("show() model:");
                com.baidu.navisdk.ui.routeguide.model.f fVar3 = mVar.V;
                sb2.append(fVar3 != null ? fVar3.toString() : "null");
                LogUtil.e(str2, sb2.toString());
            }
            com.baidu.navisdk.ui.routeguide.model.f fVar4 = mVar.V;
            if (fVar4 != null && (handler = fVar4.t) != null) {
                handler.removeMessages(1000);
                int i = mVar.o;
                if (i > 0) {
                    mVar.V.t.sendEmptyMessageDelayed(1000, i);
                }
            }
            if (mVar.w == 1 && (fVar = mVar.V) != null) {
                mVar.a(fVar.d);
                com.baidu.navisdk.ui.routeguide.model.f fVar5 = mVar.V;
                if (fVar5.d > 0) {
                    fVar5.w.start();
                }
            }
            return z;
        }
        LogUtil.e("RGMMCommonNotificationView", "not allow show or has operable notification showing");
        o0();
        return false;
    }

    public m z(int i) {
        this.n = i;
        if (i == 100) {
            y(R.drawable.nsdk_nav_notification_background);
            x(R.color.nsdk_rg_common_notification_low_priority_main_text);
            A(R.color.nsdk_rg_common_notification_low_priority_sub_text);
            D(R.color.nsdk_rg_common_notification_low_priority_third_text);
            this.o = 3000;
        } else if (i == 200) {
            y(R.drawable.nsdk_nav_notification_background_middle_priority);
            x(R.color.nsdk_rg_common_notification_middle_priority_main_text);
            A(R.color.nsdk_rg_common_notification_middle_priority_sub_text);
            D(R.color.nsdk_rg_common_notification_middle_priority_third_text);
            this.o = 3000;
        } else if (i == 300) {
            y(R.drawable.nsdk_nav_notification_background_hight_priority);
            x(R.color.nsdk_rg_common_notification_high_priority_main_text);
            A(R.color.nsdk_rg_common_notification_high_priority_sub_text);
            D(R.color.nsdk_rg_common_notification_high_priority_third_text);
            this.o = 10000;
        } else if (i == 130) {
            y(R.drawable.nsdk_nav_notification_background_blue_bg_white_txt);
            x(R.color.nsdk_rg_common_notification_middle_priority_main_text);
            A(R.color.nsdk_rg_common_notification_middle_priority_sub_text);
            D(R.color.nsdk_rg_common_notification_middle_priority_third_text);
            this.o = 3000;
        } else if (i == 160) {
            y(R.drawable.nsdk_nav_notification_background_positive_blue_bg);
            x(R.color.nsdk_rg_common_notification_middle_priority_main_text);
            A(R.color.nsdk_rg_common_notification_middle_priority_sub_text);
            D(R.color.nsdk_rg_common_notification_middle_priority_third_text);
            this.o = 3000;
        } else if (i == 150) {
            y(R.drawable.nsdk_nav_notification_background_neutral_green_bg);
            x(R.color.nsdk_rg_common_notification_middle_priority_main_text);
            A(R.color.nsdk_rg_common_notification_middle_priority_sub_text);
            D(R.color.nsdk_rg_common_notification_middle_priority_third_text);
            this.o = 3000;
        }
        w(i);
        return this;
    }

    private int a(int i, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMCommonNotificationView", "getPortraitBottomEtaBarHeight: " + i + "," + fVar);
        }
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
        if (i == 0) {
            int i3 = fVar.f;
            if (i3 == 3) {
                return fVar.f6817a == 2 ? fVar.b : dimensionPixelSize;
            }
            if (i3 == 0 || (i2 = fVar.f6817a) == 0) {
                return dimensionPixelSize;
            }
            if (i2 != 2) {
                return fVar.g(true) ? com.baidu.navisdk.ui.routeguide.utils.b.p() : dimensionPixelSize;
            }
            if (fVar.g(true)) {
                return com.baidu.navisdk.ui.routeguide.utils.b.p();
            }
            return 0;
        }
        if (fVar.f == 3 && fVar.f6817a == 2) {
            return fVar.b;
        }
        return 0;
    }

    public m b(Drawable drawable) {
        ImageView imageView = this.y;
        if (imageView != null && drawable != null) {
            this.K = drawable;
            imageView.setImageDrawable(drawable);
            this.y.setVisibility(0);
        }
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        x0();
        CountDownTimer countDownTimer = this.Y;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().d(this.V);
        com.baidu.navisdk.ui.routeguide.model.f fVar = this.V;
        if (fVar != null) {
            fVar.c();
            this.V = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        z0();
    }

    public m f(String str) {
        if (this.z != null && this.A != null && this.B != null && !TextUtils.isEmpty(str)) {
            this.E = str;
            this.z.setText(Html.fromHtml(str));
            this.z.setVisibility(0);
            if (this.A.getVisibility() == 8 && this.B.getVisibility() == 8) {
                this.z.setMaxLines(2);
            } else {
                this.z.setMaxLines(1);
            }
        }
        return this;
    }

    public m g(String str) {
        TextView textView;
        if (this.A != null && !TextUtils.isEmpty(str) && (textView = this.z) != null) {
            this.F = str;
            textView.setMaxLines(1);
            this.A.setText(str);
            this.A.setVisibility(0);
        }
        return this;
    }

    public m h(String str) {
        if (this.z != null && this.B != null && !TextUtils.isEmpty(str)) {
            this.G = str;
            this.z.setMaxLines(1);
            this.B.setText(str);
            this.B.setVisibility(0);
            if (this.A != null && this.D != null) {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new b("setThirdTitleText1-" + m.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(2, 0));
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new c("setThirdTitleText2-" + m.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(2, 0));
            }
        }
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMCommonNotificationView", "getEnterNormal: " + i + ",params:" + fVar + "," + a());
        }
        if (z) {
            if (this.k == null || !a()) {
                return null;
            }
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.k, a(this.w, fVar));
        }
        super.c(i, i2, z, fVar);
        return null;
    }

    public void a(long j) {
        TextView textView = this.T;
        if (textView == null || j <= 0) {
            return;
        }
        textView.setText("我知道了(" + ((int) (j / 1000)) + oIX0oI.I0Io.f4095I0Io);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    public m a(String str, com.baidu.navisdk.util.navimageloader.b bVar, com.baidu.navisdk.util.navimageloader.e eVar) {
        if (this.y == null) {
            return this;
        }
        this.M = str;
        this.N = bVar;
        this.O = eVar;
        com.baidu.navisdk.util.navimageloader.c.d().a(str, this.y, bVar, eVar);
        this.y.setVisibility(0);
        return this;
    }

    public m a(com.baidu.navisdk.ui.routeguide.model.f fVar) {
        if (fVar == null) {
            return this;
        }
        this.V = fVar;
        return this;
    }

    public m a(g gVar) {
        this.P = gVar;
        return this;
    }

    public m a(g0.e eVar) {
        this.r = eVar;
        return this;
    }

    public m a(g0.d dVar) {
        this.s = dVar;
        return this;
    }

    public m a(f.c cVar) {
        this.X = cVar;
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMCommonNotificationView", "getEnterDoubleMap: " + i + ",params:" + fVar + "," + a());
        }
        if (z) {
            if (this.k == null || !a()) {
                return null;
            }
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.k, i2);
        }
        super.a(i, i2, z, fVar);
        return null;
    }

    public m y(int i) {
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout == null || this.w == 1) {
            return this;
        }
        this.L = i;
        com.baidu.navisdk.ui.util.b.a(relativeLayout, i);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMCommonNotificationView", "OperableNotification setNotificationBackground, " + i);
        }
        return this;
    }

    public m y(boolean z) {
        View view = this.R;
        if (view != null) {
            view.setVisibility(z ? 8 : 0);
        }
        return this;
    }
}
