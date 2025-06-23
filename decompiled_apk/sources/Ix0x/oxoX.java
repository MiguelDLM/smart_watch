package Ix0x;

import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;

/* loaded from: classes13.dex */
public class oxoX extends II0XooXoX {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static oxoX f1015IXxxXO;

    public static oxoX IIxOXoOo0() {
        oxoX oxox = f1015IXxxXO;
        if (oxox == null) {
            oxoX oxox2 = new oxoX();
            f1015IXxxXO = oxox2;
            return oxox2;
        }
        return oxox;
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
        return (((((((oX() * 10.0d) - 30.0d) * 1445.0d) + ((1000.0d - ((this.f982oxoX - 30.0d) * i)) * 18800.0d)) - i2) / 40000.0d) * this.f978oIX0oI) / 11000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public int I0X0x0oIo() {
        double d = ((((this.f978oIX0oI * 0.444d) * this.f973II0xO0) * 0.663d) * 88.83d) / 10000.0d;
        double oxoX2 = oxoX();
        return (int) ((this.f982oxoX * 0.7d) + ((((((1.0d - (oxoX2 / 80.0d)) * this.f978oIX0oI) / d) + (oxoX2 / 0.20000000298023224d)) * 0.3d) / 2.0d));
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        return X0o0xo() + I0Io();
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return (this.f978oIX0oI * ox()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] IIXOooo() {
        double[] OOXIxO02 = OOXIxO0();
        double d = OOXIxO02[0];
        double d2 = this.f978oIX0oI;
        double d3 = (OOXIxO02[1] * d2) / 100.0d;
        double d4 = (OOXIxO02[2] * d2) / 100.0d;
        double d5 = (OOXIxO02[3] * d2) / 100.0d;
        return new double[]{(d2 * 1.0d) / 100.0d, (d * d2) / 100.0d, d3, d4, d5, 1.5d * d5};
    }

    @Override // Ix0x.II0XooXoX
    public double[] Io() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 18.5d, 25.0d, 30.0d, 45.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        double oX2 = (((oX() * 1.2000000476837158d) + (this.f982oxoX * 0.23d)) - (((this.f971I0Io + 1) % 2) * 10.8d)) - 5.4d;
        if (oX2 <= XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return oX2;
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        return Ioxxx() - (x0xO() * 0.4f);
    }

    @Override // Ix0x.II0XooXoX
    public double[] O0xOxO() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = 49.0d;
            d2 = 59.0d;
        } else {
            d = 40.0d;
            d2 = 50.0d;
        }
        double d3 = this.f978oIX0oI / 100.0d;
        double d4 = d2 * d3;
        return new double[]{XIXIX.OOXIXo.f3760XO, d * d3, d4, 1.5d * d4};
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        double d;
        if (oOoXoXO()) {
            d = 22.8d;
        } else {
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
            double d3 = this.f973II0xO0;
            if (d3 <= 160.0d) {
                d = this.f978oIX0oI;
                d2 = 38.5d;
            } else {
                d = this.f978oIX0oI;
                if (d3 <= 169.0d) {
                    d2 = 44.0d;
                } else {
                    d2 = 49.400001525878906d;
                }
            }
        } else {
            double d4 = this.f973II0xO0;
            if (d4 <= 150.0d) {
                d = this.f978oIX0oI;
                d2 = 29.100000381469727d;
            } else {
                d = this.f978oIX0oI;
                if (d4 <= 159.0d) {
                    d2 = 32.900001525878906d;
                } else {
                    d2 = 36.5d;
                }
            }
        }
        double X0o0xo2 = X0o0xo() - ((d * d2) / 100.0d);
        if (X0o0xo2 > XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return X0o0xo2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x0219, code lost:
    
        if (oOoXoXO() != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02af, code lost:
    
        r0 = 41.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02ac, code lost:
    
        r0 = 28.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0244, code lost:
    
        if (oOoXoXO() != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x02aa, code lost:
    
        if (oOoXoXO() != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0035, code lost:
    
        if (oOoXoXO() != false) goto L242;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double[] OOXIxO0() {
        /*
            Method dump skipped, instructions count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oxoX.OOXIxO0():double[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        r0 = 65.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (oOoXoXO() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (oOoXoXO() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        if (oOoXoXO() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0043, code lost:
    
        r0 = 60.0d;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double[] Oo() {
        /*
            r10 = this;
            double r0 = r10.f982oxoX
            r2 = 4618441417868443648(0x4018000000000000, double:6.0)
            r4 = 4631530004285489152(0x4046800000000000, double:45.0)
            r6 = 4632937379169042432(0x404b800000000000, double:55.0)
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 >= 0) goto L20
            boolean r0 = r10.oOoXoXO()
            if (r0 == 0) goto L19
            r4 = r6
        L19:
            boolean r0 = r10.oOoXoXO()
            if (r0 == 0) goto L43
            goto L3d
        L20:
            r2 = 4635329916471083008(0x4054000000000000, double:80.0)
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            boolean r0 = r10.oOoXoXO()
            if (r8 > 0) goto L34
            if (r0 == 0) goto L2d
            r4 = r6
        L2d:
            boolean r0 = r10.oOoXoXO()
            if (r0 == 0) goto L43
            goto L3d
        L34:
            if (r0 == 0) goto L37
            r4 = r6
        L37:
            boolean r0 = r10.oOoXoXO()
            if (r0 == 0) goto L43
        L3d:
            r0 = 4634274385308418048(0x4050400000000000, double:65.0)
            goto L45
        L43:
            r0 = 4633641066610819072(0x404e000000000000, double:60.0)
        L45:
            r2 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r2 = r2 * r0
            r6 = 4
            double[] r6 = new double[r6]
            r7 = 0
            r9 = 0
            r6[r9] = r7
            r7 = 1
            r6[r7] = r4
            r4 = 2
            r6[r4] = r0
            r0 = 3
            r6[r0] = r2
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oxoX.Oo():double[]");
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxI() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = this.f973II0xO0 - 80.0d;
            d2 = 0.699999988079071d;
        } else {
            d = this.f973II0xO0 - 70.0d;
            d2 = 0.6000000238418579d;
        }
        double d3 = d * d2;
        double d4 = 0.20000000298023224d * d3;
        double d5 = d3 - d4;
        double d6 = 0.10000000149011612d * d3;
        double d7 = d3 - d6;
        double d8 = d6 + d3;
        double d9 = d3 + d4;
        return new double[]{XIXIX.OOXIXo.f3760XO, d5, d7, d8, d9, 1.5d * d9};
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return X0o0xo() * 0.6800000071525574d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxxIIOOXO() {
        return new double[]{1.0d, 5.0d, 10.0d, 15.0d, 22.5d};
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        double d = this.f978oIX0oI;
        return (d - ((Ioxxx() * d) / 100.0d)) - I0Io();
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
        double oX2 = oX();
        double d10 = 16.0d;
        double d11 = XIXIX.OOXIXo.f3760XO;
        double d12 = 18.5d;
        if (oX2 <= 18.5d) {
            d3 = 0.0d;
            d = 50.0d;
            d2 = 34.0d;
        } else if (oX2 < 25.0d) {
            d = 84.0d;
            d2 = 16.0d;
            d12 = 22.0d;
            d3 = 18.5d;
        } else {
            d = 30.0d;
            d2 = 54.0d;
            d12 = 25.0d;
            d3 = 0.0d;
        }
        double abs = d + ((1.0d - (Math.abs(d12 - oX2) / Math.abs(d12 - d3))) * d2);
        double Ioxxx2 = Ioxxx();
        double d13 = this.f982oxoX;
        double d14 = 10.0d;
        if (d13 >= 10.0d && d13 <= 17.0d) {
            if (Ioxxx2 <= 12.1d) {
                d10 = 12.100000381469727d;
                d9 = 34.0d;
                d8 = 50.0d;
            } else if (Ioxxx2 < 17.0d) {
                d5 = 14.5d;
                d8 = 84.0d;
                d11 = 17.0d;
                d9 = 16.0d;
                d10 = d5;
            } else {
                d8 = 30.0d;
                d9 = 54.0d;
                d10 = 17.0d;
            }
        } else if (d13 > 17.0d && d13 <= 30.0d) {
            d6 = 12.5d;
            if (Ioxxx2 > 12.5d) {
                d7 = 18.0d;
                if (Ioxxx2 < 18.0d) {
                    d11 = 18.0d;
                    d8 = 84.0d;
                    d9 = 16.0d;
                    d10 = 15.0d;
                }
                d10 = d7;
                d8 = 30.0d;
                d9 = 54.0d;
            }
            d10 = d6;
            d9 = 34.0d;
            d8 = 50.0d;
        } else if (d13 > 30.0d && d13 <= 40.0d) {
            if (Ioxxx2 <= 13.1d) {
                d10 = 13.100000381469727d;
                d9 = 34.0d;
                d8 = 50.0d;
            } else {
                d4 = 18.399999618530273d;
                if (Ioxxx2 < 18.4d) {
                    d5 = 15.5d;
                    d11 = d4;
                    d8 = 84.0d;
                    d9 = 16.0d;
                    d10 = d5;
                }
                d9 = 54.0d;
                d10 = d4;
                d8 = 30.0d;
            }
        } else if (d13 > 40.0d && d13 <= 60.0d) {
            d6 = 13.5d;
            if (Ioxxx2 > 13.5d) {
                d7 = 19.0d;
                if (Ioxxx2 < 19.0d) {
                    d11 = 19.0d;
                    d8 = 84.0d;
                    d9 = 16.0d;
                }
                d10 = d7;
                d8 = 30.0d;
                d9 = 54.0d;
            }
            d10 = d6;
            d9 = 34.0d;
            d8 = 50.0d;
        } else if (Ioxxx2 <= 14.1d) {
            d10 = 14.100000381469727d;
            d9 = 34.0d;
            d8 = 50.0d;
        } else {
            d4 = 19.399999618530273d;
            if (Ioxxx2 < 19.4d) {
                d5 = 16.5d;
                d11 = d4;
                d8 = 84.0d;
                d9 = 16.0d;
                d10 = d5;
            }
            d9 = 54.0d;
            d10 = d4;
            d8 = 30.0d;
        }
        double abs2 = (abs * 0.5d) + ((d8 + ((1.0d - (Math.abs(d10 - Ioxxx2) / Math.abs(d10 - d11))) * d9)) * 0.5d);
        if (abs2 > 100.0d) {
            abs2 = 100.0d;
        }
        if (abs2 >= 10.0d) {
            d14 = abs2;
        }
        return (int) Math.round(d14);
    }

    @Override // Ix0x.II0XooXoX
    public double XO() {
        return (XX0xXo() * this.f978oIX0oI) / 100.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        r0 = 65.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (oOoXoXO() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (oOoXoXO() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        if (oOoXoXO() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0043, code lost:
    
        r0 = 60.0d;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double[] XOxIOxOx() {
        /*
            r10 = this;
            double r0 = r10.f982oxoX
            r2 = 4618441417868443648(0x4018000000000000, double:6.0)
            r4 = 4631530004285489152(0x4046800000000000, double:45.0)
            r6 = 4632937379169042432(0x404b800000000000, double:55.0)
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 >= 0) goto L20
            boolean r0 = r10.oOoXoXO()
            if (r0 == 0) goto L19
            r4 = r6
        L19:
            boolean r0 = r10.oOoXoXO()
            if (r0 == 0) goto L43
            goto L3d
        L20:
            r2 = 4635329916471083008(0x4054000000000000, double:80.0)
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            boolean r0 = r10.oOoXoXO()
            if (r8 > 0) goto L34
            if (r0 == 0) goto L2d
            r4 = r6
        L2d:
            boolean r0 = r10.oOoXoXO()
            if (r0 == 0) goto L43
            goto L3d
        L34:
            if (r0 == 0) goto L37
            r4 = r6
        L37:
            boolean r0 = r10.oOoXoXO()
            if (r0 == 0) goto L43
        L3d:
            r0 = 4634274385308418048(0x4050400000000000, double:65.0)
            goto L45
        L43:
            r0 = 4633641066610819072(0x404e000000000000, double:60.0)
        L45:
            double r2 = r10.f978oIX0oI
            double r4 = r4 * r2
            r6 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 / r6
            double r2 = r2 * r0
            double r2 = r2 / r6
            r0 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r0 = r0 * r2
            r6 = 4
            double[] r6 = new double[r6]
            r7 = 0
            r9 = 0
            r6[r9] = r7
            r7 = 1
            r6[r7] = r4
            r4 = 2
            r6[r4] = r2
            r2 = 3
            r6[r2] = r0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oxoX.XOxIOxOx():double[]");
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return xxIO() * 0.3499999940395355d;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        double d;
        double d2;
        double d3;
        if (oOoXoXO()) {
            d = (this.f978oIX0oI * 13.7d) + 66.0d + (this.f973II0xO0 * 5.0d);
            d2 = this.f982oxoX;
            d3 = 6.8d;
        } else {
            d = (this.f978oIX0oI * 9.6d) + 655.0d + (this.f973II0xO0 * 1.7d);
            d2 = this.f982oxoX;
            d3 = 4.7d;
        }
        return (int) (d - (d2 * d3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0054, code lost:
    
        if (r1 < 25.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0066, code lost:
    
        if (r1 < 24.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0076, code lost:
    
        if (r1 < 23.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0088, code lost:
    
        if (r1 < 22.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x009c, code lost:
    
        if (r1 < 23.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x00a8, code lost:
    
        if (r1 < 25.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00ba, code lost:
    
        if (r1 < 25.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x00ca, code lost:
    
        if (r1 < 25.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x00dc, code lost:
    
        if (r1 < 26.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x00ee, code lost:
    
        if (r1 < 28.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0100, code lost:
    
        if (r1 < 29.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0114, code lost:
    
        if (r1 < 21.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0128, code lost:
    
        if (r1 < 32.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x01e6, code lost:
    
        if (r3 <= 46.5d) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x013c, code lost:
    
        if (r1 < 34.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0151, code lost:
    
        if (r1 < 35.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x026a, code lost:
    
        r2 = 1;
        r3 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0165, code lost:
    
        if (r1 < 36.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x017a, code lost:
    
        if (r1 < 37.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x018a, code lost:
    
        if (r1 < 37.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x01a1, code lost:
    
        if (r1 < 35.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x01b6, code lost:
    
        if (r1 < 36.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x01c1, code lost:
    
        if (r1 < 37.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0267, code lost:
    
        r2 = 1;
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0201, code lost:
    
        if (r3 <= 52.400000000000006d) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0215, code lost:
    
        if (r3 <= 59.4d) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0232, code lost:
    
        if (r3 <= 34.699999999999996d) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x024f, code lost:
    
        if (r3 <= 37.5d) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r1 < 25.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0265, code lost:
    
        if (r3 <= 42.5d) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c3, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0044, code lost:
    
        if (r1 < 26.0d) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x01c5, code lost:
    
        r1 = 3;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.vtrump.vtble.Scale.ScaleInfo.a XoI0Ixx0() {
        /*
            Method dump skipped, instructions count: 691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oxoX.XoI0Ixx0():com.vtrump.vtble.Scale.ScaleInfo$a");
    }

    @Override // Ix0x.II0XooXoX
    public double[] Xx000oIo() {
        return OxI();
    }

    @Override // Ix0x.II0XooXoX
    public double[] o00() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f978oIX0oI;
        if (oOoXoXO2) {
            d2 = 0.16d * d3;
            d = d3 * 0.18d;
        } else {
            double d4 = 0.14d * d3;
            d = d3 * 0.16d;
            d2 = d4;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, d, 1.5d * d};
    }

    @Override // Ix0x.II0XooXoX
    public double o0xxxXXxX() {
        return (X0o0xo() / this.f978oIX0oI) * 100.0d * 0.6800000071525574d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oI0IIXIo() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = 8.6d;
            d2 = 16.7d;
        } else {
            d = 18.5d;
            d2 = 26.7d;
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
        double d;
        double d2 = 16.0d;
        if (oOoXoXO()) {
            d2 = 18.0d;
            d = 16.0d;
        } else {
            d = 14.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double[] ooOOo0oXI() {
        double[] OOXIxO02 = OOXIxO0();
        double d = OOXIxO02[0];
        double d2 = OOXIxO02[1];
        double d3 = OOXIxO02[2];
        double d4 = OOXIxO02[3];
        return new double[]{1.0d, d, d2, d3, d4, 1.5d * d4};
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        return ((((this.f973II0xO0 * 0.597d) / 2.0d) + 1.396d) + (this.f978oIX0oI * 0.099d)) - (this.f982oxoX * 0.009d);
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxXx0IX() {
        double d;
        double d2;
        double d3 = this.f982oxoX;
        if (d3 < 18.0d) {
            if (oOoXoXO()) {
                d = this.f978oIX0oI;
                d2 = 26.0d;
            } else {
                d = this.f978oIX0oI;
                d2 = 25.600000381469727d;
            }
        } else if (d3 < 30.0d) {
            if (oOoXoXO()) {
                d = this.f978oIX0oI;
                d2 = 24.0d;
            } else {
                d = this.f978oIX0oI;
                d2 = 23.600000381469727d;
            }
        } else if (d3 < 50.0d) {
            if (oOoXoXO()) {
                d = this.f978oIX0oI;
                d2 = 22.299999237060547d;
            } else {
                d = this.f978oIX0oI;
                d2 = 21.700000762939453d;
            }
        } else {
            boolean oOoXoXO2 = oOoXoXO();
            if (d3 >= 70.0d ? oOoXoXO2 : oOoXoXO2) {
                d = this.f978oIX0oI;
                d2 = 21.5d;
            } else {
                d = this.f978oIX0oI;
                d2 = 20.700000762939453d;
            }
        }
        double d4 = d * d2;
        return new double[]{XIXIX.OOXIXo.f3760XO, d4, 1.5d * d4};
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        return (Ioxxx() * this.f978oIX0oI) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxxXoxO() {
        return Io();
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0XOIxOo() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f973II0xO0;
        if (oOoXoXO2) {
            if (d3 < 160.0d) {
                d = 38.5d;
                d2 = 46.5d;
            } else if (d3 < 170.0d) {
                d = 44.0d;
                d2 = 52.400001525878906d;
            } else {
                d = 49.400001525878906d;
                d2 = 59.400001525878906d;
            }
        } else if (d3 < 150.0d) {
            d = 29.100000381469727d;
            d2 = 34.70000076293945d;
        } else if (d3 < 160.0d) {
            d = 32.900001525878906d;
            d2 = 37.5d;
        } else {
            d = 36.5d;
            d2 = 42.5d;
        }
        double d4 = this.f978oIX0oI;
        double d5 = (d2 / d4) * 100.0d;
        return new double[]{XIXIX.OOXIXo.f3760XO, (d / d4) * 100.0d, d5, 1.5d * d5};
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        int i;
        int i2;
        double d;
        if (oOoXoXO()) {
            i = 10;
            i2 = 60000;
        } else {
            i = 7;
            i2 = 80000;
        }
        double oX2 = ((((oX() * 100.0d) * Ioxxx()) * i) + (this.f982oxoX * 1500.0d)) - i2;
        if (oX2 >= XIXIX.OOXIXo.f3760XO) {
            d = oX2 / 100000.0d;
        } else {
            d = 0.0d;
        }
        double Ioxxx2 = Ioxxx();
        double d2 = (Ioxxx2 * 10.0d) - (d * 10.0d);
        if (Ioxxx2 > 25.6d) {
            if (d2 >= XIXIX.OOXIXo.f3760XO && d2 <= 10.0d) {
                d -= 1.0d;
            } else if (d2 <= 10.0d) {
                d = Ioxxx2 - 1.0d;
            }
        }
        int round = (int) Math.round(d);
        if (round < 1) {
            return 1;
        }
        return round;
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0xO0oo() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = 49.0d;
            d2 = 59.0d;
        } else {
            d = 40.0d;
            d2 = 50.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double[] xXOx() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f978oIX0oI;
        if (oOoXoXO2) {
            if (d3 >= 60.0d) {
                if (d3 <= 75.0d) {
                    d2 = 2.6999999999999997d;
                    d = 3.1d;
                } else {
                    d2 = 3.0d;
                    d = 3.4000000000000004d;
                }
            }
            d2 = 2.3d;
            d = 2.7d;
        } else if (d3 < 45.0d) {
            d2 = 1.6d;
            d = 2.0d;
        } else {
            if (d3 <= 60.0d) {
                d = 2.4000000000000004d;
                d2 = 2.0d;
            }
            d2 = 2.3d;
            d = 2.7d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, d, 1.5d * d};
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
    public double[] xoXoI() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f973II0xO0;
        if (oOoXoXO2) {
            if (d3 < 160.0d) {
                d = 38.5d;
                d2 = 46.5d;
            } else if (d3 < 170.0d) {
                d = 44.0d;
                d2 = 52.400000000000006d;
            } else {
                d = 49.4d;
                d2 = 59.4d;
            }
        } else if (d3 < 150.0d) {
            d = 29.099999999999998d;
            d2 = 34.699999999999996d;
        } else if (d3 < 160.0d) {
            d = 32.900000000000006d;
            d2 = 37.5d;
        } else {
            d = 36.5d;
            d2 = 42.5d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r2 <= 59.0d) goto L33;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double xoxXI() {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oxoX.xoxXI():double");
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
