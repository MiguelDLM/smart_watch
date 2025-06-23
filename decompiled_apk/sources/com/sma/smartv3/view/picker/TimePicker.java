package com.sma.smartv3.view.picker;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.xoIox;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import com.google.android.material.timepicker.TimeModel;
import com.sma.smartv3.R;
import com.sma.smartv3.view.WheelView.WheelView;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class TimePicker extends LinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25555IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25556IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25557Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OOXIXo
    public final TextView f25558Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25559OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25560XO;

    /* renamed from: o00, reason: collision with root package name */
    @oOoXoXO
    public x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> f25561o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25562oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f25563xoXoI;

    /* loaded from: classes12.dex */
    public static final class I0Io extends oIX0oI {
        public I0Io() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.TimePicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            TimePicker.this.f25562oI0IIXIo = i;
            super.onItemSelected(i);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends oIX0oI {
        public II0xO0() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.TimePicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            TimePicker.this.f25555IIXOooo = i;
            super.onItemSelected(i);
        }
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements X0O0I0.I0Io {
        public oIX0oI() {
        }

        @Override // X0O0I0.I0Io
        @CallSuper
        public void onItemSelected(int i) {
            x0xO0oo<Integer, Integer, oXIO0o0XI> mListener = TimePicker.this.getMListener();
            if (mListener != null) {
                mListener.invoke(Integer.valueOf((TimePicker.this.f25555IIXOooo * 12) + TimePicker.this.f25562oI0IIXIo), Integer.valueOf(TimePicker.this.f25559OxxIIOOXO));
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX extends oIX0oI {
        public oxoX() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.TimePicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            TimePicker.this.f25559OxxIIOOXO = i;
            super.onItemSelected(i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public TimePicker(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public final void II0XooXoX(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WheelView);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        float f = obtainStyledAttributes.getFloat(3, 24.0f);
        float f2 = obtainStyledAttributes.getFloat(2, 1.3f);
        boolean z = obtainStyledAttributes.getBoolean(1, false);
        set24Hourly(obtainStyledAttributes.getBoolean(0, com.sma.smartv3.util.xoIox.ooXIXxIX()));
        this.f25560XO.setTextSize(f);
        this.f25560XO.setScaleX(f2);
        this.f25557Oo.setTextSize(f);
        this.f25557Oo.setScaleX(f2);
        this.f25556IXxxXO.setTextSize(f);
        this.f25556IXxxXO.xxIXOIIO();
        this.f25558Oxx0xo.setTextSize(f);
        if (z) {
            this.f25558Oxx0xo.setVisibility(0);
        }
    }

    public final void Oxx0IOOO() {
        String valueOf;
        if (this.f25563xoXoI) {
            this.f25556IXxxXO.setVisibility(8);
            WheelView wheelView = this.f25560XO;
            ArrayList arrayList = new ArrayList(24);
            for (int i = 0; i < 24; i++) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                IIX0o.oO(format, "format(...)");
                arrayList.add(format);
            }
            wheelView.setItems(arrayList);
        } else {
            this.f25556IXxxXO.setVisibility(0);
            this.f25556IXxxXO.xxIXOIIO();
            this.f25556IXxxXO.setItems(CollectionsKt__CollectionsKt.X00IoxXI(getContext().getString(com.sma.smartv3.co_fit.R.string.am), getContext().getString(com.sma.smartv3.co_fit.R.string.pm)));
            this.f25556IXxxXO.setListener(new II0xO0());
            WheelView wheelView2 = this.f25560XO;
            ArrayList arrayList2 = new ArrayList(12);
            for (int i2 = 0; i2 < 12; i2++) {
                if (i2 == 0) {
                    valueOf = com.tencent.connect.common.II0xO0.f26834o0IXXIx;
                } else {
                    valueOf = String.valueOf(i2);
                }
                arrayList2.add(valueOf);
            }
            wheelView2.setItems(arrayList2);
        }
        this.f25560XO.setListener(new I0Io());
        WheelView wheelView3 = this.f25557Oo;
        ArrayList arrayList3 = new ArrayList(60);
        for (int i3 = 0; i3 < 60; i3++) {
            oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
            String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            IIX0o.oO(format2, "format(...)");
            arrayList3.add(format2);
        }
        wheelView3.setItems(arrayList3);
        this.f25557Oo.setListener(new oxoX());
    }

    @oOoXoXO
    public final x0xO0oo<Integer, Integer, oXIO0o0XI> getMListener() {
        return this.f25561o00;
    }

    public final void set24Hourly(boolean z) {
        this.f25563xoXoI = z;
        Oxx0IOOO();
    }

    public final void setMListener(@oOoXoXO x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> x0xo0oo) {
        this.f25561o00 = x0xo0oo;
    }

    public final void setVisibleCount(int i) {
        this.f25560XO.setVisibleCount(i);
        this.f25557Oo.setVisibleCount(i);
        this.f25556IXxxXO.setVisibleCount(i);
    }

    public final void xoIox(int i, int i2) {
        if (this.f25563xoXoI) {
            this.f25560XO.setInitPosition(i);
            this.f25562oI0IIXIo = i;
        } else {
            int i3 = i / 12;
            this.f25556IXxxXO.setInitPosition(i3);
            int i4 = i % 12;
            this.f25560XO.setInitPosition(i4);
            this.f25555IIXOooo = i3;
            this.f25562oI0IIXIo = i4;
        }
        this.f25557Oo.setInitPosition(i2);
        this.f25559OxxIIOOXO = i2;
    }

    public final boolean xxIXOIIO() {
        return this.f25563xoXoI;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public TimePicker(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ TimePicker(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public TimePicker(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25563xoXoI = com.sma.smartv3.util.xoIox.ooXIXxIX();
        oIxOXo.oxoX.f31821II0XooXoX = isInEditMode();
        LayoutInflater.from(context).inflate(com.sma.smartv3.co_fit.R.layout.view_three_pickers, (ViewGroup) this, true);
        View findViewById = findViewById(com.sma.smartv3.co_fit.R.id.wv1);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f25560XO = (WheelView) findViewById;
        View findViewById2 = findViewById(com.sma.smartv3.co_fit.R.id.wv2);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.f25557Oo = (WheelView) findViewById2;
        View findViewById3 = findViewById(com.sma.smartv3.co_fit.R.id.wv3);
        IIX0o.oO(findViewById3, "findViewById(...)");
        this.f25556IXxxXO = (WheelView) findViewById3;
        View findViewById4 = findViewById(com.sma.smartv3.co_fit.R.id.tvColon);
        IIX0o.oO(findViewById4, "findViewById(...)");
        this.f25558Oxx0xo = (TextView) findViewById4;
        II0XooXoX(context, attributeSet);
        Oxx0IOOO();
    }
}
