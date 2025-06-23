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
import android.widget.TextView;
import androidx.annotation.CallSuper;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.WheelView.WheelView;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class WeightPicker extends LinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f25579IIXOooo = new oIX0oI(null);

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f25580O0xOxO = 44;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f25581OxI = 440;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f25582o00 = 20;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f25583xoXoI = 150;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public final TextView f25584IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25585Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OOXIXo
    public final int[] f25586Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @oOoXoXO
    public Oox.oOoXoXO<? super Float, oXIO0o0XI> f25587OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25588XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25589oI0IIXIo;

    /* loaded from: classes12.dex */
    public static final class I0Io extends II0xO0 {
        public I0Io() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.WeightPicker.II0xO0, X0O0I0.I0Io
        public void onItemSelected(int i) {
            WeightPicker.this.f25586Oxx0xo[0] = i;
            super.onItemSelected(i);
        }
    }

    /* loaded from: classes12.dex */
    public class II0xO0 implements X0O0I0.I0Io {
        public II0xO0() {
        }

        @Override // X0O0I0.I0Io
        @CallSuper
        public void onItemSelected(int i) {
            if (WeightPicker.this.f25589oI0IIXIo == 0) {
                Oox.oOoXoXO<Float, oXIO0o0XI> mListener = WeightPicker.this.getMListener();
                if (mListener != null) {
                    mListener.invoke(Float.valueOf(Xx000oIo.XO.Oxx0IOOO(WeightPicker.this.f25586Oxx0xo[0] + 20, WeightPicker.this.f25586Oxx0xo[1], WeightPicker.this.f25589oI0IIXIo)));
                    return;
                }
                return;
            }
            if (WeightPicker.this.f25586Oxx0xo[1] == 10) {
                WeightPicker.this.f25586Oxx0xo[1] = 0;
            }
            Oox.oOoXoXO<Float, oXIO0o0XI> mListener2 = WeightPicker.this.getMListener();
            if (mListener2 != null) {
                mListener2.invoke(Float.valueOf(Xx000oIo.XO.Oxx0IOOO(WeightPicker.this.f25586Oxx0xo[0] + 44, WeightPicker.this.f25586Oxx0xo[1], WeightPicker.this.f25589oI0IIXIo)));
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX extends II0xO0 {
        public oxoX() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.WeightPicker.II0xO0, X0O0I0.I0Io
        public void onItemSelected(int i) {
            WeightPicker.this.f25586Oxx0xo[1] = i;
            super.onItemSelected(i);
        }
    }

    @xoIox
    public WeightPicker(@oOoXoXO Context context) {
        this(context, null, 0, 6, null);
    }

    public final void I0Io() {
        this.f25588XO.setListener(new I0Io());
        this.f25585Oo.setListener(new oxoX());
    }

    @oOoXoXO
    public final Oox.oOoXoXO<Float, oXIO0o0XI> getMListener() {
        return this.f25587OxxIIOOXO;
    }

    public final void setMListener(@oOoXoXO Oox.oOoXoXO<? super Float, oXIO0o0XI> oooxoxo) {
        this.f25587OxxIIOOXO = oooxoxo;
    }

    public final void setUnit(int i) {
        this.f25589oI0IIXIo = i;
        WheelView wheelView = this.f25585Oo;
        ArrayList arrayList = new ArrayList(10);
        int i2 = 0;
        for (int i3 = 0; i3 < 10; i3++) {
            StringBuilder sb = new StringBuilder();
            sb.append('.');
            sb.append(i3);
            arrayList.add(sb.toString());
        }
        wheelView.setItems(arrayList);
        if (i == 0) {
            WheelView wheelView2 = this.f25588XO;
            ArrayList arrayList2 = new ArrayList(131);
            while (i2 < 131) {
                arrayList2.add(String.valueOf(i2 + 20));
                i2++;
            }
            wheelView2.setItems(arrayList2);
            this.f25584IXxxXO.setText(R.string.kg);
            return;
        }
        WheelView wheelView3 = this.f25588XO;
        ArrayList arrayList3 = new ArrayList(397);
        while (i2 < 397) {
            arrayList3.add(String.valueOf(i2 + 44));
            i2++;
        }
        wheelView3.setItems(arrayList3);
        this.f25584IXxxXO.setText(R.string.lbs);
    }

    public final void setVisibleCount(int i) {
        this.f25588XO.setVisibleCount(i);
        this.f25585Oo.setVisibleCount(i);
    }

    public final void setWeight(float f) {
        int i;
        int[] II0XooXoX2 = Xx000oIo.XO.II0XooXoX(f, this.f25589oI0IIXIo);
        if (this.f25589oI0IIXIo == 0) {
            int[] iArr = this.f25586Oxx0xo;
            iArr[0] = II0XooXoX2[0] - 20;
            iArr[1] = II0XooXoX2[1];
        } else {
            int i2 = II0XooXoX2[1];
            if (i2 == 10) {
                i2 = 0;
                i = 1;
            } else {
                i = 0;
            }
            int[] iArr2 = this.f25586Oxx0xo;
            iArr2[0] = (II0XooXoX2[0] - 44) + i;
            iArr2[1] = i2;
        }
        this.f25588XO.setInitPosition(this.f25586Oxx0xo[0]);
        this.f25585Oo.setInitPosition(this.f25586Oxx0xo[1]);
    }

    @xoIox
    public WeightPicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ WeightPicker(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public WeightPicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.ooOOo0oXI(context);
        this.f25586Oxx0xo = new int[2];
        LayoutInflater.from(context).inflate(R.layout.view_weight_picker, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.wv1);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f25588XO = (WheelView) findViewById;
        View findViewById2 = findViewById(R.id.wv2);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.f25585Oo = (WheelView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_picker_unit);
        IIX0o.oO(findViewById3, "findViewById(...)");
        this.f25584IXxxXO = (TextView) findViewById3;
        I0Io();
    }
}
