package jxl.write.biff;

import java.text.NumberFormat;
import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class xoO0xx0 extends ooOx implements xIoXXXIXo.oI0IIXIo {

    /* renamed from: Oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f29037Oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(xoO0xx0.class);

    public xoO0xx0(OoIXo.IIX0o iIX0o) {
        super(iIX0o);
    }

    @Override // jxl.write.biff.ooOx
    public byte[] OOXIxO0() {
        byte[] O00XxXI2 = super.O00XxXI();
        IOoo IIxOXoOo02 = I0oOIX().IIxOXoOo0();
        jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(Double.toString(getValue()), IIxOXoOo02, IIxOXoOo02, IIxOXoOo02.Io());
        try {
            xoxoi.Oxx0IOOO();
        } catch (FormulaException e) {
            f29037Oo.ooOOo0oXI(e.getMessage());
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
        OoIXo.OxI.oIX0oI(getValue(), bArr2, 6);
        return bArr2;
    }

    @Override // xIoXXXIXo.Oxx0xo
    public NumberFormat X00IoxXI() {
        return ((xIoXXXIXo.oI0IIXIo) XI0oooXX()).X00IoxXI();
    }

    @Override // xIoXXXIXo.Oxx0xo
    public double getValue() {
        return ((xIoXXXIXo.oI0IIXIo) XI0oooXX()).getValue();
    }
}
