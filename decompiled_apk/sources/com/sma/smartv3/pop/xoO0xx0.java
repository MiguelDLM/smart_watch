package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.WheelView.WheelView;
import java.util.List;

/* loaded from: classes12.dex */
public final class xoO0xx0 extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21541II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21542OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Integer, Boolean> f21543oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f21544ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21545xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final WheelView f21546xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xoO0xx0(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo List<String> items) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(items, "items");
        this.f21545xoIox = -1;
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_picker2, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21541II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.wv);
        WheelView wheelView = (WheelView) findViewById2;
        wheelView.setListener(new X0O0I0.I0Io() { // from class: com.sma.smartv3.pop.IIxOXoOo0
            @Override // X0O0I0.I0Io
            public final void onItemSelected(int i) {
                xoO0xx0.ooXIXxIX(xoO0xx0.this, i);
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21546xxIXOIIO = wheelView;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.I0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xoO0xx0.XIxXXX0x0(xoO0xx0.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.ooOx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xoO0xx0.xxX(xoO0xx0.this, view);
            }
        });
        wheelView.setVisibleCount(3);
        wheelView.setItems(items);
    }

    public static final void XIxXXX0x0(xoO0xx0 this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void ooXIXxIX(xoO0xx0 this$0, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.f21545xoIox = i;
    }

    public static final void xxX(xoO0xx0 this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21543oOoXoXO;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(Integer.valueOf(this$0.f21545xoIox)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final boolean IIX0o() {
        return this.f21544ooOOo0oXI;
    }

    public final void IoOoX(int i) {
        this.f21545xoIox = i;
        this.f21546xxIXOIIO.setInitPosition(i);
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Integer, Boolean> XxX0x0xxx() {
        return this.f21543oOoXoXO;
    }

    public final void oo(boolean z) {
        this.f21544ooOOo0oXI = z;
        if (z) {
            this.f21546xxIXOIIO.xxIXOIIO();
        }
    }

    public final void oo0xXOI0I(int i) {
        this.f21542OOXIXo = i;
        this.f21541II0XooXoX.setText(i);
    }

    public final void xI(@OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        this.f21543oOoXoXO = oooxoxo;
    }

    public final int xXxxox0I() {
        return this.f21542OOXIXo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xoO0xx0(@OXOo.OOXIXo android.app.Activity r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            android.content.res.Resources r0 = r2.getResources()
            java.lang.String[] r3 = r0.getStringArray(r3)
            java.lang.String r0 = "getStringArray(...)"
            kotlin.jvm.internal.IIX0o.oO(r3, r0)
            java.util.List r3 = kotlin.collections.ArraysKt___ArraysKt.IoXOX(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.pop.xoO0xx0.<init>(android.app.Activity, int):void");
    }
}
