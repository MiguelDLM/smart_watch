package jxl.read.biff;

import java.text.DateFormat;
import java.util.Date;
import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class o0xxxXXxX extends II0xO0 implements xIoXXXIXo.xxIXOIIO, OoIXo.IIX0o, xIoXXXIXo.xoIox {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public double f28345IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public oI0IIXIo f28346Oo;

    public o0xxxXXxX(OOXIxO0 oOXIxO0, OoIXo.xXxxox0I xxxxox0i, boolean z, I0 i0, int i) {
        super(oOXIxO0.oxXx0IX(), xxxxox0i, oOXIxO0.XX0(), oOXIxO0.oX(), i0, i);
        this.f28346Oo = new oI0IIXIo(oOXIxO0, oOXIxO0.xXOx(), xxxxox0i, z, i0);
        this.f28345IXxxXO = oOXIxO0.getValue();
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28346Oo.IIX0o();
    }

    @Override // xIoXXXIXo.xxIXOIIO
    public boolean IXxxXO() {
        return this.f28346Oo.IXxxXO();
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
            OoIXo.OxI.oIX0oI(this.f28345IXxxXO, bArr, 6);
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
        return xIoXXXIXo.Oxx0IOOO.f34233II0XooXoX;
    }

    public double getValue() {
        return this.f28345IXxxXO;
    }

    @Override // xIoXXXIXo.xxIXOIIO
    public Date oo0xXOI0I() {
        return this.f28346Oo.oo0xXOI0I();
    }

    @Override // xIoXXXIXo.xxIXOIIO
    public DateFormat x0o() {
        return this.f28346Oo.x0o();
    }
}
