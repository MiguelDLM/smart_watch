package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.CalendarView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes12.dex */
public final class xoIox extends OOOI.oxoX implements CalendarView.oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21532II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f21533OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    public int f21534oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public Calendar f21535oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CalendarView f21536ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.oOoXoXO<? super Calendar, Boolean> f21537x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ImageView f21538xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ImageView f21539xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xoIox(@OXOo.OOXIXo Activity activity) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        x0xO0oo(false);
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_calendar_view, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.tv_title_data);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21532II0XooXoX = (TextView) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.tv_last_month);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById2;
        this.f21539xxIXOIIO = imageView;
        View findViewById3 = xxIXOIIO().findViewById(R.id.tv_next_month);
        kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
        ImageView imageView2 = (ImageView) findViewById3;
        this.f21538xoIox = imageView2;
        View findViewById4 = xxIXOIIO().findViewById(R.id.pop_calendar_view);
        kotlin.jvm.internal.IIX0o.oO(findViewById4, "findViewById(...)");
        CalendarView calendarView = (CalendarView) findViewById4;
        this.f21536ooOOo0oXI = calendarView;
        Calendar calendar = Calendar.getInstance();
        kotlin.jvm.internal.IIX0o.oO(calendar, "getInstance(...)");
        this.f21535oOoXoXO = calendar;
        calendarView.setOnDateSelectedListener(this);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xoIox.xxX(xoIox.this, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xoIox.XxX0x0xxx(xoIox.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.II0XooXoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xoIox.xXxxox0I(xoIox.this, view);
            }
        });
        xxIXOIIO().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.xxIXOIIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xoIox.IIX0o(xoIox.this, view);
            }
        });
        this.f21533OOXIXo = ooXIXxIX(this.f21535oOoXoXO, "yyyy-MM-dd");
    }

    public static final void IIX0o(xoIox this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Oox.oOoXoXO<? super Calendar, Boolean> oooxoxo = this$0.f21537x0XOIxOo;
        if (oooxoxo != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(oooxoxo);
            if (!oooxoxo.invoke(this$0.f21535oOoXoXO).booleanValue()) {
                return;
            }
        }
        this$0.dismiss();
    }

    public static final void XxX0x0xxx(xoIox this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.f21536ooOOo0oXI.Oxx0IOOO();
    }

    public static final void xXxxox0I(xoIox this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void xxX(xoIox this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.f21536ooOOo0oXI.XO();
    }

    @Override // com.sma.smartv3.view.CalendarView.oIX0oI
    public void I0Io(@OXOo.oOoXoXO String str) {
        ToastUtils.showLong(str, new Object[0]);
    }

    @Override // com.sma.smartv3.view.CalendarView.oIX0oI
    public void II0xO0(@OXOo.oOoXoXO Calendar calendar, int i, int i2, int i3) {
        TextView textView = this.f21532II0XooXoX;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        textView.setText(ooXIXxIX(calendar, "yyyy-MM"));
        this.f21535oOoXoXO = calendar;
        this.f21533OOXIXo = ooXIXxIX(calendar, "yyyy-MM-dd");
    }

    public final void IoOoX(@OXOo.oOoXoXO Oox.oOoXoXO<? super Calendar, Boolean> oooxoxo) {
        this.f21537x0XOIxOo = oooxoxo;
    }

    @Override // com.sma.smartv3.view.CalendarView.oIX0oI
    public void oIX0oI(@OXOo.oOoXoXO Calendar calendar, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(calendar);
        this.f21535oOoXoXO = calendar;
        this.f21533OOXIXo = ooXIXxIX(calendar, "yyyy-MM-dd");
    }

    public final void oOXoIIIo(int i) {
        this.f21534oO = i;
        this.f21532II0XooXoX.setText(i);
    }

    public final void oo(@OXOo.OOXIXo Calendar calendar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(calendar, "calendar");
        this.f21536ooOOo0oXI.setDate(calendar);
    }

    public final int oo0xXOI0I() {
        return this.f21534oO;
    }

    public final String ooXIXxIX(Calendar calendar, String str) {
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<Calendar, Boolean> xI() {
        return this.f21537x0XOIxOo;
    }
}
