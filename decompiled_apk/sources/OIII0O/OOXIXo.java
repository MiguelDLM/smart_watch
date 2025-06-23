package OIII0O;

import java.io.PrintStream;
import org.apache.log4j.helpers.IXxxXO;
import org.apache.log4j.helpers.x0xO0oo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.x0XOIxOo;

/* loaded from: classes6.dex */
public class OOXIXo extends org.apache.log4j.II0xO0 {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f1548IIX0o = 0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f1549IIXOooo = 72;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f1550IXxxXO = 40;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f1551O0xOxO = 136;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f1552Oo = 32;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f1553OxI = 128;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f1554Oxx0xo = 48;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f1555OxxIIOOXO = 64;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f1556X0IIOO = 144;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f1557XI0IXoo = 152;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f1558XIxXXX0x0 = 160;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f1559XxX0x0xxx = 176;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f1560o00 = 88;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f1561oI0IIXIo = 56;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f1562oO = 16;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f1563ooOOo0oXI = 0;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f1564ooXIXxIX = 1;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f1565x0XOIxOo = 8;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f1566x0xO0oo = 24;

    /* renamed from: xI, reason: collision with root package name */
    public static final String f1567xI = "    ";

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f1568xXxxox0I = 184;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f1569xoXoI = 80;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f1570xxX = 168;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f1571II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public x0xO0oo f1572OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f1573oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f1574xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f1575xxIXOIIO;

    public OOXIXo() {
        this.f1571II0XooXoX = 8;
        this.f1574xoIox = false;
        xXxxox0I();
    }

