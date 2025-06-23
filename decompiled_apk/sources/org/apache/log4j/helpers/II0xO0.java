package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f33238X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public LoggingEvent[] f33239oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33237II0xO0 = 0;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f33236I0Io = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f33240oxoX = 0;

    public II0xO0(int i) {
        if (i >= 1) {
            this.f33238X0o0xo = i;
            this.f33239oIX0oI = new LoggingEvent[i];
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The maxSize argument (");
            stringBuffer.append(i);
            stringBuffer.append(") is not a positive integer.");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public boolean I0Io() {
        if (this.f33237II0xO0 == this.f33238X0o0xo) {
            return true;
        }
        return false;
    }

    public boolean II0XooXoX() {
        if (this.f33237II0xO0 == 1) {
            return true;
        }
        return false;
    }

    public int II0xO0() {
        return this.f33238X0o0xo;
    }

    public synchronized void Oxx0IOOO(int i) {
        int i2;
        try {
            int i3 = this.f33238X0o0xo;
            if (i == i3) {
                return;
            }
            LoggingEvent[] loggingEventArr = new LoggingEvent[i];
            int X0o0xo2 = X0o0xo(X0o0xo(i3 - this.f33236I0Io, i), this.f33237II0xO0);
            System.arraycopy(this.f33239oIX0oI, this.f33236I0Io, loggingEventArr, 0, X0o0xo2);
            int i4 = this.f33237II0xO0;
            if (X0o0xo2 < i4 && X0o0xo2 < i) {
                i2 = X0o0xo(i4 - X0o0xo2, i - X0o0xo2);
                System.arraycopy(this.f33239oIX0oI, 0, loggingEventArr, X0o0xo2, i2);
            } else {
                i2 = 0;
            }
            this.f33239oIX0oI = loggingEventArr;
            this.f33238X0o0xo = i;
            this.f33236I0Io = 0;
            int i5 = X0o0xo2 + i2;
            this.f33237II0xO0 = i5;
            this.f33240oxoX = i5;
            if (i5 == i) {
                this.f33240oxoX = 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int X0o0xo(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public void XO(LoggingEvent loggingEvent) {
        int i = this.f33237II0xO0;
        int i2 = this.f33238X0o0xo;
        if (i != i2) {
            LoggingEvent[] loggingEventArr = this.f33239oIX0oI;
            int i3 = this.f33240oxoX;
            loggingEventArr[i3] = loggingEvent;
            int i4 = i3 + 1;
            this.f33240oxoX = i4;
            if (i4 == i2) {
                this.f33240oxoX = 0;
            }
            this.f33237II0xO0 = i + 1;
        }
    }

    public LoggingEvent oIX0oI() {
        int i = this.f33237II0xO0;
        if (i == 0) {
            return null;
        }
        LoggingEvent[] loggingEventArr = this.f33239oIX0oI;
        int i2 = this.f33236I0Io;
        LoggingEvent loggingEvent = loggingEventArr[i2];
        loggingEventArr[i2] = null;
        int i3 = i2 + 1;
        this.f33236I0Io = i3;
        if (i3 == this.f33238X0o0xo) {
            this.f33236I0Io = 0;
        }
        this.f33237II0xO0 = i - 1;
        return loggingEvent;
    }

    public int oxoX() {
        return this.f33237II0xO0;
    }

    public boolean xxIXOIIO() {
        if (this.f33237II0xO0 + 1 == this.f33238X0o0xo) {
            return true;
        }
        return false;
    }
}
