package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class RGMMACESpeedView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private RGMMRotatingSpeedView f8709a;

    @OOXIXo
    private View b;

    @xoIox
    public RGMMACESpeedView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void a(@OOXIXo String speed, int i) {
        IIX0o.x0xO0oo(speed, "speed");
        int a2 = com.baidu.navisdk.ui.routeguide.ace.h.f8430a.a(speed, i);
        a(a2);
        this.f8709a.a(a2);
        RGMMRotatingSpeedView.a(this.f8709a, speed, null, 2, null);
    }

    @OOXIXo
    public final View getMShadowView() {
        return this.b;
    }

    @OOXIXo
    public final RGMMRotatingSpeedView getMSpeedView() {
        return this.f8709a;
    }

    public final void setMShadowView(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.b = view;
    }

    public final void setMSpeedView(@OOXIXo RGMMRotatingSpeedView rGMMRotatingSpeedView) {
        IIX0o.x0xO0oo(rGMMRotatingSpeedView, "<set-?>");
        this.f8709a = rGMMRotatingSpeedView;
    }

    public /* synthetic */ RGMMACESpeedView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public RGMMACESpeedView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_smart_traffic_speed_view, this, true);
        View findViewById = findViewById(R.id.speed_view);
        IIX0o.oO(findViewById, "findViewById(R.id.speed_view)");
        this.f8709a = (RGMMRotatingSpeedView) findViewById;
        View findViewById2 = findViewById(R.id.speed_view_shadow);
        IIX0o.oO(findViewById2, "findViewById(R.id.speed_view_shadow)");
        this.b = findViewById2;
    }

    private final void a(int i) {
        if (i == 1) {
            com.baidu.navisdk.ui.util.b.a(this.b, R.drawable.nsdk_smart_traffic_speed_blue_shadow);
        } else {
            if (i != 3) {
                return;
            }
            com.baidu.navisdk.ui.util.b.a(this.b, R.drawable.nsdk_smart_traffic_speed_red_shadow);
        }
    }
}
