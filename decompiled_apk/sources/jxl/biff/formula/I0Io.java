package jxl.biff.formula;

/* loaded from: classes6.dex */
public class I0Io extends IO implements o0 {

    /* renamed from: oO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27645oO = XxIIOXIXx.X0o0xo.Oxx0IOOO(I0Io.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f27646II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f27647OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f27648Oxx0IOOO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f27649oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f27650ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f27651x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f27652xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f27653xxIXOIIO;

    public I0Io() {
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void I0Io(int i, int i2, boolean z) {
        if (!z) {
            return;
        }
        int i3 = this.f27648Oxx0IOOO;
        if (i2 < i3) {
            this.f27648Oxx0IOOO = i3 - 1;
        }
        int i4 = this.f27653xxIXOIIO;
        if (i2 <= i4) {
            this.f27653xxIXOIIO = i4 - 1;
        }
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void II0xO0(int i, int i2, boolean z) {
        if (!z) {
            return;
        }
        int i3 = this.f27648Oxx0IOOO;
        if (i2 <= i3) {
            this.f27648Oxx0IOOO = i3 + 1;
        }
        int i4 = this.f27653xxIXOIIO;
        if (i2 <= i4) {
            this.f27653xxIXOIIO = i4 + 1;
        }
    }

    public void IIXOooo(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f27648Oxx0IOOO = i;
        this.f27653xxIXOIIO = i2;
        this.f27646II0XooXoX = i3;
        this.f27652xoIox = i4;
        this.f27647OOXIXo = z;
        this.f27650ooOOo0oXI = z2;
        this.f27649oOoXoXO = z3;
        this.f27651x0XOIxOo = z4;
    }

    public int IXxxXO() {
        return this.f27648Oxx0IOOO;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void OOXIXo(int i, int i2, boolean z) {
        int i3;
        if (!z || (i3 = this.f27652xoIox) == 65535) {
            return;
        }
        int i4 = this.f27646II0XooXoX;
        if (i2 < i4) {
            this.f27646II0XooXoX = i4 - 1;
        }
        if (i2 <= i3) {
            this.f27652xoIox = i3 - 1;
        }
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    public int Oxx0xo() {
        return this.f27646II0XooXoX;
    }

    public int OxxIIOOXO() {
        return this.f27652xoIox;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OoIXo.oOoXoXO.oxoX(this.f27648Oxx0IOOO, this.f27646II0XooXoX, stringBuffer);
        stringBuffer.append(':');
        OoIXo.oOoXoXO.oxoX(this.f27653xxIXOIIO, this.f27652xoIox, stringBuffer);
    }

    public int oI0IIXIo() {
        return this.f27653xxIXOIIO;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void oIX0oI(int i, int i2) {
        if (this.f27647OOXIXo) {
            this.f27648Oxx0IOOO += i;
        }
        if (this.f27650ooOOo0oXI) {
            this.f27653xxIXOIIO += i;
        }
        if (this.f27649oOoXoXO) {
            this.f27646II0XooXoX += i2;
        }
        if (this.f27651x0XOIxOo) {
            this.f27652xoIox += i2;
        }
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte II0xO02;
        byte[] bArr = new byte[9];
        if (!Oo()) {
            II0xO02 = xoxXI.f28036oO.oIX0oI();
        } else {
            II0xO02 = xoxXI.f28036oO.II0xO0();
        }
        bArr[0] = II0xO02;
        OoIXo.oo0xXOI0I.XO(this.f27646II0XooXoX, bArr, 1);
        OoIXo.oo0xXOI0I.XO(this.f27652xoIox, bArr, 3);
        int i = this.f27648Oxx0IOOO;
        if (this.f27649oOoXoXO) {
            i |= 32768;
        }
        if (this.f27647OOXIXo) {
            i |= 16384;
        }
        OoIXo.oo0xXOI0I.XO(i, bArr, 5);
        int i2 = this.f27653xxIXOIIO;
        if (this.f27651x0XOIxOo) {
            i2 |= 32768;
        }
        if (this.f27650ooOOo0oXI) {
            i2 |= 16384;
        }
        OoIXo.oo0xXOI0I.XO(i2, bArr, 7);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        this.f27646II0XooXoX = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
        this.f27652xoIox = OoIXo.oo0xXOI0I.I0Io(bArr[i + 2], bArr[i + 3]);
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 4], bArr[i + 5]);
        this.f27648Oxx0IOOO = I0Io2 & 255;
        boolean z4 = false;
        if ((I0Io2 & 16384) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f27647OOXIXo = z;
        if ((I0Io2 & 32768) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f27649oOoXoXO = z2;
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 6], bArr[i + 7]);
        this.f27653xxIXOIIO = I0Io3 & 255;
        if ((I0Io3 & 16384) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f27650ooOOo0oXI = z3;
        if ((I0Io3 & 32768) != 0) {
            z4 = true;
        }
        this.f27651x0XOIxOo = z4;
        return 8;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void xoIox(int i, int i2, boolean z) {
        int i3;
        if (!z || (i3 = this.f27652xoIox) == 65535) {
            return;
        }
        int i4 = this.f27646II0XooXoX;
        if (i2 <= i4) {
            this.f27646II0XooXoX = i4 + 1;
        }
        if (i2 <= i3) {
            this.f27652xoIox = i3 + 1;
        }
    }

    public I0Io(String str) {
        int indexOf = str.indexOf(":");
        XxIIOXIXx.oIX0oI.oIX0oI(indexOf != -1);
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        this.f27648Oxx0IOOO = OoIXo.oOoXoXO.Oxx0IOOO(substring);
        this.f27646II0XooXoX = OoIXo.oOoXoXO.OOXIXo(substring);
        this.f27653xxIXOIIO = OoIXo.oOoXoXO.Oxx0IOOO(substring2);
        this.f27652xoIox = OoIXo.oOoXoXO.OOXIXo(substring2);
        this.f27647OOXIXo = OoIXo.oOoXoXO.ooOOo0oXI(substring);
        this.f27649oOoXoXO = OoIXo.oOoXoXO.x0XOIxOo(substring);
        this.f27650ooOOo0oXI = OoIXo.oOoXoXO.ooOOo0oXI(substring2);
        this.f27651x0XOIxOo = OoIXo.oOoXoXO.x0XOIxOo(substring2);
    }
}
