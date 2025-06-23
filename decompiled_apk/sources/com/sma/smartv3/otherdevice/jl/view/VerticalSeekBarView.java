package com.sma.smartv3.otherdevice.jl.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public class VerticalSeekBarView extends View {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public PointF f21207IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Paint f21208IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public Bitmap f21209O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public TextPaint f21210Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f21211OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Paint f21212Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f21213OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Bitmap f21214X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public Bitmap f21215XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public boolean f21216XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public TextPaint f21217XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f21218XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public oIX0oI f21219o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String f21220oI0IIXIo;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f21221xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public II0xO0 f21222xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f21223xxX;

    /* loaded from: classes12.dex */
    public interface II0xO0 {
        void oIX0oI(int value, boolean end);
    }

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void oIX0oI(boolean hover);
    }

    public VerticalSeekBarView(Context context) {
        super(context);
        this.f21220oI0IIXIo = "125";
        this.f21213OxxIIOOXO = 0;
        this.f21207IIXOooo = new PointF();
        this.f21211OxI = false;
        this.f21209O0xOxO = BitmapFactory.decodeResource(getResources(), R.drawable.ic_eq_btn_slider_nor);
        this.f21214X0IIOO = BitmapFactory.decodeResource(getResources(), R.drawable.ic_eq_btn_slider_sel);
        this.f21215XI0IXoo = BitmapFactory.decodeResource(getResources(), R.drawable.ic_eq_sb_labal_bg);
        this.f21223xxX = 0;
        this.f21218XxX0x0xxx = -8;
        this.f21221xXxxox0I = 8;
        oxoX(null, 0);
    }

    private float getProgressEndY() {
        return getProgressStartY() + getProgressHeight();
    }

    private float getProgressHeight() {
        return (getHeight() - (this.f21209O0xOxO.getHeight() / 1.1f)) - getProgressStartY();
    }

    private float getProgressStartY() {
        return this.f21209O0xOxO.getHeight() * 1.15f;
    }

    public final float I0Io(float y) {
        if (y < getProgressStartY()) {
            return getProgressStartY();
        }
        if (y > getProgressEndY()) {
            return getProgressEndY();
        }
        return y;
    }

    public final int II0XooXoX(float sp) {
        return (int) TypedValue.applyDimension(2, sp, getResources().getDisplayMetrics());
    }

    public final int II0xO0(float dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    public final boolean Oxx0IOOO(float x, float y) {
        float f = this.f21207IIXOooo.y;
        float height = this.f21209O0xOxO.getHeight() / 2.0f;
        if (y < f + height && y > f - height) {
            return true;
        }
        return false;
    }

    public final boolean X0o0xo() {
        return this.f21216XIxXXX0x0;
    }

    public boolean XO() {
        return this.f21211OxI;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            this.f21216XIxXXX0x0 = Oxx0IOOO(event.getX(), event.getY());
        }
        if (X0o0xo()) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.dispatchTouchEvent(event);
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        return false;
    }

    public final int oIX0oI(float y) {
        return (int) (this.f21221xXxxox0I - (((y - getProgressStartY()) / getProgressHeight()) * (this.f21221xXxxox0I - this.f21218XxX0x0xxx)));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        float f = this.f21207IIXOooo.y;
        float width = getWidth() / 2.0f;
        if (X0o0xo()) {
            bitmap = this.f21214X0IIOO;
        } else {
            bitmap = this.f21209O0xOxO;
        }
        Bitmap bitmap2 = bitmap;
        canvas.drawLine(width, getProgressStartY(), width, getProgressEndY(), this.f21212Oxx0xo);
        if (f != getProgressEndY()) {
            canvas.drawLine(width, f, width, getProgressEndY(), this.f21208IXxxXO);
        }
        float height = f - (bitmap2.getHeight() / 2.0f);
        canvas.drawBitmap(bitmap2, (getWidth() - bitmap2.getWidth()) / 2.0f, height, (Paint) null);
        canvas.drawText(this.f21220oI0IIXIo, width, getHeight() - II0XooXoX(2.0f), this.f21217XO);
        if (X0o0xo()) {
            float height2 = (height - this.f21215XI0IXoo.getHeight()) + (bitmap2.getHeight() / 4.0f);
            canvas.drawBitmap(this.f21215XI0IXoo, (getWidth() - this.f21215XI0IXoo.getWidth()) / 2.0f, height2, (Paint) null);
            canvas.drawText(this.f21213OxxIIOOXO + "", getWidth() / 2.0f, height2 + (this.f21215XI0IXoo.getHeight() / 1.65f), this.f21210Oo);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float progressHeight = getProgressHeight();
        float f = progressHeight / (r3 - r4);
        float progressHeight2 = (((r3 - this.f21213OxxIIOOXO) / (this.f21221xXxxox0I - (this.f21218XxX0x0xxx * 1.0f))) * getProgressHeight()) + getProgressStartY();
        if (Math.abs(this.f21207IIXOooo.y - progressHeight2) > f) {
            this.f21207IIXOooo.set(0.0f, I0Io(progressHeight2));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z = false;
        if (!this.f21211OxI) {
            this.f21216XIxXXX0x0 = false;
            return super.onTouchEvent(event);
        }
        float I0Io2 = I0Io(event.getY());
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    I0Io2 = this.f21207IIXOooo.y;
                }
            }
            oIX0oI oix0oi = this.f21219o00;
            if (oix0oi != null) {
                oix0oi.oIX0oI(false);
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            this.f21216XIxXXX0x0 = false;
            z = true;
        } else {
            oIX0oI oix0oi2 = this.f21219o00;
            if (oix0oi2 != null) {
                oix0oi2.oIX0oI(true);
            }
        }
        invalidate();
        int oIX0oI2 = oIX0oI(I0Io2);
        this.f21207IIXOooo.set(event.getX(), I0Io2);
        if ((event.getAction() != 0 && oIX0oI2 != this.f21213OxxIIOOXO) || z) {
            this.f21213OxxIIOOXO = oIX0oI2;
            II0xO0 iI0xO0 = this.f21222xoXoI;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(oIX0oI2, z);
            }
        }
        return X0o0xo();
    }

    public final void oxoX(AttributeSet attrs, int defStyle) {
        TextPaint textPaint = new TextPaint();
        this.f21217XO = textPaint;
        textPaint.setFlags(1);
        TextPaint textPaint2 = this.f21217XO;
        Paint.Align align = Paint.Align.CENTER;
        textPaint2.setTextAlign(align);
        this.f21217XO.setTextSize(II0XooXoX(12.0f));
        this.f21217XO.setColor(getContext().getResources().getColor(R.color.gray_8B8B8B));
        TextPaint textPaint3 = new TextPaint();
        this.f21210Oo = textPaint3;
        textPaint3.setFlags(1);
        this.f21210Oo.setTextAlign(align);
        this.f21210Oo.setTextSize(II0XooXoX(14.0f));
        this.f21210Oo.setColor(-1);
        Paint paint = new Paint();
        this.f21208IXxxXO = paint;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        this.f21208IXxxXO.setStrokeWidth(II0xO0(3.0f));
        setEnable(true);
        Paint paint2 = new Paint();
        this.f21212Oxx0xo = paint2;
        paint2.setStrokeCap(cap);
        this.f21212Oxx0xo.setStrokeWidth(II0xO0(3.0f));
        this.f21212Oxx0xo.setColor(getContext().getResources().getColor(R.color.gray_E5E5E5));
    }

    public void setEnable(boolean enable) {
        int color;
        this.f21211OxI = enable;
        Paint paint = this.f21208IXxxXO;
        if (!enable) {
            color = getContext().getResources().getColor(R.color.color_vsbv_false);
        } else {
            color = getContext().getResources().getColor(R.color.color_vsbv_true);
        }
        paint.setColor(color);
        invalidate();
    }

    public void setHoverListener(oIX0oI hoverListener) {
        this.f21219o00 = hoverListener;
    }

    public void setIndex(int index) {
        this.f21223xxX = index;
    }

    public void setText(String text) {
        this.f21220oI0IIXIo = text;
        invalidate();
    }

    public void setValue(int value) {
        if (X0o0xo()) {
            return;
        }
        int i = this.f21218XxX0x0xxx;
        if (value < i) {
            value = i;
        } else {
            int i2 = this.f21221xXxxox0I;
            if (value > i2) {
                value = i2;
            }
        }
        this.f21207IIXOooo.set(0.0f, I0Io((((r1 - value) / ((this.f21221xXxxox0I * 1.0f) - i)) * getProgressHeight()) + getProgressStartY()));
        this.f21213OxxIIOOXO = value;
        invalidate();
    }

    public void setValueListener(II0xO0 valueListener) {
        this.f21222xoXoI = valueListener;
    }

    public VerticalSeekBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f21220oI0IIXIo = "125";
        this.f21213OxxIIOOXO = 0;
        this.f21207IIXOooo = new PointF();
        this.f21211OxI = false;
        this.f21209O0xOxO = BitmapFactory.decodeResource(getResources(), R.drawable.ic_eq_btn_slider_nor);
        this.f21214X0IIOO = BitmapFactory.decodeResource(getResources(), R.drawable.ic_eq_btn_slider_sel);
        this.f21215XI0IXoo = BitmapFactory.decodeResource(getResources(), R.drawable.ic_eq_sb_labal_bg);
        this.f21223xxX = 0;
        this.f21218XxX0x0xxx = -8;
        this.f21221xXxxox0I = 8;
        oxoX(attrs, 0);
    }

    public VerticalSeekBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f21220oI0IIXIo = "125";
        this.f21213OxxIIOOXO = 0;
        this.f21207IIXOooo = new PointF();
        this.f21211OxI = false;
        this.f21209O0xOxO = BitmapFactory.decodeResource(getResources(), R.drawable.ic_eq_btn_slider_nor);
        this.f21214X0IIOO = BitmapFactory.decodeResource(getResources(), R.drawable.ic_eq_btn_slider_sel);
        this.f21215XI0IXoo = BitmapFactory.decodeResource(getResources(), R.drawable.ic_eq_sb_labal_bg);
        this.f21223xxX = 0;
        this.f21218XxX0x0xxx = -8;
        this.f21221xXxxox0I = 8;
        oxoX(attrs, defStyle);
    }
}
