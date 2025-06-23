package jxl.read.biff;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class OOXIxO0 extends II0xO0 implements xIoXXXIXo.Oxx0xo, OoIXo.IIX0o, xIoXXXIXo.oI0IIXIo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public NumberFormat f28239IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public double f28240Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public OoIXo.xXxxox0I f28241Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28238oI0IIXIo = XxIIOXIXx.X0o0xo.Oxx0IOOO(OOXIxO0.class);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static DecimalFormat f28237OxxIIOOXO = new DecimalFormat("#.###");

    public OOXIxO0(xoxXI xoxxi, XIxXXX0x0 xIxXXX0x0, double d, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0) {
        super(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0, xIxXXX0x0.oxoX());
        this.f28240Oo = d;
        this.f28239IXxxXO = f28237OxxIIOOXO;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        if (!Double.isNaN(this.f28240Oo)) {
            return this.f28239IXxxXO.format(this.f28240Oo);
        }
        return "";
    }

    public final void O0Xx(NumberFormat numberFormat) {
        if (numberFormat != null) {
            this.f28239IXxxXO = numberFormat;
        }
    }

    @Override // xIoXXXIXo.Oxx0xo
    public NumberFormat X00IoxXI() {
        return this.f28239IXxxXO;
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
            OoIXo.OxI.oIX0oI(this.f28240Oo, bArr, 6);
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
        return xIoXXXIXo.Oxx0IOOO.f34236Oxx0IOOO;
    }

    @Override // xIoXXXIXo.Oxx0xo
    public double getValue() {
        return this.f28240Oo;
    }
}
