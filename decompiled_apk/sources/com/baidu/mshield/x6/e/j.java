package com.baidu.mshield.x6.e;

import OoOoXO0.xoXoI;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class j {
    public static String a(String str, String str2, String str3, String str4) {
        try {
            return a(str, str2, str3, str4, true);
        } catch (Throwable th) {
            f.a(th);
            return "";
        }
    }

    public static String b(String str, String str2, String str3, String str4) {
        try {
            return a(str, str2, str3, str4, false);
        } catch (Throwable th) {
            f.a(th);
            return "";
        }
    }

    public static String a(String str, String str2, String str3, String str4, boolean z) {
        try {
            com.baidu.mshield.b.c.a.a("doExecMethod cn :" + str + ",mn : " + str2 + ", paramTypes : " + str3 + ", paramValues : " + str4 + ", isStaticMethod " + z);
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                String[] split = str3.split(xoXoI.f2670oxoX);
                String[] split2 = str4.split(xoXoI.f2670oxoX, -1);
                if (split.length > 0 && split.length == split2.length) {
                    Class[] clsArr = new Class[split.length];
                    Object[] objArr = new Object[split.length];
                    for (int i = 0; i < split.length; i++) {
                        Object[] a2 = a(split[i], split2[i]);
                        clsArr[i] = (Class) a2[0];
                        objArr[i] = a2[1];
                    }
                    return a(str, str2, clsArr, objArr, z);
                }
                com.baidu.mshield.b.c.a.a("doExecMethod types values length error");
                return "#doExecMethod types values length error";
            }
            return a(str, str2, new Class[0], new Object[0], false);
        } catch (Throwable th) {
            try {
                f.a(th);
                return xoXoI.f2670oxoX + th.toString();
            } catch (Throwable th2) {
                f.a(th2);
                return "";
            }
        }
    }

    public static String a(String str, String str2, Class[] clsArr, Object[] objArr, boolean z) {
        Method method;
        Object invoke;
        try {
            com.baidu.mshield.b.c.a.a("doExecMethod cn :" + str + ",mn : " + str2 + ", at : " + clsArr + ", ao : " + objArr + ", isStaticMethod " + z);
            Class<?> cls = Class.forName(str);
            try {
                method = cls.getDeclaredMethod(str2, clsArr);
            } catch (NoSuchMethodException unused) {
                method = cls.getSuperclass().getMethod(str2, clsArr);
            }
            if (method == null) {
                return "";
            }
            com.baidu.mshield.b.c.a.a("doExecMethod method exist ");
            if (z) {
                invoke = method.invoke(null, objArr);
            } else {
                invoke = method.invoke(cls.newInstance(), objArr);
            }
            return invoke != null ? invoke.toString() : "";
        } catch (Throwable th) {
            try {
                f.a(th);
                return xoXoI.f2670oxoX + th.toString();
            } catch (Throwable th2) {
                f.a(th2);
                return "";
            }
        }
    }

    public static Object[] a(String str, String str2) {
        Object[] objArr = new Object[2];
        try {
            if ("byte".equals(str)) {
                objArr[0] = Byte.TYPE;
                objArr[1] = Byte.valueOf(Byte.parseByte(str2));
            } else if ("short".equals(str)) {
                objArr[0] = Short.TYPE;
                objArr[1] = Short.valueOf(Short.parseShort(str2));
            } else if (IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL.equalsIgnoreCase(str)) {
                objArr[0] = Integer.TYPE;
                objArr[1] = Integer.valueOf(Integer.parseInt(str2));
            } else if ("long".equalsIgnoreCase(str)) {
                objArr[0] = Long.TYPE;
                objArr[1] = Long.valueOf(Long.parseLong(str2));
            } else if (TypedValues.Custom.S_FLOAT.equalsIgnoreCase(str)) {
                objArr[0] = Float.TYPE;
                objArr[1] = Float.valueOf(Float.parseFloat(str2));
            } else if ("double".equalsIgnoreCase(str)) {
                objArr[0] = Double.TYPE;
                objArr[1] = Double.valueOf(Double.parseDouble(str2));
            } else if ("char".equalsIgnoreCase(str)) {
                objArr[0] = Character.TYPE;
                objArr[1] = Character.valueOf(str2.charAt(0));
            } else if (TypedValues.Custom.S_BOOLEAN.equalsIgnoreCase(str)) {
                objArr[0] = Boolean.TYPE;
                objArr[1] = Boolean.valueOf(Boolean.parseBoolean(str2));
            } else if ("java.lang.String".equalsIgnoreCase(str)) {
                objArr[0] = String.class;
                objArr[1] = str2;
            } else {
                Class.forName(str).newInstance();
            }
        } catch (Throwable th) {
            f.a(th);
        }
        return objArr;
    }
}
