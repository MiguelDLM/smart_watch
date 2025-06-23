package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class OOXIXo implements org.apache.log4j.spi.X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f33248oIX0oI = "log4j warning: ";

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f33247II0xO0 = "log4j error: ";

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f33246I0Io = true;

    @Override // org.apache.log4j.spi.X0o0xo
    public void II0xO0(org.apache.log4j.x0xO0oo x0xo0oo) {
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void IXxxXO(String str, Exception exc, int i, LoggingEvent loggingEvent) {
        if (this.f33246I0Io) {
            xxIXOIIO.oxoX(str, exc);
            this.f33246I0Io = false;
        }
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void Oo(org.apache.log4j.oIX0oI oix0oi) {
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void OxxIIOOXO(String str, Exception exc, int i) {
        IXxxXO(str, exc, i, null);
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void XO(org.apache.log4j.oIX0oI oix0oi) {
    }

    @Override // org.apache.log4j.spi.X0o0xo
    public void error(String str) {
        if (this.f33246I0Io) {
            xxIXOIIO.I0Io(str);
            this.f33246I0Io = false;
        }
    }

    @Override // org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
    }
}
