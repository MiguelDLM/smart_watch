package xXIX0Xo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;
import org.apache.log4j.lf5.Log4JLogRecord;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogLevelFormatException;
import org.apache.log4j.lf5.LogRecord;
import org.apache.log4j.lf5.viewer.IoOoX;
import org.apache.log4j.lf5.viewer.OI0;
import org.apache.log4j.lf5.viewer.X00IoxXI;

/* loaded from: classes6.dex */
public class I0Io implements Runnable {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f34648IIXOooo = "[slf5s.THREAD]";

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final String f34649O0xOxO = "[slf5s.PRIORITY]";

    /* renamed from: OxI, reason: collision with root package name */
    public static final String f34650OxI = "[slf5s.MESSAGE]";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f34651Oxx0xo = "[slf5s.start]";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final String f34652OxxIIOOXO = "[slf5s.DATE]";

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final String f34653X0IIOO = "[slf5s.NDC]";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static SimpleDateFormat f34654XI0IXoo = new SimpleDateFormat("dd MMM yyyy HH:mm:ss,S");

    /* renamed from: o00, reason: collision with root package name */
    public static final String f34655o00 = "[slf5s.LOCATION]";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f34656oI0IIXIo = "[slf5s.";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final String f34657xoXoI = "[slf5s.CATEGORY]";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public InputStream f34658IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public OI0 f34659Oo;

    /* renamed from: XO, reason: collision with root package name */
    public IoOoX f34660XO;

    public I0Io(File file) throws IOException, FileNotFoundException {
        this(new FileInputStream(file));
    }

    public final void I0Io() {
        this.f34659Oo.hide();
        this.f34659Oo.dispose();
    }

    public final String II0XooXoX(String str, String str2) {
        int indexOf = str2.indexOf(str);
        if (indexOf == -1) {
            return null;
        }
        return X0o0xo(indexOf, str2);
    }

    public final LogRecord II0xO0(String str) {
        if (str != null && str.trim().length() != 0) {
            Log4JLogRecord log4JLogRecord = new Log4JLogRecord();
            log4JLogRecord.setMillis(xoIox(str));
            log4JLogRecord.setLevel(x0XOIxOo(str));
            log4JLogRecord.setCategory(xxIXOIIO(str));
            log4JLogRecord.setLocation(OOXIXo(str));
            log4JLogRecord.setThreadDescription(oO(str));
            log4JLogRecord.setNDC(ooOOo0oXI(str));
            log4JLogRecord.setMessage(oOoXoXO(str));
            log4JLogRecord.setThrownStackTrace(x0xO0oo(str));
            return log4JLogRecord;
        }
        return null;
    }

    public final String OOXIXo(String str) {
        return II0XooXoX(f34655o00, str);
    }

    public void Oxx0IOOO(IoOoX ioOoX) throws RuntimeException {
        this.f34660XO = ioOoX;
        new Thread(this).start();
    }

    public final String X0o0xo(int i, String str) {
        int lastIndexOf = str.lastIndexOf(f34656oI0IIXIo, i - 1);
        if (lastIndexOf == -1) {
            return str.substring(0, i);
        }
        return str.substring(str.indexOf("]", lastIndexOf) + 1, i).trim();
    }

    public final String XO(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int available = bufferedInputStream.available();
        if (available > 0) {
            stringBuffer = new StringBuffer(available);
        } else {
            stringBuffer = new StringBuffer(1024);
        }
        while (true) {
            int read = bufferedInputStream.read();
            if (read == -1) {
                bufferedInputStream.close();
                return stringBuffer.toString();
            }
            stringBuffer.append((char) read);
        }
    }

    public final String oO(String str) {
        return II0XooXoX(f34648IIXOooo, str);
    }

    public final String oOoXoXO(String str) {
        return II0XooXoX(f34650OxI, str);
    }

    public final String ooOOo0oXI(String str) {
        return II0XooXoX(f34653X0IIOO, str);
    }

    public void oxoX(String str) {
        new X00IoxXI(this.f34660XO.OI0(), str);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        LogRecord II0xO02;
        this.f34659Oo = new OI0(this.f34660XO.OI0(), "Loading file...");
        try {
            String XO2 = XO(this.f34658IXxxXO);
            int i = 0;
            z = false;
            while (true) {
                int indexOf = XO2.indexOf(f34651Oxx0xo, i);
                if (indexOf == -1) {
                    break;
                }
                LogRecord II0xO03 = II0xO0(XO2.substring(i, indexOf));
                if (II0xO03 != null) {
                    this.f34660XO.II0xO0(II0xO03);
                }
                i = indexOf + 13;
                z = true;
            }
            if (i < XO2.length() && z && (II0xO02 = II0xO0(XO2.substring(i))) != null) {
                this.f34660XO.II0xO0(II0xO02);
            }
        } catch (IOException unused) {
            I0Io();
            oxoX("Error - Unable to load log file!");
        } catch (RuntimeException unused2) {
            I0Io();
            oxoX("Error - Invalid log file format.\nPlease see documentation on how to load log files.");
        }
        if (z) {
            SwingUtilities.invokeLater(new II0xO0(this));
            this.f34658IXxxXO = null;
            return;
        }
        throw new RuntimeException("Invalid log file format");
    }

    public final LogLevel x0XOIxOo(String str) {
        String II0XooXoX2 = II0XooXoX(f34649O0xOxO, str);
        if (II0XooXoX2 != null) {
            try {
                return LogLevel.valueOf(II0XooXoX2);
            } catch (LogLevelFormatException unused) {
                return LogLevel.DEBUG;
            }
        }
        return LogLevel.DEBUG;
    }

    public final String x0xO0oo(String str) {
        return X0o0xo(str.length(), str);
    }

    public final long xoIox(String str) {
        try {
            String II0XooXoX2 = II0XooXoX(f34652OxxIIOOXO, str);
            if (II0XooXoX2 == null) {
                return 0L;
            }
            return f34654XI0IXoo.parse(II0XooXoX2).getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public final String xxIXOIIO(String str) {
        return II0XooXoX(f34657xoXoI, str);
    }

    public I0Io(InputStream inputStream) throws IOException {
        this.f34658IXxxXO = inputStream;
    }
}
