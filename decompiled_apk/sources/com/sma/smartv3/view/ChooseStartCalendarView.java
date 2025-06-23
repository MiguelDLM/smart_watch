package com.sma.smartv3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.xxIO;
import java.util.Calendar;
import java.util.Date;
import skin.support.widget.SkinCompatView;

/* loaded from: classes12.dex */
public class ChooseStartCalendarView extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public Calendar f24841IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f24842IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Context f24843IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public LinearLayout.LayoutParams f24844IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f24845O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public String[] f24846Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f24847OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Paint f24848Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Rect f24849OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f24850X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public Date f24851XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public Calendar f24852XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public Calendar f24853XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f24854o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f24855oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public oIX0oI f24856oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f24857oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f24858oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f24859ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f24860xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public Calendar f24861xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f24862xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public Calendar f24863xxX;

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void I0Io(String msg);

        void II0xO0(Calendar calendar, int year, int month, int day);

        void oIX0oI(Calendar calendar, int year, int month, int day);
    }

    public ChooseStartCalendarView(Context context) {
        this(context, null);
    }

    private int I0Io(int resId) {
        return xxoXO.I0Io.II0xO0(resId);
    }

    private int II0xO0(float x, float y) {
        return ((((int) (y / this.f24847OxI)) - 1) * 7) + ((int) (x / this.f24854o00));
    }

    private void oIX0oI(int count) {
        Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.f24851XI0IXoo);
        calendar.add(2, count);
        setDate(calendar);
    }

    public void Oxx0IOOO() {
        oIX0oI(1);
    }

    public void X0o0xo(int year, int month, int day) {
        this.f24860xI = year;
        this.f24858oo0xXOI0I = month;
        this.f24857oo = day;
        this.f24861xXxxox0I.set(year, month, day);
    }

    public void XO() {
        oIX0oI(-1);
    }

    @Override // skin.support.widget.SkinCompatView, xxoXO.Oxx0IOOO
    public void applySkin() {
        super.applySkin();
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        int II0xO02;
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        if (action == 1 && (II0xO02 = II0xO0(x, y)) >= 0 && II0xO02 < this.f24845O0xOxO * 7 && this.f24856oOXoIIIo != null) {
            int i = this.f24852XIxXXX0x0.get(1);
            int i2 = this.f24852XIxXXX0x0.get(2);
            int i3 = (1 - this.f24859ooXIXxIX) + II0xO02;
            Calendar calendar = Calendar.getInstance();
            calendar.set(i, i2, i3);
            if ((((calendar.getTimeInMillis() / 1000) / 60) / 60) / 24 < (((this.f24861xXxxox0I.getTimeInMillis() / 1000) / 60) / 60) / 24 && (((calendar.getTimeInMillis() / 1000) / 60) / 60) / 24 >= (((this.f24841IIX0o.getTimeInMillis() / 1000) / 60) / 60) / 24) {
                this.f24856oOXoIIIo.oIX0oI(calendar, i, i2, i3);
                this.f24852XIxXXX0x0.set(5, (1 - this.f24859ooXIXxIX) + II0xO02);
                setDate(this.f24852XIxXXX0x0);
            }
        }
        return true;
    }

    public Date getDate() {
        return this.f24851XI0IXoo;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f24851XI0IXoo == null) {
            setDate(Calendar.getInstance());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LinearLayout.LayoutParams layoutParams = this.f24844IoOoX;
        layoutParams.width = this.f24842IIXOooo;
        layoutParams.height = this.f24862xoXoI;
        setLayoutParams(layoutParams);
        this.f24848Oxx0xo.setColor(xxIO.II0xO0(this.f24843IXxxXO, R.color.colorAccent));
        for (int i = 0; i < 7; i++) {
            String str = this.f24846Oo[i];
            int i2 = this.f24854o00;
            canvas.drawText(str, (i2 / 2) + (i2 * i), this.f24850X0IIOO, this.f24848Oxx0xo);
        }
        this.f24853XxX0x0xxx.setTime(this.f24863xxX.getTime());
        this.f24853XxX0x0xxx.add(5, ((-this.f24845O0xOxO) + 1) * 7);
        Calendar.getInstance();
        for (int i3 = 0; i3 < this.f24845O0xOxO * 7; i3++) {
            this.f24853XxX0x0xxx.add(5, 1);
            int i4 = this.f24853XxX0x0xxx.get(5);
            int i5 = i3 % 7;
            int i6 = (i3 / 7) + 1;
            this.f24848Oxx0xo.setStyle(Paint.Style.FILL);
            if (this.f24853XxX0x0xxx.get(1) == this.f24852XIxXXX0x0.get(1) && this.f24853XxX0x0xxx.get(2) == this.f24852XIxXXX0x0.get(2) && this.f24853XxX0x0xxx.get(5) == this.f24852XIxXXX0x0.get(5)) {
                this.f24848Oxx0xo.setColor(this.f24855oI0IIXIo);
                canvas.drawCircle((float) ((i5 + 0.5d) * this.f24854o00), (this.f24850X0IIOO + (this.f24847OxI * i6)) - (this.f24849OxxIIOOXO.height() / 2), this.f24848Oxx0xo.getTextSize(), this.f24848Oxx0xo);
            }
            if ((((this.f24853XxX0x0xxx.getTimeInMillis() / 1000) / 60) / 60) / 24 < (((this.f24861xXxxox0I.getTimeInMillis() / 1000) / 60) / 60) / 24 && (((this.f24853XxX0x0xxx.getTimeInMillis() / 1000) / 60) / 60) / 24 >= (((this.f24841IIX0o.getTimeInMillis() / 1000) / 60) / 60) / 24) {
                if (this.f24853XxX0x0xxx.get(1) == this.f24852XIxXXX0x0.get(1) && this.f24853XxX0x0xxx.get(2) == this.f24852XIxXXX0x0.get(2) && this.f24853XxX0x0xxx.get(5) == this.f24852XIxXXX0x0.get(5)) {
                    this.f24848Oxx0xo.setColor(xxIO.II0xO0(this.f24843IXxxXO, R.color.light));
                } else {
                    this.f24848Oxx0xo.setColor(xxIO.II0xO0(this.f24843IXxxXO, R.color.text_color));
                }
            } else {
                this.f24848Oxx0xo.setColor(-7829368);
            }
            canvas.drawText(i4 + "", (float) ((i5 + 0.5d) * this.f24854o00), this.f24850X0IIOO + (i6 * this.f24847OxI), this.f24848Oxx0xo);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        this.f24842IIXOooo = measuredWidth;
        this.f24854o00 = measuredWidth / 7;
    }

    public void oxoX(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        setDate(calendar.getTime());
    }

    public void setDate(Calendar cal) {
        setDate(cal.getTime());
    }

    public void setMax(Calendar cal) {
        X0o0xo(cal.get(1), cal.get(2), cal.get(5));
    }

    public void setMin(Calendar cal) {
        this.f24841IIX0o.set(cal.get(1), cal.get(2), cal.get(5));
    }

    public void setOnDateSelectedListener(oIX0oI listener) {
        this.f24856oOXoIIIo = listener;
    }

    public ChooseStartCalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void setDate(Date data) {
        Calendar.getInstance().setTime(data);
        this.f24851XI0IXoo = data;
        this.f24852XIxXXX0x0.setTime(data);
        this.f24863xxX.setTime(data);
        Calendar calendar = this.f24863xxX;
        calendar.add(5, (-calendar.get(5)) + 1);
        int i = this.f24863xxX.get(7);
        this.f24859ooXIXxIX = i < 2 ? 6 : i - 2;
        this.f24863xxX.add(2, 1);
        this.f24863xxX.add(5, -1);
        int ceil = ((int) Math.ceil(((r7 + this.f24863xxX.get(5)) * 1.0f) / 7.0f)) + 1;
        this.f24845O0xOxO = ceil;
        this.f24862xoXoI = this.f24847OxI * ceil;
        int i2 = this.f24863xxX.get(7);
        this.f24863xxX.add(5, i2 < 2 ? 0 : 8 - i2);
        if (this.f24856oOXoIIIo != null) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(this.f24852XIxXXX0x0.getTime());
            this.f24856oOXoIIIo.II0xO0(calendar2, calendar2.get(1), calendar2.get(2), calendar2.get(5));
        }
        invalidate();
    }

    public ChooseStartCalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f24848Oxx0xo = new Paint();
        this.f24849OxxIIOOXO = new Rect();
        this.f24852XIxXXX0x0 = Calendar.getInstance();
        this.f24863xxX = Calendar.getInstance();
        this.f24853XxX0x0xxx = Calendar.getInstance();
        this.f24861xXxxox0I = Calendar.getInstance();
        this.f24841IIX0o = Calendar.getInstance();
        this.f24860xI = -1;
        this.f24858oo0xXOI0I = -1;
        this.f24844IoOoX = new LinearLayout.LayoutParams(0, 0);
        this.f24843IXxxXO = context;
        this.f24846Oo = context.getResources().getStringArray(R.array.weekdays_s);
        this.f24848Oxx0xo.setAntiAlias(true);
        this.f24848Oxx0xo.setDither(true);
        this.f24848Oxx0xo.setTextSize(oI00o.II0xO0.II0XooXoX(context, 14.0f));
        this.f24848Oxx0xo.setTextAlign(Paint.Align.CENTER);
        this.f24848Oxx0xo.getTextBounds("日日日", 0, 1, this.f24849OxxIIOOXO);
        this.f24848Oxx0xo.setStrokeWidth(oI00o.II0xO0.II0xO0(this.f24843IXxxXO, 1.0f));
        int height = (int) (this.f24849OxxIIOOXO.height() * 3.0d);
        this.f24847OxI = height;
        this.f24850X0IIOO = (height / 2) + (this.f24849OxxIIOOXO.height() / 2);
        this.f24855oI0IIXIo = ContextCompat.getColor(context, I0Io(R.color.colorAccent));
        setMax(Calendar.getInstance());
        applySkin();
    }
}
