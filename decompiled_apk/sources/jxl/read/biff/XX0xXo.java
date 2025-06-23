package jxl.read.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class XX0xXo extends II0xO0 implements xIoXXXIXo.oIX0oI, OoIXo.IIX0o, xIoXXXIXo.II0xO0 {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28303IXxxXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(XX0xXo.class);

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f28304Oo;

    public XX0xXo(xoxXI xoxxi, XIxXXX0x0 xIxXXX0x0, boolean z, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0) {
        super(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0, xIxXXX0x0.oxoX());
        this.f28304Oo = z;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return new Boolean(this.f28304Oo).toString();
    }

    @Override // OoIXo.IIX0o
    public byte[] X0o0xo() throws FormulaException {
        if (xo0x().ooOx().XX0()) {
            jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(Xo0(), this, XX0(), oX(), xo0x().I0().XX());
            xoxoi.Oxx0IOOO();
            byte[] oxoX2 = xoxoi.oxoX();
            int length = oxoX2.length;
            byte[] bArr = new byte[length + 22];
            OoIXo.oo0xXOI0I.XO(II0xO0(), bArr, 0);
            OoIXo.oo0xXOI0I.XO(oIX0oI(), bArr, 2);
            OoIXo.oo0xXOI0I.XO(xXOx(), bArr, 4);
            int i = 1;
            bArr[6] = 1;
            if (!this.f28304Oo) {
                i = 0;
            }
            bArr[8] = (byte) i;
            bArr[12] = -1;
            bArr[13] = -1;
            System.arraycopy(oxoX2, 0, bArr, 22, oxoX2.length);
            OoIXo.oo0xXOI0I.XO(oxoX2.length, bArr, 20);
            int i2 = length + 16;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 6, bArr2, 0, i2);
            return bArr2;
        }
        throw new FormulaException(FormulaException.BIFF8_SUPPORTED);
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34241xoIox;
    }

    @Override // xIoXXXIXo.oIX0oI
    public boolean getValue() {
        return this.f28304Oo;
    }
}
