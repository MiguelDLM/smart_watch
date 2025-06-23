package Ix0x;

import com.qq.e.comm.constants.ErrorCode;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;

/* loaded from: classes13.dex */
public class oI0IIXIo extends II0XooXoX {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static oI0IIXIo f1003oI0IIXIo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int[] f1004IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f1005Oxx0xo = false;

    public static oI0IIXIo I0() {
        oI0IIXIo oi0iixio = f1003oI0IIXIo;
        if (oi0iixio == null) {
            oI0IIXIo oi0iixio2 = new oI0IIXIo();
            f1003oI0IIXIo = oi0iixio2;
            return oi0iixio2;
        }
        return oi0iixio;
    }

    @Override // Ix0x.II0XooXoX
    public double I0Io() {
        int[] iArr = this.f1004IXxxXO;
        double d = ((iArr[10] * 256) + iArr[11]) / 10.0d;
        if (this.f1005Oxx0xo) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d;
    }

    @Override // Ix0x.II0XooXoX
    public int I0X0x0oIo() {
        if (this.f1005Oxx0xo) {
            return 0;
        }
        return (int) OOXIxO0(Ioxxx());
    }

    @Override // Ix0x.II0XooXoX
    public double I0oOIX() {
        double Ioxxx2 = this.f978oIX0oI * (1.0d - (Ioxxx() / 100.0d));
        if (this.f1005Oxx0xo) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return Ioxxx2;
    }

