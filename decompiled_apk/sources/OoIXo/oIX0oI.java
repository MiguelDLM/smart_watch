package OoIXo;

import java.io.IOException;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public I0Io f2333I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public II0xO0 f2334II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public XI0IXoo f2335oIX0oI;

    public oIX0oI(XI0IXoo xI0IXoo, II0xO0 iI0xO0) {
        this.f2335oIX0oI = xI0IXoo;
        this.f2334II0xO0 = iI0xO0;
    }

    public void II0xO0(jxl.write.biff.IIX0o iIX0o) throws IOException {
        XI0IXoo xI0IXoo = this.f2335oIX0oI;
        if (xI0IXoo != null) {
            iIX0o.XO(xI0IXoo);
        }
        II0xO0 iI0xO0 = this.f2334II0xO0;
        if (iI0xO0 != null) {
            iIX0o.XO(iI0xO0);
        }
        I0Io i0Io = this.f2333I0Io;
        if (i0Io != null) {
            iIX0o.XO(i0Io);
        }
    }

    public void oIX0oI(I0Io i0Io) {
        this.f2333I0Io = i0Io;
    }
}
