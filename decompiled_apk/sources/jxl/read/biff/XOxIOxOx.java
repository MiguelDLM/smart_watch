package jxl.read.biff;

/* loaded from: classes6.dex */
public class XOxIOxOx extends OoIXo.Xx000oIo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28294II0XooXoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(XOxIOxOx.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28295I0Io;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int[] f28296Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28297X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28298XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28299oxoX;

    public XOxIOxOx(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        int oxoX2 = oxXx0IX().oxoX();
        this.f28295I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28299oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[oxoX2 - 2], I0Io2[oxoX2 - 1]);
        this.f28297X0o0xo = I0Io3;
        int i = (I0Io3 - this.f28299oxoX) + 1;
        this.f28298XO = i;
        this.f28296Oxx0IOOO = new int[i];
        I0X0x0oIo(I0Io2);
    }

    public final void I0X0x0oIo(byte[] bArr) {
        int i = 4;
        for (int i2 = 0; i2 < this.f28298XO; i2++) {
            this.f28296Oxx0IOOO[i2] = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
            i += 2;
        }
    }

    public int II0xO0() {
        return this.f28295I0Io;
    }

    public int XX0(int i) {
        return this.f28296Oxx0IOOO[i];
    }

    public int xXOx() {
        return this.f28298XO;
    }

    public int xo0x() {
        return this.f28299oxoX;
    }
}
