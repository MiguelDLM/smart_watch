package o0xxxXXxX;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class OxxIIOOXO extends oO<Entry> implements IIxOXoOo0.OOXIXo {

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public float f31259XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public float f31260XxX0x0xxx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f31261xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public xOOOX.X0o0xo f31262xxX;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f31263oIX0oI;

        static {
            int[] iArr = new int[ScatterChart.ScatterShape.values().length];
            f31263oIX0oI = iArr;
            try {
                iArr[ScatterChart.ScatterShape.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31263oIX0oI[ScatterChart.ScatterShape.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31263oIX0oI[ScatterChart.ScatterShape.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31263oIX0oI[ScatterChart.ScatterShape.CROSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31263oIX0oI[ScatterChart.ScatterShape.X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31263oIX0oI[ScatterChart.ScatterShape.CHEVRON_UP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31263oIX0oI[ScatterChart.ScatterShape.CHEVRON_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public OxxIIOOXO(List<Entry> list, String str) {
        super(list, str);
        this.f31259XIxXXX0x0 = 15.0f;
        this.f31262xxX = new xOOOX.XO();
        this.f31260XxX0x0xxx = 0.0f;
        this.f31261xXxxox0I = XIXIX.oIX0oI.f3782oIX0oI;
    }

    public static xOOOX.X0o0xo XooIO0oo0(ScatterChart.ScatterShape scatterShape) {
        switch (oIX0oI.f31263oIX0oI[scatterShape.ordinal()]) {
            case 1:
                return new xOOOX.XO();
            case 2:
                return new xOOOX.I0Io();
            case 3:
                return new xOOOX.Oxx0IOOO();
            case 4:
                return new xOOOX.oxoX();
            case 5:
                return new xOOOX.II0XooXoX();
            case 6:
                return new xOOOX.II0xO0();
            case 7:
                return new xOOOX.oIX0oI();
            default:
                return null;
        }
    }

    @Override // IIxOXoOo0.OOXIXo
    public int IIxOXoOo0() {
        return this.f31261xXxxox0I;
    }

    public void OOIXx0x(ScatterChart.ScatterShape scatterShape) {
        this.f31262xxX = XooIO0oo0(scatterShape);
    }

    public void OXXoIoXI(OxxIIOOXO oxxIIOOXO) {
        super.o0oxo0oI(oxxIIOOXO);
        oxxIIOOXO.f31259XIxXXX0x0 = this.f31259XIxXXX0x0;
        oxxIIOOXO.f31262xxX = this.f31262xxX;
        oxxIIOOXO.f31260XxX0x0xxx = this.f31260XxX0x0xxx;
        oxxIIOOXO.f31261xXxxox0I = this.f31261xXxxox0I;
    }

    @Override // IIxOXoOo0.OOXIXo
    public float XI() {
        return this.f31260XxX0x0xxx;
    }

    @Override // IIxOXoOo0.OOXIXo
    public xOOOX.X0o0xo XX() {
        return this.f31262xxX;
    }

    @Override // IIxOXoOo0.OOXIXo
    public float oO() {
        return this.f31259XIxXXX0x0;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> oX0I0O() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f16010Oxx0xo.size(); i++) {
            arrayList.add(((Entry) this.f16010Oxx0xo.get(i)).Oxx0IOOO());
        }
        OxxIIOOXO oxxIIOOXO = new OxxIIOOXO(arrayList, getLabel());
        OXXoIoXI(oxxIIOOXO);
        return oxxIIOOXO;
    }

    public void oXxx000(float f) {
        this.f31260XxX0x0xxx = f;
    }

    public void xIx(xOOOX.X0o0xo x0o0xo) {
        this.f31262xxX = x0o0xo;
    }

    public void xIx0XO(int i) {
        this.f31261xXxxox0I = i;
    }

    public void xOOxI(float f) {
        this.f31259XIxXXX0x0 = f;
    }
}
