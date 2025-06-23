package Ix0x;

import com.baidu.ar.auth.FeatureCodes;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.garmin.fit.OxXXx0X;
import com.qq.e.comm.constants.ErrorCode;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.xxX;

/* loaded from: classes13.dex */
public class xxIXOIIO extends II0XooXoX {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static xxIXOIIO f1023IXxxXO;

    public static xxIXOIIO OOXIxO0() {
        xxIXOIIO xxixoiio = f1023IXxxXO;
        if (xxixoiio == null) {
            xxIXOIIO xxixoiio2 = new xxIXOIIO();
            f1023IXxxXO = xxixoiio2;
            return xxixoiio2;
        }
        return xxixoiio;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        double d;
        double d2;
        double d3;
        double d4;
        String str;
        double oX2 = oX() * 10.0d;
        if (oX2 <= 320.0d) {
            d = 38.0d;
            d2 = 16390.0d;
            d3 = 7.0d;
        } else {
            d = 9.0d;
            d2 = 7744.0d;
            d3 = 5.0d;
        }
        double d5 = d * oX2;
        double abs = ((Math.abs(oX2 - 320.0d) * Math.abs(d2 - d5)) * 10.0d) / this.f977XO;
        double d6 = XIXIX.OOXIXo.f3760XO;
        if ((oX2 < 320.0d && d2 > d5 && 4280.0d > abs) || (oX2 > 320.0d && d2 < d5 && 4280.0d > abs)) {
            d4 = ((d3 * this.f982oxoX) + 4280.0d) - abs;
        } else if ((oX2 < 320.0d && d2 > d5) || (oX2 > 320.0d && d2 < d5 && 4280.0d - abs < XIXIX.OOXIXo.f3760XO)) {
            d4 = ((d3 * this.f982oxoX) - 4280.0d) - abs;
            if (d4 < XIXIX.OOXIXo.f3760XO) {
                str = "calcWeightOfBone: error:" + d4;
                com.vtrump.vtble.Oxx0xo.oIX0oI("1003Calc", str);
                return XIXIX.OOXIXo.f3760XO;
            }
        } else {
            d4 = (d3 * this.f982oxoX) + 4280.0d + abs;
        }
        double d7 = (((((this.f978oIX0oI * 93.0d) * 100.0d) * (1000.0d - ((d4 / 10.0d) - 40.0d))) / 1000000.0d) + 3.0d) * 972.0d;
        double d8 = this.f973II0xO0;
        if (d8 > 160.0d && d8 <= 200.0d) {
            d7 -= (d8 - 160.0d) * 60.0d;
        }
        if (d8 > 100.0d && d8 <= 160.0d) {
            d7 -= (d8 - 100.0d) * 30.0d;
        }
        double d9 = (d7 / 10000.0d) - 8.0d;
        if (d9 < XIXIX.OOXIXo.f3760XO) {
            str = "calcWeightOfBone: error:" + d9;
            com.vtrump.vtble.Oxx0xo.oIX0oI("1003Calc", str);
            return XIXIX.OOXIXo.f3760XO;
        }
        if (d9 < 20.0d) {
            d6 = 20.0d - ((20.0d - d9) / 2.0d);
        } else if (d9 <= 30.0d) {
            d6 = d9;
        } else if (d9 > 30.0d) {
            d6 = ((d9 - 30.0d) / 2.0d) + 30.0d;
        }
        if (!oOoXoXO()) {
            d6 -= 2.0d;
        }
        return d6 / 10.0d;
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
        return ((int) (((1.0d - d3) * this.f982oxoX) + ((d3 * (d + d2)) / 2.0d))) - 2;
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
        double d4;
        double d5;
        if (oOoXoXO()) {
            double d6 = this.f982oxoX;
            if (d6 < 16.0d) {
                double d7 = this.f978oIX0oI;
                d2 = 0.18000000715255737d * d7;
                d3 = 0.23000000417232513d * d7;
                d5 = d7 * 0.2800000011920929d;
            } else if (d6 < 31.0d) {
                double d8 = this.f978oIX0oI;
                d2 = 0.18400000035762787d * d8;
                d3 = 0.23999999463558197d * d8;
                d5 = d8 * 0.28999999165534973d;
            } else {
                d = this.f978oIX0oI;
                if (d6 < 61.0d) {
                    d2 = 0.1940000057220459d * d;
                    double d9 = 0.25d * d;
                    d5 = d * 0.2939999997615814d;
                    d3 = d9;
                } else {
                    d2 = 0.20000000298023224d * d;
                    d3 = 0.2540000081062317d * d;
                    d4 = 0.30000001192092896d;
                }
            }
            return new double[]{XIXIX.OOXIXo.f3760XO, xxX.Oo(d2, 1), xxX.Oo(d3, 1), xxX.Oo(d5, 1), xxX.Oo(d5 * 1.5d, 1)};
        }
        double d10 = this.f982oxoX;
        if (d10 < 16.0d) {
            d = this.f978oIX0oI;
            d2 = 0.20000000298023224d * d;
            d3 = 0.27000001072883606d * d;
            d4 = 0.3140000104904175d;
        } else if (d10 < 31.0d) {
            d = this.f978oIX0oI;
            d2 = 0.20399999618530273d * d;
            d3 = d * 0.2800000011920929d;
            d4 = 0.3199999928474426d;
        } else {
            d = this.f978oIX0oI;
            if (d10 < 61.0d) {
                d2 = 0.21400000154972076d * d;
                d3 = d * 0.28999999165534973d;
                d4 = 0.33000001311302185d;
            } else {
                d2 = 0.2199999988079071d * d;
                d3 = 0.2939999997615814d * d;
                d4 = 0.33399999141693115d;
            }
        }
        d5 = d * d4;
        return new double[]{XIXIX.OOXIXo.f3760XO, xxX.Oo(d2, 1), xxX.Oo(d3, 1), xxX.Oo(d5, 1), xxX.Oo(d5 * 1.5d, 1)};
    }

