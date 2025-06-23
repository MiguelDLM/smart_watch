package XI0oooXX;

import XIXIX.OOXIXo;
import com.github.mikephil.charting.charts.RadarChart;
import java.util.List;
import o0xxxXXxX.IXxxXO;

/* loaded from: classes9.dex */
public class xxIXOIIO extends II0XooXoX<RadarChart> {
    public xxIXOIIO(RadarChart radarChart) {
        super(radarChart);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.data.Entry, o0xxxXXxX.XO] */
    public List<oxoX> I0Io(int i) {
        int i2 = i;
        this.f3716II0xO0.clear();
        float II0XooXoX2 = ((RadarChart) this.f3717oIX0oI).getAnimator().II0XooXoX();
        float xxIXOIIO2 = ((RadarChart) this.f3717oIX0oI).getAnimator().xxIXOIIO();
        float sliceAngle = ((RadarChart) this.f3717oIX0oI).getSliceAngle();
        float factor = ((RadarChart) this.f3717oIX0oI).getFactor();
        XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
        int i3 = 0;
        while (i3 < ((IXxxXO) ((RadarChart) this.f3717oIX0oI).getData()).ooOOo0oXI()) {
            IIxOXoOo0.xoIox OOXIXo2 = ((IXxxXO) ((RadarChart) this.f3717oIX0oI).getData()).OOXIXo(i3);
            ?? OOXIXo3 = OOXIXo2.OOXIXo(i2);
            float f = i2;
            OOXIXo.XI0IXoo(((RadarChart) this.f3717oIX0oI).getCenterOffsets(), (OOXIXo3.I0Io() - ((RadarChart) this.f3717oIX0oI).getYChartMin()) * factor * xxIXOIIO2, (sliceAngle * f * II0XooXoX2) + ((RadarChart) this.f3717oIX0oI).getRotationAngle(), I0Io2);
            this.f3716II0xO0.add(new oxoX(f, OOXIXo3.I0Io(), I0Io2.f3771IXxxXO, I0Io2.f3772Oxx0xo, i3, OOXIXo2.OX00O0xII()));
            i3++;
            i2 = i;
        }
        return this.f3716II0xO0;
    }

    @Override // XI0oooXX.II0XooXoX
    public oxoX II0xO0(int i, float f, float f2) {
        List<oxoX> I0Io2 = I0Io(i);
        float XoX2 = ((RadarChart) this.f3717oIX0oI).XoX(f, f2) / ((RadarChart) this.f3717oIX0oI).getFactor();
        oxoX oxox = null;
        float f3 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < I0Io2.size(); i2++) {
            oxoX oxox2 = I0Io2.get(i2);
            float abs = Math.abs(oxox2.xoIox() - XoX2);
            if (abs < f3) {
                oxox = oxox2;
                f3 = abs;
            }
        }
        return oxox;
    }
}
