package jxl.read.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class O00XxXI extends II0xO0 implements xIoXXXIXo.OOXIXo, OoIXo.IIX0o, xIoXXXIXo.oOoXoXO {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28216oI0IIXIo = XxIIOXIXx.X0o0xo.Oxx0IOOO(O00XxXI.class);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public byte[] f28217IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f28218Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public jxl.biff.formula.IIXOooo f28219Oxx0xo;

    public O00XxXI(xoxXI xoxxi, XIxXXX0x0 xIxXXX0x0, int i, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0) {
        super(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0, xIxXXX0x0.oxoX());
        this.f28218Oo = i;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        if (this.f28219Oxx0xo == null) {
            this.f28219Oxx0xo = jxl.biff.formula.IIXOooo.I0Io(this.f28218Oo);
        }
        jxl.biff.formula.IIXOooo iIXOooo = this.f28219Oxx0xo;
        if (iIXOooo != jxl.biff.formula.IIXOooo.f27678oxoX) {
            return iIXOooo.II0xO0();
        }
        return "ERROR " + this.f28218Oo;
    }

    @Override // xIoXXXIXo.OOXIXo
    public int IO() {
        return this.f28218Oo;
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
            bArr[6] = 2;
            bArr[8] = (byte) this.f28218Oo;
            bArr[12] = -1;
            bArr[13] = -1;
            System.arraycopy(oxoX2, 0, bArr, 22, oxoX2.length);
            OoIXo.oo0xXOI0I.XO(oxoX2.length, bArr, 20);
            int i = length + 16;
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 6, bArr2, 0, i);
            return bArr2;
        }
        throw new FormulaException(FormulaException.BIFF8_SUPPORTED);
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34235OOXIXo;
    }
}
