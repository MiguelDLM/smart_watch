package org.apache.commons.lang3;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Supplier;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;

/* loaded from: classes6.dex */
public class ObjectUtils {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Null f32505II0xO0 = new Null();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final char f32506oIX0oI = '@';

    /* loaded from: classes6.dex */
    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        private Object readResolve() {
            return ObjectUtils.f32505II0xO0;
        }
    }

    public static double I0Io(double d) {
        return d;
    }

    public static short II0XooXoX(short s) {
        return s;
    }

    public static char II0xO0(char c) {
        return c;
    }

    public static boolean IIX0o(Object obj) {
        return !xXxxox0I(obj);
    }

    @SafeVarargs
    public static <T> T IIXOooo(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            return null;
        }
        return null;
    }

    public static String IO(Object obj, Supplier<String> supplier) {
        Object obj2;
        if (obj == null) {
            if (supplier != null) {
                obj2 = supplier.get();
                return (String) obj2;
            }
            return null;
        }
        return obj.toString();
    }

    public static <T extends Comparable<? super T>> int IXxxXO(T t, T t2) {
        return Oxx0xo(t, t2, false);
    }

    @SafeVarargs
    public static <T> T IoOoX(T... tArr) {
        if (!oxoX.o0IXXIx(tArr)) {
            return null;
        }
        HashMap hashMap = new HashMap(tArr.length);
        int i = 0;
        for (T t : tArr) {
            MutableInt mutableInt = (MutableInt) hashMap.get(t);
            if (mutableInt == null) {
                hashMap.put(t, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        while (true) {
            T t2 = null;
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((MutableInt) entry.getValue()).intValue();
                if (intValue == i) {
                    break;
                }
                if (intValue > i) {
                    t2 = (T) entry.getKey();
                    i = intValue;
                }
            }
            return t2;
        }
    }

    @Deprecated
    public static int O0xOxO(Object... objArr) {
        int i = 1;
        if (objArr != null) {
            for (Object obj : objArr) {
                i = (i * 31) + OxI(obj);
            }
        }
        return i;
    }

    public static short OOXIXo(int i) {
        if (i >= -32768 && i <= 32767) {
            return (short) i;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + i + "]");
    }

    public static <T> T Oo(T t) {
        T t2 = (T) x0xO0oo(t);
        if (t2 != null) {
            return t2;
        }
        return t;
    }

    @Deprecated
    public static int OxI(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static <T> T Oxx0IOOO(T t) {
        return t;
    }

    public static <T extends Comparable<? super T>> int Oxx0xo(T t, T t2, boolean z) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            if (!z) {
                return -1;
            }
            return 1;
        }
        if (t2 == null) {
            if (z) {
                return -1;
            }
            return 1;
        }
        return t.compareTo(t2);
    }

    @Deprecated
    public static boolean OxxIIOOXO(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj2 != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    @Deprecated
    public static String X00IoxXI(Object obj, String str) {
        if (obj != null) {
            return obj.toString();
        }
        return str;
    }

    public static String X0IIOO(Object obj) {
        if (obj == null) {
            return null;
        }
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        StringBuilder sb = new StringBuilder(name.length() + 1 + hexString.length());
        sb.append(name);
        sb.append(f32506oIX0oI);
        sb.append(hexString);
        return sb.toString();
    }

    public static int X0o0xo(int i) {
        return i;
    }

    public static void XI0IXoo(Appendable appendable, Object obj) throws IOException {
        xoIxX.xo0x(obj, "Cannot get the toString of a null object", new Object[0]);
        appendable.append(obj.getClass().getName()).append(f32506oIX0oI).append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void XIxXXX0x0(StringBuffer stringBuffer, Object obj) {
        xoIxX.xo0x(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        stringBuffer.ensureCapacity(stringBuffer.length() + name.length() + 1 + hexString.length());
        stringBuffer.append(name);
        stringBuffer.append(f32506oIX0oI);
        stringBuffer.append(hexString);
    }

    public static long XO(long j) {
        return j;
    }

    @Deprecated
    public static String Xx000oIo(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    @Deprecated
    public static void XxX0x0xxx(StrBuilder strBuilder, Object obj) {
        xoIxX.xo0x(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        strBuilder.ensureCapacity(strBuilder.length() + name.length() + 1 + hexString.length());
        strBuilder.append(name).append(f32506oIX0oI).append(hexString);
    }

    public static <T> T o00(T t, Supplier<T> supplier) {
        Object obj;
        if (t == null) {
            if (supplier != null) {
                obj = supplier.get();
                return (T) obj;
            }
            return null;
        }
        return t;
    }

    public static <T> T oI0IIXIo(T t, T t2) {
        return t != null ? t : t2;
    }

    public static byte oIX0oI(byte b) {
        return b;
    }

    public static boolean oO(Object... objArr) {
        return !oOoXoXO(objArr);
    }

    public static boolean oOXoIIIo(Object obj, Object obj2) {
        return !OxxIIOOXO(obj, obj2);
    }

    public static boolean oOoXoXO(Object... objArr) {
        if (objArr == null) {
            return false;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T oo(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (Oxx0xo(t2, t, true) < 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    @SafeVarargs
    public static <T> T oo0xXOI0I(Comparator<T> comparator, T... tArr) {
        xoIxX.I0oOoX(tArr, "null/empty items", new Object[0]);
        xoIxX.oOXoIIIo(tArr);
        xoIxX.xo0x(comparator, "null comparator", new Object[0]);
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static boolean ooOOo0oXI(Object... objArr) {
        return !x0XOIxOo(objArr);
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T ooXIXxIX(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (Oxx0xo(t2, t, false) > 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    public static float oxoX(float f) {
        return f;
    }

    public static boolean x0XOIxOo(Object... objArr) {
        if (IIXOooo(objArr) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T x0xO0oo(T t) {
        if (!(t instanceof Cloneable)) {
            return null;
        }
        if (t.getClass().isArray()) {
            Class<?> componentType = t.getClass().getComponentType();
            if (componentType.isPrimitive()) {
                int length = Array.getLength(t);
                T t2 = (T) Array.newInstance(componentType, length);
                while (true) {
                    int i = length - 1;
                    if (length > 0) {
                        Array.set(t2, i, Array.get(t, i));
                        length = i;
                    } else {
                        return t2;
                    }
                }
            } else {
                return (T) ((Object[]) t).clone();
            }
        } else {
            try {
                return (T) t.getClass().getMethod("clone", null).invoke(t, null);
            } catch (IllegalAccessException e) {
                throw new CloneFailedException("Cannot clone Cloneable type " + t.getClass().getName(), e);
            } catch (NoSuchMethodException e2) {
                throw new CloneFailedException("Cloneable type " + t.getClass().getName() + " has no clone method", e2);
            } catch (InvocationTargetException e3) {
                throw new CloneFailedException("Exception cloning Cloneable type " + t.getClass().getName(), e3.getCause());
            }
        }
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T xI(T... tArr) {
        xoIxX.XX(tArr);
        xoIxX.oOXoIIIo(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static boolean xXxxox0I(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            if (((CharSequence) obj).length() == 0) {
                return true;
            }
            return false;
        }
        if (obj.getClass().isArray()) {
            if (Array.getLength(obj) == 0) {
                return true;
            }
            return false;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return ((Map) obj).isEmpty();
    }

    public static byte xoIox(int i) {
        if (i >= -128 && i <= 127) {
            return (byte) i;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + i + "]");
    }

    @SafeVarargs
    public static <T> T xoXoI(Supplier<T>... supplierArr) {
        Object obj;
        if (supplierArr != null) {
            for (Supplier<T> supplier : supplierArr) {
                if (supplier != null) {
                    obj = supplier.get();
                    T t = (T) obj;
                    if (t != null) {
                        return t;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static boolean xxIXOIIO(boolean z) {
        return z;
    }

    public static void xxX(StringBuilder sb, Object obj) {
        xoIxX.xo0x(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        sb.ensureCapacity(sb.length() + name.length() + 1 + hexString.length());
        sb.append(name);
        sb.append(f32506oIX0oI);
        sb.append(hexString);
    }
}
