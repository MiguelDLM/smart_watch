package Oxxo;

import java.util.Enumeration;
import org.apache.log4j.lf5.LogRecord;

/* loaded from: classes6.dex */
public class I0Io implements org.apache.log4j.lf5.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public X0o0xo f3124oIX0oI;

    public I0Io(X0o0xo x0o0xo) {
        this.f3124oIX0oI = x0o0xo;
    }

    public void I0Io() {
        Enumeration depthFirstEnumeration = this.f3124oIX0oI.XO().depthFirstEnumeration();
        while (depthFirstEnumeration.hasMoreElements()) {
            xxIXOIIO xxixoiio = (xxIXOIIO) depthFirstEnumeration.nextElement();
            xxixoiio.ooOOo0oXI();
            this.f3124oIX0oI.nodeChanged(xxixoiio);
        }
    }

    public void II0xO0() {
        I0Io();
    }

    @Override // org.apache.log4j.lf5.oxoX
    public boolean oIX0oI(LogRecord logRecord) {
        return this.f3124oIX0oI.II0XooXoX(new IIXOooo(logRecord.getCategory()));
    }
}
