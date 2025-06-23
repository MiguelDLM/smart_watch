package com.github.mikephil.charting.charts;

import IIxOXoOo0.xxIXOIIO;
import XI0oooXX.oxoX;
import XIXIX.OOXIXo;
import XIXIX.Oxx0IOOO;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import java.util.List;
import o0xxxXXxX.x0xO0oo;
import xX0IIXIx0.ooOOo0oXI;

/* loaded from: classes9.dex */
public class PieChart extends PieRadarChartBase<x0xO0oo> {

    /* renamed from: I0oOIX, reason: collision with root package name */
    public float[] f15903I0oOIX;

    /* renamed from: IoOoo, reason: collision with root package name */
    public boolean f15904IoOoo;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public float f15905Ioxxx;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public float f15906O00XxXI;

    /* renamed from: O0Xx, reason: collision with root package name */
    public float[] f15907O0Xx;

    /* renamed from: OO, reason: collision with root package name */
    public boolean f15908OO;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public Oxx0IOOO f15909OO0x0xX;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public float f15910XIo0oOXIx;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public float f15911XX0xXo;

    /* renamed from: Xo0, reason: collision with root package name */
    public RectF f15912Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public boolean f15913XoI0Ixx0;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public float f15914o0xxxXXxX;

    /* renamed from: x0xO, reason: collision with root package name */
    public CharSequence f15915x0xO;

    /* renamed from: xoIxX, reason: collision with root package name */
    public boolean f15916xoIxX;

    /* renamed from: xoxXI, reason: collision with root package name */
    public boolean f15917xoxXI;

    /* renamed from: xxIO, reason: collision with root package name */
    public boolean f15918xxIO;

    public PieChart(Context context) {
        super(context);
        this.f15912Xo0 = new RectF();
        this.f15913XoI0Ixx0 = true;
        this.f15907O0Xx = new float[1];
        this.f15903I0oOIX = new float[1];
        this.f15917xoxXI = true;
        this.f15908OO = false;
        this.f15904IoOoo = false;
        this.f15916xoIxX = false;
        this.f15915x0xO = "";
        this.f15909OO0x0xX = Oxx0IOOO.I0Io(0.0f, 0.0f);
        this.f15910XIo0oOXIx = 50.0f;
        this.f15905Ioxxx = 55.0f;
        this.f15918xxIO = true;
        this.f15911XX0xXo = 100.0f;
        this.f15914o0xxxXXxX = 360.0f;
        this.f15906O00XxXI = 0.0f;
    }

    public int I0oOIX(int i) {
        List<xxIXOIIO> Oo2 = ((x0xO0oo) this.f15871Oo).Oo();
        for (int i2 = 0; i2 < Oo2.size(); i2++) {
            if (Oo2.get(i2).Ox0O(i, Float.NaN) != null) {
                return i2;
            }
        }
        return -1;
    }

    public boolean IoOoo() {
        return this.f15917xoxXI;
    }

    public void Ioxxx(float f, float f2) {
        this.f15909OO0x0xX.f3771IXxxXO = OOXIXo.X0o0xo(f);
        this.f15909OO0x0xX.f3772Oxx0xo = OOXIXo.X0o0xo(f2);
    }

