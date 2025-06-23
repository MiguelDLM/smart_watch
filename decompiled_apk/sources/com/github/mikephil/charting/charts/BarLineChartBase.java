package com.github.mikephil.charting.charts;

import XI0oooXX.oxoX;
import XIXIX.OOXIXo;
import XIXIX.Oxx0IOOO;
import XIXIX.XO;
import XIXIX.oOoXoXO;
import XIXIX.xxIXOIIO;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import o0xxxXXxX.I0Io;
import xX0IIXIx0.IXxxXO;
import xX0IIXIx0.OxxIIOOXO;

@SuppressLint({"RtlHardcoded"})
/* loaded from: classes9.dex */
public abstract class BarLineChartBase<T extends I0Io<? extends IIxOXoOo0.II0xO0<? extends Entry>>> extends Chart<T> implements OOXIxO0.II0xO0 {

    /* renamed from: I0, reason: collision with root package name */
    public long f15814I0;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public boolean f15815I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public boolean f15816I0oOIX;

    /* renamed from: IIxOXoOo0, reason: collision with root package name */
    public IXxxXO f15817IIxOXoOo0;

    /* renamed from: IoOoo, reason: collision with root package name */
    public Paint f15818IoOoo;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public boolean f15819Ioxxx;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public OxxIIOOXO f15820O00XxXI;

    /* renamed from: O0X, reason: collision with root package name */
    public float[] f15821O0X;

    /* renamed from: O0Xx, reason: collision with root package name */
    public boolean f15822O0Xx;

    /* renamed from: OO, reason: collision with root package name */
    public Paint f15823OO;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public boolean f15824OO0x0xX;

    /* renamed from: OOXIxO0, reason: collision with root package name */
    public xxIXOIIO f15825OOXIxO0;

    /* renamed from: OX00O0xII, reason: collision with root package name */
    public Matrix f15826OX00O0xII;

    /* renamed from: XI0oooXX, reason: collision with root package name */
    public xxIXOIIO f15827XI0oooXX;

    /* renamed from: XIXIX, reason: collision with root package name */
    public float[] f15828XIXIX;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public float f15829XIo0oOXIx;

    /* renamed from: XX0, reason: collision with root package name */
    public boolean f15830XX0;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public YAxis f15831XX0xXo;

    /* renamed from: Xo0, reason: collision with root package name */
    public boolean f15832Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public boolean f15833XoI0Ixx0;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public YAxis f15834o0xxxXXxX;

    /* renamed from: oOo, reason: collision with root package name */
    public XO f15835oOo;

    /* renamed from: oX, reason: collision with root package name */
    public boolean f15836oX;

    /* renamed from: oXIO0o0XI, reason: collision with root package name */
    public XO f15837oXIO0o0XI;

    /* renamed from: ooOx, reason: collision with root package name */
    public long f15838ooOx;

    /* renamed from: ox, reason: collision with root package name */
    public OxxIIOOXO f15839ox;

    /* renamed from: x0xO, reason: collision with root package name */
    public boolean f15840x0xO;

    /* renamed from: xOOOX, reason: collision with root package name */
    public boolean f15841xOOOX;

    /* renamed from: xX0IIXIx0, reason: collision with root package name */
    public Matrix f15842xX0IIXIx0;

    /* renamed from: xXOx, reason: collision with root package name */
    public int f15843xXOx;

    /* renamed from: xoIxX, reason: collision with root package name */
    public boolean f15844xoIxX;

    /* renamed from: xoO0xx0, reason: collision with root package name */
    public RectF f15845xoO0xx0;

    /* renamed from: xoxXI, reason: collision with root package name */
    public boolean f15846xoxXI;

