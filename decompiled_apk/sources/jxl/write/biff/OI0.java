package jxl.write.biff;

/* loaded from: classes6.dex */
public class OI0 extends OoIXo.OI0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28665II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28666Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28667X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28668XO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28669xxIXOIIO;

    public OI0(int i, int i2, int i3) {
        super(OoIXo.xII.f2428IXxxXO);
        this.f28666Oxx0IOOO = i;
        this.f28668XO = i2;
        this.f28665II0XooXoX = i3;
        this.f28667X0o0xo = new byte[(i3 * 4) + 16];
        this.f28669xxIXOIIO = 16;
    }

    public void I0X0x0oIo(int i) {
        OoIXo.oo0xXOI0I.oIX0oI(i - this.f28666Oxx0IOOO, this.f28667X0o0xo, 12);
    }

    public void XX0(int i) {
        OoIXo.oo0xXOI0I.oIX0oI(i - this.f28666Oxx0IOOO, this.f28667X0o0xo, this.f28669xxIXOIIO);
        this.f28669xxIXOIIO += 4;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        OoIXo.oo0xXOI0I.oIX0oI(this.f28668XO, this.f28667X0o0xo, 8);
        return this.f28667X0o0xo;
    }
}
