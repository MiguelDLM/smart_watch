package Ox00XOXoo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Comparator<Method> f2754oIX0oI;

    static {
        Comparator<Method> comparing;
        comparing = Comparator.comparing(new Function() { // from class: Ox00XOXoo.X0o0xo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Method) obj).toString();
            }
        });
        f2754oIX0oI = comparing;
    }

    public static Method I0Io(Method method) {
        if (!oxoX.Oxx0IOOO(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method oxoX2 = oxoX(declaringClass, name, parameterTypes);
        if (oxoX2 == null) {
            return X0o0xo(declaringClass, name, parameterTypes);
        }
        return oxoX2;
    }

    public static Method II0XooXoX(Class<?> cls, String str, Class<?>... clsArr) {
        String name;
        String name2;
        try {
            Method method = cls.getMethod(str, clsArr);
            oxoX.oOoXoXO(method);
            return method;
        } catch (NoSuchMethodException unused) {
            Method[] methods = cls.getMethods();
            ArrayList arrayList = new ArrayList();
            for (Method method2 : methods) {
                if (method2.getName().equals(str) && oxoX.xoIox(method2, clsArr)) {
                    arrayList.add(method2);
                }
            }
            arrayList.sort(f2754oIX0oI);
            Iterator it = arrayList.iterator();
            Method method3 = null;
            while (it.hasNext()) {
                Method I0Io2 = I0Io((Method) it.next());
                if (I0Io2 != null && (method3 == null || oxoX.II0xO0(I0Io2, method3, clsArr) < 0)) {
                    method3 = I0Io2;
                }
            }
            if (method3 != null) {
                oxoX.oOoXoXO(method3);
            }
            if (method3 != null && method3.isVarArgs() && method3.getParameterTypes().length > 0 && clsArr.length > 0) {
                String name3 = ClassUtils.oxxXoxO(method3.getParameterTypes()[r5.length - 1].getComponentType()).getName();
                Class<?> cls2 = clsArr[clsArr.length - 1];
                if (cls2 == null) {
                    name = null;
                } else {
                    name = cls2.getName();
                }
                if (cls2 == null) {
                    name2 = null;
                } else {
                    name2 = cls2.getSuperclass().getName();
                }
                if (name != null && name2 != null && !name3.equals(name) && !name3.equals(name2)) {
                    return null;
                }
            }
            return method3;
        }
    }

    public static Method II0xO0(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return I0Io(cls.getMethod(str, clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Object IIXOooo(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        return xoXoI(obj, str, OIxx0I02, ClassUtils.xo0x(OIxx0I02));
    }

    public static Object IXxxXO(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        Method II0xO02 = II0xO0(obj.getClass(), str, org.apache.commons.lang3.oxoX.XxIo(clsArr));
        if (II0xO02 != null) {
            return II0xO02.invoke(obj, OIxx0I02);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object O0xOxO(Object obj, boolean z, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method II0XooXoX2;
        String str2;
        Class<?>[] XxIo2 = org.apache.commons.lang3.oxoX.XxIo(clsArr);
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        if (z) {
            II0XooXoX2 = xxIXOIIO(obj.getClass(), str, XxIo2);
            if (II0XooXoX2 != null && !II0XooXoX2.isAccessible()) {
                II0XooXoX2.setAccessible(true);
            }
            str2 = "No such method: ";
        } else {
            II0XooXoX2 = II0XooXoX(obj.getClass(), str, XxIo2);
            str2 = "No such accessible method: ";
        }
        if (II0XooXoX2 != null) {
            return II0XooXoX2.invoke(obj, XIxXXX0x0(II0XooXoX2, OIxx0I02));
        }
        throw new NoSuchMethodException(str2 + str + "() on object: " + obj.getClass().getName());
    }

    public static List<Method> OOXIXo(Class<?> cls, Class<? extends Annotation> cls2, boolean z, boolean z2) {
        List<Class> arrayList;
        Method[] methods;
        xoIxX.xo0x(cls, "The class must not be null", new Object[0]);
        xoIxX.xo0x(cls2, "The annotation class must not be null", new Object[0]);
        if (z) {
            arrayList = XO(cls);
        } else {
            arrayList = new ArrayList();
        }
        arrayList.add(0, cls);
        ArrayList arrayList2 = new ArrayList();
        for (Class cls3 : arrayList) {
            if (z2) {
                methods = cls3.getDeclaredMethods();
            } else {
                methods = cls3.getMethods();
            }
            for (Method method : methods) {
                if (method.getAnnotation(cls2) != null) {
                    arrayList2.add(method);
                }
            }
        }
        return arrayList2;
    }

    public static Object Oo(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        return IXxxXO(obj, str, OIxx0I02, ClassUtils.xo0x(OIxx0I02));
    }

    public static Object OxI(Object obj, boolean z, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        return O0xOxO(obj, z, str, OIxx0I02, ClassUtils.xo0x(OIxx0I02));
    }

    public static <A extends Annotation> A Oxx0IOOO(Method method, Class<A> cls, boolean z, boolean z2) {
        Method II0XooXoX2;
        xoIxX.xo0x(method, "The method must not be null", new Object[0]);
        xoIxX.xo0x(cls, "The annotation class must not be null", new Object[0]);
        if (!z2 && !oxoX.Oxx0IOOO(method)) {
            return null;
        }
        A a2 = (A) method.getAnnotation(cls);
        if (a2 == null && z) {
            for (Class<?> cls2 : XO(method.getDeclaringClass())) {
                if (z2) {
                    II0XooXoX2 = xxIXOIIO(cls2, method.getName(), method.getParameterTypes());
                } else {
                    II0XooXoX2 = II0XooXoX(cls2, method.getName(), method.getParameterTypes());
                }
                if (II0XooXoX2 != null && (a2 = (A) II0XooXoX2.getAnnotation(cls)) != null) {
                    break;
                }
            }
        }
        return a2;
    }

    public static Object Oxx0xo(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        return oI0IIXIo(cls, str, OIxx0I02, ClassUtils.xo0x(OIxx0I02));
    }

    public static Object OxxIIOOXO(Object obj, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return xoXoI(obj, str, org.apache.commons.lang3.oxoX.f32753IXxxXO, null);
    }

    public static Object X0IIOO(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        return XI0IXoo(cls, str, OIxx0I02, ClassUtils.xo0x(OIxx0I02));
    }

    public static Method X0o0xo(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
        }
        return null;
    }

    public static Object XI0IXoo(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        Method II0XooXoX2 = II0XooXoX(cls, str, org.apache.commons.lang3.oxoX.XxIo(clsArr));
        if (II0XooXoX2 != null) {
            return II0XooXoX2.invoke(null, XIxXXX0x0(II0XooXoX2, OIxx0I02));
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static Object[] XIxXXX0x0(Method method, Object[] objArr) {
        if (method.isVarArgs()) {
            return oO(objArr, method.getParameterTypes());
        }
        return objArr;
    }

    public static List<Class<?>> XO(Class<?> cls) {
        Class<?> cls2;
        int i;
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Class<?>> xxIXOIIO2 = ClassUtils.xxIXOIIO(cls);
        List<Class<?>> Oxx0IOOO2 = ClassUtils.Oxx0IOOO(cls);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= Oxx0IOOO2.size() && i3 >= xxIXOIIO2.size()) {
                return arrayList;
            }
            if (i2 >= Oxx0IOOO2.size()) {
                i = i3 + 1;
                cls2 = xxIXOIIO2.get(i3);
            } else if (i3 < xxIXOIIO2.size() && i2 >= i3 && i3 < i2) {
                i = i3 + 1;
                cls2 = xxIXOIIO2.get(i3);
            } else {
                int i4 = i3;
                cls2 = Oxx0IOOO2.get(i2);
                i2++;
                i = i4;
            }
            arrayList.add(cls2);
            i3 = i;
        }
    }

    public static Object o00(Object obj, boolean z, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return O0xOxO(obj, z, str, org.apache.commons.lang3.oxoX.f32753IXxxXO, null);
    }

    public static Object oI0IIXIo(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] OIxx0I02 = org.apache.commons.lang3.oxoX.OIxx0I0(objArr);
        Method II0xO02 = II0xO0(cls, str, org.apache.commons.lang3.oxoX.XxIo(clsArr));
        if (II0xO02 != null) {
            return II0xO02.invoke(null, OIxx0I02);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static int oIX0oI(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (!ClassUtils.XOxIOxOx(clsArr, clsArr2, true)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (!clsArr[i2].equals(clsArr2[i2])) {
                if (ClassUtils.xII(clsArr[i2], clsArr2[i2], true) && !ClassUtils.xII(clsArr[i2], clsArr2[i2], false)) {
                    i++;
                } else {
                    i += 2;
                }
            }
        }
        return i;
    }

    public static Object[] oO(Object[] objArr, Class<?>[] clsArr) {
        if (objArr.length == clsArr.length && (objArr[objArr.length - 1] == null || objArr[objArr.length - 1].getClass().equals(clsArr[clsArr.length - 1]))) {
            return objArr;
        }
        Object[] objArr2 = new Object[clsArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, clsArr.length - 1);
        Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
        int length = (objArr.length - clsArr.length) + 1;
        Object newInstance = Array.newInstance(ClassUtils.oxxXoxO(componentType), length);
        System.arraycopy(objArr, clsArr.length - 1, newInstance, 0, length);
        if (componentType.isPrimitive()) {
            newInstance = org.apache.commons.lang3.oxoX.xOIx00(newInstance);
        }
        objArr2[clsArr.length - 1] = newInstance;
        return objArr2;
    }

    public static Method[] oOoXoXO(Class<?> cls, Class<? extends Annotation> cls2) {
        return ooOOo0oXI(cls, cls2, false, false);
    }

    public static Method[] ooOOo0oXI(Class<?> cls, Class<? extends Annotation> cls2, boolean z, boolean z2) {
        return (Method[]) OOXIXo(cls, cls2, z, z2).toArray(org.apache.commons.lang3.oxoX.f32755Oo);
    }

    public static Method oxoX(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (Modifier.isPublic(cls2.getModifiers())) {
                    try {
                        return cls2.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method oxoX2 = oxoX(cls2, str, clsArr);
                        if (oxoX2 != null) {
                            return oxoX2;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Set<Method> x0XOIxOo(Method method, ClassUtils.Interfaces interfaces) {
        xoIxX.oxXx0IX(method);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(method);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> declaringClass = method.getDeclaringClass();
        Iterator<Class<?>> it = ClassUtils.X00IoxXI(declaringClass, interfaces).iterator();
        it.next();
        while (it.hasNext()) {
            Method II0XooXoX2 = II0XooXoX(it.next(), method.getName(), parameterTypes);
            if (II0XooXoX2 != null) {
                if (Arrays.equals(II0XooXoX2.getParameterTypes(), parameterTypes)) {
                    linkedHashSet.add(II0XooXoX2);
                } else {
                    Map<TypeVariable<?>, Type> xxX2 = xxIXOIIO.xxX(declaringClass, II0XooXoX2.getDeclaringClass());
                    int i = 0;
                    while (true) {
                        if (i < parameterTypes.length) {
                            if (!xxIXOIIO.ooOOo0oXI(xxIXOIIO.I0X0x0oIo(xxX2, method.getGenericParameterTypes()[i]), xxIXOIIO.I0X0x0oIo(xxX2, II0XooXoX2.getGenericParameterTypes()[i]))) {
                                break;
                            }
                            i++;
                        } else {
                            linkedHashSet.add(II0XooXoX2);
                            break;
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }

    public static Object x0xO0oo(Object obj, String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return IXxxXO(obj, str, org.apache.commons.lang3.oxoX.f32753IXxxXO, null);
    }

    public static List<Method> xoIox(Class<?> cls, Class<? extends Annotation> cls2) {
        return OOXIXo(cls, cls2, false, false);
    }

    public static Object xoXoI(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return O0xOxO(obj, false, str, objArr, clsArr);
    }

    public static Method xxIXOIIO(Class<?> cls, String str, Class<?>... clsArr) {
        xoIxX.xo0x(cls, "Null class not allowed.", new Object[0]);
        xoIxX.x0o(str, "Null or blank methodName not allowed.", new Object[0]);
        Method[] declaredMethods = cls.getDeclaredMethods();
        Iterator<Class<?>> it = ClassUtils.xxIXOIIO(cls).iterator();
        while (it.hasNext()) {
            declaredMethods = (Method[]) org.apache.commons.lang3.oxoX.O0xOxO(declaredMethods, it.next().getDeclaredMethods());
        }
        Method method = null;
        for (Method method2 : declaredMethods) {
            if (str.equals(method2.getName()) && Objects.deepEquals(clsArr, method2.getParameterTypes())) {
                return method2;
            }
            if (str.equals(method2.getName()) && ClassUtils.XOxIOxOx(clsArr, method2.getParameterTypes(), true) && (method == null || oIX0oI(clsArr, method2.getParameterTypes()) < oIX0oI(clsArr, method.getParameterTypes()))) {
                method = method2;
            }
        }
        return method;
    }
}
