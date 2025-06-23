package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class xxIXOIIO implements oIX0oI<Integer> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f32669IXxxXO = 17;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f32670Oxx0xo = 37;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final ThreadLocal<Set<OOXIXo>> f32671oI0IIXIo = new ThreadLocal<>();

    /* renamed from: Oo, reason: collision with root package name */
    public int f32672Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f32673XO;

    public xxIXOIIO() {
        this.f32673XO = 37;
        this.f32672Oo = 17;
    }

    public static void IIX0o(Object obj) {
        Set<OOXIXo> IIXOooo2 = IIXOooo();
        if (IIXOooo2 != null) {
            IIXOooo2.remove(new OOXIXo(obj));
            if (IIXOooo2.isEmpty()) {
                f32671oI0IIXIo.remove();
            }
        }
    }

    public static Set<OOXIXo> IIXOooo() {
        return f32671oI0IIXIo.get();
    }

    public static int O0xOxO(int i, int i2, Object obj, boolean z) {
        return X0IIOO(i, i2, obj, z, null, new String[0]);
    }

    public static int OxI(int i, int i2, Object obj) {
        return X0IIOO(i, i2, obj, false, null, new String[0]);
    }

    public static <T> int X0IIOO(int i, int i2, T t, boolean z, Class<? super T> cls, String... strArr) {
        xoIxX.xo0x(t, "The object to build a hash code for must not be null", new Object[0]);
        xxIXOIIO xxixoiio = new xxIXOIIO(i, i2);
        Class<?> cls2 = t.getClass();
        o00(t, cls2, xxixoiio, z, strArr);
        while (cls2.getSuperclass() != null && cls2 != cls) {
            cls2 = cls2.getSuperclass();
            o00(t, cls2, xxixoiio, z, strArr);
        }
        return xxixoiio.xXxxox0I();
    }

    public static int XI0IXoo(Object obj, Collection<String> collection) {
        return xxX(obj, ooOOo0oXI.ox(collection));
    }

    public static int XIxXXX0x0(Object obj, boolean z) {
        return X0IIOO(17, 37, obj, z, null, new String[0]);
    }

    public static void XxX0x0xxx(Object obj) {
        Set<OOXIXo> IIXOooo2 = IIXOooo();
        if (IIXOooo2 == null) {
            IIXOooo2 = new HashSet<>();
            f32671oI0IIXIo.set(IIXOooo2);
        }
        IIXOooo2.add(new OOXIXo(obj));
    }

    public static void o00(Object obj, Class<?> cls, xxIXOIIO xxixoiio, boolean z, String[] strArr) {
        Comparator comparing;
        if (xoXoI(obj)) {
            return;
        }
        try {
            XxX0x0xxx(obj);
            Field[] declaredFields = cls.getDeclaredFields();
            comparing = Comparator.comparing(new II0XooXoX());
            Arrays.sort(declaredFields, comparing);
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                if (!org.apache.commons.lang3.oxoX.xo0x(strArr, field.getName())) {
                    if (field.getName().contains("$")) {
                        continue;
                    } else {
                        if (!z && Modifier.isTransient(field.getModifiers())) {
                        }
                        if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(xoIox.class)) {
                            try {
                                xxixoiio.Oxx0IOOO(field.get(obj));
                            } catch (IllegalAccessException unused) {
                                throw new InternalError("Unexpected IllegalAccessException");
                            }
                        }
                    }
                }
            }
            IIX0o(obj);
        } catch (Throwable th) {
            IIX0o(obj);
            throw th;
        }
    }

    public static boolean xoXoI(Object obj) {
        Set<OOXIXo> IIXOooo2 = IIXOooo();
        if (IIXOooo2 != null && IIXOooo2.contains(new OOXIXo(obj))) {
            return true;
        }
        return false;
    }

    public static int xxX(Object obj, String... strArr) {
        return X0IIOO(17, 37, obj, false, null, strArr);
    }

    public xxIXOIIO I0Io(double d) {
        return XO(Double.doubleToLongBits(d));
    }

    public xxIXOIIO II0XooXoX(short s) {
        this.f32672Oo = (this.f32672Oo * this.f32673XO) + s;
        return this;
    }

    public xxIXOIIO II0xO0(char c) {
        this.f32672Oo = (this.f32672Oo * this.f32673XO) + c;
        return this;
    }

    public xxIXOIIO IXxxXO(boolean[] zArr) {
        if (zArr == null) {
            this.f32672Oo *= this.f32673XO;
        } else {
            for (boolean z : zArr) {
                xxIXOIIO(z);
            }
        }
        return this;
    }

    public xxIXOIIO OOXIXo(char[] cArr) {
        if (cArr == null) {
            this.f32672Oo *= this.f32673XO;
        } else {
            for (char c : cArr) {
                II0xO0(c);
            }
        }
        return this;
    }

    public xxIXOIIO Oo(short[] sArr) {
        if (sArr == null) {
            this.f32672Oo *= this.f32673XO;
        } else {
            for (short s : sArr) {
                II0XooXoX(s);
            }
        }
        return this;
    }

    public xxIXOIIO Oxx0IOOO(Object obj) {
        if (obj == null) {
            this.f32672Oo *= this.f32673XO;
        } else if (obj.getClass().isArray()) {
            Oxx0xo(obj);
        } else {
            this.f32672Oo = (this.f32672Oo * this.f32673XO) + obj.hashCode();
        }
        return this;
    }

    public final void Oxx0xo(Object obj) {
        if (obj instanceof long[]) {
            oO((long[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            x0XOIxOo((int[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            Oo((short[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            OOXIXo((char[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            xoIox((byte[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            oOoXoXO((double[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            ooOOo0oXI((float[]) obj);
        } else if (obj instanceof boolean[]) {
            IXxxXO((boolean[]) obj);
        } else {
            x0xO0oo((Object[]) obj);
        }
    }

    @Override // org.apache.commons.lang3.builder.oIX0oI
    /* renamed from: OxxIIOOXO, reason: merged with bridge method [inline-methods] */
    public Integer build() {
        return Integer.valueOf(xXxxox0I());
    }

    public xxIXOIIO X0o0xo(int i) {
        this.f32672Oo = (this.f32672Oo * this.f32673XO) + i;
        return this;
    }

    public xxIXOIIO XO(long j) {
        this.f32672Oo = (this.f32672Oo * this.f32673XO) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public int hashCode() {
        return xXxxox0I();
    }

    public xxIXOIIO oI0IIXIo(int i) {
        this.f32672Oo = (this.f32672Oo * this.f32673XO) + i;
        return this;
    }

    public xxIXOIIO oIX0oI(byte b) {
        this.f32672Oo = (this.f32672Oo * this.f32673XO) + b;
        return this;
    }

    public xxIXOIIO oO(long[] jArr) {
        if (jArr == null) {
            this.f32672Oo *= this.f32673XO;
        } else {
            for (long j : jArr) {
                XO(j);
            }
        }
        return this;
    }

    public xxIXOIIO oOoXoXO(double[] dArr) {
        if (dArr == null) {
            this.f32672Oo *= this.f32673XO;
        } else {
            for (double d : dArr) {
                I0Io(d);
            }
        }
        return this;
    }

    public xxIXOIIO ooOOo0oXI(float[] fArr) {
        if (fArr == null) {
            this.f32672Oo *= this.f32673XO;
        } else {
            for (float f : fArr) {
                oxoX(f);
            }
        }
        return this;
    }

    public xxIXOIIO oxoX(float f) {
        this.f32672Oo = (this.f32672Oo * this.f32673XO) + Float.floatToIntBits(f);
        return this;
    }

    public xxIXOIIO x0XOIxOo(int[] iArr) {
        if (iArr == null) {
            this.f32672Oo *= this.f32673XO;
        } else {
            for (int i : iArr) {
                X0o0xo(i);
            }
        }
        return this;
    }

    public xxIXOIIO x0xO0oo(Object[] objArr) {
        if (objArr == null) {
            this.f32672Oo *= this.f32673XO;
        } else {
            for (Object obj : objArr) {
                Oxx0IOOO(obj);
            }
        }
        return this;
    }

    public int xXxxox0I() {
        return this.f32672Oo;
    }

    public xxIXOIIO xoIox(byte[] bArr) {
        if (bArr == null) {
            this.f32672Oo *= this.f32673XO;
        } else {
            for (byte b : bArr) {
                oIX0oI(b);
            }
        }
        return this;
    }

    public xxIXOIIO xxIXOIIO(boolean z) {
        this.f32672Oo = (this.f32672Oo * this.f32673XO) + (!z ? 1 : 0);
        return this;
    }

    public xxIXOIIO(int i, int i2) {
        this.f32672Oo = 0;
        xoIxX.XI0IXoo(i % 2 != 0, "HashCodeBuilder requires an odd initial value", new Object[0]);
        xoIxX.XI0IXoo(i2 % 2 != 0, "HashCodeBuilder requires an odd multiplier", new Object[0]);
        this.f32673XO = i2;
        this.f32672Oo = i;
    }
}
