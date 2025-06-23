package Ix0x;

import android.util.Log;
import com.vtrump.vtble.Scale.ScaleInfo;

/* loaded from: classes13.dex */
public class oOoXoXO extends II0XooXoX {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static oOoXoXO f1013IXxxXO;

    public static oOoXoXO OOXIxO0() {
        oOoXoXO oooxoxo = f1013IXxxXO;
        if (oooxoxo == null) {
            oOoXoXO oooxoxo2 = new oOoXoXO();
            f1013IXxxXO = oooxoxo2;
            return oooxoxo2;
        }
        return oooxoxo;
    }

    public int I0() {
        float f = (float) xoXoI()[1];
        float f2 = (float) xoXoI()[2];
        float X0o0xo2 = (float) X0o0xo();
        if (X0o0xo2 < f) {
            return 1;
        }
        if (X0o0xo2 <= f2) {
            return 2;
        }
        return 3;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        double d;
        double d2 = this.f982oxoX - 35.0d;
        double ox2 = (ox() * 0.18000000715255737d) / 100.0d;
        if (d2 < 9.999999747378752E-6d) {
            d = ox2 + ((this.f982oxoX * 5.0d) / 35.0d);
        } else {
            d = (ox2 + 9.0d) - ((this.f982oxoX * 4.0d) / 35.0d);
        }
        if (!oOoXoXO()) {
            d -= 2.0d;
        }
        if (OOXIXo()) {
            d += 0.30000001192092896d;
        }
        if (d - 2.0d < 9.999999747378752E-6d) {
            return 2.0d;
        }
        if (d - 6.0d > 9.999999747378752E-6d) {
            return 6.0d;
        }
        return d;
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
        double d5 = this.f982oxoX;
        double d6 = ((float) (((1.0d - d3) * d5) + ((d3 * (d + d2)) / 2.0d))) - d5;
        if (d6 - 10.0d > 9.999999747378752E-6d) {
            d6 = 10.0d;
        } else if (10.0d + d6 < 9.999999747378752E-6d) {
            d6 = -10.0d;
        }
        float f = (float) (d5 + d6);
        if (f - 10.0f < 1.0E-5f) {
            f = 10.0f;
        } else if (f - 99.0f > 1.0E-5f) {
            f = 99.0f;
        }
        Log.d("TAG", "calcAgeOfBody: " + f);
        return (int) (f + 0.5d);
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        return this.f978oIX0oI - oxoX();
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return (this.f978oIX0oI * ox()) / 100.0d;
    }

