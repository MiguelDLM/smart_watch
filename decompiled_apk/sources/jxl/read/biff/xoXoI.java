package jxl.read.biff;

/* loaded from: classes6.dex */
public class xoXoI extends OoIXo.Xx000oIo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28528X0o0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(xoXoI.class);

    /* renamed from: XO, reason: collision with root package name */
    public static II0xO0 f28529XO = new II0xO0();

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28530I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28531oxoX;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    public xoXoI(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = xoxxi.I0Io();
        if (I0Io2.length == 10) {
            XX0(I0Io2);
        } else {
            I0X0x0oIo(I0Io2);
        }
    }

    public final void I0X0x0oIo(byte[] bArr) {
        this.f28530I0Io = OoIXo.oo0xXOI0I.oxoX(bArr[4], bArr[5], bArr[6], bArr[7]);
        this.f28531oxoX = OoIXo.oo0xXOI0I.I0Io(bArr[10], bArr[11]);
    }

    public final void XX0(byte[] bArr) {
        this.f28530I0Io = OoIXo.oo0xXOI0I.I0Io(bArr[2], bArr[3]);
        this.f28531oxoX = OoIXo.oo0xXOI0I.I0Io(bArr[6], bArr[7]);
    }

    public int xXOx() {
        return this.f28530I0Io;
    }

    public int xo0x() {
        return this.f28531oxoX;
    }

    public xoXoI(xoxXI xoxxi, II0xO0 iI0xO0) {
        super(xoxxi);
        XX0(xoxxi.I0Io());
    }
}
