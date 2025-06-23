package jxl.biff.formula;

/* loaded from: classes6.dex */
public class IXxxXO extends Xx000oIo implements o0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27683II0XooXoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(IXxxXO.class);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public double f27684Oxx0IOOO;

    public IXxxXO() {
    }

    @Override // jxl.biff.formula.Xx000oIo
    public double IXxxXO() {
        return this.f27684Oxx0IOOO;
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] bArr = new byte[9];
        bArr[0] = xoxXI.f28048xoIox.oIX0oI();
        OoIXo.OxI.oIX0oI(this.f27684Oxx0IOOO, bArr, 1);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        this.f27684Oxx0IOOO = OoIXo.OxI.II0xO0(bArr, i);
        return 8;
    }

    public IXxxXO(double d) {
        this.f27684Oxx0IOOO = d;
    }

    public IXxxXO(String str) {
        try {
            this.f27684Oxx0IOOO = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            f27683II0XooXoX.x0XOIxOo(e, e);
            this.f27684Oxx0IOOO = XIXIX.OOXIXo.f3760XO;
        }
    }
}
