package X0xOO;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class x0xO0oo extends o00 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3611OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(x0xO0oo.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3612II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3613Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f3614X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3615XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public ArrayList f3616xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f3617xxIXOIIO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f3618II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f3619oIX0oI;

        public oIX0oI(int i, int i2) {
            this.f3619oIX0oI = i;
            this.f3618II0xO0 = i2;
        }
    }

    public x0xO0oo(XI0IXoo xI0IXoo) {
        super(xI0IXoo);
        this.f3616xoIox = new ArrayList();
        byte[] oIX0oI2 = oIX0oI();
        this.f3613Oxx0IOOO = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[0], oIX0oI2[1], oIX0oI2[2], oIX0oI2[3]);
        this.f3615XO = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[4], oIX0oI2[5], oIX0oI2[6], oIX0oI2[7]);
        this.f3612II0XooXoX = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[8], oIX0oI2[9], oIX0oI2[10], oIX0oI2[11]);
        this.f3617xxIXOIIO = OoIXo.oo0xXOI0I.oxoX(oIX0oI2[12], oIX0oI2[13], oIX0oI2[14], oIX0oI2[15]);
        int i = 16;
        for (int i2 = 0; i2 < this.f3615XO; i2++) {
            this.f3616xoIox.add(new oIX0oI(OoIXo.oo0xXOI0I.I0Io(oIX0oI2[i], oIX0oI2[i + 1]), OoIXo.oo0xXOI0I.I0Io(oIX0oI2[i + 2], oIX0oI2[i + 3])));
            i += 4;
        }
    }

    @Override // X0xOO.o00, X0xOO.X0IIOO
    public byte[] II0xO0() {
        int size = this.f3616xoIox.size();
        this.f3615XO = size;
        int i = 16;
        byte[] bArr = new byte[(size * 4) + 16];
        this.f3614X0o0xo = bArr;
        OoIXo.oo0xXOI0I.oIX0oI(this.f3612II0XooXoX + 1024, bArr, 0);
        OoIXo.oo0xXOI0I.oIX0oI(this.f3615XO, this.f3614X0o0xo, 4);
        OoIXo.oo0xXOI0I.oIX0oI(this.f3612II0XooXoX, this.f3614X0o0xo, 8);
        OoIXo.oo0xXOI0I.oIX0oI(1, this.f3614X0o0xo, 12);
        for (int i2 = 0; i2 < this.f3615XO; i2++) {
            oIX0oI oix0oi = (oIX0oI) this.f3616xoIox.get(i2);
            OoIXo.oo0xXOI0I.XO(oix0oi.f3619oIX0oI, this.f3614X0o0xo, i);
            OoIXo.oo0xXOI0I.XO(oix0oi.f3618II0xO0, this.f3614X0o0xo, i + 2);
            i += 4;
        }
        return OOXIXo(this.f3614X0o0xo);
    }

    public int Oo() {
        return this.f3612II0XooXoX;
    }

    public oIX0oI oO(int i) {
        return (oIX0oI) this.f3616xoIox.get(i);
    }

    public void x0XOIxOo(int i, int i2) {
        this.f3616xoIox.add(new oIX0oI(i, i2));
    }

    public int x0xO0oo() {
        return this.f3617xxIXOIIO;
    }

    public x0xO0oo(int i, int i2) {
        super(XIxXXX0x0.f3428xxIXOIIO);
        this.f3612II0XooXoX = i;
        this.f3617xxIXOIIO = i2;
        this.f3616xoIox = new ArrayList();
    }
}
