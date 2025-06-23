package Ix0x;

import com.holtek.libHTBodyfat.HTBodyResultAllBody;
import com.holtek.libHTBodyfat.HTBodyResultTwoLegs;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import com.vtrump.vtble.xxX;

/* loaded from: classes13.dex */
public class I0Io extends II0XooXoX {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static I0Io f965IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public HTBodyResultAllBody f966IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public HTBodyResultTwoLegs f967Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f968OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f969oI0IIXIo = false;

    public static I0Io IIxOXoOo0() {
        I0Io i0Io = f965IIXOooo;
        if (i0Io == null) {
            I0Io i0Io2 = new I0Io();
            f965IIXOooo = i0Io2;
            return i0Io2;
        }
        return i0Io;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2781X0o0xo;
    }

    @Override // Ix0x.II0XooXoX
    public int I0X0x0oIo() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2787oO;
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        return (this.f978oIX0oI * (100.0d - Ioxxx())) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return (this.f978oIX0oI * ox()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        double d = iI0xO0.f2777Oxx0IOOO;
        if (d <= XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d;
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        return (1.0f - (x0xO() * 0.0267f)) * Ioxxx();
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2792x0xO0oo;
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d3 < 18.0d) {
                d = this.f978oIX0oI;
                d2 = 0.30000001192092896d;
            }
            d = this.f978oIX0oI;
            d2 = 0.25d;
        } else {
            if (d3 >= 18.0d) {
                d = this.f978oIX0oI;
                d2 = 0.20000000298023224d;
            }
            d = this.f978oIX0oI;
            d2 = 0.25d;
        }
        double d4 = d * d2;
        if (X0o0xo() < d4) {
            return X0o0xo() - d4;
        }
        return XIXIX.OOXIXo.f3760XO;
    }

    @Override // Ix0x.II0XooXoX
    /* renamed from: OOXIxO0, reason: merged with bridge method [inline-methods] */
    public I0Io XIxXXX0x0(ScaleUserInfo scaleUserInfo, double d, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        int oIX0oI2;
        ScaleInfo scaleInfo;
        com.vtrump.vtble.Oxx0xo.oIX0oI("1004Calc", "execue1004:BaseCalc ");
        super.XIxXXX0x0(scaleUserInfo, d, i, i2, i3, i4, i5, i6, z);
        this.f969oI0IIXIo = z;
        OIoxIx.oxoX.oxoX().II0xO0(new byte[15]);
        int i7 = 4006;
        if (scaleUserInfo == null) {
            this.f983x0XOIxOo.xx0X0(4006);
            return this;
        }
        Ox0O.oIX0oI oix0oi = xxX.xxIXOIIO(scaleUserInfo) ? new Ox0O.oIX0oI(0, 170, d, 20) : new Ox0O.oIX0oI((scaleUserInfo.I0Io() + 1) % 2, scaleUserInfo.oxoX(), d, (int) scaleUserInfo.II0xO0());
        if (z) {
            oix0oi.f2801XO = i;
            oix0oi.f2799Oxx0IOOO = i3;
            oix0oi.f2797II0XooXoX = i4;
            oix0oi.f2805xxIXOIIO = i5;
            oix0oi.f2804xoIox = i6;
            HTBodyResultAllBody hTBodyResultAllBody = new HTBodyResultAllBody();
            this.f966IXxxXO = hTBodyResultAllBody;
            oIX0oI2 = hTBodyResultAllBody.oIX0oI(oix0oi);
            com.vtrump.vtble.Oxx0xo.oIX0oI("1004Calc", "execue1004:888 " + oIX0oI2);
            if (oIX0oI2 == 0) {
                this.f983x0XOIxOo.O0X(this.f966IXxxXO.f17132xxX);
                this.f983x0XOIxOo.O0(this.f966IXxxXO.f17119Xx000oIo);
                this.f983x0XOIxOo.oxIIX0o(this.f966IXxxXO.f17129xI);
                this.f983x0XOIxOo.OX(this.f966IXxxXO.f17120XxX0x0xxx);
                this.f983x0XOIxOo.oXIoO(this.f966IXxxXO.f17114X00IoxXI);
                this.f983x0XOIxOo.XoIxOXIXo(this.f966IXxxXO.f17124oo0xXOI0I);
                this.f983x0XOIxOo.ox(this.f966IXxxXO.f17131xXxxox0I);
                this.f983x0XOIxOo.ooOx(this.f966IXxxXO.f17110IO);
                this.f983x0XOIxOo.xX0IIXIx0(this.f966IXxxXO.f17123oo);
                this.f983x0XOIxOo.XI(this.f966IXxxXO.f17109IIX0o);
                this.f983x0XOIxOo.oXX0IoI(this.f966IXxxXO.f17130xII);
                this.f983x0XOIxOo.I0xX0(this.f966IXxxXO.f17112IoOoX);
                this.f983x0XOIxOo.o0(this.f966IXxxXO.f17115XIxXXX0x0);
            }
        } else {
            HTBodyResultTwoLegs hTBodyResultTwoLegs = new HTBodyResultTwoLegs();
            this.f967Oxx0xo = hTBodyResultTwoLegs;
            oix0oi.f2800X0o0xo = i2;
            oIX0oI2 = hTBodyResultTwoLegs.oIX0oI(oix0oi);
            com.vtrump.vtble.Oxx0xo.oIX0oI("1004Calc", "execue1004:666 " + oIX0oI2);
            this.f983x0XOIxOo.II0xO0(this.f967Oxx0xo.f17133XIxXXX0x0);
            this.f983x0XOIxOo.O0X(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.O0(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.oxIIX0o(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.OX(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.oXIoO(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.XoIxOXIXo(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.ox(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.ooOx(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.xX0IIXIx0(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.XI(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.oXX0IoI(XIXIX.OOXIXo.f3760XO);
            this.f983x0XOIxOo.I0xX0(XIXIX.OOXIXo.f3760XO);
        }
        if (oIX0oI2 == 0) {
            scaleInfo = this.f983x0XOIxOo;
            i7 = 0;
        } else {
            if (oIX0oI2 != 1 && oIX0oI2 != 4 && oIX0oI2 != 8) {
                if (oIX0oI2 == 16 || oIX0oI2 == 32 || oIX0oI2 == 64 || oIX0oI2 == 128 || oIX0oI2 == 256) {
                    scaleInfo = this.f983x0XOIxOo;
                    i7 = 4008;
                }
                return this;
            }
            scaleInfo = this.f983x0XOIxOo;
        }
        scaleInfo.xx0X0(i7);
        return this;
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return X0o0xo() * 0.6800000071525574d;
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2793xoIox;
    }

    @Override // Ix0x.II0XooXoX
    public int XI0oooXX() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2772IXxxXO;
    }

    @Override // Ix0x.II0XooXoX
    public double XO() {
        return -10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2795xxIXOIIO;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2768I0Io;
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.a XoI0Ixx0() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        int i = iI0xO0.f2775Oo;
        this.f968OxxIIOOXO = i;
        switch (i) {
            case 0:
                return ScaleInfo.a.VT_BODY_SHAPE_SLENDER;
            case 1:
                return ScaleInfo.a.VT_BODY_SHAPE_LEAN;
            case 2:
                return ScaleInfo.a.VT_BODY_SHAPE_WELL_BUILT;
            case 3:
                return ScaleInfo.a.VT_BODY_SHAPE_SLIM;
            case 4:
                return ScaleInfo.a.VT_BODY_SHAPE_FIT;
            case 5:
                return ScaleInfo.a.VT_BODY_SHAPE_ATHLETIC;
            case 6:
                return ScaleInfo.a.VT_BODY_SHAPE_HIDDEN_FAT;
            case 7:
                return ScaleInfo.a.VT_BODY_SHAPE_CHUBBY;
            case 8:
                return ScaleInfo.a.VT_BODY_SHAPE_BEEFY;
            default:
                return ScaleInfo.a.VT_BODY_SHAPE_ERROR;
        }
    }

    @Override // Ix0x.II0XooXoX
    public double o0xxxXXxX() {
        return xxIO() * 0.6800000071525574d;
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.b oIX0oI() {
        double oX2 = oX();
        if (oX2 <= 16.0d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_SEVERELY_MALNUTRITION;
        }
        if (oX2 <= 17.5d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_MODERATE_MALNUTRITION;
        }
        if (oX2 <= 18.5d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_MALNUTRITION;
        }
        if (oX2 <= 24.0d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_NORMAL;
        }
        if (oX2 <= 28.0d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_OVERNUTRITION;
        }
        return ScaleInfo.b.VT_NUTRITRUE_STATE_SEVERLY_OVERNUTRITION;
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2769II0XooXoX;
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2783XO;
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        int i = iI0xO0.f2790oxoX;
        if (i < 1) {
            return 1;
        }
        return i;
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo xXxxox0I(ScaleUserInfo scaleUserInfo, double d, double d2, double d3, String str) {
        return super.xXxxox0I(scaleUserInfo, d, d2, d3, str);
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.c xoIxX() {
        double OO2 = ((this.f978oIX0oI - OO()) / OO()) * 100.0d;
        if (OO2 < -15.0d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_LIGHT;
        }
        if (OO2 <= 15.0d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_NORMAL;
        }
        if (OO2 <= 32.0d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_OVERWEIGHT;
        }
        if (OO2 <= 52.0d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_MILD;
        }
        if (OO2 <= 74.0d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_MODERATE;
        }
        if (OO2 > 74.0d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_SEVERE;
        }
        return ScaleInfo.c.VT_OBESITY_LEVEL_INVALID;
    }

    @Override // Ix0x.II0XooXoX
    public double xoxXI() {
        boolean oOoXoXO2 = oOoXoXO();
        double d = 17.0d;
        double d2 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d2 < 10.0d || d2 > 17.0d) {
                if (d2 <= 30.0d) {
                    d = 18.0d;
                } else if (d2 <= 40.0d) {
                    d = 18.399999618530273d;
                } else if (d2 <= 60.0d) {
                    d = 19.0d;
                } else {
                    d = 19.399999618530273d;
                }
            }
        } else if (d2 >= 10.0d && d2 <= 17.0d) {
            d = 22.0d;
        } else if (d2 <= 30.0d) {
            d = 23.0d;
        } else if (d2 <= 40.0d) {
            d = 23.399999618530273d;
        } else if (d2 <= 60.0d) {
            d = 24.0d;
        } else {
            d = 24.399999618530273d;
        }
        double oxoX2 = oxoX() - ((d * this.f978oIX0oI) / 100.0d);
        if (oxoX2 < XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return oxoX2;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIO() {
        Ox0O.II0xO0 iI0xO0;
        if (this.f969oI0IIXIo) {
            iI0xO0 = this.f966IXxxXO;
        } else {
            iI0xO0 = this.f967Oxx0xo;
        }
        return iI0xO0.f2774OOXIXo;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        return this.f978oIX0oI - OO();
    }
}
