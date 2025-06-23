package OoIXo;

import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class XOxIOxOx extends OI0 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f2248OOXIXo = 1024;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f2249oOoXoXO = 2048;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f2250ooOOo0oXI = 1217;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f2251xoIox = 256;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2252xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(XOxIOxOx.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f2253II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f2254Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f2255X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f2256XO;

    public XOxIOxOx(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f2255X0o0xo = oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f2253II0XooXoX = true;
        this.f2256XO = true;
        this.f2254Oxx0IOOO = true;
    }

    public void I0X0x0oIo(boolean z) {
        this.f2256XO = true;
    }

    public boolean XX0() {
        return this.f2253II0XooXoX;
    }

    public void Xo0(boolean z) {
        this.f2256XO = true;
    }

    public void oX(boolean z) {
        this.f2253II0XooXoX = z;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[2];
        if (this.f2253II0XooXoX) {
            this.f2255X0o0xo |= 256;
        }
        if (this.f2256XO) {
            this.f2255X0o0xo |= 1024;
        }
        if (this.f2254Oxx0IOOO) {
            this.f2255X0o0xo |= 2048;
        }
        oo0xXOI0I.XO(this.f2255X0o0xo, bArr, 0);
        return bArr;
    }

    public XOxIOxOx() {
        super(xII.f2443OI0);
        this.f2255X0o0xo = f2250ooOOo0oXI;
    }
}
