package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.picker.TimeRangePicker;

/* loaded from: classes12.dex */
public final class TimeRangePopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TimeRangePicker f21356II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21357OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21358oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.Oxx0xo<? super Integer, ? super Integer, ? super Integer, ? super Integer, Boolean> f21359ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21360xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f21361xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeRangePopup(@OXOo.OOXIXo Activity activity, boolean z) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_time_range, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.time_range_picker);
        TimeRangePicker timeRangePicker = (TimeRangePicker) findViewById;
        timeRangePicker.set24Hourly(z);
        timeRangePicker.setVisibleCount(3);
        timeRangePicker.setMListener(new Oox.Oxx0xo<Integer, Integer, Integer, Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.pop.TimeRangePopup$1$1
            {
                super(4);
            }

            @Override // Oox.Oxx0xo
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2, int i3, int i4) {
                TimeRangePopup.this.f21361xxIXOIIO = i;
                TimeRangePopup.this.f21360xoIox = i2;
                TimeRangePopup.this.f21357OOXIXo = i3;
                TimeRangePopup.this.f21358oOoXoXO = i4;
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById, "apply(...)");
        this.f21356II0XooXoX = timeRangePicker;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oXxOI0oIx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeRangePopup.XI0IXoo(TimeRangePopup.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XOxxooXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeRangePopup.XIxXXX0x0(TimeRangePopup.this, view);
            }
        });
    }

    public static final void XI0IXoo(TimeRangePopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(TimeRangePopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.Oxx0xo<? super Integer, ? super Integer, ? super Integer, ? super Integer, Boolean> oxx0xo = this$0.f21359ooOOo0oXI;
        if (oxx0xo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oxx0xo);
            if (!oxx0xo.invoke(Integer.valueOf(this$0.f21361xxIXOIIO), Integer.valueOf(this$0.f21360xoIox), Integer.valueOf(this$0.f21357OOXIXo), Integer.valueOf(this$0.f21358oOoXoXO)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final void oo0xXOI0I(int i, int i2, int i3, int i4) {
        this.f21361xxIXOIIO = i;
        this.f21360xoIox = i2;
        this.f21357OOXIXo = i3;
        this.f21358oOoXoXO = i4;
        this.f21356II0XooXoX.OOXIXo(i, i2, i3, i4);
    }

    @OXOo.oOoXoXO
    public final Oox.Oxx0xo<Integer, Integer, Integer, Integer, Boolean> ooXIXxIX() {
        return this.f21359ooOOo0oXI;
    }

    public final void xI(@OXOo.oOoXoXO Oox.Oxx0xo<? super Integer, ? super Integer, ? super Integer, ? super Integer, Boolean> oxx0xo) {
        this.f21359ooOOo0oXI = oxx0xo;
    }

    public /* synthetic */ TimeRangePopup(Activity activity, boolean z, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i & 2) != 0 ? com.sma.smartv3.util.xoIox.ooXIXxIX() : z);
    }
}
