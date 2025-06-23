package xXIX0Xo;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogRecord;
import org.apache.log4j.lf5.util.AdapterLogRecord;
import org.apache.log4j.lf5.viewer.IoOoX;

/* loaded from: classes6.dex */
public class oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f34668I0Io = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f34669oxoX = 1;

    /* renamed from: II0xO0, reason: collision with root package name */
    public LogLevel f34670II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public IoOoX f34671oIX0oI;

    public oxoX(List list) {
        this.f34670II0xO0 = null;
        this.f34670II0xO0 = (LogLevel) list.get(0);
        IoOoX ioOoX = new IoOoX(list);
        this.f34671oIX0oI = ioOoX;
        ioOoX.XIXIX(oxoX(), I0Io());
        this.f34671oIX0oI.OX00O0xII(12);
        this.f34671oIX0oI.xI0oxI00();
    }

    public static int I0Io() {
        return (X0o0xo() * 3) / 4;
    }

    public static int X0o0xo() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().height;
        } catch (Throwable unused) {
            return 600;
        }
    }

    public static int XO() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().width;
        } catch (Throwable unused) {
            return 800;
        }
    }

    public static oxoX oO(LogLevel[] logLevelArr) {
        if (logLevelArr == null) {
            return null;
        }
        return x0XOIxOo(Arrays.asList(logLevelArr));
    }

    public static oxoX ooOOo0oXI(int i) {
        if (i == 1) {
            oxoX x0XOIxOo2 = x0XOIxOo(LogLevel.getJdk14Levels());
            x0XOIxOo2.x0xO0oo(LogLevel.FINEST);
            x0XOIxOo2.IXxxXO(LogLevel.SEVERE);
            return x0XOIxOo2;
        }
        oxoX x0XOIxOo3 = x0XOIxOo(LogLevel.getLog4JLevels());
        x0XOIxOo3.x0xO0oo(LogLevel.DEBUG);
        x0XOIxOo3.IXxxXO(LogLevel.FATAL);
        return x0XOIxOo3;
    }

    public static int oxoX() {
        return (XO() * 3) / 4;
    }

    public static oxoX x0XOIxOo(List list) {
        return new oxoX(list);
    }

    public void II0XooXoX(String str, String str2) {
        xxIXOIIO(str, null, str2);
    }

    public LogLevel II0xO0() {
        return this.f34670II0xO0;
    }

    public void IXxxXO(LogLevel logLevel) {
        AdapterLogRecord.setSevereLevel(logLevel);
    }

    public void OOXIXo(String str, LogLevel logLevel, String str2, Throwable th) {
        oOoXoXO(str, logLevel, str2, th, null);
    }

    public void Oo(int i) {
        this.f34671oIX0oI.oOo(i);
    }

    public LogLevel Oxx0IOOO() {
        return AdapterLogRecord.getSevereLevel();
    }

    public void oIX0oI(LogRecord logRecord) {
        this.f34671oIX0oI.II0xO0(logRecord);
    }

    public void oOoXoXO(String str, LogLevel logLevel, String str2, Throwable th, String str3) {
        AdapterLogRecord adapterLogRecord = new AdapterLogRecord();
        adapterLogRecord.setCategory(str);
        adapterLogRecord.setMessage(str2);
        adapterLogRecord.setNDC(str3);
        adapterLogRecord.setThrown(th);
        if (logLevel == null) {
            adapterLogRecord.setLevel(II0xO0());
        } else {
            adapterLogRecord.setLevel(logLevel);
        }
        oIX0oI(adapterLogRecord);
    }

    public void x0xO0oo(LogLevel logLevel) {
        this.f34670II0xO0 = logLevel;
    }

    public void xoIox(String str, LogLevel logLevel, String str2, String str3) {
        oOoXoXO(str, logLevel, str2, null, str3);
    }

    public void xxIXOIIO(String str, LogLevel logLevel, String str2) {
        oOoXoXO(str, logLevel, str2, null, null);
    }
}
