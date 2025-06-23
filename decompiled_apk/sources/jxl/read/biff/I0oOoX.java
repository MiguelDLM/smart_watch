package jxl.read.biff;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class I0oOoX extends oOoXoXO implements xIoXXXIXo.Oxx0xo, OoIXo.IIX0o, xIoXXXIXo.oI0IIXIo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28142IXxxXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(I0oOoX.class);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final DecimalFormat f28143Oxx0xo = new DecimalFormat("#.###");

    /* renamed from: Oo, reason: collision with root package name */
    public byte[] f28144Oo;

    /* renamed from: oO, reason: collision with root package name */
    public jxl.biff.formula.OxxIIOOXO f28145oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public double f28146oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public NumberFormat f28147ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f28148x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public OoIXo.x0o f28149x0xO0oo;

    public I0oOoX(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0) {
        super(xoxxi, xxxxox0i, i0);
        this.f28145oO = oxxIIOOXO;
        this.f28149x0xO0oo = x0oVar;
        this.f28144Oo = oxXx0IX().I0Io();
        NumberFormat Oxx0IOOO2 = xxxxox0i.Oxx0IOOO(xXOx());
        this.f28147ooOOo0oXI = Oxx0IOOO2;
        if (Oxx0IOOO2 == null) {
            this.f28147ooOOo0oXI = f28143Oxx0xo;
        }
        this.f28146oOoXoXO = OoIXo.OxI.II0xO0(this.f28144Oo, 6);
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        if (!Double.isNaN(this.f28146oOoXoXO)) {
            return this.f28147ooOOo0oXI.format(this.f28146oOoXoXO);
        }
        return "";
    }

    @Override // xIoXXXIXo.ooOOo0oXI
    public String Oxx0IOOO() throws FormulaException {
        if (this.f28148x0XOIxOo == null) {
            byte[] bArr = this.f28144Oo;
            int length = bArr.length - 22;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 22, bArr2, 0, length);
            jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr2, this, this.f28145oO, this.f28149x0xO0oo, xo0x().I0().XX());
            xoxoi.Oxx0IOOO();
            this.f28148x0XOIxOo = xoxoi.X0o0xo();
        }
        return this.f28148x0XOIxOo;
    }

    @Override // xIoXXXIXo.Oxx0xo
    public NumberFormat X00IoxXI() {
        return this.f28147ooOOo0oXI;
    }

    @Override // OoIXo.IIX0o
    public byte[] X0o0xo() throws FormulaException {
        if (xo0x().ooOx().XX0()) {
            byte[] bArr = this.f28144Oo;
            byte[] bArr2 = new byte[bArr.length - 6];
            System.arraycopy(bArr, 6, bArr2, 0, bArr.length - 6);
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
        return this.f28146oOoXoXO;
    }
}
