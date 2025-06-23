package com.octopus.ad.internal;

import O0IxXx.II0XooXoX;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.garmin.fit.O0Xx;
import com.huawei.openalliance.ad.constant.bn;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import jxl.read.biff.oI0IIXIo;
import x0.xII;

/* loaded from: classes11.dex */
public class xoIox {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static int f19050IIX0o = 1000;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static xoIox f19051O0xOxO = null;

    /* renamed from: OxI, reason: collision with root package name */
    public static String f19052OxI = "USED_AD_UNIT_IDS_KEY";

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static String f19053X0IIOO = "OctopusImpl";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static String f19054XI0IXoo = null;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static String f19055XIxXXX0x0 = null;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static String f19056XxX0x0xxx = "";

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static boolean f19057oo0xXOI0I = false;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static long f19058ooXIXxIX = 7200000;

    /* renamed from: xI, reason: collision with root package name */
    public static boolean f19059xI = false;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static int f19060xXxxox0I = 1000;

    /* renamed from: xxX, reason: collision with root package name */
    public static String f19061xxX = "";

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f19064II0xO0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f19066IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f19068Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f19070Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public DisplayMetrics f19071OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f19072X0o0xo;

    /* renamed from: o00, reason: collision with root package name */
    public O0IxXx.II0XooXoX f19074o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f19075oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f19076oIX0oI;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public Context f19082x0xO0oo;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f19062I0Io = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f19080oxoX = false;

    /* renamed from: XO, reason: collision with root package name */
    public HashMap<String, String> f19073XO = new HashMap<>();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public HashSet<String> f19069Oxx0IOOO = new HashSet<>();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public HashSet<String> f19063II0XooXoX = new HashSet<>();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public HashSet<String> f19085xxIXOIIO = new HashSet<>();

    /* renamed from: xoIox, reason: collision with root package name */
    public HashSet<String> f19083xoIox = new HashSet<>();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public HashSet<String> f19067OOXIXo = new HashSet<>();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public HashSet<String> f19078oOoXoXO = new HashSet<>();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public Handler f19079ooOOo0oXI = new oIX0oI(Looper.getMainLooper());

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public Handler f19081x0XOIxOo = null;

