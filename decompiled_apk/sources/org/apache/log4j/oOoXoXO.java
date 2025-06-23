package org.apache.log4j;

import fi.iki.elonen.NanoHTTPD;
import java.util.Date;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class oOoXoXO extends x0XOIxOo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static String f33470II0XooXoX = "<br>&nbsp;&nbsp;&nbsp;&nbsp;";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f33471xoIox = "Title";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f33472xxIXOIIO = "LocationInfo";

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f33473I0Io = 256;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f33477oxoX = 1024;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public StringBuffer f33475X0o0xo = new StringBuffer(256);

    /* renamed from: XO, reason: collision with root package name */
    public boolean f33476XO = false;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f33474Oxx0IOOO = "Log4J Log Messages";

    @Override // org.apache.log4j.x0XOIxOo
    public String I0Io() {
        return NanoHTTPD.MIME_HTML;
    }

    public void II0XooXoX(String[] strArr, StringBuffer stringBuffer) {
        int length;
        if (strArr == null || (length = strArr.length) == 0) {
            return;
        }
        stringBuffer.append(org.apache.log4j.helpers.oI0IIXIo.II0xO0(strArr[0]));
        stringBuffer.append(x0XOIxOo.f33503oIX0oI);
        for (int i = 1; i < length; i++) {
            stringBuffer.append(f33470II0XooXoX);
            stringBuffer.append(org.apache.log4j.helpers.oI0IIXIo.II0xO0(strArr[i]));
            stringBuffer.append(x0XOIxOo.f33503oIX0oI);
        }
    }

    public void OOXIXo(boolean z) {
        this.f33476XO = z;
    }

    @Override // org.apache.log4j.x0XOIxOo
    public boolean Oxx0IOOO() {
        return false;
    }

    @Override // org.apache.log4j.x0XOIxOo
    public String X0o0xo() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        String str = x0XOIxOo.f33503oIX0oI;
        stringBuffer2.append(str);
        stringBuffer.append(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("<html>");
        stringBuffer3.append(str);
        stringBuffer.append(stringBuffer3.toString());
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("<head>");
        stringBuffer4.append(str);
        stringBuffer.append(stringBuffer4.toString());
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("<title>");
        stringBuffer5.append(this.f33474Oxx0IOOO);
        stringBuffer5.append("</title>");
        stringBuffer5.append(str);
        stringBuffer.append(stringBuffer5.toString());
        StringBuffer stringBuffer6 = new StringBuffer();
        stringBuffer6.append("<style type=\"text/css\">");
        stringBuffer6.append(str);
        stringBuffer.append(stringBuffer6.toString());
        StringBuffer stringBuffer7 = new StringBuffer();
        stringBuffer7.append("<!--");
        stringBuffer7.append(str);
        stringBuffer.append(stringBuffer7.toString());
        StringBuffer stringBuffer8 = new StringBuffer();
        stringBuffer8.append("body, table {font-family: arial,sans-serif; font-size: x-small;}");
        stringBuffer8.append(str);
        stringBuffer.append(stringBuffer8.toString());
        StringBuffer stringBuffer9 = new StringBuffer();
        stringBuffer9.append("th {background: #336699; color: #FFFFFF; text-align: left;}");
        stringBuffer9.append(str);
        stringBuffer.append(stringBuffer9.toString());
        StringBuffer stringBuffer10 = new StringBuffer();
        stringBuffer10.append("-->");
        stringBuffer10.append(str);
        stringBuffer.append(stringBuffer10.toString());
        StringBuffer stringBuffer11 = new StringBuffer();
        stringBuffer11.append("</style>");
        stringBuffer11.append(str);
        stringBuffer.append(stringBuffer11.toString());
        StringBuffer stringBuffer12 = new StringBuffer();
        stringBuffer12.append("</head>");
        stringBuffer12.append(str);
        stringBuffer.append(stringBuffer12.toString());
        StringBuffer stringBuffer13 = new StringBuffer();
        stringBuffer13.append("<body bgcolor=\"#FFFFFF\" topmargin=\"6\" leftmargin=\"6\">");
        stringBuffer13.append(str);
        stringBuffer.append(stringBuffer13.toString());
        StringBuffer stringBuffer14 = new StringBuffer();
        stringBuffer14.append("<hr size=\"1\" noshade>");
        stringBuffer14.append(str);
        stringBuffer.append(stringBuffer14.toString());
        StringBuffer stringBuffer15 = new StringBuffer();
        stringBuffer15.append("Log session start time ");
        stringBuffer15.append(new Date());
        stringBuffer15.append("<br>");
        stringBuffer15.append(str);
        stringBuffer.append(stringBuffer15.toString());
        StringBuffer stringBuffer16 = new StringBuffer();
        stringBuffer16.append("<br>");
        stringBuffer16.append(str);
        stringBuffer.append(stringBuffer16.toString());
        StringBuffer stringBuffer17 = new StringBuffer();
        stringBuffer17.append("<table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" bordercolor=\"#224466\" width=\"100%\">");
        stringBuffer17.append(str);
        stringBuffer.append(stringBuffer17.toString());
        StringBuffer stringBuffer18 = new StringBuffer();
        stringBuffer18.append("<tr>");
        stringBuffer18.append(str);
        stringBuffer.append(stringBuffer18.toString());
        StringBuffer stringBuffer19 = new StringBuffer();
        stringBuffer19.append("<th>Time</th>");
        stringBuffer19.append(str);
        stringBuffer.append(stringBuffer19.toString());
        StringBuffer stringBuffer20 = new StringBuffer();
        stringBuffer20.append("<th>Thread</th>");
        stringBuffer20.append(str);
        stringBuffer.append(stringBuffer20.toString());
        StringBuffer stringBuffer21 = new StringBuffer();
        stringBuffer21.append("<th>Level</th>");
        stringBuffer21.append(str);
        stringBuffer.append(stringBuffer21.toString());
        StringBuffer stringBuffer22 = new StringBuffer();
        stringBuffer22.append("<th>Category</th>");
        stringBuffer22.append(str);
        stringBuffer.append(stringBuffer22.toString());
        if (this.f33476XO) {
            StringBuffer stringBuffer23 = new StringBuffer();
            stringBuffer23.append("<th>File:Line</th>");
            stringBuffer23.append(str);
            stringBuffer.append(stringBuffer23.toString());
        }
        StringBuffer stringBuffer24 = new StringBuffer();
        stringBuffer24.append("<th>Message</th>");
        stringBuffer24.append(str);
        stringBuffer.append(stringBuffer24.toString());
        StringBuffer stringBuffer25 = new StringBuffer();
        stringBuffer25.append("</tr>");
        stringBuffer25.append(str);
        stringBuffer.append(stringBuffer25.toString());
        return stringBuffer.toString();
    }

    @Override // org.apache.log4j.x0XOIxOo, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
    }

    @Override // org.apache.log4j.x0XOIxOo
    public String oIX0oI(LoggingEvent loggingEvent) {
        if (this.f33475X0o0xo.capacity() > 1024) {
            this.f33475X0o0xo = new StringBuffer(256);
        } else {
            this.f33475X0o0xo.setLength(0);
        }
        StringBuffer stringBuffer = this.f33475X0o0xo;
        StringBuffer stringBuffer2 = new StringBuffer();
        String str = x0XOIxOo.f33503oIX0oI;
        stringBuffer2.append(str);
        stringBuffer2.append("<tr>");
        stringBuffer2.append(str);
        stringBuffer.append(stringBuffer2.toString());
        this.f33475X0o0xo.append("<td>");
        this.f33475X0o0xo.append(loggingEvent.timeStamp - LoggingEvent.getStartTime());
        StringBuffer stringBuffer3 = this.f33475X0o0xo;
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("</td>");
        stringBuffer4.append(str);
        stringBuffer3.append(stringBuffer4.toString());
        StringBuffer stringBuffer5 = this.f33475X0o0xo;
        StringBuffer stringBuffer6 = new StringBuffer();
        stringBuffer6.append("<td title=\"");
        stringBuffer6.append(loggingEvent.getThreadName());
        stringBuffer6.append(" thread\">");
        stringBuffer5.append(stringBuffer6.toString());
        this.f33475X0o0xo.append(org.apache.log4j.helpers.oI0IIXIo.II0xO0(loggingEvent.getThreadName()));
        StringBuffer stringBuffer7 = this.f33475X0o0xo;
        StringBuffer stringBuffer8 = new StringBuffer();
        stringBuffer8.append("</td>");
        stringBuffer8.append(str);
        stringBuffer7.append(stringBuffer8.toString());
        this.f33475X0o0xo.append("<td title=\"Level\">");
        if (loggingEvent.getLevel().equals(Level.DEBUG)) {
            this.f33475X0o0xo.append("<font color=\"#339933\">");
            this.f33475X0o0xo.append(loggingEvent.getLevel());
            this.f33475X0o0xo.append("</font>");
        } else if (loggingEvent.getLevel().isGreaterOrEqual(Level.WARN)) {
            this.f33475X0o0xo.append("<font color=\"#993300\"><strong>");
            this.f33475X0o0xo.append(loggingEvent.getLevel());
            this.f33475X0o0xo.append("</strong></font>");
        } else {
            this.f33475X0o0xo.append(loggingEvent.getLevel());
        }
        StringBuffer stringBuffer9 = this.f33475X0o0xo;
        StringBuffer stringBuffer10 = new StringBuffer();
        stringBuffer10.append("</td>");
        stringBuffer10.append(str);
        stringBuffer9.append(stringBuffer10.toString());
        StringBuffer stringBuffer11 = this.f33475X0o0xo;
        StringBuffer stringBuffer12 = new StringBuffer();
        stringBuffer12.append("<td title=\"");
        stringBuffer12.append(loggingEvent.getLoggerName());
        stringBuffer12.append(" category\">");
        stringBuffer11.append(stringBuffer12.toString());
        this.f33475X0o0xo.append(org.apache.log4j.helpers.oI0IIXIo.II0xO0(loggingEvent.getLoggerName()));
        StringBuffer stringBuffer13 = this.f33475X0o0xo;
        StringBuffer stringBuffer14 = new StringBuffer();
        stringBuffer14.append("</td>");
        stringBuffer14.append(str);
        stringBuffer13.append(stringBuffer14.toString());
        if (this.f33476XO) {
            LocationInfo locationInformation = loggingEvent.getLocationInformation();
            this.f33475X0o0xo.append("<td>");
            this.f33475X0o0xo.append(org.apache.log4j.helpers.oI0IIXIo.II0xO0(locationInformation.getFileName()));
            this.f33475X0o0xo.append(':');
            this.f33475X0o0xo.append(locationInformation.getLineNumber());
            StringBuffer stringBuffer15 = this.f33475X0o0xo;
            StringBuffer stringBuffer16 = new StringBuffer();
            stringBuffer16.append("</td>");
            stringBuffer16.append(str);
            stringBuffer15.append(stringBuffer16.toString());
        }
        this.f33475X0o0xo.append("<td title=\"Message\">");
        this.f33475X0o0xo.append(org.apache.log4j.helpers.oI0IIXIo.II0xO0(loggingEvent.getRenderedMessage()));
        StringBuffer stringBuffer17 = this.f33475X0o0xo;
        StringBuffer stringBuffer18 = new StringBuffer();
        stringBuffer18.append("</td>");
        stringBuffer18.append(str);
        stringBuffer17.append(stringBuffer18.toString());
        StringBuffer stringBuffer19 = this.f33475X0o0xo;
        StringBuffer stringBuffer20 = new StringBuffer();
        stringBuffer20.append("</tr>");
        stringBuffer20.append(str);
        stringBuffer19.append(stringBuffer20.toString());
        if (loggingEvent.getNDC() != null) {
            this.f33475X0o0xo.append("<tr><td bgcolor=\"#EEEEEE\" style=\"font-size : xx-small;\" colspan=\"6\" title=\"Nested Diagnostic Context\">");
            StringBuffer stringBuffer21 = this.f33475X0o0xo;
            StringBuffer stringBuffer22 = new StringBuffer();
            stringBuffer22.append("NDC: ");
            stringBuffer22.append(org.apache.log4j.helpers.oI0IIXIo.II0xO0(loggingEvent.getNDC()));
            stringBuffer21.append(stringBuffer22.toString());
            StringBuffer stringBuffer23 = this.f33475X0o0xo;
            StringBuffer stringBuffer24 = new StringBuffer();
            stringBuffer24.append("</td></tr>");
            stringBuffer24.append(str);
            stringBuffer23.append(stringBuffer24.toString());
        }
        String[] throwableStrRep = loggingEvent.getThrowableStrRep();
        if (throwableStrRep != null) {
            this.f33475X0o0xo.append("<tr><td bgcolor=\"#993300\" style=\"color:White; font-size : xx-small;\" colspan=\"6\">");
            II0XooXoX(throwableStrRep, this.f33475X0o0xo);
            StringBuffer stringBuffer25 = this.f33475X0o0xo;
            StringBuffer stringBuffer26 = new StringBuffer();
            stringBuffer26.append("</td></tr>");
            stringBuffer26.append(str);
            stringBuffer25.append(stringBuffer26.toString());
        }
        return this.f33475X0o0xo.toString();
    }

    public void oOoXoXO(String str) {
        this.f33474Oxx0IOOO = str;
    }

    @Override // org.apache.log4j.x0XOIxOo
    public String oxoX() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("</table>");
        String str = x0XOIxOo.f33503oIX0oI;
        stringBuffer2.append(str);
        stringBuffer.append(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("<br>");
        stringBuffer3.append(str);
        stringBuffer.append(stringBuffer3.toString());
        stringBuffer.append("</body></html>");
        return stringBuffer.toString();
    }

    public String xoIox() {
        return this.f33474Oxx0IOOO;
    }

    public boolean xxIXOIIO() {
        return this.f33476XO;
    }
}
