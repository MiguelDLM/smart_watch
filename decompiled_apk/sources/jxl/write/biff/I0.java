package jxl.write.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class I0 extends ooOx implements xIoXXXIXo.oOoXoXO {

    /* renamed from: Oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28558Oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(I0.class);

    public I0(OoIXo.IIX0o iIX0o) {
        super(iIX0o);
    }

    @Override // xIoXXXIXo.OOXIXo
    public int IO() {
        return ((xIoXXXIXo.oOoXoXO) XI0oooXX()).IO();
    }

    @Override // jxl.write.biff.ooOx
    public byte[] OOXIxO0() {
        String str;
        byte[] O00XxXI2 = super.O00XxXI();
        int IO2 = IO();
        if (IO2 == jxl.biff.formula.IIXOooo.f27677XO.oIX0oI()) {
            str = "1/0";
        } else if (IO2 == jxl.biff.formula.IIXOooo.f27675Oxx0IOOO.oIX0oI()) {
            str = "\"\"/0";
        } else if (IO2 == jxl.biff.formula.IIXOooo.f27673II0XooXoX.oIX0oI()) {
            str = "\"#REF!\"";
        } else {
            str = "\"ERROR\"";
        }
        IOoo IIxOXoOo02 = I0oOIX().IIxOXoOo0();
        jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(str, IIxOXoOo02, IIxOXoOo02, IIxOXoOo02.Io());
        try {
            xoxoi.Oxx0IOOO();
        } catch (FormulaException e) {
            f28558Oo.ooOOo0oXI(e.getMessage());
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
        bArr2[6] = 2;
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[8] = (byte) IO2;
        return bArr2;
    }
}
