package xX0IIXIx0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes9.dex */
public class ooOOo0oXI extends Oxx0IOOO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public Paint f34565II0XooXoX;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public Path f34566IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Canvas f34567IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public TextPaint f34568OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public WeakReference<Bitmap> f34569Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public PieChart f34570Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Path f34571Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Path f34572OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public RectF f34573oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public RectF f34574oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public Paint f34575oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public StaticLayout f34576ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public CharSequence f34577x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public RectF[] f34578x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public Paint f34579xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public RectF f34580xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Paint f34581xxIXOIIO;

    public ooOOo0oXI(PieChart pieChart, Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
        this.f34574oO = new RectF();
        this.f34578x0xO0oo = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.f34571Oxx0xo = new Path();
        this.f34573oI0IIXIo = new RectF();
        this.f34572OxxIIOOXO = new Path();
        this.f34566IIXOooo = new Path();
        this.f34580xoXoI = new RectF();
        this.f34570Oxx0IOOO = pieChart;
        Paint paint = new Paint(1);
        this.f34565II0XooXoX = paint;
        paint.setColor(-1);
        Paint paint2 = this.f34565II0XooXoX;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f34581xxIXOIIO = paint3;
        paint3.setColor(-1);
        this.f34581xxIXOIIO.setStyle(style);
        this.f34581xxIXOIIO.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.f34568OOXIXo = textPaint;
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f34568OOXIXo.setTextSize(XIXIX.OOXIXo.X0o0xo(12.0f));
        this.f34532XO.setTextSize(XIXIX.OOXIXo.X0o0xo(13.0f));
        this.f34532XO.setColor(-1);
        Paint paint4 = this.f34532XO;
        Paint.Align align = Paint.Align.CENTER;
        paint4.setTextAlign(align);
        Paint paint5 = new Paint(1);
        this.f34575oOoXoXO = paint5;
        paint5.setColor(-1);
        this.f34575oOoXoXO.setTextAlign(align);
        this.f34575oOoXoXO.setTextSize(XIXIX.OOXIXo.X0o0xo(13.0f));
        Paint paint6 = new Paint(1);
        this.f34579xoIox = paint6;
        paint6.setStyle(Paint.Style.STROKE);
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void I0Io(Canvas canvas) {
        x0xO0oo(canvas);
        canvas.drawBitmap(this.f34569Oo.get(), 0.0f, 0.0f, (Paint) null);
        ooOOo0oXI(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void II0xO0(Canvas canvas) {
        Bitmap bitmap;
        int oO2 = (int) this.f34563oIX0oI.oO();
        int x0XOIxOo2 = (int) this.f34563oIX0oI.x0XOIxOo();
        WeakReference<Bitmap> weakReference = this.f34569Oo;
        if (weakReference == null) {
            bitmap = null;
        } else {
            bitmap = weakReference.get();
        }
        if (bitmap == null || bitmap.getWidth() != oO2 || bitmap.getHeight() != x0XOIxOo2) {
            if (oO2 > 0 && x0XOIxOo2 > 0) {
                bitmap = Bitmap.createBitmap(oO2, x0XOIxOo2, Bitmap.Config.ARGB_4444);
                this.f34569Oo = new WeakReference<>(bitmap);
                this.f34567IXxxXO = new Canvas(bitmap);
            } else {
                return;
            }
        }
        bitmap.eraseColor(0);
        for (IIxOXoOo0.xxIXOIIO xxixoiio : ((o0xxxXXxX.x0xO0oo) this.f34570Oxx0IOOO.getData()).Oo()) {
            if (xxixoiio.isVisible() && xxixoiio.X0xxXX0() > 0) {
                x0XOIxOo(canvas, xxixoiio);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float IIXOooo(IIxOXoOo0.xxIXOIIO xxixoiio) {
        if (!xxixoiio.xoIox()) {
            return xxixoiio.oOo();
        }
        if (xxixoiio.oOo() / this.f34563oIX0oI.OxI() > (xxixoiio.x0xO() / ((o0xxxXXxX.x0xO0oo) this.f34570Oxx0IOOO.getData()).OI0()) * 2.0f) {
            return 0.0f;
        }
        return xxixoiio.oOo();
    }

    public TextPaint IXxxXO() {
        return this.f34568OOXIXo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Oo(Canvas canvas) {
        float f;
        float[] fArr;
        float f2;
        if (!this.f34570Oxx0IOOO.xoIxX()) {
            return;
        }
        IIxOXoOo0.xxIXOIIO xII2 = ((o0xxxXXxX.x0xO0oo) this.f34570Oxx0IOOO.getData()).xII();
        if (!xII2.isVisible()) {
            return;
        }
        float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        XIXIX.Oxx0IOOO centerCircleBox = this.f34570Oxx0IOOO.getCenterCircleBox();
        float radius = this.f34570Oxx0IOOO.getRadius();
        float holeRadius = (radius - ((this.f34570Oxx0IOOO.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        float[] drawAngles = this.f34570Oxx0IOOO.getDrawAngles();
        float rotationAngle = this.f34570Oxx0IOOO.getRotationAngle();
        int i = 0;
        while (i < xII2.X0xxXX0()) {
            float f3 = drawAngles[i];
            if (Math.abs(xII2.OOXIXo(i).I0Io()) > XIXIX.OOXIXo.f3758Oxx0IOOO) {
                double d = radius - holeRadius;
                double d2 = (rotationAngle + f3) * xxIXOIIO2;
                f = xxIXOIIO2;
                fArr = drawAngles;
                f2 = rotationAngle;
                float cos = (float) (centerCircleBox.f3771IXxxXO + (Math.cos(Math.toRadians(d2)) * d));
                float sin = (float) ((d * Math.sin(Math.toRadians(d2))) + centerCircleBox.f3772Oxx0xo);
                this.f34529I0Io.setColor(xII2.XXoOx0(i));
                this.f34567IXxxXO.drawCircle(cos, sin, holeRadius, this.f34529I0Io);
            } else {
                f = xxIXOIIO2;
                fArr = drawAngles;
                f2 = rotationAngle;
            }
            rotationAngle = f2 + (f3 * II0XooXoX2);
            i++;
            xxIXOIIO2 = f;
            drawAngles = fArr;
        }
        XIXIX.Oxx0IOOO.II0XooXoX(centerCircleBox);
    }

    public Paint Oxx0xo() {
        return this.f34575oOoXoXO;
    }

    public Paint OxxIIOOXO() {
        return this.f34581xxIXOIIO;
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void X0o0xo(Canvas canvas, String str, float f, float f2, int i) {
        this.f34532XO.setColor(i);
        canvas.drawText(str, f, f2, this.f34532XO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void XO(Canvas canvas) {
        int i;
        List<IIxOXoOo0.xxIXOIIO> list;
        float[] fArr;
        float[] fArr2;
        float f;
        float f2;
        float f3;
        XIXIX.Oxx0IOOO oxx0IOOO;
        float f4;
        Canvas canvas2;
        float f5;
        float I0Io2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        PieDataSet.ValuePosition valuePosition;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        XIXIX.Oxx0IOOO oxx0IOOO2;
        PieEntry pieEntry;
        XIXIX.Oxx0IOOO oxx0IOOO3;
        IIxOXoOo0.xxIXOIIO xxixoiio;
        float f12;
        Canvas canvas3;
        String str;
        String str2;
        Canvas canvas4;
        XIXIX.Oxx0IOOO oxx0IOOO4;
        XIXIX.Oxx0IOOO oxx0IOOO5;
        Canvas canvas5 = canvas;
        XIXIX.Oxx0IOOO centerCircleBox = this.f34570Oxx0IOOO.getCenterCircleBox();
        float radius = this.f34570Oxx0IOOO.getRadius();
        float rotationAngle = this.f34570Oxx0IOOO.getRotationAngle();
        float[] drawAngles = this.f34570Oxx0IOOO.getDrawAngles();
        float[] absoluteAngles = this.f34570Oxx0IOOO.getAbsoluteAngles();
        float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        float holeRadius = (radius - ((this.f34570Oxx0IOOO.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        float holeRadius2 = this.f34570Oxx0IOOO.getHoleRadius() / 100.0f;
        float f13 = (radius / 10.0f) * 3.6f;
        if (this.f34570Oxx0IOOO.IoOoo()) {
            f13 = (radius - (radius * holeRadius2)) / 2.0f;
            if (!this.f34570Oxx0IOOO.x0xO() && this.f34570Oxx0IOOO.xoIxX()) {
                rotationAngle = (float) (rotationAngle + ((holeRadius * 360.0f) / (radius * 6.283185307179586d)));
            }
        }
        float f14 = rotationAngle;
        float f15 = radius - f13;
        o0xxxXXxX.x0xO0oo x0xo0oo = (o0xxxXXxX.x0xO0oo) this.f34570Oxx0IOOO.getData();
        List<IIxOXoOo0.xxIXOIIO> Oo2 = x0xo0oo.Oo();
        float OI02 = x0xo0oo.OI0();
        boolean OO2 = this.f34570Oxx0IOOO.OO();
        canvas.save();
        float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(5.0f);
        int i2 = 0;
        int i3 = 0;
        while (i3 < Oo2.size()) {
            IIxOXoOo0.xxIXOIIO xxixoiio2 = Oo2.get(i3);
            boolean xoO0xx02 = xxixoiio2.xoO0xx0();
            if (!xoO0xx02 && !OO2) {
                i = i3;
                list = Oo2;
                f4 = radius;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f = II0XooXoX2;
                f2 = xxIXOIIO2;
                f3 = f14;
                canvas2 = canvas5;
                oxx0IOOO = centerCircleBox;
            } else {
                PieDataSet.ValuePosition IO2 = xxixoiio2.IO();
                PieDataSet.ValuePosition IoXIXo2 = xxixoiio2.IoXIXo();
                oIX0oI(xxixoiio2);
                int i4 = i2;
                i = i3;
                float oIX0oI2 = XIXIX.OOXIXo.oIX0oI(this.f34532XO, "Q") + XIXIX.OOXIXo.X0o0xo(4.0f);
                ox.x0xO0oo xxIO2 = xxixoiio2.xxIO();
                int X0xxXX02 = xxixoiio2.X0xxXX0();
                list = Oo2;
                this.f34579xoIox.setColor(xxixoiio2.x0OIX00oO());
                this.f34579xoIox.setStrokeWidth(XIXIX.OOXIXo.X0o0xo(xxixoiio2.XX0xXo()));
                float IIXOooo2 = IIXOooo(xxixoiio2);
                XIXIX.Oxx0IOOO oxoX2 = XIXIX.Oxx0IOOO.oxoX(xxixoiio2.IO0XoXxO());
                XIXIX.Oxx0IOOO oxx0IOOO6 = centerCircleBox;
                oxoX2.f3771IXxxXO = XIXIX.OOXIXo.X0o0xo(oxoX2.f3771IXxxXO);
                oxoX2.f3772Oxx0xo = XIXIX.OOXIXo.X0o0xo(oxoX2.f3772Oxx0xo);
                int i5 = 0;
                while (i5 < X0xxXX02) {
                    XIXIX.Oxx0IOOO oxx0IOOO7 = oxoX2;
                    PieEntry OOXIXo2 = xxixoiio2.OOXIXo(i5);
                    if (i4 == 0) {
                        f5 = 0.0f;
                    } else {
                        f5 = absoluteAngles[i4 - 1] * II0XooXoX2;
                    }
                    int i6 = X0xxXX02;
                    float f16 = f14 + ((f5 + ((drawAngles[i4] - ((IIXOooo2 / (f15 * 0.017453292f)) / 2.0f)) / 2.0f)) * xxIXOIIO2);
                    float f17 = IIXOooo2;
                    if (this.f34570Oxx0IOOO.OO0x0xX()) {
                        I0Io2 = (OOXIXo2.I0Io() / OI02) * 100.0f;
                    } else {
                        I0Io2 = OOXIXo2.I0Io();
                    }
                    String xxIXOIIO3 = xxIO2.xxIXOIIO(I0Io2, OOXIXo2);
                    float[] fArr3 = drawAngles;
                    String oOoXoXO2 = OOXIXo2.oOoXoXO();
                    ox.x0xO0oo x0xo0oo2 = xxIO2;
                    double d = f16 * 0.017453292f;
                    float[] fArr4 = absoluteAngles;
                    float f18 = II0XooXoX2;
                    float cos = (float) Math.cos(d);
                    float f19 = xxIXOIIO2;
                    float sin = (float) Math.sin(d);
                    if (OO2 && IO2 == PieDataSet.ValuePosition.OUTSIDE_SLICE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    float f20 = f14;
                    if (xoO0xx02 && IoXIXo2 == PieDataSet.ValuePosition.OUTSIDE_SLICE) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (OO2 && IO2 == PieDataSet.ValuePosition.INSIDE_SLICE) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    PieDataSet.ValuePosition valuePosition2 = IO2;
                    if (xoO0xx02 && IoXIXo2 == PieDataSet.ValuePosition.INSIDE_SLICE) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z && !z2) {
                        valuePosition = IoXIXo2;
                        f11 = sin;
                        oxx0IOOO3 = oxx0IOOO6;
                        oxx0IOOO2 = oxx0IOOO7;
                        pieEntry = OOXIXo2;
                        str2 = oOoXoXO2;
                        xxixoiio = xxixoiio2;
                        f8 = radius;
                        canvas4 = canvas;
                    } else {
                        float o0xxxXXxX2 = xxixoiio2.o0xxxXXxX();
                        float Oxx0xo2 = xxixoiio2.Oxx0xo();
                        float oxxXoxO2 = xxixoiio2.oxxXoxO() / 100.0f;
                        valuePosition = IoXIXo2;
                        if (this.f34570Oxx0IOOO.IoOoo()) {
                            float f21 = radius * holeRadius2;
                            f6 = ((radius - f21) * oxxXoxO2) + f21;
                        } else {
                            f6 = radius * oxxXoxO2;
                        }
                        if (xxixoiio2.xxOXOOoIX()) {
                            f7 = Oxx0xo2 * f15 * ((float) Math.abs(Math.sin(d)));
                        } else {
                            f7 = Oxx0xo2 * f15;
                        }
                        XIXIX.Oxx0IOOO oxx0IOOO8 = oxx0IOOO6;
                        float f22 = oxx0IOOO8.f3771IXxxXO;
                        float f23 = (f6 * cos) + f22;
                        f8 = radius;
                        float f24 = oxx0IOOO8.f3772Oxx0xo;
                        float f25 = (f6 * sin) + f24;
                        float f26 = (o0xxxXXxX2 + 1.0f) * f15;
                        float f27 = (f26 * cos) + f22;
                        float f28 = f24 + (f26 * sin);
                        double d2 = f16 % 360.0d;
                        if (d2 >= 90.0d && d2 <= 270.0d) {
                            float f29 = f27 - f7;
                            Paint paint = this.f34532XO;
                            Paint.Align align = Paint.Align.RIGHT;
                            paint.setTextAlign(align);
                            if (z) {
                                this.f34575oOoXoXO.setTextAlign(align);
                            }
                            f9 = f29;
                            f10 = f29 - X0o0xo2;
                        } else {
                            f9 = f27 + f7;
                            Paint paint2 = this.f34532XO;
                            Paint.Align align2 = Paint.Align.LEFT;
                            paint2.setTextAlign(align2);
                            if (z) {
                                this.f34575oOoXoXO.setTextAlign(align2);
                            }
                            f10 = f9 + X0o0xo2;
                        }
                        if (xxixoiio2.x0OIX00oO() != 1122867) {
                            if (xxixoiio2.xXoOI00O()) {
                                this.f34579xoIox.setColor(xxixoiio2.XXoOx0(i5));
                            }
                            f11 = sin;
                            xxixoiio = xxixoiio2;
                            oxx0IOOO2 = oxx0IOOO7;
                            pieEntry = OOXIXo2;
                            oxx0IOOO3 = oxx0IOOO8;
                            f12 = f10;
                            canvas.drawLine(f23, f25, f27, f28, this.f34579xoIox);
                            canvas.drawLine(f27, f28, f9, f28, this.f34579xoIox);
                        } else {
                            f11 = sin;
                            oxx0IOOO2 = oxx0IOOO7;
                            pieEntry = OOXIXo2;
                            oxx0IOOO3 = oxx0IOOO8;
                            xxixoiio = xxixoiio2;
                            f12 = f10;
                        }
                        if (z && z2) {
                            X0o0xo(canvas, xxIXOIIO3, f12, f28, xxixoiio.x0xO0oo(i5));
                            if (i5 < x0xo0oo.IXxxXO() && oOoXoXO2 != null) {
                                canvas3 = canvas;
                                str = oOoXoXO2;
                                oO(canvas3, str, f12, f28 + oIX0oI2);
                                str2 = str;
                                canvas4 = canvas3;
                            } else {
                                canvas4 = canvas;
                                str2 = oOoXoXO2;
                            }
                        } else {
                            canvas3 = canvas;
                            float f30 = f12;
                            str = oOoXoXO2;
                            if (z) {
                                if (i5 < x0xo0oo.IXxxXO() && str != null) {
                                    oO(canvas3, str, f30, f28 + (oIX0oI2 / 2.0f));
                                }
                            } else if (z2) {
                                str2 = str;
                                canvas4 = canvas3;
                                X0o0xo(canvas, xxIXOIIO3, f30, f28 + (oIX0oI2 / 2.0f), xxixoiio.x0xO0oo(i5));
                            }
                            str2 = str;
                            canvas4 = canvas3;
                        }
                    }
                    if (!z3 && !z4) {
                        oxx0IOOO4 = oxx0IOOO3;
                    } else {
                        oxx0IOOO4 = oxx0IOOO3;
                        float f31 = (f15 * cos) + oxx0IOOO4.f3771IXxxXO;
                        float f32 = (f15 * f11) + oxx0IOOO4.f3772Oxx0xo;
                        this.f34532XO.setTextAlign(Paint.Align.CENTER);
                        if (z3 && z4) {
                            X0o0xo(canvas, xxIXOIIO3, f31, f32, xxixoiio.x0xO0oo(i5));
                            if (i5 < x0xo0oo.IXxxXO() && str2 != null) {
                                oO(canvas4, str2, f31, f32 + oIX0oI2);
                            }
                        } else {
                            if (z3) {
                                if (i5 < x0xo0oo.IXxxXO() && str2 != null) {
                                    oO(canvas4, str2, f31, f32 + (oIX0oI2 / 2.0f));
                                }
                            } else if (z4) {
                                X0o0xo(canvas, xxIXOIIO3, f31, f32 + (oIX0oI2 / 2.0f), xxixoiio.x0xO0oo(i5));
                            }
                            if (pieEntry.II0xO0() == null && xxixoiio.oo0xXOI0I()) {
                                Drawable II0xO02 = pieEntry.II0xO0();
                                oxx0IOOO5 = oxx0IOOO2;
                                float f33 = oxx0IOOO5.f3772Oxx0xo;
                                XIXIX.OOXIXo.OOXIXo(canvas, II0xO02, (int) (((f15 + f33) * cos) + oxx0IOOO4.f3771IXxxXO), (int) (((f33 + f15) * f11) + oxx0IOOO4.f3772Oxx0xo + oxx0IOOO5.f3771IXxxXO), II0xO02.getIntrinsicWidth(), II0xO02.getIntrinsicHeight());
                            } else {
                                oxx0IOOO5 = oxx0IOOO2;
                            }
                            i4++;
                            i5++;
                            oxoX2 = oxx0IOOO5;
                            xxixoiio2 = xxixoiio;
                            radius = f8;
                            IIXOooo2 = f17;
                            X0xxXX02 = i6;
                            drawAngles = fArr3;
                            xxIO2 = x0xo0oo2;
                            absoluteAngles = fArr4;
                            II0XooXoX2 = f18;
                            f14 = f20;
                            IO2 = valuePosition2;
                            IoXIXo2 = valuePosition;
                            oxx0IOOO6 = oxx0IOOO4;
                            xxIXOIIO2 = f19;
                        }
                    }
                    if (pieEntry.II0xO0() == null) {
                    }
                    oxx0IOOO5 = oxx0IOOO2;
                    i4++;
                    i5++;
                    oxoX2 = oxx0IOOO5;
                    xxixoiio2 = xxixoiio;
                    radius = f8;
                    IIXOooo2 = f17;
                    X0xxXX02 = i6;
                    drawAngles = fArr3;
                    xxIO2 = x0xo0oo2;
                    absoluteAngles = fArr4;
                    II0XooXoX2 = f18;
                    f14 = f20;
                    IO2 = valuePosition2;
                    IoXIXo2 = valuePosition;
                    oxx0IOOO6 = oxx0IOOO4;
                    xxIXOIIO2 = f19;
                }
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f = II0XooXoX2;
                f2 = xxIXOIIO2;
                f3 = f14;
                oxx0IOOO = oxx0IOOO6;
                f4 = radius;
                canvas2 = canvas;
                XIXIX.Oxx0IOOO.II0XooXoX(oxoX2);
                i2 = i4;
            }
            i3 = i + 1;
            canvas5 = canvas2;
            centerCircleBox = oxx0IOOO;
            Oo2 = list;
            radius = f4;
            drawAngles = fArr;
            absoluteAngles = fArr2;
            II0XooXoX2 = f;
            xxIXOIIO2 = f2;
            f14 = f3;
        }
        XIXIX.Oxx0IOOO.II0XooXoX(centerCircleBox);
        canvas.restore();
    }

    public Paint oI0IIXIo() {
        return this.f34565II0XooXoX;
    }

    public void oO(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.f34575oOoXoXO);
    }

    public float oOoXoXO(XIXIX.Oxx0IOOO oxx0IOOO, float f, float f2, float f3, float f4, float f5, float f6) {
        double d = (f5 + f6) * 0.017453292f;
        float cos = oxx0IOOO.f3771IXxxXO + (((float) Math.cos(d)) * f);
        float sin = oxx0IOOO.f3772Oxx0xo + (((float) Math.sin(d)) * f);
        double d2 = (f5 + (f6 / 2.0f)) * 0.017453292f;
        return (float) ((f - ((float) ((Math.sqrt(Math.pow(cos - f3, 2.0d) + Math.pow(sin - f4, 2.0d)) / 2.0d) * Math.tan(((180.0d - f2) / 2.0d) * 0.017453292519943295d)))) - Math.sqrt(Math.pow((oxx0IOOO.f3771IXxxXO + (((float) Math.cos(d2)) * f)) - ((cos + f3) / 2.0f), 2.0d) + Math.pow((oxx0IOOO.f3772Oxx0xo + (((float) Math.sin(d2)) * f)) - ((sin + f4) / 2.0f), 2.0d)));
    }

    public void ooOOo0oXI(Canvas canvas) {
        float radius;
        XIXIX.Oxx0IOOO oxx0IOOO;
        CharSequence centerText = this.f34570Oxx0IOOO.getCenterText();
        if (this.f34570Oxx0IOOO.xoxXI() && centerText != null) {
            XIXIX.Oxx0IOOO centerCircleBox = this.f34570Oxx0IOOO.getCenterCircleBox();
            XIXIX.Oxx0IOOO centerTextOffset = this.f34570Oxx0IOOO.getCenterTextOffset();
            float f = centerCircleBox.f3771IXxxXO + centerTextOffset.f3771IXxxXO;
            float f2 = centerCircleBox.f3772Oxx0xo + centerTextOffset.f3772Oxx0xo;
            if (this.f34570Oxx0IOOO.IoOoo() && !this.f34570Oxx0IOOO.x0xO()) {
                radius = this.f34570Oxx0IOOO.getRadius() * (this.f34570Oxx0IOOO.getHoleRadius() / 100.0f);
            } else {
                radius = this.f34570Oxx0IOOO.getRadius();
            }
            RectF[] rectFArr = this.f34578x0xO0oo;
            RectF rectF = rectFArr[0];
            rectF.left = f - radius;
            rectF.top = f2 - radius;
            rectF.right = f + radius;
            rectF.bottom = f2 + radius;
            RectF rectF2 = rectFArr[1];
            rectF2.set(rectF);
            float centerTextRadiusPercent = this.f34570Oxx0IOOO.getCenterTextRadiusPercent() / 100.0f;
            if (centerTextRadiusPercent > XIXIX.OOXIXo.f3760XO) {
                rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
            }
            if (centerText.equals(this.f34577x0XOIxOo) && rectF2.equals(this.f34574oO)) {
                oxx0IOOO = centerTextOffset;
            } else {
                this.f34574oO.set(rectF2);
                this.f34577x0XOIxOo = centerText;
                oxx0IOOO = centerTextOffset;
                this.f34576ooOOo0oXI = new StaticLayout(centerText, 0, centerText.length(), this.f34568OOXIXo, (int) Math.max(Math.ceil(this.f34574oO.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            }
            float height = this.f34576ooOOo0oXI.getHeight();
            canvas.save();
            Path path = this.f34566IIXOooo;
            path.reset();
            path.addOval(rectF, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
            this.f34576ooOOo0oXI.draw(canvas);
            canvas.restore();
            XIXIX.Oxx0IOOO.II0XooXoX(centerCircleBox);
            XIXIX.Oxx0IOOO.II0XooXoX(oxx0IOOO);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void oxoX(Canvas canvas, XI0oooXX.oxoX[] oxoxArr) {
        boolean z;
        float f;
        IIxOXoOo0.xxIXOIIO OOXIXo2;
        float f2;
        int i;
        float oOo2;
        boolean z2;
        float f3;
        float f4;
        float f5;
        float[] fArr;
        float f6;
        int i2;
        boolean z3;
        RectF rectF;
        XIXIX.Oxx0IOOO oxx0IOOO;
        int i3;
        float f7;
        float[] fArr2;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        XI0oooXX.oxoX[] oxoxArr2 = oxoxArr;
        if (this.f34570Oxx0IOOO.IoOoo() && !this.f34570Oxx0IOOO.x0xO()) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.f34570Oxx0IOOO.xoIxX()) {
            return;
        }
        float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        float rotationAngle = this.f34570Oxx0IOOO.getRotationAngle();
        float[] drawAngles = this.f34570Oxx0IOOO.getDrawAngles();
        float[] absoluteAngles = this.f34570Oxx0IOOO.getAbsoluteAngles();
        XIXIX.Oxx0IOOO centerCircleBox = this.f34570Oxx0IOOO.getCenterCircleBox();
        float radius = this.f34570Oxx0IOOO.getRadius();
        if (z) {
            f = (this.f34570Oxx0IOOO.getHoleRadius() / 100.0f) * radius;
        } else {
            f = 0.0f;
        }
        RectF rectF2 = this.f34580xoXoI;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 0;
        while (i4 < oxoxArr2.length) {
            int II0XooXoX3 = (int) oxoxArr2[i4].II0XooXoX();
            if (II0XooXoX3 >= drawAngles.length || (OOXIXo2 = ((o0xxxXXxX.x0xO0oo) this.f34570Oxx0IOOO.getData()).OOXIXo(oxoxArr2[i4].oxoX())) == null || !OOXIXo2.XX0()) {
                i3 = i4;
                rectF = rectF2;
                f7 = f;
                fArr2 = drawAngles;
                z3 = z;
                f9 = II0XooXoX2;
                f10 = xxIXOIIO2;
                oxx0IOOO = centerCircleBox;
            } else {
                int X0xxXX02 = OOXIXo2.X0xxXX0();
                int i5 = 0;
                for (int i6 = 0; i6 < X0xxXX02; i6++) {
                    if (Math.abs(OOXIXo2.OOXIXo(i6).I0Io()) > XIXIX.OOXIXo.f3758Oxx0IOOO) {
                        i5++;
                    }
                }
                if (II0XooXoX3 == 0) {
                    i = 1;
                    f2 = 0.0f;
                } else {
                    f2 = absoluteAngles[II0XooXoX3 - 1] * II0XooXoX2;
                    i = 1;
                }
                if (i5 <= i) {
                    oOo2 = 0.0f;
                } else {
                    oOo2 = OOXIXo2.oOo();
                }
                float f13 = drawAngles[II0XooXoX3];
                float xoXoI2 = OOXIXo2.xoXoI();
                int i7 = i4;
                float f14 = radius + xoXoI2;
                float f15 = f;
                rectF2.set(this.f34570Oxx0IOOO.getCircleBox());
                float f16 = -xoXoI2;
                rectF2.inset(f16, f16);
                if (oOo2 > 0.0f && f13 <= 180.0f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f34529I0Io.setColor(OOXIXo2.XXoOx0(II0XooXoX3));
                if (i5 == 1) {
                    f3 = 0.0f;
                } else {
                    f3 = oOo2 / (radius * 0.017453292f);
                }
                if (i5 == 1) {
                    f4 = 0.0f;
                } else {
                    f4 = oOo2 / (f14 * 0.017453292f);
                }
                float f17 = rotationAngle + (((f3 / 2.0f) + f2) * xxIXOIIO2);
                float f18 = (f13 - f3) * xxIXOIIO2;
                if (f18 < 0.0f) {
                    f5 = 0.0f;
                } else {
                    f5 = f18;
                }
                float f19 = (((f4 / 2.0f) + f2) * xxIXOIIO2) + rotationAngle;
                float f20 = (f13 - f4) * xxIXOIIO2;
                if (f20 < 0.0f) {
                    f20 = 0.0f;
                }
                this.f34571Oxx0xo.reset();
                if (f5 >= 360.0f && f5 % 360.0f <= XIXIX.OOXIXo.f3758Oxx0IOOO) {
                    this.f34571Oxx0xo.addCircle(centerCircleBox.f3771IXxxXO, centerCircleBox.f3772Oxx0xo, f14, Path.Direction.CW);
                    fArr = drawAngles;
                    f6 = f2;
                    i2 = i5;
                    z3 = z;
                } else {
                    fArr = drawAngles;
                    f6 = f2;
                    double d = f19 * 0.017453292f;
                    i2 = i5;
                    z3 = z;
                    this.f34571Oxx0xo.moveTo(centerCircleBox.f3771IXxxXO + (((float) Math.cos(d)) * f14), centerCircleBox.f3772Oxx0xo + (f14 * ((float) Math.sin(d))));
                    this.f34571Oxx0xo.arcTo(rectF2, f19, f20);
                }
                if (z2) {
                    double d2 = f17 * 0.017453292f;
                    i3 = i7;
                    rectF = rectF2;
                    f7 = f15;
                    oxx0IOOO = centerCircleBox;
                    fArr2 = fArr;
                    f8 = oOoXoXO(centerCircleBox, radius, f13 * xxIXOIIO2, (((float) Math.cos(d2)) * radius) + centerCircleBox.f3771IXxxXO, centerCircleBox.f3772Oxx0xo + (((float) Math.sin(d2)) * radius), f17, f5);
                } else {
                    rectF = rectF2;
                    oxx0IOOO = centerCircleBox;
                    i3 = i7;
                    f7 = f15;
                    fArr2 = fArr;
                    f8 = 0.0f;
                }
                RectF rectF3 = this.f34573oI0IIXIo;
                float f21 = oxx0IOOO.f3771IXxxXO;
                float f22 = oxx0IOOO.f3772Oxx0xo;
                rectF3.set(f21 - f7, f22 - f7, f21 + f7, f22 + f7);
                if (!z3 || (f7 <= 0.0f && !z2)) {
                    f9 = II0XooXoX2;
                    f10 = xxIXOIIO2;
                    if (f5 % 360.0f > XIXIX.OOXIXo.f3758Oxx0IOOO) {
                        if (z2) {
                            double d3 = (f17 + (f5 / 2.0f)) * 0.017453292f;
                            this.f34571Oxx0xo.lineTo(oxx0IOOO.f3771IXxxXO + (((float) Math.cos(d3)) * f8), oxx0IOOO.f3772Oxx0xo + (f8 * ((float) Math.sin(d3))));
                        } else {
                            this.f34571Oxx0xo.lineTo(oxx0IOOO.f3771IXxxXO, oxx0IOOO.f3772Oxx0xo);
                        }
                    }
                } else {
                    if (z2) {
                        if (f8 < 0.0f) {
                            f8 = -f8;
                        }
                        f11 = Math.max(f7, f8);
                    } else {
                        f11 = f7;
                    }
                    if (i2 != 1 && f11 != 0.0f) {
                        f12 = oOo2 / (f11 * 0.017453292f);
                    } else {
                        f12 = 0.0f;
                    }
                    float f23 = ((f6 + (f12 / 2.0f)) * xxIXOIIO2) + rotationAngle;
                    float f24 = (f13 - f12) * xxIXOIIO2;
                    if (f24 < 0.0f) {
                        f24 = 0.0f;
                    }
                    float f25 = f23 + f24;
                    if (f5 >= 360.0f && f5 % 360.0f <= XIXIX.OOXIXo.f3758Oxx0IOOO) {
                        this.f34571Oxx0xo.addCircle(oxx0IOOO.f3771IXxxXO, oxx0IOOO.f3772Oxx0xo, f11, Path.Direction.CCW);
                        f9 = II0XooXoX2;
                        f10 = xxIXOIIO2;
                    } else {
                        double d4 = f25 * 0.017453292f;
                        f9 = II0XooXoX2;
                        f10 = xxIXOIIO2;
                        this.f34571Oxx0xo.lineTo(oxx0IOOO.f3771IXxxXO + (((float) Math.cos(d4)) * f11), oxx0IOOO.f3772Oxx0xo + (f11 * ((float) Math.sin(d4))));
                        this.f34571Oxx0xo.arcTo(this.f34573oI0IIXIo, f25, -f24);
                    }
                }
                this.f34571Oxx0xo.close();
                this.f34567IXxxXO.drawPath(this.f34571Oxx0xo, this.f34529I0Io);
            }
            i4 = i3 + 1;
            II0XooXoX2 = f9;
            rectF2 = rectF;
            f = f7;
            centerCircleBox = oxx0IOOO;
            xxIXOIIO2 = f10;
            drawAngles = fArr2;
            z = z3;
            oxoxArr2 = oxoxArr;
        }
        XIXIX.Oxx0IOOO.II0XooXoX(centerCircleBox);
    }

    public void x0XOIxOo(Canvas canvas, IIxOXoOo0.xxIXOIIO xxixoiio) {
        boolean z;
        float f;
        boolean z2;
        float IIXOooo2;
        boolean z3;
        float f2;
        int i;
        int i2;
        int i3;
        float[] fArr;
        float f3;
        float f4;
        RectF rectF;
        float f5;
        float f6;
        int i4;
        RectF rectF2;
        XIXIX.Oxx0IOOO oxx0IOOO;
        float f7;
        RectF rectF3;
        XIXIX.Oxx0IOOO oxx0IOOO2;
        int i5;
        float f8;
        IIxOXoOo0.xxIXOIIO xxixoiio2 = xxixoiio;
        float rotationAngle = this.f34570Oxx0IOOO.getRotationAngle();
        float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        RectF circleBox = this.f34570Oxx0IOOO.getCircleBox();
        int X0xxXX02 = xxixoiio.X0xxXX0();
        float[] drawAngles = this.f34570Oxx0IOOO.getDrawAngles();
        XIXIX.Oxx0IOOO centerCircleBox = this.f34570Oxx0IOOO.getCenterCircleBox();
        float radius = this.f34570Oxx0IOOO.getRadius();
        if (this.f34570Oxx0IOOO.IoOoo() && !this.f34570Oxx0IOOO.x0xO()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f = (this.f34570Oxx0IOOO.getHoleRadius() / 100.0f) * radius;
        } else {
            f = 0.0f;
        }
        float holeRadius = (radius - ((this.f34570Oxx0IOOO.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF4 = new RectF();
        if (z && this.f34570Oxx0IOOO.xoIxX()) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < X0xxXX02; i7++) {
            if (Math.abs(xxixoiio2.OOXIXo(i7).I0Io()) > XIXIX.OOXIXo.f3758Oxx0IOOO) {
                i6++;
            }
        }
        if (i6 <= 1) {
            IIXOooo2 = 0.0f;
        } else {
            IIXOooo2 = IIXOooo(xxixoiio2);
        }
        int i8 = 0;
        float f9 = 0.0f;
        while (i8 < X0xxXX02) {
            float f10 = drawAngles[i8];
            float abs = Math.abs(xxixoiio2.OOXIXo(i8).I0Io());
            float f11 = XIXIX.OOXIXo.f3758Oxx0IOOO;
            if (abs <= f11 || (this.f34570Oxx0IOOO.XIo0oOXIx(i8) && !z2)) {
                f9 += f10 * II0XooXoX2;
                i = i8;
                rectF = rectF4;
                f6 = radius;
                f3 = rotationAngle;
                f4 = II0XooXoX2;
                rectF2 = circleBox;
                i3 = X0xxXX02;
                fArr = drawAngles;
                i4 = i6;
                f5 = f;
                oxx0IOOO = centerCircleBox;
            } else {
                if (IIXOooo2 > 0.0f && f10 <= 180.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f34529I0Io.setColor(xxixoiio2.XXoOx0(i8));
                if (i6 == 1) {
                    f2 = 0.0f;
                } else {
                    f2 = IIXOooo2 / (radius * 0.017453292f);
                }
                float f12 = rotationAngle + ((f9 + (f2 / 2.0f)) * xxIXOIIO2);
                float f13 = (f10 - f2) * xxIXOIIO2;
                if (f13 < 0.0f) {
                    f13 = 0.0f;
                }
                this.f34571Oxx0xo.reset();
                if (z2) {
                    float f14 = radius - holeRadius;
                    i = i8;
                    i2 = i6;
                    double d = f12 * 0.017453292f;
                    i3 = X0xxXX02;
                    fArr = drawAngles;
                    float cos = centerCircleBox.f3771IXxxXO + (((float) Math.cos(d)) * f14);
                    float sin = centerCircleBox.f3772Oxx0xo + (f14 * ((float) Math.sin(d)));
                    rectF4.set(cos - holeRadius, sin - holeRadius, cos + holeRadius, sin + holeRadius);
                } else {
                    i = i8;
                    i2 = i6;
                    i3 = X0xxXX02;
                    fArr = drawAngles;
                }
                double d2 = f12 * 0.017453292f;
                f3 = rotationAngle;
                f4 = II0XooXoX2;
                float cos2 = centerCircleBox.f3771IXxxXO + (((float) Math.cos(d2)) * radius);
                float sin2 = centerCircleBox.f3772Oxx0xo + (((float) Math.sin(d2)) * radius);
                if (f13 >= 360.0f && f13 % 360.0f <= f11) {
                    this.f34571Oxx0xo.addCircle(centerCircleBox.f3771IXxxXO, centerCircleBox.f3772Oxx0xo, radius, Path.Direction.CW);
                } else {
                    if (z2) {
                        this.f34571Oxx0xo.arcTo(rectF4, f12 + 180.0f, -180.0f);
                    }
                    this.f34571Oxx0xo.arcTo(circleBox, f12, f13);
                }
                RectF rectF5 = this.f34573oI0IIXIo;
                float f15 = centerCircleBox.f3771IXxxXO;
                float f16 = centerCircleBox.f3772Oxx0xo;
                float f17 = f13;
                rectF5.set(f15 - f, f16 - f, f15 + f, f16 + f);
                if (z) {
                    if (f <= 0.0f && !z3) {
                        rectF = rectF4;
                        f5 = f;
                        f6 = radius;
                        i4 = i2;
                        f7 = 360.0f;
                        rectF2 = circleBox;
                        oxx0IOOO = centerCircleBox;
                    } else {
                        if (z3) {
                            i4 = i2;
                            rectF2 = circleBox;
                            f5 = f;
                            rectF3 = rectF4;
                            i5 = 1;
                            f6 = radius;
                            oxx0IOOO2 = centerCircleBox;
                            float oOoXoXO2 = oOoXoXO(centerCircleBox, radius, f10 * xxIXOIIO2, cos2, sin2, f12, f17);
                            if (oOoXoXO2 < 0.0f) {
                                oOoXoXO2 = -oOoXoXO2;
                            }
                            f = Math.max(f5, oOoXoXO2);
                        } else {
                            rectF3 = rectF4;
                            f5 = f;
                            f6 = radius;
                            oxx0IOOO2 = centerCircleBox;
                            i4 = i2;
                            rectF2 = circleBox;
                            i5 = 1;
                        }
                        if (i4 != i5 && f != 0.0f) {
                            f8 = IIXOooo2 / (f * 0.017453292f);
                        } else {
                            f8 = 0.0f;
                        }
                        float f18 = f3 + ((f9 + (f8 / 2.0f)) * xxIXOIIO2);
                        float f19 = (f10 - f8) * xxIXOIIO2;
                        if (f19 < 0.0f) {
                            f19 = 0.0f;
                        }
                        float f20 = f18 + f19;
                        if (f13 >= 360.0f && f17 % 360.0f <= f11) {
                            this.f34571Oxx0xo.addCircle(oxx0IOOO2.f3771IXxxXO, oxx0IOOO2.f3772Oxx0xo, f, Path.Direction.CCW);
                            rectF = rectF3;
                        } else {
                            if (z2) {
                                float f21 = f6 - holeRadius;
                                double d3 = f20 * 0.017453292f;
                                float cos3 = oxx0IOOO2.f3771IXxxXO + (((float) Math.cos(d3)) * f21);
                                float sin3 = oxx0IOOO2.f3772Oxx0xo + (f21 * ((float) Math.sin(d3)));
                                RectF rectF6 = rectF3;
                                rectF6.set(cos3 - holeRadius, sin3 - holeRadius, cos3 + holeRadius, sin3 + holeRadius);
                                this.f34571Oxx0xo.arcTo(rectF6, f20, 180.0f);
                                rectF = rectF6;
                            } else {
                                double d4 = f20 * 0.017453292f;
                                rectF = rectF3;
                                this.f34571Oxx0xo.lineTo(oxx0IOOO2.f3771IXxxXO + (((float) Math.cos(d4)) * f), oxx0IOOO2.f3772Oxx0xo + (f * ((float) Math.sin(d4))));
                            }
                            this.f34571Oxx0xo.arcTo(this.f34573oI0IIXIo, f20, -f19);
                        }
                        oxx0IOOO = oxx0IOOO2;
                        this.f34571Oxx0xo.close();
                        this.f34567IXxxXO.drawPath(this.f34571Oxx0xo, this.f34529I0Io);
                        f9 += f10 * f4;
                    }
                } else {
                    rectF = rectF4;
                    f5 = f;
                    f6 = radius;
                    i4 = i2;
                    rectF2 = circleBox;
                    oxx0IOOO = centerCircleBox;
                    f7 = 360.0f;
                }
                if (f17 % f7 > f11) {
                    if (z3) {
                        float oOoXoXO3 = oOoXoXO(oxx0IOOO, f6, f10 * xxIXOIIO2, cos2, sin2, f12, f17);
                        double d5 = (f12 + (f17 / 2.0f)) * 0.017453292f;
                        this.f34571Oxx0xo.lineTo(oxx0IOOO.f3771IXxxXO + (((float) Math.cos(d5)) * oOoXoXO3), oxx0IOOO.f3772Oxx0xo + (oOoXoXO3 * ((float) Math.sin(d5))));
                    } else {
                        this.f34571Oxx0xo.lineTo(oxx0IOOO.f3771IXxxXO, oxx0IOOO.f3772Oxx0xo);
                    }
                }
                this.f34571Oxx0xo.close();
                this.f34567IXxxXO.drawPath(this.f34571Oxx0xo, this.f34529I0Io);
                f9 += f10 * f4;
            }
            i8 = i + 1;
            rectF4 = rectF;
            xxixoiio2 = xxixoiio;
            f = f5;
            centerCircleBox = oxx0IOOO;
            i6 = i4;
            radius = f6;
            rotationAngle = f3;
            circleBox = rectF2;
            X0xxXX02 = i3;
            drawAngles = fArr;
            II0XooXoX2 = f4;
        }
        XIXIX.Oxx0IOOO.II0XooXoX(centerCircleBox);
    }

    public void x0xO0oo(Canvas canvas) {
        if (this.f34570Oxx0IOOO.IoOoo() && this.f34567IXxxXO != null) {
            float radius = this.f34570Oxx0IOOO.getRadius();
            float holeRadius = (this.f34570Oxx0IOOO.getHoleRadius() / 100.0f) * radius;
            XIXIX.Oxx0IOOO centerCircleBox = this.f34570Oxx0IOOO.getCenterCircleBox();
            if (Color.alpha(this.f34565II0XooXoX.getColor()) > 0) {
                this.f34567IXxxXO.drawCircle(centerCircleBox.f3771IXxxXO, centerCircleBox.f3772Oxx0xo, holeRadius, this.f34565II0XooXoX);
            }
            if (Color.alpha(this.f34581xxIXOIIO.getColor()) > 0 && this.f34570Oxx0IOOO.getTransparentCircleRadius() > this.f34570Oxx0IOOO.getHoleRadius()) {
                int alpha = this.f34581xxIXOIIO.getAlpha();
                float transparentCircleRadius = radius * (this.f34570Oxx0IOOO.getTransparentCircleRadius() / 100.0f);
                this.f34581xxIXOIIO.setAlpha((int) (alpha * this.f34530II0xO0.II0XooXoX() * this.f34530II0xO0.xxIXOIIO()));
                this.f34572OxxIIOOXO.reset();
                this.f34572OxxIIOOXO.addCircle(centerCircleBox.f3771IXxxXO, centerCircleBox.f3772Oxx0xo, transparentCircleRadius, Path.Direction.CW);
                this.f34572OxxIIOOXO.addCircle(centerCircleBox.f3771IXxxXO, centerCircleBox.f3772Oxx0xo, holeRadius, Path.Direction.CCW);
                this.f34567IXxxXO.drawPath(this.f34572OxxIIOOXO, this.f34581xxIXOIIO);
                this.f34581xxIXOIIO.setAlpha(alpha);
            }
            XIXIX.Oxx0IOOO.II0XooXoX(centerCircleBox);
        }
    }

    public void xoXoI() {
        Canvas canvas = this.f34567IXxxXO;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.f34567IXxxXO = null;
        }
        WeakReference<Bitmap> weakReference = this.f34569Oo;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f34569Oo.clear();
            this.f34569Oo = null;
        }
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void xoIox() {
    }
}
