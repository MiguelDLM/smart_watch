package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public abstract class ooOOo0oXI {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static String[] f33282X0o0xo = {" ", "  ", OIII0O.OOXIXo.f1567xI, "        ", "                ", "                                "};

    /* renamed from: I0Io, reason: collision with root package name */
    public int f33283I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33284II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ooOOo0oXI f33285oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f33286oxoX;

    public ooOOo0oXI() {
        this.f33284II0xO0 = -1;
        this.f33283I0Io = Integer.MAX_VALUE;
        this.f33286oxoX = false;
    }

    public void I0Io(StringBuffer stringBuffer, int i) {
        while (i >= 32) {
            stringBuffer.append(f33282X0o0xo[5]);
            i -= 32;
        }
        for (int i2 = 4; i2 >= 0; i2--) {
            if (((1 << i2) & i) != 0) {
                stringBuffer.append(f33282X0o0xo[i2]);
            }
        }
    }

    public void II0xO0(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        String oIX0oI2 = oIX0oI(loggingEvent);
        if (oIX0oI2 == null) {
            int i = this.f33284II0xO0;
            if (i > 0) {
                I0Io(stringBuffer, i);
                return;
            }
            return;
        }
        int length = oIX0oI2.length();
        int i2 = this.f33283I0Io;
        if (length > i2) {
            stringBuffer.append(oIX0oI2.substring(length - i2));
            return;
        }
        int i3 = this.f33284II0xO0;
        if (length < i3) {
            if (this.f33286oxoX) {
                stringBuffer.append(oIX0oI2);
                I0Io(stringBuffer, this.f33284II0xO0 - length);
                return;
            } else {
                I0Io(stringBuffer, i3 - length);
                stringBuffer.append(oIX0oI2);
                return;
            }
        }
        stringBuffer.append(oIX0oI2);
    }

    public abstract String oIX0oI(LoggingEvent loggingEvent);

    public ooOOo0oXI(Oxx0IOOO oxx0IOOO) {
        this.f33284II0xO0 = -1;
        this.f33283I0Io = Integer.MAX_VALUE;
        this.f33286oxoX = false;
        this.f33284II0xO0 = oxx0IOOO.f33251oIX0oI;
        this.f33283I0Io = oxx0IOOO.f33250II0xO0;
        this.f33286oxoX = oxx0IOOO.f33249I0Io;
    }
}
