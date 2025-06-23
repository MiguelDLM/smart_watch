package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.picker.CalibrationPicker;

/* loaded from: classes12.dex */
public final class CalibrationPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21224II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21225OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21226oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super Integer, ? super Integer, Boolean> f21227ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21228xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CalibrationPicker f21229xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalibrationPopup(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_date_calibration, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21224II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.date_picker);
        CalibrationPicker calibrationPicker = (CalibrationPicker) findViewById2;
        calibrationPicker.setVisibleCount(3);
        calibrationPicker.setMListener(new Oox.x0xO0oo<Integer, Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.pop.CalibrationPopup$1$1
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2) {
                CalibrationPopup.this.f21228xoIox = i;
                CalibrationPopup.this.f21225OOXIXo = i2;
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21229xxIXOIIO = calibrationPicker;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oOoXoXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalibrationPopup.XI0IXoo(CalibrationPopup.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.ooOOo0oXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalibrationPopup.XIxXXX0x0(CalibrationPopup.this, view);
            }
        });
    }

    public static final void XI0IXoo(CalibrationPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(CalibrationPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.x0xO0oo<? super Integer, ? super Integer, Boolean> x0xo0oo = this$0.f21227ooOOo0oXI;
        if (x0xo0oo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(x0xo0oo);
            if (!x0xo0oo.invoke(Integer.valueOf(this$0.f21228xoIox), Integer.valueOf(this$0.f21225OOXIXo)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final int IIX0o() {
        return this.f21226oOoXoXO;
    }

    public final void oo0xXOI0I(int i) {
        this.f21226oOoXoXO = i;
        this.f21224II0XooXoX.setText(i);
    }

    public final void ooXIXxIX(int i, int i2) {
        this.f21228xoIox = i;
        this.f21225OOXIXo = i2;
        this.f21229xxIXOIIO.Oxx0IOOO(i, i2);
    }

    public final void xI(@OXOo.oOoXoXO Oox.x0xO0oo<? super Integer, ? super Integer, Boolean> x0xo0oo) {
        this.f21227ooOOo0oXI = x0xo0oo;
    }

    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<Integer, Integer, Boolean> xXxxox0I() {
        return this.f21227ooOOo0oXI;
    }
}
