package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class RGMMRotatingSpeedView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private View f8710a;

    @OOXIXo
    private View b;

    @OOXIXo
    private TextView c;

    @OOXIXo
    private TextView d;
    private int e;

    @xoIox
    public RGMMRotatingSpeedView(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RGMMGreenLightSpeedView);
        IIX0o.oO(obtainStyledAttributes, "context.obtainStyledAttr….RGMMGreenLightSpeedView)");
        int i = R.styleable.RGMMGreenLightSpeedView_green_light_speed_oval_bg;
        if (obtainStyledAttributes.hasValue(i)) {
            this.f8710a.setBackgroundResource(obtainStyledAttributes.getResourceId(i, 0));
        }
        int i2 = R.styleable.RGMMGreenLightSpeedView_green_light_speed_circle_bg;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.b.setBackgroundResource(obtainStyledAttributes.getResourceId(i2, 0));
        }
        obtainStyledAttributes.recycle();
    }

    private final void b() {
        this.f8710a.clearAnimation();
        this.f8710a.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.code_table_rotate));
    }

    @OOXIXo
    public final View getMCircleBgView() {
        return this.b;
    }

    @OOXIXo
    public final View getMOvalBgView() {
        return this.f8710a;
    }

    public final int getMPreStaus() {
        return this.e;
    }

    @OOXIXo
    public final TextView getMSpeedNumView() {
        return this.c;
    }

    @OOXIXo
    public final TextView getMSpeedUnitView() {
        return this.d;
    }

    public final void setMCircleBgView(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.b = view;
    }

    public final void setMOvalBgView(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.f8710a = view;
    }

    public final void setMPreStaus(int i) {
        this.e = i;
    }

    public final void setMSpeedNumView(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.c = textView;
    }

    public final void setMSpeedUnitView(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.d = textView;
    }

    @xoIox
    public final void setSpeed(@OOXIXo String str) {
        a(this, str, null, 2, null);
    }

    @xoIox
    public RGMMRotatingSpeedView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ RGMMRotatingSpeedView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public RGMMRotatingSpeedView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_green_light_top_speed_part, this, true);
        View findViewById = findViewById(R.id.oval_bg);
        IIX0o.oO(findViewById, "findViewById(R.id.oval_bg)");
        this.f8710a = findViewById;
        View findViewById2 = findViewById(R.id.circle_bg);
        IIX0o.oO(findViewById2, "findViewById(R.id.circle_bg)");
        this.b = findViewById2;
        View findViewById3 = findViewById(R.id.speed_num);
        IIX0o.oO(findViewById3, "findViewById(R.id.speed_num)");
        this.c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.speed_unit);
        IIX0o.oO(findViewById4, "findViewById(R.id.speed_unit)");
        this.d = (TextView) findViewById4;
        if (attributeSet != null) {
            a(attributeSet);
        }
    }

    public final void a(int i) {
        if (i == 1) {
            this.f8710a.setBackgroundResource(R.drawable.nsdk_green_light_normal_speed_oval_bg);
            this.b.setBackgroundResource(R.drawable.nsdk_green_light_normal_speed_circle_bg);
        } else if (i == 2) {
            this.f8710a.setBackgroundResource(R.drawable.nsdk_green_light_perfect_speed_oval_bg);
            this.b.setBackgroundResource(R.drawable.nsdk_green_light_perfect_speed_circle_bg);
        } else if (i == 3) {
            this.f8710a.setBackgroundResource(R.drawable.nsdk_green_light_over_speed_oval_bg);
            this.b.setBackgroundResource(R.drawable.nsdk_green_light_over_speed_circle_speed);
        }
        if (i != this.e) {
            a();
            b();
        }
        this.e = i;
    }

    public static /* synthetic */ void a(RGMMRotatingSpeedView rGMMRotatingSpeedView, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "km/h";
        }
        rGMMRotatingSpeedView.a(str, str2);
    }

    @xoIox
    public final void a(@OOXIXo String speed, @OOXIXo String unit) {
        IIX0o.x0xO0oo(speed, "speed");
        IIX0o.x0xO0oo(unit, "unit");
        this.c.setText(speed);
        this.d.setText(unit);
    }

    public final void a() {
        this.b.clearAnimation();
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.code_table_rotate));
        this.b.startAnimation(animationSet);
    }
}
