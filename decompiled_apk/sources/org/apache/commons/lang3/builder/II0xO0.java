package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

/* loaded from: classes6.dex */
public class II0xO0 implements oIX0oI<Integer> {

    /* renamed from: XO, reason: collision with root package name */
    public int f32647XO = 0;

    public static int O0xOxO(Object obj, Object obj2, Collection<String> collection) {
        return XIxXXX0x0(obj, obj2, ooOOo0oXI.ox(collection));
    }

    public static int OxI(Object obj, Object obj2) {
        return XI0IXoo(obj, obj2, false, null, new String[0]);
    }

    public static int X0IIOO(Object obj, Object obj2, boolean z) {
        return XI0IXoo(obj, obj2, z, null, new String[0]);
    }

    public static int XI0IXoo(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        if (obj == obj2) {
            return 0;
        }
        Objects.requireNonNull(obj, "lhs");
        Objects.requireNonNull(obj2, "rhs");
        Class<?> cls2 = obj.getClass();
        if (cls2.isInstance(obj2)) {
            II0xO0 iI0xO0 = new II0xO0();
            o00(obj, obj2, cls2, iI0xO0, z, strArr);
            while (cls2.getSuperclass() != null && cls2 != cls) {
                cls2 = cls2.getSuperclass();
                o00(obj, obj2, cls2, iI0xO0, z, strArr);
            }
            return iI0xO0.xxX();
        }
        throw new ClassCastException();
    }

    public static int XIxXXX0x0(Object obj, Object obj2, String... strArr) {
        return XI0IXoo(obj, obj2, false, null, strArr);
    }

