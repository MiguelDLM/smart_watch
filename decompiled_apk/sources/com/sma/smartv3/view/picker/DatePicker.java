package com.sma.smartv3.view.picker;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import XO0OX.xoIox;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.view.WheelView.WheelView;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nDatePicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DatePicker.kt\ncom/sma/smartv3/view/picker/DatePicker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
/* loaded from: classes12.dex */
public final class DatePicker extends LinearLayout {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25500IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25501IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25502Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25503Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f25504OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final WheelView f25505XO;

    /* renamed from: o00, reason: collision with root package name */
    @oOoXoXO
    public IXxxXO<? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> f25506o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25507oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f25508xoXoI;

    /* loaded from: classes12.dex */
    public static final class I0Io extends oIX0oI {
        public I0Io() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.DatePicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            DatePicker.this.f25500IIXOooo = i + 1;
            DatePicker.this.oOoXoXO();
            super.onItemSelected(i);
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends oIX0oI {
        public II0xO0() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.DatePicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            DatePicker datePicker = DatePicker.this;
            datePicker.f25504OxxIIOOXO = datePicker.f25507oI0IIXIo + i;
            DatePicker.this.oOoXoXO();
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
            IXxxXO<Integer, Integer, Integer, oXIO0o0XI> mListener = DatePicker.this.getMListener();
            if (mListener != null) {
                mListener.invoke(Integer.valueOf(DatePicker.this.f25504OxxIIOOXO), Integer.valueOf(DatePicker.this.f25500IIXOooo), Integer.valueOf(DatePicker.this.f25508xoXoI));
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX extends oIX0oI {
        public oxoX() {
            super();
        }

        @Override // com.sma.smartv3.view.picker.DatePicker.oIX0oI, X0O0I0.I0Io
        public void onItemSelected(int i) {
            DatePicker.this.f25508xoXoI = i + 1;
            super.onItemSelected(i);
        }
    }

    @xoIox
    public DatePicker(@oOoXoXO Context context) {
        this(context, null, 0, 6, null);
    }

    public final void OOXIXo(int i, int i2) {
        this.f25503Oxx0xo = i;
        this.f25507oI0IIXIo = i2;
        WheelView wheelView = this.f25505XO;
        int i3 = (i - i2) + 1;
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(String.valueOf(this.f25507oI0IIXIo + i4));
        }
        wheelView.setItems(arrayList);
    }

    @oOoXoXO
    public final IXxxXO<Integer, Integer, Integer, oXIO0o0XI> getMListener() {
        return this.f25506o00;
    }

    public final void oOoXoXO() {
        Calendar calendar = Calendar.getInstance();
        IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.XI0IXoo(calendar, this.f25504OxxIIOOXO);
        oOXoIIIo.II0xO0.o00(calendar, this.f25500IIXOooo);
        oOXoIIIo.II0xO0.IXxxXO(calendar, 1);
        IIX0o.oO(calendar, "also(...)");
        int oxoX2 = oOXoIIIo.II0xO0.oxoX(calendar);
        if (this.f25508xoXoI > oxoX2) {
            this.f25508xoXoI = oxoX2;
        }
        this.f25501IXxxXO.setInitPosition(this.f25508xoXoI - 1);
        WheelView wheelView = this.f25501IXxxXO;
        ArrayList arrayList = new ArrayList(oxoX2);
        int i = 0;
        while (i < oxoX2) {
            i++;
            arrayList.add(String.valueOf(i));
        }
        wheelView.setItems(arrayList);
    }

    public final void setMListener(@oOoXoXO IXxxXO<? super Integer, ? super Integer, ? super Integer, oXIO0o0XI> iXxxXO) {
        this.f25506o00 = iXxxXO;
    }

    public final void setVisibleCount(int i) {
        this.f25502Oo.setVisibleCount(i);
        this.f25501IXxxXO.setVisibleCount(i);
        this.f25505XO.setVisibleCount(i);
    }

    public final void xoIox(int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.XI0IXoo(calendar, i);
        oOXoIIIo.II0xO0.o00(calendar, i2);
        oOXoIIIo.II0xO0.IXxxXO(calendar, i3);
        IIX0o.ooOOo0oXI(calendar);
        this.f25504OxxIIOOXO = oOXoIIIo.II0xO0.oO(calendar);
        this.f25500IIXOooo = oOXoIIIo.II0xO0.OOXIXo(calendar);
        this.f25508xoXoI = oOXoIIIo.II0xO0.II0xO0(calendar);
        this.f25505XO.setInitPosition(this.f25504OxxIIOOXO - this.f25507oI0IIXIo);
        this.f25502Oo.setInitPosition(this.f25500IIXOooo - 1);
        oOoXoXO();
    }

    public final void xxIXOIIO() {
        this.f25505XO.xxIXOIIO();
        WheelView wheelView = this.f25505XO;
        int i = (this.f25503Oxx0xo - this.f25507oI0IIXIo) + 1;
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            arrayList.add(String.valueOf(this.f25507oI0IIXIo + i3));
        }
        wheelView.setItems(arrayList);
        this.f25505XO.setListener(new II0xO0());
        WheelView wheelView2 = this.f25502Oo;
        ArrayList arrayList2 = new ArrayList(12);
        while (i2 < 12) {
            i2++;
            arrayList2.add(String.valueOf(i2));
        }
        wheelView2.setItems(arrayList2);
        this.f25502Oo.setListener(new I0Io());
        this.f25501IXxxXO.setListener(new oxoX());
    }

