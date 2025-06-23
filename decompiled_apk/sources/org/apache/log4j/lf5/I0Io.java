package org.apache.log4j.lf5;

import java.awt.Toolkit;
import org.apache.log4j.lf5.viewer.IoOoX;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class I0Io extends org.apache.log4j.II0xO0 {

    /* renamed from: xoIox, reason: collision with root package name */
    public static oIX0oI f33338xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static IoOoX f33339xxIXOIIO;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public IoOoX f33340II0XooXoX;

    public I0Io() {
        this(XI0IXoo());
    }

    public static int IIX0o() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().width;
        } catch (Throwable unused) {
            return 800;
        }
    }

    public static synchronized IoOoX XI0IXoo() {
        IoOoX ioOoX;
        synchronized (I0Io.class) {
            if (f33339xxIXOIIO == null) {
                try {
                    IoOoX ioOoX2 = new IoOoX(LogLevel.getLog4JLevels());
                    f33339xxIXOIIO = ioOoX2;
                    f33338xoIox = new oIX0oI(ioOoX2);
                    f33339xxIXOIIO.XIXIX(xxX(), XIxXXX0x0());
                    f33339xxIXOIIO.OX00O0xII(12);
                    f33339xxIXOIIO.xI0oxI00();
                } catch (SecurityException unused) {
                    f33339xxIXOIIO = null;
                }
            }
            ioOoX = f33339xxIXOIIO;
        }
        return ioOoX;
    }

    public static int XIxXXX0x0() {
        return (xXxxox0I() * 3) / 4;
    }

    public static void ooXIXxIX(String[] strArr) {
        new I0Io();
    }

    public static int xXxxox0I() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().height;
        } catch (Throwable unused) {
            return 600;
        }
    }

    public static int xxX() {
        return (IIX0o() * 3) / 4;
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        String loggerName = loggingEvent.getLoggerName();
        String renderedMessage = loggingEvent.getRenderedMessage();
        String ndc = loggingEvent.getNDC();
        String threadName = loggingEvent.getThreadName();
        String oxxIIOOXO = loggingEvent.getLevel().toString();
        long j = loggingEvent.timeStamp;
        LocationInfo locationInformation = loggingEvent.getLocationInformation();
        Log4JLogRecord log4JLogRecord = new Log4JLogRecord();
        log4JLogRecord.setCategory(loggerName);
        log4JLogRecord.setMessage(renderedMessage);
        log4JLogRecord.setLocation(locationInformation.fullInfo);
        log4JLogRecord.setMillis(j);
        log4JLogRecord.setThreadDescription(threadName);
        if (ndc != null) {
            log4JLogRecord.setNDC(ndc);
        } else {
            log4JLogRecord.setNDC("");
        }
        if (loggingEvent.getThrowableInformation() != null) {
            log4JLogRecord.setThrownStackTrace(loggingEvent.getThrowableInformation());
        }
        try {
            log4JLogRecord.setLevel(LogLevel.valueOf(oxxIIOOXO));
        } catch (LogLevelFormatException unused) {
            log4JLogRecord.setLevel(LogLevel.WARN);
        }
        IoOoX ioOoX = this.f33340II0XooXoX;
        if (ioOoX != null) {
            ioOoX.II0xO0(log4JLogRecord);
        }
    }

    public boolean X0IIOO(I0Io i0Io) {
        if (this.f33340II0XooXoX == i0Io.XxX0x0xxx()) {
            return true;
        }
        return false;
    }

    public IoOoX XxX0x0xxx() {
        return this.f33340II0XooXoX;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public void close() {
    }

    public void oo0xXOI0I(int i) {
        f33339xxIXOIIO.oOo(i);
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return false;
    }

    public void xI(boolean z) {
        this.f33340II0XooXoX.ooOx(z);
    }

    public I0Io(IoOoX ioOoX) {
        if (ioOoX != null) {
            this.f33340II0XooXoX = ioOoX;
        }
    }
}
