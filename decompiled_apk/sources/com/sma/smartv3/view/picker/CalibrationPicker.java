package com.sma.smartv3.view.picker;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
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
import com.sma.smartv3.view.WheelView.WheelView;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nCalibrationPicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CalibrationPicker.kt\ncom/sma/smartv3/view/picker/CalibrationPicker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,77:1\n1#2:78\n*E\n"})
/* loaded from: classes12.dex */
public final class CalibrationPicker extends LinearLayout {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25491IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25492Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25493Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @oOoXoXO
    public x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> f25494OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25495XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25496oI0IIXIo;

    /* loaded from: classes12.dex */
    public static final class I0Io extends oIX0oI {
        public I0Io() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.CalibrationPicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            CalibrationPicker calibrationPicker = CalibrationPicker.this;
            calibrationPicker.f25493Oxx0xo = calibrationPicker.f25496oI0IIXIo + i;
            super.onItemSelected(i);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends oIX0oI {
        public II0xO0() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.CalibrationPicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            CalibrationPicker calibrationPicker = CalibrationPicker.this;
            calibrationPicker.f25491IXxxXO = calibrationPicker.f25496oI0IIXIo + i;
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
            x0xO0oo<Integer, Integer, oXIO0o0XI> mListener = CalibrationPicker.this.getMListener();
            if (mListener != null) {
                mListener.invoke(Integer.valueOf(CalibrationPicker.this.f25491IXxxXO), Integer.valueOf(CalibrationPicker.this.f25493Oxx0xo));
            }
        }
    }

    @xoIox
    public CalibrationPicker(@oOoXoXO Context context) {
        this(context, null, 0, 6, null);
    }

    public final void Oxx0IOOO(int i, int i2) {
        this.f25491IXxxXO = i;
        this.f25493Oxx0xo = i2;
        this.f25495XO.setInitPosition(i - this.f25496oI0IIXIo);
        this.f25492Oo.setInitPosition(i2 - this.f25496oI0IIXIo);
    }

    public final void XO() {
        WheelView wheelView = this.f25495XO;
        ArrayList arrayList = new ArrayList(130);
        for (int i = 0; i < 130; i++) {
            arrayList.add(String.valueOf(this.f25496oI0IIXIo + i));
        }
        wheelView.setItems(arrayList);
        this.f25495XO.setListener(new II0xO0());
        WheelView wheelView2 = this.f25492Oo;
        ArrayList arrayList2 = new ArrayList(130);
        for (int i2 = 0; i2 < 130; i2++) {
            arrayList2.add(String.valueOf(this.f25496oI0IIXIo + i2));
        }
        wheelView2.setItems(arrayList2);
        this.f25492Oo.setListener(new I0Io());
    }

    @oOoXoXO
    public final x0xO0oo<Integer, Integer, oXIO0o0XI> getMListener() {
        return this.f25494OxxIIOOXO;
    }

    public final void setMListener(@oOoXoXO x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> x0xo0oo) {
        this.f25494OxxIIOOXO = x0xo0oo;
    }

    public final void setVisibleCount(int i) {
        this.f25492Oo.setVisibleCount(i);
        this.f25495XO.setVisibleCount(i);
    }

    @xoIox
    public CalibrationPicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CalibrationPicker(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public CalibrationPicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.ooOOo0oXI(context);
        this.f25496oI0IIXIo = 65;
        LayoutInflater.from(context).inflate(R.layout.view_two_calibration, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.wv1);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f25495XO = (WheelView) findViewById;
        View findViewById2 = findViewById(R.id.wv2);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.f25492Oo = (WheelView) findViewById2;
        XO();
    }
}
