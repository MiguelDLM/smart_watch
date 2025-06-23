package I0;

import XIXIX.II0XooXoX;
import XIXIX.oOoXoXO;
import XIXIX.xxIXOIIO;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;

/* loaded from: classes9.dex */
public class XO extends X0o0xo {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static II0XooXoX<XO> f30XI0IXoo;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public YAxis.AxisDependency f31O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public float f32OxI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public Matrix f33X0IIOO;

    /* renamed from: o00, reason: collision with root package name */
    public float f34o00;

    static {
        II0XooXoX<XO> oIX0oI2 = II0XooXoX.oIX0oI(1, new XO(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null));
        f30XI0IXoo = oIX0oI2;
        oIX0oI2.oOoXoXO(0.5f);
    }

    public XO(oOoXoXO oooxoxo, float f, float f2, float f3, float f4, xxIXOIIO xxixoiio, YAxis.AxisDependency axisDependency, View view) {
        super(oooxoxo, f3, f4, xxixoiio, view);
        this.f33X0IIOO = new Matrix();
        this.f34o00 = f;
        this.f32OxI = f2;
        this.f31O0xOxO = axisDependency;
    }

    public static void X0o0xo(XO xo2) {
        f30XI0IXoo.Oxx0IOOO(xo2);
    }

    public static XO oxoX(oOoXoXO oooxoxo, float f, float f2, float f3, float f4, xxIXOIIO xxixoiio, YAxis.AxisDependency axisDependency, View view) {
        XO II0xO02 = f30XI0IXoo.II0xO0();
        II0xO02.f28oI0IIXIo = f3;
        II0xO02.f27OxxIIOOXO = f4;
        II0xO02.f34o00 = f;
        II0xO02.f32OxI = f2;
        II0xO02.f26Oxx0xo = oooxoxo;
        II0xO02.f24IIXOooo = xxixoiio;
        II0xO02.f31O0xOxO = axisDependency;
        II0xO02.f29xoXoI = view;
        return II0xO02;
    }

    @Override // XIXIX.II0XooXoX.oIX0oI
    public II0XooXoX.oIX0oI oIX0oI() {
        return new XO(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix matrix = this.f33X0IIOO;
        this.f26Oxx0xo.IoOoo(this.f34o00, this.f32OxI, matrix);
        this.f26Oxx0xo.XOxIOxOx(matrix, this.f29xoXoI, false);
        float o002 = ((BarLineChartBase) this.f29xoXoI).XO(this.f31O0xOxO).f4028xI / this.f26Oxx0xo.o00();
        float xoXoI2 = ((BarLineChartBase) this.f29xoXoI).getXAxis().f4028xI / this.f26Oxx0xo.xoXoI();
        float[] fArr = this.f25IXxxXO;
        fArr[0] = this.f28oI0IIXIo - (xoXoI2 / 2.0f);
        fArr[1] = this.f27OxxIIOOXO + (o002 / 2.0f);
        this.f24IIXOooo.oO(fArr);
        this.f26Oxx0xo.O0Xx(this.f25IXxxXO, matrix);
        this.f26Oxx0xo.XOxIOxOx(matrix, this.f29xoXoI, false);
        ((BarLineChartBase) this.f29xoXoI).x0xO0oo();
        this.f29xoXoI.postInvalidate();
        X0o0xo(this);
    }
}
