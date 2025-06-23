package org.apache.commons.lang3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class xoIxX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f32985I0Io = "The value %s is not in the specified exclusive range of %s to %s";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f32986II0XooXoX = "The validated array contains null element at index: %d";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f32987II0xO0 = "The value is invalid: %f";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f32988IXxxXO = "The validated state is false";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f32989OOXIXo = "The validated array is empty";

    /* renamed from: Oo, reason: collision with root package name */
    public static final String f32990Oo = "The validated collection index is invalid: %d";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f32991Oxx0IOOO = "The validated expression is false";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f32992Oxx0xo = "Cannot assign a %s to a %s";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f32993X0o0xo = "The string %s does not match the pattern %s";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f32994XO = "The validated object is null";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f32995oI0IIXIo = "Expected type: %s, actual: %s";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f32996oIX0oI = "The validated value is not a number";

    /* renamed from: oO, reason: collision with root package name */
    public static final String f32997oO = "The validated array index is invalid: %d";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f32998oOoXoXO = "The validated character sequence is empty";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f32999ooOOo0oXI = "The validated collection is empty";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f33000oxoX = "The value %s is not in the specified inclusive range of %s to %s";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f33001x0XOIxOo = "The validated map is empty";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f33002x0xO0oo = "The validated character sequence index is invalid: %d";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f33003xoIox = "The validated character sequence is blank";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f33004xxIXOIIO = "The validated collection contains null element at index: %d";

    public static <T extends Collection<?>> T I0X0x0oIo(T t, int i) {
        return (T) oX(t, i, f32990Oo, Integer.valueOf(i));
    }

    public static void I0oOIX(boolean z, String str, Object... objArr) {
        if (z) {
        } else {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T> T[] I0oOoX(T[] tArr, final String str, final Object... objArr) {
        oX.oIX0oI(tArr, new Supplier() { // from class: org.apache.commons.lang3.IoOoo
            @Override // java.util.function.Supplier
            public final Object get() {
                String format;
                format = String.format(str, objArr);
                return format;
            }
        });
        if (tArr.length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static void II0XooXoX(double d, double d2, double d3, String str) {
        if (d3 > d && d3 < d2) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static void IIXOooo(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        if (cls.isAssignableFrom(cls2)) {
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T IO(T t, final String str, final Object... objArr) {
        oX.oIX0oI(t, new Supplier() { // from class: org.apache.commons.lang3.XoI0Ixx0
            @Override // java.util.function.Supplier
            public final Object get() {
                String format;
                format = String.format(str, objArr);
                return format;
            }
        });
        if (!xXOx.xOOOX(t)) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static void IXxxXO(long j, long j2, long j3, String str) {
        if (j3 >= j && j3 <= j2) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T extends Map<?, ?>> T Io(T t) {
        return (T) o0(t, f33001x0XOIxOo, new Object[0]);
    }

    public static <T extends Iterable<?>> T IoOoX(T t, String str, Object... objArr) {
        oxXx0IX(t);
        Iterator it = t.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() != null) {
                i++;
            } else {
                throw new IllegalArgumentException(String.format(str, oxoX.O0xOxO(objArr, Integer.valueOf(i))));
            }
        }
        return t;
    }

    public static void O0Xx(boolean z) {
        if (z) {
        } else {
            throw new IllegalStateException(f32988IXxxXO);
        }
    }

    public static void O0xOxO(boolean z, String str, double d) {
        if (z) {
        } else {
            throw new IllegalArgumentException(String.format(str, Double.valueOf(d)));
        }
    }

    public static <T extends Collection<?>> T OI0(T t, final String str, final Object... objArr) {
        oX.oIX0oI(t, new Supplier() { // from class: org.apache.commons.lang3.xoxXI
            @Override // java.util.function.Supplier
            public final Object get() {
                String format;
                format = String.format(str, objArr);
                return format;
            }
        });
        if (!t.isEmpty()) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static <T> void OOXIXo(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) > 0 && comparable.compareTo(t2) < 0) {
        } else {
            throw new IllegalArgumentException(String.format(f32985I0Io, comparable, t, t2));
        }
    }

    public static void Oo(long j, long j2, long j3) {
        if (j3 >= j && j3 <= j2) {
        } else {
            throw new IllegalArgumentException(String.format(f33000oxoX, Long.valueOf(j3), Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void OxI(boolean z) {
        if (z) {
        } else {
            throw new IllegalArgumentException(f32991Oxx0IOOO);
        }
    }

    public static void Oxx0IOOO(double d, double d2, double d3) {
        if (d3 > d && d3 < d2) {
        } else {
            throw new IllegalArgumentException(String.format(f32985I0Io, Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2)));
        }
    }

    public static <T> void Oxx0xo(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) >= 0 && comparable.compareTo(t2) <= 0) {
        } else {
            throw new IllegalArgumentException(String.format(f33000oxoX, comparable, t, t2));
        }
    }

    public static void OxxIIOOXO(Class<?> cls, Class<?> cls2) {
        String name;
        if (!cls.isAssignableFrom(cls2)) {
            if (cls2 == null) {
                name = "null";
            } else {
                name = cls2.getName();
            }
            throw new IllegalArgumentException(String.format(f32992Oxx0xo, name, cls.getName()));
        }
    }

    public static <T extends CharSequence> T X00IoxXI(T t) {
        return (T) IO(t, f33003xoIox, new Object[0]);
    }

    public static void X0IIOO(boolean z, String str, long j) {
        if (z) {
        } else {
            throw new IllegalArgumentException(String.format(str, Long.valueOf(j)));
        }
    }

    public static void XI0IXoo(boolean z, String str, Object... objArr) {
        if (z) {
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Collection<?>> T XOxIOxOx(T t) {
        return (T) OI0(t, f32999ooOOo0oXI, new Object[0]);
    }

    public static <T> T[] XX(T[] tArr) {
        return (T[]) I0oOoX(tArr, f32989OOXIXo, new Object[0]);
    }

    public static <T extends CharSequence> T XX0(T t, int i, String str, Object... objArr) {
        oxXx0IX(t);
        if (i >= 0 && i < t.length()) {
            return t;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static <T> T[] Xo0(T[] tArr, int i) {
        return (T[]) XoI0Ixx0(tArr, i, f32997oO, Integer.valueOf(i));
    }

    public static <T> T[] XoI0Ixx0(T[] tArr, int i, String str, Object... objArr) {
        oxXx0IX(tArr);
        if (i >= 0 && i < tArr.length) {
            return tArr;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static void XoX(double d, String str, Object... objArr) {
        if (!Double.isNaN(d)) {
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T[] Xx000oIo(T[] tArr, String str, Object... objArr) {
        oxXx0IX(tArr);
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == null) {
                throw new IllegalArgumentException(String.format(str, oxoX.oO(objArr, Integer.valueOf(i))));
            }
        }
        return tArr;
    }

    public static <T extends Map<?, ?>> T o0(T t, final String str, final Object... objArr) {
        oX.oIX0oI(t, new Supplier() { // from class: org.apache.commons.lang3.Xo0
            @Override // java.util.function.Supplier
            public final Object get() {
                String format;
                format = String.format(str, objArr);
                return format;
            }
        });
        if (!t.isEmpty()) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static void o00(Class<?> cls, Object obj, String str, Object... objArr) {
        if (cls.isInstance(obj)) {
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> void oI0IIXIo(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) >= 0 && comparable.compareTo(t2) <= 0) {
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void oO(double d, double d2, double d3) {
        if (d3 >= d && d3 <= d2) {
        } else {
            throw new IllegalArgumentException(String.format(f33000oxoX, Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2)));
        }
    }

    public static <T> T[] oOXoIIIo(T[] tArr) {
        return (T[]) Xx000oIo(tArr, f32986II0XooXoX, new Object[0]);
    }

    public static <T> void oOoXoXO(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) > 0 && comparable.compareTo(t2) < 0) {
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Collection<?>> T oX(T t, int i, String str, Object... objArr) {
        oxXx0IX(t);
        if (i >= 0 && i < t.size()) {
            return t;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static <T extends Iterable<?>> T oo(T t) {
        return (T) IoOoX(t, f33004xxIXOIIO, new Object[0]);
    }

    public static void oo0xXOI0I(CharSequence charSequence, String str, String str2, Object... objArr) {
        if (Pattern.matches(str, charSequence)) {
        } else {
            throw new IllegalArgumentException(String.format(str2, objArr));
        }
    }

    public static void ooOOo0oXI(double d) {
        x0XOIxOo(d, f32987II0xO0, Double.valueOf(d));
    }

    public static <T> T oxXx0IX(T t) {
        return (T) xo0x(t, f32994XO, new Object[0]);
    }

    public static void oxxXoxO(double d) {
        XoX(d, f32996oIX0oI, new Object[0]);
    }

    public static void x0XOIxOo(double d, String str, Object... objArr) {
        if (!Double.isNaN(d) && !Double.isInfinite(d)) {
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T x0o(T t, final String str, final Object... objArr) {
        oX.oIX0oI(t, new Supplier() { // from class: org.apache.commons.lang3.I0oOIX
            @Override // java.util.function.Supplier
            public final Object get() {
                String format;
                format = String.format(str, objArr);
                return format;
            }
        });
        if (t.length() != 0) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static void x0xO0oo(double d, double d2, double d3, String str) {
        if (d3 >= d && d3 <= d2) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static void xI(CharSequence charSequence, String str) {
        if (Pattern.matches(str, charSequence)) {
        } else {
            throw new IllegalArgumentException(String.format(f32993X0o0xo, charSequence, str));
        }
    }

    public static <T extends CharSequence> T xII(T t) {
        return (T) x0o(t, f32998oOoXoXO, new Object[0]);
    }

    public static <T extends CharSequence> T xXOx(T t, int i) {
        return (T) XX0(t, i, f33002x0xO0oo, Integer.valueOf(i));
    }

    public static <T> T xo0x(T t, final String str, final Object... objArr) {
        return (T) oX.oIX0oI(t, new Supplier() { // from class: org.apache.commons.lang3.O0Xx
            @Override // java.util.function.Supplier
            public final Object get() {
                String format;
                format = String.format(str, objArr);
                return format;
            }
        });
    }

    public static void xoIox(long j, long j2, long j3, String str) {
        if (j3 > j && j3 < j2) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static void xoXoI(Class<?> cls, Object obj) {
        String name;
        if (!cls.isInstance(obj)) {
            String name2 = cls.getName();
            if (obj == null) {
                name = "null";
            } else {
                name = obj.getClass().getName();
            }
            throw new IllegalArgumentException(String.format(f32995oI0IIXIo, name2, name));
        }
    }

    public static void xxIXOIIO(long j, long j2, long j3) {
        if (j3 > j && j3 < j2) {
        } else {
            throw new IllegalArgumentException(String.format(f32985I0Io, Long.valueOf(j3), Long.valueOf(j), Long.valueOf(j2)));
        }
    }
}
