package jxl.read.biff;

/* loaded from: classes6.dex */
public class OO0x0xX extends OoIXo.Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28235I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28236oxoX;

    public OO0x0xX(xoxXI xoxxi) {
        super(OoIXo.xII.f2427IXO);
        byte[] I0Io2 = xoxxi.I0Io();
        this.f28235I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28236oxoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
    }

    public int xo0x() {
        return (this.f28235I0Io * 100) / this.f28236oxoX;
    }
}
