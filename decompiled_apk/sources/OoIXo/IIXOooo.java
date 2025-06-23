package OoIXo;

import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class IIXOooo extends OI0 {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2050xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(IIXOooo.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public byte[] f2051II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public oI0IIXIo f2052Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f2053X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f2054XO;

    public IIXOooo(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f2051II0XooXoX = I0Io2;
        this.f2054XO = oo0xXOI0I.oxoX(I0Io2[10], I0Io2[11], I0Io2[12], I0Io2[13]);
        byte[] bArr = this.f2051II0XooXoX;
        this.f2053X0o0xo = oo0xXOI0I.oxoX(bArr[14], bArr[15], bArr[16], bArr[17]);
    }

    public void I0X0x0oIo() {
        if (this.f2052Oxx0IOOO == null) {
            this.f2052Oxx0IOOO = new oI0IIXIo(this.f2051II0XooXoX);
        }
        this.f2052Oxx0IOOO.II0xO0();
    }

    public void XX0() {
        if (this.f2052Oxx0IOOO == null) {
            this.f2052Oxx0IOOO = new oI0IIXIo(this.f2051II0XooXoX);
        }
        this.f2052Oxx0IOOO.oIX0oI();
    }

    public int Xo0() {
        oI0IIXIo oi0iixio = this.f2052Oxx0IOOO;
        if (oi0iixio == null) {
            return this.f2054XO;
        }
        return oi0iixio.X0o0xo();
    }

    public boolean XoI0Ixx0() {
        oI0IIXIo oi0iixio = this.f2052Oxx0IOOO;
        if (oi0iixio == null || oi0iixio.oxoX() > 0) {
            return true;
        }
        return false;
    }

    public int oX() {
        return this.f2053X0o0xo;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        oI0IIXIo oi0iixio = this.f2052Oxx0IOOO;
        if (oi0iixio == null) {
            return this.f2051II0XooXoX;
        }
        return oi0iixio.I0Io();
    }

    public IIXOooo(oI0IIXIo oi0iixio) {
        super(xII.f2510x0OxxIOxX);
        this.f2052Oxx0IOOO = oi0iixio;
    }

    public IIXOooo(IIXOooo iIXOooo) {
        super(xII.f2510x0OxxIOxX);
        this.f2051II0XooXoX = iIXOooo.xo0x();
    }
}
