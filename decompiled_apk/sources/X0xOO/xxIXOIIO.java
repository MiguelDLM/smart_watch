package X0xOO;

/* loaded from: classes6.dex */
public class xxIXOIIO extends o00 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final XxIIOXIXx.X0o0xo f3635OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(xxIXOIIO.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public double f3636II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public double f3637Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f3638X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3639XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public double f3640xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public double f3641xxIXOIIO;

    public xxIXOIIO(XI0IXoo xI0IXoo) {
        super(xI0IXoo);
        byte[] oIX0oI2 = oIX0oI();
        this.f3639XO = OoIXo.oo0xXOI0I.I0Io(oIX0oI2[0], oIX0oI2[1]);
        this.f3637Oxx0IOOO = OoIXo.oo0xXOI0I.I0Io(oIX0oI2[2], oIX0oI2[3]) + (OoIXo.oo0xXOI0I.I0Io(oIX0oI2[4], oIX0oI2[5]) / 1024.0d);
        this.f3636II0XooXoX = OoIXo.oo0xXOI0I.I0Io(oIX0oI2[6], oIX0oI2[7]) + (OoIXo.oo0xXOI0I.I0Io(oIX0oI2[8], oIX0oI2[9]) / 256.0d);
        this.f3641xxIXOIIO = OoIXo.oo0xXOI0I.I0Io(oIX0oI2[10], oIX0oI2[11]) + (OoIXo.oo0xXOI0I.I0Io(oIX0oI2[12], oIX0oI2[13]) / 1024.0d);
        this.f3640xoIox = OoIXo.oo0xXOI0I.I0Io(oIX0oI2[14], oIX0oI2[15]) + (OoIXo.oo0xXOI0I.I0Io(oIX0oI2[16], oIX0oI2[17]) / 256.0d);
    }

    @Override // X0xOO.o00, X0xOO.X0IIOO
    public byte[] II0xO0() {
        byte[] bArr = new byte[18];
        this.f3638X0o0xo = bArr;
        OoIXo.oo0xXOI0I.XO(this.f3639XO, bArr, 0);
        OoIXo.oo0xXOI0I.XO((int) this.f3637Oxx0IOOO, this.f3638X0o0xo, 2);
        OoIXo.oo0xXOI0I.XO((int) ((this.f3637Oxx0IOOO - ((int) r0)) * 1024.0d), this.f3638X0o0xo, 4);
        OoIXo.oo0xXOI0I.XO((int) this.f3636II0XooXoX, this.f3638X0o0xo, 6);
        OoIXo.oo0xXOI0I.XO((int) ((this.f3636II0XooXoX - ((int) r0)) * 256.0d), this.f3638X0o0xo, 8);
        OoIXo.oo0xXOI0I.XO((int) this.f3641xxIXOIIO, this.f3638X0o0xo, 10);
        OoIXo.oo0xXOI0I.XO((int) ((this.f3641xxIXOIIO - ((int) r0)) * 1024.0d), this.f3638X0o0xo, 12);
        OoIXo.oo0xXOI0I.XO((int) this.f3640xoIox, this.f3638X0o0xo, 14);
        OoIXo.oo0xXOI0I.XO((int) ((this.f3640xoIox - ((int) r0)) * 256.0d), this.f3638X0o0xo, 16);
        return OOXIXo(this.f3638X0o0xo);
    }

    public double IXxxXO() {
        return this.f3640xoIox;
    }

    public double Oo() {
        return this.f3636II0XooXoX;
    }

    public double oO() {
        return this.f3637Oxx0IOOO;
    }

    public int x0XOIxOo() {
        return this.f3639XO;
    }

    public double x0xO0oo() {
        return this.f3641xxIXOIIO;
    }

    public xxIXOIIO(double d, double d2, double d3, double d4, int i) {
        super(XIxXXX0x0.f3421oO);
        this.f3637Oxx0IOOO = d;
        this.f3636II0XooXoX = d2;
        this.f3641xxIXOIIO = d3;
        this.f3640xoIox = d4;
        this.f3639XO = i;
    }
}
