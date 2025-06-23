package com.kwad.sdk.api.loader;

import androidx.annotation.Nullable;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* loaded from: classes11.dex */
public final class ApiReflect {
    private final Class<?> and;
    private final Object ane;

    /* loaded from: classes11.dex */
    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException() {
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        private b() {
        }
    }

    private ApiReflect(Class<?> cls) {
        this(cls, cls);
    }

    public static ApiReflect a(Class<?> cls) {
        return new ApiReflect(cls);
    }

    private static Class<?>[] c(Object... objArr) {
        Class<?> cls;
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                cls = b.class;
            } else {
                cls = obj.getClass();
            }
            clsArr[i] = cls;
        }
        return clsArr;
    }

    public static ApiReflect cg(String str) {
        return a(forName(str));
    }

    private ApiReflect ch(String str) {
        try {
            Field ci = ci(str);
            return a(ci.getType(), ci.get(this.ane));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field ci(String str) {
        Class<?> type = type();
        try {
            return (Field) a(a.b(type, str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) a(a.a(type, str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new ReflectException(e);
                    }
                }
            } while (type == null);
            throw new ReflectException(e);
        }
    }

    private static Class<?> forName(String str) {
        try {
            return a.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static ApiReflect g(Object obj) {
        return new ApiReflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    private static Object h(Object obj) {
        if (obj instanceof ApiReflect) {
            return ((ApiReflect) obj).get();
        }
        return obj;
    }

    private Class<?> type() {
        return this.and;
    }

    public final ApiReflect AL() {
        return b(new Object[0]);
    }

    public final ApiReflect b(String str, Object obj) {
        try {
            Field ci = ci(str);
            if ((ci.getModifiers() & 16) == 16) {
                try {
                    Field a2 = a.a(Field.class, "modifiers");
                    a2.setAccessible(true);
                    a2.setInt(ci, ci.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            ci.set(this.ane, h(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public final ApiReflect cj(String str) {
        return g(str, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ApiReflect) {
            return this.ane.equals(((ApiReflect) obj).get());
        }
        return false;
    }

    public final <T> T get() {
        return (T) this.ane;
    }

    public final int hashCode() {
        return this.ane.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.ane);
    }

    private ApiReflect(Class<?> cls, Object obj) {
        this.and = cls;
        this.ane = obj;
    }

    private static ApiReflect a(Class<?> cls, Object obj) {
        return new ApiReflect(cls, obj);
    }

    private ApiReflect g(String str, Object... objArr) {
        return a(str, c(objArr), objArr);
    }

    public final <T> T get(String str) {
        return (T) ch(str).get();
    }

    @Nullable
    private static <T extends AccessibleObject> T a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private static final Method anf;
        private static final Method ang;
        private static final Method anh;
        private static final Method ani;
        private static final Method anj;
        private static final Method ank;
        private static final Method anl;
        private static final Method anm;
        private static final Method ann;
        private static final Method ano;
        private static final Method anp;
        private static final Method anq;
        private static final Method anr;
        private static final Method ans;

        static {
            try {
                anf = Class.class.getDeclaredMethod("forName", String.class);
                ang = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                anh = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                ani = Class.class.getDeclaredMethod("getDeclaredFields", null);
                anj = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                ank = Class.class.getDeclaredMethod("getDeclaredMethods", null);
                anl = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                anm = Class.class.getDeclaredMethod("getDeclaredConstructors", null);
                ann = Class.class.getDeclaredMethod("getField", String.class);
                ano = Class.class.getDeclaredMethod("getFields", null);
                anp = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                anq = Class.class.getDeclaredMethod("getMethods", null);
                anr = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                ans = Class.class.getDeclaredMethod("getConstructors", null);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }

        public static Field a(Class cls, String str) {
            try {
                return (Field) anh.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        public static Field b(Class cls, String str) {
            try {
                return (Field) ann.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        public static Method c(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) anj.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Method d(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) anp.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Constructor[] e(Class cls) {
            try {
                return (Constructor[]) anm.invoke(cls, null);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        public static Class forName(String str) {
            try {
                return (Class) anf.invoke(null, str);
            } catch (Exception e) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e);
                throw classNotFoundException;
            }
        }

        public static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) anl.invoke(cls, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Method[] c(Class cls) {
            try {
                return (Method[]) ank.invoke(cls, null);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        public static Method[] d(Class cls) {
            try {
                return (Method[]) anq.invoke(cls, null);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }
    }

    private Method b(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        for (Method method : a.d(type)) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : a.c(type)) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public final ApiReflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return a(a(str, clsArr), this.ane, objArr);
            } catch (NoSuchMethodException unused) {
                return a(b(str, clsArr), this.ane, objArr);
            }
        } catch (NoSuchMethodException e) {
            throw new ReflectException(e);
        }
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        try {
            return a.d(type, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return a.c(type, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type = type.getSuperclass();
                }
            } while (type != null);
            throw new NoSuchMethodException();
        }
    }

    private ApiReflect b(Object... objArr) {
        return a(c(objArr), objArr);
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    public final ApiReflect a(Class<?>[] clsArr, Object... objArr) {
        try {
            return a((Constructor<?>) a.a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : a.e(type())) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a((Constructor<?>) constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != b.class && !b(clsArr[i]).isAssignableFrom(b(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    private static ApiReflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static ApiReflect a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return g(obj);
            }
            return g(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }
}
