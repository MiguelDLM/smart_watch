package XI0oooXX;

import com.github.mikephil.charting.data.BarEntry;

/* loaded from: classes9.dex */
public class oIX0oI extends II0xO0<OOXIxO0.oIX0oI> {
    public oIX0oI(OOXIxO0.oIX0oI oix0oi) {
        super(oix0oi);
    }

    public int OOXIXo(xoIox[] xoioxArr, float f) {
        if (xoioxArr == null || xoioxArr.length == 0) {
            return 0;
        }
        int i = 0;
        for (xoIox xoiox : xoioxArr) {
            if (xoiox.oIX0oI(f)) {
                return i;
            }
            i++;
        }
        int max = Math.max(xoioxArr.length - 1, 0);
        if (f <= xoioxArr[max].f3730II0xO0) {
            return 0;
        }
        return max;
    }

    @Override // XI0oooXX.II0xO0
    public float X0o0xo(float f, float f2, float f3, float f4) {
        return Math.abs(f - f3);
    }

    @Override // XI0oooXX.II0xO0, XI0oooXX.XO
    public oxoX oIX0oI(float f, float f2) {
        oxoX oIX0oI2 = super.oIX0oI(f, f2);
        if (oIX0oI2 == null) {
            return null;
        }
        XIXIX.XO xoIox2 = xoIox(f, f2);
        IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) ((OOXIxO0.oIX0oI) this.f3719oIX0oI).getBarData().OOXIXo(oIX0oI2.oxoX());
        if (oix0oi.XoX()) {
            return oOoXoXO(oIX0oI2, oix0oi, (float) xoIox2.f3774IXxxXO, (float) xoIox2.f3775Oxx0xo);
        }
        XIXIX.XO.I0Io(xoIox2);
        return oIX0oI2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public oxoX oOoXoXO(oxoX oxox, IIxOXoOo0.oIX0oI oix0oi, float f, float f2) {
        BarEntry barEntry = (BarEntry) oix0oi.Ox0O(f, f2);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.oI0IIXIo() == null) {
            return oxox;
        }
        xoIox[] IXxxXO2 = barEntry.IXxxXO();
        if (IXxxXO2.length <= 0) {
            return null;
        }
        int OOXIXo2 = OOXIXo(IXxxXO2, f2);
        XIXIX.XO XO2 = ((OOXIxO0.oIX0oI) this.f3719oIX0oI).oxoX(oix0oi.OX00O0xII()).XO(oxox.II0XooXoX(), IXxxXO2[OOXIXo2].f3730II0xO0);
        oxoX oxox2 = new oxoX(barEntry.xxIXOIIO(), barEntry.I0Io(), (float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo, oxox.oxoX(), OOXIXo2, oxox.II0xO0());
        XIXIX.XO.I0Io(XO2);
        return oxox2;
    }

    @Override // XI0oooXX.II0xO0
    public o0xxxXXxX.I0Io oxoX() {
        return ((OOXIxO0.oIX0oI) this.f3719oIX0oI).getBarData();
    }
}
