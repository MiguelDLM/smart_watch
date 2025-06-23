package jxl.read.biff;

/* loaded from: classes6.dex */
public class oXIO0o0XI extends OoIXo.Xx000oIo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static II0xO0 f28408X0o0xo = new II0xO0();

    /* renamed from: I0Io, reason: collision with root package name */
    public final XxIIOXIXx.X0o0xo f28409I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int[] f28410oxoX;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    public oXIO0o0XI(xoxXI xoxxi) {
        super(xoxxi);
        this.f28409I0Io = XxIIOXIXx.X0o0xo.Oxx0IOOO(oXIO0o0XI.class);
        byte[] I0Io2 = xoxxi.I0Io();
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28410oxoX = new int[I0Io3];
        int i = 2;
        for (int i2 = 0; i2 < I0Io3; i2++) {
            this.f28410oxoX[i2] = OoIXo.oo0xXOI0I.I0Io(I0Io2[i], I0Io2[i + 1]);
            i += 6;
        }
    }

    public int[] xo0x() {
        return this.f28410oxoX;
    }

    public oXIO0o0XI(xoxXI xoxxi, II0xO0 iI0xO0) {
        super(xoxxi);
        this.f28409I0Io = XxIIOXIXx.X0o0xo.Oxx0IOOO(oXIO0o0XI.class);
        byte[] I0Io2 = xoxxi.I0Io();
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28410oxoX = new int[I0Io3];
        int i = 2;
        for (int i2 = 0; i2 < I0Io3; i2++) {
            this.f28410oxoX[i2] = OoIXo.oo0xXOI0I.I0Io(I0Io2[i], I0Io2[i + 1]);
            i += 2;
        }
    }
}
