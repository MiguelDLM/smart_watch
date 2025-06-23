package com.sma.smartv3.view.picker;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import com.google.android.material.timepicker.TimeModel;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.WheelView.WheelView;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class DurationPicker extends LinearLayout {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25522IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25523Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25524Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25525XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @oOoXoXO
    public Oox.oOoXoXO<? super Integer, oXIO0o0XI> f25526oI0IIXIo;

    /* loaded from: classes12.dex */
    public static final class I0Io extends oIX0oI {
        public I0Io() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.DurationPicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            DurationPicker.this.f25524Oxx0xo = i;
            super.onItemSelected(i);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends oIX0oI {
        public II0xO0() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.DurationPicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            DurationPicker.this.f25522IXxxXO = i;
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
            Oox.oOoXoXO<Integer, oXIO0o0XI> mListener = DurationPicker.this.getMListener();
            if (mListener != null) {
                mListener.invoke(Integer.valueOf((DurationPicker.this.f25522IXxxXO * 60) + DurationPicker.this.f25524Oxx0xo));
            }
        }
    }

    @xoIox
    public DurationPicker(@oOoXoXO Context context) {
        this(context, null, 0, 6, null);
    }

    public final void X0o0xo() {
        WheelView wheelView = this.f25525XO;
        ArrayList arrayList = new ArrayList(100);
        for (int i = 0; i < 100; i++) {
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            IIX0o.oO(format, "format(...)");
            arrayList.add(format);
        }
        wheelView.setItems(arrayList);
        wheelView.setListener(new II0xO0());
        WheelView wheelView2 = this.f25523Oo;
        ArrayList arrayList2 = new ArrayList(60);
        for (int i2 = 0; i2 < 60; i2++) {
            oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
            String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
            IIX0o.oO(format2, "format(...)");
            arrayList2.add(format2);
        }
        wheelView2.setItems(arrayList2);
        wheelView2.setListener(new I0Io());
    }

    @oOoXoXO
    public final Oox.oOoXoXO<Integer, oXIO0o0XI> getMListener() {
        return this.f25526oI0IIXIo;
    }

    public final void setDuration(int i) {
        int i2 = i / 60;
        this.f25522IXxxXO = i2;
        this.f25524Oxx0xo = i % 60;
        this.f25525XO.setInitPosition(i2);
        this.f25523Oo.setInitPosition(this.f25524Oxx0xo);
    }

    public final void setMListener(@oOoXoXO Oox.oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
        this.f25526oI0IIXIo = oooxoxo;
    }

    public final void setVisibleCount(int i) {
        this.f25525XO.setVisibleCount(i);
        this.f25523Oo.setVisibleCount(i);
    }

    @xoIox
    public DurationPicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DurationPicker(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public DurationPicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.ooOOo0oXI(context);
        LayoutInflater.from(context).inflate(R.layout.view_duration_pickers, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.wv1);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f25525XO = (WheelView) findViewById;
        View findViewById2 = findViewById(R.id.wv2);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.f25523Oo = (WheelView) findViewById2;
        X0o0xo();
    }
}
