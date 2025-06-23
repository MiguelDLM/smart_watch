package jxl.read.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class IIxOXoOo0 extends jxl.read.biff.II0xO0 implements xIoXXXIXo.IXxxXO, OoIXo.IIX0o, xIoXXXIXo.o00 {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28191IXxxXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(IIxOXoOo0.class);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final II0xO0 f28192Oxx0xo = new II0xO0();

    /* renamed from: Oo, reason: collision with root package name */
    public String f28193Oo;

    /* loaded from: classes6.dex */
    public static final class II0xO0 {
        public II0xO0() {
        }
    }

    public IIxOXoOo0(xoxXI xoxxi, XIxXXX0x0 xIxXXX0x0, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0, xIxXXX0x0.oxoX());
        int oxoX2 = xIxXXX0x0.oxoX();
        int oxoX3 = xIxXXX0x0.oxoX();
        xoxXI Oxx0IOOO2 = xIxXXX0x0.Oxx0IOOO();
        boolean z = false;
        int i = 0;
        while (Oxx0IOOO2.X0o0xo() != OoIXo.xII.f2481XxX0x0xxx && i < 4) {
            Oxx0IOOO2 = xIxXXX0x0.Oxx0IOOO();
            i++;
        }
        XxIIOXIXx.oIX0oI.II0xO0(i < 4, " @ " + oxoX2);
        byte[] I0Io2 = Oxx0IOOO2.I0Io();
        xoxXI II0XooXoX2 = xIxXXX0x0.II0XooXoX();
        while (II0XooXoX2.X0o0xo() == OoIXo.xII.f2528xoXoI) {
            xoxXI Oxx0IOOO3 = xIxXXX0x0.Oxx0IOOO();
            byte[] bArr = new byte[(I0Io2.length + Oxx0IOOO3.oxoX()) - 1];
            System.arraycopy(I0Io2, 0, bArr, 0, I0Io2.length);
            System.arraycopy(Oxx0IOOO3.I0Io(), 1, bArr, I0Io2.length, Oxx0IOOO3.oxoX() - 1);
            II0XooXoX2 = xIxXXX0x0.II0XooXoX();
            I0Io2 = bArr;
        }
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        int i2 = 2;
        if (I0Io2.length != I0Io3 + 2) {
            i2 = 3;
            if (I0Io2[2] == 1) {
                z = true;
            }
        }
        if (!z) {
            this.f28193Oo = OoIXo.IO.oxoX(I0Io2, I0Io3, i2, o0xOxO);
        } else {
            this.f28193Oo = OoIXo.IO.Oxx0IOOO(I0Io2, I0Io3, i2);
        }
        xIxXXX0x0.OOXIXo(oxoX3);
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28193Oo;
    }

    @Override // xIoXXXIXo.IXxxXO
    public String IoOoX() {
        return this.f28193Oo;
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
            bArr[6] = 0;
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
        return xIoXXXIXo.Oxx0IOOO.f34242xxIXOIIO;
    }

    public IIxOXoOo0(xoxXI xoxxi, XIxXXX0x0 xIxXXX0x0, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0, II0xO0 iI0xO0) {
        super(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0, xIxXXX0x0.oxoX());
        this.f28193Oo = "";
    }
}
