package jxl.write.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class OX00O0xII extends ooOx implements xIoXXXIXo.o00 {

    /* renamed from: Oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28682Oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(ooOx.class);

    public OX00O0xII(OoIXo.IIX0o iIX0o) {
        super(iIX0o);
    }

    @Override // xIoXXXIXo.IXxxXO
    public String IoOoX() {
        return ((xIoXXXIXo.o00) XI0oooXX()).IoOoX();
    }

    @Override // jxl.write.biff.ooOx
    public byte[] OOXIxO0() {
        byte[] O00XxXI2 = super.O00XxXI();
        IOoo IIxOXoOo02 = I0oOIX().IIxOXoOo0();
        jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI("\"" + IIX0o() + "\"", IIxOXoOo02, IIxOXoOo02, IIxOXoOo02.Io());
        try {
            xoxoi.Oxx0IOOO();
        } catch (FormulaException e) {
            f28682Oo.ooOOo0oXI(e.getMessage());
            xoxoi = new jxl.biff.formula.xoXoI("\"ERROR\"", IIxOXoOo02, IIxOXoOo02, IIxOXoOo02.Io());
            try {
                xoxoi.Oxx0IOOO();
            } catch (FormulaException unused) {
                XxIIOXIXx.oIX0oI.oIX0oI(false);
            }
        }
        byte[] oxoX2 = xoxoi.oxoX();
        int length = oxoX2.length + 16;
        byte[] bArr = new byte[length];
        OoIXo.oo0xXOI0I.XO(oxoX2.length, bArr, 14);
        System.arraycopy(oxoX2, 0, bArr, 16, oxoX2.length);
        bArr[8] = (byte) (bArr[8] | 2);
        byte[] bArr2 = new byte[O00XxXI2.length + length];
        System.arraycopy(O00XxXI2, 0, bArr2, 0, O00XxXI2.length);
        System.arraycopy(bArr, 0, bArr2, O00XxXI2.length, length);
        bArr2[6] = 0;
        bArr2[12] = -1;
        bArr2[13] = -1;
        return bArr2;
    }
}
