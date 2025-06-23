package org.apache.log4j;

import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public abstract class II0xO0 implements oIX0oI, org.apache.log4j.spi.OOXIXo {

    /* renamed from: I0Io, reason: collision with root package name */
    public OxxIIOOXO f33156I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f33157II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public org.apache.log4j.spi.XO f33159X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public org.apache.log4j.spi.XO f33160XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public x0XOIxOo f33161oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public org.apache.log4j.spi.X0o0xo f33162oxoX = new org.apache.log4j.helpers.OOXIXo();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f33158Oxx0IOOO = false;

    @Override // org.apache.log4j.oIX0oI
    public synchronized void I0Io(org.apache.log4j.spi.X0o0xo x0o0xo) {
        try {
            if (x0o0xo == null) {
                org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("You have tried to set a null error-handler.");
            } else {
                this.f33162oxoX = x0o0xo;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract void IIXOooo(LoggingEvent loggingEvent);

    public void O0xOxO(OxxIIOOXO oxxIIOOXO) {
        this.f33156I0Io = oxxIIOOXO;
    }

    public boolean OxI(OxxIIOOXO oxxIIOOXO) {
        OxxIIOOXO oxxIIOOXO2 = this.f33156I0Io;
        if (oxxIIOOXO2 != null && !oxxIIOOXO.isGreaterOrEqual(oxxIIOOXO2)) {
            return false;
        }
        return true;
    }

    @Override // org.apache.log4j.oIX0oI
    public x0XOIxOo Oxx0xo() {
        return this.f33161oIX0oI;
    }

    @Override // org.apache.log4j.oIX0oI
    public abstract void close();

    public void finalize() {
        if (this.f33158Oxx0IOOO) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Finalizing appender named [");
        stringBuffer.append(this.f33157II0xO0);
        stringBuffer.append("].");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        close();
    }

    @Override // org.apache.log4j.oIX0oI
    public org.apache.log4j.spi.XO getFilter() {
        return this.f33159X0o0xo;
    }

    @Override // org.apache.log4j.oIX0oI
    public final String getName() {
        return this.f33157II0xO0;
    }

    public OxxIIOOXO o00() {
        return this.f33156I0Io;
    }

    public void oI0IIXIo() {
    }

    @Override // org.apache.log4j.oIX0oI
    public abstract boolean ooOOo0oXI();

    @Override // org.apache.log4j.oIX0oI
    public void oxoX(x0XOIxOo x0xoixoo) {
        this.f33161oIX0oI = x0xoixoo;
    }

    @Override // org.apache.log4j.oIX0oI
    public void setName(String str) {
        this.f33157II0xO0 = str;
    }

    @Override // org.apache.log4j.oIX0oI
    public void x0XOIxOo(org.apache.log4j.spi.XO xo2) {
        if (this.f33159X0o0xo == null) {
            this.f33160XO = xo2;
            this.f33159X0o0xo = xo2;
        } else {
            this.f33160XO.f33494oIX0oI = xo2;
            this.f33160XO = xo2;
        }
    }

    @Override // org.apache.log4j.oIX0oI
    public void x0xO0oo() {
        this.f33160XO = null;
        this.f33159X0o0xo = null;
    }

    @Override // org.apache.log4j.oIX0oI
    public org.apache.log4j.spi.X0o0xo xoIox() {
        return this.f33162oxoX;
    }

    public final org.apache.log4j.spi.XO xoXoI() {
        return this.f33159X0o0xo;
    }

    @Override // org.apache.log4j.oIX0oI
    public synchronized void xxIXOIIO(LoggingEvent loggingEvent) {
        if (this.f33158Oxx0IOOO) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attempted to append to closed appender named [");
            stringBuffer.append(this.f33157II0xO0);
            stringBuffer.append("].");
            org.apache.log4j.helpers.xxIXOIIO.I0Io(stringBuffer.toString());
            return;
        }
        if (!OxI(loggingEvent.getLevel())) {
            return;
        }
        org.apache.log4j.spi.XO xo2 = this.f33159X0o0xo;
        while (xo2 != null) {
            int oIX0oI2 = xo2.oIX0oI(loggingEvent);
            if (oIX0oI2 != -1) {
                if (oIX0oI2 != 0) {
                    if (oIX0oI2 == 1) {
                        break;
                    }
                } else {
                    xo2 = xo2.f33494oIX0oI;
                }
            } else {
                return;
            }
        }
        IIXOooo(loggingEvent);
    }
}
