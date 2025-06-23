package OX00o0X;

import org.apache.log4j.OxxIIOOXO;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class xoIox {

    /* renamed from: I0Io, reason: collision with root package name */
    public final String f1972I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final String f1973II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final OxxIIOOXO f1974II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final String[] f1975Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final String f1976X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final String f1977XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final long f1978oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final String f1979oxoX;

    public xoIox(long j, OxxIIOOXO oxxIIOOXO, String str, String str2, String str3, String str4, String[] strArr, String str5) {
        this.f1978oIX0oI = j;
        this.f1974II0xO0 = oxxIIOOXO;
        this.f1972I0Io = str;
        this.f1979oxoX = str2;
        this.f1976X0o0xo = str3;
        this.f1977XO = str4;
        this.f1975Oxx0IOOO = strArr;
        this.f1973II0XooXoX = str5;
    }

    public String I0Io() {
        return this.f1977XO;
    }

    public long II0XooXoX() {
        return this.f1978oIX0oI;
    }

    public String II0xO0() {
        return this.f1973II0XooXoX;
    }

    public String[] Oxx0IOOO() {
        return this.f1975Oxx0IOOO;
    }

    public OxxIIOOXO X0o0xo() {
        return this.f1974II0xO0;
    }

    public String XO() {
        return this.f1976X0o0xo;
    }

    public String oIX0oI() {
        return this.f1972I0Io;
    }

    public String oxoX() {
        return this.f1979oxoX;
    }

    public xoIox(LoggingEvent loggingEvent) {
        this(loggingEvent.timeStamp, loggingEvent.getLevel(), loggingEvent.getLoggerName(), loggingEvent.getNDC(), loggingEvent.getThreadName(), loggingEvent.getRenderedMessage(), loggingEvent.getThrowableStrRep(), loggingEvent.getLocationInformation() == null ? null : loggingEvent.getLocationInformation().fullInfo);
    }
}
