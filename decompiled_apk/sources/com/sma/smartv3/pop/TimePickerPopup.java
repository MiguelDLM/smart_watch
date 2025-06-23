package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.picker.TimePicker;

/* loaded from: classes12.dex */
public final class TimePickerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21350II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21351OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21352oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super Integer, ? super Integer, Boolean> f21353ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21354xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TimePicker f21355xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerPopup(@OXOo.OOXIXo Activity activity, boolean z) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_time_picker, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21350II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.time_picker);
        TimePicker timePicker = (TimePicker) findViewById2;
        timePicker.set24Hourly(z);
        timePicker.setVisibleCount(3);
        timePicker.setMListener(new Oox.x0xO0oo<Integer, Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.pop.TimePickerPopup$1$1
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2) {
                TimePickerPopup.this.f21354xoIox = i;
                TimePickerPopup.this.f21351OOXIXo = i2;
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21355xxIXOIIO = timePicker;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.X0xII0I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerPopup.XI0IXoo(TimePickerPopup.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.X0xxXX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerPopup.XIxXXX0x0(TimePickerPopup.this, view);
            }
        });
    }

    public static final void XI0IXoo(TimePickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(TimePickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.x0xO0oo<? super Integer, ? super Integer, Boolean> x0xo0oo = this$0.f21353ooOOo0oXI;
        if (x0xo0oo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(x0xo0oo);
            if (!x0xo0oo.invoke(Integer.valueOf(this$0.f21354xoIox), Integer.valueOf(this$0.f21351OOXIXo)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final int IIX0o() {
        return this.f21352oOoXoXO;
    }

    public final void oo0xXOI0I(int i, int i2) {
        this.f21354xoIox = i;
        this.f21351OOXIXo = i2;
        this.f21355xxIXOIIO.xoIox(i, i2);
    }

    public final void ooXIXxIX(@OXOo.oOoXoXO Oox.x0xO0oo<? super Integer, ? super Integer, Boolean> x0xo0oo) {
        this.f21353ooOOo0oXI = x0xo0oo;
    }

    public final void xI(int i) {
        this.f21352oOoXoXO = i;
        this.f21350II0XooXoX.setText(i);
    }

    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<Integer, Integer, Boolean> xXxxox0I() {
        return this.f21353ooOOo0oXI;
    }

    public /* synthetic */ TimePickerPopup(Activity activity, boolean z, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i & 2) != 0 ? com.sma.smartv3.util.xoIox.ooXIXxIX() : z);
    }
}
