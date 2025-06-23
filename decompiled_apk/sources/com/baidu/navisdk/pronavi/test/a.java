package com.baidu.navisdk.pronavi.test;

import OXOo.OOXIXo;
import android.animation.ValueAnimator;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7831a;
    private ValueAnimator b;

    @OOXIXo
    public static final C0335a d = new C0335a(null);

    @OOXIXo
    private static final a c = b.b.a();

    /* renamed from: com.baidu.navisdk.pronavi.test.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0335a {
        private C0335a() {
        }

        @OOXIXo
        public final a a() {
            return a.c;
        }

        public /* synthetic */ C0335a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        @OOXIXo
        public static final b b = new b();

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private static final a f7832a = new a(null);

        private b() {
        }

        @OOXIXo
        public final a a() {
            return f7832a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator value) {
            IIX0o.oO(value, "value");
            Object animatedValue = value.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                if (intValue == 160) {
                    a.this.c();
                    return;
                } else {
                    com.baidu.navisdk.vi.b.a(4384, intValue, intValue * 2);
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        if (g.PRO_NAV.d()) {
            com.baidu.navisdk.framework.a c2 = com.baidu.navisdk.framework.a.c();
            IIX0o.oO(c2, "BNContextManager.getInstance()");
            TipTool.onCreateToastDialog(c2.a(), "区间测速---关 ");
        }
        this.f7831a = false;
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        com.baidu.navisdk.vi.b.a(4385, 0, 0);
    }

    private final void d() {
        if (g.PRO_NAV.d()) {
            com.baidu.navisdk.framework.a c2 = com.baidu.navisdk.framework.a.c();
            IIX0o.oO(c2, "BNContextManager.getInstance()");
            TipTool.onCreateToastDialog(c2.a(), "区间测速---开 ");
        }
        com.baidu.navisdk.vi.b.a(4383, 80, 3000);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 160);
        this.b = ofInt;
        if (ofInt != null) {
            ofInt.setDuration(120000L);
            ofInt.addUpdateListener(new c());
            ofInt.start();
        }
    }

    public /* synthetic */ a(IIXOooo iIXOooo) {
        this();
    }

    public final void a() {
        boolean z = this.f7831a;
        this.f7831a = !z;
        if (z) {
            c();
        } else {
            d();
        }
    }
}
