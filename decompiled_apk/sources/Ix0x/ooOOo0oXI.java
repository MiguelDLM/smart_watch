package Ix0x;

import com.vtrump.vtble.Scale.ScaleInfo;

/* loaded from: classes13.dex */
public class ooOOo0oXI extends II0XooXoX {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static ooOOo0oXI f1014IXxxXO;

    public static ooOOo0oXI OOXIxO0() {
        ooOOo0oXI ooooo0oxi = f1014IXxxXO;
        if (ooooo0oxi == null) {
            ooOOo0oXI ooooo0oxi2 = new ooOOo0oXI();
            f1014IXxxXO = ooooo0oxi2;
            return ooooo0oxi2;
        }
        return ooooo0oxi;
    }

    public final double I0() {
        double d;
        double d2 = this.f973II0xO0;
        if (d2 >= 220.0d) {
            d = 28.0d;
        } else if (d2 >= 210.0d) {
            d = 27.2d;
        } else if (d2 >= 200.0d) {
            d = 26.4d;
        } else if (d2 >= 190.0d) {
            d = 25.6d;
        } else if (d2 >= 180.0d) {
            d = 24.7d;
        } else if (d2 >= 170.0d) {
            d = 23.8d;
        } else if (d2 >= 160.0d) {
            d = 22.8d;
        } else if (d2 >= 150.0d) {
            d = 21.8d;
        } else if (d2 >= 140.0d) {
            d = 20.9d;
        } else if (d2 >= 130.0d) {
            d = 19.9d;
        } else if (d2 >= 120.0d) {
            d = 19.1d;
        } else {
            d = 18.4d;
        }
        double d3 = ((d * d2) * d2) / 10000.0d;
        if (oOoXoXO()) {
            return d3 + 0.1d;
        }
        return d3;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double IIxOXoOo02 = IIxOXoOo0();
        if (oOoXoXO()) {
            if (IIxOXoOo02 > 60.0d) {
                d5 = this.f978oIX0oI * 22.534982474991d;
                d6 = -49.105517591188d;
                d7 = d5 + d6;
            } else {
                d = this.f973II0xO0;
                double d8 = this.f978oIX0oI;
                d2 = d8 * d8;
                d3 = (((((236.342733326017d - (6.64030403153769d * d)) + (192.851026509674d * d8)) + (0.144006818746681d * d2)) - ((d8 * d) * 0.203212043052917d)) + (184767.529341193d / d)) - ((d8 * 16735.2834366709d) / d);
                d4 = 72.9384694859453d;
                d7 = d3 - ((d2 * d4) / d);
            }
        } else if (IIxOXoOo02 > 60.0d) {
            d5 = this.f978oIX0oI * 24.752769303642d;
            d6 = -98.290669887422d;
            d7 = d5 + d6;
        } else {
            d = this.f973II0xO0;
            double d9 = this.f978oIX0oI;
            d2 = d9 * d9;
            d3 = (((((466.28909818965d - (7.69539388288214d * d)) + (197.331751165713d * d9)) + (0.0830071625805276d * d2)) - ((d9 * d) * 0.171716102108274d)) + (213307.282794853d / d)) - ((d9 * 18918.390383811d) / d);
            d4 = 63.5345981610536d;
            d7 = d3 - ((d2 * d4) / d);
        }
        double d10 = d7 + 5.0d;
        if (d10 - 1000.0d < 9.999999974752427E-7d) {
            d10 = 1000.0d;
        }
        return d10 / 1000.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int I0X0x0oIo() {
        /*
            r7 = this;
            double r0 = r7.Ioxxx()
            r2 = 4625759767262920704(0x4032000000000000, double:18.0)
            double r2 = r0 - r2
            r4 = 4517329193096183808(0x3eb0c6f7a0000000, double:9.999999974752427E-7)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L1f
            r2 = 4600877379429072896(0x3fd99999a0000000, double:0.4000000059604645)
            double r0 = r0 * r2
            r2 = 4619681033476898816(0x401c676c80000000, double:7.10099983215332)
        L1d:
            double r0 = r0 - r2
            goto L30
        L1f:
            r2 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r2 = r0 - r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L2e
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r0 = r0 * r2
            r2 = 4621819117588971520(0x4024000000000000, double:10.0)
            goto L1d
        L2e:
            r0 = 0
        L30:
            double r2 = r7.f982oxoX
            float r2 = (float) r2
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            double r2 = (double) r2
            double r0 = r0 + r2
            int r0 = (int) r0
            r1 = 5
            if (r0 >= r1) goto L3e
            r0 = 5
            goto L44
        L3e:
            r1 = 99
            if (r0 <= r1) goto L44
            r0 = 99
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.ooOOo0oXI.I0X0x0oIo():int");
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        return this.f978oIX0oI - oxoX();
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        double d;
        double d2;
        double d3;
        boolean oOoXoXO2 = oOoXoXO();
        double d4 = this.f978oIX0oI;
        if (oOoXoXO2) {
            if (d4 > 100.0d) {
                double d5 = this.f973II0xO0;
                double d6 = 413.0168d - (4.5986d * d5);
                double d7 = this.f982oxoX;
                return (((((((d6 + (2.4216d * d7)) + (2.8999d * d4)) + (((2.0026d * d5) * d5) / d4)) - (((4.4406d * d7) * d4) / d5)) - (((0.0537d * d4) * d4) / d7)) - ((253.0163d * d5) / d4)) + ((d5 * 2.9252d) / d7)) - (this.f976X0o0xo * 0.0215d);
            }
            double d8 = this.f973II0xO0;
            double d9 = this.f982oxoX;
            d = (((((((0.613d * d8) - 46.3381d) + (0.1642d * d9)) + (0.1288d * d4)) - (((0.11d * d8) * d8) / d4)) - (((0.6127d * d9) * d4) / d8)) - (((0.0175d * d4) * d4) / d9)) + ((9.6722d * d8) / d4) + ((d8 * 0.1517d) / d9);
            d2 = this.f976X0o0xo;
            d3 = 0.001d;
        } else if (d4 > 100.0d) {
            double d10 = this.f973II0xO0;
            double d11 = (13.6694d * d10) + XIXIX.OOXIXo.f3760XO;
            double d12 = this.f982oxoX;
            d = ((((((d11 - (33.7343d * d12)) - (13.0099d * d4)) - (((2.1709d * d10) * d10) / d4)) + (((44.028d * d12) * d4) / d10)) + (((0.0651d * d4) * d4) / d12)) + ((XIXIX.OOXIXo.f3760XO * d10) / d4)) - ((d10 * 26.2435d) / d12);
            d2 = this.f976X0o0xo;
            d3 = 0.0017d;
        } else {
            double d13 = this.f973II0xO0;
            double d14 = this.f982oxoX;
            return (((((((((0.7528d * d13) - 82.7855d) + (0.3714d * d14)) + (0.2286d * d4)) - (((0.1725d * d13) * d13) / d4)) - (((1.1214d * d14) * d4) / d13)) - (((0.0389d * d4) * d4) / d14)) + ((20.8032d * d13) / d4)) + ((d13 * 0.9029d) / d14)) - (this.f976X0o0xo * 8.0E-4d);
        }
        return d + (d2 * d3);
    }

    @Override // Ix0x.II0XooXoX
    public double[] IIXOooo() {
        double d;
        double d2;
        double d3;
        if (oOoXoXO()) {
            d = this.f978oIX0oI;
            d2 = 0.1d * d;
            d3 = 0.2d;
        } else {
            d = this.f978oIX0oI;
            d2 = 0.18d * d;
            d3 = 0.28d;
        }
        double d4 = d * d3;
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, d4, 1.5d * d4};
    }

    public final double IIxOXoOo0() {
        if (oOoXoXO()) {
            double d = this.f973II0xO0;
            double d2 = this.f978oIX0oI;
            double log = (((-0.498390119124715d) * d) - 689.2084347d) + ((-7.89924635802088d) * d2) + (((0.945125695686575d * d2) * d2) / d) + (((28501.6938287363d * d2) / d) / d) + (((((-2.3189284183297d) * d2) * d2) * d2) / 100000.0d) + (d * 0.0188763959463404d * d2) + (Math.log(d2) * 239.168185117735d);
            double d3 = this.f973II0xO0;
            double d4 = this.f978oIX0oI;
            return log + (((403.299818139663d * d3) / d4) / d4) + (((((-2.46477311167064d) * d3) * d3) * d4) / 100000.0d) + (0.0113235553128364d * d4 * d4) + (this.f976X0o0xo / 1000.0d) + (Math.abs(this.f982oxoX - 30.0d) / 100.0d);
        }
        double d5 = this.f973II0xO0;
        double d6 = this.f978oIX0oI;
        double log2 = (((-0.300571245494834d) * d5) - 459.680795817939d) + ((-5.27480670158172d) * d6) + (((0.563000856524543d * d6) * d6) / d5) + (((28119.7182378661d * d6) / d5) / d5) + (((((-1.29308729473524d) * d6) * d6) * d6) / 100000.0d) + (d5 * 0.0123627859962689d * d6) + (Math.log(d6) * 157.906925674619d);
        double d7 = this.f973II0xO0;
        double d8 = this.f978oIX0oI;
        return log2 + (((241.251099037496d * d7) / d8) / d8) + (((((-1.57557932881544d) * d7) * d7) * d8) / 100000.0d) + (0.00711939496190164d * d8 * d8) + (this.f976X0o0xo / 1000.0d) + (Math.abs(this.f982oxoX - 30.0d) / 100.0d);
    }

    @Override // Ix0x.II0XooXoX
    public double[] Io() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 18.5d, 24.0d, 36.0d};
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if ((r0 - 60.0d) > 9.999999974752427E-7d) goto L4;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double Ioxxx() {
        /*
            r9 = this;
            double r0 = r9.IIxOXoOo0()
            r2 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r4 = r0 - r2
            r6 = 4517329193096183808(0x3eb0c6f7a0000000, double:9.999999974752427E-7)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L13
        L11:
            r0 = r2
            goto L1c
        L13:
            r2 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r4 = r0 - r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L1c
            goto L11
        L1c:
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L23
            goto L24
        L23:
            r0 = r2
        L24:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.ooOOo0oXI.Ioxxx():double");
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        double d;
        double d2;
        double d3;
        double Ioxxx2 = Ioxxx();
        if (oOoXoXO()) {
            d = (72.06837463378906d * Ioxxx2) - 5.644039630889893d;
            d2 = Ioxxx2 * Ioxxx2;
            d3 = 0.19953425228595734d;
        } else {
            d = (72.03131866455078d * Ioxxx2) - 4.608469486236572d;
            d2 = Ioxxx2 * Ioxxx2;
            d3 = 0.19925649464130402d;
        }
        return (d - (d2 * d3)) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] O0xOxO() {
        double d;
        double ooOx2 = ooOx();
        double I02 = I0();
        if (oOoXoXO()) {
            d = 0.597d;
        } else {
            d = 0.543d;
        }
        double d2 = I02 * d;
        return new double[]{XIXIX.OOXIXo.f3760XO, ooOx2 * d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        double d;
        double d2;
        double d3;
        double d4;
        if (!oOoXoXO()) {
            d = this.f973II0xO0;
            double d5 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = (((((2.6558d * d) - 314.9836d) - (0.3088d * d5)) - (0.6317d * d2)) - (((0.5868d * d) * d) / d2)) + (((1.0275d * d5) * d2) / d) + (((0.0259d * d2) * d2) / d5);
            d4 = 84.8258d;
        } else {
            d = this.f973II0xO0;
            double d6 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = (((((1.4561d * d) - 168.364d) - (0.0286d * d6)) - (0.1315d * d2)) - (((0.1655d * d) * d) / d2)) + (((0.0834d * d6) * d2) / d) + (((4.0E-4d * d2) * d2) / d6);
            d4 = 25.0475d;
        }
        double d7 = d3 + ((d * d4) / d2);
        if (d7 > 150.0d) {
            return 130.0d;
        }
        return d7;
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        double d;
        double ooOx2 = ooOx();
        I0();
        if (oOoXoXO()) {
            d = 0.796d;
        } else {
            d = 0.724d;
        }
        double d2 = ooOx2 * d;
        double X0o0xo2 = X0o0xo();
        if (X0o0xo2 < d2) {
            return X0o0xo2 - d2;
        }
        return XIXIX.OOXIXo.f3760XO;
    }

    @Override // Ix0x.II0XooXoX
    public double[] Oo() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 54.1d, 66.0d, 99.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxI() {
        double ooOx2 = ooOx();
        double I02 = I0();
        return new double[]{XIXIX.OOXIXo.f3760XO, ooOx2, I02, 1.5d * I02};
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        double d;
        double d2;
        double d3;
        double d4;
        if (oOoXoXO()) {
            d = this.f973II0xO0;
            double d5 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = ((0.7621d * d) - 64.3308d) + (0.0146d * d5) + ((-0.033d) * d2) + ((((-0.1634d) * d) * d) / d2) + ((((-0.1713d) * d5) * d2) / d) + ((((-0.007d) * d2) * d2) / d5);
            d4 = 18.2628d;
        } else {
            d = this.f973II0xO0;
            double d6 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = ((0.8047d * d) - 56.695d) + ((-0.0217d) * d6) + ((-0.1947d) * d2) + ((((-0.1476d) * d) * d) / d2) + ((((-0.1646d) * d6) * d2) / d) + ((((-0.024d) * d2) * d2) / d6);
            d4 = 13.4531d;
        }
        return d3 + ((d * d4) / d2);
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxxIIOOXO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 9.0d, 14.0d, 21.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        double d;
        double d2;
        double d3;
        double d4;
        if (oOoXoXO()) {
            d = this.f973II0xO0;
            double d5 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = ((1.034d * d) - 87.751d) + (0.0197d * d5) + ((-0.021d) * d2) + ((((-0.2204d) * d) * d) / d2) + ((((-0.2418d) * d5) * d2) / d) + ((((-0.0099d) * d2) * d2) / d5);
            d4 = 24.832d;
        } else {
            d = this.f973II0xO0;
            double d6 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = ((1.1404d * d) - 80.792d) + ((-0.0382d) * d6) + ((-0.2818d) * d2) + ((((-0.2089d) * d) * d) / d2) + ((((-0.2069d) * d6) * d2) / d) + ((((-0.0335d) * d2) * d2) / d6);
            d4 = 19.1188d;
        }
        return d3 + ((d * d4) / d2);
    }

    @Override // Ix0x.II0XooXoX
    public int XI0oooXX() {
        double d;
        double d2;
        double d3;
        double d4;
        if (oOoXoXO()) {
            d = this.f973II0xO0;
            double d5 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = ((1.3266d * d) - 167.578d) + (0.0045d * d5) + ((-0.3181d) * d2) + ((((-0.2659d) * d) * d) / d2) + ((((-0.1536d) * d5) * d2) / d) + ((((-0.0374d) * d2) * d2) / d5);
            d4 = 64.7653d;
        } else {
            d = this.f973II0xO0;
            double d6 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = ((3.164d * d) - 468.02d) + (0.5228d * d6) + (0.4896d * d2) + ((((-0.9829d) * d) * d) / d2) + ((((-2.3712d) * d6) * d2) / d) + ((((-0.1629d) * d2) * d2) / d6);
            d4 = 168.602d;
        }
        double d7 = d3 + ((d * d4) / d2);
        if (d7 < 10.0d) {
            d7 = 10.0d;
        } else if (d7 > 100.0d) {
            d7 = 99.0d;
        }
        return (int) Math.ceil(d7);
    }

    @Override // Ix0x.II0XooXoX
    public double XO() {
        double d;
        double d2;
        double d3;
        double d4;
        if (oOoXoXO()) {
            d = this.f973II0xO0;
            double d5 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = ((0.2262d * d) - 19.8458d) + (0.012d * d5) + (1.0E-4d * d2) + ((((-0.0493d) * d) * d) / d2) + ((((-0.0735d) * d5) * d2) / d) + ((((-0.0021d) * d2) * d2) / d5);
            d4 = 5.6398d;
        } else {
            d = this.f973II0xO0;
            double d6 = this.f982oxoX;
            d2 = this.f978oIX0oI;
            d3 = ((0.2473d * d) - 19.209d) + ((-0.0049d) * d6) + ((-0.0506d) * d2) + ((((-0.0461d) * d) * d) / d2) + ((((-0.0625d) * d6) * d2) / d) + ((((-0.0081d) * d2) * d2) / d6);
            d4 = 4.3494d;
        }
        return d3 + ((d * d4) / d2);
    }

    @Override // Ix0x.II0XooXoX
    public double[] XOxIOxOx() {
        double d = this.f978oIX0oI;
        double d2 = 0.541d * d;
        double d3 = d * 0.66d;
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, d3, 1.5d * d3};
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return (XO() / this.f978oIX0oI) * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        double d;
        double d2;
        double d3;
        double d4;
        boolean oOoXoXO2 = oOoXoXO();
        double d5 = this.f982oxoX * 4.9984d;
        if (oOoXoXO2) {
            double d6 = 6.726d - d5;
            d = this.f973II0xO0;
            d2 = this.f978oIX0oI;
            d3 = d6 + (6.2422d * d) + (10.0129d * d2);
            d4 = 370.0371d;
        } else {
            double d7 = (-159.2842d) - d5;
            d = this.f973II0xO0;
            d2 = this.f978oIX0oI;
            d3 = d7 + (6.2422d * d) + (10.0129d * d2);
            d4 = 403.6723d;
        }
        return (int) (d3 - (((d2 * d4) / d) / d));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0057, code lost:
    
        if (r3 > (((r9 * 0.796d) / r7) * 100.0d)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0079, code lost:
    
        r3 = 1;
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0076, code lost:
    
        r3 = 1;
        r4 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0074, code lost:
    
        if (r3 > (((r9 * 0.724d) / r5) * 100.0d)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x002c, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r1 >= 10.0d) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x002a, code lost:
    
        if (r1 >= 18.0d) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        r1 = 1;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.vtrump.vtble.Scale.ScaleInfo.a XoI0Ixx0() {
        /*
            Method dump skipped, instructions count: 194
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.ooOOo0oXI.XoI0Ixx0():com.vtrump.vtble.Scale.ScaleInfo$a");
    }

    @Override // Ix0x.II0XooXoX
    public double[] o00() {
        double d = this.f978oIX0oI;
        double d2 = 0.14d * d;
        double d3 = d * 0.17d;
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, d3, 1.5d * d3};
    }

    @Override // Ix0x.II0XooXoX
    public double o0xxxXXxX() {
        return (Oxx0IOOO() / this.f978oIX0oI) * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oI0IIXIo() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = 7.0d;
            d2 = 15.0d;
        } else {
            d = 11.0d;
            d2 = 17.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
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
    public double[] oO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 14.0d, 17.0d, 25.5d};
    }

    @Override // Ix0x.II0XooXoX
    public double[] ooOOo0oXI() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = 10.0d;
            d2 = 20.0d;
        } else {
            d = 18.0d;
            d2 = 28.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    public final double ooOx() {
        double d;
        double d2 = this.f973II0xO0;
        if (d2 >= 220.0d) {
            d = 22.9d;
        } else if (d2 >= 210.0d) {
            d = 22.3d;
        } else if (d2 >= 200.0d) {
            d = 21.6d;
        } else if (d2 >= 190.0d) {
            d = 20.9d;
        } else if (d2 >= 180.0d) {
            d = 20.2d;
        } else if (d2 >= 170.0d) {
            d = 19.4d;
        } else if (d2 >= 160.0d) {
            d = 18.7d;
        } else if (d2 >= 150.0d) {
            d = 17.9d;
        } else if (d2 >= 140.0d) {
            d = 17.1d;
        } else if (d2 >= 130.0d) {
            d = 16.3d;
        } else if (d2 >= 120.0d) {
            d = 15.6d;
        } else {
            d = 15.1d;
        }
        double d3 = ((d * d2) * d2) / 10000.0d;
        if (oOoXoXO()) {
            return d3 + 0.1d;
        }
        return d3;
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        return (II0XooXoX() / this.f978oIX0oI) * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0XOIxOo() {
        double d;
        double ooOx2 = ooOx();
        double I02 = I0();
        if (oOoXoXO()) {
            d = 0.796d;
        } else {
            d = 0.724d;
        }
        double d2 = this.f978oIX0oI;
        double d3 = ((I02 * d) / d2) * 100.0d;
        return new double[]{XIXIX.OOXIXo.f3760XO, ((ooOx2 * d) / d2) * 100.0d, d3, 1.5d * d3};
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        double d;
        double Ioxxx2 = Ioxxx();
        if (oOoXoXO()) {
            d = (0.2943492829799652d - (0.43206900358200073d * Ioxxx2)) + (Ioxxx2 * Ioxxx2 * 0.183098703622818d);
        } else {
            d = (Ioxxx2 * 3.5235164165496826d) - 4.886061191558838d;
        }
        double d2 = d + 0.5d;
        double d3 = this.f982oxoX;
        if ((d3 >= 35.0d && d3 <= 55.0d) || d3 >= 77.0d) {
            d2 += 1.0d;
        }
        int i = (int) d2;
        if (i < 0) {
            i = 0;
        } else if (i > 300) {
            i = 300;
        }
        return i / 10;
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0xO0oo() {
        double d;
        double ooOx2 = ooOx();
        double I02 = I0();
        if (oOoXoXO()) {
            d = 0.597d;
        } else {
            d = 0.543d;
        }
        double d2 = this.f978oIX0oI;
        double d3 = ((I02 * d) / d2) * 100.0d;
        return new double[]{XIXIX.OOXIXo.f3760XO, ((ooOx2 * d) / d2) * 100.0d, d3, 1.5d * d3};
    }

    @Override // Ix0x.II0XooXoX
    public double[] xXOx() {
        double d;
        double d2;
        double d3 = this.f978oIX0oI + 0.005d;
        if (oOoXoXO()) {
            if (d3 >= 60.0d) {
                if (d3 >= 75.0d) {
                    d = 3.1d;
                    d2 = 3.3d;
                } else {
                    d = 2.8d;
                    d2 = 3.0d;
                }
            }
            d = 2.4d;
            d2 = 2.6d;
        } else if (d3 < 45.0d) {
            d = 1.7d;
            d2 = 1.9d;
        } else {
            if (d3 < 60.0d) {
                d = 2.1d;
                d2 = 2.3d;
            }
            d = 2.4d;
            d2 = 2.6d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        if (r0 > 17.5d) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        return com.vtrump.vtble.Scale.ScaleInfo.c.VT_OBESITY_LEVEL_LIGHT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return com.vtrump.vtble.Scale.ScaleInfo.c.VT_OBESITY_LEVEL_OVERWEIGHT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        if (r0 > 17.5d) goto L27;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.vtrump.vtble.Scale.ScaleInfo.c xoIxX() {
        /*
            r11 = this;
            double r0 = r11.oX()
            boolean r2 = r11.oOoXoXO()
            r3 = 4625619029774565376(0x4031800000000000, double:17.5)
            r5 = 4627307879634829312(0x4037800000000000, double:23.5)
            r7 = 4629137466983448576(0x403e000000000000, double:30.0)
            if (r2 != 0) goto L2c
            r9 = 4631107791820423168(0x4045000000000000, double:42.0)
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 <= 0) goto L1d
            goto L32
        L1d:
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 <= 0) goto L22
            goto L39
        L22:
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L27
            goto L40
        L27:
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 <= 0) goto L4a
            goto L47
        L2c:
            r9 = 4630826316843712512(0x4044000000000000, double:40.0)
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 <= 0) goto L35
        L32:
            com.vtrump.vtble.Scale.ScaleInfo$c r0 = com.vtrump.vtble.Scale.ScaleInfo.c.VT_OBESITY_LEVEL_SEVERE
            goto L4c
        L35:
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 <= 0) goto L3c
        L39:
            com.vtrump.vtble.Scale.ScaleInfo$c r0 = com.vtrump.vtble.Scale.ScaleInfo.c.VT_OBESITY_LEVEL_MODERATE
            goto L4c
        L3c:
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L43
        L40:
            com.vtrump.vtble.Scale.ScaleInfo$c r0 = com.vtrump.vtble.Scale.ScaleInfo.c.VT_OBESITY_LEVEL_MILD
            goto L4c
        L43:
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 <= 0) goto L4a
        L47:
            com.vtrump.vtble.Scale.ScaleInfo$c r0 = com.vtrump.vtble.Scale.ScaleInfo.c.VT_OBESITY_LEVEL_OVERWEIGHT
            goto L4c
        L4a:
            com.vtrump.vtble.Scale.ScaleInfo$c r0 = com.vtrump.vtble.Scale.ScaleInfo.c.VT_OBESITY_LEVEL_LIGHT
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.ooOOo0oXI.xoIxX():com.vtrump.vtble.Scale.ScaleInfo$c");
    }

    @Override // Ix0x.II0XooXoX
    public double[] xoXoI() {
        double d;
        double ooOx2 = ooOx();
        double I02 = I0();
        if (oOoXoXO()) {
            d = 0.796d;
        } else {
            d = 0.724d;
        }
        double d2 = I02 * d;
        return new double[]{XIXIX.OOXIXo.f3760XO, ooOx2 * d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double xoxXI() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = this.f978oIX0oI;
            d2 = 0.2d;
        } else {
            d = this.f978oIX0oI;
            d2 = 0.28d;
        }
        double d3 = d * d2;
        double oxoX2 = oxoX();
        if (oxoX2 > d3) {
            return oxoX2 - d3;
        }
        return XIXIX.OOXIXo.f3760XO;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIO() {
        return (X0o0xo() / this.f978oIX0oI) * 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        return this.f978oIX0oI - OO();
    }
}
