package OoIXo;

/* loaded from: classes6.dex */
public class oI0IIXIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f2328I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f2329II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f2330X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f2331oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f2332oxoX;

    /* renamed from: XO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2326XO = XxIIOXIXx.X0o0xo.Oxx0IOOO(oI0IIXIo.class);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static int f2325Oxx0IOOO = 1;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static int f2324II0XooXoX = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static int f2327xxIXOIIO = 4;

    public oI0IIXIo(byte[] bArr) {
        int I0Io2 = oo0xXOI0I.I0Io(bArr[0], bArr[1]);
        this.f2331oIX0oI = (f2325Oxx0IOOO & I0Io2) != 0;
        this.f2329II0xO0 = (f2324II0XooXoX & I0Io2) != 0;
        this.f2328I0Io = (I0Io2 & f2327xxIXOIIO) != 0;
        this.f2330X0o0xo = oo0xXOI0I.oxoX(bArr[10], bArr[11], bArr[12], bArr[13]);
        this.f2332oxoX = oo0xXOI0I.oxoX(bArr[14], bArr[15], bArr[16], bArr[17]);
    }

    public byte[] I0Io() {
        int i;
        byte[] bArr = new byte[18];
        if (this.f2331oIX0oI) {
            i = f2325Oxx0IOOO;
        } else {
            i = 0;
        }
        if (this.f2329II0xO0) {
            i |= f2324II0XooXoX;
        }
        if (this.f2328I0Io) {
            i |= f2327xxIXOIIO;
        }
        oo0xXOI0I.XO(i, bArr, 0);
        oo0xXOI0I.oIX0oI(this.f2330X0o0xo, bArr, 10);
        oo0xXOI0I.oIX0oI(this.f2332oxoX, bArr, 14);
        return bArr;
    }

    public void II0xO0() {
        this.f2332oxoX--;
    }

    public int X0o0xo() {
        return this.f2330X0o0xo;
    }

    public void oIX0oI() {
        this.f2332oxoX++;
    }

    public int oxoX() {
        return this.f2332oxoX;
    }

    public oI0IIXIo(int i, int i2) {
        this.f2330X0o0xo = i;
        this.f2332oxoX = i2;
        this.f2328I0Io = true;
    }
}
