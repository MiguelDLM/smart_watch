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
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.WheelView.WheelView;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import kotlin.text.XIxXXX0x0;

/* loaded from: classes12.dex */
public final class HeightPicker extends LinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f25530IIXOooo = new oIX0oI(null);

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f25531O0xOxO = 3;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f25532OxI = 7;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f25533o00;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f25534xoXoI = 218;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public final TextView f25535IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25536Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OOXIXo
    public final int[] f25537Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @oOoXoXO
    public Oox.oOoXoXO<? super Float, oXIO0o0XI> f25538OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25539XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25540oI0IIXIo;

    /* loaded from: classes12.dex */
    public static final class I0Io extends II0xO0 {
        public I0Io() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.HeightPicker.II0xO0, X0O0I0.I0Io
        public void onItemSelected(int i) {
            HeightPicker.this.f25537Oxx0xo[0] = i;
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
            if (HeightPicker.this.f25540oI0IIXIo == 0) {
                Oox.oOoXoXO<Float, oXIO0o0XI> mListener = HeightPicker.this.getMListener();
                if (mListener != null) {
                    mListener.invoke(Float.valueOf(HeightPicker.this.f25537Oxx0xo[0] + HeightPicker.f25533o00));
                    return;
                }
                return;
            }
            Oox.oOoXoXO<Float, oXIO0o0XI> mListener2 = HeightPicker.this.getMListener();
            if (mListener2 != null) {
                mListener2.invoke(Float.valueOf(Xx000oIo.XO.II0xO0(HeightPicker.this.f25537Oxx0xo[0] + 3, HeightPicker.this.f25537Oxx0xo[1])));
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

        @Override // com.sma.smartv3.view.picker.HeightPicker.II0xO0, X0O0I0.I0Io
        public void onItemSelected(int i) {
            HeightPicker.this.f25537Oxx0xo[1] = i;
            super.onItemSelected(i);
        }
    }

    static {
        int XI0IXoo2;
        if (oIxOXo.oxoX.f31821II0XooXoX) {
            XI0IXoo2 = 108;
        } else {
            XI0IXoo2 = ProjectManager.f19822oIX0oI.XI0IXoo();
        }
        f25533o00 = XI0IXoo2;
    }

    @xoIox
    public HeightPicker(@oOoXoXO Context context) {
        this(context, null, 0, 6, null);
    }

    @oOoXoXO
    public final Oox.oOoXoXO<Float, oXIO0o0XI> getMListener() {
        return this.f25538OxxIIOOXO;
    }

    public final void oxoX() {
        this.f25539XO.setListener(new I0Io());
        this.f25536Oo.setListener(new oxoX());
    }

    public final void setHeight(float f) {
        if (this.f25540oI0IIXIo == 0) {
            this.f25537Oxx0xo[0] = oOIx.oxoX.xOoOIoI(f - f25533o00);
            this.f25539XO.setInitPosition(this.f25537Oxx0xo[0]);
            return;
        }
        int[] oIX0oI2 = Xx000oIo.XO.oIX0oI(f);
        int[] iArr = this.f25537Oxx0xo;
        int i = oIX0oI2[0] - 3;
        iArr[0] = i;
        iArr[1] = oIX0oI2[1];
        this.f25539XO.setInitPosition(i);
        this.f25536Oo.setInitPosition(this.f25537Oxx0xo[1]);
    }

    public final void setMListener(@oOoXoXO Oox.oOoXoXO<? super Float, oXIO0o0XI> oooxoxo) {
        this.f25538OxxIIOOXO = oooxoxo;
    }

    public final void setUnit(int i) {
        this.f25540oI0IIXIo = i;
        if (i == 0) {
            WheelView wheelView = this.f25539XO;
            int i2 = 219 - f25533o00;
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(String.valueOf(f25533o00 + i3));
            }
            wheelView.setItems(arrayList);
            this.f25539XO.xxIXOIIO();
            this.f25536Oo.setVisibility(8);
            this.f25535IXxxXO.setVisibility(0);
            return;
        }
        WheelView wheelView2 = this.f25539XO;
        ArrayList arrayList2 = new ArrayList(5);
        for (int i4 = 0; i4 < 5; i4++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i4 + 3);
            sb.append(XIxXXX0x0.f29528IIX0o);
            arrayList2.add(sb.toString());
        }
        wheelView2.setItems(arrayList2);
        this.f25539XO.xxIXOIIO();
        WheelView wheelView3 = this.f25536Oo;
        ArrayList arrayList3 = new ArrayList(12);
        for (int i5 = 0; i5 < 12; i5++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i5);
            sb2.append(XIxXXX0x0.f29557ooXIXxIX);
            arrayList3.add(sb2.toString());
        }
        wheelView3.setItems(arrayList3);
        this.f25536Oo.xxIXOIIO();
        this.f25536Oo.setVisibility(0);
        this.f25535IXxxXO.setVisibility(8);
    }

    public final void setVisibleCount(int i) {
        this.f25539XO.setVisibleCount(i);
        this.f25536Oo.setVisibleCount(i);
    }

    @xoIox
    public HeightPicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ HeightPicker(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public HeightPicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.ooOOo0oXI(context);
        this.f25537Oxx0xo = new int[2];
        LayoutInflater.from(context).inflate(R.layout.view_height_picker, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.wv1);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.f25539XO = (WheelView) findViewById;
        View findViewById2 = findViewById(R.id.wv2);
        IIX0o.oO(findViewById2, "findViewById(...)");
        this.f25536Oo = (WheelView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_picker_unit);
        IIX0o.oO(findViewById3, "findViewById(...)");
        this.f25535IXxxXO = (TextView) findViewById3;
        oxoX();
    }
}
