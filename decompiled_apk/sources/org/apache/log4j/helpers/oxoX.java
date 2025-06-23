package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f33287I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33288II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f33289X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public LoggingEvent[] f33290oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f33291oxoX;

    public oxoX(int i) throws IllegalArgumentException {
        if (i >= 1) {
            this.f33289X0o0xo = i;
            this.f33290oIX0oI = new LoggingEvent[i];
            this.f33288II0xO0 = 0;
            this.f33287I0Io = 0;
            this.f33291oxoX = 0;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The maxSize argument (");
        stringBuffer.append(i);
        stringBuffer.append(") is not a positive integer.");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public LoggingEvent I0Io(int i) {
        if (i >= 0 && i < this.f33291oxoX) {
            return this.f33290oIX0oI[(this.f33288II0xO0 + i) % this.f33289X0o0xo];
        }
        return null;
    }

    public LoggingEvent II0xO0() {
        int i = this.f33291oxoX;
        if (i <= 0) {
            return null;
        }
        this.f33291oxoX = i - 1;
        LoggingEvent[] loggingEventArr = this.f33290oIX0oI;
        int i2 = this.f33288II0xO0;
        LoggingEvent loggingEvent = loggingEventArr[i2];
        loggingEventArr[i2] = null;
        int i3 = i2 + 1;
        this.f33288II0xO0 = i3;
        if (i3 == this.f33289X0o0xo) {
            this.f33288II0xO0 = 0;
        }
        return loggingEvent;
    }

    public int X0o0xo() {
        return this.f33291oxoX;
    }

    public void XO(int i) {
        if (i >= 0) {
            int i2 = this.f33291oxoX;
            if (i == i2) {
                return;
            }
            LoggingEvent[] loggingEventArr = new LoggingEvent[i];
            if (i < i2) {
                i2 = i;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                LoggingEvent[] loggingEventArr2 = this.f33290oIX0oI;
                int i4 = this.f33288II0xO0;
                loggingEventArr[i3] = loggingEventArr2[i4];
                loggingEventArr2[i4] = null;
                int i5 = i4 + 1;
                this.f33288II0xO0 = i5;
                if (i5 == this.f33291oxoX) {
                    this.f33288II0xO0 = 0;
                }
            }
            this.f33290oIX0oI = loggingEventArr;
            this.f33288II0xO0 = 0;
            this.f33291oxoX = i2;
            this.f33289X0o0xo = i;
            if (i2 == i) {
                this.f33287I0Io = 0;
                return;
            } else {
                this.f33287I0Io = i2;
                return;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Negative array size [");
        stringBuffer.append(i);
        stringBuffer.append("] not allowed.");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public void oIX0oI(LoggingEvent loggingEvent) {
        LoggingEvent[] loggingEventArr = this.f33290oIX0oI;
        int i = this.f33287I0Io;
        loggingEventArr[i] = loggingEvent;
        int i2 = i + 1;
        this.f33287I0Io = i2;
        int i3 = this.f33289X0o0xo;
        if (i2 == i3) {
            this.f33287I0Io = 0;
        }
        int i4 = this.f33291oxoX;
        if (i4 < i3) {
            this.f33291oxoX = i4 + 1;
            return;
        }
        int i5 = this.f33288II0xO0 + 1;
        this.f33288II0xO0 = i5;
        if (i5 == i3) {
            this.f33288II0xO0 = 0;
        }
    }

    public int oxoX() {
        return this.f33289X0o0xo;
    }
}
