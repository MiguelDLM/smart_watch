package org.apache.log4j;

import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class OxI extends x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    public StringBuffer f33191I0Io = new StringBuffer(128);

    @Override // org.apache.log4j.x0XOIxOo
    public boolean Oxx0IOOO() {
        return true;
    }

    @Override // org.apache.log4j.x0XOIxOo, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
    }

    @Override // org.apache.log4j.x0XOIxOo
    public String oIX0oI(LoggingEvent loggingEvent) {
        this.f33191I0Io.setLength(0);
        this.f33191I0Io.append(loggingEvent.getLevel().toString());
        this.f33191I0Io.append(" - ");
        this.f33191I0Io.append(loggingEvent.getRenderedMessage());
        this.f33191I0Io.append(x0XOIxOo.f33503oIX0oI);
        return this.f33191I0Io.toString();
    }
}
