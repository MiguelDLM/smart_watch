package com.baidu.navisdk.pronavi.hd;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final d f7723a = new d();

    /* loaded from: classes7.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7724a;
        final /* synthetic */ boolean b;
        final /* synthetic */ ViewGroup.MarginLayoutParams c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ boolean f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        public a(View view, boolean z, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, boolean z2, int i3, int i4) {
            this.f7724a = view;
            this.b = z;
            this.c = marginLayoutParams;
            this.d = i;
            this.e = i2;
            this.f = z2;
            this.g = i3;
            this.h = i4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            if (this.f7724a != null) {
                IIX0o.oO(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    if (this.b) {
                        this.c.leftMargin = (int) (this.d + (this.e * floatValue));
                    }
                    if (this.f) {
                        this.c.rightMargin = (int) (this.g + (this.h * floatValue));
                    }
                    this.f7724a.requestLayout();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7725a;
        final /* synthetic */ ViewGroup.MarginLayoutParams b;

        public b(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f7725a = view;
            this.b = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            if (this.f7725a != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = this.b;
                IIX0o.oO(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    marginLayoutParams.bottomMargin = ((Integer) animatedValue).intValue();
                    this.f7725a.requestLayout();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    private d() {
    }

    @Nullable
    @oOoXoXO
    public final Animator a(@oOoXoXO View view, int i) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i2 = marginLayoutParams.bottomMargin;
            if (i2 == i) {
                return null;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(i2, i);
            ofInt.addUpdateListener(new b(view, marginLayoutParams));
            return ofInt;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @oOoXoXO
    public final ArrayList<Animator> b(@oOoXoXO View view, int i) {
        Animator a2 = a(view, i);
        if (a2 == null) {
            return null;
        }
        ArrayList<Animator> arrayList = new ArrayList<>(1);
        arrayList.add(a2);
        return arrayList;
    }

    @oOoXoXO
    public final ArrayList<Animator> c(@oOoXoXO View view, int i) {
        if (view == null) {
            return null;
        }
        if (view.getVisibility() != 0) {
            com.baidu.navisdk.pronavi.util.b.f7961a.a(view, i);
            return null;
        }
        return b(view, i);
    }

    @oOoXoXO
    public final Animator d(@oOoXoXO View view, int i) {
        if (view == null) {
            return null;
        }
        if (view.getVisibility() != 0) {
            com.baidu.navisdk.pronavi.util.b.f7961a.a(view, i);
            return null;
        }
        return a(view, i);
    }

    public final void e(@oOoXoXO View view, int i) {
        com.baidu.navisdk.pronavi.util.b.f7961a.a(view, i);
    }

    public final void e(@oOoXoXO View view, int i, int i2) {
        boolean z;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDAnimatorUtil", "setLandViewMarginLeftRight: " + i + ':' + i2 + "-->" + view);
        }
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            boolean z2 = true;
            if (marginLayoutParams.leftMargin != i) {
                marginLayoutParams.leftMargin = i;
                z = true;
            } else {
                z = false;
            }
            if (marginLayoutParams.rightMargin != i2) {
                marginLayoutParams.rightMargin = i2;
            } else {
                z2 = z;
            }
            if (z2) {
                view.requestLayout();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @oOoXoXO
    public final ArrayList<Animator> b(@oOoXoXO View view, int i, int i2) {
        Animator a2 = a(view, i, i2);
        if (a2 == null) {
            return null;
        }
        ArrayList<Animator> arrayList = new ArrayList<>(1);
        arrayList.add(a2);
        return arrayList;
    }

    @oOoXoXO
    public final ArrayList<Animator> c(@oOoXoXO View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        if (view.getVisibility() != 0) {
            e(view, i, i2);
            return null;
        }
        return b(view, i, i2);
    }

    @oOoXoXO
    public final Animator d(@oOoXoXO View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        if (view.getVisibility() != 0) {
            e(view, i, i2);
            return null;
        }
        return a(view, i, i2);
    }

    public final void a(@oOoXoXO View view, boolean z, int i, int i2) {
        if (view == null) {
            return;
        }
        com.baidu.navisdk.pronavi.util.b.f7961a.a(view, (z ? com.baidu.navisdk.ui.routeguide.utils.b.c() : 0) + i + i2);
    }

    @Nullable
    @oOoXoXO
    public final Animator a(@oOoXoXO View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i3 = marginLayoutParams.leftMargin;
            int i4 = marginLayoutParams.rightMargin;
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDAnimatorUtil", "getLandMarginLeftRightAnimator left: " + i3 + " ->" + i + " ;right:" + i4 + "->" + i);
            }
            boolean z = i3 != i;
            boolean z2 = i4 != i2;
            if (!z && !z2) {
                return null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new a(view, z, marginLayoutParams, i3, i - i3, z2, i4, i2 - i4));
            return ofFloat;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void a(@oOoXoXO View view, boolean z, int i, int i2, boolean z2) {
        if (i != 0 || z2) {
            if (z) {
                if (i == 2) {
                    com.baidu.navisdk.pronavi.util.b.f7961a.a(view, i2);
                    return;
                } else if (i != 3) {
                    com.baidu.navisdk.pronavi.util.b.f7961a.a(view, 0);
                    return;
                } else {
                    com.baidu.navisdk.pronavi.util.b.f7961a.a(view, 0);
                    return;
                }
            }
            if (i == 2) {
                e(view, com.baidu.navisdk.ui.routeguide.utils.b.q(), i2);
            } else if (i != 3) {
                e(view, com.baidu.navisdk.ui.routeguide.utils.b.j(), 0);
            } else {
                int k = com.baidu.navisdk.ui.routeguide.utils.b.k();
                e(view, com.baidu.navisdk.ui.routeguide.utils.b.q() + k, k);
            }
        }
    }
}
