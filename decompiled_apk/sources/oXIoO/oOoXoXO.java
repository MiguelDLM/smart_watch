package oXIoO;

import android.app.Application;
import android.content.Context;

/* loaded from: classes11.dex */
public final class oOoXoXO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static oXxOI0oIx.oxoX f32133II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static oXxOI0oIx.oxoX f32134oIX0oI;

    public static oXxOI0oIx.oxoX I0Io(Context context) {
        if (!oXxOI0oIx.XO.ooOOo0oXI() && !oXxOI0oIx.XO.x0xO0oo()) {
            if (oXxOI0oIx.XO.oOoXoXO()) {
                return new xxIXOIIO(context);
            }
            if (oXxOI0oIx.XO.x0XOIxOo()) {
                return new OOXIXo(context);
            }
            if (!oXxOI0oIx.XO.Oxx0IOOO() && !oXxOI0oIx.XO.II0XooXoX() && !oXxOI0oIx.XO.xxIXOIIO()) {
                if (oXxOI0oIx.XO.OOXIXo()) {
                    return new oO(context);
                }
                if (oXxOI0oIx.XO.XO()) {
                    return new x0xO0oo(context);
                }
                if (oXxOI0oIx.XO.oO()) {
                    return new oIX0oI(context);
                }
                if (!oXxOI0oIx.XO.II0xO0() && !oXxOI0oIx.XO.oxoX()) {
                    if (!oXxOI0oIx.XO.X0o0xo() && !oXxOI0oIx.XO.xoIox()) {
                        if (oXxOI0oIx.XO.I0Io(context)) {
                            return new II0xO0(context);
                        }
                        if (oXxOI0oIx.XO.IXxxXO()) {
                            return new I0Io(context);
                        }
                        if (oXxOI0oIx.XO.Oo()) {
                            return new X0o0xo(context);
                        }
                        return null;
                    }
                    return new x0XOIxOo(context);
                }
                return new Oxx0IOOO(context);
            }
            return new IXxxXO(context);
        }
        return new II0XooXoX(context);
    }

    public static oXxOI0oIx.oxoX II0xO0(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        oXxOI0oIx.oxoX oxox = f32133II0xO0;
        if (oxox != null) {
            return oxox;
        }
        oXxOI0oIx.oxoX X0o0xo2 = X0o0xo(context);
        f32133II0xO0 = X0o0xo2;
        return X0o0xo2;
    }

    public static oXxOI0oIx.oxoX X0o0xo(Context context) {
        XO xo2 = new XO(context);
        if (xo2.a()) {
            oXxOI0oIx.X0o0xo.oIX0oI("Google Play Service has been found: " + XO.class.getName());
            return xo2;
        }
        oxoX oxox = new oxoX();
        oXxOI0oIx.X0o0xo.oIX0oI("GAID was not supported: " + oxoX.class.getName());
        return oxox;
    }

    public static oXxOI0oIx.oxoX oIX0oI(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        oXxOI0oIx.oxoX oxox = f32134oIX0oI;
        if (oxox != null) {
            return oxox;
        }
        oXxOI0oIx.oxoX I0Io2 = I0Io(context);
        f32134oIX0oI = I0Io2;
        if (I0Io2 != null && I0Io2.a()) {
            oXxOI0oIx.X0o0xo.oIX0oI("Manufacturer interface has been found: " + f32134oIX0oI.getClass().getName());
            return f32134oIX0oI;
        }
        oXxOI0oIx.oxoX oxoX2 = oxoX(context);
        f32134oIX0oI = oxoX2;
        return oxoX2;
    }

    public static oXxOI0oIx.oxoX oxoX(Context context) {
        xoIox xoiox = new xoIox(context);
        if (xoiox.a()) {
            oXxOI0oIx.X0o0xo.oIX0oI("Mobile Security Alliance has been found: " + xoIox.class.getName());
            return xoiox;
        }
        XO xo2 = new XO(context);
        if (xo2.a()) {
            oXxOI0oIx.X0o0xo.oIX0oI("Google Play Service has been found: " + XO.class.getName());
            return xo2;
        }
        oxoX oxox = new oxoX();
        oXxOI0oIx.X0o0xo.oIX0oI("OAID/GAID was not supported: " + oxoX.class.getName());
        return oxox;
    }
}
