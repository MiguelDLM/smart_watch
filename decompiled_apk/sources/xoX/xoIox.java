package xoX;

import XxXX.X0o0xo;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import kotlin.text.XIxXXX0x0;

/* loaded from: classes13.dex */
public class xoIox {

    /* renamed from: I0Io, reason: collision with root package name */
    public static String f35143I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static String f35144II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static String f35145X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static String f35146oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static String f35147oxoX;

    public static String I0Io() {
        return Locale.getDefault().getLanguage();
    }

    public static String II0xO0(Context context) {
        if (!TextUtils.isEmpty(f35146oIX0oI)) {
            return f35146oIX0oI;
        }
        if (context == null) {
            return "";
        }
        f35146oIX0oI = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f35146oIX0oI = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f35146oIX0oI;
    }

    public static String Oxx0IOOO(Context context) {
        try {
            if (f35145X0o0xo == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb = new StringBuilder();
                sb.append("imei=");
                sb.append(oxoX(context));
                sb.append(XIxXXX0x0.f29558oxoX);
                sb.append("model=");
                sb.append(Build.MODEL);
                sb.append(XIxXXX0x0.f29558oxoX);
                sb.append("os=");
                sb.append(Build.VERSION.RELEASE);
                sb.append(XIxXXX0x0.f29558oxoX);
                sb.append("apilevel=");
                sb.append(Build.VERSION.SDK_INT);
                sb.append(XIxXXX0x0.f29558oxoX);
                String II0xO02 = xxIXOIIO.II0xO0(context);
                if (II0xO02 == null) {
                    II0xO02 = "";
                }
                sb.append("network=");
                sb.append(II0xO02);
                sb.append(XIxXXX0x0.f29558oxoX);
                sb.append("sdcard=");
                sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append(XIxXXX0x0.f29558oxoX);
                sb.append("display=");
                sb.append(displayMetrics.widthPixels);
                sb.append('*');
                sb.append(displayMetrics.heightPixels);
                sb.append(XIxXXX0x0.f29558oxoX);
                sb.append("manu=");
                sb.append(Build.MANUFACTURER);
                sb.append("&");
                sb.append("wifi=");
                sb.append(xxIXOIIO.X0o0xo(context));
                f35145X0o0xo = sb.toString();
            }
            return f35145X0o0xo;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String X0o0xo(Context context) {
        String str = f35143I0Io;
        if (str != null && str.length() > 0) {
            return f35143I0Io;
        }
        if (context == null) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            f35143I0Io = simSerialNumber;
            return simSerialNumber;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String XO(Context context) {
        String str = f35147oxoX;
        if (str != null && str.length() > 0) {
            return f35147oxoX;
        }
        if (context == null) {
            return "";
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            f35147oxoX = string;
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String oIX0oI() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            Context oIX0oI2 = X0o0xo.oIX0oI();
            if (oIX0oI2 == null || (wifiManager = (WifiManager) oIX0oI2.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "";
            }
            return connectionInfo.getMacAddress();
        } catch (SecurityException e) {
            xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.MobileInfoUtil", "getLocalMacAddress>>>", e);
            return "";
        }
    }

    public static String oxoX(Context context) {
        String str = f35144II0xO0;
        if (str != null && str.length() > 0) {
            return f35144II0xO0;
        }
        if (context == null) {
            return "";
        }
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            f35144II0xO0 = deviceId;
            return deviceId;
        } catch (Exception unused) {
            return "";
        }
    }
}
