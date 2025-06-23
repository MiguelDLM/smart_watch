package com.baidu.navisdk.yellowbannerui.view;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routeresult.interfaces.a;
import com.baidu.navisdk.yellowtipdata.model.data.g;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public class b extends com.baidu.navisdk.yellowbannerui.view.a {
    private View A;
    private Drawable B;
    private ImageView C;
    private g D;
    private int E;
    private boolean F;
    private boolean G;
    private View t;
    private TextView u;
    private TextView v;
    private View w;
    private TextView x;
    private TextView y;
    private Button z;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.yellowbannerui.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class ViewOnClickListenerC0518b implements View.OnClickListener {
        public ViewOnClickListenerC0518b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.b bVar = ((com.baidu.navisdk.module.routeresult.ui.a) b.this).n;
            b bVar2 = b.this;
            bVar.a(bVar2, 1, bVar2.p);
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.b bVar = ((com.baidu.navisdk.module.routeresult.ui.a) b.this).n;
            b bVar2 = b.this;
            bVar.a(bVar2, 2, bVar2.p);
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.b bVar = ((com.baidu.navisdk.module.routeresult.ui.a) b.this).n;
            b bVar2 = b.this;
            bVar.a(bVar2, 2, bVar2.p);
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.b bVar = ((com.baidu.navisdk.module.routeresult.ui.a) b.this).n;
            b bVar2 = b.this;
            bVar.a(bVar2, 6, bVar2.p);
        }
    }

    /* loaded from: classes8.dex */
    public static final class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
            if (((com.baidu.navisdk.module.routeresult.ui.a) b.this).d != null) {
                b.this.c(false);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@OOXIXo Animation animation) {
            IIX0o.x0xO0oo(animation, "animation");
        }
    }

    static {
        new a(null);
    }

    public b(@oOoXoXO Context context, @oOoXoXO com.baidu.navisdk.yellowbannerui.view.params.a aVar) {
        super(context, aVar);
        this.G = true;
    }

    private final void i(int i) {
        if (this.z != null && this.B != null) {
            String r = r();
            if (TextUtils.isEmpty(r) || this.q.f9442a == com.baidu.navisdk.yellowbannerui.config.b.UnClickable) {
                return;
            }
            View view = this.A;
            if (view != null) {
                view.setVisibility(0);
            }
            Button button = this.z;
            IIX0o.ooOOo0oXI(button);
            button.setVisibility(0);
            Button button2 = this.z;
            IIX0o.ooOOo0oXI(button2);
            button2.setText(r);
            Button button3 = this.z;
            IIX0o.ooOOo0oXI(button3);
            button3.setTextColor(Color.parseColor("#FFFFFF"));
            Drawable drawable = this.B;
            IIX0o.ooOOo0oXI(drawable);
            drawable.setColorFilter(e(i), PorterDuff.Mode.SRC_IN);
            Button button4 = this.z;
            IIX0o.ooOOo0oXI(button4);
            button4.setBackgroundDrawable(this.B);
        }
    }

    private final void j(int i) {
        if (this.t == null) {
            return;
        }
        g gVar = this.D;
        IIX0o.ooOOo0oXI(gVar);
        String o = gVar.o();
        TextView textView = this.u;
        IIX0o.ooOOo0oXI(textView);
        TextPaint textPaint = textView.getPaint();
        IIX0o.oO(textPaint, "textPaint");
        textPaint.setFakeBoldText(true);
        TextView textView2 = this.u;
        IIX0o.ooOOo0oXI(textView2);
        textView2.setTextColor(Color.parseColor("#FFFFFF"));
        if (o != null) {
            TextView textView3 = this.u;
            IIX0o.ooOOo0oXI(textView3);
            textView3.setText(Html.fromHtml(o));
        }
        g gVar2 = this.D;
        IIX0o.ooOOo0oXI(gVar2);
        String m = gVar2.m();
        if (TextUtils.isEmpty(m)) {
            TextView textView4 = this.u;
            IIX0o.ooOOo0oXI(textView4);
            textView4.setSingleLine(false);
            TextView textView5 = this.u;
            IIX0o.ooOOo0oXI(textView5);
            textView5.setMaxLines(2);
            this.G = true;
            return;
        }
        TextView textView6 = this.v;
        IIX0o.ooOOo0oXI(textView6);
        textView6.setVisibility(0);
        TextView textView7 = this.v;
        IIX0o.ooOOo0oXI(textView7);
        textView7.setText(Html.fromHtml(m));
        TextView textView8 = this.u;
        IIX0o.ooOOo0oXI(textView8);
        textView8.setSingleLine(true);
        TextView textView9 = this.u;
        IIX0o.ooOOo0oXI(textView9);
        textView9.setMaxLines(1);
        this.G = false;
    }

    private final void k(int i) {
        String n;
        g gVar = this.D;
        if (gVar != null && (n = gVar.n()) != null) {
            if (n.length() > 3) {
                StringBuilder sb = new StringBuilder(n);
                sb.insert(2, "\n");
                TextView textView = this.x;
                IIX0o.ooOOo0oXI(textView);
                textView.setText(sb.toString());
                TextView textView2 = this.x;
                IIX0o.ooOOo0oXI(textView2);
                textView2.setCompoundDrawables(null, null, null, null);
                TextView textView3 = this.x;
                IIX0o.ooOOo0oXI(textView3);
                textView3.setSingleLine(false);
                TextView textView4 = this.x;
                IIX0o.ooOOo0oXI(textView4);
                textView4.setMaxLines(2);
            } else if (n.length() > 0) {
                TextView textView5 = this.x;
                IIX0o.ooOOo0oXI(textView5);
                textView5.setText(n);
            }
        }
        TextView textView6 = this.x;
        IIX0o.ooOOo0oXI(textView6);
        textView6.setBackgroundResource(f(i));
        v();
    }

    private final String r() {
        com.baidu.navisdk.yellowtipdata.model.data.a c2;
        g c3 = this.p.c();
        if (c3 != null && (c2 = c3.c()) != null) {
            return c2.b();
        }
        return null;
    }

    private final void s() {
        this.D = this.p.c();
        T mParams = this.b;
        IIX0o.oO(mParams, "mParams");
        this.E = ((com.baidu.navisdk.yellowbannerui.view.params.a) mParams).i();
        this.F = ((com.baidu.navisdk.yellowbannerui.view.params.a) this.b).m();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NewStyleView initData ", String.valueOf(this.D));
        }
    }

    private final void t() {
        com.baidu.navisdk.yellowtipdata.model.data.d dVar = this.p;
        if (dVar != null && dVar.c() != null) {
            this.w = c(R.id.yellow_tips_head);
            this.x = (TextView) c(R.id.yellow_tips_notice);
            this.y = (TextView) c(R.id.yellow_tips_notice_label);
            this.t = c(R.id.yellow_banner_content);
            this.u = (TextView) c(R.id.yellow_tips_title);
            this.v = (TextView) c(R.id.yellow_tips_sub_title);
            this.z = (Button) c(R.id.yellow_tips_btn);
            this.A = c(R.id.yellow_tips_close_divider);
            this.C = (ImageView) c(R.id.yellow_tips_close_iv);
            Context mContext = this.f7502a;
            IIX0o.oO(mContext, "mContext");
            this.B = mContext.getResources().getDrawable(R.drawable.nsdk_route_result_yellow_bar_btn_bg);
            ImageView imageView = this.C;
            IIX0o.ooOOo0oXI(imageView);
            imageView.setVisibility(0);
            ImageView imageView2 = this.C;
            IIX0o.ooOOo0oXI(imageView2);
            imageView2.setOnClickListener(new ViewOnClickListenerC0518b());
            View view = this.w;
            IIX0o.ooOOo0oXI(view);
            view.setOnClickListener(new c());
            View view2 = this.t;
            IIX0o.ooOOo0oXI(view2);
            view2.setOnClickListener(new d());
            Button button = this.z;
            IIX0o.ooOOo0oXI(button);
            button.setOnClickListener(new e());
        }
    }

    private final void u() {
        if (this.f != null && this.t != null && this.z != null && this.C != null) {
            g gVar = this.D;
            IIX0o.ooOOo0oXI(gVar);
            h(gVar.b());
            g gVar2 = this.D;
            IIX0o.ooOOo0oXI(gVar2);
            k(gVar2.b());
            g gVar3 = this.D;
            IIX0o.ooOOo0oXI(gVar3);
            j(gVar3.b());
            g gVar4 = this.D;
            IIX0o.ooOOo0oXI(gVar4);
            i(gVar4.b());
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.h.1", String.valueOf(this.p.a()) + "", null, "0");
        }
    }

    private final void v() {
        if (this.F && this.E > 1) {
            TextView textView = this.y;
            IIX0o.ooOOo0oXI(textView);
            textView.setText(String.valueOf(this.E));
            TextView textView2 = this.y;
            IIX0o.ooOOo0oXI(textView2);
            textView2.setVisibility(0);
            return;
        }
        TextView textView3 = this.y;
        IIX0o.ooOOo0oXI(textView3);
        textView3.setVisibility(8);
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void m() {
        ImageView imageView = this.C;
        if (imageView != null) {
            IIX0o.ooOOo0oXI(imageView);
            imageView.setOnClickListener(null);
        }
        View view = this.t;
        if (view != null) {
            IIX0o.ooOOo0oXI(view);
            view.setOnClickListener(null);
        }
        super.m();
    }

    @Override // com.baidu.navisdk.yellowbannerui.view.a, com.baidu.navisdk.module.routeresult.ui.a
    public void n() {
        super.n();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new f());
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.startAnimation(alphaAnimation);
        }
    }

    @Override // com.baidu.navisdk.yellowbannerui.view.a
    public int q() {
        int i;
        if (!this.G) {
            i = 65;
        } else {
            i = 60;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
        if (gVar.d()) {
            gVar.e("RouteCarYBannerButtonView", "getYBannerViewHeight --> heightDp = " + i);
        }
        return i;
    }

    @Override // com.baidu.navisdk.module.routeresult.ui.a
    public void a(@oOoXoXO Bundle bundle) {
        super.a(bundle);
        d(R.layout.nsdk_layout_route_banner_yellow_new_style_tips);
        s();
        t();
        u();
    }

    @Override // com.baidu.navisdk.yellowbannerui.view.a
    public void a(@oOoXoXO com.baidu.navisdk.yellowbannerui.view.params.a aVar) {
        super.a(aVar);
        this.E = aVar != null ? aVar.i() : 0;
        this.F = aVar != null ? aVar.m() : false;
        v();
    }

    @Override // com.baidu.navisdk.yellowbannerui.view.a
    public void a(int i, boolean z) {
        this.r = z;
        View view = this.f;
        if (view == null) {
            return;
        }
        view.setBackgroundResource(g(i));
    }
}
