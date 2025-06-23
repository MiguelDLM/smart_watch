package jxl.read.biff;

/* loaded from: classes6.dex */
public class XI0IXoo extends OoIXo.Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public I0Io[] f28264I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28263oxoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(XI0IXoo.class);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static II0xO0 f28262X0o0xo = new II0xO0();

    /* loaded from: classes6.dex */
    public static class I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f28265I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f28266II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f28267oIX0oI;

        public I0Io(int i, int i2, int i3) {
            this.f28267oIX0oI = i;
            this.f28266II0xO0 = i2;
            this.f28265I0Io = i3;
        }
    }

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    public XI0IXoo(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        int i = 2;
        if (I0Io2.length < (I0Io3 * 6) + 2) {
            this.f28264I0Io = new I0Io[0];
            f28263oxoX.ooOOo0oXI("Could not process external sheets.  Formulas may be compromised.");
            return;
        }
        this.f28264I0Io = new I0Io[I0Io3];
        for (int i2 = 0; i2 < I0Io3; i2++) {
            this.f28264I0Io[i2] = new I0Io(OoIXo.oo0xXOI0I.I0Io(I0Io2[i], I0Io2[i + 1]), OoIXo.oo0xXOI0I.I0Io(I0Io2[i + 2], I0Io2[i + 3]), OoIXo.oo0xXOI0I.I0Io(I0Io2[i + 4], I0Io2[i + 5]));
            i += 6;
        }
    }

    public int I0X0x0oIo() {
        I0Io[] i0IoArr = this.f28264I0Io;
        if (i0IoArr != null) {
            return i0IoArr.length;
        }
        return 0;
    }

    public int XX0(int i) {
        return this.f28264I0Io[i].f28265I0Io;
    }

    public int oX(int i) {
        return this.f28264I0Io[i].f28267oIX0oI;
    }

    public int xXOx(int i) {
        return this.f28264I0Io[i].f28266II0xO0;
    }

    public byte[] xo0x() {
        return oxXx0IX().I0Io();
    }

    public XI0IXoo(xoxXI xoxxi, xIoXXXIXo.O0xOxO o0xOxO, II0xO0 iI0xO0) {
        super(xoxxi);
        f28263oxoX.ooOOo0oXI("External sheet record for Biff 7 not supported");
    }
}
