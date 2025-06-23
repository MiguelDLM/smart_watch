package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.speed.interval.RGMMIntervalSpeedBgView;
import com.garmin.fit.IXXIXx00I;

/* loaded from: classes8.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private ObjectAnimator f8918a;
    private ValueAnimator b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private Context i;
    private i j;
    private AnimatorSet k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private volatile boolean q;
    private volatile boolean r;
    private int s = 0;
    private int t = 0;

    /* loaded from: classes8.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f8919a;
        final /* synthetic */ int b;

        public a(h hVar, int i) {
            this.f8919a = hVar;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMIntervalCameraAnimHelper", "startBtnAnim->onAnimationCancel,animType=" + this.f8919a);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Object valueOf;
            super.onAnimationEnd(animator);
            if (z.this.j != null) {
                z.this.j.a(this.b, this.f8919a);
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("startBtnAnim->onAnimationEnd,animType=");
                sb.append(this.f8919a);
                sb.append(", mRootView:");
                if (z.this.f == null) {
                    valueOf = "null";
                } else {
                    valueOf = Boolean.valueOf(z.this.f.isShown());
                }
                sb.append(valueOf);
                gVar.e("RGMMIntervalCameraAnimHelper", sb.toString());
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMIntervalCameraAnimHelper", "startBtnAnim->onAnimationStart,animType=" + this.f8919a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8920a;

        public b(int i) {
            this.f8920a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (z.this.g != null && (z.this.g instanceof RGMMIntervalSpeedBgView)) {
                ((RGMMIntervalSpeedBgView) z.this.g).a(intValue, this.f8920a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c(z zVar) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((Float) valueAnimator.getAnimatedValue("alpha")).floatValue();
        }
    }

    /* loaded from: classes8.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f8921a;

        public d(h hVar) {
            this.f8921a = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMIntervalCameraAnimHelper", "getLimitSpeedViewAlphaAnim end");
            }
            if (z.this.d != null) {
                if (this.f8921a == h.ENTER) {
                    z.this.d.setVisibility(0);
                    z.this.d.setAlpha(1.0f);
                } else {
                    z.this.d.setVisibility(0);
                    z.this.d.setAlpha(0.0f);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMIntervalCameraAnimHelper", "getLimitSpeedViewAlphaAnim start");
            }
            if (z.this.d != null) {
                if (this.f8921a == h.ENTER) {
                    z.this.d.setVisibility(0);
                    z.this.d.setAlpha(0.0f);
                } else {
                    z.this.d.setVisibility(0);
                    z.this.d.setAlpha(1.0f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f8922a;

        public e(h hVar) {
            this.f8922a = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (z.this.c != null) {
                if (this.f8922a == h.ENTER) {
                    z.this.c.setVisibility(0);
                    z.this.c.setAlpha(1.0f);
                } else {
                    z.this.c.setVisibility(0);
                    z.this.c.setAlpha(0.0f);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (z.this.c != null) {
                if (this.f8922a == h.ENTER) {
                    z.this.c.setVisibility(0);
                    z.this.c.setAlpha(0.0f);
                } else {
                    z.this.c.setVisibility(0);
                    z.this.c.setAlpha(1.0f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f8923a;

        public f(h hVar) {
            this.f8923a = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("getTranslationAnim", "getTranslationAnim,end:" + this.f8923a);
            }
            if (this.f8923a == h.ENTER && z.this.h != null) {
                z.this.h.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("getTranslationAnim", "getTranslationAnim,start:" + this.f8923a);
            }
            if (this.f8923a == h.ENTER) {
                z.this.q = false;
                z.this.f8918a = null;
                if (z.this.h != null) {
                    z.this.h.setVisibility(4);
                }
                if (z.this.d != null) {
                    z.this.d.setVisibility(0);
                    z.this.d.setAlpha(0.0f);
                    return;
                }
                return;
            }
            z.this.b = null;
            z.this.r = false;
            if (z.this.h != null) {
                z.this.h.setVisibility(4);
            }
            if (z.this.c != null) {
                z.this.c.setVisibility(0);
                z.this.c.setAlpha(1.0f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8924a;
        final /* synthetic */ h b;

        public g(int i, h hVar) {
            this.f8924a = i;
            this.b = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int dimensionPixelOffset;
            String str;
            if (this.f8924a == 1) {
                dimensionPixelOffset = z.this.i.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_61dp);
                str = "TranslationY";
            } else {
                dimensionPixelOffset = z.this.i.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_61dp);
                str = "TranslationX";
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue(str)).floatValue();
            if (this.b == h.ENTER) {
                if (Math.abs(floatValue) < dimensionPixelOffset && !z.this.q) {
                    z.this.q = true;
                    z zVar = z.this;
                    zVar.b = zVar.e(this.f8924a, this.b);
                    z.this.b.start();
                    return;
                }
                return;
            }
            if (Math.abs(floatValue) > dimensionPixelOffset && !z.this.r) {
                z.this.r = true;
                z zVar2 = z.this;
                zVar2.f8918a = zVar2.b(this.f8924a, this.b);
                z.this.f8918a.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public enum h {
        ENTER,
        EXIT
    }

    /* loaded from: classes8.dex */
    public interface i {
        void a(int i, h hVar);
    }

    private void c() {
        if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
            return;
        }
        this.p = 750;
        this.n = 0;
        this.o = IXXIXx00I.f11766x0;
        this.l = 0;
        this.m = 250;
    }

    private void d() {
        if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
            return;
        }
        this.p = 750;
        this.l = 0;
        this.m = IXXIXx00I.f11766x0;
        this.n = 0;
        this.o = 250;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator e(int i2, h hVar) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        if (hVar == h.ENTER) {
            f2 = 0.0f;
            f3 = 1.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d, "alpha", f2, f3);
        ofFloat.setDuration(this.m);
        ofFloat.setStartDelay(this.l);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new c(this));
        ofFloat.addListener(new d(hVar));
        return ofFloat;
    }

    private ObjectAnimator f(int i2, h hVar) {
        int e2;
        String str;
        if (i2 == 1) {
            e2 = com.baidu.navisdk.ui.util.b.e(R.dimen.navi_dimens_123dp);
            str = "TranslationY";
        } else {
            e2 = com.baidu.navisdk.ui.util.b.e(R.dimen.navi_dimens_126dp);
            str = "TranslationX";
        }
        float f2 = 0.0f;
        float f3 = -e2;
        if (hVar == h.ENTER) {
            f2 = f3;
            f3 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e, str, f2, f3);
        ofFloat.setDuration(this.p);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new f(hVar));
        ofFloat.addUpdateListener(new g(i2, hVar));
        return ofFloat;
    }

    public void b(int i2) {
        a(i2, h.ENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator b(int i2, h hVar) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        if (hVar == h.ENTER) {
            f2 = 0.0f;
            f3 = 1.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "alpha", f2, f3);
        ofFloat.setDuration(this.o);
        ofFloat.setStartDelay(this.n);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new e(hVar));
        return ofFloat;
    }

    public void a(Context context, View... viewArr) {
        this.i = context;
        if (viewArr != null && viewArr.length == 6 && context != null) {
            this.g = viewArr[0];
            this.d = viewArr[1];
            this.c = viewArr[2];
            this.e = viewArr[3];
            this.f = viewArr[4];
            this.h = viewArr[5];
        } else if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            throw new IllegalArgumentException("参数错误");
        }
        this.k = null;
        if (this.s == 0) {
            this.s = this.i.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_199dp);
        }
        if (this.t == 0) {
            this.t = this.i.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_208dp);
        }
    }

    private ValueAnimator d(int i2, h hVar) {
        int i3;
        if (i2 == 1) {
            i3 = this.s;
        } else {
            int dimensionPixelOffset = this.i.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_12dp);
            int width = this.c.getWidth() + this.e.getWidth() + this.d.getWidth();
            int i4 = this.t;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMIntervalCameraAnimHelper", "land width = " + i4 + " viewWidth = " + (width + dimensionPixelOffset));
            }
            i3 = i4;
        }
        int dimensionPixelOffset2 = this.i.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_76dp);
        if (hVar == h.ENTER) {
            dimensionPixelOffset2 = i3;
            i3 = dimensionPixelOffset2;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, dimensionPixelOffset2);
        ofInt.setDuration(this.p);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new b(i2));
        return ofInt;
    }

    public void c(int i2) {
        a(i2, h.EXIT);
    }

    private ObjectAnimator c(int i2, h hVar) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        if (hVar == h.ENTER) {
            f2 = 0.0f;
            f3 = 1.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.g, "alpha", f2, f3);
        ofFloat.setDuration(this.p);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public void b() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMIntervalCameraAnimHelper", "stopBtnAnim ,animatorSet:");
        }
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.end();
        }
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            if (gVar.d()) {
                gVar.e("RGMMIntervalCameraAnimHelper", "stopBtnAnim ,limitSpeedAlphaAnim end");
            }
            this.b.end();
        }
        ObjectAnimator objectAnimator = this.f8918a;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            if (gVar.d()) {
                gVar.e("RGMMIntervalCameraAnimHelper", "stopBtnAnim ,aveViewAlphaAnim end");
            }
            this.f8918a.end();
        }
        View view = this.c;
        if (view != null) {
            view.clearAnimation();
        }
        View view2 = this.g;
        if (view2 != null) {
            view2.clearAnimation();
        }
        View view3 = this.d;
        if (view3 != null) {
            view3.clearAnimation();
        }
        View view4 = this.e;
        if (view4 != null) {
            view4.clearAnimation();
        }
    }

    public void a(i iVar) {
        this.j = iVar;
    }

    public void a(int i2, h hVar) {
        h hVar2 = h.ENTER;
        if (hVar == hVar2) {
            c();
        } else {
            d();
        }
        this.k = new AnimatorSet();
        ObjectAnimator f2 = f(i2, hVar);
        ObjectAnimator c2 = c(i2, hVar);
        ValueAnimator d2 = d(i2, hVar);
        this.k.addListener(new a(hVar, i2));
        if (hVar == hVar2) {
            this.k.play(c2).with(d2).with(f2).with(b(i2, hVar));
        } else {
            this.k.play(c2).with(d2).with(f2).with(e(i2, hVar));
        }
        this.k.start();
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMIntervalCameraAnimHelper", "stopBtnAnim ,release");
        }
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.k = null;
        }
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = this.f8918a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        View view = this.c;
        if (view != null) {
            view.clearAnimation();
        }
        View view2 = this.g;
        if (view2 != null) {
            view2.clearAnimation();
        }
        View view3 = this.d;
        if (view3 != null) {
            view3.clearAnimation();
        }
        View view4 = this.e;
        if (view4 != null) {
            view4.clearAnimation();
        }
        this.j = null;
    }

    public void a(int i2) {
        this.s = i2;
    }
}
