package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class IXxxXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f32496I0Io = "%s does not seem to be an Enum type";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f32497II0xO0 = "Cannot store %s %s values in %s bits";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f32498oIX0oI = "null elements not permitted";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f32499oxoX = "EnumClass must be defined.";

    public static <E extends Enum<E>> long I0Io(Class<E> cls, Iterable<? extends E> iterable) {
        II0xO0(cls);
        xoIxX.oxXx0IX(iterable);
        long j = 0;
        for (E e : iterable) {
            xoIxX.xo0x(e, f32498oIX0oI, new Object[0]);
            j |= 1 << e.ordinal();
        }
        return j;
    }

    public static <E extends Enum<E>> E II0XooXoX(Class<E> cls, String str, E e) {
        if (str == null) {
            return e;
        }
        try {
            return (E) Enum.valueOf(cls, str);
        } catch (IllegalArgumentException unused) {
            return e;
        }
    }

    public static <E extends Enum<E>> Class<E> II0xO0(Class<E> cls) {
        boolean z;
        Enum[] enumArr = (Enum[]) oIX0oI(cls).getEnumConstants();
        if (enumArr.length <= 64) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, f32497II0xO0, Integer.valueOf(enumArr.length), cls.getSimpleName(), 64);
        return cls;
    }

    public static <E extends Enum<E>> List<E> OOXIXo(Class<E> cls) {
        return new ArrayList(Arrays.asList(cls.getEnumConstants()));
    }

    public static <E extends Enum<E>> E Oxx0IOOO(Class<E> cls, String str) {
        return (E) II0XooXoX(cls, str, null);
    }

    public static <E extends Enum<E>> long[] X0o0xo(Class<E> cls, Iterable<? extends E> iterable) {
        oIX0oI(cls);
        xoIxX.oxXx0IX(iterable);
        EnumSet noneOf = EnumSet.noneOf(cls);
        for (E e : iterable) {
            xoIxX.xo0x(e, f32498oIX0oI, new Object[0]);
            noneOf.add(e);
        }
        long[] jArr = new long[((cls.getEnumConstants().length - 1) / 64) + 1];
        Iterator it = noneOf.iterator();
        while (it.hasNext()) {
            Enum r0 = (Enum) it.next();
            int ordinal = r0.ordinal() / 64;
            jArr[ordinal] = jArr[ordinal] | (1 << (r0.ordinal() % 64));
        }
        oxoX.o0xIoII(jArr);
        return jArr;
    }

    @SafeVarargs
    public static <E extends Enum<E>> long[] XO(Class<E> cls, E... eArr) {
        oIX0oI(cls);
        xoIxX.oOXoIIIo(eArr);
        EnumSet noneOf = EnumSet.noneOf(cls);
        Collections.addAll(noneOf, eArr);
        long[] jArr = new long[((cls.getEnumConstants().length - 1) / 64) + 1];
        Iterator it = noneOf.iterator();
        while (it.hasNext()) {
            Enum r0 = (Enum) it.next();
            int ordinal = r0.ordinal() / 64;
            jArr[ordinal] = jArr[ordinal] | (1 << (r0.ordinal() % 64));
        }
        oxoX.o0xIoII(jArr);
        return jArr;
    }

    public static <E extends Enum<E>> Class<E> oIX0oI(Class<E> cls) {
        xoIxX.xo0x(cls, f32499oxoX, new Object[0]);
        xoIxX.XI0IXoo(cls.isEnum(), f32496I0Io, cls);
        return cls;
    }

    public static <E extends Enum<E>> EnumSet<E> oO(Class<E> cls, long j) {
        II0xO0(cls).getEnumConstants();
        return x0xO0oo(cls, j);
    }

    public static <E extends Enum<E>> Map<String, E> oOoXoXO(Class<E> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (E e : cls.getEnumConstants()) {
            linkedHashMap.put(e.name(), e);
        }
        return linkedHashMap;
    }

    public static <E extends Enum<E>> boolean ooOOo0oXI(Class<E> cls, String str) {
        if (Oxx0IOOO(cls, str) != null) {
            return true;
        }
        return false;
    }

    @SafeVarargs
    public static <E extends Enum<E>> long oxoX(Class<E> cls, E... eArr) {
        xoIxX.oOXoIIIo(eArr);
        return I0Io(cls, Arrays.asList(eArr));
    }

    public static <E extends Enum<E>> boolean x0XOIxOo(Class<E> cls, String str) {
        if (xxIXOIIO(cls, str) != null) {
            return true;
        }
        return false;
    }

    public static <E extends Enum<E>> EnumSet<E> x0xO0oo(Class<E> cls, long... jArr) {
        EnumSet<E> noneOf = EnumSet.noneOf(oIX0oI(cls));
        long[] xII2 = oxoX.xII((long[]) xoIxX.oxXx0IX(jArr));
        oxoX.o0xIoII(xII2);
        for (E e : cls.getEnumConstants()) {
            int ordinal = e.ordinal() / 64;
            if (ordinal < xII2.length && (xII2[ordinal] & (1 << (e.ordinal() % 64))) != 0) {
                noneOf.add(e);
            }
        }
        return noneOf;
    }

    public static <E extends Enum<E>> E xoIox(Class<E> cls, String str, E e) {
        if (str != null && cls.isEnum()) {
            for (E e2 : cls.getEnumConstants()) {
                if (e2.name().equalsIgnoreCase(str)) {
                    return e2;
                }
            }
        }
        return e;
    }

    public static <E extends Enum<E>> E xxIXOIIO(Class<E> cls, String str) {
        return (E) xoIox(cls, str, null);
    }
}
