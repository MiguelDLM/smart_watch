package com.jd.ad.sdk.jad_do;

import java.lang.reflect.Method;

/* loaded from: classes10.dex */
public class jad_iv {
    public static Method jad_an;
    public static Method jad_bo;
    public static Method jad_cp;

    static {
        try {
            jad_an = Class.class.getDeclaredMethod("forName", String.class);
            jad_bo = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            jad_cp = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean jad_an() {
        return (jad_an == null || jad_bo == null || jad_cp == null) ? false : true;
    }
}
