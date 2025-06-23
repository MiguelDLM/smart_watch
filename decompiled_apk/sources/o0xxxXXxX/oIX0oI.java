package o0xxxXXxX;

import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* loaded from: classes9.dex */
public class oIX0oI extends I0Io<IIxOXoOo0.oIX0oI> {

    /* renamed from: xoIox, reason: collision with root package name */
    public float f31285xoIox;

    public oIX0oI() {
        this.f31285xoIox = 0.85f;
    }

    public void OI0(float f) {
        this.f31285xoIox = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void XOxIOxOx(float f, float f2, float f3) {
        BarEntry barEntry;
        if (this.f31251xxIXOIIO.size() > 1) {
            int X0xxXX02 = ((IIxOXoOo0.oIX0oI) xoXoI()).X0xxXX0();
            float f4 = f2 / 2.0f;
            float f5 = f3 / 2.0f;
            float f6 = this.f31285xoIox / 2.0f;
            float x0o2 = x0o(f2, f3);
            for (int i = 0; i < X0xxXX02; i++) {
                float f7 = f + f4;
                for (T t : this.f31251xxIXOIIO) {
                    float f8 = f7 + f5 + f6;
                    if (i < t.X0xxXX0() && (barEntry = (BarEntry) t.OOXIXo(i)) != null) {
                        barEntry.xoIox(f8);
                    }
                    f7 = f8 + f6 + f5;
                }
                float f9 = f7 + f4;
                float f10 = x0o2 - (f9 - f);
                if (f10 > 0.0f || f10 < 0.0f) {
                    f9 += f10;
                }
                f = f9;
            }
            XxX0x0xxx();
            return;
        }
        throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
    }

    public float x0o(float f, float f2) {
        return (this.f31251xxIXOIIO.size() * (this.f31285xoIox + f2)) + f;
    }

    public float xII() {
        return this.f31285xoIox;
    }

    public oIX0oI(IIxOXoOo0.oIX0oI... oix0oiArr) {
        super(oix0oiArr);
        this.f31285xoIox = 0.85f;
    }

    public oIX0oI(List<IIxOXoOo0.oIX0oI> list) {
        super(list);
        this.f31285xoIox = 0.85f;
    }
}
