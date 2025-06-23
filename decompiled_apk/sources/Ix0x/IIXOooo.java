package Ix0x;

import com.vtrump.vtble.Scale.ScaleInfo;

/* loaded from: classes13.dex */
public class IIXOooo extends II0XooXoX {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static IIXOooo f990IXxxXO;

    public static IIXOooo OOXIxO0() {
        IIXOooo iIXOooo = f990IXxxXO;
        if (iIXOooo == null) {
            IIXOooo iIXOooo2 = new IIXOooo();
            f990IXxxXO = iIXOooo2;
            return iIXOooo2;
        }
        return iIXOooo;
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
        return (this.f978oIX0oI * ox()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        if (oOoXoXO()) {
            d = 1174.0d;
            d2 = 4570000.0d;
            d3 = 4142.0d;
            d4 = 80.0d;
        } else {
            d = 1160.0d;
            d2 = 4950000.0d;
            d3 = 4500.0d;
            d4 = 100.0d;
        }
        double pow = ((d2 / (d - (((this.f978oIX0oI * 100.0d) * this.f976X0o0xo) / Math.pow(this.f973II0xO0, 2.0d)))) - d3) + Math.abs(this.f982oxoX - 30.0d) + d4;
        if (pow > 400.0d) {
            if (pow <= 500.0d) {
                d5 = (pow - 400.0d) / 2.0d;
            } else if (pow <= 700.0d) {
                d5 = (pow - 500.0d) / 3.0d;
            } else {
                com.vtrump.vtble.Oxx0xo.oIX0oI("1005Calc", "calcRatioOfFat: error::" + pow);
                pow = 0.0d;
            }
            pow = d5 + 450.0d;
        }
        double d6 = (pow / 10.0d) - 5.0d;
        if (d6 <= XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d6;
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        return (1.0d - (((x0xO() / 10.0f) + 1.0f) * 0.12488d)) * Ioxxx();
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        double d = this.f973II0xO0;
        if (oOoXoXO()) {
            if (d < 143.0d) {
                d = 143.0d;
            }
            return (d - 100.0d) * 0.9d;
        }
        if (d < 150.0d) {
            d = 150.0d;
        }
        return ((d - 100.0d) * 0.9d) - 2.5d;
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f978oIX0oI;
        if (oOoXoXO2) {
            d = 0.3499999940395355d;
        } else {
            d = 0.30000001192092896d;
        }
        double xxIO2 = (d2 * d) - ((xxIO() * this.f978oIX0oI) / 100.0d);
        if (xxIO2 > XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return xxIO2;
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        return (this.f978oIX0oI * xxIO()) / 100.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bb, code lost:
    
        if (r31 < 25.0d) goto L77;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int XI0oooXX() {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.IIXOooo.XI0oooXX():int");
    }

    @Override // Ix0x.II0XooXoX
    public double XO() {
        return (this.f978oIX0oI * XX0xXo()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return xxIO() * 0.6499999761581421d;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = ((this.f978oIX0oI * 13.75d) + (this.f973II0xO0 * 5.0d)) - (this.f982oxoX * 6.76d);
            d2 = 66.47d;
        } else {
            d = ((this.f978oIX0oI * 9.56d) + (this.f973II0xO0 * 1.85d)) - (this.f982oxoX * 4.68d);
            d2 = 655.1d;
        }
        return (int) (d + d2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x005f, code lost:
    
        if (r1 <= 25.0d) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0074, code lost:
    
        if (r1 <= 25.4d) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x00ce, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x008b, code lost:
    
        if (r1 <= 27.0d) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00a0, code lost:
    
        if (r1 <= 28.0d) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00b5, code lost:
    
        if (r1 <= 29.0d) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00ca, code lost:
    
        if (r1 <= 29.4d) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00f2, code lost:
    
        if (r3 <= 75.0d) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x012b, code lost:
    
        r2 = 1;
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0100, code lost:
    
        if (r3 <= 55.0d) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0117, code lost:
    
        if (r3 <= 65.0d) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0129, code lost:
    
        if (r3 <= 55.0d) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00cc, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x004a, code lost:
    
        if (r1 <= 24.0d) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
    
        if (r1 <= 23.0d) goto L65;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.vtrump.vtble.Scale.ScaleInfo.a XoI0Ixx0() {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.IIXOooo.XoI0Ixx0():com.vtrump.vtble.Scale.ScaleInfo$a");
    }

    @Override // Ix0x.II0XooXoX
    public double o0xxxXXxX() {
        double I0Io2;
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double Ioxxx2 = this.f978oIX0oI * (1.0d - (Ioxxx() / 100.0d));
        if (oOoXoXO2) {
            I0Io2 = Ioxxx2 - I0Io();
            d = (this.f973II0xO0 - 80.0d) * 0.7d;
            d2 = 0.35d;
        } else {
            I0Io2 = Ioxxx2 - I0Io();
            d = (this.f973II0xO0 - 70.0d) * 0.6d;
            d2 = 0.34d;
        }
        return ((I0Io2 - (d * d2)) / this.f978oIX0oI) * 100.0d;
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
        return (708.0d - (((Ioxxx() * 73.0d) * 10.0d) / 100.0d)) / 10.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        return (this.f978oIX0oI * Ioxxx()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        double d;
        double d2;
        double d3;
        boolean oOoXoXO2 = oOoXoXO();
        double Ioxxx2 = Ioxxx() * 10.0d;
        if (oOoXoXO2) {
            d = Ioxxx2 + 80.0d;
        } else {
            d = Ioxxx2 - 20.0d;
        }
        double d4 = XIXIX.OOXIXo.f3760XO;
        if (d > 140.0d) {
            if (d <= 180.0d) {
                d4 = 1.0d;
            } else if (d <= 340.0d) {
                d4 = ((d - 180.0d) / 20.0d) + 1.0d;
            } else {
                if (d <= 600.0d) {
                    d2 = (d - 340.0d) / 30.0d;
                    d3 = 8.0d;
                } else if (d > 600.0d) {
                    d2 = (d - 600.0d) / 40.0d;
                    d3 = 14.0d;
                }
                d4 = d2 + d3;
            }
        }
        int floor = (int) Math.floor(d4);
        if (floor < 1) {
            return 1;
        }
        return floor;
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
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f978oIX0oI;
        if (oOoXoXO2) {
            d = 0.1d;
        } else {
            d = 0.2d;
        }
        double Ioxxx2 = (d2 * d) - ((Ioxxx() * this.f978oIX0oI) / 100.0d);
        if (Ioxxx2 < XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return Ioxxx2;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIO() {
        double d;
        if (Ioxxx() < 0.01d) {
            return XIXIX.OOXIXo.f3760XO;
        }
        double ox2 = ox();
        double d2 = this.f973II0xO0 * 130.0d;
        double d3 = this.f978oIX0oI;
        double d4 = ox2 - (((d2 + (40.0d * d3)) - 14700.0d) / (d3 * 10.0d));
        if (oOoXoXO()) {
            d = 0.18799999356269836d;
        } else {
            d = 0.25d;
        }
        return (d4 / 1.0499999523162842d) - ((100.0d - ox()) * d);
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        return this.f978oIX0oI - OO();
    }
}