    /* renamed from: xxIO, reason: collision with root package name */
    public ooOx.I0Io f15847xxIO;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public static final /* synthetic */ int[] f15848I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f15849II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f15850oIX0oI;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            f15848I0Io = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15848I0Io[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            f15849II0xO0 = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15849II0xO0[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15849II0xO0[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f15850oIX0oI = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15850oIX0oI[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ float f15851IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ float f15852Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ float f15853Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ float f15854XO;

        public oIX0oI(float f, float f2, float f3, float f4) {
            this.f15854XO = f;
            this.f15852Oo = f2;
            this.f15851IXxxXO = f3;
            this.f15853Oxx0xo = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            BarLineChartBase.this.f15890xI.Io(this.f15854XO, this.f15852Oo, this.f15851IXxxXO, this.f15853Oxx0xo);
            BarLineChartBase.this.xOOOX();
            BarLineChartBase.this.XIXIX();
        }
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15843xXOx = 100;
        this.f15830XX0 = false;
        this.f15815I0X0x0oIo = false;
        this.f15836oX = true;
        this.f15832Xo0 = true;
        this.f15833XoI0Ixx0 = true;
        this.f15822O0Xx = true;
        this.f15816I0oOIX = true;
        this.f15846xoxXI = true;
        this.f15844xoIxX = false;
        this.f15840x0xO = false;
        this.f15824OO0x0xX = false;
        this.f15829XIo0oOXIx = 15.0f;
        this.f15819Ioxxx = false;
        this.f15814I0 = 0L;
        this.f15838ooOx = 0L;
        this.f15845xoO0xx0 = new RectF();
        this.f15826OX00O0xII = new Matrix();
        this.f15842xX0IIXIx0 = new Matrix();
        this.f15841xOOOX = false;
        this.f15828XIXIX = new float[2];
        this.f15837oXIO0o0XI = XO.II0xO0(OOXIXo.f3760XO, OOXIXo.f3760XO);
        this.f15835oOo = XO.II0xO0(OOXIXo.f3760XO, OOXIXo.f3760XO);
        this.f15821O0X = new float[2];
    }

    public boolean I0() {
        return this.f15816I0oOIX;
    }

    public void I0X0x0oIo(Canvas canvas) {
        if (this.f15844xoIxX) {
            canvas.drawRect(this.f15890xI.Oo(), this.f15823OO);
        }
        if (this.f15840x0xO) {
            canvas.drawRect(this.f15890xI.Oo(), this.f15818IoOoo);
        }
    }

    public XO I0oOIX(float f, float f2, YAxis.AxisDependency axisDependency) {
        return oxoX(axisDependency).XO(f, f2);
    }

    public void IIX0(float f, float f2) {
        this.f15890xI.xXOx(f);
        this.f15890xI.XX0(f2);
    }

    public boolean IIxOXoOo0() {
        return this.f15815I0X0x0oIo;
    }

    public void IoIOOxIIo(float f, float f2, float f3, float f4) {
        this.f15890xI.OO(f, f2, f3, -f4, this.f15826OX00O0xII);
        this.f15890xI.XOxIOxOx(this.f15826OX00O0xII, this, false);
        x0xO0oo();
        postInvalidate();
    }

    public void IoOoo(float f, float f2, YAxis.AxisDependency axisDependency, XO xo2) {
        oxoX(axisDependency).OOXIXo(f, f2, xo2);
    }

    public boolean Ioxxx() {
        return this.f15836oX;
    }

    public void O0(float f, float f2, YAxis.AxisDependency axisDependency) {
        this.f15890xI.xo0x(Xo0(axisDependency) / f, Xo0(axisDependency) / f2);
    }

    public boolean O00XxXI() {
        return this.f15840x0xO;
    }

    public void O0X() {
        this.f15890xI.OI0(this.f15826OX00O0xII);
        this.f15890xI.XOxIOxOx(this.f15826OX00O0xII, this, false);
        x0xO0oo();
        postInvalidate();
    }

    public Entry O0Xx(float f, float f2) {
        oxoX o002 = o00(f, f2);
        if (o002 != null) {
            return ((I0Io) this.f15871Oo).Oxx0xo(o002);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Paint O0xOxO(int i) {
        Paint O0xOxO2 = super.O0xOxO(i);
        if (O0xOxO2 != null) {
            return O0xOxO2;
        }
        if (i != 4) {
            return null;
        }
        return this.f15823OO;
    }

    public void OIOoIIOIx(float f, float f2) {
        Oxx0IOOO centerOffsets = getCenterOffsets();
        Matrix matrix = this.f15826OX00O0xII;
        this.f15890xI.OO(f, f2, centerOffsets.f3771IXxxXO, -centerOffsets.f3772Oxx0xo, matrix);
        this.f15890xI.XOxIOxOx(matrix, this, false);
    }

    public XO OO(float f, float f2, YAxis.AxisDependency axisDependency) {
        XO II0xO02 = XO.II0xO0(OOXIXo.f3760XO, OOXIXo.f3760XO);
        IoOoo(f, f2, axisDependency, II0xO02);
        return II0xO02;
    }

    public boolean OO0x0xX() {
        return this.f15830XX0;
    }

    public boolean OOXIxO0() {
        return this.f15819Ioxxx;
    }

    @TargetApi(11)
    public void OX00O0xII(float f, float f2, YAxis.AxisDependency axisDependency, long j) {
        XO OO2 = OO(this.f15890xI.II0XooXoX(), this.f15890xI.xoIox(), axisDependency);
        Oxx0IOOO(I0.oIX0oI.xoIox(this.f15890xI, f, f2 + ((Xo0(axisDependency) / this.f15890xI.o00()) / 2.0f), oxoX(axisDependency), this, (float) OO2.f3774IXxxXO, (float) OO2.f3775Oxx0xo, j));
        XO.I0Io(OO2);
    }

    public void OoO() {
        Oxx0IOOO x0xO0oo2 = this.f15890xI.x0xO0oo();
        this.f15890xI.XIo0oOXIx(x0xO0oo2.f3771IXxxXO, -x0xO0oo2.f3772Oxx0xo, this.f15826OX00O0xII);
        this.f15890xI.XOxIOxOx(this.f15826OX00O0xII, this, false);
        Oxx0IOOO.II0XooXoX(x0xO0oo2);
        x0xO0oo();
        postInvalidate();
    }

    public void Ox0O(float f, float f2) {
        float f3 = this.f15883o00.f4028xI;
        this.f15890xI.oxXx0IX(f3 / f, f3 / f2);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void X00IoxXI() {
        if (this.f15871Oo == 0) {
            if (this.f15879XO) {
                Log.i(Chart.f15859o0, "Preparing... DATA NOT SET.");
                return;
            }
            return;
        }
        if (this.f15879XO) {
            Log.i(Chart.f15859o0, "Preparing...");
        }
        xX0IIXIx0.Oxx0IOOO oxx0IOOO = this.f15863IIX0o;
        if (oxx0IOOO != null) {
            oxx0IOOO.xoIox();
        }
        oO();
        OxxIIOOXO oxxIIOOXO = this.f15820O00XxXI;
        YAxis yAxis = this.f15831XX0xXo;
        oxxIIOOXO.oIX0oI(yAxis.f4025ooXIXxIX, yAxis.f4006IIX0o, yAxis.oOo());
        OxxIIOOXO oxxIIOOXO2 = this.f15839ox;
        YAxis yAxis2 = this.f15834o0xxxXXxX;
        oxxIIOOXO2.oIX0oI(yAxis2.f4025ooXIXxIX, yAxis2.f4006IIX0o, yAxis2.oOo());
        IXxxXO iXxxXO = this.f15817IIxOXoOo0;
        XAxis xAxis = this.f15883o00;
        iXxxXO.oIX0oI(xAxis.f4025ooXIXxIX, xAxis.f4006IIX0o, false);
        if (this.f15876X0IIOO != null) {
            this.f15892xXxxox0I.oIX0oI(this.f15871Oo);
        }
        x0xO0oo();
    }

    @Override // OOXIxO0.II0xO0
    public boolean X0o0xo(YAxis.AxisDependency axisDependency) {
        return XO(axisDependency).oOo();
    }

    public boolean XI0oooXX() {
        return this.f15832Xo0;
    }

    public void XIXIX() {
        if (this.f15879XO) {
            Log.i(Chart.f15859o0, "Preparing Value-Px Matrix, xmin: " + this.f15883o00.f4025ooXIXxIX + ", xmax: " + this.f15883o00.f4006IIX0o + ", xdelta: " + this.f15883o00.f4028xI);
        }
        xxIXOIIO xxixoiio = this.f15825OOXIxO0;
        XAxis xAxis = this.f15883o00;
        float f = xAxis.f4025ooXIXxIX;
        float f2 = xAxis.f4028xI;
        YAxis yAxis = this.f15834o0xxxXXxX;
        xxixoiio.Oo(f, f2, yAxis.f4028xI, yAxis.f4025ooXIXxIX);
        xxIXOIIO xxixoiio2 = this.f15827XI0oooXX;
        XAxis xAxis2 = this.f15883o00;
        float f3 = xAxis2.f4025ooXIXxIX;
        float f4 = xAxis2.f4028xI;
        YAxis yAxis2 = this.f15831XX0xXo;
        xxixoiio2.Oo(f3, f4, yAxis2.f4028xI, yAxis2.f4025ooXIXxIX);
    }

    public void XIXIxO() {
        Oxx0IOOO x0xO0oo2 = this.f15890xI.x0xO0oo();
        this.f15890xI.x0xO(x0xO0oo2.f3771IXxxXO, -x0xO0oo2.f3772Oxx0xo, this.f15826OX00O0xII);
        this.f15890xI.XOxIOxOx(this.f15826OX00O0xII, this, false);
        Oxx0IOOO.II0XooXoX(x0xO0oo2);
        x0xO0oo();
        postInvalidate();
    }

    public boolean XIo0oOXIx() {
        return this.f15824OO0x0xX;
    }

    public YAxis XO(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.f15831XX0xXo;
        }
        return this.f15834o0xxxXXxX;
    }

    public void XX0(float f, YAxis.AxisDependency axisDependency) {
        Oxx0IOOO(I0.oxoX.oxoX(this.f15890xI, 0.0f, f + ((Xo0(axisDependency) / this.f15890xI.o00()) / 2.0f), oxoX(axisDependency), this));
    }

    public boolean XX0xXo() {
        return this.f15833XoI0Ixx0;
    }

    public float Xo0(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.f15831XX0xXo.f4028xI;
        }
        return this.f15834o0xxxXXxX.f4028xI;
    }

    public IIxOXoOo0.II0xO0 XoI0Ixx0(float f, float f2) {
        oxoX o002 = o00(f, f2);
        if (o002 != null) {
            return (IIxOXoOo0.II0xO0) ((I0Io) this.f15871Oo).OOXIXo(o002.oxoX());
        }
        return null;
    }

    public void XoX() {
        ((I0Io) this.f15871Oo).Oxx0IOOO(getLowestVisibleX(), getHighestVisibleX());
        this.f15883o00.x0XOIxOo(((I0Io) this.f15871Oo).OxI(), ((I0Io) this.f15871Oo).o00());
        if (this.f15831XX0xXo.XO()) {
            YAxis yAxis = this.f15831XX0xXo;
            I0Io i0Io = (I0Io) this.f15871Oo;
            YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
            yAxis.x0XOIxOo(i0Io.XIxXXX0x0(axisDependency), ((I0Io) this.f15871Oo).X0IIOO(axisDependency));
        }
        if (this.f15834o0xxxXXxX.XO()) {
            YAxis yAxis2 = this.f15834o0xxxXXxX;
            I0Io i0Io2 = (I0Io) this.f15871Oo;
            YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
            yAxis2.x0XOIxOo(i0Io2.XIxXXX0x0(axisDependency2), ((I0Io) this.f15871Oo).X0IIOO(axisDependency2));
        }
        x0xO0oo();
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.f15878XIxXXX0x0;
        if (chartTouchListener instanceof com.github.mikephil.charting.listener.oIX0oI) {
            ((com.github.mikephil.charting.listener.oIX0oI) chartTouchListener).II0XooXoX();
        }
    }

    public YAxis getAxisLeft() {
        return this.f15831XX0xXo;
    }

    public YAxis getAxisRight() {
        return this.f15834o0xxxXXxX;
    }

    @Override // com.github.mikephil.charting.charts.Chart, OOXIxO0.X0o0xo
    public /* bridge */ /* synthetic */ I0Io getData() {
        return (I0Io) super.getData();
    }

    public ooOx.I0Io getDrawListener() {
        return this.f15847xxIO;
    }

    @Override // OOXIxO0.II0xO0
    public float getHighestVisibleX() {
        oxoX(YAxis.AxisDependency.LEFT).OOXIXo(this.f15890xI.xxIXOIIO(), this.f15890xI.XO(), this.f15835oOo);
        return (float) Math.min(this.f15883o00.f4006IIX0o, this.f15835oOo.f3774IXxxXO);
    }

    @Override // OOXIxO0.II0xO0
    public float getLowestVisibleX() {
        oxoX(YAxis.AxisDependency.LEFT).OOXIXo(this.f15890xI.II0XooXoX(), this.f15890xI.XO(), this.f15837oXIO0o0XI);
        return (float) Math.max(this.f15883o00.f4025ooXIXxIX, this.f15837oXIO0o0XI.f3774IXxxXO);
    }

    @Override // OOXIxO0.X0o0xo
    public int getMaxVisibleCount() {
        return this.f15843xXOx;
    }

    public float getMinOffset() {
        return this.f15829XIo0oOXIx;
    }

    public OxxIIOOXO getRendererLeftYAxis() {
        return this.f15820O00XxXI;
    }

    public OxxIIOOXO getRendererRightYAxis() {
        return this.f15839ox;
    }

    public IXxxXO getRendererXAxis() {
        return this.f15817IIxOXoOo0;
    }

    @Override // android.view.View
    public float getScaleX() {
        oOoXoXO oooxoxo = this.f15890xI;
        if (oooxoxo == null) {
            return 1.0f;
        }
        return oooxoxo.xoXoI();
    }

    @Override // android.view.View
    public float getScaleY() {
        oOoXoXO oooxoxo = this.f15890xI;
        if (oooxoxo == null) {
            return 1.0f;
        }
        return oooxoxo.o00();
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // OOXIxO0.X0o0xo
    public float getYChartMax() {
        return Math.max(this.f15831XX0xXo.f4006IIX0o, this.f15834o0xxxXXxX.f4006IIX0o);
    }

    @Override // OOXIxO0.X0o0xo
    public float getYChartMin() {
        return Math.min(this.f15831XX0xXo.f4025ooXIXxIX, this.f15834o0xxxXXxX.f4025ooXIXxIX);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void o0(Paint paint, int i) {
        super.o0(paint, i);
        if (i == 4) {
            this.f15823OO = paint;
        }
    }

    @TargetApi(11)
    public void o0oIxOo(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency, long j) {
        XO OO2 = OO(this.f15890xI.II0XooXoX(), this.f15890xI.xoIox(), axisDependency);
        Oxx0IOOO(I0.I0Io.xoIox(this.f15890xI, this, oxoX(axisDependency), XO(axisDependency), this.f15883o00.f4028xI, f, f2, this.f15890xI.xoXoI(), this.f15890xI.o00(), f3, f4, (float) OO2.f3774IXxxXO, (float) OO2.f3775Oxx0xo, j));
        XO.I0Io(OO2);
    }

    public boolean o0xxxXXxX() {
        return this.f15822O0Xx;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void oO() {
        this.f15883o00.x0XOIxOo(((I0Io) this.f15871Oo).OxI(), ((I0Io) this.f15871Oo).o00());
        YAxis yAxis = this.f15831XX0xXo;
        I0Io i0Io = (I0Io) this.f15871Oo;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.x0XOIxOo(i0Io.XIxXXX0x0(axisDependency), ((I0Io) this.f15871Oo).X0IIOO(axisDependency));
        YAxis yAxis2 = this.f15834o0xxxXXxX;
        I0Io i0Io2 = (I0Io) this.f15871Oo;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.x0XOIxOo(i0Io2.XIxXXX0x0(axisDependency2), ((I0Io) this.f15871Oo).X0IIOO(axisDependency2));
    }

    public void oOo() {
        this.f15841xOOOX = false;
        x0xO0oo();
    }

    public void oX() {
        Matrix matrix = this.f15842xX0IIXIx0;
        this.f15890xI.ooOOo0oXI(matrix);
        this.f15890xI.XOxIOxOx(matrix, this, false);
        x0xO0oo();
        postInvalidate();
    }

    public void oXIO0o0XI() {
        this.f15814I0 = 0L;
        this.f15838ooOx = 0L;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15871Oo == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        I0X0x0oIo(canvas);
        if (this.f15830XX0) {
            XoX();
        }
        if (this.f15831XX0xXo.XO()) {
            OxxIIOOXO oxxIIOOXO = this.f15820O00XxXI;
            YAxis yAxis = this.f15831XX0xXo;
            oxxIIOOXO.oIX0oI(yAxis.f4025ooXIXxIX, yAxis.f4006IIX0o, yAxis.oOo());
        }
        if (this.f15834o0xxxXXxX.XO()) {
            OxxIIOOXO oxxIIOOXO2 = this.f15839ox;
            YAxis yAxis2 = this.f15834o0xxxXXxX;
            oxxIIOOXO2.oIX0oI(yAxis2.f4025ooXIXxIX, yAxis2.f4006IIX0o, yAxis2.oOo());
        }
        if (this.f15883o00.XO()) {
            IXxxXO iXxxXO = this.f15817IIxOXoOo0;
            XAxis xAxis = this.f15883o00;
            iXxxXO.oIX0oI(xAxis.f4025ooXIXxIX, xAxis.f4006IIX0o, false);
        }
        this.f15817IIxOXoOo0.II0XooXoX(canvas);
        this.f15820O00XxXI.II0XooXoX(canvas);
        this.f15839ox.II0XooXoX(canvas);
        if (this.f15883o00.Xx000oIo()) {
            this.f15817IIxOXoOo0.xxIXOIIO(canvas);
        }
        if (this.f15831XX0xXo.Xx000oIo()) {
            this.f15820O00XxXI.xxIXOIIO(canvas);
        }
        if (this.f15834o0xxxXXxX.Xx000oIo()) {
            this.f15839ox.xxIXOIIO(canvas);
        }
        if (this.f15883o00.XO() && this.f15883o00.xII()) {
            this.f15817IIxOXoOo0.xoIox(canvas);
        }
        if (this.f15831XX0xXo.XO() && this.f15831XX0xXo.xII()) {
            this.f15820O00XxXI.xoIox(canvas);
        }
        if (this.f15834o0xxxXXxX.XO() && this.f15834o0xxxXXxX.xII()) {
            this.f15839ox.xoIox(canvas);
        }
        int save = canvas.save();
        canvas.clipRect(this.f15890xI.Oo());
        this.f15863IIX0o.II0xO0(canvas);
        if (!this.f15883o00.Xx000oIo()) {
            this.f15817IIxOXoOo0.xxIXOIIO(canvas);
        }
        if (!this.f15831XX0xXo.Xx000oIo()) {
            this.f15820O00XxXI.xxIXOIIO(canvas);
        }
        if (!this.f15834o0xxxXXxX.Xx000oIo()) {
            this.f15839ox.xxIXOIIO(canvas);
        }
        if (oxxXoxO()) {
            this.f15863IIX0o.oxoX(canvas, this.f15865IO);
        }
        canvas.restoreToCount(save);
        this.f15863IIX0o.I0Io(canvas);
        if (this.f15883o00.XO() && !this.f15883o00.xII()) {
            this.f15817IIxOXoOo0.xoIox(canvas);
        }
        if (this.f15831XX0xXo.XO() && !this.f15831XX0xXo.xII()) {
            this.f15820O00XxXI.xoIox(canvas);
        }
        if (this.f15834o0xxxXXxX.XO() && !this.f15834o0xxxXXxX.xII()) {
            this.f15839ox.xoIox(canvas);
        }
        this.f15817IIxOXoOo0.Oxx0IOOO(canvas);
        this.f15820O00XxXI.Oxx0IOOO(canvas);
        this.f15839ox.Oxx0IOOO(canvas);
        if (XIo0oOXIx()) {
            int save2 = canvas.save();
            canvas.clipRect(this.f15890xI.Oo());
            this.f15863IIX0o.XO(canvas);
            canvas.restoreToCount(save2);
        } else {
            this.f15863IIX0o.XO(canvas);
        }
        this.f15892xXxxox0I.XO(canvas);
        OxxIIOOXO(canvas);
        IIXOooo(canvas);
        if (this.f15879XO) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            long j = this.f15814I0 + currentTimeMillis2;
            this.f15814I0 = j;
            long j2 = this.f15838ooOx + 1;
            this.f15838ooOx = j2;
            Log.i(Chart.f15859o0, "Drawtime: " + currentTimeMillis2 + " ms, average: " + (j / j2) + " ms, cycles: " + this.f15838ooOx);
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float[] fArr = this.f15821O0X;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.f15819Ioxxx) {
            fArr[0] = this.f15890xI.II0XooXoX();
            this.f15821O0X[1] = this.f15890xI.xoIox();
            oxoX(YAxis.AxisDependency.LEFT).x0XOIxOo(this.f15821O0X);
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f15819Ioxxx) {
            oxoX(YAxis.AxisDependency.LEFT).oO(this.f15821O0X);
            this.f15890xI.X0o0xo(this.f15821O0X, this);
        } else {
            oOoXoXO oooxoxo = this.f15890xI;
            oooxoxo.XOxIOxOx(oooxoxo.IXxxXO(), this, true);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        ChartTouchListener chartTouchListener = this.f15878XIxXXX0x0;
        if (chartTouchListener == null || this.f15871Oo == 0 || !this.f15872OxI) {
            return false;
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    public boolean ooOx() {
        return this.f15846xoxXI;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void ooXIXxIX() {
        super.ooXIXxIX();
        this.f15831XX0xXo = new YAxis(YAxis.AxisDependency.LEFT);
        this.f15834o0xxxXXxX = new YAxis(YAxis.AxisDependency.RIGHT);
        this.f15827XI0oooXX = new xxIXOIIO(this.f15890xI);
        this.f15825OOXIxO0 = new xxIXOIIO(this.f15890xI);
        this.f15820O00XxXI = new OxxIIOOXO(this.f15890xI, this.f15831XX0xXo, this.f15827XI0oooXX);
        this.f15839ox = new OxxIIOOXO(this.f15890xI, this.f15834o0xxxXXxX, this.f15825OOXIxO0);
        this.f15817IIxOXoOo0 = new IXxxXO(this.f15890xI, this.f15883o00, this.f15827XI0oooXX);
        setHighlighter(new XI0oooXX.II0xO0(this));
        this.f15878XIxXXX0x0 = new com.github.mikephil.charting.listener.oIX0oI(this, this.f15890xI.IXxxXO(), 3.0f);
        Paint paint = new Paint();
        this.f15823OO = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f15823OO.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.f15818IoOoo = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f15818IoOoo.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f15818IoOoo.setStrokeWidth(OOXIXo.X0o0xo(1.0f));
    }

    public boolean ox() {
        return this.f15890xI.xxX();
    }

    public void oxIIX0o(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency) {
        Oxx0IOOO(I0.XO.oxoX(this.f15890xI, f, f2, f3, f4, oxoX(axisDependency), axisDependency, this));
    }

    public void oxXx0IX(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.f15876X0IIOO;
        if (legend != null && legend.XO() && !this.f15876X0IIOO.ooXIXxIX()) {
            int i = II0xO0.f15848I0Io[this.f15876X0IIOO.XIxXXX0x0().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    int i2 = II0xO0.f15850oIX0oI[this.f15876X0IIOO.XxX0x0xxx().ordinal()];
                    if (i2 != 1) {
                        if (i2 == 2) {
                            rectF.bottom += Math.min(this.f15876X0IIOO.f15943OxI, this.f15890xI.x0XOIxOo() * this.f15876X0IIOO.O0xOxO()) + this.f15876X0IIOO.X0o0xo();
                            return;
                        }
                        return;
                    }
                    rectF.top += Math.min(this.f15876X0IIOO.f15943OxI, this.f15890xI.x0XOIxOo() * this.f15876X0IIOO.O0xOxO()) + this.f15876X0IIOO.X0o0xo();
                    return;
                }
                return;
            }
            int i3 = II0xO0.f15849II0xO0[this.f15876X0IIOO.OxI().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        int i4 = II0xO0.f15850oIX0oI[this.f15876X0IIOO.XxX0x0xxx().ordinal()];
                        if (i4 != 1) {
                            if (i4 == 2) {
                                rectF.bottom += Math.min(this.f15876X0IIOO.f15943OxI, this.f15890xI.x0XOIxOo() * this.f15876X0IIOO.O0xOxO()) + this.f15876X0IIOO.X0o0xo();
                                return;
                            }
                            return;
                        }
                        rectF.top += Math.min(this.f15876X0IIOO.f15943OxI, this.f15890xI.x0XOIxOo() * this.f15876X0IIOO.O0xOxO()) + this.f15876X0IIOO.X0o0xo();
                        return;
                    }
                    return;
                }
                rectF.right += Math.min(this.f15876X0IIOO.f15951o00, this.f15890xI.oO() * this.f15876X0IIOO.O0xOxO()) + this.f15876X0IIOO.oxoX();
                return;
            }
            rectF.left += Math.min(this.f15876X0IIOO.f15951o00, this.f15890xI.oO() * this.f15876X0IIOO.O0xOxO()) + this.f15876X0IIOO.oxoX();
        }
    }

    @Override // OOXIxO0.II0xO0
    public xxIXOIIO oxoX(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            return this.f15827XI0oooXX;
        }
        return this.f15825OOXIxO0;
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.f15830XX0 = z;
    }

    public void setBorderColor(int i) {
        this.f15818IoOoo.setColor(i);
    }

    public void setBorderWidth(float f) {
        this.f15818IoOoo.setStrokeWidth(OOXIXo.X0o0xo(f));
    }

    public void setClipValuesToContent(boolean z) {
        this.f15824OO0x0xX = z;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.f15836oX = z;
    }

    public void setDragEnabled(boolean z) {
        this.f15833XoI0Ixx0 = z;
        this.f15822O0Xx = z;
    }

    public void setDragOffsetX(float f) {
        this.f15890xI.XX(f);
    }

    public void setDragOffsetY(float f) {
        this.f15890xI.I0oOoX(f);
    }

    public void setDragXEnabled(boolean z) {
        this.f15833XoI0Ixx0 = z;
    }

    public void setDragYEnabled(boolean z) {
        this.f15822O0Xx = z;
    }

    public void setDrawBorders(boolean z) {
        this.f15840x0xO = z;
    }

    public void setDrawGridBackground(boolean z) {
        this.f15844xoIxX = z;
    }

    public void setGridBackgroundColor(int i) {
        this.f15823OO.setColor(i);
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.f15832Xo0 = z;
    }

    public void setKeepPositionOnRotation(boolean z) {
        this.f15819Ioxxx = z;
    }

    public void setMaxVisibleValueCount(int i) {
        this.f15843xXOx = i;
    }

    public void setMinOffset(float f) {
        this.f15829XIo0oOXIx = f;
    }

    public void setOnDrawListener(ooOx.I0Io i0Io) {
        this.f15847xxIO = i0Io;
    }

    public void setPinchZoom(boolean z) {
        this.f15815I0X0x0oIo = z;
    }

    public void setRendererLeftYAxis(OxxIIOOXO oxxIIOOXO) {
        this.f15820O00XxXI = oxxIIOOXO;
    }

    public void setRendererRightYAxis(OxxIIOOXO oxxIIOOXO) {
        this.f15839ox = oxxIIOOXO;
    }

    public void setScaleEnabled(boolean z) {
        this.f15816I0oOIX = z;
        this.f15846xoxXI = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.f15816I0oOIX = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.f15846xoxXI = z;
    }

    public void setVisibleXRangeMaximum(float f) {
        this.f15890xI.xXOx(this.f15883o00.f4028xI / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.f15890xI.oxxXoxO(this.f15883o00.f4028xI / f);
    }

    public void setXAxisRenderer(IXxxXO iXxxXO) {
        this.f15817IIxOXoOo0 = iXxxXO;
    }

    public boolean x0xO() {
        if (this.f15831XX0xXo.oOo() || this.f15834o0xxxXXxX.oOo()) {
            return true;
        }
        return false;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void x0xO0oo() {
        if (!this.f15841xOOOX) {
            oxXx0IX(this.f15845xoO0xx0);
            RectF rectF = this.f15845xoO0xx0;
            float f = rectF.left + 0.0f;
            float f2 = rectF.top + 0.0f;
            float f3 = rectF.right + 0.0f;
            float f4 = rectF.bottom + 0.0f;
            if (this.f15831XX0xXo.xOoOIoI()) {
                f += this.f15831XX0xXo.I0(this.f15820O00XxXI.I0Io());
            }
            if (this.f15834o0xxxXXxX.xOoOIoI()) {
                f3 += this.f15834o0xxxXXxX.I0(this.f15839ox.I0Io());
            }
            if (this.f15883o00.XO() && this.f15883o00.IO()) {
                float X0o0xo2 = r2.f15977oOXoIIIo + this.f15883o00.X0o0xo();
                if (this.f15883o00.ox() == XAxis.XAxisPosition.BOTTOM) {
                    f4 += X0o0xo2;
                } else {
                    if (this.f15883o00.ox() != XAxis.XAxisPosition.TOP) {
                        if (this.f15883o00.ox() == XAxis.XAxisPosition.BOTH_SIDED) {
                            f4 += X0o0xo2;
                        }
                    }
                    f2 += X0o0xo2;
                }
            }
            float extraTopOffset = f2 + getExtraTopOffset();
            float extraRightOffset = f3 + getExtraRightOffset();
            float extraBottomOffset = f4 + getExtraBottomOffset();
            float extraLeftOffset = f + getExtraLeftOffset();
            float X0o0xo3 = OOXIXo.X0o0xo(this.f15829XIo0oOXIx);
            this.f15890xI.Io(Math.max(X0o0xo3, extraLeftOffset), Math.max(X0o0xo3, extraTopOffset), Math.max(X0o0xo3, extraRightOffset), Math.max(X0o0xo3, extraBottomOffset));
            if (this.f15879XO) {
                Log.i(Chart.f15859o0, "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                StringBuilder sb = new StringBuilder();
                sb.append("Content: ");
                sb.append(this.f15890xI.Oo().toString());
                Log.i(Chart.f15859o0, sb.toString());
            }
        }
        xOOOX();
        XIXIX();
    }

    public void xI0oxI00(float f, YAxis.AxisDependency axisDependency) {
        this.f15890xI.XoX(Xo0(axisDependency) / f);
    }

    public void xOOOX() {
        this.f15825OOXIxO0.x0xO0oo(this.f15834o0xxxXXxX.oOo());
        this.f15827XI0oooXX.x0xO0oo(this.f15831XX0xXo.oOo());
    }

    public void xOoOIoI(float f, float f2, float f3, float f4) {
        this.f15841xOOOX = true;
        post(new oIX0oI(f, f2, f3, f4));
    }

    public void xX0IIXIx0(float f) {
        Oxx0IOOO(I0.oxoX.oxoX(this.f15890xI, f, 0.0f, oxoX(YAxis.AxisDependency.LEFT), this));
    }

    @TargetApi(11)
    public void xXOx(float f, float f2, YAxis.AxisDependency axisDependency, long j) {
        XO OO2 = OO(this.f15890xI.II0XooXoX(), this.f15890xI.xoIox(), axisDependency);
        float Xo02 = Xo0(axisDependency) / this.f15890xI.o00();
        Oxx0IOOO(I0.oIX0oI.xoIox(this.f15890xI, f - ((getXAxis().f4028xI / this.f15890xI.xoXoI()) / 2.0f), f2 + (Xo02 / 2.0f), oxoX(axisDependency), this, (float) OO2.f3774IXxxXO, (float) OO2.f3775Oxx0xo, j));
        XO.I0Io(OO2);
    }

    public void xo0x(float f, float f2, YAxis.AxisDependency axisDependency) {
        float Xo02 = Xo0(axisDependency) / this.f15890xI.o00();
        Oxx0IOOO(I0.oxoX.oxoX(this.f15890xI, f - ((getXAxis().f4028xI / this.f15890xI.xoXoI()) / 2.0f), f2 + (Xo02 / 2.0f), oxoX(axisDependency), this));
    }

    public boolean xoIxX() {
        return this.f15890xI.XIxXXX0x0();
    }

    public void xoO0xx0(float f, float f2, YAxis.AxisDependency axisDependency) {
        Oxx0IOOO(I0.oxoX.oxoX(this.f15890xI, f, f2 + ((Xo0(axisDependency) / this.f15890xI.o00()) / 2.0f), oxoX(axisDependency), this));
    }

    public Oxx0IOOO xoxXI(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        this.f15828XIXIX[0] = entry.xxIXOIIO();
        this.f15828XIXIX[1] = entry.I0Io();
        oxoX(axisDependency).oO(this.f15828XIXIX);
        float[] fArr = this.f15828XIXIX;
        return Oxx0IOOO.I0Io(fArr[0], fArr[1]);
    }

    public void xx0X0(float f, YAxis.AxisDependency axisDependency) {
        this.f15890xI.XX0(Xo0(axisDependency) / f);
    }

    public boolean xxIO() {
        if (!this.f15833XoI0Ixx0 && !this.f15822O0Xx) {
            return false;
        }
        return true;
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15843xXOx = 100;
        this.f15830XX0 = false;
        this.f15815I0X0x0oIo = false;
        this.f15836oX = true;
        this.f15832Xo0 = true;
        this.f15833XoI0Ixx0 = true;
        this.f15822O0Xx = true;
        this.f15816I0oOIX = true;
        this.f15846xoxXI = true;
        this.f15844xoIxX = false;
        this.f15840x0xO = false;
        this.f15824OO0x0xX = false;
        this.f15829XIo0oOXIx = 15.0f;
        this.f15819Ioxxx = false;
        this.f15814I0 = 0L;
        this.f15838ooOx = 0L;
        this.f15845xoO0xx0 = new RectF();
        this.f15826OX00O0xII = new Matrix();
        this.f15842xX0IIXIx0 = new Matrix();
        this.f15841xOOOX = false;
        this.f15828XIXIX = new float[2];
        this.f15837oXIO0o0XI = XO.II0xO0(OOXIXo.f3760XO, OOXIXo.f3760XO);
        this.f15835oOo = XO.II0xO0(OOXIXo.f3760XO, OOXIXo.f3760XO);
        this.f15821O0X = new float[2];
    }

    public BarLineChartBase(Context context) {
        super(context);
        this.f15843xXOx = 100;
        this.f15830XX0 = false;
        this.f15815I0X0x0oIo = false;
        this.f15836oX = true;
        this.f15832Xo0 = true;
        this.f15833XoI0Ixx0 = true;
        this.f15822O0Xx = true;
        this.f15816I0oOIX = true;
        this.f15846xoxXI = true;
        this.f15844xoIxX = false;
        this.f15840x0xO = false;
        this.f15824OO0x0xX = false;
        this.f15829XIo0oOXIx = 15.0f;
        this.f15819Ioxxx = false;
        this.f15814I0 = 0L;
        this.f15838ooOx = 0L;
        this.f15845xoO0xx0 = new RectF();
        this.f15826OX00O0xII = new Matrix();
        this.f15842xX0IIXIx0 = new Matrix();
        this.f15841xOOOX = false;
        this.f15828XIXIX = new float[2];
        this.f15837oXIO0o0XI = XO.II0xO0(OOXIXo.f3760XO, OOXIXo.f3760XO);
        this.f15835oOo = XO.II0xO0(OOXIXo.f3760XO, OOXIXo.f3760XO);
        this.f15821O0X = new float[2];
    }
}
