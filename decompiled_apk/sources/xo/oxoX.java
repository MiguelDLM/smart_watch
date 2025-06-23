package xo;

import IOOoXo0Ix.ooOOo0oXI;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.kuaishou.weapon.p0.g;
import com.tanx.onlyid.api.OAIDException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes13.dex */
public final class oxoX implements XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f34936I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f34937II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Application f34938oIX0oI;

    /* loaded from: classes13.dex */
    public static class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final oxoX f34939oIX0oI = new oxoX();
    }

    public static String I0Io() {
        String str = II0xO0.f34939oIX0oI.f34937II0xO0;
        if (str == null) {
            return "";
        }
        return str;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String II0XooXoX(Context context) {
        String imei;
        xxIXOIIO.I0Io("OnlyId", "getIMEI");
        if (context != null) {
            try {
                imei = ((TelephonyManager) context.getSystemService("phone")).getImei();
                if (TextUtils.isEmpty(imei)) {
                    return xxIXOIIO(context, 0);
                }
                return imei;
            } catch (Error e) {
                xxIXOIIO.II0xO0(e);
                return "";
            } catch (Exception e2) {
                xxIXOIIO.II0xO0(e2);
                return "";
            }
        }
        return "";
    }

    @SuppressLint({"HardwareIds"})
    public static String II0xO0(Context context) {
        String string;
        if (context == null || (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) {
            return "";
        }
        return string;
    }

    public static boolean IIXOooo(Context context) {
        return ooOOo0oXI.oIX0oI(context).II0xO0();
    }

    public static void IXxxXO(Application application) {
        if (application == null) {
            return;
        }
        II0xO0.f34939oIX0oI.f34938oIX0oI = application;
    }

    public static void OOXIXo(Context context, XO xo2) {
        ooOOo0oXI.oIX0oI(context).oIX0oI(xo2);
    }

    public static String Oo() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : propertyByteArray) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Error e) {
            xxIXOIIO.II0xO0(e);
            return "";
        } catch (Exception e2) {
            xxIXOIIO.II0xO0(e2);
            return "";
        }
    }

    public static File Oxx0IOOO(Context context) {
        int checkSelfPermission;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (i < 30 && context != null) {
                checkSelfPermission = context.checkSelfPermission(g.j);
                if (checkSelfPermission != 0) {
                    return null;
                }
            } else {
                return null;
            }
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    public static void Oxx0xo(Context context, String str) {
        if (context == null) {
            return;
        }
        File Oxx0IOOO2 = Oxx0IOOO(context);
        if (Oxx0IOOO2 == null) {
            xxIXOIIO.II0xO0("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Oxx0IOOO2));
            try {
                if (!Oxx0IOOO2.exists()) {
                    Oxx0IOOO2.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                xxIXOIIO.II0xO0("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e) {
            xxIXOIIO.II0xO0(e);
        }
    }

    public static void OxxIIOOXO(Context context, String str) {
        boolean canWrite;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            canWrite = Settings.System.canWrite(context);
            if (!canWrite) {
                xxIXOIIO.II0xO0("android.permission.WRITE_SETTINGS not granted");
                return;
            }
        }
        try {
            Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            xxIXOIIO.II0xO0("Save uuid to system settings: " + str);
        } catch (Exception e) {
            xxIXOIIO.II0xO0(e);
        }
    }

    public static String X0o0xo() {
        return oIX0oI(I0Io(), MessageDigestAlgorithms.SHA_1);
    }

    public static String XO(Context context) {
        String x0xO0oo2 = x0xO0oo(context);
        if (TextUtils.isEmpty(x0xO0oo2)) {
            x0xO0oo2 = x0XOIxOo(context);
        }
        if (TextUtils.isEmpty(x0xO0oo2)) {
            x0xO0oo2 = oO(context);
        }
        if (TextUtils.isEmpty(x0xO0oo2)) {
            String uuid = UUID.randomUUID().toString();
            xxIXOIIO.II0xO0("Generate uuid by random: " + uuid);
            oI0IIXIo(context, uuid);
            OxxIIOOXO(context, uuid);
            Oxx0xo(context, uuid);
            return uuid;
        }
        return x0xO0oo2;
    }

    public static void oI0IIXIo(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString(Constant.MAP_KEY_UUID, str).apply();
        xxIXOIIO.II0xO0("Save uuid to shared preferences: " + str);
    }

    public static String oIX0oI(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(str2).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            xxIXOIIO.II0xO0(e);
            return "";
        }
    }

    public static String oO(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString(Constant.MAP_KEY_UUID, "");
        xxIXOIIO.II0xO0("Get uuid from shared preferences: " + string);
        return string;
    }

    public static String oOoXoXO() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.BOARD.length() % 10);
        sb.append(Arrays.deepToString(Build.SUPPORTED_ABIS).length() % 10);
        sb.append(Build.DEVICE.length() % 10);
        sb.append(Build.DISPLAY.length() % 10);
        sb.append(Build.HOST.length() % 10);
        sb.append(Build.ID.length() % 10);
        sb.append(Build.MANUFACTURER.length() % 10);
        sb.append(Build.BRAND.length() % 10);
        sb.append(Build.MODEL.length() % 10);
        sb.append(Build.PRODUCT.length() % 10);
        sb.append(Build.BOOTLOADER.length() % 10);
        sb.append(Build.HARDWARE.length() % 10);
        sb.append(Build.TAGS.length() % 10);
        sb.append(Build.TYPE.length() % 10);
        sb.append(Build.USER.length() % 10);
        return sb.toString();
    }

    public static String ooOOo0oXI(Context context) {
        int checkSelfPermission;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            xxIXOIIO.II0xO0("IMEI/MEID not allowed on Android 10+");
            return "";
        }
        if (context == null) {
            return "";
        }
        if (i >= 23) {
            checkSelfPermission = context.checkSelfPermission(g.c);
            if (checkSelfPermission != 0) {
                xxIXOIIO.II0xO0("android.permission.READ_PHONE_STATE not granted");
                return "";
            }
        }
        return II0XooXoX(context);
    }

    public static String oxoX() {
        return oIX0oI(I0Io(), "MD5");
    }

    public static String x0XOIxOo(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        File Oxx0IOOO2 = Oxx0IOOO(context);
        if (Oxx0IOOO2 != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(Oxx0IOOO2));
                try {
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e) {
                xxIXOIIO.II0xO0(e);
            }
        }
        xxIXOIIO.II0xO0("Get uuid from external storage: " + str);
        return str;
    }

    public static String x0xO0oo(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        xxIXOIIO.II0xO0("Get uuid from system settings: " + string);
        return string;
    }

    public static String xoIox() {
        String str = II0xO0.f34939oIX0oI.f34936I0Io;
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String xxIXOIIO(Context context, int i) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (String) telephonyManager.getClass().getMethod("getImei", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i));
        } catch (Exception e) {
            xxIXOIIO.II0xO0(e);
            return "";
        }
    }

    @Override // xo.XO
    public void oaidError(Exception exc) {
        String Oo2 = Oo();
        if (!TextUtils.isEmpty(Oo2)) {
            this.f34937II0xO0 = Oo2;
            xxIXOIIO.II0xO0("Client id is WidevineID: " + this.f34937II0xO0);
            return;
        }
        String II0xO02 = II0xO0(this.f34938oIX0oI);
        if (!TextUtils.isEmpty(II0xO02)) {
            this.f34937II0xO0 = II0xO02;
            xxIXOIIO.II0xO0("Client id is AndroidID: " + this.f34937II0xO0);
            return;
        }
        this.f34937II0xO0 = XO(this.f34938oIX0oI);
        xxIXOIIO.II0xO0("Client id is GUID: " + this.f34937II0xO0);
    }

    @Override // xo.XO
    public void oaidSucc(String str) {
        if (TextUtils.isEmpty(str)) {
            oaidError(new OAIDException("OAID is empty"));
            return;
        }
        this.f34937II0xO0 = str;
        this.f34936I0Io = str;
        xxIXOIIO.II0xO0("Client id is OAID/AAID: " + this.f34937II0xO0);
        II0XooXoX.I0Io(this.f34938oIX0oI).X0o0xo(II0XooXoX.f34908oxoX, this.f34936I0Io);
    }

    public oxoX() {
    }
}
