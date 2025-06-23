package XI0oooXX;

import OOXIxO0.II0xO0;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class II0xO0<T extends OOXIxO0.II0xO0> implements XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public List<oxoX> f3718II0xO0 = new ArrayList();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public T f3719oIX0oI;

    public II0xO0(T t) {
        this.f3719oIX0oI = t;
    }

    public oxoX I0Io(List<oxoX> list, float f, float f2, YAxis.AxisDependency axisDependency, float f3) {
        oxoX oxox = null;
        for (int i = 0; i < list.size(); i++) {
            oxoX oxox2 = list.get(i);
            if (axisDependency == null || oxox2.II0xO0() == axisDependency) {
                float X0o0xo2 = X0o0xo(f, f2, oxox2.xxIXOIIO(), oxox2.OOXIXo());
                if (X0o0xo2 < f3) {
                    oxox = oxox2;
                    f3 = X0o0xo2;
                }
            }
        }
        return oxox;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [IIxOXoOo0.X0o0xo] */
    public List<oxoX> II0XooXoX(float f, float f2, float f3) {
        this.f3718II0xO0.clear();
        o0xxxXXxX.I0Io oxoX2 = oxoX();
        if (oxoX2 == null) {
            return this.f3718II0xO0;
        }
        int ooOOo0oXI2 = oxoX2.ooOOo0oXI();
        for (int i = 0; i < ooOOo0oXI2; i++) {
            ?? OOXIXo2 = oxoX2.OOXIXo(i);
            if (OOXIXo2.XX0()) {
                this.f3718II0xO0.addAll(II0xO0(OOXIXo2, i, f, DataSet.Rounding.CLOSEST));
            }
        }
        return this.f3718II0xO0;
    }

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
            XIXIX.XO XO2 = this.f3719oIX0oI.oxoX(x0o0xo.OX00O0xII()).XO(entry.xxIXOIIO(), entry.I0Io());
            arrayList.add(new oxoX(entry.xxIXOIIO(), entry.I0Io(), (float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo, i, x0o0xo.OX00O0xII()));
        }
        return arrayList;
    }

    public float Oxx0IOOO(oxoX oxox) {
        return oxox.OOXIXo();
    }

    public float X0o0xo(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f - f3, f2 - f4);
    }

    public oxoX XO(float f, float f2, float f3) {
        YAxis.AxisDependency axisDependency;
        List<oxoX> II0XooXoX2 = II0XooXoX(f, f2, f3);
        if (II0XooXoX2.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.LEFT;
        float xxIXOIIO2 = xxIXOIIO(II0XooXoX2, f3, axisDependency2);
        YAxis.AxisDependency axisDependency3 = YAxis.AxisDependency.RIGHT;
        if (xxIXOIIO2 < xxIXOIIO(II0XooXoX2, f3, axisDependency3)) {
            axisDependency = axisDependency2;
        } else {
            axisDependency = axisDependency3;
        }
        return I0Io(II0XooXoX2, f2, f3, axisDependency, this.f3719oIX0oI.getMaxHighlightDistance());
    }

    @Override // XI0oooXX.XO
    public oxoX oIX0oI(float f, float f2) {
        XIXIX.XO xoIox2 = xoIox(f, f2);
        float f3 = (float) xoIox2.f3774IXxxXO;
        XIXIX.XO.I0Io(xoIox2);
        return XO(f3, f, f2);
    }

    public o0xxxXXxX.I0Io oxoX() {
        return this.f3719oIX0oI.getData();
    }

    public XIXIX.XO xoIox(float f, float f2) {
        return this.f3719oIX0oI.oxoX(YAxis.AxisDependency.LEFT).xoIox(f, f2);
    }

    public float xxIXOIIO(List<oxoX> list, float f, YAxis.AxisDependency axisDependency) {
        float f2 = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            oxoX oxox = list.get(i);
            if (oxox.II0xO0() == axisDependency) {
                float abs = Math.abs(Oxx0IOOO(oxox) - f);
                if (abs < f2) {
                    f2 = abs;
                }
            }
        }
        return f2;
    }
}
