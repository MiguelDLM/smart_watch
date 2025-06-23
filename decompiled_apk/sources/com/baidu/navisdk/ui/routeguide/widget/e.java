package com.baidu.navisdk.ui.routeguide.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.animation.Animator;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.navisdk.util.common.p0;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private String f9169a;
    private long b;
    private int c;
    private int d;
    private boolean e;
    private final X0IIOO f;
    private final X0IIOO g;
    private final X0IIOO h;
    private final X0IIOO i;
    private LottieAnimationView j;
    private final String k;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements oIX0oI<a> {

        /* loaded from: classes8.dex */
        public static final class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@oOoXoXO Animator animator) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNLottieAnimatorIntervalHolder", e.this.k + " onAnimationCancel");
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@oOoXoXO Animator animator) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNLottieAnimatorIntervalHolder", e.this.k + " onAnimationEnd");
                }
                e.this.j();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@oOoXoXO Animator animator) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNLottieAnimatorIntervalHolder", e.this.k + " onAnimationRepeat");
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@oOoXoXO Animator animator) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNLottieAnimatorIntervalHolder", e.this.k + " onAnimationStart");
                }
                e.this.e = true;
                e.this.c();
            }
        }

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final a invoke() {
            return new a();
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements oIX0oI<p0> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final p0 invoke() {
            return new p0("LottieAnimatorIntervalHolder" + e.this.k);
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements oIX0oI<p0.b> {

        /* loaded from: classes8.dex */
        public static final class a implements p0.b {
            public a() {
            }

            @Override // com.baidu.navisdk.util.common.p0.b
            public final void onTick(int i) {
                LottieAnimationView lottieAnimationView;
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNLottieAnimatorIntervalHolder", "TimerCallBack:" + i + TokenParser.SP);
                }
                if (e.this.f9169a != null && (lottieAnimationView = e.this.j) != null) {
                    lottieAnimationView.playAnimation();
                }
            }
        }

        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final p0.b invoke() {
            return new a();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.widget.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0487e extends Lambda implements oIX0oI<a> {

        /* renamed from: com.baidu.navisdk.ui.routeguide.widget.e$e$a */
        /* loaded from: classes8.dex */
        public static final class a implements View.OnAttachStateChangeListener {
            public a() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@OOXIXo View view) {
                IIX0o.x0xO0oo(view, "view");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@OOXIXo View view) {
                IIX0o.x0xO0oo(view, "view");
                e.this.h();
            }
        }

        public C0487e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final a invoke() {
            return new a();
        }
    }

    static {
        new a(null);
    }

    public e(@oOoXoXO LottieAnimationView lottieAnimationView, @OOXIXo String tag) {
        IIX0o.x0xO0oo(tag, "tag");
        this.j = lottieAnimationView;
        this.k = tag;
        this.c = -1;
        this.d = 1;
        this.e = true;
        this.f = XIxXXX0x0.oIX0oI(new C0487e());
        b();
        this.g = XIxXXX0x0.oIX0oI(new d());
        this.h = XIxXXX0x0.oIX0oI(new c());
        this.i = XIxXXX0x0.oIX0oI(new b());
    }

    private final Animator.AnimatorListener d() {
        return (Animator.AnimatorListener) this.i.getValue();
    }

    private final p0 e() {
        return (p0) this.h.getValue();
    }

    private final p0.b f() {
        return (p0.b) this.g.getValue();
    }

    private final View.OnAttachStateChangeListener g() {
        return (View.OnAttachStateChangeListener) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNLottieAnimatorIntervalHolder", "onDestroy: ");
        }
        a();
        e().b();
        LottieAnimationView lottieAnimationView = this.j;
        if (lottieAnimationView != null) {
            lottieAnimationView.removeOnAttachStateChangeListener(g());
        }
    }

    private final void i() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNLottieAnimatorIntervalHolder", "removeLottieAnimator: " + this.j);
        }
        this.f9169a = null;
        LottieAnimationView lottieAnimationView = this.j;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.clearAnimation();
            lottieAnimationView.setImageResource(0);
            lottieAnimationView.removeAllAnimatorListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNLottieAnimatorIntervalHolder", "startCountDown: " + this.e);
        }
        c();
        if (this.e) {
            p0 e = e();
            e.a(f());
            e.a(this.b);
            e.a(1);
        }
    }

    private final void b() {
        LottieAnimationView lottieAnimationView = this.j;
        if (lottieAnimationView != null) {
            lottieAnimationView.addOnAttachStateChangeListener(g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNLottieAnimatorIntervalHolder", "cancelCountDown: ");
        }
        e().a();
    }

    private final void b(String str, long j, int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNLottieAnimatorIntervalHolder", "showLottieAnimatorInner: " + str + ", " + j + ", " + i + ", " + i2);
        }
        this.e = true;
        c();
        LottieAnimationView lottieAnimationView = this.j;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(str);
            lottieAnimationView.setRepeatCount(i);
            lottieAnimationView.setRepeatMode(i2);
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.playAnimation();
            if (j <= 0 || i == -1) {
                return;
            }
            lottieAnimationView.addAnimatorListener(d());
        }
    }

    public final void a(@oOoXoXO String str, long j, int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNLottieAnimatorIntervalHolder", "showLottieAnimator1: " + str + ", " + j);
        }
        if (str != null && str.length() != 0) {
            this.f9169a = str;
            this.b = j;
            this.c = i;
            this.d = i2;
            b(str, j, i, i2);
            return;
        }
        a();
    }

    public final void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNLottieAnimatorIntervalHolder", "hideLottieAnimator: ");
        }
        this.e = false;
        c();
        i();
    }

    public final void a(@oOoXoXO LottieAnimationView lottieAnimationView, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNLottieAnimatorIntervalHolder", "onLottieViewChange: ");
        }
        if (IIX0o.Oxx0IOOO(lottieAnimationView, this.j)) {
            return;
        }
        i();
        LottieAnimationView lottieAnimationView2 = this.j;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.removeOnAttachStateChangeListener(g());
        }
        this.j = lottieAnimationView;
        b();
        String str = this.f9169a;
        if (str != null) {
            int i = z ? this.c : 0;
            IIX0o.ooOOo0oXI(str);
            b(str, this.b, i, this.d);
        }
    }
}
