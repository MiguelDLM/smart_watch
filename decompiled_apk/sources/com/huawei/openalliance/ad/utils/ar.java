package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public abstract class ar {
    private static final String Code = "ReflectAPI";

    public static boolean B(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            fb.I(Code, "class not found for %s", str);
            return false;
        }
    }

    public static Class Code(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            fb.I(Code, "classNoFound %s", str);
            return null;
        }
    }

    public static boolean I(String str) {
        return B(str) || Z(str);
    }

    public static Object V(String str) {
        StringBuilder sb;
        try {
            return Class.forName(str).newInstance();
        } catch (ClassNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("createInstance ");
            sb.append(e.getClass().getSimpleName());
            fb.I(Code, sb.toString());
            return null;
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("createInstance ");
            sb.append(e.getClass().getSimpleName());
            fb.I(Code, sb.toString());
            return null;
        }
    }

    public static boolean Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (Throwable unused) {
            fb.I(Code, "class not found for %s", str);
        }
        return ClassLoader.getSystemClassLoader().loadClass(str) != null;
    }

    public static Class Code(Field field) {
        int i;
        if (Map.class.isAssignableFrom(field.getType())) {
            i = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i = 0;
        }
        return Code(field, i);
    }

    public static Field V(Class cls, String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && cls != null) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                str2 = "getDeclaredField NoSuchFieldException";
                fb.I(Code, str2);
                return null;
            } catch (SecurityException unused2) {
                str2 = "getDeclaredField SecurityException";
                fb.I(Code, str2);
                return null;
            }
        }
        return null;
    }

    public static Class Code(Field field, int i) {
        Type[] actualTypeArguments;
        StringBuilder sb;
        Type genericType = field.getGenericType();
        if ((genericType instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) != null && actualTypeArguments.length > i) {
            try {
                Type type = actualTypeArguments[i];
                if (type instanceof Class) {
                    return (Class) type;
                }
                String obj = type.toString();
                int indexOf = obj.indexOf("class ");
                if (indexOf < 0) {
                    indexOf = 0;
                }
                int indexOf2 = obj.indexOf("<");
                if (indexOf2 < 0) {
                    indexOf2 = obj.length();
                }
                return Class.forName(obj.substring(indexOf, indexOf2));
            } catch (ClassNotFoundException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("getType ");
                sb.append(e.getClass().getSimpleName());
                fb.I(Code, sb.toString());
                return null;
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("getType ");
                sb.append(e.getClass().getSimpleName());
                fb.I(Code, sb.toString());
                return null;
            }
        }
        return null;
    }

    public static Object Code(Class cls, String str) {
        String str2;
        Field V = V(cls, str);
        if (V == null) {
            return null;
        }
        Code(V, true);
        try {
            return V.get(null);
        } catch (IllegalAccessException unused) {
            str2 = "getFieldValue IllegalAccessException";
            fb.I(Code, str2);
            return null;
        } catch (Exception e) {
            str2 = "getFieldValue " + e.getClass().getSimpleName();
            fb.I(Code, str2);
            return null;
        }
    }

    public static Object Code(Object obj, Class cls, String str, Class<?>[] clsArr, Object[] objArr) {
        StringBuilder sb;
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                Method method = cls.getMethod(str, clsArr);
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            } catch (NoSuchMethodException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("invokeMethod ");
                sb.append(e.getClass().getSimpleName());
                fb.I(Code, sb.toString());
                return null;
            } catch (Throwable th) {
                e = th;
                sb = new StringBuilder();
                sb.append("invokeMethod ");
                sb.append(e.getClass().getSimpleName());
                fb.I(Code, sb.toString());
                return null;
            }
        }
        return null;
    }

    public static Field Code(Field field, boolean z) {
        field.setAccessible(z);
        return field;
    }

    public static boolean Code(String str, String str2, Class<?>[] clsArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Class.forName(str).getDeclaredMethod(str2, clsArr);
                return true;
            } catch (ClassNotFoundException unused) {
                fb.I(Code, "class not found for %s", str);
            } catch (NoSuchMethodException unused2) {
                fb.I(Code, "method not found for %s", str2);
            } catch (Throwable th) {
                fb.I(Code, "isMethodAvailable %s", th.getClass().getSimpleName());
            }
        }
        return false;
    }

    public static Field[] Code(Class cls) {
        Field[] Code2 = cls.getSuperclass() != null ? Code(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (Code2 == null || Code2.length <= 0) {
            return declaredFields;
        }
        Field[] fieldArr = new Field[declaredFields.length + Code2.length];
        System.arraycopy(Code2, 0, fieldArr, 0, Code2.length);
        System.arraycopy(declaredFields, 0, fieldArr, Code2.length, declaredFields.length);
        return fieldArr;
    }
}
