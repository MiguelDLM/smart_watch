package Ix0x;

import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.garmin.fit.OxXXx0X;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import com.vtrump.vtble.xxX;

/* loaded from: classes13.dex */
public class II0XooXoX {

    /* renamed from: Oo, reason: collision with root package name */
    public static II0XooXoX f970Oo;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f971I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public double f973II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f974OOXIXo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public double f976X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public double f977XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public double f978oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f980oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    public double f982oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ScaleInfo f983x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f985xoIox;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f975Oxx0IOOO = false;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f972II0XooXoX = false;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f986xxIXOIIO = false;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f981ooOOo0oXI = false;

    /* renamed from: oO, reason: collision with root package name */
    public double[][] f979oO = {new double[]{10.2d, 11.1d, 14.8d, 16.3d, 18.1d}, new double[]{11.3d, 12.4d, 16.3d, 17.8d, 19.4d}, new double[]{12.5d, 13.7d, 17.8d, 19.4d, 21.1d}, new double[]{13.1d, 14.3d, 18.4d, 20.0d, 21.8d}, new double[]{13.4d, 14.5d, 18.7d, 20.3d, 22.1d}, new double[]{13.5d, 14.7d, 18.8d, 20.5d, 22.3d}, new double[]{13.6d, 14.7d, 18.8d, 20.5d, 22.3d}, new double[]{13.7d, 14.8d, 18.8d, 20.5d, 22.3d}, new double[]{13.6d, 14.7d, 18.7d, 20.4d, 22.2d}, new double[]{13.6d, 14.7d, 18.6d, 20.3d, 22.1d}, new double[]{13.5d, 14.6d, 18.5d, 20.1d, 22.0d}, new double[]{13.4d, 14.5d, 18.4d, 20.0d, 21.8d}, new double[]{13.4d, 14.4d, 18.2d, 19.8d, 21.6d}, new double[]{13.3d, 14.3d, 18.1d, 19.7d, 21.5d}, new double[]{13.2d, 14.2d, 18.0d, 19.6d, 21.3d}, new double[]{13.1d, 14.1d, 17.8d, 19.4d, 21.2d}, new double[]{13.1d, 14.0d, 17.7d, 19.3d, 21.0d}, new double[]{13.0d, 13.9d, 17.6d, 19.1d, 20.9d}, new double[]{12.9d, 13.9d, 17.5d, 19.0d, 20.8d}, new double[]{12.9d, 13.8d, 17.4d, 18.9d, 20.7d}, new double[]{12.8d, 13.7d, 17.3d, 18.8d, 20.6d}, new double[]{12.8d, 13.7d, 17.2d, 18.7d, 20.5d}, new double[]{12.7d, 13.6d, 17.2d, 18.7d, 20.4d}, new double[]{12.7d, 13.6d, 17.1d, 18.6d, 20.3d}, new double[]{12.7d, 13.6d, 17.0d, 18.5d, 20.3d}, new double[]{12.8d, 13.8d, 17.3d, 18.8d, 20.5d}, new double[]{12.8d, 13.7d, 17.3d, 18.8d, 20.5d}, new double[]{12.7d, 13.7d, 17.2d, 18.7d, 20.4d}, new double[]{12.7d, 13.6d, 17.2d, 18.7d, 20.4d}, new double[]{12.7d, 13.6d, 17.1d, 18.6d, 20.3d}, new double[]{12.6d, 13.6d, 17.1d, 18.6d, 20.2d}, new double[]{12.6d, 13.5d, 17.1d, 18.5d, 20.2d}, new double[]{12.5d, 13.5d, 17.0d, 18.5d, 20.1d}, new double[]{12.5d, 13.5d, 17.0d, 18.5d, 20.1d}, new double[]{12.5d, 13.4d, 17.0d, 18.4d, 20.0d}, new double[]{12.4d, 13.4d, 16.9d, 18.4d, 20.0d}, new double[]{12.4d, 13.4d, 16.9d, 18.4d, 20.0d}, new double[]{12.4d, 13.3d, 16.9d, 18.3d, 19.9d}, new double[]{12.3d, 13.3d, 16.8d, 18.3d, 19.9d}, new double[]{12.3d, 13.3d, 16.8d, 18.3d, 19.9d}, new double[]{12.3d, 13.2d, 16.8d, 18.2d, 19.9d}, new double[]{12.2d, 13.2d, 16.8d, 18.2d, 19.9d}, new double[]{12.2d, 13.2d, 16.8d, 18.2d, 19.8d}};

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public double[][] f984x0xO0oo = {new double[]{10.1d, 11.1d, 14.6d, 16.1d, 17.7d}, new double[]{10.8d, 12.0d, 16.0d, 17.5d, 19.1d}, new double[]{11.8d, 13.0d, 17.3d, 19.0d, 20.7d}, new double[]{12.4d, 13.6d, 17.9d, 19.7d, 21.5d}, new double[]{12.7d, 13.9d, 18.3d, 20.0d, 22.0d}, new double[]{12.9d, 14.1d, 18.4d, 20.2d, 22.2d}, new double[]{13.0d, 14.1d, 18.5d, 20.3d, 22.3d}, new double[]{13.0d, 14.2d, 18.5d, 20.3d, 22.3d}, new double[]{13.0d, 14.1d, 18.4d, 20.2d, 22.2d}, new double[]{12.9d, 14.1d, 18.3d, 20.1d, 22.1d}, new double[]{12.9d, 14.0d, 18.2d, 19.9d, 21.9d}, new double[]{12.8d, 13.9d, 18.0d, 19.8d, 21.8d}, new double[]{12.7d, 13.8d, 17.9d, 19.6d, 21.6d}, new double[]{12.6d, 13.7d, 17.7d, 19.5d, 21.4d}, new double[]{12.6d, 13.6d, 17.6d, 19.3d, 21.3d}, new double[]{12.5d, 13.5d, 17.5d, 19.2d, 21.1d}, new double[]{12.4d, 13.5d, 17.4d, 19.1d, 21.0d}, new double[]{12.4d, 13.4d, 17.3d, 18.9d, 20.9d}, new double[]{12.3d, 13.3d, 17.2d, 18.8d, 20.8d}, new double[]{12.3d, 13.3d, 17.1d, 18.8d, 20.7d}, new double[]{12.2d, 13.2d, 17.0d, 18.7d, 20.6d}, new double[]{12.2d, 13.2d, 17.0d, 18.6d, 20.5d}, new double[]{12.2d, 13.1d, 16.9d, 18.5d, 20.4d}, new double[]{12.2d, 13.1d, 16.9d, 18.5d, 20.4d}, new double[]{12.1d, 13.1d, 16.8d, 18.4d, 20.3d}, new double[]{12.4d, 13.3d, 17.1d, 18.7d, 20.6d}, new double[]{12.3d, 13.3d, 17.0d, 18.7d, 20.6d}, new double[]{12.3d, 13.3d, 17.0d, 18.6d, 20.5d}, new double[]{12.3d, 13.3d, 17.0d, 18.6d, 20.5d}, new double[]{12.3d, 13.2d, 17.0d, 18.6d, 20.4d}, new double[]{12.3d, 13.2d, 16.9d, 18.5d, 20.4d}, new double[]{12.2d, 13.2d, 16.9d, 18.5d, 20.4d}, new double[]{12.2d, 13.2d, 16.9d, 18.5d, 20.4d}, new double[]{12.2d, 13.1d, 16.9d, 18.5d, 20.3d}, new double[]{12.2d, 13.1d, 16.8d, 18.5d, 20.3d}, new double[]{12.1d, 13.1d, 16.8d, 18.4d, 20.3d}, new double[]{12.1d, 13.1d, 16.8d, 18.4d, 20.3d}, new double[]{12.1d, 13.1d, 16.8d, 18.4d, 20.3d}, new double[]{12.1d, 13.0d, 16.8d, 18.4d, 20.3d}, new double[]{12.0d, 13.0d, 16.8d, 18.4d, 20.3d}, new double[]{12.0d, 13.0d, 16.8d, 18.2d, 19.9d}, new double[]{12.0d, 13.0d, 16.8d, 18.4d, 20.4d}, new double[]{12.0d, 12.9d, 16.8d, 18.4d, 20.4d}};

