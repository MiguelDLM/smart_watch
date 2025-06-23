package com.jd.ad.sdk.jad_do;

/* loaded from: classes10.dex */
public final class jad_kx {
    public static final String[] jad_an = {"huawei"};
    public static final String[] jad_bo = {"xiaomi"};
    public static final String[] jad_cp = {"oppo"};
    public static final String[] jad_dq = {"oneplus"};
    public static final String[] jad_er = {"meizu"};

    public static boolean jad_an() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equals(cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Exception unused) {
            return false;
        }
    }
}
