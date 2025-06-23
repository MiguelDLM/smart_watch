package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.data.Entry;
import java.util.List;
import xX0IIXIx0.I0Io;

/* loaded from: classes9.dex */
public class x0xO0oo extends oOoXoXO {

    /* renamed from: xoIox, reason: collision with root package name */
    public float[] f34591xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public OOXIxO0.II0XooXoX f34592xxIXOIIO;

    public x0xO0oo(OOXIxO0.II0XooXoX iI0XooXoX, Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
        this.f34591xoIox = new float[2];
        this.f34592xxIXOIIO = iI0XooXoX;
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void II0xO0(Canvas canvas) {
        for (T t : this.f34592xxIXOIIO.getScatterData().Oo()) {
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

    @Override // xX0IIXIx0.Oxx0IOOO
    public void XO(Canvas canvas) {
        IIxOXoOo0.OOXIXo oOXIXo;
        Entry entry;
        if (OOXIXo(this.f34592xxIXOIIO)) {
            List<T> Oo2 = this.f34592xxIXOIIO.getScatterData().Oo();
            for (int i = 0; i < this.f34592xxIXOIIO.getScatterData().ooOOo0oXI(); i++) {
                IIxOXoOo0.OOXIXo oOXIXo2 = (IIxOXoOo0.OOXIXo) Oo2.get(i);
                if (ooOOo0oXI(oOXIXo2) && oOXIXo2.X0xxXX0() >= 1) {
                    oIX0oI(oOXIXo2);
                    this.f34506Oxx0IOOO.oIX0oI(this.f34592xxIXOIIO, oOXIXo2);
                    XIXIX.xxIXOIIO oxoX2 = this.f34592xxIXOIIO.oxoX(oOXIXo2.OX00O0xII());
                    float II0XooXoX2 = this.f34530II0xO0.II0XooXoX();
                    float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
                    I0Io.oIX0oI oix0oi = this.f34506Oxx0IOOO;
                    float[] oxoX3 = oxoX2.oxoX(oOXIXo2, II0XooXoX2, xxIXOIIO2, oix0oi.f34509oIX0oI, oix0oi.f34508II0xO0);
                    float X0o0xo2 = XIXIX.OOXIXo.X0o0xo(oOXIXo2.oO());
                    ox.x0xO0oo xxIO2 = oOXIXo2.xxIO();
                    XIXIX.Oxx0IOOO oxoX4 = XIXIX.Oxx0IOOO.oxoX(oOXIXo2.IO0XoXxO());
                    oxoX4.f3771IXxxXO = XIXIX.OOXIXo.X0o0xo(oxoX4.f3771IXxxXO);
                    oxoX4.f3772Oxx0xo = XIXIX.OOXIXo.X0o0xo(oxoX4.f3772Oxx0xo);
                    int i2 = 0;
                    while (i2 < oxoX3.length && this.f34563oIX0oI.oo0xXOI0I(oxoX3[i2])) {
                        if (this.f34563oIX0oI.xI(oxoX3[i2])) {
                            int i3 = i2 + 1;
                            if (this.f34563oIX0oI.oOXoIIIo(oxoX3[i3])) {
                                int i4 = i2 / 2;
                                Entry OOXIXo2 = oOXIXo2.OOXIXo(this.f34506Oxx0IOOO.f34509oIX0oI + i4);
                                if (oOXIXo2.xoO0xx0()) {
                                    entry = OOXIXo2;
                                    oOXIXo = oOXIXo2;
                                    X0o0xo(canvas, xxIO2.xoIox(OOXIXo2), oxoX3[i2], oxoX3[i3] - X0o0xo2, oOXIXo2.x0xO0oo(i4 + this.f34506Oxx0IOOO.f34509oIX0oI));
                                } else {
                                    entry = OOXIXo2;
                                    oOXIXo = oOXIXo2;
                                }
                                if (entry.II0xO0() != null && oOXIXo.oo0xXOI0I()) {
                                    Drawable II0xO02 = entry.II0xO0();
                                    XIXIX.OOXIXo.OOXIXo(canvas, II0xO02, (int) (oxoX3[i2] + oxoX4.f3771IXxxXO), (int) (oxoX3[i3] + oxoX4.f3772Oxx0xo), II0xO02.getIntrinsicWidth(), II0xO02.getIntrinsicHeight());
                                }
                                i2 += 2;
                                oOXIXo2 = oOXIXo;
                            }
                        }
                        oOXIXo = oOXIXo2;
                        i2 += 2;
                        oOXIXo2 = oOXIXo;
                    }
                    XIXIX.Oxx0IOOO.II0XooXoX(oxoX4);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public void oO(Canvas canvas, IIxOXoOo0.OOXIXo oOXIXo) {
        int i;
        if (oOXIXo.X0xxXX0() < 1) {
            return;
        }
        XIXIX.oOoXoXO oooxoxo = this.f34563oIX0oI;
        XIXIX.xxIXOIIO oxoX2 = this.f34592xxIXOIIO.oxoX(oOXIXo.OX00O0xII());
        float xxIXOIIO2 = this.f34530II0xO0.xxIXOIIO();
        xOOOX.X0o0xo XX2 = oOXIXo.XX();
        if (XX2 == null) {
            Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
            return;
        }
        int min = (int) Math.min(Math.ceil(oOXIXo.X0xxXX0() * this.f34530II0xO0.II0XooXoX()), oOXIXo.X0xxXX0());
        int i2 = 0;
        while (i2 < min) {
            ?? OOXIXo2 = oOXIXo.OOXIXo(i2);
            this.f34591xoIox[0] = OOXIXo2.xxIXOIIO();
            this.f34591xoIox[1] = OOXIXo2.I0Io() * xxIXOIIO2;
            oxoX2.oO(this.f34591xoIox);
            if (oooxoxo.oo0xXOI0I(this.f34591xoIox[0])) {
                if (!oooxoxo.xI(this.f34591xoIox[0]) || !oooxoxo.oOXoIIIo(this.f34591xoIox[1])) {
                    i = i2;
                } else {
                    this.f34529I0Io.setColor(oOXIXo.XXoOx0(i2 / 2));
                    XIXIX.oOoXoXO oooxoxo2 = this.f34563oIX0oI;
                    float[] fArr = this.f34591xoIox;
                    i = i2;
                    XX2.oIX0oI(canvas, oOXIXo, oooxoxo2, fArr[0], fArr[1], this.f34529I0Io);
                }
                i2 = i + 1;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    @Override // xX0IIXIx0.Oxx0IOOO
    public void oxoX(Canvas canvas, XI0oooXX.oxoX[] oxoxArr) {
        o0xxxXXxX.oI0IIXIo scatterData = this.f34592xxIXOIIO.getScatterData();
        for (XI0oooXX.oxoX oxox : oxoxArr) {
            IIxOXoOo0.OOXIXo oOXIXo = (IIxOXoOo0.OOXIXo) scatterData.OOXIXo(oxox.oxoX());
            if (oOXIXo != null && oOXIXo.XX0()) {
                ?? Ox0O2 = oOXIXo.Ox0O(oxox.II0XooXoX(), oxox.xoIox());
                if (oOoXoXO(Ox0O2, oOXIXo)) {
                    XIXIX.XO XO2 = this.f34592xxIXOIIO.oxoX(oOXIXo.OX00O0xII()).XO(Ox0O2.xxIXOIIO(), Ox0O2.I0Io() * this.f34530II0xO0.xxIXOIIO());
                    oxox.x0XOIxOo((float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo);
                    x0XOIxOo(canvas, (float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo, oOXIXo);
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
