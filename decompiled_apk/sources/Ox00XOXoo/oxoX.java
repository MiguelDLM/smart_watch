package Ox00XOXoo;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes6.dex */
public abstract class oxoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Class<?>[] f2755II0xO0 = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f2756oIX0oI = 7;

    public static int I0Io(oIX0oI oix0oi, oIX0oI oix0oi2, Class<?>[] clsArr) {
        return Float.compare(XO(clsArr, oix0oi), XO(clsArr, oix0oi2));
    }

    public static boolean II0XooXoX(Constructor<?> constructor, Class<?>[] clsArr) {
        return xxIXOIIO(oIX0oI.X0o0xo(constructor), clsArr);
    }

    public static int II0xO0(Method method, Method method2, Class<?>[] clsArr) {
        return I0Io(oIX0oI.XO(method), oIX0oI.XO(method2), clsArr);
    }

    public static boolean OOXIXo(int i) {
        if ((i & 7) == 0) {
            return true;
        }
        return false;
    }

    public static boolean Oxx0IOOO(Member member) {
        if (member != null && Modifier.isPublic(member.getModifiers()) && !member.isSynthetic()) {
            return true;
        }
        return false;
    }

    public static float X0o0xo(Class<?> cls, Class<?> cls2) {
        float f;
        if (cls == null) {
            return 1.5f;
        }
        if (!cls.isPrimitive()) {
            cls = ClassUtils.XX0(cls);
            f = 0.1f;
        } else {
            f = 0.0f;
        }
        int i = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = f2755II0xO0;
            if (i >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i]) {
                f += 0.1f;
                if (i < clsArr.length - 1) {
                    cls = clsArr[i + 1];
                }
            }
            i++;
        }
        return f;
    }

    public static float XO(Class<?>[] clsArr, oIX0oI oix0oi) {
        boolean z;
        float oxoX2;
        Class<?>[] I0Io2 = oix0oi.I0Io();
        boolean oxoX3 = oix0oi.oxoX();
        int length = I0Io2.length;
        if (oxoX3) {
            length--;
        }
        long j = length;
        if (clsArr.length < j) {
            return Float.MAX_VALUE;
        }
        boolean z2 = false;
        float f = 0.0f;
        for (int i = 0; i < j; i++) {
            f += oxoX(clsArr[i], I0Io2[i]);
        }
        if (oxoX3) {
            if (clsArr.length < I0Io2.length) {
                z = true;
            } else {
                z = false;
            }
            if (clsArr.length == I0Io2.length && clsArr[clsArr.length - 1] != null && clsArr[clsArr.length - 1].isArray()) {
                z2 = true;
            }
            Class<?> componentType = I0Io2[I0Io2.length - 1].getComponentType();
            if (z) {
                oxoX2 = oxoX(componentType, Object.class);
            } else if (z2) {
                oxoX2 = oxoX(clsArr[clsArr.length - 1].getComponentType(), componentType);
            } else {
                for (int length2 = I0Io2.length - 1; length2 < clsArr.length; length2++) {
                    f += oxoX(clsArr[length2], componentType) + 0.001f;
                }
                return f;
            }
            return f + oxoX2 + 0.001f;
        }
        return f;
    }

    public static int oIX0oI(Constructor<?> constructor, Constructor<?> constructor2, Class<?>[] clsArr) {
        return I0Io(oIX0oI.X0o0xo(constructor), oIX0oI.X0o0xo(constructor2), clsArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean oOoXoXO(AccessibleObject accessibleObject) {
        if (accessibleObject != 0 && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && OOXIXo(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException unused) {
                }
            }
        }
        return false;
    }

    public static float oxoX(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return X0o0xo(cls, cls2);
        }
        float f = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && ClassUtils.IO(cls, cls2)) {
                    f += 0.25f;
                    break;
                }
                f += 1.0f;
                cls = cls.getSuperclass();
            } else {
                break;
            }
        }
        if (cls == null) {
            return f + 1.5f;
        }
        return f;
    }

    public static boolean xoIox(Method method, Class<?>[] clsArr) {
        return xxIXOIIO(oIX0oI.XO(method), clsArr);
    }

    public static boolean xxIXOIIO(oIX0oI oix0oi, Class<?>[] clsArr) {
        Class<?>[] I0Io2 = oix0oi.I0Io();
        if (ClassUtils.XOxIOxOx(clsArr, I0Io2, true)) {
            return true;
        }
        if (!oix0oi.oxoX()) {
            return false;
        }
        int i = 0;
        while (i < I0Io2.length - 1 && i < clsArr.length) {
            if (!ClassUtils.xII(clsArr[i], I0Io2[i], true)) {
                return false;
            }
            i++;
        }
        Class<?> componentType = I0Io2[I0Io2.length - 1].getComponentType();
        while (i < clsArr.length) {
            if (!ClassUtils.xII(clsArr[i], componentType, true)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final boolean f2757II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Class<?>[] f2758oIX0oI;

        public oIX0oI(Method method) {
            this.f2758oIX0oI = method.getParameterTypes();
            this.f2757II0xO0 = method.isVarArgs();
        }

        public static oIX0oI X0o0xo(Constructor<?> constructor) {
            return new oIX0oI(constructor);
        }

        public static oIX0oI XO(Method method) {
            return new oIX0oI(method);
        }

        public Class<?>[] I0Io() {
            return this.f2758oIX0oI;
        }

        public boolean oxoX() {
            return this.f2757II0xO0;
        }

        public oIX0oI(Constructor<?> constructor) {
            this.f2758oIX0oI = constructor.getParameterTypes();
            this.f2757II0xO0 = constructor.isVarArgs();
        }
    }
}
