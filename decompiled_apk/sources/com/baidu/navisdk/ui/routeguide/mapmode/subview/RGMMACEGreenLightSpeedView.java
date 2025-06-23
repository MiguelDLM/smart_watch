package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class RGMMACEGreenLightSpeedView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private View f8708a;

    @OOXIXo
    private RGMMRotatingSpeedView b;

    @OOXIXo
    private TextView c;

    @OOXIXo
    private TextView d;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    @xoIox
    public RGMMACEGreenLightSpeedView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void a(@OOXIXo String speed, int i, int i2, int i3) {
        IIX0o.x0xO0oo(speed, "speed");
        int a2 = com.baidu.navisdk.ui.routeguide.ace.h.f8430a.a(speed, i, i2, i3);
        RGMMRotatingSpeedView.a(this.b, speed, null, 2, null);
        a(a2);
    }

    @OOXIXo
    public final TextView getMGreenLightLabel() {
        return this.d;
    }

    @OOXIXo
    public final TextView getMRangeView() {
        return this.c;
    }

    @OOXIXo
    public final View getMShadowView() {
        return this.f8708a;
    }

    @OOXIXo
    public final RGMMRotatingSpeedView getMSpeedView() {
        return this.b;
    }

    public final void setMGreenLightLabel(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.d = textView;
    }

    public final void setMRangeView(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.c = textView;
    }

    public final void setMShadowView(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.f8708a = view;
    }

    public final void setMSpeedView(@OOXIXo RGMMRotatingSpeedView rGMMRotatingSpeedView) {
        IIX0o.x0xO0oo(rGMMRotatingSpeedView, "<set-?>");
        this.b = rGMMRotatingSpeedView;
    }

    public /* synthetic */ RGMMACEGreenLightSpeedView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public RGMMACEGreenLightSpeedView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_smart_traffic_green_light_speed_view, this, true);
        View findViewById = findViewById(R.id.speed_view);
        IIX0o.oO(findViewById, "findViewById(R.id.speed_view)");
        this.b = (RGMMRotatingSpeedView) findViewById;
        View findViewById2 = findViewById(R.id.green_light_speed_range);
        IIX0o.oO(findViewById2, "findViewById(R.id.green_light_speed_range)");
        this.c = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.speed_view_shadow);
        IIX0o.oO(findViewById3, "findViewById(R.id.speed_view_shadow)");
        this.f8708a = findViewById3;
        View findViewById4 = findViewById(R.id.green_light_speed_label);
        IIX0o.oO(findViewById4, "findViewById(R.id.green_light_speed_label)");
        this.d = (TextView) findViewById4;
    }

    private final void a(int i) {
        if (i == 1) {
            this.b.a(i);
            this.f8708a.setBackgroundResource(R.drawable.nsdk_green_light_speed_view_shadow_bg);
            TextView textView = this.c;
            int i2 = R.color.bnav_smart_green_light_text_color;
            com.baidu.navisdk.ui.util.b.a(textView, i2);
            com.baidu.navisdk.ui.util.b.a(this.d, i2);
            return;
        }
        if (i == 2) {
            this.b.a(i);
            this.f8708a.setBackgroundResource(R.drawable.nsdk_green_light_perfect_speed_shadow_bg);
            this.c.setTextColor(Color.parseColor("#00C3A6"));
            this.d.setTextColor(Color.parseColor("#00C3A6"));
            return;
        }
        if (i != 3) {
            return;
        }
        this.b.a(i);
        this.f8708a.setBackgroundResource(R.drawable.nsdk_green_light_speed_view_shadow_bg);
        TextView textView2 = this.c;
        int i3 = R.color.bnav_smart_green_light_text_color;
        com.baidu.navisdk.ui.util.b.a(textView2, i3);
        com.baidu.navisdk.ui.util.b.a(this.d, i3);
    }

    public final void a(int i, int i2) {
        TextView textView = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('~');
        sb.append(i2);
        textView.setText(sb.toString());
    }
}