    /* renamed from: oO, reason: collision with root package name */
    public HandlerThread f19077oO = null;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f19065IIXOooo = false;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f19084xoXoI = false;

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = new WebView(xoIox.this.f19082x0xO0oo);
            WebView.setWebContentsDebuggingEnabled(false);
            webView.getSettings().setSavePassword(false);
            String userAgentString = webView.getSettings().getUserAgentString();
            if (!TextUtils.isEmpty(userAgentString)) {
                xoIox.this.oOoXoXO(userAgentString);
                xII.ooOOo0oXI(xoIox.this.f19082x0xO0oo, TTDownloadField.TT_USERAGENT, userAgentString);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI extends Handler {
        public oIX0oI(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
        }
    }

    public static xoIox oIX0oI() {
        xoIox xoiox;
        synchronized (xoIox.class) {
            try {
                if (f19051O0xOxO == null) {
                    f19051O0xOxO = new xoIox();
                }
                xoiox = f19051O0xOxO;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xoiox;
    }

    public void I0Io(int i) {
        f19060xXxxox0I = i;
        f19050IIX0o = i;
    }

    public O0IxXx.II0XooXoX II0XooXoX() {
        if (this.f19082x0xO0oo == null) {
            return null;
        }
        O0IxXx.II0XooXoX iI0XooXoX = this.f19074o00;
        if (iI0XooXoX == null) {
            O0IxXx.II0XooXoX O0xOxO2 = O0xOxO();
            this.f19074o00 = O0xOxO2;
            return O0xOxO2;
        }
        return iI0XooXoX;
    }

    public void II0xO0(float f) {
        boolean z;
        if (0.0f <= f && f <= 1.0f) {
            z = true;
        } else {
            z = false;
        }
        x0XOIxOo.I0Io(z, "The app volume must be a value between 0 and 1 inclusive.");
        x0XOIxOo.II0xO0(f19055XIxXXX0x0, "Octopus.initialize() must be called prior to setting the app volume.");
        this.f19068Oo = f;
    }

    public float IIXOooo() {
        return Math.max(this.f19070Oxx0xo, this.f19075oI0IIXIo);
    }

    public String IXxxXO() {
        String oIX0oI2 = o0IXXIx.I0Io.oIX0oI("aHR0cDovL3N2LmFkaW50bC5jbg==");
        if (TextUtils.isEmpty(oIX0oI2)) {
            return "";
        }
        if (this.f19062I0Io) {
            return oIX0oI2.replace("http:", "https:");
        }
        return oIX0oI2;
    }

    public final O0IxXx.II0XooXoX O0xOxO() {
        Context context = this.f19082x0xO0oo;
        if (context == null) {
            return null;
        }
        return new II0XooXoX.II0xO0(context).oIX0oI(O0Xx.f12382xxX).II0xO0();
    }

    public String OOXIXo() {
        return f19055XIxXXX0x0;
    }

    public String Oo() {
        if (TextUtils.isEmpty(this.f19072X0o0xo)) {
            return XI0IXoo();
        }
        return this.f19072X0o0xo;
    }

    public boolean OxI() {
        return f19059xI;
    }

    public void Oxx0IOOO(boolean z) {
        x0XOIxOo.II0xO0(f19055XIxXXX0x0, "Octopus.initialize() must be called prior to setting the app volume.");
        this.f19066IXxxXO = z;
    }

    public String Oxx0xo() {
        if (!TextUtils.isEmpty(f19054XI0IXoo)) {
            return f19054XI0IXoo;
        }
        String oIX0oI2 = o0IXXIx.I0Io.oIX0oI("aHR0cDovL3N2LmFkaW50bC5jbg==");
        if (TextUtils.isEmpty(oIX0oI2)) {
            return "";
        }
        if (this.f19062I0Io) {
            return oIX0oI2.replace("http:", "https:");
        }
        return oIX0oI2;
    }

    public float OxxIIOOXO() {
        return this.f19075oI0IIXIo;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public final void X0IIOO() {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Throwable unused) {
        }
    }

    public void X0o0xo(String str) {
        this.f19076oIX0oI = str;
    }

    public final String XI0IXoo() {
        String property;
        try {
            property = WebSettings.getDefaultUserAgent(x0xO0oo());
        } catch (Exception unused) {
            property = System.getProperty("http.agent");
        }
        StringBuilder sb = new StringBuilder();
        if (property != null) {
            int length = property.length();
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                }
            }
        }
        return sb.toString();
    }

    public void XO(String str, boolean z) {
    }

    public HashSet<String> o00() {
        return this.f19078oOoXoXO;
    }

    public float oI0IIXIo() {
        return this.f19070Oxx0xo;
    }

    public String oO() {
        return this.f19064II0xO0;
    }

    public void oOoXoXO(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f19072X0o0xo = str;
        }
    }

    public void ooOOo0oXI(boolean z) {
        f19059xI = z;
    }

