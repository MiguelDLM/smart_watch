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
public final class IntValuePicker extends LinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OOXIXo
    public String f25544IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25545IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final TextView f25546Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25547Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f25548OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25549XO;

    /* renamed from: o00, reason: collision with root package name */
    @oOoXoXO
    public Oox.oOoXoXO<? super Integer, oXIO0o0XI> f25550o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25551oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f25552xoXoI;

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends oIX0oI {
        public II0xO0() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.IntValuePicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            IntValuePicker intValuePicker = IntValuePicker.this;
            intValuePicker.f25545IXxxXO = intValuePicker.oxoX(i);
            IntValuePicker.this.XO(i);
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
            Oox.oOoXoXO<Integer, oXIO0o0XI> mListener = IntValuePicker.this.getMListener();
            if (mListener != null) {
                mListener.invoke(Integer.valueOf(IntValuePicker.this.oxoX(i)));
            }
        }
    }

    @xoIox
    public IntValuePicker(@oOoXoXO Context context) {
        this(context, null, 0, 6, null);
    }

    public final void I0Io() {
        this.f25549XO.setListener(new II0xO0());
    }

    public final int Oxx0IOOO(int i) {
        if (this.f25548OxxIIOOXO) {
            if (i == 0) {
                return 0;
            }
            return (i - this.f25547Oxx0xo) + 1;
        }
        return i - this.f25547Oxx0xo;
    }

    public final void X0o0xo(int i, int i2) {
        int i3;
        String valueOf;
        this.f25547Oxx0xo = i;
        this.f25551oI0IIXIo = i2;
        boolean z = this.f25548OxxIIOOXO;
        if (z && i == 0) {
            throw new IllegalArgumentException("when setUseZero is true, the min is not zero!");
        }
        WheelView wheelView = this.f25549XO;
        int i4 = i2 - i;
        if (z) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        int i5 = i4 + i3;
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.f25548OxxIIOOXO) {
                if (i6 == 0) {
                    valueOf = this.f25544IIXOooo;
                } else {
                    valueOf = String.valueOf((i6 - 1) + this.f25547Oxx0xo);
                }
            } else {
                valueOf = String.valueOf(this.f25547Oxx0xo + i6);
            }
            arrayList.add(valueOf);
        }
        wheelView.setItems(arrayList);
    }

    public final void XO(int i) {
        if (this.f25548OxxIIOOXO) {
            TextView textView = this.f25546Oo;
            int i2 = 8;
            if (this.f25552xoXoI != 0 && i != 0) {
                i2 = 0;
            }
            textView.setVisibility(i2);
        }
    }

    @oOoXoXO
    public final Oox.oOoXoXO<Integer, oXIO0o0XI> getMListener() {
        return this.f25550o00;
    }

    public final int oxoX(int i) {
        int i2;
        if (this.f25548OxxIIOOXO) {
            if (i == 0) {
                return 0;
            }
            i--;
            i2 = this.f25547Oxx0xo;
        } else {
            i2 = this.f25547Oxx0xo;
        }
        return i + i2;
    }

    public final void setMListener(@oOoXoXO Oox.oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
        this.f25550o00 = oooxoxo;
    }

    public final void setUnit(int i) {
        this.f25552xoXoI = i;
        if (i == 0) {
            this.f25546Oo.setVisibility(8);
        } else {
            this.f25546Oo.setVisibility(0);
            this.f25546Oo.setText(i);
        }
    }

    public final void setUseZero(boolean z) {
        this.f25548OxxIIOOXO = z;
    }

    public final void setValuse(int i) {
        this.f25545IXxxXO = i;
        XO(i);
        this.f25549XO.setInitPosition(Oxx0IOOO(this.f25545IXxxXO));
    }

    public final void setVisibleCount(int i) {
        this.f25549XO.setVisibleCount(i);
    }

    public final void setZeroText(@OOXIXo String text) {
        IIX0o.x0xO0oo(text, "text");
        this.f25544IIXOooo = text;
    }

    @xoIox
    public IntValuePicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ IntValuePicker(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public IntValuePicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.ooOOo0oXI(context);
        this.f25544IIXOooo = "0";
        LayoutInflater.from(context).inflate(R.layout.view_value_picker, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.wv1);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f25549XO = (WheelView) findViewById;
        View findViewById2 = findViewById(R.id.tv_picker_unit);
        IIX0o.oO(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f25546Oo = textView;
        textView.setVisibility(8);
        I0Io();
    }
}