    @Override // Ix0x.II0XooXoX
    public double[] Io() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 18.5d, 24.0d, 28.0d, 42.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6 = this.f976X0o0xo;
        if (d6 >= 300.0d && d6 <= 4000.0d) {
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
            double d7 = 400.0d;
            if (pow > 400.0d) {
                if (pow <= 550.0d) {
                    d5 = ((pow - 400.0d) * 2.0d) / 3.0d;
                } else if (pow <= 700.0d) {
                    d5 = (pow - 550.0d) / 2.0d;
                    d7 = 500.0d;
                } else {
                    com.vtrump.vtble.Oxx0xo.oIX0oI("1003Calc", "calcRatioOfFat: error::" + pow);
                    pow = XIXIX.OOXIXo.f3760XO;
                }
                pow = d5 + d7;
            }
            double d8 = pow / 10.0d;
            if (d8 <= XIXIX.OOXIXo.f3760XO) {
                return XIXIX.OOXIXo.f3760XO;
            }
            return d8;
        }
        this.f983x0XOIxOo.xx0X0(ErrorCode.SKIP_VIEW_SIZE_ERROR);
        return XIXIX.OOXIXo.f3760XO;
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        return (1.0d - (((x0xO() / 10.0f) + 1.0f) * 0.12488d)) * Ioxxx();
    }

    @Override // Ix0x.II0XooXoX
    public double O0Xx() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f973II0xO0 - 100.0d;
        if (oOoXoXO2) {
            d = 0.9d;
        } else {
            d = 0.8d;
        }
        return d2 * d;
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f973II0xO0 - 105.0d;
        if (oOoXoXO2) {
            return d;
        }
        return d - 2.5d;
    }

    @Override // Ix0x.II0XooXoX
    public double OO0x0xX() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d2 >= 10.0d && d2 <= 17.0d) {
                d = 45.0d;
            }
            d = 40.0d;
        } else {
            if (d2 < 10.0d || d2 > 17.0d) {
                d = 35.0d;
            }
            d = 40.0d;
        }
        double d3 = ((d * this.f978oIX0oI) / 100.0d) * 0.8999999761581421d;
        if (X0o0xo() < d3) {
            return X0o0xo() - d3;
        }
        return XIXIX.OOXIXo.f3760XO;
    }

    @Override // Ix0x.II0XooXoX
    public double[] Oo() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d2 <= 15.0d) {
                return o0(57.0d, 62.0d);
            }
            if (d2 <= 30.0d) {
                return o0(56.0d, 61.0d);
            }
            if (d2 <= 60.0d) {
                return o0(55.0d, 60.0d);
            }
            d = 54.0d;
        } else if (d2 <= 15.0d) {
            d = 53.0d;
        } else {
            if (d2 <= 30.0d) {
                return o0(52.0d, 58.0d);
            }
            if (d2 <= 60.0d) {
                return o0(51.0d, 57.0d);
            }
            return o0(50.0d, 56.0d);
        }
        return o0(d, 59.0d);
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxI() {
        double pow = Math.pow(this.f973II0xO0 / 100.0d, 2.0d) * 18.5d;
        double pow2 = Math.pow(this.f973II0xO0 / 100.0d, 2.0d) * 24.0d;
        return new double[]{XIXIX.OOXIXo.f3760XO, pow, pow2, 1.5d * pow2};
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return ((this.f978oIX0oI - oxoX()) - I0Io()) * 0.71d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxxIIOOXO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 10.0d, 15.0d, 22.5d};
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
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.xxIXOIIO.XI0oooXX():int");
    }

    @Override // Ix0x.II0XooXoX
    public double XO() {
        return ((this.f978oIX0oI - oxoX()) - I0Io()) - II0XooXoX();
    }

    @Override // Ix0x.II0XooXoX
    public double[] XOxIOxOx() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        boolean oOoXoXO2 = oOoXoXO();
        double d7 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d7 <= 15.0d) {
                double d8 = this.f978oIX0oI;
                return o0(0.57d * d8, d8 * 0.62d);
            }
            if (d7 <= 30.0d) {
                double d9 = this.f978oIX0oI;
                return o0(0.56d * d9, d9 * 0.61d);
            }
            if (d7 <= 60.0d) {
                d3 = this.f978oIX0oI;
                d = 0.55d * d3;
                d4 = 0.6d;
                d2 = d3 * d4;
            } else {
                d5 = this.f978oIX0oI;
                d6 = 0.54d;
                return o0(d6 * d5, d5 * 0.59d);
            }
        } else {
            if (d7 <= 15.0d) {
                d5 = this.f978oIX0oI;
                d6 = 0.53d;
                return o0(d6 * d5, d5 * 0.59d);
            }
            if (d7 <= 30.0d) {
                d3 = this.f978oIX0oI;
                d = 0.52d * d3;
                d4 = 0.58d;
                d2 = d3 * d4;
            } else if (d7 <= 60.0d) {
                double d10 = this.f978oIX0oI;
                d = 0.51d * d10;
                d2 = d10 * 0.57d;
            } else {
                double d11 = this.f978oIX0oI;
                d = 0.5d * d11;
                d2 = d11 * 0.56d;
            }
        }
        return o0(d, d2);
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return (XO() * 100.0d) / this.f978oIX0oI;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f982oxoX;
        if (d2 > XIXIX.OOXIXo.f3760XO && d2 <= 11.0d) {
            if (oOoXoXO2) {
                d = 3725.0d;
            } else {
                d = 3467.0d;
            }
        } else if (d2 <= 14.0d) {
            if (oOoXoXO2) {
                d = 3089.0d;
            } else {
                d = 2951.0d;
            }
        } else if (d2 <= 17.0d) {
            if (oOoXoXO2) {
                d = 2692.0d;
            } else {
                d = 2522.0d;
            }
        } else if (d2 <= 29.0d) {
            if (oOoXoXO2) {
                d = 2394.0d;
            } else {
                d = 2203.0d;
            }
        } else if (d2 <= 49.0d) {
            if (oOoXoXO2) {
                d = 2225.0d;
            } else {
                d = 2165.0d;
            }
        } else if (oOoXoXO2) {
            d = 2145.0d;
        } else {
            d = 2065.0d;
        }
        return (int) ((d * ((this.f978oIX0oI * 1000.0d) + this.f973II0xO0)) / 100000.0d);
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
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.xxIXOIIO.XoI0Ixx0():com.vtrump.vtble.Scale.ScaleInfo$a");
    }

    @Override // Ix0x.II0XooXoX
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

    @Override // Ix0x.II0XooXoX
    public double[] oI0IIXIo() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = 17.0d;
        double d4 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d4 <= 15.0d) {
                d3 = 14.0d;
                d = 22.0d;
            } else if (d4 <= 30.0d) {
                d = 23.0d;
                d3 = 15.0d;
            } else if (d4 <= 60.0d) {
                d2 = 24.0d;
                d3 = 16.0d;
                d = d2;
            } else {
                d = 25.0d;
            }
        } else if (d4 <= 15.0d) {
            d2 = 26.0d;
            d3 = 16.0d;
            d = d2;
        } else if (d4 <= 30.0d) {
            d = 27.0d;
        } else if (d4 <= 60.0d) {
            d3 = 18.0d;
            d = 28.0d;
        } else {
            d3 = 19.0d;
            d = 29.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d3, d, 1.5d * d};
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

    @Override // Ix0x.II0XooXoX
    public double[] oo0xXOI0I() {
        double d = this.f982oxoX;
        return new double[]{XIXIX.OOXIXo.f3760XO, d, 1.5d * d};
    }

    @Override // Ix0x.II0XooXoX
    public double[] ooOOo0oXI() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5 = 29.4d;
        if (oOoXoXO()) {
            double d6 = this.f982oxoX;
            if (d6 < 16.0d) {
                d = 18.0d;
                d2 = 23.0d;
                d5 = 28.0d;
            } else if (d6 < 31.0d) {
                d = 18.4d;
                d2 = 24.0d;
                d5 = 29.0d;
            } else if (d6 < 61.0d) {
                d = 19.4d;
                d2 = 25.0d;
            } else {
                d3 = 25.4d;
                d4 = 30.0d;
                d2 = d3;
                d5 = d4;
                d = 20.0d;
            }
        } else {
            double d7 = this.f982oxoX;
            if (d7 < 16.0d) {
                d3 = 27.0d;
                d4 = 31.4d;
                d2 = d3;
                d5 = d4;
                d = 20.0d;
            } else if (d7 < 31.0d) {
                d = 20.4d;
                d5 = 32.0d;
                d2 = 28.0d;
            } else if (d7 < 61.0d) {
                d = 21.4d;
                d5 = 33.0d;
                d2 = 29.0d;
            } else {
                d = 22.0d;
                d5 = 33.4d;
                d2 = 29.4d;
            }
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, d5, 1.5d * d5};
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        return (708.0d - (((Ioxxx() * 73.0d) * 10.0d) / 100.0d)) / 10.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxXx0IX() {
        int i;
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f982oxoX;
        if (oOoXoXO2) {
            if (d <= 11.0d) {
                i = MapParams.Const.LayerType.MAP_LAYER_TYPE_THROUGH_NODE;
            } else if (d <= 14.0d) {
                i = 1388;
            } else if (d <= 17.0d) {
                i = 1450;
            } else if (d <= 29.0d) {
                i = OxXXx0X.f13141o0;
            } else if (d <= 49.0d) {
                i = 1420;
            } else if (d <= 60.0d) {
                i = FeatureCodes.VO;
            } else {
                i = 1200;
            }
        } else if (d <= 11.0d) {
            i = 1140;
        } else if (d <= 14.0d) {
            i = 1280;
        } else if (d <= 17.0d) {
            i = FeatureCodes.FACE_CHANGING;
        } else if (d <= 29.0d) {
            i = ScreenUtil.DEFAULT_WIDTH;
        } else if (d <= 49.0d) {
            i = 1100;
        } else if (d <= 60.0d) {
            i = 1070;
        } else {
            i = 980;
        }
        double d2 = i;
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        double Ioxxx2 = (this.f978oIX0oI * Ioxxx()) / 100.0d;
        if (Ioxxx2 <= XIXIX.OOXIXo.f3760XO) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return Ioxxx2;
    }

    @Override // Ix0x.II0XooXoX
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

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double Ioxxx2 = Ioxxx() * 10.0d;
        if (oOoXoXO2) {
            d = Ioxxx2 + 80.0d;
        } else {
            d = Ioxxx2 - 20.0d;
        }
        double d3 = XIXIX.OOXIXo.f3760XO;
        if (d > 140.0d) {
            double d4 = 1.0d;
            if (d <= 180.0d) {
                d3 = 1.0d;
            } else {
                if (d <= 350.0d) {
                    d2 = (d - 180.0d) / 24.0d;
                } else if (d <= 600.0d) {
                    d2 = (d - 350.0d) / 32.0d;
                    d4 = 8.0d;
                } else if (d > 600.0d) {
                    d2 = (d - 600.0d) / 42.0d;
                    d4 = 16.0d;
                }
                d3 = d2 + d4;
            }
        }
        int floor = (int) Math.floor(d3);
        if (floor < 1) {
            return 1;
        }
        return floor;
    }

    @Override // Ix0x.II0XooXoX
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
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f982oxoX;
        if (oOoXoXO2) {
            if (d < 19.0d) {
                double d2 = this.f978oIX0oI;
                return xII(0.3d * d2, d2 * 0.75d);
            }
            double d3 = this.f978oIX0oI;
            return xII(0.25d * d3, d3 * 0.55d);
        }
        if (d < 19.0d) {
            double d4 = this.f978oIX0oI;
            return xII(0.25d * d4, d4 * 0.65d);
        }
        double d5 = this.f978oIX0oI;
        return xII(0.2d * d5, d5 * 0.55d);
    }

    @Override // Ix0x.II0XooXoX
    public double xoxXI() {
        double oxoX2 = oxoX();
        double[] dArr = new double[2];
        if (oOoXoXO()) {
            double d = this.f982oxoX;
            if (d >= 10.0d && d <= 15.0d) {
                dArr[0] = 18.100000381469727d;
                dArr[1] = 23.0d;
            } else if (d <= 30.0d) {
                dArr[0] = 18.5d;
                dArr[1] = 24.0d;
            } else if (d <= 60.0d) {
                dArr[0] = 19.5d;
                dArr[1] = 25.0d;
            } else if (d <= 100.0d) {
                dArr[0] = 20.100000381469727d;
                dArr[1] = 25.399999618530273d;
            }
        } else {
            double d2 = this.f982oxoX;
            if (d2 >= 10.0d && d2 <= 15.0d) {
                dArr[0] = 20.100000381469727d;
                dArr[1] = 27.0d;
            } else if (d2 <= 30.0d) {
                dArr[0] = 20.5d;
                dArr[1] = 28.0d;
            } else if (d2 <= 60.0d) {
                dArr[0] = 21.5d;
                dArr[1] = 29.0d;
            } else if (d2 <= 100.0d) {
                dArr[0] = 22.100000381469727d;
                dArr[1] = 29.399999618530273d;
            }
        }
        double d3 = dArr[0];
        double d4 = this.f978oIX0oI;
        if (oxoX2 >= (d3 * d4) / 100.0d && oxoX2 <= (dArr[1] * d4) / 100.0d) {
            return XIXIX.OOXIXo.f3760XO;
        }
        if (oxoX2 >= (d3 * d4) / 100.0d) {
            d3 = dArr[1];
        }
        return oxoX2 - ((d3 * d4) / 100.0d);
    }

    @Override // Ix0x.II0XooXoX
    public double xxIO() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        boolean oOoXoXO2 = oOoXoXO();
        double d7 = this.f982oxoX;
        if (oOoXoXO2) {
            d = 233300.0d;
            if (d7 < 18.0d) {
                d3 = 614200.0d;
                d4 = 232.0d;
            } else {
                d2 = 514200.0d;
                d3 = d2;
                d4 = 242.0d;
            }
        } else {
            d = 230000.0d;
            if (d7 < 18.0d) {
                d3 = 334000.0d;
                d4 = 220.0d;
            } else {
                d2 = 166000.0d;
                d3 = d2;
                d4 = 242.0d;
            }
        }
        double pow = ((((((d * Math.pow(this.f973II0xO0, 2.0d)) / ((this.f977XO * 10.0d) + 800.0d)) + d3) / (this.f978oIX0oI * 100.0d)) + d4) - (this.f982oxoX * 1.5d)) * 1.7999999523162842d;
        if (pow <= XIXIX.OOXIXo.f3760XO || pow > 550.0d) {
            if (pow <= 650.0d) {
                pow = ((pow - 550.0d) * 0.5d) + 550.0d;
            } else {
                if (pow <= 750.0d) {
                    d5 = (pow - 650.0d) * 0.4000000059604645d;
                    d6 = 600.0d;
                } else if (pow <= 1800.0d) {
                    d5 = (pow - 750.0d) * 0.30000001192092896d;
                    d6 = 640.0d;
                } else {
                    com.vtrump.vtble.Oxx0xo.oIX0oI("1003Calc", "calcRatioOfMuscle: error:" + pow);
                    pow = 0.0d;
                }
                pow = d5 + d6;
            }
        }
        return pow / 10.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        double OO2 = OO() * 0.8999999761581421d;
        double OO3 = OO() * 1.100000023841858d;
        double d = this.f978oIX0oI;
        if (d < OO2) {
            return d - OO2;
        }
        if (d <= OO3) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d - OO3;
    }
}
