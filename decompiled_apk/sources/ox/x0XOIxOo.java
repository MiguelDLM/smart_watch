package ox;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

/* loaded from: classes9.dex */
public class x0XOIxOo extends x0xO0oo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public PieChart f33523II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public DecimalFormat f33524oIX0oI;

    public x0XOIxOo() {
        this.f33524oIX0oI = new DecimalFormat("###,###,##0.0");
    }

    @Override // ox.x0xO0oo
    public String II0XooXoX(float f) {
        return this.f33524oIX0oI.format(f) + " %";
    }

    @Override // ox.x0xO0oo
    public String xxIXOIIO(float f, PieEntry pieEntry) {
        PieChart pieChart = this.f33523II0xO0;
        if (pieChart != null && pieChart.OO0x0xX()) {
            return II0XooXoX(f);
        }
        return this.f33524oIX0oI.format(f);
    }

    public x0XOIxOo(PieChart pieChart) {
        this();
        this.f33523II0xO0 = pieChart;
    }
}
