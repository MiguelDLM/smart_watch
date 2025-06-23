package kotlin.jvm.internal;

import OI0IXox.Oxx0IOOO;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class XoX {
    public static Iterable I0Io(Object obj) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.I0Io)) {
            oOXoIIIo(obj, "kotlin.collections.MutableIterable");
        }
        return oI0IIXIo(obj);
    }

    public static List II0XooXoX(Object obj, String str) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.X0o0xo)) {
            Xx000oIo(str);
        }
        return IIXOooo(obj);
    }

    public static Collection II0xO0(Object obj, String str) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.II0xO0)) {
            Xx000oIo(str);
        }
        return Oxx0xo(obj);
    }

    public static boolean IIX0o(Object obj) {
        if ((obj instanceof ListIterator) && (!(obj instanceof OI0IXox.oIX0oI) || (obj instanceof OI0IXox.XO))) {
            return true;
        }
        return false;
    }

    public static List IIXOooo(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw IoOoX(e);
        }
    }

    public static Object IXxxXO(Object obj, int i, String str) {
        if (obj != null && !XI0IXoo(obj, i)) {
            Xx000oIo(str);
        }
        return obj;
    }

    public static ClassCastException IoOoX(ClassCastException classCastException) {
        throw ((ClassCastException) oo(classCastException));
    }

    public static Set O0xOxO(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw IoOoX(e);
        }
    }

    public static Map OOXIXo(Object obj) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.Oxx0IOOO)) {
            oOXoIIIo(obj, "kotlin.collections.MutableMap");
        }
        return o00(obj);
    }

    public static Object Oo(Object obj, int i) {
        if (obj != null && !XI0IXoo(obj, i)) {
            oOXoIIIo(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    public static Map.Entry OxI(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e) {
            throw IoOoX(e);
        }
    }

    public static List Oxx0IOOO(Object obj) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.X0o0xo)) {
            oOXoIIIo(obj, "kotlin.collections.MutableList");
        }
        return IIXOooo(obj);
    }

    public static Collection Oxx0xo(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw IoOoX(e);
        }
    }

    public static Iterator OxxIIOOXO(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e) {
            throw IoOoX(e);
        }
    }

    public static int X0IIOO(Object obj) {
        if (obj instanceof XIxXXX0x0) {
            return ((XIxXXX0x0) obj).getArity();
        }
        if (obj instanceof Oox.oIX0oI) {
            return 0;
        }
        if (obj instanceof Oox.oOoXoXO) {
            return 1;
        }
        if (obj instanceof Oox.x0xO0oo) {
            return 2;
        }
        if (obj instanceof Oox.IXxxXO) {
            return 3;
        }
        if (obj instanceof Oox.Oxx0xo) {
            return 4;
        }
        if (obj instanceof Oox.oI0IIXIo) {
            return 5;
        }
        if (obj instanceof Oox.OxxIIOOXO) {
            return 6;
        }
        if (obj instanceof Oox.IIXOooo) {
            return 7;
        }
        if (obj instanceof Oox.xoXoI) {
            return 8;
        }
        if (obj instanceof Oox.o00) {
            return 9;
        }
        if (obj instanceof Oox.II0xO0) {
            return 10;
        }
        if (obj instanceof Oox.I0Io) {
            return 11;
        }
        if (obj instanceof Oox.oxoX) {
            return 12;
        }
        if (obj instanceof Oox.X0o0xo) {
            return 13;
        }
        if (obj instanceof Oox.XO) {
            return 14;
        }
        if (obj instanceof Oox.Oxx0IOOO) {
            return 15;
        }
        if (obj instanceof Oox.II0XooXoX) {
            return 16;
        }
        if (obj instanceof Oox.xxIXOIIO) {
            return 17;
        }
        if (obj instanceof Oox.xoIox) {
            return 18;
        }
        if (obj instanceof Oox.OOXIXo) {
            return 19;
        }
        if (obj instanceof Oox.ooOOo0oXI) {
            return 20;
        }
        if (obj instanceof Oox.x0XOIxOo) {
            return 21;
        }
        if (obj instanceof Oox.oO) {
            return 22;
        }
        return -1;
    }

    public static Iterator X0o0xo(Object obj) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.oxoX)) {
            oOXoIIIo(obj, "kotlin.collections.MutableIterator");
        }
        return OxxIIOOXO(obj);
    }

    public static boolean XI0IXoo(Object obj, int i) {
        if ((obj instanceof kotlin.IIXOooo) && X0IIOO(obj) == i) {
            return true;
        }
        return false;
    }

    public static boolean XIxXXX0x0(Object obj) {
        if ((obj instanceof Collection) && (!(obj instanceof OI0IXox.oIX0oI) || (obj instanceof OI0IXox.II0xO0))) {
            return true;
        }
        return false;
    }

    public static Iterator XO(Object obj, String str) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.oxoX)) {
            Xx000oIo(str);
        }
        return OxxIIOOXO(obj);
    }

    public static void Xx000oIo(String str) {
        throw IoOoX(new ClassCastException(str));
    }

    public static boolean XxX0x0xxx(Object obj) {
        if ((obj instanceof Iterator) && (!(obj instanceof OI0IXox.oIX0oI) || (obj instanceof OI0IXox.oxoX))) {
            return true;
        }
        return false;
    }

    public static Map o00(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw IoOoX(e);
        }
    }

    public static Iterable oI0IIXIo(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw IoOoX(e);
        }
    }

    public static Collection oIX0oI(Object obj) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.II0xO0)) {
            oOXoIIIo(obj, "kotlin.collections.MutableCollection");
        }
        return Oxx0xo(obj);
    }

    public static Set oO(Object obj) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.II0XooXoX)) {
            oOXoIIIo(obj, "kotlin.collections.MutableSet");
        }
        return O0xOxO(obj);
    }

    public static void oOXoIIIo(Object obj, String str) {
        String name;
        if (obj == null) {
            name = "null";
        } else {
            name = obj.getClass().getName();
        }
        Xx000oIo(name + " cannot be cast to " + str);
    }

    public static Map oOoXoXO(Object obj, String str) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.Oxx0IOOO)) {
            Xx000oIo(str);
        }
        return o00(obj);
    }

    public static <T extends Throwable> T oo(T t) {
        return (T) IIX0o.XI0IXoo(t, XoX.class.getName());
    }

    public static boolean oo0xXOI0I(Object obj) {
        if ((obj instanceof Set) && (!(obj instanceof OI0IXox.oIX0oI) || (obj instanceof OI0IXox.II0XooXoX))) {
            return true;
        }
        return false;
    }

    public static Map.Entry ooOOo0oXI(Object obj) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof Oxx0IOOO.oIX0oI)) {
            oOXoIIIo(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return OxI(obj);
    }

    public static boolean ooXIXxIX(Object obj) {
        if ((obj instanceof Map) && (!(obj instanceof OI0IXox.oIX0oI) || (obj instanceof OI0IXox.Oxx0IOOO))) {
            return true;
        }
        return false;
    }

    public static Iterable oxoX(Object obj, String str) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.I0Io)) {
            Xx000oIo(str);
        }
        return oI0IIXIo(obj);
    }

    public static Map.Entry x0XOIxOo(Object obj, String str) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof Oxx0IOOO.oIX0oI)) {
            Xx000oIo(str);
        }
        return OxI(obj);
    }

    public static Set x0xO0oo(Object obj, String str) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.II0XooXoX)) {
            Xx000oIo(str);
        }
        return O0xOxO(obj);
    }

    public static boolean xI(Object obj) {
        if ((obj instanceof Map.Entry) && (!(obj instanceof OI0IXox.oIX0oI) || (obj instanceof Oxx0IOOO.oIX0oI))) {
            return true;
        }
        return false;
    }

    public static boolean xXxxox0I(Object obj) {
        if ((obj instanceof List) && (!(obj instanceof OI0IXox.oIX0oI) || (obj instanceof OI0IXox.X0o0xo))) {
            return true;
        }
        return false;
    }

    public static ListIterator xoIox(Object obj, String str) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.XO)) {
            Xx000oIo(str);
        }
        return xoXoI(obj);
    }

    public static ListIterator xoXoI(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e) {
            throw IoOoX(e);
        }
    }

    public static ListIterator xxIXOIIO(Object obj) {
        if ((obj instanceof OI0IXox.oIX0oI) && !(obj instanceof OI0IXox.XO)) {
            oOXoIIIo(obj, "kotlin.collections.MutableListIterator");
        }
        return xoXoI(obj);
    }

    public static boolean xxX(Object obj) {
        if ((obj instanceof Iterable) && (!(obj instanceof OI0IXox.oIX0oI) || (obj instanceof OI0IXox.I0Io))) {
            return true;
        }
        return false;
    }
}
