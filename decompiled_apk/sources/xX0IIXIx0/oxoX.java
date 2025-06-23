package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BubbleEntry;
import java.util.List;
import xX0IIXIx0.I0Io;

/* loaded from: classes9.dex */
public class oxoX extends I0Io {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OOXIxO0.I0Io f34582II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public float[] f34583OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public float[] f34584xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public float[] f34585xxIXOIIO;

    public oxoX(OOXIxO0.I0Io i0Io, Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
        this.f34585xxIXOIIO = new float[4];
        this.f34584xoIox = new float[2];
        this.f34583OOXIXo = new float[3];
        this.f34582II0XooXoX = i0Io;
        this.f34529I0Io.setStyle(Paint.Style.FILL);
        this.f34533oxoX.setStyle(Paint.Style.STROKE);
        this.f34533oxoX.setStrokeWidth(XIXIX.OOXIXo.X0o0xo(1.5f));
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void II0xO0(Canvas canvas) {
        for (T t : this.f34582II0XooXoX.getBubbleData().Oo()) {
            if (t.isVisible()) {
                x0XOIxOo(canvas, t);
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
        float f;
        int i;
        BubbleEntry bubbleEntry;
        float f2;
        float f3;
        o0xxxXXxX.Oxx0IOOO bubbleData = this.f34582II0XooXoX.getBubbleData();
        if (bubbleData != null && OOXIXo(this.f34582II0XooXoX)) {
            List<T> Oo2 = bubbleData.Oo();
            float oIX0oI2 = XIXIX.OOXIXo.oIX0oI(this.f34532XO, "1");
            for (int i2 = 0; i2 < Oo2.size(); i2++) {
                IIxOXoOo0.I0Io i0Io = (IIxOXoOo0.I0Io) Oo2.get(i2);
                if (ooOOo0oXI(i0Io) && i0Io.X0xxXX0() >= 1) {
                    oIX0oI(i0Io);
                    float max = Math.max(0.0f, Math.min(1.0f, this.f34530II0xO0.II0XooXoX()));
                    float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
                    this.f34506Oxx0IOOO.oIX0oI(this.f34582II0XooXoX, i0Io);
                    XIXIX.xxIXOIIO oxoX2 = this.f34582II0XooXoX.oxoX(i0Io.OX00O0xII());
                    I0Io.oIX0oI oix0oi = this.f34506Oxx0IOOO;
                    float[] oIX0oI3 = oxoX2.oIX0oI(i0Io, xxIXOIIO2, oix0oi.f34509oIX0oI, oix0oi.f34508II0xO0);
                    if (max == 1.0f) {
                        f = xxIXOIIO2;
                    } else {
                        f = max;
                    }
                    ox.x0xO0oo xxIO2 = i0Io.xxIO();
                    XIXIX.Oxx0IOOO oxoX3 = XIXIX.Oxx0IOOO.oxoX(i0Io.IO0XoXxO());
                    oxoX3.f3771IXxxXO = XIXIX.OOXIXo.X0o0xo(oxoX3.f3771IXxxXO);
                    oxoX3.f3772Oxx0xo = XIXIX.OOXIXo.X0o0xo(oxoX3.f3772Oxx0xo);
                    for (int i3 = 0; i3 < oIX0oI3.length; i3 = i + 2) {
                        int i4 = i3 / 2;
                        int x0xO0oo2 = i0Io.x0xO0oo(this.f34506Oxx0IOOO.f34509oIX0oI + i4);
                        int argb = Color.argb(Math.round(255.0f * f), Color.red(x0xO0oo2), Color.green(x0xO0oo2), Color.blue(x0xO0oo2));
                        float f4 = oIX0oI3[i3];
                        float f5 = oIX0oI3[i3 + 1];
                        if (!this.f34563oIX0oI.oo0xXOI0I(f4)) {
                            break;
                        }
                        if (!this.f34563oIX0oI.xI(f4) || !this.f34563oIX0oI.oOXoIIIo(f5)) {
                            i = i3;
                        } else {
                            BubbleEntry bubbleEntry2 = (BubbleEntry) i0Io.OOXIXo(i4 + this.f34506Oxx0IOOO.f34509oIX0oI);
                            if (i0Io.xoO0xx0()) {
                                bubbleEntry = bubbleEntry2;
                                f2 = f5;
                                f3 = f4;
                                i = i3;
                                X0o0xo(canvas, xxIO2.XO(bubbleEntry2), f4, f5 + (0.5f * oIX0oI2), argb);
                            } else {
                                bubbleEntry = bubbleEntry2;
                                f2 = f5;
                                f3 = f4;
                                i = i3;
                            }
                            if (bubbleEntry.II0xO0() != null && i0Io.oo0xXOI0I()) {
                                Drawable II0xO02 = bubbleEntry.II0xO0();
                                XIXIX.OOXIXo.OOXIXo(canvas, II0xO02, (int) (f3 + oxoX3.f3771IXxxXO), (int) (f2 + oxoX3.f3772Oxx0xo), II0xO02.getIntrinsicWidth(), II0xO02.getIntrinsicHeight());
                            }
                        }
                    }
                    XIXIX.Oxx0IOOO.II0XooXoX(oxoX3);
                }
            }
        }
    }

    public float oO(float f, float f2, float f3, boolean z) {
        if (z) {
            if (f2 == 0.0f) {
                f = 1.0f;
            } else {
                f = (float) Math.sqrt(f / f2);
            }
        }
        return f3 * f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void oxoX(Canvas canvas, XI0oooXX.oxoX[] oxoxArr) {
        o0xxxXXxX.Oxx0IOOO bubbleData = this.f34582II0XooXoX.getBubbleData();
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        for (XI0oooXX.oxoX oxox : oxoxArr) {
            IIxOXoOo0.I0Io i0Io = (IIxOXoOo0.I0Io) bubbleData.OOXIXo(oxox.oxoX());
            if (i0Io != null && i0Io.XX0()) {
                BubbleEntry bubbleEntry = (BubbleEntry) i0Io.Ox0O(oxox.II0XooXoX(), oxox.xoIox());
                if (bubbleEntry.I0Io() == oxox.xoIox() && oOoXoXO(bubbleEntry, i0Io)) {
                    XIXIX.xxIXOIIO oxoX2 = this.f34582II0XooXoX.oxoX(i0Io.OX00O0xII());
                    float[] fArr = this.f34585xxIXOIIO;
                    fArr[0] = 0.0f;
                    fArr[2] = 1.0f;
                    oxoX2.oO(fArr);
                    boolean XIxXXX0x02 = i0Io.XIxXXX0x0();
                    float[] fArr2 = this.f34585xxIXOIIO;
                    float min = Math.min(Math.abs(this.f34563oIX0oI.XO() - this.f34563oIX0oI.xoIox()), Math.abs(fArr2[2] - fArr2[0]));
                    this.f34584xoIox[0] = bubbleEntry.xxIXOIIO();
                    this.f34584xoIox[1] = bubbleEntry.I0Io() * xxIXOIIO2;
                    oxoX2.oO(this.f34584xoIox);
                    float[] fArr3 = this.f34584xoIox;
                    oxox.x0XOIxOo(fArr3[0], fArr3[1]);
                    float oO2 = oO(bubbleEntry.oOoXoXO(), i0Io.getMaxSize(), min, XIxXXX0x02) / 2.0f;
                    if (this.f34563oIX0oI.oo(this.f34584xoIox[1] + oO2) && this.f34563oIX0oI.ooXIXxIX(this.f34584xoIox[1] - oO2) && this.f34563oIX0oI.xI(this.f34584xoIox[0] + oO2)) {
                        if (this.f34563oIX0oI.oo0xXOI0I(this.f34584xoIox[0] - oO2)) {
                            int XXoOx02 = i0Io.XXoOx0((int) bubbleEntry.xxIXOIIO());
                            Color.RGBToHSV(Color.red(XXoOx02), Color.green(XXoOx02), Color.blue(XXoOx02), this.f34583OOXIXo);
                            float[] fArr4 = this.f34583OOXIXo;
                            fArr4[2] = fArr4[2] * 0.5f;
                            this.f34533oxoX.setColor(Color.HSVToColor(Color.alpha(XXoOx02), this.f34583OOXIXo));
                            this.f34533oxoX.setStrokeWidth(i0Io.ooOx());
                            float[] fArr5 = this.f34584xoIox;
                            canvas.drawCircle(fArr5[0], fArr5[1], oO2, this.f34533oxoX);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void x0XOIxOo(Canvas canvas, IIxOXoOo0.I0Io i0Io) {
        if (i0Io.X0xxXX0() < 1) {
            return;
        }
        XIXIX.xxIXOIIO oxoX2 = this.f34582II0XooXoX.oxoX(i0Io.OX00O0xII());
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        this.f34506Oxx0IOOO.oIX0oI(this.f34582II0XooXoX, i0Io);
        float[] fArr = this.f34585xxIXOIIO;
        fArr[0] = 0.0f;
        fArr[2] = 1.0f;
        oxoX2.oO(fArr);
        boolean XIxXXX0x02 = i0Io.XIxXXX0x0();
        float[] fArr2 = this.f34585xxIXOIIO;
        float min = Math.min(Math.abs(this.f34563oIX0oI.XO() - this.f34563oIX0oI.xoIox()), Math.abs(fArr2[2] - fArr2[0]));
        int i = this.f34506Oxx0IOOO.f34509oIX0oI;
        while (true) {
            I0Io.oIX0oI oix0oi = this.f34506Oxx0IOOO;
            if (i <= oix0oi.f34507I0Io + oix0oi.f34509oIX0oI) {
                BubbleEntry bubbleEntry = (BubbleEntry) i0Io.OOXIXo(i);
                this.f34584xoIox[0] = bubbleEntry.xxIXOIIO();
                this.f34584xoIox[1] = bubbleEntry.I0Io() * xxIXOIIO2;
                oxoX2.oO(this.f34584xoIox);
                float oO2 = oO(bubbleEntry.oOoXoXO(), i0Io.getMaxSize(), min, XIxXXX0x02) / 2.0f;
                if (this.f34563oIX0oI.oo(this.f34584xoIox[1] + oO2) && this.f34563oIX0oI.ooXIXxIX(this.f34584xoIox[1] - oO2) && this.f34563oIX0oI.xI(this.f34584xoIox[0] + oO2)) {
                    if (this.f34563oIX0oI.oo0xXOI0I(this.f34584xoIox[0] - oO2)) {
                        this.f34529I0Io.setColor(i0Io.XXoOx0((int) bubbleEntry.xxIXOIIO()));
                        float[] fArr3 = this.f34584xoIox;
                        canvas.drawCircle(fArr3[0], fArr3[1], oO2, this.f34529I0Io);
                    } else {
                        return;
                    }
                }
                i++;
            } else {
                return;
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
