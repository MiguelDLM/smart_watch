package org.apache.commons.lang3;

import XXO0.oIX0oI;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.lang3.builder.ToStringStyle;

/* loaded from: classes6.dex */
public class AnnotationUtils {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final ToStringStyle f32462oIX0oI = new ToStringStyle() { // from class: org.apache.commons.lang3.AnnotationUtils.1
        private static final long serialVersionUID = 1;

        {
            setDefaultFullDetail(true);
            setArrayContentDetail(true);
            setUseClassName(true);
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
            setContentStart(oIX0oI.I0Io.f4096II0xO0);
            setContentEnd(oIX0oI.I0Io.f4095I0Io);
            setFieldSeparator(", ");
            setArrayStart("[");
            setArrayEnd("]");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
            if (obj instanceof Annotation) {
                obj = AnnotationUtils.xxIXOIIO((Annotation) obj);
            }
            super.appendDetail(stringBuffer, str, obj);
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public String getShortClassName(Class<?> cls) {
            for (Class<?> cls2 : ClassUtils.Oxx0IOOO(cls)) {
                if (Annotation.class.isAssignableFrom(cls2)) {
                    return "@" + cls2.getName();
                }
            }
            return "";
        }
    };

    public static int I0Io(Class<?> cls, Object obj) {
        if (cls.equals(Byte.TYPE)) {
            return Arrays.hashCode((byte[]) obj);
        }
        if (cls.equals(Short.TYPE)) {
            return Arrays.hashCode((short[]) obj);
        }
        if (cls.equals(Integer.TYPE)) {
            return Arrays.hashCode((int[]) obj);
        }
        if (cls.equals(Character.TYPE)) {
            return Arrays.hashCode((char[]) obj);
        }
        if (cls.equals(Long.TYPE)) {
            return Arrays.hashCode((long[]) obj);
        }
        if (cls.equals(Float.TYPE)) {
            return Arrays.hashCode((float[]) obj);
        }
        if (cls.equals(Double.TYPE)) {
            return Arrays.hashCode((double[]) obj);
        }
        if (cls.equals(Boolean.TYPE)) {
            return Arrays.hashCode((boolean[]) obj);
        }
        return Arrays.hashCode((Object[]) obj);
    }

    public static boolean II0XooXoX(Class<?> cls, Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj2 != null) {
            if (cls.isArray()) {
                return II0xO0(cls.getComponentType(), obj, obj2);
            }
            if (cls.isAnnotation()) {
                return oxoX((Annotation) obj, (Annotation) obj2);
            }
            return obj.equals(obj2);
        }
        return false;
    }

    public static boolean II0xO0(Class<?> cls, Object obj, Object obj2) {
        if (cls.isAnnotation()) {
            return oIX0oI((Annotation[]) obj, (Annotation[]) obj2);
        }
        if (cls.equals(Byte.TYPE)) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        if (cls.equals(Short.TYPE)) {
            return Arrays.equals((short[]) obj, (short[]) obj2);
        }
        if (cls.equals(Integer.TYPE)) {
            return Arrays.equals((int[]) obj, (int[]) obj2);
        }
        if (cls.equals(Character.TYPE)) {
            return Arrays.equals((char[]) obj, (char[]) obj2);
        }
        if (cls.equals(Long.TYPE)) {
            return Arrays.equals((long[]) obj, (long[]) obj2);
        }
        if (cls.equals(Float.TYPE)) {
            return Arrays.equals((float[]) obj, (float[]) obj2);
        }
        if (cls.equals(Double.TYPE)) {
            return Arrays.equals((double[]) obj, (double[]) obj2);
        }
        if (cls.equals(Boolean.TYPE)) {
            return Arrays.equals((boolean[]) obj, (boolean[]) obj2);
        }
        return Arrays.equals((Object[]) obj, (Object[]) obj2);
    }

    public static boolean Oxx0IOOO(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        if (!cls.isPrimitive() && !cls.isEnum() && !cls.isAnnotation() && !String.class.equals(cls) && !Class.class.equals(cls)) {
            return false;
        }
        return true;
    }

    public static int X0o0xo(Annotation annotation) {
        int i = 0;
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            try {
                Object invoke = method.invoke(annotation, null);
                if (invoke != null) {
                    i += XO(method.getName(), invoke);
                } else {
                    throw new IllegalStateException(String.format("Annotation method %s returned null", method));
                }
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return i;
    }

    public static int XO(String str, Object obj) {
        int hashCode;
        int hashCode2 = str.hashCode() * 127;
        if (obj.getClass().isArray()) {
            hashCode = I0Io(obj.getClass().getComponentType(), obj);
        } else if (obj instanceof Annotation) {
            hashCode = X0o0xo((Annotation) obj);
        } else {
            hashCode = obj.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public static boolean oIX0oI(Annotation[] annotationArr, Annotation[] annotationArr2) {
        if (annotationArr.length != annotationArr2.length) {
            return false;
        }
        for (int i = 0; i < annotationArr.length; i++) {
            if (!oxoX(annotationArr[i], annotationArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean oxoX(Annotation annotation, Annotation annotation2) {
        if (annotation == annotation2) {
            return true;
        }
        if (annotation != null && annotation2 != null) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            Class<? extends Annotation> annotationType2 = annotation2.annotationType();
            xoIxX.xo0x(annotationType, "Annotation %s with null annotationType()", annotation);
            xoIxX.xo0x(annotationType2, "Annotation %s with null annotationType()", annotation2);
            if (!annotationType.equals(annotationType2)) {
                return false;
            }
            try {
                for (Method method : annotationType.getDeclaredMethods()) {
                    if (method.getParameterTypes().length == 0 && Oxx0IOOO(method.getReturnType()) && !II0XooXoX(method.getReturnType(), method.invoke(annotation, null), method.invoke(annotation2, null))) {
                        return false;
                    }
                }
                return true;
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return false;
    }

    public static String xxIXOIIO(Annotation annotation) {
        org.apache.commons.lang3.builder.x0XOIxOo x0xoixoo = new org.apache.commons.lang3.builder.x0XOIxOo(annotation, f32462oIX0oI);
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            if (method.getParameterTypes().length <= 0) {
                try {
                    x0xoixoo.x0XOIxOo(method.getName(), method.invoke(annotation, null));
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return x0xoixoo.build();
    }
}
