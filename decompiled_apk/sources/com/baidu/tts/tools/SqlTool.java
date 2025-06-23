package com.baidu.tts.tools;

import XXO0.oIX0oI;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes8.dex */
public class SqlTool {
    public static String a(Method method, Method method2, Object obj) {
        String a2;
        String a3 = a(method, obj);
        if (a3 == null || (a2 = a(method2, obj)) == null) {
            return null;
        }
        return a3 + " " + a2;
    }

    public static String addPlaceholders(int i) {
        if (i < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(LocationInfo.NA);
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static String buildConditions(String str, String... strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : strArr) {
                if (!StringTool.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                sb.append((String) it.next());
            }
            while (it.hasNext()) {
                String str3 = (String) it.next();
                sb.append(" " + str + " ");
                sb.append(str3);
            }
            return sb.toString();
        }
        return null;
    }

    public static String buildInCondition(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(str)) {
            return str + " in (" + addPlaceholders(strArr.length) + oIX0oI.I0Io.f4095I0Io;
        }
        return null;
    }

    public static String[] getSQLformat(String str, String[] strArr, String[] strArr2, String[] strArr3) {
        String[] strArr4 = new String[strArr.length + 1 + strArr2.length + strArr3.length];
        strArr4[0] = str;
        System.arraycopy(strArr, 0, strArr4, 1, strArr.length);
        System.arraycopy(strArr2, 0, strArr4, strArr.length + 1, strArr2.length);
        System.arraycopy(strArr3, 0, strArr4, strArr.length + 1 + strArr2.length, strArr3.length);
        return strArr4;
    }

    public static String sqlCreateTable(String str, Object[] objArr) {
        if (str != null && objArr != null) {
            Object obj = objArr[0];
            Class<?> cls = obj.getClass();
            try {
                Method supportedMethod = ReflectTool.getSupportedMethod(cls, "getColumnName", null);
                Method supportedMethod2 = ReflectTool.getSupportedMethod(cls, "getDataType", null);
                StringBuilder sb = new StringBuilder("create Table " + str);
                String a2 = a(supportedMethod, supportedMethod2, obj);
                if (a2 != null) {
                    sb.append(" (" + a2);
                    int length = objArr.length;
                    for (int i = 1; i < length; i++) {
                        sb.append(",");
                        sb.append(a(supportedMethod, supportedMethod2, objArr[i]));
                    }
                    sb.append(oIX0oI.I0Io.f4095I0Io);
                    return sb.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String sqlDropTable(String str) {
        return "drop table if exists " + str;
    }

    public static String a(Method method, Object obj) {
        try {
            return (String) method.invoke(obj, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
