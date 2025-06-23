package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.navisdk.embed.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class BNLottieSpeedView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private LottieAnimationView f8705a;
    private View b;
    private View c;
    private TextView d;
    private TextView e;
    private boolean f;
    private boolean g;

    @ColorRes
    private int h;

    @ColorRes
    private int i;

    @DrawableRes
    private int j;

    @DrawableRes
    private int k;

    @DrawableRes
    private int l;

    @ColorRes
    private int m;

    @DrawableRes
    private int n;

    @DrawableRes
    private int o;

    @DrawableRes
    private int p;

    @ColorRes
    private int q;

    @DrawableRes
    private int r;

    @DrawableRes
    private int s;

    @DrawableRes
    private int t;
    private String u;
    private String v;

    /* loaded from: classes8.dex */
    public static final class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@oOoXoXO Animator animator) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNLottieSpeedView", "onAnimationCancel: ");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@oOoXoXO Animator animator) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNLottieSpeedView", "onAnimationEnd: ");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@oOoXoXO Animator animator) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNLottieSpeedView", "onAnimationRepeat: ");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@oOoXoXO Animator animator) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNLottieSpeedView", "onAnimationStart: ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8706a = new b();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new c(null);
    }

    @xoIox
    public BNLottieSpeedView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final void b() {
        String str = this.u;
        if (str != null && str.length() != 0) {
            e();
        }
        setBg(this.n);
        setInnerBehindBg(this.o);
        setInnerFrontBg(this.p);
        setCurSpeedColor(this.m);
        setSpeedUnitColor(this.m);
    }

    private final void c() {
        String str;
        if (!this.g && (str = this.u) != null && str.length() != 0) {
            d();
        }
        setBg(this.r);
        setInnerBehindBg(this.s);
        setInnerFrontBg(this.t);
        setCurSpeedColor(this.q);
        setSpeedUnitColor(this.q);
    }

    private final void d() {
        LottieAnimationView lottieAnimationView = this.f8705a;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            if (!lottieAnimationView.isAnimating()) {
                lottieAnimationView.setSafeMode(true);
                lottieAnimationView.setRepeatMode(1);
                lottieAnimationView.setRepeatCount(-1);
                if (this.f) {
                    com.baidu.navisdk.ui.util.b.a(this.f8705a);
                    if (!com.baidu.navisdk.ui.util.b.b()) {
                        lottieAnimationView.setAnimation(this.v);
                    } else {
                        lottieAnimationView.setAnimation(this.u);
                    }
                }
                lottieAnimationView.playAnimation();
            }
        }
    }

    private final void e() {
        LottieAnimationView lottieAnimationView = this.f8705a;
        if (lottieAnimationView != null) {
            if (lottieAnimationView.isAnimating()) {
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.clearAnimation();
                lottieAnimationView.setImageResource(0);
            }
            lottieAnimationView.setVisibility(8);
        }
    }

    private final void setBg(@DrawableRes int i) {
        if (this.j == i) {
            return;
        }
        this.j = i;
        if (this.f) {
            if (i == 0) {
                com.baidu.navisdk.ui.util.b.a(this);
                setBackgroundResource(i);
                return;
            } else {
                com.baidu.navisdk.ui.util.b.a(this, i);
                return;
            }
        }
        setBackgroundResource(i);
    }

    private final void setCurSpeedColor(@ColorRes int i) {
        if (this.h == i) {
            return;
        }
        this.h = i;
        TextView textView = this.d;
        if (textView != null) {
            if (this.f) {
                com.baidu.navisdk.ui.util.b.a(textView, i);
            } else {
                textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
            }
        }
    }

    private final void setInnerBehindBg(@DrawableRes int i) {
        if (this.k == i) {
            return;
        }
        this.k = i;
        View view = this.b;
        if (view != null) {
            if (this.f) {
                if (i == 0) {
                    com.baidu.navisdk.ui.util.b.a(view);
                    view.setBackgroundResource(i);
                    return;
                } else {
                    com.baidu.navisdk.ui.util.b.a(view, i);
                    return;
                }
            }
            view.setBackgroundResource(i);
        }
    }

    private final void setInnerFrontBg(@DrawableRes int i) {
        if (this.l == i) {
            return;
        }
        this.l = i;
        View view = this.c;
        if (view != null) {
            if (this.f) {
                if (i == 0) {
                    com.baidu.navisdk.ui.util.b.a(view);
                    view.setBackgroundResource(i);
                    return;
                } else {
                    com.baidu.navisdk.ui.util.b.a(view, i);
                    return;
                }
            }
            view.setBackgroundResource(i);
        }
    }

    private final void setSpeedUnitColor(@ColorRes int i) {
        if (this.i == i) {
            return;
        }
        this.i = i;
        TextView textView = this.e;
        if (textView != null) {
            if (this.f) {
                com.baidu.navisdk.ui.util.b.a(textView, i);
            } else {
                textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
            }
        }
    }

    public final boolean a() {
        return this.g;
    }

    public final void setLottieRes(boolean z) {
        if (z) {
            LottieAnimationView lottieAnimationView = this.f8705a;
            if (lottieAnimationView != null) {
                lottieAnimationView.setAnimation(this.u);
                return;
            }
            return;
        }
        LottieAnimationView lottieAnimationView2 = this.f8705a;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setAnimation(this.v);
        }
    }

    public final void setOverSpeed(boolean z) {
        this.g = z;
    }

    public /* synthetic */ BNLottieSpeedView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a(@OOXIXo String speed, boolean z, @oOoXoXO String str) {
        IIX0o.x0xO0oo(speed, "speed");
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(speed);
        }
        if (z) {
            c();
        } else {
            b();
        }
        this.g = z;
        TextView textView2 = this.e;
        if (textView2 != null) {
            if (str == null) {
                str = "km/h";
            }
            textView2.setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public BNLottieSpeedView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int dimensionPixelSize;
        TextView textView;
        int dimensionPixelSize2;
        TextView textView2;
        int dimensionPixelSize3;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        int dimensionPixelSize4;
        ViewGroup.LayoutParams layoutParams5;
        ViewGroup.LayoutParams layoutParams6;
        ViewGroup.LayoutParams layoutParams7;
        ViewGroup.LayoutParams layoutParams8;
        IIX0o.x0xO0oo(context, "context");
        this.f = true;
        this.m = R.color.bnav_smart_green_light_text_color;
        this.n = R.drawable.bnav_j_speed_bg;
        this.o = R.drawable.bnav_j_speed_normal_small_c;
        this.p = R.drawable.bnav_j_speed_normal_blue_c;
        this.q = R.color.bnav_speed_view_over_speed_text_color;
        this.u = "lottie/nsdk_j_over_speed.json";
        this.v = "lottie/nsdk_j_over_speed_night.json";
        com.baidu.navisdk.ui.util.b.a(context, R.layout.bnav_layout_lottie_speed_view, this, true);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.bnav_rg_speed_over_lottie_anim_view);
        this.f8705a = lottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.addAnimatorListener(new a());
        }
        this.b = findViewById(R.id.bnav_rg_speed_inner_circle_behind_layout);
        this.c = findViewById(R.id.bnav_rg_speed_inner_circle_front_layout);
        int dimensionPixelSize5 = getResources().getDimensionPixelSize(R.dimen.navi_dimens_64dp);
        View view = this.b;
        if (view != null && (layoutParams8 = view.getLayoutParams()) != null) {
            layoutParams8.width = dimensionPixelSize5;
        }
        View view2 = this.b;
        if (view2 != null && (layoutParams7 = view2.getLayoutParams()) != null) {
            layoutParams7.height = dimensionPixelSize5;
        }
        View view3 = this.c;
        if (view3 != null && (layoutParams6 = view3.getLayoutParams()) != null) {
            layoutParams6.width = dimensionPixelSize5;
        }
        View view4 = this.c;
        if (view4 != null && (layoutParams5 = view4.getLayoutParams()) != null) {
            layoutParams5.height = dimensionPixelSize5;
        }
        TextView textView3 = (TextView) findViewById(R.id.bnav_rg_cp_cur_car_speed);
        this.d = textView3;
        if (textView3 != null) {
            textView3.setTextSize(0, getResources().getDimension(R.dimen.navi_dimens_28dp));
        }
        TextView textView4 = (TextView) findViewById(R.id.bnav_rg_cp_cur_car_speed_unit);
        this.e = textView4;
        if (textView4 != null) {
            textView4.setTextSize(0, getResources().getDimension(R.dimen.navi_dimens_12dp));
        }
        setOnTouchListener(b.f8706a);
        String str = "km/h";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNLottieSpeedView);
            IIX0o.oO(obtainStyledAttributes, "context.obtainStyledAttr…leable.BNLottieSpeedView)");
            int i2 = R.styleable.BNLottieSpeedView_nsdk_speed_view_size;
            if (obtainStyledAttributes.hasValue(i2) && (dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(i2, Integer.MAX_VALUE)) != Integer.MAX_VALUE) {
                getLayoutParams().width = dimensionPixelSize4;
                getLayoutParams().height = dimensionPixelSize4;
            }
            int i3 = R.styleable.BNLottieSpeedView_nsdk_speed_inner_circle_size;
            if (obtainStyledAttributes.hasValue(i3) && (dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(i3, Integer.MAX_VALUE)) != Integer.MAX_VALUE) {
                View view5 = this.b;
                if (view5 != null && (layoutParams4 = view5.getLayoutParams()) != null) {
                    layoutParams4.width = dimensionPixelSize3;
                }
                View view6 = this.b;
                if (view6 != null && (layoutParams3 = view6.getLayoutParams()) != null) {
                    layoutParams3.height = dimensionPixelSize3;
                }
                View view7 = this.c;
                if (view7 != null && (layoutParams2 = view7.getLayoutParams()) != null) {
                    layoutParams2.width = dimensionPixelSize3;
                }
                View view8 = this.c;
                if (view8 != null && (layoutParams = view8.getLayoutParams()) != null) {
                    layoutParams.height = dimensionPixelSize3;
                }
            }
            int i4 = R.styleable.BNLottieSpeedView_nsdk_speed_unit;
            if (obtainStyledAttributes.hasValue(i4)) {
                str = obtainStyledAttributes.getString(i4);
                TextView textView5 = this.e;
                if (textView5 != null) {
                    textView5.setText(str);
                }
            }
            int i5 = R.styleable.BNLottieSpeedView_nsdk_speed_cur_speed_txt_size;
            if (obtainStyledAttributes.hasValue(i5) && (dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(i5, 0)) > 0 && (textView2 = this.d) != null) {
                textView2.setTextSize(0, dimensionPixelSize2);
            }
            int i6 = R.styleable.BNLottieSpeedView_nsdk_speed_km_h_txt_size;
            if (obtainStyledAttributes.hasValue(i6) && (dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i6, 0)) > 0 && (textView = this.e) != null) {
                textView.setTextSize(0, dimensionPixelSize);
            }
            int i7 = R.styleable.BNLottieSpeedView_nsdk_speed_support_night;
            if (obtainStyledAttributes.hasValue(i7)) {
                this.f = obtainStyledAttributes.getBoolean(i7, false);
            }
            int i8 = R.styleable.BNLottieSpeedView_nsdk_speed_normal_text_color;
            if (obtainStyledAttributes.hasValue(i8)) {
                this.m = obtainStyledAttributes.getResourceId(i8, 0);
            }
            int i9 = R.styleable.BNLottieSpeedView_nsdk_speed_normal_bg;
            if (obtainStyledAttributes.hasValue(i9)) {
                this.n = obtainStyledAttributes.getResourceId(i9, 0);
            }
            int i10 = R.styleable.BNLottieSpeedView_nsdk_speed_normal_behind_bg;
            if (obtainStyledAttributes.hasValue(i10)) {
                this.o = obtainStyledAttributes.getResourceId(i10, 0);
            }
            int i11 = R.styleable.BNLottieSpeedView_nsdk_speed_normal_front_bg;
            if (obtainStyledAttributes.hasValue(i11)) {
                this.p = obtainStyledAttributes.getResourceId(i11, 0);
            }
            int i12 = R.styleable.BNLottieSpeedView_nsdk_speed_over_text_color;
            if (obtainStyledAttributes.hasValue(i12)) {
                this.q = obtainStyledAttributes.getResourceId(i12, 0);
            }
            int i13 = R.styleable.BNLottieSpeedView_nsdk_speed_over_bg;
            if (obtainStyledAttributes.hasValue(i13)) {
                this.r = obtainStyledAttributes.getResourceId(i13, 0);
            }
            int i14 = R.styleable.BNLottieSpeedView_nsdk_speed_over_behind_bg;
            if (obtainStyledAttributes.hasValue(i14)) {
                this.s = obtainStyledAttributes.getResourceId(i14, 0);
            }
            int i15 = R.styleable.BNLottieSpeedView_nsdk_speed_over_front_bg;
            if (obtainStyledAttributes.hasValue(i15)) {
                this.t = obtainStyledAttributes.getResourceId(i15, 0);
            }
            int i16 = R.styleable.BNLottieSpeedView_nsdk_speed_over_lottie_anim_asset_name;
            if (obtainStyledAttributes.hasValue(i16)) {
                String string = obtainStyledAttributes.getString(i16);
                IIX0o.ooOOo0oXI(string);
                this.u = string;
            }
            obtainStyledAttributes.recycle();
        }
        a("0", false, str);
    }
}
