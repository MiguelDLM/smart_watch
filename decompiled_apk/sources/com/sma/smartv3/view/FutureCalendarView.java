package com.sma.smartv3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.xxIO;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public final class FutureCalendarView extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    @OXOo.oOoXoXO
    public oIX0oI f24910IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f24911IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24912IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public final int f24913O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Context f24914Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f24915OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final int f24916Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f24917OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Date f24918X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public boolean f24919XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Calendar f24920XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Calendar f24921XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public final int f24922o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Rect f24923oI0IIXIo;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public final LinearLayout.LayoutParams f24924xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f24925xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Calendar f24926xxX;

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void oIX0oI(@OXOo.oOoXoXO Calendar calendar, int i, int i2, int i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public FutureCalendarView(@OXOo.OOXIXo Context mContext) {
        this(mContext, null, 0, 6, null);
        IIX0o.x0xO0oo(mContext, "mContext");
    }

    private final int II0xO0(int i) {
        return xxoXO.I0Io.II0xO0(i);
    }

    private final int oIX0oI(float f, float f2) {
        return ((((int) (f2 / this.f24922o00)) - 1) * 7) + ((int) (f / this.f24925xoXoI));
    }

    public final void I0Io(boolean z) {
        this.f24919XI0IXoo = z;
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(@OXOo.OOXIXo MotionEvent event) {
        int oIX0oI2;
        IIX0o.x0xO0oo(event, "event");
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        if (action == 0 && (oIX0oI2 = oIX0oI(x, y)) >= 0 && oIX0oI2 < this.f24915OxI * 7 && this.f24910IIX0o != null) {
            this.f24920XIxXXX0x0.setTimeInMillis(this.f24926xxX.getTimeInMillis() + (oIX0oI2 * 86400 * 1000));
            int oO2 = oOXoIIIo.II0xO0.oO(this.f24920XIxXXX0x0);
            int xoIox2 = oOXoIIIo.II0xO0.xoIox(this.f24920XIxXXX0x0);
            int II0xO02 = oOXoIIIo.II0xO0.II0xO0(this.f24920XIxXXX0x0) + 1;
            oOXoIIIo.II0xO0.oI0IIXIo(this.f24920XIxXXX0x0, 0);
            oOXoIIIo.II0xO0.IIXOooo(this.f24920XIxXXX0x0, 0);
            oOXoIIIo.II0xO0.O0xOxO(this.f24920XIxXXX0x0, 0);
            oOXoIIIo.II0xO0.OxxIIOOXO(this.f24920XIxXXX0x0, 0);
            oIX0oI oix0oi = this.f24910IIX0o;
            IIX0o.ooOOo0oXI(oix0oi);
            oix0oi.oIX0oI(this.f24920XIxXXX0x0, oO2, xoIox2, II0xO02);
            invalidate();
        }
        return true;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f24918X0IIOO == null) {
            Calendar calendar = Calendar.getInstance();
            IIX0o.oO(calendar, "getInstance(...)");
            setDate(calendar);
        }
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        int II0xO02;
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        LinearLayout.LayoutParams layoutParams = this.f24924xXxxox0I;
        layoutParams.width = this.f24917OxxIIOOXO;
        layoutParams.height = this.f24911IIXOooo;
        setLayoutParams(layoutParams);
        int i = this.f24915OxI * 7;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            this.f24921XxX0x0xxx.setTimeInMillis(this.f24926xxX.getTimeInMillis() + (86400 * i3 * 1000));
            if (this.f24919XI0IXoo) {
                II0xO02 = com.sma.smartv3.util.xoIox.x0XOIxOo(this.f24921XxX0x0xxx.getTimeInMillis(), i2, 2, null).XO();
            } else {
                II0xO02 = oOXoIIIo.II0xO0.II0xO0(this.f24921XxX0x0xxx);
            }
            int i5 = i3 % 7;
            int i6 = (i3 / 7) + 1;
            if (oOXoIIIo.II0xO0.oO(this.f24921XxX0x0xxx) == oOXoIIIo.II0xO0.oO(this.f24920XIxXXX0x0) && oOXoIIIo.II0xO0.xoIox(this.f24921XxX0x0xxx) == oOXoIIIo.II0xO0.xoIox(this.f24920XIxXXX0x0) && oOXoIIIo.II0xO0.II0xO0(this.f24921XxX0x0xxx) == oOXoIIIo.II0xO0.II0xO0(this.f24920XIxXXX0x0)) {
                this.f24912IXxxXO.setColor(this.f24916Oxx0xo);
                canvas.drawCircle((float) ((i5 + 0.5d) * this.f24925xoXoI), (this.f24913O0xOxO + (this.f24922o00 * i6)) - (this.f24923oI0IIXIo.height() / 2), this.f24912IXxxXO.getTextSize(), this.f24912IXxxXO);
                this.f24912IXxxXO.setColor(xxIO.II0xO0(this.f24914Oo, R.color.light));
                i4 = i5;
            } else {
                this.f24912IXxxXO.setColor(-7829368);
            }
            canvas.drawText(II0xO02 + "", (float) ((i5 + 0.5d) * this.f24925xoXoI), this.f24913O0xOxO + (i6 * this.f24922o00), this.f24912IXxxXO);
            i3++;
            i2 = 0;
        }
        for (int i7 = 0; i7 < 7; i7++) {
            if (i4 == i7) {
                this.f24912IXxxXO.setColor(this.f24916Oxx0xo);
            } else {
                this.f24912IXxxXO.setColor(xxIO.II0xO0(this.f24914Oo, R.color.text_color));
            }
            String upperCase = com.sma.smartv3.util.xoIox.XIxXXX0x0(System.currentTimeMillis(), i7).XO().toUpperCase(Locale.ROOT);
            IIX0o.oO(upperCase, "toUpperCase(...)");
            int i8 = this.f24925xoXoI;
            canvas.drawText(upperCase, (i8 / 2) + (i8 * i7), this.f24913O0xOxO, this.f24912IXxxXO);
        }
        this.f24912IXxxXO.setColor(-7829368);
        int i9 = this.f24922o00;
        canvas.drawLine(0.0f, i9, this.f24917OxxIIOOXO, i9, this.f24912IXxxXO);
        this.f24912IXxxXO.setStrokeWidth(SizeUtils.dp2px(2.0f));
        this.f24912IXxxXO.setColor(this.f24916Oxx0xo);
        int i10 = this.f24925xoXoI;
        float f = i10 * 0.5f;
        float f2 = (i4 * i10) + ((i10 - f) / 2.0f);
        int i11 = this.f24922o00;
        float f3 = 1;
        canvas.drawLine(f2, i11 - f3, f2 + f, i11 - f3, this.f24912IXxxXO);
        this.f24912IXxxXO.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        this.f24917OxxIIOOXO = measuredWidth;
        this.f24925xoXoI = measuredWidth / 7;
    }

    public final void oxoX(int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2, i3);
        Date time = calendar.getTime();
        IIX0o.oO(time, "getTime(...)");
        setDate(time);
    }

    public final void setDate(@OXOo.OOXIXo Calendar cal) {
        IIX0o.x0xO0oo(cal, "cal");
        Date time = cal.getTime();
        IIX0o.oO(time, "getTime(...)");
        setDate(time);
    }

    public final void setOnDateSelectedListener(@OXOo.oOoXoXO oIX0oI oix0oi) {
        this.f24910IIX0o = oix0oi;
    }

    public final void setRow(int i) {
        this.f24915OxI = i;
        this.f24911IIXOooo = this.f24922o00 * i;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public FutureCalendarView(@OXOo.OOXIXo Context mContext, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(mContext, "mContext");
    }

    public final void setDate(@OXOo.OOXIXo Date data) {
        IIX0o.x0xO0oo(data, "data");
        this.f24918X0IIOO = data;
        this.f24920XIxXXX0x0.setTime(data);
        this.f24926xxX.setTime(data);
        this.f24911IIXOooo = this.f24922o00 * this.f24915OxI;
        invalidate();
    }

    public /* synthetic */ FutureCalendarView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public FutureCalendarView(@OXOo.OOXIXo Context mContext, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        IIX0o.x0xO0oo(mContext, "mContext");
        this.f24914Oo = mContext;
        Paint paint = new Paint();
        this.f24912IXxxXO = paint;
        Rect rect = new Rect();
        this.f24923oI0IIXIo = rect;
        this.f24915OxI = 2;
        Calendar calendar = Calendar.getInstance();
        IIX0o.oO(calendar, "getInstance(...)");
        this.f24920XIxXXX0x0 = calendar;
        Calendar calendar2 = Calendar.getInstance();
        IIX0o.oO(calendar2, "getInstance(...)");
        this.f24926xxX = calendar2;
        Calendar calendar3 = Calendar.getInstance();
        IIX0o.oO(calendar3, "getInstance(...)");
        this.f24921XxX0x0xxx = calendar3;
        this.f24924xXxxox0I = new LinearLayout.LayoutParams(0, 0);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setTextSize(SizeUtils.sp2px(14.0f));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.getTextBounds("日日日", 0, 1, rect);
        paint.setStrokeWidth(1.0f);
        int height = (int) (rect.height() * 3.8d);
        this.f24922o00 = height;
        this.f24913O0xOxO = (height / 2) + (rect.height() / 2);
        this.f24916Oxx0xo = ContextCompat.getColor(mContext, II0xO0(R.color.colorAccent));
        applySkin();
    }
}
