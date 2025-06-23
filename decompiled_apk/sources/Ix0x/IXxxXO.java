package Ix0x;

import com.baidu.ar.auth.FeatureCodes;

/* loaded from: classes13.dex */
public class IXxxXO extends OOXIXo {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static IXxxXO f991oI0IIXIo;

    public static IXxxXO OOXIxO0() {
        IXxxXO iXxxXO = f991oI0IIXIo;
        if (iXxxXO == null) {
            IXxxXO iXxxXO2 = new IXxxXO();
            f991oI0IIXIo = iXxxXO2;
            return iXxxXO2;
        }
        return iXxxXO;
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double I0Io() {
        double d;
        double d2 = this.f982oxoX;
        if (d2 >= 10.0d && d2 <= 99.0d) {
            double oX2 = oX();
            double Ioxxx2 = Ioxxx();
            double ox2 = ox();
            if (oOoXoXO()) {
                d = ((((((this.f973II0xO0 * 0.0067d) - 4.9235d) + (this.f982oxoX * 0.0131d)) + (this.f978oIX0oI * 0.0324d)) + (this.f976X0o0xo * 0.0033d)) + (ox2 * 0.0419d)) - (Ioxxx2 * 8.0E-4d);
            } else {
                double d3 = this.f973II0xO0;
                double d4 = this.f982oxoX;
                double d5 = this.f978oIX0oI;
                d = (((((((0.0308d * d3) - 6.2108d) + (0.0302d * d4)) + (0.0109d * d5)) + (this.f976X0o0xo * 0.0023d)) + (oX2 * 0.0832d)) - (((0.0575d * d5) * d4) / d3)) - ((((d3 * 0.2696d) * d4) / d5) / d5);
            }
            if (d < 1.0d) {
                return 1.0d;
            }
            if (d > 4.0d) {
                return 4.0d;
            }
            return d;
        }
        return -10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] IIXOooo() {
        double[] ooOOo0oXI2 = ooOOo0oXI();
        double[] dArr = new double[ooOOo0oXI2.length];
        for (int i = 0; i < ooOOo0oXI2.length; i++) {
            dArr[i] = (ooOOo0oXI2[i] * this.f978oIX0oI) / 100.0d;
        }
        return dArr;
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double Ioxxx() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5 = this.f982oxoX;
        if (d5 >= 10.0d && d5 <= 99.0d) {
            double oX2 = oX();
            boolean oOoXoXO2 = oOoXoXO();
            double d6 = this.f973II0xO0;
            if (oOoXoXO2) {
                d = this.f982oxoX;
                d2 = this.f978oIX0oI;
                d3 = (((((68.922d - (0.4798d * d6)) + (1.3667d * d)) + (0.3283d * d2)) + (this.f976X0o0xo * 0.0115d)) + (oX2 * 0.1543d)) - (((1.7205d * d2) * d) / d6);
                d4 = 18.3084d;
            } else {
                d = this.f982oxoX;
                d2 = this.f978oIX0oI;
                d3 = (((((63.3576d - (0.49d * d6)) + (0.9583d * d)) + (0.5159d * d2)) + (this.f976X0o0xo * 0.0115d)) + (oX2 * 0.3558d)) - (((1.5271d * d2) * d) / d6);
                d4 = 8.1461d;
            }
            double d7 = d3 - ((((d6 * d4) * d) / d2) / d2);
            if (d7 < 5.0d) {
                return 5.0d;
            }
            if (d7 > 45.0d) {
                return 45.0d;
            }
            return d7;
        }
        return -1.0E8d;
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double O00XxXI() {
        double d;
        double d2;
        double Ioxxx2 = Ioxxx();
        if (Ioxxx2 == -1.0d) {
            return -1.0d;
        }
        if (oOoXoXO()) {
            d = (0.762d * Ioxxx2) + 0.9515d + (0.0092d * Ioxxx2 * Ioxxx2);
            d2 = 2.0E-4d;
        } else {
            d = ((1.0746d * Ioxxx2) - 0.3412d) - ((0.0014d * Ioxxx2) * Ioxxx2);
            d2 = 1.0E-4d;
        }
        double d3 = d - (((d2 * Ioxxx2) * Ioxxx2) * Ioxxx2);
        if (d3 < 3.0d) {
            return 3.0d;
        }
        if (d3 > 42.0d) {
            return 42.0d;
        }
        return d3;
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
    public double[] Oo() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = 55.0d;
            d2 = 65.0d;
        } else {
            d = 45.0d;
            d2 = 60.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double[] OxxIIOOXO() {
        return new double[]{1.0d, 5.0d, 10.0d, 15.0d, 22.5d};
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double X0o0xo() {
        double d;
        double d2 = this.f982oxoX;
        double d3 = 10.0d;
        if (d2 >= 10.0d && d2 <= 99.0d) {
            double Ioxxx2 = Ioxxx();
            double I0Io2 = I0Io();
            if (oOoXoXO()) {
                if (Ioxxx2 < 45.0d) {
                    d3 = Ioxxx2;
                }
                d = ((this.f978oIX0oI * (100.0d - d3)) / 100.0d) - I0Io2;
                if (d > 70.0d) {
                    return 70.0d;
                }
            } else {
                if (Ioxxx2 < 45.0d) {
                    d3 = Ioxxx2;
                }
                d = ((this.f978oIX0oI * (100.0d - d3)) / 100.0d) - I0Io2;
                if (d > 70.0d) {
                    return 70.0d;
                }
            }
            return d;
        }
        return -10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] XOxIOxOx() {
        double[] Oo2 = Oo();
        double[] dArr = new double[Oo2.length];
        for (int i = 0; i < Oo2.length; i++) {
            dArr[i] = (Oo2[i] * this.f978oIX0oI) / 100.0d;
        }
        return dArr;
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double XX0xXo() {
        double d;
        double d2 = this.f982oxoX;
        if (d2 >= 10.0d && d2 <= 99.0d) {
            double oX2 = oX();
            double Ioxxx2 = Ioxxx();
            double ox2 = ox();
            if (oOoXoXO()) {
                d = ((((((this.f973II0xO0 * 0.411d) - 101.0612d) - (this.f982oxoX * 0.0633d)) - (this.f978oIX0oI * 0.2347d)) - (this.f976X0o0xo * 0.0035d)) - (oX2 * 0.0845d)) + (Ioxxx2 * 0.5728d) + (ox2 * 1.1204d);
            } else {
                d = (((((((this.f973II0xO0 * 0.0366d) + 40.2015d) - (this.f982oxoX * 0.0191d)) - (this.f978oIX0oI * 0.0033d)) - (this.f976X0o0xo * 0.0046d)) + (oX2 * 0.0856d)) - (Ioxxx2 * 0.708d)) - (ox2 * 0.1548d);
            }
            if (d < XIXIX.OOXIXo.f3760XO) {
                return 0.5d;
            }
            return d;
        }
        return -10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = ((this.f978oIX0oI * 13.7d) + (this.f973II0xO0 * 5.0d)) - (this.f982oxoX * 6.8d);
            d2 = 66.0d;
        } else {
            d = ((this.f978oIX0oI * 9.6d) + (this.f973II0xO0 * 1.8d)) - (this.f982oxoX * 4.7d);
            d2 = 655.0d;
        }
        return (int) (d + d2);
    }

    @Override // Ix0x.II0XooXoX
    public double[] oO() {
        return new double[]{XIXIX.OOXIXo.f3760XO, 16.0d, 20.0d, 30.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double[] ooOOo0oXI() {
        double d;
        double d2;
        double d3;
        double d4;
        boolean oOoXoXO2 = oOoXoXO();
        double d5 = 29.0d;
        double d6 = 27.0d;
        double d7 = 22.0d;
        double d8 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d8 <= 39.0d) {
                d7 = 10.0d;
                d3 = 16.0d;
                d4 = 26.0d;
                d2 = 21.0d;
                d = d3;
                d5 = d4;
            } else {
                if (d8 <= 59.0d) {
                    d6 = 17.0d;
                    d2 = 22.0d;
                    d7 = 11.0d;
                    d5 = 27.0d;
                } else {
                    d7 = 13.0d;
                    d6 = 19.0d;
                    d2 = 24.0d;
                }
                return new double[]{5.0d, d7, d6, d2, d5, 1.5d * d5};
            }
        } else {
            if (d8 <= 39.0d) {
                d7 = 20.0d;
                d2 = 34.0d;
                d5 = 39.0d;
                return new double[]{5.0d, d7, d6, d2, d5, 1.5d * d5};
            }
            if (d8 <= 59.0d) {
                d3 = 28.0d;
                d4 = 40.0d;
                d2 = 35.0d;
                d7 = 21.0d;
                d = d3;
                d5 = d4;
            } else {
                d = 29.0d;
                d5 = 41.0d;
                d2 = 36.0d;
            }
        }
        d6 = d;
        return new double[]{5.0d, d7, d6, d2, d5, 1.5d * d5};
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public double ox() {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6 = this.f982oxoX;
        if (d6 >= 10.0d && d6 <= 99.0d) {
            double oX2 = oX();
            if (oOoXoXO()) {
                d = this.f973II0xO0;
                d2 = this.f982oxoX;
                d3 = this.f978oIX0oI;
                d4 = ((((((0.1051d * d) + 54.4588d) - (0.705d * d2)) - (0.1254d * d3)) - (this.f976X0o0xo * 0.009d)) - (oX2 * 0.1459d)) + (((0.9319d * d3) * d2) / d);
                d5 = 9.2069d;
            } else {
                d = this.f973II0xO0;
                d2 = this.f982oxoX;
                d3 = this.f978oIX0oI;
                d4 = ((((((0.122d * d) + 42.3525d) - (0.4089d * d2)) - (0.1293d * d3)) - (this.f976X0o0xo * 0.0089d)) - (oX2 * 0.0484d)) + (((0.5081d * d3) * d2) / d);
                d5 = 5.7155d;
            }
            return d4 + ((((d * d5) * d2) / d3) / d3);
        }
        return -1.0E8d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxXx0IX() {
        int i;
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f982oxoX;
        if (oOoXoXO2) {
            if (d <= 29.0d) {
                i = 1550;
            } else if (d <= 49.0d) {
                i = 1500;
            } else if (d <= 69.0d) {
                i = 1350;
            } else {
                i = FeatureCodes.FACE_CHANGING;
            }
        } else if (d <= 29.0d) {
            i = FeatureCodes.FACE_MULTI;
        } else if (d <= 49.0d) {
            i = 1170;
        } else if (d <= 69.0d) {
            i = FeatureCodes.SPLIT_FILTER;
        } else {
            i = 1010;
        }
        double d2 = i;
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, 1.5d * d2};
    }

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
    public int x0xO() {
        double d;
        double d2 = this.f982oxoX;
        if (d2 >= 10.0d && d2 <= 99.0d) {
            double oX2 = oX();
            double Ioxxx2 = Ioxxx();
            if (oOoXoXO()) {
                double d3 = this.f973II0xO0;
                double d4 = this.f982oxoX;
                double d5 = this.f978oIX0oI;
                d = (((((66.1355d - (0.5525d * d3)) - (0.2179d * d4)) + (0.6154d * d5)) + (this.f976X0o0xo * 0.0096d)) - (oX2 * 0.8246d)) + (0.003d * d5 * d4) + ((((d3 * 4.5822d) * d4) / d5) / d5) + (Ioxxx2 * 0.1546d);
            } else {
                d = ((((((-8.6999d) - (this.f973II0xO0 * 0.0401d)) + (this.f982oxoX * 0.053d)) + (this.f978oIX0oI * 0.128d)) + (this.f976X0o0xo * 0.0029d)) + (oX2 * 0.4721d)) - (Ioxxx2 * 0.0707d);
            }
            int round = (int) Math.round(d);
            if (round < 1) {
                return 1;
            }
            return round;
        }
        return -10000;
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0xO0oo() {
        return new double[0];
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

    @Override // Ix0x.OOXIXo, Ix0x.II0XooXoX
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
                d2 = 52.4d;
            } else {
                d = 49.4d;
                d2 = 59.4d;
            }
        } else if (d3 < 150.0d) {
            d = 21.9d;
            d2 = 34.7d;
        } else if (d3 < 160.0d) {
            d = 32.9d;
            d2 = 37.5d;
        } else {
            d = 36.5d;
            d2 = 42.5d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }
}
