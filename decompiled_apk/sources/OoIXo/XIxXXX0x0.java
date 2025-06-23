package OoIXo;

import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class XIxXXX0x0 extends OI0 implements oI0X0.Oxx0IOOO {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f2232Oxx0xo = 20;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f2233II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public byte f2234OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f2235Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f2236X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f2237XO;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f2238oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f2239oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f2240ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f2241x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f2242x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public byte f2243xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f2244xxIXOIIO;

    /* renamed from: Oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2231Oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(XIxXXX0x0.class);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final II0xO0 f2230IXxxXO = new II0xO0();

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    public XIxXXX0x0(String str, int i, int i2, boolean z, int i3, int i4, int i5) {
        super(xII.f2412I0);
        this.f2235Oxx0IOOO = i2;
        this.f2244xxIXOIIO = i3;
        this.f2241x0XOIxOo = str;
        this.f2236X0o0xo = i;
        this.f2239oOoXoXO = z;
        this.f2233II0XooXoX = i5;
        this.f2237XO = i4;
        this.f2238oO = false;
        this.f2240ooOOo0oXI = false;
    }

    public void I0X0x0oIo(int i) {
        XxIIOXIXx.oIX0oI.oIX0oI(!this.f2238oO);
        this.f2235Oxx0IOOO = i;
    }

    public void I0oOIX(boolean z) {
        this.f2240ooOOo0oXI = z;
    }

    public void O0Xx(int i) {
        XxIIOXIXx.oIX0oI.oIX0oI(!this.f2238oO);
        this.f2233II0XooXoX = i;
    }

    @Override // oI0X0.Oxx0IOOO
    public oI0X0.XO O0xOxO() {
        return oI0X0.XO.Oxx0IOOO(this.f2237XO);
    }

    @Override // oI0X0.Oxx0IOOO
    public boolean OI0() {
        return this.f2239oOoXoXO;
    }

    public final void OO() {
        this.f2238oO = false;
    }

    @Override // oI0X0.Oxx0IOOO
    public int XOxIOxOx() {
        return this.f2235Oxx0IOOO;
    }

    @Override // oI0X0.Oxx0IOOO
    public oI0X0.oO XX() {
        return oI0X0.oO.II0xO0(this.f2233II0XooXoX);
    }

    public final int XX0() {
        return this.f2242x0xO0oo;
    }

    public void Xo0(boolean z) {
        XxIIOXIXx.oIX0oI.oIX0oI(!this.f2238oO);
        this.f2239oOoXoXO = z;
    }

    public void XoI0Ixx0(int i) {
        XxIIOXIXx.oIX0oI.oIX0oI(!this.f2238oO);
        this.f2236X0o0xo = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof XIxXXX0x0)) {
            return false;
        }
        XIxXXX0x0 xIxXXX0x0 = (XIxXXX0x0) obj;
        if (this.f2236X0o0xo == xIxXXX0x0.f2236X0o0xo && this.f2237XO == xIxXXX0x0.f2237XO && this.f2235Oxx0IOOO == xIxXXX0x0.f2235Oxx0IOOO && this.f2233II0XooXoX == xIxXXX0x0.f2233II0XooXoX && this.f2244xxIXOIIO == xIxXXX0x0.f2244xxIXOIIO && this.f2239oOoXoXO == xIxXXX0x0.f2239oOoXoXO && this.f2240ooOOo0oXI == xIxXXX0x0.f2240ooOOo0oXI && this.f2243xoIox == xIxXXX0x0.f2243xoIox && this.f2234OOXIXo == xIxXXX0x0.f2234OOXIXo && this.f2241x0XOIxOo.equals(xIxXXX0x0.f2241x0XOIxOo)) {
            return true;
        }
        return false;
    }

    @Override // oI0X0.Oxx0IOOO
    public String getName() {
        return this.f2241x0XOIxOo;
    }

    public int hashCode() {
        return this.f2241x0XOIxOo.hashCode();
    }

    public final void initialize(int i) {
        this.f2242x0xO0oo = i;
        this.f2238oO = true;
    }

    public final boolean isInitialized() {
        return this.f2238oO;
    }

    @Override // oI0X0.Oxx0IOOO
    public oI0X0.x0xO0oo o00() {
        return oI0X0.x0xO0oo.II0xO0(this.f2244xxIXOIIO);
    }

    public void oX(int i) {
        XxIIOXIXx.oIX0oI.oIX0oI(!this.f2238oO);
        this.f2237XO = i;
    }

    @Override // oI0X0.Oxx0IOOO
    public boolean x0xO0oo() {
        return this.f2240ooOOo0oXI;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[(this.f2241x0XOIxOo.length() * 2) + 16];
        oo0xXOI0I.XO(this.f2236X0o0xo * 20, bArr, 0);
        if (this.f2239oOoXoXO) {
            bArr[2] = (byte) (bArr[2] | 2);
        }
        if (this.f2240ooOOo0oXI) {
            bArr[2] = (byte) (bArr[2] | 8);
        }
        oo0xXOI0I.XO(this.f2237XO, bArr, 4);
        oo0xXOI0I.XO(this.f2235Oxx0IOOO, bArr, 6);
        oo0xXOI0I.XO(this.f2233II0XooXoX, bArr, 8);
        bArr[10] = (byte) this.f2244xxIXOIIO;
        bArr[11] = this.f2243xoIox;
        bArr[12] = this.f2234OOXIXo;
        bArr[13] = 0;
        bArr[14] = (byte) this.f2241x0XOIxOo.length();
        bArr[15] = 1;
        IO.X0o0xo(this.f2241x0XOIxOo, bArr, 16);
        return bArr;
    }

    @Override // oI0X0.Oxx0IOOO
    public int xoXoI() {
        return this.f2236X0o0xo;
    }

    public void xoxXI(int i) {
        XxIIOXIXx.oIX0oI.oIX0oI(!this.f2238oO);
        this.f2244xxIXOIIO = i;
    }

    public XIxXXX0x0(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f2236X0o0xo = oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]) / 20;
        this.f2237XO = oo0xXOI0I.I0Io(I0Io2[4], I0Io2[5]);
        this.f2235Oxx0IOOO = oo0xXOI0I.I0Io(I0Io2[6], I0Io2[7]);
        this.f2233II0XooXoX = oo0xXOI0I.I0Io(I0Io2[8], I0Io2[9]);
        this.f2244xxIXOIIO = I0Io2[10];
        this.f2243xoIox = I0Io2[11];
        this.f2234OOXIXo = I0Io2[12];
        this.f2238oO = false;
        byte b = I0Io2[2];
        if ((b & 2) != 0) {
            this.f2239oOoXoXO = true;
        }
        if ((b & 8) != 0) {
            this.f2240ooOOo0oXI = true;
        }
        byte b2 = I0Io2[14];
        byte b3 = I0Io2[15];
        if (b3 == 0) {
            this.f2241x0XOIxOo = IO.oxoX(I0Io2, b2, 16, o0xOxO);
        } else if (b3 == 1) {
            this.f2241x0XOIxOo = IO.Oxx0IOOO(I0Io2, b2, 16);
        } else {
            this.f2241x0XOIxOo = IO.oxoX(I0Io2, b2, 15, o0xOxO);
        }
    }

    public XIxXXX0x0(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO, II0xO0 iI0xO0) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f2236X0o0xo = oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]) / 20;
        this.f2237XO = oo0xXOI0I.I0Io(I0Io2[4], I0Io2[5]);
        this.f2235Oxx0IOOO = oo0xXOI0I.I0Io(I0Io2[6], I0Io2[7]);
        this.f2233II0XooXoX = oo0xXOI0I.I0Io(I0Io2[8], I0Io2[9]);
        this.f2244xxIXOIIO = I0Io2[10];
        this.f2243xoIox = I0Io2[11];
        this.f2238oO = false;
        byte b = I0Io2[2];
        if ((b & 2) != 0) {
            this.f2239oOoXoXO = true;
        }
        if ((b & 8) != 0) {
            this.f2240ooOOo0oXI = true;
        }
        this.f2241x0XOIxOo = IO.oxoX(I0Io2, I0Io2[14], 15, o0xOxO);
    }

    public XIxXXX0x0(oI0X0.Oxx0IOOO oxx0IOOO) {
        super(xII.f2412I0);
        XxIIOXIXx.oIX0oI.oIX0oI(oxx0IOOO != null);
        this.f2236X0o0xo = oxx0IOOO.xoXoI();
        this.f2237XO = oxx0IOOO.O0xOxO().II0XooXoX();
        this.f2235Oxx0IOOO = oxx0IOOO.XOxIOxOx();
        this.f2233II0XooXoX = oxx0IOOO.XX().I0Io();
        this.f2244xxIXOIIO = oxx0IOOO.o00().I0Io();
        this.f2239oOoXoXO = oxx0IOOO.OI0();
        this.f2241x0XOIxOo = oxx0IOOO.getName();
        this.f2240ooOOo0oXI = oxx0IOOO.x0xO0oo();
        this.f2238oO = false;
    }
}
