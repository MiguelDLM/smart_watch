package com.sma.smartv3.view.WheelView;

import X0O0I0.I0Io;
import X0O0I0.II0xO0;
import X0O0I0.X0o0xo;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.MyTypeface;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import oIxOXo.oxoX;

/* loaded from: classes12.dex */
public class WheelView extends View {

    /* renamed from: I0oOoX, reason: collision with root package name */
    public float f25392I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    public float f25393IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public ScheduledFuture<?> f25394IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public int f25395IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Handler f25396IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public int f25397Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f25398IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public List<String> f25399O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public int f25400OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public Context f25401Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public Paint f25402OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public GestureDetector f25403Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public ScheduledExecutorService f25404OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f25405X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f25406X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f25407XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f25408XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public float f25409XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public int f25410XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public int f25411XX;

    /* renamed from: XoX, reason: collision with root package name */
    public Rect f25412XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f25413Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f25414XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public int f25415o0;

    /* renamed from: o00, reason: collision with root package name */
    public Paint f25416o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public I0Io f25417oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f25418oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f25419oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f25420oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public boolean f25421ooXIXxIX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public long f25422oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public int f25423x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f25424xI;

    /* renamed from: xII, reason: collision with root package name */
    public int f25425xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f25426xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public Paint f25427xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f25428xxX;

