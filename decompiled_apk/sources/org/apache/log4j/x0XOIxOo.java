package org.apache.log4j;

import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public abstract class x0XOIxOo implements org.apache.log4j.spi.OOXIXo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f33502II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33503oIX0oI;

    static {
        String property = System.getProperty("line.separator");
        f33503oIX0oI = property;
        f33502II0xO0 = property.length();
    }

    public String I0Io() {
        return "text/plain";
    }

    public abstract boolean Oxx0IOOO();

    public String X0o0xo() {
        return null;
    }

    @Override // org.apache.log4j.spi.OOXIXo
    public abstract void oI0IIXIo();

    public abstract String oIX0oI(LoggingEvent loggingEvent);

    public String oxoX() {
        return null;
    }
}
