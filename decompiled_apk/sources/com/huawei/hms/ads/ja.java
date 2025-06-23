package com.huawei.hms.ads;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public abstract class ja {
    public static boolean B(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 14);
        return Code != null && 1 == Code.intValue();
    }

    public static int C(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 15);
        if (Code != null) {
            return Code.intValue();
        }
        return 1;
    }

    public static boolean Code(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 2);
        return (Code == null || Code.intValue() == 0) ? false : true;
    }

    public static int D(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 1, 1);
        if (Code != null) {
            return Code.intValue();
        }
        return 0;
    }

    public static boolean F(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 0, 1);
        return Code != null && 1 == Code.intValue();
    }

    @com.huawei.openalliance.ad.annotations.b
    public static boolean I(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 9);
        return Code == null || 1 == Code.intValue();
    }

    public static boolean L(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 2, 1);
        return Code != null && Code.intValue() == 1;
    }

    public static int S(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 20);
        if (Code != null) {
            return Code.intValue();
        }
        return 1;
    }

    public static boolean V(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 0);
        return Code == null || 1 == Code.intValue();
    }

    @com.huawei.openalliance.ad.annotations.b
    public static boolean Z(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 12);
        return Code != null && 1 == Code.intValue();
    }

    public static int a(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 3, 1);
        if (Code == null) {
            return 0;
        }
        return Code.intValue();
    }

    public static boolean b(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 4, 1);
        return Code != null && Code.intValue() == 1;
    }

    public static boolean c(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 6, 1);
        return Code != null && Code.intValue() == 1;
    }

    public static boolean d(String str) {
        Integer Code = com.huawei.openalliance.ad.utils.az.Code(str, 7, 1);
        return Code != null && Code.intValue() == 1;
    }
}
