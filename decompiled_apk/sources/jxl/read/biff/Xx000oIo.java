package jxl.read.biff;

/* loaded from: classes6.dex */
public class Xx000oIo extends oOoXoXO implements xIoXXXIXo.IXxxXO {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f28317oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public String f28318ooOOo0oXI;

    public Xx000oIo(xoxXI xoxxi, XIo0oOXIx xIo0oOXIx, OoIXo.xXxxox0I xxxxox0i, I0 i0) {
        super(xoxxi, xxxxox0i, i0);
        byte[] I0Io2 = oxXx0IX().I0Io();
        int oxoX2 = OoIXo.oo0xXOI0I.oxoX(I0Io2[6], I0Io2[7], I0Io2[8], I0Io2[9]);
        this.f28317oOoXoXO = oxoX2;
        this.f28318ooOOo0oXI = xIo0oOXIx.XX0(oxoX2);
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28318ooOOo0oXI;
    }

    @Override // xIoXXXIXo.IXxxXO
    public String IoOoX() {
        return this.f28318ooOOo0oXI;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34232I0Io;
    }
}
