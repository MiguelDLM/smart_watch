package oIX0o;

import org.apache.log4j.Level;
import org.apache.log4j.helpers.oOoXoXO;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class XO extends org.apache.log4j.spi.XO {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f31635X0o0xo = true;

    /* renamed from: XO, reason: collision with root package name */
    public Level f31636XO;

    public void II0XooXoX(boolean z) {
        this.f31635X0o0xo = z;
    }

    public String Oxx0IOOO() {
        Level level = this.f31636XO;
        if (level == null) {
            return null;
        }
        return level.toString();
    }

    public boolean X0o0xo() {
        return this.f31635X0o0xo;
    }

    @Override // org.apache.log4j.spi.XO
    public int oIX0oI(LoggingEvent loggingEvent) {
        Level level = this.f31636XO;
        if (level == null || !level.equals(loggingEvent.getLevel())) {
            return 0;
        }
        if (this.f31635X0o0xo) {
            return 1;
        }
        return -1;
    }

    public void xxIXOIIO(String str) {
        this.f31636XO = oOoXoXO.ooOOo0oXI(str, null);
    }
}
