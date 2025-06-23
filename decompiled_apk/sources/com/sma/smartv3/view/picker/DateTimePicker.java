package com.sma.smartv3.view.picker;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import Oox.oI0IIXIo;
import Oox.x0xO0oo;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.sma.smartv3.co_fit.R;
import java.util.Calendar;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class DateTimePicker extends LinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25513IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25514IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final TimePicker f25515Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25516Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25517OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final DatePicker f25518XO;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f25519o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25520oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    @oOoXoXO
    public oI0IIXIo<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> f25521xoXoI;

    @xoIox
    public DateTimePicker(@oOoXoXO Context context) {
        this(context, null, 0, 6, null);
    }

    public final void OOXIXo() {
        this.f25518XO.setMListener(new IXxxXO<Integer, Integer, Integer, oXIO0o0XI>() { // from class: com.sma.smartv3.view.picker.DateTimePicker$init$1
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Integer num2, Integer num3) {
                invoke(num.intValue(), num2.intValue(), num3.intValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2, int i3) {
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                DateTimePicker.this.f25514IXxxXO = i;
                DateTimePicker.this.f25516Oxx0xo = i2;
                DateTimePicker.this.f25520oI0IIXIo = i3;
                oI0IIXIo<Integer, Integer, Integer, Integer, Integer, oXIO0o0XI> mListener = DateTimePicker.this.getMListener();
                if (mListener != null) {
                    i4 = DateTimePicker.this.f25514IXxxXO;
                    Integer valueOf = Integer.valueOf(i4);
                    i5 = DateTimePicker.this.f25516Oxx0xo;
                    Integer valueOf2 = Integer.valueOf(i5);
                    i6 = DateTimePicker.this.f25520oI0IIXIo;
                    Integer valueOf3 = Integer.valueOf(i6);
                    i7 = DateTimePicker.this.f25517OxxIIOOXO;
                    Integer valueOf4 = Integer.valueOf(i7);
                    i8 = DateTimePicker.this.f25513IIXOooo;
                    mListener.invoke(valueOf, valueOf2, valueOf3, valueOf4, Integer.valueOf(i8));
                }
            }
        });
        this.f25515Oo.set24Hourly(this.f25519o00);
        this.f25515Oo.setMListener(new x0xO0oo<Integer, Integer, oXIO0o0XI>() { // from class: com.sma.smartv3.view.picker.DateTimePicker$init$2
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2) {
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                DateTimePicker.this.f25517OxxIIOOXO = i;
                DateTimePicker.this.f25513IIXOooo = i2;
                oI0IIXIo<Integer, Integer, Integer, Integer, Integer, oXIO0o0XI> mListener = DateTimePicker.this.getMListener();
                if (mListener != null) {
                    i3 = DateTimePicker.this.f25514IXxxXO;
                    Integer valueOf = Integer.valueOf(i3);
                    i4 = DateTimePicker.this.f25516Oxx0xo;
                    Integer valueOf2 = Integer.valueOf(i4);
                    i5 = DateTimePicker.this.f25520oI0IIXIo;
                    Integer valueOf3 = Integer.valueOf(i5);
                    i6 = DateTimePicker.this.f25517OxxIIOOXO;
                    Integer valueOf4 = Integer.valueOf(i6);
                    i7 = DateTimePicker.this.f25513IIXOooo;
                    mListener.invoke(valueOf, valueOf2, valueOf3, valueOf4, Integer.valueOf(i7));
                }
            }
        });
    }

    @oOoXoXO
    public final oI0IIXIo<Integer, Integer, Integer, Integer, Integer, oXIO0o0XI> getMListener() {
        return this.f25521xoXoI;
    }

    public final boolean oOoXoXO() {
        return this.f25519o00;
    }

    public final void ooOOo0oXI(int i, int i2, int i3, int i4, int i5) {
        this.f25518XO.xoIox(i, i2, i3);
        this.f25515Oo.xoIox(i4, i5);
    }

    public final void set24Hourly(boolean z) {
        this.f25519o00 = z;
        OOXIXo();
    }

    public final void setMListener(@oOoXoXO oI0IIXIo<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oi0iixio) {
        this.f25521xoXoI = oi0iixio;
    }

    public final void setVisibleCount(int i) {
        this.f25518XO.setVisibleCount(i);
        this.f25515Oo.setVisibleCount(i);
    }

    @xoIox
    public DateTimePicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DateTimePicker(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public DateTimePicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.ooOOo0oXI(context);
        this.f25519o00 = com.sma.smartv3.util.xoIox.ooXIXxIX();
        LayoutInflater.from(context).inflate(R.layout.view_date_time_picker, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.time_picker);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f25515Oo = (TimePicker) findViewById;
        View findViewById2 = findViewById(R.id.date_picker);
        IIX0o.oO(findViewById2, "findViewById(...)");
        DatePicker datePicker = (DatePicker) findViewById2;
        this.f25518XO = datePicker;
        Calendar calendar = Calendar.getInstance();
        IIX0o.oO(calendar, "getInstance(...)");
        int oO2 = oOXoIIIo.II0xO0.oO(calendar);
        datePicker.OOXIXo(oO2 + 1, oO2);
        OOXIXo();
    }
}
