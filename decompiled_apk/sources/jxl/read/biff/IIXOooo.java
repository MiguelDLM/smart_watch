package jxl.read.biff;

/* loaded from: classes6.dex */
public class IIXOooo extends OoIXo.Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28190I0Io;

    public IIXOooo(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = xoxxi.I0Io();
        if (I0Io2.length > 2) {
            this.f28190I0Io = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
        }
    }

    public int xo0x() {
        return this.f28190I0Io;
    }
}
