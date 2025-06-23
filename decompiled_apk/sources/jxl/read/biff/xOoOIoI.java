package jxl.read.biff;

/* loaded from: classes6.dex */
public class xOoOIoI extends OoIXo.Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f28496I0Io;

    public xOoOIoI(xoxXI xoxxi, boolean z, xIoXXXIXo.O0xOxO o0xOxO) {
        super(OoIXo.xII.f2470XOxIOxOx);
        byte[] I0Io2 = xoxxi.I0Io();
        if (z) {
            this.f28496I0Io = OoIXo.IO.Oxx0IOOO(I0Io2, 56, 0);
        } else {
            this.f28496I0Io = OoIXo.IO.oxoX(I0Io2, I0Io2[1], 1, o0xOxO);
        }
    }

    public String xo0x() {
        return this.f28496I0Io;
    }
}
