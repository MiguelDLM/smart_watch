package XI0oooXX;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class X0o0xo extends oIX0oI {
    public X0o0xo(OOXIxO0.oIX0oI oix0oi) {
        super(oix0oi);
    }

    @Override // XI0oooXX.II0xO0
    public List<oxoX> II0xO0(IIxOXoOo0.X0o0xo x0o0xo, int i, float f, DataSet.Rounding rounding) {
        Entry Ix00oIoI2;
        ArrayList arrayList = new ArrayList();
        List<Entry> OxxIIOOXO2 = x0o0xo.OxxIIOOXO(f);
        if (OxxIIOOXO2.size() == 0 && (Ix00oIoI2 = x0o0xo.Ix00oIoI(f, Float.NaN, rounding)) != null) {
            OxxIIOOXO2 = x0o0xo.OxxIIOOXO(Ix00oIoI2.xxIXOIIO());
        }
        if (OxxIIOOXO2.size() == 0) {
            return arrayList;
        }
        for (Entry entry : OxxIIOOXO2) {
            XIXIX.XO XO2 = ((OOXIxO0.oIX0oI) this.f3719oIX0oI).oxoX(x0o0xo.OX00O0xII()).XO(entry.I0Io(), entry.xxIXOIIO());
            arrayList.add(new oxoX(entry.xxIXOIIO(), entry.I0Io(), (float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo, i, x0o0xo.OX00O0xII()));
        }
        return arrayList;
    }

    @Override // XI0oooXX.oIX0oI, XI0oooXX.II0xO0
    public float X0o0xo(float f, float f2, float f3, float f4) {
        return Math.abs(f2 - f4);
    }

    @Override // XI0oooXX.oIX0oI, XI0oooXX.II0xO0, XI0oooXX.XO
    public oxoX oIX0oI(float f, float f2) {
        o0xxxXXxX.oIX0oI barData = ((OOXIxO0.oIX0oI) this.f3719oIX0oI).getBarData();
        XIXIX.XO xoIox2 = xoIox(f2, f);
        oxoX XO2 = XO((float) xoIox2.f3775Oxx0xo, f2, f);
        if (XO2 == null) {
            return null;
        }
        IIxOXoOo0.oIX0oI oix0oi = (IIxOXoOo0.oIX0oI) barData.OOXIXo(XO2.oxoX());
        if (oix0oi.XoX()) {
            return oOoXoXO(XO2, oix0oi, (float) xoIox2.f3775Oxx0xo, (float) xoIox2.f3774IXxxXO);
        }
        XIXIX.XO.I0Io(xoIox2);
        return XO2;
    }
}
