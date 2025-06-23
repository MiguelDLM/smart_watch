package Ix0x;

import chipsea.bias.v235.CSBiasAPI;
import com.vtrump.vtble.Scale.ScaleInfo;

/* loaded from: classes13.dex */
public class OxxIIOOXO extends II0XooXoX {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static OxxIIOOXO f999Oxx0xo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public CSBiasAPI.oIX0oI f1000IXxxXO;

    private double[] I0(double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = (dArr[i] * this.f978oIX0oI) / 100.0d;
        }
        return dArr2;
    }

    public static OxxIIOOXO ooOx() {
        OxxIIOOXO oxxIIOOXO = f999Oxx0xo;
        if (oxxIIOOXO == null) {
            OxxIIOOXO oxxIIOOXO2 = new OxxIIOOXO();
            f999Oxx0xo = oxxIIOOXO2;
            return oxxIIOOXO2;
        }
        return oxxIIOOXO;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        return this.f1000IXxxXO.f4582I0Io;
    }

    @Override // Ix0x.II0XooXoX
    public int I0X0x0oIo() {
        return this.f1000IXxxXO.f4594x0XOIxOo;
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        return this.f978oIX0oI - oxoX();
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return (this.f1000IXxxXO.f4593oxoX * this.f978oIX0oI) / 100.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    @Override // Ix0x.II0XooXoX
    /* renamed from: IIxOXoOo0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Ix0x.OxxIIOOXO OI0(com.vtrump.vtble.Scale.ScaleUserInfo r11, double r12, double r14) {
        /*
            r10 = this;
            super.OI0(r11, r12, r14)
            int r0 = r11.I0Io()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L13
            if (r0 == r1) goto L11
            r3 = 2
            if (r0 == r3) goto L13
            r1 = 3
        L11:
            r4 = 0
            goto L14
        L13:
            r4 = 1
        L14:
            double r0 = r11.II0xO0()
            int r5 = (int) r0
            int r6 = r11.oxoX()
            r0 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r12 = r12 * r0
            int r7 = (int) r12
            double r14 = r14 * r0
            int r8 = (int) r14
            r3 = 0
            r9 = 2018(0x7e2, float:2.828E-42)
            chipsea.bias.v235.CSBiasAPI$CSBiasV235Resp r11 = chipsea.bias.v235.CSBiasAPI.cs_bias_v235(r3, r4, r5, r6, r7, r8, r9)
            chipsea.bias.v235.CSBiasAPI$oIX0oI r12 = r11.f4580II0xO0
            r10.f1000IXxxXO = r12
            int r11 = r11.f4581oIX0oI
            r12 = -6
            if (r11 == r12) goto L57
            r12 = -5
            if (r11 == r12) goto L52
            r12 = -4
            if (r11 == r12) goto L52
            r12 = -3
            if (r11 == r12) goto L52
            r12 = -2
            if (r11 == r12) goto L4a
            if (r11 == 0) goto L44
            goto L5c
        L44:
            com.vtrump.vtble.Scale.ScaleInfo r11 = r10.f983x0XOIxOo
            r11.xx0X0(r2)
            goto L5c
        L4a:
            com.vtrump.vtble.Scale.ScaleInfo r11 = r10.f983x0XOIxOo
            r12 = 4013(0xfad, float:5.623E-42)
        L4e:
            r11.xx0X0(r12)
            goto L5c
        L52:
            com.vtrump.vtble.Scale.ScaleInfo r11 = r10.f983x0XOIxOo
            r12 = 4006(0xfa6, float:5.614E-42)
            goto L4e
        L57:
            com.vtrump.vtble.Scale.ScaleInfo r11 = r10.f983x0XOIxOo
            r12 = 4008(0xfa8, float:5.616E-42)
            goto L4e
        L5c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.OxxIIOOXO.OI0(com.vtrump.vtble.Scale.ScaleUserInfo, double, double):Ix0x.OxxIIOOXO");
    }

    @Override // Ix0x.II0XooXoX
    public double[] Io() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 18.5d, 24.0d, 28.0d, 42.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        return this.f1000IXxxXO.f4589oIX0oI;
    }

    @Override // Ix0x.II0XooXoX
    public double O0Xx() {
        return this.f1000IXxxXO.f4596xxIXOIIO;
    }

    @Override // Ix0x.II0XooXoX
    public double[] O0xOxO() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f973II0xO0;
        if (oOoXoXO2) {
            if (d3 < 160.0d) {
                d = 21.2d;
                d2 = 26.599999999999998d;
            } else if (d3 <= 170.0d) {
                d = 24.799999999999997d;
                d2 = 34.6d;
            } else {
                d = 29.599999999999998d;
                d2 = 43.199999999999996d;
            }
        } else if (d3 < 150.0d) {
            d = 16.0d;
            d2 = 20.6d;
        } else if (d3 <= 160.0d) {
            d = 18.900000000000002d;
            d2 = 23.7d;
        } else {
            d = 22.1d;
            d2 = 30.299999999999997d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        return O0Xx();
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        double d = this.f1000IXxxXO.f4595xoIox;
        if (d < XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d;
    }

    public final int OOXIxO0(double d, double d2, double d3) {
        if (d < d2) {
            return 1;
        }
        if (d <= d3) {
            return 2;
        }
        return 3;
    }

    public final int OX00O0xII() {
        return OOXIxO0(Ioxxx(), ooOOo0oXI()[1], ooOOo0oXI()[2]);
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
        double[] Io2 = Io();
        double[] dArr = new double[Io2.length];
        for (int i = 0; i < Io2.length; i++) {
            double d = Io2[i];
            double d2 = this.f973II0xO0;
            dArr[i] = ((d * d2) * d2) / 10000.0d;
        }
        return dArr;
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return this.f1000IXxxXO.f4588XO;
    }

    @Override // Ix0x.II0XooXoX
    public int[] Oxx0xo() {
        return new int[]{0, 60, 75, 85, 100};
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxxIIOOXO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 4.5d, 9.5d, 14.5d, 21.75d};
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        return this.f1000IXxxXO.f4584II0xO0;
    }

    @Override // Ix0x.II0XooXoX
    public int XI0oooXX() {
        return this.f1000IXxxXO.f4590oO;
    }

    @Override // Ix0x.II0XooXoX
    public double XO() {
        return (XX0xXo() * this.f978oIX0oI) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] XOxIOxOx() {
        return I0(Oo());
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return this.f1000IXxxXO.f4587X0o0xo;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        return this.f1000IXxxXO.f4592ooOOo0oXI;
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.a XoI0Ixx0() {
        int OX00O0xII2 = OX00O0xII();
        int xX0IIXIx02 = xX0IIXIx0();
        if (1 == OX00O0xII2) {
            if (1 == xX0IIXIx02) {
                return ScaleInfo.a.VT_BODY_SHAPE_SLENDER;
            }
            if (2 == xX0IIXIx02) {
                return ScaleInfo.a.VT_BODY_SHAPE_LEAN;
            }
            return ScaleInfo.a.VT_BODY_SHAPE_WELL_BUILT;
        }
        if (2 == OX00O0xII2) {
            if (1 == xX0IIXIx02) {
                return ScaleInfo.a.VT_BODY_SHAPE_SLIM;
            }
            if (2 == xX0IIXIx02) {
                return ScaleInfo.a.VT_BODY_SHAPE_FIT;
            }
            return ScaleInfo.a.VT_BODY_SHAPE_ATHLETIC;
        }
        if (1 == xX0IIXIx02) {
            return ScaleInfo.a.VT_BODY_SHAPE_HIDDEN_FAT;
        }
        if (2 == xX0IIXIx02) {
            return ScaleInfo.a.VT_BODY_SHAPE_CHUBBY;
        }
        return ScaleInfo.a.VT_BODY_SHAPE_BEEFY;
    }

    @Override // Ix0x.II0XooXoX
    public double[] o00() {
        return I0(oO());
    }

    @Override // Ix0x.II0XooXoX
    public double o0xxxXXxX() {
        return (Oxx0IOOO() / this.f978oIX0oI) * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 16.0d, 20.0d, 30.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double oX() {
        return this.f1000IXxxXO.f4583II0XooXoX;
    }

    @Override // Ix0x.II0XooXoX
    public double[] ooOOo0oXI() {
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f982oxoX;
        if (oOoXoXO2) {
            if (d <= 39.0d) {
                return new double[]{XIXIX.OOXIXo.f3760XO, 10.0d, 21.0d, 26.0d, 39.0d};
            }
            double[] dArr = {XIXIX.OOXIXo.f3760XO, 13.0d, 24.0d, 29.0d, 43.5d};
            if (d <= 59.0d) {
                // fill-array-data instruction
                dArr[0] = 0.0d;
                dArr[1] = 11.0d;
                dArr[2] = 22.0d;
                dArr[3] = 27.0d;
                dArr[4] = 40.5d;
                return dArr;
            }
            return dArr;
        }
        if (d <= 39.0d) {
            return new double[]{XIXIX.OOXIXo.f3760XO, 20.0d, 34.0d, 39.0d, 58.5d};
        }
        double[] dArr2 = {XIXIX.OOXIXo.f3760XO, 22.0d, 36.0d, 41.0d, 61.5d};
        if (d <= 59.0d) {
            // fill-array-data instruction
            dArr2[0] = 0.0d;
            dArr2[1] = 21.0d;
            dArr2[2] = 35.0d;
            dArr2[3] = 40.0d;
            dArr2[4] = 60.0d;
            return dArr2;
        }
        return dArr2;
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        return this.f1000IXxxXO.f4593oxoX;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxXx0IX() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d2 <= 29.0d) {
                d = 1550.0d;
            } else if (d2 <= 49.0d) {
                d = 1500.0d;
            } else if (d2 <= 69.0d) {
                d = 1350.0d;
            } else {
                d = 1220.0d;
            }
        } else if (d2 <= 29.0d) {
            d = 1210.0d;
        } else if (d2 <= 49.0d) {
            d = 1170.0d;
        } else if (d2 <= 69.0d) {
            d = 1110.0d;
        } else {
            d = 1010.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, 1.5d * d};
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        return (this.f978oIX0oI * Ioxxx()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0XOIxOo() {
        return xoO0xx0(xoXoI());
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        return (int) this.f1000IXxxXO.f4586Oxx0IOOO;
    }

    public final int xX0IIXIx0() {
        return OOXIxO0(X0o0xo(), xoXoI()[1], xoXoI()[2]);
    }

    @Override // Ix0x.II0XooXoX
    public double[] xXOx() {
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f978oIX0oI;
        if (oOoXoXO2) {
            if (d <= 60.0d) {
                return new double[]{XIXIX.OOXIXo.f3760XO, 2.5d, 3.75d};
            }
            double[] dArr = {XIXIX.OOXIXo.f3760XO, 3.2d, 4.800000000000001d};
            if (d <= 75.0d) {
                // fill-array-data instruction
                dArr[0] = 0.0d;
                dArr[1] = 2.9d;
                dArr[2] = 4.35d;
                return dArr;
            }
            return dArr;
        }
        if (d <= 45.0d) {
            return new double[]{XIXIX.OOXIXo.f3760XO, 1.8d, 2.7d};
        }
        double[] dArr2 = {XIXIX.OOXIXo.f3760XO, 2.5d, 3.75d};
        if (d <= 60.0d) {
            // fill-array-data instruction
            dArr2[0] = 0.0d;
            dArr2[1] = 2.2d;
            dArr2[2] = 3.3000000000000003d;
            return dArr2;
        }
        return dArr2;
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.c xoIxX() {
        double O0Xx2 = (this.f978oIX0oI - O0Xx()) / O0Xx();
        if (O0Xx2 < -0.1d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_LIGHT;
        }
        if (O0Xx2 < 0.1d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_NORMAL;
        }
        if (O0Xx2 < 0.2d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_OVERWEIGHT;
        }
        if (O0Xx2 < 0.3d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_MILD;
        }
        if (O0Xx2 < 0.5d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_MODERATE;
        }
        return ScaleInfo.c.VT_OBESITY_LEVEL_SEVERE;
    }

    public final double[] xoO0xx0(double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = (dArr[i] * 100.0d) / this.f978oIX0oI;
        }
        return dArr2;
    }

    @Override // Ix0x.II0XooXoX
    public double[] xoXoI() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f973II0xO0;
        if (oOoXoXO2) {
            if (d3 < 160.0d) {
                d = 38.5d;
                d2 = 46.5d;
            } else if (d3 <= 170.0d) {
                d = 44.0d;
                d2 = 52.4d;
            } else {
                d = 49.4d;
                d2 = 59.4d;
            }
        } else if (d3 < 150.0d) {
            d = 21.9d;
            d2 = 34.7d;
        } else if (d3 <= 160.0d) {
            d = 32.9d;
            d2 = 37.5d;
        } else {
            d = 36.5d;
            d2 = 42.5d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double xoxXI() {
        double d = this.f1000IXxxXO.f4591oOoXoXO;
        if (d > XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIO() {
        return (this.f1000IXxxXO.f4584II0xO0 / this.f978oIX0oI) * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        return -this.f1000IXxxXO.f4585OOXIXo;
    }
}
