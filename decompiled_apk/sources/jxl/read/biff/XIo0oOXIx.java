package jxl.read.biff;

/* loaded from: classes6.dex */
public class XIo0oOXIx extends OoIXo.Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28278I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String[] f28279X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int[] f28280XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28281oxoX;

    /* loaded from: classes6.dex */
    public static class I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public byte[] f28282oIX0oI;

        public I0Io() {
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public boolean f28283oIX0oI;

        public II0xO0() {
        }
    }

    public XIo0oOXIx(xoxXI xoxxi, xoxXI[] xoxxiArr, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi);
        int i = 0;
        for (xoxXI xoxxi2 : xoxxiArr) {
            i += xoxxi2.oxoX();
        }
        byte[] bArr = new byte[i + oxXx0IX().oxoX()];
        System.arraycopy(oxXx0IX().I0Io(), 0, bArr, 0, oxXx0IX().oxoX());
        int oxoX2 = oxXx0IX().oxoX();
        this.f28280XO = new int[xoxxiArr.length];
        for (int i2 = 0; i2 < xoxxiArr.length; i2++) {
            xoxXI xoxxi3 = xoxxiArr[i2];
            System.arraycopy(xoxxi3.I0Io(), 0, bArr, oxoX2, xoxxi3.oxoX());
            this.f28280XO[i2] = oxoX2;
            oxoX2 += xoxxi3.oxoX();
        }
        this.f28278I0Io = OoIXo.oo0xXOI0I.oxoX(bArr[0], bArr[1], bArr[2], bArr[3]);
        int oxoX3 = OoIXo.oo0xXOI0I.oxoX(bArr[4], bArr[5], bArr[6], bArr[7]);
        this.f28281oxoX = oxoX3;
        this.f28279X0o0xo = new String[oxoX3];
        I0X0x0oIo(bArr, 8, o0xOxO);
    }

    public final void I0X0x0oIo(byte[] bArr, int i, xIoXXXIXo.O0xOxO o0xOxO) {
        boolean z;
        boolean z2;
        String Oxx0IOOO2;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.f28281oxoX) {
            int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i2], bArr[i2 + 1]);
            byte b = bArr[i2 + 2];
            int i6 = i2 + 3;
            boolean z3 = true;
            if ((b & 4) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((b & 8) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                i3 = OoIXo.oo0xXOI0I.I0Io(bArr[i6], bArr[i2 + 4]);
                i6 = i2 + 5;
            }
            int i7 = i3;
            if (z) {
                i4 = OoIXo.oo0xXOI0I.oxoX(bArr[i6], bArr[i6 + 1], bArr[i6 + 2], bArr[i6 + 3]);
                i6 += 4;
            }
            int i8 = i4;
            int i9 = i6;
            if ((b & 1) != 0) {
                z3 = false;
            }
            I0Io i0Io = new I0Io();
            II0xO0 iI0xO0 = new II0xO0();
            iI0xO0.f28283oIX0oI = z3;
            int xo0x2 = i9 + xo0x(bArr, i0Io, i9, iI0xO0, I0Io2);
            if (iI0xO0.f28283oIX0oI) {
                Oxx0IOOO2 = OoIXo.IO.oxoX(i0Io.f28282oIX0oI, I0Io2, 0, o0xOxO);
            } else {
                Oxx0IOOO2 = OoIXo.IO.Oxx0IOOO(i0Io.f28282oIX0oI, I0Io2, 0);
            }
            this.f28279X0o0xo[i5] = Oxx0IOOO2;
            if (z2) {
                xo0x2 += i7 * 4;
            }
            if (z) {
                xo0x2 += i8;
            }
            i2 = xo0x2;
            if (i2 > bArr.length) {
                XxIIOXIXx.oIX0oI.II0xO0(false, "pos exceeds record length");
            }
            i5++;
            i3 = i7;
            i4 = i8;
        }
    }

    public String XX0(int i) {
        boolean z;
        if (i < this.f28281oxoX) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        return this.f28279X0o0xo[i];
    }

    public final int xXOx(byte[] bArr, I0Io i0Io, int i, int i2, II0xO0 iI0xO0, int i3) {
        boolean z;
        int min;
        int min2;
        int min3;
        int i4 = i2;
        int i5 = i3;
        int i6 = this.f28280XO[i2];
        int i7 = 0;
        int i8 = i;
        while (i5 > 0) {
            if (i4 < this.f28280XO.length) {
                z = true;
            } else {
                z = false;
            }
            XxIIOXIXx.oIX0oI.II0xO0(z, "continuation break index");
            boolean z2 = iI0xO0.f28283oIX0oI;
            if (z2 && bArr[i6] == 0) {
                int[] iArr = this.f28280XO;
                if (i4 == iArr.length - 1) {
                    min3 = i5;
                } else {
                    min3 = Math.min(i5, (iArr[i4 + 1] - i6) - 1);
                }
                System.arraycopy(bArr, i6 + 1, i0Io.f28282oIX0oI, i8, min3);
                i8 += min3;
                i7 += min3 + 1;
                i5 -= min3;
                iI0xO0.f28283oIX0oI = true;
            } else if (!z2 && bArr[i6] != 0) {
                int[] iArr2 = this.f28280XO;
                if (i4 == iArr2.length - 1) {
                    min2 = i5 * 2;
                } else {
                    min2 = Math.min(i5 * 2, (iArr2[i4 + 1] - i6) - 1);
                }
                System.arraycopy(bArr, i6 + 1, i0Io.f28282oIX0oI, i8, min2);
                i8 += min2;
                i7 += min2 + 1;
                i5 -= min2 / 2;
                iI0xO0.f28283oIX0oI = false;
            } else if (!z2 && bArr[i6] == 0) {
                int[] iArr3 = this.f28280XO;
                if (i4 == iArr3.length - 1) {
                    min = i5;
                } else {
                    min = Math.min(i5, (iArr3[i4 + 1] - i6) - 1);
                }
                for (int i9 = 0; i9 < min; i9++) {
                    i0Io.f28282oIX0oI[i8] = bArr[i6 + i9 + 1];
                    i8 += 2;
                }
                i7 += min + 1;
                i5 -= min;
                iI0xO0.f28283oIX0oI = false;
            } else {
                byte[] bArr2 = i0Io.f28282oIX0oI;
                int i10 = i8 * 2;
                int i11 = i5 * 2;
                i0Io.f28282oIX0oI = new byte[i10 + i11];
                for (int i12 = 0; i12 < i8; i12++) {
                    i0Io.f28282oIX0oI[i12 * 2] = bArr2[i12];
                }
                int[] iArr4 = this.f28280XO;
                if (i4 != iArr4.length - 1) {
                    i11 = Math.min(i11, (iArr4[i4 + 1] - i6) - 1);
                }
                System.arraycopy(bArr, i6 + 1, i0Io.f28282oIX0oI, i10, i11);
                i7 += i11 + 1;
                i5 -= i11 / 2;
                iI0xO0.f28283oIX0oI = false;
                i8 = i10 + i11;
            }
            i4++;
            int[] iArr5 = this.f28280XO;
            if (i4 < iArr5.length) {
                i6 = iArr5[i4];
            }
        }
        return i7;
    }

    public final int xo0x(byte[] bArr, I0Io i0Io, int i, II0xO0 iI0xO0, int i2) {
        int[] iArr;
        int i3;
        if (iI0xO0.f28283oIX0oI) {
            i0Io.f28282oIX0oI = new byte[i2];
        } else {
            i0Io.f28282oIX0oI = new byte[i2 * 2];
        }
        boolean z = false;
        int i4 = 0;
        while (true) {
            iArr = this.f28280XO;
            if (i4 >= iArr.length || z) {
                break;
            }
            int i5 = iArr[i4];
            if (i <= i5 && i0Io.f28282oIX0oI.length + i > i5) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i4++;
            }
        }
        if (!z) {
            byte[] bArr2 = i0Io.f28282oIX0oI;
            System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
            return i0Io.f28282oIX0oI.length;
        }
        int i6 = iArr[i4] - i;
        System.arraycopy(bArr, i, i0Io.f28282oIX0oI, 0, i6);
        if (iI0xO0.f28283oIX0oI) {
            i3 = i6;
        } else {
            i3 = i6 / 2;
        }
        return i6 + xXOx(bArr, i0Io, i6, i4, iI0xO0, i2 - i3);
    }
}
