package OI0;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes8.dex */
public final class oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f1509II0XooXoX = "ro.build.version.emui";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f1511OOXIXo = "ro.build.version.opporom";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f1516oOoXoXO = "unknown";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f1519xoIox = "ro.build.version.incremental";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f1520xxIXOIIO = "ro.vivo.os.build.display.id";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String[] f1515oIX0oI = {"huawei"};

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String[] f1510II0xO0 = {"harmony"};

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String[] f1508I0Io = {"honor"};

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String[] f1518oxoX = {"vivo"};

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String[] f1513X0o0xo = {"xiaomi"};

    /* renamed from: XO, reason: collision with root package name */
    public static final String[] f1514XO = {"oppo"};

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String[] f1512Oxx0IOOO = {"samsung"};

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static oIX0oI f1517ooOOo0oXI = null;

    /* loaded from: classes8.dex */
    public static class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f1521II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f1522oIX0oI;

        public String X0o0xo() {
            return this.f1521II0xO0;
        }

        public String oxoX() {
            return this.f1522oIX0oI;
        }

        public String toString() {
            return "RomInfo{name=" + this.f1522oIX0oI + ", version=" + this.f1521II0xO0 + ooOOo0oXI.f33074oOoXoXO;
        }
    }

    public oxoX() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String I0Io() {
        try {
            String str = Build.MODEL;
            if (!TextUtils.isEmpty(str)) {
                return str.toLowerCase();
            }
            return "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String II0XooXoX(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    readLine = bufferedReader.readLine();
                } catch (IOException unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                        return "";
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                return "";
            }
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (readLine != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
            return readLine;
        }
        bufferedReader.close();
        return "";
    }

    public static String II0xO0() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                return str.toLowerCase();
            }
            return "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static boolean OOXIXo() {
        return f1508I0Io[0].equals(oxoX().f1522oIX0oI);
    }

    public static String Oo() {
        return "Rom Info           : " + oxoX() + "\nDevice Manufacturer: " + Build.MANUFACTURER + "\nDevice Model       : " + Build.MODEL + "\nAndroid Version    : " + Build.VERSION.RELEASE + "\nAndroid SDK        : " + Build.VERSION.SDK_INT + "\n\n";
    }

    public static String Oxx0IOOO(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String X0o0xo(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = XO(str);
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2) || str2.equals("unknown")) {
            try {
                String str3 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str3.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return "unknown";
        }
        return str2;
    }

    public static String XO(String str) {
        String II0XooXoX2 = II0XooXoX(str);
        if (!TextUtils.isEmpty(II0XooXoX2)) {
            return II0XooXoX2;
        }
        String xxIXOIIO2 = xxIXOIIO(str);
        if (!TextUtils.isEmpty(xxIXOIIO2)) {
            return xxIXOIIO2;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return Oxx0IOOO(str);
        }
        return xxIXOIIO2;
    }

    public static String oIX0oI() {
        try {
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                return str.toLowerCase();
            }
            return "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static boolean oO() {
        return f1518oxoX[0].equals(oxoX().f1522oIX0oI);
    }

    public static boolean oOoXoXO() {
        return f1515oIX0oI[0].equals(oxoX().f1522oIX0oI);
    }

    public static boolean ooOOo0oXI() {
        return f1514XO[0].equals(oxoX().f1522oIX0oI);
    }

    public static oIX0oI oxoX() {
        oIX0oI oix0oi = f1517ooOOo0oXI;
        if (oix0oi != null) {
            return oix0oi;
        }
        f1517ooOOo0oXI = new oIX0oI();
        String oIX0oI2 = oIX0oI();
        String II0xO02 = II0xO0();
        String[] strArr = f1515oIX0oI;
        if (x0XOIxOo(oIX0oI2, II0xO02, strArr)) {
            f1517ooOOo0oXI.f1522oIX0oI = strArr[0];
            String X0o0xo2 = X0o0xo(f1509II0XooXoX);
            String[] split = X0o0xo2.split("_");
            if (split.length <= 1) {
                f1517ooOOo0oXI.f1521II0xO0 = X0o0xo2;
            } else {
                f1517ooOOo0oXI.f1521II0xO0 = split[1];
            }
            return f1517ooOOo0oXI;
        }
        String[] strArr2 = f1518oxoX;
        if (x0XOIxOo(oIX0oI2, II0xO02, strArr2)) {
            f1517ooOOo0oXI.f1522oIX0oI = strArr2[0];
            f1517ooOOo0oXI.f1521II0xO0 = X0o0xo(f1520xxIXOIIO);
            return f1517ooOOo0oXI;
        }
        String[] strArr3 = f1513X0o0xo;
        if (x0XOIxOo(oIX0oI2, II0xO02, strArr3)) {
            f1517ooOOo0oXI.f1522oIX0oI = strArr3[0];
            f1517ooOOo0oXI.f1521II0xO0 = X0o0xo(f1519xoIox);
            return f1517ooOOo0oXI;
        }
        String[] strArr4 = f1514XO;
        if (x0XOIxOo(oIX0oI2, II0xO02, strArr4)) {
            f1517ooOOo0oXI.f1522oIX0oI = strArr4[0];
            f1517ooOOo0oXI.f1521II0xO0 = X0o0xo(f1511OOXIXo);
            return f1517ooOOo0oXI;
        }
        String[] strArr5 = f1512Oxx0IOOO;
        if (!x0XOIxOo(oIX0oI2, II0xO02, strArr5)) {
            f1517ooOOo0oXI.f1522oIX0oI = II0xO02;
        } else {
            f1517ooOOo0oXI.f1522oIX0oI = strArr5[0];
        }
        f1517ooOOo0oXI.f1521II0xO0 = X0o0xo("");
        return f1517ooOOo0oXI;
    }

    public static boolean x0XOIxOo(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean x0xO0oo() {
        return f1513X0o0xo[0].equals(oxoX().f1522oIX0oI);
    }

    public static boolean xoIox() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object invoke = cls.getMethod("getOsBrand", null).invoke(cls, null);
            if (invoke == null) {
                return false;
            }
            if (!f1510II0xO0[0].equalsIgnoreCase(invoke.toString())) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String xxIXOIIO(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }
}
