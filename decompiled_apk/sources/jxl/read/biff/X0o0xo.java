package jxl.read.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class X0o0xo extends oOoXoXO implements xIoXXXIXo.oIX0oI, OoIXo.IIX0o, xIoXXXIXo.II0xO0 {

    /* renamed from: oO, reason: collision with root package name */
    public String f28257oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f28258oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public jxl.biff.formula.OxxIIOOXO f28259ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public OoIXo.x0o f28260x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public byte[] f28261x0xO0oo;

    public X0o0xo(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0) {
        super(xoxxi, xxxxox0i, i0);
        boolean z;
        this.f28259ooOOo0oXI = oxxIIOOXO;
        this.f28260x0XOIxOo = x0oVar;
        this.f28258oOoXoXO = false;
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28261x0xO0oo = I0Io2;
        if (I0Io2[6] != 2) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        this.f28258oOoXoXO = this.f28261x0xO0oo[8] == 1;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return new Boolean(this.f28258oOoXoXO).toString();
    }

    @Override // xIoXXXIXo.ooOOo0oXI
    public String Oxx0IOOO() throws FormulaException {
        if (this.f28257oO == null) {
            byte[] bArr = this.f28261x0xO0oo;
            int length = bArr.length - 22;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 22, bArr2, 0, length);
            jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr2, this, this.f28259ooOOo0oXI, this.f28260x0XOIxOo, xo0x().I0().XX());
            xoxoi.Oxx0IOOO();
            this.f28257oO = xoxoi.X0o0xo();
        }
        return this.f28257oO;
    }

    @Override // OoIXo.IIX0o
    public byte[] X0o0xo() throws FormulaException {
        if (xo0x().ooOx().XX0()) {
            byte[] bArr = this.f28261x0xO0oo;
            byte[] bArr2 = new byte[bArr.length - 6];
            System.arraycopy(bArr, 6, bArr2, 0, bArr.length - 6);
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
        return this.f28258oOoXoXO;
    }
}
