package Ix0x;

import com.vtrump.vtble.Scale.ScaleInfo;

/* loaded from: classes13.dex */
public class OOXIXo extends II0XooXoX {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static double[][] f992Oxx0xo = {new double[]{1.6619999408721924d, 8.900000248104334E-4d, 0.38999998569488525d, 0.0010000000474974513d, 3.299999952316284d, 0.08100000023841858d}, new double[]{2.877000093460083d, 8.999999845400453E-4d, 0.3919999897480011d, 9.500000160187483E-4d, 4.5d, 0.0689999982714653d}, new double[]{4.826000213623047d, 9.058000287041068E-4d, 0.38999998569488525d, 8.999999845400453E-4d, 6.310999870300293d, 0.044199999421834946d}, new double[]{6.770999908447266d, 9.121000184677541E-4d, 0.3919999897480011d, 8.299999753944576E-4d, 8.5d, 0.01899999938905239d}, new double[]{10.659000396728516d, 9.247999987564981E-4d, 0.38999998569488525d, 6.900000153109431E-4d, 12.890000343322754d, 0.009999999776482582d}};

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f993IXxxXO = 2;

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        throw null;
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
        return this.f978oIX0oI - oxoX();
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return (this.f978oIX0oI * ox()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        throw null;
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        return -10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f973II0xO0 - 100.0d;
        if (oOoXoXO2) {
            d = 0.8999999761581421d;
        } else {
            d = 0.800000011920929d;
        }
        return d2 * d;
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        double[] dArr = new double[2];
        double X0o0xo2 = X0o0xo();
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f973II0xO0;
        if (oOoXoXO2) {
            if (d < 160.0d) {
                dArr[0] = 38.5d;
                dArr[1] = 46.5d;
            } else if (d < 170.0d) {
                dArr[0] = 44.0d;
                dArr[1] = 52.400001525878906d;
            } else {
                dArr[0] = 49.400001525878906d;
                dArr[1] = 59.400001525878906d;
            }
        } else if (d < 150.0d) {
            dArr[0] = 21.899999618530273d;
            dArr[1] = 34.70000076293945d;
        } else if (d < 160.0d) {
            dArr[0] = 32.900001525878906d;
            dArr[1] = 37.5d;
        } else {
            dArr[0] = 36.5d;
            dArr[1] = 42.5d;
        }
        double d2 = dArr[0];
        if (X0o0xo2 < d2) {
            return X0o0xo2 - d2;
        }
        return XIXIX.OOXIXo.f3760XO;
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return X0o0xo() * 0.7099999785423279d;
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        return (this.f978oIX0oI - oxoX()) - I0Io();
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
        double d10 = XIXIX.OOXIXo.f3760XO;
        double d11 = 16.0d;
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
                d11 = 12.100000381469727d;
                d9 = 34.0d;
                d8 = 50.0d;
            } else if (Ioxxx2 < 17.0d) {
                d5 = 14.5d;
                d8 = 84.0d;
                d10 = 17.0d;
                d9 = 16.0d;
                d11 = d5;
            } else {
                d8 = 30.0d;
                d9 = 54.0d;
                d11 = 17.0d;
            }
        } else if (d13 <= 30.0d) {
            d6 = 12.5d;
            if (Ioxxx2 > 12.5d) {
                d7 = 18.0d;
                if (Ioxxx2 < 18.0d) {
                    d8 = 84.0d;
                    d9 = 16.0d;
                    d10 = 18.0d;
                    d11 = 15.0d;
                }
                d11 = d7;
                d8 = 30.0d;
                d9 = 54.0d;
            }
            d11 = d6;
            d9 = 34.0d;
            d8 = 50.0d;
        } else if (d13 <= 40.0d) {
            if (Ioxxx2 <= 13.1d) {
                d11 = 13.100000381469727d;
                d9 = 34.0d;
                d8 = 50.0d;
            } else {
                d4 = 18.399999618530273d;
                if (Ioxxx2 < 18.4d) {
                    d5 = 15.5d;
                    d10 = d4;
                    d8 = 84.0d;
                    d9 = 16.0d;
                    d11 = d5;
                }
                d9 = 54.0d;
                d11 = d4;
                d8 = 30.0d;
            }
        } else if (d13 <= 60.0d) {
            d6 = 13.5d;
            if (Ioxxx2 > 13.5d) {
                d7 = 19.0d;
                if (Ioxxx2 < 19.0d) {
                    d10 = 19.0d;
                    d8 = 84.0d;
                    d9 = 16.0d;
                }
                d11 = d7;
                d8 = 30.0d;
                d9 = 54.0d;
            }
            d11 = d6;
            d9 = 34.0d;
            d8 = 50.0d;
        } else if (Ioxxx2 <= 14.1d) {
            d11 = 14.100000381469727d;
            d9 = 34.0d;
            d8 = 50.0d;
        } else {
            d4 = 19.399999618530273d;
            if (Ioxxx2 < 19.4d) {
                d5 = 16.5d;
                d10 = d4;
                d8 = 84.0d;
                d9 = 16.0d;
                d11 = d5;
            }
            d9 = 54.0d;
            d11 = d4;
            d8 = 30.0d;
        }
        double abs2 = (abs * 0.5d) + ((d8 + ((1.0d - (Math.abs(d11 - Ioxxx2) / Math.abs(d11 - d10))) * d9)) * 0.5d);
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
        return X0o0xo() - II0XooXoX();
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return (XO() * 100.0d) / this.f978oIX0oI;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x004d, code lost:
    
        if (r1 <= 22.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x005b, code lost:
    
        if (r1 <= 24.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x006e, code lost:
    
        if (r1 <= 33.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0080, code lost:
    
        if (r1 <= 34.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0093, code lost:
    
        if (r1 <= 35.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00a2, code lost:
    
        if (r1 <= 36.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00c7, code lost:
    
        if (r3 <= 46.5d) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0146, code lost:
    
        r2 = 1;
        r3 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0143, code lost:
    
        r2 = 1;
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e2, code lost:
    
        if (r3 <= 52.400001525878906d) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f6, code lost:
    
        if (r3 <= 59.400001525878906d) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0113, code lost:
    
        if (r3 <= 34.70000076293945d) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
    
        if (r1 <= 21.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x012b, code lost:
    
        if (r3 <= 37.5d) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0141, code lost:
    
        if (r3 <= 42.5d) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00a6, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00a4, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x003a, code lost:
    
        if (r1 <= 21.0d) goto L61;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.vtrump.vtble.Scale.ScaleInfo.a XoI0Ixx0() {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.OOXIXo.XoI0Ixx0():com.vtrump.vtble.Scale.ScaleInfo$a");
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
        throw null;
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0XOIxOo() {
        double d;
        double d2;
        double d3;
        boolean oOoXoXO2 = oOoXoXO();
        double d4 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d4 < 40.0d) {
                d = 72.9000015258789d;
                d2 = 82.0d;
            } else if (d4 < 60.0d) {
                d = 69.9000015258789d;
                d2 = 79.0d;
            } else {
                d3 = 66.9000015258789d;
                return xII(d3, 77.0d);
            }
            return xII(d, d2);
        }
        if (d4 < 40.0d) {
            d3 = 67.9000015258789d;
            return xII(d3, 77.0d);
        }
        if (d4 < 60.0d) {
            d = 64.9000015258789d;
            d2 = 75.0d;
        } else {
            d = 61.900001525878906d;
            d2 = 72.0d;
        }
        return xII(d, d2);
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        int i;
        if (oOoXoXO()) {
            i = (int) ((17.0282d - (this.f973II0xO0 * 0.237d)) + (this.f982oxoX * 0.1259d) + (this.f978oIX0oI * 0.377d) + (this.f976X0o0xo * 0.00139999995008111d));
        } else {
            i = (int) (((((this.f978oIX0oI * 0.3857d) - (this.f973II0xO0 * 0.0671d)) - (this.f982oxoX * 0.2806d)) + (this.f976X0o0xo * 0.00430000014603138d)) - 1.976d);
        }
        if (i < 1) {
            return 1;
        }
        return i;
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
                d2 = 52.400001525878906d;
            } else {
                d = 49.400001525878906d;
                d2 = 59.400001525878906d;
            }
        } else if (d3 < 150.0d) {
            d = 21.899999618530273d;
            d2 = 34.70000076293945d;
        } else if (d3 < 160.0d) {
            d = 32.900001525878906d;
            d2 = 37.5d;
        } else {
            d = 36.5d;
            d2 = 42.5d;
        }
        return xII(d, d2);
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
        return (X0o0xo() * 100.0d) / this.f978oIX0oI;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        return this.f978oIX0oI - OO();
    }
}
