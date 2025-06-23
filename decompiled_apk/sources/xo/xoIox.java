package xo;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import oOoIIO0.oIX0oI;

/* loaded from: classes13.dex */
public final class xoIox {
    public static boolean I0Io(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean II0XooXoX() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public static boolean II0xO0() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") && !Build.BRAND.equalsIgnoreCase("BLACKSHARK")) {
            return false;
        }
        return true;
    }

    public static boolean IXxxXO() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(oIX0oI.f32057oO)) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(oIX0oI.f32057oO) && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static boolean OOXIXo() {
        return !TextUtils.isEmpty(oI0IIXIo("ro.miui.ui.version.name", ""));
    }

    public static boolean Oo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(oIX0oI.f32059ooOOo0oXI) && !Build.BRAND.equalsIgnoreCase(oIX0oI.f32059ooOOo0oXI) && TextUtils.isEmpty(oI0IIXIo("ro.vivo.os.version", ""))) {
            return false;
        }
        return true;
    }

    public static boolean Oxx0IOOO() {
        return Build.BRAND.equalsIgnoreCase("HONOR");
    }

    public static boolean Oxx0xo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("ZTE") && !Build.BRAND.equalsIgnoreCase("ZTE")) {
            return false;
        }
        return true;
    }

    public static boolean X0o0xo() {
        return !TextUtils.isEmpty(oI0IIXIo(OI0.oxoX.f1509II0XooXoX, ""));
    }

    public static boolean XO() {
        return !TextUtils.isEmpty(oI0IIXIo("ro.build.freeme.label", ""));
    }

    public static String oI0IIXIo(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            xxIXOIIO.II0xO0("System property invoke error: " + e);
            str3 = null;
        }
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    public static boolean oIX0oI() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("ASUS") && !Build.BRAND.equalsIgnoreCase("ASUS")) {
            return false;
        }
        return true;
    }

    public static boolean oO() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(oI0IIXIo(OI0.oxoX.f1511OOXIXo, ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean oOoXoXO() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") && !Build.BRAND.equalsIgnoreCase("MOTOLORA")) {
            return false;
        }
        return true;
    }

    public static boolean ooOOo0oXI() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("NUBIA") && !Build.BRAND.equalsIgnoreCase("NUBIA")) {
            return false;
        }
        return true;
    }

    public static boolean oxoX() {
        return oI0IIXIo("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean x0XOIxOo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") && !Build.BRAND.equalsIgnoreCase("ONEPLUS")) {
            return false;
        }
        return true;
    }

    public static boolean x0xO0oo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") && !Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
            return false;
        }
        return true;
    }

    public static boolean xoIox() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("MEIZU") && !Build.BRAND.equalsIgnoreCase("MEIZU") && !Build.DISPLAY.toUpperCase().contains("FLYME")) {
            return false;
        }
        return true;
    }

    public static boolean xxIXOIIO() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("LENOVO") && !str.equalsIgnoreCase("ZUK")) {
                return false;
            }
        }
        return true;
    }
}
