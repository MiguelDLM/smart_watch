package com.baidu.navisdk.ui.routeguide.ar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNRoundProgress;
import com.baidu.navisdk.util.common.i;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.apache.commons.text.oIX0oI;

/* loaded from: classes8.dex */
public final class d implements View.OnClickListener, i.b {

    /* renamed from: a, reason: collision with root package name */
    private View f8456a;
    private TextView b;
    private Context c;
    private b e;
    private BNRoundProgress f;
    private View g;
    private View h;
    private View i;
    private View j;
    private ValueAnimator k;
    private long m;
    private float n;
    private float o;
    private float p;
    private int q;
    private AnimatorSet r;
    private int u;
    private int v;
    private int d = 2;
    private final int l = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_63dp);
    private final ArrayList<Animator> s = new ArrayList<>(2);
    private final Runnable t = new c();

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void a(int i);

        void b();

        void c();
    }

    /* loaded from: classes8.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = d.this.e;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.ar.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0417d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f8458a;
        final /* synthetic */ View b;

        public C0417d(ViewGroup.MarginLayoutParams marginLayoutParams, View view) {
            this.f8458a = marginLayoutParams;
            this.b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            ViewGroup.MarginLayoutParams marginLayoutParams = this.f8458a;
            IIX0o.oO(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue != null) {
                marginLayoutParams.topMargin = ((Integer) animatedValue).intValue();
                this.b.requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public static final e f8459a = new e();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object obj;
            BNRoundProgress bNRoundProgress = d.this.f;
            if (bNRoundProgress != null) {
                if (valueAnimator != null) {
                    obj = valueAnimator.getAnimatedValue();
                } else {
                    obj = null;
                }
                if (obj != null) {
                    bNRoundProgress.setProgress(((Integer) obj).intValue());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@oOoXoXO Animator animator) {
            View view = d.this.g;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = d.this.h;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            View view3 = d.this.h;
            if (view3 != null) {
                view3.post(d.this.t);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@oOoXoXO Animator animator) {
            BNRoundProgress bNRoundProgress = d.this.f;
            if (bNRoundProgress != null) {
                bNRoundProgress.setVisibility(0);
            }
        }
    }

    static {
        new a(null);
    }

    public d(int i, int i2) {
        this.u = i;
        this.v = i2;
    }

    private final void f() {
        i a2 = i.f.a();
        Context context = this.c;
        if (context == null) {
            IIX0o.XOxIOxOx("mContext");
        }
        a2.a(context, this);
    }

    private final void g() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArAngleAdjustView", "startCalibrateSuccessAnimator: ");
        }
        ValueAnimator valueAnimator = this.k;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            if (gVar.d()) {
                gVar.e("RGArAngleAdjustView", "startCalibrateSuccessAnimator: is running");
                return;
            }
            return;
        }
        View view = this.g;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        this.k = ofInt;
        if (ofInt != null) {
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.addUpdateListener(new f());
            ofInt.addListener(new g());
            ofInt.setDuration(3000L);
            ofInt.start();
        }
    }

    private final void h() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArAngleAdjustView", "stopCalibrateSuccessAnimator: ");
        }
        ValueAnimator valueAnimator = this.k;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.k;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.k = null;
        View view = this.h;
        if (view != null) {
            view.removeCallbacks(this.t);
        }
        BNRoundProgress bNRoundProgress = this.f;
        if (bNRoundProgress != null) {
            bNRoundProgress.setVisibility(8);
        }
        View view2 = this.g;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.h;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@oOoXoXO View view) {
        Integer num;
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        int i = R.id.bn_ar_angle_adjust_switch_orientation_btn;
        if (num != null && num.intValue() == i) {
            int e2 = e();
            b bVar = this.e;
            if (bVar != null) {
                bVar.a(e2);
            }
            if (e2 == 2) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.10.4.2", "1");
                return;
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.10.4.2", "0");
                return;
            }
        }
        int i2 = R.id.bn_ar_angle_adjust_exit_btn;
        if (num != null && num.intValue() == i2) {
            b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.b();
            }
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.10.4.1");
            return;
        }
        int i3 = R.id.bn_ar_temp_skip_adjust_btn;
        if (num != null && num.intValue() == i3) {
            b bVar3 = this.e;
            if (bVar3 != null) {
                bVar3.c();
            }
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.10.4.3");
        }
    }

    private final void c() {
        int OxxIIOOXO2;
        if (this.d == 2) {
            OxxIIOOXO2 = X0.IIXOooo.XI0IXoo(this.u, this.v) / 2;
        } else {
            OxxIIOOXO2 = X0.IIXOooo.OxxIIOOXO(this.u, this.v) / 2;
        }
        this.q = OxxIIOOXO2;
    }

    private final void d() {
        String string;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArAngleAdjustView", "changeSwitchOrientationBtnTxt: " + this.d);
        }
        if (this.d == 2) {
            string = JarUtils.getResources().getString(R.string.bnav_switch_portrait_navi);
            IIX0o.oO(string, "JarUtils.getResources().…rtrait_navi\n            )");
        } else {
            string = JarUtils.getResources().getString(R.string.bnav_switch_land_navi);
            IIX0o.oO(string, "JarUtils.getResources().…ng.bnav_switch_land_navi)");
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(string);
        }
    }

    private final int e() {
        return this.d == 2 ? 1 : 2;
    }

    @oOoXoXO
    public final View a(@oOoXoXO Context context, @oOoXoXO ViewGroup viewGroup, int i, @OOXIXo b pageListener) {
        IIX0o.x0xO0oo(pageListener, "pageListener");
        if (viewGroup != null && context != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGArAngleAdjustView", "onCreateView:");
            }
            this.d = i;
            this.e = pageListener;
            View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_ar_angle_adjustment, viewGroup, false);
            this.f8456a = inflate;
            if (inflate == null) {
                return null;
            }
            this.c = context;
            IIX0o.ooOOo0oXI(inflate);
            TextView textView = (TextView) inflate.findViewById(R.id.bn_ar_angle_adjust_switch_orientation_btn);
            this.b = textView;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            View findViewById = inflate.findViewById(R.id.bn_ar_angle_adjust_exit_btn);
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
            }
            View findViewById2 = inflate.findViewById(R.id.bn_ar_temp_skip_adjust_btn);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(this);
            }
            this.f = (BNRoundProgress) inflate.findViewById(R.id.bn_ar_calibrate_success_progress_bar);
            this.g = inflate.findViewById(R.id.bn_ar_calibrate_success_hook);
            this.h = inflate.findViewById(R.id.bn_ar_calibrate_success_text);
            this.i = inflate.findViewById(R.id.bn_ar_angle_adjust_hr_line);
            this.j = inflate.findViewById(R.id.bn_ar_angle_adjust_hr_line_p);
            inflate.setOnClickListener(e.f8459a);
            if (com.baidu.navisdk.module.abtest.model.a.v()) {
                TextView textView2 = this.b;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else {
                TextView textView3 = this.b;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
            }
            c();
            d();
            f();
            return this.f8456a;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.c()) {
            gVar2.e("RGArAngleAdjustView", "viewGroup == null || context == null");
        }
        return null;
    }

    public final void b() {
        this.e = null;
        View view = this.f8456a;
        if ((view != null ? view.getParent() : null) instanceof ViewGroup) {
            View view2 = this.f8456a;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(this.f8456a);
        }
        h();
        i.f.a().a(this);
    }

    private final float c(float f2, float f3, float f4) {
        return ((this.d == 2 ? (int) (f3 * 10) : (int) (f2 * 10)) / 98.0f) * 90;
    }

    private final int b(float f2, float f3, float f4) {
        int i = (int) (this.q * (1 + (((int) (f4 * 10)) / 98.0f)));
        int i2 = this.v;
        return i > i2 ? i2 : i;
    }

    private final boolean d(float f2, float f3, float f4) {
        return Math.abs(this.n - f2) > 0.1f || Math.abs(this.p - f3) > 0.1f || Math.abs(this.o - f4) > 0.1f;
    }

    public final void a(@oOoXoXO ViewGroup viewGroup, int i) {
        this.d = i;
        d();
        c();
    }

    public final boolean a() {
        View view = this.f8456a;
        if (view != null) {
            return view.isShown();
        }
        return false;
    }

    @Override // com.baidu.navisdk.util.common.i.b
    public void a(float f2, float f3, float f4) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
        if (gVar.d()) {
            gVar.e("BNSysSensorHelper", "onSensorChanged Pitch(x轴偏转角度):" + f2);
            gVar.e("BNSysSensorHelper", "onSensorChanged Roll(y轴偏转角度):" + f3);
            gVar.e("BNSysSensorHelper", "onSensorChanged Azimuth(z轴偏转角度):" + f4 + "\n\n");
        }
        long nanoTime = System.nanoTime();
        if (nanoTime - this.m < 200000000) {
            return;
        }
        this.m = nanoTime;
        View view = this.i;
        if (view == null || !d(f2, f3, f4)) {
            return;
        }
        int b2 = b(f2, f3, f4);
        float c2 = c(f2, f3, f4);
        a(view, b2, c2, f2, f3, f4);
        if (a(b2, c2)) {
            g();
        } else {
            h();
        }
    }

    private final void a(View view, int i, float f2, float f3, float f4, float f5) {
        this.s.clear();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (Math.abs(marginLayoutParams.topMargin - i) > 4 && i != Integer.MAX_VALUE) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGArAngleAdjustView", "marginTopRotationAnimatorIfNeed:" + this.n + oIX0oI.f33048oxoX + f3 + "; " + i);
                }
                ValueAnimator topAnimator = ValueAnimator.ofInt(marginLayoutParams.topMargin, i);
                IIX0o.oO(topAnimator, "topAnimator");
                topAnimator.setInterpolator(null);
                topAnimator.addUpdateListener(new C0417d(marginLayoutParams, view));
                topAnimator.setDuration(300L);
                this.s.add(topAnimator);
                this.o = f5;
            }
            float rotation = view.getRotation();
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGArAngleAdjustView", "setRotation222: " + rotation + oIX0oI.f33048oxoX + f2);
            }
            if (rotation != f2 && f2 != Float.MAX_VALUE) {
                ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(view, "rotation", rotation, f2);
                IIX0o.oO(rotationAnimator, "rotationAnimator");
                rotationAnimator.setDuration(300L);
                rotationAnimator.setInterpolator(null);
                this.s.add(rotationAnimator);
                this.n = f3;
            }
            if (this.s.isEmpty()) {
                return;
            }
            AnimatorSet animatorSet = this.r;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.r = animatorSet2;
            IIX0o.ooOOo0oXI(animatorSet2);
            animatorSet2.playTogether(this.s);
            animatorSet2.start();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final boolean a(int i, float f2) {
        return Math.abs(i - this.q) < this.l / 2 && Math.abs(f2) < ((float) 8);
    }

    public final void a(int i, int i2) {
        this.v = i2;
        this.u = i;
        c();
    }
}
