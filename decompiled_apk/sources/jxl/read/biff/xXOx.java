package jxl.read.biff;

/* loaded from: classes6.dex */
public class xXOx extends OoIXo.Xx000oIo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28507X0o0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(xXOx.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28508I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28509oxoX;

    public xXOx(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = xoxxi.I0Io();
        this.f28509oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28508I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
    }

    public final int xXOx() {
        return this.f28508I0Io;
    }

    public final int xo0x() {
        return this.f28509oxoX;
    }
}
