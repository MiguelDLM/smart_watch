package xx0;

import android.text.TextUtils;
import com.tencent.open.utils.II0xO0;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import xx0.oO;

/* loaded from: classes13.dex */
public class ooOOo0oXI {

    /* renamed from: xoIox, reason: collision with root package name */
    public static SimpleDateFormat f35221xoIox = oO.oxoX.oIX0oI("yy.MM.dd.HH");

    /* renamed from: XO, reason: collision with root package name */
    public File f35227XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f35228oIX0oI = "Tracer.File";

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f35224II0xO0 = Integer.MAX_VALUE;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f35222I0Io = Integer.MAX_VALUE;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f35229oxoX = 4096;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public long f35226X0o0xo = 10000;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f35225Oxx0IOOO = 10;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f35223II0XooXoX = ".log";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public long f35230xxIXOIIO = Long.MAX_VALUE;

    public ooOOo0oXI(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        I0Io(file);
        Oxx0IOOO(i);
        oIX0oI(i2);
        oOoXoXO(i3);
        oxoX(str);
        II0xO0(j);
        x0xO0oo(i4);
        xxIXOIIO(str2);
        II0XooXoX(j2);
    }

    public void I0Io(File file) {
        this.f35227XO = file;
    }

    public void II0XooXoX(long j) {
        this.f35230xxIXOIIO = j;
    }

    public void II0xO0(long j) {
        this.f35226X0o0xo = j;
    }

    public int IXxxXO() {
        return this.f35225Oxx0IOOO;
    }

    public final String OOXIXo(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public File Oo() {
        return this.f35227XO;
    }

    public void Oxx0IOOO(int i) {
        this.f35222I0Io = i;
    }

    public File[] X0o0xo() {
        return ooOOo0oXI(System.currentTimeMillis());
    }

    public File XO() {
        File Oo2 = Oo();
        if (Oo2 != null) {
            Oo2.mkdirs();
        }
        return Oo2;
    }

    public void oIX0oI(int i) {
        this.f35224II0xO0 = i;
    }

    public final String oO(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public void oOoXoXO(int i) {
        this.f35229oxoX = i;
    }

    public final File[] ooOOo0oXI(long j) {
        File file;
        File XO2 = XO();
        String OOXIXo2 = OOXIXo(oO(j));
        try {
            XO2 = new File(XO2, OOXIXo2);
        } catch (Throwable th) {
            xxIXOIIO.xxIXOIIO(xxIXOIIO.f35263Oxx0xo, "getWorkFile,get old sdcard file exception:", th);
        }
        String X0IIOO2 = II0xO0.X0IIOO();
        if (!TextUtils.isEmpty(X0IIOO2) || X0IIOO2 != null) {
            try {
                File file2 = new File(X0IIOO2, x0XOIxOo.f35239oO);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, OOXIXo2);
            } catch (Exception e) {
                xxIXOIIO.xxIXOIIO(xxIXOIIO.f35263Oxx0xo, "getWorkFile,get app specific file exception:", e);
            }
            return new File[]{XO2, file};
        }
        file = null;
        return new File[]{XO2, file};
    }

    public void oxoX(String str) {
        this.f35228oIX0oI = str;
    }

    public int x0XOIxOo() {
        return this.f35229oxoX;
    }

    public void x0xO0oo(int i) {
        this.f35225Oxx0IOOO = i;
    }

    public String xoIox() {
        return this.f35228oIX0oI;
    }

    public void xxIXOIIO(String str) {
        this.f35223II0XooXoX = str;
    }
}
