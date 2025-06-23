package jxl.read.biff;

/* loaded from: classes6.dex */
public class xII extends OoIXo.Xx000oIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public xIoXXXIXo.OxxIIOOXO[] f28493I0Io;

    public xII(xoxXI xoxxi, xIoXXXIXo.IIXOooo iIXOooo) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28493I0Io = new xIoXXXIXo.OxxIIOOXO[I0Io3];
        int i = 2;
        for (int i2 = 0; i2 < I0Io3; i2++) {
            int I0Io4 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i], I0Io2[i + 1]);
            int I0Io5 = OoIXo.oo0xXOI0I.I0Io(I0Io2[i + 2], I0Io2[i + 3]);
            this.f28493I0Io[i2] = new OoIXo.X00IoxXI(iIXOooo, OoIXo.oo0xXOI0I.I0Io(I0Io2[i + 4], I0Io2[i + 5]), I0Io4, OoIXo.oo0xXOI0I.I0Io(I0Io2[i + 6], I0Io2[i + 7]), I0Io5);
            i += 8;
        }
    }

    public xIoXXXIXo.OxxIIOOXO[] xo0x() {
        return this.f28493I0Io;
    }
}
