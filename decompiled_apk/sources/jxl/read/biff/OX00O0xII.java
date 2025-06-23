package jxl.read.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class OX00O0xII extends oOoXoXO implements xIoXXXIXo.IXxxXO, OoIXo.IIX0o, xIoXXXIXo.o00 {

    /* renamed from: Oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28242Oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(OX00O0xII.class);

    /* renamed from: oO, reason: collision with root package name */
    public String f28243oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f28244oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public jxl.biff.formula.OxxIIOOXO f28245ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public OoIXo.x0o f28246x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public byte[] f28247x0xO0oo;

    public OX00O0xII(xoxXI xoxxi, XIxXXX0x0 xIxXXX0x0, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi, xxxxox0i, i0);
        this.f28245ooOOo0oXI = oxxIIOOXO;
        this.f28246x0XOIxOo = x0oVar;
        this.f28247x0xO0oo = oxXx0IX().I0Io();
        int oxoX2 = xIxXXX0x0.oxoX();
        xoxXI Oxx0IOOO2 = xIxXXX0x0.Oxx0IOOO();
        int i = 0;
        while (Oxx0IOOO2.X0o0xo() != OoIXo.xII.f2481XxX0x0xxx && i < 4) {
            Oxx0IOOO2 = xIxXXX0x0.Oxx0IOOO();
            i++;
        }
        XxIIOXIXx.oIX0oI.II0xO0(i < 4, " @ " + oxoX2);
        byte[] I0Io2 = Oxx0IOOO2.I0Io();
        xoxXI II0XooXoX2 = xIxXXX0x0.II0XooXoX();
        while (II0XooXoX2.X0o0xo() == OoIXo.xII.f2528xoXoI) {
            xoxXI Oxx0IOOO3 = xIxXXX0x0.Oxx0IOOO();
            byte[] bArr = new byte[(I0Io2.length + Oxx0IOOO3.oxoX()) - 1];
            System.arraycopy(I0Io2, 0, bArr, 0, I0Io2.length);
            System.arraycopy(Oxx0IOOO3.I0Io(), 1, bArr, I0Io2.length, Oxx0IOOO3.oxoX() - 1);
            II0XooXoX2 = xIxXXX0x0.II0XooXoX();
            I0Io2 = bArr;
        }
        XX0(I0Io2, o0xOxO);
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28244oOoXoXO;
    }

    @Override // xIoXXXIXo.IXxxXO
    public String IoOoX() {
        return this.f28244oOoXoXO;
    }

    @Override // xIoXXXIXo.ooOOo0oXI
    public String Oxx0IOOO() throws FormulaException {
        if (this.f28243oO == null) {
            byte[] bArr = this.f28247x0xO0oo;
            int length = bArr.length - 22;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 22, bArr2, 0, length);
            jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr2, this, this.f28245ooOOo0oXI, this.f28246x0XOIxOo, xo0x().I0().XX());
            xoxoi.Oxx0IOOO();
            this.f28243oO = xoxoi.X0o0xo();
        }
        return this.f28243oO;
    }

    @Override // OoIXo.IIX0o
    public byte[] X0o0xo() throws FormulaException {
        if (xo0x().I0().II0XooXoX().XX0()) {
            byte[] bArr = this.f28247x0xO0oo;
            byte[] bArr2 = new byte[bArr.length - 6];
            System.arraycopy(bArr, 6, bArr2, 0, bArr.length - 6);
            return bArr2;
        }
        throw new FormulaException(FormulaException.BIFF8_SUPPORTED);
    }

    public final void XX0(byte[] bArr, xIoXXXIXo.O0xOxO o0xOxO) {
        boolean z = false;
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[0], bArr[1]);
        if (I0Io2 == 0) {
            this.f28244oOoXoXO = "";
            return;
        }
        int i = 2;
        byte b = bArr[2];
        if ((b & 15) != b) {
            I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[0], (byte) 0);
            b = bArr[1];
        } else {
            i = 3;
        }
        if ((b & 4) != 0) {
            z = true;
        }
        if ((b & 8) != 0) {
            i += 2;
        }
        if (z) {
            i += 4;
        }
        if ((b & 1) == 0) {
            this.f28244oOoXoXO = OoIXo.IO.oxoX(bArr, I0Io2, i, o0xOxO);
        } else {
            this.f28244oOoXoXO = OoIXo.IO.Oxx0IOOO(bArr, I0Io2, i);
        }
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34242xxIXOIIO;
    }

    public OX00O0xII(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0) {
        super(xoxxi, xxxxox0i, i0);
        this.f28245ooOOo0oXI = oxxIIOOXO;
        this.f28246x0XOIxOo = x0oVar;
        this.f28247x0xO0oo = oxXx0IX().I0Io();
        this.f28244oOoXoXO = "";
    }
}
