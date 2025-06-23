package XxIIOXIXx;

import java.security.AccessControlException;

/* loaded from: classes6.dex */
public abstract class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static X0o0xo f4197oIX0oI;

    public static synchronized void OOXIXo() {
        synchronized (X0o0xo.class) {
            if (f4197oIX0oI != null) {
                return;
            }
            String str = O0O0Io00X.oIX0oI.f1263oIX0oI;
            try {
                try {
                    try {
                        String property = System.getProperty("logger");
                        if (property != null) {
                            str = property;
                        }
                        f4197oIX0oI = (X0o0xo) Class.forName(str).newInstance();
                    } catch (InstantiationException unused) {
                        O0O0Io00X.II0xO0 iI0xO0 = new O0O0Io00X.II0xO0();
                        f4197oIX0oI = iI0xO0;
                        iI0xO0.ooOOo0oXI("Could not instantiate logger " + str + " using default");
                    }
                } catch (IllegalAccessException unused2) {
                    O0O0Io00X.II0xO0 iI0xO02 = new O0O0Io00X.II0xO0();
                    f4197oIX0oI = iI0xO02;
                    iI0xO02.ooOOo0oXI("Could not instantiate logger " + str + " using default");
                }
            } catch (ClassNotFoundException unused3) {
                O0O0Io00X.II0xO0 iI0xO03 = new O0O0Io00X.II0xO0();
                f4197oIX0oI = iI0xO03;
                iI0xO03.ooOOo0oXI("Could not instantiate logger " + str + " using default");
            } catch (AccessControlException unused4) {
                O0O0Io00X.II0xO0 iI0xO04 = new O0O0Io00X.II0xO0();
                f4197oIX0oI = iI0xO04;
                iI0xO04.ooOOo0oXI("Could not instantiate logger " + str + " using default");
            }
        }
    }

    public static final X0o0xo Oxx0IOOO(Class cls) {
        if (f4197oIX0oI == null) {
            OOXIXo();
        }
        return f4197oIX0oI.II0XooXoX(cls);
    }

    public abstract void I0Io(Object obj);

    public abstract X0o0xo II0XooXoX(Class cls);

    public abstract void II0xO0(Object obj, Throwable th);

    public abstract void X0o0xo(Object obj);

    public abstract void XO(Object obj, Throwable th);

    public abstract void oIX0oI(Object obj);

    public abstract void ooOOo0oXI(Object obj);

    public abstract void oxoX(Object obj, Throwable th);

    public abstract void x0XOIxOo(Object obj, Throwable th);

    public abstract void xoIox(Object obj, Throwable th);

    public abstract void xxIXOIIO(Object obj);

    public void oOoXoXO(boolean z) {
    }
}
