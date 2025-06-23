package jxl.biff.formula;

/* loaded from: classes6.dex */
public abstract class OI0 {

    /* renamed from: XO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27706XO = XxIIOXIXx.X0o0xo.Oxx0IOOO(OI0.class);

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OI0 f27710oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f27708II0xO0 = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f27707I0Io = false;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f27709X0o0xo = true;

    /* renamed from: oxoX, reason: collision with root package name */
    public XOxIOxOx f27711oxoX = XOxIOxOx.f27731oIX0oI;

    public abstract void I0Io(int i, int i2, boolean z);

    public final boolean II0XooXoX() {
        return this.f27709X0o0xo;
    }

    public abstract void II0xO0(int i, int i2, boolean z);

    public abstract void OOXIXo(int i, int i2, boolean z);

    public final boolean Oo() {
        return this.f27707I0Io;
    }

    public abstract void Oxx0IOOO();

    public final XOxIOxOx X0o0xo() {
        return this.f27711oxoX;
    }

    public abstract void XO(StringBuffer stringBuffer);

    public abstract void oIX0oI(int i, int i2);

    public void oO(XOxIOxOx xOxIOxOx) {
        this.f27711oxoX = xOxIOxOx;
    }

    public void oOoXoXO() {
        this.f27707I0Io = true;
    }

    public final void ooOOo0oXI() {
        this.f27709X0o0xo = false;
        OI0 oi0 = this.f27710oIX0oI;
        if (oi0 != null) {
            oi0.ooOOo0oXI();
        }
    }

    public abstract byte[] oxoX();

    public void x0XOIxOo(OI0 oi0) {
        this.f27710oIX0oI = oi0;
    }

    public void x0xO0oo() {
        this.f27708II0xO0 = true;
        OI0 oi0 = this.f27710oIX0oI;
        if (oi0 != null && !oi0.xxIXOIIO()) {
            this.f27710oIX0oI.x0xO0oo();
        }
    }

    public abstract void xoIox(int i, int i2, boolean z);

    public final boolean xxIXOIIO() {
        return this.f27708II0xO0;
    }
}