    public final void O0Xx() {
        boolean z;
        int IXxxXO2 = ((x0xO0oo) this.f15871Oo).IXxxXO();
        if (this.f15907O0Xx.length != IXxxXO2) {
            this.f15907O0Xx = new float[IXxxXO2];
        } else {
            for (int i = 0; i < IXxxXO2; i++) {
                this.f15907O0Xx[i] = 0.0f;
            }
        }
        if (this.f15903I0oOIX.length != IXxxXO2) {
            this.f15903I0oOIX = new float[IXxxXO2];
        } else {
            for (int i2 = 0; i2 < IXxxXO2; i2++) {
                this.f15903I0oOIX[i2] = 0.0f;
            }
        }
        float OI02 = ((x0xO0oo) this.f15871Oo).OI0();
        List<xxIXOIIO> Oo2 = ((x0xO0oo) this.f15871Oo).Oo();
        float f = this.f15906O00XxXI;
        if (f != 0.0f && IXxxXO2 * f <= this.f15914o0xxxXXxX) {
            z = true;
        } else {
            z = false;
        }
        float[] fArr = new float[IXxxXO2];
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i3 = 0;
        for (int i4 = 0; i4 < ((x0xO0oo) this.f15871Oo).ooOOo0oXI(); i4++) {
            xxIXOIIO xxixoiio = Oo2.get(i4);
            for (int i5 = 0; i5 < xxixoiio.X0xxXX0(); i5++) {
                float XoI0Ixx02 = XoI0Ixx0(Math.abs(xxixoiio.OOXIXo(i5).I0Io()), OI02);
                if (z) {
                    float f4 = this.f15906O00XxXI;
                    float f5 = XoI0Ixx02 - f4;
                    if (f5 <= 0.0f) {
                        fArr[i3] = f4;
                        f2 += -f5;
                    } else {
                        fArr[i3] = XoI0Ixx02;
                        f3 += f5;
                    }
                }
                this.f15907O0Xx[i3] = XoI0Ixx02;
                if (i3 == 0) {
                    this.f15903I0oOIX[i3] = XoI0Ixx02;
                } else {
                    float[] fArr2 = this.f15903I0oOIX;
                    fArr2[i3] = fArr2[i3 - 1] + XoI0Ixx02;
                }
                i3++;
            }
        }
        if (z) {
            for (int i6 = 0; i6 < IXxxXO2; i6++) {
                float f6 = fArr[i6];
                float f7 = f6 - (((f6 - this.f15906O00XxXI) / f3) * f2);
                fArr[i6] = f7;
                if (i6 == 0) {
                    this.f15903I0oOIX[0] = fArr[0];
                } else {
                    float[] fArr3 = this.f15903I0oOIX;
                    fArr3[i6] = fArr3[i6 - 1] + f7;
                }
            }
            this.f15907O0Xx = fArr;
        }
    }

    public boolean OO() {
        return this.f15913XoI0Ixx0;
    }

