package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public class xxIXOIIO extends oO {

    /* renamed from: I0Io, reason: collision with root package name */
    public Paint f34610I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Paint f34611II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Path f34612Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public List<com.github.mikephil.charting.components.oIX0oI> f34613X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Paint.FontMetrics f34614XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public Legend f34615oxoX;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public static final /* synthetic */ int[] f34616I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f34617II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f34618oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public static final /* synthetic */ int[] f34619oxoX;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            f34619oxoX = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34619oxoX[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34619oxoX[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34619oxoX[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34619oxoX[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34619oxoX[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            f34616I0Io = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34616I0Io[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f34617II0xO0 = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f34617II0xO0[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f34617II0xO0[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            f34618oIX0oI = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f34618oIX0oI[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f34618oIX0oI[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public xxIXOIIO(XIXIX.oOoXoXO oooxoxo, Legend legend) {
        super(oooxoxo);
        this.f34613X0o0xo = new ArrayList(16);
        this.f34614XO = new Paint.FontMetrics();
        this.f34612Oxx0IOOO = new Path();
        this.f34615oxoX = legend;
        Paint paint = new Paint(1);
        this.f34611II0xO0 = paint;
        paint.setTextSize(XIXIX.OOXIXo.X0o0xo(9.0f));
        this.f34611II0xO0.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.f34610I0Io = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public void I0Io(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.f34611II0xO0);
    }

    public void II0xO0(Canvas canvas, float f, float f2, com.github.mikephil.charting.components.oIX0oI oix0oi, Legend legend) {
        float f3;
        float f4;
        int i = oix0oi.f15997XO;
        if (i != 1122868 && i != 1122867 && i != 0) {
            int save = canvas.save();
            Legend.LegendForm legendForm = oix0oi.f15995II0xO0;
            if (legendForm == Legend.LegendForm.DEFAULT) {
                legendForm = legend.oI0IIXIo();
            }
            this.f34610I0Io.setColor(oix0oi.f15997XO);
            if (Float.isNaN(oix0oi.f15994I0Io)) {
                f3 = legend.xoXoI();
            } else {
                f3 = oix0oi.f15994I0Io;
            }
            float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(f3);
            float f5 = X0o0xo2 / 2.0f;
            int i2 = oIX0oI.f34619oxoX[legendForm.ordinal()];
            if (i2 != 3 && i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 6) {
                        if (Float.isNaN(oix0oi.f15999oxoX)) {
                            f4 = legend.IIXOooo();
                        } else {
                            f4 = oix0oi.f15999oxoX;
                        }
                        float X0o0xo3 = XIXIX.OOXIXo.X0o0xo(f4);
                        DashPathEffect dashPathEffect = oix0oi.f15996X0o0xo;
                        if (dashPathEffect == null) {
                            dashPathEffect = legend.OxxIIOOXO();
                        }
                        this.f34610I0Io.setStyle(Paint.Style.STROKE);
                        this.f34610I0Io.setStrokeWidth(X0o0xo3);
                        this.f34610I0Io.setPathEffect(dashPathEffect);
                        this.f34612Oxx0IOOO.reset();
                        this.f34612Oxx0IOOO.moveTo(f, f2);
                        this.f34612Oxx0IOOO.lineTo(f + X0o0xo2, f2);
                        canvas.drawPath(this.f34612Oxx0IOOO, this.f34610I0Io);
                    }
                } else {
                    this.f34610I0Io.setStyle(Paint.Style.FILL);
                    canvas.drawRect(f, f2 - f5, f + X0o0xo2, f2 + f5, this.f34610I0Io);
                }
            } else {
                this.f34610I0Io.setStyle(Paint.Style.FILL);
                canvas.drawCircle(f + f5, f2, f5, this.f34610I0Io);
            }
            canvas.restoreToCount(save);
        }
    }

    public Paint X0o0xo() {
        return this.f34611II0xO0;
    }

    public void XO(Canvas canvas) {
        float f;
        float f2;
        float f3;
        boolean z;
        float X0o0xo2;
        float f4;
        float f5;
        boolean z2;
        List<Boolean> list;
        List<XIXIX.I0Io> list2;
        int i;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float xoIox2;
        float f12;
        boolean z3;
        float X0o0xo3;
        float f13;
        float f14;
        float f15;
        Legend.LegendDirection legendDirection;
        com.github.mikephil.charting.components.oIX0oI oix0oi;
        float f16;
        float f17;
        float f18;
        float XO2;
        float xxIXOIIO2;
        float II0XooXoX2;
        float f19;
        double d;
        if (!this.f34615oxoX.XO()) {
            return;
        }
        Typeface I0Io2 = this.f34615oxoX.I0Io();
        if (I0Io2 != null) {
            this.f34611II0xO0.setTypeface(I0Io2);
        }
        this.f34611II0xO0.setTextSize(this.f34615oxoX.II0xO0());
        this.f34611II0xO0.setColor(this.f34615oxoX.oIX0oI());
        float OxxIIOOXO2 = XIXIX.OOXIXo.OxxIIOOXO(this.f34611II0xO0, this.f34614XO);
        float xoXoI2 = XIXIX.OOXIXo.xoXoI(this.f34611II0xO0, this.f34614XO) + XIXIX.OOXIXo.X0o0xo(this.f34615oxoX.IIX0o());
        float oIX0oI2 = OxxIIOOXO2 - (XIXIX.OOXIXo.oIX0oI(this.f34611II0xO0, "ABC") / 2.0f);
        com.github.mikephil.charting.components.oIX0oI[] IXxxXO2 = this.f34615oxoX.IXxxXO();
        float X0o0xo4 = XIXIX.OOXIXo.X0o0xo(this.f34615oxoX.o00());
        float X0o0xo5 = XIXIX.OOXIXo.X0o0xo(this.f34615oxoX.xXxxox0I());
        Legend.LegendOrientation XIxXXX0x02 = this.f34615oxoX.XIxXXX0x0();
        Legend.LegendHorizontalAlignment OxI2 = this.f34615oxoX.OxI();
        Legend.LegendVerticalAlignment XxX0x0xxx2 = this.f34615oxoX.XxX0x0xxx();
        Legend.LegendDirection Oo2 = this.f34615oxoX.Oo();
        float X0o0xo6 = XIXIX.OOXIXo.X0o0xo(this.f34615oxoX.xoXoI());
        float X0o0xo7 = XIXIX.OOXIXo.X0o0xo(this.f34615oxoX.xxX());
        float X0o0xo8 = this.f34615oxoX.X0o0xo();
        float oxoX2 = this.f34615oxoX.oxoX();
        int i2 = oIX0oI.f34618oIX0oI[OxI2.ordinal()];
        float f20 = X0o0xo7;
        float f21 = X0o0xo5;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    f = OxxIIOOXO2;
                    f2 = xoXoI2;
                    f3 = 0.0f;
                } else {
                    Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                    if (XIxXXX0x02 == legendOrientation) {
                        II0XooXoX2 = this.f34563oIX0oI.oO() / 2.0f;
                    } else {
                        II0XooXoX2 = this.f34563oIX0oI.II0XooXoX() + (this.f34563oIX0oI.OOXIXo() / 2.0f);
                    }
                    Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                    f2 = xoXoI2;
                    if (Oo2 == legendDirection2) {
                        f19 = oxoX2;
                    } else {
                        f19 = -oxoX2;
                    }
                    f3 = II0XooXoX2 + f19;
                    if (XIxXXX0x02 == legendOrientation) {
                        double d2 = f3;
                        if (Oo2 == legendDirection2) {
                            f = OxxIIOOXO2;
                            d = ((-this.f34615oxoX.f15951o00) / 2.0d) + oxoX2;
                        } else {
                            f = OxxIIOOXO2;
                            d = (this.f34615oxoX.f15951o00 / 2.0d) - oxoX2;
                        }
                        f3 = (float) (d2 + d);
                    } else {
                        f = OxxIIOOXO2;
                    }
                }
            } else {
                f = OxxIIOOXO2;
                f2 = xoXoI2;
                if (XIxXXX0x02 == Legend.LegendOrientation.VERTICAL) {
                    xxIXOIIO2 = this.f34563oIX0oI.oO();
                } else {
                    xxIXOIIO2 = this.f34563oIX0oI.xxIXOIIO();
                }
                f3 = xxIXOIIO2 - oxoX2;
                if (Oo2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f3 -= this.f34615oxoX.f15951o00;
                }
            }
        } else {
            f = OxxIIOOXO2;
            f2 = xoXoI2;
            if (XIxXXX0x02 != Legend.LegendOrientation.VERTICAL) {
                oxoX2 += this.f34563oIX0oI.II0XooXoX();
            }
            if (Oo2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                f3 = oxoX2 + this.f34615oxoX.f15951o00;
            } else {
                f3 = oxoX2;
            }
        }
        int i3 = oIX0oI.f34616I0Io[XIxXXX0x02.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                int i4 = oIX0oI.f34617II0xO0[XxX0x0xxx2.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            f12 = 0.0f;
                        } else {
                            float x0XOIxOo2 = this.f34563oIX0oI.x0XOIxOo() / 2.0f;
                            Legend legend = this.f34615oxoX;
                            f12 = (x0XOIxOo2 - (legend.f15943OxI / 2.0f)) + legend.X0o0xo();
                        }
                    } else {
                        if (OxI2 == Legend.LegendHorizontalAlignment.CENTER) {
                            XO2 = this.f34563oIX0oI.x0XOIxOo();
                        } else {
                            XO2 = this.f34563oIX0oI.XO();
                        }
                        f12 = XO2 - (this.f34615oxoX.f15943OxI + X0o0xo8);
                    }
                } else {
                    if (OxI2 == Legend.LegendHorizontalAlignment.CENTER) {
                        xoIox2 = 0.0f;
                    } else {
                        xoIox2 = this.f34563oIX0oI.xoIox();
                    }
                    f12 = xoIox2 + X0o0xo8;
                }
                float f22 = f12;
                boolean z4 = false;
                int i5 = 0;
                float f23 = 0.0f;
                while (i5 < IXxxXO2.length) {
                    com.github.mikephil.charting.components.oIX0oI oix0oi2 = IXxxXO2[i5];
                    if (oix0oi2.f15995II0xO0 != Legend.LegendForm.NONE) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (Float.isNaN(oix0oi2.f15994I0Io)) {
                        X0o0xo3 = X0o0xo6;
                    } else {
                        X0o0xo3 = XIXIX.OOXIXo.X0o0xo(oix0oi2.f15994I0Io);
                    }
                    if (z3) {
                        Legend.LegendDirection legendDirection3 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        if (Oo2 == legendDirection3) {
                            f18 = f3 + f23;
                        } else {
                            f18 = f3 - (X0o0xo3 - f23);
                        }
                        f16 = f18;
                        f14 = oIX0oI2;
                        f15 = f20;
                        f13 = f3;
                        legendDirection = Oo2;
                        II0xO0(canvas, f16, f22 + oIX0oI2, oix0oi2, this.f34615oxoX);
                        if (legendDirection == legendDirection3) {
                            f16 += X0o0xo3;
                        }
                        oix0oi = oix0oi2;
                    } else {
                        f13 = f3;
                        f14 = oIX0oI2;
                        f15 = f20;
                        legendDirection = Oo2;
                        oix0oi = oix0oi2;
                        f16 = f13;
                    }
                    if (oix0oi.f15998oIX0oI != null) {
                        if (z3 && !z4) {
                            if (legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                f17 = X0o0xo4;
                            } else {
                                f17 = -X0o0xo4;
                            }
                            f16 += f17;
                        } else if (z4) {
                            f16 = f13;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f16 -= XIXIX.OOXIXo.oxoX(this.f34611II0xO0, r1);
                        }
                        float f24 = f16;
                        if (!z4) {
                            I0Io(canvas, f24, f22 + f, oix0oi.f15998oIX0oI);
                        } else {
                            f22 += f + f2;
                            I0Io(canvas, f24, f22 + f, oix0oi.f15998oIX0oI);
                        }
                        f22 += f + f2;
                        f23 = 0.0f;
                    } else {
                        f23 += X0o0xo3 + f15;
                        z4 = true;
                    }
                    i5++;
                    Oo2 = legendDirection;
                    f20 = f15;
                    oIX0oI2 = f14;
                    f3 = f13;
                }
                return;
            }
            return;
        }
        float f25 = f3;
        float f26 = f20;
        List<XIXIX.I0Io> x0xO0oo2 = this.f34615oxoX.x0xO0oo();
        List<XIXIX.I0Io> oO2 = this.f34615oxoX.oO();
        List<Boolean> x0XOIxOo3 = this.f34615oxoX.x0XOIxOo();
        int i6 = oIX0oI.f34617II0xO0[XxX0x0xxx2.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    X0o0xo8 = 0.0f;
                } else {
                    X0o0xo8 += (this.f34563oIX0oI.x0XOIxOo() - this.f34615oxoX.f15943OxI) / 2.0f;
                }
            } else {
                X0o0xo8 = (this.f34563oIX0oI.x0XOIxOo() - X0o0xo8) - this.f34615oxoX.f15943OxI;
            }
        }
        int length = IXxxXO2.length;
        float f27 = f25;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            float f28 = f26;
            com.github.mikephil.charting.components.oIX0oI oix0oi3 = IXxxXO2[i7];
            float f29 = f27;
            int i9 = length;
            if (oix0oi3.f15995II0xO0 != Legend.LegendForm.NONE) {
                z = true;
            } else {
                z = false;
            }
            if (Float.isNaN(oix0oi3.f15994I0Io)) {
                X0o0xo2 = X0o0xo6;
            } else {
                X0o0xo2 = XIXIX.OOXIXo.X0o0xo(oix0oi3.f15994I0Io);
            }
            if (i7 < x0XOIxOo3.size() && x0XOIxOo3.get(i7).booleanValue()) {
                f5 = X0o0xo8 + f + f2;
                f4 = f25;
            } else {
                f4 = f29;
                f5 = X0o0xo8;
            }
            if (f4 == f25 && OxI2 == Legend.LegendHorizontalAlignment.CENTER && i8 < x0xO0oo2.size()) {
                if (Oo2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                    f11 = x0xO0oo2.get(i8).f3743IXxxXO;
                } else {
                    f11 = -x0xO0oo2.get(i8).f3743IXxxXO;
                }
                f4 += f11 / 2.0f;
                i8++;
            }
            int i10 = i8;
            if (oix0oi3.f15998oIX0oI == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                if (Oo2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                    f4 -= X0o0xo2;
                }
                float f30 = f4;
                list2 = x0xO0oo2;
                i = i7;
                list = x0XOIxOo3;
                II0xO0(canvas, f30, f5 + oIX0oI2, oix0oi3, this.f34615oxoX);
                if (Oo2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f4 = f30 + X0o0xo2;
                } else {
                    f4 = f30;
                }
            } else {
                list = x0XOIxOo3;
                list2 = x0xO0oo2;
                i = i7;
            }
            if (!z2) {
                if (z) {
                    if (Oo2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f10 = -X0o0xo4;
                    } else {
                        f10 = X0o0xo4;
                    }
                    f4 += f10;
                }
                Legend.LegendDirection legendDirection4 = Legend.LegendDirection.RIGHT_TO_LEFT;
                if (Oo2 == legendDirection4) {
                    f4 -= oO2.get(i).f3743IXxxXO;
                }
                I0Io(canvas, f4, f5 + f, oix0oi3.f15998oIX0oI);
                if (Oo2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f4 += oO2.get(i).f3743IXxxXO;
                }
                if (Oo2 == legendDirection4) {
                    f6 = f21;
                    f9 = -f6;
                } else {
                    f6 = f21;
                    f9 = f6;
                }
                f27 = f4 + f9;
                f7 = f28;
            } else {
                f6 = f21;
                if (Oo2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                    f7 = f28;
                    f8 = -f7;
                } else {
                    f7 = f28;
                    f8 = f7;
                }
                f27 = f4 + f8;
            }
            f21 = f6;
            f26 = f7;
            i7 = i + 1;
            X0o0xo8 = f5;
            length = i9;
            i8 = i10;
            x0xO0oo2 = list2;
            x0XOIxOo3 = list;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [IIxOXoOo0.X0o0xo] */
    /* JADX WARN: Type inference failed for: r7v1, types: [IIxOXoOo0.X0o0xo] */
    public void oIX0oI(o0xxxXXxX.OOXIXo<?> oOXIXo) {
        String label;
        o0xxxXXxX.OOXIXo<?> oOXIXo2;
        o0xxxXXxX.OOXIXo<?> oOXIXo3 = oOXIXo;
        if (!this.f34615oxoX.xI()) {
            this.f34613X0o0xo.clear();
            int i = 0;
            while (i < oOXIXo.ooOOo0oXI()) {
                ?? OOXIXo2 = oOXIXo3.OOXIXo(i);
                List<Integer> OOXIxO02 = OOXIXo2.OOXIxO0();
                int X0xxXX02 = OOXIXo2.X0xxXX0();
                if (OOXIXo2 instanceof IIxOXoOo0.oIX0oI) {
                    IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) OOXIXo2;
                    if (oix0oi.XoX()) {
                        String[] oxXx0IX2 = oix0oi.oxXx0IX();
                        for (int i2 = 0; i2 < OOXIxO02.size() && i2 < oix0oi.IXxxXO(); i2++) {
                            this.f34613X0o0xo.add(new com.github.mikephil.charting.components.oIX0oI(oxXx0IX2[i2 % oxXx0IX2.length], OOXIXo2.Oxx0IOOO(), OOXIXo2.oOoXoXO(), OOXIXo2.X00IoxXI(), OOXIXo2.xI(), OOXIxO02.get(i2).intValue()));
                        }
                        if (oix0oi.getLabel() != null) {
                            this.f34613X0o0xo.add(new com.github.mikephil.charting.components.oIX0oI(OOXIXo2.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, XIXIX.oIX0oI.f3782oIX0oI));
                        }
                        oOXIXo2 = oOXIXo3;
                        i++;
                        oOXIXo3 = oOXIXo2;
                    }
                }
                if (OOXIXo2 instanceof IIxOXoOo0.xxIXOIIO) {
                    IIxOXoOo0.xxIXOIIO xxixoiio = (IIxOXoOo0.xxIXOIIO) OOXIXo2;
                    for (int i3 = 0; i3 < OOXIxO02.size() && i3 < X0xxXX02; i3++) {
                        this.f34613X0o0xo.add(new com.github.mikephil.charting.components.oIX0oI(xxixoiio.OOXIXo(i3).oOoXoXO(), OOXIXo2.Oxx0IOOO(), OOXIXo2.oOoXoXO(), OOXIXo2.X00IoxXI(), OOXIXo2.xI(), OOXIxO02.get(i3).intValue()));
                    }
                    if (xxixoiio.getLabel() != null) {
                        this.f34613X0o0xo.add(new com.github.mikephil.charting.components.oIX0oI(OOXIXo2.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, XIXIX.oIX0oI.f3782oIX0oI));
                    }
                } else {
                    if (OOXIXo2 instanceof IIxOXoOo0.oxoX) {
                        IIxOXoOo0.oxoX oxox = (IIxOXoOo0.oxoX) OOXIXo2;
                        if (oxox.XoI0Ixx0() != 1122867) {
                            int XoI0Ixx02 = oxox.XoI0Ixx0();
                            int o002 = oxox.o00();
                            this.f34613X0o0xo.add(new com.github.mikephil.charting.components.oIX0oI(null, OOXIXo2.Oxx0IOOO(), OOXIXo2.oOoXoXO(), OOXIXo2.X00IoxXI(), OOXIXo2.xI(), XoI0Ixx02));
                            this.f34613X0o0xo.add(new com.github.mikephil.charting.components.oIX0oI(OOXIXo2.getLabel(), OOXIXo2.Oxx0IOOO(), OOXIXo2.oOoXoXO(), OOXIXo2.X00IoxXI(), OOXIXo2.xI(), o002));
                        }
                    }
                    for (int i4 = 0; i4 < OOXIxO02.size() && i4 < X0xxXX02; i4++) {
                        if (i4 < OOXIxO02.size() - 1 && i4 < X0xxXX02 - 1) {
                            label = null;
                        } else {
                            label = oOXIXo.OOXIXo(i).getLabel();
                        }
                        this.f34613X0o0xo.add(new com.github.mikephil.charting.components.oIX0oI(label, OOXIXo2.Oxx0IOOO(), OOXIXo2.oOoXoXO(), OOXIXo2.X00IoxXI(), OOXIXo2.xI(), OOXIxO02.get(i4).intValue()));
                    }
                }
                oOXIXo2 = oOXIXo;
                i++;
                oOXIXo3 = oOXIXo2;
            }
            if (this.f34615oxoX.Oxx0xo() != null) {
                Collections.addAll(this.f34613X0o0xo, this.f34615oxoX.Oxx0xo());
            }
            this.f34615oxoX.IO(this.f34613X0o0xo);
        }
        Typeface I0Io2 = this.f34615oxoX.I0Io();
        if (I0Io2 != null) {
            this.f34611II0xO0.setTypeface(I0Io2);
        }
        this.f34611II0xO0.setTextSize(this.f34615oxoX.II0xO0());
        this.f34611II0xO0.setColor(this.f34615oxoX.oIX0oI());
        this.f34615oxoX.ooOOo0oXI(this.f34611II0xO0, this.f34563oIX0oI);
    }

    public Paint oxoX() {
        return this.f34610I0Io;
    }
}
