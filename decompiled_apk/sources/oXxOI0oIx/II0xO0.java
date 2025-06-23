package oXxOI0oIx;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import oOoIIO0.x0XOIxOo;
import x0.xII;

/* loaded from: classes11.dex */
public final class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static volatile String f32165I0Io = null;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static volatile String f32166II0XooXoX = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static volatile String f32167II0xO0 = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static volatile String f32168Oxx0IOOO = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static volatile String f32169X0o0xo = "";

    /* renamed from: XO, reason: collision with root package name */
    public static volatile String f32170XO = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static volatile boolean f32171oIX0oI = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public static volatile String f32172oxoX = null;

    /* renamed from: xoIox, reason: collision with root package name */
    public static boolean f32173xoIox = true;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static volatile String f32174xxIXOIIO;

    /* renamed from: oXxOI0oIx.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1133II0xO0 implements I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Context f32175oIX0oI;

        public C1133II0xO0(Context context) {
            this.f32175oIX0oI = context;
        }

        @Override // oXxOI0oIx.I0Io
        public void a(String str) {
            String unused = II0xO0.f32174xxIXOIIO = str;
        }

        @Override // oXxOI0oIx.I0Io
        public void a(Exception exc) {
            String unused = II0xO0.f32174xxIXOIIO = II0xO0.xxIXOIIO(this.f32175oIX0oI);
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements I0Io {
        @Override // oXxOI0oIx.I0Io
        public void a(String str) {
            String unused = II0xO0.f32172oxoX = str;
        }

        @Override // oXxOI0oIx.I0Io
        public void a(Exception exc) {
            String unused = II0xO0.f32172oxoX = II0xO0.oIX0oI();
        }
    }

    public static String II0XooXoX(Context context) {
        if (f32173xoIox) {
            f32173xoIox = false;
            if (x0XOIxOo.oIX0oI() == null || x0XOIxOo.oIX0oI().isCanUsePhoneState()) {
                synchronized (II0xO0.class) {
                    f32169X0o0xo = oXxOI0oIx.oIX0oI.xoIox(context);
                }
            }
        }
        return f32169X0o0xo;
    }

    public static String II0xO0(Context context) {
        if (x0XOIxOo.oIX0oI() != null && !x0XOIxOo.oIX0oI().isCanUsePhoneState()) {
            f32165I0Io = x0XOIxOo.oIX0oI().getImei();
        } else if (f32165I0Io == null) {
            synchronized (II0xO0.class) {
                try {
                    if (f32165I0Io == null) {
                        f32165I0Io = oXxOI0oIx.oIX0oI.I0Io(context);
                    }
                } finally {
                }
            }
        }
        if (f32165I0Io == null) {
            f32165I0Io = "";
        }
        return f32165I0Io;
    }

    public static String Oxx0IOOO(Context context) {
        f32174xxIXOIIO = xII.OOXIXo(context, "gaid");
        if (TextUtils.isEmpty(f32174xxIXOIIO)) {
            synchronized (II0xO0.class) {
                try {
                    if (TextUtils.isEmpty(f32174xxIXOIIO)) {
                        f32174xxIXOIIO = oXxOI0oIx.oIX0oI.x0xO0oo();
                        if (TextUtils.isEmpty(f32174xxIXOIIO)) {
                            oXxOI0oIx.oIX0oI.II0XooXoX(context, new C1133II0xO0(context));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (f32174xxIXOIIO == null) {
                f32174xxIXOIIO = "";
            } else {
                xII.ooOOo0oXI(context, "gaid", f32174xxIXOIIO);
            }
        }
        X0o0xo.II0xO0("Gaid is: " + f32174xxIXOIIO);
        return f32174xxIXOIIO;
    }

    public static String X0o0xo(Context context) {
        f32172oxoX = xII.OOXIXo(context, "oaid");
        if (TextUtils.isEmpty(f32172oxoX)) {
            synchronized (II0xO0.class) {
                try {
                    if (TextUtils.isEmpty(f32172oxoX)) {
                        f32172oxoX = oXxOI0oIx.oIX0oI.ooOOo0oXI();
                        if (TextUtils.isEmpty(f32172oxoX)) {
                            oXxOI0oIx.oIX0oI.II0XooXoX(context, new oIX0oI());
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (f32172oxoX == null) {
                f32172oxoX = "";
            } else {
                xII.ooOOo0oXI(context, "oaid", f32172oxoX);
            }
        }
        X0o0xo.II0xO0("Oaid is: " + f32172oxoX);
        return f32172oxoX;
    }

    public static String oIX0oI() {
        if (TextUtils.isEmpty(f32167II0xO0)) {
            synchronized (II0xO0.class) {
                try {
                    if (TextUtils.isEmpty(f32167II0xO0)) {
                        f32167II0xO0 = oXxOI0oIx.oIX0oI.xxIXOIIO();
                    }
                } finally {
                }
            }
        }
        if (f32167II0xO0 == null) {
            f32167II0xO0 = "";
        }
        return f32167II0xO0;
    }

    public static void oxoX(Application application) {
        if (f32171oIX0oI) {
            return;
        }
        synchronized (II0xO0.class) {
            try {
                if (!f32171oIX0oI) {
                    oXxOI0oIx.oIX0oI.XO(application);
                    f32171oIX0oI = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String xxIXOIIO(Context context) {
        if (f32166II0XooXoX == null) {
            synchronized (II0xO0.class) {
                try {
                    if (f32166II0XooXoX == null) {
                        f32166II0XooXoX = oXxOI0oIx.oIX0oI.x0XOIxOo(context);
                    }
                } finally {
                }
            }
        }
        if (f32166II0XooXoX == null) {
            f32166II0XooXoX = "";
        }
        return f32166II0XooXoX;
    }
}
