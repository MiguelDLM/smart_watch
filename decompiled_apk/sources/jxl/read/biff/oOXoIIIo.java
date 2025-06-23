package jxl.read.biff;

/* loaded from: classes6.dex */
public class oOXoIIIo extends oOoXoXO implements xIoXXXIXo.IXxxXO {

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static II0xO0 f28385x0XOIxOo = new II0xO0();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f28386oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public String f28387ooOOo0oXI;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    public oOXoIIIo(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, I0 i0, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi, xxxxox0i, i0);
        byte[] I0Io2 = oxXx0IX().I0Io();
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[6], I0Io2[7]);
        this.f28386oOoXoXO = I0Io3;
        if (I0Io2[8] == 0) {
            this.f28387ooOOo0oXI = OoIXo.IO.oxoX(I0Io2, I0Io3, 9, o0xOxO);
        } else {
            this.f28387ooOOo0oXI = OoIXo.IO.Oxx0IOOO(I0Io2, I0Io3, 9);
        }
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28387ooOOo0oXI;
    }

    @Override // xIoXXXIXo.IXxxXO
    public String IoOoX() {
        return this.f28387ooOOo0oXI;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34232I0Io;
    }

    public oOXoIIIo(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, I0 i0, xIoXXXIXo.O0xOxO o0xOxO, II0xO0 iI0xO0) {
        super(xoxxi, xxxxox0i, i0);
        byte[] I0Io2 = oxXx0IX().I0Io();
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[6], I0Io2[7]);
        this.f28386oOoXoXO = I0Io3;
        this.f28387ooOOo0oXI = OoIXo.IO.oxoX(I0Io2, I0Io3, 8, o0xOxO);
    }
}
