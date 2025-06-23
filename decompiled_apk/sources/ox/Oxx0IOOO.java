package ox;

/* loaded from: classes9.dex */
public class Oxx0IOOO implements xoIox {
    @Override // ox.xoIox
    public float oIX0oI(IIxOXoOo0.XO xo2, OOXIxO0.Oxx0IOOO oxx0IOOO) {
        float yChartMax = oxx0IOOO.getYChartMax();
        float yChartMin = oxx0IOOO.getYChartMin();
        o0xxxXXxX.ooOOo0oXI lineData = oxx0IOOO.getLineData();
        if (xo2.xoxXI() > 0.0f && xo2.x0xO() < 0.0f) {
            return 0.0f;
        }
        if (lineData.O0xOxO() > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.XI0IXoo() < 0.0f) {
            yChartMin = 0.0f;
        }
        if (xo2.x0xO() >= 0.0f) {
            return yChartMin;
        }
        return yChartMax;
    }
}
