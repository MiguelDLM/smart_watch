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
public class CalendarView extends SkinCompatView {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f24819IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f24820IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Context f24821IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public oIX0oI f24822IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f24823O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public String[] f24824Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f24825OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Paint f24826Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Rect f24827OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f24828X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public Date f24829XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public Calendar f24830XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public Calendar f24831XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f24832o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f24833oI0IIXIo;

    /* renamed from: oo, reason: collision with root package name */
    public LinearLayout.LayoutParams f24834oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f24835oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f24836ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f24837xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public Calendar f24838xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f24839xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public Calendar f24840xxX;

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void I0Io(String msg);

        void II0xO0(Calendar calendar, int year, int month, int day);

        void oIX0oI(Calendar calendar, int year, int month, int day);
    }

    public CalendarView(Context context) {
        this(context, null);
    }

    public final int I0Io(int resId) {
        return xxoXO.I0Io.II0xO0(resId);
    }

    public final int II0xO0(float x, float y) {
        return ((((int) (y / this.f24825OxI)) - 1) * 7) + ((int) (x / this.f24832o00));
    }

    public void Oxx0IOOO() {
        oIX0oI(1);
    }

    public void X0o0xo(int year, int month, int day) {
        this.f24836ooXIXxIX = year;
        this.f24837xI = month;
        this.f24835oo0xXOI0I = day;
        this.f24838xXxxox0I.set(year, month, day);
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
        if (action == 1 && (II0xO02 = II0xO0(x, y)) >= 0 && II0xO02 < this.f24823O0xOxO * 7 && this.f24822IoOoX != null) {
            int i = this.f24830XIxXXX0x0.get(1);
            int i2 = this.f24830XIxXXX0x0.get(2);
            int i3 = (1 - this.f24819IIX0o) + II0xO02;
            Calendar calendar = Calendar.getInstance();
            calendar.set(i, i2, i3);
            if ((((calendar.getTimeInMillis() / 1000) / 60) / 60) / 24 > (((this.f24838xXxxox0I.getTimeInMillis() / 1000) / 60) / 60) / 24) {
                return true;
            }
            this.f24822IoOoX.oIX0oI(calendar, i, i2, i3);
            this.f24830XIxXXX0x0.set(5, (1 - this.f24819IIX0o) + II0xO02);
            setDate(this.f24830XIxXXX0x0);
        }
        return true;
    }

    public Date getDate() {
        return this.f24829XI0IXoo;
    }

    public final void oIX0oI(int count) {
        Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.f24829XI0IXoo);
        calendar.add(2, count);
        setDate(calendar);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f24829XI0IXoo == null) {
            setDate(Calendar.getInstance());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LinearLayout.LayoutParams layoutParams = this.f24834oo;
        layoutParams.width = this.f24820IIXOooo;
        layoutParams.height = this.f24839xoXoI;
        setLayoutParams(layoutParams);
        this.f24826Oxx0xo.setColor(xxIO.II0xO0(this.f24821IXxxXO, R.color.text_color));
        for (int i = 0; i < 7; i++) {
            String str = this.f24824Oo[i];
            int i2 = this.f24832o00;
            canvas.drawText(str, (i2 / 2) + (i2 * i), this.f24828X0IIOO, this.f24826Oxx0xo);
        }
        this.f24831XxX0x0xxx.setTime(this.f24840xxX.getTime());
        this.f24831XxX0x0xxx.add(5, ((-this.f24823O0xOxO) + 1) * 7);
        Calendar calendar = Calendar.getInstance();
        for (int i3 = 0; i3 < this.f24823O0xOxO * 7; i3++) {
            this.f24831XxX0x0xxx.add(5, 1);
            int i4 = this.f24831XxX0x0xxx.get(5);
            int i5 = i3 % 7;
            int i6 = (i3 / 7) + 1;
            if (this.f24831XxX0x0xxx.get(1) == this.f24830XIxXXX0x0.get(1) && this.f24831XxX0x0xxx.get(2) == this.f24830XIxXXX0x0.get(2) && this.f24831XxX0x0xxx.get(5) == this.f24830XIxXXX0x0.get(5)) {
                this.f24826Oxx0xo.setColor(this.f24833oI0IIXIo);
                this.f24826Oxx0xo.setStyle(Paint.Style.STROKE);
                canvas.drawCircle((float) ((i5 + 0.5d) * this.f24832o00), (this.f24828X0IIOO + (this.f24825OxI * i6)) - (this.f24827OxxIIOOXO.height() / 2), this.f24826Oxx0xo.getTextSize(), this.f24826Oxx0xo);
                this.f24826Oxx0xo.setStyle(Paint.Style.FILL);
            }
            if (calendar.get(1) == this.f24831XxX0x0xxx.get(1) && calendar.get(2) == this.f24831XxX0x0xxx.get(2) && calendar.get(5) == this.f24831XxX0x0xxx.get(5)) {
                this.f24826Oxx0xo.setColor(this.f24833oI0IIXIo);
                canvas.drawCircle((float) ((i5 + 0.5d) * this.f24832o00), (this.f24828X0IIOO + (this.f24825OxI * i6)) - (this.f24827OxxIIOOXO.height() / 2), this.f24826Oxx0xo.getTextSize(), this.f24826Oxx0xo);
            }
            if (this.f24830XIxXXX0x0.get(2) == this.f24831XxX0x0xxx.get(2)) {
                if ((((this.f24831XxX0x0xxx.getTimeInMillis() / 1000) / 60) / 60) / 24 < (((this.f24838xXxxox0I.getTimeInMillis() / 1000) / 60) / 60) / 24) {
                    this.f24826Oxx0xo.setColor(xxIO.II0xO0(this.f24821IXxxXO, R.color.text_color));
                } else {
                    this.f24826Oxx0xo.setColor(-7829368);
                }
            } else {
                this.f24826Oxx0xo.setColor(-7829368);
            }
            canvas.drawText(i4 + "", (float) ((i5 + 0.5d) * this.f24832o00), this.f24828X0IIOO + (i6 * this.f24825OxI), this.f24826Oxx0xo);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        this.f24820IIXOooo = measuredWidth;
        this.f24832o00 = measuredWidth / 7;
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

    public void setOnDateSelectedListener(oIX0oI listener) {
        this.f24822IoOoX = listener;
    }

    public CalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void setDate(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        if (this.f24836ooXIXxIX != -1 && this.f24837xI != -1) {
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            int i3 = this.f24836ooXIXxIX;
            if (i > i3) {
                oIX0oI oix0oi = this.f24822IoOoX;
                if (oix0oi != null) {
                    oix0oi.I0Io(this.f24821IXxxXO.getString(R.string.no_more));
                    return;
                }
                return;
            }
            if (i == i3 && i2 > this.f24837xI) {
                oIX0oI oix0oi2 = this.f24822IoOoX;
                if (oix0oi2 != null) {
                    oix0oi2.I0Io(this.f24821IXxxXO.getString(R.string.no_more));
                    return;
                }
                return;
            }
        }
        this.f24829XI0IXoo = data;
        this.f24830XIxXXX0x0.setTime(data);
        this.f24840xxX.setTime(data);
        Calendar calendar2 = this.f24840xxX;
        calendar2.add(5, (-calendar2.get(5)) + 1);
        int i4 = this.f24840xxX.get(7);
        this.f24819IIX0o = i4 < 2 ? 6 : i4 - 2;
        this.f24840xxX.add(2, 1);
        this.f24840xxX.add(5, -1);
        int ceil = ((int) Math.ceil(((r8 + this.f24840xxX.get(5)) * 1.0f) / 7.0f)) + 1;
        this.f24823O0xOxO = ceil;
        this.f24839xoXoI = this.f24825OxI * ceil;
        int i5 = this.f24840xxX.get(7);
        this.f24840xxX.add(5, i5 < 2 ? 0 : 8 - i5);
        if (this.f24822IoOoX != null) {
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(this.f24830XIxXXX0x0.getTime());
            this.f24822IoOoX.II0xO0(calendar3, calendar3.get(1), calendar3.get(2), calendar3.get(5));
        }
        invalidate();
    }

    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f24826Oxx0xo = new Paint();
        this.f24827OxxIIOOXO = new Rect();
        this.f24830XIxXXX0x0 = Calendar.getInstance();
        this.f24840xxX = Calendar.getInstance();
        this.f24831XxX0x0xxx = Calendar.getInstance();
        this.f24838xXxxox0I = Calendar.getInstance();
        this.f24836ooXIXxIX = -1;
        this.f24837xI = -1;
        this.f24834oo = new LinearLayout.LayoutParams(0, 0);
        this.f24821IXxxXO = context;
        this.f24824Oo = context.getResources().getStringArray(R.array.weekdays_s);
        this.f24826Oxx0xo.setAntiAlias(true);
        this.f24826Oxx0xo.setDither(true);
        this.f24826Oxx0xo.setTextSize(oI00o.II0xO0.II0XooXoX(context, 14.0f));
        this.f24826Oxx0xo.setTextAlign(Paint.Align.CENTER);
        this.f24826Oxx0xo.getTextBounds("日日日", 0, 1, this.f24827OxxIIOOXO);
        this.f24826Oxx0xo.setStrokeWidth(oI00o.II0xO0.II0xO0(this.f24821IXxxXO, 1.0f));
        int height = (int) (this.f24827OxxIIOOXO.height() * 3.0d);
        this.f24825OxI = height;
        this.f24828X0IIOO = (height / 2) + (this.f24827OxxIIOOXO.height() / 2);
        this.f24833oI0IIXIo = ContextCompat.getColor(context, I0Io(R.color.colorAccent));
        setBackgroundColor(xxIO.II0xO0(this.f24821IXxxXO, R.color.view_page_secondary_bg));
        setMax(Calendar.getInstance());
        applySkin();
    }
}
