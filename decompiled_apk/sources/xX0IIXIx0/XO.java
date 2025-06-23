package xX0IIXIx0;

import android.graphics.Canvas;
import android.util.Log;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public class XO extends Oxx0IOOO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public WeakReference<Chart> f34552II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public List<Oxx0IOOO> f34553Oxx0IOOO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public List<XI0oooXX.oxoX> f34554xxIXOIIO;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f34555oIX0oI;

        static {
            int[] iArr = new int[CombinedChart.DrawOrder.values().length];
            f34555oIX0oI = iArr;
            try {
                iArr[CombinedChart.DrawOrder.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34555oIX0oI[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34555oIX0oI[CombinedChart.DrawOrder.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34555oIX0oI[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34555oIX0oI[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public XO(CombinedChart combinedChart, Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
        this.f34553Oxx0IOOO = new ArrayList(5);
        this.f34554xxIXOIIO = new ArrayList();
        this.f34552II0XooXoX = new WeakReference<>(combinedChart);
        oOoXoXO();
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void I0Io(Canvas canvas) {
        Iterator<Oxx0IOOO> it = this.f34553Oxx0IOOO.iterator();
        while (it.hasNext()) {
            it.next().I0Io(canvas);
        }
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void II0xO0(Canvas canvas) {
        Iterator<Oxx0IOOO> it = this.f34553Oxx0IOOO.iterator();
        while (it.hasNext()) {
            it.next().II0xO0(canvas);
        }
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void X0o0xo(Canvas canvas, String str, float f, float f2, int i) {
        Log.e(Chart.f15859o0, "Erroneous call to drawValue() in CombinedChartRenderer!");
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void XO(Canvas canvas) {
        Iterator<Oxx0IOOO> it = this.f34553Oxx0IOOO.iterator();
        while (it.hasNext()) {
            it.next().XO(canvas);
        }
    }

    public void oO(List<Oxx0IOOO> list) {
        this.f34553Oxx0IOOO = list;
    }

    public void oOoXoXO() {
        this.f34553Oxx0IOOO.clear();
        CombinedChart combinedChart = (CombinedChart) this.f34552II0XooXoX.get();
        if (combinedChart == null) {
            return;
        }
        for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
            int i = oIX0oI.f34555oIX0oI[drawOrder.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5 && combinedChart.getScatterData() != null) {
                                this.f34553Oxx0IOOO.add(new x0xO0oo(combinedChart, this.f34530II0xO0, this.f34563oIX0oI));
                            }
                        } else if (combinedChart.getCandleData() != null) {
                            this.f34553Oxx0IOOO.add(new X0o0xo(combinedChart, this.f34530II0xO0, this.f34563oIX0oI));
                        }
                    } else if (combinedChart.getLineData() != null) {
                        this.f34553Oxx0IOOO.add(new xoIox(combinedChart, this.f34530II0xO0, this.f34563oIX0oI));
                    }
                } else if (combinedChart.getBubbleData() != null) {
                    this.f34553Oxx0IOOO.add(new oxoX(combinedChart, this.f34530II0xO0, this.f34563oIX0oI));
                }
            } else if (combinedChart.getBarData() != null) {
                this.f34553Oxx0IOOO.add(new II0xO0(combinedChart, this.f34530II0xO0, this.f34563oIX0oI));
            }
        }
    }

    public Oxx0IOOO ooOOo0oXI(int i) {
        if (i < this.f34553Oxx0IOOO.size() && i >= 0) {
            return this.f34553Oxx0IOOO.get(i);
        }
        return null;
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void oxoX(Canvas canvas, XI0oooXX.oxoX[] oxoxArr) {
        Object obj;
        int indexOf;
        Chart chart = this.f34552II0XooXoX.get();
        if (chart == null) {
            return;
        }
        for (Oxx0IOOO oxx0IOOO : this.f34553Oxx0IOOO) {
            if (oxx0IOOO instanceof II0xO0) {
                obj = ((II0xO0) oxx0IOOO).f34512II0XooXoX.getBarData();
            } else if (oxx0IOOO instanceof xoIox) {
                obj = ((xoIox) oxx0IOOO).f34603xxIXOIIO.getLineData();
            } else if (oxx0IOOO instanceof X0o0xo) {
                obj = ((X0o0xo) oxx0IOOO).f34551xxIXOIIO.getCandleData();
            } else if (oxx0IOOO instanceof x0xO0oo) {
                obj = ((x0xO0oo) oxx0IOOO).f34592xxIXOIIO.getScatterData();
            } else if (oxx0IOOO instanceof oxoX) {
                obj = ((oxoX) oxx0IOOO).f34582II0XooXoX.getBubbleData();
            } else {
                obj = null;
            }
            if (obj == null) {
                indexOf = -1;
            } else {
                indexOf = ((o0xxxXXxX.oOoXoXO) chart.getData()).xII().indexOf(obj);
            }
            this.f34554xxIXOIIO.clear();
            for (XI0oooXX.oxoX oxox : oxoxArr) {
                if (oxox.I0Io() == indexOf || oxox.I0Io() == -1) {
                    this.f34554xxIXOIIO.add(oxox);
                }
            }
            List<XI0oooXX.oxoX> list = this.f34554xxIXOIIO;
            oxx0IOOO.oxoX(canvas, (XI0oooXX.oxoX[]) list.toArray(new XI0oooXX.oxoX[list.size()]));
        }
    }

    public List<Oxx0IOOO> x0XOIxOo() {
        return this.f34553Oxx0IOOO;
    }

    @Override // xX0IIXIx0.Oxx0IOOO
    public void xoIox() {
        Iterator<Oxx0IOOO> it = this.f34553Oxx0IOOO.iterator();
        while (it.hasNext()) {
            it.next().xoIox();
        }
    }
}
