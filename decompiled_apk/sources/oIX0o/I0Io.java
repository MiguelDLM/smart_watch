package oIX0o;

import java.util.Vector;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class I0Io implements org.apache.log4j.spi.X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public Vector f31616I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public org.apache.log4j.oIX0oI f31617II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public org.apache.log4j.oIX0oI f31618oIX0oI;

    @Override // org.apache.log4j.spi.X0o0xo
    public void II0xO0(x0xO0oo x0xo0oo) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FB: Adding logger [");
        stringBuffer.append(x0xo0oo.xxX());
        stringBuffer.append("].");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        if (this.f31616I0Io == null) {
            this.f31616I0Io = new Vector();
        }
        this.f31616I0Io.addElement(x0xo0oo);
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void IXxxXO(String str, Exception exc, int i, LoggingEvent loggingEvent) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FB: The following error reported: ");
        stringBuffer.append(str);
        org.apache.log4j.helpers.xxIXOIIO.II0xO0(stringBuffer.toString(), exc);
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI("FB: INITIATING FALLBACK PROCEDURE.");
        if (this.f31616I0Io != null) {
            for (int i2 = 0; i2 < this.f31616I0Io.size(); i2++) {
                x0xO0oo x0xo0oo = (x0xO0oo) this.f31616I0Io.elementAt(i2);
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("FB: Searching for [");
                stringBuffer2.append(this.f31617II0xO0.getName());
                stringBuffer2.append("] in logger [");
                stringBuffer2.append(x0xo0oo.xxX());
                stringBuffer2.append("].");
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("FB: Replacing [");
                stringBuffer3.append(this.f31617II0xO0.getName());
                stringBuffer3.append("] by [");
                stringBuffer3.append(this.f31618oIX0oI.getName());
                stringBuffer3.append("] in logger [");
                stringBuffer3.append(x0xo0oo.xxX());
                stringBuffer3.append("].");
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer3.toString());
                x0xo0oo.Oxx0IOOO(this.f31617II0xO0);
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("FB: Adding appender [");
                stringBuffer4.append(this.f31618oIX0oI.getName());
                stringBuffer4.append("] to logger ");
                stringBuffer4.append(x0xo0oo.xxX());
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer4.toString());
                x0xo0oo.oIX0oI(this.f31618oIX0oI);
            }
        }
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void Oo(org.apache.log4j.oIX0oI oix0oi) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FB: Setting primary appender to [");
        stringBuffer.append(oix0oi.getName());
        stringBuffer.append("].");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        this.f31617II0xO0 = oix0oi;
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void OxxIIOOXO(String str, Exception exc, int i) {
        IXxxXO(str, exc, i, null);
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void XO(org.apache.log4j.oIX0oI oix0oi) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FB: Setting backup appender to [");
        stringBuffer.append(oix0oi.getName());
        stringBuffer.append("].");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        this.f31618oIX0oI = oix0oi;
    }

    @Override // org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void error(String str) {
    }
}
