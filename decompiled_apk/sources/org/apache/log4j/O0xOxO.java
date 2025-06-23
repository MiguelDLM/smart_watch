package org.apache.log4j;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class O0xOxO extends org.apache.log4j.helpers.X0o0xo {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f33184oOoXoXO = true;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f33185ooOOo0oXI = true;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f33186x0XOIxOo = true;

    /* renamed from: oO, reason: collision with root package name */
    public final StringBuffer f33183oO = new StringBuffer(256);

    public O0xOxO() {
        ooOOo0oXI(org.apache.log4j.helpers.X0o0xo.f33255xxIXOIIO, null);
    }

    public boolean IIXOooo() {
        return this.f33186x0XOIxOo;
    }

    public void O0xOxO(boolean z) {
        this.f33184oOoXoXO = z;
    }

    public void OxI(boolean z) {
        this.f33186x0XOIxOo = z;
    }

    @Override // org.apache.log4j.x0XOIxOo
    public boolean Oxx0IOOO() {
        return true;
    }

    public boolean Oxx0xo() {
        return this.f33185ooOOo0oXI;
    }

    public void o00(boolean z) {
        this.f33185ooOOo0oXI = z;
    }

    @Override // org.apache.log4j.x0XOIxOo
    public String oIX0oI(LoggingEvent loggingEvent) {
        String ndc;
        this.f33183oO.setLength(0);
        II0XooXoX(this.f33183oO, loggingEvent);
        if (this.f33184oOoXoXO) {
            this.f33183oO.append('[');
            this.f33183oO.append(loggingEvent.getThreadName());
            this.f33183oO.append("] ");
        }
        this.f33183oO.append(loggingEvent.getLevel().toString());
        this.f33183oO.append(TokenParser.SP);
        if (this.f33185ooOOo0oXI) {
            this.f33183oO.append(loggingEvent.getLoggerName());
            this.f33183oO.append(TokenParser.SP);
        }
        if (this.f33186x0XOIxOo && (ndc = loggingEvent.getNDC()) != null) {
            this.f33183oO.append(ndc);
            this.f33183oO.append(TokenParser.SP);
        }
        this.f33183oO.append("- ");
        this.f33183oO.append(loggingEvent.getRenderedMessage());
        this.f33183oO.append(x0XOIxOo.f33503oIX0oI);
        return this.f33183oO.toString();
    }

    public boolean xoXoI() {
        return this.f33184oOoXoXO;
    }

    public O0xOxO(String str) {
        oOoXoXO(str);
    }
}
