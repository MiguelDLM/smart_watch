package jxl.biff.formula;

/* loaded from: classes6.dex */
public class xoXoI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final XxIIOXIXx.X0o0xo f28010II0xO0 = XxIIOXIXx.X0o0xo.Oxx0IOOO(xoXoI.class);

    /* renamed from: oIX0oI, reason: collision with root package name */
    public XX f28011oIX0oI;

    public xoXoI(byte[] bArr, xIoXXXIXo.I0Io i0Io, OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO) throws FormulaException {
        if (oxxIIOOXO.II0XooXoX() != null && !oxxIIOOXO.II0XooXoX().XX0()) {
            throw new FormulaException(FormulaException.BIFF8_SUPPORTED);
        }
        XxIIOXIXx.oIX0oI.oIX0oI(x0oVar != null);
        this.f28011oIX0oI = new IoOoo(bArr, i0Io, oxxIIOOXO, x0oVar, o0xOxO, XOxIOxOx.f27731oIX0oI);
    }

    public void I0Io(int i, int i2, boolean z) {
        this.f28011oIX0oI.oOoXoXO(i, i2, z);
    }

    public void II0XooXoX(int i, int i2, boolean z) {
        this.f28011oIX0oI.xoIox(i, i2, z);
    }

    public void II0xO0(int i, int i2, boolean z) {
        this.f28011oIX0oI.OOXIXo(i, i2, z);
    }

    public void Oxx0IOOO() throws FormulaException {
        this.f28011oIX0oI.parse();
    }

    public String X0o0xo() throws FormulaException {
        return this.f28011oIX0oI.Oxx0IOOO();
    }

    public boolean XO() {
        return this.f28011oIX0oI.II0XooXoX();
    }

    public void oIX0oI(int i, int i2) {
        this.f28011oIX0oI.xxIXOIIO(i, i2);
    }

    public byte[] oxoX() {
        return this.f28011oIX0oI.I0Io();
    }

    public void xxIXOIIO(int i, int i2, boolean z) {
        this.f28011oIX0oI.ooOOo0oXI(i, i2, z);
    }

    public xoXoI(byte[] bArr, xIoXXXIXo.I0Io i0Io, OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO, XOxIOxOx xOxIOxOx) throws FormulaException {
        if (oxxIIOOXO.II0XooXoX() != null && !oxxIIOOXO.II0XooXoX().XX0()) {
            throw new FormulaException(FormulaException.BIFF8_SUPPORTED);
        }
        XxIIOXIXx.oIX0oI.oIX0oI(x0oVar != null);
        this.f28011oIX0oI = new IoOoo(bArr, i0Io, oxxIIOOXO, x0oVar, o0xOxO, xOxIOxOx);
    }

    public xoXoI(String str, OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f28011oIX0oI = new XX0(str, oxxIIOOXO, x0oVar, o0xOxO, XOxIOxOx.f27731oIX0oI);
    }

    public xoXoI(String str, OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO, XOxIOxOx xOxIOxOx) {
        this.f28011oIX0oI = new XX0(str, oxxIIOOXO, x0oVar, o0xOxO, xOxIOxOx);
    }
}
