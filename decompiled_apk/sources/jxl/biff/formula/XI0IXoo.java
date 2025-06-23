package jxl.biff.formula;

/* loaded from: classes6.dex */
public class XI0IXoo extends Xx000oIo implements o0 {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27726xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(XI0IXoo.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f27727II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public double f27728Oxx0IOOO;

    public XI0IXoo() {
        this.f27727II0XooXoX = false;
    }

    @Override // jxl.biff.formula.Xx000oIo
    public double IXxxXO() {
        return this.f27728Oxx0IOOO;
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    public boolean Oxx0xo() {
        return this.f27727II0XooXoX;
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] bArr = {xoxXI.f28050xxIXOIIO.oIX0oI()};
        OoIXo.oo0xXOI0I.XO((int) this.f27728Oxx0IOOO, bArr, 1);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        this.f27728Oxx0IOOO = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
        return 2;
    }

    public XI0IXoo(String str) {
        try {
            this.f27728Oxx0IOOO = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            f27726xxIXOIIO.x0XOIxOo(e, e);
            this.f27728Oxx0IOOO = XIXIX.OOXIXo.f3760XO;
        }
        double d = this.f27728Oxx0IOOO;
        this.f27727II0XooXoX = d != ((double) ((short) ((int) d)));
    }
}
