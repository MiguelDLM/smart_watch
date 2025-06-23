package jxl.read.biff;

import java.text.NumberFormat;
import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class Oxx0xo extends oI0IIXIo implements xIoXXXIXo.xxIXOIIO, OoIXo.IIX0o, xIoXXXIXo.xoIox {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public String f28249IIXOooo;

    /* renamed from: OxI, reason: collision with root package name */
    public byte[] f28250OxI;

    /* renamed from: o00, reason: collision with root package name */
    public OoIXo.x0o f28251o00;

    /* renamed from: xoXoI, reason: collision with root package name */
    public jxl.biff.formula.OxxIIOOXO f28252xoXoI;

    public Oxx0xo(I0oOoX i0oOoX, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, boolean z, I0 i0) throws FormulaException {
        super(i0oOoX, i0oOoX.xXOx(), xxxxox0i, z, i0);
        this.f28252xoXoI = oxxIIOOXO;
        this.f28251o00 = x0oVar;
        this.f28250OxI = i0oOoX.X0o0xo();
    }

    @Override // xIoXXXIXo.ooOOo0oXI
    public String Oxx0IOOO() throws FormulaException {
        if (this.f28249IIXOooo == null) {
            byte[] bArr = this.f28250OxI;
            int length = bArr.length - 16;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 16, bArr2, 0, length);
            jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr2, this, this.f28252xoXoI, this.f28251o00, I0Io().I0().XX());
            xoxoi.Oxx0IOOO();
            this.f28249IIXOooo = xoxoi.X0o0xo();
        }
        return this.f28249IIXOooo;
    }

    public NumberFormat X00IoxXI() {
        return null;
    }

    @Override // OoIXo.IIX0o
    public byte[] X0o0xo() throws FormulaException {
        if (I0Io().ooOx().XX0()) {
            return this.f28250OxI;
        }
        throw new FormulaException(FormulaException.BIFF8_SUPPORTED);
    }

    @Override // jxl.read.biff.oI0IIXIo, xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34233II0XooXoX;
    }

    public double getValue() {
        return XIXIX.OOXIXo.f3760XO;
    }
}
