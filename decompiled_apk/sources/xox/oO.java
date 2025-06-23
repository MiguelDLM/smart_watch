package xox;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.open.utils.oIX0oI;
import java.lang.reflect.Method;
import xIxooxXX.II0xO0;
import xoX.OOXIXo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static Method f35184I0Io = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static Class<?> f35185II0xO0 = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static boolean f35186Oxx0IOOO = false;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static Method f35187X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static Method f35188XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static Class<?> f35189oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static Method f35190oxoX;

    public static void I0Io(Context context, II0xO0 iI0xO0) {
        try {
            if (II0xO0(context, iI0xO0)) {
                f35188XO.invoke(f35189oIX0oI, Boolean.TRUE);
            } else {
                f35188XO.invoke(f35189oIX0oI, Boolean.FALSE);
            }
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("OpenConfig", "checkStatStatus exception: " + e.toString());
        }
    }

    public static boolean II0xO0(Context context, II0xO0 iI0xO0) {
        return oIX0oI.oxoX(context, iI0xO0.X0o0xo()).xoIox("Common_ta_enable");
    }

    public static void X0o0xo(Context context, II0xO0 iI0xO0) {
        if (!TextUtils.isEmpty(iI0xO0.II0XooXoX())) {
            OOXIXo.oIX0oI().oxoX(iI0xO0.II0XooXoX(), iI0xO0.X0o0xo(), "2", "1", "11", "0", "0", "0");
        }
        if (!f35186Oxx0IOOO) {
            return;
        }
        I0Io(context, iI0xO0);
        if (iI0xO0.II0XooXoX() != null) {
            try {
                f35184I0Io.invoke(f35185II0xO0, context, iI0xO0.II0XooXoX());
            } catch (Exception e) {
                xxIXOIIO.II0XooXoX("OpenConfig", "reportQQ exception: " + e.toString());
            }
        }
    }

    public static void oIX0oI(Context context, II0xO0 iI0xO0, String str, String... strArr) {
        if (!f35186Oxx0IOOO) {
            return;
        }
        I0Io(context, iI0xO0);
        try {
            f35190oxoX.invoke(f35185II0xO0, context, str, strArr);
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("OpenConfig", "trackCustomEvent exception: " + e.toString());
        }
    }

    public static void oxoX(Context context, II0xO0 iI0xO0) {
        String str = "Aqc" + iI0xO0.X0o0xo();
        try {
            f35189oIX0oI = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f35185II0xO0 = cls;
            f35184I0Io = cls.getMethod("reportQQ", Context.class, String.class);
            f35190oxoX = f35185II0xO0.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls2 = f35185II0xO0;
            Class<?> cls3 = Integer.TYPE;
            f35187X0o0xo = cls2.getMethod("commitEvents", Context.class, cls3);
            Class<?> cls4 = f35189oIX0oI;
            Class<?> cls5 = Boolean.TYPE;
            f35188XO = cls4.getMethod("setEnableStatService", cls5);
            I0Io(context, iI0xO0);
            f35189oIX0oI.getMethod("setAutoExceptionCaught", cls5).invoke(f35189oIX0oI, Boolean.FALSE);
            f35189oIX0oI.getMethod("setEnableSmartReporting", cls5).invoke(f35189oIX0oI, Boolean.TRUE);
            f35189oIX0oI.getMethod("setSendPeriodMinutes", cls3).invoke(f35189oIX0oI, 1440);
            Class<?> cls6 = Class.forName("com.tencent.stat.StatReportStrategy");
            f35189oIX0oI.getMethod("setStatSendStrategy", cls6).invoke(f35189oIX0oI, cls6.getField("PERIOD").get(null));
            f35185II0xO0.getMethod("startStatService", Context.class, String.class, String.class).invoke(f35185II0xO0, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null));
            f35186Oxx0IOOO = true;
        } catch (Exception e) {
            xxIXOIIO.II0XooXoX("OpenConfig", "start4QQConnect exception: " + e.toString());
        }
    }
}
