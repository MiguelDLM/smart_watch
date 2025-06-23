package org.apache.log4j;

import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class oI0IIXIo extends x0XOIxOo {

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f33455xoIox = "%r [%t] %p %c %x - %m%n";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f33456xxIXOIIO = "%m%n";

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f33457I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f33458II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public org.apache.log4j.helpers.ooOOo0oXI f33459Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public StringBuffer f33460X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f33461XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f33462oxoX;

    public oI0IIXIo() {
        this(f33456xxIXOIIO);
    }

    public org.apache.log4j.helpers.x0XOIxOo II0XooXoX(String str) {
        return new org.apache.log4j.helpers.x0XOIxOo(str);
    }

    @Override // org.apache.log4j.x0XOIxOo
    public boolean Oxx0IOOO() {
        return true;
    }

    @Override // org.apache.log4j.x0XOIxOo, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
    }

    @Override // org.apache.log4j.x0XOIxOo
    public String oIX0oI(LoggingEvent loggingEvent) {
        if (this.f33460X0o0xo.capacity() > 1024) {
            this.f33460X0o0xo = new StringBuffer(256);
        } else {
            this.f33460X0o0xo.setLength(0);
        }
        for (org.apache.log4j.helpers.ooOOo0oXI ooooo0oxi = this.f33459Oxx0IOOO; ooooo0oxi != null; ooooo0oxi = ooooo0oxi.f33285oIX0oI) {
            ooooo0oxi.II0xO0(this.f33460X0o0xo, loggingEvent);
        }
        return this.f33460X0o0xo.toString();
    }

    public void xoIox(String str) {
        this.f33461XO = str;
        this.f33459Oxx0IOOO = II0XooXoX(str).Oxx0IOOO();
    }

    public String xxIXOIIO() {
        return this.f33461XO;
    }

    public oI0IIXIo(String str) {
        this.f33457I0Io = 256;
        this.f33462oxoX = 1024;
        this.f33460X0o0xo = new StringBuffer(256);
        this.f33461XO = str;
        this.f33459Oxx0IOOO = II0XooXoX(str == null ? f33456xxIXOIIO : str).Oxx0IOOO();
    }
}
