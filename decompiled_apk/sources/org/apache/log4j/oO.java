package org.apache.log4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;

/* loaded from: classes6.dex */
public class oO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f33463I0Io = "log4j.configuration";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f33464II0xO0 = "log4j.xml";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static org.apache.log4j.spi.ooOOo0oXI f33465Oxx0IOOO = new org.apache.log4j.spi.I0Io(new ooOOo0oXI(new org.apache.log4j.spi.oO(Level.DEBUG)));

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f33466X0o0xo = "log4j.defaultInitOverride";

    /* renamed from: XO, reason: collision with root package name */
    public static Object f33467XO = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33468oIX0oI = "log4j.properties";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f33469oxoX = "log4j.configuratorClass";

    static {
        URL II0xO02;
        String X0o0xo2 = org.apache.log4j.helpers.oOoXoXO.X0o0xo(f33466X0o0xo, null);
        if (X0o0xo2 == null || "false".equalsIgnoreCase(X0o0xo2)) {
            String X0o0xo3 = org.apache.log4j.helpers.oOoXoXO.X0o0xo(f33463I0Io, null);
            String X0o0xo4 = org.apache.log4j.helpers.oOoXoXO.X0o0xo(f33469oxoX, null);
            if (X0o0xo3 == null) {
                II0xO02 = org.apache.log4j.helpers.II0XooXoX.II0xO0(f33464II0xO0);
                if (II0xO02 == null) {
                    II0xO02 = org.apache.log4j.helpers.II0XooXoX.II0xO0(f33468oIX0oI);
                }
            } else {
                try {
                    II0xO02 = new URL(X0o0xo3);
                } catch (MalformedURLException unused) {
                    II0xO02 = org.apache.log4j.helpers.II0XooXoX.II0xO0(X0o0xo3);
                }
            }
            if (II0xO02 != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Using URL [");
                stringBuffer.append(II0xO02);
                stringBuffer.append("] for automatic log4j configuration.");
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
                org.apache.log4j.helpers.oOoXoXO.II0XooXoX(II0xO02, X0o0xo4, XO());
                return;
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not find resource: [");
            stringBuffer2.append(X0o0xo3);
            stringBuffer2.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
        }
    }

    public static x0xO0oo I0Io(Class cls) {
        return f33465Oxx0IOOO.oIX0oI().xxIXOIIO(cls.getName());
    }

    public static void II0XooXoX() {
        f33465Oxx0IOOO.oIX0oI().OOXIXo();
    }

    public static Enumeration II0xO0() {
        return f33465Oxx0IOOO.oIX0oI().Oxx0IOOO();
    }

    public static x0xO0oo Oxx0IOOO() {
        return f33465Oxx0IOOO.oIX0oI().oO();
    }

    public static x0xO0oo X0o0xo(String str, org.apache.log4j.spi.II0XooXoX iI0XooXoX) {
        return f33465Oxx0IOOO.oIX0oI().x0XOIxOo(str, iI0XooXoX);
    }

    public static org.apache.log4j.spi.xxIXOIIO XO() {
        return f33465Oxx0IOOO.oIX0oI();
    }

    public static x0xO0oo oIX0oI(String str) {
        return f33465Oxx0IOOO.oIX0oI().x0xO0oo(str);
    }

    public static x0xO0oo oxoX(String str) {
        return f33465Oxx0IOOO.oIX0oI().xxIXOIIO(str);
    }

    public static void xoIox() {
        f33465Oxx0IOOO.oIX0oI().shutdown();
    }

    public static void xxIXOIIO(org.apache.log4j.spi.ooOOo0oXI ooooo0oxi, Object obj) throws IllegalArgumentException {
        Object obj2 = f33467XO;
        if (obj2 != null && obj2 != obj) {
            throw new IllegalArgumentException("Attempted to reset the LoggerFactory without possessing the guard.");
        }
        if (ooooo0oxi != null) {
            f33467XO = obj;
            f33465Oxx0IOOO = ooooo0oxi;
            return;
        }
        throw new IllegalArgumentException("RepositorySelector must be non-null.");
    }
}
