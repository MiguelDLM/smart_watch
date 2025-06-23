package XI0oooXX;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public abstract class II0XooXoX<T extends PieRadarChartBase> implements XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public List<oxoX> f3716II0xO0 = new ArrayList();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public T f3717oIX0oI;

    public II0XooXoX(T t) {
        this.f3717oIX0oI = t;
    }

    public abstract oxoX II0xO0(int i, float f, float f2);

    @Override // XI0oooXX.XO
    public oxoX oIX0oI(float f, float f2) {
        if (this.f3717oIX0oI.XoX(f, f2) > this.f3717oIX0oI.getRadius()) {
            return null;
        }
        float oxXx0IX2 = this.f3717oIX0oI.oxXx0IX(f, f2);
        T t = this.f3717oIX0oI;
        if (t instanceof PieChart) {
            oxXx0IX2 /= t.getAnimator().xxIXOIIO();
        }
        int xo0x2 = this.f3717oIX0oI.xo0x(oxXx0IX2);
        if (xo0x2 < 0 || xo0x2 >= this.f3717oIX0oI.getData().xoXoI().X0xxXX0()) {
            return null;
        }
        return II0xO0(xo0x2, f, f2);
    }
}
