package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.widget.RGMMCountDownCloseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.b;
import java.util.List;

/* loaded from: classes8.dex */
public class l extends g0 {
    private ImageView A;
    private RGMMCountDownCloseView B;
    private LinearLayout C;
    private String D;
    private com.baidu.navisdk.ui.routeguide.model.e E;
    private com.baidu.navisdk.util.navimageloader.b F;
    private View w;
    private TextView x;
    private Button y;
    private Button z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.E != null && l.this.E.i() != null) {
                l.this.E.i().b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.E != null && l.this.E.i() != null) {
                l.this.E.i().b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c(l lVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class d implements g0.c {
        public d() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void a() {
            if (l.this.E.l()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().W3();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void c() {
            if (!com.baidu.navisdk.ui.routeguide.control.s.T().b(l.this.E)) {
                com.baidu.navisdk.ui.routeguide.control.x.b().V0();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.c
        public void d() {
            com.baidu.navisdk.ui.routeguide.control.s.T().c(l.this);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f8813a;

        public e(i iVar) {
            this.f8813a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.E != null && l.this.E.i() != null) {
                l.this.E.i().a(((Integer) view.getTag()).intValue(), this.f8813a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.E != null && l.this.E.i() != null) {
                l.this.E.i().a(((Integer) view.getTag()).intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f8815a;

        public g(List list) {
            this.f8815a = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.E != null && l.this.E.i() != null) {
                if (l.this.E.b() == 2) {
                    l.this.E.i().a(0);
                } else if (l.this.E.b() == 1) {
                    l.this.E.i().a(0, (i) this.f8815a.get(0));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f8816a;

        public h(List list) {
            this.f8816a = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.E != null && l.this.E.i() != null) {
                if (l.this.E.b() == 2) {
                    l.this.E.i().a(1);
                } else if (l.this.E.b() == 1) {
                    l.this.E.i().a(1, (i) this.f8816a.get(1));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f8817a;
        private String b;
        private String c;
        private int d;

        public i(String str) {
            this.c = str;
        }

        public String c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public Drawable a() {
            return this.f8817a;
        }

        public String b() {
            return this.b;
        }

        public i(Drawable drawable, String str, String str2) {
            this.f8817a = drawable;
            this.b = str;
            this.c = str2;
        }

        public i(Drawable drawable, String str, String str2, int i) {
            this.f8817a = drawable;
            this.b = str;
            this.c = str2;
            this.d = i;
        }
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a();

        void a(int i);

        void a(int i, i iVar);

        void b();
    }

    public l(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.model.e eVar) {
        super(context, viewGroup);
        this.E = null;
        this.F = new b.C0502b().b(R.drawable.nsdk_notification_default_business_voice).a();
        if (eVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMCheckboxNotificationView", "RGMMCheckboxNotificationView constructor model is null");
                new Throwable("model can't null!");
                return;
            }
            return;
        }
        String valueOf = String.valueOf(hashCode());
        this.D = valueOf;
        this.E = eVar;
        eVar.a(valueOf);
        this.E.a(this);
        this.o = eVar.c();
        this.t = eVar.h();
        w0();
    }

    private void b(List<i> list) {
        if (list != null && list.size() > 0) {
            Button button = this.y;
            if (button != null) {
                button.setText(list.get(0).c);
                this.y.setOnClickListener(new g(list));
            }
            Button button2 = this.z;
            if (button2 != null) {
                button2.setText(list.get(1).c);
                this.z.setOnClickListener(new h(list));
            }
        }
    }

    private void f(String str) {
        if (this.x != null && !TextUtils.isEmpty(str)) {
            this.x.setText(str);
            this.x.setVisibility(0);
        }
    }

    private int t0() {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f h0 = h0();
        int i2 = h0.f;
        if (i2 == 3) {
            return h0.b;
        }
        if (i2 == 0) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
        }
        if (h0.g(true)) {
            return com.baidu.navisdk.ui.routeguide.utils.b.p();
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
    }

    private int u0() {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f h0 = h0();
        if (h0.f == 3) {
            return h0.b;
        }
        return 0;
    }

    private void v(int i2) {
        LinearLayout linearLayout = this.C;
        if (linearLayout != null && linearLayout.getLayoutParams() != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.C.getLayoutParams();
            if (i2 == 1) {
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
            } else {
                int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_checkbox_notification_margin_horizontal_land);
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = dimensionPixelOffset;
            }
            this.C.requestLayout();
        }
    }

    private void w(int i2) {
        TextView textView = this.x;
        if (textView != null && i2 != 0) {
            com.baidu.navisdk.ui.util.b.a(textView, i2);
        }
    }

    private void w0() {
        if (this.b != null && this.i != null && com.baidu.navisdk.framework.a.c().a() != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            if (this.t == 1) {
                View inflate = JarUtils.inflate(com.baidu.navisdk.framework.a.c().a(), R.layout.nsdk_layout_bnav_checkbox_notification_first, null);
                this.k = inflate;
                this.w = inflate.findViewById(R.id.first_panel);
                if (com.baidu.navisdk.module.newguide.a.e().d() && j0()) {
                    layoutParams.bottomMargin = t0();
                }
                this.y = (Button) this.k.findViewById(R.id.notification_yes);
                this.z = (Button) this.k.findViewById(R.id.notification_no);
                ImageView imageView = (ImageView) this.k.findViewById(R.id.iv_notification_close);
                this.A = imageView;
                imageView.setOnClickListener(new a());
            } else {
                View inflate2 = JarUtils.inflate(com.baidu.navisdk.framework.a.c().a(), R.layout.nsdk_layout_bnav_checkbox_notification, null);
                this.k = inflate2;
                this.w = inflate2.findViewById(R.id.bnav_rg_notification_layout);
                this.C = (LinearLayout) this.k.findViewById(R.id.ll_radio_group);
                RGMMCountDownCloseView rGMMCountDownCloseView = (RGMMCountDownCloseView) this.k.findViewById(R.id.count_down_close_view);
                this.B = rGMMCountDownCloseView;
                rGMMCountDownCloseView.setClickListener(new b());
                if (com.baidu.navisdk.module.newguide.a.e().d() && j0()) {
                    layoutParams.bottomMargin = u0();
                }
            }
            this.k.setOnClickListener(new c(this));
            this.i.addView(this.k, layoutParams);
            this.x = (TextView) this.k.findViewById(R.id.tv_title);
            x0();
            v(com.baidu.navisdk.ui.routeguide.control.x.b().d0());
            this.q = new d();
        }
    }

    private void x(int i2) {
        View view = this.w;
        if (view != null && i2 != 0) {
            com.baidu.navisdk.ui.util.b.a(view, i2);
        }
    }

    private void x0() {
        f(this.E.f());
        w(this.E.e());
        x(this.E.g());
        c(this.E.a());
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.ui.routeguide.control.s.T().d(this.E);
        com.baidu.navisdk.ui.routeguide.model.e eVar = this.E;
        if (eVar != null) {
            eVar.m();
            this.E = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        x0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void e0() {
        CountDownTimer d2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("cancelAutoHide() + mModel = ");
            sb.append(this.E);
            sb.append(" countDown = ");
            if (this.E.d() == null) {
                d2 = null;
            } else {
                d2 = this.E.d();
            }
            sb.append(d2);
            gVar.e("RGMMCheckboxNotificationView", sb.toString());
        }
        this.o = 0;
        com.baidu.navisdk.ui.routeguide.model.e eVar = this.E;
        if (eVar != null && eVar.d() != null) {
            this.E.d().cancel();
            this.E.d(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0
    public void o0() {
        super.o0();
    }

    public void q0() {
        com.baidu.navisdk.ui.routeguide.model.e eVar = this.E;
        if (eVar != null && eVar.i() != null) {
            this.E.i().a();
        }
    }

    public int r0() {
        return 1;
    }

    public void s0() {
        super.c();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (!com.baidu.navisdk.ui.routeguide.control.s.T().a(this.t, this.E.k())) {
            this.i.removeView(this.k);
            com.baidu.navisdk.ui.routeguide.control.s.T().c(this);
            return false;
        }
        com.baidu.navisdk.asr.d.B().a(r0());
        com.baidu.navisdk.ui.routeguide.control.x.b().a(false);
        com.baidu.navisdk.ui.routeguide.control.s.T().o();
        com.baidu.navisdk.ui.routeguide.control.s.T().p();
        com.baidu.navisdk.ui.routeguide.control.s.T().f(this.t);
        if (!com.baidu.navisdk.ui.routeguide.control.s.T().c(this.E)) {
            com.baidu.navisdk.ui.routeguide.control.s.T().a(this.E);
            if (com.baidu.navisdk.ui.routeguide.control.s.T().a(this.t, this.E.k())) {
                super.y();
            } else {
                LogUtil.e("RGMMCheckboxNotificationView", "not allow show");
                o0();
            }
        }
        com.baidu.navisdk.ui.routeguide.model.e eVar = this.E;
        if (eVar != null && this.o > 0) {
            eVar.d().start();
            return true;
        }
        return true;
    }

    private void a(i iVar, int i2) {
        View inflate = JarUtils.inflate(this.f9165a, R.layout.nsdk_include_checkbox_notification, null);
        inflate.setTag(Integer.valueOf(i2));
        ((TextView) inflate.findViewById(R.id.tv_button_name)).setText(iVar.c);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_button_icon);
        if (!com.baidu.navisdk.util.common.l0.c(iVar.b())) {
            com.baidu.navisdk.util.navimageloader.c.d().a(iVar.b(), imageView, this.F);
        } else if (iVar.a() != null) {
            imageView.setImageDrawable(iVar.f8817a);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        int i3 = this.t;
        if (i3 == 108 || i3 == 2) {
            inflate.setOnClickListener(new e(iVar));
        } else if (i3 == 109) {
            inflate.setOnClickListener(new f());
        }
        this.C.addView(inflate, layoutParams);
    }

    private void c(List<i> list) {
        if (this.t == 1) {
            b(list);
            return;
        }
        if (this.C == null || list == null || list.isEmpty()) {
            return;
        }
        if (list.size() > 4) {
            new Throwable("buttonList length must be less than 4!");
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2() && list.size() == 3) {
            int i2 = (int) (Resources.getSystem().getDisplayMetrics().density * 15.0f);
            this.C.setPadding(i2, 0, i2, 0);
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(list.get(i3), i3);
        }
    }

    public void a(long j2) {
        RGMMCountDownCloseView rGMMCountDownCloseView = this.B;
        if (rGMMCountDownCloseView != null) {
            rGMMCountDownCloseView.updateCountDownTime(((int) j2) / 1000);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i2, int i3, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMCheckboxNotificationView", "getEnterNormal: " + i2 + ",params:" + fVar + "," + a());
        }
        if (z) {
            if (this.k == null || !a()) {
                return null;
            }
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.k, this.t == 1 ? com.baidu.navisdk.ui.routeguide.utils.b.c() : 0);
        }
        super.c(i2, i3, z, fVar);
        return null;
    }

    public l a(g0.e eVar) {
        this.r = eVar;
        return this;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0, com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i2, int i3, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMCheckboxNotificationView", "getEnterDoubleMap: " + i2 + ",params:" + fVar + "," + a());
        }
        if (z) {
            if (this.k == null || !a()) {
                return null;
            }
            return com.baidu.navisdk.pronavi.hd.d.f7723a.c(this.k, i3);
        }
        super.a(i2, i3, z, fVar);
        return null;
    }
}
