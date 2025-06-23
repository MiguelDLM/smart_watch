package com.baidu.ar;

/* loaded from: classes7.dex */
public class as {
    public static int a(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return i;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static long a(Object obj, long j) {
        if (obj == null) {
            return j;
        }
        if ((obj instanceof Long) || (obj instanceof Float)) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return j;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return j;
        }
    }

    public static String a(Object obj, String str) {
        return obj != null ? String.valueOf(obj) : str;
    }
}