    public int IIxOXoOo0() {
        float f = (float) ooOOo0oXI()[1];
        float f2 = (float) ooOOo0oXI()[2];
        float Ioxxx2 = (float) Ioxxx();
        if (Ioxxx2 < f) {
            return 1;
        }
        if (Ioxxx2 <= f2) {
            return 2;
        }
        return 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double Ioxxx() {
        /*
            r13 = this;
            boolean r0 = r13.OOXIXo()
            r1 = 4603669611219517440(0x3fe3851ec0000000, double:0.6100000143051147)
            if (r0 != 0) goto L44
            boolean r0 = r13.oOoXoXO()
            r3 = 4561440257962147840(0x3f4d7dbf40000000, double:8.999999845400453E-4)
            r5 = 4586530712265424896(0x3fa6a161e0000000, double:0.044199999421834946)
            r7 = -4602083218340970496(0xc0221db220000000, double:-9.057999610900879)
            double r9 = r13.f978oIX0oI
            if (r0 == 0) goto L3e
            r11 = -4606252425236447232(0xc0134dd300000000, double:-4.826000213623047)
        L27:
            double r11 = r11 / r9
            double r11 = r11 + r1
            double r0 = r13.oX()
            double r7 = r7 / r0
            double r11 = r11 + r7
            double r0 = r13.f982oxoX
            double r0 = r0 * r5
            double r5 = r13.f978oIX0oI
            double r0 = r0 / r5
            double r11 = r11 + r0
            double r0 = r13.f976X0o0xo
            double r0 = r0 * r3
            double r0 = r0 / r5
            double r11 = r11 + r0
            goto L84
        L3e:
            r11 = 4609366664683716608(0x3ff7c28f60000000, double:1.4850000143051147)
            goto L27
        L44:
            boolean r0 = r13.oOoXoXO()
            r3 = 4559503350118219776(0x3f469c23c0000000, double:6.900000153109431E-4)
            r5 = 4576918229175238656(0x3f847ae140000000, double:0.009999999776482582)
            r7 = -4601976257549172736(0xc0227ef9e0000000, double:-9.248000144958496)
            if (r0 == 0) goto L61
            double r9 = r13.f978oIX0oI
            r11 = -4601181935023161344(0xc025516880000000, double:-10.659000396728516)
            goto L27
        L61:
            double r0 = r13.f978oIX0oI
            r9 = -4611165852790685696(0xc001d91680000000, double:-2.2309999465942383)
            double r9 = r9 / r0
            r0 = 4603489466869350400(0x3fe2e147a0000000, double:0.5899999737739563)
            double r9 = r9 + r0
            double r0 = r13.oX()
            double r7 = r7 / r0
            double r9 = r9 + r7
            double r0 = r13.f982oxoX
            double r0 = r0 * r5
            double r5 = r13.f978oIX0oI
            double r0 = r0 / r5
            double r9 = r9 + r0
            double r0 = r13.f976X0o0xo
            double r0 = r0 * r3
            double r0 = r0 / r5
            double r11 = r9 + r0
        L84:
            r0 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r11 = r11 * r0
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r2 = r11 - r0
            r4 = 4532020583461814272(0x3ee4f8b580000000, double:9.999999747378752E-6)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L97
        L95:
            r11 = r0
            goto La3
        L97:
            r0 = 4634626229029306368(0x4051800000000000, double:70.0)
            double r2 = r11 - r0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto La3
            goto L95
        La3:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oOoXoXO.Ioxxx():double");
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        return -10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] O0xOxO() {
        float f;
        float f2;
        boolean oOoXoXO2 = oOoXoXO();
        double d = this.f973II0xO0;
        if (oOoXoXO2) {
            if (d - 160.0d < -9.999999747378752E-6d) {
                f = 21.2f;
                f2 = 26.6f;
            } else if (d - 170.0d > 9.999999747378752E-6d) {
                f = 29.6f;
                f2 = 43.2f;
            } else {
                f = 24.8f;
                f2 = 34.6f;
            }
        } else if (d - 150.0d < -9.999999747378752E-6d) {
            f = 16.0f;
            f2 = 20.6f;
        } else if (d - 160.0d > 9.999999747378752E-6d) {
            f = 22.1f;
            f2 = 30.3f;
        } else {
            f = 18.9f;
            f2 = 23.7f;
        }
        if (OOXIXo()) {
            f += 1.7f;
            f2 += 5.0f;
        }
        double d2 = f;
        double d3 = f2;
        return new double[]{XIXIX.OOXIXo.f3760XO, d2, d3, 1.5d * d3};
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        double d = this.f973II0xO0 / 100.0d;
        return d * d * 42.5d * 0.5d;
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
            } else if (d <= 170.0d) {
                dArr[0] = 44.0d;
                dArr[1] = 52.400001525878906d;
            } else {
                dArr[0] = 49.400001525878906d;
                dArr[1] = 59.400001525878906d;
            }
        } else if (d < 150.0d) {
            dArr[0] = 21.899999618530273d;
            dArr[1] = 34.70000076293945d;
        } else if (d <= 160.0d) {
            dArr[0] = 32.900001525878906d;
            dArr[1] = 37.5d;
        } else {
            dArr[0] = 36.5d;
            dArr[1] = 42.5d;
        }
        if (OOXIXo()) {
            dArr[0] = dArr[0] + 2.5d;
            dArr[1] = dArr[1] + 7.0d;
        }
        double d2 = dArr[0];
        if (X0o0xo2 < d2) {
            return X0o0xo2 - d2;
        }
        return XIXIX.OOXIXo.f3760XO;
    }

    @Override // Ix0x.II0XooXoX
    public double[] Oo() {
        double d;
        double d2;
        if (oOoXoXO()) {
            d = 50.0d;
            d2 = 65.0d;
        } else {
            d = 45.0d;
            d2 = 60.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
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
        double d;
        double II0XooXoX2;
        double X0o0xo2 = X0o0xo() - II0XooXoX();
        double d2 = this.f978oIX0oI;
        double d3 = (X0o0xo2 * 100.0d) / d2;
        if (d3 - 5.0d < 9.999999747378752E-6d) {
            d = (d2 * 5.0d) / 100.0d;
            II0XooXoX2 = II0XooXoX() - (d - X0o0xo2);
        } else if (d3 - 32.0d > 9.999999747378752E-6d) {
            d = (d2 * 32.0d) / 100.0d;
            II0XooXoX2 = II0XooXoX() + (X0o0xo2 - d);
        } else {
            return X0o0xo2;
        }
        this.f983x0XOIxOo.X0xII0I((II0XooXoX() * 100.0d) / this.f978oIX0oI);
        this.f983x0XOIxOo.x0xO0oo(II0XooXoX2);
        return d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] XOxIOxOx() {
        return oOXoIIIo(Oo());
    }

    @Override // Ix0x.II0XooXoX
    public double XX0xXo() {
        return (XO() * 100.0d) / this.f978oIX0oI;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        if ((r0 - 3500.0d) > 9.999999747378752E-6d) goto L12;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int Xo0() {
        /*
            r9 = this;
            boolean r0 = r9.oOoXoXO()
            if (r0 == 0) goto L27
            double r0 = r9.f982oxoX
            r2 = -4604029898846109696(0xc01b333340000000, double:-6.800000190734863)
            double r0 = r0 * r2
            r2 = 4634344754052595712(0x4050800000000000, double:66.0)
            double r0 = r0 + r2
            double r2 = r9.f973II0xO0
            r4 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r9.f978oIX0oI
            r4 = 4623902032309256192(0x402b666660000000, double:13.699999809265137)
        L23:
            double r2 = r2 * r4
            double r0 = r0 + r2
            goto L48
        L27:
            double r0 = r9.f982oxoX
            r2 = -4606394289079975936(0xc012ccccc0000000, double:-4.699999809265137)
            double r0 = r0 * r2
            r2 = 4648972656748527616(0x4084780000000000, double:655.0)
            double r0 = r0 + r2
            double r2 = r9.f973II0xO0
            r4 = 4610785298287165440(0x3ffcccccc0000000, double:1.7999999523162842)
            double r2 = r2 * r4
            double r0 = r0 + r2
            double r2 = r9.f978oIX0oI
            r4 = 4621593937822351360(0x4023333340000000, double:9.600000381469727)
            goto L23
        L48:
            boolean r2 = r9.OOXIXo()
            if (r2 == 0) goto L52
            r2 = 4608308318706860032(0x3ff4000000000000, double:1.25)
            double r0 = r0 * r2
        L52:
            r2 = 4645744490609377280(0x4079000000000000, double:400.0)
            double r4 = r0 - r2
            r6 = 4532020583461814272(0x3ee4f8b580000000, double:9.999999747378752E-6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L61
        L5f:
            r0 = r2
            goto L6d
        L61:
            r2 = 4659914996468154368(0x40ab580000000000, double:3500.0)
            double r4 = r0 - r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L6d
            goto L5f
        L6d:
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r0 = r0 + r2
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oOoXoXO.Xo0():int");
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.a XoI0Ixx0() {
        int IIxOXoOo02 = IIxOXoOo0();
        int I02 = I0();
        if (1 == IIxOXoOo02) {
            if (1 == I02) {
                return ScaleInfo.a.VT_BODY_SHAPE_SLENDER;
            }
            if (2 == I02) {
                return ScaleInfo.a.VT_BODY_SHAPE_LEAN;
            }
            return ScaleInfo.a.VT_BODY_SHAPE_WELL_BUILT;
        }
        if (2 == IIxOXoOo02) {
            if (1 == I02) {
                return ScaleInfo.a.VT_BODY_SHAPE_SLIM;
            }
            if (2 == I02) {
                return ScaleInfo.a.VT_BODY_SHAPE_FIT;
            }
            return ScaleInfo.a.VT_BODY_SHAPE_ATHLETIC;
        }
        if (1 == I02) {
            return ScaleInfo.a.VT_BODY_SHAPE_HIDDEN_FAT;
        }
        if (2 == I02) {
            return ScaleInfo.a.VT_BODY_SHAPE_CHUBBY;
        }
        return ScaleInfo.a.VT_BODY_SHAPE_BEEFY;
    }

    @Override // Ix0x.II0XooXoX
    public double[] o00() {
        return oOXoIIIo(oO());
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
        return new double[]{XIXIX.OOXIXo.f3760XO, 16.0d, 20.0d, 30.0d};
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        double I0oOIX2 = I0oOIX() * 0.7300000190734863d;
        com.vtrump.vtble.Oxx0xo.oIX0oI("TAG", "calcRatioOfWater:BWC " + I0oOIX2);
        double d = (I0oOIX2 * 100.0d) / this.f978oIX0oI;
        com.vtrump.vtble.Oxx0xo.oIX0oI("TAG", "calcRatioOfWater:BWR " + d);
        if (d - 20.0d < 9.999999747378752E-6d) {
            d = 5.0d;
        } else if (d - 85.0d > 9.999999747378752E-6d) {
            d = 32.0d;
        }
        com.vtrump.vtble.Oxx0xo.oIX0oI("TAG", "calcRatioOfWater:BWR " + d);
        return d;
    }

    @Override // Ix0x.II0XooXoX
    public double[] oxXx0IX() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f982oxoX;
        double d3 = d2 - 18.0d;
        if (oOoXoXO2) {
            if (d3 < 9.999999747378752E-6d) {
                d = 1620.0d;
            } else if (d2 - 30.0d < -9.999999747378752E-6d) {
                d = 1560.0d;
            } else if (d2 - 50.0d < -9.999999747378752E-6d) {
                d = 1561.0d;
            } else if (d2 - 70.0d < -9.999999747378752E-6d) {
                d = 1501.0d;
            } else {
                d = 1398.0d;
            }
        } else if (d3 < 9.999999747378752E-6d) {
            d = 1265.0d;
        } else if (d2 - 30.0d < -9.999999747378752E-6d) {
            d = 1298.0d;
        } else if (d2 - 50.0d < -9.999999747378752E-6d) {
            d = 1302.0d;
        } else if (d2 - 70.0d < -9.999999747378752E-6d) {
            d = 1242.0d;
        } else {
            d = 1035.0d;
        }
        if (OOXIXo()) {
            d = ((float) d) * 1.25f;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, 1.5d * d};
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0XOIxOo() {
        double[] xoXoI2 = xoXoI();
        double[] dArr = new double[xoXoI2.length];
        for (int i = 0; i < xoXoI2.length; i++) {
            dArr[i] = (xoXoI2[i] / this.f978oIX0oI) * 100.0d;
        }
        return dArr;
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        int i;
        if (oOoXoXO()) {
            i = (int) ((17.0282d - (this.f973II0xO0 * 0.237d)) + (this.f982oxoX * 0.1259d) + (this.f978oIX0oI * 0.377d) + (this.f976X0o0xo * 0.00139999995008111d));
        } else {
            i = (int) (((((this.f978oIX0oI * 0.3857d) - (this.f973II0xO0 * 0.0671d)) - (this.f982oxoX * 0.2806d)) + (this.f976X0o0xo * 0.00430000014603138d)) - 1.976d);
        }
        if (OOXIXo()) {
            i = (int) (i - 2.0f);
        }
        float f = i;
        if (f - 1.0f < 1.0E-5f) {
            return 1;
        }
        if (f - 30.0f > 1.0E-5f) {
            return 30;
        }
        return i;
    }

    @Override // Ix0x.II0XooXoX
    public double[] x0xO0oo() {
        return x0o(O0xOxO());
    }

    @Override // Ix0x.II0XooXoX
    public ScaleInfo.c xoIxX() {
        double d;
        double OO2 = ((this.f978oIX0oI - OO()) / OO()) * 100.0d;
        if (OOXIXo()) {
            d = 5.0d;
        } else {
            d = XIXIX.OOXIXo.f3760XO;
        }
        if (OO2 < (-15.0d) + d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_LIGHT;
        }
        if (OO2 <= 15.0d + d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_NORMAL;
        }
        if (OO2 <= 32.0d + d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_OVERWEIGHT;
        }
        if (OO2 <= 52.0d + d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_MILD;
        }
        if (OO2 <= d + 74.0d) {
            return ScaleInfo.c.VT_OBESITY_LEVEL_MODERATE;
        }
        return ScaleInfo.c.VT_OBESITY_LEVEL_SEVERE;
    }

    @Override // Ix0x.II0XooXoX
    public double[] xoXoI() {
        double d;
        double d2;
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f973II0xO0;
        if (oOoXoXO2) {
            if (d3 - 160.0d < -9.999999747378752E-6d) {
                d = 38.5d;
                d2 = 46.5d;
            } else if (d3 - 170.0d > 9.999999747378752E-6d) {
                d = 49.400001525878906d;
                d2 = 59.400001525878906d;
            } else {
                d = 44.0d;
                d2 = 52.400001525878906d;
            }
        } else if (d3 - 150.0d < -9.999999747378752E-6d) {
            d = 21.899999618530273d;
            d2 = 34.70000076293945d;
        } else if (d3 - 160.0d > 9.999999747378752E-6d) {
            d = 36.5d;
            d2 = 42.5d;
        } else {
            d = 32.900001525878906d;
            d2 = 37.5d;
        }
        if (OOXIXo()) {
            d += 2.5d;
            d2 += 7.0d;
        }
        return new double[]{XIXIX.OOXIXo.f3760XO, d, d2, 1.5d * d2};
    }

    @Override // Ix0x.II0XooXoX
    public double xoxXI() {
        double d;
        boolean oOoXoXO2 = oOoXoXO();
        double d2 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d2 < 19.0d) {
                d = 20.0d;
            } else if (d2 < 41.0d) {
                d = 21.0d;
            } else if (d2 < 61.0d) {
                d = 22.0d;
            } else {
                d = 24.0d;
            }
        } else if (d2 < 19.0d) {
            d = 33.0d;
        } else if (d2 < 41.0d) {
            d = 34.0d;
        } else if (d2 < 61.0d) {
            d = 35.0d;
        } else {
            d = 36.0d;
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
        double d;
        if (OOXIXo()) {
            d = 0.10000000149011612d;
        } else {
            d = 0.0d;
        }
        double d2 = d + 1.100000023841858d;
        if (this.f978oIX0oI - (OO() * d2) > 9.999999747378752E-6d) {
            return this.f978oIX0oI - (OO() * d2);
        }
        if (this.f978oIX0oI - (OO() * 0.8999999761581421d) >= -9.999999747378752E-6d) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return this.f978oIX0oI - (OO() * 0.8999999761581421d);
    }
}