    public static int X0IIOO(String str) {
        if (str != null) {
            str = str.trim();
        }
        if ("KERN".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("USER".equalsIgnoreCase(str)) {
            return 8;
        }
        if ("MAIL".equalsIgnoreCase(str)) {
            return 16;
        }
        if ("DAEMON".equalsIgnoreCase(str)) {
            return 24;
        }
        if ("AUTH".equalsIgnoreCase(str)) {
            return 32;
        }
        if ("SYSLOG".equalsIgnoreCase(str)) {
            return 40;
        }
        if ("LPR".equalsIgnoreCase(str)) {
            return 48;
        }
        if ("NEWS".equalsIgnoreCase(str)) {
            return 56;
        }
        if ("UUCP".equalsIgnoreCase(str)) {
            return 64;
        }
        if ("CRON".equalsIgnoreCase(str)) {
            return 72;
        }
        if ("AUTHPRIV".equalsIgnoreCase(str)) {
            return 80;
        }
        if ("FTP".equalsIgnoreCase(str)) {
            return 88;
        }
        if ("LOCAL0".equalsIgnoreCase(str)) {
            return 128;
        }
        if ("LOCAL1".equalsIgnoreCase(str)) {
            return 136;
        }
        if ("LOCAL2".equalsIgnoreCase(str)) {
            return 144;
        }
        if ("LOCAL3".equalsIgnoreCase(str)) {
            return 152;
        }
        if ("LOCAL4".equalsIgnoreCase(str)) {
            return 160;
        }
        if ("LOCAL5".equalsIgnoreCase(str)) {
            return 168;
        }
        if ("LOCAL6".equalsIgnoreCase(str)) {
            return 176;
        }
        if ("LOCAL7".equalsIgnoreCase(str)) {
            return 184;
        }
        return -1;
    }

    public static String xxX(int i) {
        switch (i) {
            case 0:
                return "kern";
            case 8:
                return "user";
            case 16:
                return "mail";
            case 24:
                return "daemon";
            case 32:
                return "auth";
            case 40:
                return "syslog";
            case 48:
                return "lpr";
            case 56:
                return "news";
            case 64:
                return "uucp";
            case 72:
                return "cron";
            case 80:
                return "authpriv";
            case 88:
                return "ftp";
            case 128:
                return "local0";
            case 136:
                return "local1";
            case 144:
                return "local2";
            case 152:
                return "local3";
            case 160:
                return "local4";
            case 168:
                return "local5";
            case 176:
                return "local6";
            case 184:
                return "local7";
            default:
                return null;
        }
    }

    public void IIX0o(String str) {
        if (str == null) {
            return;
        }
        int X0IIOO2 = X0IIOO(str);
        this.f1571II0XooXoX = X0IIOO2;
        if (X0IIOO2 == -1) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            stringBuffer.append(str);
            stringBuffer.append("] is an unknown syslog facility. Defaulting to [USER].");
            printStream.println(stringBuffer.toString());
            this.f1571II0XooXoX = 8;
        }
        xXxxox0I();
        x0xO0oo x0xo0oo = this.f1572OOXIXo;
        if (x0xo0oo != null) {
            x0xo0oo.I0Io(this.f1571II0XooXoX);
        }
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        String str;
        String[] throwableStrRep;
        int length;
        if (!OxI(loggingEvent.getLevel())) {
            return;
        }
        if (this.f1572OOXIXo == null) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No syslog host is set for SyslogAppedender named \"");
            stringBuffer.append(this.f33157II0xO0);
            stringBuffer.append("\".");
            x0o0xo.error(stringBuffer.toString());
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.f1574xoIox) {
            str = this.f1575xxIXOIIO;
        } else {
            str = "";
        }
        stringBuffer2.append(str);
        stringBuffer2.append(this.f33161oIX0oI.oIX0oI(loggingEvent));
        String stringBuffer3 = stringBuffer2.toString();
        this.f1572OOXIXo.II0xO0(loggingEvent.getLevel().getSyslogEquivalent());
        this.f1572OOXIXo.write(stringBuffer3);
        if (this.f33161oIX0oI.Oxx0IOOO() && (throwableStrRep = loggingEvent.getThrowableStrRep()) != null && (length = throwableStrRep.length) > 0) {
            this.f1572OOXIXo.write(throwableStrRep[0]);
            for (int i = 1; i < length; i++) {
                x0xO0oo x0xo0oo = this.f1572OOXIXo;
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(f1567xI);
                stringBuffer4.append(throwableStrRep[i].substring(1));
                x0xo0oo.write(stringBuffer4.toString());
            }
        }
    }

    public String XI0IXoo() {
        return xxX(this.f1571II0XooXoX);
    }

    public boolean XIxXXX0x0() {
        return this.f1574xoIox;
    }

    public String XxX0x0xxx() {
        return this.f1573oOoXoXO;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public synchronized void close() {
        this.f33158Oxx0IOOO = true;
        this.f1572OOXIXo = null;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return true;
    }

    public void ooXIXxIX(boolean z) {
        this.f1574xoIox = z;
    }

    public void xI(String str) {
        this.f1572OOXIXo = new x0xO0oo(new IXxxXO(str), this.f1571II0XooXoX, this.f33162oxoX);
        this.f1573oOoXoXO = str;
    }

    public final void xXxxox0I() {
        String xxX2 = xxX(this.f1571II0XooXoX);
        this.f1575xxIXOIIO = xxX2;
        if (xxX2 == null) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\"");
            stringBuffer.append(this.f1571II0XooXoX);
            stringBuffer.append("\" is an unknown syslog facility. Defaulting to \"USER\".");
            printStream.println(stringBuffer.toString());
            this.f1571II0XooXoX = 8;
            this.f1575xxIXOIIO = "user:";
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.f1575xxIXOIIO);
        stringBuffer2.append(":");
        this.f1575xxIXOIIO = stringBuffer2.toString();
    }

    public OOXIXo(x0XOIxOo x0xoixoo, int i) {
        this.f1574xoIox = false;
        this.f33161oIX0oI = x0xoixoo;
        this.f1571II0XooXoX = i;
        xXxxox0I();
    }

    public OOXIXo(x0XOIxOo x0xoixoo, String str, int i) {
        this(x0xoixoo, i);
        xI(str);
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
    }
}
