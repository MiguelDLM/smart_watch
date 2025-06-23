package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.picker.IntValuePicker;

/* loaded from: classes12.dex */
public final class IntValuePickerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21287II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21288OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Integer, Boolean> f21289oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21290xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final IntValuePicker f21291xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntValuePickerPopup(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_int_value_picker, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21287II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.int_value_picker);
        IntValuePicker intValuePicker = (IntValuePicker) findViewById2;
        intValuePicker.setVisibleCount(3);
        intValuePicker.setMListener(new Oox.oOoXoXO<Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.pop.IntValuePickerPopup$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i) {
                IntValuePickerPopup.this.f21290xoIox = i;
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21291xxIXOIIO = intValuePicker;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.x0o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntValuePickerPopup.XI0IXoo(IntValuePickerPopup.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XOxIOxOx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntValuePickerPopup.XIxXXX0x0(IntValuePickerPopup.this, view);
            }
        });
    }

    public static final void XI0IXoo(IntValuePickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(IntValuePickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21289oOoXoXO;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(Integer.valueOf(this$0.f21290xoIox)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final void IIX0o(@OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        this.f21289oOoXoXO = oooxoxo;
    }

    public final void IoOoX(int i) {
        this.f21290xoIox = i;
        this.f21291xxIXOIIO.setValuse(i);
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Integer, Boolean> XxX0x0xxx() {
        return this.f21289oOoXoXO;
    }

    public final void oOXoIIIo(@OXOo.OOXIXo String text) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        this.f21291xxIXOIIO.setZeroText(text);
    }

    public final void oo(boolean z) {
        this.f21291xxIXOIIO.setUseZero(z);
    }

    public final void oo0xXOI0I(int i) {
        this.f21291xxIXOIIO.setUnit(i);
    }

    public final void ooXIXxIX(int i) {
        this.f21288OOXIXo = i;
        this.f21287II0XooXoX.setText(i);
    }

    public final void xI(int i, int i2) {
        this.f21291xxIXOIIO.X0o0xo(i, i2);
    }

    public final int xXxxox0I() {
        return this.f21288OOXIXo;
    }
}
