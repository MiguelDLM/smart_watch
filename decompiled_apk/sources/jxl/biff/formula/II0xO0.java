package jxl.biff.formula;

/* loaded from: classes6.dex */
public class II0xO0 extends IO implements o0 {

    /* renamed from: Oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27660Oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(II0xO0.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f27661II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f27662OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f27663Oxx0IOOO;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f27664oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f27665oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f27666ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f27667x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public OxxIIOOXO f27668x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f27669xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f27670xxIXOIIO;

    public II0xO0(OxxIIOOXO oxxIIOOXO) {
        this.f27668x0xO0oo = oxxIIOOXO;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void I0Io(int i, int i2, boolean z) {
        if (i != this.f27663Oxx0IOOO) {
            return;
        }
        int i3 = this.f27661II0XooXoX;
        if (i2 < i3) {
            this.f27661II0XooXoX = i3 - 1;
        }
        int i4 = this.f27669xoIox;
        if (i2 <= i4) {
            this.f27669xoIox = i4 - 1;
        }
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void II0xO0(int i, int i2, boolean z) {
        if (i != this.f27663Oxx0IOOO) {
            return;
        }
        int i3 = this.f27661II0XooXoX;
        if (i3 >= i2) {
            this.f27661II0XooXoX = i3 + 1;
        }
        int i4 = this.f27669xoIox;
        if (i4 >= i2) {
            this.f27669xoIox = i4 + 1;
        }
    }

    public void IIXOooo(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f27663Oxx0IOOO = i;
        this.f27661II0XooXoX = i2;
        this.f27669xoIox = i3;
        this.f27670xxIXOIIO = i4;
        this.f27662OOXIXo = i5;
        this.f27665oOoXoXO = z;
        this.f27667x0XOIxOo = z2;
        this.f27666ooOOo0oXI = z3;
        this.f27664oO = z4;
    }

    public int IXxxXO() {
        return this.f27661II0XooXoX;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void OOXIXo(int i, int i2, boolean z) {
        int i3;
        if (i != this.f27663Oxx0IOOO || (i3 = this.f27662OOXIXo) == 65535) {
            return;
        }
        int i4 = this.f27670xxIXOIIO;
        if (i2 < i4) {
            this.f27670xxIXOIIO = i4 - 1;
        }
        if (i2 <= i3) {
            this.f27662OOXIXo = i3 - 1;
        }
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
        ooOOo0oXI();
    }

    public int Oxx0xo() {
        return this.f27670xxIXOIIO;
    }

    public int OxxIIOOXO() {
        return this.f27662OOXIXo;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OoIXo.oOoXoXO.I0Io(this.f27663Oxx0IOOO, this.f27661II0XooXoX, this.f27670xxIXOIIO, this.f27668x0xO0oo, stringBuffer);
        stringBuffer.append(':');
        OoIXo.oOoXoXO.oxoX(this.f27669xoIox, this.f27662OOXIXo, stringBuffer);
    }

    public int oI0IIXIo() {
        return this.f27669xoIox;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void oIX0oI(int i, int i2) {
        if (this.f27665oOoXoXO) {
            this.f27661II0XooXoX += i;
        }
        if (this.f27667x0XOIxOo) {
            this.f27669xoIox += i;
        }
        if (this.f27666ooOOo0oXI) {
            this.f27670xxIXOIIO += i2;
        }
        if (this.f27664oO) {
            this.f27662OOXIXo += i2;
        }
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] bArr = new byte[11];
        bArr[0] = xoxXI.f28017IXxxXO.oIX0oI();
        OoIXo.oo0xXOI0I.XO(this.f27663Oxx0IOOO, bArr, 1);
        OoIXo.oo0xXOI0I.XO(this.f27670xxIXOIIO, bArr, 3);
        OoIXo.oo0xXOI0I.XO(this.f27662OOXIXo, bArr, 5);
        int i = this.f27661II0XooXoX;
        if (this.f27666ooOOo0oXI) {
            i |= 32768;
        }
        if (this.f27665oOoXoXO) {
            i |= 16384;
        }
        OoIXo.oo0xXOI0I.XO(i, bArr, 7);
        int i2 = this.f27669xoIox;
        if (this.f27664oO) {
            i2 |= 32768;
        }
        if (this.f27667x0XOIxOo) {
            i2 |= 16384;
        }
        OoIXo.oo0xXOI0I.XO(i2, bArr, 9);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        this.f27663Oxx0IOOO = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
        this.f27670xxIXOIIO = OoIXo.oo0xXOI0I.I0Io(bArr[i + 2], bArr[i + 3]);
        this.f27662OOXIXo = OoIXo.oo0xXOI0I.I0Io(bArr[i + 4], bArr[i + 5]);
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 6], bArr[i + 7]);
        this.f27661II0XooXoX = I0Io2 & 255;
        boolean z4 = false;
        if ((I0Io2 & 16384) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f27665oOoXoXO = z;
        if ((I0Io2 & 32768) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f27666ooOOo0oXI = z2;
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 8], bArr[i + 9]);
        this.f27669xoIox = I0Io3 & 255;
        if ((I0Io3 & 16384) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f27667x0XOIxOo = z3;
        if ((I0Io3 & 32768) != 0) {
            z4 = true;
        }
        this.f27664oO = z4;
        return 10;
    }

    @Override // jxl.biff.formula.IO, jxl.biff.formula.OI0
    public void xoIox(int i, int i2, boolean z) {
        int i3;
        if (i != this.f27663Oxx0IOOO || (i3 = this.f27662OOXIXo) == 65535) {
            return;
        }
        int i4 = this.f27670xxIXOIIO;
        if (i2 <= i4) {
            this.f27670xxIXOIIO = i4 + 1;
        }
        if (i2 <= i3) {
            this.f27662OOXIXo = i3 + 1;
        }
    }

    public II0xO0(String str, OxxIIOOXO oxxIIOOXO) throws FormulaException {
        this.f27668x0xO0oo = oxxIIOOXO;
        int lastIndexOf = str.lastIndexOf(":");
        XxIIOXIXx.oIX0oI.oIX0oI(lastIndexOf != -1);
        String substring = str.substring(lastIndexOf + 1);
        int indexOf = str.indexOf(33);
        String substring2 = str.substring(indexOf + 1, lastIndexOf);
        this.f27661II0XooXoX = OoIXo.oOoXoXO.Oxx0IOOO(substring2);
        this.f27670xxIXOIIO = OoIXo.oOoXoXO.OOXIXo(substring2);
        String substring3 = str.substring(0, indexOf);
        if (substring3.charAt(0) == '\'' && substring3.charAt(substring3.length() - 1) == '\'') {
            substring3 = substring3.substring(1, substring3.length() - 1);
        }
        int XO2 = oxxIIOOXO.XO(substring3);
        this.f27663Oxx0IOOO = XO2;
        if (XO2 >= 0) {
            this.f27669xoIox = OoIXo.oOoXoXO.Oxx0IOOO(substring);
            this.f27662OOXIXo = OoIXo.oOoXoXO.OOXIXo(substring);
            this.f27665oOoXoXO = true;
            this.f27666ooOOo0oXI = true;
            this.f27667x0XOIxOo = true;
            this.f27664oO = true;
            return;
        }
        throw new FormulaException(FormulaException.SHEET_REF_NOT_FOUND, substring3);
    }
}
