package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.view.picker.DateTimePicker;

/* loaded from: classes12.dex */
public final class DateTimePickerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21237II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21238OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    public int f21239oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21240oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f21241ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f21242x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oI0IIXIo<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Boolean> f21243x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21244xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final DateTimePicker f21245xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTimePickerPopup(@OXOo.OOXIXo Activity activity, boolean z) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        if (ProjectManager.f19822oIX0oI.x0XOIxOo() == DateTimeFormat.ddMMyyyy) {
            LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_date_time_picker_1, xxIXOIIO());
        } else {
            LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_date_time_picker, xxIXOIIO());
        }
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21237II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.date_time_picker);
        DateTimePicker dateTimePicker = (DateTimePicker) findViewById2;
        dateTimePicker.set24Hourly(z);
        dateTimePicker.setVisibleCount(3);
        dateTimePicker.setMListener(new Oox.oI0IIXIo<Integer, Integer, Integer, Integer, Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.pop.DateTimePickerPopup$1$1
            {
                super(5);
            }

            @Override // Oox.oI0IIXIo
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
                invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), num5.intValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2, int i3, int i4, int i5) {
                DateTimePickerPopup dateTimePickerPopup = DateTimePickerPopup.this;
                if (i == 0) {
                    i = dateTimePickerPopup.f21244xoIox;
                }
                dateTimePickerPopup.f21244xoIox = i;
                DateTimePickerPopup dateTimePickerPopup2 = DateTimePickerPopup.this;
                if (i2 == 0) {
                    i2 = dateTimePickerPopup2.f21238OOXIXo;
                }
                dateTimePickerPopup2.f21238OOXIXo = i2;
                DateTimePickerPopup dateTimePickerPopup3 = DateTimePickerPopup.this;
                if (i3 == 0) {
                    i3 = dateTimePickerPopup3.f21240oOoXoXO;
                }
                dateTimePickerPopup3.f21240oOoXoXO = i3;
                DateTimePickerPopup.this.f21241ooOOo0oXI = i4;
                DateTimePickerPopup dateTimePickerPopup4 = DateTimePickerPopup.this;
                dateTimePickerPopup4.f21242x0XOIxOo = i5 == 0 ? dateTimePickerPopup4.f21242x0XOIxOo : i5;
                DateTimePickerPopup.this.f21242x0XOIxOo = i5;
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21245xxIXOIIO = dateTimePicker;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.o00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateTimePickerPopup.XI0IXoo(DateTimePickerPopup.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.OxI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateTimePickerPopup.XIxXXX0x0(DateTimePickerPopup.this, view);
            }
        });
    }

    public static final void XI0IXoo(DateTimePickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(DateTimePickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oI0IIXIo<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Boolean> oi0iixio = this$0.f21243x0xO0oo;
        if (oi0iixio != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oi0iixio);
            if (!oi0iixio.invoke(Integer.valueOf(this$0.f21244xoIox), Integer.valueOf(this$0.f21238OOXIXo), Integer.valueOf(this$0.f21240oOoXoXO), Integer.valueOf(this$0.f21241ooOOo0oXI), Integer.valueOf(this$0.f21242x0XOIxOo)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public final void IO(@OXOo.oOoXoXO Oox.oI0IIXIo<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Boolean> oi0iixio) {
        this.f21243x0xO0oo = oi0iixio;
    }

    public final void X00IoxXI(int i, int i2, int i3, int i4, int i5) {
        this.f21244xoIox = i;
        this.f21238OOXIXo = i2;
        this.f21240oOoXoXO = i3;
        this.f21241ooOOo0oXI = i4;
        this.f21242x0XOIxOo = i5;
        this.f21245xxIXOIIO.ooOOo0oXI(i, i2, i3, i4, i5);
    }

    public final int Xx000oIo() {
        return this.f21239oO;
    }

    @OXOo.oOoXoXO
    public final Oox.oI0IIXIo<Integer, Integer, Integer, Integer, Integer, Boolean> oOXoIIIo() {
        return this.f21243x0xO0oo;
    }

    public final void xII(int i) {
        this.f21239oO = i;
        this.f21237II0XooXoX.setText(i);
    }

    public /* synthetic */ DateTimePickerPopup(Activity activity, boolean z, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i & 2) != 0 ? com.sma.smartv3.util.xoIox.ooXIXxIX() : z);
    }
}
