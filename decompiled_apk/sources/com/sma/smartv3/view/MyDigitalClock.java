package com.sma.smartv3.view;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Calendar;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class MyDigitalClock extends TextView {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f25069IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Calendar f25070Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Runnable f25071Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f25072OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f25073XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Handler f25074oI0IIXIo;

    public MyDigitalClock(@OXOo.oOoXoXO Context context) {
        super(context);
        this.f25073XO = com.sma.smartv3.util.xoIox.f24709oo0xXOI0I;
        II0xO0();
    }

    public static final void I0Io(MyDigitalClock this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.f25072OxxIIOOXO) {
            return;
        }
        Calendar calendar = this$0.f25070Oo;
        if (calendar != null) {
            calendar.setTimeInMillis(System.currentTimeMillis() + this$0.f25069IXxxXO);
        }
        CharSequence format = DateFormat.format(this$0.f25073XO, this$0.f25070Oo);
        if (!IIX0o.Oxx0IOOO(this$0.getText().toString(), format)) {
            this$0.setText(format);
            this$0.invalidate();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = 1000;
        long j2 = uptimeMillis + (j - (uptimeMillis % j));
        Handler handler = this$0.f25074oI0IIXIo;
        if (handler != null) {
            Runnable runnable = this$0.f25071Oxx0xo;
            IIX0o.ooOOo0oXI(runnable);
            handler.postAtTime(runnable, j2);
        }
    }

    public final void II0xO0() {
        if (this.f25070Oo == null) {
            this.f25070Oo = Calendar.getInstance();
        }
    }

    @OXOo.oOoXoXO
    public final Calendar getMCalendar() {
        return this.f25070Oo;
    }

    @OXOo.OOXIXo
    public final String getMFormat() {
        return this.f25073XO;
    }

    public final int getMOffset() {
        return this.f25069IXxxXO;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        this.f25072OxxIIOOXO = false;
        super.onAttachedToWindow();
        this.f25074oI0IIXIo = new Handler();
        Runnable runnable = new Runnable() { // from class: com.sma.smartv3.view.ooOOo0oXI
            @Override // java.lang.Runnable
            public final void run() {
                MyDigitalClock.I0Io(MyDigitalClock.this);
            }
        };
        this.f25071Oxx0xo = runnable;
        runnable.run();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f25072OxxIIOOXO = true;
    }

    public final void setMCalendar(@OXOo.oOoXoXO Calendar calendar) {
        this.f25070Oo = calendar;
    }

    public final void setMFormat(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f25073XO = str;
    }

    public final void setMOffset(int i) {
        this.f25069IXxxXO = i;
    }

    public MyDigitalClock(@OXOo.oOoXoXO Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25073XO = com.sma.smartv3.util.xoIox.f24709oo0xXOI0I;
        II0xO0();
    }
}
