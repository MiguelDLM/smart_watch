package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.widget.BNFlowLayout;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class i0 extends g0 {
    private static final String y0 = "i0";
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private View E;
    private CharSequence F;
    private String G;
    private CharSequence H;
    private CharSequence I;
    private int J;
    private int K;
    private int L;
    private int M;
    private RelativeLayout N;
    private RelativeLayout O;
    private TextView P;
    private TextView Q;
    private BNFlowLayout R;
    private View S;
    private View T;
    private View U;
    private TextView V;
    private ImageView W;
    private ImageView X;
    private ImageView Y;
    private ImageView Z;
    private ImageView a0;
    private ImageView b0;
    private String c0;
    private String d0;
    private int e0;
    private int f0;
    private int g0;
    private Drawable h0;
    private Drawable i0;
    private Drawable j0;
    private int k0;
    private String l0;
    private com.baidu.navisdk.util.navimageloader.b m0;
    private com.baidu.navisdk.util.navimageloader.e n0;

    /* renamed from: o0, reason: collision with root package name */
    private String f8788o0;
    private boolean p0;
    private boolean q0;
    private com.baidu.navisdk.ui.routeguide.model.u r0;
    private boolean s0;
    private int t0;
    private List<e> u0;
    private f v0;
    private LinearLayout w;
    private ArrayList<ImageView> w0;
    private RelativeLayout x;

    /* renamed from: x0, reason: collision with root package name */
    private com.baidu.navisdk.module.pronavi.model.d f8789x0;
    private LinearLayout y;
    private ImageView z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a(i0 i0Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements g0.c {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void a() {
            if (i0.this.p0) {
                com.baidu.navisdk.ui.routeguide.control.x.b().W3();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void b() {
            i0.this.w0();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void c() {
            if (!com.baidu.navisdk.ui.routeguide.control.s.T().b(i0.this.r0)) {
                com.baidu.navisdk.ui.routeguide.control.x.b().V0();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void d() {
            i0.this.A0();
            i0.this.z0();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i0.this.v0 != null) {
                i0.this.v0.c();
            }
            i0.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i0.this.v0 != null) {
                i0.this.v0.b();
            }
            i0.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public String f8793a;
        public int b = com.baidu.navisdk.ui.util.b.b(R.color.nsdk_rg_operable_notification_label_border);
        public int c = com.baidu.navisdk.ui.util.b.b(R.color.nsdk_rg_operable_notification_subtitle);
        public int d = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_12dp);
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a();

        void b();

        void c();
    }

    public i0(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup);
        this.w = null;
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
        this.H = null;
        this.I = null;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.c0 = null;
        this.d0 = null;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = null;
        this.i0 = null;
        this.j0 = null;
        this.k0 = 0;
        this.l0 = null;
        this.m0 = null;
        this.n0 = null;
        this.f8788o0 = null;
        this.p0 = false;
        this.q0 = false;
        this.r0 = null;
        this.s0 = false;
        this.t0 = 2;
        this.u0 = null;
        this.v0 = null;
        this.t = i;
        this.f8788o0 = String.valueOf(hashCode());
        y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        com.baidu.navisdk.ui.routeguide.control.s.T().c(this);
    }

    private void B0() {
        if (this.E != null && this.y != null) {
            if (!TextUtils.isEmpty(this.H) && !TextUtils.isEmpty(this.I)) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.H) && TextUtils.isEmpty(this.I)) {
                this.y.setVisibility(8);
            } else {
                this.y.setVisibility(0);
            }
        }
    }

    private void C0() {
        a(this.F);
        h(this.G);
        b(this.H);
        c(this.I);
        y(this.J);
        E(this.K);
        A(this.L);
        F(this.M);
        B0();
        d(this.h0);
        a(this.l0, this.m0, this.n0);
        B(this.k0);
        g(this.c0);
        f(this.d0);
        c(this.i0);
        b(this.j0);
        x(this.e0);
        w(this.f0);
        b(this.u0);
        b(this.f8789x0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null && this.O != null) {
            relativeLayout.setClickable(true);
            this.N.setOnClickListener(new c());
            this.O.setClickable(true);
            this.O.setOnClickListener(new d());
        }
    }

    private int x0() {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f h0 = h0();
        if (h0.f == 3) {
            return h0.b;
        }
        return 0;
    }

    private void y0() {
        Context context;
        if (this.i != null && (context = this.f9165a) != null) {
            View a2 = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_mapmode_operable_notification);
            this.k = a2;
            if (a2 == null) {
                return;
            }
            a2.setOnClickListener(new a(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            if (com.baidu.navisdk.module.newguide.a.e().d() && j0()) {
                layoutParams.bottomMargin = x0();
            }
            this.i.addView(this.k, layoutParams);
            this.x = (RelativeLayout) this.k.findViewById(R.id.bnav_rg_operable_notification_title_layout);
            this.z = (ImageView) this.k.findViewById(R.id.bnav_rg_operable_notification_icon);
            this.A = (TextView) this.k.findViewById(R.id.bnav_rg_operable_notification_maintitle_text);
            this.B = (TextView) this.k.findViewById(R.id.bnav_rg_operable_notification_maintitle_label);
            this.y = (LinearLayout) this.k.findViewById(R.id.bnav_rg_operable_notification_subtitle_layout);
            this.C = (TextView) this.k.findViewById(R.id.bnav_rg_operable_notification_subtitle_text);
            this.D = (TextView) this.k.findViewById(R.id.bnav_rg_operable_notification_subtitle_text_1);
            this.E = this.k.findViewById(R.id.bnav_rg_operable_notification_subtitle_split_line);
            this.N = (RelativeLayout) this.k.findViewById(R.id.bnav_rg_operable_notification_confirm_btn_layout);
            this.O = (RelativeLayout) this.k.findViewById(R.id.bnav_rg_operable_notification_cancel_btn_layout);
            this.P = (TextView) this.k.findViewById(R.id.bnav_rg_operable_notification_confirm_text);
            this.Q = (TextView) this.k.findViewById(R.id.bnav_rg_operable_notification_cancel_text);
            this.w = (LinearLayout) this.k.findViewById(R.id.bnav_rg_operable_notification_layout);
            this.R = (BNFlowLayout) this.k.findViewById(R.id.bnav_rg_operable_notification_labels);
            this.S = this.k.findViewById(R.id.service_area_layout);
            this.T = this.k.findViewById(R.id.hw_service_icon_layout);
            this.W = (ImageView) this.k.findViewById(R.id.hw_item_icon_park);
            this.X = (ImageView) this.k.findViewById(R.id.hw_item_icon_petrol_station);
            this.Y = (ImageView) this.k.findViewById(R.id.hw_item_icon_diningroom);
            this.Z = (ImageView) this.k.findViewById(R.id.hw_item_icon_wc);
            this.a0 = (ImageView) this.k.findViewById(R.id.hw_item_icon_garage);
            this.b0 = (ImageView) this.k.findViewById(R.id.hw_item_icon_shop);
            this.U = this.k.findViewById(R.id.bnavi_rg_hw_service_panel_empty_parking_place_container);
            View view = this.k;
            int i = R.id.bnavi_rg_hw_service_panel_empty_parking_place_count;
            this.V = (TextView) view.findViewById(i);
            this.V = (TextView) this.k.findViewById(i);
            ArrayList<ImageView> arrayList = new ArrayList<>();
            this.w0 = arrayList;
            arrayList.add(this.W);
            this.w0.add(this.X);
            this.w0.add(this.Y);
            this.w0.add(this.Z);
            this.w0.add(this.a0);
            this.w0.add(this.b0);
            z0();
            this.q = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null && this.O != null) {
            relativeLayout.setClickable(false);
            this.O.setClickable(false);
        }
    }

    public i0 A(int i) {
        if (i <= 0) {
            return this;
        }
        this.L = i;
        TextView textView = this.A;
        if (textView != null) {
            textView.setTextSize(0, i);
        }
        return this;
    }

    public i0 B(boolean z) {
        ImageView imageView = this.z;
        if (imageView == null) {
            return this;
        }
        imageView.setVisibility(z ? 0 : 8);
        return this;
    }

    public i0 C(int i) {
        ImageView imageView = this.z;
        if (imageView != null && i > 0) {
            this.g0 = i;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            this.z.setLayoutParams(layoutParams);
        }
        return this;
    }

    public i0 D(int i) {
        this.n = i;
        if (i == 100) {
            B(R.color.nsdk_rg_operable_notification_background);
            y(R.color.nsdk_rg_operable_notification_maintitle);
            E(R.color.nsdk_rg_operable_notification_subtitle);
            A(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_18dp));
            F(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_16dp));
            c(com.baidu.navisdk.ui.util.b.c(R.drawable.nsdk_note_confirm_bt_bg_selector, true));
            b(com.baidu.navisdk.ui.util.b.c(R.drawable.nsdk_note_cancel_bt_bg_selector, true));
            x(R.color.nsdk_note_confirm_bt_txt_selector);
            w(R.color.nsdk_note_cancel_bt_txt_selector);
            this.o = 10000;
        } else if (i == 200) {
            int i2 = R.color.nsdk_rg_operable_notification_background;
            B(i2);
            y(R.color.nsdk_rg_operable_notification_maintitle);
            E(R.color.nsdk_rg_operable_notification_subtitle);
            A(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_18dp));
            F(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_16dp));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_rg_operable_notification_middle_priority_confirm_background, true));
            gradientDrawable.setCornerRadius(ScreenUtil.getInstance().dip2px(30));
            c(gradientDrawable);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setStroke(ScreenUtil.getInstance().dip2px(1), com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_a, true));
            gradientDrawable2.setColor(com.baidu.navisdk.ui.util.b.a(i2, true));
            gradientDrawable2.setCornerRadius(ScreenUtil.getInstance().dip2px(30));
            b(gradientDrawable2);
            x(R.color.nsdk_rg_operable_notification_middle_priority_confirm_text);
            w(R.color.nsdk_rg_operable_notification_middle_priority_cancel_text);
            this.o = 15000;
        } else if (i == 300) {
            int i3 = R.color.nsdk_rg_operable_notification_high_priority_background;
            B(i3);
            y(R.color.nsdk_rg_operable_notification_high_priority_maintitle);
            E(R.color.nsdk_rg_operable_notification_high_priority_subtitle);
            A(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_18dp));
            F(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_16dp));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_rg_operable_notification_high_priority_confirm_background, true));
            gradientDrawable3.setCornerRadius(ScreenUtil.getInstance().dip2px(30));
            c(gradientDrawable3);
            GradientDrawable gradientDrawable4 = new GradientDrawable();
            gradientDrawable4.setStroke(ScreenUtil.getInstance().dip2px(1), com.baidu.navisdk.ui.util.b.a(android.R.color.white, true));
            gradientDrawable4.setColor(com.baidu.navisdk.ui.util.b.a(i3, true));
            gradientDrawable4.setCornerRadius(ScreenUtil.getInstance().dip2px(30));
            b(gradientDrawable4);
            x(R.color.nsdk_rg_operable_notification_high_priority_confirm_text);
            w(R.color.nsdk_rg_operable_notification_high_priority_cancel_text);
            this.o = 20000;
        }
        return this;
    }

    public i0 E(int i) {
        if (i == -1) {
            return this;
        }
        this.K = i;
        TextView textView = this.C;
        if (textView != null) {
            com.baidu.navisdk.ui.util.b.a(textView, i);
        }
        TextView textView2 = this.D;
        if (textView2 != null) {
            com.baidu.navisdk.ui.util.b.a(textView2, i);
        }
        return this;
    }

    public i0 F(int i) {
        if (i <= 0) {
            return this;
        }
        this.M = i;
        TextView textView = this.C;
        if (textView != null) {
            textView.setTextSize(0, i);
        }
        TextView textView2 = this.D;
        if (textView2 != null) {
            textView2.setTextSize(0, i);
        }
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void e0() {
        this.o = 0;
        com.baidu.navisdk.ui.routeguide.model.u uVar = this.r0;
        if (uVar != null) {
            CountDownTimer countDownTimer = uVar.A;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            com.baidu.navisdk.ui.routeguide.model.u uVar2 = this.r0;
            uVar2.F = false;
            uVar2.E = false;
            u0();
        }
    }

    public i0 g(String str) {
        if (this.P != null && !TextUtils.isEmpty(str)) {
            this.c0 = str;
            this.P.setText(str);
            com.baidu.navisdk.ui.routeguide.model.u uVar = this.r0;
            if (uVar != null && uVar.D > 0 && uVar.E && uVar.F) {
                this.P.setText(str + " (" + this.r0.D + "s)");
            } else {
                this.P.setText(str);
            }
            this.P.setVisibility(0);
            this.N.setVisibility(0);
        }
        return this;
    }

    public i0 h(String str) {
        if (this.B == null) {
            return this;
        }
        if (TextUtils.isEmpty(str)) {
            this.G = null;
            this.B.setVisibility(8);
            return this;
        }
        this.G = str;
        this.B.setText(str);
        this.B.setVisibility(0);
        return this;
    }

    public i0 i(String str) {
        if (com.baidu.navisdk.j.d()) {
            this.l0 = str;
            this.z.setVisibility(0);
            ImageLoader.with(this.f9165a).load(str).placeHolder(R.drawable.nsdk_icon_default_pic).into(this.z);
        }
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0
    public void o0() {
        super.o0();
        z0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0
    public void p0() {
        if (!com.baidu.navisdk.ui.routeguide.control.s.T().b(this.t)) {
            o0();
        } else {
            super.p0();
            w0();
        }
    }

    public void q0() {
        f fVar = this.v0;
        if (fVar != null) {
            fVar.a();
        }
    }

    public int r0() {
        return 1;
    }

    public ImageView s0() {
        return this.z;
    }

    public void t0() {
        super.c();
        z0();
    }

    public i0 u0() {
        com.baidu.navisdk.ui.routeguide.model.u uVar = this.r0;
        if (uVar != null && uVar.F) {
            if (this.P != null && !TextUtils.isEmpty(this.c0)) {
                com.baidu.navisdk.ui.routeguide.model.u uVar2 = this.r0;
                if (uVar2 != null && uVar2.D > 0 && uVar2.E) {
                    this.P.setText(this.c0 + " (" + this.r0.D + "s)");
                } else {
                    this.P.setText(this.c0);
                }
                this.P.setVisibility(0);
            } else {
                return this;
            }
        } else if (this.Q != null && !TextUtils.isEmpty(this.d0)) {
            com.baidu.navisdk.ui.routeguide.model.u uVar3 = this.r0;
            if (uVar3 != null && uVar3.D > 0 && uVar3.E) {
                this.Q.setText(this.d0 + " (" + this.r0.D + "s)");
            } else {
                this.Q.setText(this.d0);
            }
            this.Q.setVisibility(0);
        }
        return this;
    }

    public i0 v(int i) {
        this.o = i;
        return this;
    }

    public i0 w(int i) {
        TextView textView = this.Q;
        if (textView == null) {
            return this;
        }
        this.f0 = i;
        com.baidu.navisdk.ui.util.b.a(textView, i);
        return this;
    }

    public i0 x(int i) {
        TextView textView = this.P;
        if (textView == null) {
            return this;
        }
        this.e0 = i;
        com.baidu.navisdk.ui.util.b.a(textView, i);
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        i0 i0Var;
        CountDownTimer countDownTimer;
        com.baidu.navisdk.asr.d.B().a(r0());
        com.baidu.navisdk.ui.routeguide.control.x.b().a(false);
        com.baidu.navisdk.ui.routeguide.control.x.b().A(false);
        com.baidu.navisdk.ui.routeguide.control.s.T().o();
        com.baidu.navisdk.ui.routeguide.control.s.T().h(this.t);
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().b().c();
        }
        if (this.r0 == null) {
            i0Var = this;
            i0Var.r0 = new com.baidu.navisdk.ui.routeguide.model.u(this, this.f8788o0, this.n, this.o, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.c0, this.d0, this.e0, this.f0, this.h0, this.k0, this.i0, this.j0, this.v0, this.r, this.s, this.l0, this.m0, this.n0, this.t, this.p0, this.q0, this.t0, this.s0, this.p, this.g0, this.u0, this.f8789x0);
        } else {
            i0Var = this;
        }
        if (!com.baidu.navisdk.ui.routeguide.control.s.T().c(i0Var.r0)) {
            com.baidu.navisdk.ui.routeguide.control.s.T().a(i0Var.r0);
            super.y();
        }
        com.baidu.navisdk.ui.routeguide.model.u uVar = i0Var.r0;
        if (uVar == null || (countDownTimer = uVar.A) == null || i0Var.o < 0) {
            return true;
        }
        countDownTimer.start();
        return true;
    }

    public i0 z(int i) {
        TextView textView = this.A;
        if (textView != null && i > 0) {
            if (i > 1) {
                this.t0 = i;
                textView.setMaxLines(i);
            } else {
                this.t0 = 1;
                textView.setMaxLines(1);
            }
        }
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    public i0 b(CharSequence charSequence) {
        if (this.C != null && !TextUtils.isEmpty(charSequence) && com.baidu.navisdk.j.d()) {
            this.H = charSequence;
            this.C.setText(charSequence);
            this.C.setVisibility(0);
            B0();
        }
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        z0();
        com.baidu.navisdk.ui.routeguide.control.s.T().d(this.r0);
        com.baidu.navisdk.ui.routeguide.model.u uVar = this.r0;
        if (uVar != null) {
            uVar.a();
            this.r0 = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        C0();
    }

    public i0 f(String str) {
        if (this.Q != null && !TextUtils.isEmpty(str)) {
            this.d0 = str;
            com.baidu.navisdk.ui.routeguide.model.u uVar = this.r0;
            if (uVar != null && uVar.D > 0 && uVar.E && !uVar.F) {
                this.Q.setText(str + " (" + this.r0.D + "s)");
            } else {
                this.Q.setText(str);
            }
            this.Q.setVisibility(0);
            this.O.setVisibility(0);
        }
        return this;
    }

    public i0 B(int i) {
        LinearLayout linearLayout = this.w;
        if (linearLayout == null) {
            return this;
        }
        if (linearLayout.getBackground() != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.f();
            }
            this.k0 = i;
            Drawable background = this.w.getBackground();
            background.clearColorFilter();
            background.setColorFilter(com.baidu.navisdk.ui.util.b.b(i), PorterDuff.Mode.SRC_IN);
        } else {
            LogUtil.e(y0, "OperableNotification setNotificationColor, mNotificationLayout.getBackground() == null!!");
        }
        return this;
    }

    public i0 a(CharSequence charSequence) {
        if (this.A != null && !TextUtils.isEmpty(charSequence)) {
            this.F = charSequence;
            this.A.setText(charSequence);
            this.A.setVisibility(0);
        }
        return this;
    }

    public i0 d(Drawable drawable) {
        ImageView imageView = this.z;
        if (imageView != null && drawable != null) {
            this.h0 = drawable;
            imageView.setImageDrawable(drawable);
            this.z.setVisibility(0);
        }
        return this;
    }

    public i0 A(boolean z) {
        this.p0 = z;
        return this;
    }

    public i0 z(boolean z) {
        this.p = z;
        return this;
    }

    private void C(boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int d2;
        ImageView.ScaleType scaleType;
        int d3;
        if (this.x != null) {
            if (z) {
                d3 = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_25dp);
            } else {
                d3 = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_17dp);
            }
            this.x.setPadding(0, d3, 0, d3);
        }
        ImageView imageView = this.z;
        if (imageView != null) {
            if (z) {
                scaleType = ImageView.ScaleType.FIT_START;
            } else {
                scaleType = ImageView.ScaleType.FIT_CENTER;
            }
            imageView.setScaleType(scaleType);
        }
        LinearLayout linearLayout = this.y;
        if (linearLayout == null || (layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            d2 = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_8dp);
        } else {
            d2 = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_3dp);
        }
        layoutParams.topMargin = d2;
    }

    public i0 a(String str, com.baidu.navisdk.util.navimageloader.b bVar, com.baidu.navisdk.util.navimageloader.e eVar) {
        if (this.z == null) {
            return this;
        }
        this.l0 = str;
        this.m0 = bVar;
        this.n0 = eVar;
        com.baidu.navisdk.util.navimageloader.c.d().a(str, this.z, bVar, eVar);
        this.z.setVisibility(0);
        return this;
    }

    public i0 b(Drawable drawable) {
        RelativeLayout relativeLayout = this.O;
        if (relativeLayout != null && drawable != null) {
            this.j0 = drawable;
            relativeLayout.setBackgroundDrawable(drawable);
        }
        return this;
    }

    public i0 c(CharSequence charSequence) {
        if (this.D != null && !TextUtils.isEmpty(charSequence) && com.baidu.navisdk.j.d()) {
            this.I = charSequence;
            this.D.setText(charSequence);
            this.D.setVisibility(0);
            B0();
        }
        return this;
    }

    public i0 b(List<e> list) {
        this.u0 = list;
        if (this.R != null) {
            if (list != null && list.size() > 0) {
                this.R.setVisibility(0);
                c(list);
                C(true);
            } else {
                this.R.setVisibility(8);
                C(false);
            }
        }
        return this;
    }

    public i0 a(com.baidu.navisdk.ui.routeguide.model.u uVar) {
        if (uVar == null) {
            return this;
        }
        this.r0 = uVar;
        return this;
    }

    public i0 c(Drawable drawable) {
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null && drawable != null) {
            this.i0 = drawable;
            relativeLayout.setBackgroundDrawable(drawable);
        }
        return this;
    }

    public i0 a(f fVar) {
        this.v0 = fVar;
        return this;
    }

    public i0 a(g0.e eVar) {
        this.r = eVar;
        return this;
    }

    private void c(@NonNull List<e> list) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        Resources resources = JarUtils.getResources();
        int i = R.dimen.navi_dimens_6dp;
        int dimensionPixelSize = resources.getDimensionPixelSize(i);
        int dimensionPixelSize2 = JarUtils.getResources().getDimensionPixelSize(i);
        int dimensionPixelSize3 = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_2dp);
        layoutParams.setMargins(0, 0, dimensionPixelSize, 0);
        BNFlowLayout bNFlowLayout = this.R;
        if (bNFlowLayout != null) {
            bNFlowLayout.removeAllViews();
        }
        for (e eVar : list) {
            TextView textView = new TextView(this.f9165a);
            textView.setText(eVar.f8793a);
            textView.setGravity(17);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3);
            textView.setTextColor(eVar.c);
            textView.setTextSize(0, eVar.d);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(1, eVar.b);
            gradientDrawable.setCornerRadius(ScreenUtil.getInstance().dip2px(2));
            textView.setBackground(gradientDrawable);
            BNFlowLayout bNFlowLayout2 = this.R;
            if (bNFlowLayout2 != null) {
                bNFlowLayout2.addView(textView, layoutParams);
            }
        }
    }

    public i0 a(g0.d dVar) {
        this.s = dVar;
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(y0, "getEnterDoubleMap: " + i + ",params:" + fVar + "," + a());
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

    public i0 y(int i) {
        TextView textView = this.A;
        if (textView != null && i != -1) {
            this.J = i;
            com.baidu.navisdk.ui.util.b.a(textView, i);
        }
        return this;
    }

    public i0 b(com.baidu.navisdk.module.pronavi.model.d dVar) {
        this.f8789x0 = dVar;
        if (dVar != null && dVar.p() == 4) {
            this.T.setVisibility(0);
            this.U.setVisibility(dVar.r() ? 0 : 8);
            if (dVar.r()) {
                com.baidu.navisdk.module.pronavi.model.a aVar = (com.baidu.navisdk.module.pronavi.model.a) dVar.a("parking_lot_info");
                if (aVar != null && aVar.a() > 0) {
                    this.U.setVisibility(0);
                    this.V.setText(String.valueOf(aVar.a()));
                } else {
                    this.U.setVisibility(8);
                }
            } else {
                this.U.setVisibility(8);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.i.a(new ArrayList(dVar.o()), this.w0, com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.i.f8769a);
        } else {
            this.S.setVisibility(8);
        }
        return this;
    }

    public i0 y(boolean z) {
        this.s0 = z;
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(y0, "getEnterNormal: " + i + ",params:" + fVar + "," + a());
        }
        if (z) {
            if (this.k == null || !a()) {
                return null;
            }
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.k, 0);
        }
        super.c(i, i2, z, fVar);
        return null;
    }
}
