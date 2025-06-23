package jxl.read.biff;

/* loaded from: classes6.dex */
public class IXxxXO extends OoIXo.Xx000oIo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28195X0o0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(IXxxXO.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28196I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28197oxoX;

    public IXxxXO(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = xoxxi.I0Io();
        this.f28196I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28197oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
    }

    public int xXOx() {
        return this.f28197oxoX;
    }

    public int xo0x() {
        return this.f28196I0Io;
    }
}
