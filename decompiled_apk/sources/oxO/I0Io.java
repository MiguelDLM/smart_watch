package oxO;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;

/* loaded from: classes6.dex */
public class I0Io implements oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public Logger f33540II0XooXoX = null;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ResourceBundle f33545xxIXOIIO = null;

    /* renamed from: xoIox, reason: collision with root package name */
    public ResourceBundle f33544xoIox = null;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f33541OOXIXo = null;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f33542oOoXoXO = null;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public String f33543ooOOo0oXI = null;

    public static void XIxXXX0x0(Logger logger) {
        if (logger != null) {
            Handler[] handlers = logger.getHandlers();
            for (int i = 0; i < handlers.length; i++) {
                Handler handler = handlers[i];
                if (handler instanceof MemoryHandler) {
                    synchronized (handler) {
                        ((MemoryHandler) handlers[i]).push();
                    }
                    return;
                }
            }
            XIxXXX0x0(logger.getParent());
        }
    }

    @Override // oxO.oxoX
    public void I0Io(String str, String str2, String str3, Object[] objArr) {
        II0XooXoX(6, str, str2, str3, objArr, null);
    }

    @Override // oxO.oxoX
    public void II0XooXoX(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        Level xXxxox0I2 = xXxxox0I(i);
        if (this.f33540II0XooXoX.isLoggable(xXxxox0I2)) {
            XxX0x0xxx(xXxxox0I2, str, str2, this.f33541OOXIXo, this.f33544xoIox, str3, objArr, th);
        }
    }

    @Override // oxO.oxoX
    public void II0xO0(String str, String str2, String str3, Object[] objArr, Throwable th) {
        II0XooXoX(5, str, str2, str3, objArr, th);
    }

    @Override // oxO.oxoX
    public void IIXOooo(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        Level xXxxox0I2 = xXxxox0I(i);
        if (this.f33540II0XooXoX.isLoggable(xXxxox0I2)) {
            XxX0x0xxx(xXxxox0I2, str, str2, this.f33541OOXIXo, this.f33545xxIXOIIO, str3, objArr, th);
        }
    }

    @Override // oxO.oxoX
    public String IXxxXO(String str, Object[] objArr) {
        try {
            return this.f33545xxIXOIIO.getString(str);
        } catch (MissingResourceException unused) {
            return str;
        }
    }

    @Override // oxO.oxoX
    public void O0xOxO(String str, String str2, String str3, Object[] objArr) {
        IIXOooo(1, str, str2, str3, objArr, null);
    }

    @Override // oxO.oxoX
    public void OOXIXo(String str, String str2, String str3, Object[] objArr) {
        II0XooXoX(5, str, str2, str3, objArr, null);
    }

    @Override // oxO.oxoX
    public void Oo(ResourceBundle resourceBundle, String str, String str2) {
        this.f33544xoIox = this.f33545xxIXOIIO;
        this.f33542oOoXoXO = str2;
        this.f33543ooOOo0oXI = str;
        this.f33540II0XooXoX = Logger.getLogger(str);
        this.f33545xxIXOIIO = resourceBundle;
        this.f33544xoIox = resourceBundle;
        this.f33541OOXIXo = resourceBundle.getString("0");
    }

    @Override // oxO.oxoX
    public void OxI(String str, String str2, String str3, Object[] objArr, Throwable th) {
        II0XooXoX(6, str, str2, str3, objArr, th);
    }

    @Override // oxO.oxoX
    public void Oxx0IOOO(String str, String str2, String str3) {
        IIXOooo(4, str, str2, str3, null, null);
    }

    @Override // oxO.oxoX
    public void Oxx0xo(String str, String str2, String str3, Object[] objArr, Throwable th) {
        II0XooXoX(7, str, str2, str3, objArr, th);
    }

    @Override // oxO.oxoX
    public void OxxIIOOXO(String str, String str2, String str3) {
        II0XooXoX(7, str, str2, str3, null, null);
    }

    @Override // oxO.oxoX
    public boolean X0IIOO(int i) {
        return this.f33540II0XooXoX.isLoggable(xXxxox0I(i));
    }

    @Override // oxO.oxoX
    public void X0o0xo(String str, String str2, String str3, Object[] objArr, Throwable th) {
        IIXOooo(3, str, str2, str3, objArr, th);
    }

    @Override // oxO.oxoX
    public void XI0IXoo(String str, String str2, String str3, Object[] objArr) {
        II0XooXoX(7, str, str2, str3, objArr, null);
    }

    @Override // oxO.oxoX
    public void XO(String str, String str2, String str3) {
        IIXOooo(3, str, str2, str3, null, null);
    }

    public final void XxX0x0xxx(Level level, String str, String str2, String str3, ResourceBundle resourceBundle, String str4, Object[] objArr, Throwable th) {
        if (str4.indexOf("=====") == -1) {
            str4 = MessageFormat.format(xxX(resourceBundle, str4), objArr);
        }
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(this.f33542oOoXoXO));
        stringBuffer.append(": ");
        stringBuffer.append(str4);
        LogRecord logRecord = new LogRecord(level, stringBuffer.toString());
        logRecord.setSourceClassName(str);
        logRecord.setSourceMethodName(str2);
        logRecord.setLoggerName(this.f33543ooOOo0oXI);
        if (th != null) {
            logRecord.setThrown(th);
        }
        this.f33540II0XooXoX.log(logRecord);
    }

    @Override // oxO.oxoX
    public void o00(String str, String str2, String str3) {
        IIXOooo(1, str, str2, str3, null, null);
    }

    @Override // oxO.oxoX
    public void oI0IIXIo(String str, String str2, String str3, Object[] objArr, Throwable th) {
        IIXOooo(1, str, str2, str3, objArr, th);
    }

    @Override // oxO.oxoX
    public void oIX0oI(String str, String str2, String str3, Object[] objArr) {
        IIXOooo(2, str, str2, str3, objArr, null);
    }

    @Override // oxO.oxoX
    public void oO(String str, String str2, String str3) {
        IIXOooo(2, str, str2, str3, null, null);
    }

    @Override // oxO.oxoX
    public void oOoXoXO(String str, String str2, String str3, Object[] objArr) {
        IIXOooo(4, str, str2, str3, objArr, null);
    }

    @Override // oxO.oxoX
    public void ooOOo0oXI(String str, String str2, String str3, Object[] objArr, Throwable th) {
        IIXOooo(2, str, str2, str3, objArr, th);
    }

    @Override // oxO.oxoX
    public void oxoX(String str, String str2, String str3, Object[] objArr, Throwable th) {
        IIXOooo(4, str, str2, str3, objArr, th);
    }

    @Override // oxO.oxoX
    public void x0XOIxOo(String str, String str2, String str3, Object[] objArr) {
        IIXOooo(3, str, str2, str3, objArr, null);
    }

    @Override // oxO.oxoX
    public void x0xO0oo(String str, String str2, String str3) {
        II0XooXoX(6, str, str2, str3, null, null);
    }

    public final Level xXxxox0I(int i) {
        switch (i) {
            case 1:
                return Level.SEVERE;
            case 2:
                return Level.WARNING;
            case 3:
                return Level.INFO;
            case 4:
                return Level.CONFIG;
            case 5:
                return Level.FINE;
            case 6:
                return Level.FINER;
            case 7:
                return Level.FINEST;
            default:
                return null;
        }
    }

    @Override // oxO.oxoX
    public void xoIox(String str) {
        this.f33542oOoXoXO = str;
    }

    @Override // oxO.oxoX
    public void xoXoI() {
        XIxXXX0x0(this.f33540II0XooXoX);
    }

    @Override // oxO.oxoX
    public void xxIXOIIO(String str, String str2, String str3) {
        II0XooXoX(5, str, str2, str3, null, null);
    }

    public final String xxX(ResourceBundle resourceBundle, String str) {
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return str;
        }
    }
}