    /* loaded from: classes13.dex */
    public static class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f987II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f988oIX0oI;

        public oIX0oI(int i, int i2) {
            this.f988oIX0oI = i;
            this.f987II0xO0 = i2;
        }

        public int II0xO0() {
            return this.f988oIX0oI;
        }

        public int oIX0oI() {
            return this.f987II0xO0;
        }
    }

    public static void IXxxXO() {
        f970Oo = null;
    }

    public static II0XooXoX X0IIOO(int i) {
        II0XooXoX OOXIxO02;
        Log.d("0000calc", "" + i);
        switch (i) {
            case 1000:
                OOXIxO02 = oOoXoXO.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1001:
                OOXIxO02 = Ix0x.oIX0oI.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1002:
                OOXIxO02 = X0o0xo.IIxOXoOo0();
                f970Oo = OOXIxO02;
                break;
            case 1003:
                OOXIxO02 = xxIXOIIO.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1004:
                OOXIxO02 = I0Io.IIxOXoOo0();
                f970Oo = OOXIxO02;
                break;
            case 1005:
                OOXIxO02 = IIXOooo.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1006:
                OOXIxO02 = IXxxXO.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1007:
                OOXIxO02 = oI0IIXIo.I0();
                f970Oo = OOXIxO02;
                break;
            case 1008:
                OOXIxO02 = x0xO0oo.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1009:
                OOXIxO02 = Oxx0xo.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1010:
            case 1017:
            default:
                OOXIxO02 = f970Oo;
                if (OOXIxO02 == null) {
                    OOXIxO02 = new II0XooXoX();
                    f970Oo = OOXIxO02;
                    break;
                }
                break;
            case 1011:
                OOXIxO02 = ooOOo0oXI.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1012:
                OOXIxO02 = oO.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1013:
                OOXIxO02 = II0xO0.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1014:
                OOXIxO02 = XO.IIxOXoOo0();
                f970Oo = OOXIxO02;
                break;
            case 1015:
                OOXIxO02 = oxoX.IIxOXoOo0();
                f970Oo = OOXIxO02;
                break;
            case 1016:
                OOXIxO02 = Oxx0IOOO.IIxOXoOo0();
                f970Oo = OOXIxO02;
                break;
            case 1018:
                OOXIxO02 = x0XOIxOo.OOXIxO0();
                f970Oo = OOXIxO02;
                break;
            case 1019:
                OOXIxO02 = xoIox.I0();
                f970Oo = OOXIxO02;
                break;
            case 1020:
                OOXIxO02 = OxxIIOOXO.ooOx();
                f970Oo = OOXIxO02;
                break;
        }
        return OOXIxO02;
    }

    public double I0Io() {
        return -10000.0d;
    }

    public int I0X0x0oIo() {
        return -10000;
    }

    public double I0oOIX() {
        return -10000.0d;
    }

    public II0XooXoX I0oOoX(ScaleUserInfo scaleUserInfo, double d, double d2) {
        this.f985xoIox = true;
        this.f983x0XOIxOo = new ScaleInfo();
        return this;
    }

    public double II0XooXoX() {
        return -10000.0d;
    }

    public ScaleInfo.b II0xO0() {
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

    public ScaleInfo IIX0o(ScaleUserInfo scaleUserInfo, double d, double d2, String str) {
        return xXxxox0I(scaleUserInfo, d, d2, XIXIX.OOXIXo.f3760XO, str);
    }

    public double[] IIXOooo() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        if (oOoXoXO()) {
            double d6 = this.f982oxoX;
            if (d6 < 19.0d) {
                d = this.f978oIX0oI;
                d2 = 0.09000000357627869d * d;
                d3 = 0.20000000298023224d * d;
                d4 = 0.25d;
            } else if (d6 < 41.0d) {
                d = this.f978oIX0oI;
                d2 = 0.10000000149011612d * d;
                d3 = d * 0.20999999344348907d;
                d4 = 0.25999999046325684d;
            } else {
                d = this.f978oIX0oI;
                if (d6 < 61.0d) {
                    double d7 = 0.10999999940395355d * d;
                    d3 = d * 0.2199999988079071d;
                    d5 = d * 0.27000001072883606d;
                    d2 = d7;
                    return new double[]{XIXIX.OOXIXo.f3760XO, xxX.Oo(d2, 1), xxX.Oo(d3, 1), xxX.Oo(d5, 1), xxX.Oo(d5 * 1.5d, 1)};
                }
                d2 = 0.12999999523162842d * d;
                d3 = d * 0.23000000417232513d;
                d4 = 0.28999999165534973d;
            }
        } else {
            double d8 = this.f982oxoX;
            if (d8 < 19.0d) {
                d = this.f978oIX0oI;
                d2 = 0.1899999976158142d * d;
                d3 = d * 0.33000001311302185d;
                d4 = 0.3799999952316284d;
            } else if (d8 < 41.0d) {
                d = this.f978oIX0oI;
                d2 = d * 0.20000000298023224d;
                d3 = d * 0.3400000035762787d;
                d4 = 0.38999998569488525d;
            } else {
                d = this.f978oIX0oI;
                if (d8 < 61.0d) {
                    d2 = d * 0.20999999344348907d;
                    d3 = d * 0.3499999940395355d;
                    d4 = 0.4000000059604645d;
                } else {
                    d2 = 0.2199999988079071d * d;
                    d3 = d * 0.36000001430511475d;
                    d4 = 0.4099999964237213d;
                }
            }
        }
        d5 = d * d4;
        return new double[]{XIXIX.OOXIXo.f3760XO, xxX.Oo(d2, 1), xxX.Oo(d3, 1), xxX.Oo(d5, 1), xxX.Oo(d5 * 1.5d, 1)};
    }

    public double[] IO() {
        double[] dArr = new double[5];
        int i = (int) (this.f982oxoX * 100.0d);
        if (i >= 0 && i <= 42) {
            int i2 = this.f971I0Io;
            if (i2 == 4) {
                dArr = this.f979oO[i];
            }
            if (i2 == 5) {
                dArr = this.f984x0xO0oo[i];
            }
            double[] oO2 = xxX.oO(dArr, 0, XIXIX.OOXIXo.f3760XO);
            return xxX.oO(oO2, oO2.length - 1, oO2[oO2.length - 1] * 1.5d);
        }
        dArr[0] = -10000.0d;
        dArr[1] = -10000.0d;
        dArr[2] = -10000.0d;
        dArr[3] = -10000.0d;
        dArr[4] = -10000.0d;
        return dArr;
    }

    public double[] Io() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 18.5d, 24.0d, 28.0d, 42.0d};
    }

    public double[] IoOoX(double d, double d2, double d3) {
        return new double[]{XIXIX.OOXIXo.f3760XO, xxX.Oo(d, 1), xxX.Oo(d2, 1), xxX.Oo(d3, 1), xxX.Oo(d3 * 1.5d, 1)};
    }

    public double IoOoo() {
        double d;
        if (oOoXoXO()) {
            d = 24.200000762939453d;
        } else {
            d = 20.0d;
        }
        double d2 = this.f973II0xO0;
        return ((d * d2) * d2) / 10000.0d;
    }

    public double Ioxxx() {
        return -10000.0d;
    }

    public double O00XxXI() {
        return -10000.0d;
    }

    public double O0Xx() {
        return OO();
    }

    public double[] O0xOxO() {
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f982oxoX;
        if (oOoXoXO2) {
            if (d < 19.0d) {
                double d2 = this.f978oIX0oI;
                return xII(0.21299999952316284d * d2, d2 * 0.5325000286102295d);
            }
            double d3 = this.f978oIX0oI;
            return xII(0.17749999463558197d * d3, d3 * 0.390500009059906d);
        }
        if (d < 19.0d) {
            double d4 = this.f978oIX0oI;
            return xII(0.17749999463558197d * d4, d4 * 0.46149998903274536d);
        }
        double d5 = this.f978oIX0oI;
        return xII(0.1420000046491623d * d5, d5 * 0.390500009059906d);
    }

    public II0XooXoX OI0(ScaleUserInfo scaleUserInfo, double d, double d2) {
        this.f980oOoXoXO = true;
        this.f983x0XOIxOo = new ScaleInfo();
        return this;
    }

    public double OO() {
        return -10000.0d;
    }

    public double OO0x0xX() {
        return -10000.0d;
    }

    public boolean OOXIXo() {
        if (this.f971I0Io > 1) {
            return true;
        }
        return false;
    }

    public double[] Oo() {
        double d;
        double d2;
        double d3;
        boolean oOoXoXO2 = oOoXoXO();
        double d4 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d4 < 19.0d) {
                d = 57.0d;
                d2 = 62.0d;
            } else if (d4 < 31.0d) {
                d = 56.5d;
                d2 = 61.5d;
            } else {
                if (d4 < 41.0d) {
                    return o0(56.0d, 61.0d);
                }
                if (d4 < 61.0d) {
                    d = 55.5d;
                    d2 = 60.5d;
                } else {
                    d3 = 55.0d;
                    return o0(d3, 60.0d);
                }
            }
            return o0(d, d2);
        }
        if (d4 < 19.0d) {
            d3 = 54.0d;
            return o0(d3, 60.0d);
        }
        if (d4 < 31.0d) {
            d = 53.5d;
            d2 = 59.5d;
        } else if (d4 < 41.0d) {
            d = 53.0d;
            d2 = 59.0d;
        } else if (d4 < 61.0d) {
            d = 52.5d;
            d2 = 58.5d;
        } else {
            d = 52.0d;
            d2 = 58.0d;
        }
        return o0(d, d2);
    }

    public double[] OxI() {
        double pow = Math.pow(this.f973II0xO0 / 100.0d, 2.0d) * 18.5d;
        double pow2 = Math.pow(this.f973II0xO0 / 100.0d, 2.0d) * 24.0d;
        return new double[]{XIXIX.OOXIXo.f3760XO, xxX.Oo(pow, 1), xxX.Oo(pow2, 1), xxX.Oo(pow2 * 1.5d, 1)};
    }

    public double Oxx0IOOO() {
        return -10000.0d;
    }

    public int[] Oxx0xo() {
        return new int[]{0, 60, 70, 80, 90, 100};
    }

    public double[] OxxIIOOXO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 10.0d, 15.0d, 23.0d};
    }

    public II0XooXoX X00IoxXI(ScaleUserInfo scaleUserInfo, double d, double d2) {
        this.f974OOXIXo = true;
        this.f983x0XOIxOo = new ScaleInfo();
        return this;
    }

    public double X0o0xo() {
        return (xxIO() * this.f978oIX0oI) / 100.0d;
    }

    public II0XooXoX XI0IXoo(ScaleUserInfo scaleUserInfo, double d, double d2) {
        this.f981ooOOo0oXI = true;
        this.f983x0XOIxOo = new ScaleInfo();
        return this;
    }

    public int XI0oooXX() {
        return -10000;
    }

    public oIX0oI XIo0oOXIx() {
        double d = 220.0d - this.f982oxoX;
        return new oIX0oI((int) (0.6d * d), (int) (d * 0.8d));
    }

    public II0XooXoX XIxXXX0x0(ScaleUserInfo scaleUserInfo, double d, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        this.f983x0XOIxOo = new ScaleInfo();
        this.f975Oxx0IOOO = true;
        return this;
    }

    public double XO() {
        return -10000.0d;
    }

    public double[] XOxIOxOx() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        boolean oOoXoXO2 = oOoXoXO();
        double d6 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d6 < 19.0d) {
                d = this.f978oIX0oI;
                d2 = 0.5699999928474426d * d;
                d3 = 0.6200000047683716d;
            } else if (d6 < 31.0d) {
                d = this.f978oIX0oI;
                d2 = 0.5649999976158142d * d;
                d3 = 0.6150000095367432d;
            } else if (d6 < 41.0d) {
                d = this.f978oIX0oI;
                d2 = 0.5600000023841858d * d;
                d3 = 0.6100000143051147d;
            } else if (d6 < 61.0d) {
                d = this.f978oIX0oI;
                d2 = 0.5550000071525574d * d;
                d3 = 0.6050000190734863d;
            } else {
                d4 = this.f978oIX0oI;
                d5 = 0.550000011920929d;
                return o0(d5 * d4, d4 * 0.6000000238418579d);
            }
            return o0(d2, d * d3);
        }
        if (d6 < 19.0d) {
            d4 = this.f978oIX0oI;
            d5 = 0.5400000214576721d;
            return o0(d5 * d4, d4 * 0.6000000238418579d);
        }
        if (d6 < 31.0d) {
            d = this.f978oIX0oI;
            d2 = 0.5350000262260437d * d;
            d3 = 0.5950000286102295d;
        } else if (d6 < 41.0d) {
            d = this.f978oIX0oI;
            d2 = 0.5299999713897705d * d;
            d3 = 0.5899999737739563d;
        } else if (d6 < 61.0d) {
            d = this.f978oIX0oI;
            d2 = 0.5249999761581421d * d;
            d3 = 0.5849999785423279d;
        } else {
            d = this.f978oIX0oI;
            d2 = 0.5199999809265137d * d;
            d3 = 0.5799999833106995d;
        }
        return o0(d2, d * d3);
    }

    public final void XX() {
        this.f983x0XOIxOo.XOxxooXI(Xx000oIo());
        if (XoX()) {
            this.f983x0XOIxOo.I0oOoX(IO());
            this.f983x0XOIxOo.X0xxXX0(XX0());
            return;
        }
        this.f983x0XOIxOo.I0oOoX(Io());
        this.f983x0XOIxOo.X0xxXX0(OxI());
        this.f983x0XOIxOo.xXOx(oxxXoxO());
        this.f983x0XOIxOo.o0xxxXXxX(ooOOo0oXI());
        this.f983x0XOIxOo.OIOoIIOIx(IIXOooo());
        this.f983x0XOIxOo.xI0oxI00(Oo());
        this.f983x0XOIxOo.x0OxxIOxX(XOxIOxOx());
        this.f983x0XOIxOo.OOXIxO0(x0XOIxOo());
        this.f983x0XOIxOo.IxIX0I(xoXoI());
        this.f983x0XOIxOo.OX00O0xII(oO());
        this.f983x0XOIxOo.oI(o00());
        this.f983x0XOIxOo.o0oIxOo(xXOx());
        this.f983x0XOIxOo.Ioxxx(OxxIIOOXO());
        this.f983x0XOIxOo.xOoOIoI(oI0IIXIo());
        this.f983x0XOIxOo.XIXIX(x0xO0oo());
        this.f983x0XOIxOo.IoXIXo(O0xOxO());
        this.f983x0XOIxOo.Xo0(oxXx0IX());
        this.f983x0XOIxOo.OO(xoIox());
        this.f983x0XOIxOo.x0o(oo0xXOI0I());
        this.f983x0XOIxOo.XOxIOxOx(Oxx0xo());
    }

    public final double[] XX0() {
        double[] IO2 = IO();
        double[] dArr = new double[IO2.length];
        int i = (int) (this.f982oxoX * 100.0d);
        if (i >= 0 && i <= 42) {
            for (int i2 = 0; i2 < IO2.length; i2++) {
                double d = IO2[i2];
                double d2 = this.f973II0xO0;
                dArr[i2] = ((d * d2) * d2) / 10000.0d;
            }
        } else {
            dArr[0] = -10000.0d;
            dArr[1] = -10000.0d;
            dArr[2] = -10000.0d;
            dArr[3] = -10000.0d;
            dArr[4] = -10000.0d;
        }
        return dArr;
    }

    public double XX0xXo() {
        return -10000.0d;
    }

    public int Xo0() {
        return -10000;
    }

    public ScaleInfo.a XoI0Ixx0() {
        return ScaleInfo.a.VT_BODY_SHAPE_INVALID;
    }

    public final boolean XoX() {
        int i = this.f971I0Io;
        if (i == 4 || i == 5) {
            double d = this.f982oxoX;
            if (d >= XIXIX.OOXIXo.f3760XO && d < 1.0d) {
                return true;
            }
            return false;
        }
        return false;
    }

    public double[] Xx000oIo() {
        double pow = Math.pow(this.f973II0xO0 / 100.0d, 2.0d) * 18.5d;
        double pow2 = Math.pow(this.f973II0xO0 / 100.0d, 2.0d) * 25.0d;
        return new double[]{XIXIX.OOXIXo.f3760XO, xxX.Oo(pow, 1), xxX.Oo(pow2, 1), xxX.Oo(pow2 * 1.5d, 1)};
    }

    public ScaleInfo XxX0x0xxx(ScaleUserInfo scaleUserInfo, double d) {
        this.f973II0xO0 = scaleUserInfo.oxoX();
        this.f982oxoX = scaleUserInfo.II0xO0();
        this.f971I0Io = scaleUserInfo.I0Io();
        this.f978oIX0oI = d;
        ScaleInfo scaleInfo = new ScaleInfo();
        scaleInfo.IoOoX();
        scaleInfo.I0Io(d);
        scaleInfo.oxXx0IX(oX());
        scaleInfo.X0xxXX0(OxI());
        scaleInfo.I0oOoX(Io());
        scaleInfo.X00IoxXI(XIo0oOXIx());
        scaleInfo.xoO0xx0(xoIxX().i);
        scaleInfo.xxIO(IoOoo());
        scaleInfo.IIX0(II0xO0().j);
        return scaleInfo;
    }

    public double[] o0(double d, double d2) {
        return new double[]{XIXIX.OOXIXo.f3760XO, xxX.Oo(d, 1), xxX.Oo(d2, 1), xxX.Oo(d2 * 1.5d, 1)};
    }

    public double[] o00() {
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f982oxoX;
        if (oOoXoXO2) {
            if (d < 19.0d) {
                double d2 = this.f978oIX0oI;
                return xII(0.10750000178813934d * d2, d2 * 0.46875d);
            }
            double d3 = this.f978oIX0oI;
            return xII(0.15625d * d3, d3 * 0.34375d);
        }
        if (d < 19.0d) {
            double d4 = this.f978oIX0oI;
            return xII(0.15625d * d4, d4 * 0.40625d);
        }
        double d5 = this.f978oIX0oI;
        return xII(0.125d * d5, d5 * 0.34375d);
    }

    public double o0xxxXXxX() {
        return -10000.0d;
    }

    public double[] oI0IIXIo() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 10.0d, 15.0d, 22.5d};
    }

    public ScaleInfo.b oIX0oI() {
        return ScaleInfo.b.VT_NUTRITRUE_STATE_INVALID;
    }

    public double[] oO() {
        boolean oOoXoXO2 = oOoXoXO();
        double d = 15.625d;
        double d2 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d2 < 19.0d) {
                return xII(10.75d, 46.875d);
            }
        } else {
            if (d2 < 19.0d) {
                return xII(15.625d, 40.625d);
            }
            d = 12.5d;
        }
        return xII(d, 34.375d);
    }

    public double[] oOXoIIIo(double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = (dArr[i] * this.f978oIX0oI) / 100.0d;
        }
        return dArr2;
    }

    public boolean oOoXoXO() {
        int i = this.f971I0Io;
        if (i != 0 && i != 2) {
            return false;
        }
        return true;
    }

    public double oX() {
        com.vtrump.vtble.Oxx0xo.II0xO0("0000Calc", "calcBmi: Height " + this.f973II0xO0);
        double d = this.f973II0xO0;
        if (d <= XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return (this.f978oIX0oI * 10000.0d) / (d * d);
    }

    public double[] oo(double d, double d2) {
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, xxX.Oo(1.5d * d2, 1)};
    }

    public double[] oo0xXOI0I() {
        double d = this.f982oxoX;
        return new double[]{XIXIX.OOXIXo.f3760XO, d, 1.5d * d};
    }

    public double[] ooOOo0oXI() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = 22.0d;
        double d3 = 41.0d;
        double d4 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d4 < 19.0d) {
                d2 = 9.0d;
                d3 = 25.0d;
                d = 20.0d;
            } else if (d4 < 41.0d) {
                d2 = 10.0d;
                d3 = 26.0d;
                d = 21.0d;
            } else if (d4 < 61.0d) {
                d3 = 27.0d;
                d2 = 11.0d;
                d = 22.0d;
            } else {
                d2 = 13.0d;
                d = 24.0d;
                d3 = 29.0d;
            }
        } else if (d4 < 19.0d) {
            d3 = 38.0d;
            d = 33.0d;
            d2 = 19.0d;
        } else if (d4 < 41.0d) {
            d3 = 39.0d;
            d = 34.0d;
            d2 = 20.0d;
        } else if (d4 < 61.0d) {
            d3 = 40.0d;
            d = 35.0d;
            d2 = 21.0d;
        } else {
            d = 36.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, d, d3, 1.5d * d3};
    }

    public final void ooXIXxIX(String str) {
        com.vtrump.vtble.Oxx0xo.oIX0oI("0000Calc", "makeOtherDataInvalid: ");
        if (str.equals("baby")) {
            this.f983x0XOIxOo.IIX0(-10000);
        } else {
            str.equals(MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        }
        this.f983x0XOIxOo.XXoOx0(-10000.0d);
        this.f983x0XOIxOo.Oxx0IOOO(-10000.0d);
        this.f983x0XOIxOo.X0xII0I(-10000.0d);
        this.f983x0XOIxOo.x0xO0oo(-10000.0d);
        this.f983x0XOIxOo.XO(-10000.0d);
        this.f983x0XOIxOo.IXO(-10000.0d);
        this.f983x0XOIxOo.xxIXOIIO(-10000.0d);
        this.f983x0XOIxOo.oOoXoXO(-10000.0d);
        this.f983x0XOIxOo.O0IxXx(-10000.0d);
        this.f983x0XOIxOo.XX(-10000);
        this.f983x0XOIxOo.Xx000oIo(-10000);
        this.f983x0XOIxOo.XI0oooXX(-10000);
        this.f983x0XOIxOo.xXoOI00O(-10000.0d);
        this.f983x0XOIxOo.I0X0x0oIo(-10000.0d);
        this.f983x0XOIxOo.I0oOIX(-10000.0d);
        this.f983x0XOIxOo.oXxOI0oIx(-10000.0d);
        this.f983x0XOIxOo.ooOOo0oXI(-10000.0d);
        this.f983x0XOIxOo.Oo(-10000.0d);
        this.f983x0XOIxOo.OO0x0xX(-10000.0d);
        this.f983x0XOIxOo.OoO(-10000.0d);
        this.f983x0XOIxOo.xo0x(-10000);
        this.f983x0XOIxOo.xxIO(-10000.0d);
        this.f983x0XOIxOo.xOOOX(-10000);
    }

    public double ox() {
        return -10000.0d;
    }

    public double[] oxXx0IX() {
        int i;
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f982oxoX;
        if (oOoXoXO2) {
            if (d < 19.0d) {
                i = 1620;
            } else if (d < 30.0d) {
                i = 1560;
            } else if (d < 50.0d) {
                i = OxXXx0X.f13124Xo0;
            } else if (d < 70.0d) {
                i = 1501;
            } else {
                i = 1398;
            }
        } else if (d < 19.0d) {
            i = 1265;
        } else if (d < 30.0d) {
            i = 1298;
        } else if (d < 50.0d) {
            i = 1302;
        } else if (d < 70.0d) {
            i = 1242;
        } else {
            i = 1035;
        }
        double d2 = i;
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, 1.5d * d2};
    }

    public double oxoX() {
        return (Ioxxx() * this.f978oIX0oI) / 100.0d;
    }

    public double[] oxxXoxO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 18.5d, 25.0d, 30.0d, 45.0d};
    }

    public double[] x0XOIxOo() {
        boolean oOoXoXO2 = oOoXoXO();
        double d = 25.0d;
        double d2 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d2 < 19.0d) {
                return xII(30.0d, 75.0d);
            }
        } else {
            if (d2 < 19.0d) {
                return xII(25.0d, 65.0d);
            }
            d = 20.0d;
        }
        return xII(d, 55.0d);
    }

    public double[] x0o(double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = (dArr[i] * 100.0d) / this.f978oIX0oI;
        }
        return dArr2;
    }

    public int x0xO() {
        return -10000;
    }

    public double[] x0xO0oo() {
        if (oOoXoXO()) {
            return new double[]{XIXIX.OOXIXo.f3760XO, 49.0d, 59.0d, 88.5d};
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, 40.0d, 50.0d, 75.0d};
    }

    public final boolean xI(double d) {
        if (d <= 60.0d && d >= 10.0d) {
            return false;
        }
        return true;
    }

    public double[] xII(double d, double d2) {
        return new double[]{XIXIX.OOXIXo.f3760XO, xxX.Oo(d, 1), xxX.Oo(d2, 1), xxX.Oo(d2 * 1.5d, 1)};
    }

    public double[] xXOx() {
        double d;
        double d2;
        double d3;
        double d4;
        boolean oOoXoXO2 = oOoXoXO();
        double d5 = this.f978oIX0oI;
        if (oOoXoXO2) {
            if (d5 < 60.0d) {
                d4 = 4.5d;
                return oo(0.5d, d4);
            }
            if (d5 < 75.0d) {
                d = 6.0d;
                return oo(2.0d, d);
            }
            d2 = 2.5d;
            d3 = 7.5d;
            return oo(d2, d3);
        }
        if (d5 < 45.0d) {
            d4 = 3.0d;
            return oo(0.5d, d4);
        }
        if (d5 < 60.0d) {
            d2 = 1.7999999523162842d;
            d3 = 4.199999809265137d;
            return oo(d2, d3);
        }
        d = 6.5d;
        return oo(2.0d, d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0109, code lost:
    
        if (r11 <= 42.0d) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.vtrump.vtble.Scale.ScaleInfo xXxxox0I(com.vtrump.vtble.Scale.ScaleUserInfo r19, double r20, double r22, double r24, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.II0XooXoX.xXxxox0I(com.vtrump.vtble.Scale.ScaleUserInfo, double, double, double, java.lang.String):com.vtrump.vtble.Scale.ScaleInfo");
    }

    public final boolean xo0x() {
        if (this.f971I0Io < 4) {
            double d = this.f982oxoX;
            if (d > 0.42d && d <= 10.0d) {
                return true;
            }
            return false;
        }
        return false;
    }

    public double[] xoIox() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        II0XooXoX iI0XooXoX;
        double d7;
        double d8;
        double d9;
        double d10;
        if (oOoXoXO()) {
            double d11 = this.f982oxoX;
            if (d11 < 19.0d) {
                double d12 = this.f978oIX0oI;
                d2 = 0.8799999952316284d * d12;
                d3 = d12 * 0.8299999833106995d;
                d6 = d12 * 0.7799999713897705d;
            } else {
                if (d11 < 31.0d) {
                    d9 = this.f978oIX0oI;
                    d2 = 0.8759999871253967d * d9;
                    d10 = 0.8199999928474426d;
                } else if (d11 < 41.0d) {
                    d9 = this.f978oIX0oI;
                    d2 = 0.8700000047683716d * d9;
                    d10 = 0.8159999847412109d;
                } else {
                    if (d11 < 61.0d) {
                        double d13 = this.f978oIX0oI;
                        double d14 = 0.8659999966621399d * d13;
                        double d15 = 0.8100000023841858d * d13;
                        double d16 = d13 * 0.7660000324249268d;
                        iI0XooXoX = this;
                        d7 = d14;
                        d5 = d15;
                        d8 = d16;
                        return iI0XooXoX.IoOoX(d7, d5, d8);
                    }
                    d = this.f978oIX0oI;
                    d2 = 0.8600000143051147d * d;
                    d3 = 0.8059999942779541d * d;
                    d4 = 0.7599999904632568d;
                }
                d3 = d10 * d9;
                d6 = d9 * 0.7699999809265137d;
            }
            iI0XooXoX = this;
            d7 = d2;
            d5 = d3;
            d8 = d6;
            return iI0XooXoX.IoOoX(d7, d5, d8);
        }
        double d17 = this.f982oxoX;
        if (d17 < 19.0d) {
            d = this.f978oIX0oI;
            d2 = 0.8500000238418579d * d;
            d3 = d * 0.7799999713897705d;
            d4 = 0.7360000014305115d;
        } else if (d17 < 31.0d) {
            d = this.f978oIX0oI;
            d2 = 0.8460000157356262d * d;
            d3 = d * 0.7699999809265137d;
            d4 = 0.7300000190734863d;
        } else {
            if (d17 < 41.0d) {
                double d18 = this.f978oIX0oI;
                double d19 = 0.8400000333786011d * d18;
                d5 = 0.7660000324249268d * d18;
                d6 = 0.7260000109672546d * d18;
                iI0XooXoX = this;
                d7 = d19;
                d8 = d6;
                return iI0XooXoX.IoOoX(d7, d5, d8);
            }
            d = this.f978oIX0oI;
            if (d17 < 61.0d) {
                d2 = 0.8359999656677246d * d;
                d3 = 0.7599999904632568d * d;
                d4 = 0.7200000286102295d;
            } else {
                d2 = d * 0.8299999833106995d;
                d3 = 0.7559999823570251d * d;
                d4 = 0.715999960899353d;
            }
        }
        d6 = d4 * d;
        iI0XooXoX = this;
        d7 = d2;
        d5 = d3;
        d8 = d6;
        return iI0XooXoX.IoOoX(d7, d5, d8);
    }

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

    public double[] xoXoI() {
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f982oxoX;
        if (oOoXoXO2) {
            if (d < 19.0d) {
                double d2 = this.f978oIX0oI;
                return xII(0.30000001192092896d * d2, d2 * 0.75d);
            }
            double d3 = this.f978oIX0oI;
            return xII(0.25d * d3, d3 * 0.550000011920929d);
        }
        if (d < 19.0d) {
            double d4 = this.f978oIX0oI;
            return xII(0.25d * d4, d4 * 0.6499999761581421d);
        }
        double d5 = this.f978oIX0oI;
        return xII(0.20000000298023224d * d5, d5 * 0.550000011920929d);
    }

    public double xoxXI() {
        return -10000.0d;
    }

    public double xxIO() {
        return -10000.0d;
    }

    public double xxIXOIIO() {
        return -10000.0d;
    }

    public II0XooXoX xxX(ScaleUserInfo scaleUserInfo, byte[] bArr) {
        this.f983x0XOIxOo = new ScaleInfo();
        this.f972II0XooXoX = true;
        return this;
    }
}
