package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.CandleEntry;
import java.util.List;
import xX0IIXIx0.I0Io;

/* loaded from: classes9.dex */
public class X0o0xo extends oOoXoXO {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public float[] f34546OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public float[] f34547oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public float[] f34548ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public float[] f34549x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public float[] f34550xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public OOXIxO0.oxoX f34551xxIXOIIO;

    public X0o0xo(OOXIxO0.oxoX oxox, Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
        this.f34550xoIox = new float[8];
        this.f34546OOXIXo = new float[4];
        this.f34547oOoXoXO = new float[4];
        this.f34548ooOOo0oXI = new float[4];
        this.f34549x0XOIxOo = new float[4];
        this.f34551xxIXOIIO = oxox;
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void II0xO0(Canvas canvas) {
        for (T t : this.f34551xxIXOIIO.getCandleData().Oo()) {
            if (t.isVisible()) {
                oO(canvas, t);
            }
        }
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void X0o0xo(Canvas canvas, String str, float f, float f2, int i) {
        this.f34532XO.setColor(i);
        canvas.drawText(str, f, f2, this.f34532XO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void XO(Canvas canvas) {
        IIxOXoOo0.oxoX oxox;
        CandleEntry candleEntry;
        float f;
        if (OOXIXo(this.f34551xxIXOIIO)) {
            List<T> Oo2 = this.f34551xxIXOIIO.getCandleData().Oo();
            for (int i = 0; i < Oo2.size(); i++) {
                IIxOXoOo0.oxoX oxox2 = (IIxOXoOo0.oxoX) Oo2.get(i);
                if (ooOOo0oXI(oxox2) && oxox2.X0xxXX0() >= 1) {
                    oIX0oI(oxox2);
                    XIXIX.xxIXOIIO oxoX2 = this.f34551xxIXOIIO.oxoX(oxox2.OX00O0xII());
                    this.f34506Oxx0IOOO.oIX0oI(this.f34551xxIXOIIO, oxox2);
                    float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
                    float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
                    I0Io.oIX0oI oix0oi = this.f34506Oxx0IOOO;
                    float[] II0xO02 = oxoX2.II0xO0(oxox2, II0XooXoX2, xxIXOIIO2, oix0oi.f34509oIX0oI, oix0oi.f34508II0xO0);
                    float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(5.0f);
                    ox.x0xO0oo xxIO2 = oxox2.xxIO();
                    XIXIX.Oxx0IOOO oxoX3 = XIXIX.Oxx0IOOO.oxoX(oxox2.IO0XoXxO());
                    oxoX3.f3771IXxxXO = XIXIX.OOXIXo.X0o0xo(oxoX3.f3771IXxxXO);
                    oxoX3.f3772Oxx0xo = XIXIX.OOXIXo.X0o0xo(oxoX3.f3772Oxx0xo);
                    int i2 = 0;
                    while (i2 < II0xO02.length) {
                        float f2 = II0xO02[i2];
                        float f3 = II0xO02[i2 + 1];
                        if (!this.f34563oIX0oI.oo0xXOI0I(f2)) {
                            break;
                        }
                        if (!this.f34563oIX0oI.xI(f2) || !this.f34563oIX0oI.oOXoIIIo(f3)) {
                            oxox = oxox2;
                        } else {
                            int i3 = i2 / 2;
                            CandleEntry candleEntry2 = (CandleEntry) oxox2.OOXIXo(this.f34506Oxx0IOOO.f34509oIX0oI + i3);
                            if (oxox2.xoO0xx0()) {
                                candleEntry = candleEntry2;
                                f = f3;
                                oxox = oxox2;
                                X0o0xo(canvas, xxIO2.Oxx0IOOO(candleEntry2), f2, f3 - X0o0xo2, oxox2.x0xO0oo(i3));
                            } else {
                                candleEntry = candleEntry2;
                                f = f3;
                                oxox = oxox2;
                            }
                            if (candleEntry.II0xO0() != null && oxox.oo0xXOI0I()) {
                                Drawable II0xO03 = candleEntry.II0xO0();
                                XIXIX.OOXIXo.OOXIXo(canvas, II0xO03, (int) (f2 + oxoX3.f3771IXxxXO), (int) (f + oxoX3.f3772Oxx0xo), II0xO03.getIntrinsicWidth(), II0xO03.getIntrinsicHeight());
                            }
                        }
                        i2 += 2;
                        oxox2 = oxox;
                    }
                    XIXIX.Oxx0IOOO.II0XooXoX(oxoX3);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void oO(Canvas canvas, IIxOXoOo0.oxoX oxox) {
        int oXIO0o0XI2;
        int x02;
        int oXIO0o0XI3;
        int o002;
        int XoI0Ixx02;
        XIXIX.xxIXOIIO oxoX2 = this.f34551xxIXOIIO.oxoX(oxox.OX00O0xII());
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        float XIXIxO2 = oxox.XIXIxO();
        boolean X0IIOO2 = oxox.X0IIOO();
        this.f34506Oxx0IOOO.oIX0oI(this.f34551xxIXOIIO, oxox);
        this.f34529I0Io.setStrokeWidth(oxox.xOoOIoI());
        int i = this.f34506Oxx0IOOO.f34509oIX0oI;
        while (true) {
            I0Io.oIX0oI oix0oi = this.f34506Oxx0IOOO;
            if (i <= oix0oi.f34507I0Io + oix0oi.f34509oIX0oI) {
                CandleEntry candleEntry = (CandleEntry) oxox.OOXIXo(i);
                if (candleEntry != null) {
                    float xxIXOIIO3 = candleEntry.xxIXOIIO();
                    float x0xO0oo2 = candleEntry.x0xO0oo();
                    float ooOOo0oXI2 = candleEntry.ooOOo0oXI();
                    float x0XOIxOo2 = candleEntry.x0XOIxOo();
                    float oO2 = candleEntry.oO();
                    if (X0IIOO2) {
                        float[] fArr = this.f34550xoIox;
                        fArr[0] = xxIXOIIO3;
                        fArr[2] = xxIXOIIO3;
                        fArr[4] = xxIXOIIO3;
                        fArr[6] = xxIXOIIO3;
                        if (x0xO0oo2 > ooOOo0oXI2) {
                            fArr[1] = x0XOIxOo2 * xxIXOIIO2;
                            fArr[3] = x0xO0oo2 * xxIXOIIO2;
                            fArr[5] = oO2 * xxIXOIIO2;
                            fArr[7] = ooOOo0oXI2 * xxIXOIIO2;
                        } else if (x0xO0oo2 < ooOOo0oXI2) {
                            fArr[1] = x0XOIxOo2 * xxIXOIIO2;
                            fArr[3] = ooOOo0oXI2 * xxIXOIIO2;
                            fArr[5] = oO2 * xxIXOIIO2;
                            fArr[7] = x0xO0oo2 * xxIXOIIO2;
                        } else {
                            fArr[1] = x0XOIxOo2 * xxIXOIIO2;
                            float f = x0xO0oo2 * xxIXOIIO2;
                            fArr[3] = f;
                            fArr[5] = oO2 * xxIXOIIO2;
                            fArr[7] = f;
                        }
                        oxoX2.oO(fArr);
                        if (oxox.XI0oooXX()) {
                            if (x0xO0oo2 > ooOOo0oXI2) {
                                Paint paint = this.f34529I0Io;
                                if (oxox.XoI0Ixx0() == 1122867) {
                                    XoI0Ixx02 = oxox.XXoOx0(i);
                                } else {
                                    XoI0Ixx02 = oxox.XoI0Ixx0();
                                }
                                paint.setColor(XoI0Ixx02);
                            } else if (x0xO0oo2 < ooOOo0oXI2) {
                                Paint paint2 = this.f34529I0Io;
                                if (oxox.o00() == 1122867) {
                                    o002 = oxox.XXoOx0(i);
                                } else {
                                    o002 = oxox.o00();
                                }
                                paint2.setColor(o002);
                            } else {
                                Paint paint3 = this.f34529I0Io;
                                if (oxox.oXIO0o0XI() == 1122867) {
                                    oXIO0o0XI3 = oxox.XXoOx0(i);
                                } else {
                                    oXIO0o0XI3 = oxox.oXIO0o0XI();
                                }
                                paint3.setColor(oXIO0o0XI3);
                            }
                        } else {
                            Paint paint4 = this.f34529I0Io;
                            if (oxox.x0() == 1122867) {
                                x02 = oxox.XXoOx0(i);
                            } else {
                                x02 = oxox.x0();
                            }
                            paint4.setColor(x02);
                        }
                        this.f34529I0Io.setStyle(Paint.Style.STROKE);
                        canvas.drawLines(this.f34550xoIox, this.f34529I0Io);
                        float[] fArr2 = this.f34546OOXIXo;
                        fArr2[0] = (xxIXOIIO3 - 0.5f) + XIXIxO2;
                        fArr2[1] = ooOOo0oXI2 * xxIXOIIO2;
                        fArr2[2] = (xxIXOIIO3 + 0.5f) - XIXIxO2;
                        fArr2[3] = x0xO0oo2 * xxIXOIIO2;
                        oxoX2.oO(fArr2);
                        if (x0xO0oo2 > ooOOo0oXI2) {
                            if (oxox.XoI0Ixx0() == 1122867) {
                                this.f34529I0Io.setColor(oxox.XXoOx0(i));
                            } else {
                                this.f34529I0Io.setColor(oxox.XoI0Ixx0());
                            }
                            this.f34529I0Io.setStyle(oxox.oxIIX0o());
                            float[] fArr3 = this.f34546OOXIXo;
                            canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.f34529I0Io);
                        } else if (x0xO0oo2 < ooOOo0oXI2) {
                            if (oxox.o00() == 1122867) {
                                this.f34529I0Io.setColor(oxox.XXoOx0(i));
                            } else {
                                this.f34529I0Io.setColor(oxox.o00());
                            }
                            this.f34529I0Io.setStyle(oxox.xII());
                            float[] fArr4 = this.f34546OOXIXo;
                            canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.f34529I0Io);
                        } else {
                            if (oxox.oXIO0o0XI() == 1122867) {
                                this.f34529I0Io.setColor(oxox.XXoOx0(i));
                            } else {
                                this.f34529I0Io.setColor(oxox.oXIO0o0XI());
                            }
                            float[] fArr5 = this.f34546OOXIXo;
                            canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.f34529I0Io);
                        }
                    } else {
                        float[] fArr6 = this.f34547oOoXoXO;
                        fArr6[0] = xxIXOIIO3;
                        fArr6[1] = x0XOIxOo2 * xxIXOIIO2;
                        fArr6[2] = xxIXOIIO3;
                        fArr6[3] = oO2 * xxIXOIIO2;
                        float[] fArr7 = this.f34548ooOOo0oXI;
                        fArr7[0] = (xxIXOIIO3 - 0.5f) + XIXIxO2;
                        float f2 = x0xO0oo2 * xxIXOIIO2;
                        fArr7[1] = f2;
                        fArr7[2] = xxIXOIIO3;
                        fArr7[3] = f2;
                        float[] fArr8 = this.f34549x0XOIxOo;
                        fArr8[0] = (0.5f + xxIXOIIO3) - XIXIxO2;
                        float f3 = ooOOo0oXI2 * xxIXOIIO2;
                        fArr8[1] = f3;
                        fArr8[2] = xxIXOIIO3;
                        fArr8[3] = f3;
                        oxoX2.oO(fArr6);
                        oxoX2.oO(this.f34548ooOOo0oXI);
                        oxoX2.oO(this.f34549x0XOIxOo);
                        if (x0xO0oo2 > ooOOo0oXI2) {
                            if (oxox.XoI0Ixx0() == 1122867) {
                                oXIO0o0XI2 = oxox.XXoOx0(i);
                            } else {
                                oXIO0o0XI2 = oxox.XoI0Ixx0();
                            }
                        } else if (x0xO0oo2 < ooOOo0oXI2) {
                            if (oxox.o00() == 1122867) {
                                oXIO0o0XI2 = oxox.XXoOx0(i);
                            } else {
                                oXIO0o0XI2 = oxox.o00();
                            }
                        } else if (oxox.oXIO0o0XI() == 1122867) {
                            oXIO0o0XI2 = oxox.XXoOx0(i);
                        } else {
                            oXIO0o0XI2 = oxox.oXIO0o0XI();
                        }
                        this.f34529I0Io.setColor(oXIO0o0XI2);
                        float[] fArr9 = this.f34547oOoXoXO;
                        canvas.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.f34529I0Io);
                        float[] fArr10 = this.f34548ooOOo0oXI;
                        canvas.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.f34529I0Io);
                        float[] fArr11 = this.f34549x0XOIxOo;
                        canvas.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.f34529I0Io);
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void oxoX(Canvas canvas, XI0oooXX.oxoX[] oxoxArr) {
        o0xxxXXxX.xxIXOIIO candleData = this.f34551xxIXOIIO.getCandleData();
        for (XI0oooXX.oxoX oxox : oxoxArr) {
            IIxOXoOo0.II0XooXoX iI0XooXoX = (IIxOXoOo0.oxoX) candleData.OOXIXo(oxox.oxoX());
            if (iI0XooXoX != null && iI0XooXoX.XX0()) {
                CandleEntry candleEntry = (CandleEntry) iI0XooXoX.Ox0O(oxox.II0XooXoX(), oxox.xoIox());
                if (oOoXoXO(candleEntry, iI0XooXoX)) {
                    XIXIX.XO XO2 = this.f34551xxIXOIIO.oxoX(iI0XooXoX.OX00O0xII()).XO(candleEntry.xxIXOIIO(), ((candleEntry.oO() * this.f34530II0xO0.xxIXOIIO()) + (candleEntry.x0XOIxOo() * this.f34530II0xO0.xxIXOIIO())) / 2.0f);
                    oxox.x0XOIxOo((float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo);
                    x0XOIxOo(canvas, (float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo, iI0XooXoX);
                }
            }
        }
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void I0Io(Canvas canvas) {
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void xoIox() {
    }
}
