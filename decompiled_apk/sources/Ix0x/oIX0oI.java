package Ix0x;

import com.garmin.fit.OxXXx0X;
import com.vtrump.vtble.Scale.ScaleInfo;

/* loaded from: classes13.dex */
public class oIX0oI extends II0XooXoX {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static oIX0oI f1006IXxxXO;

    public static oIX0oI OOXIxO0() {
        oIX0oI oix0oi = f1006IXxxXO;
        if (oix0oi == null) {
            oIX0oI oix0oi2 = new oIX0oI();
            f1006IXxxXO = oix0oi2;
            return oix0oi2;
        }
        return oix0oi;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        int i;
        int i2;
        if (oOoXoXO()) {
            i = 5;
            i2 = 320000;
        } else {
            i = 8;
            i2 = 290000;
        }
        return (((((((oX() * 10.0d) - 30.0d) * 1445.0d) + ((1000.0d - (Math.abs(this.f982oxoX - 30.0d) * i)) * 18800.0d)) - i2) / 40000.0d) * this.f978oIX0oI) / 10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public int I0X0x0oIo() {
        double d;
        double d2;
        double pow = ((Math.pow(this.f978oIX0oI, 0.4440000057220459d) * Math.pow(this.f973II0xO0, 0.6629999876022339d)) * 88.83000183105469d) / 10000.0d;
        double Ioxxx2 = Ioxxx();
        double d3 = 0.10000000149011612d;
        double d4 = ((1.0d - (Ioxxx2 / 100.0d)) * this.f978oIX0oI) / pow;
        if (oOoXoXO()) {
            d = (34.667999267578125d - d4) / 0.10000000149011612d;
            d2 = (Ioxxx2 - 10.739999771118164d) / 0.258899986743927d;
            d3 = 0.20000000298023224d;
        } else {
            d = (28.746000289916992d - d4) / 0.03200000151991844d;
            d2 = (Ioxxx2 - 21.989999771118164d) / 0.09700000286102295d;
        }
        return (int) (((1.0d - d3) * this.f982oxoX) + ((d3 * (d + d2)) / 2.0d));
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        return (this.f978oIX0oI * (100.0d - Ioxxx())) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return (this.f978oIX0oI * this.f983x0XOIxOo.oO()) / 100.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        if (r7 <= 2.0d) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double Ioxxx() {
        /*
            r11 = this;
            int r0 = r11.f971I0Io
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r3 = 0
            goto Ld
        Lb:
            r3 = 30
        Ld:
            r4 = 45
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L15
            if (r0 != r5) goto L17
        L15:
            r3 = 45
        L17:
            if (r0 != 0) goto L1c
            r1 = 100
            goto L2a
        L1c:
            if (r0 != r1) goto L1f
            goto L2a
        L1f:
            if (r0 != r6) goto L24
            r1 = 120(0x78, float:1.68E-43)
            goto L2a
        L24:
            if (r0 != r5) goto L29
            r1 = 45
            goto L2a
        L29:
            r1 = 0
        L2a:
            boolean r0 = r11.oOoXoXO()
            if (r0 == 0) goto L36
            r4 = 4627026404658118656(0x4036800000000000, double:22.5)
            goto L3c
        L36:
            r4 = 4629770785681047552(0x4040400000000000, double:32.5)
            r6 = 4
        L3c:
            double r7 = r11.oX()
            r9 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r7 = r7 * r9
            double r2 = (double) r3
            double r7 = r7 - r2
            r2 = 4609164002893758464(0x3ff70a3d80000000, double:1.440000057220459)
            double r7 = r7 * r2
            double r0 = (double) r1
            double r7 = r7 - r0
            double r0 = r11.f982oxoX
            r2 = 4627730092099895296(0x4039000000000000, double:25.0)
            double r0 = r0 - r2
            double r0 = java.lang.Math.abs(r0)
            double r7 = r7 + r0
            r0 = 4622382067542392832(0x4026000000000000, double:11.0)
            double r7 = r7 / r0
            r0 = 4632233691727265792(0x4049000000000000, double:50.0)
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 < 0) goto L64
        L62:
            r7 = r0
            goto L7a
        L64:
            r0 = 4616189618054758400(0x4010000000000000, double:4.0)
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 > 0) goto L6b
            goto L62
        L6b:
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 >= 0) goto L7a
            double r4 = r4 - r7
            double r0 = (double) r6
            double r4 = r4 / r0
            double r7 = r7 - r4
            r0 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 > 0) goto L7a
            goto L62
        L7a:
            r0 = 0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 <= 0) goto L81
            goto L82
        L81:
            r7 = r0
        L82:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oIX0oI.Ioxxx():double");
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        return (1.0f - (x0xO() * 0.0267f)) * Ioxxx();
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        double d;
        if (oOoXoXO()) {
            d = 24.200000762939453d;
        } else {
            d = XIXIX.OOXIXo.f3760XO;
        }
        if (!oOoXoXO()) {
            d = 20.0d;
        }
        double d2 = this.f973II0xO0;
        return ((d * d2) * d2) / 10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        double d;
        double d2;
        if (Ioxxx() == XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        if (oOoXoXO()) {
            if (this.f982oxoX < 18.0d) {
                d = this.f978oIX0oI;
                d2 = 0.3d;
            }
            d = this.f978oIX0oI;
            d2 = 0.25d;
        } else {
            if (this.f982oxoX >= 18.0d) {
                d = this.f978oIX0oI;
                d2 = 0.2d;
            }
            d = this.f978oIX0oI;
            d2 = 0.25d;
        }
        double d3 = d * d2;
        if (X0o0xo() >= d3) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return X0o0xo() - d3;
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return X0o0xo() * 0.7099999785423279d;
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        return (this.f978oIX0oI * this.f983x0XOIxOo.oIX0oI()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public int XI0oooXX() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double oX2 = oX();
        double d11 = XIXIX.OOXIXo.f3760XO;
        double d12 = 16.0d;
        double d13 = 18.5d;
        if (oX2 <= 18.5d) {
            d3 = 0.0d;
            d = 50.0d;
            d2 = 34.0d;
        } else if (oX2 < 25.0d) {
            d = 84.0d;
            d2 = 16.0d;
            d13 = 22.0d;
            d3 = 18.5d;
        } else {
            d = 30.0d;
            d2 = 54.0d;
            d13 = 25.0d;
            d3 = 0.0d;
        }
        double abs = d + ((1.0d - (Math.abs(d13 - oX2) / Math.abs(d13 - d3))) * d2);
        double Ioxxx2 = Ioxxx();
        double d14 = this.f982oxoX;
        if (d14 >= 10.0d && d14 <= 17.0d) {
            if (Ioxxx2 <= 12.1d) {
                d12 = 12.100000381469727d;
                d9 = 34.0d;
                d8 = 50.0d;
            } else if (Ioxxx2 < 17.0d) {
                d5 = 14.5d;
                d8 = 84.0d;
                d11 = 17.0d;
                d9 = 16.0d;
                d12 = d5;
            } else {
                d8 = 30.0d;
                d9 = 54.0d;
                d12 = 17.0d;
            }
        } else if (d14 > 17.0d && d14 <= 30.0d) {
            d6 = 12.5d;
            if (Ioxxx2 > 12.5d) {
                d7 = 18.0d;
                if (Ioxxx2 < 18.0d) {
                    d8 = 84.0d;
                    d9 = 16.0d;
                    d11 = 18.0d;
                    d12 = 15.0d;
                }
                d12 = d7;
                d8 = 30.0d;
                d9 = 54.0d;
            }
            d12 = d6;
            d9 = 34.0d;
            d8 = 50.0d;
        } else if (d14 > 30.0d && d14 <= 40.0d) {
            if (Ioxxx2 <= 13.1d) {
                d12 = 13.100000381469727d;
                d9 = 34.0d;
                d8 = 50.0d;
            } else {
                d4 = 18.399999618530273d;
                if (Ioxxx2 < 18.4d) {
                    d5 = 15.5d;
                    d11 = d4;
                    d8 = 84.0d;
                    d9 = 16.0d;
                    d12 = d5;
                }
                d9 = 54.0d;
                d12 = d4;
                d8 = 30.0d;
            }
        } else if (d14 > 40.0d && d14 <= 60.0d) {
            d6 = 13.5d;
            if (Ioxxx2 > 13.5d) {
                d7 = 19.0d;
                if (Ioxxx2 < 19.0d) {
                    d11 = 19.0d;
                    d8 = 84.0d;
                    d9 = 16.0d;
                }
                d12 = d7;
                d8 = 30.0d;
                d9 = 54.0d;
            }
            d12 = d6;
            d9 = 34.0d;
            d8 = 50.0d;
        } else if (Ioxxx2 <= 14.1d) {
            d12 = 14.100000381469727d;
            d9 = 34.0d;
            d8 = 50.0d;
        } else {
            d4 = 19.399999618530273d;
            if (Ioxxx2 < 19.4d) {
                d5 = 16.5d;
                d11 = d4;
                d8 = 84.0d;
                d9 = 16.0d;
                d12 = d5;
            }
            d9 = 54.0d;
            d12 = d4;
            d8 = 30.0d;
        }
        double abs2 = (abs * 0.5d) + ((d8 + ((1.0d - (Math.abs(d12 - Ioxxx2) / Math.abs(d12 - d11))) * d9)) * 0.5d);
        if (abs2 > 100.0d) {
            abs2 = 100.0d;
        }
        if (abs2 < 10.0d) {
            d10 = 10.0d;
        } else {
            d10 = abs2;
        }
        return (int) d10;
    }

    @Override // Ix0x.II0XooXoX
    public double XO() {
        return -10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return xxIO() * 0.6499999761581421d;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        int i;
        int i2;
        int i3;
        int i4;
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d2 <= 17.0d) {
                i = 166;
                i2 = 77;
                i3 = 57200;
            } else if (d2 > 17.0d && d2 <= 29.0d) {
                i = 154;
                i2 = 27;
                i3 = 71700;
            } else if (d2 > 29.0d && d2 <= 59.0d) {
                i = 113;
                i2 = 16;
                i3 = 90100;
            } else {
                i = 88;
                i2 = 1128;
                i3 = 107100;
            }
            i4 = 108;
        } else {
            if (d2 <= 17.0d) {
                i = 74;
                i2 = 482;
                i3 = 21700;
            } else if (d2 > 17.0d && d2 <= 29.0d) {
                i = 133;
                i2 = 334;
                i3 = OxXXx0X.f13024OIII0O;
            } else if (d2 > 29.0d && d2 <= 59.0d) {
                i = 87;
                i2 = 25;
                i3 = 86500;
            } else {
                i = 92;
                i2 = 637;
                i3 = 30200;
            }
            i4 = 93;
        }
        double d3 = (i * 10 * this.f978oIX0oI) + (this.f973II0xO0 * i2);
        double d4 = i3;
        if (this.f982oxoX < 60.0d) {
            d = d3 + d4;
        } else {
            d = d3 - d4;
        }
        return (int) (d / i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0062, code lost:
    
        if (r1 <= 22.0d) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x00d4, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0075, code lost:
    
        if (r1 <= 24.0d) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x008c, code lost:
    
        if (r1 <= 33.0d) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x00a6, code lost:
    
        if (r1 <= 34.0d) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x00c1, code lost:
    
        if (r1 <= 35.0d) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00d2, code lost:
    
        if (r1 <= 36.0d) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00fc, code lost:
    
        if (r3 <= 75.0d) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0135, code lost:
    
        r2 = 1;
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x010a, code lost:
    
        if (r3 <= 55.0d) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0121, code lost:
    
        if (r3 <= 65.0d) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0133, code lost:
    
        if (r3 <= 55.0d) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0048, code lost:
    
        if (r1 <= 21.0d) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        if (r1 <= 21.0d) goto L85;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.vtrump.vtble.Scale.ScaleInfo.a XoI0Ixx0() {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oIX0oI.XoI0Ixx0():com.vtrump.vtble.Scale.ScaleInfo$a");
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.b oIX0oI() {
        double oX2 = oX();
        if (oX2 <= 16.0d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_SEVERELY_MALNUTRITION;
        }
        if (oX2 > 16.0d && oX2 <= 17.5d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_MODERATE_MALNUTRITION;
        }
        if (oX2 > 17.5d && oX2 <= 18.5d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_MALNUTRITION;
        }
        if (oX2 > 18.5d && oX2 <= 24.0d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_NORMAL;
        }
        if (oX2 > 24.0d && oX2 <= 28.0d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_OVERNUTRITION;
        }
        if (oX2 > 28.0d) {
            return ScaleInfo.b.VT_NUTRITRUE_STATE_SEVERLY_OVERNUTRITION;
        }
        return ScaleInfo.b.VT_NUTRITRUE_STATE_ERROR;
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        int i;
        if (oOoXoXO()) {
            i = 725;
        } else {
            i = 0;
        }
        if (!oOoXoXO()) {
            i = 772;
        }
        double Ioxxx2 = Ioxxx();
        if (Ioxxx2 <= 0.01d) {
            Ioxxx2 = Ioxxx();
        }
        return ((((((oX() * 10.0d) - 30.0d) * 0.289000004529953d) + i) - ((this.f982oxoX + 30.0d) / 2.0d)) / 10.0d) - Ioxxx2;
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        return (this.f978oIX0oI * this.f983x0XOIxOo.Oxx()) / 100.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int x0xO() {
        /*
            r13 = this;
            boolean r0 = r13.oOoXoXO()
            if (r0 == 0) goto Lc
            r0 = 15
            r1 = 90000(0x15f90, float:1.26117E-40)
            goto Lf
        Lc:
            r0 = 18
            r1 = 0
        Lf:
            double r2 = r13.oX()
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r2 = r2 * r4
            double r4 = r13.oX()
            double r2 = r2 * r4
            double r4 = (double) r0
            double r2 = r2 * r4
            int r0 = (int) r2
            double r2 = (double) r0
            double r4 = r13.f982oxoX
            r6 = 4654311885213007872(0x4097700000000000, double:1500.0)
            double r4 = r4 * r6
            double r2 = r2 + r4
            double r0 = (double) r1
            double r2 = r2 - r0
            r0 = 0
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 < 0) goto L3b
            r4 = 4681608360884174848(0x40f86a0000000000, double:100000.0)
            double r2 = r2 / r4
            goto L3c
        L3b:
            r2 = r0
        L3c:
            double r4 = r13.Ioxxx()
            r6 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r8 = r4 * r6
            double r10 = r2 * r6
            double r8 = r8 - r10
            r10 = 4627898977085921690(0x403999999999999a, double:25.6)
            int r12 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r12 < 0) goto L51
            goto L62
        L51:
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r12 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r12 < 0) goto L5e
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 > 0) goto L5e
            double r2 = r2 - r10
        L5c:
            int r0 = (int) r2
            goto L69
        L5e:
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 <= 0) goto L63
        L62:
            goto L5c
        L63:
            double r0 = java.lang.Math.floor(r4)
            double r0 = r0 - r10
            int r0 = (int) r0
        L69:
            r1 = 1
            if (r0 >= r1) goto L6d
            r0 = 1
        L6d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oIX0oI.x0xO():int");
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
                if (d2 > 17.0d && d2 <= 30.0d) {
                    d = 18.0d;
                } else if (d2 > 30.0d && d2 <= 40.0d) {
                    d = 18.399999618530273d;
                } else if (d2 > 40.0d && d2 <= 60.0d) {
                    d = 19.0d;
                } else {
                    d = 19.399999618530273d;
                }
            }
        } else if (d2 >= 10.0d && d2 <= 17.0d) {
            d = 22.0d;
        } else if (d2 > 17.0d && d2 <= 30.0d) {
            d = 23.0d;
        } else if (d2 > 30.0d && d2 <= 40.0d) {
            d = 23.399999618530273d;
        } else if (d2 > 40.0d && d2 <= 60.0d) {
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
        double ox2 = ox();
        double d = XIXIX.OOXIXo.f3760XO;
        if (ox2 < 0.01d) {
            return XIXIX.OOXIXo.f3760XO;
        }
        double ox3 = ox();
        double d2 = this.f973II0xO0 * 130.0d;
        double d3 = this.f978oIX0oI;
        double d4 = ox3 - (((d2 + (40.0d * d3)) - 14700.0d) / (d3 * 10.0d));
        if (oOoXoXO()) {
            d = 0.18799999356269836d;
        }
        if (!oOoXoXO()) {
            d = 0.25d;
        }
        return (d4 / 1.0499999523162842d) - ((100.0d - ox()) * d);
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        return this.f978oIX0oI - OO();
    }
}