    @xoIox
    public DatePicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DatePicker(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public DatePicker(@oOoXoXO Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.ooOOo0oXI(context);
        Calendar calendar = Calendar.getInstance();
        IIX0o.oO(calendar, "getInstance(...)");
        this.f25503Oxx0xo = oOXoIIIo.II0xO0.oO(calendar);
        this.f25507oI0IIXIo = ScreenUtil.DEFAULT_HEIGHT;
        LayoutInflater.from(context).inflate(R.layout.view_three_pickser2, (ViewGroup) this, true);
        if (!oIxOXo.oxoX.f31821II0XooXoX) {
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (projectManager.OoO() && projectManager.x0XOIxOo() == DateTimeFormat.ddMMyyyy) {
                View findViewById = findViewById(R.id.wv3);
                IIX0o.oO(findViewById, "findViewById(...)");
                this.f25505XO = (WheelView) findViewById;
                View findViewById2 = findViewById(R.id.wv1);
                IIX0o.oO(findViewById2, "findViewById(...)");
                this.f25501IXxxXO = (WheelView) findViewById2;
                View findViewById3 = findViewById(R.id.wv2);
                IIX0o.oO(findViewById3, "findViewById(...)");
                this.f25502Oo = (WheelView) findViewById3;
                xxIXOIIO();
            }
        }
        if (!oIxOXo.oxoX.f31821II0XooXoX) {
            ProjectManager projectManager2 = ProjectManager.f19822oIX0oI;
            if (projectManager2.OoO() && projectManager2.x0XOIxOo() == DateTimeFormat.yyyyMMdd) {
                View findViewById4 = findViewById(R.id.wv1);
                IIX0o.oO(findViewById4, "findViewById(...)");
                this.f25505XO = (WheelView) findViewById4;
                View findViewById5 = findViewById(R.id.wv2);
                IIX0o.oO(findViewById5, "findViewById(...)");
                this.f25502Oo = (WheelView) findViewById5;
                View findViewById6 = findViewById(R.id.wv3);
                IIX0o.oO(findViewById6, "findViewById(...)");
                this.f25501IXxxXO = (WheelView) findViewById6;
                xxIXOIIO();
            }
        }
        View findViewById7 = findViewById(R.id.wv3);
        IIX0o.oO(findViewById7, "findViewById(...)");
        this.f25505XO = (WheelView) findViewById7;
        View findViewById8 = findViewById(R.id.wv1);
        IIX0o.oO(findViewById8, "findViewById(...)");
        this.f25502Oo = (WheelView) findViewById8;
        View findViewById9 = findViewById(R.id.wv2);
        IIX0o.oO(findViewById9, "findViewById(...)");
        this.f25501IXxxXO = (WheelView) findViewById9;
        xxIXOIIO();
    }
}
