package OIII0O;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.x0xO0oo;

/* loaded from: classes6.dex */
public class oIX0oI implements x0xO0oo {
    @Override // org.apache.log4j.spi.x0xO0oo
    public boolean oIX0oI(LoggingEvent loggingEvent) {
        return loggingEvent.getLevel().isGreaterOrEqual(Level.ERROR);
    }
}
