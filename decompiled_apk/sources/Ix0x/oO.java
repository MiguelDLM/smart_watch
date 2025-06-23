package Ix0x;

import com.vtrump.vtble.Scale.ScaleInfo;

/* loaded from: classes13.dex */
public class oO extends II0XooXoX {

    /* renamed from: xoXoI, reason: collision with root package name */
    public static oO f1007xoXoI;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public double f1008IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public float f1009IXxxXO = 1.0E-6f;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public double f1010Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public double f1011OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public double f1012oI0IIXIo;

    private double I0() {
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

    private double IIxOXoOo0() {
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

    public static oO OOXIxO0() {
        oO oOVar = f1007xoXoI;
        if (oOVar == null) {
            oO oOVar2 = new oO();
            f1007xoXoI = oOVar2;
            return oOVar2;
        }
        return oOVar;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        double d;
        double d2;
        double d3;
        if (oOoXoXO()) {
            d = ((this.f982oxoX * 0.012199999764561653d) - 1.2267999649047852d) + (this.f973II0xO0 * 0.01899999938905239d) + (this.f978oIX0oI * 0.03460000082850456d) + (this.f1010Oxx0xo * (-0.12200000137090683d)) + (this.f1012oI0IIXIo * (-6.000000284984708E-4d)) + (this.f1011OxxIIOOXO * (-0.047600001096725464d));
            d2 = this.f1008IIXOooo;
            d3 = -0.0010999999940395355d;
        } else {
            d = ((this.f982oxoX * (-0.003000000026077032d)) - 3.234499931335449d) + (this.f973II0xO0 * 0.06440000236034393d) + (this.f978oIX0oI * (-0.020500000566244125d)) + (this.f1010Oxx0xo * 0.8513000011444092d) + (this.f1012oI0IIXIo * (-0.010999999940395355d)) + (this.f1011OxxIIOOXO * (-0.020899999886751175d));
            d2 = this.f1008IIXOooo;
            d3 = -0.0038999998942017555d;
        }
        float f = (float) (d + (d2 * d3));
        if (OOXIXo()) {
            f *= 1.1f;
        }
        float f2 = f - 1.0f;
        float f3 = this.f1009IXxxXO;
        if (f2 < f3) {
            f = 1.0f;
        } else if (f - 4.0f > (-f3)) {
            f = 4.0f;
        }
        return f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
    
        if (r0 < r2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        r0 = r0 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r0 = 10.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0060, code lost:
    
        if (r0 < r2) goto L24;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int I0X0x0oIo() {
        /*
            r14 = this;
            r0 = 13
            r1 = 30
            r2 = 31
            int[] r3 = new int[r1]
            r3 = {x0092: FILL_ARRAY_DATA , data: [3, 6, 9, 11, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 33, 35, 37, 39, 41, 44, 47, 50} // fill-array
            r4 = 0
            int[] r5 = new int[r2]
            r5 = {x00d2: FILL_ARRAY_DATA , data: [13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 16} // fill-array
            int[] r6 = new int[r1]
            r6 = {x0114: FILL_ARRAY_DATA , data: [3, 6, 9, 11, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 33, 35, 37, 39, 41, 44, 47, 50} // fill-array
            int[] r2 = new int[r2]
            r2 = {x0154: FILL_ARRAY_DATA , data: [12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 17} // fill-array
            double r7 = r14.Ioxxx()
            boolean r9 = r14.oOoXoXO()
            r10 = 4621819117588971520(0x4024000000000000, double:10.0)
            if (r9 != 0) goto L4a
        L27:
            if (r4 >= r1) goto L34
            r2 = r3[r4]
            double r12 = (double) r2
            int r2 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r2 >= 0) goto L31
            goto L34
        L31:
            int r4 = r4 + 1
            goto L27
        L34:
            if (r4 >= r0) goto L43
            double r0 = r14.f982oxoX
            r2 = r5[r4]
            double r3 = (double) r2
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L40
            goto L62
        L40:
            double r2 = (double) r2
            double r0 = r0 - r2
            goto L69
        L43:
            double r0 = r14.f982oxoX
            r2 = r5[r4]
        L47:
            double r2 = (double) r2
            double r0 = r0 + r2
            goto L69
        L4a:
            if (r4 >= r1) goto L57
            r3 = r6[r4]
            double r12 = (double) r3
            int r3 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r3 >= 0) goto L54
            goto L57
        L54:
            int r4 = r4 + 1
            goto L4a
        L57:
            if (r4 >= r0) goto L64
            double r0 = r14.f982oxoX
            r2 = r2[r4]
            double r3 = (double) r2
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L40
        L62:
            r0 = r10
            goto L69
        L64:
            double r0 = r14.f982oxoX
            r2 = r2[r4]
            goto L47
        L69:
            boolean r2 = r14.OOXIXo()
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r2 == 0) goto L72
            double r0 = r0 - r3
        L72:
            r5 = 4635329916471083008(0x4054000000000000, double:80.0)
            double r5 = r0 - r5
            float r2 = r14.f1009IXxxXO
            double r7 = (double) r2
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L7f
            double r5 = r5 / r3
            double r0 = r0 - r5
        L7f:
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 >= 0) goto L84
            goto L85
        L84:
            r10 = r0
        L85:
            r0 = 4636666922610458624(0x4058c00000000000, double:99.0)
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 <= 0) goto L8f
            r10 = r0
        L8f:
            int r0 = (int) r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oO.I0X0x0oIo():int");
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        return this.f978oIX0oI - oxoX();
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return (ox() * this.f978oIX0oI) / 100.0d;
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

    @Override // Ix0x.II0XooXoX
    public double[] Io() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 18.5d, 24.0d, 28.0d, 42.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = 1.0d;
        double d3 = this.f982oxoX;
        if (oOoXoXO2) {
            d = (d3 * (-0.0215000007301569d)) + 132.77499389648438d + (this.f973II0xO0 * (-0.9190000295639038d)) + (this.f978oIX0oI * 0.49070000648498535d) + (this.f1010Oxx0xo * (-29.01099967956543d)) + (this.f1012oI0IIXIo * 0.1784999966621399d) + (this.f1011OxxIIOOXO * 0.3840999901294708d) + (this.f1008IIXOooo * 0.01730000041425228d);
        } else {
            double d4 = (d3 * 0.0071000000461936d) + 251.07400512695312d + (this.f973II0xO0 * (-1.712399959564209d)) + (this.f978oIX0oI * 0.5210999846458435d) + (this.f1010Oxx0xo * (-63.89699935913086d)) + (this.f1012oI0IIXIo * 0.41780000925064087d) + (this.f1011OxxIIOOXO * 0.5978999733924866d) + (this.f1008IIXOooo * 0.06080000102519989d);
            double oX2 = (float) ((1.8680000305175781d - (oX() * 0.400299996137619d)) + (oX() * 0.02167000062763691d * oX()));
            if (oX() - 16.0d > this.f1009IXxxXO) {
                oX2 = 1.0d;
            }
            d = d4 * oX2;
        }
        if (OOXIXo()) {
            double d5 = (float) ((1.1449999809265137d - (this.f973II0xO0 * 0.001167000038549304d)) - (this.f978oIX0oI * 0.0020310000982135534d));
            if (d5 - 1.0d <= this.f1009IXxxXO) {
                d2 = d5;
            }
            d *= d2;
        }
        double d6 = 5.0d;
        if (d - 5.0d >= this.f1009IXxxXO) {
            d6 = 70.0d;
            if (d - 70.0d <= (-r2)) {
                return d;
            }
        }
        return d6;
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        double d;
        double Ioxxx2 = Ioxxx();
        if (Ioxxx2 == -1.0d) {
            return -1.0d;
        }
        if (oOoXoXO()) {
            d = 0.72d;
        } else {
            d = 0.6d;
        }
        double d2 = Ioxxx2 * d;
        if (OOXIXo()) {
            d2 *= 0.800000011920929d;
        }
        if (d2 - 3.0d < this.f1009IXxxXO) {
            return 3.0d;
        }
        return d2;
    }

    @Override // Ix0x.II0XooXoX
    public double[] O0xOxO() {
        double d;
        double d2;
        double d3 = this.f973II0xO0 / 100.0d;
        if (OOXIXo()) {
            d = 1.0d;
        } else {
            d = 0.0d;
        }
        double d4 = d3 * d3;
        double d5 = 18.5d * d4;
        double d6 = d4 * (d + 24.0d);
        if (oOoXoXO()) {
            d2 = 0.597000002861023d;
        } else {
            d2 = 0.543d;
        }
        double d7 = d6 * d2;
        return new double[]{XIXIX.OOXIXo.f3760XO, d5 * d2, d7, 1.5d * d7};
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        double d;
        double d2 = this.f973II0xO0 / 100.0d;
        if (OOXIXo()) {
            d = 1.0d;
        } else {
            d = XIXIX.OOXIXo.f3760XO;
        }
        return d2 * d2 * (d + 42.5d) * 0.5d;
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        double d;
        double I02 = I0();
        IIxOXoOo0();
        if (oOoXoXO()) {
            d = 0.796d;
        } else {
            d = 0.724d;
        }
        double d2 = I02 * d;
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
        double d;
        double d2 = this.f973II0xO0 / 100.0d;
        if (OOXIXo()) {
            d = 1.0d;
        } else {
            d = 0.0d;
        }
        double d3 = d2 * d2;
        double d4 = 18.5d * d3;
        double d5 = d3 * (d + 24.0d);
        return new double[]{XIXIX.OOXIXo.f3760XO, d4, d5, 1.5d * d5};
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return X0o0xo() * 0.71d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxxIIOOXO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 10.0d, 14.0d, 21.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        return (this.f978oIX0oI - oxoX()) - I0Io();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00e1, code lost:
    
        if ((r0 - 100.0d) > (-r6)) goto L15;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int XI0oooXX() {
        /*
            r11 = this;
            boolean r0 = r11.oOoXoXO()
            if (r0 == 0) goto L52
            double r0 = r11.f982oxoX
            r2 = 4571838168924413755(0x3f726e978d4fdf3b, double:0.0045)
            double r0 = r0 * r2
            r2 = -4583271893584633135(0xc064f27ef9db22d1, double:-167.578)
            double r0 = r0 + r2
            double r2 = r11.f973II0xO0
            r4 = 4608653294438316612(0x3ff539c0ebedfa44, double:1.3266)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f978oIX0oI
            r4 = -4623970036771003669(0xbfd45bc01a36e2eb, double:-0.3181)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f1010Oxx0xo
            r4 = 4634257869764159550(0x405030faacd9e83e, double:64.7653)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f1012oI0IIXIo
            r4 = -4624910388373198628(0xbfd104816f0068dc, double:-0.2659)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f1011OxxIIOOXO
            r4 = -4628669993342127519(0xbfc3a92a30553261, double:-0.1536)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f1008IIXOooo
            r4 = -4637821307784944366(0xbfa32617c1bda512, double:-0.0374)
        L4e:
            double r2 = r2 * r4
            double r0 = r0 + r2
            goto L9b
        L52:
            double r0 = r11.f982oxoX
            r2 = 4602884183315655007(0x3fe0bac710cb295f, double:0.5228)
            double r0 = r0 * r2
            r2 = -4576430925750657352(0xc07d4051eb851eb8, double:-468.02)
            double r0 = r0 + r2
            double r2 = r11.f973II0xO0
            r4 = 4614307113410517533(0x40094fdf3b645a1d, double:3.164)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f978oIX0oI
            r4 = 4602491469428148299(0x3fdf559b3d07c84b, double:0.4896)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f1010Oxx0xo
            r4 = 4640136172067161637(0x4065134395810625, double:168.602)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f1012oI0IIXIo
            r4 = -4616343641162014471(0xbfef73eab367a0f9, double:-0.9829)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f1011OxxIIOOXO
            r4 = -4610850150336547940(0xc002f837b4a2339c, double:-2.3712)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r11.f1008IIXOooo
            r4 = -4628334925529851154(0xbfc4d9e83e425aee, double:-0.1629)
            goto L4e
        L9b:
            boolean r2 = r11.OOXIXo()
            if (r2 == 0) goto Lc9
            double r2 = r11.f973II0xO0
            r4 = 4563024660482446714(0x3f531ec0b567557a, double:0.001167)
            double r2 = r2 * r4
            r4 = 4605876375079878656(0x3feb5c2900000000, double:0.8550000190734863)
            double r2 = r2 + r4
            double r4 = r11.f978oIX0oI
            r6 = 4566829589678025460(0x3f60a350d2806af4, double:0.002031)
            double r4 = r4 * r6
            double r2 = r2 + r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r6 = r2 - r4
            float r8 = r11.f1009IXxxXO
            float r8 = -r8
            double r8 = (double) r8
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto Lc7
            r2 = r4
        Lc7:
            double r0 = r0 * r2
        Lc9:
            r2 = 4631530004285489152(0x4046800000000000, double:45.0)
            double r4 = r0 - r2
            float r6 = r11.f1009IXxxXO
            double r7 = (double) r6
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 >= 0) goto Ld9
        Ld7:
            r0 = r2
            goto Le4
        Ld9:
            r2 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r0 - r2
            float r6 = -r6
            double r6 = (double) r6
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto Le4
            goto Ld7
        Le4:
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r0 = r0 + r2
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oO.XI0oooXX():int");
    }

    @Override // Ix0x.II0XooXoX
    public double XO() {
        return (XX0xXo() * this.f978oIX0oI) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] XOxIOxOx() {
        double d = this.f978oIX0oI;
        double d2 = 0.541d * d;
        double d3 = d * 0.66d;
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, d3, 1.5d * d3};
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x014e, code lost:
    
        r3 = r3 * r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x014c, code lost:
    
        if ((r5 - 1.0d) < (-r13.f1009IXxxXO)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e4, code lost:
    
        r7 = 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e2, code lost:
    
        if ((r5 - 30.0d) > r13.f1009IXxxXO) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0076, code lost:
    
        if ((r5 - 50.0d) > r13.f1009IXxxXO) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0118, code lost:
    
        if ((r5 - 1.0d) < (-r13.f1009IXxxXO)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x011b, code lost:
    
        r1 = r5;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double XX0xXo() {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oO.XX0xXo():double");
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
        double d8 = d3 - (((d2 * d4) / d) / d);
        if (OOXIXo()) {
            double d9 = this.f973II0xO0;
            double d10 = this.f978oIX0oI;
            double d11 = ((1.097000002861023d - (4.710000066552311E-4d * d9)) + (0.0015940000303089619d * d10)) - ((0.15940000116825104d * d10) / d9);
            double d12 = d11 - 1.0d;
            float f = this.f1009IXxxXO;
            if (d12 < (-f) || d10 - 30.0d < f) {
                d11 = 1.0d;
            }
            d8 *= d11;
        }
        if (d8 < 400.0d) {
            d8 = 400.0d;
        }
        if (d8 > 3500.0d) {
            d8 = 3500.0d;
        }
        return (int) (d8 + 0.5d);
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
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oO.XoI0Ixx0():com.vtrump.vtble.Scale.ScaleInfo$a");
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
        if (OOXIXo()) {
            d *= 0.800000011920929d;
            d2 *= 0.800000011920929d;
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
    public double oX() {
        double d = this.f973II0xO0;
        double d2 = this.f978oIX0oI;
        this.f1010Oxx0xo = d / d2;
        double d3 = d * d;
        this.f1012oI0IIXIo = d3 / d2;
        double d4 = this.f982oxoX;
        this.f1011OxxIIOOXO = (d4 * d2) / d;
        this.f1008IIXOooo = (d2 * d2) / d4;
        return (d2 * 10000.0d) / d3;
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

    /* JADX WARN: Code restructure failed: missing block: B:21:0x010a, code lost:
    
        r3 = 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0108, code lost:
    
        if ((r9 - 50.0d) > r15.f1009IXxxXO) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0087, code lost:
    
        if ((r9 - 40.0d) > r15.f1009IXxxXO) goto L9;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double ox() {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oO.ox():double");
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxXx0IX() {
        short s;
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f982oxoX;
        double d2 = d - 18.0d;
        if (oOoXoXO2) {
            float f = this.f1009IXxxXO;
            if (d2 < f) {
                s = 1620;
            } else {
                double d3 = -f;
                if (d - 30.0d < d3) {
                    s = 1560;
                } else if (d - 50.0d < d3) {
                    s = 1561;
                } else if (d - 70.0d < d3) {
                    s = 1501;
                } else {
                    s = 1398;
                }
            }
        } else {
            float f2 = this.f1009IXxxXO;
            if (d2 < f2) {
                s = 1265;
            } else {
                double d4 = -f2;
                if (d - 30.0d < d4) {
                    s = 1298;
                } else if (d - 50.0d < d4) {
                    s = 1302;
                } else if (d - 70.0d < d4) {
                    s = 1242;
                } else {
                    s = 1035;
                }
            }
        }
        if (OOXIXo()) {
            double d5 = this.f973II0xO0;
            double d6 = this.f978oIX0oI;
            double d7 = ((1.097000002861023d - (4.710000066552311E-4d * d5)) + (0.0015940000303089619d * d6)) - ((0.15940000116825104d * d6) / d5);
            double d8 = d7 - 1.0d;
            double d9 = this.f1009IXxxXO;
            if (d8 < d9 || d6 - 30.0d < d9) {
                d7 = 1.0d;
            }
            s = (short) (s * d7);
        }
        double d10 = s;
        return new double[]{XIXIX.OOXIXo.f3760XO, d10, 1.5d * d10};
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxxXoxO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 18.5d, 25.0d, 30.0d, 45.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0XOIxOo() {
        return x0o(xoXoI());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00f4, code lost:
    
        r4 = 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00f2, code lost:
    
        if ((oX() - 19.0d) > r18.f1009IXxxXO) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0086, code lost:
    
        if ((oX() - 19.0d) > r18.f1009IXxxXO) goto L9;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int x0xO() {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oO.x0xO():int");
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0xO0oo() {
        return x0o(O0xOxO());
    }

    @Override // Ix0x.II0XooXoX
    public double[] xXOx() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = this.f978oIX0oI;
            d2 = 0.045d;
        } else {
            d = this.f978oIX0oI;
            d2 = 0.044d;
        }
        double d3 = d * d2;
        return new double[]{XIXIX.OOXIXo.f3760XO, d3, 1.5d * d3};
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
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oO.xoIxX():com.vtrump.vtble.Scale.ScaleInfo$c");
    }

    @Override // Ix0x.II0XooXoX
    public double[] xoXoI() {
        double d;
        double d2;
        double d3 = this.f973II0xO0 / 100.0d;
        if (OOXIXo()) {
            d = 1.0d;
        } else {
            d = 0.0d;
        }
        double d4 = d3 * d3;
        double d5 = 18.5d * d4;
        double d6 = d4 * (d + 24.0d);
        if (oOoXoXO()) {
            d2 = 0.796d;
        } else {
            d2 = 0.724d;
        }
        double d7 = d6 * d2;
        return new double[]{XIXIX.OOXIXo.f3760XO, d5 * d2, d7, 1.5d * d7};
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
        double d = 1.100000023841858d;
        if (this.f978oIX0oI - (OO() * 1.100000023841858d) <= this.f1009IXxxXO) {
            d = 0.8999999761581421d;
            if (this.f978oIX0oI - (OO() * 0.8999999761581421d) >= (-this.f1009IXxxXO)) {
                return XIXIX.OOXIXo.f3760XO;
            }
        }
        return this.f978oIX0oI - (OO() * d);
    }
}
