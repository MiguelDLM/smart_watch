package jxl.read.biff;

/* loaded from: classes6.dex */
public class xX0IIXIx0 extends OoIXo.Xx000oIo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final II0xO0 f28497II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final II0xO0 f28498OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28499Oxx0IOOO = XxIIOXIXx.X0o0xo.Oxx0IOOO(xX0IIXIx0.class);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final II0xO0 f28500oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final II0xO0 f28501xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final II0xO0 f28502xxIXOIIO;

    /* renamed from: I0Io, reason: collision with root package name */
    public II0xO0 f28503I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f28504X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String[] f28505XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28506oxoX;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    static {
        f28497II0XooXoX = new II0xO0();
        f28502xxIXOIIO = new II0xO0();
        f28501xoIox = new II0xO0();
        f28498OOXIXo = new II0xO0();
        f28500oOoXoXO = new II0xO0();
    }

    public xX0IIXIx0(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        if (I0Io2.length == 4) {
            byte b = I0Io2[2];
            if (b == 1 && I0Io2[3] == 4) {
                this.f28503I0Io = f28497II0XooXoX;
            } else if (b == 1 && I0Io2[3] == 58) {
                this.f28503I0Io = f28501xoIox;
            } else {
                this.f28503I0Io = f28500oOoXoXO;
            }
        } else if (I0Io2[0] == 0 && I0Io2[1] == 0) {
            this.f28503I0Io = f28498OOXIXo;
        } else {
            this.f28503I0Io = f28502xxIXOIIO;
        }
        if (this.f28503I0Io == f28497II0XooXoX) {
            this.f28506oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        }
        if (this.f28503I0Io == f28502xxIXOIIO) {
            O0Xx(I0Io2, o0xOxO);
        }
    }

    public int I0X0x0oIo() {
        return this.f28506oxoX;
    }

    public final void O0Xx(byte[] bArr, xIoXXXIXo.O0xOxO o0xOxO) {
        int i;
        int i2;
        this.f28506oxoX = OoIXo.oo0xXOI0I.I0Io(bArr[0], bArr[1]);
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[2], bArr[3]);
        int i3 = I0Io2 - 1;
        if (bArr[4] == 0) {
            if (bArr[5] == 0) {
                this.f28504X0o0xo = OoIXo.IO.oxoX(bArr, i3, 6, o0xOxO);
            } else {
                this.f28504X0o0xo = xXOx(bArr, i3, 6);
            }
            i = I0Io2 + 5;
        } else {
            if (OoIXo.oo0xXOI0I.I0Io(bArr[5], bArr[6]) == 0) {
                this.f28504X0o0xo = OoIXo.IO.Oxx0IOOO(bArr, i3, 7);
            } else {
                this.f28504X0o0xo = XoI0Ixx0(bArr, i3, 7);
            }
            i = (i3 * 2) + 7;
        }
        this.f28505XO = new String[this.f28506oxoX];
        for (int i4 = 0; i4 < this.f28505XO.length; i4++) {
            int I0Io3 = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
            byte b = bArr[i + 2];
            if (b == 0) {
                this.f28505XO[i4] = OoIXo.IO.oxoX(bArr, I0Io3, i + 3, o0xOxO);
                i2 = I0Io3 + 3;
            } else if (b == 1) {
                this.f28505XO[i4] = OoIXo.IO.Oxx0IOOO(bArr, I0Io3, i + 3);
                i2 = (I0Io3 * 2) + 3;
            }
            i += i2;
        }
    }

    public String XX0() {
        return this.f28504X0o0xo;
    }

    public II0xO0 Xo0() {
        return this.f28503I0Io;
    }

    public final String XoI0Ixx0(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = (i * 2) + i2;
        while (i2 < i3) {
            char I0Io2 = (char) OoIXo.oo0xXOI0I.I0Io(bArr[i2], bArr[i2 + 1]);
            if (I0Io2 == 1) {
                int i4 = i2 + 2;
                stringBuffer.append((char) OoIXo.oo0xXOI0I.I0Io(bArr[i4], bArr[i2 + 3]));
                stringBuffer.append(":\\\\");
                i2 = i4;
            } else if (I0Io2 == 2) {
                stringBuffer.append('\\');
            } else if (I0Io2 == 3) {
                stringBuffer.append('\\');
            } else if (I0Io2 == 4) {
                stringBuffer.append("..\\");
            } else {
                stringBuffer.append(I0Io2);
            }
            i2 += 2;
        }
        return stringBuffer.toString();
    }

    public String oX(int i) {
        return this.f28505XO[i];
    }

    public final String xXOx(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i + i2;
        while (i2 < i3) {
            char c = (char) bArr[i2];
            if (c == 1) {
                i2++;
                stringBuffer.append((char) bArr[i2]);
                stringBuffer.append(":\\\\");
            } else if (c == 2) {
                stringBuffer.append('\\');
            } else if (c == 3) {
                stringBuffer.append('\\');
            } else if (c == 4) {
                stringBuffer.append("..\\");
            } else {
                stringBuffer.append(c);
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    public byte[] xo0x() {
        return oxXx0IX().I0Io();
    }
}
