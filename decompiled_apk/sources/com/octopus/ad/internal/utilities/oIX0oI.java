package com.octopus.ad.internal.utilities;

import android.content.Context;
import com.octopus.ad.internal.utilities.HaoboLogListener;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes11.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final boolean f18700oIX0oI = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static String f18685II0xO0 = "OCTOPUS_SDK";

    /* renamed from: I0Io, reason: collision with root package name */
    public static String f18683I0Io = f18685II0xO0 + "-MEDIATION";

    /* renamed from: oxoX, reason: collision with root package name */
    public static String f18704oxoX = f18685II0xO0 + "-INTERFACE";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static String f18696X0o0xo = f18685II0xO0 + "-REQUEST";

    /* renamed from: XO, reason: collision with root package name */
    public static String f18697XO = f18685II0xO0 + "-RESPONSE";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static String f18692Oxx0IOOO = f18685II0xO0 + "-PB";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static String f18684II0XooXoX = f18685II0xO0 + "-XML";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static String f18709xxIXOIIO = f18685II0xO0 + "-JSON";

    /* renamed from: xoIox, reason: collision with root package name */
    public static String f18707xoIox = f18685II0xO0 + "-JS";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static String f18689OOXIXo = f18685II0xO0 + "-MRAID";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static String f18702oOoXoXO = f18685II0xO0 + "-APPBROWSER";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static String f18703ooOOo0oXI = f18685II0xO0 + "-NATIVE";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static String f18705x0XOIxOo = f18685II0xO0 + "-VIDEO";

    /* renamed from: oO, reason: collision with root package name */
    public static String f18701oO = f18685II0xO0 + "-FIX";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static String f18706x0xO0oo = f18685II0xO0 + "-PINGER";

    /* renamed from: Oo, reason: collision with root package name */
    public static String f18690Oo = f18685II0xO0 + "-LRUDISKUSAGE";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static String f18687IXxxXO = f18685II0xO0 + "-CACHESERVER";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static String f18693Oxx0xo = f18685II0xO0 + "-URLSOURCE";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static String f18699oI0IIXIo = f18685II0xO0 + "-PROXYCACHE";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static String f18694OxxIIOOXO = f18685II0xO0 + "-PROXYCACHEUTILS";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static String f18686IIXOooo = f18685II0xO0 + "-STORAGEUTILS";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static SoftReference<Context> f18708xoXoI = new SoftReference<>(null);

    /* renamed from: o00, reason: collision with root package name */
    public static String f18698o00 = "";

    /* renamed from: OxI, reason: collision with root package name */
    public static String f18691OxI = "";

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static String f18688O0xOxO = "";

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final ArrayList<HaoboLogListener> f18695X0IIOO = new ArrayList<>();

    public static void I0Io(String str, String str2, Throwable th) {
        if (str2 != null) {
            O0xOxO(HaoboLogListener.LOG_LEVEL.D, str, str2, th);
            o00(str, str2, 4, th);
        }
    }

    public static synchronized String II0XooXoX() {
        String str;
        synchronized (oIX0oI.class) {
            str = f18691OxI;
        }
        return str;
    }

    public static void II0xO0(String str, String str2) {
        if (str2 != null) {
            OxI(HaoboLogListener.LOG_LEVEL.D, str, str2);
            o00(str, str2, 4, null);
        }
    }

    public static synchronized boolean IIX0o(HaoboLogListener haoboLogListener) {
        boolean z;
        synchronized (oIX0oI.class) {
            if (haoboLogListener != null) {
                if (f18695X0IIOO.remove(haoboLogListener)) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public static void IIXOooo(String str, String str2) {
        if (str2 != null) {
            OxI(HaoboLogListener.LOG_LEVEL.I, str, str2);
            o00(str, str2, 4, null);
        }
    }

    public static String IXxxXO(int i, String str, int i2, String str2) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, str, Integer.valueOf(i2), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized void O0xOxO(HaoboLogListener.LOG_LEVEL log_level, String str, String str2, Throwable th) {
        synchronized (oIX0oI.class) {
            try {
                Iterator<HaoboLogListener> it = f18695X0IIOO.iterator();
                while (it.hasNext()) {
                    HaoboLogListener next = it.next();
                    if (log_level.ordinal() >= next.oIX0oI().ordinal()) {
                        if (th != null) {
                            next.I0Io(log_level, str, str2, th);
                        } else {
                            next.II0xO0(log_level, str, str2);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String OOXIXo(int i, int i2, int i3, int i4, int i5) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String Oo(int i, String str, int i2) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, str, Integer.valueOf(i2));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized void OxI(HaoboLogListener.LOG_LEVEL log_level, String str, String str2) {
        synchronized (oIX0oI.class) {
            O0xOxO(log_level, str, str2, null);
        }
    }

    public static synchronized String Oxx0IOOO() {
        String str;
        synchronized (oIX0oI.class) {
            str = f18698o00;
        }
        return str;
    }

    public static String Oxx0xo(int i, String str, String str2) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String OxxIIOOXO(int i, boolean z, int i2) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Boolean.valueOf(z), Integer.valueOf(i2));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized boolean X0IIOO(HaoboLogListener haoboLogListener) {
        boolean z;
        synchronized (oIX0oI.class) {
            if (haoboLogListener != null) {
                if (f18695X0IIOO.add(haoboLogListener)) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public static void X0o0xo(String str, String str2, Throwable th) {
        if (str2 != null) {
            O0xOxO(HaoboLogListener.LOG_LEVEL.E, str, str2, th);
            o00(str, str2, 6, th);
        }
    }

    public static void XI0IXoo(Context context) {
        f18708xoXoI = new SoftReference<>(context);
    }

    public static synchronized void XIxXXX0x0(String str) {
        synchronized (oIX0oI.class) {
            f18688O0xOxO = str;
        }
    }

    public static synchronized String XO() {
        String str;
        synchronized (oIX0oI.class) {
            str = f18688O0xOxO;
        }
        return str;
    }

    public static synchronized void XxX0x0xxx(String str) {
        synchronized (oIX0oI.class) {
            f18691OxI = str;
        }
    }

    public static void o00(String str, String str2, int i, Throwable th) {
    }

    public static String oI0IIXIo(int i, boolean z) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized void oIX0oI() {
        synchronized (oIX0oI.class) {
            f18691OxI = "";
        }
    }

    public static String oO(int i, long j) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Long.valueOf(j));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String oOoXoXO(int i, int i2, int i3, int i4, int i5, String str, boolean z) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void oo(String str, String str2, Throwable th) {
        if (str2 != null) {
            O0xOxO(HaoboLogListener.LOG_LEVEL.W, str, str2, th);
            o00(str, str2, 5, th);
        }
    }

    public static void oo0xXOI0I(String str, String str2) {
        if (str2 != null) {
            OxI(HaoboLogListener.LOG_LEVEL.W, str, str2);
            o00(str, str2, 5, null);
        }
    }

    public static String ooOOo0oXI(int i, int i2, String str) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void ooXIXxIX(String str, String str2) {
        if (str2 != null) {
            OxI(HaoboLogListener.LOG_LEVEL.V, str, str2);
            o00(str, str2, 4, null);
        }
    }

    public static void oxoX(String str, String str2) {
        if (str2 != null) {
            OxI(HaoboLogListener.LOG_LEVEL.E, str, str2);
            o00(str, str2, 6, null);
        }
    }

    public static String x0XOIxOo(int i, int i2, String str, String str2) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String x0xO0oo(int i, String str) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void xI(String str, String str2, Throwable th) {
        if (str2 != null) {
            O0xOxO(HaoboLogListener.LOG_LEVEL.V, str, str2, th);
            o00(str, str2, 4, th);
        }
    }

    public static synchronized void xXxxox0I() {
        synchronized (oIX0oI.class) {
            f18695X0IIOO.clear();
        }
    }

    public static String xoIox(int i, int i2, int i3) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i, Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void xoXoI(String str, String str2, Throwable th) {
        if (str2 != null) {
            O0xOxO(HaoboLogListener.LOG_LEVEL.I, str, str2, th);
            o00(str, str2, 4, th);
        }
    }

    public static String xxIXOIIO(int i) {
        try {
            Context context = f18708xoXoI.get();
            if (context == null) {
                return null;
            }
            return context.getString(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized void xxX(String str) {
        synchronized (oIX0oI.class) {
            f18698o00 = str;
        }
    }
}