    public boolean OO0x0xX() {
        return this.f15904IoOoo;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public float[] OxI(oxoX oxox) {
        Oxx0IOOO centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f = (radius / 10.0f) * 3.6f;
        if (IoOoo()) {
            f = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f2 = radius - f;
        float rotationAngle = getRotationAngle();
        float f3 = this.f15907O0Xx[(int) oxox.II0XooXoX()] / 2.0f;
        double d = f2;
        float cos = (float) ((Math.cos(Math.toRadians(((this.f15903I0oOIX[r11] + rotationAngle) - f3) * this.f15887oo0xXOI0I.xxIXOIIO())) * d) + centerCircleBox.f3771IXxxXO);
        float sin = (float) ((d * Math.sin(Math.toRadians(((rotationAngle + this.f15903I0oOIX[r11]) - f3) * this.f15887oo0xXOI0I.xxIXOIIO()))) + centerCircleBox.f3772Oxx0xo);
        Oxx0IOOO.II0XooXoX(centerCircleBox);
        return new float[]{cos, sin};
    }

    public boolean XIo0oOXIx(int i) {
        if (!oxxXoxO()) {
            return false;
        }
        int i2 = 0;
        while (true) {
            oxoX[] oxoxArr = this.f15865IO;
            if (i2 >= oxoxArr.length) {
                return false;
            }
            if (((int) oxoxArr[i2].II0XooXoX()) == i) {
                return true;
            }
            i2++;
        }
    }

    public final float Xo0(float f) {
        return XoI0Ixx0(f, ((x0xO0oo) this.f15871Oo).OI0());
    }

    public final float XoI0Ixx0(float f, float f2) {
        return (f / f2) * this.f15914o0xxxXXxX;
    }

    public float[] getAbsoluteAngles() {
        return this.f15903I0oOIX;
    }

    public Oxx0IOOO getCenterCircleBox() {
        return Oxx0IOOO.I0Io(this.f15912Xo0.centerX(), this.f15912Xo0.centerY());
    }

    public CharSequence getCenterText() {
        return this.f15915x0xO;
    }

    public Oxx0IOOO getCenterTextOffset() {
        Oxx0IOOO oxx0IOOO = this.f15909OO0x0xX;
        return Oxx0IOOO.I0Io(oxx0IOOO.f3771IXxxXO, oxx0IOOO.f3772Oxx0xo);
    }

    public float getCenterTextRadiusPercent() {
        return this.f15911XX0xXo;
    }

    public RectF getCircleBox() {
        return this.f15912Xo0;
    }

    public float[] getDrawAngles() {
        return this.f15907O0Xx;
    }

    public float getHoleRadius() {
        return this.f15910XIo0oOXIx;
    }

    public float getMaxAngle() {
        return this.f15914o0xxxXXxX;
    }

    public float getMinAngleForSlices() {
        return this.f15906O00XxXI;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.f15912Xo0;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.f15912Xo0.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredLegendOffset() {
        return this.f15892xXxxox0I.X0o0xo().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.f15905Ioxxx;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void oO() {
        O0Xx();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        xX0IIXIx0.Oxx0IOOO oxx0IOOO = this.f15863IIX0o;
        if (oxx0IOOO != null && (oxx0IOOO instanceof ooOOo0oXI)) {
            ((ooOOo0oXI) oxx0IOOO).xoXoI();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15871Oo == 0) {
            return;
        }
        this.f15863IIX0o.II0xO0(canvas);
        if (oxxXoxO()) {
            this.f15863IIX0o.oxoX(canvas, this.f15865IO);
        }
        this.f15863IIX0o.I0Io(canvas);
        this.f15863IIX0o.XO(canvas);
        this.f15892xXxxox0I.XO(canvas);
        OxxIIOOXO(canvas);
        IIXOooo(canvas);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15863IIX0o = new ooOOo0oXI(this, this.f15887oo0xXOI0I, this.f15890xI);
        this.f15883o00 = null;
        this.f15888ooXIXxIX = new XI0oooXX.Oxx0IOOO(this);
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.f15915x0xO = "";
        } else {
            this.f15915x0xO = charSequence;
        }
    }

    public void setCenterTextColor(int i) {
        ((ooOOo0oXI) this.f15863IIX0o).IXxxXO().setColor(i);
    }

    public void setCenterTextRadiusPercent(float f) {
        this.f15911XX0xXo = f;
    }

    public void setCenterTextSize(float f) {
        ((ooOOo0oXI) this.f15863IIX0o).IXxxXO().setTextSize(OOXIXo.X0o0xo(f));
    }

    public void setCenterTextSizePixels(float f) {
        ((ooOOo0oXI) this.f15863IIX0o).IXxxXO().setTextSize(f);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((ooOOo0oXI) this.f15863IIX0o).IXxxXO().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z) {
        this.f15918xxIO = z;
    }

    public void setDrawEntryLabels(boolean z) {
        this.f15913XoI0Ixx0 = z;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.f15917xoxXI = z;
    }

    public void setDrawRoundedSlices(boolean z) {
        this.f15916xoIxX = z;
    }

    @Deprecated
    public void setDrawSliceText(boolean z) {
        this.f15913XoI0Ixx0 = z;
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.f15908OO = z;
    }

    public void setEntryLabelColor(int i) {
        ((ooOOo0oXI) this.f15863IIX0o).Oxx0xo().setColor(i);
    }

    public void setEntryLabelTextSize(float f) {
        ((ooOOo0oXI) this.f15863IIX0o).Oxx0xo().setTextSize(OOXIXo.X0o0xo(f));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((ooOOo0oXI) this.f15863IIX0o).Oxx0xo().setTypeface(typeface);
    }

    public void setHoleColor(int i) {
        ((ooOOo0oXI) this.f15863IIX0o).oI0IIXIo().setColor(i);
    }

    public void setHoleRadius(float f) {
        this.f15910XIo0oOXIx = f;
    }

    public void setMaxAngle(float f) {
        if (f > 360.0f) {
            f = 360.0f;
        }
        if (f < 90.0f) {
            f = 90.0f;
        }
        this.f15914o0xxxXXxX = f;
    }

    public void setMinAngleForSlices(float f) {
        float f2 = this.f15914o0xxxXXxX;
        if (f > f2 / 2.0f) {
            f = f2 / 2.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f15906O00XxXI = f;
    }

    public void setTransparentCircleAlpha(int i) {
        ((ooOOo0oXI) this.f15863IIX0o).OxxIIOOXO().setAlpha(i);
    }

    public void setTransparentCircleColor(int i) {
        Paint OxxIIOOXO2 = ((ooOOo0oXI) this.f15863IIX0o).OxxIIOOXO();
        int alpha = OxxIIOOXO2.getAlpha();
        OxxIIOOXO2.setColor(i);
        OxxIIOOXO2.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f) {
        this.f15905Ioxxx = f;
    }

    public void setUsePercentValues(boolean z) {
        this.f15904IoOoo = z;
    }

    public boolean x0xO() {
        return this.f15908OO;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void x0xO0oo() {
        super.x0xO0oo();
        if (this.f15871Oo == 0) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        Oxx0IOOO centerOffsets = getCenterOffsets();
        float xoXoI2 = ((x0xO0oo) this.f15871Oo).xII().xoXoI();
        RectF rectF = this.f15912Xo0;
        float f = centerOffsets.f3771IXxxXO;
        float f2 = centerOffsets.f3772Oxx0xo;
        rectF.set((f - diameter) + xoXoI2, (f2 - diameter) + xoXoI2, (f + diameter) - xoXoI2, (f2 + diameter) - xoXoI2);
        Oxx0IOOO.II0XooXoX(centerOffsets);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int xo0x(float f) {
        float O0xOxO2 = OOXIXo.O0xOxO(f - getRotationAngle());
        int i = 0;
        while (true) {
            float[] fArr = this.f15903I0oOIX;
            if (i < fArr.length) {
                if (fArr[i] > O0xOxO2) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    public boolean xoIxX() {
        return this.f15916xoIxX;
    }

    public boolean xoxXI() {
        return this.f15918xxIO;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15912Xo0 = new RectF();
        this.f15913XoI0Ixx0 = true;
        this.f15907O0Xx = new float[1];
        this.f15903I0oOIX = new float[1];
        this.f15917xoxXI = true;
        this.f15908OO = false;
        this.f15904IoOoo = false;
        this.f15916xoIxX = false;
        this.f15915x0xO = "";
        this.f15909OO0x0xX = Oxx0IOOO.I0Io(0.0f, 0.0f);
        this.f15910XIo0oOXIx = 50.0f;
        this.f15905Ioxxx = 55.0f;
        this.f15918xxIO = true;
        this.f15911XX0xXo = 100.0f;
        this.f15914o0xxxXXxX = 360.0f;
        this.f15906O00XxXI = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15912Xo0 = new RectF();
        this.f15913XoI0Ixx0 = true;
        this.f15907O0Xx = new float[1];
        this.f15903I0oOIX = new float[1];
        this.f15917xoxXI = true;
        this.f15908OO = false;
        this.f15904IoOoo = false;
        this.f15916xoIxX = false;
        this.f15915x0xO = "";
        this.f15909OO0x0xX = Oxx0IOOO.I0Io(0.0f, 0.0f);
        this.f15910XIo0oOXIx = 50.0f;
        this.f15905Ioxxx = 55.0f;
        this.f15918xxIO = true;
        this.f15911XX0xXo = 100.0f;
        this.f15914o0xxxXXxX = 360.0f;
        this.f15906O00XxXI = 0.0f;
    }
}
