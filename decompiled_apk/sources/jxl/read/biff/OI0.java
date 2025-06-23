package jxl.read.biff;

/* loaded from: classes6.dex */
public class OI0 extends OoIXo.Xx000oIo {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28228xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(OI0.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28229I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int[] f28230II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int[] f28231Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28232X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28233XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28234oxoX;

    public OI0(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        int oxoX2 = oxXx0IX().oxoX();
        this.f28229I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28234oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[oxoX2 - 2], I0Io2[oxoX2 - 1]);
        this.f28232X0o0xo = I0Io3;
        int i = (I0Io3 - this.f28234oxoX) + 1;
        this.f28233XO = i;
        this.f28231Oxx0IOOO = new int[i];
        this.f28230II0XooXoX = new int[i];
        oX(I0Io2);
    }

    public int I0X0x0oIo(int i) {
        return this.f28230II0XooXoX[i];
    }

    public int II0xO0() {
        return this.f28229I0Io;
    }

    public int XX0(int i) {
        return this.f28231Oxx0IOOO[i];
    }

    public final void oX(byte[] bArr) {
        int i = 4;
        for (int i2 = 0; i2 < this.f28233XO; i2++) {
            this.f28230II0XooXoX[i2] = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
            this.f28231Oxx0IOOO[i2] = OoIXo.oo0xXOI0I.oxoX(bArr[i + 2], bArr[i + 3], bArr[i + 4], bArr[i + 5]);
            i += 6;
        }
    }

    public int xXOx() {
        return this.f28233XO;
    }

    public int xo0x() {
        return this.f28234oxoX;
    }
}