    @Override // Ix0x.II0XooXoX
    public double II0XooXoX() {
        return (this.f978oIX0oI * ox()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    /* renamed from: IIxOXoOo0, reason: merged with bridge method [inline-methods] */
    public oI0IIXIo xxX(ScaleUserInfo scaleUserInfo, byte[] bArr) {
        this.f1004IXxxXO = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            this.f1004IXxxXO[i] = 255 & bArr[i];
        }
        super.xxX(scaleUserInfo, bArr);
        int[] iArr = this.f1004IXxxXO;
        if (iArr[6] != 255 && iArr[7] != 255) {
            this.f1005Oxx0xo = false;
            this.f983x0XOIxOo.xx0X0(0);
        } else {
            this.f983x0XOIxOo.xx0X0(ErrorCode.SKIP_VIEW_SIZE_ERROR);
            this.f1005Oxx0xo = true;
        }
        return this;
    }

    @Override // Ix0x.II0XooXoX
    public double Ioxxx() {
        int[] iArr = this.f1004IXxxXO;
        double d = ((iArr[6] * 256) + iArr[7]) / 10.0d;
        if (this.f1005Oxx0xo) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d;
    }

    @Override // Ix0x.II0XooXoX
    public double O00XxXI() {
        double Ioxxx2 = Ioxxx() - this.f1004IXxxXO[14];
        if (this.f1005Oxx0xo) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return Ioxxx2;
    }

    @Override // Ix0x.II0XooXoX
    public double OO() {
        double d;
        if (oOoXoXO()) {
            d = 24.200000762939453d;
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
        boolean oOoXoXO2 = oOoXoXO();
        double d3 = this.f982oxoX;
        if (oOoXoXO2) {
            if (d3 < 18.0d) {
                d = this.f978oIX0oI;
                d2 = 0.30000001192092896d;
            }
            d = this.f978oIX0oI;
            d2 = 0.25d;
        } else {
            if (d3 >= 18.0d) {
                d = this.f978oIX0oI;
                d2 = 0.20000000298023224d;
            }
            d = this.f978oIX0oI;
            d2 = 0.25d;
        }
        double d4 = d * d2;
        if (X0o0xo() < d4) {
            return X0o0xo() - d4;
        }
        return XIXIX.OOXIXo.f3760XO;
    }

    public double OOXIxO0(double d) {
        double ooOx2;
        double d2;
        double d3;
        double d4;
        double d5 = this.f978oIX0oI;
        double d6 = (1.0d - (d / 100.0d)) * d5;
        int i = this.f971I0Io;
        double d7 = 0.10000000149011612d;
        if (i != 0) {
            if (i != 1) {
                d7 = 0.2d;
                d3 = 0.1d;
                d4 = 0.1d;
                return ((1.0d - d7) * this.f982oxoX) + ((d7 * (d3 + d4)) / 2.0d);
            }
            ooOx2 = (28.746d - (d6 / ooOx(d5, this.f973II0xO0))) / 0.03200000151991844d;
            d2 = (d - 21.99d) / 0.097d;
        } else {
            ooOx2 = (34.668d - (d6 / ooOx(d5, this.f973II0xO0))) / 0.10000000149011612d;
            d2 = (d - 10.74d) / 0.2589d;
            d7 = 0.20000000298023224d;
        }
        double d8 = d2;
        d3 = ooOx2;
        d4 = d8;
        return ((1.0d - d7) * this.f982oxoX) + ((d7 * (d3 + d4)) / 2.0d);
    }

    @Override // Ix0x.II0XooXoX
    public double Oxx0IOOO() {
        return X0o0xo() * 0.7099999785423279d;
    }

    @Override // Ix0x.II0XooXoX
    public double X0o0xo() {
        return (this.f978oIX0oI * xxIO()) / 100.0d;
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
        } else if (d14 <= 30.0d) {
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
        } else if (d14 <= 40.0d) {
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
        } else if (d14 <= 60.0d) {
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
        int[] iArr = this.f1004IXxxXO;
        double d = (((iArr[12] * 256) + iArr[13]) / 10.0d) * 0.625d;
        if (this.f1005Oxx0xo) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d;
    }

    @Override // Ix0x.II0XooXoX
    public int Xo0() {
        int[] iArr = this.f1004IXxxXO;
        int i = (iArr[15] * 256) + iArr[16];
        if (this.f1005Oxx0xo) {
            return 0;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x006e, code lost:
    
        if (r1 <= 33.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0080, code lost:
    
        if (r1 <= 34.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0093, code lost:
    
        if (r1 <= 35.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00a0, code lost:
    
        if (r1 <= 36.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00c6, code lost:
    
        if (r3 <= 75.0d) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00f6, code lost:
    
        r2 = 1;
        r3 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f3, code lost:
    
        r2 = 1;
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d0, code lost:
    
        if (r3 <= 55.0d) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e3, code lost:
    
        if (r3 <= 65.0d) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f1, code lost:
    
        if (r3 <= 55.0d) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00a2, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
    
        if (r1 <= 21.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x003c, code lost:
    
        if (r1 <= 21.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00a4, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x004d, code lost:
    
        if (r1 <= 22.0d) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x005b, code lost:
    
        if (r1 <= 24.0d) goto L61;
     */
    @Override // Ix0x.II0XooXoX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.vtrump.vtble.Scale.ScaleInfo.a XoI0Ixx0() {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Ix0x.oI0IIXIo.XoI0Ixx0():com.vtrump.vtble.Scale.ScaleInfo$a");
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

    public double ooOx(double d, double d2) {
        return ((Math.pow(d, 0.444d) * Math.pow(d2, 0.663d)) * 88.83d) / 10000.0d;
    }

    @Override // Ix0x.II0XooXoX
    public double ox() {
        int[] iArr = this.f1004IXxxXO;
        double d = ((iArr[8] * 256) + iArr[9]) / 10.0d;
        if (this.f1005Oxx0xo) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d;
    }

    @Override // Ix0x.II0XooXoX
    public double oxoX() {
        return (this.f978oIX0oI * Ioxxx()) / 100.0d;
    }

    @Override // Ix0x.II0XooXoX
    public int x0xO() {
        int i = this.f1004IXxxXO[14];
        if (this.f1005Oxx0xo) {
            i = 0;
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
        int[] iArr = this.f1004IXxxXO;
        double d = ((iArr[12] * 256) + iArr[13]) / 10.0d;
        if (this.f1005Oxx0xo) {
            return XIXIX.OOXIXo.f3760XO;
        }
        return d;
    }

    @Override // Ix0x.II0XooXoX
    public double xxIXOIIO() {
        return this.f978oIX0oI - OO();
    }
}
