package Ix0x;

import Ix0x.II0XooXoX;
import com.app.sicbiaalg.SicBiaAlgInInfJClass;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;

/* loaded from: classes13.dex */
public class x0XOIxOo extends II0XooXoX {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static x0XOIxOo f1016OxxIIOOXO = null;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f1017oI0IIXIo = "n";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public xXxxox0I.oxoX f1018IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public xXxxox0I.oxoX f1019Oxx0xo;

    public static x0XOIxOo OOXIxO0() {
        x0XOIxOo x0xoixoo = f1016OxxIIOOXO;
        if (x0xoixoo == null) {
            x0XOIxOo x0xoixoo2 = new x0XOIxOo();
            f1016OxxIIOOXO = x0xoixoo2;
            return x0xoixoo2;
        }
        return x0xoixoo;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        return this.f1018IXxxXO.I0Io();
    }

    @Override // Ix0x.II0XooXoX
    public int I0X0x0oIo() {
        return (int) this.f1018IXxxXO.xxX();
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        return this.f1018IXxxXO.IXxxXO();
    }

    @Override // Ix0x.II0XooXoX
    public II0XooXoX I0oOoX(ScaleUserInfo scaleUserInfo, double d, double d2) {
        ScaleInfo scaleInfo;
        int i;
        super.I0oOoX(scaleUserInfo, d, d2);
        if (scaleUserInfo.XO()) {
            return this;
        }
        scaleUserInfo.oIX0oI();
        SicBiaAlgInInfJClass sicBiaAlgInInfJClass = new SicBiaAlgInInfJClass();
        sicBiaAlgInInfJClass.ooOOo0oXI((byte) scaleUserInfo.I0Io());
        sicBiaAlgInInfJClass.II0XooXoX((short) (scaleUserInfo.II0xO0() * 10.0d));
        sicBiaAlgInInfJClass.xoIox((short) (scaleUserInfo.oxoX() * 10));
        sicBiaAlgInInfJClass.x0XOIxOo((short) (d * 100.0d));
        sicBiaAlgInInfJClass.OOXIXo((int) d2);
        sicBiaAlgInInfJClass.oOoXoXO((byte) 0);
        sicBiaAlgInInfJClass.oOoXoXO((byte) 1);
        String str = f1017oI0IIXIo;
        com.vtrump.vtble.Oxx0xo.oIX0oI(str, "execueTJHW: rucan:age:" + ((int) sicBiaAlgInInfJClass.oIX0oI()) + " ,height:" + ((int) sicBiaAlgInInfJClass.I0Io()) + " ,sex:" + ((int) sicBiaAlgInInfJClass.XO()) + " ,weight:" + ((int) sicBiaAlgInInfJClass.Oxx0IOOO()) + " ,imp:" + sicBiaAlgInInfJClass.oxoX() + " ,location:" + ((int) sicBiaAlgInInfJClass.X0o0xo()));
        StringBuilder sb = new StringBuilder();
        sb.append("execueXH_X:rucan，，rvalue ");
        sb.append(d2);
        com.vtrump.vtble.Oxx0xo.oIX0oI(str, sb.toString());
        this.f1018IXxxXO = xXxxox0I.X0o0xo.II0xO0(sicBiaAlgInInfJClass);
        this.f1019Oxx0xo = xXxxox0I.X0o0xo.II0xO0(sicBiaAlgInInfJClass);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("execueHW:getError ");
        sb2.append(this.f1018IXxxXO.x0xO0oo());
        com.vtrump.vtble.Oxx0xo.II0xO0(str, sb2.toString());
        int x0xO0oo2 = this.f1018IXxxXO.x0xO0oo();
        if (x0xO0oo2 != 0) {
            if (x0xO0oo2 != 2 && x0xO0oo2 != 3 && x0xO0oo2 != 4 && x0xO0oo2 != 5) {
                switch (x0xO0oo2) {
                    case 8:
                    case 9:
                        scaleInfo = this.f983x0XOIxOo;
                        i = 4008;
                        break;
                    case 10:
                        scaleInfo = this.f983x0XOIxOo;
                        i = 4007;
                        break;
                }
            } else {
                scaleInfo = this.f983x0XOIxOo;
                i = 4006;
            }
            scaleInfo.xx0X0(i);
        } else {
            this.f983x0XOIxOo.xx0X0(0);
        }
        return this;
    }

