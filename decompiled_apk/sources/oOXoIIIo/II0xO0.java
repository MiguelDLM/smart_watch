package oOXoIIIo;

import OXOo.OOXIXo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class II0xO0 {
    public static final int I0Io(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(7);
    }

    public static final int II0XooXoX(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(14);
    }

    public static final int II0xO0(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(5);
    }

    public static final void IIXOooo(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(12, i);
    }

    public static final void IXxxXO(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(5, i);
    }

    public static final void O0xOxO(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(13, i);
    }

    public static final int OOXIXo(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return xoIox(calendar) + 1;
    }

    public static final boolean Oo(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        if (oOoXoXO(calendar) == 1) {
            return true;
        }
        return false;
    }

    public static final void OxI(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(9, i);
    }

    public static final int Oxx0IOOO(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(11);
    }

    public static final void Oxx0xo(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(7, i);
    }

    public static final void OxxIIOOXO(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(14, i);
    }

    public static final void X0IIOO(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(3, i);
    }

    @OOXIXo
    public static final String X0o0xo(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        String format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.S EEE z", Locale.getDefault()).format(calendar.getTime());
        IIX0o.oO(format, "format(...)");
        return format;
    }

    public static final void XI0IXoo(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(1, i);
    }

    public static final int XO(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        if (calendar.get(10) == 0) {
            return 12;
        }
        return calendar.get(10);
    }

    public static final void o00(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        xoXoI(calendar, i - 1);
    }

    public static final void oI0IIXIo(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(11, i);
    }

    public static final int oIX0oI(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        int i = calendar.get(7);
        if (i == 1) {
            return 7;
        }
        return i - 1;
    }

    public static final int oO(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(1);
    }

    public static final int oOoXoXO(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(9);
    }

    public static final int ooOOo0oXI(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(13);
    }

    public static final int oxoX(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.getActualMaximum(5);
    }

    public static final int x0XOIxOo(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(3);
    }

    public static final boolean x0xO0oo(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        if (oOoXoXO(calendar) == 0) {
            return true;
        }
        return false;
    }

    public static final int xoIox(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(2);
    }

    public static final void xoXoI(@OOXIXo Calendar calendar, int i) {
        IIX0o.x0xO0oo(calendar, "<this>");
        calendar.set(2, i);
    }

    public static final int xxIXOIIO(@OOXIXo Calendar calendar) {
        IIX0o.x0xO0oo(calendar, "<this>");
        return calendar.get(12);
    }
}
