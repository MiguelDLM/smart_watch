package jxl.read.biff;

/* loaded from: classes6.dex */
public class X0IIOO extends OoIXo.Xx000oIo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28254X0o0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(X0IIOO.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public String f28255I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f28256oxoX;

    public X0IIOO(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        if (OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]) == 0) {
            this.f28256oxoX = true;
        }
        if (!this.f28256oxoX) {
            return;
        }
        byte b = I0Io2[6];
        if (I0Io2[7] != 0) {
            this.f28255I0Io = OoIXo.IO.Oxx0IOOO(I0Io2, b, 8);
        } else {
            this.f28255I0Io = OoIXo.IO.oxoX(I0Io2, b, 8, o0xOxO);
        }
    }

    public String getName() {
        return this.f28255I0Io;
    }

    public boolean xo0x() {
        return this.f28256oxoX;
    }
}
