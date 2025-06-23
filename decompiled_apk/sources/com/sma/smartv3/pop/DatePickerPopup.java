package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.view.picker.DatePicker;
import java.util.Calendar;

/* loaded from: classes12.dex */
public final class DatePickerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21230II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f21231OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f21232oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f21233ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.IXxxXO<? super Integer, ? super Integer, ? super Integer, Boolean> f21234x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f21235xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final DatePicker f21236xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerPopup(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.OoO() && projectManager.x0XOIxOo() == DateTimeFormat.ddMMyyyy) {
            LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_date_picker2, xxIXOIIO());
        } else if (projectManager.OoO() && projectManager.x0XOIxOo() == DateTimeFormat.yyyyMMdd) {
            LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_date_picker3, xxIXOIIO());
        } else {
            LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_date_picker, xxIXOIIO());
        }
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21230II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.date_picker);
        DatePicker datePicker = (DatePicker) findViewById2;
        datePicker.setVisibleCount(3);
        datePicker.setMListener(new Oox.IXxxXO<Integer, Integer, Integer, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.pop.DatePickerPopup$1$1
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Integer num, Integer num2, Integer num3) {
                invoke(num.intValue(), num2.intValue(), num3.intValue());
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, int i2, int i3) {
                DatePickerPopup.this.f21235xoIox = i;
                DatePickerPopup.this.f21231OOXIXo = i2;
                DatePickerPopup.this.f21232oOoXoXO = i3;
            }
        });
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "apply(...)");
        this.f21236xxIXOIIO = datePicker;
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.OxxIIOOXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DatePickerPopup.XI0IXoo(DatePickerPopup.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.IIXOooo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DatePickerPopup.XIxXXX0x0(DatePickerPopup.this, view);
            }
        });
    }

    public static final void XI0IXoo(DatePickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void XIxXXX0x0(DatePickerPopup this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.IXxxXO<? super Integer, ? super Integer, ? super Integer, Boolean> iXxxXO = this$0.f21234x0XOIxOo;
        if (iXxxXO != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(iXxxXO);
            if (!iXxxXO.invoke(Integer.valueOf(this$0.f21235xoIox), Integer.valueOf(this$0.f21231OOXIXo), Integer.valueOf(this$0.f21232oOoXoXO)).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    @OXOo.oOoXoXO
    public final Oox.IXxxXO<Integer, Integer, Integer, Boolean> IIX0o() {
        return this.f21234x0XOIxOo;
    }

    public final void IoOoX(long j) {
        Calendar calendar = Calendar.getInstance();
        if (j != 0) {
            calendar.setTimeInMillis(j);
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        this.f21235xoIox = oOXoIIIo.II0xO0.oO(calendar);
        this.f21231OOXIXo = oOXoIIIo.II0xO0.OOXIXo(calendar);
        int II0xO02 = oOXoIIIo.II0xO0.II0xO0(calendar);
        this.f21232oOoXoXO = II0xO02;
        this.f21236xxIXOIIO.xoIox(this.f21235xoIox, this.f21231OOXIXo, II0xO02);
    }

    public final void oo(int i) {
        this.f21233ooOOo0oXI = i;
        this.f21230II0XooXoX.setText(i);
    }

    public final void oo0xXOI0I(@OXOo.oOoXoXO Oox.IXxxXO<? super Integer, ? super Integer, ? super Integer, Boolean> iXxxXO) {
        this.f21234x0XOIxOo = iXxxXO;
    }

    public final int ooXIXxIX() {
        return this.f21233ooOOo0oXI;
    }

    public final void xI(int i, int i2, int i3) {
        this.f21235xoIox = i;
        this.f21231OOXIXo = i2;
        this.f21232oOoXoXO = i3;
        this.f21236xxIXOIIO.xoIox(i, i2, i3);
    }
}
