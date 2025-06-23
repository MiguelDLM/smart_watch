package jxl.write.biff;

/* loaded from: classes6.dex */
public class xI0oxI00 extends OoIXo.OI0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public double f29001II0XooXoX;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f29002IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f29003OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public int f29004Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public double f29005Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f29006Oxx0xo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public XxIIOXIXx.X0o0xo f29007X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f29008XO;

    /* renamed from: oO, reason: collision with root package name */
    public int f29009oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f29010oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f29011ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f29012x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f29013x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public oI0X0.xoIox f29014xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public oI0X0.OOXIXo f29015xxIXOIIO;

    public xI0oxI00(xIoXXXIXo.xoXoI xoxoi) {
        super(OoIXo.xII.f2529xoxXI);
        this.f29007X0o0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(xI0oxI00.class);
        this.f29015xxIXOIIO = xoxoi.oI0IIXIo();
        this.f29014xoIox = xoxoi.xoXoI();
        this.f29005Oxx0IOOO = xoxoi.oO();
        this.f29001II0XooXoX = xoxoi.ooOOo0oXI();
        this.f29003OOXIXo = xoxoi.OxI().II0xO0();
        this.f29013x0xO0oo = xoxoi.Oo();
        this.f29004Oo = xoxoi.oOXoIIIo();
        this.f29012x0XOIxOo = xoxoi.OOXIXo();
        this.f29009oO = xoxoi.xxIXOIIO();
        this.f29011ooOOo0oXI = xoxoi.o00();
        this.f29010oOoXoXO = xoxoi.xI();
        this.f29002IXxxXO = xoxoi.I0Io();
        this.f29006Oxx0xo = true;
    }

    public void I0X0x0oIo(oI0X0.xoIox xoiox) {
        this.f29014xoIox = xoiox;
    }

    public void XX0(double d, double d2) {
        this.f29005Oxx0IOOO = d;
        this.f29001II0XooXoX = d2;
    }

    public void Xo0(oI0X0.oOoXoXO oooxoxo) {
        this.f29003OOXIXo = oooxoxo.II0xO0();
    }

    public void oX(oI0X0.OOXIXo oOXIXo) {
        this.f29015xxIXOIIO = oOXIXo;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[34];
        this.f29008XO = bArr;
        int i = 0;
        OoIXo.oo0xXOI0I.XO(this.f29003OOXIXo, bArr, 0);
        OoIXo.oo0xXOI0I.XO(this.f29010oOoXoXO, this.f29008XO, 2);
        OoIXo.oo0xXOI0I.XO(this.f29011ooOOo0oXI, this.f29008XO, 4);
        OoIXo.oo0xXOI0I.XO(this.f29012x0XOIxOo, this.f29008XO, 6);
        OoIXo.oo0xXOI0I.XO(this.f29009oO, this.f29008XO, 8);
        if (this.f29014xoIox == oI0X0.xoIox.f31602II0xO0) {
            i = 1;
        }
        if (this.f29015xxIXOIIO == oI0X0.OOXIXo.f31385oIX0oI) {
            i |= 2;
        }
        if (this.f29011ooOOo0oXI != 0) {
            i |= 128;
        }
        if (!this.f29006Oxx0xo) {
            i |= 4;
        }
        OoIXo.oo0xXOI0I.XO(i, this.f29008XO, 10);
        OoIXo.oo0xXOI0I.XO(this.f29013x0xO0oo, this.f29008XO, 12);
        OoIXo.oo0xXOI0I.XO(this.f29004Oo, this.f29008XO, 14);
        OoIXo.OxI.oIX0oI(this.f29005Oxx0IOOO, this.f29008XO, 16);
        OoIXo.OxI.oIX0oI(this.f29001II0XooXoX, this.f29008XO, 24);
        OoIXo.oo0xXOI0I.XO(this.f29002IXxxXO, this.f29008XO, 32);
        return this.f29008XO;
    }
}
