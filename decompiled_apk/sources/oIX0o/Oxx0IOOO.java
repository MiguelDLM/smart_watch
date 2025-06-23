package oIX0o;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class Oxx0IOOO extends org.apache.log4j.spi.XO {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Level f31628Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f31629X0o0xo = false;

    /* renamed from: XO, reason: collision with root package name */
    public Level f31630XO;

    public Level II0XooXoX() {
        return this.f31630XO;
    }

    public void OOXIXo(Level level) {
        this.f31630XO = level;
    }

    public Level Oxx0IOOO() {
        return this.f31628Oxx0IOOO;
    }

    public boolean X0o0xo() {
        return this.f31629X0o0xo;
    }

    @Override // org.apache.log4j.spi.XO
    public int oIX0oI(LoggingEvent loggingEvent) {
        if (this.f31630XO != null && !loggingEvent.getLevel().isGreaterOrEqual(this.f31630XO)) {
            return -1;
        }
        if (this.f31628Oxx0IOOO != null && loggingEvent.getLevel().toInt() > this.f31628Oxx0IOOO.toInt()) {
            return -1;
        }
        if (this.f31629X0o0xo) {
            return 1;
        }
        return 0;
    }

    public void xoIox(Level level) {
        this.f31628Oxx0IOOO = level;
    }

    public void xxIXOIIO(boolean z) {
        this.f31629X0o0xo = z;
    }
}
