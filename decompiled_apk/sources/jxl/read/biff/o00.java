package jxl.read.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class o00 extends oOoXoXO implements xIoXXXIXo.OOXIXo, OoIXo.IIX0o, xIoXXXIXo.oOoXoXO {

    /* renamed from: Oo, reason: collision with root package name */
    public jxl.biff.formula.IIXOooo f28339Oo;

    /* renamed from: oO, reason: collision with root package name */
    public String f28340oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f28341oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public jxl.biff.formula.OxxIIOOXO f28342ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public OoIXo.x0o f28343x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public byte[] f28344x0xO0oo;

    public o00(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0) {
        super(xoxxi, xxxxox0i, i0);
        boolean z;
        this.f28342ooOOo0oXI = oxxIIOOXO;
        this.f28343x0XOIxOo = x0oVar;
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28344x0xO0oo = I0Io2;
        if (I0Io2[6] == 2) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        this.f28341oOoXoXO = this.f28344x0xO0oo[8];
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        if (this.f28339Oo == null) {
            this.f28339Oo = jxl.biff.formula.IIXOooo.I0Io(this.f28341oOoXoXO);
        }
        jxl.biff.formula.IIXOooo iIXOooo = this.f28339Oo;
        if (iIXOooo != jxl.biff.formula.IIXOooo.f27678oxoX) {
            return iIXOooo.II0xO0();
        }
        return "ERROR " + this.f28341oOoXoXO;
    }

    @Override // xIoXXXIXo.OOXIXo
    public int IO() {
        return this.f28341oOoXoXO;
    }

    @Override // xIoXXXIXo.ooOOo0oXI
    public String Oxx0IOOO() throws FormulaException {
        if (this.f28340oO == null) {
            byte[] bArr = this.f28344x0xO0oo;
            int length = bArr.length - 22;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 22, bArr2, 0, length);
            jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr2, this, this.f28342ooOOo0oXI, this.f28343x0XOIxOo, xo0x().I0().XX());
            xoxoi.Oxx0IOOO();
            this.f28340oO = xoxoi.X0o0xo();
        }
        return this.f28340oO;
    }

    @Override // OoIXo.IIX0o
    public byte[] X0o0xo() throws FormulaException {
        if (xo0x().ooOx().XX0()) {
            byte[] bArr = this.f28344x0xO0oo;
            byte[] bArr2 = new byte[bArr.length - 6];
            System.arraycopy(bArr, 6, bArr2, 0, bArr.length - 6);
            return bArr2;
        }
        throw new FormulaException(FormulaException.BIFF8_SUPPORTED);
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34235OOXIXo;
    }
}
