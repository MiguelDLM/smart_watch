package com.sma.smartv3.otherdevice.jl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.blankj.utilcode.util.SizeUtils;
import com.jieli.eq.EQPlotCore;
import com.sma.smartv3.R;
import oo00.II0xO0;

/* loaded from: classes12.dex */
public class EqWaveView extends View {

    /* renamed from: IIX0o, reason: collision with root package name */
    public int[] f21092IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public float[] f21093IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Paint f21094IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public Path f21095O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public Paint f21096Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public float[] f21097OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Paint f21098Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public EQPlotCore f21099OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f21100X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f21101XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f21102XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public TextPaint f21103XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f21104XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public II0xO0 f21105o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f21106oI0IIXIo;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f21107xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int[] f21108xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f21109xxX;

    public EqWaveView(Context context) {
        super(context);
        this.f21106oI0IIXIo = 2000;
        this.f21108xoXoI = new int[10];
        this.f21105o00 = null;
        this.f21100X0IIOO = -8365077;
        this.f21101XI0IXoo = -8365077;
        this.f21102XIxXXX0x0 = 2136883691;
        this.f21109xxX = 13948116;
        this.f21104XxX0x0xxx = 12303291;
        this.f21107xXxxox0I = 12303291;
        this.f21092IIX0o = new int[]{31, 63, 125, 250, 500, 1000, 2000, 8000, 16000};
        I0Io(null, 0);
    }

