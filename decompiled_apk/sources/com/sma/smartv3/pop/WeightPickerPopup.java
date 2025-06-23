package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.picker.WeightPicker;

/* loaded from: classes12.dex */
public final class WeightPickerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21362II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21363OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Float, Boolean> f21364oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public float f21365xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final WeightPicker f21366xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeightPickerPopup(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_weight_picker, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21362II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.weight_picker);
        WeightPicker weightPicker = (WeightPicker) findViewById2;
        weightPicker.setVisibleCount(3);
        weightPicker.setMListener(new Oox.oOoXoXO<Float, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.pop.WeightPickerPopup$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Float f) {
                invoke(f.floatValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(float f) {
                WeightPickerPopup.this.f21365xoIox = f;
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21366xxIXOIIO = weightPicker;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.O0xxXxI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeightPickerPopup.XI0IXoo(WeightPickerPopup.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oxOXxoXII
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeightPickerPopup.XIxXXX0x0(WeightPickerPopup.this, view);
            }
        });
    }

    public static final void XI0IXoo(WeightPickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(WeightPickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Float, Boolean> oooxoxo = this$0.f21364oOoXoXO;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(Float.valueOf(this$0.f21365xoIox)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final void IIX0o(@OXOo.oOoXoXO Oox.oOoXoXO<? super Float, Boolean> oooxoxo) {
        this.f21364oOoXoXO = oooxoxo;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Float, Boolean> XxX0x0xxx() {
        return this.f21364oOoXoXO;
    }

    public final void oo0xXOI0I(float f) {
        this.f21365xoIox = f;
        this.f21366xxIXOIIO.setWeight(f);
    }

    public final void ooXIXxIX(int i) {
        this.f21363OOXIXo = i;
        this.f21362II0XooXoX.setText(i);
    }

    public final void xI(int i) {
        this.f21366xxIXOIIO.setUnit(i);
    }

    public final int xXxxox0I() {
        return this.f21363OOXIXo;
    }
}
