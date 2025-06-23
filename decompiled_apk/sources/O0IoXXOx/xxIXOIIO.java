package O0IoXXOx;

import org.apache.log4j.helpers.oI0IIXIo;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.x0XOIxOo;

/* loaded from: classes6.dex */
public class xxIXOIIO extends x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f1195I0Io = 256;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f1198oxoX = 2048;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public StringBuffer f1196X0o0xo = new StringBuffer(256);

    /* renamed from: XO, reason: collision with root package name */
    public boolean f1197XO = false;

    public boolean II0XooXoX() {
        return this.f1197XO;
    }

    @Override // org.apache.log4j.x0XOIxOo
    public boolean Oxx0IOOO() {
        return false;
    }

    @Override // org.apache.log4j.x0XOIxOo
    public String oIX0oI(LoggingEvent loggingEvent) {
        if (this.f1196X0o0xo.capacity() > 2048) {
            this.f1196X0o0xo = new StringBuffer(256);
        } else {
            this.f1196X0o0xo.setLength(0);
        }
        this.f1196X0o0xo.append("<log4j:event logger=\"");
        this.f1196X0o0xo.append(loggingEvent.getLoggerName());
        this.f1196X0o0xo.append("\" timestamp=\"");
        this.f1196X0o0xo.append(loggingEvent.timeStamp);
        this.f1196X0o0xo.append("\" level=\"");
        this.f1196X0o0xo.append(loggingEvent.getLevel());
        this.f1196X0o0xo.append("\" thread=\"");
        this.f1196X0o0xo.append(loggingEvent.getThreadName());
        this.f1196X0o0xo.append("\">\r\n");
        this.f1196X0o0xo.append("<log4j:message><![CDATA[");
        oI0IIXIo.oIX0oI(this.f1196X0o0xo, loggingEvent.getRenderedMessage());
        this.f1196X0o0xo.append("]]></log4j:message>\r\n");
        String ndc = loggingEvent.getNDC();
        if (ndc != null) {
            this.f1196X0o0xo.append("<log4j:NDC><![CDATA[");
            this.f1196X0o0xo.append(ndc);
            this.f1196X0o0xo.append("]]></log4j:NDC>\r\n");
        }
        String[] throwableStrRep = loggingEvent.getThrowableStrRep();
        if (throwableStrRep != null) {
            this.f1196X0o0xo.append("<log4j:throwable><![CDATA[");
            for (String str : throwableStrRep) {
                this.f1196X0o0xo.append(str);
                this.f1196X0o0xo.append("\r\n");
            }
            this.f1196X0o0xo.append("]]></log4j:throwable>\r\n");
        }
        if (this.f1197XO) {
            LocationInfo locationInformation = loggingEvent.getLocationInformation();
            this.f1196X0o0xo.append("<log4j:locationInfo class=\"");
            this.f1196X0o0xo.append(oI0IIXIo.II0xO0(locationInformation.getClassName()));
            this.f1196X0o0xo.append("\" method=\"");
            this.f1196X0o0xo.append(oI0IIXIo.II0xO0(locationInformation.getMethodName()));
            this.f1196X0o0xo.append("\" file=\"");
            this.f1196X0o0xo.append(locationInformation.getFileName());
            this.f1196X0o0xo.append("\" line=\"");
            this.f1196X0o0xo.append(locationInformation.getLineNumber());
            this.f1196X0o0xo.append("\"/>\r\n");
        }
        this.f1196X0o0xo.append("</log4j:event>\r\n\r\n");
        return this.f1196X0o0xo.toString();
    }

    public void xxIXOIIO(boolean z) {
        this.f1197XO = z;
    }

    @Override // org.apache.log4j.x0XOIxOo, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
    }
}
