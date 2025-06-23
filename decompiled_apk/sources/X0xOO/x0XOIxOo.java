package X0xOO;

/* loaded from: classes6.dex */
public class x0XOIxOo extends o00 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3606II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3607Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f3608X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3609XO;

    public x0XOIxOo(XI0IXoo xI0IXoo) {
        super(xI0IXoo);
        this.f3609XO = X0o0xo();
        byte[] oIX0oI2 = oIX0oI();
        this.f3607Oxx0IOOO = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[0], oIX0oI2[1], oIX0oI2[2], oIX0oI2[3]);
        this.f3606II0XooXoX = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[4], oIX0oI2[5], oIX0oI2[6], oIX0oI2[7]);
    }

    @Override // X0xOO.o00, X0xOO.X0IIOO
    public byte[] II0xO0() {
        byte[] bArr = new byte[8];
        this.f3608X0o0xo = bArr;
        OoIXo.oo0xXOI0I.oIX0oI(this.f3607Oxx0IOOO, bArr, 0);
        OoIXo.oo0xXOI0I.oIX0oI(this.f3606II0XooXoX, this.f3608X0o0xo, 4);
        return OOXIXo(this.f3608X0o0xo);
    }

    public int oO() {
        return this.f3607Oxx0IOOO;
    }

    public int x0XOIxOo() {
        return this.f3609XO;
    }

    public x0XOIxOo(int i) {
        super(XIxXXX0x0.f3416OOXIXo);
        this.f3609XO = 1;
        this.f3607Oxx0IOOO = i + 1;
        this.f3606II0XooXoX = i + 1026;
        oOoXoXO(1);
    }
}
