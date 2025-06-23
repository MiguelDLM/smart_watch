package jxl.read.biff;

/* loaded from: classes6.dex */
public class ooXIXxIX extends OoIXo.Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f28451I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28450oxoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(ooXIXxIX.class);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static II0xO0 f28449X0o0xo = new II0xO0();

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    public ooXIXxIX(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        if (I0Io2.length == 0) {
            return;
        }
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        if (I0Io2[2] == 1) {
            this.f28451I0Io = OoIXo.IO.Oxx0IOOO(I0Io2, I0Io3, 3);
        } else {
            this.f28451I0Io = OoIXo.IO.oxoX(I0Io2, I0Io3, 3, o0xOxO);
        }
    }

    public String xo0x() {
        return this.f28451I0Io;
    }

    public ooXIXxIX(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO, II0xO0 iI0xO0) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        if (I0Io2.length == 0) {
            return;
        }
        this.f28451I0Io = OoIXo.IO.oxoX(I0Io2, I0Io2[0], 1, o0xOxO);
    }
}
