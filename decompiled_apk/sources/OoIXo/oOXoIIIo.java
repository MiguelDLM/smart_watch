package OoIXo;

/* loaded from: classes6.dex */
public class oOXoIIIo implements xIoXXXIXo.OxxIIOOXO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2338II0XooXoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(oOXoIIIo.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f2339I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f2340II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f2341Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f2342X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f2343XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public x0o f2344oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f2345oxoX;

    public oOXoIIIo(x0o x0oVar, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f2344oIX0oI = x0oVar;
        this.f2340II0xO0 = i;
        this.f2342X0o0xo = i4;
        this.f2345oxoX = i3;
        this.f2341Oxx0IOOO = i6;
        this.f2339I0Io = i2;
        this.f2343XO = i5;
    }

    @Override // xIoXXXIXo.OxxIIOOXO
    public int I0Io() {
        return this.f2342X0o0xo;
    }

    @Override // xIoXXXIXo.OxxIIOOXO
    public xIoXXXIXo.I0Io II0xO0() {
        xIoXXXIXo.IIXOooo X0o0xo2 = this.f2344oIX0oI.X0o0xo(this.f2342X0o0xo);
        if (this.f2343XO < X0o0xo2.XoI0Ixx0() && this.f2341Oxx0IOOO < X0o0xo2.OxxIIOOXO()) {
            return X0o0xo2.XX(this.f2343XO, this.f2341Oxx0IOOO);
        }
        return new O0xOxO(this.f2343XO, this.f2341Oxx0IOOO);
    }

    @Override // xIoXXXIXo.OxxIIOOXO
    public xIoXXXIXo.I0Io oIX0oI() {
        xIoXXXIXo.IIXOooo X0o0xo2 = this.f2344oIX0oI.X0o0xo(this.f2340II0xO0);
        if (this.f2339I0Io < X0o0xo2.XoI0Ixx0() && this.f2345oxoX < X0o0xo2.OxxIIOOXO()) {
            return X0o0xo2.XX(this.f2339I0Io, this.f2345oxoX);
        }
        return new O0xOxO(this.f2339I0Io, this.f2345oxoX);
    }

    @Override // xIoXXXIXo.OxxIIOOXO
    public int oxoX() {
        return this.f2340II0xO0;
    }
}
