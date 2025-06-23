package IOOoXo0Ix;

import android.app.Application;
import android.content.Context;

/* loaded from: classes13.dex */
public final class ooOOo0oXI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static xo.Oxx0IOOO f594oIX0oI;

    public static xo.Oxx0IOOO I0Io(Context context) {
        OOXIXo oOXIXo = new OOXIXo(context);
        if (oOXIXo.II0xO0()) {
            xo.xxIXOIIO.II0xO0("Mobile Security Alliance has been found: " + OOXIXo.class.getName());
            return oOXIXo;
        }
        XO xo2 = new XO(context);
        if (xo2.II0xO0()) {
            xo.xxIXOIIO.II0xO0("Google Play Service has been found: " + XO.class.getName());
            return xo2;
        }
        oxoX oxox = new oxoX();
        xo.xxIXOIIO.II0xO0("OAID/AAID was not supported: " + oxoX.class.getName());
        return oxox;
    }

    public static xo.Oxx0IOOO II0xO0(Context context) {
        if (!xo.xoIox.xxIXOIIO() && !xo.xoIox.oOoXoXO()) {
            if (xo.xoIox.xoIox()) {
                return new xoIox(context);
            }
            if (xo.xoIox.ooOOo0oXI()) {
                return new oOoXoXO(context);
            }
            if (!xo.xoIox.IXxxXO() && !xo.xoIox.OOXIXo() && !xo.xoIox.II0xO0()) {
                if (xo.xoIox.x0xO0oo()) {
                    return new x0xO0oo(context);
                }
                if (xo.xoIox.Oo()) {
                    return new IXxxXO(context);
                }
                if (xo.xoIox.oIX0oI()) {
                    return new oIX0oI(context);
                }
                if (xo.xoIox.Oxx0IOOO()) {
                    Oxx0IOOO oxx0IOOO = new Oxx0IOOO(context);
                    if (oxx0IOOO.II0xO0()) {
                        return oxx0IOOO;
                    }
                }
                if (!xo.xoIox.II0XooXoX() && !xo.xoIox.X0o0xo()) {
                    if (!xo.xoIox.oO() && !xo.xoIox.x0XOIxOo()) {
                        if (xo.xoIox.I0Io(context)) {
                            return new II0xO0(context);
                        }
                        if (xo.xoIox.oxoX()) {
                            return new I0Io(context);
                        }
                        if (xo.xoIox.XO()) {
                            return new X0o0xo(context);
                        }
                        return null;
                    }
                    return new oO(context);
                }
                return new II0XooXoX(context);
            }
            return new Oxx0xo(context);
        }
        return new xxIXOIIO(context);
    }

    public static xo.Oxx0IOOO oIX0oI(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        xo.Oxx0IOOO oxx0IOOO = f594oIX0oI;
        if (oxx0IOOO != null) {
            return oxx0IOOO;
        }
        xo.Oxx0IOOO II0xO02 = II0xO0(context);
        f594oIX0oI = II0xO02;
        if (II0xO02 != null && II0xO02.II0xO0()) {
            xo.xxIXOIIO.II0xO0("Manufacturer interface has been found: " + f594oIX0oI.getClass().getName());
            return f594oIX0oI;
        }
        xo.Oxx0IOOO I0Io2 = I0Io(context);
        f594oIX0oI = I0Io2;
        return I0Io2;
    }
}
