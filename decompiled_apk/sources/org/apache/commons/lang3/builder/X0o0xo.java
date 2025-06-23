package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: classes6.dex */
public class X0o0xo implements oIX0oI<Boolean> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final ThreadLocal<Set<Pair<OOXIXo, OOXIXo>>> f32650IIXOooo = new ThreadLocal<>();

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public List<Class<?>> f32653Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f32655XO = true;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f32652Oo = false;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f32651IXxxXO = false;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Class<?> f32656oI0IIXIo = null;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String[] f32654OxxIIOOXO = null;

    public X0o0xo() {
        ArrayList arrayList = new ArrayList();
        this.f32653Oxx0xo = arrayList;
        arrayList.add(String.class);
    }

    public static void IIX0o(Object obj, Object obj2) {
        Set<Pair<OOXIXo, OOXIXo>> xoXoI2 = xoXoI();
        if (xoXoI2 == null) {
            xoXoI2 = new HashSet<>();
            f32650IIXOooo.set(xoXoI2);
        }
        xoXoI2.add(IIXOooo(obj, obj2));
    }

    public static Pair<OOXIXo, OOXIXo> IIXOooo(Object obj, Object obj2) {
        return Pair.of(new OOXIXo(obj), new OOXIXo(obj2));
    }

    public static boolean OxI(Object obj, Object obj2) {
        Set<Pair<OOXIXo, OOXIXo>> xoXoI2 = xoXoI();
        Pair<OOXIXo, OOXIXo> IIXOooo2 = IIXOooo(obj, obj2);
        Pair of = Pair.of(IIXOooo2.getRight(), IIXOooo2.getLeft());
        if (xoXoI2 != null && (xoXoI2.contains(IIXOooo2) || xoXoI2.contains(of))) {
            return true;
        }
        return false;
    }

    public static void X00IoxXI(Object obj, Object obj2) {
        Set<Pair<OOXIXo, OOXIXo>> xoXoI2 = xoXoI();
        if (xoXoI2 != null) {
            xoXoI2.remove(IIXOooo(obj, obj2));
            if (xoXoI2.isEmpty()) {
                f32650IIXOooo.remove();
            }
        }
    }

    public static boolean XI0IXoo(Object obj, Object obj2, Collection<String> collection) {
        return xXxxox0I(obj, obj2, ooOOo0oXI.ox(collection));
    }

    public static boolean XIxXXX0x0(Object obj, Object obj2, boolean z) {
        return XxX0x0xxx(obj, obj2, z, null, new String[0]);
    }

    public static boolean XxX0x0xxx(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        return xxX(obj, obj2, z, cls, false, strArr);
    }

    public static boolean xXxxox0I(Object obj, Object obj2, String... strArr) {
        return XxX0x0xxx(obj, obj2, false, null, strArr);
    }

    public static Set<Pair<OOXIXo, OOXIXo>> xoXoI() {
        return f32650IIXOooo.get();
    }

    public static boolean xxX(Object obj, Object obj2, boolean z, Class<?> cls, boolean z2, String... strArr) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj2 != null) {
            return new X0o0xo().oo(strArr).IoOoX(cls).Xx000oIo(z).oOXoIIIo(z2).O0xOxO(obj, obj2).o00();
        }
        return false;
    }

    public X0o0xo I0Io(double d, double d2) {
        if (!this.f32655XO) {
            return this;
        }
        return XO(Double.doubleToLongBits(d), Double.doubleToLongBits(d2));
    }

    public X0o0xo II0XooXoX(short s, short s2) {
        boolean z;
        if (!this.f32655XO) {
            return this;
        }
        if (s == s2) {
            z = true;
        } else {
            z = false;
        }
        this.f32655XO = z;
        return this;
    }

    public X0o0xo II0xO0(char c, char c2) {
        boolean z;
        if (!this.f32655XO) {
            return this;
        }
        if (c == c2) {
            z = true;
        } else {
            z = false;
        }
        this.f32655XO = z;
        return this;
    }

    public X0o0xo IXxxXO(boolean[] zArr, boolean[] zArr2) {
        if (!this.f32655XO) {
            return this;
        }
        if (zArr == zArr2) {
            return this;
        }
        if (zArr != null && zArr2 != null) {
            if (zArr.length != zArr2.length) {
                oo0xXOI0I(false);
                return this;
            }
            for (int i = 0; i < zArr.length && this.f32655XO; i++) {
                xxIXOIIO(zArr[i], zArr2[i]);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public X0o0xo IoOoX(Class<?> cls) {
        this.f32656oI0IIXIo = cls;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        if (r2.isInstance(r6) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0031, code lost:
    
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x002d, code lost:
    
        if (r1.isInstance(r7) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.apache.commons.lang3.builder.X0o0xo O0xOxO(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            boolean r0 = r5.f32655XO
            if (r0 != 0) goto L5
            return r5
        L5:
            if (r6 != r7) goto L8
            return r5
        L8:
            r0 = 0
            if (r6 == 0) goto L71
            if (r7 != 0) goto Le
            goto L71
        Le:
            java.lang.Class r1 = r6.getClass()
            java.lang.Class r2 = r7.getClass()
            boolean r3 = r1.isInstance(r7)
            if (r3 == 0) goto L23
            boolean r3 = r2.isInstance(r6)
            if (r3 != 0) goto L2f
            goto L31
        L23:
            boolean r3 = r2.isInstance(r6)
            if (r3 == 0) goto L6e
            boolean r3 = r1.isInstance(r7)
            if (r3 != 0) goto L31
        L2f:
            r3 = r1
            goto L32
        L31:
            r3 = r2
        L32:
            boolean r4 = r3.isArray()     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r4 == 0) goto L3c
            r5.Oxx0IOOO(r6, r7)     // Catch: java.lang.IllegalArgumentException -> L6b
            goto L6a
        L3c:
            java.util.List<java.lang.Class<?>> r4 = r5.f32653Oxx0xo     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r4 == 0) goto L55
            boolean r1 = r4.contains(r1)     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r1 != 0) goto L4e
            java.util.List<java.lang.Class<?>> r1 = r5.f32653Oxx0xo     // Catch: java.lang.IllegalArgumentException -> L6b
            boolean r1 = r1.contains(r2)     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r1 == 0) goto L55
        L4e:
            boolean r6 = r6.equals(r7)     // Catch: java.lang.IllegalArgumentException -> L6b
            r5.f32655XO = r6     // Catch: java.lang.IllegalArgumentException -> L6b
            goto L6a
        L55:
            r5.X0IIOO(r6, r7, r3)     // Catch: java.lang.IllegalArgumentException -> L6b
        L58:
            java.lang.Class r1 = r3.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r1 == 0) goto L6a
            java.lang.Class<?> r1 = r5.f32656oI0IIXIo     // Catch: java.lang.IllegalArgumentException -> L6b
            if (r3 == r1) goto L6a
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L6b
            r5.X0IIOO(r6, r7, r3)     // Catch: java.lang.IllegalArgumentException -> L6b
            goto L58
        L6a:
            return r5
        L6b:
            r5.f32655XO = r0
            return r5
        L6e:
            r5.f32655XO = r0
            return r5
        L71:
            r5.f32655XO = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.builder.X0o0xo.O0xOxO(java.lang.Object, java.lang.Object):org.apache.commons.lang3.builder.X0o0xo");
    }

    public X0o0xo OOXIXo(char[] cArr, char[] cArr2) {
        if (!this.f32655XO) {
            return this;
        }
        if (cArr == cArr2) {
            return this;
        }
        if (cArr != null && cArr2 != null) {
            if (cArr.length != cArr2.length) {
                oo0xXOI0I(false);
                return this;
            }
            for (int i = 0; i < cArr.length && this.f32655XO; i++) {
                II0xO0(cArr[i], cArr2[i]);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public X0o0xo Oo(short[] sArr, short[] sArr2) {
        if (!this.f32655XO) {
            return this;
        }
        if (sArr == sArr2) {
            return this;
        }
        if (sArr != null && sArr2 != null) {
            if (sArr.length != sArr2.length) {
                oo0xXOI0I(false);
                return this;
            }
            for (int i = 0; i < sArr.length && this.f32655XO; i++) {
                II0XooXoX(sArr[i], sArr2[i]);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public X0o0xo Oxx0IOOO(Object obj, Object obj2) {
        if (!this.f32655XO) {
            return this;
        }
        if (obj == obj2) {
            return this;
        }
        if (obj != null && obj2 != null) {
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                Oxx0xo(obj, obj2);
            } else if (this.f32651IXxxXO && !ClassUtils.Io(cls)) {
                O0xOxO(obj, obj2);
            } else {
                this.f32655XO = obj.equals(obj2);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public final void Oxx0xo(Object obj, Object obj2) {
        if (obj.getClass() != obj2.getClass()) {
            oo0xXOI0I(false);
            return;
        }
        if (obj instanceof long[]) {
            oO((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            x0XOIxOo((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            Oo((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            OOXIXo((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            xoIox((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            oOoXoXO((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            ooOOo0oXI((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            IXxxXO((boolean[]) obj, (boolean[]) obj2);
        } else {
            x0xO0oo((Object[]) obj, (Object[]) obj2);
        }
    }

    @Override // org.apache.commons.lang3.builder.oIX0oI
    /* renamed from: OxxIIOOXO, reason: merged with bridge method [inline-methods] */
    public Boolean build() {
        return Boolean.valueOf(o00());
    }

    public final void X0IIOO(Object obj, Object obj2, Class<?> cls) {
        if (OxI(obj, obj2)) {
            return;
        }
        try {
            IIX0o(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i = 0; i < declaredFields.length && this.f32655XO; i++) {
                Field field = declaredFields[i];
                if (!org.apache.commons.lang3.oxoX.xo0x(this.f32654OxxIIOOXO, field.getName())) {
                    if (field.getName().contains("$")) {
                        continue;
                    } else {
                        if (!this.f32652Oo && Modifier.isTransient(field.getModifiers())) {
                        }
                        if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(XO.class)) {
                            try {
                                Oxx0IOOO(field.get(obj), field.get(obj2));
                            } catch (IllegalAccessException unused) {
                                throw new InternalError("Unexpected IllegalAccessException");
                            }
                        }
                    }
                }
            }
            X00IoxXI(obj, obj2);
        } catch (Throwable th) {
            X00IoxXI(obj, obj2);
            throw th;
        }
    }

    public X0o0xo X0o0xo(int i, int i2) {
        boolean z;
        if (!this.f32655XO) {
            return this;
        }
        if (i == i2) {
            z = true;
        } else {
            z = false;
        }
        this.f32655XO = z;
        return this;
    }

    public X0o0xo XO(long j, long j2) {
        boolean z;
        if (!this.f32655XO) {
            return this;
        }
        if (j == j2) {
            z = true;
        } else {
            z = false;
        }
        this.f32655XO = z;
        return this;
    }

    public X0o0xo Xx000oIo(boolean z) {
        this.f32652Oo = z;
        return this;
    }

    public boolean o00() {
        return this.f32655XO;
    }

    public X0o0xo oI0IIXIo(boolean z) {
        if (!this.f32655XO) {
            return this;
        }
        this.f32655XO = z;
        return this;
    }

    public X0o0xo oIX0oI(byte b, byte b2) {
        boolean z;
        if (!this.f32655XO) {
            return this;
        }
        if (b == b2) {
            z = true;
        } else {
            z = false;
        }
        this.f32655XO = z;
        return this;
    }

    public X0o0xo oO(long[] jArr, long[] jArr2) {
        if (!this.f32655XO) {
            return this;
        }
        if (jArr == jArr2) {
            return this;
        }
        if (jArr != null && jArr2 != null) {
            if (jArr.length != jArr2.length) {
                oo0xXOI0I(false);
                return this;
            }
            for (int i = 0; i < jArr.length && this.f32655XO; i++) {
                XO(jArr[i], jArr2[i]);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public X0o0xo oOXoIIIo(boolean z) {
        this.f32651IXxxXO = z;
        return this;
    }

    public X0o0xo oOoXoXO(double[] dArr, double[] dArr2) {
        if (!this.f32655XO) {
            return this;
        }
        if (dArr == dArr2) {
            return this;
        }
        if (dArr != null && dArr2 != null) {
            if (dArr.length != dArr2.length) {
                oo0xXOI0I(false);
                return this;
            }
            for (int i = 0; i < dArr.length && this.f32655XO; i++) {
                I0Io(dArr[i], dArr2[i]);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public X0o0xo oo(String... strArr) {
        this.f32654OxxIIOOXO = strArr;
        return this;
    }

    public void oo0xXOI0I(boolean z) {
        this.f32655XO = z;
    }

    public X0o0xo ooOOo0oXI(float[] fArr, float[] fArr2) {
        if (!this.f32655XO) {
            return this;
        }
        if (fArr == fArr2) {
            return this;
        }
        if (fArr != null && fArr2 != null) {
            if (fArr.length != fArr2.length) {
                oo0xXOI0I(false);
                return this;
            }
            for (int i = 0; i < fArr.length && this.f32655XO; i++) {
                oxoX(fArr[i], fArr2[i]);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public void ooXIXxIX() {
        this.f32655XO = true;
    }

    public X0o0xo oxoX(float f, float f2) {
        if (!this.f32655XO) {
            return this;
        }
        return X0o0xo(Float.floatToIntBits(f), Float.floatToIntBits(f2));
    }

    public X0o0xo x0XOIxOo(int[] iArr, int[] iArr2) {
        if (!this.f32655XO) {
            return this;
        }
        if (iArr == iArr2) {
            return this;
        }
        if (iArr != null && iArr2 != null) {
            if (iArr.length != iArr2.length) {
                oo0xXOI0I(false);
                return this;
            }
            for (int i = 0; i < iArr.length && this.f32655XO; i++) {
                X0o0xo(iArr[i], iArr2[i]);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public X0o0xo x0xO0oo(Object[] objArr, Object[] objArr2) {
        if (!this.f32655XO) {
            return this;
        }
        if (objArr == objArr2) {
            return this;
        }
        if (objArr != null && objArr2 != null) {
            if (objArr.length != objArr2.length) {
                oo0xXOI0I(false);
                return this;
            }
            for (int i = 0; i < objArr.length && this.f32655XO; i++) {
                Oxx0IOOO(objArr[i], objArr2[i]);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public X0o0xo xI(List<Class<?>> list) {
        this.f32653Oxx0xo = list;
        return this;
    }

    public X0o0xo xoIox(byte[] bArr, byte[] bArr2) {
        if (!this.f32655XO) {
            return this;
        }
        if (bArr == bArr2) {
            return this;
        }
        if (bArr != null && bArr2 != null) {
            if (bArr.length != bArr2.length) {
                oo0xXOI0I(false);
                return this;
            }
            for (int i = 0; i < bArr.length && this.f32655XO; i++) {
                oIX0oI(bArr[i], bArr2[i]);
            }
            return this;
        }
        oo0xXOI0I(false);
        return this;
    }

    public X0o0xo xxIXOIIO(boolean z, boolean z2) {
        boolean z3;
        if (!this.f32655XO) {
            return this;
        }
        if (z == z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f32655XO = z3;
        return this;
    }
}
