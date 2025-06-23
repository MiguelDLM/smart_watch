package X0xOO;

/* loaded from: classes6.dex */
public class X00IoxXI extends o00 {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3383xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(X00IoxXI.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3384II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3385Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f3386X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3387XO;

    public X00IoxXI(XI0IXoo xI0IXoo) {
        super(xI0IXoo);
        this.f3387XO = X0o0xo();
        byte[] oIX0oI2 = oIX0oI();
        this.f3385Oxx0IOOO = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[0], oIX0oI2[1], oIX0oI2[2], oIX0oI2[3]);
        this.f3384II0XooXoX = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[4], oIX0oI2[5], oIX0oI2[6], oIX0oI2[7]);
    }

    @Override // X0xOO.o00, X0xOO.X0IIOO
    public byte[] II0xO0() {
        byte[] bArr = new byte[8];
        this.f3386X0o0xo = bArr;
        OoIXo.oo0xXOI0I.oIX0oI(this.f3385Oxx0IOOO, bArr, 0);
        OoIXo.oo0xXOI0I.oIX0oI(this.f3384II0XooXoX, this.f3386X0o0xo, 4);
        return OOXIXo(this.f3386X0o0xo);
    }

    public int oO() {
        return this.f3387XO;
    }

    public int x0XOIxOo() {
        return this.f3385Oxx0IOOO;
    }

    public X00IoxXI(oOXoIIIo ooxoiiio, int i, int i2) {
        super(XIxXXX0x0.f3423ooOOo0oXI);
        ooOOo0oXI(2);
        int II0xO02 = ooxoiiio.II0xO0();
        this.f3387XO = II0xO02;
        this.f3385Oxx0IOOO = i;
        this.f3384II0XooXoX = i2;
        oOoXoXO(II0xO02);
    }
}
