package jxl.write.biff;

/* loaded from: classes6.dex */
public abstract class oxxXoxO extends oOoXoXO {

    /* renamed from: Oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28962Oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(oxxXoxO.class);

    /* renamed from: oO, reason: collision with root package name */
    public IoIOOxIIo f28963oO;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f28964x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f28965x0xO0oo;

    public oxxXoxO(int i, int i2, String str) {
        super(OoIXo.xII.f2442O0xOxO, i, i2);
        this.f28964x0XOIxOo = str;
        if (str == null) {
            this.f28964x0XOIxOo = "";
        }
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28964x0XOIxOo;
    }

    public String IoOoX() {
        return this.f28964x0XOIxOo;
    }

    public void O00XxXI(String str) {
        boolean z;
        if (str == null) {
            str = "";
        }
        this.f28964x0XOIxOo = str;
        if (!xoIxX()) {
            return;
        }
        if (this.f28963oO != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        int I0Io2 = this.f28963oO.I0Io(this.f28964x0XOIxOo);
        this.f28965x0xO0oo = I0Io2;
        this.f28964x0XOIxOo = this.f28963oO.II0xO0(I0Io2);
    }

    @Override // jxl.write.biff.oOoXoXO
    public void XX0xXo(OoIXo.xXxxox0I xxxxox0i, IoIOOxIIo ioIOOxIIo, XOxxooXI xOxxooXI) {
        super.XX0xXo(xxxxox0i, ioIOOxIIo, xOxxooXI);
        this.f28963oO = ioIOOxIIo;
        int I0Io2 = ioIOOxIIo.I0Io(this.f28964x0XOIxOo);
        this.f28965x0xO0oo = I0Io2;
        this.f28964x0XOIxOo = this.f28963oO.II0xO0(I0Io2);
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34232I0Io;
    }

    @Override // jxl.write.biff.oOoXoXO, OoIXo.OI0
    public byte[] xo0x() {
        byte[] xo0x2 = super.xo0x();
        byte[] bArr = new byte[xo0x2.length + 4];
        System.arraycopy(xo0x2, 0, bArr, 0, xo0x2.length);
        OoIXo.oo0xXOI0I.oIX0oI(this.f28965x0xO0oo, bArr, xo0x2.length);
        return bArr;
    }

    public oxxXoxO(int i, int i2, String str, oI0X0.X0o0xo x0o0xo) {
        super(OoIXo.xII.f2442O0xOxO, i, i2, x0o0xo);
        this.f28964x0XOIxOo = str;
        if (str == null) {
            this.f28964x0XOIxOo = "";
        }
    }

    public oxxXoxO(int i, int i2, oxxXoxO oxxxoxo) {
        super(OoIXo.xII.f2442O0xOxO, i, i2, oxxxoxo);
        this.f28964x0XOIxOo = oxxxoxo.f28964x0XOIxOo;
    }

    public oxxXoxO(xIoXXXIXo.IXxxXO iXxxXO) {
        super(OoIXo.xII.f2442O0xOxO, iXxxXO);
        String IoOoX2 = iXxxXO.IoOoX();
        this.f28964x0XOIxOo = IoOoX2;
        if (IoOoX2 == null) {
            this.f28964x0XOIxOo = "";
        }
    }
}
