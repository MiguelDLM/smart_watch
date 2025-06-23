package jxl.read.biff;

/* loaded from: classes6.dex */
public class XO extends oOoXoXO implements xIoXXXIXo.oIX0oI {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f28292oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f28293ooOOo0oXI;

    public XO(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, I0 i0) {
        super(xoxxi, xxxxox0i, i0);
        boolean z;
        this.f28292oOoXoXO = false;
        this.f28293ooOOo0oXI = false;
        byte[] I0Io2 = oxXx0IX().I0Io();
        if (I0Io2[7] == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f28292oOoXoXO = z;
        if (!z) {
            this.f28293ooOOo0oXI = I0Io2[6] == 1;
        }
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        XxIIOXIXx.oIX0oI.oIX0oI(!XX0());
        return new Boolean(this.f28293ooOOo0oXI).toString();
    }

    public boolean XX0() {
        return this.f28292oOoXoXO;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34237X0o0xo;
    }

    @Override // xIoXXXIXo.oIX0oI
    public boolean getValue() {
        return this.f28293ooOOo0oXI;
    }

    @Override // OoIXo.Xx000oIo
    public xoxXI oxXx0IX() {
        return super.oxXx0IX();
    }
}
