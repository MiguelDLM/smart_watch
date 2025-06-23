package jxl.biff.formula;

/* loaded from: classes6.dex */
public class xxIXOIIO extends IO implements o0 {

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28088x0XOIxOo = XxIIOXIXx.X0o0xo.Oxx0IOOO(xxIXOIIO.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f28089II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public xIoXXXIXo.I0Io f28090OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f28091Oxx0IOOO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f28092oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public OxxIIOOXO f28093ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28094xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28095xxIXOIIO;

    public xxIXOIIO(xIoXXXIXo.I0Io i0Io, OxxIIOOXO oxxIIOOXO) {
        this.f28090OOXIXo = i0Io;
        this.f28093ooOOo0oXI = oxxIIOOXO;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void I0Io(int i, int i2, boolean z) {
        int i3;
        if (i == this.f28092oOoXoXO && (i3 = this.f28095xxIXOIIO) >= i2) {
            this.f28095xxIXOIIO = i3 - 1;
        }
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void II0xO0(int i, int i2, boolean z) {
        int i3;
        if (i == this.f28092oOoXoXO && (i3 = this.f28095xxIXOIIO) >= i2) {
            this.f28095xxIXOIIO = i3 + 1;
        }
    }

    public int IXxxXO() {
        return this.f28095xxIXOIIO;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void OOXIXo(int i, int i2, boolean z) {
        int i3;
        if (i == this.f28092oOoXoXO && (i3 = this.f28094xoIox) >= i2) {
            this.f28094xoIox = i3 - 1;
        }
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
        ooOOo0oXI();
    }

    public int Oxx0xo() {
        return this.f28094xoIox;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OoIXo.oOoXoXO.X0o0xo(this.f28092oOoXoXO, this.f28095xxIXOIIO, !this.f28091Oxx0IOOO, this.f28094xoIox, !this.f28089II0XooXoX, this.f28093ooOOo0oXI, stringBuffer);
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void oIX0oI(int i, int i2) {
        if (this.f28091Oxx0IOOO) {
            this.f28095xxIXOIIO += i;
        }
        if (this.f28089II0XooXoX) {
            this.f28094xoIox += i2;
        }
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] bArr = new byte[7];
        bArr[0] = xoxXI.f28043oxoX.oIX0oI();
        OoIXo.oo0xXOI0I.XO(this.f28092oOoXoXO, bArr, 1);
        OoIXo.oo0xXOI0I.XO(this.f28094xoIox, bArr, 3);
        int i = this.f28095xxIXOIIO;
        if (this.f28089II0XooXoX) {
            i |= 32768;
        }
        if (this.f28091Oxx0IOOO) {
            i |= 16384;
        }
        OoIXo.oo0xXOI0I.XO(i, bArr, 5);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        boolean z;
        this.f28092oOoXoXO = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
        this.f28094xoIox = OoIXo.oo0xXOI0I.I0Io(bArr[i + 2], bArr[i + 3]);
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 4], bArr[i + 5]);
        this.f28095xxIXOIIO = I0Io2 & 255;
        boolean z2 = false;
        if ((I0Io2 & 16384) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f28091Oxx0IOOO = z;
        if ((I0Io2 & 32768) != 0) {
            z2 = true;
        }
        this.f28089II0XooXoX = z2;
        return 6;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void xoIox(int i, int i2, boolean z) {
        int i3;
        if (i == this.f28092oOoXoXO && (i3 = this.f28094xoIox) >= i2) {
            this.f28094xoIox = i3 + 1;
        }
    }

    public xxIXOIIO(String str, OxxIIOOXO oxxIIOOXO) throws FormulaException {
        this.f28093ooOOo0oXI = oxxIIOOXO;
        this.f28091Oxx0IOOO = true;
        this.f28089II0XooXoX = true;
        int indexOf = str.indexOf(33);
        String substring = str.substring(indexOf + 1);
        this.f28095xxIXOIIO = OoIXo.oOoXoXO.Oxx0IOOO(substring);
        this.f28094xoIox = OoIXo.oOoXoXO.OOXIXo(substring);
        String substring2 = str.substring(0, indexOf);
        if (substring2.charAt(0) == '\'' && substring2.charAt(substring2.length() - 1) == '\'') {
            substring2 = substring2.substring(1, substring2.length() - 1);
        }
        int XO2 = oxxIIOOXO.XO(substring2);
        this.f28092oOoXoXO = XO2;
        if (XO2 < 0) {
            throw new FormulaException(FormulaException.SHEET_REF_NOT_FOUND, substring2);
        }
    }
}
