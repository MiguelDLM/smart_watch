package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.WheelView.WheelView;
import java.util.List;

/* loaded from: classes12.dex */
public final class OX00O0xII extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21315II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21316OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21317oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f21318ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Integer, Boolean> f21319x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21320xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final WheelView f21321xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OX00O0xII(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo List<String> items) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(items, "items");
        this.f21316OOXIXo = -1;
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_picker, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21315II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.wv);
        WheelView wheelView = (WheelView) findViewById2;
        wheelView.setListener(new X0O0I0.I0Io() { // from class: com.sma.smartv3.pop.O00XxXI
            @Override // X0O0I0.I0Io
            public final void onItemSelected(int i) {
                OX00O0xII.xI(OX00O0xII.this, i);
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21321xxIXOIIO = wheelView;
        View findViewById3 = xxIXOIIO().findViewById(R.id.tv_picker_unit);
        kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
        this.f21320xoIox = (TextView) findViewById3;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XI0oooXX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OX00O0xII.XIxXXX0x0(OX00O0xII.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.OOXIxO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OX00O0xII.xxX(OX00O0xII.this, view);
            }
        });
        wheelView.setVisibleCount(3);
        wheelView.setItems(items);
    }

    public static final void XIxXXX0x0(OX00O0xII this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void xI(OX00O0xII this$0, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.f21316OOXIXo = i;
    }

    public static final void xxX(OX00O0xII this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21319x0XOIxOo;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(Integer.valueOf(this$0.f21316OOXIXo)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final int IIX0o() {
        return this.f21318ooOOo0oXI;
    }

    public final void IoOoX(int i) {
        this.f21318ooOOo0oXI = i;
        this.f21320xoIox.setText(i);
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Integer, Boolean> XxX0x0xxx() {
        return this.f21319x0XOIxOo;
    }

    public final void oOXoIIIo(int i) {
        this.f21316OOXIXo = i;
        this.f21321xxIXOIIO.setInitPosition(i);
    }

    public final void oo(int i) {
        this.f21317oOoXoXO = i;
        this.f21315II0XooXoX.setText(i);
    }

    public final void oo0xXOI0I(@OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        this.f21319x0XOIxOo = oooxoxo;
    }

    @OXOo.OOXIXo
    public final TextView ooXIXxIX() {
        return this.f21320xoIox;
    }

    public final int xXxxox0I() {
        return this.f21317oOoXoXO;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public OX00O0xII(@OXOo.OOXIXo android.app.Activity r2, int r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.pop.OX00O0xII.<init>(android.app.Activity, int):void");
    }
}
