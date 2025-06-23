package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.picker.DurationPicker;

/* loaded from: classes12.dex */
public final class DurationPickerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21246II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21247OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21248oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Integer, Boolean> f21249ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21250xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final DurationPicker f21251xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DurationPickerPopup(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        this.f21248oOoXoXO = "";
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_duration_picker, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21246II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.duration_picker);
        DurationPicker durationPicker = (DurationPicker) findViewById2;
        durationPicker.setVisibleCount(3);
        durationPicker.setMListener(new Oox.oOoXoXO<Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.pop.DurationPickerPopup$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i) {
                DurationPickerPopup.this.f21250xoIox = i;
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21251xxIXOIIO = durationPicker;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.X0IIOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DurationPickerPopup.XI0IXoo(DurationPickerPopup.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XI0IXoo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DurationPickerPopup.XIxXXX0x0(DurationPickerPopup.this, view);
            }
        });
    }

    public static final void XI0IXoo(DurationPickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(DurationPickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Integer, Boolean> oooxoxo = this$0.f21249ooOOo0oXI;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(Integer.valueOf(this$0.f21250xoIox)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    @OXOo.OOXIXo
    public final String IIX0o() {
        return this.f21248oOoXoXO;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Integer, Boolean> XxX0x0xxx() {
        return this.f21249ooOOo0oXI;
    }

    public final void oo(@OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f21248oOoXoXO = value;
        this.f21246II0XooXoX.setText(value);
    }

    public final void oo0xXOI0I(int i) {
        this.f21247OOXIXo = i;
        this.f21246II0XooXoX.setText(i);
    }

    public final void ooXIXxIX(int i) {
        this.f21250xoIox = i;
        this.f21251xxIXOIIO.setDuration(i);
    }

    public final void xI(@OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        this.f21249ooOOo0oXI = oooxoxo;
    }

    public final int xXxxox0I() {
        return this.f21247OOXIXo;
    }
}
