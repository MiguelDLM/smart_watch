package org.apache.log4j.spi;

/* loaded from: classes6.dex */
public abstract class XO implements OOXIXo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f33491I0Io = 0;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f33492II0xO0 = -1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f33493oxoX = 1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public XO f33494oIX0oI;

    public XO I0Io() {
        return this.f33494oIX0oI;
    }

    @Override // org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
    }

    public abstract int oIX0oI(LoggingEvent loggingEvent);

    public void oxoX(XO xo2) {
        this.f33494oIX0oI = xo2;
    }
}