    public final void I0Io(AttributeSet attrs, int defStyle) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.EqWaveView);
        if (obtainStyledAttributes != null) {
            this.f21100X0IIOO = obtainStyledAttributes.getColor(4, this.f21100X0IIOO);
            this.f21109xxX = obtainStyledAttributes.getColor(5, this.f21109xxX);
            this.f21101XI0IXoo = obtainStyledAttributes.getColor(2, this.f21101XI0IXoo);
            this.f21104XxX0x0xxx = obtainStyledAttributes.getColor(3, this.f21104XxX0x0xxx);
            this.f21102XIxXXX0x0 = obtainStyledAttributes.getColor(0, this.f21102XIxXXX0x0);
            this.f21107xXxxox0I = obtainStyledAttributes.getColor(1, this.f21107xXxxox0I);
        }
        this.f21106oI0IIXIo = getContext().getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        TextPaint textPaint = new TextPaint();
        this.f21103XO = textPaint;
        textPaint.setFlags(1);
        this.f21103XO.setTextAlign(Paint.Align.LEFT);
        this.f21103XO.setTextSize(X0o0xo(8.0f));
        this.f21103XO.setColor(-1);
        Paint paint = new Paint();
        this.f21096Oo = paint;
        paint.setColor(this.f21101XI0IXoo);
        Paint paint2 = this.f21096Oo;
        Paint.Align align = Paint.Align.CENTER;
        paint2.setTextAlign(align);
        this.f21096Oo.setStrokeWidth(5.0f);
        Paint paint3 = new Paint();
        this.f21094IXxxXO = paint3;
        paint3.setColor(this.f21100X0IIOO);
        this.f21094IXxxXO.setTextAlign(align);
        this.f21094IXxxXO.setStrokeWidth(oIX0oI(1.5f));
        this.f21094IXxxXO.setStyle(Paint.Style.STROKE);
        this.f21103XO.setFlags(1);
        Paint paint4 = new Paint();
        this.f21098Oxx0xo = paint4;
        paint4.setColor(-1);
        this.f21098Oxx0xo.setTextAlign(align);
        this.f21098Oxx0xo.setStrokeWidth(1.0f);
        this.f21095O0xOxO = new Path();
        oxoX();
    }

    public final void II0xO0(Canvas canvas) {
        int i = 0;
        while (true) {
            if (i < this.f21092IIX0o.length) {
                float I0Io2 = this.f21105o00.I0Io(r1[i]);
                canvas.drawLine(I0Io2, 0.0f, I0Io2, getHeight(), this.f21098Oxx0xo);
                canvas.drawText(this.f21108xoXoI[i] + "", I0Io2 + X0o0xo(2.0f), getHeight() - 2, this.f21103XO);
                i++;
            } else {
                return;
            }
        }
    }

    public final int X0o0xo(float sp) {
        return (int) TypedValue.applyDimension(2, sp, getResources().getDisplayMetrics());
    }

    public void XO(int index, int value) {
        this.f21108xoXoI[index] = value;
        this.f21099OxxIIOOXO.updatePara(index, this.f21092IIX0o[index], value);
        if (this.f21097OxI == null) {
            this.f21097OxI = new float[((this.f21106oI0IIXIo - 2) * 4) + 4];
        }
        this.f21099OxxIIOOXO.getEQPlotData(this.f21097OxI, index);
        this.f21093IIXOooo = this.f21105o00.II0xO0(this.f21097OxI);
        invalidate();
    }

    public final int oIX0oI(float dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        super.onDraw(canvas);
        float height = canvas.getHeight();
        if (isEnabled()) {
            i = this.f21102XIxXXX0x0;
        } else {
            i = this.f21107xXxxox0I;
        }
        int i4 = i;
        if (isEnabled()) {
            i2 = this.f21101XI0IXoo;
        } else {
            i2 = this.f21104XxX0x0xxx;
        }
        this.f21096Oo.setShader(new LinearGradient(0.0f, height, 0.0f, 0.0f, i4, i2, Shader.TileMode.REPEAT));
        Paint paint = this.f21094IXxxXO;
        if (!isEnabled()) {
            i3 = this.f21109xxX;
        } else {
            i3 = this.f21100X0IIOO;
        }
        paint.setColor(i3);
        this.f21095O0xOxO.reset();
        this.f21095O0xOxO.moveTo(0.0f, getHeight());
        int i5 = 0;
        while (true) {
            float[] fArr = this.f21093IIXOooo;
            if (i5 < fArr.length) {
                this.f21095O0xOxO.lineTo(fArr[i5], fArr[i5 + 1]);
                i5 += 2;
            } else {
                this.f21095O0xOxO.lineTo(getWidth(), this.f21093IIXOooo[r3.length - 1]);
                canvas.drawPath(this.f21095O0xOxO, this.f21094IXxxXO);
                this.f21095O0xOxO.lineTo(getWidth(), getHeight());
                this.f21095O0xOxO.lineTo(0.0f, getHeight());
                canvas.drawPath(this.f21095O0xOxO, this.f21096Oo);
                canvas.clipPath(this.f21095O0xOxO);
                II0xO0(canvas);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        II0xO0 iI0xO0 = new II0xO0(w, h - X0o0xo(6.0f));
        this.f21105o00 = iI0xO0;
        iI0xO0.X0o0xo(SizeUtils.dp2px(20.0f));
        II0xO0 iI0xO02 = this.f21105o00;
        int[] iArr = this.f21092IIX0o;
        iI0xO02.XO(iArr[0], iArr[iArr.length - 1]);
        if (this.f21097OxI == null) {
            this.f21097OxI = new float[((this.f21106oI0IIXIo - 2) * 4) + 4];
        }
        this.f21099OxxIIOOXO.getEQPlotData(this.f21097OxI, 0);
        setData(this.f21108xoXoI);
        this.f21093IIXOooo = this.f21105o00.II0xO0(this.f21097OxI);
    }

    public final void oxoX() {
        int i = this.f21106oI0IIXIo;
        int[] iArr = this.f21092IIX0o;
        this.f21099OxxIIOOXO = new EQPlotCore(i, iArr.length, iArr);
        if (this.f21097OxI == null) {
            this.f21097OxI = new float[((this.f21106oI0IIXIo - 2) * 4) + 4];
        }
    }

    public void setData(int[] value) {
        int i = 0;
        while (true) {
            if (i >= this.f21092IIX0o.length || i >= value.length) {
                break;
            }
            this.f21099OxxIIOOXO.updatePara(i, r1[i], value[i]);
            this.f21108xoXoI[i] = value[i];
            this.f21099OxxIIOOXO.getEQPlotData(this.f21097OxI, i);
            i++;
        }
        II0xO0 iI0xO0 = this.f21105o00;
        if (iI0xO0 == null) {
            return;
        }
        this.f21093IIXOooo = iI0xO0.II0xO0(this.f21097OxI);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean enable) {
        super.setEnabled(enable);
        invalidate();
    }

    public void setFreqs(int[] freqs) {
        if (freqs.length == this.f21092IIX0o.length) {
            boolean z = true;
            for (int i = 0; i < freqs.length; i++) {
                if (freqs[i] != this.f21092IIX0o[i]) {
                    z = false;
                }
            }
            if (z) {
                return;
            }
        }
        this.f21092IIX0o = freqs;
        II0xO0 iI0xO0 = this.f21105o00;
        if (iI0xO0 != null) {
            iI0xO0.X0o0xo(SizeUtils.dp2px(20.0f));
            II0xO0 iI0xO02 = this.f21105o00;
            int[] iArr = this.f21092IIX0o;
            iI0xO02.XO(iArr[0], iArr[iArr.length - 1]);
        }
        int i2 = this.f21106oI0IIXIo;
        int[] iArr2 = this.f21092IIX0o;
        this.f21099OxxIIOOXO = new EQPlotCore(i2, iArr2.length, iArr2);
        if (this.f21097OxI == null) {
            this.f21097OxI = new float[((this.f21106oI0IIXIo - 2) * 4) + 4];
        }
        setData(this.f21108xoXoI);
    }

    public EqWaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f21106oI0IIXIo = 2000;
        this.f21108xoXoI = new int[10];
        this.f21105o00 = null;
        this.f21100X0IIOO = -8365077;
        this.f21101XI0IXoo = -8365077;
        this.f21102XIxXXX0x0 = 2136883691;
        this.f21109xxX = 13948116;
        this.f21104XxX0x0xxx = 12303291;
        this.f21107xXxxox0I = 12303291;
        this.f21092IIX0o = new int[]{31, 63, 125, 250, 500, 1000, 2000, 8000, 16000};
        I0Io(attrs, 0);
    }

    public EqWaveView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f21106oI0IIXIo = 2000;
        this.f21108xoXoI = new int[10];
        this.f21105o00 = null;
        this.f21100X0IIOO = -8365077;
        this.f21101XI0IXoo = -8365077;
        this.f21102XIxXXX0x0 = 2136883691;
        this.f21109xxX = 13948116;
        this.f21104XxX0x0xxx = 12303291;
        this.f21107xXxxox0I = 12303291;
        this.f21092IIX0o = new int[]{31, 63, 125, 250, 500, 1000, 2000, 8000, 16000};
        I0Io(attrs, defStyle);
    }
}
