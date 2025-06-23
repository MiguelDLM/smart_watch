package XI0oooXX;

import com.github.mikephil.charting.data.DataSet;
import java.util.List;

/* loaded from: classes9.dex */
public class I0Io extends II0xO0<OOXIxO0.XO> implements XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public oIX0oI f3715I0Io;

    public I0Io(OOXIxO0.XO xo2, OOXIxO0.oIX0oI oix0oi) {
        super(xo2);
        oIX0oI oix0oi2;
        if (oix0oi.getBarData() == null) {
            oix0oi2 = null;
        } else {
            oix0oi2 = new oIX0oI(oix0oi);
        }
        this.f3715I0Io = oix0oi2;
    }

    @Override // XI0oooXX.II0xO0
    public List<oxoX> II0XooXoX(float f, float f2, float f3) {
        this.f3718II0xO0.clear();
        List<o0xxxXXxX.I0Io> xII2 = ((OOXIxO0.XO) this.f3719oIX0oI).getCombinedData().xII();
        for (int i = 0; i < xII2.size(); i++) {
            o0xxxXXxX.I0Io i0Io = xII2.get(i);
            oIX0oI oix0oi = this.f3715I0Io;
            if (oix0oi != null && (i0Io instanceof o0xxxXXxX.oIX0oI)) {
                oxoX oIX0oI2 = oix0oi.oIX0oI(f2, f3);
                if (oIX0oI2 != null) {
                    oIX0oI2.ooOOo0oXI(i);
                    this.f3718II0xO0.add(oIX0oI2);
                }
            } else {
                int ooOOo0oXI2 = i0Io.ooOOo0oXI();
                for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
                    IIxOXoOo0.X0o0xo OOXIXo2 = xII2.get(i).OOXIXo(i2);
                    if (OOXIXo2.XX0()) {
                        for (oxoX oxox : II0xO0(OOXIXo2, i2, f, DataSet.Rounding.CLOSEST)) {
                            oxox.ooOOo0oXI(i);
                            this.f3718II0xO0.add(oxox);
                        }
                    }
                }
            }
        }
        return this.f3718II0xO0;
    }
}
