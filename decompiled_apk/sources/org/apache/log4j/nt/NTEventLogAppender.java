package org.apache.log4j.nt;

import org.apache.log4j.II0xO0;
import org.apache.log4j.Level;
import org.apache.log4j.O0xOxO;
import org.apache.log4j.helpers.xxIXOIIO;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.x0XOIxOo;

/* loaded from: classes6.dex */
public class NTEventLogAppender extends II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f33450II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public String f33451xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f33452xxIXOIIO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f33445OOXIXo = Level.FATAL.toInt();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f33447oOoXoXO = Level.ERROR.toInt();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f33448ooOOo0oXI = Level.WARN.toInt();

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f33449x0XOIxOo = Level.INFO.toInt();

    /* renamed from: oO, reason: collision with root package name */
    public static final int f33446oO = Level.DEBUG.toInt();

    static {
        System.loadLibrary("NTEventLogAppender");
    }

    public NTEventLogAppender() {
        this(null, null, null);
    }

    private native void deregisterEventSource(int i);

    private native int registerEventSource(String str, String str2);

    private native void reportEvent(int i, String str, int i2);

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        String[] throwableStrRep;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f33161oIX0oI.oIX0oI(loggingEvent));
        if (this.f33161oIX0oI.Oxx0IOOO() && (throwableStrRep = loggingEvent.getThrowableStrRep()) != null) {
            for (String str : throwableStrRep) {
                stringBuffer.append(str);
            }
        }
        reportEvent(this.f33450II0XooXoX, stringBuffer.toString(), loggingEvent.getLevel().toInt());
    }

    public String X0IIOO() {
        return this.f33452xxIXOIIO;
    }

    public void XI0IXoo(String str) {
        this.f33452xxIXOIIO = str.trim();
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public void close() {
    }

    @Override // org.apache.log4j.II0xO0
    public void finalize() {
        deregisterEventSource(this.f33450II0XooXoX);
        this.f33450II0XooXoX = 0;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        String str = this.f33452xxIXOIIO;
        if (str != null) {
            try {
                this.f33450II0XooXoX = registerEventSource(this.f33451xoIox, str);
            } catch (Exception e) {
                xxIXOIIO.oxoX("Could not register event source.", e);
                this.f33450II0XooXoX = 0;
            }
        }
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return true;
    }

    public NTEventLogAppender(String str) {
        this(null, str, null);
    }

    public NTEventLogAppender(String str, String str2) {
        this(str, str2, null);
    }

    public NTEventLogAppender(x0XOIxOo x0xoixoo) {
        this(null, null, x0xoixoo);
    }

    public NTEventLogAppender(String str, x0XOIxOo x0xoixoo) {
        this(null, str, x0xoixoo);
    }

    public NTEventLogAppender(String str, String str2, x0XOIxOo x0xoixoo) {
        this.f33450II0XooXoX = 0;
        this.f33452xxIXOIIO = null;
        this.f33451xoIox = null;
        str2 = str2 == null ? "Log4j" : str2;
        if (x0xoixoo == null) {
            this.f33161oIX0oI = new O0xOxO();
        } else {
            this.f33161oIX0oI = x0xoixoo;
        }
        try {
            this.f33450II0XooXoX = registerEventSource(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            this.f33450II0XooXoX = 0;
        }
    }
}