    public static void o00(Object obj, Object obj2, Class<?> cls, II0xO0 iI0xO0, boolean z, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i = 0; i < declaredFields.length && iI0xO0.f32647XO == 0; i++) {
            Field field = declaredFields[i];
            if (!org.apache.commons.lang3.oxoX.xo0x(strArr, field.getName()) && !field.getName().contains("$") && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    iI0xO0.Oxx0IOOO(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException unused) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public II0xO0 I0Io(double d, double d2) {
        if (this.f32647XO != 0) {
            return this;
        }
        this.f32647XO = Double.compare(d, d2);
        return this;
    }

    public II0xO0 II0XooXoX(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (obj == obj2) {
            return this;
        }
        if (obj == null) {
            this.f32647XO = -1;
            return this;
        }
        if (obj2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (obj.getClass().isArray()) {
            OxxIIOOXO(obj, obj2, comparator);
        } else if (comparator == null) {
            this.f32647XO = ((Comparable) obj).compareTo(obj2);
        } else {
            this.f32647XO = comparator.compare(obj, obj2);
        }
        return this;
    }

    public II0xO0 II0xO0(char c, char c2) {
        if (this.f32647XO != 0) {
            return this;
        }
        this.f32647XO = Character.compare(c, c2);
        return this;
    }

    public II0xO0 IIXOooo(int i) {
        if (this.f32647XO != 0) {
            return this;
        }
        this.f32647XO = i;
        return this;
    }

    public II0xO0 IXxxXO(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (objArr == objArr2) {
            return this;
        }
        int i = -1;
        if (objArr == null) {
            this.f32647XO = -1;
            return this;
        }
        if (objArr2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (objArr.length != objArr2.length) {
            if (objArr.length >= objArr2.length) {
                i = 1;
            }
            this.f32647XO = i;
            return this;
        }
        for (int i2 = 0; i2 < objArr.length && this.f32647XO == 0; i2++) {
            II0XooXoX(objArr[i2], objArr2[i2], comparator);
        }
        return this;
    }

    public II0xO0 OOXIXo(byte[] bArr, byte[] bArr2) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (bArr == bArr2) {
            return this;
        }
        int i = -1;
        if (bArr == null) {
            this.f32647XO = -1;
            return this;
        }
        if (bArr2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (bArr.length != bArr2.length) {
            if (bArr.length >= bArr2.length) {
                i = 1;
            }
            this.f32647XO = i;
            return this;
        }
        for (int i2 = 0; i2 < bArr.length && this.f32647XO == 0; i2++) {
            oIX0oI(bArr[i2], bArr2[i2]);
        }
        return this;
    }

    public II0xO0 Oo(Object[] objArr, Object[] objArr2) {
        return IXxxXO(objArr, objArr2, null);
    }

    public II0xO0 Oxx0IOOO(Object obj, Object obj2) {
        return II0XooXoX(obj, obj2, null);
    }

    public II0xO0 Oxx0xo(short[] sArr, short[] sArr2) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (sArr == sArr2) {
            return this;
        }
        int i = -1;
        if (sArr == null) {
            this.f32647XO = -1;
            return this;
        }
        if (sArr2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (sArr.length != sArr2.length) {
            if (sArr.length >= sArr2.length) {
                i = 1;
            }
            this.f32647XO = i;
            return this;
        }
        for (int i2 = 0; i2 < sArr.length && this.f32647XO == 0; i2++) {
            xxIXOIIO(sArr[i2], sArr2[i2]);
        }
        return this;
    }

    public final void OxxIIOOXO(Object obj, Object obj2, Comparator<?> comparator) {
        if (obj instanceof long[]) {
            x0xO0oo((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            oO((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            Oxx0xo((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            oOoXoXO((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            OOXIXo((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            ooOOo0oXI((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            x0XOIxOo((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            oI0IIXIo((boolean[]) obj, (boolean[]) obj2);
        } else {
            IXxxXO((Object[]) obj, (Object[]) obj2, comparator);
        }
    }

    public II0xO0 X0o0xo(int i, int i2) {
        if (this.f32647XO != 0) {
            return this;
        }
        this.f32647XO = Integer.compare(i, i2);
        return this;
    }

    public II0xO0 XO(long j, long j2) {
        if (this.f32647XO != 0) {
            return this;
        }
        this.f32647XO = Long.compare(j, j2);
        return this;
    }

    public II0xO0 oI0IIXIo(boolean[] zArr, boolean[] zArr2) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (zArr == zArr2) {
            return this;
        }
        int i = -1;
        if (zArr == null) {
            this.f32647XO = -1;
            return this;
        }
        if (zArr2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (zArr.length != zArr2.length) {
            if (zArr.length >= zArr2.length) {
                i = 1;
            }
            this.f32647XO = i;
            return this;
        }
        for (int i2 = 0; i2 < zArr.length && this.f32647XO == 0; i2++) {
            xoIox(zArr[i2], zArr2[i2]);
        }
        return this;
    }

    public II0xO0 oIX0oI(byte b, byte b2) {
        if (this.f32647XO != 0) {
            return this;
        }
        this.f32647XO = Byte.compare(b, b2);
        return this;
    }

    public II0xO0 oO(int[] iArr, int[] iArr2) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (iArr == iArr2) {
            return this;
        }
        int i = -1;
        if (iArr == null) {
            this.f32647XO = -1;
            return this;
        }
        if (iArr2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (iArr.length != iArr2.length) {
            if (iArr.length >= iArr2.length) {
                i = 1;
            }
            this.f32647XO = i;
            return this;
        }
        for (int i2 = 0; i2 < iArr.length && this.f32647XO == 0; i2++) {
            X0o0xo(iArr[i2], iArr2[i2]);
        }
        return this;
    }

    public II0xO0 oOoXoXO(char[] cArr, char[] cArr2) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (cArr == cArr2) {
            return this;
        }
        int i = -1;
        if (cArr == null) {
            this.f32647XO = -1;
            return this;
        }
        if (cArr2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (cArr.length != cArr2.length) {
            if (cArr.length >= cArr2.length) {
                i = 1;
            }
            this.f32647XO = i;
            return this;
        }
        for (int i2 = 0; i2 < cArr.length && this.f32647XO == 0; i2++) {
            II0xO0(cArr[i2], cArr2[i2]);
        }
        return this;
    }

    public II0xO0 ooOOo0oXI(double[] dArr, double[] dArr2) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (dArr == dArr2) {
            return this;
        }
        int i = -1;
        if (dArr == null) {
            this.f32647XO = -1;
            return this;
        }
        if (dArr2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (dArr.length != dArr2.length) {
            if (dArr.length >= dArr2.length) {
                i = 1;
            }
            this.f32647XO = i;
            return this;
        }
        for (int i2 = 0; i2 < dArr.length && this.f32647XO == 0; i2++) {
            I0Io(dArr[i2], dArr2[i2]);
        }
        return this;
    }

    public II0xO0 oxoX(float f, float f2) {
        if (this.f32647XO != 0) {
            return this;
        }
        this.f32647XO = Float.compare(f, f2);
        return this;
    }

    public II0xO0 x0XOIxOo(float[] fArr, float[] fArr2) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (fArr == fArr2) {
            return this;
        }
        int i = -1;
        if (fArr == null) {
            this.f32647XO = -1;
            return this;
        }
        if (fArr2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (fArr.length != fArr2.length) {
            if (fArr.length >= fArr2.length) {
                i = 1;
            }
            this.f32647XO = i;
            return this;
        }
        for (int i2 = 0; i2 < fArr.length && this.f32647XO == 0; i2++) {
            oxoX(fArr[i2], fArr2[i2]);
        }
        return this;
    }

    public II0xO0 x0xO0oo(long[] jArr, long[] jArr2) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (jArr == jArr2) {
            return this;
        }
        int i = -1;
        if (jArr == null) {
            this.f32647XO = -1;
            return this;
        }
        if (jArr2 == null) {
            this.f32647XO = 1;
            return this;
        }
        if (jArr.length != jArr2.length) {
            if (jArr.length >= jArr2.length) {
                i = 1;
            }
            this.f32647XO = i;
            return this;
        }
        for (int i2 = 0; i2 < jArr.length && this.f32647XO == 0; i2++) {
            XO(jArr[i2], jArr2[i2]);
        }
        return this;
    }

    public II0xO0 xoIox(boolean z, boolean z2) {
        if (this.f32647XO != 0) {
            return this;
        }
        if (z == z2) {
            return this;
        }
        if (z) {
            this.f32647XO = 1;
        } else {
            this.f32647XO = -1;
        }
        return this;
    }

    @Override // org.apache.commons.lang3.builder.oIX0oI
    /* renamed from: xoXoI, reason: merged with bridge method [inline-methods] */
    public Integer build() {
        return Integer.valueOf(xxX());
    }

    public II0xO0 xxIXOIIO(short s, short s2) {
        if (this.f32647XO != 0) {
            return this;
        }
        this.f32647XO = Short.compare(s, s2);
        return this;
    }

    public int xxX() {
        return this.f32647XO;
    }
}
