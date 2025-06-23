package xxx00;

import OXOo.OOXIXo;
import XIXIX.oOoXoXO;
import XIXIX.xxIXOIIO;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.xoIox;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f35574oIX0oI = new oIX0oI();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static float f35573II0xO0 = 300.0f;

    @OOXIXo
    public final LimitLine I0Io(@OOXIXo Context mContext) {
        IIX0o.x0xO0oo(mContext, "mContext");
        LimitLine limitLine = new LimitLine(f35573II0xO0, null);
        limitLine.O0xOxO(0.5f);
        limitLine.OxI(ContextCompat.getColor(mContext, R.color.line_color));
        limitLine.x0XOIxOo(4.0f, 2.0f, 0.0f);
        return limitLine;
    }

    public final void II0XooXoX(@OOXIXo YAxis yLeft, @OOXIXo YAxis yRight, float f, int i) {
        IIX0o.x0xO0oo(yLeft, "yLeft");
        IIX0o.x0xO0oo(yRight, "yRight");
        yLeft.Oxx0IOOO(false);
        yRight.XoI0Ixx0(false);
        if (f > 0.0f) {
            yRight.xXOx(f);
            yLeft.xXOx(f);
        }
        yRight.I0oOIX(false);
        yRight.Xo0(false);
        yRight.II0XooXoX(i);
        yRight.I0X0x0oIo(0.0f);
        yRight.o0oIxOo(0.0f);
        yLeft.I0X0x0oIo(0.0f);
        yLeft.o0oIxOo(0.0f);
    }

    public final void II0xO0(@OOXIXo LineChart bpChart) {
        IIX0o.x0xO0oo(bpChart, "bpChart");
        oOoXoXO viewPortHandler = bpChart.getViewPortHandler();
        IIX0o.oO(viewPortHandler, "getViewPortHandler(...)");
        XAxis xAxis = bpChart.getXAxis();
        IIX0o.oO(xAxis, "getXAxis(...)");
        xxIXOIIO oxoX2 = bpChart.oxoX(YAxis.AxisDependency.LEFT);
        IIX0o.oO(oxoX2, "getTransformer(...)");
        bpChart.setXAxisRenderer(new oxoX(viewPortHandler, xAxis, oxoX2));
        if (!xoIox.ooXIXxIX()) {
            bpChart.setExtraBottomOffset(8.0f);
        }
        bpChart.II0XooXoX(1000);
        bpChart.setNoDataText("");
        bpChart.setExtraBottomOffset(18.0f);
    }

    public final void Oxx0IOOO(@OOXIXo YAxis yLeft, @OOXIXo YAxis yRight, float f, float f2, int i) {
        IIX0o.x0xO0oo(yLeft, "yLeft");
        IIX0o.x0xO0oo(yRight, "yRight");
        yLeft.Oxx0IOOO(false);
        yRight.XoI0Ixx0(true);
        if (f > 0.0f) {
            yRight.xXOx(f);
            yLeft.xXOx(f);
        }
        yRight.I0oOIX(true);
        yRight.Xo0(false);
        yRight.II0XooXoX(i);
        yRight.I0X0x0oIo(f2);
        yRight.o0oIxOo(0.0f);
        yLeft.I0X0x0oIo(f2);
        yLeft.o0oIxOo(0.0f);
    }

    public final void X0o0xo(@OOXIXo XAxis xAxis, boolean z, @OOXIXo Context mContext) {
        IIX0o.x0xO0oo(xAxis, "xAxis");
        IIX0o.x0xO0oo(mContext, "mContext");
        xAxis.XoI0Ixx0(false);
        xAxis.I0(XAxis.XAxisPosition.BOTTOM);
        xAxis.oxxXoxO(oIxOXo.oxoX.I0Io(mContext, R.color.line_color));
        xAxis.II0XooXoX(oIxOXo.oxoX.I0Io(mContext, R.color.status_x_axis_text_color));
        xAxis.oxXx0IX(1.0f);
        xAxis.xxIXOIIO(10.0f);
        if (z) {
            xAxis.Oo(4.0f, 2.0f, 0.0f);
        }
    }

    public final void XO(@OOXIXo YAxis yLeft, @OOXIXo YAxis yRight, float f, float f2) {
        IIX0o.x0xO0oo(yLeft, "yLeft");
        IIX0o.x0xO0oo(yRight, "yRight");
        f35573II0xO0 = f;
        yRight.Oxx0IOOO(false);
        yLeft.XoI0Ixx0(false);
        if (f > 0.0f) {
            yLeft.xXOx(f);
        }
        yLeft.I0oOIX(false);
        yLeft.Xo0(false);
        yLeft.I0X0x0oIo(f2);
        yLeft.o0oIxOo(0.0f);
        yRight.I0X0x0oIo(f2);
        yRight.o0oIxOo(0.0f);
    }

    public final void oIX0oI(@OOXIXo BarChart bpChart) {
        IIX0o.x0xO0oo(bpChart, "bpChart");
        oOoXoXO viewPortHandler = bpChart.getViewPortHandler();
        IIX0o.oO(viewPortHandler, "getViewPortHandler(...)");
        XAxis xAxis = bpChart.getXAxis();
        IIX0o.oO(xAxis, "getXAxis(...)");
        xxIXOIIO oxoX2 = bpChart.oxoX(YAxis.AxisDependency.LEFT);
        IIX0o.oO(oxoX2, "getTransformer(...)");
        bpChart.setXAxisRenderer(new oxoX(viewPortHandler, xAxis, oxoX2));
        if (!xoIox.ooXIXxIX()) {
            bpChart.setExtraBottomOffset(10.0f);
        }
        bpChart.setFitBars(true);
        bpChart.II0XooXoX(1000);
        bpChart.setNoDataText("");
        bpChart.setExtraBottomOffset(18.0f);
    }

    public final void oxoX(@OOXIXo YAxis yLeft, @OOXIXo YAxis yRight, float f) {
        IIX0o.x0xO0oo(yLeft, "yLeft");
        IIX0o.x0xO0oo(yRight, "yRight");
        float f2 = f + 20.0f;
        yRight.xXOx(f2);
        yLeft.xXOx(f2);
    }
}
