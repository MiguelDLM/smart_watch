package com.sma.smartv3.view.picker;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.Oxx0xo;
import Oox.x0xO0oo;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class TimeRangePicker extends LinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @oOoXoXO
    public Oxx0xo<? super Integer, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> f25568IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25569IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final TimePicker f25570Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25571Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25572OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final TimePicker f25573XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25574oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f25575xoXoI;

    /* loaded from: classes12.dex */
    public static final class I0Io extends oIX0oI {
        public I0Io() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.TimeRangePicker.oIX0oI, Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Integer num2) {
            oIX0oI(num.intValue(), num2.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }

        @Override // com.sma.smartv3.view.picker.TimeRangePicker.oIX0oI
        public void oIX0oI(int i, int i2) {
            TimeRangePicker.this.f25574oI0IIXIo = i;
            TimeRangePicker.this.f25572OxxIIOOXO = i2;
            super.oIX0oI(i, i2);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends oIX0oI {
        public II0xO0() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.TimeRangePicker.oIX0oI, Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Integer num2) {
            oIX0oI(num.intValue(), num2.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }

        @Override // com.sma.smartv3.view.picker.TimeRangePicker.oIX0oI
        public void oIX0oI(int i, int i2) {
            TimeRangePicker.this.f25569IXxxXO = i;
            TimeRangePicker.this.f25571Oxx0xo = i2;
            super.oIX0oI(i, i2);
        }
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements x0xO0oo<Integer, Integer, oXIO0o0XI> {
        public oIX0oI() {
        }

        @Override // Oox.x0xO0oo
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, Integer num2) {
            oIX0oI(num.intValue(), num2.intValue());
            return oXIO0o0XI.f29392oIX0oI;
        }

        @CallSuper
        public void oIX0oI(int i, int i2) {
            Oxx0xo<Integer, Integer, Integer, Integer, oXIO0o0XI> mListener = TimeRangePicker.this.getMListener();
            if (mListener != null) {
                mListener.invoke(Integer.valueOf(TimeRangePicker.this.f25569IXxxXO), Integer.valueOf(TimeRangePicker.this.f25571Oxx0xo), Integer.valueOf(TimeRangePicker.this.f25574oI0IIXIo), Integer.valueOf(TimeRangePicker.this.f25572OxxIIOOXO));
            }
        }
    }

    @xoIox
    public TimeRangePicker(@oOoXoXO Context context) {
        this(context, null, 0, 6, null);
    }

    public final void OOXIXo(int i, int i2, int i3, int i4) {
        this.f25573XO.xoIox(i, i2);
        this.f25570Oo.xoIox(i3, i4);
        this.f25569IXxxXO = i;
        this.f25571Oxx0xo = i2;
        this.f25574oI0IIXIo = i3;
        this.f25572OxxIIOOXO = i4;
    }

    @oOoXoXO
    public final Oxx0xo<Integer, Integer, Integer, Integer, oXIO0o0XI> getMListener() {
        return this.f25568IIXOooo;
    }

    public final void set24Hourly(boolean z) {
        this.f25575xoXoI = z;
        xxIXOIIO();
    }

    public final void setMListener(@oOoXoXO Oxx0xo<? super Integer, ? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> oxx0xo) {
        this.f25568IIXOooo = oxx0xo;
    }

    public final void setVisibleCount(int i) {
        this.f25573XO.setVisibleCount(i);
        this.f25570Oo.setVisibleCount(i);
    }

    public final boolean xoIox() {
        return this.f25575xoXoI;
    }

    public final void xxIXOIIO() {
        this.f25573XO.set24Hourly(this.f25575xoXoI);
        this.f25573XO.setMListener(new II0xO0());
        this.f25570Oo.set24Hourly(this.f25575xoXoI);
        this.f25570Oo.setMListener(new I0Io());
    }

    @xoIox
    public TimeRangePicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TimeRangePicker(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @xoIox
    public TimeRangePicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25575xoXoI = com.sma.smartv3.util.xoIox.ooXIXxIX();
        LayoutInflater.from(context).inflate(R.layout.view_time_range_picker, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.picker_start);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f25573XO = (TimePicker) findViewById;
        View findViewById2 = findViewById(R.id.picker_end);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.f25570Oo = (TimePicker) findViewById2;
        xxIXOIIO();
    }
}
