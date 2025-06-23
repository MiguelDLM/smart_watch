package Ox00XOXoo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class oIX0oI {
    public static <T> Constructor<T> I0Io(Class<T> cls, Class<?>... clsArr) {
        Constructor<T> II0xO02;
        xoIxX.xo0x(cls, "class cannot be null", new Object[0]);
        try {
            Constructor<T> constructor = cls.getConstructor(clsArr);
            oxoX.oOoXoXO(constructor);
            return constructor;
        } catch (NoSuchMethodException unused) {
            Constructor<T> constructor2 = null;
            for (Constructor<?> constructor3 : cls.getConstructors()) {
                if (oxoX.II0XooXoX(constructor3, clsArr) && (II0xO02 = II0xO0(constructor3)) != null) {
                    oxoX.oOoXoXO(II0xO02);
                    if (constructor2 == null || oxoX.oIX0oI(II0xO02, constructor2, clsArr) < 0) {
                        constructor2 = II0xO02;
                    }
                }
            }
            return constructor2;
        }
    }

    public static boolean II0XooXoX(Class<?> cls) {
        while (cls != null) {
            if (!Modifier.isPublic(cls.getModifiers())) {
                return false;
            }
            cls = cls.getEnclosingClass();
        }
        return true;
    }

    public static <T> Constructor<T> II0xO0(Constructor<T> constructor) {
        xoIxX.xo0x(constructor, "constructor cannot be null", new Object[0]);
        if (!oxoX.Oxx0IOOO(constructor) || !II0XooXoX(constructor.getDeclaringClass())) {
            return null;
        }
        return constructor;
    }

    public static <T> T Oxx0IOOO(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        Constructor oIX0oI2 = oIX0oI(cls, org.apache.commons.lang3.oxoX.XxIo(clsArr));
        if (oIX0oI2 != null) {
            return (T) oIX0oI2.newInstance(OIxx0I02);
        }
        throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
    }

    public static <T> T X0o0xo(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        Constructor I0Io2 = I0Io(cls, org.apache.commons.lang3.oxoX.XxIo(clsArr));
        if (I0Io2 != null) {
            if (I0Io2.isVarArgs()) {
                OIxx0I02 = XO.oO(OIxx0I02, I0Io2.getParameterTypes());
            }
            return (T) I0Io2.newInstance(OIxx0I02);
        }
        throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
    }

    public static <T> T XO(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        return (T) Oxx0IOOO(cls, OIxx0I02, ClassUtils.xo0x(OIxx0I02));
    }

    public static <T> Constructor<T> oIX0oI(Class<T> cls, Class<?>... clsArr) {
        xoIxX.xo0x(cls, "class cannot be null", new Object[0]);
        try {
            return II0xO0(cls.getConstructor(clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static <T> T oxoX(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        return (T) X0o0xo(cls, OIxx0I02, ClassUtils.xo0x(OIxx0I02));
    }
}
