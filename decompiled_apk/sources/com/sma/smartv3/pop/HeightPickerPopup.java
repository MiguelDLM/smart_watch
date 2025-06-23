package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.picker.HeightPicker;

/* loaded from: classes12.dex */
public final class HeightPickerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21252II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21253OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Float, Boolean> f21254oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public float f21255xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final HeightPicker f21256xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeightPickerPopup(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_height_picker, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21252II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.height_picker);
        HeightPicker heightPicker = (HeightPicker) findViewById2;
        heightPicker.setVisibleCount(3);
        heightPicker.setMListener(new Oox.oOoXoXO<Float, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.pop.HeightPickerPopup$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Float f) {
                invoke(f.floatValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(float f) {
                HeightPickerPopup.this.f21255xoIox = f;
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21256xxIXOIIO = heightPicker;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.X00IoxXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeightPickerPopup.XI0IXoo(HeightPickerPopup.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.IO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeightPickerPopup.XIxXXX0x0(HeightPickerPopup.this, view);
            }
        });
    }

    public static final void XI0IXoo(HeightPickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(HeightPickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Float, Boolean> oooxoxo = this$0.f21254oOoXoXO;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(Float.valueOf(this$0.f21255xoIox)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final void IIX0o(float f) {
        this.f21255xoIox = f;
        this.f21256xxIXOIIO.setHeight(f);
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Float, Boolean> XxX0x0xxx() {
        return this.f21254oOoXoXO;
    }

    public final void oo0xXOI0I(int i) {
        this.f21256xxIXOIIO.setUnit(i);
    }

    public final void ooXIXxIX(@OXOo.oOoXoXO Oox.oOoXoXO<? super Float, Boolean> oooxoxo) {
        this.f21254oOoXoXO = oooxoxo;
    }

    public final void xI(int i) {
        this.f21253OOXIXo = i;
        this.f21252II0XooXoX.setText(i);
    }

    public final int xXxxox0I() {
        return this.f21253OOXIXo;
    }
}
