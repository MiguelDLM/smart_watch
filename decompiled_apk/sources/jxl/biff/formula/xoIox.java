package jxl.biff.formula;

/* loaded from: classes6.dex */
public class xoIox extends IO implements o0 {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28004oOoXoXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(xoIox.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f28005II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public xIoXXXIXo.I0Io f28006OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f28007Oxx0IOOO;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28008xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28009xxIXOIIO;

    public xoIox(xIoXXXIXo.I0Io i0Io) {
        this.f28006OOXIXo = i0Io;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void I0Io(int i, int i2, boolean z) {
        int i3;
        if (z && (i3 = this.f28009xxIXOIIO) >= i2) {
            this.f28009xxIXOIIO = i3 - 1;
        }
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void II0xO0(int i, int i2, boolean z) {
        int i3;
        if (z && (i3 = this.f28009xxIXOIIO) >= i2) {
            this.f28009xxIXOIIO = i3 + 1;
        }
    }

    public int IXxxXO() {
        return this.f28009xxIXOIIO;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void OOXIXo(int i, int i2, boolean z) {
        int i3;
        if (z && (i3 = this.f28008xoIox) >= i2) {
            this.f28008xoIox = i3 - 1;
        }
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    public int Oxx0xo() {
        return this.f28008xoIox;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OoIXo.oOoXoXO.XO(this.f28009xxIXOIIO, !this.f28007Oxx0IOOO, this.f28008xoIox, !this.f28005II0XooXoX, stringBuffer);
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void oIX0oI(int i, int i2) {
        if (this.f28007Oxx0IOOO) {
            this.f28009xxIXOIIO += i;
        }
        if (this.f28005II0XooXoX) {
            this.f28008xoIox += i2;
        }
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte II0xO02;
        byte[] bArr = new byte[5];
        if (!Oo()) {
            II0xO02 = xoxXI.f28012I0Io.oIX0oI();
        } else {
            II0xO02 = xoxXI.f28012I0Io.II0xO0();
        }
        bArr[0] = II0xO02;
        OoIXo.oo0xXOI0I.XO(this.f28008xoIox, bArr, 1);
        int i = this.f28009xxIXOIIO;
        if (this.f28005II0XooXoX) {
            i |= 32768;
        }
        if (this.f28007Oxx0IOOO) {
            i |= 16384;
        }
        OoIXo.oo0xXOI0I.XO(i, bArr, 3);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        boolean z;
        this.f28008xoIox = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 2], bArr[i + 3]);
        this.f28009xxIXOIIO = I0Io2 & 255;
        boolean z2 = false;
        if ((I0Io2 & 16384) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f28007Oxx0IOOO = z;
        if ((I0Io2 & 32768) != 0) {
            z2 = true;
        }
        this.f28005II0XooXoX = z2;
        return 4;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void xoIox(int i, int i2, boolean z) {
        int i3;
        if (z && (i3 = this.f28008xoIox) >= i2) {
            this.f28008xoIox = i3 + 1;
        }
    }

    public xoIox() {
    }

    public xoIox(String str) {
        this.f28009xxIXOIIO = OoIXo.oOoXoXO.Oxx0IOOO(str);
        this.f28008xoIox = OoIXo.oOoXoXO.OOXIXo(str);
        this.f28007Oxx0IOOO = OoIXo.oOoXoXO.ooOOo0oXI(str);
        this.f28005II0XooXoX = OoIXo.oOoXoXO.x0XOIxOo(str);
    }
}