    public void oxoX(Context context, String str, String str2) {
        synchronized (xoIox.class) {
            try {
                if (context != null) {
                    Log.i("octopus", "SDK_VERSION:1.5.9.16");
                    this.f19082x0xO0oo = context.getApplicationContext();
                    try {
                        if (!"OctopusGroup".equals(str2)) {
                            o0IXXIx.oxoX.oIX0oI().II0xO0(this.f19082x0xO0oo);
                        }
                        o0IXXIx.xoIox.II0xO0().oxoX().execute(new o0IXXIx.II0xO0(this.f19082x0xO0oo));
                        Long l = (Long) xII.oxoX(this.f19082x0xO0oo, "duration", Long.valueOf(oI0IIXIo.f28349Oxx0xo));
                        String str3 = (String) xII.oxoX(this.f19082x0xO0oo, "version", "1686041703212");
                        Long l2 = (Long) xII.oxoX(this.f19082x0xO0oo, "lastReqTime", 0L);
                        if (l != null && str3 != null && l2 != null && o0IXXIx.x0XOIxOo.II0XooXoX() - l2.longValue() > l.longValue()) {
                            new II0XooXoX(o0IXXIx.I0Io.oIX0oI("aHR0cDovL3Nka2NmZy5hZGludGwuY24vc2RrL3BrZ0NvbmZpZz92ZXJzaW9uPQ==") + str3).XO();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!oOoIIO0.x0XOIxOo.xoIox()) {
                        oXxOI0oIx.II0xO0.oxoX((Application) this.f19082x0xO0oo);
                    }
                    com.octopus.ad.internal.utilities.oIX0oI.XI0IXoo(this.f19082x0xO0oo);
                    f19055XIxXXX0x0 = str;
                    try {
                        try {
                            String OOXIXo2 = xII.OOXIXo(this.f19082x0xO0oo, TTDownloadField.TT_USERAGENT);
                            if (!TextUtils.isEmpty(OOXIXo2)) {
                                oOoXoXO(OOXIXo2);
                            } else {
                                IO0XoXxO.oIX0oI.I0Io(new II0xO0());
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    DisplayMetrics displayMetrics = this.f19082x0xO0oo.getResources().getDisplayMetrics();
                    this.f19071OxxIIOOXO = displayMetrics;
                    int i = displayMetrics.widthPixels;
                    int i2 = displayMetrics.heightPixels;
                    if (i < i2) {
                        this.f19070Oxx0xo = i / 720.0f;
                        this.f19075oI0IIXIo = i2 / 1280.0f;
                    } else {
                        this.f19070Oxx0xo = i2 / 720.0f;
                        this.f19075oI0IIXIo = i / 1280.0f;
                    }
                    if (!this.f19084xoXoI) {
                        IO0XoXxO.XO.oIX0oI(this.f19082x0xO0oo).II0xO0(new I0Io());
                    }
                    this.f19084xoXoI = true;
                    if (Build.VERSION.SDK_INT >= 28) {
                        X0IIOO();
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String x0XOIxOo() {
        return this.f19076oIX0oI;
    }

    public Context x0xO0oo() {
        return this.f19082x0xO0oo;
    }

    public void xoIox(String str) {
        this.f19064II0xO0 = str;
    }

    public DisplayMetrics xoXoI() {
        return this.f19071OxxIIOOXO;
    }

    public String xxIXOIIO(boolean z) {
        String str = "/api/zysdk?isEncrypt=2";
        if (!TextUtils.isEmpty(f19054XI0IXoo)) {
            Boolean bool = (Boolean) xII.xxIXOIIO(this.f19082x0xO0oo, "encrypt", Boolean.TRUE);
            if (bool != null && !bool.booleanValue()) {
                if (!z) {
                    str = "/api/zysdk?isEncrypt=0";
                } else {
                    str = "/api/zysdksd?isEncrypt=0";
                }
            } else if (z) {
                str = "/api/zysdksd?isEncrypt=2";
            }
            return f19054XI0IXoo + str;
        }
        Boolean bool2 = (Boolean) xII.xxIXOIIO(this.f19082x0xO0oo, "encrypt", Boolean.TRUE);
        if (bool2 != null && !bool2.booleanValue()) {
            if (!z) {
                str = "/api/zysdk?isEncrypt=0";
            } else {
                str = "/api/zysdksd?isEncrypt=0";
            }
        } else if (z) {
            str = "/api/zysdksd?isEncrypt=2";
        }
        return IXxxXO() + str;
    }

    /* loaded from: classes11.dex */
    public class I0Io implements IO0XoXxO.X0o0xo {
        public I0Io() {
        }

        @Override // IO0XoXxO.X0o0xo
        public void a(long j, long j2) {
            o0IXXIx.II0XooXoX.oIX0oI("octopus", "在线时长:" + (j2 - j));
            xII.ooOOo0oXI(xoIox.this.f19082x0xO0oo, bn.f.g, Long.valueOf(j));
            xII.ooOOo0oXI(xoIox.this.f19082x0xO0oo, "endTime", Long.valueOf(j2));
        }

        @Override // IO0XoXxO.X0o0xo
        public void a() {
            o0IXXIx.II0XooXoX.oIX0oI("octopus", "上报活跃量");
        }
    }
}
