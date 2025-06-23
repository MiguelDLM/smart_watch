package Ix0x;

import android.util.Log;
import com.app.sicbiaalg.BiaAlgInInfJClass;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import java.math.BigDecimal;

/* loaded from: classes13.dex */
public class Oxx0IOOO extends II0XooXoX {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static Oxx0IOOO f994Oxx0xo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public xXxxox0I.oIX0oI f995IXxxXO;

    public static Oxx0IOOO IIxOXoOo0() {
        Oxx0IOOO oxx0IOOO = f994Oxx0xo;
        if (oxx0IOOO == null) {
            Oxx0IOOO oxx0IOOO2 = new Oxx0IOOO();
            f994Oxx0xo = oxx0IOOO2;
            return oxx0IOOO2;
        }
        return oxx0IOOO;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        return this.f995IXxxXO.ooOOo0oXI();
    }

    @Override // Ix0x.II0XooXoX
    public int I0X0x0oIo() {
        return (int) this.f995IXxxXO.oIX0oI();
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return this.f995IXxxXO.XX();
    }

    @Override // Ix0x.II0XooXoX
    public double[] IIXOooo() {
        return OOXIxO0(ooOOo0oXI());
    }

    @Override // Ix0x.II0XooXoX
    public double[] Io() {
        return this.f995IXxxXO.IoOoX();
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        return this.f995IXxxXO.OxI();
    }

    @Override // Ix0x.II0XooXoX
    public double O0Xx() {
        return this.f995IXxxXO.oxxXoxO();
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        return O0Xx();
    }

    public final double[] OOXIxO0(double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = (dArr[i] * this.f978oIX0oI) / 100.0d;
        }
        return dArr2;
    }

    @Override // Ix0x.II0XooXoX
    public double[] Oo() {
        return this.f995IXxxXO.OI0();
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxI() {
        return this.f995IXxxXO.Io();
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxxIIOOXO() {
        return this.f995IXxxXO.XOxIOxOx();
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        return this.f995IXxxXO.IIX0o();
    }

    @Override // Ix0x.II0XooXoX
    public II0XooXoX XI0IXoo(ScaleUserInfo scaleUserInfo, double d, double d2) {
        ScaleInfo scaleInfo;
        super.XI0IXoo(scaleUserInfo, d, d2);
        if (scaleUserInfo.XO()) {
            return this;
        }
        scaleUserInfo.oIX0oI();
        BiaAlgInInfJClass biaAlgInInfJClass = new BiaAlgInInfJClass();
        biaAlgInInfJClass.XO(((int) scaleUserInfo.II0xO0()) * 10);
        biaAlgInInfJClass.Oxx0IOOO(scaleUserInfo.oxoX());
        biaAlgInInfJClass.xxIXOIIO(scaleUserInfo.I0Io());
        int i = 0;
        biaAlgInInfJClass.xoIox(new BigDecimal(d + "").multiply(new BigDecimal("100")).setScale(0, 4).intValue());
        biaAlgInInfJClass.II0XooXoX((int) d2);
        Log.d("1016Calc", "execueBonso: rucan:age:" + biaAlgInInfJClass.oIX0oI() + " ,height:" + biaAlgInInfJClass.II0xO0() + " ,sex:" + biaAlgInInfJClass.oxoX() + " ,weight:" + biaAlgInInfJClass.X0o0xo() + " ,imp:" + biaAlgInInfJClass.I0Io());
        this.f995IXxxXO = xXxxox0I.II0xO0.oIX0oI(biaAlgInInfJClass);
        StringBuilder sb = new StringBuilder();
        sb.append("execueBonso:getError1 ");
        sb.append(this.f995IXxxXO.Oo());
        Log.e("1016Calc", sb.toString());
        int Oo2 = this.f995IXxxXO.Oo();
        if (Oo2 != 0) {
            if (Oo2 != 2 && Oo2 != 3 && Oo2 != 4 && Oo2 != 5) {
                if (Oo2 == 8 || Oo2 == 9) {
                    scaleInfo = this.f983x0XOIxOo;
                    i = 4008;
                }
                return this;
            }
            scaleInfo = this.f983x0XOIxOo;
            i = 4006;
        } else {
            scaleInfo = this.f983x0XOIxOo;
        }
        scaleInfo.xx0X0(i);
        return this;
    }

    @Override // Ix0x.II0XooXoX
    public double[] XOxIOxOx() {
        return OOXIxO0(Oo());
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        return (int) this.f995IXxxXO.X0o0xo();
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.a XoI0Ixx0() {
        ScaleInfo.a aVar = ScaleInfo.a.VT_BODY_SHAPE_HIDDEN_FAT;
        switch ((int) this.f995IXxxXO.xxIXOIIO()) {
            case 1:
                return ScaleInfo.a.VT_BODY_SHAPE_SLENDER;
            case 2:
                return ScaleInfo.a.VT_BODY_SHAPE_LEAN;
            case 3:
                return ScaleInfo.a.VT_BODY_SHAPE_WELL_BUILT;
            case 4:
                return ScaleInfo.a.VT_BODY_SHAPE_SLIM;
            case 5:
                return ScaleInfo.a.VT_BODY_SHAPE_FIT;
            case 6:
                return ScaleInfo.a.VT_BODY_SHAPE_ATHLETIC;
            case 7:
            default:
                return aVar;
            case 8:
                return ScaleInfo.a.VT_BODY_SHAPE_CHUBBY;
            case 9:
                return ScaleInfo.a.VT_BODY_SHAPE_BEEFY;
        }
    }

    @Override // Ix0x.II0XooXoX
    public double[] ooOOo0oXI() {
        return this.f995IXxxXO.xII();
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        return this.f995IXxxXO.I0oOoX();
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxXx0IX() {
        return this.f995IXxxXO.Xx000oIo();
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        return this.f995IXxxXO.OxxIIOOXO();
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        return (int) this.f995IXxxXO.o0();
    }

    @Override // Ix0x.II0XooXoX
    public double[] xXOx() {
        return this.f995IXxxXO.IO();
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.c xoIxX() {
        ScaleInfo.c cVar = ScaleInfo.c.VT_OBESITY_LEVEL_NORMAL;
        int XIxXXX0x02 = (int) this.f995IXxxXO.XIxXXX0x0();
        if (XIxXXX0x02 != 4) {
            if (XIxXXX0x02 != 5) {
                if (XIxXXX0x02 != 6) {
                    if (XIxXXX0x02 == 7) {
                        return ScaleInfo.c.VT_OBESITY_LEVEL_MILD;
                    }
                    return cVar;
                }
                return ScaleInfo.c.VT_OBESITY_LEVEL_OVERWEIGHT;
            }
            return cVar;
        }
        return ScaleInfo.c.VT_OBESITY_LEVEL_LIGHT;
    }

    @Override // Ix0x.II0XooXoX
    public double[] xoXoI() {
        return this.f995IXxxXO.x0o();
    }
}
