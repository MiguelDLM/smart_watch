package Ox00XOXoo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.xXOx;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class II0xO0 {
    public static Field I0Io(Class<?> cls, String str) {
        return oxoX(cls, str, false);
    }

    public static Field[] II0XooXoX(Class<?> cls, Class<? extends Annotation> cls2) {
        return (Field[]) Oxx0IOOO(cls, cls2).toArray(org.apache.commons.lang3.oxoX.f32770xoIox);
    }

    public static List<Field> II0xO0(Class<?> cls) {
        xoIxX.xo0x(cls, "The class must not be null", new Object[0]);
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            Collections.addAll(arrayList, cls.getDeclaredFields());
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static void IIX0o(Field field, Object obj) throws IllegalAccessException {
        ooXIXxIX(field, obj, false);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void IIXOooo(java.lang.reflect.Field r3, boolean r4) {
        /*
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "The field must not be null"
            org.apache.commons.lang3.xoIxX.xo0x(r3, r2, r1)
            int r1 = r3.getModifiers()     // Catch: java.lang.IllegalAccessException -> L25 java.lang.NoSuchFieldException -> L27
            boolean r1 = java.lang.reflect.Modifier.isFinal(r1)     // Catch: java.lang.IllegalAccessException -> L25 java.lang.NoSuchFieldException -> L27
            if (r1 == 0) goto L4d
            java.lang.Class<java.lang.reflect.Field> r1 = java.lang.reflect.Field.class
            java.lang.String r2 = "modifiers"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch: java.lang.IllegalAccessException -> L25 java.lang.NoSuchFieldException -> L27
            r2 = 1
            if (r4 == 0) goto L29
            boolean r4 = r1.isAccessible()     // Catch: java.lang.IllegalAccessException -> L25 java.lang.NoSuchFieldException -> L27
            if (r4 != 0) goto L29
            r4 = 1
            goto L2a
        L25:
            r3 = move-exception
            goto L45
        L27:
            r3 = move-exception
            goto L45
        L29:
            r4 = 0
        L2a:
            if (r4 == 0) goto L2f
            r1.setAccessible(r2)     // Catch: java.lang.IllegalAccessException -> L25 java.lang.NoSuchFieldException -> L27
        L2f:
            int r2 = r3.getModifiers()     // Catch: java.lang.Throwable -> L3e
            r2 = r2 & (-17)
            r1.setInt(r3, r2)     // Catch: java.lang.Throwable -> L3e
            if (r4 == 0) goto L4d
            r1.setAccessible(r0)     // Catch: java.lang.IllegalAccessException -> L25 java.lang.NoSuchFieldException -> L27
            goto L4d
        L3e:
            r3 = move-exception
            if (r4 == 0) goto L44
            r1.setAccessible(r0)     // Catch: java.lang.IllegalAccessException -> L25 java.lang.NoSuchFieldException -> L27
        L44:
            throw r3     // Catch: java.lang.IllegalAccessException -> L25 java.lang.NoSuchFieldException -> L27
        L45:
            org.apache.commons.lang3.JavaVersion r4 = org.apache.commons.lang3.JavaVersion.JAVA_12
            boolean r4 = org.apache.commons.lang3.XX0.x0XOIxOo(r4)
            if (r4 != 0) goto L4e
        L4d:
            return
        L4e:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "In java 12+ final cannot be removed."
            r4.<init>(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: Ox00XOXoo.II0xO0.IIXOooo(java.lang.reflect.Field, boolean):void");
    }

    public static Object IXxxXO(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        Field XO2 = XO(cls, str, z);
        xoIxX.xo0x(XO2, "Cannot locate field '%s' on %s", str, cls);
        return oI0IIXIo(XO2, false);
    }

    public static void O0xOxO(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field oxoX2 = oxoX(cls, str, z);
        xoIxX.xo0x(oxoX2, "Cannot locate declared field %s.%s", cls.getName(), str);
        xxX(oxoX2, null, obj, false);
    }

    public static Object OOXIXo(Class<?> cls, String str) throws IllegalAccessException {
        return oOoXoXO(cls, str, false);
    }

    public static Object Oo(Class<?> cls, String str) throws IllegalAccessException {
        return IXxxXO(cls, str, false);
    }

    public static void OxI(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        O0xOxO(cls, str, obj, false);
    }

    public static List<Field> Oxx0IOOO(Class<?> cls, Class<? extends Annotation> cls2) {
        xoIxX.xo0x(cls2, "The annotation class must not be null", new Object[0]);
        List<Field> II0xO02 = II0xO0(cls);
        ArrayList arrayList = new ArrayList();
        for (Field field : II0xO02) {
            if (field.getAnnotation(cls2) != null) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    public static Object Oxx0xo(Field field) throws IllegalAccessException {
        return oI0IIXIo(field, false);
    }

    public static void OxxIIOOXO(Field field) {
        IIXOooo(field, true);
    }

    public static void X0IIOO(Object obj, String str, Object obj2) throws IllegalAccessException {
        XI0IXoo(obj, str, obj2, false);
    }

    public static Field X0o0xo(Class<?> cls, String str) {
        Field XO2 = XO(cls, str, false);
        oxoX.oOoXoXO(XO2);
        return XO2;
    }

    public static void XI0IXoo(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        boolean z2;
        xoIxX.xo0x(obj, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field XO2 = XO(cls, str, z);
        if (XO2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "Cannot locate declared field %s.%s", cls.getName(), str);
        xxX(XO2, obj, obj2, false);
    }

    public static void XIxXXX0x0(Field field, Object obj, Object obj2) throws IllegalAccessException {
        xxX(field, obj, obj2, false);
    }

    public static Field XO(Class<?> cls, String str, boolean z) {
        boolean z2;
        Field declaredField;
        xoIxX.xo0x(cls, "The class must not be null", new Object[0]);
        xoIxX.XI0IXoo(xXOx.IIX0(str), "The field name must not be blank/empty", new Object[0]);
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                declaredField = cls2.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
            }
            if (!Modifier.isPublic(declaredField.getModifiers())) {
                if (z) {
                    declaredField.setAccessible(true);
                } else {
                    continue;
                }
            }
            return declaredField;
        }
        Iterator<Class<?>> it = ClassUtils.Oxx0IOOO(cls).iterator();
        Field field = null;
        while (it.hasNext()) {
            try {
                Field field2 = it.next().getField(str);
                if (field == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                xoIxX.XI0IXoo(z2, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field = field2;
            } catch (NoSuchFieldException unused2) {
            }
        }
        return field;
    }

    public static void XxX0x0xxx(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        xXxxox0I(cls, str, obj, false);
    }

    public static void o00(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        boolean z2;
        xoIxX.xo0x(obj, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field oxoX2 = oxoX(cls, str, z);
        if (oxoX2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "Cannot locate declared field %s.%s", cls.getName(), str);
        xxX(oxoX2, obj, obj2, false);
    }

    public static Object oI0IIXIo(Field field, boolean z) throws IllegalAccessException {
        xoIxX.xo0x(field, "The field must not be null", new Object[0]);
        xoIxX.XI0IXoo(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
        return x0xO0oo(field, null, z);
    }

    public static Field[] oIX0oI(Class<?> cls) {
        return (Field[]) II0xO0(cls).toArray(org.apache.commons.lang3.oxoX.f32770xoIox);
    }

    public static Object oO(Field field, Object obj) throws IllegalAccessException {
        return x0xO0oo(field, obj, false);
    }

    public static Object oOoXoXO(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        Field oxoX2 = oxoX(cls, str, z);
        xoIxX.xo0x(oxoX2, "Cannot locate declared field %s.%s", cls.getName(), str);
        return oI0IIXIo(oxoX2, false);
    }

    public static Object ooOOo0oXI(Object obj, String str) throws IllegalAccessException {
        return x0XOIxOo(obj, str, false);
    }

    public static void ooXIXxIX(Field field, Object obj, boolean z) throws IllegalAccessException {
        xoIxX.xo0x(field, "The field must not be null", new Object[0]);
        xoIxX.XI0IXoo(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
        xxX(field, null, obj, z);
    }

    public static Field oxoX(Class<?> cls, String str, boolean z) {
        xoIxX.xo0x(cls, "The class must not be null", new Object[0]);
        xoIxX.XI0IXoo(xXOx.IIX0(str), "The field name must not be blank/empty", new Object[0]);
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!oxoX.Oxx0IOOO(declaredField)) {
                if (!z) {
                    return null;
                }
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static Object x0XOIxOo(Object obj, String str, boolean z) throws IllegalAccessException {
        boolean z2;
        xoIxX.xo0x(obj, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field XO2 = XO(cls, str, z);
        if (XO2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "Cannot locate field %s on %s", str, cls);
        return x0xO0oo(XO2, obj, false);
    }

    public static Object x0xO0oo(Field field, Object obj, boolean z) throws IllegalAccessException {
        xoIxX.xo0x(field, "The field must not be null", new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            oxoX.oOoXoXO(field);
        }
        return field.get(obj);
    }

    public static void xXxxox0I(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field XO2 = XO(cls, str, z);
        xoIxX.xo0x(XO2, "Cannot locate field %s on %s", str, cls);
        ooXIXxIX(XO2, obj, false);
    }

    public static Object xoIox(Object obj, String str, boolean z) throws IllegalAccessException {
        boolean z2;
        xoIxX.xo0x(obj, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field oxoX2 = oxoX(cls, str, z);
        if (oxoX2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "Cannot locate declared field %s.%s", cls, str);
        return x0xO0oo(oxoX2, obj, false);
    }

    public static void xoXoI(Object obj, String str, Object obj2) throws IllegalAccessException {
        o00(obj, str, obj2, false);
    }

    public static Object xxIXOIIO(Object obj, String str) throws IllegalAccessException {
        return xoIox(obj, str, false);
    }

    public static void xxX(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        xoIxX.xo0x(field, "The field must not be null", new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            oxoX.oOoXoXO(field);
        }
        field.set(obj, obj2);
    }
}
