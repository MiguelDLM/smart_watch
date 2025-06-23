package x0;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.octopus.ad.internal.utilities.DeviceInfo;
import com.octopus.ad.internal.utilities.oIX0oI;
import com.octopus.ad.model.e;
import o0IXXIx.X0o0xo;
import o0IXXIx.x0XOIxOo;

/* loaded from: classes11.dex */
public class XxX0x0xxx {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static int f33734II0xO0 = 2;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static String f33735oIX0oI = "ethernet";

    public static void I0Io(Context context, DeviceInfo deviceInfo) {
        String str = (String) xII.oxoX(context, DeviceInfo.f18664oI0IIXIo, "");
        deviceInfo.f18674oIX0oI = str;
        if (TextUtils.isEmpty(str)) {
            deviceInfo.I0Io(context);
        }
    }

    public static void II0xO0(Context context, DeviceInfo deviceInfo) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        deviceInfo.f18682xxIXOIIO = displayMetrics.widthPixels + "_" + displayMetrics.heightPixels;
        float f = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        double sqrt = Math.sqrt((double) ((f2 * f2) + (f * f)));
        deviceInfo.f18681xoIox = String.format("%.2f", Double.valueOf(Math.round(sqrt * r2) / Math.pow(10.0d, (double) f33734II0xO0)));
    }

    public static void oIX0oI(Context context, DeviceInfo deviceInfo) {
        try {
            if (((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getPhoneType() != 0) {
                deviceInfo.f18672X0o0xo = e.b.DEVICE_PHONE;
            } else {
                deviceInfo.f18672X0o0xo = e.b.DEVICE_FLAT;
            }
        } catch (SecurityException unused) {
            oIX0oI.oxoX(oIX0oI.f18685II0xO0, "No permission to access imei");
            int i = context.getResources().getConfiguration().screenLayout & 15;
            if (i != 4 && i != 3) {
                deviceInfo.f18672X0o0xo = e.b.DEVICE_PHONE;
            } else {
                deviceInfo.f18672X0o0xo = e.b.DEVICE_FLAT;
            }
        }
        deviceInfo.f18666I0Io = x0XOIxOo.II0xO0();
    }

    public static void oxoX(Context context) {
        DeviceInfo oxoX2 = DeviceInfo.oxoX();
        if (!TextUtils.isEmpty(oxoX2.f18674oIX0oI)) {
            return;
        }
        try {
            oIX0oI(context, oxoX2);
            II0xO0(context, oxoX2);
            I0Io(context, oxoX2);
            oxoX2.X0o0xo(context);
            if (!TextUtils.isEmpty(oxoX2.f18667II0XooXoX)) {
                if (!oxoX2.f18667II0XooXoX.equalsIgnoreCase("HUAWEI")) {
                    if (oxoX2.f18667II0XooXoX.equalsIgnoreCase("HONOR")) {
                    }
                }
                oxoX2.f18679x0XOIxOo = x0XOIxOo.Oxx0xo(context);
                oxoX2.f18675oO = x0XOIxOo.oI0IIXIo(context);
            }
            oxoX2.f18680x0xO0oo = X0o0xo.oxoX(context, "com.tencent.mm");
            oxoX2.f18670Oo = x0XOIxOo.Oxx0IOOO(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