    @Override // Ix0x.II0XooXoX
    public double[] Io() {
        return this.f1018IXxxXO.OOXIXo();
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        return this.f1018IXxxXO.oIX0oI();
    }

    @Override // Ix0x.II0XooXoX
    public double O0Xx() {
        return this.f1018IXxxXO.XxX0x0xxx();
    }

    @Override // Ix0x.II0XooXoX
    public double[] O0xOxO() {
        return this.f1018IXxxXO.oo0xXOI0I();
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        return O0Xx();
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        return this.f1018IXxxXO.XIxXXX0x0();
    }

    @Override // Ix0x.II0XooXoX
    public double[] Oo() {
        return this.f1018IXxxXO.oO();
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxI() {
        return this.f1018IXxxXO.xxIXOIIO();
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return this.f1018IXxxXO.ooXIXxIX();
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxxIIOOXO() {
        return this.f1018IXxxXO.IoOoX();
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        return this.f1018IXxxXO.IIX0o();
    }

    @Override // Ix0x.II0XooXoX
    public int XI0oooXX() {
        return (int) this.f1018IXxxXO.xXxxox0I();
    }

    @Override // Ix0x.II0XooXoX
    public II0XooXoX.oIX0oI XIo0oOXIx() {
        return new II0XooXoX.oIX0oI(-10000, -10000);
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return this.f1018IXxxXO.XO();
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        return (int) this.f1018IXxxXO.X0o0xo();
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.a XoI0Ixx0() {
        ScaleInfo.a aVar = ScaleInfo.a.VT_BODY_SHAPE_HIDDEN_FAT;
        switch (this.f1018IXxxXO.ooOOo0oXI()) {
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
    public double[] Xx000oIo() {
        return this.f1019Oxx0xo.xxIXOIIO();
    }

    @Override // Ix0x.II0XooXoX
    public double[] oO() {
        return this.f1018IXxxXO.x0XOIxOo();
    }

    @Override // Ix0x.II0XooXoX
    public double oX() {
        return this.f1018IXxxXO.oxoX();
    }

    @Override // Ix0x.II0XooXoX
    public double[] ooOOo0oXI() {
        return this.f1018IXxxXO.II0XooXoX();
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        return this.f1018IXxxXO.Oxx0IOOO();
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxXx0IX() {
        return this.f1018IXxxXO.oOoXoXO();
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        return -10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxxXoxO() {
        return this.f1019Oxx0xo.OOXIXo();
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        return (int) this.f1018IXxxXO.oo();
    }

    @Override // Ix0x.II0XooXoX
    public double[] xXOx() {
        return this.f1018IXxxXO.xoIox();
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.c xoIxX() {
        ScaleInfo.c cVar = ScaleInfo.c.VT_OBESITY_LEVEL_NORMAL;
        switch (this.f1018IXxxXO.XI0IXoo()) {
            case 3:
            case 4:
                return ScaleInfo.c.VT_OBESITY_LEVEL_LIGHT;
            case 5:
            default:
                return cVar;
            case 6:
                return ScaleInfo.c.VT_OBESITY_LEVEL_OVERWEIGHT;
            case 7:
                return ScaleInfo.c.VT_OBESITY_LEVEL_MILD;
            case 8:
                return ScaleInfo.c.VT_OBESITY_LEVEL_MODERATE;
            case 9:
                return ScaleInfo.c.VT_OBESITY_LEVEL_SEVERE;
        }
    }

    @Override // Ix0x.II0XooXoX
    public double[] xoXoI() {
        return this.f1018IXxxXO.xI();
    }

    @Override // Ix0x.II0XooXoX
    public double xoxXI() {
        return this.f1018IXxxXO.Oo();
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        return this.f1018IXxxXO.oOXoIIIo();
    }
}