    /* loaded from: classes12.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public WheelView(Context context) {
        super(context);
        this.f25409XO = 1.15f;
        this.f25404OxxIIOOXO = Executors.newSingleThreadScheduledExecutor();
        this.f25410XOxIOxOx = 0;
        this.f25400OI0 = 0;
        this.f25411XX = 0;
        this.f25422oxxXoxO = 0L;
        this.f25412XoX = new Rect();
        I0Io(context);
    }

    public final void I0Io(Context context) {
        oxoX.f31821II0XooXoX = isInEditMode();
        this.f25401Oo = context;
        this.f25396IXxxXO = new oIX0oI(this);
        GestureDetector gestureDetector = new GestureDetector(context, new II0xO0(this));
        this.f25403Oxx0xo = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f25393IIX0o = 2.0f;
        this.f25421ooXIXxIX = true;
        this.f25395IO = 7;
        this.f25428xxX = -5263441;
        this.f25414XxX0x0xxx = oxoX.I0Io(context, R.color.colorAccent);
        this.f25426xXxxox0I = -3815995;
        this.f25419oo = 0;
        this.f25398IoOoX = -1;
        oxoX();
        setTextSize(24.0f);
    }

    public final void II0XooXoX(float velocityY) {
        oIX0oI();
        this.f25394IIXOooo = this.f25404OxxIIOOXO.scheduleWithFixedDelay(new X0O0I0.oIX0oI(this, velocityY), 0L, 10, TimeUnit.MILLISECONDS);
    }

    public final int II0xO0(String a2, Paint paint, Rect rect) {
        paint.getTextBounds(a2, 0, a2.length(), rect);
        return (this.f25423x0o - ((int) (rect.width() * this.f25409XO))) / 2;
    }

    public void OOXIXo(ACTION action) {
        oIX0oI();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.f25393IIX0o * this.f25408XIxXXX0x0;
            int i = (int) (((this.f25419oo % f) + f) % f);
            this.f25411XX = i;
            if (i > f / 2.0f) {
                this.f25411XX = (int) (f - i);
            } else {
                this.f25411XX = -i;
            }
        }
        this.f25394IIXOooo = this.f25404OxxIIOOXO.scheduleWithFixedDelay(new X0o0xo(this, this.f25411XX), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void Oxx0IOOO() {
        if (this.f25399O0xOxO == null) {
            return;
        }
        X0o0xo();
        int i = this.f25408XIxXXX0x0;
        float f = this.f25393IIX0o;
        int i2 = (int) (i * f * (this.f25395IO - 1));
        this.f25397Io = i2;
        int i3 = (int) ((i2 * 2) / 3.141592653589793d);
        this.f25425xII = i3;
        this.f25415o0 = (int) (i2 / 3.141592653589793d);
        this.f25424xI = (int) ((i3 - (i * f)) / 2.0f);
        this.f25420oo0xXOI0I = (int) ((i3 + (f * i)) / 2.0f);
        if (this.f25398IoOoX == -1) {
            if (this.f25421ooXIXxIX) {
                this.f25398IoOoX = (this.f25399O0xOxO.size() + 1) / 2;
            } else {
                this.f25398IoOoX = 0;
            }
        }
        this.f25413Xx000oIo = this.f25398IoOoX;
    }

    public final void X0o0xo() {
        for (int i = 0; i < this.f25399O0xOxO.size(); i++) {
            String str = this.f25399O0xOxO.get(i);
            this.f25416o00.getTextBounds(str, 0, str.length(), this.f25412XoX);
            this.f25416o00.getTextBounds("星期", 0, 2, this.f25412XoX);
            int height = this.f25412XoX.height();
            if (height > this.f25408XIxXXX0x0) {
                this.f25408XIxXXX0x0 = height;
            }
        }
    }

    public final void XO() {
        if (this.f25417oI0IIXIo != null) {
            postDelayed(new X0O0I0.oxoX(this), 200L);
        }
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return this.f25410XOxIOxOx;
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return this.f25400OI0;
    }

    public final int getSelectedItem() {
        return this.f25418oOXoIIIo;
    }

    public void oIX0oI() {
        ScheduledFuture<?> scheduledFuture = this.f25394IIXOooo;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f25394IIXOooo.cancel(true);
            this.f25394IIXOooo = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        List<String> list = this.f25399O0xOxO;
        if (list == null) {
            return;
        }
        String[] strArr = new String[this.f25395IO];
        int i = (int) (this.f25419oo / (this.f25393IIX0o * this.f25408XIxXXX0x0));
        this.f25405X00IoxXI = i;
        int size = this.f25398IoOoX + (i % list.size());
        this.f25413Xx000oIo = size;
        if (!this.f25421ooXIXxIX) {
            if (size < 0) {
                this.f25413Xx000oIo = 0;
            }
            if (this.f25413Xx000oIo > this.f25399O0xOxO.size() - 1) {
                this.f25413Xx000oIo = this.f25399O0xOxO.size() - 1;
            }
        } else {
            if (size < 0) {
                this.f25413Xx000oIo = this.f25399O0xOxO.size() + this.f25413Xx000oIo;
            }
            if (this.f25413Xx000oIo > this.f25399O0xOxO.size() - 1) {
                this.f25413Xx000oIo -= this.f25399O0xOxO.size();
            }
        }
        int i2 = (int) (this.f25419oo % (this.f25393IIX0o * this.f25408XIxXXX0x0));
        int i3 = 0;
        while (true) {
            int i4 = this.f25395IO;
            if (i3 >= i4) {
                break;
            }
            int i5 = this.f25413Xx000oIo - ((i4 / 2) - i3);
            if (this.f25421ooXIXxIX) {
                while (i5 < 0) {
                    i5 += this.f25399O0xOxO.size();
                }
                while (i5 > this.f25399O0xOxO.size() - 1) {
                    i5 -= this.f25399O0xOxO.size();
                }
                strArr[i3] = this.f25399O0xOxO.get(i5);
            } else if (i5 < 0) {
                strArr[i3] = "";
            } else if (i5 > this.f25399O0xOxO.size() - 1) {
                strArr[i3] = "";
            } else {
                strArr[i3] = this.f25399O0xOxO.get(i5);
            }
            i3++;
        }
        for (int i6 = 0; i6 < this.f25395IO; i6++) {
            canvas.save();
            float f = this.f25408XIxXXX0x0 * this.f25393IIX0o;
            double d = (((i6 * f) - i2) * 3.141592653589793d) / this.f25397Io;
            float f2 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f2 < 90.0f && f2 > -90.0f) {
                int cos = (int) ((this.f25415o0 - (Math.cos(d) * this.f25415o0)) - ((Math.sin(d) * this.f25408XIxXXX0x0) / 2.0d));
                canvas.translate(0.0f, cos);
                canvas.scale(1.0f, (float) Math.sin(d));
                int i7 = this.f25424xI;
                if (cos <= i7 && this.f25408XIxXXX0x0 + cos >= i7) {
                    canvas.save();
                    canvas.clipRect(0, 0, this.f25423x0o, this.f25424xI - cos);
                    canvas.drawText(strArr[i6], II0xO0(r5, this.f25427xoXoI, this.f25412XoX), this.f25408XIxXXX0x0, this.f25427xoXoI);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.f25424xI - cos, this.f25423x0o, (int) f);
                    canvas.drawText(strArr[i6], II0xO0(r4, this.f25416o00, this.f25412XoX), this.f25408XIxXXX0x0, this.f25416o00);
                    canvas.restore();
                } else {
                    int i8 = this.f25420oo0xXOI0I;
                    if (cos <= i8 && this.f25408XIxXXX0x0 + cos >= i8) {
                        canvas.save();
                        canvas.clipRect(0, 0, this.f25423x0o, this.f25420oo0xXOI0I - cos);
                        canvas.drawText(strArr[i6], II0xO0(r5, this.f25416o00, this.f25412XoX), this.f25408XIxXXX0x0, this.f25416o00);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.f25420oo0xXOI0I - cos, this.f25423x0o, (int) f);
                        canvas.drawText(strArr[i6], II0xO0(r4, this.f25427xoXoI, this.f25412XoX), this.f25408XIxXXX0x0, this.f25427xoXoI);
                        canvas.restore();
                    } else if (cos >= i7 && this.f25408XIxXXX0x0 + cos <= i8) {
                        canvas.clipRect(0, 0, this.f25423x0o, (int) f);
                        canvas.drawText(strArr[i6], II0xO0(r4, this.f25416o00, this.f25412XoX), this.f25408XIxXXX0x0, this.f25416o00);
                        this.f25418oOXoIIIo = this.f25399O0xOxO.indexOf(strArr[i6]);
                    } else {
                        canvas.clipRect(0, 0, this.f25423x0o, (int) f);
                        canvas.drawText(strArr[i6], II0xO0(r4, this.f25427xoXoI, this.f25412XoX), this.f25408XIxXXX0x0, this.f25427xoXoI);
                    }
                }
                canvas.restore();
            } else {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Oxx0IOOO();
        int measuredWidth = getMeasuredWidth();
        this.f25423x0o = measuredWidth;
        setMeasuredDimension(measuredWidth, this.f25425xII);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean onTouchEvent = this.f25403Oxx0xo.onTouchEvent(event);
        float f = this.f25393IIX0o * this.f25408XIxXXX0x0;
        int action = event.getAction();
        if (action != 0) {
            if (action != 2) {
                if (!onTouchEvent) {
                    float y = event.getY();
                    int i = this.f25415o0;
                    int acos = (int) (((Math.acos((i - y) / i) * this.f25415o0) + (f / 2.0f)) / f);
                    this.f25411XX = (int) (((acos - (this.f25395IO / 2)) * f) - (((this.f25419oo % f) + f) % f));
                    if (System.currentTimeMillis() - this.f25422oxxXoxO > 120) {
                        OOXIXo(ACTION.DAGGLE);
                    } else {
                        OOXIXo(ACTION.CLICK);
                    }
                }
            } else {
                float rawY = this.f25392I0oOoX - event.getRawY();
                this.f25392I0oOoX = event.getRawY();
                this.f25419oo = (int) (this.f25419oo + rawY);
                if (!this.f25421ooXIXxIX) {
                    float f2 = (-this.f25398IoOoX) * f;
                    float size = ((this.f25399O0xOxO.size() - 1) - this.f25398IoOoX) * f;
                    int i2 = this.f25419oo;
                    if (i2 < f2) {
                        this.f25419oo = (int) f2;
                    } else if (i2 > size) {
                        this.f25419oo = (int) size;
                    }
                }
            }
        } else {
            this.f25422oxxXoxO = System.currentTimeMillis();
            oIX0oI();
            this.f25392I0oOoX = event.getRawY();
        }
        invalidate();
        return true;
    }

    public final void oxoX() {
        Paint paint = new Paint();
        this.f25427xoXoI = paint;
        paint.setColor(this.f25428xxX);
        this.f25427xoXoI.setAntiAlias(true);
        Paint paint2 = this.f25427xoXoI;
        OOxOI.oIX0oI oix0oi = OOxOI.oIX0oI.f1804oIX0oI;
        MyTypeface myTypeface = MyTypeface.DIN_COND_BOLD;
        paint2.setTypeface(oix0oi.oIX0oI(myTypeface, this.f25401Oo));
        this.f25427xoXoI.setTextSize(this.f25406X0IIOO);
        Paint paint3 = new Paint();
        this.f25416o00 = paint3;
        paint3.setColor(this.f25414XxX0x0xxx);
        this.f25416o00.setAntiAlias(true);
        this.f25416o00.setTextScaleX(this.f25409XO);
        this.f25416o00.setTypeface(oix0oi.oIX0oI(myTypeface, this.f25401Oo));
        this.f25416o00.setTextSize(this.f25406X0IIOO);
        Paint paint4 = new Paint();
        this.f25402OxI = paint4;
        paint4.setColor(this.f25426xXxxox0I);
        this.f25402OxI.setAntiAlias(true);
        setLayerType(1, null);
    }

    public final void setInitPosition(int initPosition) {
        this.f25419oo = 0;
        if (initPosition < 0) {
            this.f25398IoOoX = 0;
        } else {
            this.f25398IoOoX = initPosition;
        }
    }

    public final void setItems(List<String> items) {
        this.f25399O0xOxO = items;
        if (this.f25398IoOoX > items.size() - 1) {
            this.f25398IoOoX = items.size() - 1;
        }
        Oxx0IOOO();
        invalidate();
    }

    public final void setListener(I0Io OnItemSelectedListener) {
        this.f25417oI0IIXIo = OnItemSelectedListener;
    }

    @Override // android.view.View
    public final void setScaleX(float scaleX) {
        if (scaleX > 0.0f) {
            this.f25409XO = scaleX;
            this.f25416o00.setTextScaleX(scaleX);
        }
    }

    public final void setTextSize(float size) {
        if (size > 0.0f) {
            int i = (int) (this.f25401Oo.getResources().getDisplayMetrics().density * size);
            this.f25406X0IIOO = i;
            this.f25427xoXoI.setTextSize(i);
            this.f25416o00.setTextSize(this.f25406X0IIOO);
        }
    }

    public void setVisibleCount(int count) {
        this.f25395IO = count + 2;
    }

    public void xoIox(int left, int top, int right, int bottom) {
        this.f25410XOxIOxOx = left;
        this.f25400OI0 = right;
    }

    public final void xxIXOIIO() {
        this.f25421ooXIXxIX = false;
    }

    public WheelView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        this.f25409XO = 1.15f;
        this.f25404OxxIIOOXO = Executors.newSingleThreadScheduledExecutor();
        this.f25410XOxIOxOx = 0;
        this.f25400OI0 = 0;
        this.f25411XX = 0;
        this.f25422oxxXoxO = 0L;
        this.f25412XoX = new Rect();
        I0Io(context);
    }

    public WheelView(Context context, AttributeSet attributeset, int defStyleAttr) {
        super(context, attributeset, defStyleAttr);
        this.f25409XO = 1.15f;
        this.f25404OxxIIOOXO = Executors.newSingleThreadScheduledExecutor();
        this.f25410XOxIOxOx = 0;
        this.f25400OI0 = 0;
        this.f25411XX = 0;
        this.f25422oxxXoxO = 0L;
        this.f25412XoX = new Rect();
        I0Io(context);
    }
}
