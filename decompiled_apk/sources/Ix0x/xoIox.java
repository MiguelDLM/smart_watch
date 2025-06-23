package Ix0x;

import com.qq.e.comm.constants.ErrorCode;
import com.senhe.fat.BodyResult;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;

/* loaded from: classes13.dex */
public class xoIox extends II0XooXoX {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static xoIox f1021Oxx0xo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public BodyResult f1022IXxxXO;

    public static xoIox I0() {
        xoIox xoiox = f1021Oxx0xo;
        if (xoiox == null) {
            xoIox xoiox2 = new xoIox();
            f1021Oxx0xo = xoiox2;
            return xoiox2;
        }
        return xoiox;
    }

    private double[] IIxOXoOo0(double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = (dArr[i] * this.f978oIX0oI) / 100.0d;
        }
        return dArr2;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        return this.f1022IXxxXO.f19667oIX0oI;
    }

    @Override // Ix0x.II0XooXoX
    public int I0X0x0oIo() {
        return (int) this.f1022IXxxXO.f19666oI0IIXIo;
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        return this.f1022IXxxXO.f19669oOoXoXO;
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return this.f1022IXxxXO.f19671oxoX;
    }

    @Override // Ix0x.II0XooXoX
    public double[] IIXOooo() {
        return IIxOXoOo0(ooOOo0oXI());
    }

    @Override // Ix0x.II0XooXoX
    public double[] Io() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 18.4d, 24.9d, 29.9d, 90.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        return this.f1022IXxxXO.f19661Oxx0xo * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        return this.f1022IXxxXO.f19662OxxIIOOXO * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double O0Xx() {
        return this.f1022IXxxXO.f19657OOXIXo;
    }

    @Override // Ix0x.II0XooXoX
    public double[] O0xOxO() {
        return IIxOXoOo0(x0xO0oo());
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        return this.f1022IXxxXO.f19657OOXIXo;
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        return this.f1022IXxxXO.f19654IIXOooo;
    }

    @Override // Ix0x.II0XooXoX
    /* renamed from: OOXIxO0, reason: merged with bridge method [inline-methods] */
    public xoIox X00IoxXI(ScaleUserInfo scaleUserInfo, double d, double d2) {
        ScaleInfo scaleInfo;
        int i;
        super.X00IoxXI(scaleUserInfo, d, d2);
        if (scaleUserInfo.XO()) {
            return this;
        }
        OooI.Oxx0IOOO oxx0IOOO = new OooI.Oxx0IOOO(scaleUserInfo.oxoX(), d, (int) scaleUserInfo.II0xO0(), (int) d2, scaleUserInfo.I0Io() % 2);
        BodyResult bodyResult = new BodyResult();
        this.f1022IXxxXO = bodyResult;
        int oIX0oI2 = bodyResult.oIX0oI(oxx0IOOO);
        com.vtrump.vtble.Oxx0xo.II0xO0("1019Calc", "execueSenhe:getError1 " + oIX0oI2);
        if (oIX0oI2 != 0) {
            if (oIX0oI2 != 1 && oIX0oI2 != 2) {
                if (oIX0oI2 != 3) {
                    if (oIX0oI2 != 4) {
                        if (oIX0oI2 == 5) {
                            scaleInfo = this.f983x0XOIxOo;
                            i = 4008;
                        }
                        return this;
                    }
                } else {
                    scaleInfo = this.f983x0XOIxOo;
                    i = ErrorCode.NOT_SUPPORT_EXPRESS_VIDEO;
                }
            }
            scaleInfo = this.f983x0XOIxOo;
            i = 4006;
        } else {
            scaleInfo = this.f983x0XOIxOo;
            i = 0;
        }
        scaleInfo.xx0X0(i);
        return this;
    }

    @Override // Ix0x.II0XooXoX
    public double[] Oo() {
        boolean oOoXoXO2 = oOoXoXO();
        double[] dArr = {XIXIX.OOXIXo.f3760XO, 45.0d, 60.0d, 90.0d};
        if (oOoXoXO2) {
            // fill-array-data instruction
            dArr[0] = 0.0d;
            dArr[1] = 55.0d;
            dArr[2] = 65.0d;
            dArr[3] = 97.5d;
            return dArr;
        }
        return dArr;
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxI() {
        double d = this.f1022IXxxXO.f19657OOXIXo;
        double d2 = 0.1d * d;
        double d3 = 0.2d * d;
        double d4 = d - d3;
        double d5 = d - d2;
        double d6 = d2 + d;
        double d7 = d + d3;
        return new double[]{XIXIX.OOXIXo.f3760XO, d4, d5, d6, d7, 1.5d * d7};
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return this.f1022IXxxXO.f19663X0o0xo;
    }

    @Override // Ix0x.II0XooXoX
    public int[] Oxx0xo() {
        return new int[]{0, 59, 69, 79, 89, 100};
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxxIIOOXO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 5.0d, 10.0d, 15.0d, 60.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        return this.f1022IXxxXO.f19653II0xO0;
    }

    @Override // Ix0x.II0XooXoX
    public int XI0oooXX() {
        return (int) this.f1022IXxxXO.f19670ooOOo0oXI;
    }

    @Override // Ix0x.II0XooXoX
    public double XO() {
        return this.f1022IXxxXO.f19651I0Io;
    }

    @Override // Ix0x.II0XooXoX
    public double[] XOxIOxOx() {
        return IIxOXoOo0(Oo());
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return this.f1022IXxxXO.f19673x0xO0oo * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        return (int) this.f1022IXxxXO.f19652II0XooXoX;
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.a XoI0Ixx0() {
        ScaleInfo.a aVar = ScaleInfo.a.VT_BODY_SHAPE_HIDDEN_FAT;
        switch (this.f1022IXxxXO.f19656O0xOxO) {
            case 2:
                return ScaleInfo.a.VT_BODY_SHAPE_CHUBBY;
            case 3:
                return ScaleInfo.a.VT_BODY_SHAPE_BEEFY;
            case 4:
                return ScaleInfo.a.VT_BODY_SHAPE_SLIM;
            case 5:
                return ScaleInfo.a.VT_BODY_SHAPE_FIT;
            case 6:
                return ScaleInfo.a.VT_BODY_SHAPE_ATHLETIC;
            case 7:
                return ScaleInfo.a.VT_BODY_SHAPE_SLENDER;
            case 8:
                return ScaleInfo.a.VT_BODY_SHAPE_LEAN;
            case 9:
                return ScaleInfo.a.VT_BODY_SHAPE_WELL_BUILT;
            default:
                return aVar;
        }
    }

    @Override // Ix0x.II0XooXoX
    public double[] o00() {
        return IIxOXoOo0(oO());
    }

    @Override // Ix0x.II0XooXoX
    public double o0xxxXXxX() {
        return this.f1022IXxxXO.f19655IXxxXO * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oI0IIXIo() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d3 <= 39) {
                d = 6.9d;
                d2 = 22.0d;
            } else if (d3 <= 59) {
                d = 8.9d;
                d2 = 25.0d;
            } else {
                d = 10.9d;
                d2 = 26.0d;
            }
        } else if (d3 <= 39) {
            d = 17.9d;
            d2 = 34.0d;
        } else if (d3 <= 59) {
            d = 19.9d;
            d2 = 36.0d;
        } else {
            d = 21.9d;
            d2 = 38.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double[] oO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 15.9d, 17.9d, 26.849999999999998d};
    }

    @Override // Ix0x.II0XooXoX
    public double oX() {
        return this.f1022IXxxXO.f19674xoIox;
    }

    @Override // Ix0x.II0XooXoX
    public double[] ooOOo0oXI() {
        double d;
        double d2 = 31.9d;
        double d3 = 18.9d;
        int i = this.f971I0Io;
        double d4 = 15.9d;
        if (i == 0) {
            double d5 = this.f982oxoX;
            d3 = 6.9d;
            if (d5 > 7.0d) {
                if (d5 <= 11.0d) {
                    d2 = 25.9d;
                    d = 29.9d;
                } else if (d5 > 13.0d) {
                    if (d5 <= 14.0d) {
                        d4 = 14.9d;
                        d = 28.9d;
                    } else if (d5 <= 15.0d) {
                        d2 = 23.9d;
                        d3 = 7.9d;
                        d4 = 14.9d;
                        d = 28.9d;
                    } else {
                        if (d5 <= 16.0d) {
                            d2 = 23.9d;
                            d3 = 7.9d;
                        } else {
                            if (d5 <= 17.0d) {
                                d3 = 8.9d;
                            } else if (d5 <= 39.0d) {
                                d = 26.9d;
                                d3 = 10.9d;
                                d2 = 21.9d;
                                d4 = 16.9d;
                            } else if (d5 <= 59.0d) {
                                d3 = 11.9d;
                                d4 = 17.9d;
                            } else {
                                d3 = 13.9d;
                                d4 = 19.9d;
                            }
                            d2 = 22.9d;
                        }
                        d = 27.9d;
                    }
                }
                return new double[]{XIXIX.OOXIXo.f3760XO, d3, d4, d2, d, 1.5d * d};
            }
            d = 29.9d;
        } else {
            if (i == 1) {
                double d6 = this.f982oxoX;
                if (d6 <= 6.0d) {
                    d3 = 7.9d;
                    d = 28.9d;
                } else if (d6 <= 7.0d) {
                    d3 = 8.9d;
                    d4 = 16.9d;
                    d = 29.9d;
                } else if (d6 <= 8.0d) {
                    d = 30.9d;
                    d3 = 9.9d;
                    d4 = 17.9d;
                    d2 = 25.9d;
                } else if (d6 <= 9.0d) {
                    d = 31.9d;
                    d4 = 18.9d;
                    d3 = 9.9d;
                    d2 = 27.9d;
                } else if (d6 <= 10.0d) {
                    d = 32.9d;
                    d3 = 10.9d;
                    d4 = 19.9d;
                    d2 = 28.9d;
                } else if (d6 <= 11.0d) {
                    d3 = 12.9d;
                    d2 = 30.9d;
                    d = 34.9d;
                    d4 = 21.9d;
                } else if (d6 <= 12.0d) {
                    d3 = 13.9d;
                    d = 35.9d;
                    d4 = 22.9d;
                } else if (d6 <= 13.0d) {
                    d2 = 33.9d;
                    d = 37.9d;
                    d3 = 14.9d;
                    d4 = 24.9d;
                } else if (d6 <= 14.0d) {
                    d = 38.9d;
                    d2 = 34.9d;
                    d3 = 16.9d;
                    d4 = 25.9d;
                } else {
                    if (d6 <= 15.0d) {
                        d4 = 26.9d;
                        d2 = 35.9d;
                        d3 = 17.9d;
                    } else {
                        if (d6 <= 16.0d) {
                            d = 40.9d;
                            d2 = 36.9d;
                        } else if (d6 <= 17.0d) {
                            d = 40.9d;
                            d2 = 36.9d;
                            d3 = 19.9d;
                        } else if (d6 <= 39.0d) {
                            d3 = 20.9d;
                            d2 = 34.9d;
                            d4 = 27.9d;
                        } else if (d6 <= 59.0d) {
                            d = 40.9d;
                            d2 = 35.9d;
                            d3 = 21.9d;
                            d4 = 28.9d;
                        } else {
                            d = 41.9d;
                            d2 = 36.9d;
                            d3 = 22.9d;
                            d4 = 29.9d;
                        }
                        d4 = 27.9d;
                    }
                    d = 39.9d;
                }
            } else {
                d = 0.0d;
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
            }
            return new double[]{XIXIX.OOXIXo.f3760XO, d3, d4, d2, d, 1.5d * d};
        }
        d2 = 24.9d;
        return new double[]{XIXIX.OOXIXo.f3760XO, d3, d4, d2, d, 1.5d * d};
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        return this.f1022IXxxXO.f19658Oo * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxXx0IX() {
        double d;
        double d2 = this.f982oxoX;
        if (d2 <= 12.0d) {
            if (oOoXoXO()) {
                d = 36.0d;
            } else {
                d = 34.0d;
            }
        } else if (d2 <= 15.0d) {
            if (oOoXoXO()) {
                d = 30.0d;
            } else {
                d = 29.0d;
            }
        } else if (d2 <= 17.0d) {
            if (oOoXoXO()) {
                d = 26.0d;
            } else {
                d = 24.0d;
            }
        } else if (d2 <= 29.0d) {
            if (oOoXoXO()) {
                d = 23.0d;
            } else {
                d = 22.0d;
            }
        } else {
            boolean oOoXoXO2 = oOoXoXO();
            if (d2 <= 49.0d) {
                if (oOoXoXO2) {
                    d = 21.0d;
                }
                d = 20.0d;
            } else {
                if (!oOoXoXO2) {
                    d = 19.0d;
                }
                d = 20.0d;
            }
        }
        double d3 = d * this.f978oIX0oI;
        return new double[]{XIXIX.OOXIXo.f3760XO, d3, 1.5d * d3};
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        return this.f1022IXxxXO.f19664XO;
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0XOIxOo() {
        boolean oOoXoXO2 = oOoXoXO();
        double[] dArr = {XIXIX.OOXIXo.f3760XO, 65.0d, 75.0d, 100.0d};
        if (oOoXoXO2) {
            // fill-array-data instruction
            dArr[0] = 0.0d;
            dArr[1] = 72.0d;
            dArr[2] = 82.0d;
            dArr[3] = 100.0d;
            return dArr;
        }
        return dArr;
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        return (int) this.f1022IXxxXO.f19676xxIXOIIO;
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0xO0oo() {
        boolean oOoXoXO2 = oOoXoXO();
        double[] dArr = {XIXIX.OOXIXo.f3760XO, 40.0d, 50.0d, 75.0d};
        if (oOoXoXO2) {
            // fill-array-data instruction
            dArr[0] = 0.0d;
            dArr[1] = 50.0d;
            dArr[2] = 60.0d;
            dArr[3] = 90.0d;
            return dArr;
        }
        return dArr;
    }

    @Override // Ix0x.II0XooXoX
    public double[] xXOx() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f978oIX0oI;
        if (oOoXoXO2) {
            if (d3 > 60.0d) {
                if (d3 <= 75.0d) {
                    d = 2.8d;
                    d2 = 3.0d;
                } else {
                    d = 3.1d;
                    d2 = 3.3d;
                }
            }
            d = 2.4d;
            d2 = 2.6d;
        } else if (d3 <= 45.0d) {
            d = 1.7d;
            d2 = 1.9d;
        } else {
            if (d3 <= 60.0d) {
                d = 2.1d;
                d2 = 2.3d;
            }
            d = 2.4d;
            d2 = 2.6d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double[] xoXoI() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f973II0xO0;
        if (oOoXoXO2) {
            if (d3 <= 159) {
                d = 38.4d;
                d2 = 46.4d;
            } else if (d3 <= 169) {
                d = 43.9d;
                d2 = 52.3d;
            } else {
                d = 49.4d;
                d2 = 59.3d;
            }
        } else if (d3 <= 159) {
            d = 29.0d;
            d2 = 34.6d;
        } else if (d3 <= 169) {
            d = 32.8d;
            d2 = 37.4d;
        } else {
            d = 36.4d;
            d2 = 42.4d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double xoxXI() {
        return this.f1022IXxxXO.f19675xoXoI;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIO() {
        return this.f1022IXxxXO.f19668oO * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        return this.f978oIX0oI - OO();
    }
}
