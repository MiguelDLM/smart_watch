package oXxOI0oIx;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.kuaishou.weapon.p0.g;
import com.octopus.ad.utils.a.e;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;
import oOoIIO0.x0XOIxOo;
import oXIoO.oOoXoXO;

/* loaded from: classes11.dex */
public final class oIX0oI implements I0Io {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static boolean f32177X0o0xo = true;

    /* renamed from: XO, reason: collision with root package name */
    public static String f32178XO = "";

    /* renamed from: I0Io, reason: collision with root package name */
    public String f32179I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f32180II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Application f32181oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f32182oxoX;

    /* loaded from: classes11.dex */
    public static class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final oIX0oI f32183oIX0oI = new oIX0oI(null);
    }

    public /* synthetic */ oIX0oI(C1134oIX0oI c1134oIX0oI) {
        this();
    }

    public static String I0Io(Context context) {
        int checkSelfPermission;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            X0o0xo.oIX0oI("IMEI/MEID not allowed on Android 10+");
            return "";
        }
        if (context == null) {
            return "";
        }
        if (i >= 23) {
            checkSelfPermission = context.checkSelfPermission(g.c);
            if (checkSelfPermission != 0) {
                X0o0xo.oIX0oI("android.permission.READ_PHONE_STATE not granted");
                return "";
            }
        }
        return Oo(context);
    }

    public static void II0XooXoX(Context context, I0Io i0Io) {
        oOoXoXO.oIX0oI(context).oIX0oI(i0Io);
    }

    public static String II0xO0() {
        String str = II0xO0.f32183oIX0oI.f32180II0xO0;
        if (str == null) {
            return "";
        }
        return str;
    }

    public static File IIXOooo(Context context) {
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

    public static String IXxxXO() {
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
            X0o0xo.oIX0oI(e);
            return "";
        } catch (Exception e2) {
            X0o0xo.oIX0oI(e2);
            return "";
        }
    }

    public static void OOXIXo(Context context, String str) {
        if (context == null) {
            return;
        }
        File IIXOooo2 = IIXOooo(context);
        if (IIXOooo2 == null) {
            X0o0xo.oIX0oI("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(IIXOooo2));
            try {
                if (!IIXOooo2.exists()) {
                    IIXOooo2.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                X0o0xo.oIX0oI("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e) {
            X0o0xo.oIX0oI(e);
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String Oo(Context context) {
        return "";
    }

    public static void Oxx0IOOO(Context context, String str) {
        boolean canWrite;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            canWrite = Settings.System.canWrite(context);
            if (!canWrite) {
                X0o0xo.oIX0oI("android.permission.WRITE_SETTINGS not granted");
                return;
            }
        }
        try {
            Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            X0o0xo.oIX0oI("Save uuid to system settings: " + str);
        } catch (Exception e) {
            X0o0xo.oIX0oI(e);
        }
    }

    public static String Oxx0xo(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        X0o0xo.oIX0oI("Get uuid from system settings: " + string);
        return string;
    }

    public static String OxxIIOOXO(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        File IIXOooo2 = IIXOooo(context);
        if (IIXOooo2 != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(IIXOooo2));
                try {
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e) {
                X0o0xo.oIX0oI(e);
            }
        }
        X0o0xo.oIX0oI("Get uuid from external storage: " + str);
        return str;
    }

    public static void XO(Application application) {
        if (application == null) {
            return;
        }
        oIX0oI oix0oi = II0xO0.f32183oIX0oI;
        oix0oi.f32181oIX0oI = application;
        II0XooXoX(application, oix0oi);
        oOoXoXO(application, new C1134oIX0oI());
    }

    public static String oI0IIXIo() {
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

    public static void oO(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString(Constant.MAP_KEY_UUID, str).apply();
        X0o0xo.oIX0oI("Save uuid to shared preferences: " + str);
    }

    public static void oOoXoXO(Context context, I0Io i0Io) {
        oOoXoXO.II0xO0(context).oIX0oI(i0Io);
    }

    public static String ooOOo0oXI() {
        String str = II0xO0.f32183oIX0oI.f32179I0Io;
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String oxoX(String str, String str2) {
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
            X0o0xo.oIX0oI(e);
            return "";
        }
    }

    public static String x0XOIxOo(Context context) {
        String Oxx0xo2 = Oxx0xo(context);
        if (TextUtils.isEmpty(Oxx0xo2)) {
            Oxx0xo2 = OxxIIOOXO(context);
        }
        if (TextUtils.isEmpty(Oxx0xo2)) {
            Oxx0xo2 = xoXoI(context);
        }
        if (TextUtils.isEmpty(Oxx0xo2)) {
            String uuid = UUID.randomUUID().toString();
            X0o0xo.oIX0oI("Generate uuid by random: " + uuid);
            oO(context, uuid);
            Oxx0IOOO(context, uuid);
            OOXIXo(context, uuid);
            return uuid;
        }
        return Oxx0xo2;
    }

    public static String x0xO0oo() {
        String str = II0xO0.f32183oIX0oI.f32182oxoX;
        if (str == null) {
            return "";
        }
        return str;
    }

    @SuppressLint({"HardwareIds"})
    public static String xoIox(Context context) {
        if (f32177X0o0xo) {
            f32177X0o0xo = false;
            if (x0XOIxOo.oIX0oI() == null || x0XOIxOo.oIX0oI().isCanUsePhoneState()) {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                f32178XO = string;
                if (string == null) {
                    f32178XO = "";
                }
            }
        }
        return f32178XO;
    }

    public static String xoXoI(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString(Constant.MAP_KEY_UUID, "");
        X0o0xo.oIX0oI("Get uuid from shared preferences: " + string);
        return string;
    }

    public static String xxIXOIIO() {
        return oxoX(II0xO0(), "MD5");
    }

    @Override // oXxOI0oIx.I0Io
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a(new e("OAID is empty"));
            return;
        }
        this.f32180II0xO0 = str;
        this.f32179I0Io = str;
        X0o0xo.oIX0oI("Client id is OAID: " + this.f32180II0xO0);
    }

    public oIX0oI() {
    }

    /* renamed from: oXxOI0oIx.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1134oIX0oI implements I0Io {
        public C1134oIX0oI() {
        }

        @Override // oXxOI0oIx.I0Io
        public void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                oIX0oI.this.f32182oxoX = str;
            } else {
                a(new e("GAID is empty"));
            }
        }

        @Override // oXxOI0oIx.I0Io
        public void a(Exception exc) {
            X0o0xo.oIX0oI("onGAIDGetError: " + exc.getMessage());
            oIX0oI oix0oi = oIX0oI.this;
            oix0oi.f32182oxoX = oIX0oI.x0XOIxOo(oix0oi.f32181oIX0oI);
        }
    }

    @Override // oXxOI0oIx.I0Io
    public void a(Exception exc) {
        X0o0xo.oIX0oI("onOAIDGetError: " + exc.getMessage());
        String xoIox2 = xoIox(this.f32181oIX0oI);
        if (!TextUtils.isEmpty(xoIox2)) {
            this.f32180II0xO0 = xoIox2;
            this.f32179I0Io = xxIXOIIO();
            X0o0xo.oIX0oI("Client id is AndroidID: " + this.f32180II0xO0);
            return;
        }
        String I0Io2 = I0Io(this.f32181oIX0oI);
        if (!TextUtils.isEmpty(I0Io2)) {
            this.f32180II0xO0 = I0Io2;
            this.f32179I0Io = xxIXOIIO();
            X0o0xo.oIX0oI("Client id is IMEI/MEID: " + this.f32180II0xO0);
            return;
        }
        String IXxxXO2 = IXxxXO();
        if (!TextUtils.isEmpty(IXxxXO2)) {
            this.f32180II0xO0 = IXxxXO2;
            this.f32179I0Io = xxIXOIIO();
            X0o0xo.oIX0oI("Client id is WidevineID: " + this.f32180II0xO0);
            return;
        }
        String oI0IIXIo2 = oI0IIXIo();
        if (!TextUtils.isEmpty(oI0IIXIo2)) {
            this.f32180II0xO0 = oI0IIXIo2;
            this.f32179I0Io = xxIXOIIO();
            X0o0xo.oIX0oI("Client id is PseudoID: " + this.f32180II0xO0);
            return;
        }
        this.f32180II0xO0 = x0XOIxOo(this.f32181oIX0oI);
        this.f32179I0Io = xxIXOIIO();
        X0o0xo.oIX0oI("Client id is GUID: " + this.f32180II0xO0);
    }
}
