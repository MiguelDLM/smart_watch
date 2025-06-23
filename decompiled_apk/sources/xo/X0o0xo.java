package xo;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes13.dex */
public final class X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static volatile boolean f34915I0Io = false;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static volatile String f34916II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static volatile X0o0xo f34917II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static volatile String f34918Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static volatile String f34919X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static volatile String f34920XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public static volatile String f34921oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public static volatile String f34922xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static volatile String f34923xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Application f34924oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements XO {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ XO f34926oIX0oI;

        public oIX0oI(XO xo2) {
            this.f34926oIX0oI = xo2;
        }

        @Override // xo.XO
        public void oaidError(Exception exc) {
            String unused = X0o0xo.f34920XO = "";
            XO xo2 = this.f34926oIX0oI;
            if (xo2 != null) {
                xo2.oaidError(exc);
            }
        }

        @Override // xo.XO
        public void oaidSucc(String str) {
            String unused = X0o0xo.f34920XO = str;
            XO xo2 = this.f34926oIX0oI;
            if (xo2 != null) {
                xo2.oaidSucc(X0o0xo.f34920XO);
            }
        }
    }

    public static X0o0xo II0XooXoX() {
        if (f34917II0xO0 == null) {
            synchronized (X0o0xo.class) {
                try {
                    if (f34917II0xO0 == null) {
                        f34917II0xO0 = new X0o0xo();
                    }
                } finally {
                }
            }
        }
        return f34917II0xO0;
    }

    public String I0Io(Context context) {
        if (f34918Oxx0IOOO == null) {
            f34918Oxx0IOOO = II0XooXoX.I0Io(this.f34924oIX0oI).oxoX(II0XooXoX.f34905Oxx0IOOO);
            if (TextUtils.isEmpty(f34918Oxx0IOOO)) {
                f34918Oxx0IOOO = oxoX.II0xO0(context);
                II0XooXoX.I0Io(this.f34924oIX0oI).X0o0xo(II0XooXoX.f34905Oxx0IOOO, f34918Oxx0IOOO);
            }
        }
        if (f34918Oxx0IOOO == null) {
            f34918Oxx0IOOO = "";
        }
        return f34918Oxx0IOOO;
    }

    public String OOXIXo(Context context, boolean z, XO xo2) {
        if (TextUtils.isEmpty(f34920XO)) {
            f34920XO = oxoX.xoIox();
            if (TextUtils.isEmpty(f34920XO)) {
                f34920XO = II0XooXoX.I0Io(this.f34924oIX0oI).oxoX(II0XooXoX.f34908oxoX);
            }
            if (TextUtils.isEmpty(f34920XO) && !z) {
                oxoX.OOXIXo(context, new oIX0oI(xo2));
            }
        }
        if (f34920XO == null) {
            f34920XO = "";
        }
        if (xo2 != null) {
            xo2.oaidSucc(f34920XO);
        }
        return f34920XO;
    }

    public String Oxx0IOOO(Context context, boolean z) {
        if (TextUtils.isEmpty(f34919X0o0xo)) {
            f34919X0o0xo = II0XooXoX.I0Io(this.f34924oIX0oI).oxoX(II0XooXoX.f34906X0o0xo);
            if (TextUtils.isEmpty(f34919X0o0xo) && !z) {
                f34919X0o0xo = oxoX.ooOOo0oXI(context);
                II0XooXoX.I0Io(this.f34924oIX0oI).X0o0xo(II0XooXoX.f34906X0o0xo, f34919X0o0xo);
            }
        }
        if (f34919X0o0xo == null) {
            f34919X0o0xo = "";
        }
        return f34919X0o0xo;
    }

    public String X0o0xo(Context context) {
        if (f34922xoIox == null) {
            f34922xoIox = oxoX.XO(context);
            if (f34922xoIox == null) {
                f34922xoIox = "";
            }
        }
        return f34922xoIox;
    }

    public String XO(Context context) {
        return Oxx0IOOO(context, false);
    }

    public void oO(Application application, boolean z) {
        this.f34924oIX0oI = application;
        if (f34915I0Io) {
            return;
        }
        oxoX.IXxxXO(application);
        f34915I0Io = true;
        xxIXOIIO.oIX0oI(z);
    }

    public String oOoXoXO() {
        if (f34923xxIXOIIO == null) {
            f34923xxIXOIIO = II0XooXoX.I0Io(this.f34924oIX0oI).oxoX(II0XooXoX.f34909xxIXOIIO);
            if (TextUtils.isEmpty(f34923xxIXOIIO)) {
                f34923xxIXOIIO = oxoX.oOoXoXO();
                II0XooXoX.I0Io(this.f34924oIX0oI).X0o0xo(II0XooXoX.f34909xxIXOIIO, f34923xxIXOIIO);
            }
        }
        if (f34923xxIXOIIO == null) {
            f34923xxIXOIIO = "";
        }
        return f34923xxIXOIIO;
    }

    public String ooOOo0oXI() {
        if (f34916II0XooXoX == null) {
            f34916II0XooXoX = II0XooXoX.I0Io(this.f34924oIX0oI).oxoX(II0XooXoX.f34903II0XooXoX);
            if (TextUtils.isEmpty(f34916II0XooXoX)) {
                f34916II0XooXoX = oxoX.Oo();
                II0XooXoX.I0Io(this.f34924oIX0oI).X0o0xo(II0XooXoX.f34903II0XooXoX, f34916II0XooXoX);
            }
        }
        if (f34916II0XooXoX == null) {
            f34916II0XooXoX = "";
        }
        return f34916II0XooXoX;
    }

    public String oxoX() {
        if (TextUtils.isEmpty(f34921oxoX)) {
            f34921oxoX = II0XooXoX.I0Io(this.f34924oIX0oI).oxoX(II0XooXoX.f34907XO);
            if (TextUtils.isEmpty(f34921oxoX)) {
                f34921oxoX = oxoX.oxoX();
                II0XooXoX.I0Io(this.f34924oIX0oI).X0o0xo(II0XooXoX.f34907XO, f34921oxoX);
            }
        }
        if (f34921oxoX == null) {
            f34921oxoX = "";
        }
        return f34921oxoX;
    }

    public void x0XOIxOo(Application application) {
        oO(application, false);
    }

    public String xoIox(Context context, boolean z) {
        return OOXIXo(context, z, null);
    }

    public String xxIXOIIO(Context context) {
        return xoIox(context, false);
    }
}
