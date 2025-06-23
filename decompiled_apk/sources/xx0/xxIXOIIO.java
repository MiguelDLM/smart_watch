package xx0;

import XxXX.X0o0xo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.II0xO0;
import java.io.File;
import xx0.oO;

/* loaded from: classes13.dex */
public class xxIXOIIO implements xoIox {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final ooOOo0oXI f35261IXxxXO = new ooOOo0oXI(oIX0oI(), x0XOIxOo.f35241ooOOo0oXI, x0XOIxOo.f35235Oxx0IOOO, x0XOIxOo.f35232II0XooXoX, x0XOIxOo.f35231I0Io, x0XOIxOo.f35245xxIXOIIO, 10, x0XOIxOo.f35236X0o0xo, x0XOIxOo.f35243x0XOIxOo);

    /* renamed from: Oo, reason: collision with root package name */
    public static xxIXOIIO f35262Oo = null;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f35263Oxx0xo = "openSDK_LOG";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static boolean f35264oI0IIXIo = false;

    /* renamed from: oO, reason: collision with root package name */
    public OOXIXo f35265oO;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public oOoXoXO f35266x0xO0oo = new oOoXoXO(f35261IXxxXO);

    public static final void II0XooXoX(String str, String str2) {
        OOXIXo().I0Io(16, str, str2, null);
    }

    public static final void IXxxXO(String str, String str2) {
        OOXIXo().I0Io(1, str, str2, null);
    }

    public static xxIXOIIO OOXIXo() {
        if (f35262Oo == null) {
            synchronized (xxIXOIIO.class) {
                try {
                    if (f35262Oo == null) {
                        f35262Oo = new xxIXOIIO();
                        f35264oI0IIXIo = true;
                    }
                } finally {
                }
            }
        }
        return f35262Oo;
    }

    public static final void Oo(String str, String str2, Throwable th) {
        OOXIXo().I0Io(32, str, str2, th);
    }

    public static final void Oxx0IOOO(String str, String str2, Throwable th) {
        OOXIXo().I0Io(2, str, str2, th);
    }

    public static final void Oxx0xo(String str, String str2, Throwable th) {
        OOXIXo().I0Io(1, str, str2, th);
    }

    public static final void OxxIIOOXO(String str, String str2, Throwable th) {
        OOXIXo().I0Io(8, str, str2, th);
    }

    public static final void XO(String str, String str2) {
        OOXIXo().I0Io(2, str, str2, null);
    }

    public static final void oI0IIXIo(String str, String str2) {
        OOXIXo().I0Io(8, str, str2, null);
    }

    public static File oIX0oI() {
        File file;
        String str = x0XOIxOo.f35242oxoX;
        try {
            oO.I0Io II0xO02 = oO.II0xO0.II0xO0();
            if (II0xO02 != null && II0xO02.Oxx0IOOO() > x0XOIxOo.f35237XO) {
                file = new File(Environment.getExternalStorageDirectory(), str);
            } else {
                file = new File(X0o0xo.oxoX(), str);
            }
            return file;
        } catch (Throwable th) {
            xxIXOIIO(f35263Oxx0xo, "getLogFilePath:", th);
            return null;
        }
    }

    public static final void oOoXoXO(String str, String str2) {
        OOXIXo().I0Io(4, str, str2, null);
    }

    public static final void ooOOo0oXI(String str, String str2, Throwable th) {
        OOXIXo().I0Io(4, str, str2, th);
    }

    public static void x0XOIxOo() {
        synchronized (xxIXOIIO.class) {
            try {
                OOXIXo().oxoX();
                if (f35262Oo != null) {
                    f35262Oo = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final void x0xO0oo(String str, String str2) {
        OOXIXo().I0Io(32, str, str2, null);
    }

    public static void xoIox() {
        OOXIXo().X0o0xo();
    }

    public static final void xxIXOIIO(String str, String str2, Throwable th) {
        OOXIXo().I0Io(16, str, str2, th);
    }

    public void I0Io(int i, String str, String str2, Throwable th) {
        if (f35264oI0IIXIo) {
            String I0Io2 = X0o0xo.I0Io();
            if (!TextUtils.isEmpty(I0Io2)) {
                String str3 = I0Io2 + " SDK_VERSION:" + II0xO0.f26901xoIox;
                if (this.f35266x0xO0oo == null) {
                    return;
                }
                x0xO0oo.f35246Oxx0xo.II0xO0(32, Thread.currentThread(), System.currentTimeMillis(), f35263Oxx0xo, str3, null);
                this.f35266x0xO0oo.II0xO0(32, Thread.currentThread(), System.currentTimeMillis(), f35263Oxx0xo, str3, null);
                f35264oI0IIXIo = false;
            }
        }
        x0xO0oo.f35246Oxx0xo.II0xO0(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (oO.oIX0oI.oIX0oI(x0XOIxOo.f35233II0xO0, i)) {
            oOoXoXO oooxoxo = this.f35266x0xO0oo;
            if (oooxoxo == null) {
                return;
            } else {
                oooxoxo.II0xO0(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            }
        }
        OOXIXo oOXIXo = this.f35265oO;
        if (oOXIXo != null) {
            try {
                oOXIXo.II0xO0(i, Thread.currentThread(), System.currentTimeMillis(), str, II0xO0(str2), th);
            } catch (Exception e) {
                Log.e(str, "Exception", e);
            }
        }
    }

    public final String II0xO0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (oO.II0xO0(str)) {
            return "xxxxxx";
        }
        return str;
    }

    public void X0o0xo() {
        oOoXoXO oooxoxo = this.f35266x0xO0oo;
        if (oooxoxo != null) {
            oooxoxo.II0XooXoX();
        }
    }

    public void oO(OOXIXo oOXIXo) {
        this.f35265oO = oOXIXo;
    }

    public void oxoX() {
        oOoXoXO oooxoxo = this.f35266x0xO0oo;
        if (oooxoxo != null) {
            oooxoxo.II0XooXoX();
            this.f35266x0xO0oo.OOXIXo();
            this.f35266x0xO0oo = null;
        }
    }
}
